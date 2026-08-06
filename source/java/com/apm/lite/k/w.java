package com.apm.lite.k;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.crash.dumper.Scraps;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class w {
    public static long a(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Scraps.INNER_FREE, b());
            jSONObject.put(Scraps.INNER_TOTAL, c());
            jSONObject.put(Scraps.SDCARD_FREE, f());
            jSONObject.put("sdcard_total", g());
            jSONObject.put("inner_free_real", d());
            jSONObject.put("inner_total_real", e());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static long b() {
        try {
            return b(Environment.getRootDirectory());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long b(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long c() {
        try {
            return a(Environment.getRootDirectory());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long d() {
        try {
            return b(com.apm.lite.e.g().getFilesDir());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long e() {
        try {
            return a(com.apm.lite.e.g().getFilesDir());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long f() {
        try {
            if (a()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long g() {
        try {
            if (a()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
