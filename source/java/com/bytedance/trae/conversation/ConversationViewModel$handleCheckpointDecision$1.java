package com.bytedance.trae.conversation;

import android.util.Log;
import com.bytedance.trae.conversation.chat.checkpoint.AnswerEntry;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ICancelTaskApi;
import com.bytedance.trae.im.service.IConfirmTaskApi;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$handleCheckpointDecision$1", f = "ConversationViewModel.kt", i = {2}, l = {3230, 3242, 3298}, m = "invokeSuspend", n = {"decisionStr"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$handleCheckpointDecision$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CheckpointDecision $decision;
    Object L$0;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$handleCheckpointDecision$1(CheckpointDecision checkpointDecision, ConversationViewModel conversationViewModel, Continuation<? super ConversationViewModel$handleCheckpointDecision$1> continuation) {
        super(2, continuation);
        this.$decision = checkpointDecision;
        this.this$0 = conversationViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$handleCheckpointDecision$1(this.$decision, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        HttpDataResult.Error error;
        MutableSharedFlow mutableSharedFlow;
        HttpDataResult.Error error2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CheckpointDecision checkpointDecision = this.$decision;
            if (checkpointDecision instanceof CheckpointDecision.Cancel) {
                String conversationId = ((CheckpointDecision.Cancel) checkpointDecision).getConversationId();
                String str4 = conversationId;
                if (str4 == null || str4.length() == 0) {
                    Log.e("Checkpoint", "CancelTask ABORT: conversationId is null/empty");
                    return Unit.INSTANCE;
                }
                this.label = 1;
                obj = ICancelTaskApi.INSTANCE.safeCall(new ConversationViewModel$handleCheckpointDecision$1$result$1(conversationId, this.$decision, null), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                error = (HttpDataResult) obj;
                if (!(error instanceof HttpDataResult.Success)) {
                }
            } else {
                if (!(checkpointDecision instanceof CheckpointDecision.Confirm) && !(checkpointDecision instanceof CheckpointDecision.Skip) && !(checkpointDecision instanceof CheckpointDecision.SubmitAnswer)) {
                    throw new NoWhenBranchMatchedException();
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                CheckpointDecision checkpointDecision2 = this.$decision;
                if (checkpointDecision2 instanceof CheckpointDecision.Confirm) {
                    objectRef.element = ((CheckpointDecision.Confirm) checkpointDecision2).getParams();
                } else if (!(checkpointDecision2 instanceof CheckpointDecision.Skip)) {
                    if (checkpointDecision2 instanceof CheckpointDecision.SubmitAnswer) {
                        List<AnswerEntry> answers = ((CheckpointDecision.SubmitAnswer) checkpointDecision2).getAnswers();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(answers, 10));
                        for (AnswerEntry answerEntry : answers) {
                            Map linkedHashMap = new LinkedHashMap();
                            if (!answerEntry.getSelectedOptions().isEmpty()) {
                                linkedHashMap.put("selected_options", answerEntry.getSelectedOptions());
                            }
                            String customInput = answerEntry.getCustomInput();
                            if (!(customInput == null || StringsKt.isBlank(customInput))) {
                                linkedHashMap.put("custom_input", answerEntry.getCustomInput());
                            }
                            if (linkedHashMap.isEmpty()) {
                                linkedHashMap = MapsKt.emptyMap();
                            }
                            arrayList.add(linkedHashMap);
                        }
                        Map mutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("questions", (JsonElement) this.this$0.getGson().fromJson(((CheckpointDecision.SubmitAnswer) this.$decision).getQuestionsJson(), JsonElement.class)), TuplesKt.to("answers", arrayList)});
                        String supplementaryInfo = ((CheckpointDecision.SubmitAnswer) this.$decision).getSupplementaryInfo();
                        if (!(supplementaryInfo == null || StringsKt.isBlank(supplementaryInfo))) {
                            mutableMapOf.put("custom_input", ((CheckpointDecision.SubmitAnswer) this.$decision).getSupplementaryInfo());
                        }
                        objectRef.element = this.this$0.getGson().toJson(mutableMapOf);
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    str = "skip";
                    String conversationId2 = this.$decision.getConversationId();
                    str2 = conversationId2;
                    if (str2 != null && str2.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        Log.e("Checkpoint", "ConfirmTask ABORT: conversationId is null/empty");
                        return Unit.INSTANCE;
                    }
                    this.L$0 = str;
                    this.label = 3;
                    Object safeCall = IConfirmTaskApi.INSTANCE.safeCall(new ConversationViewModel$handleCheckpointDecision$1$result$2(conversationId2, this.$decision, str, objectRef, null), (Continuation) this);
                    if (safeCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str3 = str;
                    obj = safeCall;
                    error2 = (HttpDataResult) obj;
                    if (!(error2 instanceof HttpDataResult.Success)) {
                    }
                }
                str = "confirm";
                String conversationId22 = this.$decision.getConversationId();
                str2 = conversationId22;
                if (str2 != null) {
                    z = false;
                }
                if (!z) {
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            error = (HttpDataResult) obj;
            if (!(error instanceof HttpDataResult.Success)) {
                if (!(error instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                HttpDataResult.Error error3 = error;
                Log.e("Checkpoint", "CancelTask error: " + error3.getMsg());
                mutableSharedFlow = this.this$0._toastText;
                this.label = 2;
                if (mutableSharedFlow.emit(error3.getMsg(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str3 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            error2 = (HttpDataResult) obj;
            if (!(error2 instanceof HttpDataResult.Success)) {
                if (!(error2 instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                HttpDataResult.Error error4 = error2;
                FLogger.INSTANCE.e("ConversationViewModel", "ConfirmTask error: " + error4.getMsg());
                this.this$0.reportCheckpointConfirmTaskError(this.$decision, str3, error4);
            }
        }
        return Unit.INSTANCE;
    }
}
