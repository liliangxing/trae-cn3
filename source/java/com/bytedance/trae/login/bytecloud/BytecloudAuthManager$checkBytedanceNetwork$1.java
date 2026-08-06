package com.bytedance.trae.login.bytecloud;

import com.bytedance.memory.shrink.HprofMemoryConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BytecloudAuthManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.bytecloud.BytecloudAuthManager", f = "BytecloudAuthManager.kt", i = {0, 1}, l = {365, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_DEBUGGER}, m = "checkBytedanceNetwork", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudAuthManager$checkBytedanceNetwork$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BytecloudAuthManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytecloudAuthManager$checkBytedanceNetwork$1(BytecloudAuthManager bytecloudAuthManager, Continuation<? super BytecloudAuthManager$checkBytedanceNetwork$1> continuation) {
        super(continuation);
        this.this$0 = bytecloudAuthManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkBytedanceNetwork((Continuation) this);
    }
}
