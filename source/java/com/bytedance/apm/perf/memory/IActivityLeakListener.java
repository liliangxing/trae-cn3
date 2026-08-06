package com.bytedance.apm.perf.memory;

import android.app.Activity;

/* loaded from: classes3.dex */
public interface IActivityLeakListener {
    void onActivityLeaked(Activity activity);
}
