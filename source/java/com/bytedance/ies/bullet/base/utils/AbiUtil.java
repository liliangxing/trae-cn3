package com.bytedance.ies.bullet.base.utils;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.ies.bullet.core.BulletEnv;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class AbiUtil {
    private static final String ARM64_V8A = "arm64-v8a";
    private static final String ARMEABI = "armeabi";
    private static final String ARMEABI_V7A = "armeabi-v7a";
    private static final String CPU_ARM_V8 = "arm64-v8a";
    private static final String KEY_AUTO_ERROR = "autoError";
    private static final String KEY_DEFAULT_ABI = "defaultABI";
    private static final String KEY_DEFAULT_ABI0 = "defaultABI0";
    private static final String KEY_MANUAL_ERROR = "manualError";
    private static final String KEY_MATCH_CPU_ABI = "matchCpuAbi";
    private static final String KEY_PRIMARY_CPU_ABI = "primaryCpuAbi";
    private static final String KEY_PROCESS_MODE = "processMode";
    private static final String KEY_SUPPORTED_ABI0 = "supportedABI0";
    private static final String MIPS = "mips";
    private static final String MIPS64 = "mips64";
    private static final String SERVICE_NAME = "mira_infer_host_abi";
    private static final String TAG = "AbiUtil";
    private static final String UNKNOWN = "unknown";
    private static final String VALUE_DEFAULT = "0";
    private static final String X86 = "x86";
    private static final String X86_64 = "x86_64";
    private static volatile String s64CpuSupport;
    private static Map<String, Integer> sCpuTypes = new HashMap();
    private static Map<String, Field> sFieldCache = new HashMap();
    private static volatile String sHostAbi;

    private static boolean isAndroidLHigher() {
        return true;
    }

    private static boolean isAndroidMOrHigher() {
        return true;
    }

    static {
        sCpuTypes.put(ARMEABI, 32);
        sCpuTypes.put(ARMEABI_V7A, 32);
        sCpuTypes.put("arm64-v8a", 64);
        sCpuTypes.put(X86, 32);
        sCpuTypes.put(X86_64, 64);
        sCpuTypes.put(MIPS, 32);
        sCpuTypes.put(MIPS64, 64);
        sHostAbi = inferHostAbi();
        s64CpuSupport = null;
    }

    public static String getHostAbi() {
        if (sHostAbi == null) {
            synchronized (AbiUtil.class) {
                if (sHostAbi == null) {
                    sHostAbi = inferHostAbi();
                }
            }
        }
        return sHostAbi;
    }

    public static boolean is32() {
        try {
            if (TextUtils.isEmpty(getHostAbi())) {
                return false;
            }
            return !"arm64-v8a".equals(getHostAbi());
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getHostAbiBit() {
        Integer num = sCpuTypes.get(getHostAbi());
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static String getSupport64Cpu() {
        if (s64CpuSupport == null) {
            synchronized (AbiUtil.class) {
                if (s64CpuSupport == null) {
                    s64CpuSupport = String.valueOf(getCpuAbi().contains("arm64-v8a"));
                }
            }
        }
        return s64CpuSupport;
    }

    private static String getCpuAbi() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.SUPPORTED_ABIS.length > 0) {
                for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                    sb.append(Build.SUPPORTED_ABIS[i]);
                    if (i != Build.SUPPORTED_ABIS.length - 1) {
                        sb.append(", ");
                    }
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            TextUtils.isEmpty(sb.toString());
            return sb.toString();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    private static String inferHostAbi() {
        JSONObject initCategory = initCategory();
        String inferHostAbiAuto = inferHostAbiAuto(initCategory);
        return inferHostAbiAuto != null ? inferHostAbiAuto : inferHostAbiManual(initCategory);
    }

    private static String inferHostAbiAuto(JSONObject jSONObject) {
        int i;
        if (!isAndroidLHigher() || BulletEnv.INSTANCE.getInstance().getApplication() == null) {
            return null;
        }
        try {
            String str = (String) readField(BulletEnv.INSTANCE.getInstance().getApplication().getApplicationInfo(), KEY_PRIMARY_CPU_ABI);
            Log.w(TAG, "AbiUtil inferHostAbiAuto, primaryCpuAbi=" + str);
            addCategory(jSONObject, KEY_PRIMARY_CPU_ABI, str);
            if (str == null) {
                return null;
            }
            if (isAndroidMOrHigher()) {
                i = getCompatAbi();
            } else {
                Log.w(TAG, "AbiUtil inferHostAbiAuto, processMode default=0");
                i = 0;
            }
            addCategory(jSONObject, KEY_PROCESS_MODE, "" + i);
            if (i != 0) {
                if (sCpuTypes.get(str).intValue() != i) {
                    return null;
                }
                Log.w(TAG, "AbiUtil inferHostAbiAuto2, sHostAbi=" + str);
                return str;
            }
            Log.w(TAG, "AbiUtil inferHostAbiAuto1, sHostAbi=" + str);
            return str;
        } catch (Throwable unused) {
            Log.e(TAG, "AbiUtil inferHostAbiAuto failed!");
            addCategory(jSONObject, KEY_AUTO_ERROR, "1");
            return null;
        }
    }

    private static int getCompatAbi() {
        int i = 0;
        try {
            i = Process.is64Bit() ? 64 : 32;
            Log.w(TAG, "AbiUtil inferHostAbiAuto, processMode=" + i);
        } catch (Exception unused) {
            Log.w(TAG, "AbiUtil inferHostAbiAuto, processMode exception default=" + i);
        } catch (NoSuchMethodError unused2) {
        }
        return i;
    }

    private static String inferHostAbiManual(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        String str = null;
        try {
            try {
                Application application = BulletEnv.INSTANCE.getInstance().getApplication();
                if (application != null) {
                    str = application.getPackageManager().getPackageInfo(application.getPackageName(), 0).applicationInfo.sourceDir;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e(TAG, "AbiUtil inferHostAbiManual, get host sourceDir PackageInfo failed!");
            }
            ZipFile zipFile = new ZipFile(new File(str));
            hashSet = new HashSet(getAllSoZipEntries(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused2) {
                Log.w(TAG, "AbiUtil inferHostAbiManual, close sourceApkZipFile error!");
            }
            strArr = isAndroidLHigher() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } catch (Throwable unused3) {
            Log.e(TAG, "AbiUtil inferHostAbiManual failed!");
            addCategory(jSONObject, KEY_MANUAL_ERROR, "1");
        }
        if (hashSet.isEmpty()) {
            Log.w(TAG, "AbiUtil inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            addCategory(jSONObject, KEY_SUPPORTED_ABI0, strArr[0]);
            return strArr[0];
        }
        for (String str2 : strArr) {
            if (hashSet.contains(str2)) {
                Log.w(TAG, "AbiUtil inferHostAbiManual, match cpuAbi=" + str2);
                addCategory(jSONObject, KEY_MATCH_CPU_ABI, str2);
                return str2;
            }
        }
        if (isAndroidLHigher()) {
            addCategory(jSONObject, KEY_DEFAULT_ABI0, Build.SUPPORTED_ABIS[0]);
            return Build.SUPPORTED_ABIS[0];
        }
        addCategory(jSONObject, KEY_DEFAULT_ABI, Build.CPU_ABI);
        return Build.CPU_ABI;
    }

    private static Map<String, List<ZipEntry>> getAllSoZipEntries(ZipFile zipFile) {
        boolean z;
        String[] split;
        HashMap hashMap = new HashMap();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory()) {
                try {
                    z = compile.matcher(nextElement.getName()).matches();
                } catch (Exception e) {
                    Log.e(TAG, "AbiUtil getAllSoZipEntries failed, match error=" + e);
                    z = false;
                }
                if (z && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                    String str = split[split.length - 2];
                    if (sCpuTypes.containsKey(str)) {
                        if (hashMap.get(str) == null) {
                            hashMap.put(str, new LinkedList());
                        }
                        ((List) hashMap.get(str)).add(nextElement);
                    }
                }
            }
        }
        Log.i(TAG, "AbiUtil getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
        return hashMap;
    }

    private static void addCategory(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject initCategory() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_PRIMARY_CPU_ABI, "0");
            jSONObject.put(KEY_PROCESS_MODE, "0");
            jSONObject.put(KEY_SUPPORTED_ABI0, "0");
            jSONObject.put(KEY_MATCH_CPU_ABI, "0");
            jSONObject.put(KEY_DEFAULT_ABI0, "0");
            jSONObject.put(KEY_DEFAULT_ABI, "0");
            jSONObject.put(KEY_AUTO_ERROR, "0");
            jSONObject.put(KEY_MANUAL_ERROR, "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static Object readField(Object obj, String str) throws IllegalAccessException {
        Object checkNotNull = checkNotNull(obj, "target object must not be null");
        Field field = getField(checkNotNull.getClass(), str);
        if (field != null) {
            return readField(field, checkNotNull);
        }
        return null;
    }

    private static Object readField(Field field, Object obj) throws IllegalAccessException {
        checkArgument(field != null, "The field must not be null");
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    private static String getKey(Class<?> cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        return sb.toString();
    }

    private static Field getField(Class<?> cls, String str) {
        Field field;
        Class cls2 = (Class) checkNotNull(cls, "The class must not be null");
        checkTrue(!TextUtils.isEmpty(str), "The field name must not be blank");
        String key = getKey(cls2, str);
        synchronized (sFieldCache) {
            field = sFieldCache.get(key);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        while (cls2 != null) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                synchronized (sFieldCache) {
                    continue;
                    sFieldCache.put(key, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
            }
        }
        return null;
    }

    private static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str);
    }

    private static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    private static void checkTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
