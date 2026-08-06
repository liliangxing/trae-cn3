package com.bytedance.helios.statichook.lifecycle;

import android.app.Service;
import android.content.Intent;

/* loaded from: classes3.dex */
public interface ServiceLifecycleInvoker {
    void onStartCommand(Service service, Intent intent, int i, int i2);
}
