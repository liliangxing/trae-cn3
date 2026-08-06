package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.tobshadow.applog.monitor.MonitorSampling;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.z2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0561z2 implements InterfaceC0526u2, Handler.Callback {

    /* renamed from: a */
    public Handler f1270a;

    /* renamed from: b */
    public final C0533v2 f1271b;

    /* renamed from: c */
    public final C0475n0 f1272c;

    public C0561z2(C0475n0 c0475n0) {
        Intrinsics.checkParameterIsNotNull(c0475n0, "mEngine");
        this.f1272c = c0475n0;
        StringBuilder m252a = C0380a.m252a("bd_tracker_monitor@");
        C0467m c0467m = c0475n0.f834d;
        Intrinsics.checkExpressionValueIsNotNull(c0467m, "mEngine.appLog");
        HandlerThread handlerThread = new HandlerThread(m252a.append(c0467m.f784m).toString());
        handlerThread.start();
        this.f1270a = new Handler(handlerThread.getLooper(), this);
        Looper looper = this.f1270a.getLooper();
        Intrinsics.checkExpressionValueIsNotNull(looper, "mHandler.looper");
        C0467m c0467m2 = c0475n0.f834d;
        Intrinsics.checkExpressionValueIsNotNull(c0467m2, "mEngine.appLog");
        String str = c0467m2.f784m;
        Intrinsics.checkExpressionValueIsNotNull(str, "mEngine.appLog.appId");
        Context m546b = c0475n0.m546b();
        Intrinsics.checkExpressionValueIsNotNull(m546b, "mEngine.context");
        this.f1271b = new C0533v2(looper, str, m546b);
    }

    /* renamed from: a */
    public void m763a(InterfaceC0400c3 interfaceC0400c3) {
        Intrinsics.checkParameterIsNotNull(interfaceC0400c3, "data");
        C0407d2 c0407d2 = this.f1272c.f835e;
        Intrinsics.checkExpressionValueIsNotNull(c0407d2, "mEngine.config");
        if (c0407d2.m324k()) {
            if (MonitorSampling.INSTANCE.isSampling$agent_liteChinaRelease()) {
                C0467m c0467m = this.f1272c.f834d;
                Intrinsics.checkExpressionValueIsNotNull(c0467m, "mEngine.appLog");
                c0467m.f764D.debug(8, "Monitor EventTrace hint trace:{}", interfaceC0400c3);
                this.f1271b.m717a(interfaceC0400c3).track(interfaceC0400c3.mo263g(), interfaceC0400c3.mo260d());
                return;
            }
            if ((interfaceC0400c3 instanceof C0464l3) || (interfaceC0400c3 instanceof C0422f3)) {
                this.f1271b.m717a(interfaceC0400c3).track(interfaceC0400c3.mo263g(), interfaceC0400c3.mo260d());
            }
            C0467m c0467m2 = this.f1272c.f834d;
            Intrinsics.checkExpressionValueIsNotNull(c0467m2, "mEngine.appLog");
            c0467m2.f764D.debug(8, "Monitor EventTrace not hint trace:{}", interfaceC0400c3);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Intrinsics.checkParameterIsNotNull(message, "msg");
        int i = message.what;
        if (i == 1) {
            C0467m c0467m = this.f1272c.f834d;
            Intrinsics.checkExpressionValueIsNotNull(c0467m, "mEngine.appLog");
            c0467m.f764D.debug(8, "Monitor trace save:{}", message.obj);
            C0521t4 m550c = this.f1272c.m550c();
            Object obj = message.obj;
            if (!TypeIntrinsics.isMutableList(obj)) {
                obj = null;
            }
            m550c.m702c((List<AbstractC0479n4>) obj);
        } else if (i == 2) {
            C0421f2 c0421f2 = this.f1272c.f839i;
            if (c0421f2 != null && c0421f2.m426i() != 0) {
                C0467m c0467m2 = this.f1272c.f834d;
                Intrinsics.checkExpressionValueIsNotNull(c0467m2, "mEngine.appLog");
                c0467m2.f764D.debug(8, "Monitor report...", new Object[0]);
                C0521t4 m550c2 = this.f1272c.m550c();
                C0467m c0467m3 = this.f1272c.f834d;
                Intrinsics.checkExpressionValueIsNotNull(c0467m3, "mEngine.appLog");
                m550c2.m696b(c0467m3.f784m, c0421f2.m420f());
                C0475n0 c0475n0 = this.f1272c;
                c0475n0.m537a(c0475n0.f842l);
            } else {
                this.f1270a.sendEmptyMessageDelayed(2, 500L);
            }
        }
        return true;
    }
}
