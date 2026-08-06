package com.bytedance.common.push.interfaze;

import android.app.Activity;

/* loaded from: classes3.dex */
public interface IInstrumentationListener {
    boolean callActivityOnPause(Activity activity);

    boolean callActivityOnResume(Activity activity);

    boolean callActivityOnStop(Activity activity);
}
