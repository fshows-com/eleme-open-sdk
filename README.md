# Eleme-open-sdk

饿了么蜂鸟跑腿 JAVA SDK，通过蜂鸟跑腿官方API进行封装。[官网API文档](http://isv-pt.alta.elenet.me/docs#/)

## 目录

- [背景](#背景)
- [打包和安装](#打包和安装)
- [使用方式](#使用方式)
- [维护者](#维护者)
- [如何贡献](#如何贡献)
- [License](#license)

## 背景

TODO

## 打包和安装

### maven本地打包
```mvn clean install -Dmaven.test.skip=true```

### maven 中央仓库

```xml

<dependency>
  <groupId>com.fshows.sdk</groupId>
   <artifactId>eleme-open-sdk</artifactId>
   <version>1.0-SNAPSHOT</version>
</dependency>

```

## 使用方式

### 1. 初始化客户端
```java
ElemeClient elemeClient = new DefaultElemeClient(serverUrl,appid, secretKey);
```
### 2. 接口请求获取凭证接口(Token)
```java
ElemeTokenRequest request = new ElemeTokenRequest();
request.setAppid(appid);
request.setTime(System.currentTimeMillis() / 1000);
request.setUserId(userId);
request.setRefresh(0);
ElemeTokenResponse response = elemeClient.execute(request);
System.out.println("response=" + JSON.toJSONString(response));
```
### 3. 授权页获取凭证接口(AuthToken)
```java
ElemeAuthTokenRequest request = new ElemeAuthTokenRequest();
request.setAppid(appid);
request.setTime(System.currentTimeMillis() / 1000);
ElemeAuthTokenResponse response = elemeClient.execute(request);
System.out.println("response=" + JSON.toJSONString(response));
```
### 4. 查询余额接口
```java
ElemeQueryAmountRequest request = new ElemeQueryAmountRequest();
request.setUserId(userId);
ElemeQueryAmountResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 5. 用户上传图片接口
```java
String fileName = "/Users/coderma/Downloads/yyzz.png";
String fileType = FileUtil.getType(new File(fileName));
byte[] bytes = FileUtil.readBytes(fileName);
String fileBinary = new BASE64Encoder().encode(bytes);

ElemeUploadFileRequest request = new ElemeUploadFileRequest();
request.setFileType(fileType);
request.setFileBinary(fileBinary);
ElemeUploadFileResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 6. 创建门店&新增门店接口
```java
ElemeUploadFileResponse ownerIdcard = JSON.parseObject("{\"hash\":\"xxx\",\"url\":\"xxx\"}",ElemeUploadFileResponse.class);

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
```
### 7. 修改门店信息接口
```java
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
```
### 8. 查询门店列表接口
```java
ElemeQueryShopListRequest request = new ElemeQueryShopListRequest();
request.setUserId(userId);
request.setPageNum(1);
request.setPageSize(20);
ElemeQueryShopListResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 9. 获取商户品类列表接口
```java
ElemeShopCategoryListRequest request = new ElemeShopCategoryListRequest();
ElemeShopCategoryListResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 10. 查询门店信息接口
```java
ElemeShopDetailRequest request = new ElemeShopDetailRequest();
request.setUserId(userId);
request.setShopId(elemeShopId);
ElemeShopDetailResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 11. 订单预取消接口
```java
ElemeQueryCancelPriceRequest request = new ElemeQueryCancelPriceRequest();
request.setAppid(appid);
request.setUserId(userId);
request.setOrderNo("");
request.setOrderStatus(null);
request.setOrderReasonCode(null);
ElemeQueryCancelPriceResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 12. 获取取消原因列表接口（取消文案的返回）
```java
ElemeQueryOrderCancelmessageRequest request = new ElemeQueryOrderCancelmessageRequest();
request.setOrderNo("");
request.setUserId(userId);
ElemeQueryOrderCancelMessageResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 13. 订单取消接口
```java
ElemeCannelOrderRequest request = new ElemeCannelOrderRequest();
request.setOrderNo("");
request.setCancelCharge("100");
request.setUserId(userId);
request.setCancelReason("没有骑手接单");
request.setOtherReason("自己输入的内容");
request.setAppid(appid);
ElemeCannelOrderResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 14. 询标品接口
```java
ElemeQueryAvailableProductListRequest request = new ElemeQueryAvailableProductListRequest();
request.setShopId(elemeShopId);
request.setCustomerLon("");
request.setCustomerLat("");
request.setExpectFetchTime("1586232000000");
List<ElemeQueryAvailableProductListResponse> responses = elemeClient.executeArray(request, token, userId);
System.out.println("response=" + JSON.toJSONString(responses));
```
### 15. 询价接口
```java
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
```
### 16. 创建订单接口
```java
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
```
### 17. 获取货损险套餐列表接口
```java
ElemeQueryGoodsInsurancePackageRequest request = new ElemeQueryGoodsInsurancePackageRequest();
request.setUserId(userId);
request.setAppid(appid);
List<ElemeQueryGoodsInsurancePackageResponse> responseList = elemeClient.executeArray(request, token, userId);
System.out.println("response=" + JSON.toJSONString(responseList));
```
### 18. 获取投保人信息接口
```java
//统一结算不能访问该接口获取身份信息
ElemeQueryInsuredPersonInfoRequest request = new ElemeQueryInsuredPersonInfoRequest();
request.setAppid(appid);
request.setUserId(userId);
ElemeQueryInsuredPersonInfoResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 19. 核保接口
```java
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
```
### 20. 订单加调度费接口
```java
ElemeAddTipRequest request = new ElemeAddTipRequest();
request.setAddTipPrice(100);
request.setOrderNo("xxxx");
request.setAppid(appid);
request.setBusinessSn("");
ElemeAddTipResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 21. 查询订单详情接口
```java
ElemeQueryOrderDetailRequest request = new ElemeQueryOrderDetailRequest();
request.setAppid(appid);
request.setUserId(userId);
request.setOrderNo("");
ElemeQueryOrderDetailResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
### 22. 查询骑手信息接口
```java
ElemeQueryKnightInfoRequest request = new ElemeQueryKnightInfoRequest();
request.setUserId(userId);
request.setAppid(appid);
request.setOrderNo("");
ElemeQueryKnightInfoResponse response = elemeClient.execute(request, token, userId);
System.out.println("response=" + JSON.toJSONString(response));
```
## 维护者

[@Maweiming](https://github.com/Maweiming)

## 如何贡献

非常欢迎你的加入! [提一个Issue](https://github.com/fshows-com/eleme-open-sdk/issues/new) 或者提交一个 Pull Request.

### 贡献者
感谢以下参与项目的人：
+ [@Maweiming](https://github.com/Maweiming)
+ [@wjn161](https://github.com/wjn161)

## License

[Apache License 2.0 © fshows.com](https://github.com/fshows-com/eleme-open-sdk/blob/master/LICENSE)
