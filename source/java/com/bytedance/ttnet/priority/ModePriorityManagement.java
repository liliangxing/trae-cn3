package com.bytedance.ttnet.priority;

import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.lynx.service.image.LynxImageService;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ModePriorityManagement extends TTHttpCallPriorityControl.BaseModeControl {
    private final RequestDropController mDropController = new RequestDropController();
    private final RequestPriorityController mPriorityController = new RequestPriorityController();
    private final RequestSpeedController mRequestSpeedThrottleController = new RequestSpeedController();
    private final Set<String> mBlackListForPriority = new CopyOnWriteArraySet();
    private final Set<String> mWhiteListForPriority = new CopyOnWriteArraySet();
    private int mMaxDelayTimeMs = 60000;

    private boolean checkIfDelayOrDropWithPriority(Request request) throws DroppedByThrottleControlException {
        this.mDropController.raiseExceptionIfDrop(request);
        if (!this.mBlackListForPriority.isEmpty()) {
            return TTHttpCallPriorityControl.isMatch(this.mBlackListForPriority, request.getPath());
        }
        if (this.mWhiteListForPriority.isEmpty()) {
            return false;
        }
        return !TTHttpCallPriorityControl.isMatch(this.mWhiteListForPriority, request.getPath());
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request request) throws Exception {
        if (checkIfDelayOrDropWithPriority(request)) {
            this.mRequestDelayController.requestBlockingDelay(request, false, true, this.mMaxDelayTimeMs);
        }
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request request, Executor executor, Runnable runnable) throws Exception {
        if (checkIfDelayOrDropWithPriority(request)) {
            return this.mRequestDelayController.requestAsyncDelay(request, false, this.mMaxDelayTimeMs, runnable, executor);
        }
        return false;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public Request setOriginalRequestProperties(Request request) {
        return this.mRequestSpeedThrottleController.setThrottleSpeedToRequest(this.mPriorityController.setPriorityToRequest(request));
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public boolean initWithTncConfig(JSONObject jSONObject) {
        super.initWithTncConfig(jSONObject);
        this.mDropController.initWithTncConfig(jSONObject);
        this.mRequestDelayController.initWithTncConfig(jSONObject, this.mStateName);
        JSONObject optJSONObject = jSONObject.optJSONObject(LynxImageService.PRIORITY_KEY);
        if (!this.mDropController.isValid() && optJSONObject == null) {
            return false;
        }
        this.mPriorityController.initWithTncConfig(optJSONObject);
        this.mRequestSpeedThrottleController.initWithTncConfig(jSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("delay");
        if (optJSONObject2 == null) {
            return true;
        }
        this.mBlackListForPriority.addAll(TTHttpCallPriorityControl.getSetFromJSONArray(optJSONObject2, "bl_with_priority"));
        this.mWhiteListForPriority.addAll(TTHttpCallPriorityControl.getSetFromJSONArray(optJSONObject2, "wl_with_priority"));
        return true;
    }

    public void initRequestDropController(Set<String> set) {
        this.mDropController.initWithLocal(set);
    }

    public void initRequestDelayController(Set<String> set, Set<String> set2, int i, int i2, int i3, int i4) {
        this.mRequestDelayController.initWithLocal(i2, i3, i4);
        this.mBlackListForPriority.clear();
        this.mWhiteListForPriority.clear();
        this.mBlackListForPriority.addAll(set);
        this.mWhiteListForPriority.addAll(set2);
        this.mMaxDelayTimeMs = i;
    }

    public void initRequestPriorityController(Set<String> set, Set<String> set2, Set<String> set3) {
        this.mPriorityController.initWithLocal(set, set2, set3);
    }

    public void initRequestSpeedController(Map<String, Integer> map, Set<String> set, Set<String> set2, Set<String> set3, Set<String> set4, long j, long j2, long j3, long j4) {
        this.mRequestSpeedThrottleController.initWithLocal(map, set2, set2, set3, set4, j, j2, j3, j4);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStart() {
        super.modeStart();
        this.mRequestSpeedThrottleController.connectionThrottleStart();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
        super.modeStop();
        this.mRequestSpeedThrottleController.connectionThrottleStop();
        this.mRequestDelayController.releaseAllDelayedRequests();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.PRIORITY;
    }
}
