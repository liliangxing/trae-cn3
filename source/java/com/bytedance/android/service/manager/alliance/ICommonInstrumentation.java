package com.bytedance.android.service.manager.alliance;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;

/* loaded from: classes3.dex */
public interface ICommonInstrumentation {
    IBinder getBinder();

    int getStartInstrumentationFlag();

    void initInstrumentation();

    boolean startInstrumentation(ComponentName componentName, Bundle bundle);

    boolean startInstrumentation(ComponentName componentName, Bundle bundle, int i);
}
