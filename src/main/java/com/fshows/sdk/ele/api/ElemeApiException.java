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
package com.fshows.sdk.ele.api;

import java.text.MessageFormat;

/**
 * @author CoderMa
 * @version ElemeApiException.java, v 0.1 2020-04-08 16:20 CoderMa
 */
public class ElemeApiException extends Exception {

    private static final long serialVersionUID = 2645249866443981952L;

    private String errCode;
    private String errMsg;

    public ElemeApiException() {
        super();
    }

    public ElemeApiException(String errCode, String msgFormat, Object... args) {
        super(MessageFormat.format(msgFormat, args));
        this.errCode = errCode;
        this.errMsg = MessageFormat.format(msgFormat, args);
    }

    public ElemeApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElemeApiException(String message) {
        super(message);
    }

    public ElemeApiException(Throwable cause) {
        super(cause);
    }

    public ElemeApiException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}