package com.bytedance.helios.statichook.lifecycle;

import android.app.Activity;
import android.os.Bundle;

/* loaded from: classes3.dex */
public interface ActivityLifecycleInvoker {
    void onCreate(Activity activity, Bundle bundle);

    void onDestroy(Activity activity);

    void onPause(Activity activity);

    void onResume(Activity activity);

    void onStart(Activity activity);

    void onStop(Activity activity);
}
