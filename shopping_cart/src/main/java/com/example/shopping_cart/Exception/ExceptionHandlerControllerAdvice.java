package com.example.shopping_cart.Exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(EmployeeServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse<Void> handleException(final EmployeeServiceException exception,
			final HttpServletRequest request) {

		BaseResponse<Void> error = new BaseResponse<Void>();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

	@ExceptionHandler(ProductException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse<Void> ProductException(final ProductException exception,
			final HttpServletRequest request) {

		BaseResponse<Void> error = new BaseResponse<Void>();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

	@ExceptionHandler(NotGenerateTokenException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse<Void> NotGenerateTokenException(final NotGenerateTokenException exception,
			final HttpServletRequest request) {

		BaseResponse<Void> error = new BaseResponse<Void>();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

	@ExceptionHandler(UserNotExpiredException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse<Void> UserNotExpiredException(final UserNotExpiredException exception,
			final HttpServletRequest request) {

		BaseResponse<Void> error = new BaseResponse<Void>();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse<Void> UserNotFoundException(final UserNotFoundException exception,
			final HttpServletRequest request) {

		BaseResponse<Void> error = new BaseResponse<Void>();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

	@ExceptionHandler(UserNotAuthenticatedException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse<Void> UserNotAuthizException(final UserNotAuthenticatedException exception,
			final HttpServletRequest request) {

		BaseResponse<Void> error = new BaseResponse<Void>();
		error.setMessage("User not Authenticated");
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

	@ExceptionHandler(ErrorInInsertException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse<Void> ErrorInInsertException(final ErrorInInsertException exception,
			final HttpServletRequest request) {

		BaseResponse<Void> error = new BaseResponse<Void>();
		error.setMessage("Not Authenticated");
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse<Void> Exception(final Exception exception, final HttpServletRequest request) {

		BaseResponse<Void> error = new BaseResponse<Void>();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> validationHandler(MethodArgumentNotValidException exception) {
		HashMap<String, Object> resObj = new HashMap<String, Object>();
		String errorMsg = "validation is failed!";
		if (exception.getErrorCount() > 0) {
			List<String> errorDetails = new ArrayList<>();
			for (ObjectError error : exception.getBindingResult().getAllErrors()) {
				errorDetails.add(error.getDefaultMessage());
			}

			if (errorDetails.size() > 0)
				errorMsg = errorDetails.get(0);
		}

//		BaseResponse<Object> erroreMsg=new BaseResponse<>();
//		erroreMsg.setStatus( HttpStatus.BAD_REQUEST);
//		erroreMsg.setMessage(errorMsg);
		resObj.put("status", HttpStatus.BAD_REQUEST.value());
		resObj.put("message", errorMsg);
		return new ResponseEntity<>(resObj, HttpStatus.BAD_REQUEST);
//		return erroreMsg;
	}

}