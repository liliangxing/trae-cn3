package com.bytedance.trae.conversation;

import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel", f = "ConversationViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1}, l = {1099, 1114}, m = "loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease", n = {"this", "conversationId", "anchorCreatedAtMs", "loader", OauthTokenTriggerScene.REQUEST, "beforeLimit", "afterLimit", "includeAnchor", OauthTokenTriggerScene.REQUEST}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "I$0", "I$1", "Z$0", "L$0"})
/* renamed from: com.bytedance.trae.conversation.ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0632xa56e9acb extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0632xa56e9acb(ConversationViewModel conversationViewModel, Continuation<? super C0632xa56e9acb> continuation) {
        super(continuation);
        this.this$0 = conversationViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m814x9d11ddca(null, null, 0, 0, false, null, (Continuation) this);
    }
}
