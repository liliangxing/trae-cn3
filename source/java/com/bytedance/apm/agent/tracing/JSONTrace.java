package com.bytedance.apm.agent.tracing;

import com.bytedance.apm.agent.filter.ISendFilter;

/* loaded from: classes3.dex */
public class JSONTrace implements ISendFilter {
    @Override // com.bytedance.apm.agent.filter.ISendFilter
    public boolean isSend() {
        return false;
    }
}
