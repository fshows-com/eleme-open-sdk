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

import java.util.List;

/**
 * 查询门店列表接口-出参
 *
 * @author CoderMa
 * @version ElemeQueryShopListResponse.java, v 0.1 2020-04-01 16:15 CoderMa
 */
@Data
public class ElemeQueryShopListResponse extends ElemeResponse<ElemeResponse> {

    private Integer shopCount;

    private Integer curPage;

    private Integer perPage;

    private List<ElemeQueryShopListInfoResponse> shopList;

}