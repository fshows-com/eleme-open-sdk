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
import com.fshows.sdk.ele.api.response.ElemeAddTipResponse;
import lombok.Data;

/**
 * 订单加调度费接口-入参
 *
 * @author CoderMa
 * @version ElemeAddTipRequest.java, v 0.1 2020-04-07 18:40 CoderMa
 */
@Data
public class ElemeAddTipRequest extends BaseRequest implements ElemeRequest<ElemeAddTipResponse> {

    /**
     * 加小费金额(分)
     */
    @JSONField(name = "add_tip_price")
    private Integer addTipPrice;

    /**
     * 待加小费的订单号
     */
    @JSONField(name = "order_no")
    private String orderNo;

    /**
     * 渠道appid
     */
    @JSONField(name = "appid")
    private String appid;

    /**
     * 调用方每次调用生成一个不重复的业务流水号
     */
    @JSONField(name = "business_sn")
    private String businessSn;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.ADD_TIP;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeAddTipResponse> getResponseClass() {
        return ElemeAddTipResponse.class;
    }
}