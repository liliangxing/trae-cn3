package com.bytedance.crash.util;

import android.text.TextUtils;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.librarian.LibrarianImpl;
import com.ss.android.update.UpdateDialogNewBase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes3.dex */
public class NativeTools {
    private static NativeTools sInstance;
    private static HashMap<String, String> sSoUUID = new HashMap<>();

    public void setResendSigquit(boolean z) {
    }

    public static NativeTools get() {
        if (sInstance == null) {
            synchronized (NativeTools.class) {
                if (sInstance == null) {
                    sInstance = new NativeTools();
                }
            }
        }
        return sInstance;
    }

    public int dumpLogcat(String str) {
        try {
            NativeBridge.dumpLogcat(str, 0, false);
            return 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public int dumpLogcat(String str, String str2) {
        try {
            NativeBridge.dumpLogcat(str, 0, false);
            return 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public String getSoUUIDCurrent(String str) {
        String str2 = sSoUUID.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String compatibleBuildID = compatibleBuildID(get().getBuildID(str));
        sSoUUID.put(str, compatibleBuildID);
        return compatibleBuildID;
    }

    public static String compatibleBuildID(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return sb.toString();
        }
        try {
            if (str.length() < 16) {
                sb.append(str);
            } else {
                sb.append(str.charAt(6));
                sb.append(str.charAt(7));
                sb.append(str.charAt(4));
                sb.append(str.charAt(5));
                sb.append(str.charAt(2));
                sb.append(str.charAt(3));
                sb.append(str.charAt(0));
                sb.append(str.charAt(1));
                sb.append(str.charAt(10));
                sb.append(str.charAt(11));
                sb.append(str.charAt(8));
                sb.append(str.charAt(9));
                sb.append(str.charAt(14));
                sb.append(str.charAt(15));
                sb.append(str.charAt(12));
                sb.append(str.charAt(13));
                if (str.length() >= 32) {
                    sb.append((CharSequence) str, 16, 32);
                    sb.append('0');
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString().toUpperCase();
    }

    private static String[] getAppSoNameFromBacktraceLine(String str) {
        int lastIndexOf;
        String[] split = str.split("\\s+");
        String[] strArr = {"", ""};
        if (split.length >= 4) {
            String str2 = null;
            for (String str3 : split) {
                if (str3.startsWith("/") && str3.endsWith(LibrarianImpl.Constants.SO_SUFFIX)) {
                    str2 = str3;
                }
            }
            if (!TextUtils.isEmpty(str2) && str2.endsWith(LibrarianImpl.Constants.SO_SUFFIX) && !str2.contains("/system/lib") && (lastIndexOf = str2.lastIndexOf(47)) != -1) {
                int i = lastIndexOf + 1;
                String substring = str2.substring(i);
                if (substring.contains(".apk!")) {
                    substring = substring.substring(substring.indexOf(".apk!") + 5);
                }
                String str4 = str2.substring(0, i) + substring;
                strArr[0] = substring;
                strArr[1] = str4;
                return strArr;
            }
        }
        return null;
    }

    public String getBuildID(String str) {
        try {
            return NativeBridge.GetBuildID(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONArray getSoUUID(String str) {
        JSONArray jSONArray = new JSONArray();
        HashSet hashSet = new HashSet();
        for (String str2 : str.split(UpdateDialogNewBase.TYPE)) {
            String[] appSoNameFromBacktraceLine = getAppSoNameFromBacktraceLine(str2);
            if (appSoNameFromBacktraceLine != null) {
                String soUUIDCurrent = get().getSoUUIDCurrent(appSoNameFromBacktraceLine[1]);
                if (!TextUtils.isEmpty(soUUIDCurrent) && !hashSet.contains(appSoNameFromBacktraceLine[0])) {
                    hashSet.add(appSoNameFromBacktraceLine[0]);
                    JSONObject jSONObject = new JSONObject();
                    JSONUtils.put(jSONObject, CrashBody.LIB_NAME, appSoNameFromBacktraceLine[0]);
                    JSONUtils.put(jSONObject, CrashBody.LIB_UUID, soUUIDCurrent);
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray;
    }

    public List<String> getFdListForAPM() {
        return NativeBridge.getFdListForAPM();
    }

    public boolean is64BitRuntime() {
        return NativeBridge.is64BitRuntime();
    }
}
