package com.redis.cache.test.serializer.mydto;


import java.util.Date;
import java.util.List;

/**
 * @description 操作类运单主表
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybillToRedis extends StringIdBean {

    private static final long serialVersionUID = 7590468961452993214L;

    /**
     * newFile
     */
    //@Version(1)
    //private String newFile;
    //
    //public String getNewFile() {
    //    return newFile;
    //}
    //
    //public void setNewFile(String newFile) {
    //    this.newFile = newFile;
    //}

    /**
     * 运单ID
     */
    private String waybillId;
    /**
     * 运单号
     */
    private String waybillNo;
    /**
     * 原寄地
     */
    private String sourceZoneCode;
    /**
     * 目的地
     */
    private String destZoneCode;
    /**
     * 计费总重量
     */
    private Double meterageWeightQty;
    /**
     * 实际重量
     */
    private Double realWeightQty;
    /**
     * 包裹总件数
     */
    private Double quantity;
    /**
     * 收件员
     */
    private String consigneeEmpCode;
    /**
     * 寄件时间
     */
    private Date consignedTm;
    /**
     * 快件内容
     */
    private String cargoTypeCode;
    /**
     * 时效类型（参见tm_limit_type表）
     */
    private String limitTypeCode;
    /**
     * 区域类型
     */
    private String distanceTypeCode;
    /**
     * 运输方式
     */
    private String transportTypeCode;
    /**
     * 业务类型
     */
    private String expressTypeCode;
    /**
     * 总体积
     */
    private Double volume;
    /**
     * 总长
     */
    private Double billLong;
    /**
     * 总宽
     */
    private Double billWidth;
    /**
     * 总高
     */
    private Double billHigh;
    /**
     * 版本号
     */
    private Integer versionNo;
    /**
     * 锁版本号
     */
    private Integer lockVersionNo;
    /**
     * 重量计量单位
     */
    private String unitWeight;
    /**
     * 声明价值
     */
    private Double consValue;
    /**
     * 声明价值币种
     */
    private String consValueCurrencyCode;
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 备注
     */
    private String waybillRemark;
    /**
     * 内部订单号（分库字段）
     */
    private String orderNo;
    /**
     * 修改时间
     */
    private Date updateTm;
    /**
     * 预约派件开始时间
     */
    private Date expectStartTm;
    /**
     * 预约派件结束时间
     */
    private Date expectFinishTm;
    /**
     * 提供者
     */
    private String provider;
    /**
     * 动态预计派件时间
     */
    private Date dynExpcDeliveryTm;
    /**
     * 创建时间
     */
    private Date createTm = new Date();

    /**
     * action动作json串，包含：信息修改infoUpdate：1,收方地址修改desitionInfoChange:1,预约派件时间修改
     * timeChange:1,位置编码修改locationCodeChange:1,动态预计派件时间 dynExpcDeliveryTmChange:1,
     * 特殊操作specialHandlers;
     * 例如：{infoUpdate：1,locationCodeChange:1},此json串只存最新的action值
     */
    private String actionJson;
    /**
     * 更新源（每次更新，都在原来基础上加上新的更新源代码,以半角逗号分隔），
     * 分别有CX的改派（CX）、WEM过来的清单（WEM）、包裹揽收（PICKED）、sss地址（SSS_ADDRESS)、sss单元区域sssSSS_LOCATION、OMPS预计派件时间（OMPS）、SGS电子签收信息（SGS_ELEC）
     * 增加(异常地址信息)UN_KNOWN_ADDR -- create by 01369587 2017-11-25
     */
    private String updateSource;

    /**
     * 根据运单生成订单标识
     */
    private boolean genOrderFlag = false;
    /**
     * 收寄件人的信息对象
     */
    private OperationWaybillAddrCons operationWaybillAddrCons;
    /**
     * 收寄件人的信息对象集合
     */
    private List<OperationWaybillAddrCons> operationWaybillAddrConsList;

    /**
     * 运单标记关系list集合
     */
    private List<OperationWaybillMark> operationWaybillMarkList;

    /**
     * 费用信息集合
     */
    private List<OperationWaybillFee> operationWaybillFeeList;

    /**
     * 运单业务附加信息list集合
     */
    private List<OperationWaybillAddition> operationWaybillAdditionList;

    /**
     * 出口件信息
     */
    private OperationWaybillCustoms operationWaybillCustoms;
    /**
     * 出口件信息集合
     */
    private List<OperationWaybillCustoms> operationWaybillCustomsList;

    /**
     * 增值服务list集合
     */
    private List<OperationWaybillService> operationWaybillServiceList;

    /**
     * 操作类运单包裹对象
     */
    private List<OperationWaybillPackage> operationWaybillPackageList;

    /**
     * 税金信息  -- create by 01369587 2017-11-24
     */
    private List<OperationTaxbillInfo> operationTaxbillInfoList;

    private OperationTaxbillInfo operationTaxbillInfo;

    /**
     * 操作类运单附加扩展
     */
    private List<OperationWaybillAdditionExt> optWaybillAdditionExtList;

    /**
     * 操作类运单信息集合：特殊操作
     */
    private List<OperationWaybillSpecialHandler> optWaybillSpecialHandlerList;

    /**
     * 派件员工号
     */
    private String deliverEmpCode;
    /**
     * 签收人
     */
    private String subscriberName;
    /**
     * 签收时间
     */
    private Date signinTm;
    /**
     * 客户编码; 下单的客户编码
     */
    private String clientCode;

    /**
     * 当前来源：对应WaybillSource的code
     */
    private String currentSource;
    /**
     * 妥投类型1:正常，2:作废件，3:转寄，4:退回，5:扣件，6:遗失，7:补单，8:满月交单
     * 优化SWS来源时添加(2018-6-20 by 80002767)
     */
    private String deliveredType;
    /**
     * 接收更新操作运单的巴枪码
     */
    private String barOpCode;

    //==========================================临时传值字段
    /**
     * 输单员工号
     */
    private String inputerEmpCode;

    public OperationWaybillToRedis() {
        super();
    }

    public OperationWaybillToRedis(String waybillNo) {
        super();
        this.waybillNo = waybillNo;
    }

    public List<OperationWaybillSpecialHandler> getOptWaybillSpecialHandlerList() {
        return optWaybillSpecialHandlerList;
    }

    public void setOptWaybillSpecialHandlerList(List<OperationWaybillSpecialHandler> optWaybillSpecialHandlerList) {
        this.optWaybillSpecialHandlerList = optWaybillSpecialHandlerList;
    }

    public OperationWaybillAddrCons getOperationWaybillAddrCons() {
        if (null != this.operationWaybillAddrConsList && !operationWaybillAddrConsList.isEmpty()) {
            operationWaybillAddrCons = this.operationWaybillAddrConsList.get(0);
        }
        return operationWaybillAddrCons;
    }

    public List<OperationWaybillAddrCons> getOperationWaybillAddrConsList() {
        return operationWaybillAddrConsList;
    }

    public List<OperationWaybillMark> getOperationWaybillMarkList() {
        return operationWaybillMarkList;
    }

    public List<OperationWaybillFee> getOperationWaybillFeeList() {
        return operationWaybillFeeList;
    }

    public List<OperationWaybillAddition> getOperationWaybillAdditionList() {
        return operationWaybillAdditionList;
    }

    public OperationWaybillCustoms getOperationWaybillCustoms() {
        if (null != this.operationWaybillCustomsList && !this.operationWaybillCustomsList.isEmpty()) {
            operationWaybillCustoms = this.operationWaybillCustomsList.get(0);
        }
        return operationWaybillCustoms;
    }

    public List<OperationWaybillCustoms> getOperationWaybillCustomsList() {
        return operationWaybillCustomsList;
    }

    public List<OperationWaybillService> getOperationWaybillServiceList() {
        return operationWaybillServiceList;
    }

    public List<OperationWaybillPackage> getOperationWaybillPackageList() {
        return operationWaybillPackageList;
    }

    public void setOperationWaybillAddrCons(OperationWaybillAddrCons operationWaybillAddrCons) {

    }

    public void setOperationWaybillAddrConsList(List<OperationWaybillAddrCons> operationWaybillAddrConsList) {
        this.operationWaybillAddrConsList = operationWaybillAddrConsList;
    }

    public void setOperationWaybillMarkList(List<OperationWaybillMark> operationWaybillMarkList) {
        this.operationWaybillMarkList = operationWaybillMarkList;
    }

    public void setOperationWaybillFeeList(List<OperationWaybillFee> operationWaybillFeeList) {
        this.operationWaybillFeeList = operationWaybillFeeList;
    }

    public void setOperationWaybillAdditionList(List<OperationWaybillAddition> operationWaybillAdditionList) {
        this.operationWaybillAdditionList = operationWaybillAdditionList;
    }

    public void setOperationWaybillCustoms(OperationWaybillCustoms operationWaybillCustoms) {

    }

    public void setOperationWaybillCustomsList(List<OperationWaybillCustoms> operationWaybillCustomsList) {
        this.operationWaybillCustomsList = operationWaybillCustomsList;
    }

    public void setOperationWaybillServiceList(List<OperationWaybillService> operationWaybillServiceList) {
        this.operationWaybillServiceList = operationWaybillServiceList;
    }

    public void setOperationWaybillPackageList(List<OperationWaybillPackage> operationWaybillPackageList) {
        this.operationWaybillPackageList = operationWaybillPackageList;
    }

    public List<OperationWaybillAdditionExt> getOptWaybillAdditionExtList() {
        return optWaybillAdditionExtList;
    }

    public void setOptWaybillAdditionExtList(List<OperationWaybillAdditionExt> optWaybillAdditionExtList) {
        this.optWaybillAdditionExtList = optWaybillAdditionExtList;
    }

    public OperationTaxbillInfo getOperationTaxbillInfo() {
        if (null != this.operationTaxbillInfoList && !this.operationTaxbillInfoList.isEmpty()) {
            operationTaxbillInfo = this.operationTaxbillInfoList.get(0);
        }
        return operationTaxbillInfo;
    }
    
    public void setOperationTaxbillInfo(OperationTaxbillInfo operationTaxbillInfo) {

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

    public Double getMeterageWeightQty() {
        return meterageWeightQty;
    }

    public void setMeterageWeightQty(Double meterageWeightQty) {
        this.meterageWeightQty = meterageWeightQty;
    }

    public Double getRealWeightQty() {
        return realWeightQty;
    }

    public void setRealWeightQty(Double realWeightQty) {
        this.realWeightQty = realWeightQty;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getConsigneeEmpCode() {
        return consigneeEmpCode;
    }

    public void setConsigneeEmpCode(String consigneeEmpCode) {
        this.consigneeEmpCode = consigneeEmpCode;
    }

    public Date getConsignedTm() {
        return consignedTm;
    }

    public void setConsignedTm(Date consignedTm) {
        this.consignedTm = consignedTm;
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

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getBillLong() {
        return billLong;
    }

    public void setBillLong(Double billLong) {
        this.billLong = billLong;
    }

    public Double getBillWidth() {
        return billWidth;
    }

    public void setBillWidth(Double billWidth) {
        this.billWidth = billWidth;
    }

    public Double getBillHigh() {
        return billHigh;
    }

    public void setBillHigh(Double billHigh) {
        this.billHigh = billHigh;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    public Integer getLockVersionNo() {
        return lockVersionNo;
    }

    public void setLockVersionNo(Integer lockVersionNo) {
        this.lockVersionNo = lockVersionNo;
    }

    public String getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(String unitWeight) {
        this.unitWeight = unitWeight;
    }

    public Double getConsValue() {
        return consValue;
    }

    public void setConsValue(Double consValue) {
        this.consValue = consValue;
    }

    public String getConsValueCurrencyCode() {
        return consValueCurrencyCode;
    }

    public void setConsValueCurrencyCode(String consValueCurrencyCode) {
        this.consValueCurrencyCode = consValueCurrencyCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getWaybillRemark() {
        return waybillRemark;
    }

    public void setWaybillRemark(String waybillRemark) {
        this.waybillRemark = waybillRemark;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
    }

    public Date getExpectStartTm() {
        return expectStartTm;
    }

    public void setExpectStartTm(Date expectStartTm) {
        this.expectStartTm = expectStartTm;
    }

    public Date getExpectFinishTm() {
        return expectFinishTm;
    }

    public void setExpectFinishTm(Date expectFinishTm) {
        this.expectFinishTm = expectFinishTm;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Date getDynExpcDeliveryTm() {
        return dynExpcDeliveryTm;
    }

    public void setDynExpcDeliveryTm(Date dynExpcDeliveryTm) {
        this.dynExpcDeliveryTm = dynExpcDeliveryTm;
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

/*    
    public String getExtJson() {
        return extJson;
    }


    public void setExtJson(String extJson) {
    	if(StringUtil.isNotNil(extJson)) {
    		this.extJson = JsonUtil.json2Object(extJson, WaybillExtJson.class);
    	}
    }
    */

	
    public String getActionJson() {
        return actionJson;
    }

    public void setActionJson(String actionJson) {
        this.actionJson = actionJson;
    }

    public String getUpdateSource() {
        return updateSource;
    }

    public void setUpdateSource(String updateSource) {
        this.updateSource = updateSource;
    }

    public boolean isGenOrderFlag() {
        return genOrderFlag;
    }

    public void setGenOrderFlag(boolean genOrderFlag) {
        this.genOrderFlag = genOrderFlag;
    }

    @Override
    protected String getId() {
        return waybillId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((waybillId == null) ? 0 : waybillId.hashCode());
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
        OperationWaybillToRedis other = (OperationWaybillToRedis) obj;
        if (null == other)
            return false;
        if (waybillId == null) {
            if (other.waybillId != null)
                return false;
        } else if (!waybillId.equals(other.waybillId))
            return false;
        return true;
    }

    
    public String getInputerEmpCode() {
        return inputerEmpCode;
    }

    
    public void setInputerEmpCode(String inputerEmpCode) {
        this.inputerEmpCode = inputerEmpCode;
    }
    public List<OperationTaxbillInfo> getOperationTaxbillInfoList() {
        return operationTaxbillInfoList;
    }
    public void setOperationTaxbillInfoList(List<OperationTaxbillInfo> operationTaxbillInfoList) {
        this.operationTaxbillInfoList = operationTaxbillInfoList;
    }
    
    public String getDeliverEmpCode() {
        return deliverEmpCode;
    }

    public void setDeliverEmpCode(String deliverEmpCode) {
        this.deliverEmpCode = deliverEmpCode;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public Date getSigninTm() {
        return signinTm;
    }

    public void setSigninTm(Date signinTm) {
        this.signinTm = signinTm;
    }

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getDeliveredType() {
        return deliveredType;
    }

    public void setDeliveredType(String deliveredType) {
        this.deliveredType = deliveredType;
    }
	
    public String getCurrentSource() {
        return currentSource;
    }

    public void setCurrentSource(String currentSource) {
        this.currentSource = currentSource;
    }

    public String getBarOpCode() {
        return barOpCode;
    }

    public void setBarOpCode(String barOpCode) {
        this.barOpCode = barOpCode;
    }

    @Override
    public String toString() {
        return "OperationWaybill [waybillId=" + waybillId + ", waybillNo="
                + waybillNo + ", orderNo=" + orderNo + ", currentSource="
                + currentSource + "]";
    }

	
}