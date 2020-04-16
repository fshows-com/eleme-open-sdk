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

import com.fshows.sdk.ele.api.ElemeResponse;
import com.fshows.sdk.ele.api.request.ElemeQueryOrderDetailDeliveryInfoResponse;
import com.fshows.sdk.ele.api.request.ElemeQueryOrderDetailFinalPriceListResponse;
import com.fshows.sdk.ele.api.request.ElemeQueryOrderDetailGoodsInsuranceInfoResponse;
import lombok.Data;

import java.util.List;

/**
 * 查询订单详情接口-出参
 *
 * @author CoderMa
 * @version ElemeQueryOrderDetailResponse.java, v 0.1 2020-04-07 18:46 CoderMa
 */
@Data
public class ElemeQueryOrderDetailResponse extends ElemeResponse {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单小号
     */
    private Integer orderSn;

    /**
     * 顾客的城市
     */
    private String customerCity;

    /**
     * 顾客的poi地址
     */
    private String customerPoiAddress;

    /**
     * 顾客的额外地址
     */
    private String customerExtraAddress;

    /**
     * 顾客姓名
     */
    private String customerName;

    /**
     * 顾客的电话
     */
    private String customerTel;

    /**
     * 预计到达时间
     */
    private String expectFetchTime;

    /**
     * 配送时长
     */
    private Integer deliveryTime;

    /**
     * 订单创建时间
     */
    private String createdAt;

    /**
     * 商户品类
     */
    private String categoryItem;

    /**
     * 运力
     */
    private String deliveryPartyShow;

    /**
     * 订单当前状态
     */
    private String orderStatusName;

    /**
     * 当前状态时间
     */
    private String orderStatusTime;

    /**
     * 订单当前状态，调用取消接口时需要传入这个字段
     */
    private Integer orderStatus;

    /**
     * 订单原因码，调用取消接口时需要传入这个字段
     */
    private Integer orderReasonCode;

    /**
     * 货物来源
     */
    private String goodsSourceName;

    /**
     * 商户品类枚举值
     */
    private Integer goodsCategory;

    /**
     * 货品的重量，单位g
     */
    private Integer goodsWeight;

    /**
     * 订单状态说明
     */
    private String orderStatusTag;

    /**
     * 是否可以加小费，0不可以加
     */
    private Integer showAddTip;

    /**
     * 骑手信息
     */
    private ElemeQueryOrderDetailDeliveryInfoResponse deliveryInfo;

    /**
     * 订单最终加的小费值，单位分
     */
    private Long orderTip;

    /**
     * 订单最终价格，单位分
     */
    private Long finalPriceFen;

    /**
     * list里面的费用数值都是元，只起一个展示作用不参与运算
     */
    private List<ElemeQueryOrderDetailFinalPriceListResponse> finalPriceList;

    /**
     * 购买货损险信息
     */
    private ElemeQueryOrderDetailGoodsInsuranceInfoResponse goodsInsuranceInfo;

    /**
     * 订单状态:ElemeOrderStatusEnum.value
     */
    private String orderStatusEnum;

}