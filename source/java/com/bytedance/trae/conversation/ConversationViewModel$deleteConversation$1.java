package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.repository.ConversationDetailCacheRepository;
import com.bytedance.trae.im.service.DeleteConversationRequest;
import com.bytedance.trae.im.service.IDeleteConversationService;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$deleteConversation$1", f = "ConversationViewModel.kt", i = {}, l = {1870, 1874, 1878, 1882, 1883, 1889}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$deleteConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$deleteConversation$1(String str, ConversationViewModel conversationViewModel, Continuation<? super ConversationViewModel$deleteConversation$1> continuation) {
        super(2, continuation);
        this.$id = str;
        this.this$0 = conversationViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$deleteConversation$1(this.$id, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00d2 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HttpDataResult.Success success;
        MutableSharedFlow mutableSharedFlow;
        MutableStateFlow mutableStateFlow;
        MutableSharedFlow mutableSharedFlow2;
        MutableSharedFlow mutableSharedFlow3;
        MutableSharedFlow mutableSharedFlow4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = IDeleteConversationService.INSTANCE.deleteConversationRawCall(new DeleteConversationRequest(this.$id), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                success = (HttpDataResult) obj;
                if (success instanceof HttpDataResult.Success) {
                    if (success instanceof HttpDataResult.Error) {
                        mutableSharedFlow = this.this$0._toastMessage;
                        this.label = 6;
                        if (mutableSharedFlow.emit(Boxing.boxInt(com.bytedance.trae.multilanguage.R.string.trae_conversation_toast_delete_failed), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (success.getBizResp().getCode() == ConversationViewModel.CODE_DEVICE_OFFLINE) {
                    mutableSharedFlow2 = this.this$0._toastMessage;
                    this.label = 2;
                    if (mutableSharedFlow2.emit(Boxing.boxInt(com.bytedance.trae.multilanguage.R.string.trae_conversation_device_offline), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    mutableStateFlow = this.this$0._conversationId;
                    String str = (String) mutableStateFlow.getValue();
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        this.label = 3;
                        if (BuildersKt.withContext(Dispatchers.getIO(), new C06271(this.this$0, str, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    mutableSharedFlow3 = this.this$0._toastMessage;
                    this.label = 4;
                    if (mutableSharedFlow3.emit(Boxing.boxInt(com.bytedance.trae.multilanguage.R.string.trae_conversation_toast_delete_success), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableSharedFlow4 = this.this$0._deleteSuccess;
                    this.label = 5;
                    if (mutableSharedFlow4.emit(Unit.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure(obj);
                success = (HttpDataResult) obj;
                if (success instanceof HttpDataResult.Success) {
                }
                return Unit.INSTANCE;
            case 2:
            case 5:
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure(obj);
                mutableSharedFlow3 = this.this$0._toastMessage;
                this.label = 4;
                if (mutableSharedFlow3.emit(Boxing.boxInt(com.bytedance.trae.multilanguage.R.string.trae_conversation_toast_delete_success), (Continuation) this) == coroutine_suspended) {
                }
                mutableSharedFlow4 = this.this$0._deleteSuccess;
                this.label = 5;
                if (mutableSharedFlow4.emit(Unit.INSTANCE, (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure(obj);
                mutableSharedFlow4 = this.this$0._deleteSuccess;
                this.label = 5;
                if (mutableSharedFlow4.emit(Unit.INSTANCE, (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$deleteConversation$1$1", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationViewModel$deleteConversation$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $convId;
        int label;
        final /* synthetic */ ConversationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06271(ConversationViewModel conversationViewModel, String str, Continuation<? super C06271> continuation) {
            super(2, continuation);
            this.this$0 = conversationViewModel;
            this.$convId = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06271(this.this$0, this.$convId, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            ConversationDetailCacheRepository cacheRepository;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                cacheRepository = this.this$0.getCacheRepository();
                cacheRepository.deleteByConversationId(this.$convId);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
