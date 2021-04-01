package com.example.loggingwithmdcdemo;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import org.slf4j.MDC;

public class MDCClearListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(final ServletRequestEvent sre) {
        MDC.remove("requestId");
    }
}
