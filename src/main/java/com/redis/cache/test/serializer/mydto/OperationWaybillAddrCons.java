package com.redis.cache.test.serializer.mydto;

import java.util.Date;

/**
 * @description 操作类运单收寄件人信息
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybillAddrCons extends StringIdBean {

    private static final long serialVersionUID = 7808843078106556653L;
    /**
     * 收寄联系人ID
     */
    private String contactsId;
    /**
     * 寄件公司
     */
    private String consignorCompName;
    /**
     * 寄件地址
     */
    private String consignorAddr;
    /**
     * 寄件电话
     */
    private String consignorPhone;
    /**
     * 寄件联系人
     */
    private String consignorContName;
    /**
     * 寄件手机
     */
    private String consignorMobile;
    /**
     * 收件公司
     */
    private String addresseeCompName;
    /**
     * 收件地址
     */
    private String addresseeAddr;
    /**
     * 收件电话
     */
    private String addresseePhone;
    /**
     * 收件联系人
     */
    private String addresseeContName;
    /**
     * 收件手机
     */
    private String addresseeMobile;
    /**
     * 寄方客户编码
     */
    private String consignorAddrNative;
    /**
     * 收方客户编码
     */
    private String addresseeAddrNative;
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
     * 寄件城市代码
     */
    private String consignorCityCode;
    /**
     * 寄件网点代码
     */
    private String consignorDeptCode;
    /**
     * 寄件中转场代码
     */
    private String consignorTransitCode;
    /**
     * 寄件单元区域
     */
    private String consignorTeamCode;
    /**
     * 收件城市代码
     */
    private String addresseeCityCode;
    /**
     * 收件网点代码
     */
    private String addresseeDeptCode;
    /**
     * 收件中转场代码
     */
    private String addresseeTransitCode;
    /**
     * 收件单元区域
     */
    private String addresseeTeamCode;
    /**
     * 收件纠偏地址
     */
    private String addresseeRedressAddr;
    /**
     * 路由标签
     */
    private String routeLabel;
    /**
     * 取件码
     */
    private String pickUpCode;
    /**
     * 柜子地址
     */
    private String boxAddress;
    /**
     * 丰巢柜编码
     */
    private String boxCode;
    /** 
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    
    /** 英文寄件地址 */
	private String englishConsignorAddr;

	/** 英文寄件公司 */
	private String englishConsignorCompName;

	/** 英文寄件联系人 */
	private String englishConsignorContName;
	/**
	 * 寄件地区
	 */
	private String consignorAreaCode;
	/**
	 * 寄件经营本部
	 */
	private String consignorHqCode;
	/**
	 * 收件地区
	 */
	private String addresseeAreaCode;
	/**
	 * 收件经营本部
	 */
	private String addresseeHqCode;
    /**
     * 签回模板图片地址
     */
    private String signModePiclAddr;
 // 增加省、市、区和不拼接的详细地址，2018-11-20 V6.4
    /**
     * 寄件方所在省名称
     */
    private String senderProvince; 
    /**
     * 寄件方所属城市名称
     */
    private String senderCity; 
    /**
     * 寄件人所在县/区
     */
    private String senderArea; 
    /**
     * 寄件方详细地址(未拼接省市区) 
     */
    private String senderAddr; 
    /**
     * 到件方所在省份
     */
    private String receiverProvince;
    /**
     * 到件方所属城市名称
     */
    private String receiverCity; 
    /**
     * 到件人所在县/区
     */
    private String receiverArea;
    /**
     * 到件方详细地址(未拼接省市区) 
     */
    private String receiverAddr; 
    /**
     * 寄件国际电话区号
     */
    private String consignorNationalPhoneCode;
    /**
     * 收件国际电话区号
     */
    private String addresseeNationalPhoneCode;

    public String getContactsId() {
        return contactsId;
    }
    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }
    public String getConsignorCompName() {
        return consignorCompName;
    }
    public void setConsignorCompName(String consignorCompName) {
        this.consignorCompName = consignorCompName;
    }
    public String getConsignorAddr() {
        return consignorAddr;
    }
    public void setConsignorAddr(String consignorAddr) {
        this.consignorAddr = consignorAddr;
    }
    public String getConsignorPhone() {
        return consignorPhone;
    }
    public void setConsignorPhone(String consignorPhone) {
        this.consignorPhone = consignorPhone;
    }
    public String getConsignorContName() {
        return consignorContName;
    }
    public void setConsignorContName(String consignorContName) {
        this.consignorContName = consignorContName;
    }
    public String getConsignorMobile() {
        return consignorMobile;
    }
    public void setConsignorMobile(String consignorMobile) {
        this.consignorMobile = consignorMobile;
    }
    public String getAddresseeCompName() {
        return addresseeCompName;
    }
    public void setAddresseeCompName(String addresseeCompName) {
        this.addresseeCompName = addresseeCompName;
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
    public String getAddresseeContName() {
        return addresseeContName;
    }
    public void setAddresseeContName(String addresseeContName) {
        this.addresseeContName = addresseeContName;
    }
    public String getAddresseeMobile() {
        return addresseeMobile;
    }
    public void setAddresseeMobile(String addresseeMobile) {
        this.addresseeMobile = addresseeMobile;
    }
    public String getConsignorAddrNative() {
        return consignorAddrNative;
    }
    public void setConsignorAddrNative(String consignorAddrNative) {
        this.consignorAddrNative = consignorAddrNative;
    }
    public String getAddresseeAddrNative() {
        return addresseeAddrNative;
    }
    public void setAddresseeAddrNative(String addresseeAddrNative) {
        this.addresseeAddrNative = addresseeAddrNative;
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
    public String getConsignorCityCode() {
        return consignorCityCode;
    }
    public void setConsignorCityCode(String consignorCityCode) {
        this.consignorCityCode = consignorCityCode;
    }
    public String getConsignorDeptCode() {
        return consignorDeptCode;
    }
    public void setConsignorDeptCode(String consignorDeptCode) {
        this.consignorDeptCode = consignorDeptCode;
    }
    public String getConsignorTransitCode() {
        return consignorTransitCode;
    }
    public void setConsignorTransitCode(String consignorTransitCode) {
        this.consignorTransitCode = consignorTransitCode;
    }
    public String getConsignorTeamCode() {
        return consignorTeamCode;
    }
    public void setConsignorTeamCode(String consignorTeamCode) {
        this.consignorTeamCode = consignorTeamCode;
    }
    public String getAddresseeCityCode() {
        return addresseeCityCode;
    }
    public void setAddresseeCityCode(String addresseeCityCode) {
        this.addresseeCityCode = addresseeCityCode;
    }
    public String getAddresseeDeptCode() {
        return addresseeDeptCode;
    }
    public void setAddresseeDeptCode(String addresseeDeptCode) {
        this.addresseeDeptCode = addresseeDeptCode;
    }
    public String getAddresseeTransitCode() {
        return addresseeTransitCode;
    }
    public void setAddresseeTransitCode(String addresseeTransitCode) {
        this.addresseeTransitCode = addresseeTransitCode;
    }
    public String getAddresseeTeamCode() {
        return addresseeTeamCode;
    }
    public void setAddresseeTeamCode(String addresseeTeamCode) {
        this.addresseeTeamCode = addresseeTeamCode;
    }
    public String getAddresseeRedressAddr() {
        return addresseeRedressAddr;
    }
    public void setAddresseeRedressAddr(String addresseeRedressAddr) {
        this.addresseeRedressAddr = addresseeRedressAddr;
    }
    public String getRouteLabel() {
        return routeLabel;
    }
    public void setRouteLabel(String routeLabel) {
        this.routeLabel = routeLabel;
    }
    public String getPickUpCode() {
        return pickUpCode;
    }
    public void setPickUpCode(String pickUpCode) {
        this.pickUpCode = pickUpCode;
    }
    public String getBoxAddress() {
        return boxAddress;
    }
    public void setBoxAddress(String boxAddress) {
        this.boxAddress = boxAddress;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }
    @Override
    protected String getId() {
        return contactsId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((contactsId == null) ? 0 : contactsId.hashCode());
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
        OperationWaybillAddrCons other = (OperationWaybillAddrCons) obj;
        if (null == other)
            return false;
        if (contactsId == null) {
            if (other.contactsId != null)
                return false;
        } else if (!contactsId.equals(other.contactsId))
            return false;
        return true;
    }
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getEnglishConsignorAddr() {
		return englishConsignorAddr;
	}
	public void setEnglishConsignorAddr(String englishConsignorAddr) {
		this.englishConsignorAddr = englishConsignorAddr;
	}
	public String getEnglishConsignorCompName() {
		return englishConsignorCompName;
	}
	public void setEnglishConsignorCompName(String englishConsignorCompName) {
		this.englishConsignorCompName = englishConsignorCompName;
	}
	public String getEnglishConsignorContName() {
		return englishConsignorContName;
	}
	public void setEnglishConsignorContName(String englishConsignorContName) {
		this.englishConsignorContName = englishConsignorContName;
	}
	public String getConsignorAreaCode() {
		return consignorAreaCode;
	}
	public void setConsignorAreaCode(String consignorAreaCode) {
		this.consignorAreaCode = consignorAreaCode;
	}
	public String getConsignorHqCode() {
		return consignorHqCode;
	}
	public void setConsignorHqCode(String consignorHqCode) {
		this.consignorHqCode = consignorHqCode;
	}
	public String getAddresseeAreaCode() {
		return addresseeAreaCode;
	}
	public void setAddresseeAreaCode(String addresseeAreaCode) {
		this.addresseeAreaCode = addresseeAreaCode;
	}
	public String getAddresseeHqCode() {
		return addresseeHqCode;
	}
	public void setAddresseeHqCode(String addresseeHqCode) {
		this.addresseeHqCode = addresseeHqCode;
	}

    public String getSignModePiclAddr() {
        return signModePiclAddr;
    }

    public void setSignModePiclAddr(String signModePiclAddr) {
        this.signModePiclAddr = signModePiclAddr;
    }
	public String getSenderProvince() {
		return senderProvince;
	}
	public void setSenderProvince(String senderProvince) {
		this.senderProvince = senderProvince;
	}
	
	public String getSenderCity() {
		return senderCity;
	}
	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}
	public String getSenderArea() {
		return senderArea;
	}
	public void setSenderArea(String senderArea) {
		this.senderArea = senderArea;
	}
	public String getSenderAddr() {
		return senderAddr;
	}
	public void setSenderAddr(String senderAddr) {
		this.senderAddr = senderAddr;
	}
	public String getReceiverProvince() {
		return receiverProvince;
	}
	public void setReceiverProvince(String receiverProvince) {
		this.receiverProvince = receiverProvince;
	}
	public String getReceiverCity() {
		return receiverCity;
	}
	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}
	public String getReceiverArea() {
		return receiverArea;
	}
	public void setReceiverArea(String receiverArea) {
		this.receiverArea = receiverArea;
	}
	public String getReceiverAddr() {
		return receiverAddr;
	}
	public void setReceiverAddr(String receiveraddr) {
		this.receiverAddr = receiveraddr;
	}
    public String getConsignorNationalPhoneCode() {
        return consignorNationalPhoneCode;
    }
    public void setConsignorNationalPhoneCode(String consignorNationalPhoneCode) {
        this.consignorNationalPhoneCode = consignorNationalPhoneCode;
    }
    public String getAddresseeNationalPhoneCode() {
        return addresseeNationalPhoneCode;
    }
    public void setAddresseeNationalPhoneCode(String addresseeNationalPhoneCode) {
        this.addresseeNationalPhoneCode = addresseeNationalPhoneCode;
    }

}