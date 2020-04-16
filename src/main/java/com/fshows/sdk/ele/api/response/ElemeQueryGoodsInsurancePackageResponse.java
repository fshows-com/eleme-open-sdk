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
package com.fshows.sdk.ele.api.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fshows.sdk.ele.api.ElemeResponse;
import lombok.Data;

/**
 * 获取货损险套餐列表接口-出参
 *
 * @author CoderMa
 * @version ElemeQueryGoodsInsurancePackageResponse.java, v 0.1 2020-04-07 16:13 CoderMa
 */
@Data
public class ElemeQueryGoodsInsurancePackageResponse extends ElemeResponse {

    @JSONField(name = "insured_plan_id")
    private String insuredPlanId;

    @JSONField(name = "premium")
    private Integer premium;

    @JSONField(name = "total_insured_amount")
    private Integer totalInsuredAmount;

    @JSONField(name = "show_premium")
    private String showPremium;

    @JSONField(name = "show_total_insured_amount")
    private String showTotalInsuredAmount;

}