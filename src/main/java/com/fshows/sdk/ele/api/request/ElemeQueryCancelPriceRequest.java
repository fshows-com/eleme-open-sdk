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
import com.fshows.sdk.ele.api.response.ElemeQueryCancelPriceResponse;
import lombok.Data;

/**
 * 订单预取消接口-入参
 *
 * @author CoderMa
 * @version ElemeQueryCancelPriceRequest.java, v 0.1 2020-04-03 14:25 CoderMa
 */
@Data
public class ElemeQueryCancelPriceRequest extends BaseRequest implements ElemeRequest<ElemeQueryCancelPriceResponse> {

    /**
     * 蜂鸟这边的订单号
     */
    @JSONField(name = "order_no")
    private String orderNo;

    /**
     * 需要先调用getOrderDetail接口拿到这个字段
     */
    @JSONField(name = "order_status")
    private Integer orderStatus;

    /**
     * 先调用getOrderDetail接口拿到这个字段
     */
    @JSONField(name = "order_reason_code")
    private Integer orderReasonCode;

    /**
     * 用户id
     */
    @JSONField(name = "user_id")
    private String userId;

    /**
     * appid
     */
    private String appid;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.GET_CANCEL_PRICE;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeQueryCancelPriceResponse> getResponseClass() {
        return ElemeQueryCancelPriceResponse.class;
    }
}