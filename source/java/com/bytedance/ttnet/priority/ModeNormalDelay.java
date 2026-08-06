package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ModeNormalDelay extends TTHttpCallPriorityControl.BaseModeControl {
    private static final String KEY_BL_WITH_DELAY_MS = "bl_with_delay_ms";
    private static final String KEY_DELAY_TIME_MS = "delay_time_ms";
    private static final String KEY_WL = "wl";
    private final RequestDropController mDropController = new RequestDropController();
    private final Map<String, Integer> mBlackList = new ConcurrentHashMap();
    private final Set<String> mWhiteList = new CopyOnWriteArraySet();
    private int mWhiteListDelayTimeMs = BytePatchException.ErrorCode.paramsError;

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request request) throws Exception {
        long delayTimeOrRaiseDroppedByThrottleControlException = getDelayTimeOrRaiseDroppedByThrottleControlException(request);
        if (Logger.debug()) {
            Logger.d("ModeNormalDelay", "get normal delay time " + delayTimeOrRaiseDroppedByThrottleControlException + " " + request.getPath());
        }
        this.mRequestDelayController.requestBlockingDelay(request, false, true, delayTimeOrRaiseDroppedByThrottleControlException);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request request, Executor executor, Runnable runnable) throws Exception {
        long delayTimeOrRaiseDroppedByThrottleControlException = getDelayTimeOrRaiseDroppedByThrottleControlException(request);
        if (Logger.debug()) {
            Logger.d("ModeNormalDelay", "get normal delay time " + delayTimeOrRaiseDroppedByThrottleControlException + " " + request.getPath());
        }
        return this.mRequestDelayController.requestAsyncDelay(request, false, delayTimeOrRaiseDroppedByThrottleControlException, runnable, executor);
    }

    private int getDelayTimeOrRaiseDroppedByThrottleControlException(Request request) throws IOException {
        this.mDropController.raiseExceptionIfDrop(request);
        if (!this.mBlackList.isEmpty()) {
            Integer mapValueIfMatch = TTHttpCallPriorityControl.getMapValueIfMatch(this.mBlackList, request.getPath());
            if (mapValueIfMatch != null) {
                return mapValueIfMatch.intValue();
            }
            return 0;
        }
        if (this.mWhiteList.isEmpty()) {
            return -1;
        }
        if (TTHttpCallPriorityControl.isMatch(this.mWhiteList, request.getPath())) {
            return 0;
        }
        return this.mWhiteListDelayTimeMs;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public boolean initWithTncConfig(JSONObject jSONObject) {
        super.initWithTncConfig(jSONObject);
        if (jSONObject.isNull(KEY_BL_WITH_DELAY_MS) && jSONObject.isNull(KEY_WL)) {
            return false;
        }
        this.mDropController.initWithTncConfig(jSONObject);
        this.mRequestDelayController.initWithTncConfig(jSONObject, this.mStateName);
        JSONObject optJSONObject = jSONObject.optJSONObject(KEY_BL_WITH_DELAY_MS);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.mBlackList.put(next, Integer.valueOf(optJSONObject.optInt(next)));
            }
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_WL);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        this.mWhiteList.add(optString);
                    }
                }
            }
            this.mWhiteListDelayTimeMs = jSONObject.optInt(KEY_DELAY_TIME_MS, BytePatchException.ErrorCode.paramsError);
        }
        return (!this.mDropController.isValid() && this.mBlackList.isEmpty() && this.mWhiteList.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
        super.modeStop();
        this.mRequestDelayController.releaseAllDelayedRequests();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.NORMAL_DELAY;
    }
}
