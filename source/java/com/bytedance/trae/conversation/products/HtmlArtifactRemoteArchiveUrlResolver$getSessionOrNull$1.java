package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver", f = "HtmlArtifactRemoteArchiveUrlResolver.kt", i = {0, 0}, l = {154}, m = "getSessionOrNull", n = {"this", "chatSessionId"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HtmlArtifactRemoteArchiveUrlResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1(HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver, Continuation<? super HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1> continuation) {
        super(continuation);
        this.this$0 = htmlArtifactRemoteArchiveUrlResolver;
    }

    public final Object invokeSuspend(Object obj) {
        Object sessionOrNull;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        sessionOrNull = this.this$0.getSessionOrNull(null, (Continuation) this);
        return sessionOrNull;
    }
}
