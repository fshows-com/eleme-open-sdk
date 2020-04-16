package com.fshows.sdk.ele.api;

import lombok.Data;

import java.io.Serializable;

/**
 * API基础响应信息。
 *
 * @author fengsheng
 */
@Data
public class ElemeResponse<E extends ElemeResponse> implements Serializable {

    private static final long serialVersionUID = 5014379068811962022L;

    private String errno;

    private String errmsg;

    private String sign;

    private String appid;

    private String code;

    private String msg;

    private String data;

}
