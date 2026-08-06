package com.bytedance.sdk.open.tt;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.OpenHostSettingService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.aweme.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.open.tt.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0139e {

    /* renamed from: d */
    private static final String f214d = "_douyin_open_sdk.ab.exposed.vids.sp";

    /* renamed from: e */
    private static final String f215e = "vid_key";

    /* renamed from: f */
    private static final String f216f = "OpenAbManager";

    /* renamed from: g */
    private static volatile C0139e f217g;

    /* renamed from: a */
    private boolean f218a = false;

    /* renamed from: b */
    private SharedPreferences f219b;

    /* renamed from: c */
    private SharedPreferences.Editor f220c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.tt.e$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f221a;

        /* renamed from: b */
        final /* synthetic */ long f222b;

        a(String str, long j) {
            this.f221a = str;
            this.f222b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C0139e.this.f218a) {
                C0139e.this.f218a = true;
                C0139e.this.m140a();
            }
            synchronized (this) {
                try {
                    if (!C0139e.this.f219b.contains(this.f221a)) {
                        C0139e.this.f219b.edit().putString(this.f221a, String.valueOf(this.f222b)).apply();
                        LogUtils.m27d(C0139e.f216f, "put vid key=" + this.f221a);
                    } else if (this.f222b != Long.parseLong(C0139e.this.f219b.getString(this.f221a, "0"))) {
                        C0139e.this.f219b.edit().putString(this.f221a, String.valueOf(this.f222b)).apply();
                        LogUtils.m27d(C0139e.f216f, "put vid key=" + this.f221a);
                    }
                } catch (Exception e) {
                    LogUtils.m28e(C0139e.f216f, "updateVidInfo", e);
                }
            }
            C0139e.this.m140a();
        }
    }

    private C0139e(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f214d, 0);
        this.f219b = sharedPreferences;
        this.f220c = sharedPreferences.edit();
    }

    /* renamed from: a */
    public static C0139e m139a(Context context) {
        if (f217g == null) {
            synchronized (C0139e.class) {
                if (f217g == null) {
                    f217g = new C0139e(context);
                }
            }
        }
        return f217g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m140a() {
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.f219b.getAll().values()) {
                if (obj instanceof String) {
                    arrayList.add((String) obj);
                }
            }
            OpenHostSettingService openHostSettingService = (OpenHostSettingService) OpenServiceManager.getInst().getService(OpenHostSettingService.class);
            if (openHostSettingService != null) {
                List<String> exposeVids = openHostSettingService.getExposeVids();
                if (exposeVids != null) {
                    arrayList.addAll(exposeVids);
                }
                openHostSettingService.setExposeVids(arrayList);
            }
        } catch (Exception e) {
            LogUtils.m28e(f216f, "updateAllAppExposeVids", e);
        }
    }

    /* renamed from: a */
    public void m145a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        long optLong = jSONObject.optLong(str, -1L);
        if (optLong <= 0) {
            return;
        }
        ThreadUtils.summit(new a(str, optLong));
    }

    /* renamed from: a */
    public void m146a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (!this.f218a) {
            this.f218a = true;
            m140a();
        }
        synchronized (this) {
            for (String str : this.f219b.getAll().keySet()) {
                try {
                    if (jSONObject.has(str)) {
                        try {
                            if (jSONObject.optLong(str) != Long.parseLong(this.f219b.getString(str, "0"))) {
                                this.f220c.remove(str);
                                LogUtils.m27d(f216f, "remove vid key=" + str);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.f220c.remove(str);
                        LogUtils.m27d(f216f, "remove vid key=" + str);
                    }
                    this.f220c.apply();
                } catch (Exception e2) {
                    LogUtils.m28e(f216f, e2);
                }
            }
            m140a();
        }
    }
}
