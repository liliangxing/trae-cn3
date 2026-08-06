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

/* loaded from: classes5.dex */
public class e {
    private static final String d = "_douyin_open_sdk.ab.exposed.vids.sp";
    private static final String e = "vid_key";
    private static final String f = "OpenAbManager";
    private static volatile e g;
    private boolean a = false;
    private SharedPreferences b;
    private SharedPreferences.Editor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ long b;

        a(String str, long j) {
            this.a = str;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.a) {
                e.this.a = true;
                e.this.a();
            }
            synchronized (this) {
                try {
                    if (!e.this.b.contains(this.a)) {
                        e.this.b.edit().putString(this.a, String.valueOf(this.b)).apply();
                        LogUtils.d(e.f, "put vid key=" + this.a);
                    } else if (this.b != Long.parseLong(e.this.b.getString(this.a, "0"))) {
                        e.this.b.edit().putString(this.a, String.valueOf(this.b)).apply();
                        LogUtils.d(e.f, "put vid key=" + this.a);
                    }
                } catch (Exception e) {
                    LogUtils.e(e.f, "updateVidInfo", e);
                }
            }
            e.this.a();
        }
    }

    private e(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(d, 0);
        this.b = sharedPreferences;
        this.c = sharedPreferences.edit();
    }

    public static e a(Context context) {
        if (g == null) {
            synchronized (e.class) {
                if (g == null) {
                    g = new e(context);
                }
            }
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.b.getAll().values()) {
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
        } catch (Exception e2) {
            LogUtils.e(f, "updateAllAppExposeVids", e2);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        long optLong = jSONObject.optLong(str, -1L);
        if (optLong <= 0) {
            return;
        }
        ThreadUtils.summit(new a(str, optLong));
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (!this.a) {
            this.a = true;
            a();
        }
        synchronized (this) {
            for (String str : this.b.getAll().keySet()) {
                try {
                    if (jSONObject.has(str)) {
                        try {
                            if (jSONObject.optLong(str) != Long.parseLong(this.b.getString(str, "0"))) {
                                this.c.remove(str);
                                LogUtils.d(f, "remove vid key=" + str);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        this.c.remove(str);
                        LogUtils.d(f, "remove vid key=" + str);
                    }
                    this.c.apply();
                } catch (Exception e3) {
                    LogUtils.e(f, e3);
                }
            }
            a();
        }
    }
}
