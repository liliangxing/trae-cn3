package com.hihonor.push.sdk;

import android.content.Context;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HonorPushClient {

    /* renamed from: a */
    public static final HonorPushClient f678a = new HonorPushClient();

    public static HonorPushClient getInstance() {
        return f678a;
    }

    public boolean checkSupportHonorPush(Context context) {
        return C0937l.f734e.m775a(context);
    }

    public void deletePushToken(HonorPushCallback<Void> honorPushCallback) {
        C0937l c0937l = C0937l.f734e;
        c0937l.m774a(new RunnableC0925g(c0937l, honorPushCallback), honorPushCallback);
    }

    public void getNotificationCenterStatus(HonorPushCallback<Boolean> honorPushCallback) {
        C0937l c0937l = C0937l.f734e;
        c0937l.m774a(new RunnableC0928h(c0937l, honorPushCallback), honorPushCallback);
    }

    public void getPushToken(HonorPushCallback<String> honorPushCallback) {
        C0937l c0937l = C0937l.f734e;
        c0937l.m774a(new RunnableC0922f(c0937l, honorPushCallback, false), honorPushCallback);
    }

    public void getUnReadMessageBox(HonorPushCallback<List<HonorPushDataMsg>> honorPushCallback) {
        C0937l c0937l = C0937l.f734e;
        c0937l.m774a(new RunnableC0935k(c0937l, honorPushCallback), honorPushCallback);
    }

    public void init(Context context, boolean z) {
        C0937l c0937l = C0937l.f734e;
        C0958v c0958v = new C0958v();
        c0958v.f776a = context.getApplicationContext();
        c0958v.f777b = z;
        C0911b1.m753a(new RunnableC0919e(c0937l, c0958v));
    }

    public void turnOffNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        C0937l c0937l = C0937l.f734e;
        c0937l.m774a(new RunnableC0933j(c0937l, honorPushCallback), honorPushCallback);
    }

    public void turnOnNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        C0937l c0937l = C0937l.f734e;
        c0937l.m774a(new RunnableC0931i(c0937l, honorPushCallback), honorPushCallback);
    }
}
