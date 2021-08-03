package com.projeto.mult3.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

			@Autowired
			private MessageSource messageSource;
			
			@ResponseStatus(code = HttpStatus.BAD_REQUEST)
			@ExceptionHandler(MethodArgumentNotValidException.class)
			public List<ErrorDto> handle(MethodArgumentNotValidException exception) {
				List<ErrorDto> excep = new ArrayList<>();
				
				List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
				fieldErrors.forEach(e -> {
					String mensagem = messageSource.getMessage(e,LocaleContextHolder.getLocale());
					ErrorDto erro = new ErrorDto(e.getField(), mensagem );
				excep.add(erro);
				});
				
				return excep;
			}
			
			@ResponseStatus(code = HttpStatus.CONFLICT)
			@ExceptionHandler(DataIntegrityViolationException.class)
				public  String dataHandle(DataIntegrityViolationException exception) {
				return "Este e-mail já está cadastrado no sistema";
			}
			
		
			
			
}
