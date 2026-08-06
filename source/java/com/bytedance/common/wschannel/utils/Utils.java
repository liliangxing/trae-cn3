package com.bytedance.common.wschannel.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.UByte;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Utils {
    private static String sCurProcessName;

    public static String byte2HexStr(byte[] bArr) {
        return byte2HexStr(bArr, " ");
    }

    public static String byte2HexStr(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder("");
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString().toUpperCase().trim();
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getTimeFormat(long j) {
        return DateFormat.getDateTimeInstance().format(new Date(j));
    }

    public static boolean isMainProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return (curProcessName == null || !curProcessName.contains(Constants.COLON_SEPARATOR)) && curProcessName != null && curProcessName.equals(context.getPackageName());
    }

    public static boolean isMainProcess(Context context, String str) {
        return (str == null || !str.contains(Constants.COLON_SEPARATOR)) && str != null && str.equals(context.getPackageName());
    }

    public static String getCurProcessName(Context context) {
        String str = sCurProcessName;
        if (!StringUtils.isEmpty(str)) {
            return str;
        }
        String currentProcessNameFromApplication = getCurrentProcessNameFromApplication();
        sCurProcessName = currentProcessNameFromApplication;
        if (!StringUtils.isEmpty(currentProcessNameFromApplication)) {
            return sCurProcessName;
        }
        String currentProcessNameFromActivityThread = getCurrentProcessNameFromActivityThread();
        sCurProcessName = currentProcessNameFromActivityThread;
        if (!StringUtils.isEmpty(currentProcessNameFromActivityThread)) {
            return sCurProcessName;
        }
        String curProcessNameFromProc = getCurProcessNameFromProc();
        sCurProcessName = curProcessNameFromProc;
        if (!StringUtils.isEmpty(curProcessNameFromProc)) {
            return sCurProcessName;
        }
        String curProcessNameFromActivityManager = getCurProcessNameFromActivityManager(context);
        sCurProcessName = curProcessNameFromActivityManager;
        return curProcessNameFromActivityManager;
    }

    private static String getCurrentProcessNameFromApplication() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getCurrentProcessNameFromActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String getCurProcessNameFromActivityManager(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    if (Logger.debug()) {
                        Logger.d("Process", "processName = " + runningAppProcessInfo.processName);
                    }
                    str = runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private static String getCurProcessNameFromProc() {
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
                    break;
                }
                sb.append((char) read);
            }
            if (Logger.debug()) {
                Logger.d("Process", "get processName = " + sb.toString());
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return sb2;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        }
    }

    public static boolean isMessageProcess(String str) {
        return str != null && str.endsWith(":push");
    }

    public static boolean isServiceRunning(Context context, Class<? extends Service> cls) {
        if (context != null && cls != null) {
            try {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
                    if (runningServiceInfo != null && runningServiceInfo.service != null && TextUtils.equals(cls.getName(), runningServiceInfo.service.getClassName())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static JSONObject mapToJson(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    try {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    public static Map<String, String> jsonToMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                Object opt = jSONObject.opt(next);
                hashMap.put(next, opt == null ? null : opt.toString());
            }
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if (r2 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String outputThrowableStackTrace(Throwable th) {
        PrintWriter printWriter;
        String str = null;
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            try {
                th.printStackTrace(printWriter);
                Throwable cause = th.getCause();
                if (cause != null) {
                    cause.printStackTrace(printWriter);
                    Throwable cause2 = cause.getCause();
                    if (cause2 != null) {
                        cause2.printStackTrace(printWriter);
                    }
                }
                str = stringWriter.toString();
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                } catch (Throwable th3) {
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            printWriter = null;
        }
        printWriter.close();
        return str;
    }
}
