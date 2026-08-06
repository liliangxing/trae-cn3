package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactDiskCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache$Lease", f = "ArtifactDiskCache.kt", i = {0, 0, 1, 1, 2}, l = {HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_UNREACHABLE, 131, 134}, m = "close", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactDiskCache$Lease$close$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactDiskCache.Lease this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDiskCache$Lease$close$1(ArtifactDiskCache.Lease lease, Continuation<? super ArtifactDiskCache$Lease$close$1> continuation) {
        super(continuation);
        this.this$0 = lease;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.close((Continuation) this);
    }
}
