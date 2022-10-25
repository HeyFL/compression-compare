package com.redis.cache.test.serializer.mydto;

import java.util.Date;

/**
 * @description 增值服务表
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybillService extends StringIdBean {

    private static final long serialVersionUID = 5238109075485835561L;
    /**
     * 服务ID
     */
    private String serviceId;
    /**
     * 增值服务代码
     */
    private String serviceProdCode;
    /**
     * 属性1
     */
    private String attribute1;
    /**
     * 属性2
     */
    private String attribute2;
    /**
     * 属性3
     */
    private String attribute3;
    /**
     * 属性4
     */
    private String attribute4;
    /**
     * 属性5
     */
    private String attribute5;
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
    
    public String getServiceId() {
        return serviceId;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
    public String getServiceProdCode() {
        return serviceProdCode;
    }
    public void setServiceProdCode(String serviceProdCode) {
        this.serviceProdCode = serviceProdCode;
    }
    public String getAttribute1() {
        return attribute1;
    }
    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }
    public String getAttribute2() {
        return attribute2;
    }
    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }
    public String getAttribute3() {
        return attribute3;
    }
    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }
    public String getAttribute4() {
        return attribute4;
    }
    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }
    public String getAttribute5() {
        return attribute5;
    }
    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
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
    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }
    @Override
    protected String getId() {
        return serviceId;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
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
        OperationWaybillService other = (OperationWaybillService) obj;
        if (null == other)
            return false;
        if (serviceId == null) {
            if (other.serviceId != null)
                return false;
        } else if (!serviceId.equals(other.serviceId))
            return false;
        return true;
    }
    
}