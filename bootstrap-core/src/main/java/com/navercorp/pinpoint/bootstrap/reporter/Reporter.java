package com.navercorp.pinpoint.bootstrap.reporter;

/**
 * @author : cuipingping
 * create at:  2020/7/20
 * @description: 采样数据上报接口
 */
public interface Reporter {
    /**
     * 是否上报
     * @return boolean
     */
    boolean isReporting();
}
