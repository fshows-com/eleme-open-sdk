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
import com.fshows.sdk.ele.api.response.ElemeCannelOrderResponse;
import lombok.Data;

/**
 * 订单取消接口-入参
 *
 * @author CoderMa
 * @version ElemeCannelOrderRequest.java, v 0.1 2020-04-07 09:56 CoderMa
 */
@Data
public class ElemeCannelOrderRequest extends BaseRequest implements ElemeRequest<ElemeCannelOrderResponse> {

    @JSONField(name = "order_no")
    private String orderNo;

    @JSONField(name = "cancel_charge")
    private String cancelCharge;

    @JSONField(name = "user_id")
    private String userId;

    @JSONField(name = "cancel_reason")
    private String cancelReason;

    @JSONField(name = "other_reason")
    private String otherReason;

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
    public Class<ElemeCannelOrderResponse> getResponseClass() {
        return ElemeCannelOrderResponse.class;
    }
}