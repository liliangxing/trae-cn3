package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectApp;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.core.p017a.C0991b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.agconnect.config.impl.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0975a extends AGConnectApp {

    /* renamed from: a */
    private static final Map<String, AGConnectApp> f809a = new HashMap();

    /* renamed from: b */
    private static final Object f810b = new Object();

    /* renamed from: c */
    private static String f811c;

    /* renamed from: d */
    private AGConnectServicesConfig f812d;

    private C0975a(Context context, String str) {
        this.f812d = AGConnectServicesConfig.fromContext(context, str);
    }

    /* renamed from: a */
    public static AGConnectApp m788a() {
        return m791a(f811c);
    }

    /* renamed from: a */
    public static AGConnectApp m789a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String packageName = context.getPackageName();
        f811c = packageName;
        return m790a(context, packageName);
    }

    /* renamed from: a */
    public static AGConnectApp m790a(Context context, String str) {
        AGConnectApp aGConnectApp;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName can not be empty");
        }
        synchronized (f810b) {
            Map<String, AGConnectApp> map = f809a;
            aGConnectApp = map.get(str);
            if (aGConnectApp == null) {
                map.put(str, new C0975a(context, str));
            }
        }
        return aGConnectApp;
    }

    /* renamed from: a */
    public static AGConnectApp m791a(String str) {
        AGConnectApp aGConnectApp;
        synchronized (f810b) {
            aGConnectApp = f809a.get(str);
            if (aGConnectApp == null) {
                throw new IllegalStateException("you should call AGConnectApp.initialize first");
            }
        }
        return aGConnectApp;
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setApiKey(String str) {
        this.f812d.setParam("/client/api_key", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setAppId(String str) {
        this.f812d.setParam("/client/app_id", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setClientId(String str) {
        this.f812d.setParam("/client/client_id", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setClientSecret(String str) {
        this.f812d.setParam("/client/client_secret", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCpId(String str) {
        this.f812d.setParam("/client/cp_id", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCustomAuthProvider(CustomAuthProvider customAuthProvider) {
        ((C0991b) AGConnectInstance.getInstance()).m839a(customAuthProvider);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCustomCredentialsProvider(CustomCredentialsProvider customCredentialsProvider) {
        ((C0991b) AGConnectInstance.getInstance()).m840a(customCredentialsProvider);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setParam(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("path can not be empty");
        }
        this.f812d.setParam(str, str2);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setProductId(String str) {
        this.f812d.setParam("/client/product_id", str);
    }
}
