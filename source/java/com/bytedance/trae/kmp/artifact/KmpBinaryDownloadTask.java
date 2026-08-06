package com.bytedance.trae.kmp.artifact;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: KmpArtifactIo.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadTask;", "", "await", "Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface KmpBinaryDownloadTask {
    Object await(Continuation<? super KmpBinaryDownloadResult> continuation);

    void cancel();
}
