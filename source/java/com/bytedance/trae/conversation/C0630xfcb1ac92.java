package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.Mode;
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
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1", f = "ConversationViewModel.kt", i = {}, l = {2670}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0630xfcb1ac92 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $code;
    final /* synthetic */ SelectedDeviceItem $device;
    final /* synthetic */ ParsedChatMessage $message;
    final /* synthetic */ Mode $mode;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0630xfcb1ac92(ConversationViewModel conversationViewModel, SelectedDeviceItem selectedDeviceItem, Mode mode, long j, String str, ParsedChatMessage parsedChatMessage, Continuation<? super C0630xfcb1ac92> continuation) {
        super(2, continuation);
        this.this$0 = conversationViewModel;
        this.$device = selectedDeviceItem;
        this.$mode = mode;
        this.$code = j;
        this.$source = str;
        this.$message = parsedChatMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0630xfcb1ac92(this.this$0, this.$device, this.$mode, this.$code, this.$source, this.$message, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object switchSelectedModelToAuto;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            switchSelectedModelToAuto = this.this$0.switchSelectedModelToAuto(this.$device, this.$mode, "message_error_code_" + this.$code + "_source_" + this.$source + "_history_" + this.$message.isHistory(), (Continuation) this);
            if (switchSelectedModelToAuto == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
