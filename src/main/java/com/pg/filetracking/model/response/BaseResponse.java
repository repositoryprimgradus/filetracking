package com.pg.filetracking.model.response;

import lombok.Data;

@Data

public class BaseResponse {
	
	private String statusCode;
	private String statusMessage;
	private String statusDesc;

}
