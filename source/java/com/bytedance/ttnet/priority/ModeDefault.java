package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ModeDefault extends TTHttpCallPriorityControl.BaseModeControl {
    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStart() {
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
    }

    private int getDispatchDelayTime(Request request) {
        List<Header> headers = request.headers("x-tt-request-tag");
        return URLDispatcher.inst().getDelayResult(request.getUrl(), (headers == null || headers.size() < 1 || TextUtils.isEmpty(headers.get(0).getValue())) ? "" : headers.get(0).getValue());
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request request) throws Exception {
        long dispatchDelayTime = getDispatchDelayTime(request);
        if (Logger.debug()) {
            Logger.d("ModeDefault", "get tag delay time " + dispatchDelayTime + " " + request.getPath());
        }
        this.mRequestDelayController.requestBlockingDelay(request, true, false, dispatchDelayTime);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request request, Executor executor, Runnable runnable) throws Exception {
        long dispatchDelayTime = getDispatchDelayTime(request);
        if (Logger.debug()) {
            Logger.d("ModeDefault", "get tag delay time " + dispatchDelayTime + " " + request.getPath());
        }
        return this.mRequestDelayController.requestAsyncDelay(request, true, dispatchDelayTime, runnable, executor);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.DEFAULT;
    }
}
