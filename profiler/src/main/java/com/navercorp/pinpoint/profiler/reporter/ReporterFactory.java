package com.navercorp.pinpoint.profiler.reporter;

import com.navercorp.pinpoint.bootstrap.reporter.Reporter;

/**
 * @author : cuipingping
 * create at:  2020/7/20
 * @description: 采样数据上报实现工厂
 */
public class ReporterFactory {
    public Reporter createReporter(int reportingRate) {
        if (reportingRate <= 0) {
            return new FalseReporter();
        }
        if (reportingRate == 1) {
            return new TrueReporter();
        }
        return new ReportingRateReporter(reportingRate);
    }
}
