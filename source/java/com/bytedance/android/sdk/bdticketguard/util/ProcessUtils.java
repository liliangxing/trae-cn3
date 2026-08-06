package com.bytedance.android.sdk.bdticketguard.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: ProcessUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0003J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/util/ProcessUtils;", "", "()V", "currentProcessName", "", "getCurrentProcessName", "()Ljava/lang/String;", "setCurrentProcessName", "(Ljava/lang/String;)V", "isMainProcess", "", "()Ljava/lang/Boolean;", "setMainProcess", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCurProcessNameFromProc", "context", "Landroid/content/Context;", "getCurrentProcessNameByActivityManager", "getCurrentProcessNameByActivityThread", "getCurrentProcessNameByApplication", "getPackageProcessName", "applicationContext", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ProcessUtils {
    public static final ProcessUtils INSTANCE = new ProcessUtils();
    private static String currentProcessName = "";
    private static Boolean isMainProcess;

    private ProcessUtils() {
    }

    public final String getCurrentProcessName() {
        return currentProcessName;
    }

    public final void setCurrentProcessName(String str) {
        currentProcessName = str;
    }

    public final String getCurrentProcessName(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        String currentProcessNameByApplication = getCurrentProcessNameByApplication();
        currentProcessName = currentProcessNameByApplication;
        if (!TextUtils.isEmpty(currentProcessNameByApplication)) {
            return currentProcessName;
        }
        String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        currentProcessName = currentProcessNameByActivityThread;
        if (!TextUtils.isEmpty(currentProcessNameByActivityThread)) {
            return currentProcessName;
        }
        String curProcessNameFromProc = getCurProcessNameFromProc();
        currentProcessName = curProcessNameFromProc;
        if (!TextUtils.isEmpty(curProcessNameFromProc)) {
            return currentProcessName;
        }
        String currentProcessNameByActivityManager = getCurrentProcessNameByActivityManager(context);
        currentProcessName = currentProcessNameByActivityManager;
        return currentProcessNameByActivityManager;
    }

    public final Boolean isMainProcess() {
        return isMainProcess;
    }

    public final void setMainProcess(Boolean bool) {
        isMainProcess = bool;
    }

    public final boolean isMainProcess(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (isMainProcess == null) {
            synchronized (this) {
                if (isMainProcess == null) {
                    ProcessUtils processUtils = INSTANCE;
                    String currentProcessName2 = processUtils.getCurrentProcessName(context);
                    String packageProcessName = processUtils.getPackageProcessName(context);
                    TicketGuardUtilsKt.log("curProcessName=" + currentProcessName2 + ", packageProcessName=" + packageProcessName);
                    isMainProcess = Boolean.valueOf(TextUtils.equals(currentProcessName2, packageProcessName));
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return Intrinsics.areEqual(isMainProcess, true);
    }

    private final String getPackageProcessName(Context applicationContext) {
        try {
            return applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).processName;
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(e)");
            TicketGuardEventHelper.monitorGetPackageProcessNameError(stackTraceString);
            return null;
        }
    }

    private final String getCurrentProcessNameByApplication() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception e) {
            TicketGuardUtilsKt.log("getCurrentProcessNameByApplication exception, e=" + Log.getStackTraceString(e));
            return null;
        }
    }

    private final String getCurrentProcessNameByActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "Class.forName(\"android.a…rayOfNulls<Class<*>?>(0))");
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Intrinsics.checkExpressionValueIsNotNull(invoke, "declaredMethod.invoke(null, arrayOfNulls<Any>(0))");
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            TicketGuardUtilsKt.log("getCurrentProcessNameByActivityThread exception, e=" + Log.getStackTraceString(th));
            return null;
        }
    }

    private final String getCurProcessNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                Ref.IntRef intRef = new Ref.IntRef();
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    intRef.element = read;
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) intRef.element);
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    TicketGuardUtilsKt.log("getCurProcessNameFromProc, cmdlineReader.close() error, e=" + Log.getStackTraceString(e));
                }
                return sb2;
            } catch (Throwable th) {
                th = th;
                try {
                    TicketGuardUtilsKt.log("getCurProcessNameFromProc error, e=" + Log.getStackTraceString(th));
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e2) {
                            TicketGuardUtilsKt.log("getCurProcessNameFromProc, cmdlineReader.close() error, e=" + Log.getStackTraceString(e2));
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    private final String getCurrentProcessNameByActivityManager(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        Object systemService = context.getSystemService("activity");
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }
}
