package com.navercorp.pinpoint.profiler.reporter;

import com.navercorp.pinpoint.bootstrap.reporter.Reporter;

/**
 * @author : cuipingping
 * create at:  2020/7/20
 * @description: 全部上报采样数据
 */
public class TrueReporter implements Reporter {
    @Override
    public boolean isReporting() {
        return true;
    }

    @Override
    public String toString() {
        return "TrueReporter";
    }
}