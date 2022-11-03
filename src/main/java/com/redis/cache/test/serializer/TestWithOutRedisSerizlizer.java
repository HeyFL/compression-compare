package com.redis.cache.test.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.redis.cache.test.serializer.mydto.OperationWaybill;
import com.redis.cache.test.serializer.serializer.*;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;
import net.bytebuddy.agent.ByteBuddyAgent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.StopWatch;
import org.xerial.snappy.Snappy;
import redis.clients.jedis.Jedis;
import sun.instrument.InstrumentationImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.lang.instrument.Instrumentation;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Description: 测试序列化 .<br>
 *
 * @author Chris Cai
 * Created By 2019/8/20 下午4:16
 */
public class TestWithOutRedisSerizlizer {
    static {

      ByteBuddyAgent.install();
    }
    static Instrumentation instrumentation = ByteBuddyAgent.getInstrumentation();
    public static Jedis jedis;
    public static RedisTemplate redisTemplate;
    public static RedisClient client;
    public static RedisStringCommands sync;

    //public static final String str = "{\"waybillId\":\"默认值\",\"waybillNo\":\"修改后的主表\",\"sourceZoneCode\":\"默认值\",\"destZoneCode\":\"默认值\",\"meterageWeightQty\":0,\"realWeightQty\":0,\"quantity\":0,\"consigneeEmpCode\":\"默认值\",\"consignedTm\":\"2020-03-24 20:10:20\",\"cargoTypeCode\":\"默认值\",\"limitTypeCode\":\"默认值\",\"distanceTypeCode\":\"默认值\",\"transportTypeCode\":\"默认值\",\"expressTypeCode\":\"默认值\",\"volume\":0,\"billLong\":0,\"billWidth\":0,\"billHigh\":0,\"versionNo\":0,\"lockVersionNo\":0,\"unitWeight\":\"默认值\",\"consValue\":0,\"consValueCurrencyCode\":\"默认值\",\"productCode\":\"默认值\",\"waybillRemark\":\"默认值\",\"orderNo\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"expectStartTm\":\"2020-03-24 20:10:20\",\"expectFinishTm\":\"2020-03-24 20:10:20\",\"provider\":\"默认值\",\"dynExpcDeliveryTm\":\"2020-03-24 20:10:20\",\"createTm\":\"2020-03-24 20:10:20\",\"extJson\":\"{\\\"isPilotWaybill\\\":false,\\\"orderCreateTrig\\\":-1,\\\"bar50SelfSendFlag\\\":-1,\\\"bar50Status\\\":-1,\\\"securityCodeTimestamp\\\":0,\\\"from50Weight\\\":false,\\\"from209Weight\\\":false,\\\"underCallOrder\\\":false,\\\"bar50FillVolume\\\":false,\\\"updatePayMethodBy50Bar\\\":false,\\\"bar50FillCustoms\\\":false,\\\"bar50FillAddresseeAddr\\\":false,\\\"ext046047UpdatedByOrder\\\":false}\",\"actionJson\":\"默认值\",\"updateSource\":\"默认值\",\"genOrderFlag\":false,\"operationWaybillAddrCons\":{\"contactsId\":\"123\",\"consignorCompName\":\"公司\",\"consignorAddr\":\"地址\",\"consignorPhone\":\"137112200230\",\"consignorContName\":\"签收人\",\"consignorMobile\":\"签收人电话\",\"addresseeCompName\":\"默认值\",\"addresseeAddr\":\"333\",\"addresseePhone\":\"33\",\"addresseeContName\":\"33\",\"addresseeMobile\":\"3\",\"consignorAddrNative\":\"签收公司\",\"addresseeAddrNative\":\"收件邮编\",\"waybillNo\":\"waybillNo312311231123\",\"orderNo\":\"orderNo123\",\"waybillId\":\"setWaybillId\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"{json}\",\"createTm\":\"2020-03-24 20:10:20\",\"consignorCityCode\":\"523900\",\"consignorDeptCode\":\"签收人公司代码\",\"consignorTransitCode\":\"11\",\"consignorTeamCode\":\"22\",\"addresseeCityCode\":\"33\",\"addresseeDeptCode\":\"44\",\"addresseeTransitCode\":\"55\",\"addresseeTeamCode\":\"66\",\"addresseeRedressAddr\":\"默认值\",\"routeLabel\":\"默认值\",\"pickUpCode\":\"默认值\",\"boxAddress\":\"默认值\",\"boxCode\":\"默认值\",\"longitude\":\"默认值\",\"latitude\":\"默认值\",\"englishConsignorAddr\":\"默认值\",\"englishConsignorCompName\":\"默认值\",\"englishConsignorContName\":\"默认值\",\"consignorAreaCode\":\"默认值\",\"consignorHqCode\":\"默认值\",\"addresseeAreaCode\":\"默认值\",\"addresseeHqCode\":\"默认值\",\"signModePiclAddr\":\"默认值\",\"senderProvince\":\"默认值\",\"senderCity\":\"默认值\",\"senderArea\":\"默认值\",\"senderAddr\":\"默认值\",\"receiverProvince\":\"默认值\",\"receiverCity\":\"默认值\",\"receiverArea\":\"默认值\",\"receiverAddr\":\"默认值\",\"consignorNationalPhoneCode\":\"默认值\",\"addresseeNationalPhoneCode\":\"默认值\"},\"operationWaybillAddrConsList\":[{\"contactsId\":\"123\",\"consignorCompName\":\"修改后的收寄件人\",\"consignorAddr\":\"地址\",\"consignorPhone\":\"137112200230\",\"consignorContName\":\"签收人\",\"consignorMobile\":\"签收人电话\",\"addresseeCompName\":\"默认值\",\"addresseeAddr\":\"333\",\"addresseePhone\":\"33\",\"addresseeContName\":\"33\",\"addresseeMobile\":\"3\",\"consignorAddrNative\":\"签收公司\",\"addresseeAddrNative\":\"收件邮编\",\"waybillNo\":\"waybillNo312311231123\",\"orderNo\":\"orderNo123\",\"waybillId\":\"setWaybillId\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"{json}\",\"createTm\":\"2020-03-24 20:10:20\",\"consignorCityCode\":\"523900\",\"consignorDeptCode\":\"签收人公司代码\",\"consignorTransitCode\":\"11\",\"consignorTeamCode\":\"22\",\"addresseeCityCode\":\"33\",\"addresseeDeptCode\":\"44\",\"addresseeTransitCode\":\"55\",\"addresseeTeamCode\":\"66\",\"addresseeRedressAddr\":\"默认值\",\"routeLabel\":\"默认值\",\"pickUpCode\":\"默认值\",\"boxAddress\":\"默认值\",\"boxCode\":\"默认值\",\"longitude\":\"默认值\",\"latitude\":\"默认值\",\"englishConsignorAddr\":\"默认值\",\"englishConsignorCompName\":\"默认值\",\"englishConsignorContName\":\"默认值\",\"consignorAreaCode\":\"默认值\",\"consignorHqCode\":\"默认值\",\"addresseeAreaCode\":\"默认值\",\"addresseeHqCode\":\"默认值\",\"signModePiclAddr\":\"默认值\",\"senderProvince\":\"默认值\",\"senderCity\":\"默认值\",\"senderArea\":\"默认值\",\"senderAddr\":\"默认值\",\"receiverProvince\":\"默认值\",\"receiverCity\":\"默认值\",\"receiverArea\":\"默认值\",\"receiverAddr\":\"默认值\",\"consignorNationalPhoneCode\":\"默认值\",\"addresseeNationalPhoneCode\":\"默认值\"},{\"contactsId\":\"123\",\"consignorCompName\":\"公司\",\"consignorAddr\":\"地址\",\"consignorPhone\":\"137112200230\",\"consignorContName\":\"签收人\",\"consignorMobile\":\"签收人电话\",\"addresseeCompName\":\"默认值\",\"addresseeAddr\":\"333\",\"addresseePhone\":\"33\",\"addresseeContName\":\"33\",\"addresseeMobile\":\"3\",\"consignorAddrNative\":\"签收公司\",\"addresseeAddrNative\":\"收件邮编\",\"waybillNo\":\"waybillNo312311231123\",\"orderNo\":\"orderNo123\",\"waybillId\":\"setWaybillId\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"{json}\",\"createTm\":\"2020-03-24 20:10:20\",\"consignorCityCode\":\"523900\",\"consignorDeptCode\":\"签收人公司代码\",\"consignorTransitCode\":\"11\",\"consignorTeamCode\":\"22\",\"addresseeCityCode\":\"33\",\"addresseeDeptCode\":\"44\",\"addresseeTransitCode\":\"55\",\"addresseeTeamCode\":\"66\",\"addresseeRedressAddr\":\"默认值\",\"routeLabel\":\"默认值\",\"pickUpCode\":\"默认值\",\"boxAddress\":\"默认值\",\"boxCode\":\"默认值\",\"longitude\":\"默认值\",\"latitude\":\"默认值\",\"englishConsignorAddr\":\"默认值\",\"englishConsignorCompName\":\"默认值\",\"englishConsignorContName\":\"默认值\",\"consignorAreaCode\":\"默认值\",\"consignorHqCode\":\"默认值\",\"addresseeAreaCode\":\"默认值\",\"addresseeHqCode\":\"默认值\",\"signModePiclAddr\":\"默认值\",\"senderProvince\":\"默认值\",\"senderCity\":\"默认值\",\"senderArea\":\"默认值\",\"senderAddr\":\"默认值\",\"receiverProvince\":\"默认值\",\"receiverCity\":\"默认值\",\"receiverArea\":\"默认值\",\"receiverAddr\":\"默认值\",\"consignorNationalPhoneCode\":\"默认值\",\"addresseeNationalPhoneCode\":\"默认值\"}],\"operationWaybillFeeList\":[{\"feeId\":\"默认值\",\"feeTypeCode\":\"修改后的费用9哦那个\",\"feeAmt\":0,\"gatherZoneCode\":\"默认值\",\"paymentTypeCode\":\"默认值\",\"settlementTypeCode\":\"默认值\",\"paymentChangeTypeCode\":\"默认值\",\"customerAcctCode\":\"默认值\",\"currencyCode\":\"默认值\",\"serviceId\":\"默认值\",\"gatherEmpCode\":\"默认值\",\"bizOwnerZoneCode\":\"默认值\",\"sourceCodeFeeAmt\":0,\"exchangeRate\":0,\"destCurrencyCode\":\"默认值\",\"feeAmtInd\":0,\"feeIndType\":\"默认值\",\"valutionAcctCode\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"ticketOffsetAmt\":0,\"ticketType\":\"默认值\",\"ticketKind\":\"默认值\",\"ticketPurpose\":\"默认值\",\"isOnlineDeduct\":\"默认值\",\"isLaterPay\":\"默认值\"},{\"feeId\":\"默认值\",\"feeTypeCode\":\"默认值\",\"feeAmt\":0,\"gatherZoneCode\":\"默认值\",\"paymentTypeCode\":\"默认值\",\"settlementTypeCode\":\"默认值\",\"paymentChangeTypeCode\":\"默认值\",\"customerAcctCode\":\"默认值\",\"currencyCode\":\"默认值\",\"serviceId\":\"默认值\",\"gatherEmpCode\":\"默认值\",\"bizOwnerZoneCode\":\"默认值\",\"sourceCodeFeeAmt\":0,\"exchangeRate\":0,\"destCurrencyCode\":\"默认值\",\"feeAmtInd\":0,\"feeIndType\":\"默认值\",\"valutionAcctCode\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"ticketOffsetAmt\":0,\"ticketType\":\"默认值\",\"ticketKind\":\"默认值\",\"ticketPurpose\":\"默认值\",\"isOnlineDeduct\":\"默认值\",\"isLaterPay\":\"默认值\"}],\"operationWaybillAdditionList\":[{\"additionalId\":\"默认值\",\"additionalKey\":\"默认值\",\"additionalValues\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"},{\"additionalId\":\"默认值\",\"additionalKey\":\"默认值\",\"additionalValues\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"}],\"operationWaybillCustoms\":{\"exportId\":\"默认值\",\"customsBatchs\":\"默认值\",\"customsTypeCode\":\"默认值\",\"preCustomsDt\":\"2020-03-24 20:10:20\",\"sourcearea\":\"默认值\",\"consignorPostalCode\":\"默认值\",\"addresseePostalCode\":\"默认值\",\"countryCode\":\"默认值\",\"consignorTaxNo\":\"默认值\",\"unifiedCode\":\"默认值\",\"twinvoiceTypeCode\":\"默认值\",\"consultCode\":\"默认值\",\"tradeCondtion\":\"默认值\",\"isUseUpstreamInvoice\":false,\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"},\"operationWaybillCustomsList\":[{\"exportId\":\"默认值\",\"customsBatchs\":\"修改后的报关\",\"customsTypeCode\":\"默认值\",\"preCustomsDt\":\"2020-03-24 20:10:20\",\"sourcearea\":\"默认值\",\"consignorPostalCode\":\"默认值\",\"addresseePostalCode\":\"默认值\",\"countryCode\":\"默认值\",\"consignorTaxNo\":\"默认值\",\"unifiedCode\":\"默认值\",\"twinvoiceTypeCode\":\"默认值\",\"consultCode\":\"默认值\",\"tradeCondtion\":\"默认值\",\"isUseUpstreamInvoice\":false,\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"},{\"exportId\":\"默认值\",\"customsBatchs\":\"默认值\",\"customsTypeCode\":\"默认值\",\"preCustomsDt\":\"2020-03-24 20:10:20\",\"sourcearea\":\"默认值\",\"consignorPostalCode\":\"默认值\",\"addresseePostalCode\":\"默认值\",\"countryCode\":\"默认值\",\"consignorTaxNo\":\"默认值\",\"unifiedCode\":\"默认值\",\"twinvoiceTypeCode\":\"默认值\",\"consultCode\":\"默认值\",\"tradeCondtion\":\"默认值\",\"isUseUpstreamInvoice\":false,\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"}],\"operationWaybillServiceList\":[{\"serviceId\":\"默认值\",\"serviceProdCode\":\"修改后的增值服务\",\"attribute1\":\"默认值\",\"attribute2\":\"默认值\",\"attribute3\":\"默认值\",\"attribute4\":\"默认值\",\"attribute5\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"},{\"serviceId\":\"默认值\",\"serviceProdCode\":\"默认值\",\"attribute1\":\"默认值\",\"attribute2\":\"默认值\",\"attribute3\":\"默认值\",\"attribute4\":\"默认值\",\"attribute5\":\"默认值\",\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\"}],\"operationWaybillPackageList\":[{\"packageId\":\"默认值\",\"packageNo\":\"修改后的包裹\",\"packageLong\":0,\"packageWidth\":0,\"packageHigh\":0,\"packageVolume\":0,\"packageUnitWeight\":\"默认值\",\"packageWeight\":0,\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"operationWaybillConsignList\":[{\"consId\":\"默认值\",\"consName\":\"默认值\",\"consQty\":\"默认值\",\"weightQty\":0,\"consValue\":0,\"qtyUnit\":\"默认值\",\"productRecordNo\":\"默认值\",\"packageId\":\"默认值\",\"packageNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"hsCode\":\"默认值\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"englishConsName\":\"默认值\",\"englishQtyUnit\":\"默认值\",\"goodsCode\":\"默认值\",\"brand\":\"默认值\",\"specifications\":\"默认值\",\"productCustomsNo\":\"默认值\"},{\"consId\":\"默认值\",\"consName\":\"默认值\",\"consQty\":\"默认值\",\"weightQty\":0,\"consValue\":0,\"qtyUnit\":\"默认值\",\"productRecordNo\":\"默认值\",\"packageId\":\"默认值\",\"packageNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"hsCode\":\"默认值\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"englishConsName\":\"默认值\",\"englishQtyUnit\":\"默认值\",\"goodsCode\":\"默认值\",\"brand\":\"默认值\",\"specifications\":\"默认值\",\"productCustomsNo\":\"默认值\"}],\"boxNo\":\"默认值\"},{\"packageId\":\"默认值\",\"packageNo\":\"默认值\",\"packageLong\":0,\"packageWidth\":0,\"packageHigh\":0,\"packageVolume\":0,\"packageUnitWeight\":\"默认值\",\"packageWeight\":0,\"waybillNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"operationWaybillConsignList\":[{\"consId\":\"默认值\",\"consName\":\"默认值\",\"consQty\":\"默认值\",\"weightQty\":0,\"consValue\":0,\"qtyUnit\":\"默认值\",\"productRecordNo\":\"默认值\",\"packageId\":\"默认值\",\"packageNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"hsCode\":\"默认值\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"englishConsName\":\"默认值\",\"englishQtyUnit\":\"默认值\",\"goodsCode\":\"默认值\",\"brand\":\"默认值\",\"specifications\":\"默认值\",\"productCustomsNo\":\"默认值\"},{\"consId\":\"默认值\",\"consName\":\"默认值\",\"consQty\":\"默认值\",\"weightQty\":0,\"consValue\":0,\"qtyUnit\":\"默认值\",\"productRecordNo\":\"默认值\",\"packageId\":\"默认值\",\"packageNo\":\"默认值\",\"orderNo\":\"默认值\",\"waybillId\":\"默认值\",\"updateTm\":\"2020-03-24 20:10:20\",\"hsCode\":\"默认值\",\"extJson\":\"默认值\",\"createTm\":\"2020-03-24 20:10:20\",\"englishConsName\":\"默认值\",\"englishQtyUnit\":\"默认值\",\"goodsCode\":\"默认值\",\"brand\":\"默认值\",\"specifications\":\"默认值\",\"productCustomsNo\":\"默认值\"}],\"boxNo\":\"默认值\"}],\"operationTaxbillInfoList\":[],\"deliverEmpCode\":\"默认值\",\"subscriberName\":\"默认值\",\"signinTm\":\"2020-03-24 20:10:20\",\"clientCode\":\"默认值\",\"currentSource\":\"默认值\",\"deliveredType\":\"默认值\",\"barOpCode\":\"默认值\",\"inputerEmpCode\":\"默认值\"}";
    public static final String str = "{\n" +
            "\t\"waybillId\": \"788801605540\",\n" +
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
    public static final int SUM = 100000;
    public static RedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
    public static RedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(OperationWaybill.class);
    public static RedisSerializer fstSerializer = new FstSerializer(OperationWaybill.class);
    public static RedisSerializer fstSerializerStr = new FstSerializer(String.class);
    public static RedisSerializer fstJsonSerializer = new FstJsonSerializer(String.class);
    public static RedisSerializer kryoSerializer = new KryoSerializer(OperationWaybill.class);
    public static RedisSerializer protostuffSerializer = new ProtostuffSerializer(OperationWaybill.class);
    public static LZ4Serializer lZ4Serializer = new LZ4Serializer(byte[].class);

