package com.bytedance.trae.conversation.chat.viewholder;

import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.conversation.ConversationViewModel;
import com.bytedance.trae.conversation.chat.IMessageListener;
import com.bytedance.trae.conversation.chat.MessageManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.AIEventContext;
import com.bytedance.trae.conversation.tracker.SoloChatMode;
import com.bytedance.trae.conversation.tracker.TraeAITracker;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.DeleteConversationRequest;
import com.bytedance.trae.im.service.DeleteTaskRequest;
import com.bytedance.trae.im.service.IDeleteConversationService;
import com.bytedance.trae.im.service.IDeleteTaskApi;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$handleDeleteClick$1$1", f = "UserMessageViewHolder.kt", i = {0, 1}, l = {307, 337}, m = "invokeSuspend", n = {"convId", "convId"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserMessageViewHolder$handleDeleteClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SoloChatMode $chatMode;
    final /* synthetic */ ParsedChatMessage $message;
    final /* synthetic */ int $userMessageCount;
    Object L$0;
    int label;
    final /* synthetic */ UserMessageViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMessageViewHolder$handleDeleteClick$1$1(UserMessageViewHolder userMessageViewHolder, int i, ParsedChatMessage parsedChatMessage, SoloChatMode soloChatMode, Continuation<? super UserMessageViewHolder$handleDeleteClick$1$1> continuation) {
        super(2, continuation);
        this.this$0 = userMessageViewHolder;
        this.$userMessageCount = i;
        this.$message = parsedChatMessage;
        this.$chatMode = soloChatMode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserMessageViewHolder$handleDeleteClick$1$1(this.this$0, this.$userMessageCount, this.$message, this.$chatMode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Conversation currentConversation;
        String id;
        String str;
        String str2;
        HttpDataResult.Success success;
        TextView textView;
        TextView textView2;
        HttpDataResult.Error error;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IMessageListener messageListener = this.this$0.getMessageListener();
            if (messageListener == null || (currentConversation = messageListener.getCurrentConversation()) == null || (id = currentConversation.getId()) == null) {
                return Unit.INSTANCE;
            }
            if (this.$userMessageCount == 1) {
                this.L$0 = id;
                this.label = 1;
                Object deleteConversationRawCall = IDeleteConversationService.INSTANCE.deleteConversationRawCall(new DeleteConversationRequest(id), (Continuation) this);
                if (deleteConversationRawCall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = id;
                obj = deleteConversationRawCall;
                success = (HttpDataResult) obj;
                if (success instanceof HttpDataResult.Success) {
                }
            } else {
                this.L$0 = id;
                this.label = 2;
                Object deleteTaskRawCall = IDeleteTaskApi.INSTANCE.deleteTaskRawCall(new DeleteTaskRequest(id, this.$message.getMessageId()), (Continuation) this);
                if (deleteTaskRawCall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = id;
                obj = deleteTaskRawCall;
                error = (HttpDataResult) obj;
                if (!(error instanceof HttpDataResult.Success)) {
                }
            }
        } else if (i == 1) {
            String str3 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            str2 = str3;
            success = (HttpDataResult) obj;
            if (success instanceof HttpDataResult.Success) {
                textView = this.this$0.tvContent;
                CustomToast.showLong(textView.getContext(), R.string.trae_conversation_network_retry);
            } else if (success.getBizResp().getCode() == ConversationViewModel.CODE_DEVICE_OFFLINE) {
                textView2 = this.this$0.tvContent;
                CustomToast.showLong(textView2.getContext(), R.string.trae_conversation_device_offline);
            } else {
                MessageManager.INSTANCE.notifyMessageDeleted(str2, this.$message.getMessageId());
                MessageManager.INSTANCE.notifyConversationDeleted(str2);
                TraeAITracker.INSTANCE.trackDeleteSuccess(new AIEventContext(null, str2, this.$message.getMessageId(), null, 9, null), this.$chatMode);
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str4 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            str = str4;
            error = (HttpDataResult) obj;
            if (!(error instanceof HttpDataResult.Success)) {
                MessageManager.INSTANCE.notifyMessageDeleted(str, this.$message.getMessageId());
                TraeAITracker.INSTANCE.trackDeleteSuccess(new AIEventContext(null, str, this.$message.getMessageId(), null, 9, null), this.$chatMode);
            } else if (!(error instanceof HttpDataResult.Error)) {
                textView3 = this.this$0.tvContent;
                Toast.makeText(textView3.getContext(), R.string.trae_conversation_network_retry, 1).show();
            } else if (error.getCode() == ConversationViewModel.CODE_DEVICE_OFFLINE) {
                textView5 = this.this$0.tvContent;
                Toast.makeText(textView5.getContext(), R.string.trae_conversation_device_offline, 1).show();
            } else {
                textView4 = this.this$0.tvContent;
                Toast.makeText(textView4.getContext(), R.string.trae_conversation_network_retry, 1).show();
            }
        }
        return Unit.INSTANCE;
    }
}
