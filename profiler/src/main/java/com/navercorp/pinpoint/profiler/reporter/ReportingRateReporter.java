package com.navercorp.pinpoint.profiler.reporter;

import com.navercorp.pinpoint.bootstrap.reporter.Reporter;
import com.navercorp.pinpoint.common.util.MathUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : cuipingping
 * create at:  2020/7/20
 * @description: 按比例上报采样数据
 */
public class ReportingRateReporter implements Reporter {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final int           reportingRate;

    public ReportingRateReporter(int reportingRate) {
        if (reportingRate <= 0) {
            throw new IllegalArgumentException("Invalid reportingRate " + reportingRate);
        }
        this.reportingRate = reportingRate;
    }

    @Override
    public boolean isReporting() {
        int reportingCount = MathUtils.fastAbs(counter.getAndIncrement());
        int isReporting = reportingCount % reportingRate;
        return isReporting == 0;
    }

    @Override
    public String toString() {
        return "ReportingRateReporter{" + "counter=" + counter + "reportingRate=" + reportingRate
               + '}';
    }
}
