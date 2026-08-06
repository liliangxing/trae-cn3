package com.bytedance.ies.tools.prefetch;

import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: PrefetchMethodStub.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IPrefetchMethodStub;", "Lcom/bytedance/ies/tools/prefetch/ProcessListener;", "invoke", "", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "params", "Lorg/json/JSONObject;", "invokeForceFallback", "onTerminate", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPrefetchMethodStub extends ProcessListener {
    void invoke(PrefetchRequest request);

    void invoke(JSONObject params);

    void invokeForceFallback(PrefetchRequest request);

    void invokeForceFallback(JSONObject params);

    void onTerminate();
}
