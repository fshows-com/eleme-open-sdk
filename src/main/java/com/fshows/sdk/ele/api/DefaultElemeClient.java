/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fshows.sdk.ele.api;

import com.alibaba.fastjson.JSON;
import com.fshows.sdk.ele.api.enums.ElemeResultCodeEnum;
import com.fshows.sdk.ele.api.response.ElemeParamErrorResponse;
import com.fshows.sdk.ele.api.utils.FsRequestUtil;
import com.fshows.sdk.ele.api.utils.StringPool;
import com.fshows.sdk.ele.api.utils.StringUtils;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CoderMa
 * @version DefaultElemeClient.java, v 0.1 2020-04-01 09:46 CoderMa
 */
@Data
public class DefaultElemeClient implements ElemeClient {

    private String serverUrl;

    private String appid;

    private String secretKey;

    public DefaultElemeClient(String serverUrl, String appid, String secretKey) {
        this.serverUrl = serverUrl;
        this.appid = appid;
        this.secretKey = secretKey;
    }

    @Override
    public <T extends ElemeResponse<ElemeResponse>> T execute(ElemeRequest<T> request) throws ElemeApiException {
        return execute(request, null, null);
    }

    @Override
    public <T extends ElemeResponse<ElemeResponse>> T execute(ElemeRequest<T> request, String token, String userId) throws ElemeApiException {
        ElemeResponse<ElemeResponse> elemeResponse = executeRequest(request, token, userId);
        T response = JSON.parseObject(elemeResponse.getData(), request.getResponseClass());
        return response;
    }

    @Override
    public <T extends ElemeResponse<ElemeResponse>> String executeString(ElemeRequest<T> request, String token, String userId) throws ElemeApiException {
        return executeRequest(request, token, userId).getData();
    }

    @Override
    public <T extends ElemeResponse<ElemeResponse>> List<T> executeArray(ElemeRequest<T> request, String token, String userId) throws ElemeApiException {
        String data = executeString(request, token, userId);
        //data会有返回false的情况，需要做个特殊处理
        if (data.equals(StringPool.FALSE)) {
            return new ArrayList<>();
        }
        List<T> response = JSON.parseArray(data, request.getResponseClass());
        return response;
    }

    public ElemeResponse<ElemeResponse> executeRequest(ElemeRequest request, String token, String userId) throws ElemeApiException {
        Map<String, Object> businessParamMap = JSON.parseObject(request.getBusinessParam(), Map.class);
        String time = businessParamMap.getOrDefault("time", StringPool.EMPTY).toString();
        if (StringUtils.isBlank(time)) {
            time = String.valueOf(System.currentTimeMillis() / 1000);
        }
        //加签
        String sign = Signer.sign(businessParamMap, token, secretKey, appid, time, userId);

        Map<String, String> param = new HashMap<>();
        param.put("appid", appid);
        param.put("sign", sign);
        param.put("time", time);
        param.put("user_id", userId);
        param.put("token", token);
        param.put("para", request.getBusinessParam());
        String response = null;
        try {
            response = FsRequestUtil.post(serverUrl + request.getApiMethodName(), param, 10000);
        } catch (IOException e) {
            throw new ElemeApiException(e);
        }
        ElemeResponse<ElemeResponse> elemeResponse = JSON.parseObject(response, ElemeResponse.class);
        if (null == elemeResponse) {
            throw new ElemeApiException("000001", "返回值为空！");
        }
        ElemeResultCodeEnum resultCodeEnum = ElemeResultCodeEnum.getByValue(elemeResponse.getErrno());
        if (null == resultCodeEnum) {
            throw new ElemeApiException(elemeResponse.getErrno(), elemeResponse.getErrmsg());
        }
        //判断是否成功
        if (!ElemeResultCodeEnum.SUCCESS.equals(resultCodeEnum)) {
            switch (resultCodeEnum) {
                case PARAM_ERROR:
                    //错误信息展示错误字段
                    ElemeParamErrorResponse paramErrorResponse = JSON.parseObject(elemeResponse.getData(), ElemeParamErrorResponse.class);
                    if (null == paramErrorResponse) {
                        throw new ElemeApiException(elemeResponse.getErrno(), "{0}", elemeResponse.getErrmsg());
                    }
                    throw new ElemeApiException(elemeResponse.getErrno(), "{0}:{1}", paramErrorResponse.getErrorKey(), elemeResponse.getErrmsg());
                default:
                    throw new ElemeApiException(elemeResponse.getErrno(), elemeResponse.getErrmsg());
            }
        }
        return elemeResponse;
    }


}