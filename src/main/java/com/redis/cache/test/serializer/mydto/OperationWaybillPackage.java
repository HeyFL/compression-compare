package com.redis.cache.test.serializer.mydto;

import java.util.Date;
import java.util.List;

/**
 * @description 包裹表
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybillPackage extends StringIdBean {

    private static final long serialVersionUID = -8477435759142836647L;
    /**
     * UUID
     */
    private String packageId;
    /**
     * 包裹运单号
     */
    private String packageNo;
    /**
     * 包裹长
     */
    private Double packageLong;
    /**
     * 包裹宽
     */
    private Double packageWidth;
    /**
     * 包裹高
     */
    private Double packageHigh;
    /**
     * 体积
     */
    private Double packageVolume;
    /**
     * 体积单位
     */
    private String packageUnitWeight;
    /**
     * 包裹重量
     */
    private Double packageWeight;
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
    
    /**
     * 托寄物对象集合
     */
    private List<OperationWaybillConsign> operationWaybillConsignList;
    
    /**
     * 箱号
     */
    private String boxNo;
    
    public List<OperationWaybillConsign> getOperationWaybillConsignList() {
        return operationWaybillConsignList;
    }
    public void setOperationWaybillConsignList(List<OperationWaybillConsign> operationWaybillConsignList) {
        this.operationWaybillConsignList = operationWaybillConsignList;
    }
    public String getPackageId() {
        return packageId;
    }
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
    public String getPackageNo() {
        return packageNo;
    }
    public void setPackageNo(String packageNo) {
        this.packageNo = packageNo;
    }
    public Double getPackageLong() {
        return packageLong;
    }
    public void setPackageLong(Double packageLong) {
        this.packageLong = packageLong;
    }
    public Double getPackageWidth() {
        return packageWidth;
    }
    public void setPackageWidth(Double packageWidth) {
        this.packageWidth = packageWidth;
    }
    public Double getPackageHigh() {
        return packageHigh;
    }
    public void setPackageHigh(Double packageHigh) {
        this.packageHigh = packageHigh;
    }
    public Double getPackageVolume() {
        return packageVolume;
    }
    public void setPackageVolume(Double packageVolume) {
        this.packageVolume = packageVolume;
    }
    public String getPackageUnitWeight() {
        return packageUnitWeight;
    }
    public void setPackageUnitWeight(String packageUnitWeight) {
        this.packageUnitWeight = packageUnitWeight;
    }
    public Double getPackageWeight() {
        return packageWeight;
    }
    public void setPackageWeight(Double packageWeight) {
        this.packageWeight = packageWeight;
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
        return packageId;
    }
    
    public String getBoxNo() {
        return boxNo;
    }
    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((packageId == null) ? 0 : packageId.hashCode());
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
        OperationWaybillPackage other = (OperationWaybillPackage) obj;
        if (null == other)
            return false;
        if (packageId == null) {
            if (other.packageId != null)
                return false;
        } else if (!packageId.equals(other.packageId))
            return false;
        return true;
    }
    
}