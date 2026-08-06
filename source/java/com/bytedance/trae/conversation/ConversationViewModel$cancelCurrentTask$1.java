package com.bytedance.trae.conversation;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.CancelTaskMonitor;
import com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.MessageSourcePhase;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.service.CancelTaskRawResult;
import com.bytedance.trae.im.service.CancelTaskRequest;
import com.bytedance.trae.im.service.ICancelTaskApi;
import com.bytedance.trae.im.service.IMService;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$cancelCurrentTask$1", f = "ConversationViewModel.kt", i = {0, 7}, l = {3074, 3150, 3153, 3154, 3157, 3158, 3165, 3168, 3170}, m = "invokeSuspend", n = {"startTime", "result"}, s = {"J$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$cancelCurrentTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $convId;
    final /* synthetic */ String $taskId;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$cancelCurrentTask$1(String str, String str2, ConversationViewModel conversationViewModel, Continuation<? super ConversationViewModel$cancelCurrentTask$1> continuation) {
        super(2, continuation);
        this.$convId = str;
        this.$taskId = str2;
        this.this$0 = conversationViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$cancelCurrentTask$1(this.$convId, this.$taskId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[LOOP:2: B:87:0x0200->B:103:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[LOOP:3: B:126:0x00b0->B:141:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x017a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x03e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long currentTimeMillis;
        Object cancelTaskRawCall;
        HttpDataResult result;
        MutableSharedFlow mutableSharedFlow;
        HttpDataResult httpDataResult;
        MutableSharedFlow mutableSharedFlow2;
        MutableStateFlow mutableStateFlow;
        boolean z;
        boolean z2;
        MutableStateFlow mutableStateFlow2;
        boolean z3;
        boolean z4;
        MutableStateFlow mutableStateFlow3;
        Object obj2;
        MutableStateFlow mutableStateFlow4;
        Object obj3;
        MutableSharedFlow mutableSharedFlow3;
        IMService.StreamingMessageListener streamingMessageListener;
        MutableSharedFlow mutableSharedFlow4;
        MutableSharedFlow mutableSharedFlow5;
        MutableSharedFlow mutableSharedFlow6;
        String string;
        MutableSharedFlow mutableSharedFlow7;
        String string2;
        MutableSharedFlow mutableSharedFlow8;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                currentTimeMillis = System.currentTimeMillis();
                this.J$0 = currentTimeMillis;
                this.label = 1;
                cancelTaskRawCall = ICancelTaskApi.INSTANCE.cancelTaskRawCall(new CancelTaskRequest(this.$convId, this.$taskId), (Continuation) this);
                if (cancelTaskRawCall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                CancelTaskRawResult cancelTaskRawResult = (CancelTaskRawResult) cancelTaskRawCall;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                result = cancelTaskRawResult.getResult();
                Long bizCode = cancelTaskRawResult.getBizCode();
                cancelTaskRawResult.getBizMsg();
                if (!(result instanceof HttpDataResult.Success)) {
                    ParsedChatMessage streamingMessage = IMService.INSTANCE.getStreamingMessage(this.$taskId);
                    String messageId = streamingMessage != null ? streamingMessage.getMessageId() : null;
                    HttpDataResult.Success success = (HttpDataResult.Success) result;
                    if (!success.getBizResp().isSuccess()) {
                        try {
                            mutableStateFlow = this.this$0._messages;
                            Iterable<ParsedChatMessage> iterable = (Iterable) mutableStateFlow.getValue();
                            String str = this.$taskId;
                            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                                for (ParsedChatMessage parsedChatMessage : iterable) {
                                    if (parsedChatMessage.isAssistantMessage() && !StringsKt.startsWith$default(parsedChatMessage.getMessageId(), "placeholder_", false, 2, (Object) null)) {
                                        ParsedTaskContent taskContent = parsedChatMessage.getTaskContent();
                                        if (Intrinsics.areEqual(taskContent != null ? taskContent.getTaskId() : null, str)) {
                                            z = true;
                                            if (!z) {
                                            }
                                        }
                                    }
                                    z = false;
                                    if (!z) {
                                    }
                                }
                            }
                            CancelTaskMonitor cancelTaskMonitor = CancelTaskMonitor.INSTANCE;
                            String str2 = this.$taskId;
                            String str3 = this.$convId;
                            boolean isTaskRunning = this.this$0.getIsTaskRunning();
                            String str4 = messageId;
                            if (str4 != null && str4.length() != 0) {
                                z2 = false;
                                cancelTaskMonitor.report("biz_error", "user_click", str2, str3, messageId, currentTimeMillis2, bizCode, isTaskRunning, !z2 ? VoiceAttemptMetricsTracker.FINAL_SOURCE_EMPTY : "streaming");
                            }
                            z2 = true;
                            cancelTaskMonitor.report("biz_error", "user_click", str2, str3, messageId, currentTimeMillis2, bizCode, isTaskRunning, !z2 ? VoiceAttemptMetricsTracker.FINAL_SOURCE_EMPTY : "streaming");
                        } catch (Throwable unused) {
                        }
                    }
                    if (success.getBizResp().isSuccess() || (bizCode != null && bizCode.longValue() == 991201)) {
                        ParsedChatMessage streamingMessage2 = IMService.INSTANCE.getStreamingMessage(this.$taskId);
                        if (streamingMessage2 == null) {
                            mutableStateFlow2 = this.this$0._messages;
                            Iterable<ParsedChatMessage> iterable2 = (Iterable) mutableStateFlow2.getValue();
                            String str5 = this.$taskId;
                            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                                for (ParsedChatMessage parsedChatMessage2 : iterable2) {
                                    if (parsedChatMessage2.isAssistantMessage() && !StringsKt.startsWith$default(parsedChatMessage2.getMessageId(), "placeholder_", false, 2, (Object) null)) {
                                        ParsedTaskContent taskContent2 = parsedChatMessage2.getTaskContent();
                                        if (Intrinsics.areEqual(taskContent2 != null ? taskContent2.getTaskId() : null, str5)) {
                                            z3 = true;
                                            if (!z3) {
                                                z4 = true;
                                                if (!z4) {
                                                    String str6 = "placeholder_" + this.$taskId;
                                                    mutableStateFlow3 = this.this$0._messages;
                                                    Iterator it = ((Iterable) mutableStateFlow3.getValue()).iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            obj2 = it.next();
                                                            if (Intrinsics.areEqual(((ParsedChatMessage) obj2).getMessageId(), str6)) {
                                                            }
                                                        } else {
                                                            obj2 = null;
                                                        }
                                                    }
                                                    ParsedChatMessage parsedChatMessage3 = (ParsedChatMessage) obj2;
                                                    if (parsedChatMessage3 != null && !Intrinsics.areEqual(parsedChatMessage3.getStatus(), ConfirmInfo.STATUS_CANCELED)) {
                                                        parsedChatMessage3.setStatus(ConfirmInfo.STATUS_CANCELED);
                                                        parsedChatMessage3.setUserCanceled(Boxing.boxBoolean(true));
                                                        parsedChatMessage3.setHistory(true);
                                                        parsedChatMessage3.setSourcePhase(MessageSourcePhase.STREAM_DONE);
                                                        this.this$0.upsertMessages(CollectionsKt.listOf(parsedChatMessage3));
                                                    } else if (parsedChatMessage3 == null) {
                                                        mutableStateFlow4 = this.this$0._messages;
                                                        Iterable iterable3 = (Iterable) mutableStateFlow4.getValue();
                                                        String str7 = this.$taskId;
                                                        Iterator it2 = iterable3.iterator();
                                                        while (true) {
                                                            if (it2.hasNext()) {
                                                                obj3 = it2.next();
                                                                if (Intrinsics.areEqual(((ParsedChatMessage) obj3).getTaskIdUser(), str7)) {
                                                                }
                                                            } else {
                                                                obj3 = null;
                                                            }
                                                        }
                                                        ParsedChatMessage parsedChatMessage4 = (ParsedChatMessage) obj3;
                                                        if (parsedChatMessage4 != null) {
                                                            this.this$0.upsertMessages(CollectionsKt.listOf(new ParsedChatMessage(parsedChatMessage4.getSessionId(), str6, null, null, ConfirmInfo.STATUS_CANCELED, null, ParsedChatMessage.ROLE_ASSISTANT, 0, parsedChatMessage4.getMessageId(), null, null, null, null, null, null, null, null, null, null, null, null, null, System.currentTimeMillis(), null, null, null, null, null, null, null, null, null, null, null, Boxing.boxBoolean(true), null, null, new ParsedTaskContent(this.$taskId, null, CollectionsKt.emptyList(), 2, null), null, null, true, false, false, null, null, null, null, null, null, null, null, null, null, null, null, -4194644, 8388315, null)));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    z3 = false;
                                    if (!z3) {
                                    }
                                }
                            }
                            z4 = false;
                            if (!z4) {
                            }
                        } else {
                            streamingMessage2.setStatus(ConfirmInfo.STATUS_CANCELED);
                            streamingMessage2.setUserCanceled(Boxing.boxBoolean(true));
                            streamingMessage2.setHistory(true);
                            streamingMessageListener = this.this$0.streamingMessageListener;
                            streamingMessageListener.onStreamingMessage(streamingMessage2, true);
                        }
                        this.this$0._currentTaskId = null;
                        this.this$0.setTaskRunning(false);
                        mutableSharedFlow3 = this.this$0._cancelTaskResult;
                        this.label = 2;
                        if (mutableSharedFlow3.emit(Boxing.boxBoolean(true), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (bizCode != null && bizCode.longValue() == ConversationViewModel.CODE_DEVICE_OFFLINE) {
                        this.this$0._currentTaskId = this.$taskId;
                        mutableSharedFlow5 = this.this$0._cancelTaskResult;
                        this.label = 3;
                        if (mutableSharedFlow5.emit(Boxing.boxBoolean(false), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutableSharedFlow6 = this.this$0._toastText;
                        string = AppHost.INSTANCE.getApplication().getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_device_offline);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        this.label = 4;
                        if (mutableSharedFlow6.emit(string, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.this$0._currentTaskId = this.$taskId;
                        mutableSharedFlow4 = this.this$0._cancelTaskResult;
                        this.label = 5;
                        if (mutableSharedFlow4.emit(Boxing.boxBoolean(false), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutableSharedFlow7 = this.this$0._toastText;
                        string2 = AppHost.INSTANCE.getApplication().getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_network_retry);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        this.label = 6;
                        if (mutableSharedFlow7.emit(string2, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (!(result instanceof HttpDataResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (!StringsKt.contains(((HttpDataResult.Error) result).getMsg(), "not running", true)) {
                        this.this$0._currentTaskId = this.$taskId;
                        mutableSharedFlow = this.this$0._cancelTaskResult;
                        this.L$0 = result;
                        this.label = 8;
                        if (mutableSharedFlow.emit(Boxing.boxBoolean(false), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        httpDataResult = result;
                        if (((HttpDataResult.Error) httpDataResult).getMsg().length() > 0) {
                            mutableSharedFlow8 = this.this$0._toastText;
                            String string3 = AppHost.INSTANCE.getApplication().getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_network_retry);
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                            this.L$0 = null;
                            this.label = 9;
                            if (mutableSharedFlow8.emit(string3, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        this.this$0.setTaskRunning(false);
                        mutableSharedFlow2 = this.this$0._cancelTaskResult;
                        this.label = 7;
                        if (mutableSharedFlow2.emit(Boxing.boxBoolean(true), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                currentTimeMillis = this.J$0;
                ResultKt.throwOnFailure(obj);
                cancelTaskRawCall = obj;
                CancelTaskRawResult cancelTaskRawResult2 = (CancelTaskRawResult) cancelTaskRawCall;
                long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                result = cancelTaskRawResult2.getResult();
                Long bizCode2 = cancelTaskRawResult2.getBizCode();
                cancelTaskRawResult2.getBizMsg();
                if (!(result instanceof HttpDataResult.Success)) {
                }
                return Unit.INSTANCE;
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure(obj);
                mutableSharedFlow6 = this.this$0._toastText;
                string = AppHost.INSTANCE.getApplication().getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_device_offline);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.label = 4;
                if (mutableSharedFlow6.emit(string, (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure(obj);
                mutableSharedFlow7 = this.this$0._toastText;
                string2 = AppHost.INSTANCE.getApplication().getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_network_retry);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                this.label = 6;
                if (mutableSharedFlow7.emit(string2, (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 8:
                httpDataResult = (HttpDataResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (((HttpDataResult.Error) httpDataResult).getMsg().length() > 0) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
