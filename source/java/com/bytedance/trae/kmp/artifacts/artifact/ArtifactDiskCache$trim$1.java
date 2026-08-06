package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.memory.shrink.HprofMemoryConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactDiskCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache", f = "ArtifactDiskCache.kt", i = {0, 0, 1}, l = {HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_UNREACHABLE, 96}, m = "trim", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactDiskCache$trim$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactDiskCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDiskCache$trim$1(ArtifactDiskCache artifactDiskCache, Continuation<? super ArtifactDiskCache$trim$1> continuation) {
        super(continuation);
        this.this$0 = artifactDiskCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.trim((Continuation) this);
    }
}
