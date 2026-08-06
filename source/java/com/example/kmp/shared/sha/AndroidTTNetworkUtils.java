package com.example.kmp.shared.sha;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTNetworkUtilsBridge.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/example/kmp/shared/sha/AndroidTTNetworkUtils;", "Lcom/example/kmp/shared/sha/TTNetworkUtilsBridge;", "<init>", "()V", "preConnect", "", "host", "", "getMultiNetState", "Lcom/example/kmp/shared/sha/MultiNetStateBridge;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AndroidTTNetworkUtils extends TTNetworkUtilsBridge {
    @Override // com.example.kmp.shared.sha.TTNetworkUtilsBridge
    public void preConnect(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.example.kmp.shared.sha.TTNetworkUtilsBridge
    public Object getMultiNetState(Continuation<? super MultiNetStateBridge> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
