package com.huawei.agconnect.core.p017a;

import android.content.Context;
import android.util.Log;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.impl.C0976b;
import com.huawei.agconnect.config.impl.Utils;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.agconnect.core.a.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0991b extends AGConnectInstance {

    /* renamed from: a */
    private static List<Service> f867a;

    /* renamed from: b */
    private static final Map<String, AGConnectInstance> f868b = new HashMap();

    /* renamed from: c */
    private static String f869c;

    /* renamed from: d */
    private final AGConnectOptions f870d;

    /* renamed from: e */
    private final C0993d f871e;

    /* renamed from: f */
    private final C0993d f872f;

    public C0991b(AGConnectOptions aGConnectOptions) {
        Log.d("AGC_Instance", "AGConnectInstanceImpl init");
        this.f870d = aGConnectOptions;
        if (f867a == null) {
            Log.e("AGC_Instance", "please call `initialize()` first");
        }
        this.f871e = new C0993d(f867a, aGConnectOptions.getContext());
        C0993d c0993d = new C0993d(null, aGConnectOptions.getContext());
        this.f872f = c0993d;
        if (aGConnectOptions instanceof C0976b) {
            c0993d.m850a(((C0976b) aGConnectOptions).m794a(), aGConnectOptions.getContext());
        }
        Log.d("AGC_Instance", "AGConnectInstanceImpl init end");
    }

    /* renamed from: a */
    public static AGConnectInstance m830a() {
        String str = f869c;
        if (str == null) {
            str = Utils.DEFAULT_NAME;
        }
        return m833a(str);
    }

    /* renamed from: a */
    public static AGConnectInstance m831a(AGConnectOptions aGConnectOptions) {
        return m832a(aGConnectOptions, false);
    }

    /* renamed from: a */
    private static synchronized AGConnectInstance m832a(AGConnectOptions aGConnectOptions, boolean z) {
        AGConnectInstance aGConnectInstance;
        synchronized (C0991b.class) {
            Map<String, AGConnectInstance> map = f868b;
            aGConnectInstance = map.get(aGConnectOptions.getIdentifier());
            if (aGConnectInstance == null || z) {
                aGConnectInstance = new C0991b(aGConnectOptions);
                map.put(aGConnectOptions.getIdentifier(), aGConnectInstance);
            }
        }
        return aGConnectInstance;
    }

    /* renamed from: a */
    public static synchronized AGConnectInstance m833a(String str) {
        AGConnectInstance aGConnectInstance;
        synchronized (C0991b.class) {
            aGConnectInstance = f868b.get(str);
            if (aGConnectInstance == null) {
                if (Utils.DEFAULT_NAME.equals(str)) {
                    Log.w("AGC_Instance", "please call `initialize()` first");
                } else {
                    Log.w("AGC_Instance", "not find instance for : " + str);
                }
            }
        }
        return aGConnectInstance;
    }

    /* renamed from: a */
    public static synchronized void m834a(Context context) {
        synchronized (C0991b.class) {
            Log.w("AGC_Instance", "agc sdk initialize");
            if (f868b.size() > 0) {
                Log.w("AGC_Instance", "Repeated invoking initialize");
            } else {
                m835a(context, AGConnectServicesConfig.fromContext(context));
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m835a(Context context, AGConnectOptions aGConnectOptions) {
        synchronized (C0991b.class) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                Log.w("AGC_Instance", "context.getApplicationContext null");
            } else {
                context = applicationContext;
            }
            m837b();
            if (f867a == null) {
                f867a = new C0992c(context).m844a();
            }
            m832a(aGConnectOptions, true);
            f869c = aGConnectOptions.getIdentifier();
            Log.i("AGC_Instance", "initFinish callback start");
            C0990a.m829a();
            Log.i("AGC_Instance", "AGC SDK initialize end");
        }
    }

    /* renamed from: a */
    public static synchronized void m836a(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        synchronized (C0991b.class) {
            m838b(context, aGConnectOptionsBuilder);
            m835a(context, aGConnectOptionsBuilder.build(context));
        }
    }

    /* renamed from: b */
    private static void m837b() {
        JsonProcessingFactory.registerProcessor("/agcgw/url", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.1
            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE";
                } else {
                    if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                        return null;
                    }
                    str = "/agcgw_all/SG";
                }
                return aGConnectOptions.getString(str);
            }
        });
        JsonProcessingFactory.registerProcessor("/agcgw/backurl", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.2
            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE_back";
                } else {
                    if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                        return null;
                    }
                    str = "/agcgw_all/SG_back";
                }
                return aGConnectOptions.getString(str);
            }
        });
    }

    /* renamed from: b */
    private static void m838b(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        AGConnectServicesConfig fromContext = AGConnectServicesConfig.fromContext(context);
        if (aGConnectOptionsBuilder.getInputStream() != null) {
            try {
                String utils = Utils.toString(aGConnectOptionsBuilder.getInputStream(), Utf8Charset.NAME);
                aGConnectOptionsBuilder.getInputStream().reset();
                fromContext.overlayWith(new ByteArrayInputStream(utils.getBytes(Charset.forName(Utf8Charset.NAME))));
            } catch (IOException unused) {
                Log.e("AGC_Instance", "input stream set to AGConnectServicesConfig fail");
            }
        }
        for (Map.Entry<String, String> entry : aGConnectOptionsBuilder.getCustomConfigMap().entrySet()) {
            fromContext.setParam(entry.getKey(), entry.getValue());
        }
        if (aGConnectOptionsBuilder.getRoutePolicy() != AGCRoutePolicy.UNKNOWN) {
            fromContext.setRoutePolicy(aGConnectOptionsBuilder.getRoutePolicy());
        }
    }

    /* renamed from: a */
    public void m839a(final CustomAuthProvider customAuthProvider) {
        this.f872f.m850a(Collections.singletonList(Service.builder((Class<?>) AuthProvider.class, new AuthProvider() { // from class: com.huawei.agconnect.core.a.b.4
            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public void addTokenListener(OnTokenListener onTokenListener) {
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public Task<Token> getTokens() {
                return customAuthProvider.getTokens(false);
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public Task<Token> getTokens(boolean z) {
                return customAuthProvider.getTokens(z);
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public String getUid() {
                return "";
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public void removeTokenListener(OnTokenListener onTokenListener) {
            }
        }).build()), this.f870d.getContext());
    }

    /* renamed from: a */
    public void m840a(final CustomCredentialsProvider customCredentialsProvider) {
        this.f872f.m850a(Collections.singletonList(Service.builder((Class<?>) CredentialsProvider.class, new CredentialsProvider() { // from class: com.huawei.agconnect.core.a.b.3
            @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
            public Task<Token> getTokens() {
                return customCredentialsProvider.getTokens(false);
            }

            @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
            public Task<Token> getTokens(boolean z) {
                return customCredentialsProvider.getTokens(z);
            }
        }).build()), this.f870d.getContext());
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public Context getContext() {
        return this.f870d.getContext();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public String getIdentifier() {
        return this.f870d.getIdentifier();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public AGConnectOptions getOptions() {
        return this.f870d;
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public <T> T getService(Class<? super T> cls) {
        T t = (T) this.f872f.m849a(this, cls);
        return t != null ? t : (T) this.f871e.m849a(this, cls);
    }
}
