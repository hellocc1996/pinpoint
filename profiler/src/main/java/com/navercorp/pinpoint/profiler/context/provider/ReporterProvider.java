package com.navercorp.pinpoint.profiler.context.provider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.navercorp.pinpoint.bootstrap.config.ProfilerConfig;
import com.navercorp.pinpoint.bootstrap.reporter.Reporter;
import com.navercorp.pinpoint.profiler.reporter.ReporterFactory;

/**
 * @author : cuipingping
 * create at:  2020/7/20
 * @description: 采样数据上报提供类
 */
public class ReporterProvider implements Provider<Reporter> {

    private final ProfilerConfig profilerConfig;

    @Inject
    public ReporterProvider(ProfilerConfig profilerConfig) {
        this.profilerConfig = profilerConfig;
    }

    @Override
    public Reporter get() {
        int reportingRate = profilerConfig.getReportingRate();

        ReporterFactory reporterFactory = new ReporterFactory();
        return reporterFactory.createReporter(reportingRate);
    }
}
