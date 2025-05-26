package com.dna.umc_springboot.common;

import com.dna.umc_springboot.annotation.ValidPage;
import com.dna.umc_springboot.apiPayload.code.status.ErrorStatus;
import com.dna.umc_springboot.apiPayload.exception.GeneralException;
import com.dna.umc_springboot.apiPayload.exception.handler.PageValidationException;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class ValidPageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ValidPage.class)
                && parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String pageParam = webRequest.getParameter("page");

        if (pageParam == null) {
            throw new GeneralException(ErrorStatus.PAGE_VALIDATION_ERROR);
        }

        int page = Integer.parseInt(pageParam);

        if (page < 1) {
            throw new GeneralException(ErrorStatus.PAGE_VALIDATION_ERROR);
        }

        return page - 1;
    }
}
