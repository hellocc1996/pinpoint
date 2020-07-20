package com.navercorp.pinpoint.profiler.reporter;

import com.navercorp.pinpoint.bootstrap.reporter.Reporter;

/**
 * @author : cuipingping
 * create at:  2020/7/20
 * @description: 不上报采样数据
 */
public class FalseReporter implements Reporter {
    @Override
    public boolean isReporting() {
        return false;
    }

    @Override
    public String toString() {
        return "FalseReporter";
    }
}