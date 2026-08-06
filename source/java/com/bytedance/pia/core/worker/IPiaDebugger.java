package com.bytedance.pia.core.worker;

import android.view.View;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.vmsdk.worker.JsWorker;
import kotlin.Metadata;

/* compiled from: IPiaDebugger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/core/worker/IPiaDebugger;", "", "onJsbRequest", "", "methodName", "", "params", "result", "target", "Landroid/view/View;", "startTime", "", "onWorkerCreate", ErrorType.WORKER, "Lcom/bytedance/vmsdk/worker/JsWorker;", "url", "scriptUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPiaDebugger {
    void onJsbRequest(String methodName, Object params, Object result, View target, long startTime);

    void onWorkerCreate(JsWorker worker, String url, String scriptUrl);
}
