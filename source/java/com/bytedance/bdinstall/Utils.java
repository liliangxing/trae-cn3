package com.bytedance.bdinstall;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.bdinstall.loader.DeviceManager;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.UByte;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Utils {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final int MAX_UDID_LENGTH = 128;
    public static final int MIN_UDID_LENGTH = 13;
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static volatile Boolean isMainProcess;
    private static String sProcessName;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private static boolean isOffsetInstallInfo = false;

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
    
        com.bytedance.bdinstall.Utils.sProcessName = r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static String getProcessName(Context context) {
        String str = sProcessName;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName)) {
                sProcessName = processName;
                return processName;
            }
        }
        String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        if (!TextUtils.isEmpty(currentProcessNameByActivityThread)) {
            sProcessName = currentProcessNameByActivityThread;
            return currentProcessNameByActivityThread;
        }
        try {
            int myPid = Process.myPid();
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sProcessName = getProcessNameFromProc();
        if (DrLog.debug()) {
            DrLog.d("getProcessName, " + sProcessName);
        }
        return sProcessName;
    }

    public static String getCurrentProcessNameByActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isMainProcess(Context context) {
        if (isMainProcess == null) {
            if (context == null) {
                throw new NullPointerException("context is null");
            }
            isMainProcess = Boolean.valueOf(TextUtils.equals(getProcessName(context), context.getPackageName()));
        }
        return isMainProcess.booleanValue();
    }

    public static boolean isValidUDID(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    private static String getProcessNameFromProc() {
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

    public static void copy(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            synchronized (DeviceManager.class) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            }
        } catch (JSONException e) {
            DrLog.ysnp(e);
        }
    }

    static String format(HashMap<String, String> hashMap, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String encode = encode(entry.getKey(), str);
            String value = entry.getValue();
            String encode2 = value != null ? encode(value, str) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
        }
        return sb.toString();
    }

    private static String encode(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static boolean equal(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || (str != null && str.equals(str2));
    }

    public static void putStringIfNotEmpty(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public static boolean isBadId(String str) {
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("unknown") || str.equalsIgnoreCase("None")) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public static boolean checkId(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = true;
                break;
            }
            if (str.charAt(i) != '0') {
                break;
            }
            i++;
        }
        return !z;
    }

    public static void removeSpValues(SharedPreferences sharedPreferences, String[] strArr) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        boolean z = false;
        for (String str : strArr) {
            if (sharedPreferences.contains(str)) {
                edit.remove(str);
                z = true;
            }
        }
        if (z) {
            edit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIsMainProcess(boolean z) {
        isMainProcess = Boolean.valueOf(z);
    }

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getApp(Context context) {
        return ((context instanceof Application) || context == null) ? context : context.getApplicationContext();
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean isOffsetInstallInfo() {
        return isOffsetInstallInfo;
    }

    public static void enanbleOffsetInstallInfo(boolean z) {
        isOffsetInstallInfo = z;
    }
}
