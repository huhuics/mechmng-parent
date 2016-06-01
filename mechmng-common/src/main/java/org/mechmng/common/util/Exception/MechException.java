/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.common.util.Exception;

/**
 * 商户管理业务异常
 * @author HuHui
 * @version $Id: MechException.java, v 0.1 2016年6月1日 下午8:52:50 HuHui Exp $
 */
public class MechException extends RuntimeException {

    /** uid */
    private static final long serialVersionUID = 6092350223225195720L;

    public MechException() {
        super();
    }

    public MechException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MechException(String message, Throwable cause) {
        super(message, cause);
    }

    public MechException(String message) {
        super(message);
    }

    public MechException(Throwable cause) {
        super(cause);
    }

}
