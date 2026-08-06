package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.agconnect.config.impl.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0977c extends AGConnectServicesConfig {

    /* renamed from: a */
    private final Context f822a;

    /* renamed from: b */
    private final String f823b;

    /* renamed from: c */
    private LazyInputStream f824c;

    /* renamed from: d */
    private volatile ConfigReader f825d;

    /* renamed from: e */
    private final Object f826e = new Object();

    /* renamed from: f */
    private AGCRoutePolicy f827f = AGCRoutePolicy.UNKNOWN;

    /* renamed from: g */
    private final Map<String, String> f828g = new HashMap();

    /* renamed from: h */
    private volatile C0979e f829h;

    public C0977c(Context context, String str) {
        this.f822a = context;
        this.f823b = str;
    }

    /* renamed from: a */
    private static LazyInputStream m795a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) { // from class: com.huawei.agconnect.config.impl.c.1
            @Override // com.huawei.agconnect.config.LazyInputStream
            public InputStream get(Context context2) {
                return inputStream;
            }
        };
    }

    /* renamed from: a */
    private static String m796a(String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return "/" + str.substring(i);
    }

    /* renamed from: a */
    private void m797a() {
        Log.d("AGC_ConfigImpl", "initConfigReader");
        if (this.f825d == null) {
            synchronized (this.f826e) {
                if (this.f825d == null) {
                    LazyInputStream lazyInputStream = this.f824c;
                    if (lazyInputStream != null) {
                        this.f825d = new C0983i(lazyInputStream.loadInputStream(), Utf8Charset.NAME);
                        this.f824c.close();
                        this.f824c = null;
                    } else {
                        this.f825d = new C0987m(this.f822a, this.f823b);
                    }
                    this.f829h = new C0979e(this.f825d);
                }
                m799b();
            }
        }
    }

    /* renamed from: b */
    private String m798b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    /* renamed from: b */
    private void m799b() {
        if (this.f827f == AGCRoutePolicy.UNKNOWN) {
            if (this.f825d != null) {
                this.f827f = Utils.getRoutePolicyFromJson(this.f825d.getString("/region", null), this.f825d.getString("/agcgw/url", null));
            } else {
                Log.w("AGConnectServiceConfig", "get route fail , config not ready");
            }
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str, boolean z) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z)));
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.f822a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return Utils.DEFAULT_NAME;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str, int i) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i)));
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getPackageName() {
        return this.f823b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        Log.d("AGC_ConfigImpl", "getRoutePolicy");
        if (this.f827f == null) {
            this.f827f = AGCRoutePolicy.UNKNOWN;
        }
        if (this.f827f == AGCRoutePolicy.UNKNOWN && this.f825d == null) {
            m797a();
        }
        AGCRoutePolicy aGCRoutePolicy = this.f827f;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("path must not be null.");
        }
        if (this.f825d == null) {
            m797a();
        }
        String m796a = m796a(str);
        String str3 = this.f828g.get(m796a);
        if (str3 != null) {
            return str3;
        }
        String m798b = m798b(m796a);
        if (m798b != null) {
            return m798b;
        }
        String string = this.f825d.getString(m796a, str2);
        return C0979e.m809a(string) ? this.f829h.decrypt(string, str2) : string;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f824c = lazyInputStream;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(InputStream inputStream) {
        overlayWith(m795a(this.f822a, inputStream));
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setParam(String str, String str2) {
        this.f828g.put(Utils.fixPath(str), str2);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.f827f = aGCRoutePolicy;
    }
}
