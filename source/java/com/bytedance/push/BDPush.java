package com.bytedance.push;

import android.app.Application;
import android.content.Context;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.interfaze.ISettings;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.setting.PushSetting;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BDPush implements Keep {
    private static final IPushService sPushService = new PushImpl();

    public static IPushService getPushService() {
        return sPushService;
    }

    public static ISettings getSetting(Context context) {
        AppProvider.initApp((Application) context.getApplicationContext());
        return PushSetting.getInstance();
    }
}
