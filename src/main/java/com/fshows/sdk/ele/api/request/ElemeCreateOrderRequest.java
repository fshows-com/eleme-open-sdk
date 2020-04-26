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

    /**
     * user_id
     */
    @JSONField(name = "user_id")
    private String userId;

    /**
     * 接入方的订单号, 接入方需要保证每次请求传入的out_order_no不重复
     */
    @JSONField(name = "out_order_no")
    private String outOrderNo;

    /**
     * 询价指定的优惠券id；-1: 本次询价不指定优惠券；0：使用默认的优惠券；其他有效的coupon_id: 使用指定coupon_id的优惠券
     */
    @JSONField(name = "coupon_id")
    private String couponId;

    /**
     * 店铺id
     */
    @JSONField(name = "shop_id")
    private String shopId;

    /**
     * 收货人手机号
     */
    @JSONField(name = "customer_tel")
    private String customerTel;

    /**
     * 收货人分机号
     */
    @JSONField(name = "customer_ext_tel")
    private String customerExtTel;

    /**
     * 收货人详细地址 X号楼X层XX号
     */
    @JSONField(name = "customer_addr")
    private String customerAddr;

    /**
     * 收货人poi地址(高德坐标系) XX省XX市XX区 XX街道 XX号
     */
    @JSONField(name = "customer_poi_addr")
    private String customerPoiAddr;

    /**
     * 收货人经度(高德坐标系)
     */
    @JSONField(name = "customer_longtitude")
    private String customerLongtitude;

    /**
     * 收货人纬度(高德坐标系)
     */
    @JSONField(name = "customer_latitude")
    private String customerLatitude;

    /**
     * 收货人姓名
     */
    @JSONField(name = "customer_name")
    private String customerName;

    /**
     * 订单总价(分)
     */
    @JSONField(name = "total_price")
    private String totalPrice;

    /**
     * 实付金额(分)
     */
    @JSONField(name = "pay_price")
    private String payPrice;

    /**
     * 订单来源(美团/饿了么/天猫), 详见下方接口说明的枚举
     */
    @JSONField(name = "order_source")
    private String orderSource;

    /**
     * 标品id
     */
    @JSONField(name = "product_id")
    private String productId;

    /**
     * 货品重量(单位:g)
     */
    @JSONField(name = "goods_weight")
    private String goodsWeight;

    /**
     * 询价接口返回的 order_price_detail_json 字段
     */
    @JSONField(name = "order_price_detail_json")
    private String orderPriceDetailJson;

    /**
     * 订单来源处的单号
     */
    @JSONField(name = "order_source_id")
    private String orderSourceId;

    /**
     * 订单小费, 单位:分 (注意: 需要和提单时传参的值一致)
     */
    @JSONField(name = "order_tip")
    private String orderTip;

    /**
     * 订单期望取货时间戳
     */
    @JSONField(name = "expect_fetch_time")
    private String expectFetchTime;

    /**
     * 订单小号
     */
    @JSONField(name = "sn")
    private String sn;

    /**
     * 询标品接口返回的标品对应的t_indexid
     */
    @JSONField(name = "t_indexid")
    private String tIndexid;

    /**
     * 货品价格 单位:分 (注意: 需要和提单时传参的值一致)
     */
    @JSONField(name = "goods_price")
    private String goodsPrice;

    /**
     * 订单备注, 长度<255字符
     */
    @JSONField(name = "order_remark")
    private String orderRemark;

    /**
     * 核保单号,如果有购买货损险，传入核保接口返回的核保单号
     */
    @JSONField(name = "insure_busi_order_no")
    private String insureBusiOrderNo;

    /**
     * 是否需要收货码，默认：0,需要时传入1。
     */
    @JSONField(name = "need_fetch_code")
    private String needFetchCode;

    /**
     * getavailableproductlist 接口返回的 predict_duration 字段, 建议传入(如果不传, 默认为45 , 会导致商户侧展示的预计送达时间不准确)
     */
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