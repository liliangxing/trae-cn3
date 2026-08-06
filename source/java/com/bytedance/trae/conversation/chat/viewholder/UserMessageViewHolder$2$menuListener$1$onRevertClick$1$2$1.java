package com.bytedance.trae.conversation.chat.viewholder;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.trae.conversation.chat.MessageManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.AIEventContext;
import com.bytedance.trae.conversation.tracker.SoloChatMode;
import com.bytedance.trae.conversation.tracker.TraeAITracker;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.IRevertTaskApi;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.HttpDataResult;
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
/* compiled from: UserMessageViewHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1", f = "UserMessageViewHolder.kt", i = {}, l = {547}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ ParsedChatMessage $message;
    final /* synthetic */ SoloChatMode $revertChatMode;
    int label;
    final /* synthetic */ UserMessageViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1(String str, ParsedChatMessage parsedChatMessage, UserMessageViewHolder userMessageViewHolder, SoloChatMode soloChatMode, Continuation<? super UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1> continuation) {
        super(2, continuation);
        this.$conversationId = str;
        this.$message = parsedChatMessage;
        this.this$0 = userMessageViewHolder;
        this.$revertChatMode = soloChatMode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1(this.$conversationId, this.$message, this.this$0, this.$revertChatMode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        TextView textView;
        TextView textView2;
        ParsedChatMessage parsedChatMessage;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = IRevertTaskApi.INSTANCE.safeCall(new C0708x553e265c(this.$conversationId, this.$message, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (!(((HttpDataResult) obj) instanceof HttpDataResult.Success)) {
            textView = this.this$0.tvContent;
            Context context = textView.getContext();
            textView2 = this.this$0.tvContent;
            Toast.makeText(context, textView2.getContext().getString(R.string.trae_conversation_network_retry), 0).show();
        } else {
            MessageManager messageManager = MessageManager.INSTANCE;
            String str = this.$conversationId;
            String messageId = this.$message.getMessageId();
            parsedChatMessage = this.this$0.currentMessage;
            messageManager.notifyMessageReverted(str, messageId, parsedChatMessage);
            TraeAITracker.INSTANCE.trackRevertSuccess(new AIEventContext(null, this.$conversationId, this.$message.getMessageId(), null, 9, null), this.$revertChatMode);
        }
        return Unit.INSTANCE;
    }
}
