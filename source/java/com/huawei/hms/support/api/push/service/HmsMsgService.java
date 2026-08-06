package com.huawei.hms.support.api.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.push.C1213c;
import com.huawei.hms.push.C1219i;
import com.huawei.hms.push.C1233t;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HmsMsgService extends Service {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m2094c(Context context, Bundle bundle) {
        if (!C1219i.m1961a(context)) {
            HMSLog.m2120i("HmsMsgService", context.getPackageName() + " disable display notification.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        intent.putExtra("selfshow_info", C1213c.m1936a(bundle, "selfshow_info"));
        intent.putExtra("selfshow_token", C1213c.m1936a(bundle, "selfshow_token"));
        intent.setPackage(C1213c.m1938c(bundle, "push_package"));
        C1233t.m2038a(context, intent);
        HMSLog.m2120i("HmsMsgService", "invokeSelfShow done");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m2095d(Context context, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.push.intent.RECEIVE");
            intent.putExtra("msg_data", C1213c.m1936a(bundle, "msg_data"));
            intent.putExtra(RemoteMessageConst.DEVICE_TOKEN, C1213c.m1936a(bundle, RemoteMessageConst.DEVICE_TOKEN));
            intent.putExtra("msgIdStr", C1213c.m1938c(bundle, "msgIdStr"));
            intent.setFlags(32);
            intent.setPackage(C1213c.m1938c(bundle, "push_package"));
            context.sendBroadcast(intent, context.getPackageName() + ".permission.PROCESS_PUSH_MSG");
            HMSLog.m2120i("HmsMsgService", "send broadcast passby done");
        } catch (SecurityException unused) {
            HMSLog.m2120i("HmsMsgService", "send broadcast SecurityException");
        } catch (Exception unused2) {
            HMSLog.m2120i("HmsMsgService", "send broadcast Exception");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        HMSLog.m2120i("HmsMsgService", "onBind");
        return new Messenger(new HandlerC1255a(this)).getBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        HMSLog.m2120i("HmsMsgService", "Enter onStartCommand.");
        return 2;
    }

    /* renamed from: com.huawei.hms.support.api.push.service.HmsMsgService$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class HandlerC1255a extends Handler {

        /* renamed from: a */
        private Context f1802a;

        HandlerC1255a(Context context) {
            this.f1802a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            if (Objects.equals(this.f1802a.getApplicationContext().getPackageManager().getNameForUid(message.sendingUid), HMSPackageManager.getInstance(this.f1802a).getHMSPackageName()) && data != null && HMSPackageManager.getInstance(this.f1802a).getHMSPackageStates() == PackageManagerHelper.PackageStates.ENABLED) {
                if (HMSPackageManager.getInstance(this.f1802a).getHMSPackageStates() != PackageManagerHelper.PackageStates.ENABLED) {
                    HMSLog.m2120i("HmsMsgService", "service not start by hms");
                } else {
                    HMSLog.m2120i("HmsMsgService", "chose push type");
                    if (Objects.equals(C1213c.m1937b(data, "push_action"), "com.huawei.push.msg.NOTIFY_MSG")) {
                        if (ResourceLoaderUtil.getmContext() == null) {
                            ResourceLoaderUtil.setmContext(this.f1802a.getApplicationContext());
                        }
                        HMSLog.m2120i("HmsMsgService", "invokeSelfShow");
                        HmsMsgService.m2094c(this.f1802a, data);
                    } else if (Objects.equals(C1213c.m1937b(data, "push_action"), "com.huawei.push.msg.PASSBY_MSG")) {
                        HMSLog.m2120i("HmsMsgService", "sendBroadcastToHms");
                        HmsMsgService.m2095d(this.f1802a, data);
                    }
                }
            }
            super.handleMessage(message);
        }
    }
}
