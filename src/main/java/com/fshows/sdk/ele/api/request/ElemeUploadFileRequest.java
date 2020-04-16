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
import com.fshows.sdk.ele.api.response.ElemeUploadFileResponse;
import lombok.Data;

/**
 * 用户上传图片接口-入参
 *
 * @author CoderMa
 * @version ElemeUploadFileRequest.java, v 0.1 2020-04-01 17:05 CoderMa
 */
@Data
public class ElemeUploadFileRequest extends BaseRequest implements ElemeRequest<ElemeUploadFileResponse> {

    /**
     * 文件类型：jpg
     */
    @JSONField(name = "file_type")
    private String fileType;

    /**
     * 图片的二进制信息
     */
    @JSONField(name = "file_binary")
    private String fileBinary;

    @Override
    public String getApiMethodName() {
        return ElemeApiUrlConstant.UPLOAD_FILE;
    }

    @Override
    public String getBusinessParam() {
        return JSON.toJSONString(this);
    }

    @Override
    public Class<ElemeUploadFileResponse> getResponseClass() {
        return ElemeUploadFileResponse.class;
    }
}