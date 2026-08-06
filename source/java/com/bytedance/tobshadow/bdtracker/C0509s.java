package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.tobshadow.applog.IDataObserver;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.UriConfig;
import com.bytedance.tobshadow.applog.alink.IALinkListener;
import com.bytedance.tobshadow.applog.alink.util.LinkUtils;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import com.bytedance.tobshadow.bdtracker.AbstractC0551y;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0018\u0010$\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0014H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0003J\u0010\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020\u0014H\u0003J\u0012\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\n .*\u0004\u0018\u00010-0-H\u0002J\u0006\u0010/\u001a\u00020 J\u0018\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020 2\b\u00104\u001a\u0004\u0018\u000105J \u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0016J\u0018\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020=H\u0016J\u001a\u0010>\u001a\u00020 2\u0006\u0010;\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010=H\u0016JB\u0010@\u001a\u00020 2\u0006\u0010;\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u00010\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bH\u0016J\u000e\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/tobshadow/applog/alink/ALinkManager;", "Landroid/os/Handler$Callback;", "Lcom/bytedance/tobshadow/applog/IDataObserver;", "engine", "Lcom/bytedance/tobshadow/applog/engine/Engine;", "(Lcom/bytedance/tobshadow/applog/engine/Engine;)V", "TRACE_DATA_ATTRS", "", "", "UTM_ATTRS", "apiService", "Lcom/bytedance/tobshadow/applog/alink/network/ApiService;", "cache", "Lcom/bytedance/tobshadow/applog/alink/ALinkCache;", "deepLinkUrl", "getDeepLinkUrl", "()Ljava/lang/String;", "setDeepLinkUrl", "(Ljava/lang/String;)V", "mClipboardEnable", "", "mDeepLinkRetryCount", "", "mEngine", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "maxDeepLinkRetryCount", "destroy", "", "doDeepLinked", "queryParam", "Lcom/bytedance/tobshadow/applog/alink/model/ALinkQueryParam;", "doDeferDeepLink", "exitsAppCache", "fillALinkQueryParams", "fillAttributionRequest", "Lcom/bytedance/tobshadow/applog/alink/model/AttributionRequest;", "handleMessage", "msg", "Landroid/os/Message;", "logger", "Lcom/bytedance/tobshadow/applog/log/IAppLogLogger;", "kotlin.jvm.PlatformType", "mergeTracerData", "onAbVidsChange", "vids", "extVids", "onDeepLinked", "uri", "Landroid/net/Uri;", "onIdLoaded", "did", "iid", "ssid", "onRemoteAbConfigGet", "changed", "abConfig", "Lorg/json/JSONObject;", "onRemoteConfigGet", "config", "onRemoteIdGet", "oldDid", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "setClipboardEnabled", "clipboardEnable", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0509s implements Handler.Callback, IDataObserver {

    /* renamed from: k */
    public static final /* synthetic */ KProperty[] f981k = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0509s.class), "mHandler", "getMHandler()Landroid/os/Handler;"))};

    /* renamed from: a */
    public boolean f982a;

    /* renamed from: b */
    public final Lazy f983b;

    /* renamed from: c */
    public C0475n0 f984c;

    /* renamed from: d */
    public C0495q f985d;

    /* renamed from: e */
    public int f986e;

    /* renamed from: f */
    public C0558z f987f;

    /* renamed from: g */
    public int f988g;

    /* renamed from: h */
    public String f989h;

    /* renamed from: i */
    public final List<String> f990i;

    /* renamed from: j */
    public final List<String> f991j;

    /* renamed from: com.bytedance.tobshadow.bdtracker.s$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class a extends Lambda implements Function0<Handler> {
        public a() {
            super(0);
        }

        public Object invoke() {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_alink");
            handlerThread.start();
            return new Handler(handlerThread.getLooper(), C0509s.this);
        }
    }

    public C0509s(C0475n0 c0475n0) {
        Intrinsics.checkParameterIsNotNull(c0475n0, "engine");
        this.f983b = LazyKt.lazy(new a());
        this.f984c = c0475n0;
        this.f988g = 10;
        this.f990i = CollectionsKt.listOf(new String[]{"utm_campaign", "utm_source", "utm_term", "utm_medium", "utm_content"});
        this.f991j = CollectionsKt.listOf(new String[]{"tr_shareuser", "tr_admaster", "tr_param1", "tr_param2", "tr_param3", "tr_param4", "reengagement_window", "reengagement_time", "is_retargeting"});
        String m492a = C0453k.m492a(c0475n0.f834d, "ALINK_CACHE_SP");
        C0407d2 c0407d2 = c0475n0.f835e;
        Intrinsics.checkExpressionValueIsNotNull(c0407d2, "engine.config");
        InitConfig initConfig = c0407d2.f502c;
        Intrinsics.checkExpressionValueIsNotNull(initConfig, "engine.config.initConfig");
        Context m546b = c0475n0.m546b();
        Intrinsics.checkExpressionValueIsNotNull(m546b, "engine.context");
        Intrinsics.checkExpressionValueIsNotNull(m492a, "spName");
        this.f985d = new C0495q(initConfig, m546b, m492a);
        C0467m c0467m = c0475n0.f834d;
        Intrinsics.checkExpressionValueIsNotNull(c0467m, "engine.appLog");
        this.f987f = new C0558z(c0467m);
    }

    /* renamed from: a */
    public final Handler m644a() {
        Lazy lazy = this.f983b;
        KProperty kProperty = f981k[0];
        return (Handler) lazy.getValue();
    }

    /* renamed from: b */
    public final IAppLogLogger m645b() {
        C0467m c0467m = this.f984c.f834d;
        Intrinsics.checkExpressionValueIsNotNull(c0467m, "mEngine.appLog");
        return c0467m.f764D;
    }

    /* renamed from: c */
    public final void m646c() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        C0516t c0516t = (C0516t) this.f985d.m609a("deep_link", C0516t.class);
        JSONObject mo665a = c0516t != null ? c0516t.mo665a() : null;
        if (mo665a != null) {
            for (String str : this.f990i) {
                jSONObject2.put(str, mo665a.optString(str, null));
            }
            for (String str2 : this.f991j) {
                if (Intrinsics.areEqual(str2, "is_retargeting")) {
                    jSONObject.put(str2, mo665a.optBoolean(str2) ? 1 : 0);
                } else {
                    jSONObject.put(str2, mo665a.optString(str2, null));
                }
            }
            C0421f2 c0421f2 = this.f984c.f839i;
            if (c0421f2 != null) {
                c0421f2.m407a("tracer_data", jSONObject);
            }
            C0421f2 c0421f22 = this.f984c.f839i;
            if (c0421f22 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    c0421f22.m407a(next, (Object) jSONObject2.optString(next));
                }
            }
        }
        String m610a = this.f985d.m610a("tr_web_ssid");
        if (m610a == null || m610a.length() == 0) {
            return;
        }
        this.f984c.f834d.setHeaderInfo("$tr_web_ssid", m610a);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        String str;
        C0523u c0523u;
        C0530v<C0537w> c0530v;
        String str2;
        String str3;
        C0516t m713a;
        Integer valueOf = msg != null ? Integer.valueOf(msg.what) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            C0421f2 c0421f2 = this.f984c.f839i;
            if (c0421f2 == null || c0421f2.m426i() != 0) {
                Object obj = msg.obj;
                if (obj != null) {
                    C0523u c0523u2 = (C0523u) obj;
                    String m709c = c0523u2.m709c();
                    if (m709c == null || m709c.length() == 0) {
                        m645b().warn(3, "DeepLink terminate, queryParam not find token...", new Object[0]);
                    } else {
                        c0523u2.f1085l = "android";
                        C0467m c0467m = this.f984c.f834d;
                        Intrinsics.checkExpressionValueIsNotNull(c0467m, "mEngine.appLog");
                        c0523u2.m706a(c0467m.f784m);
                        C0467m c0467m2 = this.f984c.f834d;
                        Intrinsics.checkExpressionValueIsNotNull(c0467m2, "mEngine.appLog");
                        c0523u2.m708b(c0467m2.getDid());
                        C0467m c0467m3 = this.f984c.f834d;
                        Intrinsics.checkExpressionValueIsNotNull(c0467m3, "mEngine.appLog");
                        c0523u2.m710c(c0467m3.getSsid());
                        C0467m c0467m4 = this.f984c.f834d;
                        Intrinsics.checkExpressionValueIsNotNull(c0467m4, "mEngine.appLog");
                        c0523u2.m712d(c0467m4.getUserUniqueID());
                        C0421f2 c0421f22 = this.f984c.f839i;
                        c0523u2.f1081h = c0421f22 != null ? c0421f22.m424h() : null;
                        C0421f2 c0421f23 = this.f984c.f839i;
                        c0523u2.f1082i = c0421f23 != null ? c0421f23.m430k() : null;
                        C0421f2 c0421f24 = this.f984c.f839i;
                        if (c0421f24 != null) {
                            str2 = null;
                            str3 = (String) c0421f24.m400a(Constant.KEY_DEVICE_MODEL, (String) null, (Class<String>) String.class);
                        } else {
                            str2 = null;
                            str3 = null;
                        }
                        c0523u2.f1087n = str3;
                        C0421f2 c0421f25 = this.f984c.f839i;
                        c0523u2.f1086m = c0421f25 != null ? (String) c0421f25.m400a(Constant.KEY_OS_VERSION, str2, (Class<String>) String.class) : str2;
                        C0421f2 c0421f26 = this.f984c.f839i;
                        JSONObject jSONObject = c0421f26 != null ? (JSONObject) c0421f26.m400a("oaid", str2, (Class<String>) JSONObject.class) : null;
                        c0523u2.f1083j = jSONObject != null ? jSONObject.optString("id") : null;
                        C0421f2 c0421f27 = this.f984c.f839i;
                        c0523u2.f1084k = c0421f27 != null ? (String) c0421f27.m400a("google_aid", (String) null, (Class<String>) String.class) : null;
                        UriConfig m554e = this.f984c.m554e();
                        Intrinsics.checkExpressionValueIsNotNull(m554e, "mEngine.uriConfig");
                        String alinkQueryUri = m554e.getAlinkQueryUri();
                        C0530v<C0516t> m757a = alinkQueryUri != null ? this.f987f.m757a(alinkQueryUri, c0523u2) : null;
                        if (m757a != null && (m713a = m757a.m713a()) != null) {
                            m713a.f1043t = m709c;
                            this.f985d.m611a("deep_link", m713a, 2592000000L);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("$link_type", "direct");
                            jSONObject2.put("$deeplink_url", this.f989h);
                            this.f984c.f834d.receive(new C0528u4("$invoke", jSONObject2));
                            m646c();
                            C0467m c0467m5 = this.f984c.f834d;
                            Intrinsics.checkExpressionValueIsNotNull(c0467m5, "mEngine.appLog");
                            IALinkListener iALinkListener = c0467m5.f797z;
                            if (iALinkListener != null) {
                                iALinkListener.onALinkData(m713a.mo665a(), null);
                            }
                        }
                    }
                    return true;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.tobshadow.applog.alink.model.ALinkQueryParam");
            }
            int i = this.f986e;
            if (i < this.f988g) {
                this.f986e = i + 1;
                m645b().debug(3, "Retry do deep link delay for the {} times...", Integer.valueOf(this.f986e));
                Handler m644a = m644a();
                m644a.sendMessageDelayed(m644a.obtainMessage(msg.what, msg.obj), 500L);
            } else {
                m645b().warn(3, "Retried max times to do deep link until AppLog ready", new Object[0]);
            }
        } else if (valueOf != null && valueOf.intValue() == 0) {
            JSONObject paramFromClipboard = this.f982a ? LinkUtils.INSTANCE.getParamFromClipboard(this.f984c.m546b()) : new JSONObject();
            m645b().debug(3, "Start to do defer deeplink with data:{}...", paramFromClipboard);
            AbstractC0551y.a aVar = AbstractC0551y.f1251a;
            if (paramFromClipboard == null) {
                paramFromClipboard = new JSONObject();
            }
            C0523u c0523u3 = (C0523u) aVar.m755a(paramFromClipboard, C0523u.class);
            if (c0523u3 != null) {
                Object obj2 = msg.obj;
                if (obj2 != null) {
                    boolean booleanValue = ((Boolean) obj2).booleanValue();
                    C0467m c0467m6 = this.f984c.f834d;
                    Intrinsics.checkExpressionValueIsNotNull(c0467m6, "mEngine.appLog");
                    c0523u3.m706a(c0467m6.f784m);
                    C0467m c0467m7 = this.f984c.f834d;
                    Intrinsics.checkExpressionValueIsNotNull(c0467m7, "mEngine.appLog");
                    c0523u3.m708b(c0467m7.getDid());
                    C0467m c0467m8 = this.f984c.f834d;
                    Intrinsics.checkExpressionValueIsNotNull(c0467m8, "mEngine.appLog");
                    c0523u3.m710c(c0467m8.getSsid());
                    C0467m c0467m9 = this.f984c.f834d;
                    Intrinsics.checkExpressionValueIsNotNull(c0467m9, "mEngine.appLog");
                    c0523u3.m712d(c0467m9.getUserUniqueID());
                    String m707b = c0523u3.m707b();
                    if (!(m707b == null || m707b.length() == 0)) {
                        C0467m c0467m10 = this.f984c.f834d;
                        String m707b2 = c0523u3.m707b();
                        if (m707b2 == null) {
                            m707b2 = "";
                        }
                        c0467m10.setExternalAbVersion(m707b2);
                    }
                    String m711d = c0523u3.m711d();
                    if (m711d == null || m711d.length() == 0) {
                        str = "mEngine.appLog";
                        c0523u = c0523u3;
                    } else {
                        str = "mEngine.appLog";
                        c0523u = c0523u3;
                        this.f985d.m612a("tr_web_ssid", c0523u3.m711d(), 31536000000L);
                    }
                    UriConfig m554e2 = this.f984c.m554e();
                    Intrinsics.checkExpressionValueIsNotNull(m554e2, "mEngine.uriConfig");
                    String alinkAttributionUri = m554e2.getAlinkAttributionUri();
                    if (alinkAttributionUri != null) {
                        C0558z c0558z = this.f987f;
                        C0544x c0544x = new C0544x();
                        C0421f2 c0421f28 = this.f984c.f839i;
                        if (c0421f28 != null) {
                            c0544x.f1202b = c0421f28.m412c();
                            c0544x.f1206f = "android";
                            c0544x.f1205e = c0421f28.m422g();
                            c0544x.f1212l = c0421f28.m424h();
                            c0544x.f1213m = c0421f28.m430k();
                            JSONObject jSONObject3 = (JSONObject) c0421f28.m400a("oaid", (String) null, (Class<String>) JSONObject.class);
                            c0544x.f1204d = c0421f28.m415d();
                            c0544x.f1214n = jSONObject3 != null ? jSONObject3.optString("id") : null;
                            c0544x.f1215o = (String) c0421f28.m400a("google_aid", (String) null, (Class<String>) String.class);
                            c0544x.f1217q = (String) c0421f28.m400a("user_agent", (String) null, (Class<String>) String.class);
                            c0544x.f1218r = (String) c0421f28.m400a(Constant.KEY_DEVICE_MODEL, (String) null, (Class<String>) String.class);
                            c0544x.f1219s = (String) c0421f28.m400a(Constant.KEY_OS_VERSION, (String) null, (Class<String>) String.class);
                            c0544x.f1208h = c0421f28.m436q();
                            c0544x.f1209i = booleanValue;
                            c0544x.f1210j = c0421f28.m434o();
                            c0544x.f1211k = (String) c0421f28.m400a(Constant.KEY_CHANNEL, (String) null, (Class<String>) String.class);
                            c0544x.f1220t = (String) c0421f28.m400a("package", (String) null, (Class<String>) String.class);
                        }
                        c0530v = c0558z.m758a(alinkAttributionUri, c0544x, c0523u);
                    } else {
                        c0530v = null;
                    }
                    C0537w m713a2 = c0530v != null ? c0530v.m713a() : null;
                    if (m713a2 == null) {
                        C0502r c0502r = C0502r.f967a;
                        C0467m c0467m11 = this.f984c.f834d;
                        Intrinsics.checkExpressionValueIsNotNull(c0467m11, str);
                        IALinkListener iALinkListener2 = c0467m11.f797z;
                        if (iALinkListener2 != null) {
                            iALinkListener2.onAttributionFailedCallback(new IllegalStateException(c0502r.invoke(c0530v != null ? c0530v.f1107a : null)));
                        }
                    } else {
                        String str4 = str;
                        if (m713a2.f1150G) {
                            m713a2.f1150G = false;
                            this.f985d.m611a("deferred_deep_link", m713a2, -1L);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("$link_type", "deferred");
                            this.f984c.f834d.receive(new C0528u4("$invoke", jSONObject4));
                            C0467m c0467m12 = this.f984c.f834d;
                            Intrinsics.checkExpressionValueIsNotNull(c0467m12, str4);
                            IALinkListener iALinkListener3 = c0467m12.f797z;
                            if (iALinkListener3 != null) {
                                iALinkListener3.onAttributionData(m713a2.mo665a(), null);
                            }
                        } else {
                            C0467m c0467m13 = this.f984c.f834d;
                            Intrinsics.checkExpressionValueIsNotNull(c0467m13, str4);
                            IALinkListener iALinkListener4 = c0467m13.f797z;
                            if (iALinkListener4 != null) {
                                iALinkListener4.onAttributionFailedCallback(new IllegalStateException("DDL has data but not firstLaunch"));
                            }
                        }
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                }
            }
            return true;
        }
        return true;
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
        C0421f2 c0421f2 = this.f984c.f839i;
        if (c0421f2 != null && !c0421f2.m435p()) {
            m645b().warn(3, "Register not ready, ddl wait next time...", new Object[0]);
            return;
        }
        m646c();
        String m610a = this.f985d.m610a("app_cache");
        boolean z = !(m610a == null || m610a.length() == 0);
        if (!z) {
            this.f985d.m612a("app_cache", "app_cache", -1L);
        }
        if (!z) {
            Handler m644a = m644a();
            m644a.sendMessage(m644a.obtainMessage(0, Boolean.valueOf(z)));
        }
        C0497q1 c0497q1 = this.f984c.f834d.f796y;
        if (c0497q1 != null) {
            c0497q1.m617b(this);
        }
    }
}
