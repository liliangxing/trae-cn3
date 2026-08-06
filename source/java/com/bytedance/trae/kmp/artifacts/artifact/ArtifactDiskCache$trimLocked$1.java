package com.bytedance.trae.kmp.artifacts.artifact;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactDiskCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache", f = "ArtifactDiskCache.kt", i = {0, 0, 0}, l = {107}, m = "trimLocked", n = {"this", "entry", "totalBytes"}, s = {"L$0", "L$2", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactDiskCache$trimLocked$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactDiskCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDiskCache$trimLocked$1(ArtifactDiskCache artifactDiskCache, Continuation<? super ArtifactDiskCache$trimLocked$1> continuation) {
        super(continuation);
        this.this$0 = artifactDiskCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.trimLocked((Continuation) this);
    }
}
