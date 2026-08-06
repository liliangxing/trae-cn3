package com.bytedance.android.monitor.setting;

import android.content.Context;

/* loaded from: classes3.dex */
public interface ISettingManager {
    LynxSettingConfig getLynxConfig();

    WebSettingConfig getWebInfo();

    void init(Context context);

    void reset();
}
