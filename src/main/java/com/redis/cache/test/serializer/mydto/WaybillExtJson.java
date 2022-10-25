package com.redis.cache.test.serializer.mydto;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.util.Date;


/**
 * 
 * 描述：营运运单extJson保存格式实体
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    2018年5月18日      01369587         Create
 * ****************************************************************************
 * </pre>
 * 
 * @author 01369587
 * @since 1.0
 */
public class WaybillExtJson {

	private static final long serialVersionUID = -126239517938621002L;
	
	/**
     * 记录是否为试点网点
     */
    private boolean isPilotWaybill;
    /**
     * 记录54的inputTm时间
     */
    private Date sgsUploadTm;
    /**
     * wbep审核标记
     */
    private String wbepVersionNo;
    /**
     * 最后更新过操作运单的巴枪码
     */
    private String updateWaybillBarCode;
    /**
     * 自动确认运单的标识 
     */
    private String autoConfirmWaybillFlag;
    /**
     * 订单生成操作运单获取bsp模板的编码
     */
    private String orderTemplateCode;
    /**
     * 订单来源 
     */
    private String orderSysSource;
    /**
     *订单更新时间
     */
    private Date orderModifyTime;
    /**
     * 950巴枪的扫描时间
     */
    private Date bar950ScanTm;
    /**
     * 其他来源+订单生成操作运单时，记录取的订单是否为下call单 
     * V5.0 新增
     */
    private boolean isUnderCallOrder;
    /**
     * 根据订单生成或更新操作运单时，
     * 模板的属性Key为create_bill_trig的value是OK，
     * 在extJson字段中设置orderCreateTrig为1，否则设置为0，默认为-1
     */
    private Integer orderCreateTrig = -1;
    
    /******************************50巴枪取值字段***********************/
    /**
     * 50巴枪的扫描时间
     */
    private Date bar50ScanTm;
    /**
     * 50的巴枪来源
     */
    private String autoLoding;
    /**
     * 是否根据50巴枪更新费用付款方式结算方式月结卡号
     */
    private boolean isUpdatePayMethodBy50Bar=false;
    /**
     * 50付款方式
     */
    private String payFlg;
    /**
     * 50月结卡号
     */
    private String monthlyCard;
    /**
     * 是否50填充的报关批次
     */
    private boolean isBar50FillCustoms=false;
    /**
     * 50的自寄标识，扩展字段13的值,1标识有自寄，0表示删除自寄，默认-1表示50不处理这个标识
     */
    private int bar50SelfSendFlag=-1;
    /**
     * 是否50填充的目的地地址
     */
    private boolean isBar50FillAddresseeAddr=false;
    /**
     * 是否50填充的体积
     */
    private boolean isBar50FillVolume=false;
    /**
     * 50巴枪的状态,默认值-1
     */
    private int bar50Status=-1;
    
    /******************************50巴枪取值字段***********************/

    /**
     * SWS的版本号，丢弃乱序报文
     */
    private Integer swsVersionNo;
    /**
     * 是否通过订单更新扩展字段046，047
     */
    private boolean isExt046047UpdatedByOrder = false;
    
    /**
     * BMRS的安全码更新操作运单时间戳
     * BMRS系统会重复推送数据，用于过滤过期的数据
    */
    private long securityCodeTimestamp;
    
    /**
     * 接收系统控制点更新的当前版本号
     */
    private Integer scpVersion;
    
    /**
     * 标识数据库的重量来自50
     */
    private boolean from50Weight = false;
    /**
     * 巴枪209扫描时间
     */
    private Date bar209ScanTm;
    
    /**
     * 标识数据库的重量来自209
     */
    private boolean from209Weight = false;
    
    public WaybillExtJson() {
    	super();
    }
    
    /**
     * 【注意】此构造方法必须添加，上游的报文下发时可能extJson字段是个""空字符串
     * 没有此构造方法json转换会报错
     */
    public WaybillExtJson(String json) {
        if (!StringUtils.isEmpty(json)) {
    		JSON.parseObject(json, this.getClass());
    	}else {
    		new WaybillExtJson();
    	}
    }
    
    public boolean isFrom209Weight() {
        return from209Weight;
    }

    public void setFrom209Weight(boolean from209Weight) {
        this.from209Weight = from209Weight;
    }

    public Date getBar209ScanTm() {
        return bar209ScanTm;
    }

    public void setBar209ScanTm(Date bar209ScanTm) {
        this.bar209ScanTm = bar209ScanTm;
    }

    public boolean isFrom50Weight() {
        return from50Weight;
    }

    public void setFrom50Weight(boolean from50Weight) {
        this.from50Weight = from50Weight;
    }

    public Integer getScpVersion() {
        return scpVersion;
    }

    public void setScpVersion(Integer scpVersion) {
        this.scpVersion = scpVersion;
    }

    public boolean isBar50FillVolume() {
		return isBar50FillVolume;
	}

	public int getBar50Status() {
		return bar50Status;
	}

	public void setBar50Status(int bar50Status) {
		this.bar50Status = bar50Status;
	}

