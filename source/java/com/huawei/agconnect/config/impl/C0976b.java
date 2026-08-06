package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.core.Service;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.agconnect.config.impl.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0976b implements AGConnectOptions {

    /* renamed from: a */
    private final String f813a;

    /* renamed from: b */
    private final Context f814b;

    /* renamed from: c */
    private final String f815c;

    /* renamed from: d */
    private final AGCRoutePolicy f816d;

    /* renamed from: e */
    private final ConfigReader f817e;

    /* renamed from: f */
    private final C0979e f818f;

    /* renamed from: g */
    private final Map<String, String> f819g;

    /* renamed from: h */
    private final List<Service> f820h;

    /* renamed from: i */
    private final Map<String, String> f821i = new HashMap();

    public C0976b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list, String str2) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f814b = context;
        str = str == null ? context.getPackageName() : str;
        this.f815c = str;
        if (inputStream != null) {
            this.f817e = new C0983i(inputStream, str);
            Utils.closeQuietly(inputStream);
        } else {
            this.f817e = new C0987m(context, str);
        }
        this.f818f = new C0979e(this.f817e);
        if (aGCRoutePolicy != AGCRoutePolicy.UNKNOWN && "1.0".equals(this.f817e.getString("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.f816d = (aGCRoutePolicy == null || aGCRoutePolicy == AGCRoutePolicy.UNKNOWN) ? Utils.getRoutePolicyFromJson(this.f817e.getString("/region", null), this.f817e.getString("/agcgw/url", null)) : aGCRoutePolicy;
        this.f819g = Utils.fixKeyPathMap(map);
        this.f820h = list;
        this.f813a = str2 == null ? m793b() : str2;
    }

    /* renamed from: a */
    private String m792a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (!processors.containsKey(str)) {
            return null;
        }
        if (this.f821i.containsKey(str)) {
            return this.f821i.get(str);
        }
        JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
        if (jsonProcessor == null) {
            return null;
        }
        String processOption = jsonProcessor.processOption(this);
        this.f821i.put(str, processOption);
        return processOption;
    }

    /* renamed from: b */
    private String m793b() {
        return String.valueOf(("{packageName='" + this.f815c + "', routePolicy=" + this.f816d + ", reader=" + this.f817e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f819g).toString().hashCode() + '}').hashCode());
    }

    /* renamed from: a */
    public List<Service> m794a() {
        return this.f820h;
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
        return this.f814b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return this.f813a;
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
        return this.f815c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.f816d;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String fixPath = Utils.fixPath(str);
        String str3 = this.f819g.get(fixPath);
        if (str3 != null) {
            return str3;
        }
        String m792a = m792a(fixPath);
        if (m792a != null) {
            return m792a;
        }
        String string = this.f817e.getString(fixPath, str2);
        return C0979e.m809a(string) ? this.f818f.decrypt(string, str2) : string;
    }
}
