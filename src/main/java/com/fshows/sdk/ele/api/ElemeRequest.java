package com.fshows.sdk.ele.api;

/**
 * 请求接口。
 *
 * @author carver.gu
 * @since 1.0, Sep 12, 2009
 */
public interface ElemeRequest<T extends ElemeResponse> {

    /**
     * 获取TOP的API名称。
     */
    String getApiMethodName();

    /**
     * 获取业务参数
     */
    String getBusinessParam();

    /**
     * 得到当前API的响应结果类型
     */
    Class<T> getResponseClass();

}
