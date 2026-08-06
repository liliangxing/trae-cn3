package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTask;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ModeRuntimeDelay extends TTHttpCallPriorityControl.BaseModeControl {
    private final RequestDropController mRequestDropController = new RequestDropController();
    private final Set<String> mP0List = new CopyOnWriteArraySet();
    private final Set<String> mBlackListForRuntime = new CopyOnWriteArraySet();
    private final Set<String> mWhiteListForRuntime = new CopyOnWriteArraySet();
    private int mP0CheckCountdownMs = 5000;
    private int mP1MaxWaitMs = 5000;
    private final AtomicLong mLastP0StartTime = new AtomicLong(0);
    private final Set<Request> mRuntimePOSet = new CopyOnWriteArraySet();

    private boolean checkRequestForRuntime(Request request) throws DroppedByThrottleControlException {
        this.mRequestDropController.raiseExceptionIfDrop(request);
        boolean z = false;
        if (TTHttpCallPriorityControl.isMatch(this.mP0List, request.getPath())) {
            this.mLastP0StartTime.set(System.currentTimeMillis());
            this.mRuntimePOSet.add(request);
            return false;
        }
        if (System.currentTimeMillis() - this.mLastP0StartTime.get() <= this.mP0CheckCountdownMs && !this.mRuntimePOSet.isEmpty()) {
            if (!this.mBlackListForRuntime.isEmpty()) {
                return TTHttpCallPriorityControl.isMatch(this.mBlackListForRuntime, request.getPath());
            }
            z = true;
            if (!this.mWhiteListForRuntime.isEmpty()) {
                return !TTHttpCallPriorityControl.isMatch(this.mWhiteListForRuntime, request.getPath());
            }
        }
        return z;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request request) throws Exception {
        if (checkRequestForRuntime(request)) {
            this.mRequestDelayController.requestBlockingDelay(request, false, true, this.mP1MaxWaitMs);
        }
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request request, Executor executor, Runnable runnable) throws Exception {
        if (checkRequestForRuntime(request)) {
            return this.mRequestDelayController.requestAsyncDelay(request, false, this.mP1MaxWaitMs, runnable, executor);
        }
        return false;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl, com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(final Request request) {
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new NetworkAsyncTask() { // from class: com.bytedance.ttnet.priority.ModeRuntimeDelay.1
            public void run() {
                if (ModeRuntimeDelay.this.mRuntimePOSet.remove(request) && ModeRuntimeDelay.this.mRuntimePOSet.size() == 0) {
                    ModeRuntimeDelay.this.mRequestDelayController.releaseAllDelayedRequests();
                }
            }
        });
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public boolean initWithTncConfig(JSONObject jSONObject) {
        super.initWithTncConfig(jSONObject);
        this.mRequestDropController.initWithTncConfig(jSONObject);
        this.mRequestDelayController.initWithTncConfig(jSONObject, this.mStateName);
        JSONArray optJSONArray = jSONObject.optJSONArray("p0");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.mP0List.add(optString);
                }
            }
        }
        if (!this.mRequestDropController.isValid() && this.mP0List.isEmpty()) {
            return false;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("bl_for_runtime");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                String optString2 = optJSONArray2.optString(i2);
                if (!TextUtils.isEmpty(optString2)) {
                    this.mBlackListForRuntime.add(optString2);
                }
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("wl_for_runtime");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                String optString3 = optJSONArray3.optString(i3);
                if (!TextUtils.isEmpty(optString3)) {
                    this.mWhiteListForRuntime.add(optString3);
                }
            }
        }
        this.mP0CheckCountdownMs = jSONObject.optInt("p0_check_max_ms", 5000);
        this.mP1MaxWaitMs = jSONObject.optInt("p1_wait_max_ms", 5000);
        return true;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
        super.modeStop();
        this.mRequestDelayController.releaseAllDelayedRequests();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.RUNTIME_DELAY;
    }
}
