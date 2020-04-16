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
 * 饿了么返回值code枚举
 *
 * @author CoderMa
 * @version ElemeResultCodeEnum.java, v 0.1 2020-04-08 16:00 CoderMa
 */
public enum ElemeResultCodeEnum {

    /**
     * 返回值code枚举
     */
    SUCCESS("SUCCESS", "0"),
    ERR_SYS_ERROR("系统错误", "800000005"),
    ERR_REQUEST_PARAM_NOT_SUIT("公参和业务参数不匹配", "800000092"),
    ERR_REQUEST_TOKEN_TIMEOUT("TOKEN错误", "800000093"),
    ERR_REQUEST_SIGN("签名错误", "8000000094"),
    ERR_REQUEST_TOKEN("TOKEN错误", "800000095"),
    ERR_REQUEST_OUT_OF_TIMERANGE("请求过期", "8000000096"),
    ERR_REQUEST_REPEAT("重复请求", "8000000098"),
    ERR_PUBLIC_PARAM("公参错误", "8000000097"),
    PARAM_ERROR("参数错误", "8000000099"),

    ;

    private String name;
    private String value;

    ElemeResultCodeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static ElemeResultCodeEnum getByValue(String value) {
        ElemeResultCodeEnum[] valueList = ElemeResultCodeEnum.values();
        for (ElemeResultCodeEnum v : valueList) {
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
    public String getValue() {
        return value;
    }
}