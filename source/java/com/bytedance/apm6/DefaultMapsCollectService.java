package com.bytedance.apm6;

import com.bytedance.apm.npth.NpthUtil;
import com.bytedance.apm6.memory.IMapsCollectService;

/* loaded from: classes3.dex */
class DefaultMapsCollectService implements IMapsCollectService {
    @Override // com.bytedance.apm6.memory.IMapsCollectService
    public void stop() {
    }

    @Override // com.bytedance.apm6.memory.IMapsCollectService
    public void start() {
        NpthUtil.startMonitor();
    }
}
