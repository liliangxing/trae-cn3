package com.vivo.push.p017h;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.p010b.C1220q;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.AsyncTaskC1388o;
import com.vivo.push.util.C1374ai;
import com.vivo.push.util.C1379f;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.C1394u;
import com.vivo.push.util.C1397x;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* renamed from: com.vivo.push.h.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1296v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InsideNotificationItem f490a;

    /* renamed from: b */
    final /* synthetic */ C1220q f491b;

    /* renamed from: c */
    final /* synthetic */ boolean f492c;

    /* renamed from: d */
    final /* synthetic */ C1295u f493d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1296v(C1295u c1295u, InsideNotificationItem insideNotificationItem, C1220q c1220q, boolean z) {
        this.f493d = c1295u;
        this.f490a = insideNotificationItem;
        this.f491b = c1220q;
        this.f492c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        char c;
        Context context7;
        Context context8;
        Context context9;
        if (this.f490a.isNoShowOnForeground()) {
            C1393t.m1048d("OnNotificationArrivedTask", "msg " + this.f490a.getMsgId() + " no show on foreground");
            this.f493d.f454b.onForegroundMessageArrived(C1394u.m1051a(this.f490a));
            return;
        }
        if (this.f490a.isAppInstallCompleteMsg()) {
            C1393t.m1048d("OnNotificationArrivedTask", "msg " + this.f490a.getMsgId() + " notify app install");
            this.f493d.f454b.onAppInstallCompleteShowMsg(this.f490a.getThirdPackageName());
            return;
        }
        PushMessageCallback pushMessageCallback = this.f493d.f454b;
        context = this.f493d.f625a;
        NotifyArriveCallbackByUser onNotificationMessageArrived = pushMessageCallback.onNotificationMessageArrived(context, C1394u.m1051a(this.f490a));
        int m703a = this.f493d.m703a(onNotificationMessageArrived);
        if (m703a > 0) {
            C1379f.m995a(m703a, this.f493d.m704a(this.f491b.m632h()));
            return;
        }
        int m708b = this.f493d.m708b();
        if (m708b > 0) {
            StringBuilder sb = new StringBuilder("pkg name : ");
            context8 = this.f493d.f625a;
            C1393t.m1041b("OnNotificationArrivedTask", sb.append(context8.getPackageName()).append(" notify channel switch is ").append(m708b).toString());
            context9 = this.f493d.f625a;
            C1393t.m1043b(context9, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(m708b)));
            C1379f.m995a(m708b, this.f493d.m704a(this.f491b.m632h()));
            return;
        }
        if (!this.f492c || !this.f490a.isOperateMsg() || C1374ai.m968a().m969a(this.f490a.getWindowPeriod())) {
            context2 = this.f493d.f625a;
            InsideNotificationItem insideNotificationItem = this.f490a;
            long m632h = this.f491b.m632h();
            PushMessageCallback pushMessageCallback2 = this.f493d.f454b;
            context3 = this.f493d.f625a;
            AsyncTaskC1388o asyncTaskC1388o = new AsyncTaskC1388o(context2, insideNotificationItem, m632h, pushMessageCallback2.isAllowNet(context3), new C1297w(this), onNotificationMessageArrived);
            boolean isShowBigPicOnMobileNet = this.f490a.isShowBigPicOnMobileNet();
            String purePicUrl = this.f490a.getPurePicUrl();
            if (TextUtils.isEmpty(purePicUrl)) {
                purePicUrl = this.f490a.getCoverUrl();
            }
            if (!TextUtils.isEmpty(purePicUrl)) {
                C1393t.m1046c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
                if (!isShowBigPicOnMobileNet) {
                    context5 = this.f493d.f625a;
                    C1393t.m1038a(context5, "mobile net unshow");
                    context6 = this.f493d.f625a;
                    NetworkInfo m1056a = C1397x.m1056a(context6);
                    if (m1056a != null && m1056a.getState() == NetworkInfo.State.CONNECTED) {
                        int type = m1056a.getType();
                        c = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                    } else {
                        c = 0;
                    }
                    if (c == 1) {
                        this.f490a.clearCoverUrl();
                        this.f490a.clearPurePicUrl();
                        purePicUrl = null;
                    }
                } else {
                    context4 = this.f493d.f625a;
                    C1393t.m1038a(context4, "mobile net show");
                }
            }
            asyncTaskC1388o.execute(this.f490a.getIconUrl(), purePicUrl);
            return;
        }
        C1379f.m995a(1017L, this.f493d.m704a(this.f491b.m632h()));
        context7 = this.f493d.f625a;
        C1393t.m1043b(context7, "内部运营消息不在窗口期内，不做展示");
    }
}
