package com.redis.cache.test.serializer.mydto;

import java.util.Date;

/**
 * 描述：税金信息实体类
 * 
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID   DATE				PERSON			REASON
 *  1    2017年4月25日		80002031			Create
 *  2    2017年11月24        01369587            update
 * ****************************************************************************
 * </pre>
 * 
 * @author 80002031
 */
public class OperationTaxbillInfo extends StringIdBean {
    
    private static final long serialVersionUID = -1869627171189404872L;
    
    private String taxbillId; // 主键
    private String sn; // 序号
    private Date inDate; // 进口抵达日期
    private Date customsDate; // 报关日期
    private String mainbNo; // 主运单号
    private String waybillNo; // 运单号
    private String orderNo; // 订单号(分库字段)
    private String waybillId; // 运单主键
    private Date updateTm; // 修改时间
    private Date createTm; // 创建时间
    private String decCode; // 申报编号
    private String taxPerNo; // 纳税人编号
    private String srcCompany; // 寄方公司名称
    private String srcPersonName; // 寄方联系人
    private String desCompany; // 收方公司名称
    private String desPersonName; // 收方联系人
    private Double decValue; // 申报价值
    private String cusCurrencySymbol; // 申报币种
    private String decType; // 申报类型
    private Double customDuty; // 关税
    private Double gstValue; // 消费税
    private Double vatValue; // 增值税
    private Double exciseDuty; // 货物税
    private Double otherDutyAmount; // 其他税
    private Double totalValue; // 税金合计
    private Double wareHouseFee; // 报关仓储费
    private Double handlingFee; // 报关服务费
    private Double quarantineFee; // 检验检疫费
    private Double otherFee; // 其他费用
    private Double totalFeeAmount; // 费用合计
    private Double totalFeeVal; // 税费合计
    private String currency; // 税金币种
    private String cusDeptCode; // 口岸代码
    private String cusNetCode; // 口岸网点代码
    private String interdna; // 口岸国家
    private String taxAccount; // 税金结算账号
    private String taxPaymentType; // 税金付款方式
    private String isAudit; // 是否需要审核
    private String payZoneCode; // 税金付款网点
    private String paymentCurrency; // 付款币种，根据付款网点自动带出
    private String gatherEmpCode; // 交款的收派员工号
    private Date paymentTime; // 交款时间，业务实际发生时间(YYYY-MM-DD HH24:MI:SS)
    private Date inputTime; // CMSP传入时间（YYYY-MM-DD HH24:MI:SS）
    private Integer version; // 版本号
    private String sourceZoneCode; // 原寄地代码
    private String destZoneCode; // 目的地代码
    private String cargoTypeCode; // 快件内容
    private String limitTypeCode; // 时效类型
    private String distanceTypeCode; // 区域类型
    private String transportTypeCode; // 运输方式
    private String expressTypeCode; // 业务类型
    private String addresseeAddr; // 清单收件地址
    private String addresseePhone; // 清单收件人联系电话
    private Double quantity; // 件数
    private Double realWeightQty; // 实际重量
    private String consName; // 托寄物名称

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getCustomsDate() {
        return customsDate;
    }

    public void setCustomsDate(Date customsDate) {
        this.customsDate = customsDate;
    }

    public String getMainbNo() {
        return mainbNo;
    }

