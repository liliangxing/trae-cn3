package com.bytedance.timonbase.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMLogger;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0003J\n\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130\u0011J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/timonbase/utils/ProcessUtil;", "", "()V", "currentProcessName", "", "getCurrentProcessInfo", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "application", "Landroid/app/Application;", "getCurrentProcessName", "context", "Landroid/content/Context;", "getCurrentProcessNameByActivityThread", "getCurrentProcessNameByApplication", "getCurrentProcessNameByReflect", "getProcessNameFromProcess", "handleRunningAppProcessInfoUse", "Lkotlin/Pair;", "", "", "isMainProcess", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ProcessUtil {
    public static final ProcessUtil INSTANCE = new ProcessUtil();
    private static String currentProcessName = "";

    private ProcessUtil() {
    }

    public final boolean isMainProcess(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        return Intrinsics.areEqual(application.getPackageName(), getCurrentProcessName(application));
    }

    public final String getCurrentProcessName(Context context) {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        String processNameFromProcess = getProcessNameFromProcess();
        currentProcessName = processNameFromProcess;
        if (!TextUtils.isEmpty(processNameFromProcess)) {
            return currentProcessName;
        }
        String currentProcessNameByApplication = getCurrentProcessNameByApplication();
        currentProcessName = currentProcessNameByApplication;
        if (!TextUtils.isEmpty(currentProcessNameByApplication)) {
            return currentProcessName;
        }
        String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        currentProcessName = currentProcessNameByActivityThread;
        return !TextUtils.isEmpty(currentProcessNameByActivityThread) ? currentProcessName : currentProcessName;
    }

    private final String getProcessNameFromProcess() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Process.myProcessName();
        }
        return null;
    }

    private final String getCurrentProcessNameByApplication() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private final String getCurrentProcessNameByActivityThread() {
        try {
            Object invoke = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null) {
                return (String) invoke;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private final String getCurrentProcessNameByReflect(Application application) {
        try {
            Field field = application.getClass().getField("mLoadedApk");
            Intrinsics.checkExpressionValueIsNotNull(field, "loadedApkField");
            field.setAccessible(true);
            Object obj = field.get(application);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            Intrinsics.checkExpressionValueIsNotNull(declaredField, "activityThreadField");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            Object invoke = obj2.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(obj2, new Object[0]);
            if (invoke != null) {
                return (String) invoke;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private final ActivityManager.RunningAppProcessInfo getCurrentProcessInfo(Application application) {
        String str;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        runningAppProcessInfo.processName = getCurrentProcessName(application);
        String[] strArr = new String[1];
        if (application == null || (str = application.getPackageName()) == null) {
            str = "";
        }
        strArr[0] = str;
        runningAppProcessInfo.pkgList = strArr;
        if (TMEnv.INSTANCE.getDEBUG()) {
            TMLogger tMLogger = TMLogger.INSTANCE;
            StringBuilder append = new StringBuilder("构造当前进程RunningAppProcessInfo：processName:").append(runningAppProcessInfo.processName).append(",pid:").append(runningAppProcessInfo.pid).append(",uid:").append(runningAppProcessInfo.uid).append(",importance:").append(runningAppProcessInfo.importance).append(",importanceReasonCode:").append(runningAppProcessInfo.importanceReasonCode).append(",lastTrimLevel:").append(runningAppProcessInfo.lastTrimLevel).append(",pkgList:");
            String[] strArr2 = runningAppProcessInfo.pkgList;
            Intrinsics.checkExpressionValueIsNotNull(strArr2, "info.pkgList");
            tMLogger.m219d("ProcessUtils", append.append(ArraysKt.joinToString$default(strArr2, "｜", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).append(",lru:").append(runningAppProcessInfo.lru).toString());
        }
        return runningAppProcessInfo;
    }

    public final Pair<Boolean, List<ActivityManager.RunningAppProcessInfo>> handleRunningAppProcessInfoUse() {
        return TuplesKt.to(true, CollectionsKt.listOf(getCurrentProcessInfo(TMEnv.INSTANCE.getApplication())));
    }
}
