package com.bytedance.sync.p005v4.topic;

import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.exc.SyncException;
import com.bytedance.sync.interfaze.Callback;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.model.Topic;
import com.bytedance.sync.util.JSONUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SubscribeTopicCallbackWrapper implements Callback<Void> {
    private final String mAction;
    private final Callback<Void> mCallback;
    private final Topic mTopic;

    public SubscribeTopicCallbackWrapper(Topic topic, String str, Callback<Void> callback) {
        this.mCallback = callback;
        this.mTopic = topic;
        this.mAction = str;
    }

    @Override // com.bytedance.sync.interfaze.Callback
    public void onSuccess(Void r3) {
        LogUtils.m185d(this.mTopic + " " + this.mAction + " success");
        Callback<Void> callback = this.mCallback;
        if (callback != null) {
            callback.onSuccess(r3);
        }
        monitor(true, 0, null);
    }

    private void monitor(boolean z, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONUtils.safePutParam(jSONObject, "success", z);
        JSONUtils.safePutParam(jSONObject, "method", this.mAction);
        JSONUtils.safePutParam(jSONObject, "business", this.mTopic.getBusiness());
        if (!z) {
            JSONUtils.safePutParam(jSONObject, "error_code", i);
            JSONUtils.safePutParam(jSONObject, "error_msg", str);
        }
        SyncMonitor.monitor("sync_sdk_custom_topic", jSONObject, null, null);
    }

    @Override // com.bytedance.sync.interfaze.Callback
    public void onFailed(SyncException syncException) {
        LogUtils.m185d(this.mTopic + " " + this.mAction + " failed. reason :code-> " + syncException.getErrorCode() + ", msg = " + syncException.getErrorMsg());
        Callback<Void> callback = this.mCallback;
        if (callback != null) {
            callback.onFailed(syncException);
        }
        monitor(false, syncException.getErrorCode(), syncException.getErrorMsg());
    }
}
