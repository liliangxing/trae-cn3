package com.ss.android.update;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.NetworkUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateWifiUtils {
    private static final String ARMV9 = "arm64-v9a";
    private static final String[] ARMV9_CPU_ARRAY = {"SM8450"};
    private static final String TAG = "UpdateWifiUtils";
    private static final String UNKNOWN = "unknown";
    private static String sCpuABI;

    public static String getSSID(Context context) {
        if (UpdateAlphaManager.inst().isOpenUpdateFormalStrategy() && context != null && NetworkUtils.isWifi(context)) {
            try {
                return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getSSID();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String getIpAddress(Context context) {
        if (context == null || !NetworkUtils.isWifi(context)) {
            return "";
        }
        try {
            int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
            return (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static List<ScanResult> getWifiList(Context context) {
        boolean z;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (ScanResult scanResult : ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getScanResults()) {
                if (scanResult.SSID != null && scanResult.SSID.length() != 0 && !scanResult.capabilities.contains("[IBSS]")) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        ScanResult scanResult2 = (ScanResult) it.next();
                        if (scanResult2.SSID.equals(scanResult.SSID) && scanResult2.capabilities.equals(scanResult.capabilities)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        arrayList.add(scanResult);
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getCpuAbi() {
        if (sCpuABI == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    if (Build.SUPPORTED_ABIS[0].contains("v8a")) {
                        String systemProperty = getSystemProperty("ro.soc.model");
                        int i = 0;
                        while (true) {
                            String[] strArr = ARMV9_CPU_ARRAY;
                            if (i >= strArr.length) {
                                break;
                            }
                            if (systemProperty.contains(strArr[i])) {
                                sb.append("arm64-v9a, ");
                                break;
                            }
                            i++;
                        }
                    }
                    for (int i2 = 0; i2 < Build.SUPPORTED_ABIS.length; i2++) {
                        sb.append(Build.SUPPORTED_ABIS[i2]);
                        if (i2 != Build.SUPPORTED_ABIS.length - 1) {
                            sb.append(", ");
                        }
                    }
                } else {
                    sb = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    sCpuABI = UNKNOWN;
                }
                sCpuABI = sb.toString();
            } catch (Exception unused) {
                sCpuABI = UNKNOWN;
            }
        }
        Log.e(TAG, sCpuABI);
        return sCpuABI;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSystemProperty(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        Log.e(TAG, "Exception while closing InputStream", e);
                    }
                    return readLine;
                } catch (IOException e2) {
                    e = e2;
                    Log.e(TAG, "Unable to read sysprop " + str, e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            Log.e(TAG, "Exception while closing InputStream", e3);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                        Log.e(TAG, "Exception while closing InputStream", e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        r0 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r2.close();
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        r1.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079 A[Catch: IOException -> 0x0075, TRY_LEAVE, TryCatch #2 {IOException -> 0x0075, blocks: (B:52:0x0071, B:45:0x0079), top: B:51:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuModel() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String str;
        FileReader fileReader2 = null;
        try {
            try {
                fileReader = new FileReader("/proc/cpuinfo");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e = e2;
            fileReader = null;
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
            if (fileReader2 != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
        try {
            bufferedReader = new BufferedReader(fileReader);
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            fileReader.close();
                            bufferedReader.close();
                            break;
                        }
                        if (readLine.contains(Constants.COLON_SEPARATOR)) {
                            String[] split = readLine.split(Constants.COLON_SEPARATOR);
                            if (split[0].contains("Hardware") || split[0].contains("model name")) {
                                break;
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileReader2 = fileReader;
            if (fileReader2 != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
        return null;
        return str;
    }
}