	public void setBar50FillVolume(boolean isBar50FillVolume) {
		this.isBar50FillVolume = isBar50FillVolume;
	}

	public boolean isBar50FillAddresseeAddr() {
		return isBar50FillAddresseeAddr;
	}

	public void setBar50FillAddresseeAddr(boolean isBar50FillAddresseeAddr) {
		this.isBar50FillAddresseeAddr = isBar50FillAddresseeAddr;
	}

	public boolean getIsPilotWaybill() {
        return isPilotWaybill;
    }

    public void setIsPilotWaybill(boolean isPilotWaybill) {
        this.isPilotWaybill = isPilotWaybill;
    }

    public Date getSgsUploadTm() {
        return sgsUploadTm;
    }

    public void setSgsUploadTm(Date sgsUploadTm) {
        this.sgsUploadTm = sgsUploadTm;
    }

	public String getWbepVersionNo() {
		return wbepVersionNo;
	}

	public void setWbepVersionNo(String wbepVersionNo) {
		this.wbepVersionNo = wbepVersionNo;
	}

	public Date getBar50ScanTm() {
		return bar50ScanTm;
	}

	public void setBar50ScanTm(Date bar50ScanTm) {
		this.bar50ScanTm = bar50ScanTm;
	}

	public String getUpdateWaybillBarCode() {
		return updateWaybillBarCode;
	}

	public void setUpdateWaybillBarCode(String updateWaybillBarCode) {
		this.updateWaybillBarCode = updateWaybillBarCode;
	}

	public String getAutoConfirmWaybillFlag() {
		return autoConfirmWaybillFlag;
	}

	public void setAutoConfirmWaybillFlag(String autoConfirmWaybillFlag) {
		this.autoConfirmWaybillFlag = autoConfirmWaybillFlag;
	}

	public String getOrderTemplateCode() {
		return orderTemplateCode;
	}

	public void setOrderTemplateCode(String orderTemplateCode) {
		this.orderTemplateCode = orderTemplateCode;
	}

	public String getOrderSysSource() {
		return orderSysSource;
	}

	public void setOrderSysSource(String orderSysSource) {
		this.orderSysSource = orderSysSource;
	}

	public void setPilotWaybill(boolean isPilotWaybill) {
		this.isPilotWaybill = isPilotWaybill;
	}

	public String getAutoLoding() {
		return autoLoding;
	}

	public void setAutoLoding(String autoLoding) {
		this.autoLoding = autoLoding;
	}

	public Date getBar950ScanTm() {
		return bar950ScanTm;
	}

	public void setBar950ScanTm(Date bar950ScanTm) {
		this.bar950ScanTm = bar950ScanTm;
	}

	public boolean isUpdatePayMethodBy50Bar() {
		return isUpdatePayMethodBy50Bar;
	}

	public void setUpdatePayMethodBy50Bar(boolean isUpdatePayMethodBy50Bar) {
		this.isUpdatePayMethodBy50Bar = isUpdatePayMethodBy50Bar;
	}

	public String getPayFlg() {
		return payFlg;
	}

	public void setPayFlg(String payFlg) {
		this.payFlg = payFlg;
	}

	public String getMonthlyCard() {
		return monthlyCard;
	}

	public void setMonthlyCard(String monthlyCard) {
		this.monthlyCard = monthlyCard;
	}

    public boolean isUnderCallOrder() {
        return isUnderCallOrder;
    }

    public void setUnderCallOrder(boolean isUnderCallOrder) {
        this.isUnderCallOrder = isUnderCallOrder;
    }

	public boolean isBar50FillCustoms() {
		return isBar50FillCustoms;
	}

	public void setBar50FillCustoms(boolean isBar50FillCustoms) {
		this.isBar50FillCustoms = isBar50FillCustoms;
	}

	public int getBar50SelfSendFlag() {
		return bar50SelfSendFlag;
	}

	public void setBar50SelfSendFlag(int bar50SelfSendFlag) {
		this.bar50SelfSendFlag = bar50SelfSendFlag;
	}
    public Integer getOrderCreateTrig() {
        return orderCreateTrig;
    }

    public void setOrderCreateTrig(Integer orderCreateTrig) {
        this.orderCreateTrig = orderCreateTrig;
    }

	public Date getOrderModifyTime() {
		return orderModifyTime;
	}

	public void setOrderModifyTime(Date orderModifyTime) {
		this.orderModifyTime = orderModifyTime;
	}

    
    public Integer getSwsVersionNo() {
        return swsVersionNo;
    }

    public void setSwsVersionNo(Integer swsVersionNo) {
        this.swsVersionNo = swsVersionNo;
    }

	public boolean isExt046047UpdatedByOrder() {
		return isExt046047UpdatedByOrder;
	}

	public void setExt046047UpdatedByOrder(boolean isExt046047UpdatedByOrder) {
		this.isExt046047UpdatedByOrder = isExt046047UpdatedByOrder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    public long getSecurityCodeTimestamp() {
        return securityCodeTimestamp;
    }

    public void setSecurityCodeTimestamp(long securityCodeTimestamp) {
        this.securityCodeTimestamp = securityCodeTimestamp;
    }

}
