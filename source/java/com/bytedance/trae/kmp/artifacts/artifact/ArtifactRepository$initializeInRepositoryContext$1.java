package com.bytedance.trae.kmp.artifacts.artifact;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository", f = "ArtifactRepository.kt", i = {0, 0, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5}, l = {542, 83, 87, 552, 562, 572}, m = "initializeInRepositoryContext", n = {"this", "$this$withLock_u24default$iv", "this", "deferred", "this", "deferred", "$this$withLock_u24default$iv", "this", "deferred", "cancellation", "$this$withLock_u24default$iv", "this", "deferred", "throwable", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactRepository$initializeInRepositoryContext$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactRepository$initializeInRepositoryContext$1(ArtifactRepository artifactRepository, Continuation<? super ArtifactRepository$initializeInRepositoryContext$1> continuation) {
        super(continuation);
        this.this$0 = artifactRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object initializeInRepositoryContext;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        initializeInRepositoryContext = this.this$0.initializeInRepositoryContext((Continuation) this);
        return initializeInRepositoryContext;
    }
}
