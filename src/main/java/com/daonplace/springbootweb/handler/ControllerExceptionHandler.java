package com.daonplace.springbootweb.handler;

import com.daonplace.springbootweb.dto.CMRespDto;
import com.daonplace.springbootweb.handler.ex.CustomValidationException;
import com.daonplace.springbootweb.util.Script;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

/*    // 개발자 통신을 위한 핸들러
    @ExceptionHandler(CustomValidationException.class)
    public CMRespDto<?> validationException(CustomValidationException e) {
        return new CMRespDto<>(-1, e.getMessage(), e.getErrorMap());
    }*/

    // 클라이언트 편의성을 위한 핸들러
    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {
        return Script.back(e.getErrorMap().toString());
    }

}
