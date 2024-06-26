package org.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.web.exception.InvalidRequestException;
import org.web.resource.ErrorResouce;
import org.web.resource.FieldResource;
import org.web.resource.InvalidErrorResource;

import java.util.ArrayList;
import java.util.List;

// 使用AOP統一日誌紀錄
@RestControllerAdvice
public class ApiExceptionHandler {

    // 執行日誌紀錄
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 處理資料找不到的異常事件
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handleNoFound(RuntimeException e){
        ErrorResouce errorResouce = new ErrorResouce(e.getMessage());
        ResponseEntity result = new ResponseEntity<Object>(errorResouce, HttpStatus.NOT_FOUND);
        logger.warn("Return -------- {}", result);
        return result;
    }

    // 處理參數驗證失敗
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseBody
    public ResponseEntity<?> handleInvalidRequest(InvalidRequestException e) {
        Errors errors = e.getErrors();
        List<FieldResource> fieldResources = new ArrayList<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for( FieldError fieldError : fieldErrors) {
            // 開一個 fieldResource => 放入一筆filedError => 加入到 fieldResources
            FieldResource fieldResource = new FieldResource(fieldError.getObjectName(),
                                                            fieldError.getField(),
                                                            fieldError.getCode(),
                                                            fieldError.getDefaultMessage());
            fieldResources.add(fieldResource);
        }

        // 集合訊息及各種型式的Error、返回的狀態
        InvalidErrorResource ier = new InvalidErrorResource(e.getMessage(), fieldResources);
        ResponseEntity result = new ResponseEntity<Object>(ier, HttpStatus.BAD_REQUEST);
        logger.warn("Return ------- {}", result);
        return result;
    }


    // 處理全局異常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(Exception e){
        logger.error("Error : --- {}", e.getMessage());  // 具體的訊息
        return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
