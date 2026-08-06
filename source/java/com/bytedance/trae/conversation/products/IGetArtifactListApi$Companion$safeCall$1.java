package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.products.IGetArtifactListApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IGetArtifactListApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.IGetArtifactListApi$Companion", f = "IGetArtifactListApi.kt", i = {}, l = {29}, m = "safeCall", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IGetArtifactListApi$Companion$safeCall$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IGetArtifactListApi.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IGetArtifactListApi$Companion$safeCall$1(IGetArtifactListApi.Companion companion, Continuation<? super IGetArtifactListApi$Companion$safeCall$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.safeCall(null, (Continuation) this);
    }
}
