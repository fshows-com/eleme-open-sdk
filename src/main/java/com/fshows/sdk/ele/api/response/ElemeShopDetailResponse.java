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
import lombok.Data;

/**
 * 查询门店信息接口-出参
 *
 * @author CoderMa
 * @version ElemeShopDetailResponse.java, v 0.1 2020-04-03 13:24 CoderMa
 */
@Data
public class ElemeShopDetailResponse extends ElemeResponse {

    /**
     * userId
     */
    private String userId;

    /**
     * appid
     */
    private String appid;

    /**
     * 外部门店id，接入方的门店id
     */
    private String outShopId;

    /**
     * 商店名
     */
    private String shopName;

    /**
     * 商户手机号
     */
    private String shopPhone;

    /**
     * 经纬度地址
     */
    private String shopPoiAddress;

    /**
     * 具体地址
     */
    private String shopDetailAddress;

    /**
     * 商户经度(高德坐标系)
     */
    private String shopLongitude;

    /**
     * 商户纬度(高德坐标系)
     */
    private String shopLatitude;

    /**
     * 商户品类
     */
    private String shopCategory;

    /**
     * 商店拥有者姓名
     */
    private String shopOwnerName;

    /**
     * 身份证号
     */
    private String shopOwnerIdcard;

    /**
     * 调用图片上传身份证后，接口后返回的hash
     */
    private String shopOwnerIdcardHash;

    /**
     * 调用图片上传身份证后，接口后返回的url
     */
    private String shopOwnerIdcardUrl;

    /**
     * 统一社会信用代码
     */
    private String suCode;

    /**
     * 营业执照的hash，调用图片上传接口
     */
    private String businessLicenceHash;

    /**
     * 营业执照的url，调用图片上传接口
     */
    private String businessLicenceUrl;

    /**
     * 食品安全执照的hash，调用图片上传接口
     */
    private String foodLicensePicHash;

    /**
     * 食品安全执照的url，调用图片上传接口
     */
    private String foodLicensePicUrl;

}