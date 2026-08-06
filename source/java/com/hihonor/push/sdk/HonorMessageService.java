package com.hihonor.push.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.sdk.common.data.DownMsgType;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class HonorMessageService extends Service {

    /* renamed from: c */
    public static final /* synthetic */ int f674c = 0;

    /* renamed from: a */
    public final HandlerC0904a f675a;

    /* renamed from: b */
    public final Messenger f676b;

    /* renamed from: com.hihonor.push.sdk.HonorMessageService$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class HandlerC0904a extends Handler {

        /* renamed from: a */
        public final WeakReference<HonorMessageService> f677a;

        public HandlerC0904a(Looper looper, HonorMessageService honorMessageService) {
            super(looper);
            this.f677a = new WeakReference<>(honorMessageService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HonorMessageService honorMessageService = this.f677a.get();
            if (honorMessageService == null) {
                Log.w("HonorMessageService", "service is null for release");
                return;
            }
            Log.i("HonorMessageService", "handle message for broadcast.");
            Bundle data = message.getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtras(data);
                int i = HonorMessageService.f674c;
                honorMessageService.m730a(intent);
            }
        }
    }

    public HonorMessageService() {
        HandlerC0904a handlerC0904a = new HandlerC0904a(Looper.getMainLooper(), this);
        this.f675a = handlerC0904a;
        this.f676b = new Messenger(handlerC0904a);
    }

    /* renamed from: a */
    public final void m730a(Intent intent) {
        try {
            if (TextUtils.equals(intent.getStringExtra("event_type"), DownMsgType.RECEIVE_TOKEN)) {
                String stringExtra = intent.getStringExtra("push_token");
                Context m773a = C0937l.f734e.m773a();
                C0916d c0916d = C0916d.f695b;
                if (!TextUtils.equals(stringExtra, c0916d.m761b(m773a))) {
                    c0916d.m760a(m773a, stringExtra);
                }
                Log.i("HonorMessageService", "onNewToken");
                onNewToken(stringExtra);
            } else {
                Log.i("HonorMessageService", "parse remote data start.");
                C0908a1 m740a = C0909b.m740a(new CallableC0949q0(intent));
                C0906a c0906a = new C0906a(this);
                m740a.getClass();
                m740a.m733a(new C0955t0(C0945o0.f747c.f748a, c0906a));
            }
            Log.i("HonorMessageService", "dispatch message end.");
        } catch (Exception e) {
            String str = "dispatch message error. " + e.getMessage();
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f676b.getBinder();
    }

    public void onMessageReceived(HonorPushDataMsg honorPushDataMsg) {
    }

    public void onNewToken(String str) {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        Log.i("HonorMessageService", "handle message for service.");
        m730a(intent);
        return 2;
    }
}
