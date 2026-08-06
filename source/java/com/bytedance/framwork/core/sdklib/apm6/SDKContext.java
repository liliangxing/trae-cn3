package com.bytedance.framwork.core.sdklib.apm6;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdklib.apm6.http.DefaultHttpService;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SDKContext {
    private static Map<String, String> commonParams;
    private static volatile Context context;
    private static boolean debugMode;
    private static final ConcurrentHashMap<Long, JSONObject> headers = new ConcurrentHashMap<>();
    private static volatile boolean isReportEnable = false;
    private static FileLock lock;

    public static synchronized void setContext(Context context2) {
        synchronized (SDKContext.class) {
            if (context != null) {
                return;
            }
            context = context2;
        }
    }

    public static Context getContext() {
        return context;
    }

    public static synchronized JSONObject getHeaderInfo(long j) {
        JSONObject jSONObject;
        synchronized (SDKContext.class) {
            jSONObject = headers.get(Long.valueOf(j));
        }
        return jSONObject;
    }

    public static synchronized JSONObject getHeader() {
        synchronized (SDKContext.class) {
            ConcurrentHashMap<Long, JSONObject> concurrentHashMap = headers;
            Iterator<Long> it = concurrentHashMap.keySet().iterator();
            if (!it.hasNext()) {
                return null;
            }
            return concurrentHashMap.get(it.next());
        }
    }

    public static synchronized void setHeader(String str, JSONObject jSONObject) {
        synchronized (SDKContext.class) {
            try {
                headers.put(Long.valueOf(Long.parseLong(str)), jSONObject);
            } catch (Exception e) {
                Logger.e(Constants.TAG, "setHeader", e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> getCommonParams() {
        if (!TextUtils.isEmpty(commonParams.get("device_id"))) {
            return commonParams;
        }
        Iterator<Long> it = headers.keySet().iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = headers.get(it.next());
            if (jSONObject != null) {
                try {
                    Long.parseLong(jSONObject.optString("device_id"));
                    commonParams.put("device_id", jSONObject.optString("device_id"));
                    break;
                } catch (Throwable unused) {
                }
            }
            while (it.hasNext()) {
            }
        }
        return commonParams;
    }

    public static void setCommonParams(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        if (commonParams == null) {
            commonParams = new HashMap();
        }
        commonParams.putAll(map);
        commonParams.remove("aid");
    }

    public static synchronized boolean isReportEnableInCurProcess() {
        synchronized (SDKContext.class) {
            if (isReportEnable) {
                return true;
            }
            FileChannel fileChannel = null;
            try {
                File lockFile = DiskEnvironmentHelper.getLockFile();
                if (!lockFile.exists()) {
                    lockFile.createNewFile();
                }
                fileChannel = new RandomAccessFile(lockFile, "rw").getChannel();
                if (fileChannel != null) {
                    FileLock tryLock = fileChannel.tryLock();
                    lock = tryLock;
                    if (tryLock != null) {
                        isReportEnable = tryLock.isValid();
                    }
                }
                boolean z = isReportEnable;
                if (fileChannel != null && !isReportEnable) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused) {
                    }
                }
                return z;
            } catch (Throwable unused2) {
                if (fileChannel == null || isReportEnable) {
                    return false;
                }
                try {
                    fileChannel.close();
                    return false;
                } catch (IOException unused3) {
                    return false;
                }
            }
        }
    }

    public static void setDebugMode(boolean z) {
        debugMode = z;
    }

    public static boolean isDebugMode() {
        return debugMode;
    }

    public static HttpResponse doPost(String str, Map<String, String> map, byte[] bArr) throws Exception {
        IHttpService iHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);
        if (iHttpService != null) {
            return iHttpService.doPost(str, bArr, map);
        }
        return DefaultHttpService.doPost(str, bArr, map);
    }
}
