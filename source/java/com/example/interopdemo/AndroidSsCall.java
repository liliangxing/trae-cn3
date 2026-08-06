package com.example.interopdemo;

import com.example.interopdemo.request.Request;
import com.example.interopdemo.response.Response;
import com.example.interopdemo.response.ResponseCallback;
import com.example.kmp.shared.sha.TTHttpRequestBridge;
import com.example.kmp.shared.sha.TTHttpRequest_androidKt;
import com.lynx.tasm.DefaultLogicExecutor;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: SsCall.android.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/example/interopdemo/AndroidSsCall;", "Lcom/example/interopdemo/BaseSsCall;", "<init>", "()V", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "", "getName", "()Ljava/lang/String;", "httpRequest", "Lcom/example/kmp/shared/sha/TTHttpRequestBridge;", "execute", "Lcom/example/interopdemo/response/Response;", "request", "Lcom/example/interopdemo/request/Request;", "(Lcom/example/interopdemo/request/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeStream", "", "callback", "Lcom/example/interopdemo/response/ResponseCallback;", "(Lcom/example/interopdemo/request/Request;Lcom/example/interopdemo/response/ResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class AndroidSsCall extends BaseSsCall {
    private final String name = "AndroidSsCall";
    private final TTHttpRequestBridge httpRequest = TTHttpRequest_androidKt.getTTHttpRequest();

    @Override // com.example.interopdemo.SsCall
    public String getName() {
        return this.name;
    }

    @Override // com.example.interopdemo.SsCall
    public Object execute(Request request, Continuation<? super Response> continuation) {
        return executeInner(this.httpRequest, request, continuation);
    }

    @Override // com.example.interopdemo.SsCall
    public Object executeStream(Request request, ResponseCallback responseCallback, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.example.interopdemo.SsCall
    public void cancel() {
        this.httpRequest.cancel();
    }
}
