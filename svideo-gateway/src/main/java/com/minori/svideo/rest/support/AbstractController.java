package com.minori.svideo.rest.support;


import com.minori.svideo.common.response.PageSvideo;
import com.minori.svideo.common.response.SvideoPageResponse;
import com.minori.svideo.common.response.SvideoResponse;
import com.minori.svideo.service.exception.AccessDeniedException;
import com.minori.svideo.service.exception.WrongFormatParamException;
import com.minori.svideo.service.exception.WrongParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class AbstractController {
  private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

  protected <T, R> SvideoResponse<R> requestGW(T request, FunctionalGateway<T, R> runner) {
    try {
      Optional<R> result = runner.apply(request);
      return SvideoResponse.createSuccessMessage(result.orElse(null));
    } catch (WrongParamException ex) {
      return SvideoResponse.createErrorMessage(SvideoResponse.CodeEnum.WRONG_PARAM_ERR, ex.getMessage());
    } catch (WrongFormatParamException ex) {
      return SvideoResponse.createErrorMessage(SvideoResponse.CodeEnum.WRONG_FORMAT_PARAM_ERR, ex.getMessage());
    } catch (AccessDeniedException ex) {
      return SvideoResponse.createErrorMessage(SvideoResponse.CodeEnum.ACCESS_DENIED, ex.getMessage());
    } catch (Exception ex) {
      logger.warn("Unable to runGateway, request: " + request, ex);
      return SvideoResponse.createErrorMessage(SvideoResponse.CodeEnum.UNKNOWN_ERR, "failure: type: " + ex.getClass().getName() + ", message: " + ex.getMessage());
    }
  }

  protected <T, R> SvideoPageResponse<R> requestPageGW(T request, FunctionalPageGateway<T, R> runner) {
    try {
      PageSvideo<R> result = runner.apply(request);
      return SvideoPageResponse.createPageResponse(result.getCount(), result.getPage());
    } catch (WrongParamException ex) {
      return SvideoPageResponse.createErrorPageResponse(SvideoResponse.CodeEnum.WRONG_PARAM_ERR, ex.getMessage());
    } catch (WrongFormatParamException ex) {
      return SvideoPageResponse.createErrorPageResponse(SvideoResponse.CodeEnum.WRONG_FORMAT_PARAM_ERR, ex.getMessage());
    } catch (AccessDeniedException ex) {
      return SvideoPageResponse.createErrorPageResponse(SvideoResponse.CodeEnum.ACCESS_DENIED, ex.getMessage());
    } catch (Exception ex) {
      logger.warn("Unable to runGateway, request: " + request, ex);
      return SvideoPageResponse.createErrorPageResponse(SvideoResponse.CodeEnum.UNKNOWN_ERR, "failure: type: " + ex.getClass().getName() + ", message: " + ex.getMessage());
    }
  }

}


