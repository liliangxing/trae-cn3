package com.bytedance.tobshadow.bdtracker;

import android.accounts.Account;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tobshadow.applog.C0355R;
import com.bytedance.tobshadow.applog.IActiveCustomParamsCallback;
import com.bytedance.tobshadow.applog.IAppLogInstance;
import com.bytedance.tobshadow.applog.IDataObserver;
import com.bytedance.tobshadow.applog.IEventJsonObserver;
import com.bytedance.tobshadow.applog.IEventObserver;
import com.bytedance.tobshadow.applog.IExtraParams;
import com.bytedance.tobshadow.applog.IHeaderCustomTimelyCallback;
import com.bytedance.tobshadow.applog.IOaidObserver;
import com.bytedance.tobshadow.applog.IPresetEventObserver;
import com.bytedance.tobshadow.applog.IPullAbTestConfigCallback;
import com.bytedance.tobshadow.applog.ISessionObserver;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.Level;
import com.bytedance.tobshadow.applog.UriConfig;
import com.bytedance.tobshadow.applog.alink.IALinkListener;
import com.bytedance.tobshadow.applog.alink.util.LinkUtils;
import com.bytedance.tobshadow.applog.collector.Collector;
import com.bytedance.tobshadow.applog.event.EventBuilder;
import com.bytedance.tobshadow.applog.event.IEventHandler;
import com.bytedance.tobshadow.applog.exception.AppCrashType;
import com.bytedance.tobshadow.applog.exposure.ViewExposureManager;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import com.bytedance.tobshadow.applog.log.ILogProcessor;
import com.bytedance.tobshadow.applog.log.LogProcessorHolder;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.applog.network.INetworkClient;
import com.bytedance.tobshadow.applog.oneid.IDBindCallback;
import com.bytedance.tobshadow.applog.profile.UserProfileCallback;
import com.bytedance.tobshadow.applog.simulate.SimulateLaunchActivity;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0467m implements IAppLogInstance {

    /* renamed from: L */
    public static final List<C0467m> f759L = new CopyOnWriteArrayList();

    /* renamed from: M */
    public static final AtomicInteger f760M = new AtomicInteger(0);

    /* renamed from: A */
    public IActiveCustomParamsCallback f761A;

    /* renamed from: B */
    public volatile C0381a0 f762B;

    /* renamed from: C */
    public IEventHandler f763C;

    /* renamed from: D */
    public final IAppLogLogger f764D;

    /* renamed from: K */
    public InterfaceC0506r3 f771K;

    /* renamed from: j */
    public final C0458k4 f781j;

    /* renamed from: k */
    public final C0444i4 f782k;

    /* renamed from: o */
    public volatile C0407d2 f786o;

    /* renamed from: p */
    public volatile C0421f2 f787p;

    /* renamed from: q */
    public volatile C0475n0 f788q;

    /* renamed from: r */
    public volatile C0389b0 f789r;

    /* renamed from: s */
    public volatile ViewExposureManager f790s;

    /* renamed from: t */
    public volatile INetworkClient f791t;

    /* renamed from: v */
    public volatile IHeaderCustomTimelyCallback f793v;

    /* renamed from: w */
    public volatile AbstractC0476n1 f794w;

    /* renamed from: y */
    public C0497q1 f796y;

    /* renamed from: z */
    public IALinkListener f797z;

    /* renamed from: a */
    public final ConcurrentHashMap<String, JSONObject> f772a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public final C0511s1 f773b = new C0511s1();

    /* renamed from: c */
    public final C0504r1 f774c = new C0504r1();

    /* renamed from: d */
    public final C0435h2 f775d = new C0435h2();

    /* renamed from: e */
    public final C0539w1 f776e = new C0539w1();

    /* renamed from: f */
    public final Set<Integer> f777f = new HashSet();

    /* renamed from: g */
    public final Set<String> f778g = new HashSet();

    /* renamed from: h */
    public final Set<Class<?>> f779h = new HashSet();

    /* renamed from: i */
    public final Map<String, C0517t0> f780i = new ConcurrentHashMap();

    /* renamed from: l */
    public int f783l = 0;

    /* renamed from: m */
    public String f784m = "";

    /* renamed from: n */
    public volatile Application f785n = null;

    /* renamed from: u */
    public volatile boolean f792u = false;

    /* renamed from: x */
    public volatile boolean f795x = false;

    /* renamed from: E */
    public volatile boolean f765E = true;

    /* renamed from: F */
    public long f766F = 0;

    /* renamed from: G */
    public volatile boolean f767G = false;

    /* renamed from: H */
    public final C0494p5<String> f768H = new C0494p5<>();

    /* renamed from: I */
    public final C0494p5<String> f769I = new C0494p5<>();

    /* renamed from: J */
    public final Object f770J = new Object();

    /* renamed from: com.bytedance.tobshadow.bdtracker.m$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ boolean f798a;

        public a(boolean z) {
            this.f798a = z;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", C0467m.this.f784m);
                jSONObject2.put("接口加密开关", this.f798a);
                jSONObject.put("config", jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.m$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class b implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ boolean f800a;

        public b(boolean z) {
            this.f800a = z;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", C0467m.this.f784m);
                jSONObject2.put("剪切板开关", this.f800a);
                jSONObject.put("config", jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.m$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class c implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ boolean f802a;

        public c(boolean z) {
            this.f802a = z;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", C0467m.this.f784m);
                jSONObject2.put("隐私模式开关", this.f802a);
                jSONObject.put("config", jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public C0467m() {
        f760M.incrementAndGet();
        this.f764D = new LoggerImpl();
        this.f781j = new C0458k4(this);
        this.f782k = new C0444i4(this);
        f759L.add(this);
    }

    /* renamed from: a */
    public C0435h2 m518a() {
        return this.f775d;
    }

    /* renamed from: a */
    public final void m520a(String str, Object obj) {
        InitConfig initConfig = getInitConfig();
        if (initConfig == null || initConfig.getProcess() != 2) {
            this.f764D.warn("call setHeaderInfo process unknown.", new Object[0]);
            return;
        }
        if (obj instanceof String) {
            Intent intent = new Intent(this.f785n, (Class<?>) Collector.class);
            intent.putExtra("K_APP_ID", this.f784m);
            intent.putExtra("K_CUSTOM_HEADER_KEY", str);
            intent.putExtra("K_CUSTOM_HEADER_VALUE", (String) obj);
            intent.putExtra("K_ADD_CUSTOM_HEADER", true);
            this.f785n.sendBroadcast(intent);
            return;
        }
        this.f764D.warn("call setHeaderInfo in other process, not support value type, key: {}, value: {}.", str, obj);
    }

    /* renamed from: a */
    public final boolean m521a(String str) {
        return C0411e.m359a((Object) this.f787p, "Call " + str + " before please initialize first");
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void activateALink(Uri uri) {
        if (m523b("activateALink")) {
            return;
        }
        C0509s c0509s = this.f788q.f824B;
        c0509s.m646c();
        if (uri != null) {
            c0509s.f989h = uri.toString();
        }
        c0509s.m645b().debug(3, "Activate deep link with url: {}...", c0509s.f989h);
        Handler m644a = c0509s.m644a();
        C0523u c0523u = (C0523u) AbstractC0551y.f1251a.m755a(LinkUtils.INSTANCE.getParamFromLink(uri), C0523u.class);
        String m709c = c0523u != null ? c0523u.m709c() : null;
        if (m709c == null || m709c.length() == 0) {
            return;
        }
        c0509s.f986e = 0;
        m644a.sendMessage(m644a.obtainMessage(1, c0523u));
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public synchronized void addDataObserver(IDataObserver iDataObserver) {
        if (this.f796y == null) {
            this.f796y = new C0497q1();
        }
        this.f796y.m616a(iDataObserver);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void addEventJsonObserver(IEventJsonObserver iEventJsonObserver) {
        this.f774c.m629a(iEventJsonObserver);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void addEventObserver(IEventObserver iEventObserver) {
        this.f774c.m630a(iEventObserver);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void addEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
        this.f774c.m630a(iEventObserver);
        this.f774c.m631a(iPresetEventObserver);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return this.f781j.m501a(this.f787p != null ? this.f787p.m420f() : null, str, z, level);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void addSessionHook(ISessionObserver iSessionObserver) {
        this.f773b.m654a(iSessionObserver);
    }

    /* renamed from: b */
    public InterfaceC0506r3 m522b() {
        InterfaceC0506r3 interfaceC0506r3 = this.f771K;
        return interfaceC0506r3 != null ? interfaceC0506r3 : C0513s3.f1017a;
    }

    /* renamed from: b */
    public final boolean m523b(String str) {
        return C0411e.m359a((Object) this.f788q, "Call " + str + " before please initialize first");
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void bind(Map<String, String> map, IDBindCallback iDBindCallback) {
        if (m523b("bind")) {
            return;
        }
        C0475n0 c0475n0 = this.f788q;
        if (map == null) {
            c0475n0.f834d.f764D.warn("BindID identities is null", new Object[0]);
        } else {
            c0475n0.f830H.m265a(map, iDBindCallback);
        }
    }

    /* renamed from: c */
    public final void m524c(String str) {
        InitConfig initConfig = getInitConfig();
        if (initConfig != null && initConfig.getProcess() == 2) {
            Intent intent = new Intent(this.f785n, (Class<?>) Collector.class);
            intent.putExtra("K_APP_ID", this.f784m);
            intent.putExtra("K_CUSTOM_HEADER_KEY", str);
            intent.putExtra("K_REMOVE_CUSTOM_HEADER", true);
            this.f785n.sendBroadcast(intent);
            return;
        }
        this.f764D.warn("call removeHeaderInfo process unknown.", new Object[0]);
    }

    /* renamed from: c */
    public boolean m525c() {
        return this.f767G;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void clearAbTestConfigsCache() {
        if (this.f787p != null) {
            this.f787p.m402a();
        } else {
            new C0524u0().initCause(new AssertionError("Please initialize first")).printStackTrace();
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean clearDb() {
        if (this.f788q == null) {
            new C0524u0().initCause(new AssertionError("clearDb before init")).printStackTrace();
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f764D.debug("[event_process][delete] Start to clear db data...", new Object[0]);
        boolean m698b = this.f788q.m550c().m698b();
        this.f764D.debug("[event_process][delete] All db data cleared", new Object[0]);
        C0547x2.m745a(getMonitor(), "api_usage", "clearDb", elapsedRealtime);
        return m698b;
    }

    /* renamed from: d */
    public final void m526d() {
        C0494p5<String> c0494p5 = this.f768H;
        if (c0494p5.f928b && !C0411e.m362a(c0494p5.f927a, this.f786o.m319f())) {
            this.f787p.m427i(this.f768H.f927a);
            this.f764D.debug(C0380a.m252a("postSetUuidAfterDm uuid -> ").append(this.f768H.f927a).toString(), new Object[0]);
            this.f787p.m425h("");
        }
        C0494p5<String> c0494p52 = this.f769I;
        if (!c0494p52.f928b || C0411e.m362a(c0494p52.f927a, this.f786o.m320g())) {
            return;
        }
        this.f787p.m429j(this.f769I.f927a);
        this.f764D.debug(C0380a.m252a("postSetUuidAfterDm uuid -> ").append(this.f769I.f927a).toString(), new Object[0]);
        this.f787p.m425h("");
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void flush() {
        if (m523b("flush")) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f788q.m543a((String[]) null, true);
        C0547x2.m745a(getMonitor(), "api_usage", "flush", elapsedRealtime);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public IALinkListener getALinkListener() {
        return this.f797z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public <T> T getAbConfig(String str, T t) {
        if (m521a("getAbConfig")) {
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C0421f2 c0421f2 = this.f787p;
        JSONObject optJSONObject = c0421f2.f586c.m310a().optJSONObject(str);
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("vid");
            Object opt = optJSONObject.opt("val");
            c0421f2.m403a(optString);
            InitConfig initConfig = c0421f2.f592i.getInitConfig();
            if (initConfig != null) {
                if (!initConfig.isAbTestExposureEventRepeatEnabled()) {
                    if (!c0421f2.f595l.contains(optString)) {
                        c0421f2.f595l.add(optString);
                    }
                }
                c0421f2.m419e(optString);
            }
            T t2 = opt != 0 ? opt : null;
            if (t2 != null) {
                t = t2;
            }
        }
        C0547x2.m745a(getMonitor(), "api_usage", "getAbConfig", elapsedRealtime);
        return t;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getAbSdkVersion() {
        return m521a("getAbSdkVersion") ? "" : this.f787p.m409b();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public IActiveCustomParamsCallback getActiveCustomParams() {
        return this.f761A;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public String getAid() {
        return this.f784m;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public JSONObject getAllAbTestConfigs() {
        return this.f788q == null ? new JSONObject() : this.f788q.f835e.m310a();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public InterfaceC0481o getAppContext() {
        return null;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getAppId() {
        return this.f784m;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getClientUdid() {
        return m521a("getClientUdid") ? "" : this.f787p.f587d.optString("clientudid", "");
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public Context getContext() {
        return this.f785n;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getDeepLinkUrl() {
        if (this.f788q != null) {
            return this.f788q.f824B.f989h;
        }
        return null;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getDid() {
        if (m521a("getDid")) {
            return "";
        }
        String m415d = this.f787p.m415d();
        return !TextUtils.isEmpty(m415d) ? m415d : this.f787p.f587d.optString("device_id", "");
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean getEncryptAndCompress() {
        return this.f765E;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public AbstractC0476n1 getEventFilterByClient() {
        return this.f794w;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public IEventHandler getEventHandler() {
        return this.f763C;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getExternalAbVersion() {
        if (m521a("setExternalAbVersion")) {
            return null;
        }
        return this.f786o.m316c();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public JSONObject getHeader() {
        if (m521a("getHeader")) {
            return null;
        }
        return this.f787p.m420f();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public IHeaderCustomTimelyCallback getHeaderCustomCallback() {
        return this.f793v;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public <T> T getHeaderValue(String str, T t, Class<T> cls) {
        if (m521a("getHeaderValue")) {
            return null;
        }
        return (T) this.f787p.m400a(str, (String) t, (Class<String>) cls);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getIid() {
        return m521a("getIid") ? "" : this.f787p.m422g();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public InitConfig getInitConfig() {
        if (this.f786o != null) {
            return this.f786o.f502c;
        }
        return null;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public int getLaunchFrom() {
        return this.f783l;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public InterfaceC0526u2 getMonitor() {
        if (m523b("getMonitor")) {
            return null;
        }
        return this.f788q.f847q;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public INetworkClient getNetClient() {
        if (this.f791t != null) {
            return this.f791t;
        }
        if (getInitConfig() != null && getInitConfig().getNetworkClient() != null) {
            return getInitConfig().getNetworkClient();
        }
        synchronized (this) {
            if (this.f791t == null) {
                this.f791t = new C0555y3(this.f782k);
            }
        }
        return this.f791t;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getOpenUdid() {
        return m521a("getOpenUdid") ? "" : this.f787p.m424h();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public Map<String, String> getRequestHeader() {
        if (this.f786o == null) {
            return Collections.emptyMap();
        }
        String string = this.f786o.f505f.getString("device_token", "");
        HashMap hashMap = new HashMap();
        hashMap.put("x-tt-dt", string != null ? string : "");
        return hashMap;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getSdkVersion() {
        return "6.17.11-tobshadow";
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getSessionId() {
        return this.f788q != null ? this.f788q.m552d() : "";
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getSsid() {
        return m521a("getSsid") ? "" : this.f787p.m428j();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void getSsidGroup(Map<String, String> map) {
        String did = getDid();
        if (!TextUtils.isEmpty(did)) {
            map.put("device_id", did);
        }
        String iid = getIid();
        if (!TextUtils.isEmpty(iid)) {
            map.put("install_id", iid);
        }
        String openUdid = getOpenUdid();
        if (!TextUtils.isEmpty(openUdid)) {
            map.put("openudid", openUdid);
        }
        String clientUdid = getClientUdid();
        if (TextUtils.isEmpty(clientUdid)) {
            return;
        }
        map.put("clientudid", clientUdid);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public String getUdid() {
        return m521a("getUdid") ? "" : this.f787p.m430k();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public UriConfig getUriRuntime() {
        if (m523b("getUriRuntime")) {
            return null;
        }
        return this.f788q.m554e();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getUserID() {
        if (m523b("getUserID")) {
            return null;
        }
        return String.valueOf(this.f788q.f844n.f994a);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public String getUserUniqueID() {
        return m521a("getUserUniqueID") ? "" : this.f787p.m431l();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public ViewExposureManager getViewExposureManager() {
        return this.f790s;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public JSONObject getViewProperties(View view) {
        if (view != null) {
            return this.f772a.get(C0411e.m369b(view));
        }
        return null;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean hasStarted() {
        return this.f792u;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void ignoreAutoTrackClick(View view) {
        if (view == null) {
            return;
        }
        this.f778g.add(C0411e.m369b(view));
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void ignoreAutoTrackClickByViewType(Class<?>... clsArr) {
        if (clsArr == null) {
            return;
        }
        this.f779h.addAll(Arrays.asList(clsArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        r4 = true;
     */
    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ignoreAutoTrackPage(Class<?>... clsArr) {
        boolean z;
        if (clsArr == null) {
            return;
        }
        for (Class<?> cls : clsArr) {
            if (cls != null) {
                Iterator<Class<?>> it = C0515s5.f1022c.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().isAssignableFrom(cls)) {
                            break;
                        }
                    } else {
                        Iterator<Class<?>> it2 = C0515s5.f1023d.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().isAssignableFrom(cls)) {
                            }
                        }
                        z = false;
                    }
                }
                if (z) {
                    String canonicalName = cls.getCanonicalName();
                    if (!TextUtils.isEmpty(canonicalName)) {
                        this.f777f.add(Integer.valueOf(canonicalName.hashCode()));
                    }
                } else {
                    this.f764D.warn("{} is not a page class", cls);
                }
            }
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void init(Context context, InitConfig initConfig) {
        String str;
        ILogProcessor c0518t1;
        synchronized (C0467m.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String aid = initConfig.getAid();
            if (C0411e.m376c(aid)) {
                Log.e("AppLog", "Init failed. App id must not be empty!");
                return;
            }
            if (C0411e.m376c(initConfig.getChannel())) {
                Log.e("AppLog", "Channel must not be empty!");
                return;
            }
            if (C0453k.m498b(aid)) {
                Log.e("AppLog", "The app id: " + aid + " has initialized already");
                return;
            }
            this.f764D.setAppId(aid);
            this.f784m = aid;
            this.f785n = (Application) context.getApplicationContext();
            if (initConfig.isLogEnable()) {
                if (initConfig.getLogger() != null) {
                    str = this.f784m;
                    c0518t1 = new C0525u1(initConfig.getLogger());
                } else {
                    str = this.f784m;
                    c0518t1 = new C0518t1(this);
                }
                LogProcessorHolder.setProcessor(str, c0518t1);
            }
            this.f764D.info("AppLog init begin...", new Object[0]);
            if (!initConfig.isMonitorEnabled() && !C0540w2.m724a(initConfig) && initConfig.getUriConfig() == null) {
                initConfig.setMonitorEnabled(true);
            }
            initMetaSec(context);
            if (TextUtils.isEmpty(initConfig.getSpName())) {
                initConfig.setSpName(C0453k.m492a(this, "applog_stats"));
            }
            synchronized (this.f770J) {
                this.f786o = new C0407d2(this, this.f785n, initConfig);
                this.f787p = new C0421f2(this, this.f785n, this.f786o);
                m526d();
                this.f788q = new C0475n0(this, this.f786o, this.f787p, this.f776e);
                String string = this.f786o.f505f.getString("observe_appid", "");
                UriConfig m554e = this.f788q.m554e();
                if (TextUtils.isEmpty(string)) {
                    this.f771K = C0513s3.f1017a;
                } else {
                    String str2 = "";
                    if (m554e != null) {
                        try {
                            str2 = m554e.getSendUris()[0];
                            if (str2.endsWith("/")) {
                                str2 = str2.substring(0, str2.length() - 1);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    this.f771K = new C0520t3(this, string, str2);
                }
            }
            if (!LogUtils.isDisabled()) {
                LogUtils.sendJsonFetcher("init_begin", new C0474n(this, initConfig));
            }
            this.f789r = C0389b0.m278a(this.f785n);
            this.f790s = new ViewExposureManager(this);
            if (AppCrashType.hasJavaCrashType(initConfig.getTrackCrashType()) || initConfig.isMonitorEnabled()) {
                C0531v0.m716a();
            }
            this.f783l = 1;
            this.f792u = initConfig.autoStart();
            LogUtils.sendString("init_end", this.f784m);
            this.f764D.info("AppLog init end", new Object[0]);
            if (C0411e.m362a(SimulateLaunchActivity.entryAppId, this.f784m)) {
                AsyncTaskC0465l4.m507a(this);
            }
            this.f786o.m327n();
            InterfaceC0526u2 monitor = getMonitor();
            Intrinsics.checkParameterIsNotNull("sdk_init", "metricsName");
            C0547x2.m745a(monitor, "sdk_init", (String) null, elapsedRealtime);
            this.f788q.m559h();
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void init(Context context, InitConfig initConfig, Activity activity) {
        init(context, initConfig);
        if (this.f789r == null || activity == null) {
            return;
        }
        this.f789r.onActivityCreated(activity, null);
        this.f789r.onActivityStarted(activity);
        this.f789r.onActivityResumed(activity);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void initH5Bridge(View view, String str) {
        Class<?> m367b = C0411e.m367b("com.bytedance.tobshadow.applog.tracker.WebViewUtil");
        if (m367b == null) {
            this.f764D.warn("No WebViewUtil class, and will not initialize h5 bridge", new Object[0]);
            return;
        }
        try {
            Method declaredMethod = m367b.getDeclaredMethod("injectWebViewBridges", View.class, String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, view, str);
        } catch (Throwable th) {
            this.f764D.error("Initialize h5 bridge failed", th, new Object[0]);
            m522b().mo639a(th, "initH5Bridge");
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void initMetaSec(Context context) {
        if (getInitConfig() == null || getInitConfig().isMetaSecEnabled()) {
            Class<?> m367b = C0411e.m367b("com.bytedance.tobshadow.applog.metasec.AppLogSecHelper");
            if (m367b == null) {
                this.f764D.debug("No AppLogSecHelper class, and will not init", new Object[0]);
                return;
            }
            try {
                Method declaredMethod = m367b.getDeclaredMethod("init", IAppLogInstance.class, Context.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, this, context);
            } catch (Throwable th) {
                this.f764D.error("Initialize AppLogSecHelper failed", th, new Object[0]);
            }
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void initWebViewBridge(View view, String str) {
        Class<?> m367b = C0411e.m367b("com.bytedance.tobshadow.applog.tracker.WebViewUtil");
        if (m367b != null) {
            try {
                m367b.getMethod("injectWebViewBridges", View.class, String.class).invoke(null, view, str);
            } catch (Throwable th) {
                this.f764D.error("Init webview bridge failed", th, new Object[0]);
                m522b().mo639a(th, "initWebViewBridge");
            }
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean isAutoTrackClickIgnored(View view) {
        if (view == null) {
            return false;
        }
        if (this.f778g.contains(C0411e.m369b(view))) {
            return true;
        }
        Iterator<Class<?>> it = this.f779h.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean isAutoTrackPageIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        String canonicalName = cls.getCanonicalName();
        if (TextUtils.isEmpty(canonicalName)) {
            return false;
        }
        return this.f777f.contains(Integer.valueOf(canonicalName.hashCode()));
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean isBavEnabled() {
        return this.f788q != null && this.f788q.m558g();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean isH5BridgeEnable() {
        return getInitConfig() != null && getInitConfig().isH5BridgeEnable();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean isH5CollectEnable() {
        return getInitConfig() != null && getInitConfig().isH5CollectEnable();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean isNewUser() {
        if (m521a("isNewUser")) {
            return false;
        }
        return this.f787p.f588e;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean isPrivacyMode() {
        return this.f795x;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public boolean manualActivate() {
        if (m523b("manualActivate")) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean m545a = this.f788q.m545a(false);
        C0547x2.m745a(getMonitor(), "api_usage", "manualActivate", elapsedRealtime);
        return m545a;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public EventBuilder newEvent(String str) {
        return new EventBuilder(this).setEvent(str);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void onActivityPause() {
        if (this.f789r != null) {
            this.f789r.onActivityPaused(null);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void onActivityResumed(Activity activity, int i) {
        if (this.f789r != null) {
            this.f789r.m284a(activity, i);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void onEventV3(String str) {
        onEventV3(str, (JSONObject) null, 0);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void onEventV3(String str, Bundle bundle) {
        onEventV3(str, bundle, 0);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void onEventV3(String str, JSONObject jSONObject) {
        onEventV3(str, jSONObject, 0);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public void onMiscEvent(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null && jSONObject.length() > 0) {
            this.f764D.debug(Arrays.asList("customEvent", "miscEvent"), "logType:{} params:{} ", str, jSONObject.toString());
            try {
                jSONObject.put("log_type", str);
                receive(new C0500q4("log_data", jSONObject));
                return;
            } catch (Throwable th) {
                this.f764D.error("call onMiscEvent error", th, new Object[0]);
                return;
            }
        }
        this.f764D.warn("call onMiscEvent with invalid params", new Object[0]);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void onPause(Context context) {
        if (context instanceof Activity) {
            onActivityPause();
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void onResume(Context context) {
        if (context instanceof Activity) {
            onActivityResumed((Activity) context, context.hashCode());
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void pauseDurationEvent(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C0411e.m365a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        C0517t0 c0517t0 = this.f780i.get(str);
        if (C0411e.m359a((Object) c0517t0, "No duration event with name: " + str)) {
            return;
        }
        c0517t0.m667a(elapsedRealtime);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void profileAppend(JSONObject jSONObject) {
        if (m523b("profileAppend") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject m350a = C0411e.m350a(jSONObject);
        try {
            if (!C0411e.m364a(m350a, (Class<?>[]) new Class[]{String.class, Integer.class}, (Class<?>[]) new Class[]{String.class})) {
                this.f764D.warn("only support String、Int、String Array！", new Object[0]);
                return;
            }
        } catch (Throwable th) {
            this.f764D.error("JSON handle failed", th, new Object[0]);
        }
        C0387a6.m275a(this.f764D, m350a);
        this.f788q.m549b(m350a);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void profileIncrement(JSONObject jSONObject) {
        if (m523b("profileIncrement") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject m350a = C0411e.m350a(jSONObject);
        try {
            if (!C0411e.m364a(m350a, (Class<?>[]) new Class[]{Integer.class}, (Class<?>[]) null)) {
                this.f764D.warn("only support Int param", new Object[0]);
                return;
            }
        } catch (Throwable th) {
            this.f764D.error("JSON handle failed", th, new Object[0]);
        }
        C0387a6.m275a(this.f764D, m350a);
        this.f788q.m551c(m350a);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void profileSet(JSONObject jSONObject) {
        if (m523b("profileSet") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject m350a = C0411e.m350a(jSONObject);
        C0387a6.m275a(this.f764D, m350a);
        this.f788q.m553d(m350a);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void profileSetOnce(JSONObject jSONObject) {
        if (m523b("profileSetOnce") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject m350a = C0411e.m350a(jSONObject);
        C0387a6.m275a(this.f764D, m350a);
        this.f788q.m555e(m350a);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void profileUnset(String str) {
        if (m523b("profileUnset")) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, "");
        } catch (Throwable th) {
            this.f764D.error("JSON handle failed", th, new Object[0]);
        }
        C0387a6.m275a(this.f764D, jSONObject);
        this.f788q.m556f(jSONObject);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void pullAbTestConfigs() {
        pullAbTestConfigs(-1, null);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void pullAbTestConfigs(int i, IPullAbTestConfigCallback iPullAbTestConfigCallback) {
        if (this.f788q == null) {
            new C0524u0().initCause(new AssertionError("Please initialize first")).printStackTrace();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        long abs = this.f788q.f831a - Math.abs(currentTimeMillis - this.f766F);
        if (abs < 0) {
            this.f766F = currentTimeMillis;
            Handler handler = this.f788q.f846p;
            handler.sendMessage(handler.obtainMessage(18, i, -1, iPullAbTestConfigCallback));
        } else if (iPullAbTestConfigCallback != null) {
            iPullAbTestConfigCallback.onThrottle(abs);
        } else {
            this.f764D.warn("Pull ABTest config too frequently", new Object[0]);
        }
        C0547x2.m745a(getMonitor(), "api_usage", "pullAbTestConfigs", elapsedRealtime);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        this.f781j.m502a(this.f787p != null ? this.f787p.m420f() : null, z, map, level);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void receive(AbstractC0479n4 abstractC0479n4) {
        if (abstractC0479n4 == null) {
            return;
        }
        abstractC0479n4.f882m = this.f784m;
        if (this.f788q == null) {
            this.f776e.m722a(abstractC0479n4);
        } else {
            this.f788q.m538a(abstractC0479n4);
        }
        LogUtils.sendObject("event_receive", abstractC0479n4);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        this.f793v = iHeaderCustomTimelyCallback;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void removeAllDataObserver() {
        C0497q1 c0497q1 = this.f796y;
        if (c0497q1 != null) {
            c0497q1.f944a.clear();
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void removeDataObserver(IDataObserver iDataObserver) {
        C0497q1 c0497q1 = this.f796y;
        if (c0497q1 != null) {
            c0497q1.m617b(iDataObserver);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void removeEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
        this.f774c.m634b(iEventObserver);
        this.f774c.m635b(iPresetEventObserver);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void removeHeaderInfo(String str) {
        if (m521a("removeHeaderInfo")) {
            return;
        }
        this.f764D.debug("call removeHeaderInfo isMainProcess: {}, key: {}", Boolean.valueOf(this.f786o.m323j()), str);
        if (this.f786o.m323j()) {
            this.f787p.m416d(str);
            return;
        }
        try {
            m524c(str);
        } catch (Throwable th) {
            this.f764D.debug("call removeHeaderInfo Post Main Process failed.", th);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void removeJsonEventObserver(IEventJsonObserver iEventJsonObserver) {
        this.f774c.m633b(iEventJsonObserver);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void removeJsonEventObserver(IEventObserver iEventObserver) {
        this.f774c.m634b(iEventObserver);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void removeOaidObserver(IOaidObserver iOaidObserver) {
        C0404d.m308b(iOaidObserver);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void removeSessionHook(ISessionObserver iSessionObserver) {
        this.f773b.m655b(iSessionObserver);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void resumeDurationEvent(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C0411e.m365a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        C0517t0 c0517t0 = this.f780i.get(str);
        if (C0411e.m359a((Object) c0517t0, "No duration event with name: " + str)) {
            return;
        }
        c0517t0.m668b(elapsedRealtime);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setALinkListener(IALinkListener iALinkListener) {
        this.f797z = iALinkListener;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public void setAccount(Account account) {
        if (m521a("setAccount")) {
            return;
        }
        C0435h2 m518a = this.f787p.f592i.m518a();
        if (m518a.f647a instanceof C0466l5) {
            C0472m4 c0472m4 = m518a.f647a.f754c;
            if (c0472m4 != null) {
                c0472m4.m529a(account);
                return;
            }
            return;
        }
        m518a.f648b = account;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback) {
        this.f761A = iActiveCustomParamsCallback;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public void setAppContext(InterfaceC0481o interfaceC0481o) {
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setAppLanguageAndRegion(String str, String str2) {
        boolean z;
        if (m523b("setAppLanguageAndRegion")) {
            return;
        }
        C0475n0 c0475n0 = this.f788q;
        C0421f2 c0421f2 = c0475n0.f839i;
        boolean z2 = true;
        if (c0421f2.m407a("app_language", (Object) str)) {
            c0421f2.f586c.f505f.putString("app_language", str);
            z = true;
        } else {
            z = false;
        }
        C0421f2 c0421f22 = c0475n0.f839i;
        if (c0421f22.m407a("app_region", (Object) str2)) {
            c0421f22.f586c.f505f.putString("app_region", str2);
        } else {
            z2 = false;
        }
        if (z || z2) {
            c0475n0.m537a(c0475n0.f841k);
            c0475n0.m537a(c0475n0.f836f);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setAppTrack(JSONObject jSONObject) {
        if (jSONObject == null || m521a("setAppTrack")) {
            return;
        }
        C0421f2 c0421f2 = this.f787p;
        if (c0421f2.m407a("app_track", jSONObject)) {
            C0407d2 c0407d2 = c0421f2.f586c;
            c0407d2.f503d.putString("app_track", jSONObject.toString());
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setClipboardEnabled(boolean z) {
        if (m523b("setClipboardEnabled")) {
            return;
        }
        this.f788q.f824B.f982a = z;
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("update_config", new b(z));
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setEncryptAndCompress(boolean z) {
        this.f765E = z;
        if (!C0411e.m379d(this.f784m) || LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("update_config", new a(z));
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setEventFilterByClient(List<String> list, boolean z) {
        AbstractC0476n1 abstractC0476n1 = null;
        if (list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                abstractC0476n1 = z ? new C0490p1(hashSet, null) : new C0483o1(hashSet, null);
            }
        }
        this.f794w = abstractC0476n1;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setEventHandler(IEventHandler iEventHandler) {
        this.f763C = iEventHandler;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setExternalAbVersion(String str) {
        if (m521a("setExternalAbVersion")) {
            return;
        }
        this.f787p.m423g(str);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public void setExtraParams(IExtraParams iExtraParams) {
        this.f781j.f723a = iExtraParams;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setGPSLocation(float f, float f2, String str) {
        if (this.f787p == null) {
            this.f764D.warn("Please initialize first", new Object[0]);
        } else {
            this.f762B = new C0381a0(f, f2, str);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setGoogleAid(String str) {
        if (m521a("setGoogleAid")) {
            return;
        }
        C0421f2 c0421f2 = this.f787p;
        if (c0421f2.m407a("google_aid", (Object) str)) {
            c0421f2.f586c.f505f.putString("google_aid", str);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setHeaderInfo(String str, Object obj) {
        if (m521a("setHeaderInfo")) {
            return;
        }
        this.f764D.debug("call setHeaderInfo isMainProcess: {}, key: {}, value: {}", Boolean.valueOf(this.f786o.m323j()), str, obj);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f786o.m323j()) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(str, obj);
            C0387a6.m274a(this.f764D, hashMap);
            this.f787p.m405a(hashMap);
            return;
        }
        try {
            m520a(str, obj);
        } catch (Throwable th) {
            this.f764D.debug("call setHeaderInfo Post Main Process failed.", th);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setLaunchFrom(int i) {
        this.f783l = i;
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setOaidObserver(IOaidObserver iOaidObserver) {
        C0404d.m305a(iOaidObserver);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setPrivacyMode(boolean z) {
        this.f795x = z;
        if (!C0411e.m379d(this.f784m) || LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("update_config", new c(z));
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setPullAbTestConfigsThrottleMills(Long l) {
        if (this.f788q != null) {
            this.f788q.m539a(l);
        } else {
            new C0524u0().initCause(new AssertionError("Please initialize first")).printStackTrace();
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setRangersEventVerifyEnable(boolean z, String str) {
        if (m523b("setRangersEventVerifyEnable")) {
            return;
        }
        C0475n0 c0475n0 = this.f788q;
        c0475n0.f840j.removeMessages(15);
        c0475n0.f840j.obtainMessage(15, new Object[]{Boolean.valueOf(z), str}).sendToTarget();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setTouchPoint(String str) {
        setHeaderInfo("touch_point", str);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setTracerData(JSONObject jSONObject) {
        if (m521a("setTracerData")) {
            return;
        }
        this.f787p.m407a("tracer_data", jSONObject);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setUriRuntime(UriConfig uriConfig) {
        if (m523b("setUriRuntime")) {
            return;
        }
        C0475n0 c0475n0 = this.f788q;
        c0475n0.f845o = uriConfig;
        c0475n0.m537a(c0475n0.f841k);
        if (c0475n0.f835e.f502c.isAutoActive()) {
            c0475n0.m545a(true);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setUserAgent(String str) {
        if (m521a("setUserAgent")) {
            return;
        }
        C0421f2 c0421f2 = this.f787p;
        if (c0421f2.m407a("user_agent", (Object) str)) {
            c0421f2.f586c.f505f.putString("user_agent", str);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setUserID(long j) {
        if (m523b("setUserID")) {
            return;
        }
        this.f788q.f844n.f994a = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setUserUniqueID(String str) {
        if (this.f787p != null) {
            setUserUniqueID(str, this.f787p.m432m());
            return;
        }
        C0494p5<String> c0494p5 = this.f768H;
        c0494p5.f927a = str;
        c0494p5.f928b = true;
        this.f764D.debug(C0380a.m251a("cache uuid before init id -> ", str), new Object[0]);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setViewId(Dialog dialog, String str) {
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().getDecorView().setTag(C0355R.id.applog_tag_view_id, str);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setViewId(View view, String str) {
        if (view == null) {
            return;
        }
        view.setTag(C0355R.id.applog_tag_view_id, str);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setViewId(Object obj, String str) {
        if (obj == null) {
            return;
        }
        if (!C0411e.m360a(obj, "android.support.v7.app.AlertDialog", "androidx.appcompat.app.AlertDialog")) {
            this.f764D.warn("Only support AlertDialog view", new Object[0]);
            return;
        }
        try {
            Window window = (Window) obj.getClass().getMethod("getWindow", new Class[0]).invoke(obj, new Object[0]);
            if (window != null) {
                window.getDecorView().setTag(C0355R.id.applog_tag_view_id, str);
            }
        } catch (NoSuchMethodException e) {
            this.f764D.error("Not found getWindow method in alertDialog", e, new Object[0]);
        } catch (Throwable th) {
            this.f764D.error("Cannot set viewId for alertDialog", th, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setViewProperties(View view, JSONObject jSONObject) {
        if (view == null || jSONObject == null) {
            return;
        }
        this.f772a.put(C0411e.m369b(view), jSONObject);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void start() {
        if (m523b("start") || this.f792u) {
            return;
        }
        this.f792u = true;
        C0475n0 c0475n0 = this.f788q;
        if (c0475n0.f848r) {
            return;
        }
        c0475n0.m560i();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void startDurationEvent(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C0411e.m365a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        C0517t0 c0517t0 = this.f780i.get(str);
        if (c0517t0 == null) {
            c0517t0 = new C0517t0(this.f764D, str);
            this.f780i.put(str, c0517t0);
        }
        c0517t0.m669c(elapsedRealtime);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void startSimulator(String str) {
        if (m523b("startSimulator")) {
            return;
        }
        C0475n0 c0475n0 = this.f788q;
        AbstractC0461l0 abstractC0461l0 = c0475n0.f849s;
        if (abstractC0461l0 != null) {
            abstractC0461l0.f733d = true;
        }
        Class<?> m367b = C0411e.m367b("com.bytedance.tobshadow.applog.picker.DomSender");
        if (m367b != null) {
            try {
                c0475n0.f849s = (AbstractC0461l0) m367b.getConstructor(C0475n0.class, String.class).newInstance(c0475n0, str);
                c0475n0.f840j.sendMessage(c0475n0.f840j.obtainMessage(9, c0475n0.f849s));
            } catch (Throwable th) {
                c0475n0.f834d.f764D.error("Start simulator failed.", th, new Object[0]);
            }
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void stopDurationEvent(String str, JSONObject jSONObject) {
        stopDurationEvent(str, jSONObject, str);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void stopDurationEvent(String str, JSONObject jSONObject, String str2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C0411e.m365a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        C0517t0 c0517t0 = this.f780i.get(str);
        if (C0411e.m359a((Object) c0517t0, "No duration event with name: " + str)) {
            return;
        }
        long j = 0;
        if (elapsedRealtime <= 0) {
            IAppLogLogger iAppLogLogger = c0517t0.f1044a;
            if (iAppLogLogger != null) {
                iAppLogLogger.warn(4, "End at illegal time: " + elapsedRealtime, new Object[0]);
            }
        } else {
            c0517t0.m667a(elapsedRealtime);
            IAppLogLogger iAppLogLogger2 = c0517t0.f1044a;
            if (iAppLogLogger2 != null) {
                iAppLogLogger2.debug(4, "[DurationEvent:{}] End[ at:{} and duration is {}ms", c0517t0.f1045b, Long.valueOf(elapsedRealtime), Long.valueOf(c0517t0.f1047d));
            }
            j = c0517t0.f1047d;
        }
        JSONObject jSONObject2 = new JSONObject();
        C0411e.m375c(jSONObject, jSONObject2);
        try {
            jSONObject2.put("$event_duration", j);
        } catch (Throwable th) {
            this.f764D.error("JSON handle failed", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str2)) {
            this.f764D.info(C0380a.m251a("CustomEventName is empty, use eventName, finalEventName: {}", str), new Object[0]);
            str2 = str;
        }
        receive(new C0528u4(str2, jSONObject2));
        this.f780i.remove(str);
    }

    public String toString() {
        return C0380a.m252a("AppLogInstance{id:").append(f760M.get()).append(";appId:").append(this.f784m).append("}@").append(hashCode()).toString();
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void trackClick(View view) {
        trackClick(view, null);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void trackClick(View view, JSONObject jSONObject) {
        JSONObject m664d;
        C0493p4 m345a = C0411e.m345a(view, false);
        if (m345a != null && jSONObject != null) {
            m345a.f884o = jSONObject;
            InitConfig initConfig = getInitConfig();
            if (initConfig != null && initConfig.isClickFillPagePropertiesEnable() && (m664d = C0515s5.m664d(view.getContext())) != null) {
                m345a.f884o = C0411e.m375c(m345a.f884o, m664d);
            }
        }
        receive(m345a);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void trackPage(Activity activity) {
        trackPage(activity, (JSONObject) null);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void trackPage(Activity activity, JSONObject jSONObject) {
        m519a(activity, jSONObject);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void trackPage(Object obj) {
        trackPage(obj, (JSONObject) null);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void trackPage(Object obj, JSONObject jSONObject) {
        m519a(obj, jSONObject);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        if (m523b("userProfileSetOnce")) {
            return;
        }
        C0475n0 c0475n0 = this.f788q;
        if (c0475n0.f840j != null) {
            C0416e4.m388a(c0475n0, 0, jSONObject, userProfileCallback, c0475n0.f840j, false);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    @Deprecated
    public void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        if (m523b("userProfileSync")) {
            return;
        }
        C0475n0 c0475n0 = this.f788q;
        if (c0475n0.f840j != null) {
            C0416e4.m388a(c0475n0, 1, jSONObject, userProfileCallback, c0475n0.f840j, false);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void onEventV3(String str, Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        this.f764D.error("Parse event params failed", th, new Object[0]);
                        m522b().mo639a(th, "onEventV3");
                        onEventV3(str, jSONObject, i);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        onEventV3(str, jSONObject, i);
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void onEventV3(String str, JSONObject jSONObject, int i) {
        if (TextUtils.isEmpty(str)) {
            this.f764D.error("event name is empty", new Object[0]);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        JSONObject m350a = C0411e.m350a(jSONObject);
        IAppLogLogger iAppLogLogger = this.f764D;
        List<String> asList = Arrays.asList("customEvent", "eventV3");
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = m350a != null ? m350a.toString() : null;
        iAppLogLogger.debug(asList, "[event_process][receive] event:{} type:{} params:{} ", objArr);
        InitConfig initConfig = getInitConfig();
        if (initConfig != null && initConfig.isLogEnable()) {
            C0387a6.m273a(this.f764D, str, m350a);
        }
        receive(new C0528u4(this.f784m, str, false, m350a != null ? m350a.toString() : null, i));
        InterfaceC0526u2 monitor = getMonitor();
        String sessionId = getSessionId();
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        C0443i3 c0443i3 = new C0443i3();
        c0443i3.f663a = "onEventV3";
        c0443i3.f664b = elapsedRealtime2 - elapsedRealtime;
        if (monitor != null) {
            ((C0561z2) monitor).m763a(c0443i3);
        }
        if (monitor != null) {
            if (sessionId == null) {
                sessionId = "";
            }
            ((C0561z2) monitor).m763a(new C0429g3(0L, sessionId, 1L));
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void receive(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
            sb.append(IWeiboService.Scope.EMPTY_SCOPE);
        }
        if (this.f788q == null) {
            this.f776e.m723a(strArr);
            return;
        }
        C0475n0 c0475n0 = this.f788q;
        c0475n0.f846p.removeMessages(4);
        c0475n0.f846p.obtainMessage(4, strArr).sendToTarget();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setUserUniqueID(String str, String str2) {
        synchronized (this.f770J) {
            if (this.f787p != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f788q.m541a(str, str2);
                C0547x2.m745a(getMonitor(), "api_usage", "setUserUniqueID", elapsedRealtime);
                return;
            }
            C0494p5<String> c0494p5 = this.f768H;
            c0494p5.f927a = str;
            c0494p5.f928b = true;
            this.f764D.debug("cache uuid before init id -> " + str, new Object[0]);
            C0494p5<String> c0494p52 = this.f769I;
            c0494p52.f927a = str2;
            c0494p52.f928b = true;
            this.f764D.debug("cache uuid before init type -> " + str2, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IAppLogInstance
    public void setHeaderInfo(HashMap<String, Object> hashMap) {
        if (m521a("setHeaderInfo")) {
            return;
        }
        C0387a6.m274a(this.f764D, hashMap);
        this.f787p.m405a(hashMap);
    }

    /* renamed from: a */
    public final void m519a(Object obj, JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Activity activity;
        if (this.f789r == null || obj == null) {
            return;
        }
        C0528u4 c0528u4 = new C0528u4("bav2b_page", true);
        JSONObject jSONObject2 = new JSONObject();
        String name = obj.getClass().getName();
        Iterator<Class<?>> it = C0515s5.f1023d.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                z2 = false;
                break;
            } else if (it.next().isInstance(obj)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            try {
                activity = (Activity) obj.getClass().getMethod("getActivity", new Class[0]).invoke(obj, new Object[0]);
            } catch (Throwable unused) {
                activity = null;
            }
            if (activity != null) {
                name = activity.getClass().getName() + ":" + name;
            }
            z = true;
        }
        try {
            jSONObject2.put("page_key", name);
            jSONObject2.put("is_fragment", z);
            jSONObject2.put(ReportConstant.COMMON_INIT_DURATION, 1000L);
            jSONObject2.put("page_title", C0515s5.m663c(obj));
            jSONObject2.put("page_path", C0515s5.m662b(obj));
            jSONObject2.put("is_custom", true);
            C0411e.m375c(jSONObject, jSONObject2);
        } catch (Throwable unused2) {
        }
        c0528u4.f884o = jSONObject2;
        receive(c0528u4);
    }
}
