package com.redis.cache.test.serializer;

import com.alibaba.fastjson.JSON;
import com.redis.cache.test.serializer.mydto.OperationWaybillFST;
import com.redis.cache.test.serializer.serializer.FstSerializer;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.StopWatch;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Properties;

/**
 * Description: 测试序列化 .<br>
 *
 * @author Chris Cai
 * Created By 2019/8/20 下午4:16
 */
public class TestFinallyFSTSerizlizer {
    public static final String STRING_VALUE_TEST_MYTEST = "String:value:test:mytest:OperationWaybill:";
    private static Jedis jedis;
    private static RedisClient client;
    private static RedisStringCommands sync;

    //private static final String str = "{\"waybillId\":\"默认值\",\"waybillNo\":\"修改后的主表\",\"sourceZoneCode\":\"默认值\",\"destZoneCode\":\"默认值\",\"meterageWeightQty\":0,\"realWeightQty\":0,\"quantity\":0,\"consigneeEmpCode\":\"默认值\",\"consignedTm\":\"2020-03-24 20:10:20\",\"cargoTypeCode\":\"默认值\",\"limitTypeCode\":\"默认值\",\"distanceTypeCode\":\"默认值\",\"transportTypeCode\":\"默认值\",\"expressTypeCode\":\"默认值\",\"volume\":0,\"billLong\":0,\"billWidth\":0,\"billHigh\":0,\"versionNo\":0,\"lockVersionNo\":0,\"unitWeight\":\"默认值\",\"consValue\":0,\"consValueCurrencyCode\":\"默认值\",\"productCode\":\"默认值\",\"waybillRemark\":\"默认值\",\"orderNo\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"expectStartTm\":\"2020-03-24 20:10:20\",\"expectFinishTm\":\"2020-03-24 20:10:20\",\"provider\":\"默认值\",\"dynExpcDeliveryTm\":\"2020-03-24 20:10:20\",\"createTm\":\"2020-03-24 20:10:20\",\"extJson\":\"{\\\"isPilotWaybill\\\":false,\\\"orderCreateTrig\\\":-1,\\\"bar50SelfSendFlag\\\":-1,\\\"bar50Status\\\":-1,\\\"securityCodeTimestamp\\\":0,\\\"from50Weight\\\":false,\\\"from209Weight\\\":false,\\\"underCallOrder\\\":false,\\\"bar50FillVolume\\\":false,\\\"updatePayMethodBy50Bar\\\":false,\\\"bar50FillCustoms\\\":false,\\\"bar50FillAddresseeAddr\\\":false,\\\"ext046047UpdatedByOrder\\\":false}\",\"actionJson\":\"默认值\",\"updateSource\":\"默认值\",\"genOrderFlag\":false,\"operationWaybillAddrCons\":{\"contactsId\":\"123\",\"consignorCompName\":\"公司\",\"consignorAddr\":\"地址\",\"consignorPhone\":\"137112200230\",\"consignorContName\":\"签收人\",\"consignorMobile\":\"签收人电话\",\"addresseeCompName\":\"默认值\",\"addresseeAddr\":\"333\",\"addresseePhone\":\"33\",\"addresseeContName\":\"33\",\"addresseeMobile\":\"3\",\"consignorAddrNative\":\"签收公司\",\"addresseeAddrNative\":\"收件邮编\",\"waybillNo\":\"waybillNo312311231123\",\"orderNo\":\"orderNo123\",\"waybillId\":\"setWaybillId\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"{json}\",\"createTm\":\"2020-03-24 20:10:20\",\"consignorCityCode\":\"523900\",\"consignorDeptCode\":\"签收人公司代码\",\"consignorTransitCode\":\"11\",\"consignorTeamCode\":\"22\",\"addresseeCityCode\":\"33\",\"addresseeDeptCode\":\"44\",\"addresseeTransitCode\":\"55\",\"addresseeTeamCode\":\"66\",\"addresseeRedressAddr\":\"默认值\",\"routeLabel\":\"默认值\",\"pickUpCode\":\"默认值\",\"boxAddress\":\"默认值\",\"boxCode\":\"默认值\",\"longitude\":\"默认值\",\"latitude\":\"默认值\",\"englishConsignorAddr\":\"默认值\",\"englishConsignorCompName\":\"默认值\",\"englishConsignorContName\":\"默认值\",\"consignorAreaCode\":\"默认值\",\"consignorHqCode\":\"默认值\",\"addresseeAreaCode\":\"默认值\",\"addresseeHqCode\":\"默认值\",\"signModePiclAddr\":\"默认值\",\"senderProvince\":\"默认值\",\"senderCity\":\"默认值\",\"senderArea\":\"默认值\",\"senderAddr\":\"默认值\",\"receiverProvince\":\"默认值\",\"receiverCity\":\"默认值\",\"receiverArea\":\"默认值\",\"receiverAddr\":\"默认值\",\"consignorNationalPhoneCode\":\"默认值\",\"addresseeNationalPhoneCode\":\"默认值\"},\"operationWaybillAddrConsList\":[{\"contactsId\":\"123\",\"consignorCompName\":\"修改后的收寄件人\",\"consignorAddr\":\"地址\",\"consignorPhone\":\"137112200230\",\"consignorContName\":\"签收人\",\"consignorMobile\":\"签收人电话\",\"addresseeCompName\":\"默认值\",\"addresseeAddr\":\"333\",\"addresseePhone\":\"33\",\"addresseeContName\":\"33\",\"addresseeMobile\":\"3\",\"consignorAddrNative\":\"签收公司\",\"addresseeAddrNative\":\"收件邮编\",\"waybillNo\":\"waybillNo312311231123\",\"orderNo\":\"orderNo123\",\"waybillId\":\"setWaybillId\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"{json}\",\"createTm\":\"2020-03-24 20:10:20\",\"consignorCityCode\":\"523900\",\"consignorDeptCode\":\"签收人公司代码\",\"consignorTransitCode\":\"11\",\"consignorTeamCode\":\"22\",\"addresseeCityCode\":\"33\",\"addresseeDeptCode\":\"44\",\"addresseeTransitCode\":\"55\",\"addresseeTeamCode\":\"66\",\"addresseeRedressAddr\":\"默认值\",\"routeLabel\":\"默认值\",\"pickUpCode\":\"默认值\",\"boxAddress\":\"默认值\",\"boxCode\":\"默认值\",\"longitude\":\"默认值\",\"latitude\":\"默认值\",\"englishConsignorAddr\":\"默认值\",\"englishConsignorCompName\":\"默认值\",\"englishConsignorContName\":\"默认值\",\"consignorAreaCode\":\"默认值\",\"consignorHqCode\":\"默认值\",\"addresseeAreaCode\":\"默认值\",\"addresseeHqCode\":\"默认值\",\"signModePiclAddr\":\"默认值\",\"senderProvince\":\"默认值\",\"senderCity\":\"默认值\",\"senderArea\":\"默认值\",\"senderAddr\":\"默认值\",\"receiverProvince\":\"默认值\",\"receiverCity\":\"默认值\",\"receiverArea\":\"默认值\",\"receiverAddr\":\"默认值\",\"consignorNationalPhoneCode\":\"默认值\",\"addresseeNationalPhoneCode\":\"默认值\"},{\"contactsId\":\"123\",\"consignorCompName\":\"公司\",\"consignorAddr\":\"地址\",\"consignorPhone\":\"137112200230\",\"consignorContName\":\"签收人\",\"consignorMobile\":\"签收人电话\",\"addresseeCompName\":\"默认值\",\"addresseeAddr\":\"333\",\"addresseePhone\":\"33\",\"addresseeContName\":\"33\",\"addresseeMobile\":\"3\",\"consignorAddrNative\":\"签收公司\",\"addresseeAddrNative\":\"收件邮编\",\"waybillNo\":\"waybillNo312311231123\",\"orderNo\":\"orderNo123\",\"waybillId\":\"setWaybillId\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"{json}\",\"createTm\":\"2020-03-24 20:10:20\",\"consignorCityCode\":\"523900\",\"consignorDeptCode\":\"签收人公司代码\",\"consignorTransitCode\":\"11\",\"consignorTeamCode\":\"22\",\"addresseeCityCode\":\"33\",\"addresseeDeptCode\":\"44\",\"addresseeTransitCode\":\"55\",\"addresseeTeamCode\":\"66\",\"addresseeRedressAddr\":\"默认值\",\"routeLabel\":\"默认值\",\"pickUpCode\":\"默认值\",\"boxAddress\":\"默认值\",\"boxCode\":\"默认值\",\"longitude\":\"默认值\",\"latitude\":\"默认值\",\"englishConsignorAddr\":\"默认值\",\"englishConsignorCompName\":\"默认值\",\"englishConsignorContName\":\"默认值\",\"consignorAreaCode\":\"默认值\",\"consignorHqCode\":\"默认值\",\"addresseeAreaCode\":\"默认值\",\"addresseeHqCode\":\"默认值\",\"signModePiclAddr\":\"默认值\",\"senderProvince\":\"默认值\",\"senderCity\":\"默认值\",\"senderArea\":\"默认值\",\"senderAddr\":\"默认值\",\"receiverProvince\":\"默认值\",\"receiverCity\":\"默认值\",\"receiverArea\":\"默认值\",\"receiverAddr\":\"默认值\",\"consignorNationalPhoneCode\":\"默认值\",\"addresseeNationalPhoneCode\":\"默认值\"}],\"operationWaybillFeeList\":[{\"feeId\":\"默认值\",\"feeTypeCode\":\"修改后的费用9哦那个\",\"feeAmt\":0,\"gatherZoneCode\":\"默认值\",\"paymentTypeCode\":\"默认值\",\"settlementTypeCode\":\"默认值\",\"paymentChangeTypeCode\":\"默认值\",\"customerAcctCode\":\"默认值\",\"currencyCode\":\"默认值\",\"serviceId\":\"默认值\",\"gatherEmpCode\":\"默认值\",\"bizOwnerZoneCode\":\"默认值\",\"sourceCodeFeeAmt\":0,\"exchangeRate\":0,\"destCurrencyCode\":\"默认值\",\"feeAmtInd\":0,\"feeIndType\":\"默认值\",\"valutionAcctCode\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"ticketOffsetAmt\":0,\"ticketType\":\"默认值\",\"ticketKind\":\"默认值\",\"ticketPurpose\":\"默认值\",\"isOnlineDeduct\":\"默认值\",\"isLaterPay\":\"默认值\"},{\"feeId\":\"默认值\",\"feeTypeCode\":\"默认值\",\"feeAmt\":0,\"gatherZoneCode\":\"默认值\",\"paymentTypeCode\":\"默认值\",\"settlementTypeCode\":\"默认值\",\"paymentChangeTypeCode\":\"默认值\",\"customerAcctCode\":\"默认值\",\"currencyCode\":\"默认值\",\"serviceId\":\"默认值\",\"gatherEmpCode\":\"默认值\",\"bizOwnerZoneCode\":\"默认值\",\"sourceCodeFeeAmt\":0,\"exchangeRate\":0,\"destCurrencyCode\":\"默认值\",\"feeAmtInd\":0,\"feeIndType\":\"默认值\",\"valutionAcctCode\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"ticketOffsetAmt\":0,\"ticketType\":\"默认值\",\"ticketKind\":\"默认值\",\"ticketPurpose\":\"默认值\",\"isOnlineDeduct\":\"默认值\",\"isLaterPay\":\"默认值\"}],\"operationWaybillAdditionList\":[{\"additionalId\":\"默认值\",\"additionalKey\":\"默认值\",\"additionalValues\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"},{\"additionalId\":\"默认值\",\"additionalKey\":\"默认值\",\"additionalValues\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"}],\"operationWaybillCustoms\":{\"exportId\":\"默认值\",\"customsBatchs\":\"默认值\",\"customsTypeCode\":\"默认值\",\"preCustomsDt\":\"2020-03-24 20:10:20\",\"sourcearea\":\"默认值\",\"consignorPostalCode\":\"默认值\",\"addresseePostalCode\":\"默认值\",\"countryCode\":\"默认值\",\"consignorTaxNo\":\"默认值\",\"unifiedCode\":\"默认值\",\"twinvoiceTypeCode\":\"默认值\",\"consultCode\":\"默认值\",\"tradeCondtion\":\"默认值\",\"isUseUpstreamInvoice\":false,\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"},\"operationWaybillCustomsList\":[{\"exportId\":\"默认值\",\"customsBatchs\":\"修改后的报关\",\"customsTypeCode\":\"默认值\",\"preCustomsDt\":\"2020-03-24 20:10:20\",\"sourcearea\":\"默认值\",\"consignorPostalCode\":\"默认值\",\"addresseePostalCode\":\"默认值\",\"countryCode\":\"默认值\",\"consignorTaxNo\":\"默认值\",\"unifiedCode\":\"默认值\",\"twinvoiceTypeCode\":\"默认值\",\"consultCode\":\"默认值\",\"tradeCondtion\":\"默认值\",\"isUseUpstreamInvoice\":false,\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"},{\"exportId\":\"默认值\",\"customsBatchs\":\"默认值\",\"customsTypeCode\":\"默认值\",\"preCustomsDt\":\"2020-03-24 20:10:20\",\"sourcearea\":\"默认值\",\"consignorPostalCode\":\"默认值\",\"addresseePostalCode\":\"默认值\",\"countryCode\":\"默认值\",\"consignorTaxNo\":\"默认值\",\"unifiedCode\":\"默认值\",\"twinvoiceTypeCode\":\"默认值\",\"consultCode\":\"默认值\",\"tradeCondtion\":\"默认值\",\"isUseUpstreamInvoice\":false,\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"}],\"operationWaybillServiceList\":[{\"serviceId\":\"默认值\",\"serviceProdCode\":\"修改后的增值服务\",\"attribute1\":\"默认值\",\"attribute2\":\"默认值\",\"attribute3\":\"默认值\",\"attribute4\":\"默认值\",\"attribute5\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"},{\"serviceId\":\"默认值\",\"serviceProdCode\":\"默认值\",\"attribute1\":\"默认值\",\"attribute2\":\"默认值\",\"attribute3\":\"默认值\",\"attribute4\":\"默认值\",\"attribute5\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"}],\"operationWaybillPackageList\":[{\"packageId\":\"默认值\",\"packageNo\":\"修改后的包裹\",\"packageLong\":0,\"packageWidth\":0,\"packageHigh\":0,\"packageVolume\":0,\"packageUnitWeight\":\"默认值\",\"packageWeight\":0,\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"operationWaybillConsignList\":[{\"consId\":\"默认值\",\"consName\":\"默认值\",\"consQty\":\"默认值\",\"weightQty\":0,\"consValue\":0,\"qtyUnit\":\"默认值\",\"productRecordNo\":\"默认值\",\"packageId\":\"默认值\",\"packageNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"hsCode\":\"默认值\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"englishConsName\":\"默认值\",\"englishQtyUnit\":\"默认值\",\"goodsCode\":\"默认值\",\"brand\":\"默认值\",\"specifications\":\"默认值\",\"productCustomsNo\":\"默认值\"},{\"consId\":\"默认值\",\"consName\":\"默认值\",\"consQty\":\"默认值\",\"weightQty\":0,\"consValue\":0,\"qtyUnit\":\"默认值\",\"productRecordNo\":\"默认值\",\"packageId\":\"默认值\",\"packageNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"hsCode\":\"默认值\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"englishConsName\":\"默认值\",\"englishQtyUnit\":\"默认值\",\"goodsCode\":\"默认值\",\"brand\":\"默认值\",\"specifications\":\"默认值\",\"productCustomsNo\":\"默认值\"}],\"boxNo\":\"默认值\"},{\"packageId\":\"默认值\",\"packageNo\":\"默认值\",\"packageLong\":0,\"packageWidth\":0,\"packageHigh\":0,\"packageVolume\":0,\"packageUnitWeight\":\"默认值\",\"packageWeight\":0,\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"operationWaybillConsignList\":[{\"consId\":\"默认值\",\"consName\":\"默认值\",\"consQty\":\"默认值\",\"weightQty\":0,\"consValue\":0,\"qtyUnit\":\"默认值\",\"productRecordNo\":\"默认值\",\"packageId\":\"默认值\",\"packageNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"hsCode\":\"默认值\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"englishConsName\":\"默认值\",\"englishQtyUnit\":\"默认值\",\"goodsCode\":\"默认值\",\"brand\":\"默认值\",\"specifications\":\"默认值\",\"productCustomsNo\":\"默认值\"},{\"consId\":\"默认值\",\"consName\":\"默认值\",\"consQty\":\"默认值\",\"weightQty\":0,\"consValue\":0,\"qtyUnit\":\"默认值\",\"productRecordNo\":\"默认值\",\"packageId\":\"默认值\",\"packageNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"hsCode\":\"默认值\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"englishConsName\":\"默认值\",\"englishQtyUnit\":\"默认值\",\"goodsCode\":\"默认值\",\"brand\":\"默认值\",\"specifications\":\"默认值\",\"productCustomsNo\":\"默认值\"}],\"boxNo\":\"默认值\"}],\"operationTaxbillInfoList\":[],\"deliverEmpCode\":\"默认值\",\"subscriberName\":\"默认值\",\"signinTm\":\"2020-03-24 20:10:20\",\"clientCode\":\"默认值\",\"currentSource\":\"默认值\",\"deliveredType\":\"默认值\",\"barOpCode\":\"默认值\",\"inputerEmpCode\":\"默认值\"}";
    private static final String str = "{\n" +
            "\t\"waybillId\": \"788801605540\",\n" +
            "\t\"newFeild\": \"788801605540\",\n" +
            "\t\"waybillNo\": \"788801605540\",\n" +
            "\t\"sourceZoneCode\": \"021VC\",\n" +
            "\t\"destZoneCode\": \"755\",\n" +
            "\t\"meterageWeightQty\": 1.0,\n" +
            "\t\"realWeightQty\": 1.0,\n" +
            "\t\"quantity\": 1.0,\n" +
            "\t\"consigneeEmpCode\": \"000212\",\n" +
            "\t\"consignedTm\": \"2018-03-26 12:21:28\",\n" +
            "\t\"cargoTypeCode\": \"SP615\",\n" +
            "\t\"limitTypeCode\": \"T4\",\n" +
            "\t\"expressTypeCode\": \"B1\",\n" +
            "\t\"versionNo\": 1,\n" +
            "\t\"lockVersionNo\": 1,\n" +
            "\t\"unitWeight\": \"kg\",\n" +
            "\t\"createTm\": \"2018-03-26 12:22:29\",\n" +
            "\t\"genOrderFlag\": false,\n" +
            "\t\"operationWaybillAddrCons\": {\n" +
            "\t\t\"contactsId\": \"788801605540\",\n" +
            "\t\t\"consignorCompName\": \"招商信诺人寿保险深圳分公司\",\n" +
            "\t\t\"consignorAddr\": \"广东省深圳市南山区南山软件园1栋B座\",\n" +
            "\t\t\"consignorPhone\": \"18682311660\",\n" +
            "\t\t\"consignorContName\": \"william\",\n" +
            "\t\t\"consignorMobile\": \"18682311660\",\n" +
            "\t\t\"addresseeCompName\": \"个人\",\n" +
            "\t\t\"addresseeAddr\": \"广东省深圳市软件产业基地\",\n" +
            "\t\t\"addresseePhone\": \"17328360123\",\n" +
            "\t\t\"addresseeContName\": \"张三\",\n" +
            "\t\t\"addresseeMobile\": \"17328360123\",\n" +
            "\t\t\"waybillNo\": \"788801605540\",\n" +
            "\t\t\"waybillId\": \"788801605540\",\n" +
            "\t\t\"createTm\": \"2018-03-26 12:22:29\",\n" +
            "\t\t\"consignorDeptCode\": \"021VC\"\n" +
            "\t},\n" +
            "\t\"operationWaybillAddrConsList\": [{\n" +
            "\t\t\"contactsId\": \"788801605540\",\n" +
            "\t\t\"consignorCompName\": \"招商信诺人寿保险深圳分公司\",\n" +
            "\t\t\"consignorAddr\": \"广东省深圳市南山区南山软件园1栋B座\",\n" +
            "\t\t\"consignorPhone\": \"18682311660\",\n" +
            "\t\t\"consignorContName\": \"william\",\n" +
            "\t\t\"consignorMobile\": \"18682311660\",\n" +
            "\t\t\"addresseeCompName\": \"个人\",\n" +
            "\t\t\"addresseeAddr\": \"广东省深圳市软件产业基地\",\n" +
            "\t\t\"addresseePhone\": \"17328360123\",\n" +
            "\t\t\"addresseeContName\": \"张三\",\n" +
            "\t\t\"addresseeMobile\": \"17328360123\",\n" +
            "\t\t\"waybillNo\": \"788801605540\",\n" +
            "\t\t\"waybillId\": \"788801605540\",\n" +
            "\t\t\"createTm\": \"2018-03-26 12:22:29\",\n" +
            "\t\t\"consignorDeptCode\": \"021VC\"\n" +
            "\t}],\n" +
            "\t\"operationWaybillMarkList\": [],\n" +
            "\t\"operationWaybillFeeList\": [{\n" +
            "\t\t\"feeTypeCode\": \"1\",\n" +
            "\t\t\"feeAmt\": 20.0,\n" +
            "\t\t\"paymentTypeCode\": \"1\",\n" +
            "\t\t\"settlementTypeCode\": \"2\",\n" +
            "\t\t\"paymentChangeTypeCode\": \"0\",\n" +
            "\t\t\"gatherEmpCode\": \"000212\",\n" +
            "\t\t\"bizOwnerZoneCode\": \"021VC\",\n" +
            "\t\t\"waybillNo\": \"788801605540\",\n" +
            "\t\t\"waybillId\": \"788801605540\",\n" +
            "\t\t\"createTm\": \"2018-03-26 12:22:29\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"feeId\": \"7888016055403\",\n" +
            "\t\t\"feeTypeCode\": \"56\",\n" +
            "\t\t\"feeAmt\": 12.0,\n" +
            "\t\t\"paymentTypeCode\": \"1\",\n" +
            "\t\t\"settlementTypeCode\": \"2\",\n" +
            "\t\t\"paymentChangeTypeCode\": \"0\",\n" +
            "\t\t\"serviceId\": \"7888016055403\",\n" +
            "\t\t\"gatherEmpCode\": \"000212\",\n" +
            "\t\t\"bizOwnerZoneCode\": \"021VC\",\n" +
            "\t\t\"waybillNo\": \"788801605540\",\n" +
            "\t\t\"waybillId\": \"788801605540\",\n" +
            "\t\t\"createTm\": \"2018-03-26 12:22:29\"\n" +
            "\t}],\n" +
            "\t\"operationWaybillAdditionList\": [{\n" +
            "\t\t\"additionalId\": \"7888016055401\",\n" +
            "\t\t\"additionalKey\": \"SIGNED_BACK_WAYBILL_NO\",\n" +
            "\t\t\"additionalValues\": \"123000066675\",\n" +
            "\t\t\"waybillNo\": \"788801605540\",\n" +
            "\t\t\"waybillId\": \"788801605540\",\n" +
            "\t\t\"createTm\": \"2018-03-26 12:22:29\"\n" +
            "\t}],\n" +
            "\t\"operationWaybillServiceList\": [{\n" +
            "\t\t\"serviceId\": \"7888016055403\",\n" +
            "\t\t\"serviceProdCode\": \"IN56\",\n" +
            "\t\t\"attribute1\": \"12.00\",\n" +
            "\t\t\"waybillNo\": \"788801605540\",\n" +
            "\t\t\"waybillId\": \"788801605540\",\n" +
            "\t\t\"createTm\": \"2018-03-26 12:22:29\"\n" +
            "\t}],\n" +
            "\t\"operationWaybillPackageList\": [{\n" +
            "\t\t\"packageId\": \"788801605540\",\n" +
            "\t\t\"packageNo\": \"788801605540\",\n" +
            "\t\t\"waybillNo\": \"788801605540\",\n" +
            "\t\t\"waybillId\": \"788801605540\",\n" +
            "\t\t\"createTm\": \"2018-03-26 12:22:29\",\n" +
            "\t\t\"operationWaybillConsignList\": [{\n" +
            "\t\t\t\"consId\": \"788801605540\",\n" +
            "\t\t\t\"consName\": \"人寿险保单:0000112018025;\",\n" +
            "\t\t\t\"consQty\": \"1\",\n" +
            "\t\t\t\"qtyUnit\": \"份\",\n" +
            "\t\t\t\"packageId\": \"788801605540\",\n" +
            "\t\t\t\"packageNo\": \"788801605540\",\n" +
            "\t\t\t\"waybillId\": \"788801605540\",\n" +
            "\t\t\t\"createTm\": \"2018-03-26 12:22:29\"\n" +
            "\t\t}]\n" +
            "\t}],\n" +
            "\t\"clientCode\": \"colp-qy\"\n" +
            "}";
    private static final int SUM = 10000;
    private static RedisSerializer fstSerializer = new FstSerializer(OperationWaybillFST.class);

