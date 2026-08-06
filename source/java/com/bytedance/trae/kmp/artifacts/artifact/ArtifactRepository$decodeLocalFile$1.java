package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository", f = "ArtifactRepository.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {321, 328, 332, 339, 345, 345}, m = "decodeLocalFile", n = {"this", EventConstants.PARAM_SOURCE, "this", EventConstants.PARAM_SOURCE, "destination", "decoder", "completed", "offset", "append", "this", EventConstants.PARAM_SOURCE, "destination", "decoder", "chunk", "completed", "offset", "this", "destination", "completed"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "J$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0", "L$0", "L$1", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactRepository$decodeLocalFile$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactRepository$decodeLocalFile$1(ArtifactRepository artifactRepository, Continuation<? super ArtifactRepository$decodeLocalFile$1> continuation) {
        super(continuation);
        this.this$0 = artifactRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object decodeLocalFile;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        decodeLocalFile = this.this$0.decodeLocalFile(null, (Continuation) this);
        return decodeLocalFile;
    }
}
