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
import com.fshows.sdk.ele.api.response.ElemeShopDetailResponse;
import lombok.Data;

/**
 * 查询门店信息接口-入参
 *
 * @author CoderMa
 * @version ElemeShopDetailRequest.java, v 0.1 2020-04-03 13:51 CoderMa
 */
@Data
public class ElemeShopDetailRequest extends BaseRequest implements ElemeRequest<ElemeShopDetailResponse> {

    /**
     * 用户id
     */
    @JSONField(name = "user_id")
    private String userId;

    /**
     * 门店id
     */
    @JSONField(name = "shop_id")
    private String shopId;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.GET_SHOP_DETAIL;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeShopDetailResponse> getResponseClass() {
        return ElemeShopDetailResponse.class;
    }
}