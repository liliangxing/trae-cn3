package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile", f = "ArtifactRepository.kt", i = {0, 0}, l = {542, 495}, m = "finishDistribution", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactRepository$SharedTemporaryFile$finishDistribution$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactRepository.SharedTemporaryFile this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactRepository$SharedTemporaryFile$finishDistribution$1(ArtifactRepository.SharedTemporaryFile sharedTemporaryFile, Continuation<? super ArtifactRepository$SharedTemporaryFile$finishDistribution$1> continuation) {
        super(continuation);
        this.this$0 = sharedTemporaryFile;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.finishDistribution((Continuation) this);
    }
}
