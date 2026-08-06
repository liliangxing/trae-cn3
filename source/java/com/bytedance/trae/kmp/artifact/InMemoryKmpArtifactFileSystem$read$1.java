package com.bytedance.trae.kmp.artifact;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KmpArtifactIo.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifact.InMemoryKmpArtifactFileSystem", f = "KmpArtifactIo.kt", i = {0, 0, 0, 0, 0}, l = {169}, m = "read", n = {"this", "file", "$this$withLock_u24default$iv", "offset", "length"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InMemoryKmpArtifactFileSystem$read$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InMemoryKmpArtifactFileSystem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMemoryKmpArtifactFileSystem$read$1(InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem, Continuation<? super InMemoryKmpArtifactFileSystem$read$1> continuation) {
        super(continuation);
        this.this$0 = inMemoryKmpArtifactFileSystem;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.read(null, 0L, 0, (Continuation) this);
    }
}
