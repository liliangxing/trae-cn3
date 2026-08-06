package com.bytedance.bdinstall.callback.event;

import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class Monitor {
    protected abstract JSONObject getEventParam();

    protected abstract void reset();

    public void onEvent(InstallOptions installOptions, String str) {
        JSONObject eventParam = getEventParam();
        if (installOptions == null || installOptions.getEventDepend() == null) {
            return;
        }
        installOptions.getEventDepend().onEvent(str, eventParam);
        if (!TextUtils.isEmpty(str)) {
            DrLog.d("EventTracking# " + str + installOptions.getAid() + ", " + eventParam);
        }
        reset();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DrLog.d("EventTracking# " + str + installOptions.getAid() + " reset.");
    }
}
