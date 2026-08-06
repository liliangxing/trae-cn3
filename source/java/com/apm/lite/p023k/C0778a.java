package com.apm.lite.p023k;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.lite.p012b.C0736e;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p018f.C0755a;
import com.apm.lite.runtime.p024a.C0812b;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.apm.lite.k.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0778a {

    /* renamed from: a */
    private static String f568a;

    /* renamed from: b */
    private static Class<?> f569b;

    /* renamed from: c */
    private static Field f570c;

    /* renamed from: d */
    private static Field f571d;

    /* renamed from: e */
    private static boolean f572e;

    /* renamed from: a */
    private static long m736a(int i) {
        if (i < 0) {
            return 0L;
        }
        return i * 1024;
    }

    /* renamed from: a */
    public static ActivityManager.ProcessErrorStateInfo m737a(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        int myPid = Process.myPid();
        int i2 = 0;
        while (i2 < i) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.pid == myPid && processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
            }
            i2++;
            if (i == i2 || C0736e.m433a()) {
                break;
            }
            SystemClock.sleep(200L);
        }
        return null;
    }

    /* renamed from: a */
    private static String m738a() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return Application.getProcessName();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m739a(Context context, JSONObject jSONObject) {
        try {
            m741a(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                m745b(jSONObject, activityManager);
            }
            m742a(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m740a(String str) {
        f568a = str;
    }

    /* renamed from: a */
    private static void m741a(JSONObject jSONObject) {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", m736a(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", m736a(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", m736a(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", m736a(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", m736a(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", m736a(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", m736a(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", m736a(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        try {
            String memoryStat = memoryInfo.getMemoryStat("summary.graphics");
            if (!TextUtils.isEmpty(memoryStat)) {
                jSONObject2.put("summary.graphics", m736a(Integer.parseInt(memoryStat)));
            }
        } catch (Throwable unused) {
        }
        jSONObject2.put("totalPrivateClean", C0780c.m754a(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", m736a(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", C0780c.m755b(memoryInfo));
        jSONObject2.put("totalSharedDirty", m736a(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", m736a(C0780c.m756c(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    /* renamed from: a */
    private static void m742a(JSONObject jSONObject, ActivityManager activityManager) {
        JSONObject jSONObject2 = new JSONObject();
        C0745a.m466a(jSONObject, "filters", "native_heap_leak", String.valueOf(Debug.getNativeHeapAllocatedSize() > 209715200));
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long freeMemory = runtime.freeMemory();
        long j = runtime.totalMemory();
        jSONObject2.put("max_memory", maxMemory);
        jSONObject2.put("free_memory", freeMemory);
        jSONObject2.put("total_memory", j);
        C0745a.m466a(jSONObject, "filters", "java_heap_leak", String.valueOf(((float) (j - freeMemory)) > ((float) maxMemory) * 0.95f));
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    /* renamed from: a */
    public static boolean m743a(Context context) {
        return context == null ? C0812b.m1057d().m1084f() : C0812b.m1057d().m1084f() || m751f(context);
    }

    /* renamed from: b */
    private static String m744b() {
        try {
            return (String) C0755a.m617a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static void m745b(JSONObject jSONObject, ActivityManager activityManager) {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put(StrategyConstants.THRESHOLD, memoryInfo.threshold);
        jSONObject2.put("totalMem", C0791n.m843a(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    /* renamed from: b */
    public static boolean m746b(Context context) {
        String m748c = m748c(context);
        if (m748c != null && m748c.contains(":")) {
            return false;
        }
        if (m748c == null || !m748c.equals(context.getPackageName())) {
            return m748c != null && m748c.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    /* renamed from: c */
    private static String m747c() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    String sb2 = sb.toString();
                    C0788k.m813a(bufferedReader);
                    return sb2;
                }
                sb.append((char) read);
            }
        } catch (Throwable unused2) {
            C0788k.m813a(bufferedReader);
            return null;
        }
    }

    /* renamed from: c */
    public static String m748c(Context context) {
        if (!TextUtils.isEmpty(f568a)) {
            return f568a;
        }
        String m738a = m738a();
        f568a = m738a;
        if (!TextUtils.isEmpty(m738a)) {
            return f568a;
        }
        String m744b = m744b();
        f568a = m744b;
        if (!TextUtils.isEmpty(m744b)) {
            return f568a;
        }
        String m747c = m747c();
        f568a = m747c;
        return m747c;
    }

    /* renamed from: d */
    public static String m749d(Context context) {
        Class<?> m752g = m752g(context);
        if (f570c == null && m752g != null) {
            try {
                f570c = m752g.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = f570c;
        if (field == null) {
            return "";
        }
        try {
            return String.valueOf(field.get(null));
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* renamed from: e */
    public static int m750e(Context context) {
        Class<?> m752g = m752g(context);
        if (f571d == null && m752g != null) {
            try {
                f571d = m752g.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = f571d;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get(null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    /* renamed from: f */
    private static boolean m751f(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null) {
                if (packageName.equals(componentName.getPackageName())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: g */
    private static Class<?> m752g(Context context) {
        if (f569b == null && !f572e) {
            try {
                f569b = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            f572e = true;
        }
        return f569b;
    }
}
