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
import com.fshows.sdk.ele.api.response.ElemeQueryAvailableProductListResponse;
import lombok.Data;

/**
 * 询标品接口-入参
 *
 * @author CoderMa
 * @version ElemeQueryAvailableProductListRequest.java, v 0.1 2020-04-07 10:29 CoderMa
 */
@Data
public class ElemeQueryAvailableProductListRequest extends BaseRequest implements ElemeRequest<ElemeQueryAvailableProductListResponse> {

    /**
     * 店铺id
     */
    @JSONField(name = "shop_id")
    private String shopId;

    /**
     * 收件人经度
     */
    @JSONField(name = "customer_lon")
    private String customerLon;

    /**
     * 收件人纬度
     */
    @JSONField(name = "customer_lat")
    private String customerLat;

    /**
     * 期望取货时间戳
     */
    @JSONField(name = "expect_fetch_time")
    private String expectFetchTime;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.GET_AVAILABLE_PRODUCT_LIST;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeQueryAvailableProductListResponse> getResponseClass() {
        return ElemeQueryAvailableProductListResponse.class;
    }
}