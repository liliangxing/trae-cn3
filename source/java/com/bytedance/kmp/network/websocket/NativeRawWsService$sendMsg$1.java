package com.bytedance.kmp.network.websocket;

import com.bytedance.memory.shrink.HprofMemoryConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NativeRawWsService.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.websocket.NativeRawWsService", f = "NativeRawWsService.kt", i = {0, 0, 0, 1, 2}, l = {HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_FINALIZING, 113, 114}, m = "sendMsg", n = {"msg", "$this$withLock_u24default$iv", "id", "id", "id"}, s = {"L$0", "L$1", "I$0", "I$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NativeRawWsService$sendMsg$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NativeRawWsService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeRawWsService$sendMsg$1(NativeRawWsService nativeRawWsService, Continuation<? super NativeRawWsService$sendMsg$1> continuation) {
        super(continuation);
        this.this$0 = nativeRawWsService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendMsg(0, null, (Continuation) this);
    }
}
