package com.lynx.tasm.service;

import com.lynx.tasm.eventreport.ILynxEventReportObserver;
import com.lynx.tasm.performance.IPerformanceObserver;

/* loaded from: classes7.dex */
public interface ILynxEventReporterService extends IServiceProvider, ILynxEventReportObserver, IPerformanceObserver {
    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxEventReporterService.class;
    }
}
