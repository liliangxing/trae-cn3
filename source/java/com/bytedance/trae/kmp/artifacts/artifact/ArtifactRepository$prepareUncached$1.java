package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ug.sdk.share.api.entity.ToastCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository", f = "ArtifactRepository.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 9, 9, 9, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 16, 16, 16}, l = {197, 199, ToastCode.TELEGRAM_NOT_INSTALL, 246, 250, 222, 226, 246, 250, 246, 250, 237, 239, 241, 246, 250, 246, 250}, m = "prepareUncached", n = {"this", "request", "cacheReference", "cached", "this", "request", "cacheReference", "cached", "downloadRequest", "this", "request", "cacheReference", "cached", "downloaded", "cleanupCandidates", "downloadTask", "this", "cleanupCandidates", "this", "cacheReference", "cached", "cleanupCandidates", "this", "cacheReference", "cached", "cleanupCandidates", "prepared", "this", "cleanupCandidates", "this", "cleanupCandidates", "retainedFile", "this", "cacheReference", "cached", "cleanupCandidates", "metadata", "this", "cacheReference", "cached", "cleanupCandidates", "metadata", "accessTime", "this", "cacheReference", "cached", "cleanupCandidates", "this", "cleanupCandidates", "retainedFile", "this", "cleanupCandidates", "retainedFile"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactRepository$prepareUncached$1 extends ContinuationImpl {
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
    public ArtifactRepository$prepareUncached$1(ArtifactRepository artifactRepository, Continuation<? super ArtifactRepository$prepareUncached$1> continuation) {
        super(continuation);
        this.this$0 = artifactRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object prepareUncached;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        prepareUncached = this.this$0.prepareUncached(null, null, null, (Continuation) this);
        return prepareUncached;
    }
}