    //static {
    //    //连接redis服务器(在这里是连接本地的)
    //    jedis = new Jedis("127.0.0.1", 16379);
    //    //权限认证
    //    jedis.auth("123456");
    //    System.out.println("连接服务成功");
    //}
    public static void main(String[] args) throws IOException, InterruptedException {
        //init();
        OperationWaybill operationWaybill = JSON.parseObject(str, OperationWaybill.class);
        //OperationWaybill operationWaybill = new OperationWaybill();

        System.out.println("JDK,FST,Kryo对比测试：");

        //Thread.sleep(2000);
        //sourceJSON(operationWaybill);
        //testJdk(operationWaybill);
        //testFastJson(operationWaybill);

        //testFst(operationWaybill);
        //testFstJSONStr(operationWaybill);
        //testFstJSonSerial(operationWaybill);
        //testProtostuff(operationWaybill);
        //testSnappy(operationWaybill);
        //List<OperationWaybill> operationWaybills = new LinkedList<>();
        //try {
        //    for (int i = 0; i < SUM; i++) {
        //        operationWaybills.add(operationWaybill.clone());
        //    }
        //Thread.sleep(100_000);
        //} catch (CloneNotSupportedException e) {
        //    throw new RuntimeException(e);
        //}
        getSizeOfCompressedObjectByJDK(operationWaybill);
        getSizeOfCompressedObjectBySnappy(operationWaybill);
        getSizeOfCompressedObjectByKyro(operationWaybill);
        getSizeOfCompressedObjectBySnappyAndKyro(operationWaybill);
        getSizeOfCompressedObjectByInstrumentation(operationWaybill);
        testSnappyUncompressWithKyro(operationWaybill);
        testSnappyUncompress(operationWaybill);
        //
        //
        //testKryo(operationWaybill);
        //printRedisMemory();
        //
        //
        //testLZ4(operationWaybill);
        //printRedisMemory();

//System.out.println("==================");
//System.out.println("==================");
//System.out.println("==================");
//        sourceJSON(operationWaybill);
//        testFst(operationWaybill);
//        testProtostuff(operationWaybill);
//        testSnappy(operationWaybill);
//        testKryo(operationWaybill);

    }

