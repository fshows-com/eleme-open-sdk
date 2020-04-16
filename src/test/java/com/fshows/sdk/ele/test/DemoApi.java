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
package com.fshows.sdk.ele.test;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.fshows.sdk.ele.api.DefaultElemeClient;
import com.fshows.sdk.ele.api.ElemeApiException;
import com.fshows.sdk.ele.api.ElemeClient;
import com.fshows.sdk.ele.api.request.ElemeAddTipRequest;
import com.fshows.sdk.ele.api.request.ElemeAuthTokenRequest;
import com.fshows.sdk.ele.api.request.ElemeCannelOrderRequest;
import com.fshows.sdk.ele.api.request.ElemeCreateOrderRequest;
import com.fshows.sdk.ele.api.request.ElemeCreateShopRequest;
import com.fshows.sdk.ele.api.request.ElemeModifyShopRequest;
import com.fshows.sdk.ele.api.request.ElemePreinsuranceRequest;
import com.fshows.sdk.ele.api.request.ElemeQueryAmountRequest;
import com.fshows.sdk.ele.api.request.ElemeQueryAvailableProductListRequest;
import com.fshows.sdk.ele.api.request.ElemeQueryCancelPriceRequest;
import com.fshows.sdk.ele.api.request.ElemeQueryGoodsInsurancePackageRequest;
import com.fshows.sdk.ele.api.request.ElemeQueryInsuredPersonInfoRequest;
import com.fshows.sdk.ele.api.request.ElemeQueryKnightInfoRequest;
import com.fshows.sdk.ele.api.request.ElemeQueryOrderCancelmessageRequest;
import com.fshows.sdk.ele.api.request.ElemeQueryOrderDetailRequest;
import com.fshows.sdk.ele.api.request.ElemeQueryOrderPriceRequest;
import com.fshows.sdk.ele.api.request.ElemeQueryShopListRequest;
import com.fshows.sdk.ele.api.request.ElemeShopCategoryListRequest;
import com.fshows.sdk.ele.api.request.ElemeShopDetailRequest;
import com.fshows.sdk.ele.api.request.ElemeTokenRequest;
import com.fshows.sdk.ele.api.request.ElemeUploadFileRequest;
import com.fshows.sdk.ele.api.response.ElemeAddTipResponse;
import com.fshows.sdk.ele.api.response.ElemeAuthTokenResponse;
import com.fshows.sdk.ele.api.response.ElemeCannelOrderResponse;
import com.fshows.sdk.ele.api.response.ElemeCreateOrderResponse;
import com.fshows.sdk.ele.api.response.ElemeCreateShopResponse;
import com.fshows.sdk.ele.api.response.ElemeModifyShopResponse;
import com.fshows.sdk.ele.api.response.ElemePreinsuranceResponse;
import com.fshows.sdk.ele.api.response.ElemeQueryAmountResponse;
import com.fshows.sdk.ele.api.response.ElemeQueryAvailableProductListResponse;
import com.fshows.sdk.ele.api.response.ElemeQueryCancelPriceResponse;
import com.fshows.sdk.ele.api.response.ElemeQueryGoodsInsurancePackageResponse;
import com.fshows.sdk.ele.api.response.ElemeQueryInsuredPersonInfoResponse;
import com.fshows.sdk.ele.api.response.ElemeQueryKnightInfoResponse;
import com.fshows.sdk.ele.api.response.ElemeQueryOrderCancelMessageResponse;
import com.fshows.sdk.ele.api.response.ElemeQueryOrderDetailResponse;
import com.fshows.sdk.ele.api.response.ElemeQueryOrderPriceResponse;
import com.fshows.sdk.ele.api.response.ElemeQueryShopListResponse;
import com.fshows.sdk.ele.api.response.ElemeShopCategoryListResponse;
import com.fshows.sdk.ele.api.response.ElemeShopDetailResponse;
import com.fshows.sdk.ele.api.response.ElemeTokenResponse;
import com.fshows.sdk.ele.api.response.ElemeUploadFileResponse;
import com.fshows.sdk.ele.api.utils.StringUtils;
import org.junit.Before;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.util.List;

