package org.hikeOn.Model.Response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ExceptionResponse {
	
	private String timestamp;

	private int statusCode;

	private HttpStatus status;

	private String message;

	private String devMessage;

	private String requestMethod;

	private String path;

}