    //static {
    //    //连接redis服务器(在这里是连接本地的)
    //    jedis = new Jedis("127.0.0.1", 16379);
    //    //权限认证
    //    jedis.auth("123456");
    //    System.out.println("连接服务成功");
    //}
    public static void main(String[] args) throws IOException {
        init();

        OperationWaybillFST operationWaybillFST = JSON.parseObject(str, OperationWaybillFST.class);

        System.out.println("JDK,FST,Kryo对比测试：");
        //System.out.println("========空redis数据库的情况Start==========");
        emptyRedis2();
        System.out.println("========测试前==========");
        printRedisMemory();
        System.out.println("==================");


        //sourceJSON(operationWaybillFST);
        //printRedisMemory();
        //emptyRedis2();

        testFstWrite(operationWaybillFST);
        testFstRead();
        printRedisMemory();

    }



    private static void printRedisMemory() throws IOException {
        String s = jedis.info("memory");
        Properties props = new Properties();
        props.load(new StringReader(s));
        Object used_memory_human = props.get("used_memory_human");
        System.out.println("在Redis中占用内存: "+ used_memory_human);
        System.out.println("================= ");
        System.out.println("================= ");
        System.out.println("================= ");
        /* Props from documentation:
            used_memory:193581208
            used_memory_human:184.61M
            used_memory_rss:207888384
            used_memory_rss_human:198.26M
            used_memory_peak:199361424
            used_memory_peak_human:190.13M
            used_memory_peak_perc:97.10%
            used_memory_overhead:60022312
            used_memory_startup:510704
            used_memory_dataset:133558896
            used_memory_dataset_perc:69.18%
            allocator_allocated:193574472
            allocator_active:193900544
            allocator_resident:206139392
            total_system_memory:1044770816
            total_system_memory_human:996.37M
            used_memory_lua:37888
            used_memory_lua_human:37.00K
            maxmemory:0
            maxmemory_human:0B
            maxmemory_policy:noeviction
            allocator_frag_ratio:1.00
            allocator_frag_bytes:326072
            allocator_rss_ratio:1.06
            allocator_rss_bytes:12238848
            rss_overhead_ratio:1.01
            rss_overhead_bytes:1748992
            mem_fragmentation_ratio:1.07
            mem_fragmentation_bytes:14390192
            mem_allocator:jemalloc-4.0.3
            active_defrag_running:0
            lazyfree_pending_objects:0
            */
    }

