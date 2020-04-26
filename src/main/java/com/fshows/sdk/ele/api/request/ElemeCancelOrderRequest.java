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
import com.fshows.sdk.ele.api.response.ElemeCancelOrderResponse;
import lombok.Data;

/**
 * 订单取消接口-入参
 *
 * @author CoderMa
 * @version ElemeCancelOrderRequest.java, v 0.1 2020-04-07 09:56 CoderMa
 */
@Data
public class ElemeCancelOrderRequest extends BaseRequest implements ElemeRequest<ElemeCancelOrderResponse> {

    /**
     * 跑腿这边的订单号
     */
    @JSONField(name = "order_no")
    private String orderNo;

    /**
     * 预取消接口返回的价格，单位都是分
     */
    @JSONField(name = "cancel_charge")
    private String cancelCharge;

    /**
     * 用户id
     */
    @JSONField(name = "user_id")
    private String userId;

    /**
     * 取消原因列表接口返回的文案，选填，
     */
    @JSONField(name = "cancel_reason")
    private String cancelReason;

    /**
     * 其他原因，需要用户手动输入
     */
    @JSONField(name = "other_reason")
    private String otherReason;

    /**
     * appid
     */
    @JSONField(name = "appid")
    private String appid;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.CANNEL_ORDER;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeCancelOrderResponse> getResponseClass() {
        return ElemeCancelOrderResponse.class;
    }
}