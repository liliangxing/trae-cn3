package com.ss.android.common.applog;

import android.content.Context;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.applog.util.IEventsSender;
import com.ss.android.deviceregister.DeviceRegisterManager;
import java.util.List;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class EventVerifyBdtracker implements IEventsSender {
    public void putEvent(String str, JSONArray jSONArray) {
        EventsSenderUtils.putEvent(String.valueOf(DeviceRegisterManager.getAppId()), str, jSONArray);
    }

    public boolean isEnable() {
        return EventsSenderUtils.isEnable(String.valueOf(DeviceRegisterManager.getAppId()));
    }

    public void setEventVerifyUrl(String str) {
        EventsSenderUtils.setEventVerifyHost(String.valueOf(DeviceRegisterManager.getAppId()), str);
    }

    public void setEnable(boolean z, Context context) {
        EventsSenderUtils.setEventsSenderEnable(String.valueOf(DeviceRegisterManager.getAppId()), z, context);
    }

    public void loginEtWithScheme(String str, Context context) {
        EventsSenderUtils.loginEtWithScheme(String.valueOf(DeviceRegisterManager.getAppId()), str, context);
    }

    public void setEventVerifyInterval(long j) {
        EventsSenderUtils.setEventVerifyInterval(String.valueOf(DeviceRegisterManager.getAppId()), j);
    }

    public void setSpecialKeys(List<String> list) {
        EventsSenderUtils.setSpecialKeys(String.valueOf(DeviceRegisterManager.getAppId()), list);
    }
}
