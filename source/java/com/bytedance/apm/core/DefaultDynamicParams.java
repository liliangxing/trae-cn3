package com.bytedance.apm.core;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultDynamicParams implements IDynamicParams {
    @Override // com.bytedance.apm.core.IDynamicParams
    public String getSessionId() {
        return null;
    }

    @Override // com.bytedance.apm.core.IDynamicParams
    public long getUid() {
        return 0L;
    }

    @Override // com.bytedance.apm.core.IDynamicParams
    public Map<String, String> getCommonParams() {
        return Collections.emptyMap();
    }
}
