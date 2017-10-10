package com.minori.svideo.rest.support;

import com.minori.svideo.common.response.PageSvideo;

import javax.validation.constraints.NotNull;

/**
 * Created by trungdovan on 20/01/2017.
 */
@FunctionalInterface
public interface FunctionalPageGateway<T, R> {
  /**
   * @param request for request
   * @return not Null
   */
  @NotNull
  PageSvideo<R> apply(@NotNull T request);
}
