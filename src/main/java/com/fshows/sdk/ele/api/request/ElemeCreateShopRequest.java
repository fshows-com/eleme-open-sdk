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
import com.fshows.sdk.ele.api.response.ElemeCreateShopResponse;
import lombok.Data;

/**
 * 创建门店&新增门店接口-入参
 *
 * @author CoderMa
 * @version ElemeCreateShopRequest.java, v 0.1 2020-04-01 17:16 CoderMa
 */
@Data
public class ElemeCreateShopRequest extends BaseRequest implements ElemeRequest<ElemeCreateShopResponse> {

    /**
     * userId
     */
    @JSONField(name = "user_id")
    private String userId;

    /**
     * appid
     */
    private String appid;

    /**
     * 外部门店id，接入方的门店id
     */
    @JSONField(name = "out_shop_id")
    private String outShopId;

    /**
     * 商店名
     */
    @JSONField(name = "shop_name")
    private String shopName;

    /**
     * 商户手机号
     */
    @JSONField(name = "shop_phone")
    private String shopPhone;

    /**
     * 经纬度地址
     */
    @JSONField(name = "shop_poi_address")
    private String shopPoiAddress;

    /**
     * 具体地址
     */
    @JSONField(name = "shop_detail_address")
    private String shopDetailAddress;

    /**
     * 商户经度(高德坐标系)
     */
    @JSONField(name = "shop_longitude")
    private String shopLongitude;

    /**
     * 商户纬度(高德坐标系)
     */
    @JSONField(name = "shop_latitude")
    private String shopLatitude;

    /**
     * 商户品类
     */
    @JSONField(name = "shop_category")
    private String shopCategory;

    /**
     * 商店拥有者姓名
     */
    @JSONField(name = "shop_owner_name")
    private String shopOwnerName;

    /**
     * 身份证号
     */
    @JSONField(name = "shop_owner_idcard")
    private String shopOwnerIdcard;

    /**
     * 调用图片上传身份证后，接口后返回的hash
     */
    @JSONField(name = "shop_owner_idcard_hash")
    private String shopOwnerIdcardHash;

    /**
     * 调用图片上传身份证后，接口后返回的url
     */
    @JSONField(name = "shop_owner_idcard_url")
    private String shopOwnerIdcardUrl;

    /**
     * 统一社会信用代码
     */
    @JSONField(name = "su_code")
    private String suCode;

    /**
     * 营业执照的hash，调用图片上传接口 // TODO： 不一定有
     */
    @JSONField(name = "business_licence_hash")
    private String businessLicenceHash;

    /**
     * 营业执照的url，调用图片上传接口 // TODO： 不一定有
     */
    @JSONField(name = "business_licence_url")
    private String businessLicenceUrl;

    /**
     * 食品安全执照的hash，调用图片上传接口
     */
    @JSONField(name = "food_license_pic_hash")
    private String foodLicensePicHash;

    /**
     * 食品安全执照的url，调用图片上传接口
     */
    @JSONField(name = "food_license_pic_url")
    private String foodLicensePicUrl;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.CREATE_SHOP;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeCreateShopResponse> getResponseClass() {
        return ElemeCreateShopResponse.class;
    }
}