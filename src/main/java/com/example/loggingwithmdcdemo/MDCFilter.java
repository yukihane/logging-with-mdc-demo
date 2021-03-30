package com.example.loggingwithmdcdemo;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

public class MDCFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
        final FilterChain filterChain)
        throws ServletException, IOException {

        MDC.put("MY_MDC", "MY_MDC_VALUE");

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

}
