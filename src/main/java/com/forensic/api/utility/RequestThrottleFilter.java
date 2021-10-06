package com.forensic.api.utility;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RequestThrottleFilter class implements the Filter Interface
 * To restrict each user email to only 5 maximum guesses.
 * @author mamallan.chidambaram
 */
@Component
public class RequestThrottleFilter implements Filter{
    private Logger logger = LoggerFactory.getLogger(RequestThrottleFilter.class);

    private int MAX_REQUESTS_PER_USER = 5;

    private LoadingCache<String, Integer> requestCountsPerEmailAddress;

    /**
     * RequestThrottleFilter constructor
     * Which will load the Cache using LoadingCache, to store the email ID of the user
     */
    public RequestThrottleFilter(){
        super();
        requestCountsPerEmailAddress = CacheBuilder.newBuilder().build(new CacheLoader<String, Integer>() {
                    public Integer load(String key) {
                        return 0;
                    }
                });
    }

    /**
     * doFilter method which will accept the ServletRequest, ServletResponse, FilterChain
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        //Getting the URL and Path parameter from the Request
        logger.info("URL :"+httpServletRequest.getRequestURL().toString());
        String pathVariables = httpServletRequest.getRequestURL().toString();
        String[] value = pathVariables.split("/");
        logger.info("PathVariable{emailId} -> "+value[4]);
        String clientEmail = value[4];

        //Verifying the user whether they've exceeded 5 guesses
        if(isMaximumRequestsPerEmailExceeded(clientEmail)){
            httpServletResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            httpServletResponse.getWriter().write("{ Too many requests, Unfortunately only 5 guesses are permitted for a user! }"+
                    "\n ResponseCode: " + HttpStatus.TOO_MANY_REQUESTS.value());
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * isMaximumRequestsPerEmailExceeded method to
     * Verify the user whether they've exceeded 5 guesses in their request
     * @param clientEmail
     * @return
     */
    private boolean isMaximumRequestsPerEmailExceeded(String clientEmail){
        int requestsCounter = 0;
        try {
            requestsCounter = requestCountsPerEmailAddress.get(clientEmail);
            logger.info("Requests Count for the User(" + clientEmail + ") :: " + requestsCounter);
            if(requestsCounter >= MAX_REQUESTS_PER_USER){
                requestCountsPerEmailAddress.put(clientEmail, requestsCounter);
                return true;
            }
        } catch (ExecutionException e) {
            requestsCounter = 0;
        }
        requestsCounter++;
        requestCountsPerEmailAddress.put(clientEmail, requestsCounter);
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }
}
