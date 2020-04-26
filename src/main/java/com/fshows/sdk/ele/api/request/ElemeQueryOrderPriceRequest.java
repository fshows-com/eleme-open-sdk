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

    /**
     * 询价指定的优惠券id;-1: 本次询价不指定优惠券	;0：使用默认的优惠券;其他有效的coupon_id: 使用指定coupon_id的优惠券
     */
    @JSONField(name = "coupon_id")
    private String couponId;

    /**
     * 若指定优惠券id, 则需要传入上次询价返回的pk_id
     */
    @JSONField(name = "pk_id")
    private String pkId;

    /**
     * 标品id
     */
    @JSONField(name = "product_id")
    private String productId;

    /**
     * 收件人经度
     */
    @JSONField(name = "customerLon")
    private String customerLon;

    /**
     * 收件人纬度
     */
    @JSONField(name = "customerLat")
    private String customerLat;

    /**
     * 期望取货时间戳
     */
    @JSONField(name = "expect_fetch_time")
    private String expectFetchTime;

    /**
     * 货品重量(g)
     */
    @JSONField(name = "goods_weight")
    private String goodsWeight;

    /**
     * 货品价格, 单位:分 (注意: 需要和提单时传参的值一致)
     */
    @JSONField(name = "goods_price")
    private String goodsPrice;

    /**
     * 订单小费, 单位:分 (注意: 需要和提单时传参的值一致)
     */
    @JSONField(name = "order_tip")
    private String orderTip;

    /**
     * 订单来源(美团/饿了么/天猫), 详见下方接口说明的枚举
     */
    @JSONField(name = "order_source")
    private String orderSource;

    /**
     * 核保单号，如果有购买货损险，传入核保接口返回的核保单号
     */
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