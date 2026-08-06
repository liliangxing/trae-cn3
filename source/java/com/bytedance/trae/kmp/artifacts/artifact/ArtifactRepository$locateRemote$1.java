package com.bytedance.trae.kmp.artifacts.artifact;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository", f = "ArtifactRepository.kt", i = {0}, l = {265}, m = "locateRemote", n = {"request"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactRepository$locateRemote$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactRepository$locateRemote$1(ArtifactRepository artifactRepository, Continuation<? super ArtifactRepository$locateRemote$1> continuation) {
        super(continuation);
        this.this$0 = artifactRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object locateRemote;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        locateRemote = this.this$0.locateRemote(null, (Continuation) this);
        return locateRemote;
    }
}
