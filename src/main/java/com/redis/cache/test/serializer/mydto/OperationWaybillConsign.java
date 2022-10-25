package com.redis.cache.test.serializer.mydto;

import java.util.Date;

/**
 * @description 托寄物表
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybillConsign extends StringIdBean {

    private static final long serialVersionUID = -33143943407447622L;
    /**
     * UUID
     */
    private String consId;
    /**
     * 品名
     */
    private String consName;
    /**
     * 数量
     */
    private String consQty;
    /**
     * 重量
     */
    private Double weightQty;
    /**
     * 价值
     */
    private Double consValue;
    /**
     * 数量单位
     */
    private String qtyUnit;
    /**
     * 产品国检备案编号
     */
    private String productRecordNo;
    /**
     * 包裹ID
     */
    private String packageId;
    /**
     * 包裹运单号
     */
    private String packageNo;
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
     * 海关编码
     */
    private String hsCode;

    /**
     * 创建时间
     */
    private Date createTm;
    
    /**
     * 寄物英文名称
     */
    private String englishConsName;

    /**
     * 托寄物单位英文名称
     */
    private String englishQtyUnit;

    /**
     * 商品编号 V5.5 新增
     */
    private String goodsCode;
    /**
     * 品牌  V5.5 新增
     */
    private String brand;
    /**
     * 规格型号 V5.5 新增
     */
    private String specifications;
    /**
     * 商品海关备案号 V6.4 新增
     */
    private String productCustomsNo;
    
    public String getProductCustomsNo() {
        return productCustomsNo;
    }
    public void setProductCustomsNo(String productCustomsNo) {
        this.productCustomsNo = productCustomsNo;
    }
    public String getGoodsCode() {
        return goodsCode;
    }
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getSpecifications() {
        return specifications;
    }
    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
    public String getConsId() {
        return consId;
    }
    public void setConsId(String consId) {
        this.consId = consId;
    }
    public String getConsName() {
        return consName;
    }
    public void setConsName(String consName) {
        this.consName = consName;
    }
    public String getConsQty() {
        return consQty;
    }
    public void setConsQty(String consQty) {
        this.consQty = consQty;
    }
    public Double getWeightQty() {
        return weightQty;
    }
    public void setWeightQty(Double weightQty) {
        this.weightQty = weightQty;
    }
    public Double getConsValue() {
        return consValue;
    }
    public void setConsValue(Double consValue) {
        this.consValue = consValue;
    }
    public String getQtyUnit() {
        return qtyUnit;
    }
    public void setQtyUnit(String qtyUnit) {
        this.qtyUnit = qtyUnit;
    }
    public String getProductRecordNo() {
        return productRecordNo;
    }
    public void setProductRecordNo(String productRecordNo) {
        this.productRecordNo = productRecordNo;
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
    public String getHsCode() {
        return hsCode;
    }
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }
    public Date getCreateTm() {
        return createTm;
    }
    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }
    @Override
    protected String getId() {
        return consId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((consId == null) ? 0 : consId.hashCode());
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
        OperationWaybillConsign other = (OperationWaybillConsign) obj;
        if (null == other)
            return false;
        if (consId == null) {
            if (other.consId != null)
                return false;
        } else if (!consId.equals(other.consId))
            return false;
        return true;
    }
	public String getEnglishConsName() {
		return englishConsName;
	}
	public void setEnglishConsName(String englishConsName) {
		this.englishConsName = englishConsName;
	}
	public String getEnglishQtyUnit() {
		return englishQtyUnit;
	}
	public void setEnglishQtyUnit(String englishQtyUnit) {
		this.englishQtyUnit = englishQtyUnit;
	}
    
}