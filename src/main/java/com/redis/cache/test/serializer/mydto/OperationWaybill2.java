package com.redis.cache.test.serializer.mydto;

/**
 * @description 操作类运单主表
 * 
 * HISTORY
 * ****************************************************************************
 *  ID   DATE            PERSON       REASON    
 *  1    2017年09月16日           01369587       Create   
 * ****************************************************************************
 */
public class OperationWaybill2 extends OperationWaybill {

    //private static final long serialVersionUID = 7590468961452993214L;
    /**
     * 新增字段
     */
    private String newFiled;

    public String getNewFiled() {
        return newFiled;
    }

    public void setNewFiled(String newFiled) {
        this.newFiled = newFiled;
    }
}