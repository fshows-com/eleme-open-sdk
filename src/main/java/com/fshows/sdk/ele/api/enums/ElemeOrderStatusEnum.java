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
package com.fshows.sdk.ele.api.enums;

import com.fshows.sdk.ele.api.utils.StringUtils;

/**
 * 饿了么订单状态枚举
 *
 * @author CoderMa
 * @version ElemeOrderStatusEnum.java, v 0.1 2020-04-08 15:49 CoderMa
 */
public enum ElemeOrderStatusEnum {

    /**
     * 枚举列表
     */
    ORDER_STATUS_DISPATCH("订单已推单", "ORDER_STATUS_DISPATCH"),
    ORDER_STATUS_RECEIVE("订单已被骑手接单", "ORDER_STATUS_RECEIVE"),
    ORDER_STATUS_REACH("骑手已到店", "ORDER_STATUS_REACH"),
    ORDER_STATUS_PICKUP("骑手已取餐", "ORDER_STATUS_PICKUP"),
    ORDER_STATUS_FINISH("订单完成", "ORDER_STATUS_FINISH"),
    ORDER_STATUS_REFUSE("订单失败(包括寄件人取消、骑手拒单、运力系统取消等)", "ORDER_STATUS_REFUSE");

    private String name;
    private String value;

    ElemeOrderStatusEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static ElemeOrderStatusEnum getByValue(String value) {
        ElemeOrderStatusEnum[] valueList = ElemeOrderStatusEnum.values();
        for (ElemeOrderStatusEnum v : valueList) {
            if (StringUtils.equalsIgnoreCase(v.getValue(), value)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for property <tt>value</tt>.
     *
     * @return property value of value
     */
    public String getValue() {
        return value;
    }
}