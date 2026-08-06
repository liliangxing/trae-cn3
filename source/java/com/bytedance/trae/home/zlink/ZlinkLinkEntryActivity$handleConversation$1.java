package com.bytedance.trae.home.zlink;

import android.content.Context;
import android.content.Intent;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.ConversationActivity;
import com.bytedance.trae.conversation.ConversationUtils;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.Conversation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ZlinkLinkEntryActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity$handleConversation$1", f = "ZlinkLinkEntryActivity.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ZlinkLinkEntryActivity$handleConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ ZlinkLinkEntryActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZlinkLinkEntryActivity$handleConversation$1(ZlinkLinkEntryActivity zlinkLinkEntryActivity, String str, Continuation<? super ZlinkLinkEntryActivity$handleConversation$1> continuation) {
        super(2, continuation);
        this.this$0 = zlinkLinkEntryActivity;
        this.$conversationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZlinkLinkEntryActivity$handleConversation$1(this.this$0, this.$conversationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Conversation resolveInitialConversation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BillingUpgradePromptCoordinator.awaitReady$default(BillingUpgradePromptCoordinator.INSTANCE, 0L, (Continuation) this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
            return Unit.INSTANCE;
        }
        Intent intent = new Intent((Context) this.this$0, (Class<?>) ConversationActivity.class);
        String str = this.$conversationId;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z && (resolveInitialConversation = ConversationUtils.INSTANCE.resolveInitialConversation(this.$conversationId, null)) != null && CliListRepository.INSTANCE.getInstance().getCliTypeById(resolveInitialConversation.getCliId()) != null) {
            resolveInitialConversation.setEnvironment(CliListRepository.INSTANCE.getInstance().getCliTypeById(resolveInitialConversation.getCliId()));
            intent.putExtra(ConversationActivity.EXTRA_CONVERSATION, resolveInitialConversation);
        }
        this.this$0.startActivity(intent);
        this.this$0.finish();
        return Unit.INSTANCE;
    }
}
