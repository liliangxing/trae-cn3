package com.apm.lite.p012b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0795r;
import com.apm.lite.p023k.C0799v;
import org.json.JSONObject;

/* renamed from: com.apm.lite.b.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0734c {

    /* renamed from: a */
    private static String f386a = null;

    /* renamed from: b */
    private static long f387b = -1;

    /* renamed from: c */
    private static boolean f388c;

    /* renamed from: d */
    private static ActivityManager.ProcessErrorStateInfo f389d;

    /* renamed from: a */
    static String m420a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        if (!C0749e.m578t()) {
            return "|------------- processErrorStateInfo--------------|\ndisable anr info\n\"-----------------------end----------------------------\"";
        }
        StringBuilder sb = new StringBuilder("|------------- processErrorStateInfo--------------|\n");
        sb.append("condition: " + processErrorStateInfo.condition + "\n");
        sb.append("processName: " + processErrorStateInfo.processName + "\n");
        sb.append("pid: " + processErrorStateInfo.pid + "\n");
        sb.append("uid: " + processErrorStateInfo.uid + "\n");
        sb.append("tag: " + processErrorStateInfo.tag + "\n");
        sb.append("shortMsg : " + processErrorStateInfo.shortMsg + "\n");
        sb.append("longMsg : " + processErrorStateInfo.longMsg + "\n");
        sb.append("-----------------------end----------------------------");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m421a(Context context, int i) {
        if (C0795r.m896a(256)) {
            f388c = false;
            return "TEST_ANR_INFO";
        }
        if (SystemClock.uptimeMillis() - f387b < CoroutineLiveDataKt.DEFAULT_TIMEOUT) {
            return null;
        }
        try {
            ActivityManager.ProcessErrorStateInfo m737a = C0778a.m737a(context, i);
            if (m737a != null && Process.myPid() == m737a.pid) {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfo = f389d;
                if (processErrorStateInfo != null && m424a(processErrorStateInfo, m737a)) {
                    return null;
                }
                f389d = m737a;
                f386a = null;
                f387b = SystemClock.uptimeMillis();
                f388c = false;
                return m420a(m737a);
            }
        } catch (Throwable unused) {
        }
        String str = f386a;
        if (str == null) {
            return null;
        }
        f388c = true;
        f386a = null;
        f387b = SystemClock.uptimeMillis();
        return str;
    }

    /* renamed from: a */
    public static JSONObject m422a(boolean z) {
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("thread_number", 1);
            jSONObject.put("mainStackFromTrace", C0799v.m920a(stackTrace));
            return jSONObject;
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m423a() {
        return f388c;
    }

    /* renamed from: a */
    static boolean m424a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo, ActivityManager.ProcessErrorStateInfo processErrorStateInfo2) {
        return String.valueOf(processErrorStateInfo.condition).equals(String.valueOf(processErrorStateInfo2.condition)) && String.valueOf(processErrorStateInfo.processName).equals(String.valueOf(processErrorStateInfo2.processName)) && String.valueOf(processErrorStateInfo.pid).equals(String.valueOf(processErrorStateInfo2.pid)) && String.valueOf(processErrorStateInfo.uid).equals(String.valueOf(processErrorStateInfo2.uid)) && String.valueOf(processErrorStateInfo.tag).equals(String.valueOf(processErrorStateInfo2.tag)) && String.valueOf(processErrorStateInfo.shortMsg).equals(String.valueOf(processErrorStateInfo2.shortMsg)) && String.valueOf(processErrorStateInfo.longMsg).equals(String.valueOf(processErrorStateInfo2.longMsg));
    }

    /* renamed from: b */
    public static void m425b() {
        f389d = null;
    }
}
