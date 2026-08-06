package com.bytedance.sysoptimizer.anr;

import com.bytedance.sysoptimizer.anr.AnrManager;

/* loaded from: classes5.dex */
public interface AnrListener {
    void onAnrChange(boolean z, int i, AnrManager.AnrReason anrReason);
}
