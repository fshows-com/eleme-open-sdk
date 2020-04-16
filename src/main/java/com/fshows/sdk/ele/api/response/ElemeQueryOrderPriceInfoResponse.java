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
 * @version ElemeQueryOrderPriceInfoResponse.java, v 0.1 2020-04-07 11:21 CoderMa
 */
@Data
public class ElemeQueryOrderPriceInfoResponse {

    private String totalPrice;

    private String basicPrice;

    private String distancePrice;

    private String weightPrice;

    private String weight;

    private String tipPrice;

    private String deliveryPrice;

    private String couponPrice;

    private String obstaclePrice;

    private String payPrice;

    private String discountTotalPrice;

    private String showTotalPrice;

    private String showRedPacketPrice;

    private String showTipPrice;

    private String showDiscountTotalPrice;

    private String showPayPrice;

}