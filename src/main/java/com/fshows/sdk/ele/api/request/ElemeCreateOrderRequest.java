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
import com.fshows.sdk.ele.api.response.ElemeCreateOrderResponse;
import lombok.Data;

/**
 * 创建订单接口-入参
 *
 * @author CoderMa
 * @version ElemeCreateOrderRequest.java, v 0.1 2020-04-07 11:26 CoderMa
 */
@Data
public class ElemeCreateOrderRequest extends BaseRequest implements ElemeRequest<ElemeCreateOrderResponse> {

    @JSONField(name = "user_id")
    private String userId;

    @JSONField(name = "out_order_no")
    private String outOrderNo;

    @JSONField(name = "coupon_id")
    private String couponId;

    @JSONField(name = "shop_id")
    private String shopId;

    @JSONField(name = "customer_tel")
    private String customerTel;

    @JSONField(name = "customer_ext_tel")
    private String customerExtTel;

    @JSONField(name = "customer_addr")
    private String customerAddr;

    @JSONField(name = "customer_poi_addr")
    private String customerPoiAddr;

    @JSONField(name = "customer_longtitude")
    private String customerLongtitude;

    @JSONField(name = "customer_latitude")
    private String customerLatitude;

    @JSONField(name = "customer_name")
    private String customerName;

    @JSONField(name = "total_price")
    private String totalPrice;

    @JSONField(name = "pay_price")
    private String payPrice;

    @JSONField(name = "order_source")
    private String orderSource;

    @JSONField(name = "product_id")
    private String productId;

    @JSONField(name = "goods_weight")
    private String goodsWeight;

    @JSONField(name = "order_price_detail_json")
    private String orderPriceDetailJson;

    @JSONField(name = "order_source_id")
    private String orderSourceId;

    @JSONField(name = "order_tip")
    private String orderTip;

    @JSONField(name = "expect_fetch_time")
    private String expectFetchTime;

    @JSONField(name = "sn")
    private String sn;

    @JSONField(name = "t_indexid")
    private String tIndexid;

    @JSONField(name = "goods_price")
    private String goodsPrice;

    @JSONField(name = "order_remark")
    private String orderRemark;

    @JSONField(name = "insure_busi_order_no")
    private String insureBusiOrderNo;

    @JSONField(name = "need_fetch_code")
    private String needFetchCode;

    @JSONField(name = "predict_duration")
    private Integer predictDuration;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.CREATE_ORDER;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeCreateOrderResponse> getResponseClass() {
        return ElemeCreateOrderResponse.class;
    }
}