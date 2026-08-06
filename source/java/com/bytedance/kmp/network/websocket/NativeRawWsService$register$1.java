package com.bytedance.kmp.network.websocket;

import com.bytedance.memory.shrink.HprofMemoryConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NativeRawWsService.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.websocket.NativeRawWsService", f = "NativeRawWsService.kt", i = {0, 0, 0, 0, 0, 1, 2, 2}, l = {HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_FINALIZING, 71, 170}, m = "register", n = {"info", "listener", "clientId", "client", "$this$withLock_u24default$iv", "clientId", "clientId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NativeRawWsService$register$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NativeRawWsService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeRawWsService$register$1(NativeRawWsService nativeRawWsService, Continuation<? super NativeRawWsService$register$1> continuation) {
        super(continuation);
        this.this$0 = nativeRawWsService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.register(null, null, (Continuation) this);
    }
}
