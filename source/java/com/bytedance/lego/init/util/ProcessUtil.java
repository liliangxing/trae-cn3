package com.bytedance.lego.init.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.lego.init.model.InitTaskProcess;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ProcessUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lego/init/util/ProcessUtil;", "", "()V", "sCurrentProcessName", "", "getCurProcessNameFromProc", "getCurrentProcessName", "context", "Landroid/content/Context;", "isMainProcess", "", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ProcessUtil {
    public static final ProcessUtil INSTANCE = new ProcessUtil();
    private static String sCurrentProcessName;

    private ProcessUtil() {
    }

    public final boolean isMainProcess(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        String currentProcessName = getCurrentProcessName(context);
        return (currentProcessName == null || !StringsKt.contains$default(currentProcessName, ":", false, 2, (Object) null)) && currentProcessName != null && Intrinsics.areEqual(currentProcessName, context.getPackageName());
    }

    public final String getCurrentProcessName(Context context) {
        int myPid;
        Object systemService;
        Intrinsics.checkParameterIsNotNull(context, "context");
        String str = sCurrentProcessName;
        if (!(str == null || str.length() == 0)) {
            String str2 = sCurrentProcessName;
            if (str2 == null) {
                Intrinsics.throwNpe();
            }
            return str2;
        }
        try {
            myPid = Process.myPid();
            systemService = context.getSystemService("activity");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                InitLogger.d$default(InitLogger.INSTANCE, null, "processName = " + runningAppProcessInfo.processName, 1, null);
                String str3 = runningAppProcessInfo.processName;
                sCurrentProcessName = str3;
                return str3 != null ? str3 : InitTaskProcess.NONMAIN;
            }
        }
        String curProcessNameFromProc = getCurProcessNameFromProc();
        sCurrentProcessName = curProcessNameFromProc;
        return curProcessNameFromProc != null ? curProcessNameFromProc : InitTaskProcess.NONMAIN;
    }

    private final String getCurProcessNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                for (int read = bufferedReader.read(); read > 0; read = bufferedReader.read()) {
                    sb.append((char) read);
                }
                InitLogger.d$default(InitLogger.INSTANCE, null, "processName = " + ((Object) sb), 1, null);
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return sb2;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }
}
