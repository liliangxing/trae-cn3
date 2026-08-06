package com.bytedance.trae.conversation.chat.viewholder;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.trae.conversation.ConversationViewModel;
import com.bytedance.trae.conversation.chat.menu.RevertConfirmDialog;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.SoloChatMode;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.DiffFileInfo;
import com.bytedance.trae.im.service.IRevertCheckTaskApi;
import com.bytedance.trae.im.service.RevertCheckTaskRequest;
import com.bytedance.trae.im.service.RevertCheckTaskResponse;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: UserMessageViewHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$2$menuListener$1$onRevertClick$1", f = "UserMessageViewHolder.kt", i = {0}, l = {474}, m = "invokeSuspend", n = {"conversationId"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class UserMessageViewHolder$2$menuListener$1$onRevertClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstMessage;
    final /* synthetic */ ParsedChatMessage $message;
    final /* synthetic */ SoloChatMode $revertChatMode;
    Object L$0;
    int label;
    final /* synthetic */ UserMessageViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMessageViewHolder$2$menuListener$1$onRevertClick$1(UserMessageViewHolder userMessageViewHolder, ParsedChatMessage parsedChatMessage, boolean z, SoloChatMode soloChatMode, Continuation<? super UserMessageViewHolder$2$menuListener$1$onRevertClick$1> continuation) {
        super(2, continuation);
        this.this$0 = userMessageViewHolder;
        this.$message = parsedChatMessage;
        this.$isFirstMessage = z;
        this.$revertChatMode = soloChatMode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserMessageViewHolder$2$menuListener$1$onRevertClick$1(this.this$0, this.$message, this.$isFirstMessage, this.$revertChatMode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String id;
        final String str;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Conversation currentConversation = this.this$0.getMessageListener().getCurrentConversation();
            if (currentConversation == null || (id = currentConversation.getId()) == null) {
                return Unit.INSTANCE;
            }
            this.L$0 = id;
            this.label = 1;
            Object revertCheckTaskRawCall = IRevertCheckTaskApi.INSTANCE.revertCheckTaskRawCall(new RevertCheckTaskRequest(id, this.$message.getMessageId()), (Continuation) this);
            if (revertCheckTaskRawCall == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = id;
            obj = revertCheckTaskRawCall;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        HttpDataResult.Success success = (HttpDataResult) obj;
        if (success instanceof HttpDataResult.Success) {
            RevertCheckTaskResponse revertCheckTaskResponse = (RevertCheckTaskResponse) success.getBizResp().getData();
            List<DiffFileInfo> diffFileInfos = revertCheckTaskResponse != null ? revertCheckTaskResponse.getDiffFileInfos() : null;
            if (diffFileInfos == null) {
                diffFileInfos = CollectionsKt.emptyList();
            }
            List<DiffFileInfo> list = diffFileInfos;
            try {
                textView7 = this.this$0.tvContent;
                Context context = textView7.getContext();
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (!(activity != null && activity.isFinishing())) {
                    Activity activity2 = context instanceof Activity ? (Activity) context : null;
                    if (activity2 == null || !activity2.isDestroyed()) {
                        z = false;
                    }
                    if (!z) {
                        if (this.$isFirstMessage) {
                            Intrinsics.checkNotNull(context);
                            String string = context.getString(R.string.trae_conversation_revert_dialog_title);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            String string2 = context.getString(R.string.trae_conversation_dialog_btn_cancel);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            String string3 = context.getString(R.string.trae_conversation_dialog_btn_confirm);
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                            String string4 = context.getString(R.string.trae_conversation_revert_first_message);
                            final UserMessageViewHolder userMessageViewHolder = this.this$0;
                            final ParsedChatMessage parsedChatMessage = this.$message;
                            final SoloChatMode soloChatMode = this.$revertChatMode;
                            new RevertConfirmDialog(context, string, list, string2, string3, string4, new Function0() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda0
                                public final Object invoke() {
                                    Unit invokeSuspend$lambda$0;
                                    invokeSuspend$lambda$0 = UserMessageViewHolder$2$menuListener$1$onRevertClick$1.invokeSuspend$lambda$0(UserMessageViewHolder.this, parsedChatMessage, soloChatMode);
                                    return invokeSuspend$lambda$0;
                                }
                            }).show();
                        } else {
                            Intrinsics.checkNotNull(context);
                            String string5 = context.getString(R.string.trae_conversation_revert_dialog_title);
                            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                            String string6 = context.getString(R.string.trae_conversation_dialog_btn_cancel);
                            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                            String string7 = context.getString(R.string.trae_conversation_dialog_btn_confirm);
                            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                            final ParsedChatMessage parsedChatMessage2 = this.$message;
                            final UserMessageViewHolder userMessageViewHolder2 = this.this$0;
                            final SoloChatMode soloChatMode2 = this.$revertChatMode;
                            new RevertConfirmDialog(context, string5, list, string6, string7, null, new Function0() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$2$menuListener$1$onRevertClick$1$$ExternalSyntheticLambda1
                                public final Object invoke() {
                                    Unit invokeSuspend$lambda$1;
                                    invokeSuspend$lambda$1 = UserMessageViewHolder$2$menuListener$1$onRevertClick$1.invokeSuspend$lambda$1(str, parsedChatMessage2, userMessageViewHolder2, soloChatMode2);
                                    return invokeSuspend$lambda$1;
                                }
                            }, 32, null).show();
                        }
                    }
                }
                return Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        } else {
            if (!(success instanceof HttpDataResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            HttpDataResult.Error error = (HttpDataResult.Error) success;
            if (error.getCode() == ConversationViewModel.CODE_DEVICE_OFFLINE) {
                textView5 = this.this$0.tvContent;
                Context context2 = textView5.getContext();
                textView6 = this.this$0.tvContent;
                Toast.makeText(context2, textView6.getContext().getString(R.string.trae_conversation_device_offline), 0).show();
                return Unit.INSTANCE;
            }
            if (error.getCode() == 991505) {
                textView3 = this.this$0.tvContent;
                Context context3 = textView3.getContext();
                textView4 = this.this$0.tvContent;
                Toast.makeText(context3, textView4.getContext().getString(R.string.trae_conversation_check_rollback_failed), 0).show();
            } else {
                textView = this.this$0.tvContent;
                Context context4 = textView.getContext();
                textView2 = this.this$0.tvContent;
                Toast.makeText(context4, textView2.getContext().getString(R.string.trae_conversation_network_retry), 0).show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(UserMessageViewHolder userMessageViewHolder, ParsedChatMessage parsedChatMessage, SoloChatMode soloChatMode) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new UserMessageViewHolder$2$menuListener$1$onRevertClick$1$1$1(userMessageViewHolder, parsedChatMessage, soloChatMode, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(String str, ParsedChatMessage parsedChatMessage, UserMessageViewHolder userMessageViewHolder, SoloChatMode soloChatMode) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new UserMessageViewHolder$2$menuListener$1$onRevertClick$1$2$1(str, parsedChatMessage, userMessageViewHolder, soloChatMode, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}
