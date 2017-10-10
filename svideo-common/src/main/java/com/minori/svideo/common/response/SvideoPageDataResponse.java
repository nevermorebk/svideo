package com.minori.svideo.common.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by trungdovan on 22/01/2017.
 */
public class SvideoPageDataResponse<T> implements Serializable {
  private Long count;
  private List<T> page;

  public SvideoPageDataResponse() {
    //contract for jackson create Response and binding data
  }

  public SvideoPageDataResponse(Long count, List<T> page) {
    this.count = count;
    this.page = page;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public List<T> getPage() {
    return page;
  }

  public void setPage(List<T> page) {
    this.page = page;
  }
}
