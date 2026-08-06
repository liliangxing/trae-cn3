package com.bytedance.sdk.open.douyin.settings;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.commonbase.net.OpenNetworkManager;
import com.bytedance.sdk.open.aweme.core.OpenHostInfoService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.aweme.utils.NetUtils;
import com.bytedance.sdk.open.aweme.utils.ThreadUtils;
import com.bytedance.sdk.open.douyin.settings.C0131g;
import com.bytedance.sdk.open.tt.C0139e;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.open.douyin.settings.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0127c {

    /* renamed from: h */
    private static final String f114h = "OpenSettingsUpdater";

    /* renamed from: a */
    private Context f115a;

    /* renamed from: b */
    private volatile int f116b = 0;

    /* renamed from: c */
    private volatile long f117c = 0;

    /* renamed from: d */
    private volatile boolean f118d = false;

    /* renamed from: e */
    private final List<Integer> f119e = Arrays.asList(0, 60, 60, 120, 240, Integer.valueOf(FConstants.DOWNLOAD_FAIL_CODE));

    /* renamed from: f */
    private C0129e f120f;

    /* renamed from: g */
    protected b f121g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.douyin.settings.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f122a;

        /* renamed from: b */
        final /* synthetic */ String f123b;

        /* renamed from: c */
        final /* synthetic */ Map f124c;

        a(boolean z, String str, Map map) {
            this.f122a = z;
            this.f123b = str;
            this.f124c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0130f m53a;
            C0130f m71c = C0127c.this.f120f.m71c();
            if (!C0127c.this.m58a(this.f122a, m71c)) {
                LogUtils.m27d(C0127c.f114h, "cannot update " + m71c.m74b());
                return;
            }
            synchronized (this) {
                if (C0127c.this.f118d) {
                    LogUtils.m29i(C0127c.f114h, "is updating, ignore " + this.f123b);
                    return;
                }
                C0127c.this.f118d = true;
                try {
                    try {
                        C0127c c0127c = C0127c.this;
                        m53a = c0127c.m53a(c0127c.f115a, m71c, this.f124c, this.f123b);
                    } catch (Exception unused) {
                        C0127c.m63e(C0127c.this);
                    }
                    if (m53a == null) {
                        C0127c.m63e(C0127c.this);
                        return;
                    }
                    C0127c.this.f116b = 0;
                    C0139e.m139a(C0127c.this.f115a).m146a(m53a.m77e());
                    boolean m69a = C0127c.this.f120f.m69a(m53a);
                    C0127c.this.f121g.mo43a(m53a);
                    if (!m69a) {
                        LogUtils.m30w(C0127c.f114h, "saveSettingsModel fail");
                    }
                } finally {
                    C0127c c0127c2 = C0127c.this;
                    c0127c2.f117c = c0127c2.m50a(c0127c2.f116b);
                    C0127c.this.f118d = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.douyin.settings.c$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface b {
        /* renamed from: a */
        void mo43a(C0130f c0130f);
    }

    public C0127c(Context context, C0129e c0129e, b bVar) {
        this.f115a = context;
        this.f120f = c0129e;
        this.f121g = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public long m50a(int i) {
        long currentTimeMillis;
        long intValue;
        if (i == 0) {
            currentTimeMillis = System.currentTimeMillis();
            intValue = 3600000;
        } else {
            int min = Math.min(i, this.f119e.size() - 1);
            currentTimeMillis = System.currentTimeMillis();
            intValue = this.f119e.get(min).intValue() * 1000;
        }
        return currentTimeMillis + intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C0130f m53a(Context context, C0130f c0130f, Map<String, String> map, String str) throws Exception {
        System.currentTimeMillis();
        OpenHostInfoService openHostInfoService = (OpenHostInfoService) OpenServiceManager.getInst().getService(OpenHostInfoService.class);
        if (openHostInfoService == null) {
            LogUtils.m30w(f114h, "OpenHostInfoService is not init");
            return null;
        }
        C0131g m104a = new C0131g.b().m103a(map).m111e(c0130f.m73a()).m101a(c0130f.m76d()).m102a(openHostInfoService.getAppId()).m121j(openHostInfoService.getInstallId()).m115g(openHostInfoService.getDeviceId()).m109d(openHostInfoService.getChannel()).m129n(openHostInfoService.getVersionCode()).m105b(openHostInfoService.getAppName()).m117h(SiteMessageParams.platform).m119i(Build.MODEL).m113f(Build.BRAND).m124k(Build.VERSION.RELEASE).m100a(Build.VERSION.SDK_INT).m127m(openHostInfoService.getUpdateVersionCode()).m130o(openHostInfoService.getVersionName()).m104a();
        LogUtils.m29i(f114h, "requestSettingsModel");
        OpenHostResponse execute = OpenNetworkManager.with(context).newCall(new OpenHostRequest.Builder(m104a.m99a()).addHostCommonParams(true).get().build()).execute();
        C0132h c0132h = new C0132h();
        c0132h.f184a = execute.code;
        c0132h.f185b = execute.message;
        try {
            JSONObject jSONObject = new JSONObject(execute.body.stringBody());
            c0132h.m132a(jSONObject);
            boolean equals = TextUtils.equals("success", jSONObject.getString("message"));
            c0132h.f186c = equals;
            if (equals) {
                c0132h.f189f = jSONObject.getJSONObject("data").getString("ctx_infos");
                c0132h.f188e = jSONObject.getJSONObject("data").getJSONObject(C0130f.f134g);
                c0132h.f190g = jSONObject.getJSONObject("data").optLong(C0130f.f138k, 0L);
                c0132h.f187d = jSONObject.getJSONObject("data").getJSONObject("settings");
            }
        } catch (Exception unused) {
        }
        if (c0132h.f184a != 200) {
            return null;
        }
        return m55a(c0130f, c0132h);
    }

    /* renamed from: a */
    private C0130f m55a(C0130f c0130f, C0132h c0132h) throws Exception {
        JSONObject jSONObject;
        JSONObject jSONObject2 = c0132h.f188e;
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        JSONObject jSONObject3 = jSONObject2;
        String str = TextUtils.isEmpty(c0132h.f189f) ? "" : c0132h.f189f;
        long j = c0132h.f190g;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject4 = new JSONObject();
        if (c0130f.m74b() == 0) {
            JSONObject jSONObject5 = c0132h.f187d;
            if (jSONObject5 != null) {
                jSONObject = jSONObject5;
                return new C0130f(currentTimeMillis, str, jSONObject, jSONObject3, j);
            }
        } else {
            jSONObject4 = new JSONObject(c0130f.m75c().toString());
            JSONObject jSONObject6 = c0132h.f187d;
            if (jSONObject6 != null) {
                Iterator<String> keys = jSONObject6.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject4.put(next, c0132h.f187d.get(next));
                    } catch (Exception unused) {
                    }
                }
            }
        }
        jSONObject = jSONObject4;
        return new C0130f(currentTimeMillis, str, jSONObject, jSONObject3, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m58a(boolean z, C0130f c0130f) {
        if (!NetUtils.isNetworkAvailable(this.f115a)) {
            LogUtils.m29i(f114h, "network not available");
            return false;
        }
        if (z) {
            LogUtils.m29i(f114h, "force update");
            return true;
        }
        if (c0130f.m78f()) {
            LogUtils.m29i(f114h, "settings is valid");
            return false;
        }
        if (System.currentTimeMillis() >= this.f117c) {
            return true;
        }
        LogUtils.m29i(f114h, "frequency limit " + System.currentTimeMillis() + this.f117c);
        return false;
    }

    /* renamed from: e */
    static /* synthetic */ int m63e(C0127c c0127c) {
        int i = c0127c.f116b;
        c0127c.f116b = i + 1;
        return i;
    }

    /* renamed from: a */
    public void m64a(Map<String, String> map, boolean z, String str) {
        ThreadUtils.summit(new a(z, str, map));
    }
}
