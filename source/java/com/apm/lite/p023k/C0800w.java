package com.apm.lite.p023k;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.apm.lite.C0749e;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.apm.lite.k.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0800w {
    /* renamed from: a */
    public static long m941a(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: a */
    public static JSONObject m942a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_free", m944b());
            jSONObject.put("inner_total", m946c());
            jSONObject.put("sdcard_free", m949f());
            jSONObject.put("sdcard_total", m950g());
            jSONObject.put("inner_free_real", m947d());
            jSONObject.put("inner_total_real", m948e());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static boolean m943a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: b */
    private static long m944b() {
        try {
            return m945b(Environment.getRootDirectory());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: b */
    public static long m945b(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: c */
    private static long m946c() {
        try {
            return m941a(Environment.getRootDirectory());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: d */
    private static long m947d() {
        try {
            return m945b(C0749e.m565g().getFilesDir());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: e */
    private static long m948e() {
        try {
            return m941a(C0749e.m565g().getFilesDir());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: f */
    private static long m949f() {
        try {
            if (m943a()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: g */
    private static long m950g() {
        try {
            if (m943a()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
