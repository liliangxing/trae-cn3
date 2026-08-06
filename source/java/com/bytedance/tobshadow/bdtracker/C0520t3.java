package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.sdk.account.bdplatform.model.BDPlatformConstants;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.tobshadow.applog.IDataObserver;
import com.bytedance.tobshadow.applog.ISessionObserver;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000 Y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001YB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0002J\u0012\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020\u0007H\u0002J\b\u0010+\u001a\u00020\u0013H\u0002J!\u0010,\u001a\u00020'2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130.\"\u00020\u0013H\u0002¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0016J \u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0016J\u0018\u00107\u001a\u00020'2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0013H\u0016J\u001a\u0010;\u001a\u00020'2\u0006\u00108\u001a\u0002092\b\u0010<\u001a\u0004\u0018\u00010\u0013H\u0016JB\u0010=\u001a\u00020'2\u0006\u00108\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0016J\"\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00072\b\u0010H\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010I\u001a\u00020'2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0007H\u0016J\"\u0010J\u001a\u00020'2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00072\b\u0010H\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010K\u001a\u00020'H\u0002J\b\u0010L\u001a\u00020'H\u0002J\b\u0010M\u001a\u00020'H\u0002J\b\u0010N\u001a\u00020'H\u0016J\b\u0010O\u001a\u00020'H\u0016J\u0018\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0007H\u0016J#\u0010T\u001a\u00020'\"\u0004\b\u0000\u0010U2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u0002HUH\u0016¢\u0006\u0002\u0010XR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010 \u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$¨\u0006Z"}, d2 = {"Lcom/bytedance/tobshadow/applog/monitor/v2/MonitorV2Record;", "Lcom/bytedance/tobshadow/applog/monitor/v2/IMonitorV2Record;", "Lcom/bytedance/tobshadow/applog/IDataObserver;", "Lcom/bytedance/tobshadow/applog/ISessionObserver;", "applog", "Lcom/bytedance/tobshadow/applog/AppLogInstance;", "observeAppId", "", "sendUrl", "(Lcom/bytedance/tobshadow/applog/AppLogInstance;Ljava/lang/String;Ljava/lang/String;)V", "getApplog", "()Lcom/bytedance/tobshadow/applog/AppLogInstance;", "exceptionTrace", "Lcom/bytedance/tobshadow/applog/monitor/v2/ExceptionTrace;", "getExceptionTrace", "()Lcom/bytedance/tobshadow/applog/monitor/v2/ExceptionTrace;", "exceptionTrace$delegate", "Lkotlin/Lazy;", "header", "Lorg/json/JSONObject;", "getHeader", "()Lorg/json/JSONObject;", "header$delegate", "networkTrace", "Lcom/bytedance/tobshadow/applog/monitor/v2/NetworkTrace;", "getNetworkTrace", "()Lcom/bytedance/tobshadow/applog/monitor/v2/NetworkTrace;", "networkTrace$delegate", "sdkInitTrace", "Lcom/bytedance/tobshadow/applog/monitor/v2/SDKInitTrace;", "task", "Ljava/util/concurrent/ScheduledFuture;", "threadPool", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "getThreadPool", "()Ljava/util/concurrent/ScheduledExecutorService;", "threadPool$delegate", "endRecord", "", "endRecordExceptionTrace", "endRecordInitTrace", "failed", "endRecordNetworkTrace", "flushTrace", "jsons", "", "([Lorg/json/JSONObject;)V", "onAbVidsChange", "vids", "extVids", "onIdLoaded", "did", "iid", "ssid", "onRemoteAbConfigGet", "changed", "", "abConfig", "onRemoteConfigGet", "config", "onRemoteIdGet", "oldDid", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "onSessionBatchEvent", "id", "", "sessionId", "appLog", "onSessionStart", "onSessionTerminate", "startRecord", "startRecordExceptionTrace", "startRecordInitTrace", "startRecordNetworkTrace", "stopRecord", "updateExceptionTrace", "t", "", "tag", "updateNetworkTrace", "T", "key", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.t3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0520t3 implements InterfaceC0506r3, IDataObserver, ISessionObserver {

    /* renamed from: k */
    public static final String f1054k;

    /* renamed from: a */
    public C0541w3 f1056a;

    /* renamed from: b */
    public final Lazy f1057b;

    /* renamed from: c */
    public final Lazy f1058c;

    /* renamed from: d */
    public final Lazy f1059d;

    /* renamed from: e */
    public final Lazy f1060e;

    /* renamed from: f */
    public ScheduledFuture<?> f1061f;

    /* renamed from: g */
    public final C0467m f1062g;

    /* renamed from: h */
    public final String f1063h;

    /* renamed from: i */
    public final String f1064i;

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f1053j = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0520t3.class), "networkTrace", "getNetworkTrace()Lcom/bytedance/tobshadow/applog/monitor/v2/NetworkTrace;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0520t3.class), "exceptionTrace", "getExceptionTrace()Lcom/bytedance/tobshadow/applog/monitor/v2/ExceptionTrace;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0520t3.class), "threadPool", "getThreadPool()Ljava/util/concurrent/ScheduledExecutorService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0520t3.class), "header", "getHeader()Lorg/json/JSONObject;"))};

    /* renamed from: l */
    public static final a f1055l = new a(null);

    /* renamed from: com.bytedance.tobshadow.bdtracker.t3$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final String m679a() {
            return C0520t3.f1054k;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.t3$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class b extends Lambda implements Function0<C0499q3> {
        public b() {
            super(0);
        }

        public Object invoke() {
            return new C0499q3(C0520t3.this.f1062g);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.t3$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class c extends Lambda implements Function0<JSONObject> {
        public c() {
            super(0);
        }

        public Object invoke() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constant.KEY_AID, C0520t3.this.f1063h);
            jSONObject.put("sdk_lib", SiteMessageParams.platform);
            C0520t3.this.f1062g.getSdkVersion();
            jSONObject.put(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, "6.17.11-tobshadow");
            jSONObject.put("user_unique_id", "sdk_solid_user_" + Random.Default.nextInt(1, 1001));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("runtime_id", C0520t3.f1055l.m679a());
            jSONObject2.put("client_uuid", C0520t3.this.f1062g.getUserUniqueID());
            jSONObject2.put("client_appid", C0520t3.this.f1062g.f784m);
            jSONObject.put("custom", jSONObject2);
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.t3$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class d extends Lambda implements Function0<C0534v3> {
        public d() {
            super(0);
        }

        public Object invoke() {
            return new C0534v3(C0520t3.this.f1062g);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.t3$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0520t3.this.mo637a();
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.t3$f */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class f extends Lambda implements Function0<ScheduledExecutorService> {

        /* renamed from: a */
        public static final f f1069a = new f();

        public f() {
            super(0);
        }

        public Object invoke() {
            return Executors.newScheduledThreadPool(1);
        }
    }

    static {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        f1054k = uuid;
    }

    public C0520t3(C0467m c0467m, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(c0467m, "applog");
        Intrinsics.checkParameterIsNotNull(str, "observeAppId");
        Intrinsics.checkParameterIsNotNull(str2, "sendUrl");
        this.f1062g = c0467m;
        this.f1063h = str;
        this.f1064i = str2;
        this.f1057b = LazyKt.lazy(new d());
        this.f1058c = LazyKt.lazy(new b());
        this.f1059d = LazyKt.lazy(f.f1069a);
        this.f1060e = LazyKt.lazy(new c());
        try {
            c0467m.addDataObserver(this);
            c0467m.addSessionHook(this);
            C0541w3 c0541w3 = new C0541w3(c0467m);
            c0541w3.mo592d();
            this.f1056a = c0541w3;
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0506r3
    /* renamed from: a */
    public void mo637a() {
        C0467m c0467m = this.f1062g;
        try {
            JSONObject[] jSONObjectArr = new JSONObject[2];
            jSONObjectArr[0] = m675b();
            m676c().mo590b();
            JSONObject m591c = m676c().m591c();
            C0499q3 m676c = m676c();
            C0467m c0467m2 = m676c.f894d;
            try {
                m676c.f946e.set(0);
                m676c.f947f.clear();
                m676c.f893c = false;
            } catch (Throwable th) {
                c0467m2.f764D.error(7, "Run task failed", th, new Object[0]);
            }
            jSONObjectArr[1] = m591c;
            m674a(jSONObjectArr);
            m678e();
        } catch (Throwable th2) {
            c0467m.f764D.error(7, "Run task failed", th2, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0506r3
    /* renamed from: a */
    public <T> void mo638a(String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        m677d().m719a(str, t);
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0506r3
    /* renamed from: a */
    public void mo639a(Throwable th, String str) {
        Intrinsics.checkParameterIsNotNull(th, "t");
        Intrinsics.checkParameterIsNotNull(str, "tag");
        m676c().m619a(th, str);
    }

    /* renamed from: b */
    public final JSONObject m675b() {
        m677d().mo590b();
        JSONObject m591c = m677d().m591c();
        C0534v3 m677d = m677d();
        C0467m c0467m = m677d.f894d;
        try {
            m677d.f893c = false;
            m677d.f1133o.addAndGet(m677d.f1128j.get());
            m677d.f1132n.incrementAndGet();
            m677d.f1123e.set(0);
            m677d.f1124f.set(0);
            m677d.f1125g.set(0);
            m677d.f1126h.set(0);
            m677d.f1127i.set(0);
            m677d.f1128j.set(0);
            m677d.f1132n.set(0);
            m677d.f1129k.set(0);
            m677d.f1130l.set(0);
            m677d.f1131m.set(0);
            m677d.f1134p.clear();
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
        return m591c;
    }

    /* renamed from: c */
    public final C0499q3 m676c() {
        Lazy lazy = this.f1058c;
        KProperty kProperty = f1053j[1];
        return (C0499q3) lazy.getValue();
    }

    /* renamed from: d */
    public final C0534v3 m677d() {
        Lazy lazy = this.f1057b;
        KProperty kProperty = f1053j[0];
        return (C0534v3) lazy.getValue();
    }

    /* renamed from: e */
    public final void m678e() {
        C0467m c0467m = this.f1062g;
        try {
            ScheduledFuture<?> scheduledFuture = this.f1061f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            m677d().mo592d();
            m676c().mo592d();
            Lazy lazy = this.f1059d;
            KProperty kProperty = f1053j[2];
            this.f1061f = ((ScheduledExecutorService) lazy.getValue()).schedule(new e(), 2L, TimeUnit.MINUTES);
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IDataObserver
    public void onAbVidsChange(String vids, String extVids) {
        Intrinsics.checkParameterIsNotNull(vids, "vids");
        Intrinsics.checkParameterIsNotNull(extVids, "extVids");
    }

    @Override // com.bytedance.tobshadow.applog.IDataObserver
    public void onIdLoaded(String did, String iid, String ssid) {
        Intrinsics.checkParameterIsNotNull(did, "did");
        Intrinsics.checkParameterIsNotNull(iid, "iid");
        Intrinsics.checkParameterIsNotNull(ssid, "ssid");
        C0467m c0467m = this.f1062g;
        try {
            if (!TextUtils.isEmpty(did) && !TextUtils.isEmpty(ssid)) {
                JSONObject[] jSONObjectArr = new JSONObject[1];
                jSONObjectArr[0] = m673a("");
                m674a(jSONObjectArr);
                C0497q1 c0497q1 = this.f1062g.f796y;
                if (c0497q1 != null) {
                    c0497q1.m617b(this);
                }
            }
            m678e();
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IDataObserver
    public void onRemoteAbConfigGet(boolean changed, JSONObject abConfig) {
        Intrinsics.checkParameterIsNotNull(abConfig, "abConfig");
    }

    @Override // com.bytedance.tobshadow.applog.IDataObserver
    public void onRemoteConfigGet(boolean changed, JSONObject config) {
    }

    @Override // com.bytedance.tobshadow.applog.IDataObserver
    public void onRemoteIdGet(boolean changed, String oldDid, String newDid, String oldIid, String newIid, String oldSsid, String newSsid) {
        Intrinsics.checkParameterIsNotNull(newDid, "newDid");
        Intrinsics.checkParameterIsNotNull(oldIid, "oldIid");
        Intrinsics.checkParameterIsNotNull(newIid, "newIid");
        Intrinsics.checkParameterIsNotNull(oldSsid, "oldSsid");
        Intrinsics.checkParameterIsNotNull(newSsid, "newSsid");
        C0467m c0467m = this.f1062g;
        try {
            if (TextUtils.isEmpty(newDid) || TextUtils.isEmpty(newSsid)) {
                m674a(m673a("device register failed, did: " + newDid + ", ssid: " + newSsid));
            } else {
                JSONObject[] jSONObjectArr = new JSONObject[1];
                jSONObjectArr[0] = m673a("");
                m674a(jSONObjectArr);
            }
            C0497q1 c0497q1 = this.f1062g.f796y;
            if (c0497q1 != null) {
                c0497q1.m617b(this);
            }
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.applog.ISessionObserver
    public void onSessionBatchEvent(long id, String sessionId, JSONObject appLog) {
        Intrinsics.checkParameterIsNotNull(sessionId, "sessionId");
    }

    @Override // com.bytedance.tobshadow.applog.ISessionObserver
    public void onSessionStart(long id, String sessionId) {
        Intrinsics.checkParameterIsNotNull(sessionId, "sessionId");
        mo637a();
    }

    @Override // com.bytedance.tobshadow.applog.ISessionObserver
    public void onSessionTerminate(long id, String sessionId, JSONObject appLog) {
        Intrinsics.checkParameterIsNotNull(sessionId, "sessionId");
    }

    /* renamed from: a */
    public final JSONObject m673a(String str) {
        C0497q1 c0497q1 = this.f1062g.f796y;
        if (c0497q1 != null) {
            c0497q1.m617b(this);
        }
        C0541w3 c0541w3 = this.f1056a;
        if (c0541w3 != null) {
            c0541w3.mo590b();
        }
        C0541w3 c0541w32 = this.f1056a;
        if (c0541w32 != null) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            c0541w32.f1185e = str;
        }
        C0541w3 c0541w33 = this.f1056a;
        JSONObject m591c = c0541w33 != null ? c0541w33.m591c() : null;
        this.f1056a = null;
        return m591c != null ? m591c : new JSONObject();
    }

    /* renamed from: a */
    public final void m674a(JSONObject... jSONObjectArr) {
        if (TextUtils.isEmpty(this.f1064i)) {
            return;
        }
        C0467m c0467m = this.f1062g;
        try {
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : jSONObjectArr) {
                if (jSONObject.length() == 0) {
                    break;
                }
                jSONArray.put(jSONObject);
            }
            if (jSONArray.length() == 0) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("magic_tag", "ss_app_log");
            Lazy lazy = this.f1060e;
            KProperty kProperty = f1053j[3];
            jSONObject2.put("header", (JSONObject) lazy.getValue());
            jSONObject2.put("time_sync", C0444i4.f666d);
            jSONObject2.put("event_v3", jSONArray);
            this.f1062g.f782k.m472c(this.f1064i, jSONObject2);
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }
}
