package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$ManagedCacheFileSystem", f = "ArtifactRepository.kt", i = {0, 1, 1, 1}, l = {441, 442}, m = "list", n = {"this", "this", "destination$iv$iv", "reference"}, s = {"L$0", "L$0", "L$1", "L$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactRepository$ManagedCacheFileSystem$list$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactRepository.ManagedCacheFileSystem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactRepository$ManagedCacheFileSystem$list$1(ArtifactRepository.ManagedCacheFileSystem managedCacheFileSystem, Continuation<? super ArtifactRepository$ManagedCacheFileSystem$list$1> continuation) {
        super(continuation);
        this.this$0 = managedCacheFileSystem;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.list((Continuation) this);
    }
}