/**
 * @author CoderMa
 * @version DemoApi.java, v 0.1 2020-03-30 16:59 CoderMa
 */
public class DemoApi {

    private static String serverUrl = "http://isv-pt.alta.elenet.me";

    //业务门店id
    private static String outStoreId = "102400001";

    private static String token;
    private static String appid = "xxx";
    private static String secretKey = "xxx";

    //授权页获取凭证后会回调到回调接口中
    private static String userId = "xxx";

    //饿了么门店id
    private static String elemeShopId = "xxx";

    private ElemeClient elemeClient;

    @Before
    public void config() throws ElemeApiException {
        elemeClient = getClient();
        getToken();
    }

    public ElemeClient getClient() {
        return new DefaultElemeClient(serverUrl, appid, secretKey);
    }

    /**
     * 接口请求获取凭证接口(Token)
     */
    @Test
    public void getToken() throws ElemeApiException {
        if (StringUtils.isNotBlank(token)) {
            return;
        }
        ElemeTokenRequest request = new ElemeTokenRequest();
        request.setAppid(appid);
        request.setTime(System.currentTimeMillis() / 1000);
        request.setUserId(userId);
        request.setRefresh(0);
        ElemeTokenResponse response = elemeClient.execute(request);
        token = response.getToken();
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 授权页获取凭证接口(AuthToken)
     */
    @Test
    public void getAuthToken() throws ElemeApiException {
        ElemeAuthTokenRequest request = new ElemeAuthTokenRequest();
        request.setAppid(appid);
        request.setTime(System.currentTimeMillis() / 1000);
        ElemeAuthTokenResponse response = elemeClient.execute(request);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 查询余额接口
     */
    @Test
    public void getAmount() throws ElemeApiException {
        ElemeQueryAmountRequest request = new ElemeQueryAmountRequest();
        request.setUserId(userId);
        ElemeQueryAmountResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 用户上传图片接口
     */
    @Test
    public void uploadFile() throws ElemeApiException {
        String fileName = "/Users/coderma/Downloads/yyzz.png";
        String fileType = FileUtil.getType(new File(fileName));
        byte[] bytes = FileUtil.readBytes(fileName);
        String fileBinary = new BASE64Encoder().encode(bytes);

        ElemeUploadFileRequest request = new ElemeUploadFileRequest();
        request.setFileType(fileType);
        request.setFileBinary(fileBinary);
        ElemeUploadFileResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 创建门店&新增门店接口
     */
    @Test
    public void createShop() throws ElemeApiException {

        ElemeUploadFileResponse ownerIdcard = JSON.parseObject("{\"hash\":\"xxx\",\"url\":\"xxx\"}", ElemeUploadFileResponse.class);

        ElemeCreateShopRequest request = new ElemeCreateShopRequest();
        request.setUserId(userId);
        request.setAppid(appid);
        request.setOutShopId(outStoreId);
        request.setShopName("小码烧烤");
        request.setShopPhone("181xxxxx367");
        request.setShopPoiAddress("杭州市西湖区丰盛九玺12撞21楼");
        request.setShopDetailAddress("杭州市西湖区丰盛九玺12撞21楼");//0000,
        request.setShopLongitude("120.068390");
        request.setShopLatitude("30.328831");
        //105:夜宵烧烤
        request.setShopCategory("105");
        request.setShopOwnerName("张三");
        request.setShopOwnerIdcard("50013445930629842003");
        request.setShopOwnerIdcardHash(ownerIdcard.getHash());
        request.setShopOwnerIdcardUrl(ownerIdcard.getUrl());
        request.setSuCode("43566");
        request.setBusinessLicenceHash(ownerIdcard.getHash());
        request.setBusinessLicenceUrl(ownerIdcard.getUrl());

        ElemeCreateShopResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 修改门店信息接口
     */
    @Test
    public void modifyShop() throws ElemeApiException {
        ElemeModifyShopRequest request = new ElemeModifyShopRequest();
        request.setUserId(userId);
        request.setAppid(appid);
        request.setShopId(elemeShopId);
        request.setShopName("小马烧烤2");
        request.setShopPhone("181xxxxx367");
        request.setShopPoiAddress("杭州市西湖区丰盛九玺12撞22楼");
        request.setShopDetailAddress("杭州市西湖区丰盛九玺12撞22楼");//0000,
        request.setShopLongitude("120.068390");
        request.setShopLatitude("30.328831");
        //105:夜宵烧烤
        request.setShopCategory("105");

        ElemeModifyShopResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 查询门店列表接口
     */
    @Test
    public void getShopList() throws ElemeApiException {
        ElemeQueryShopListRequest request = new ElemeQueryShopListRequest();
        request.setUserId(userId);
        request.setPageNum(1);
        request.setPageSize(20);
        ElemeQueryShopListResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 获取商户品类列表接口
     */
    @Test
    public void getShopCategoryList() throws ElemeApiException {
        ElemeShopCategoryListRequest request = new ElemeShopCategoryListRequest();
        ElemeShopCategoryListResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 查询门店信息接口
     */
    @Test
    public void getShopDetail() throws ElemeApiException {
        ElemeShopDetailRequest request = new ElemeShopDetailRequest();
        request.setUserId(userId);
        request.setShopId(elemeShopId);
        ElemeShopDetailResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 订单预取消接口
     */
    @Test
    public void getCancelPrice() throws ElemeApiException {
        ElemeQueryCancelPriceRequest request = new ElemeQueryCancelPriceRequest();
        request.setAppid(appid);
        request.setUserId(userId);
        request.setOrderNo("");
        request.setOrderStatus(null);
        request.setOrderReasonCode(null);
        ElemeQueryCancelPriceResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 获取取消原因列表接口（取消文案的返回）
     */
    @Test
    public void getOroderCannelMessage() throws ElemeApiException {
        ElemeQueryOrderCancelmessageRequest request = new ElemeQueryOrderCancelmessageRequest();
        request.setOrderNo("");
        request.setUserId(userId);
        ElemeQueryOrderCancelMessageResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 订单取消接口
     */
    @Test
    public void cannelOrder() throws ElemeApiException {
        ElemeCannelOrderRequest request = new ElemeCannelOrderRequest();
        request.setOrderNo("");
        request.setCancelCharge("100");
        request.setUserId(userId);
        request.setCancelReason("没有骑手接单");
        request.setOtherReason("自己输入的内容");
        request.setAppid(appid);
        ElemeCannelOrderResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 询标品接口
     */
    @Test
    public void getAvailableProductList() throws ElemeApiException {
        ElemeQueryAvailableProductListRequest request = new ElemeQueryAvailableProductListRequest();
        request.setShopId(elemeShopId);
        request.setCustomerLon("");
        request.setCustomerLat("");
        request.setExpectFetchTime("1586232000000");
        List<ElemeQueryAvailableProductListResponse> responses = elemeClient.executeArray(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(responses));
    }

    /**
     * 询价接口
     */
    @Test
    public void getOrderPrice() throws ElemeApiException {
        ElemeQueryOrderPriceRequest request = new ElemeQueryOrderPriceRequest();
        request.setUserId(userId);
        request.setShopId(elemeShopId);
        request.setCouponId("-1");
        request.setPkId(null);
        request.setProductId("");
        request.setCustomerLon("");
        request.setCustomerLat("");
        request.setExpectFetchTime("1586232000000");
        request.setGoodsWeight("");
        request.setGoodsPrice("");
        request.setOrderTip("");
        request.setOrderSource("");
        request.setInsureBusiOrderNo("");
        ElemeQueryOrderPriceResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 创建订单接口
     */
    @Test
    public void createOrder() throws ElemeApiException {
        ElemeCreateOrderRequest request = new ElemeCreateOrderRequest();
        request.setUserId(userId);
        request.setOutOrderNo("");
        request.setCouponId("-1");
        request.setShopId(elemeShopId);
        request.setCustomerTel("181xxxxx367");
        request.setCustomerAddr("浙江省杭州市西湖区惠仁家园10幢24室");
        request.setCustomerPoiAddr("浙江省杭州市西湖区惠仁家园10幢24室");
        request.setCustomerLongtitude("30.3306386600");
        request.setCustomerLatitude("120.0779914900");
        request.setCustomerName("马克思");
        request.setTotalPrice("100");
        request.setPayPrice("100");
        request.setOrderSource("0");
        request.setProductId("");
        request.setGoodsWeight("500");
        request.setOrderPriceDetailJson("");
        request.setOrderSourceId("");
        request.setOrderTip("");
        request.setExpectFetchTime("1586232000000");
        request.setSn("");
        request.setTIndexid("");
        request.setGoodsPrice("");
        request.setOrderRemark("速度快点");
        request.setInsureBusiOrderNo("");
        request.setNeedFetchCode("0");
        request.setPredictDuration(0);
        ElemeCreateOrderResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 获取货损险套餐列表接口
     */
    @Test
    public void getGoodsInsurancePackage() throws ElemeApiException {
        ElemeQueryGoodsInsurancePackageRequest request = new ElemeQueryGoodsInsurancePackageRequest();
        request.setUserId(userId);
        request.setAppid(appid);
        List<ElemeQueryGoodsInsurancePackageResponse> responseList = elemeClient.executeArray(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(responseList));
    }

    /**
     * 获取投保人信息接口
     */
    @Test
    public void getInsuredPersonInfo() throws ElemeApiException {
        //统一结算不能访问该接口获取身份信息
        ElemeQueryInsuredPersonInfoRequest request = new ElemeQueryInsuredPersonInfoRequest();
        request.setAppid(appid);
        request.setUserId(userId);
        ElemeQueryInsuredPersonInfoResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 核保接口
     */
    @Test
    public void preinsurance() throws ElemeApiException {
        ElemePreinsuranceRequest request = new ElemePreinsuranceRequest();
        request.setPersonName("马克思");
        request.setPersonIdcard("41161619100201153x");
        request.setPhone("181xxxxx367");
        request.setInsuredPlanId("");
        request.setExpectFetchTime("1586232000000");
        request.setGoodsWeight("1");
        request.setUserId(userId);
        request.setAppid(appid);
        ElemePreinsuranceResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 订单加调度费接口
     */
    @Test
    public void addTip() throws ElemeApiException {
        ElemeAddTipRequest request = new ElemeAddTipRequest();
        request.setAddTipPrice(100);
        request.setOrderNo("");
        request.setAppid(appid);
        request.setBusinessSn("");
        ElemeAddTipResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 查询订单详情接口
     */
    @Test
    public void getOrderDetail() throws ElemeApiException {
        ElemeQueryOrderDetailRequest request = new ElemeQueryOrderDetailRequest();
        request.setAppid(appid);
        request.setUserId(userId);
        request.setOrderNo("");
        ElemeQueryOrderDetailResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

    /**
     * 查询骑手信息接口
     */
    @Test
    public void getKnightInfo() throws ElemeApiException {
        ElemeQueryKnightInfoRequest request = new ElemeQueryKnightInfoRequest();
        request.setUserId(userId);
        request.setAppid(appid);
        request.setOrderNo("");
        ElemeQueryKnightInfoResponse response = elemeClient.execute(request, token, userId);
        System.out.println("response=" + JSON.toJSONString(response));
    }

}