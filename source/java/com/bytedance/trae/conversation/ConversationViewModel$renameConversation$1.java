package com.bytedance.trae.conversation;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.IRenameConversationService;
import com.bytedance.trae.im.service.RenameConversationRequest;
import com.bytedance.trae.im.service.RenameConversationResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$renameConversation$1", f = "ConversationViewModel.kt", i = {2}, l = {1844, 1848, 1850, 1855, 1861}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$renameConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ String $newTitle;
    Object L$0;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$renameConversation$1(String str, String str2, ConversationViewModel conversationViewModel, Continuation<? super ConversationViewModel$renameConversation$1> continuation) {
        super(2, continuation);
        this.$id = str;
        this.$newTitle = str2;
        this.this$0 = conversationViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$renameConversation$1(this.$id, this.$newTitle, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0126 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object renameConversationRawCall;
        HttpDataResult httpDataResult;
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        MutableSharedFlow mutableSharedFlow3;
        RenameConversationResponse renameConversationResponse;
        MutableSharedFlow mutableSharedFlow4;
        Conversation conversation;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        Conversation copy;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            renameConversationRawCall = IRenameConversationService.INSTANCE.renameConversationRawCall(new RenameConversationRequest(this.$id, this.$newTitle), (Continuation) this);
            if (renameConversationRawCall == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        httpDataResult = (HttpDataResult) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        renameConversationResponse = (RenameConversationResponse) ((HttpDataResult.Success) httpDataResult).getBizResp().getData();
                        if (renameConversationResponse != null && (conversation = renameConversationResponse.getConversation()) != null) {
                            ConversationViewModel conversationViewModel = this.this$0;
                            mutableStateFlow = conversationViewModel._conversation;
                            Conversation conversation2 = (Conversation) mutableStateFlow.getValue();
                            String environment = conversation2 == null ? conversation2.getEnvironment() : null;
                            mutableStateFlow2 = conversationViewModel._conversation;
                            mutableStateFlow3 = conversationViewModel._conversation;
                            Conversation conversation3 = (Conversation) mutableStateFlow3.getValue();
                            copy = conversation.copy((r44 & 1) != 0 ? conversation.id : null, (r44 & 2) != 0 ? conversation.parentConversationId : null, (r44 & 4) != 0 ? conversation.hiddenStatus : null, (r44 & 8) != 0 ? conversation.cliConversationId : null, (r44 & 16) != 0 ? conversation.userId : null, (r44 & 32) != 0 ? conversation.cliId : null, (r44 & 64) != 0 ? conversation.title : null, (r44 & 128) != 0 ? conversation.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation.mode : conversation3 == null ? conversation3.getMode() : null, (r44 & 1024) != 0 ? conversation.status : null, (r44 & 2048) != 0 ? conversation.environment : environment, (r44 & 4096) != 0 ? conversation.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation.createdAt : null, (r44 & 65536) != 0 ? conversation.updatedAt : null, (r44 & 131072) != 0 ? conversation.source : null, (r44 & 262144) != 0 ? conversation.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation.latestProjectId : null, (r44 & 4194304) != 0 ? conversation.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation.isPinned : null, (r44 & 33554432) != 0 ? conversation.pinnedAt : null);
                            mutableStateFlow2.setValue(copy);
                        }
                        mutableSharedFlow4 = this.this$0._renameSuccess;
                        this.L$0 = null;
                        this.label = 4;
                        if (mutableSharedFlow4.emit(this.$newTitle, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (i != 4 && i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            renameConversationRawCall = obj;
        }
        httpDataResult = (HttpDataResult) renameConversationRawCall;
        if (httpDataResult instanceof HttpDataResult.Success) {
            if (((HttpDataResult.Success) httpDataResult).getBizResp().getCode() == ConversationViewModel.CODE_DEVICE_OFFLINE) {
                mutableSharedFlow3 = this.this$0._toastMessage;
                this.label = 2;
                if (mutableSharedFlow3.emit(Boxing.boxInt(com.bytedance.trae.multilanguage.R.string.trae_conversation_device_offline), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                mutableSharedFlow2 = this.this$0._toastMessage;
                this.L$0 = httpDataResult;
                this.label = 3;
                if (mutableSharedFlow2.emit(Boxing.boxInt(com.bytedance.trae.multilanguage.R.string.trae_conversation_toast_rename_success), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                renameConversationResponse = (RenameConversationResponse) ((HttpDataResult.Success) httpDataResult).getBizResp().getData();
                if (renameConversationResponse != null) {
                    ConversationViewModel conversationViewModel2 = this.this$0;
                    mutableStateFlow = conversationViewModel2._conversation;
                    Conversation conversation22 = (Conversation) mutableStateFlow.getValue();
                    if (conversation22 == null) {
                    }
                    mutableStateFlow2 = conversationViewModel2._conversation;
                    mutableStateFlow3 = conversationViewModel2._conversation;
                    Conversation conversation32 = (Conversation) mutableStateFlow3.getValue();
                    copy = conversation.copy((r44 & 1) != 0 ? conversation.id : null, (r44 & 2) != 0 ? conversation.parentConversationId : null, (r44 & 4) != 0 ? conversation.hiddenStatus : null, (r44 & 8) != 0 ? conversation.cliConversationId : null, (r44 & 16) != 0 ? conversation.userId : null, (r44 & 32) != 0 ? conversation.cliId : null, (r44 & 64) != 0 ? conversation.title : null, (r44 & 128) != 0 ? conversation.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation.mode : conversation32 == null ? conversation32.getMode() : null, (r44 & 1024) != 0 ? conversation.status : null, (r44 & 2048) != 0 ? conversation.environment : environment, (r44 & 4096) != 0 ? conversation.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation.createdAt : null, (r44 & 65536) != 0 ? conversation.updatedAt : null, (r44 & 131072) != 0 ? conversation.source : null, (r44 & 262144) != 0 ? conversation.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation.latestProjectId : null, (r44 & 4194304) != 0 ? conversation.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation.isPinned : null, (r44 & 33554432) != 0 ? conversation.pinnedAt : null);
                    mutableStateFlow2.setValue(copy);
                }
                mutableSharedFlow4 = this.this$0._renameSuccess;
                this.L$0 = null;
                this.label = 4;
                if (mutableSharedFlow4.emit(this.$newTitle, (Continuation) this) == coroutine_suspended) {
                }
            }
        } else if (httpDataResult instanceof HttpDataResult.Error) {
            mutableSharedFlow = this.this$0._toastMessage;
            this.label = 5;
            if (mutableSharedFlow.emit(Boxing.boxInt(com.bytedance.trae.multilanguage.R.string.trae_conversation_toast_rename_failed), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
