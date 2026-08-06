package com.example.kmp.shared.sha;

import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: TTHttpRequest.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/example/kmp/shared/sha/AndroidTTHttpRequest;", "Lcom/example/kmp/shared/sha/TTHttpRequestBridge;", "<init>", "()V", "execute", "Lcom/example/kmp/shared/sha/BridgeResponse;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeStream", "", JsCallParser.VALUE_CALLBACK, "Lcom/example/kmp/shared/sha/BridgeResponseCallback;", "(Ljava/lang/String;Lcom/example/kmp/shared/sha/BridgeResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AndroidTTHttpRequest extends TTHttpRequestBridge {
    @Override // com.example.kmp.shared.sha.TTHttpRequestBridge
    public Object execute(String str, Continuation<? super BridgeResponse> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.example.kmp.shared.sha.TTHttpRequestBridge
    public Object executeStream(String str, BridgeResponseCallback bridgeResponseCallback, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.example.kmp.shared.sha.TTHttpRequestBridge
    public void cancel() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
