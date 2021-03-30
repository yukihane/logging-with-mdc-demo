package com.example.loggingwithmdcdemo;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

@Controller
@RequestMapping("/error")
@RequiredArgsConstructor
@Slf4j
public class MyErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping
    @ResponseBody
    public Map<String, String> error(final HttpServletRequest request) {
        final ServletWebRequest webRequest = new ServletWebRequest(request);
        final Throwable th = errorAttributes.getError(webRequest);

        if (th != null) {
            log.error("MyErrorController", th);
        }

        return Map.of("result", "error");
    }
}
