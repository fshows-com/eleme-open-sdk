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
import com.fshows.sdk.ele.api.response.ElemePreinsuranceResponse;
import lombok.Data;

/**
 * 核保接口-入参
 *
 * @author CoderMa
 * @version ElemePreinsuranceRequest.java, v 0.1 2020-04-07 17:51 CoderMa
 */
@Data
public class ElemePreinsuranceRequest extends BaseRequest implements ElemeRequest<ElemePreinsuranceResponse> {

    /**
     * 用户真实姓名
     */
    @JSONField(name = "person_name")
    private String personName;

    /**
     * 身份证
     */
    @JSONField(name = "person_idcard")
    private String personIdcard;

    /**
     * 手机号码
     */
    @JSONField(name = "phone")
    private String phone;

    /**
     * 选择的货损险套餐编号id，根据getgoodsinsurancepackage获取
     */
    @JSONField(name = "insured_plan_id")
    private String insuredPlanId;

    /**
     * 期望取货时间戳
     */
    @JSONField(name = "expect_fetch_time")
    private String expectFetchTime;

    /**
     * 货物重量(单位：kg)
     */
    @JSONField(name = "goods_weight")
    private String goodsWeight;

    /**
     * 用户id
     */
    @JSONField(name = "user_id")
    private String userId;

    /**
     * 渠道appid
     */
    @JSONField(name = "appid")
    private String appid;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.PREINSURANCE;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemePreinsuranceResponse> getResponseClass() {
        return ElemePreinsuranceResponse.class;
    }
}