package com.minori.svideo.common.response;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by trungdovan on 22/01/2017.
 */
public class SvideoPageResponse<T> extends SvideoResponse<SvideoPageDataResponse<T>> {

  public static <T> SvideoPageResponse<T> createPageResponse(Long count, List<T> list) {
    SvideoPageResponse<T> result = new SvideoPageResponse<>();
    result.setData(new SvideoPageDataResponse<>(count, list));
    return result;
  }

  public static <T> SvideoPageResponse<T> createErrorPageResponse(CodeEnum code, String desc) {
    if (code == CodeEnum.SUCCESS)
      throw new RuntimeException("Code must be NOT SUCCESS");
    return new SvideoPageResponse<>(code.getCode(), code.getMsg(), desc, null);
  }

  public SvideoPageResponse() {
    this.setCode(CodeEnum.SUCCESS.getCode());
    this.setMessage(CodeEnum.SUCCESS.getMsg());
  }

  private SvideoPageResponse(int code, @Nullable String message, @Nullable String desc, @Nullable SvideoPageDataResponse<T> data) {
    super(code, message, desc, data);
  }
}
