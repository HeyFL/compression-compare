package com.redis.cache.test.serializer.mydto;

import java.util.Date;

/**
 * @description 操作类运单出口信息
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybillCustoms extends StringIdBean {

    private static final long serialVersionUID = -1523100997733688814L;
    /**
     * 出口ID
     */
    private String exportId;
    /**
     * 报关批次
     */
    private String customsBatchs;
    /**
     * 报关类型
     */
    private String customsTypeCode;
    /**
     * 预报关日期
     */
    private Date preCustomsDt;
    /**
     * 原产地
     */
    private String sourcearea;
    /**
     * 寄方邮政编码
     */
    private String consignorPostalCode;
    /**
     * 收方邮政编码
     */
    private String addresseePostalCode;
    /**
     * 国家代码
     */
    private String countryCode;
    /**
     * 寄件人税号
     */
    private String consignorTaxNo;
    /**
     * 统一编码（收件人税号）
     */
    private String unifiedCode;
    /**
     * 台湾发票类型
     */
    private String twinvoiceTypeCode;
    /**
     * 参考编码
     */
    private String consultCode;
    /**
     * 贸易条件
     */
    private String tradeCondtion;
    /**
     * 是否以上游发票为准
     */
    private boolean isUseUpstreamInvoice;
    /**
     * 运单号
     */
    private String waybillNo;
    /**
     * 订单号（分库字段）
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

    public String getTradeCondtion() {
		return tradeCondtion;
	}
	public void setTradeCondtion(String tradeCondtion) {
		this.tradeCondtion = tradeCondtion;
	}
	public boolean getIsUseUpstreamInvoice() {
		return isUseUpstreamInvoice;
	}
	public void setIsUseUpstreamInvoice(boolean isUseUpstreamInvoice) {
		this.isUseUpstreamInvoice = isUseUpstreamInvoice;
	}
	public String getExportId() {
        return exportId;
    }
    public void setExportId(String exportId) {
        this.exportId = exportId;
    }
    public String getCustomsBatchs() {
        return customsBatchs;
    }
    public void setCustomsBatchs(String customsBatchs) {
        this.customsBatchs = customsBatchs;
    }
    public String getCustomsTypeCode() {
        return customsTypeCode;
    }
    public void setCustomsTypeCode(String customsTypeCode) {
        this.customsTypeCode = customsTypeCode;
    }
    public Date getPreCustomsDt() {
        return preCustomsDt;
    }
    public void setPreCustomsDt(Date preCustomsDt) {
        this.preCustomsDt = preCustomsDt;
    }
    public String getSourcearea() {
        return sourcearea;
    }
    public void setSourcearea(String sourcearea) {
        this.sourcearea = sourcearea;
    }
    public String getConsignorPostalCode() {
        return consignorPostalCode;
    }
    public void setConsignorPostalCode(String consignorPostalCode) {
        this.consignorPostalCode = consignorPostalCode;
    }
    public String getAddresseePostalCode() {
        return addresseePostalCode;
    }
    public void setAddresseePostalCode(String addresseePostalCode) {
        this.addresseePostalCode = addresseePostalCode;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getConsignorTaxNo() {
        return consignorTaxNo;
    }
    public void setConsignorTaxNo(String consignorTaxNo) {
        this.consignorTaxNo = consignorTaxNo;
    }
    public String getUnifiedCode() {
        return unifiedCode;
    }
    public void setUnifiedCode(String unifiedCode) {
        this.unifiedCode = unifiedCode;
    }
    public String getTwinvoiceTypeCode() {
        return twinvoiceTypeCode;
    }
    public void setTwinvoiceTypeCode(String twinvoiceTypeCode) {
        this.twinvoiceTypeCode = twinvoiceTypeCode;
    }
    public String getConsultCode() {
        return consultCode;
    }
    public void setConsultCode(String consultCode) {
        this.consultCode = consultCode;
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
        return exportId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((exportId == null) ? 0 : exportId.hashCode());
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
        OperationWaybillCustoms other = (OperationWaybillCustoms) obj;
        if (null == other)
            return false;
        if (exportId == null) {
            if (other.exportId != null)
                return false;
        } else if (!exportId.equals(other.exportId))
            return false;
        return true;
    }
    
}