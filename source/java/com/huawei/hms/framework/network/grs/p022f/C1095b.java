package com.huawei.hms.framework.network.grs.p022f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C1119a;
import com.huawei.hms.framework.network.grs.p021e.C1091a;
import com.huawei.hms.framework.network.grs.p021e.C1093c;
import com.huawei.hms.framework.network.grs.p026h.C1114c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* renamed from: com.huawei.hms.framework.network.grs.f.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1095b {

    /* renamed from: b */
    private static final Map<String, C1095b> f1303b = new ConcurrentHashMap(16);

    /* renamed from: c */
    private static final Object f1304c = new Object();

    /* renamed from: a */
    private AbstractC1094a f1305a;

    public C1095b() {
        this.f1305a = new C1097d(true, true);
    }

    public C1095b(Context context, boolean z) {
        m1271a(context, z);
        f1303b.put(context.getPackageName(), this);
    }

    /* renamed from: a */
    public static C1095b m1270a(String str) {
        return f1303b.get(str);
    }

    /* renamed from: a */
    private void m1271a(Context context, boolean z) {
        String[] split;
        long currentTimeMillis = System.currentTimeMillis();
        String m1371a = C1114c.m1371a("grs_route_config_files_list.txt", context);
        Logger.m1186i("LocalManagerProxy", "initLocalManager configFileListContent TimeCost:%d  Content:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), m1371a);
        if (TextUtils.isEmpty(m1371a)) {
            long currentTimeMillis2 = System.currentTimeMillis();
            split = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
            Logger.m1185i("LocalManagerProxy", "list by AssetsManager, timeCost:" + (System.currentTimeMillis() - currentTimeMillis2));
        } else {
            split = m1371a.split("#");
        }
        List<String> arrayList = split == null ? new ArrayList<>() : Arrays.asList(split);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.m1185i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        this.f1305a = new C1097d(false, z);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f1305a = new C1097d(context, appConfigName, z);
        }
        if (!this.f1305a.m1265d() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.f1305a = new C1096c(context, z);
        }
        this.f1305a.m1259a(context, arrayList);
        Logger.m1185i("LocalManagerProxy", "on initLocalManager finish, check appGrs: " + (this.f1305a.f1298a == null));
    }

    /* renamed from: a */
    public C1119a m1272a() {
        return this.f1305a.m1261b();
    }

    /* renamed from: a */
    public String m1273a(Context context, C1091a c1091a, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        String m1254a;
        synchronized (f1304c) {
            m1254a = this.f1305a.m1254a(context, c1091a, grsBaseInfo, str, str2, z);
        }
        return m1254a;
    }

    /* renamed from: a */
    public Map<String, String> m1274a(Context context, C1091a c1091a, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        Map<String, String> m1257a;
        synchronized (f1304c) {
            m1257a = this.f1305a.m1257a(context, c1091a, grsBaseInfo, str, z);
        }
        return m1257a;
    }

    /* renamed from: a */
    public void m1275a(String str, C1093c c1093c) {
        String str2;
        try {
            c1093c.m1248b(str + "#localConfig", this.f1305a.m1258a().toString());
        } catch (JSONException unused) {
            str2 = "save local config encounter JSONException.";
            Logger.m1189w("LocalManagerProxy", str2);
        } catch (Throwable th) {
            str2 = "save local config encounter Throwable:" + StringUtils.anonymizeMessage(th.getMessage());
            Logger.m1189w("LocalManagerProxy", str2);
        }
    }

    /* renamed from: a */
    public boolean m1276a(Context context, String str) {
        boolean m1266d = this.f1305a.m1266d(str);
        f1303b.put(context.getPackageName(), this);
        return m1266d;
    }

    /* renamed from: b */
    public Set<String> m1277b() {
        return this.f1305a.m1264c();
    }
}
