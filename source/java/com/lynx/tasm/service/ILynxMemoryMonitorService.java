package com.lynx.tasm.service;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface ILynxMemoryMonitorService extends IServiceProvider {
    void dumpMemoryAllocationReport(boolean z, JSONObject jSONObject);

    void reportMemoryUsage(LynxMemoryInfo lynxMemoryInfo);

    void startTrackMemoryAllocation(Context context);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxMemoryMonitorService.class;
    }
}
