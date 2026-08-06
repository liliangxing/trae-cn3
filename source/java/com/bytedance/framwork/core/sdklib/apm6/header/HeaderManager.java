package com.bytedance.framwork.core.sdklib.apm6.header;

import android.os.Process;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdklib.apm6.SDKContext;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import com.bytedance.framwork.core.sdklib.util.JsonUtil;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class HeaderManager {
    private static volatile HeaderManager sInstance;
    private ConcurrentHashMap<Long, ConcurrentHashMap<Long, JSONObject>> headers = new ConcurrentHashMap<>();
    private volatile boolean isAlreadyCleanUp = false;

    public static HeaderManager getInstance() {
        if (sInstance == null) {
            synchronized (HeaderManager.class) {
                if (sInstance == null) {
                    sInstance = new HeaderManager();
                }
            }
        }
        return sInstance;
    }

    public long init(long j, JSONObject jSONObject) {
        long headerId = getHeaderId();
        if (!this.headers.containsKey(Long.valueOf(j))) {
            this.headers.put(Long.valueOf(j), new ConcurrentHashMap<>());
        }
        this.headers.get(Long.valueOf(j)).put(Long.valueOf(headerId), jSONObject);
        String fileName = getFileName(j, headerId);
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "header init:" + j + ":" + fileName + " " + jSONObject);
        }
        HeaderStoreManager.getInstance().saveHeader(fileName, JsonUtil.deepCopy(jSONObject));
        cleanExpireFile();
        return headerId;
    }

    private synchronized void cleanExpireFile() {
        if (this.isAlreadyCleanUp) {
            return;
        }
        this.isAlreadyCleanUp = true;
        HeaderStoreManager.getInstance().deleteExpireFile();
    }

    public JSONObject getHeader(long j, long j2) {
        ConcurrentHashMap<Long, JSONObject> concurrentHashMap = this.headers.get(Long.valueOf(j));
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Long.valueOf(j2))) {
            return concurrentHashMap.get(Long.valueOf(j2));
        }
        JSONObject header = HeaderStoreManager.getInstance().getHeader(getFileName(j, j2));
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "header init:" + j + ":" + j2 + " " + getFileName(j, j2));
        }
        if (!this.headers.containsKey(Long.valueOf(j))) {
            this.headers.put(Long.valueOf(j), new ConcurrentHashMap<>());
        }
        if (header != null) {
            this.headers.get(Long.valueOf(j)).put(Long.valueOf(j2), header);
        } else {
            header = SDKContext.getHeaderInfo(j);
        }
        if (header == null) {
            Logger.m1306e(Constants.TAG, "header==null " + j);
        }
        return header;
    }

    private static long getHeaderId() {
        return (System.currentTimeMillis() << 16) | Process.myPid();
    }

    private String getFileName(long j, long j2) {
        return j + "_" + j2;
    }
}
