package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.bytedance.trae.apm.impl.ILaunchTraceImpl;
import java.util.Map;

/* loaded from: classes5.dex */
public class ILaunchTrace__ServiceProxy implements IServiceProxy<ILaunchTrace> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ILaunchTrace newInstance() {
        return new ILaunchTraceImpl();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> map) {
        map.put("com.bytedance.services.apm.api.ILaunchTrace", "com.bytedance.trae.apm.impl.ILaunchTraceImpl");
    }
}
