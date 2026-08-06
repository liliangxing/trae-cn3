package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.IPinConversationService;
import com.bytedance.trae.im.service.PinConversationRequest;
import com.bytedance.trae.im.service.PinConversationResponse;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$performPinAction$1", f = "ConversationViewModel.kt", i = {}, l = {1940, 1942, 1950, 1953, 1956, 1959, 1969}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$performPinAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ boolean $shouldPin;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$performPinAction$1(boolean z, String str, ConversationViewModel conversationViewModel, Continuation<? super ConversationViewModel$performPinAction$1> continuation) {
        super(2, continuation);
        this.$shouldPin = z;
        this.$id = str;
        this.this$0 = conversationViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$performPinAction$1(this.$shouldPin, this.$id, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HttpDataResult httpDataResult;
        MutableSharedFlow mutableSharedFlow;
        int pinFailureString;
        MutableSharedFlow mutableSharedFlow2;
        int pinFailureString2;
        MutableSharedFlow mutableSharedFlow3;
        MutableSharedFlow mutableSharedFlow4;
        MutableSharedFlow mutableSharedFlow5;
        int pinSuccessString;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (this.$shouldPin) {
                    this.label = 1;
                    obj = IPinConversationService.INSTANCE.pinRawCall(new PinConversationRequest(this.$id), (Continuation) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    httpDataResult = (HttpDataResult) obj;
                    if (!(httpDataResult instanceof HttpDataResult.Success)) {
                        BizResponse bizResp = ((HttpDataResult.Success) httpDataResult).getBizResp();
                        if (bizResp.isSuccess()) {
                            this.this$0.applyPinSuccess(this.$id, this.$shouldPin, (PinConversationResponse) bizResp.getData());
                            mutableSharedFlow5 = this.this$0._toastMessage;
                            pinSuccessString = this.this$0.pinSuccessString(this.$shouldPin);
                            this.label = 3;
                            if (mutableSharedFlow5.emit(Boxing.boxInt(pinSuccessString), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (bizResp.getCode() == 2900104) {
                            mutableSharedFlow4 = this.this$0._toastMessage;
                            this.label = 4;
                            if (mutableSharedFlow4.emit(Boxing.boxInt(com.bytedance.trae.multilanguage.R.string.trae_conversation_toast_pin_version_incompatible), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (bizResp.getCode() == ConversationViewModel.CODE_DEVICE_OFFLINE) {
                            mutableSharedFlow3 = this.this$0._toastMessage;
                            this.label = 5;
                            if (mutableSharedFlow3.emit(Boxing.boxInt(com.bytedance.trae.multilanguage.R.string.trae_conversation_device_offline), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            mutableSharedFlow2 = this.this$0._toastMessage;
                            pinFailureString2 = this.this$0.pinFailureString(this.$shouldPin);
                            this.label = 6;
                            if (mutableSharedFlow2.emit(Boxing.boxInt(pinFailureString2), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (!(httpDataResult instanceof HttpDataResult.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        HttpDataResult.Error error = (HttpDataResult.Error) httpDataResult;
                        TraeLogUtil.INSTANCE.e("ConversationViewModel", "performPinAction error: conversationId=" + this.$id + ", shouldPin=" + this.$shouldPin + ", code=" + error.getCode() + ", msg=" + error.getMsg(), error.getThrowable());
                        mutableSharedFlow = this.this$0._toastMessage;
                        pinFailureString = this.this$0.pinFailureString(this.$shouldPin);
                        this.label = 7;
                        if (mutableSharedFlow.emit(Boxing.boxInt(pinFailureString), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                this.label = 2;
                obj = IPinConversationService.INSTANCE.unpinRawCall(new PinConversationRequest(this.$id), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpDataResult = (HttpDataResult) obj;
                if (!(httpDataResult instanceof HttpDataResult.Success)) {
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure(obj);
                httpDataResult = (HttpDataResult) obj;
                if (!(httpDataResult instanceof HttpDataResult.Success)) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure(obj);
                httpDataResult = (HttpDataResult) obj;
                if (!(httpDataResult instanceof HttpDataResult.Success)) {
                }
                return Unit.INSTANCE;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
