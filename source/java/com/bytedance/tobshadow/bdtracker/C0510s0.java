package com.bytedance.tobshadow.bdtracker;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.IAppLogInstance;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.log.LogUtils;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.s0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0510s0 {

    /* renamed from: q */
    public static b f993q;

    /* renamed from: a */
    public long f994a;

    /* renamed from: b */
    public final C0475n0 f995b;

    /* renamed from: c */
    public C0549x4 f996c;

    /* renamed from: d */
    public C0549x4 f997d;

    /* renamed from: e */
    public volatile String f998e;

    /* renamed from: g */
    public volatile long f1000g;

    /* renamed from: h */
    public int f1001h;

    /* renamed from: j */
    public volatile boolean f1003j;

    /* renamed from: k */
    public long f1004k;

    /* renamed from: l */
    public int f1005l;

    /* renamed from: m */
    public String f1006m;

    /* renamed from: n */
    public volatile String f1007n;

    /* renamed from: f */
    public final AtomicLong f999f = new AtomicLong(1000);

    /* renamed from: i */
    public long f1002i = -1;

    /* renamed from: o */
    public volatile boolean f1008o = false;

    /* renamed from: p */
    public volatile boolean f1009p = false;

    /* renamed from: com.bytedance.tobshadow.bdtracker.s0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ C0467m f1010a;

        /* renamed from: b */
        public final /* synthetic */ boolean f1011b;

        /* renamed from: c */
        public final /* synthetic */ long f1012c;

        public a(C0467m c0467m, boolean z, long j) {
            this.f1010a = c0467m;
            this.f1011b = z;
            this.f1012c = j;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", this.f1010a.f784m);
                jSONObject.put("sessionId", C0510s0.this.f998e);
                boolean z = true;
                jSONObject.put("isBackground", !this.f1011b);
                if (this.f1012c == -1) {
                    z = false;
                }
                jSONObject.put("newLaunch", z);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.s0$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class b extends C0386a5 {
        public /* synthetic */ b(a aVar) {
        }
    }

    public C0510s0(C0475n0 c0475n0) {
        this.f995b = c0475n0;
    }

    /* renamed from: a */
    public static boolean m647a(AbstractC0479n4 abstractC0479n4) {
        if (abstractC0479n4 instanceof C0549x4) {
            return ((C0549x4) abstractC0479n4).m752k();
        }
        return false;
    }

    /* renamed from: a */
    public void m652a(AbstractC0479n4 abstractC0479n4, List<AbstractC0479n4> list, C0467m c0467m) {
        if (!(abstractC0479n4 instanceof C0549x4)) {
            if (abstractC0479n4 instanceof b) {
                return;
            }
            list.add(abstractC0479n4);
            return;
        }
        C0549x4 c0549x4 = (C0549x4) abstractC0479n4;
        if (c0549x4.m752k()) {
            this.f1004k = 0L;
            list.add(abstractC0479n4);
            if (TextUtils.isEmpty(c0549x4.f1242t)) {
                C0549x4 c0549x42 = this.f997d;
                if ((c0549x42 == null || (c0549x4.f872c - c0549x42.f872c) - c0549x42.f1241s >= 500) && ((c0549x42 = this.f996c) == null || (c0549x4.f872c - c0549x42.f872c) - c0549x42.f1241s >= 500)) {
                    return;
                }
                c0549x4.f1242t = c0549x42.f1243u;
                return;
            }
            return;
        }
        Bundle m648a = m648a(abstractC0479n4.f872c, 0L);
        if (c0467m != null && m648a != null) {
            c0467m.onEventV3("play_session", m648a, 1);
        }
        this.f1004k = c0549x4.f872c;
        list.add(abstractC0479n4);
        if (!c0549x4.f1239D) {
            this.f996c = c0549x4;
        } else {
            this.f997d = c0549x4;
            this.f996c = null;
        }
    }

    /* renamed from: a */
    public void m650a(IAppLogInstance iAppLogInstance, AbstractC0479n4 abstractC0479n4) {
        JSONObject jSONObject;
        if (abstractC0479n4 != null) {
            C0421f2 c0421f2 = this.f995b.f839i;
            abstractC0479n4.f882m = iAppLogInstance.getAppId();
            abstractC0479n4.f875f = this.f994a;
            abstractC0479n4.f876g = c0421f2.m431l();
            abstractC0479n4.f877h = c0421f2.m432m();
            abstractC0479n4.f878i = this.f995b.f828F ? "" : c0421f2.m428j();
            abstractC0479n4.f874e = this.f998e;
            abstractC0479n4.f873d = this.f999f.incrementAndGet();
            String str = abstractC0479n4.f879j;
            String m409b = c0421f2.m409b();
            if (TextUtils.isEmpty(str)) {
                str = m409b;
            } else if (!TextUtils.isEmpty(m409b)) {
                Set<String> m413c = c0421f2.m413c(m409b);
                m413c.addAll(c0421f2.m413c(str));
                str = c0421f2.m401a(m413c);
            }
            abstractC0479n4.f879j = str;
            abstractC0479n4.f880k = C0501q5.m623b(this.f995b.m546b(), true).f966a;
            if ((abstractC0479n4 instanceof C0528u4) && this.f1002i > 0 && C0411e.m362a(((C0528u4) abstractC0479n4).f1104u, "$crash") && (jSONObject = abstractC0479n4.f884o) != null) {
                try {
                    jSONObject.put("$session_duration", System.currentTimeMillis() - this.f1002i);
                } catch (Throwable unused) {
                }
            }
            this.f995b.f834d.f764D.debug("[event_process][fill] fillSessionParams data: {}", abstractC0479n4);
        }
    }

    /* renamed from: a */
    public synchronized Bundle m648a(long j, long j2) {
        Bundle bundle;
        long j3 = this.f1000g;
        if (this.f995b.f835e.f502c.isPlayEnable() && m653a() && j3 > 0) {
            long j4 = j - j3;
            if (j4 > j2) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.f1005l);
                int i = this.f1001h + 1;
                this.f1001h = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", j4 / 1000);
                bundle.putString("session_start_time", AbstractC0479n4.m568b(this.f1002i));
                this.f1000g = j;
            }
        }
        bundle = null;
        return bundle;
    }

    /* renamed from: a */
    public boolean m653a() {
        return this.f1003j && this.f1004k == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        if (r11.f1002i > (r13.f872c + 7200000)) goto L22;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m651a(C0467m c0467m, AbstractC0479n4 abstractC0479n4, List<AbstractC0479n4> list) {
        if (this.f995b.f835e.m323j()) {
            boolean z = false;
            boolean m752k = abstractC0479n4 instanceof C0549x4 ? ((C0549x4) abstractC0479n4).m752k() : false;
            if (this.f1002i != -1) {
                if (!this.f1003j && m752k) {
                    m649a(c0467m, abstractC0479n4, list, true);
                    z = true;
                    m650a(c0467m, abstractC0479n4);
                    this.f1009p = z;
                }
                long j = this.f1004k;
                if (j != 0 && abstractC0479n4.f872c > this.f995b.f835e.f505f.getLong("session_interval", 30000L) + j) {
                    this.f1008o = true;
                }
            }
            m649a(c0467m, abstractC0479n4, list, m752k);
            z = true;
            m650a(c0467m, abstractC0479n4);
            this.f1009p = z;
        }
    }

    /* renamed from: a */
    public synchronized C0535v4 m649a(C0467m c0467m, AbstractC0479n4 abstractC0479n4, List<AbstractC0479n4> list, boolean z) {
        C0535v4 c0535v4;
        long j = abstractC0479n4 instanceof b ? -1L : abstractC0479n4.f872c;
        this.f998e = UUID.randomUUID().toString();
        if (!LogUtils.isDisabled()) {
            LogUtils.sendJsonFetcher("session_start", new a(c0467m, z, j));
        }
        if (z && !this.f995b.f852v && TextUtils.isEmpty(this.f1007n)) {
            this.f1007n = this.f998e;
        }
        this.f999f.set(1000L);
        this.f1002i = j;
        this.f1003j = z;
        this.f1004k = 0L;
        this.f1000g = 0L;
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String sb = C0380a.m252a("").append(calendar.get(1)).append(calendar.get(2)).append(calendar.get(5)).toString();
            C0407d2 c0407d2 = this.f995b.f835e;
            if (TextUtils.isEmpty(this.f1006m)) {
                this.f1006m = c0407d2.f504e.getString("session_last_day", "");
                this.f1005l = c0407d2.f504e.getInt("session_order", 0);
            }
            if (sb.equals(this.f1006m)) {
                this.f1005l++;
            } else {
                this.f1006m = sb;
                this.f1005l = 1;
            }
            c0407d2.f504e.putString("session_last_day", sb).putInt("session_order", this.f1005l);
            this.f1001h = 0;
            this.f1000g = abstractC0479n4.f872c;
        }
        if (j != -1) {
            c0535v4 = new C0535v4();
            c0535v4.f882m = abstractC0479n4.f882m;
            c0535v4.f874e = this.f998e;
            c0535v4.f1137u = !this.f1003j;
            c0535v4.f873d = this.f999f.incrementAndGet();
            c0535v4.m573a(this.f1002i);
            c0535v4.f1136t = this.f995b.f839i.m434o();
            c0535v4.f1135s = this.f995b.f839i.m433n();
            c0535v4.f875f = this.f994a;
            c0535v4.f876g = this.f995b.f839i.m431l();
            c0535v4.f877h = this.f995b.f839i.m432m();
            c0535v4.f878i = c0467m.getSsid();
            c0535v4.f879j = c0467m.getAbSdkVersion();
            c0535v4.f1139w = z ? this.f995b.f835e.f505f.getInt("is_first_time_launch", 1) : 0;
            if (z && c0535v4.f1139w == 1) {
                this.f995b.f835e.f505f.putInt("is_first_time_launch", 0);
            }
            C0549x4 m279a = C0389b0.m279a();
            if (m279a != null) {
                c0535v4.f1141y = m279a.f1243u;
                c0535v4.f1140x = m279a.f1244v;
            }
            if ((abstractC0479n4 instanceof C0549x4) && m279a == null) {
                C0549x4 c0549x4 = (C0549x4) abstractC0479n4;
                c0535v4.f1141y = c0549x4.f1243u;
                c0535v4.f1140x = c0549x4.f1244v;
            }
            if (this.f1003j && this.f1008o) {
                c0535v4.f1142z = this.f1008o;
                this.f1008o = false;
            }
            this.f995b.f834d.f764D.debug("[event_process][fill] fillSessionParams launch: {}", c0535v4);
            list.add(c0535v4);
        } else {
            c0535v4 = null;
        }
        C0467m c0467m2 = this.f995b.f834d;
        if (c0467m2.f783l <= 0) {
            c0467m2.f783l = 6;
        }
        c0467m.f764D.debug("Start new session:{} with background:{}", this.f998e, Boolean.valueOf(!this.f1003j));
        return c0535v4;
    }
}
