package com.microposter.server.common;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse {
private Boolean success = false;
private Object data;

public Boolean getSuccess() {
  return success;
}

public void setSuccess(Boolean success) {
  this.success = success;
}


public Object getData() {
  return data;
}

public void setData(Object data) {
  this.data = data;
}

}