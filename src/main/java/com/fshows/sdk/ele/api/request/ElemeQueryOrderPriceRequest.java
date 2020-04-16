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
import com.fshows.sdk.ele.api.response.ElemeQueryOrderPriceResponse;
import lombok.Data;

/**
 * 询价接口-入参
 *
 * @author CoderMa
 * @version ElemeQueryOrderPriceRequest.java, v 0.1 2020-04-07 10:49 CoderMa
 */
@Data
public class ElemeQueryOrderPriceRequest extends BaseRequest implements ElemeRequest<ElemeQueryOrderPriceResponse> {

    @JSONField(name = "user_id")
    private String userId;

    @JSONField(name = "shop_id")
    private String shopId;

    @JSONField(name = "coupon_id")
    private String couponId;

    @JSONField(name = "pk_id")
    private String pkId;

    @JSONField(name = "product_id")
    private String productId;

    @JSONField(name = "customerLon")
    private String customerLon;

    @JSONField(name = "customerLat")
    private String customerLat;

    @JSONField(name = "expect_fetch_time")
    private String expectFetchTime;

    @JSONField(name = "goods_weight")
    private String goodsWeight;

    @JSONField(name = "goods_price")
    private String goodsPrice;

    @JSONField(name = "order_tip")
    private String orderTip;

    @JSONField(name = "order_source")
    private String orderSource;

    @JSONField(name = "insure_busi_order_no")
    private String insureBusiOrderNo;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.GET_ORDER_PRICE;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class getResponseClass() {
        return ElemeQueryOrderPriceResponse.class;
    }
}