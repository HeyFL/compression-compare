package com.redis.cache.test.serializer.mydto;

import java.util.Date;

/**
 * @description 操作类运单附加信息
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybillAddition extends StringIdBean {
    
    private static final long serialVersionUID = -8612752028465335501L;
    /**
     * 主键ID
     */
    private String additionalId;
    /**
     * 附加KEY
     */
    private String additionalKey;
    /**
     * 附加值
     */
    private String additionalValues;
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

    public String getAdditionalId() {
        return additionalId;
    }
    public void setAdditionalId(String additionalId) {
        this.additionalId = additionalId;
    }
    public String getAdditionalKey() {
        return additionalKey;
    }
    public void setAdditionalKey(String additionalKey) {
        this.additionalKey = additionalKey;
    }
    public String getAdditionalValues() {
        return additionalValues;
    }
    public void setAdditionalValues(String additionalValues) {
        this.additionalValues = additionalValues;
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
        return additionalId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((additionalId == null) ? 0 : additionalId.hashCode());
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
        OperationWaybillAddition other = (OperationWaybillAddition) obj;
        if (null == other)
            return false;
        if (additionalId == null) {
            if (other.additionalId != null)
                return false;
        } else if (!additionalId.equals(other.additionalId))
            return false;
        return true;
    }
    
}