    private static void sourceJSON(OperationWaybillFST operationWaybill) {

        long size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] bytes = JSON.toJSONString(operationWaybill).getBytes();
            size += bytes.length;
            jedis.set(String.valueOf(i).getBytes(), bytes);
        }
        stopWatch.stop();
        System.out.println(String.format("原生JSON方案[序列化+保存 %s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), BigDecimal.valueOf(size).divide(BigDecimal.valueOf(1024)).divide(BigDecimal.valueOf(1024))));

        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            OperationWaybillFST o = JSON.parseObject(jedis.get(String.valueOf(i).getBytes()), OperationWaybillFST.class);
        }
        stopWatch.stop();
        System.out.println(String.format("原生JSON方案[查询+反序列化 %s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), BigDecimal.valueOf(size).divide(BigDecimal.valueOf(1024)).divide(BigDecimal.valueOf(1024))));
    }



    private static void emptyRedis2() {

        jedis.keys("*").forEach(obj->{
            jedis.del(obj);
        });
        //for (int i = 0; i < SUM; i++) {
        //
        //    jedis.del(STRING_VALUE_TEST_MYTEST +i);
        //    jedis.del(STRING_VALUE_TEST_MYTEST_DOT +i);
        //    jedis.del(STRING_VALUE_TEST_MYTEST_DOT +i);
        //}
        System.out.println();
    }

    private static void emptyRedis() {

        for (int i = 0; i < SUM; i++) {
            jedis.del(String.valueOf(i).getBytes());
        }
    }

    private static void init() {
        client = RedisClient.create("redis://123456@127.0.0.1:16379");
        StatefulRedisConnection<String, String> connection = client.connect();
        sync = connection.sync();


        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("127.0.0.1", 16379);
        //权限认证
        jedis.auth("123456");

        System.out.println("连接服务成功");
    }

    private static void testFstWrite(OperationWaybillFST operationWaybill) {
        long size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] jdkserialize = fstSerializer.serialize(operationWaybill);
            jedis.set(String.valueOf(i).getBytes(), jdkserialize);
            size += jdkserialize.length;
        }
        stopWatch.stop();
        System.out.println(String.format("FST序列化方案[序列化 & 保存 %s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), BigDecimal.valueOf(size).divide(BigDecimal.valueOf(1024)).divide(BigDecimal.valueOf(1024))));
         }

    private static void testFstRead() {
        long size = 0;
        StopWatch stopWatch = new StopWatch();
        //======查询=======
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] bytes = jedis.get(String.valueOf(i).getBytes());
            size+= bytes.length;
            OperationWaybillFST operationWaybill1 = (OperationWaybillFST) fstSerializer.deserialize(bytes);
        }
        stopWatch.stop();
        System.out.println(String.format("FST序列化方案[查询 & 反序列化%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), BigDecimal.valueOf(size).divide(BigDecimal.valueOf(1024)).divide(BigDecimal.valueOf(1024))));
    }



}
