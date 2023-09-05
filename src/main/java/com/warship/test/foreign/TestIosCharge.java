//package com.warship.foreign.test;
//
//import com.alibaba.fastjson2.JSONObject;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.HashMap;
//import java.util.Map;
//
//public class TestIosCharge {
//    @RequestMapping("/iosCharge")
//    @ResponseBody
//    public String iosCharge(HttpServletRequest req,
//                            HttpServletResponse resp){
//        try{
//            JSONObject json = new JSONObject();
//            String receiptData = req.getParameter("orderId");
//            //透传实际是客户端直接发送的roleId 因为IOS没有透传 故占用此字段
//            String throughCargo = req.getParameter("through_cargo");
//            json.put("receipt-data", receiptData);
//            Map<String, String> head = new HashMap<String, String>();
//            head.put("Content-Type", "text/json");
//            //获取充值地址
//            String applePayUrl = getApplePayURL(receiptData);
//            boolean isSandbox = applePayUrl.equals(IAP_SANDBOXURL);
//            //订单前缀
//            StringBuffer orderIdPrefix = new StringBuffer();
//            if(isSandbox){
//                BillingServiceFacade billingService = BillingServiceFacade.getBillingService();
//                boolean isOPenSandbox = billingService.isOpenAppleStoreSandbox();
//                if(!isOPenSandbox){
//                    log.error("ios apple store sandbox pay has closed");
//                    return toIosErrorJson("", ERROR_IOS_SANDBOX_CODE);
//                }
//            }else{
//                orderIdPrefix.append(IOS_PAY_REAL_PREFIX);
//            }
//            String httpResp = HttpUtil.doPost(applePayUrl, head, json.toString(), true);
//            if(httpResp == null){
//                return "FAIL";
//            }else{
//
//                JSONObject resultJson = new JSONObject(httpResp);
//                String status = resultJson.optString("status");
//                if(status.equals("0")){
//                    String receipt = resultJson.optString("receipt");
//                    //消息获取
//                    resultJson = null;
//                    resultJson = new JSONObject(receipt);
//                    //++ 新版改为bundle_id，并使用in_app 返回多个未完成订单信息
//                    String bid = resultJson.optString("bundle_id");
//                    String inAppStr = resultJson.optString("in_app");
//                    if(inAppStr == null){
//                        //如果in_app为空，代表实际返回结果与苹果官方文档不一致，怎么处理待定；
//                        log.error(String.format(
//                                "ChargeController iosChargeNew in_app error: , in_app in response is Null receipt:%s , role:%s" ,
//                                receipt,throughCargo));
//                        return "FAIL";
//                    }
//                    JSONArray array = JSONArray.fromObject(inAppStr);
//                    Iterator iterator = array.iterator();
//                    //返回结果容器
//                    Map<String,String> res = new HashMap<String,String>();
//                    while(iterator.hasNext()){
//                        JSONObject inAppObj = (JSONObject) iterator.next();
//                        String transaction_id = inAppObj.optString("transaction_id").trim();
//                        String product_id = inAppObj.optString("product_id").trim();
//                        String quantity = inAppObj.optString("quantity");
//                        String orderId = orderIdPrefix.append(transaction_id).toString();
//
//                        //----------------------------验证 检测数据是否正常--------------------------
//                        //验证是否是此款游戏
//                        String clientChannel = req.getParameter("clientChannel");
//                        String appleBid = getIosBid(clientChannel);
//                        if(!appleBid.equals(bid)){
//                            log.error(String.format(
//                                    "ChargeController apple bid error: transaction_id:%s, bid:%s (ios clientChannel:%s)",
//                                    transaction_id, bid, clientChannel));
//                            res.put(transaction_id,toIosSuccessJson(transaction_id, product_id, isSandbox));
//                            //return "FAIL";
//                        }
//                        try{
//                            String cancel = inAppObj.optString("cancellation_date");
//                            if(cancel != null && cancel.trim().length() > 0){
//                                String reason = inAppObj.optString("cancellation_reason");
//                                log.info(String.format(
//                                        "ios recharge role id is cancellation transaction_id: %s (ios clientChannel:%s) date:%s reason:%s",
//                                        orderId, clientChannel, cancel, reason));
//                                ////return "FAIL"; 目前不确定 先打印log
//                            }
//                        }catch(Exception e){
//                            log.error("ios apple ChargeController parse signedData contain cancellation_date error", e);
//                        }
//                        Map<String, String> params = new TreeMap<String, String>();
//                        //goodsId
//                        params.put("product_id", product_id);
//                        if(quantity != null){
//                            params.put("quantity", quantity);
//                        }
//                        if(isEmpty(throughCargo)){
//                            log.info(String.format("ios recharge role id is null transaction_id: %s (ios clientChannel:%s)",
//                                    orderId, clientChannel));
//                            res.put(transaction_id,"FAIL");
//                        }else if(throughCargo.length() > 12){
//                            if(Long.parseLong(throughCargo.substring(0, 12)) < 1){
//                                log.info(String.format(
//                                        "ios recharge role id is < 1 role id(throughCargo):%s, transaction_id:%s (ios clientChannel:%s)",
//                                        throughCargo, orderId, clientChannel));
//                                res.put(transaction_id,"FAIL");
//                            }
//                        }else if(Long.parseLong(throughCargo) < 1){
//                            log.info(String.format(
//                                    "ios recharge role id is < 1 role id(throughCargo):%s, transaction_id:%s (ios clientChannel:%s)",
//                                    throughCargo, orderId, clientChannel));
//                            res.put(transaction_id,"FAIL");
//                        }
//                        params.put("through_cargo", throughCargo);
//                        //orderId
//                        params.put("tid", orderId);
//                        //类型
//                        params.put("type", CHARGE_TYPE_APPLE);
//                        //userId
//                        String uid = req.getParameter("uid");
//                        if(uid == null){
//                            uid = "";
//                        }
//                        params.put("uid", uid);
//                        //$
//                        String rmoney = req.getParameter("rmoney");
//                        if(isEmpty(rmoney)){
//                            rmoney = "1.1";
//                        }
//                        params.put("rmoney", rmoney);
//                        //新增
//                        params.put("channel", getChannelType(clientChannel, OSType.IOS.getType()));
//                        params.put("os", String.valueOf(OSType.IOS.getType()));
//                        //帮助他人够买
//                        String helpRoleId = req.getParameter("helpRoleId");
//                        params.put("helpRoleId", helpRoleId == null ? "" : helpRoleId);
//                        String helpRoleName = req.getParameter("helpRoleName");
//                        params.put("helpRoleName", helpRoleName == null ? "" : helpRoleName);
//                        String isBroadcast = req.getParameter("isBroadcast");
//                        params.put("isBroadcast", isBroadcast == null ? "" : isBroadcast);
//
//                        //加密
//                        String tokenAll = tokenAll(params);
//                        params.put("token_all", tokenAll);
//                        //验证通过，发送给charge处理
//                        String result = HttpUtil.doPost(getChargeUrl(req), HttpUtil.param2Body(params));
//                        log.info(String.format("ChargeController apple store charge result %s (ios clientChannel:%s)", result,
//                                clientChannel));
//                        if(result.indexOf("no reason") > -1){
//                            if(isSandbox){
//                                log.info(String.format(
//                                        "apple sandbox pay success roleId: %s   transaction_id: %s   product_id: %s (ios clientChannel:%s)",
//                                        throughCargo, orderId, product_id, clientChannel));
//                            }
//                            //结果
//                            res.put(transaction_id,toIosSuccessJson(transaction_id, product_id, isSandbox));
//                        }else if(result.indexOf("repeat") > -1){
//                            log.info(
//                                    String.format("repeat ios charge transaction_id %s throughCargo %s (ios clientChannel:%s)",
//                                            orderId, throughCargo, clientChannel));
//                            //结果
//                            //return toIosSuccessJson(transaction_id, product_id, isSandbox);
//                            Map<String, Object> args = new HashMap<String, Object>();
//                            args.put("_validateCode", "-1");
//                            res.put(transaction_id,iosResultJson(transaction_id, product_id, isSandbox, args));
//                        }else if(result.indexOf("goods upper bound") > -1){
//                            log.info(String.format(
//                                    "goods upper bound ios charge transaction_id %s throughCargo %s (ios clientChannel:%s)",
//                                    orderId, throughCargo, clientChannel));
//                            //结果
//                            res.put(transaction_id,toIosSuccessJson(transaction_id, product_id, isSandbox));
//                        }else{
//                            res.put(transaction_id,"FAIL");
//                        }
//                    }
//                    JSONObject resJson = new JSONObject(res);
//                    return resJson.toString();
//                }else{
//                    return "FAIL";
//                }
//            }
//        }catch(Exception e){
//            log.error("ios apple ChargeController parse signedData error", e);
//            return "FAIL";
//        }
//}
