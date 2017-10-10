package com.minori.svideo.common.response;

import javax.annotation.Nullable;
import java.io.Serializable;

public class SvideoResponse<T> implements Serializable {
  private static final long serialVersionUID = -6669686067446636607L;
  protected T data;
  private int code;
  private String message;
  private String desc;

  public SvideoResponse() {
    // constructor for Jackson to binding data in Test
  }

  private SvideoResponse(int code, String message, T data) {
    this(code, message, null, data);
  }

  protected SvideoResponse(int code, @Nullable String message, @Nullable String desc, @Nullable T data) {
    super();
    this.code = code;
    this.message = message;
    this.desc = desc;
    this.data = data;
  }

  public static <T> SvideoResponse<T> createSuccessMessage(@Nullable T data) {
    CodeEnum type = CodeEnum.SUCCESS;
    return new SvideoResponse<>(type.getCode(), type.getMsg(), data);
  }

  public static <T> SvideoResponse<T> createErrorMessage(CodeEnum code, String desc) {
    if (code == CodeEnum.SUCCESS)
      throw new RuntimeException("code must NOT be SUCCESS");
    return new SvideoResponse<>(code.getCode(), code.getMsg(), desc, null);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "ResponseInfo [code=" + code + ", message='" + message + ", desc = '" + desc + "', data = " + data + "]";
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
  
  public enum CodeEnum {
    SUCCESS(1, "success!!"),
    UNKNOWN_ERR(-1, "unknown error"),
    NOT_ENOUGH_PARAM_ERR(401, "NOT enough params in request"),
    WRONG_PARAM_ERR(402, "wrong params in request"),
    WRONG_FORMAT_PARAM_ERR(403, "wrong format of params in request"),
    ACCESS_DENIED(600, "Access Denied");

    private final int code;
    private final String msg;

    CodeEnum(int code, String msg) {
      this.code = code;
      this.msg = msg;
    }

    public int getCode() {
      return code;
    }

    public String getMsg() {
      return msg;
    }
  }
}