    //public static void premain(String agentArgs, Instrumentation inst) {
    //    OperationWaybill operationWaybill = JSON.parseObject(str, OperationWaybill.class);
    //    getSizeOfCompressedObjectByInstrumentation(operationWaybill,inst);
    //}



    public static void printRedisMemory() throws IOException {
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
    public static void testFstJSonSerial(OperationWaybill operationWaybill) {
        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] jdkserialize = fstJsonSerializer.serialize(operationWaybill);
            //String s = new String(jdkserialize);
            jedis.set(String.valueOf(i).getBytes(), jdkserialize);
            size += jdkserialize.length;

        }
        stopWatch.stop();
        System.out.println(String.format("FST原生JSON序列化方案(fstJsonSerializer)[序列化 & 保存%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));


        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] bytes = jedis.get(String.valueOf(i).getBytes());
            OperationWaybill operationWaybill1 = (OperationWaybill) fstJsonSerializer.deserialize(bytes);
        }

        stopWatch.stop();
        System.out.println(String.format("FST原生JSON序列化方案(fstJsonSerializer)[序列化 & 反序列化%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }

    public static void sourceJSON(OperationWaybill operationWaybill) {

        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            String json = JSON.toJSONString(operationWaybill);
            OperationWaybill o = JSON.parseObject(json, OperationWaybill.class);
        }
        stopWatch.stop();
        System.out.println(String.format("原生JSON方案[序列化+反序列化 %s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }


    public static void emptyRedis() {

        for (int i = 0; i < SUM; i++) {
            jedis.del(String.valueOf(i).getBytes());
        }
    }

    public static void init() {
        try {
            client = RedisClient.create("redis://123456@127.0.0.1:16379");
            StatefulRedisConnection<String, String> connection = client.connect();
            sync = connection.sync();


            //连接redis服务器(在这里是连接本地的)
            jedis = new Jedis("127.0.0.1", 16379);
            //权限认证
            jedis.auth("123456");

            System.out.println("连接服务成功");
        } catch (Exception e) {
            System.err.println("连接服务失败");
        }

    }

    public static void testJdk(OperationWaybill operationWaybill) {
        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] jdkserialize = jdkSerializationRedisSerializer.serialize(operationWaybill);
            jedis.set(String.valueOf(i).getBytes(), jdkserialize);
            size += jdkserialize.length;
            jedis.get(String.valueOf(i).getBytes());
            OperationWaybill operationWaybill1 = (OperationWaybill) jdkSerializationRedisSerializer.deserialize(jdkserialize);
        }
        stopWatch.stop();
        System.out.println(String.format("原生JDK序列化方案[序列化 & 反序列化%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }

    public static void testFastJson(OperationWaybill operationWaybill) {
        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] jdkserialize = fastJsonRedisSerializer.serialize(operationWaybill);
            jedis.set(String.valueOf(i).getBytes(), jdkserialize);
            size += jdkserialize.length;
            jedis.get(String.valueOf(i).getBytes());
            OperationWaybill operationWaybill1 = (OperationWaybill) fastJsonRedisSerializer.deserialize(jdkserialize);
        }
        stopWatch.stop();
        System.out.println(String.format("FastJson序列化方案[序列化 & 反序列化%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }

    public static void testFst(OperationWaybill operationWaybill) {
        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] jdkserialize = fstSerializer.serialize(operationWaybill);
            OperationWaybill operationWaybill1 = (OperationWaybill) fstSerializer.deserialize(jdkserialize);
        }
        stopWatch.stop();
        System.out.println(String.format("FST序列化方案[序列化 & 反序列化%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }

    public static void testLZ4(OperationWaybill operationWaybill) {
        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            String str = JSON.toJSONString(operationWaybill);

            Map<byte[],byte[]> jdkserialize = lZ4Serializer.serialize(str.getBytes());

            jedis.hset(String.valueOf(i).getBytes(), jdkserialize);

        }
        stopWatch.stop();



        System.out.println(String.format("LZ4序列化方案[toJSONString & 序列化 & 保存 %s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
        //======序列化=======
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            Map<byte[],byte[]> redisData = jedis.hgetAll(String.valueOf(i).getBytes());
            byte[] restored = (byte[]) lZ4Serializer.deserialize(redisData);
            OperationWaybill operationWaybill1 = JSON.parseObject(new String(restored), OperationWaybill.class);
        }
        stopWatch.stop();
        System.out.println(String.format("LZ4序列化方案[序列化 & 反序列化 & parseObject %s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }

    public static void testProtostuff(OperationWaybill operationWaybill) {
        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] jdkserialize = protostuffSerializer.serialize(operationWaybill);
            OperationWaybill operationWaybill1 = (OperationWaybill) protostuffSerializer.deserialize(jdkserialize);
        }

        stopWatch.stop();
        System.out.println(String.format("protostuff序列化方案[序列化 & 反序列化%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }
    public static void testSnappyWithJSONParse(OperationWaybill operationWaybill) throws IOException {
        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            String jsonStr = JSON.toJSONString(operationWaybill);
            byte[] jdkserialize = Snappy.compress(jsonStr.getBytes("UTF-8"));
            jedis.set(String.valueOf(i).getBytes(), jdkserialize);
            size += jdkserialize.length;
        }
        stopWatch.stop();
        System.out.println(String.format("Snappy压缩方案[序列化 & 反序列化 & toJsonString & parseObject %s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));


        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] bytes = jedis.get(String.valueOf(i).getBytes());
            byte[] uncompressed = Snappy.uncompress(bytes);
            OperationWaybill operationWaybill1 = JSON.parseObject(new String(uncompressed), OperationWaybill.class);

        }
        stopWatch.stop();
        System.out.println(String.format("Snappy压缩方案[序列化 & 反序列化 & toJsonString & parseObject %s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }
    public static void testSnappy(OperationWaybill operationWaybill) throws IOException {
        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            String jsonStr = JSON.toJSONString(operationWaybill);
            byte[] jdkserialize = Snappy.compress(jsonStr.getBytes("UTF-8"));
            OperationWaybill operationWaybill1 = JSON.parseObject(new String(Snappy.uncompress(jdkserialize), "UTF-8"), OperationWaybill.class);

        }
        stopWatch.stop();
        System.out.println(String.format("Snappy压缩方案[序列化 & 反序列化 + parseObject%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }
    public static void testSnappyUncompress(OperationWaybill operationWaybill) throws IOException {
        double size = 0;
        byte[] bytes = compressValue(operationWaybill);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            //size+=bytes.length;
            OperationWaybill operationWaybill1 = (OperationWaybill) deserialize(Snappy.uncompress(bytes));

        }
        stopWatch.stop();
        System.out.println(String.format("Snappy压缩方案[序列化 & 反序列化 + parseObject%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }

    private static BigDecimal byteToMb(Double size) {
        return BigDecimal.valueOf(size).divide(BigDecimal.valueOf(1024)).divide(BigDecimal.valueOf(1024));
    }

    private static byte[] compressValue(Object value) {
        byte[] valueCompressBytes;
        try {
            valueCompressBytes = Snappy.compress(getBytesFromObject((Serializable) value));
        } catch (Exception e) {
            System.out.println("!!! Fatal Error!!!  compressValue error"+e.getMessage());
            //任意一个对象序列化失败，都要阻塞服务启动
            throw new RuntimeException("compressValue error", e);
        }
        return valueCompressBytes;
    }

    //calculate the size of the object after compressed by jdk
    private static double getSizeOfCompressedObjectByJDK(Object value) {
        double size = 0;
        try {
            size = getBytesFromObject((Serializable) value).length*SUM;
        } catch (Exception e) {
            System.out.println("!!! Fatal Error!!!  compressValue error"+e.getMessage());
            //任意一个对象序列化失败，都要阻塞服务启动
            throw new RuntimeException("compressValue error", e);
        }
        System.out.println("JDK"+SUM+"个对象总大小"+byteToMb(size));
        return size;
    }
    //getSizeOfCompressedObjectBySnappy
    private static double getSizeOfCompressedObjectBySnappy(Object value) {
        double size = 0l;
        try {
            size = Snappy.compress(getBytesFromObject((Serializable) value)).length*SUM;
        } catch (Exception e) {
            System.out.println("!!! Fatal Error!!!  compressValue error"+e.getMessage());
            //任意一个对象序列化失败，都要阻塞服务启动
            throw new RuntimeException("compressValue error", e);
        }
        System.out.println("Snappy"+SUM+"个对象总大小"+byteToMb(size));
        return size;
    }
    private static double getSizeOfCompressedObjectByKyro(Object value) {
        double size = 0l;
        try {
            size = compressValueByKyro(value).length*SUM;
        } catch (Exception e) {
            System.out.println("!!! Fatal Error!!!  compressValue error"+e.getMessage());
            //任意一个对象序列化失败，都要阻塞服务启动
            throw new RuntimeException("compressValue error", e);
        }
        System.out.println("Kyro"+SUM+"个对象总大小"+byteToMb(size));
        return size;
    }
    //getSizeOfCompressedObjectBySnappyAndKyro
    private static double getSizeOfCompressedObjectBySnappyAndKyro(Object value) {
        double size = 0;

        try {
            size = Snappy.compress(compressValueByKyro(value)).length*SUM;
        } catch (Exception e) {
            System.out.println("!!! Fatal Error!!!  compressValue error"+e.getMessage());
            //任意一个对象序列化失败，都要阻塞服务启动
            throw new RuntimeException("compressValue error", e);
        }
        System.out.println("Snappy+Kyro "+SUM+"个对象总大小"+byteToMb(size));
        return size;
    }
    //getSizeOfCompressedObjectByInstrumentation
    private static double getSizeOfCompressedObjectByInstrumentation(Object value) {

        double size = 0;
        try {
            size = instrumentation.getObjectSize(value)*SUM;
        } catch (Exception e) {
            System.out.println("!!! Fatal Error!!!  compressValue error"+e.getMessage());
            //任意一个对象序列化失败，都要阻塞服务启动
            throw new RuntimeException("compressValue error", e);
        }
        System.out.println("原始"+SUM+"个对象总大小"+byteToMb(size));
        return size;
    }

    public static byte[] getBytesFromObject(Serializable obj) throws Exception {
        if (obj == null) {
            return null;
        }
        try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                GZIPOutputStream gzipOut = new GZIPOutputStream(baos);
                ObjectOutputStream objectOut = new ObjectOutputStream(gzipOut);
                ) {
            objectOut.writeObject(obj);
            objectOut.flush();
            objectOut.close();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new Exception("getBytesFromObject error", e);
        }
    }

    public static Object deserialize(byte[] bytes)  {
        try (
                ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                GZIPInputStream gzipIn = new GZIPInputStream(bais);
                ObjectInputStream objectIn = new ObjectInputStream(gzipIn);
                ) {
            return objectIn.readObject();
        } catch (Exception e) {
            System.err.println("deserialize fail"+ e.getMessage());
            //throw new Exception("getBytesFromObject error", e);
            return null;
        }
    }


    public static void testSnappyUncompressWithKyro(OperationWaybill operationWaybill) throws IOException {
        double size = 0;
        byte[] bytes = compressValueByKyro(operationWaybill);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            //size+=bytes.length;
            OperationWaybill operationWaybill1 = (OperationWaybill) deserializeByKyro(Snappy.uncompress(bytes));
        }
        stopWatch.stop();
        System.out.println(String.format("Snappy+Kyro压缩方案[序列化 & 反序列化 + parseObject%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }

    private static Kryo kryo;
    static {
        kryo = new Kryo();
        kryo.setRegistrationRequired(false);
    }


    private static byte[] compressValueByKyro(Object value) {
        byte[] valueCompressBytes;
        try {
            valueCompressBytes = Snappy.compress(serializeByKryo(value));
        } catch (Exception e) {
            System.out.println("!!! Fatal Error!!!  compressValue error"+e.getMessage());
            //任意一个对象序列化失败，都要阻塞服务启动
            throw new RuntimeException("compressValue error", e);
        }
        return valueCompressBytes;
    }
    public static byte[] serializeByKryo(Object t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }

        kryo.setReferences(false);
        kryo.register(OperationWaybill.class);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, t);
            output.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            System.out.println(e.getMessage());
        }

        return new byte[0];
    }
    public static Object deserializeByKyro(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }

        kryo.setReferences(false);
        kryo.register(OperationWaybill.class);
        try (Input input = new Input(bytes)) {
            return kryo.readClassAndObject(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void testFstJSONStr(OperationWaybill operationWaybill) {
        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] jdkserialize = fstSerializerStr.serialize(JSON.toJSONString(operationWaybill));
            jedis.set(String.valueOf(i).getBytes(), jdkserialize);
            size += jdkserialize.length;
        }
        stopWatch.stop();
        System.out.println(String.format("FST String序列化方案[toJSONString & 序列化 & 保存  %s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));

        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] bytes = jedis.get(String.valueOf(i).getBytes());
            OperationWaybill operationWaybill1 = JSON.parseObject((String) fstSerializerStr.deserialize(bytes),OperationWaybill.class);
        }
        stopWatch.stop();
        System.out.println(String.format("FST String序列化方案[序列化 & 反序列化 &  parseObject %s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }

    public static void testKryo(OperationWaybill operationWaybill) {
        double size = 0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < SUM; i++) {
            byte[] jdkserialize = kryoSerializer.serialize(operationWaybill);
            OperationWaybill operationWaybill1 = (OperationWaybill) kryoSerializer.deserialize(jdkserialize);;
        }
        stopWatch.stop();
        System.out.println(String.format("Kryo序列化方案[序列化 & 反序列化%s次]\n耗时：%s ms, 总大小 %s mb",
                SUM, stopWatch.getTotalTimeMillis(), byteToMb(size)));
    }
}
