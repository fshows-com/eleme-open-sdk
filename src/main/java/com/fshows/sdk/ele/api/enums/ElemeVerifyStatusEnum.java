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

/**
 * 饿了么审核状态枚举
 *
 * @author CoderMa
 * @version ElemeVerifyStatusEnum.java, v 0.1 2020-04-08 17:38 CoderMa
 */
public enum ElemeVerifyStatusEnum {

    /**
     * 枚举列表
     */
    //未认证(通常不会出现)
    NO_VERIFY("未认证", 0),
    VERIFYING("认证中", 10),
    //(只有这种情况 允许询价/提单/询标品)
    VERIFY_SUCCESS("认证成功", 20),
    VERIFY_ERROR("认证失败", 30);

    private String name;
    private Integer value;

    ElemeVerifyStatusEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public static ElemeVerifyStatusEnum getByValue(Integer value) {
        ElemeVerifyStatusEnum[] valueList = ElemeVerifyStatusEnum.values();
        for (ElemeVerifyStatusEnum v : valueList) {
            if (v.getValue().equals(value)) {
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
    public Integer getValue() {
        return value;
    }
}