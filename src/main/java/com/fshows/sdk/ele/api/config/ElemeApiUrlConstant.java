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
package com.fshows.sdk.ele.api.config;

/**
 * 饿了么接口地址
 *
 * @author CoderMa
 * @version ElemeApiUrlConstant.java, v 0.1 2020-04-01 16:32 CoderMa
 */
public class ElemeApiUrlConstant {

    /**
     * 授权页获取凭证接口(AuthToken)
     */
    public static final String GET_AUTH_TOKEN = "/openapi/isv/getauthtoken";

    /**
     * 接口请求获取凭证接口(Token)
     */
    public static final String GET_TOKEN = "/openapi/isv/gettoken";

    /**
     * 查询余额接口
     */
    public static final String GET_AMOUNT = "/openapi/isv/getamount";

    /**
     * 查询门店列表接口
     */
    public static final String GET_SHOP_LIST = "/openapi/isv/getshoplist";

    /**
     * 修改门店信息接口
     */
    public static final String MODIFY_SHOP_INFO = "/openapi/isv/modifyshopinfo";

    /**
     * 查询门店信息接口
     */
    public static final String GET_SHOP_DETAIL = "/openapi/isv/getshopdetail";

    /**
     * 创建门店&新增门店接口
     */
    public static final String CREATE_SHOP = "/openapi/isv/createshop";

    /**
     * 获取商户品类列表接口
     */
    public static final String GET_SHOPS_CATEGORY_LIST = "/openapi/isv/getshopscategorylist";

    /**
     * 用户上传图片接口
     */
    public static final String UPLOAD_FILE = "/openapi/isv/uploadfile";

    /**
     * 订单预取消接口
     */
    public static final String GET_CANCEL_PRICE = "/openapi/isv/getcancelprice";

    /**
     * 获取取消原因列表接口（取消文案的返回）
     */
    public static final String GET_ORDER_CANCEL_MESSAGE = "/openapi/isv/getordercancelmessage";

    /**
     * 订单取消接口
     */
    public static final String CANNEL_ORDER = "/openapi/isv/cancelorder";

    /**
     * 询标品接口
     */
    public static final String GET_AVAILABLE_PRODUCT_LIST = "/openapi/isv/getavailableproductlist";

    /**
     * 询价接口
     */
    public static final String GET_ORDER_PRICE = "/openapi/isv/getorderprice";

    /**
     * 创建订单接口
     */
    public static final String CREATE_ORDER = "/openapi/isv/createorder";

    /**
     * 获取货损险套餐列表接口
     */
    public static final String GET_GOODS_INSURANCE_PACKAGE = "/openapi/isv/getgoodsinsurancepackage";

    /**
     * 获取投保人信息接口
     */
    public static final String GET_INSURED_PERSON_INFO = "/openapi/isv/getinsuredpersoninfo";

    /**
     * 核保接口
     */
    public static final String PREINSURANCE = "/openapi/isv/preinsurance";

    /**
     * 订单加调度费接口
     */
    public static final String ADD_TIP = "/openapi/isv/addtip";

    /**
     * 查询订单详情接口
     */
    public static final String GET_ORDER_DETAIL = "/openapi/isv/getorderdetail";

    /**
     * 查询骑手信息接口
     */
    public static final String GET_KNIGHT_INFO = "/openapi/isv/getknightinfo";

}