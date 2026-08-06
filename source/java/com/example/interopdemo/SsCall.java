package com.example.interopdemo;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.example.interopdemo.request.Request;
import com.example.interopdemo.response.Response;
import com.example.interopdemo.response.ResponseCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: SsCall.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/example/interopdemo/SsCall;", "", "name", "", "getName", "()Ljava/lang/String;", "execute", "Lcom/example/interopdemo/response/Response;", OauthTokenTriggerScene.REQUEST, "Lcom/example/interopdemo/request/Request;", "(Lcom/example/interopdemo/request/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeStream", "", JsCallParser.VALUE_CALLBACK, "Lcom/example/interopdemo/response/ResponseCallback;", "(Lcom/example/interopdemo/request/Request;Lcom/example/interopdemo/response/ResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface SsCall {
    void cancel();

    Object execute(Request request, Continuation<? super Response> continuation);

    Object executeStream(Request request, ResponseCallback responseCallback, Continuation<? super Unit> continuation);

    String getName();
}
