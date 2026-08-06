package com.bytedance.applog.util;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.applog.EventType;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.store.Event;
import com.bytedance.applog.store.EventMisc;
import com.bytedance.applog.store.EventV3;
import com.bytedance.applog.store.ForwardEvent;
import com.bytedance.applog.store.Launch;
import com.bytedance.applog.store.Terminate;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Utils {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static String MESSAGE_PROCESS_SUFFIX = ":push";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static String sProcessName;

    public static String getEncodeTypeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "UNKNOWN" : "ZSTD+DICT" : "ZSTD" : "GZIP";
    }

    public static String getYesNoString(boolean z) {
        return z ? "yes" : "no";
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    public static String toString(Object obj) {
        return obj != null ? obj.toString() : "";
    }

    public static boolean equals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static boolean notEquals(Object obj, Object obj2) {
        return !equals(obj, obj2);
    }

    public static boolean jsonEquals(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            return jSONObject.toString().equals(jSONObject2.toString());
        }
        return equals(jSONObject, jSONObject2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
    
        com.bytedance.applog.util.Utils.sProcessName = r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getProcessName(Context context) {
        String str = sProcessName;
        if (!TextUtils.isEmpty(str)) {
            return str;
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
        LoggerImpl.global().debug("getProcessName: {}", sProcessName);
        return sProcessName;
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

    public static void setMessageProcessSuffix(String str) {
        MESSAGE_PROCESS_SUFFIX = str;
    }

    public static boolean isMessageProcess(Context context) {
        String processName = getProcessName(context);
        return processName != null && processName.endsWith(MESSAGE_PROCESS_SUFFIX);
    }

    public static JSONObject copy(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (JSONException e) {
                LoggerImpl.global().error("copy failed", e, new Object[0]);
            }
        }
        return jSONObject;
    }

    public static void format(StringBuilder sb, HashMap<String, String> hashMap, String str) {
        for (String str2 : hashMap.keySet()) {
            String encode = encode(str2, str);
            String str3 = hashMap.get(str2);
            String encode2 = str3 != null ? encode(str3, str) : "";
            if (sb.length() > 0) {
                sb.append(PARAMETER_SEPARATOR);
            }
            sb.append(encode).append(NAME_VALUE_SEPARATOR).append(encode2);
        }
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

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void closeSafely(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void endDbTransactionSafely(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        try {
            if (sQLiteDatabase.inTransaction()) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable th) {
            LoggerImpl.global().error("end transaction failed", th, new Object[0]);
        }
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

    public static JSONObject copyJson(JSONObject jSONObject) {
        Iterator<String> keys;
        if (jSONObject == null || (keys = jSONObject.keys()) == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        while (keys.hasNext()) {
            linkedList.add(keys.next());
        }
        try {
            return new JSONObject(jSONObject, (String[]) linkedList.toArray(new String[0]));
        } catch (Exception e) {
            LoggerImpl.global().error("copyJson failed", e, new Object[0]);
            return jSONObject;
        }
    }

    public static boolean hasClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String map2JsonString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static synchronized String getUniqueEventId() {
        String lowerCase;
        synchronized (Utils.class) {
            lowerCase = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        }
        return lowerCase;
    }

    public static long optLong(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.parseLong(jSONObject.optString(str));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static boolean jsonChanged(Map<String, Object> map, JSONObject jSONObject) {
        if (map == null) {
            return false;
        }
        if (jSONObject == null) {
            return true;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!isEmpty(entry.getKey()) && notEquals(jSONObject.opt(entry.getKey()), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static EventType getEventType(BaseData baseData) {
        if (baseData == null) {
            return EventType.UNKNOWN;
        }
        if (baseData instanceof ForwardEvent) {
            return EventType.FORWARD_V3;
        }
        if (baseData instanceof EventV3) {
            return EventType.V3;
        }
        if (baseData instanceof Event) {
            return EventType.V1;
        }
        if (baseData instanceof EventMisc) {
            return EventType.LogData;
        }
        if (baseData instanceof Launch) {
            return EventType.Launch;
        }
        if (baseData instanceof Terminate) {
            return EventType.Terminate;
        }
        return EventType.UNKNOWN;
    }
}
