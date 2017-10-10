package com.minori.svideo.common.response;

import java.util.List;

/**
 * Created by trungdovan on 15/02/2017.
 */
public class PageSvideo<T> {
  private final long count;
  private final List<T> page;

  public PageSvideo(long count, List<T> page) {
    this.count = count;
    this.page = page;
  }

  public long getCount() {
    return count;
  }

  public List<T> getPage() {
    return page;
  }

}
