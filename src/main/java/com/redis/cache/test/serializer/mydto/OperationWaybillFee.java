package com.redis.cache.test.serializer.mydto;

import java.util.Date;

/**
 * @description 费用表
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybillFee extends StringIdBean {

    private static final long serialVersionUID = -3827270417306005418L;
    /**
     * 费用ID
     */
    private String feeId;
    /**
     * 费用类型代码
     */
    private String feeTypeCode;
    /**
     * 费用金额
     */
    private Double feeAmt;
    /**
     * 收付款网点
     */
    private String gatherZoneCode;
    /**
     * 付款方式1.寄付2.到付3.第三方付
     */
    private String paymentTypeCode;
    /**
     * 结算方式1. 现结2.月结
     */
    private String settlementTypeCode;
    /**
     * 付款方式变更
     */
    private String paymentChangeTypeCode;
    /**
     * 付款账号
     */
    private String customerAcctCode;
    /**
     * 币别代码
     */
    private String currencyCode;
    /**
     * 服务ID
     */
    private String serviceId;
    /**
     * 交款人
     */
    private String gatherEmpCode;
    /**
     * 业务所属地区编码
     */
    private String bizOwnerZoneCode;
    /**
     * 原寄地货款
     */
    private Double sourceCodeFeeAmt;
    /**
     * 汇率（目的地到原寄地）
     */
    private Double exchangeRate;
    /**
     * 目的地所在币种
     */
    private String destCurrencyCode;
    /**
     * 个性化费用
     */
    private Double feeAmtInd;
    /**
     * 个性化类型
     */
    private String feeIndType;
    /**
     * 计价卡号
     */
    private String valutionAcctCode;
    /**
     * 运单号
     */
    private String waybillNo;
    /**
     * 内部订单号（分库字段）
     */
    private String orderNo;
    /**
     * 运单主键
     */
    private String waybillId;
    /**
     * 修改时间
     */
    private Date updateTm;

    /**
     * 创建时间
     */
    private Date createTm;
    
    //以下5个字段优化SWS来源添加(2018-6-20 by 80002767)
    /**
     * 券抵免金额
     */
    private Double ticketOffsetAmt;
    /**
     * 券类型1重量, 2现金, 3折扣率
     */
    private String ticketType;
    /**
     * 券种类1纸质券,2普通电子券,3自寄自取,4三合一电子券,5其它类型
     */
    private String ticketKind;
    /**
     * 券用途1客户维护，2公共关系维护，3员工福利
     */
    private String ticketPurpose;
    /**
     * 是否非现支付0现金（默认）1非现已支付（渠道+金额 必须）2非现未支付
     */
    private String isOnlineDeduct;
    
    /** 是否后付费 */
    private String isLaterPay;

    public String getIsLaterPay() {
        return isLaterPay;
    }
    public void setIsLaterPay(String isLaterPay) {
        this.isLaterPay = isLaterPay;
    }
    public String getFeeId() {
        return feeId;
    }
    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }
    public String getFeeTypeCode() {
        return feeTypeCode;
    }
    public void setFeeTypeCode(String feeTypeCode) {
        this.feeTypeCode = feeTypeCode;
    }
    public Double getFeeAmt() {
        return feeAmt;
    }
    public void setFeeAmt(Double feeAmt) {
        this.feeAmt = feeAmt;
    }
    public String getGatherZoneCode() {
        return gatherZoneCode;
    }
    public void setGatherZoneCode(String gatherZoneCode) {
        this.gatherZoneCode = gatherZoneCode;
    }
    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }
    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }
    public String getSettlementTypeCode() {
        return settlementTypeCode;
    }
    public void setSettlementTypeCode(String settlementTypeCode) {
        this.settlementTypeCode = settlementTypeCode;
    }
    public String getPaymentChangeTypeCode() {
        return paymentChangeTypeCode;
    }
    public void setPaymentChangeTypeCode(String paymentChangeTypeCode) {
        this.paymentChangeTypeCode = paymentChangeTypeCode;
    }
    public String getCustomerAcctCode() {
        return customerAcctCode;
    }
    public void setCustomerAcctCode(String customerAcctCode) {
        this.customerAcctCode = customerAcctCode;
    }
    public String getCurrencyCode() {
        return currencyCode;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public String getServiceId() {
        return serviceId;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
    public String getGatherEmpCode() {
        return gatherEmpCode;
    }
    public void setGatherEmpCode(String gatherEmpCode) {
        this.gatherEmpCode = gatherEmpCode;
    }
    public String getBizOwnerZoneCode() {
        return bizOwnerZoneCode;
    }
    public void setBizOwnerZoneCode(String bizOwnerZoneCode) {
        this.bizOwnerZoneCode = bizOwnerZoneCode;
    }
    public Double getSourceCodeFeeAmt() {
        return sourceCodeFeeAmt;
    }
    public void setSourceCodeFeeAmt(Double sourceCodeFeeAmt) {
        this.sourceCodeFeeAmt = sourceCodeFeeAmt;
    }
    public Double getExchangeRate() {
        return exchangeRate;
    }
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    public String getDestCurrencyCode() {
        return destCurrencyCode;
    }
    public void setDestCurrencyCode(String destCurrencyCode) {
        this.destCurrencyCode = destCurrencyCode;
    }
    public Double getFeeAmtInd() {
        return feeAmtInd;
    }
    public void setFeeAmtInd(Double feeAmtInd) {
        this.feeAmtInd = feeAmtInd;
    }
    public String getFeeIndType() {
        return feeIndType;
    }
    public void setFeeIndType(String feeIndType) {
        this.feeIndType = feeIndType;
    }
    public String getValutionAcctCode() {
        return valutionAcctCode;
    }
    public void setValutionAcctCode(String valutionAcctCode) {
        this.valutionAcctCode = valutionAcctCode;
    }
    public String getWaybillNo() {
        return waybillNo;
    }
    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
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
        return feeId;
    }
    public Double getTicketOffsetAmt() {
        return ticketOffsetAmt;
    }
    public void setTicketOffsetAmt(Double ticketOffsetAmt) {
        this.ticketOffsetAmt = ticketOffsetAmt;
    }
    public String getTicketType() {
        return ticketType;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public String getTicketKind() {
        return ticketKind;
    }
    public void setTicketKind(String ticketKind) {
        this.ticketKind = ticketKind;
    }
    public String getTicketPurpose() {
        return ticketPurpose;
    }
    public void setTicketPurpose(String ticketPurpose) {
        this.ticketPurpose = ticketPurpose;
    }
    public String getIsOnlineDeduct() {
        return isOnlineDeduct;
    }
    public void setIsOnlineDeduct(String isOnlineDeduct) {
        this.isOnlineDeduct = isOnlineDeduct;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((feeId == null) ? 0 : feeId.hashCode());
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
        OperationWaybillFee other = (OperationWaybillFee) obj;
        if (null == other)
            return false;
        if (feeId == null) {
            if (other.feeId != null)
                return false;
        } else if (!feeId.equals(other.feeId))
            return false;
        return true;
    }
    
}