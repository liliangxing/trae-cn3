package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.products.IShareLinkApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IShareLinkApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.IShareLinkApi$Companion", f = "IShareLinkApi.kt", i = {}, l = {120}, m = "createLocalShareLink", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IShareLinkApi$Companion$createLocalShareLink$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IShareLinkApi.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IShareLinkApi$Companion$createLocalShareLink$1(IShareLinkApi.Companion companion, Continuation<? super IShareLinkApi$Companion$createLocalShareLink$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createLocalShareLink(null, (Continuation) this);
    }
}
