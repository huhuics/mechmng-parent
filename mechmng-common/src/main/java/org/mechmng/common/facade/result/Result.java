/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.common.facade.result;

import java.io.Serializable;
import java.util.Map;

/**
 * 结果类
 * @author HuHui
 * @version $Id: Result.java, v 0.1 2016年5月22日 上午12:35:42 HuHui Exp $
 */
public class Result<T> implements Serializable {

    /** uid */
    private static final long   serialVersionUID = -7226506032494666664L;

    /** 业务是否成功 */
    private boolean             success          = false;

    /** 结果对象 */
    private T                   resultObj;

    /** 错误扩展信息 */
    private Map<String, Object> errorInfo;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResultObj() {
        return resultObj;
    }

    public void setResultObj(T resultObj) {
        this.resultObj = resultObj;
    }

    public Map<String, Object> getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(Map<String, Object> errorInfo) {
        this.errorInfo = errorInfo;
    }

}
