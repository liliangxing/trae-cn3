package com.bytedance.ies.tools.prefetch.ies;

import com.bytedance.ies.tools.prefetch.IPrefetchProcessor;
import com.bytedance.ies.tools.prefetch.IPrefetchResultListener;
import com.bytedance.ies.tools.prefetch.PrefetchMethodStub;
import com.bytedance.ies.web.jsbridge2.BaseStatefulMethod;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0014B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0094\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/ies/PrefetchMethod;", "Lcom/bytedance/ies/web/jsbridge2/BaseStatefulMethod;", "Lorg/json/JSONObject;", "Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener;", "prefetchProcessor", "Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;", "(Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;)V", "stub", "Lcom/bytedance/ies/tools/prefetch/PrefetchMethodStub;", "invoke", "", "params", "context", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", "onFailed", "throwable", "", "onSucceed", "result", "onTerminate", "Companion", "prefetch-ies_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchMethod extends BaseStatefulMethod<JSONObject, JSONObject> implements IPrefetchResultListener {
    public static final String DEFAULT_PREFETCH_METHOD_NAME = "__prefetch";
    private final PrefetchMethodStub stub;

    public PrefetchMethod(IPrefetchProcessor iPrefetchProcessor) {
        Intrinsics.checkParameterIsNotNull(iPrefetchProcessor, "prefetchProcessor");
        this.stub = new PrefetchMethodStub(iPrefetchProcessor, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.web.jsbridge2.BaseStatefulMethod
    public void invoke(JSONObject params, CallContext context) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.stub.invoke(params);
    }

    @Override // com.bytedance.ies.web.jsbridge2.BaseStatefulMethod
    protected void onTerminate() {
        this.stub.onTerminate();
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchResultListener
    public void onSucceed(JSONObject result) {
        Intrinsics.checkParameterIsNotNull(result, "result");
        finishWithResult(result);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchResultListener
    public void onFailed(Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        finishWithFailure(throwable);
    }
}
