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

import lombok.Data;

/**
 * @author CoderMa
 * @version ElemeQueryKnightInfoDeliveryInfoResponse.java, v 0.1 2020-04-07 19:09 CoderMa
 */
@Data
public class ElemeQueryKnightInfoDeliveryInfoResponse {

    /**
     * 骑手姓名
     */
    private String deliveryName;

    /**
     * 骑手电话
     */
    private String deliveryPhone;

    /**
     * 运力类型(汉字)
     */
    private String deliveryParty;

    /**
     * 骑手经度
     */
    private String deliveryLongitude;

    /**
     * 骑手纬度
     */
    private String deliveryLatitude;

}