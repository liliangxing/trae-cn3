package com.bytedance.trae.kmp.artifact;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KmpArtifactIo.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifact.InMemoryKmpArtifactFileSystem", f = "KmpArtifactIo.kt", i = {0, 0, 0, 0, 0}, l = {169}, m = "write", n = {"this", "file", "bytes", "$this$withLock_u24default$iv", "append"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InMemoryKmpArtifactFileSystem$write$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InMemoryKmpArtifactFileSystem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMemoryKmpArtifactFileSystem$write$1(InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem, Continuation<? super InMemoryKmpArtifactFileSystem$write$1> continuation) {
        super(continuation);
        this.this$0 = inMemoryKmpArtifactFileSystem;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.write(null, null, false, (Continuation) this);
    }
}
