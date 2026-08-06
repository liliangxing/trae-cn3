package com.hihonor.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CallableC0939m implements Callable<String> {

    /* renamed from: a */
    public final /* synthetic */ boolean f742a;

    /* renamed from: b */
    public final /* synthetic */ C0952s f743b;

    public CallableC0939m(C0952s c0952s, boolean z) {
        this.f743b = c0952s;
        this.f742a = z;
    }

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        this.f743b.f760b.getClass();
        try {
            C0921e1 c0921e1 = new C0921e1(UpMsgType.REQUEST_PUSH_TOKEN, null);
            c0921e1.f715e = C0909b.m739a();
            String pushToken = ((PushTokenResult) C0909b.m743a(C0966z.f792c.m783a(c0921e1))).getPushToken();
            if (this.f742a) {
                C0952s c0952s = this.f743b;
                c0952s.getClass();
                if (!TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("event_type", DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    ServiceConnectionC0926g0 serviceConnectionC0926g0 = new ServiceConnectionC0926g0();
                    Context context = c0952s.f759a;
                    Log.i("MessengerSrvConnection", "start bind service.");
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        serviceConnectionC0926g0.f720c = applicationContext;
                        serviceConnectionC0926g0.f719b = bundle;
                        if (applicationContext.bindService(intent, serviceConnectionC0926g0, 1)) {
                            Log.i("MessengerSrvConnection", "bind service succeeded.");
                        }
                    } catch (Exception e) {
                        String str = "bind service failed." + e.getMessage();
                    }
                }
            }
            return pushToken;
        } catch (Exception e2) {
            throw C0909b.m742a(e2);
        }
    }
}