    public void setMainbNo(String mainbNo) {
        this.mainbNo = mainbNo;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public String getDecCode() {
        return decCode;
    }

    public void setDecCode(String decCode) {
        this.decCode = decCode;
    }

    public String getTaxPerNo() {
        return taxPerNo;
    }

    public void setTaxPerNo(String taxPerNo) {
        this.taxPerNo = taxPerNo;
    }

    public String getSrcCompany() {
        return srcCompany;
    }

    public void setSrcCompany(String srcCompany) {
        this.srcCompany = srcCompany;
    }

    public String getSrcPersonName() {
        return srcPersonName;
    }

    public void setSrcPersonName(String srcPersonName) {
        this.srcPersonName = srcPersonName;
    }

    public String getDesCompany() {
        return desCompany;
    }

    public void setDesCompany(String desCompany) {
        this.desCompany = desCompany;
    }

    public String getDesPersonName() {
        return desPersonName;
    }

    public void setDesPersonName(String desPersonName) {
        this.desPersonName = desPersonName;
    }

    public Double getDecValue() {
        return decValue;
    }

    public void setDecValue(Double decValue) {
        this.decValue = decValue;
    }

    public String getCusCurrencySymbol() {
        return cusCurrencySymbol;
    }

    public void setCusCurrencySymbol(String cusCurrencySymbol) {
        this.cusCurrencySymbol = cusCurrencySymbol;
    }

    public String getDecType() {
        return decType;
    }

    public void setDecType(String decType) {
        this.decType = decType;
    }

    public Double getCustomDuty() {
        return customDuty;
    }

    public void setCustomDuty(Double customDuty) {
        this.customDuty = customDuty;
    }

    public Double getGstValue() {
        return gstValue;
    }

    public void setGstValue(Double gstValue) {
        this.gstValue = gstValue;
    }

    public Double getVatValue() {
        return vatValue;
    }

    public void setVatValue(Double vatValue) {
        this.vatValue = vatValue;
    }

    public Double getExciseDuty() {
        return exciseDuty;
    }

    public void setExciseDuty(Double exciseDuty) {
        this.exciseDuty = exciseDuty;
    }

    public Double getOtherDutyAmount() {
        return otherDutyAmount;
    }

    public void setOtherDutyAmount(Double otherDutyAmount) {
        this.otherDutyAmount = otherDutyAmount;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Double getWareHouseFee() {
        return wareHouseFee;
    }

    public void setWareHouseFee(Double wareHouseFee) {
        this.wareHouseFee = wareHouseFee;
    }

    public Double getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(Double handlingFee) {
        this.handlingFee = handlingFee;
    }

    public Double getQuarantineFee() {
        return quarantineFee;
    }

    public void setQuarantineFee(Double quarantineFee) {
        this.quarantineFee = quarantineFee;
    }

    public Double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Double otherFee) {
        this.otherFee = otherFee;
    }

    public Double getTotalFeeAmount() {
        return totalFeeAmount;
    }

    public void setTotalFeeAmount(Double totalFeeAmount) {
        this.totalFeeAmount = totalFeeAmount;
    }

    public Double getTotalFeeVal() {
        return totalFeeVal;
    }

    public void setTotalFeeVal(Double totalFeeVal) {
        this.totalFeeVal = totalFeeVal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCusDeptCode() {
        return cusDeptCode;
    }

    public void setCusDeptCode(String cusDeptCode) {
        this.cusDeptCode = cusDeptCode;
    }

    public String getCusNetCode() {
        return cusNetCode;
    }

    public void setCusNetCode(String cusNetCode) {
        this.cusNetCode = cusNetCode;
    }

    public String getInterdna() {
        return interdna;
    }

    public void setInterdna(String interdna) {
        this.interdna = interdna;
    }

    public String getTaxAccount() {
        return taxAccount;
    }

    public void setTaxAccount(String taxAccount) {
        this.taxAccount = taxAccount;
    }

    public String getTaxPaymentType() {
        return taxPaymentType;
    }

    public void setTaxPaymentType(String taxPaymentType) {
        this.taxPaymentType = taxPaymentType;
    }

    public String getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit;
    }

    public String getPayZoneCode() {
        return payZoneCode;
    }

    public void setPayZoneCode(String payZoneCode) {
        this.payZoneCode = payZoneCode;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    public String getGatherEmpCode() {
        return gatherEmpCode;
    }

    public void setGatherEmpCode(String gatherEmpCode) {
        this.gatherEmpCode = gatherEmpCode;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSourceZoneCode() {
        return sourceZoneCode;
    }

    public void setSourceZoneCode(String sourceZoneCode) {
        this.sourceZoneCode = sourceZoneCode;
    }

    public String getDestZoneCode() {
        return destZoneCode;
    }

    public void setDestZoneCode(String destZoneCode) {
        this.destZoneCode = destZoneCode;
    }

    public String getCargoTypeCode() {
        return cargoTypeCode;
    }

    public void setCargoTypeCode(String cargoTypeCode) {
        this.cargoTypeCode = cargoTypeCode;
    }

    public String getLimitTypeCode() {
        return limitTypeCode;
    }

    public void setLimitTypeCode(String limitTypeCode) {
        this.limitTypeCode = limitTypeCode;
    }

    public String getDistanceTypeCode() {
        return distanceTypeCode;
    }

    public void setDistanceTypeCode(String distanceTypeCode) {
        this.distanceTypeCode = distanceTypeCode;
    }

    public String getTransportTypeCode() {
        return transportTypeCode;
    }

    public void setTransportTypeCode(String transportTypeCode) {
        this.transportTypeCode = transportTypeCode;
    }

    public String getExpressTypeCode() {
        return expressTypeCode;
    }

    public void setExpressTypeCode(String expressTypeCode) {
        this.expressTypeCode = expressTypeCode;
    }

    public String getAddresseeAddr() {
        return addresseeAddr;
    }

    public void setAddresseeAddr(String addresseeAddr) {
        this.addresseeAddr = addresseeAddr;
    }

    public String getAddresseePhone() {
        return addresseePhone;
    }

    public void setAddresseePhone(String addresseePhone) {
        this.addresseePhone = addresseePhone;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRealWeightQty() {
        return realWeightQty;
    }

    public void setRealWeightQty(Double realWeightQty) {
        this.realWeightQty = realWeightQty;
    }

    public String getConsName() {
        return consName;
    }

    public void setConsName(String consName) {
        this.consName = consName;
    }

    public String getTaxbillId() {
        return taxbillId;
    }

    public void setTaxbillId(String taxbillId) {
        this.taxbillId = taxbillId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }

    public Date getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }


    @Override
    protected String getId() {
        return taxbillId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((taxbillId == null) ? 0 : taxbillId.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (null != obj && getClass() != obj.getClass())
            return false;
        OperationTaxbillInfo other = (OperationTaxbillInfo) obj;
        if (null == other)
            return false;
        if (taxbillId == null) {
            if (other.taxbillId != null)
                return false;
        } else if (!taxbillId.equals(other.taxbillId))
            return false;
        return true;
    }
}
