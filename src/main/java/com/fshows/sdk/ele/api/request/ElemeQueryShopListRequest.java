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
import com.fshows.sdk.ele.api.response.ElemeQueryShopListResponse;
import lombok.Data;

/**
 * 查询门店列表接口-入参
 *
 * @author CoderMa
 * @version ElemeQueryShopListRequest.java, v 0.1 2020-04-01 16:21 CoderMa
 */
@Data
public class ElemeQueryShopListRequest extends BaseRequest implements ElemeRequest<ElemeQueryShopListResponse> {

    /**
     * 用户id
     */
    @JSONField(name = "user_id")
    private String userId;

    /**
     * 当前分页 默认:1
     */
    @JSONField(name = "cur_page")
    private Integer pageNum;

    /**
     * 每页记录数 默认: 20
     */
    @JSONField(name = "per_page")
    private Integer pageSize;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.GET_SHOP_LIST;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeQueryShopListResponse> getResponseClass() {
        return ElemeQueryShopListResponse.class;
    }
}