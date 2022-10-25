package com.redis.cache.test.serializer.mydto;

import java.util.Date;

/**
 * @description 操作类运单信息：特殊操作
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybillSpecialHandler extends StringIdBean {

    private static final long serialVersionUID = 3124067477045920522L;
    /**
     * 主键ID
     */
    private String id;
    /**
     * 内部订单号（分库字段)
     */
    private String orderNo;
    /**
     * 类型
     */
    private String type;
    /**
     * 编码
     */
    private String code;
    /**
     * 操作
     */
    private String operation;
    /**
     * 创建时间
     */
    private Date createTm;
    /**
     * 更新时间
     */
    private Date updateTm;

    /**
     * 运单主键
     */
    private String waybillId;
    /**
     * 运单号
     */
    private String waybillNo;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public Date getCreateTm() {
        return createTm;
    }
    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }
    public Date getUpdateTm() {
        return updateTm;
    }
    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
    }
    public String getWaybillId() {
        return waybillId;
    }
    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }
    public String getWaybillNo() {
        return waybillNo;
    }
    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        OperationWaybillSpecialHandler other = (OperationWaybillSpecialHandler) obj;
        if (null == other)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}