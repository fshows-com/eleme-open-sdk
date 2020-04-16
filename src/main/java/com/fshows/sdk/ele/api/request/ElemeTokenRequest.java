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
package com.fshows.sdk.ele.api.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.fshows.sdk.ele.api.ElemeRequest;
import com.fshows.sdk.ele.api.config.ElemeApiUrlConstant;
import com.fshows.sdk.ele.api.response.ElemeTokenResponse;
import lombok.Data;

/**
 * 接口请求获取凭证接口(Token)-入参
 *
 * @author CoderMa
 * @version ElemeTokenRequest.java, v 0.1 2020-04-01 15:16 CoderMa
 */
@Data
public class ElemeTokenRequest extends BaseRequest implements ElemeRequest<ElemeTokenResponse> {

    private String appid;

    private Long time;

    @JSONField(name = "user_id")
    private String userId;

    private Integer refresh;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.GET_TOKEN;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeTokenResponse> getResponseClass() {
        return ElemeTokenResponse.class;
    }
}