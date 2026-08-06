package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.push.C1219i;
import com.huawei.hms.push.C1233t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PushMsgReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static void m2083a(Context context, Intent intent) {
        if (intent.hasExtra("selfshow_info")) {
            if (!C1219i.m1961a(context)) {
                HMSLog.m2120i("PushMsgReceiver", context.getPackageName() + " disable display notification.");
                if (!intent.hasExtra("selfshow_event_id")) {
                    return;
                }
            }
            C1233t.m2038a(context, intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        HMSLog.m2120i("PushMsgReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
        try {
            intent.getStringExtra("TestIntent");
            String action = intent.getAction();
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if (!"com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action) && (!"com.huawei.intent.action.PUSH".equals(action) || HwBuildEx.VERSION.EMUI_SDK_INT >= 10)) {
                HMSLog.m2120i("PushMsgReceiver", "message can't be recognised.");
            } else {
                m2083a(context, intent);
            }
        } catch (Exception unused) {
            HMSLog.m2118e("PushMsgReceiver", "intent has some error");
        }
    }
}
