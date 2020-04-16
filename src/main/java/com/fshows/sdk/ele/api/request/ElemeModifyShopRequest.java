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
import com.fshows.sdk.ele.api.response.ElemeModifyShopResponse;
import lombok.Data;

/**
 * 修改门店信息接口-入参
 *
 * @author CoderMa
 * @version ElemeModifyShopRequest.java, v 0.1 2020-04-03 00:59 CoderMa
 */
@Data
public class ElemeModifyShopRequest extends BaseRequest implements ElemeRequest<ElemeModifyShopResponse> {

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
     * 饿了么门店id
     */
    @JSONField(name = "shop_id")
    private String shopId;

    /**
     * 商店名（可以修改）
     */
    @JSONField(name = "shop_name")
    private String shopName;

    /**
     * 商户手机号（可以修改）
     */
    @JSONField(name = "shop_phone")
    private String shopPhone;

    /**
     * 经纬度地址（可以修改）
     */
    @JSONField(name = "shop_poi_address")
    private String shopPoiAddress;

    /**
     * 具体地址（可以修改）
     */
    @JSONField(name = "shop_detail_address")
    private String shopDetailAddress;

    /**
     * 商户经度(高德坐标系)（可以修改）
     */
    @JSONField(name = "shop_longitude")
    private String shopLongitude;

    /**
     * 商户纬度(高德坐标系)（可以修改）
     */
    @JSONField(name = "shop_latitude")
    private String shopLatitude;

    /**
     * 商户品类（可以修改）
     */
    @JSONField(name = "shop_category")
    private String shopCategory;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.MODIFY_SHOP_INFO;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeModifyShopResponse> getResponseClass() {
        return ElemeModifyShopResponse.class;
    }
}