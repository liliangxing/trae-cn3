package com.bytedance.applog.monitor.exception;

import com.bytedance.applog.forward.EventForwardLoader;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.monitor.exception.HighFrequencyTracker;
import com.bytedance.applog.monitor.p006v3.StageEventType;
import com.bytedance.applog.server.Api;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppLogExceptionManager {
    private static final AppLogExceptionManager sInstance = new AppLogExceptionManager();
    private boolean enabled = false;
    private AppLogExceptionHandler exceptionHandler;
    private HighFrequencyTracker highFrequencyTracker;

    public static AppLogExceptionManager getInstance() {
        return sInstance;
    }

    public void setExceptionHandler(AppLogExceptionHandler appLogExceptionHandler) {
        this.exceptionHandler = appLogExceptionHandler;
    }

    public void dispatchOutOfDataBoundary(StageEventType stageEventType, JSONArray jSONArray, long j) {
        if (isEnabled()) {
            HashMap hashMap = new HashMap();
            hashMap.put(EventForwardLoader.KEY_EVENT_FORWARD_EVENTS, jSONArray);
            dispatchException(ExceptionScene.DataPackaging, ExceptionType.OutOfDataBoundary, ExceptionLevel.Fatal, stageEventType + " out of data boundary, pack limit length: " + j, hashMap);
        }
    }

    public void dispatchOutOfDataBoundary(StageEventType stageEventType, String str, String str2, long j) {
        if (isEnabled()) {
            HashMap hashMap = new HashMap();
            hashMap.put(Api.COL_TAG, str);
            hashMap.put("params", str2);
            dispatchException(ExceptionScene.DataCollection, ExceptionType.OutOfDataBoundary, ExceptionLevel.Fatal, stageEventType + " out of data boundary, event limit length: " + j, hashMap);
        }
    }

    public void dispatchTouristMode(ExceptionScene exceptionScene) {
        if (isEnabled()) {
            dispatchException(exceptionScene, ExceptionType.InterruptionTouristMode, ExceptionLevel.Notice, "report interrupted due to tourist mode.", null);
        }
    }

    public void dispatchInvalidDid(ExceptionScene exceptionScene) {
        if (isEnabled()) {
            dispatchException(exceptionScene, ExceptionType.InterruptionInvalidDid, ExceptionLevel.Notice, "report interrupted due to invalid did.", null);
        }
    }

    public void dispatchException(ExceptionScene exceptionScene, ExceptionType exceptionType, ExceptionLevel exceptionLevel, String str, Map<String, ?> map) {
        AppLogExceptionHandler appLogExceptionHandler;
        if (isEnabled() && (appLogExceptionHandler = this.exceptionHandler) != null) {
            try {
                appLogExceptionHandler.onException(exceptionScene, exceptionType, exceptionLevel, str, map);
            } catch (Throwable th) {
                LoggerImpl.global().error("AppLogExceptionHandler onException failed, ", th, new Object[0]);
            }
        }
    }

    public void dispatchCacheOverflow(String str) {
        if (isEnabled()) {
            dispatchException(ExceptionScene.DataCollection, ExceptionType.CacheOverflow, ExceptionLevel.Fatal, str, null);
        }
    }

    public void dispatchError(String str, Throwable th) {
        if (isEnabled()) {
            HashMap hashMap = new HashMap();
            hashMap.put("throwable", th);
            dispatchException(ExceptionScene.Common, ExceptionType.CommonError, ExceptionLevel.Fatal, str, hashMap);
        }
    }

    public void dispatchDiscardEvent(ExceptionType exceptionType, String str) {
        if (isEnabled()) {
            dispatchException(ExceptionScene.DataCollection, exceptionType, ExceptionLevel.Notice, str, null);
        }
    }

    public void setHighFrequencyConfig(long j, long j2) {
        if (j > 0 && j2 > 0) {
            this.highFrequencyTracker = new HighFrequencyTracker(j, j2, new HighFrequencyTracker.HighFrequencyCallback() { // from class: com.bytedance.applog.monitor.exception.AppLogExceptionManager.1
                @Override // com.bytedance.applog.monitor.exception.HighFrequencyTracker.HighFrequencyCallback
                public void onHighFrequencyDetected(Map<String, Integer> map) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(EventForwardLoader.KEY_EVENT_FORWARD_EVENTS, map);
                    AppLogExceptionManager.this.dispatchException(ExceptionScene.DataCollection, ExceptionType.HighFrequency, ExceptionLevel.Fatal, "high frequency events detected", hashMap);
                }
            });
        } else {
            this.highFrequencyTracker = null;
        }
    }

    public void addHighFrequencyEvent(StageEventType stageEventType, String str, long j) {
        HighFrequencyTracker highFrequencyTracker;
        if (isEnabled() && (highFrequencyTracker = this.highFrequencyTracker) != null) {
            try {
                highFrequencyTracker.addEvent(stageEventType, str, j);
            } catch (Throwable unused) {
            }
        }
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
