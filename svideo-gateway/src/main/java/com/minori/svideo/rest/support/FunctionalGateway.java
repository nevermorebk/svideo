package com.minori.svideo.rest.support;

import java.util.Optional;

/**
 * Created by trungdovan on 20/01/2017.
 */
@FunctionalInterface
public interface FunctionalGateway<T, R> {
  Optional<R> apply(T request);
}
