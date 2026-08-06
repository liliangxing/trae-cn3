package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import java.util.Collections;

/* renamed from: com.bytedance.tobshadow.bdtracker.z4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0563z4 extends AbstractC0486o4 {

    /* renamed from: f */
    public static C0563z4 f1273f;

    /* renamed from: c */
    public final IKVStore f1274c;

    /* renamed from: d */
    public IKVStore f1275d;

    /* renamed from: e */
    public boolean f1276e;

    /* renamed from: com.bytedance.tobshadow.bdtracker.z4$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface a {
        /* renamed from: a */
        String mo240a();
    }

    public C0563z4(Context context, String str, boolean z) {
        this.f1276e = false;
        this.f1274c = C0424f5.m438a(context, str);
        this.f1276e = z;
    }

    public C0563z4(InitConfig initConfig, Context context, String str, String str2) {
        this.f1276e = false;
        this.f1274c = C0424f5.m439a(initConfig, context, str);
        this.f1275d = C0424f5.m439a(initConfig, context, str2);
    }

    /* renamed from: a */
    public static SharedPreferences m764a(Context context, String str, int i) {
        Context context2;
        Throwable th;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                context2 = context.createDeviceProtectedStorageContext();
                try {
                    if (!context2.moveSharedPreferencesFrom(context, str)) {
                        LoggerImpl.global().warn(Collections.singletonList("SharedPreferenceCacheHelper"), "Failed to migrate shared preferences.", new Object[0]);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    LoggerImpl.global().error(Collections.singletonList("SharedPreferenceCacheHelper"), "Create protected storage context failed", th, new Object[0]);
                    context = context2;
                    return context.getSharedPreferences(str, i);
                }
            } catch (Throwable th3) {
                context2 = context;
                th = th3;
            }
            context = context2;
        }
        return context.getSharedPreferences(str, i);
    }

    /* renamed from: a */
    public static synchronized C0563z4 m765a(Context context) {
        C0563z4 c0563z4;
        synchronized (C0563z4.class) {
            if (f1273f == null) {
                f1273f = new C0563z4(context, "_global_cache", true);
            }
            c0563z4 = f1273f;
        }
        return c0563z4;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4
    /* renamed from: a */
    public void mo530a(String str) {
        IKVStore m767c = m767c(str);
        if (m767c != null && m767c.contains(str)) {
            m767c.remove(str);
        }
        super.mo530a(str);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4
    /* renamed from: a */
    public void mo531a(String str, String str2) {
        if (this.f1276e || !TextUtils.isEmpty(str2)) {
            IKVStore m767c = m767c(str);
            if (this.f1276e && str2 == null) {
                str2 = "";
            }
            m767c.putString(str, str2);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4
    /* renamed from: b */
    public String mo532b(String str) {
        return m767c(str).getString(str, null);
    }

    /* renamed from: c */
    public IKVStore m767c(String str) {
        IKVStore iKVStore;
        return (!"device_id".equals(str) || (iKVStore = this.f1275d) == null) ? this.f1274c : iKVStore;
    }

    /* renamed from: a */
    public synchronized String m766a(String str, a aVar) {
        if (m767c(str).contains(str)) {
            return m767c(str).getString(str, null);
        }
        String mo240a = aVar != null ? aVar.mo240a() : null;
        mo531a(str, mo240a);
        return mo240a;
    }
}
