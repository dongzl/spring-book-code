package com.spring.boot.step.error;

import com.spring.boot.step.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-18 18:45
 */
@ControllerAdvice(basePackages = {"com.spring.boot.step"})
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public ErrorInfo defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(req.getRequestURI());
        errorInfo.setCode(ErrorInfo.SUCCESS);
        return errorInfo;
    }
}
