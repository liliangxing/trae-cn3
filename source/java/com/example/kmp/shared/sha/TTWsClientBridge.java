package com.example.kmp.shared.sha;

import com.bytedance.apm.constant.CommonKey;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: TTWsClientBridge.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\fJ\u000e\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\fJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/example/kmp/shared/sha/TTWsClientBridge;", "", "<init>", "()V", "register", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/example/kmp/shared/sha/WsBridgeListener;", "bridgeInfo", "Lcom/example/kmp/shared/sha/WsBridgeInfo;", "(Lcom/example/kmp/shared/sha/WsBridgeListener;Lcom/example/kmp/shared/sha/WsBridgeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "isConnected", "", CommonKey.KEY_SEND, "text", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class TTWsClientBridge {
    public abstract Object isConnected(Continuation<? super Boolean> continuation);

    public abstract Object register(WsBridgeListener wsBridgeListener, WsBridgeInfo wsBridgeInfo, Continuation<? super Unit> continuation);

    public abstract Object send(String str, Continuation<? super Unit> continuation);

    public abstract Object send(byte[] bArr, Continuation<? super Unit> continuation);

    public abstract Object start(Continuation<? super Unit> continuation);

    public abstract Object stop(Continuation<? super Unit> continuation);
}
