package com.scaler.test.controlleradvices;

import com.scaler.test.dtos.ArithmeticExceptionDto;
import com.scaler.test.dtos.ExceptionDto;
import com.scaler.test.execptions.ProductNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.exceptions;

@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto>handlerArithmeticException(){
        ArithmeticExceptionDto arithmeticExceptionDto= new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("SomeThing is Wrong");
        return new ResponseEntity<>(arithmeticExceptionDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Void> handleArrayIndexOutOfBoundException() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ExceptionHandler(ProductNotExistsException.class)
        public ResponseEntity<ExceptionDto>handleProductNotExistException(
                ProductNotExistsException exception
                )
        {
            ExceptionDto dto = new ExceptionDto();
            dto.setMessage(exception.getMessage());
            dto.setDetail("Check the product id. It probably doesn't exist.");

            return new ResponseEntity<>(dto, HttpStatus.OK);
        }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> genericException(Exception e) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
