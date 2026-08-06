package com.bytedance.push.frontier.interfaze;

import android.content.Context;
import com.bytedance.push.Keep;

/* loaded from: classes4.dex */
public interface ISettingService extends Keep {
    void getFrontierSetting(Context context, OnFrontierSettingUpdateListener onFrontierSettingUpdateListener);
}
