package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.memory.shrink.HprofMemoryConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository", f = "ArtifactRepository.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 5, 5, 5, 5, 5, 5, 5, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 11, 11, 11, 11, 11}, l = {134, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_UNREACHABLE, 146, 147, 148, 543, 163, 166, 553, 178, 179, 563}, m = "prepareInRepositoryContext", n = {"this", "request", "this", "request", "key", "cacheReference", "cached", "this", "cacheReference", "cached", "accessTime", "this", "cacheReference", "cached", "this", "request", "key", "cacheReference", "cached", "waiter", "$this$withLock_u24default$iv", "this", "key", "waiter", "flight", "this", "key", "waiter", "flight", "prepared", "$this$withLock_u24default$iv", "this", "key", "waiter", "flight", "this", "key", "flight", "this", "key", "flight", "cancellation", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactRepository$prepareInRepositoryContext$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactRepository$prepareInRepositoryContext$1(ArtifactRepository artifactRepository, Continuation<? super ArtifactRepository$prepareInRepositoryContext$1> continuation) {
        super(continuation);
        this.this$0 = artifactRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object prepareInRepositoryContext;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        prepareInRepositoryContext = this.this$0.prepareInRepositoryContext(null, (Continuation) this);
        return prepareInRepositoryContext;
    }
}
