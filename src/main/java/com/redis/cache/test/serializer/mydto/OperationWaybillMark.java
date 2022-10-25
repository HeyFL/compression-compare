package com.redis.cache.test.serializer.mydto;

import java.util.Date;

/**
 * @description 标记关系表
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybillMark extends StringIdBean {

    private static final long serialVersionUID = 8533571512746316713L;
    /**
     * ID
     */
    private String labellingId;
    /**
     * 标记类型
     */
    private String labellingPattern;
    /**
     * 运单号
     */
    private String waybillNo;
    /**
     * 订单号
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

    public String getLabellingId() {
        return labellingId;
    }
    public void setLabellingId(String labellingId) {
        this.labellingId = labellingId;
    }
    public String getLabellingPattern() {
        return labellingPattern;
    }
    public void setLabellingPattern(String labellingPattern) {
        this.labellingPattern = labellingPattern;
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
        return labellingId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((labellingId == null) ? 0 : labellingId.hashCode());
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
        OperationWaybillMark other = (OperationWaybillMark) obj;
        if (null == other)
            return false;
        if (labellingId == null) {
            if (other.labellingId != null)
                return false;
        } else if (!labellingId.equals(other.labellingId))
            return false;
        return true;
    }
    
}