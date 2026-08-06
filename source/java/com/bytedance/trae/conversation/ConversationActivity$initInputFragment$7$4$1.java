package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.widget.InputFragment;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$initInputFragment$7$4$1", f = "ConversationActivity.kt", i = {}, l = {1721}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$initInputFragment$7$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<SelectedDeviceItem, Unit> $onResult;
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConversationActivity$initInputFragment$7$4$1(ConversationActivity conversationActivity, Function1<? super SelectedDeviceItem, Unit> function1, Continuation<? super ConversationActivity$initInputFragment$7$4$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
        this.$onResult = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$initInputFragment$7$4$1(this.this$0, this.$onResult, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConversationViewModel conversationViewModel;
        ConversationViewModel conversationViewModel2;
        Map map;
        InputFragment inputFragment;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            conversationViewModel = this.this$0.viewModel;
            ConversationViewModel conversationViewModel3 = null;
            if (conversationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel = null;
            }
            String str = (String) conversationViewModel.getConversationId().getValue();
            String str2 = str;
            if (!(str2 == null || StringsKt.isBlank(str2))) {
                conversationViewModel2 = this.this$0.viewModel;
                if (conversationViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    conversationViewModel3 = conversationViewModel2;
                }
                this.label = 1;
                obj = conversationViewModel3.checkIdeProjectForSkills(str, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.$onResult.invoke((Object) null);
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) obj;
        if (selectedDeviceItem != null) {
            map = this.this$0.selectedDeviceByMode;
            inputFragment = this.this$0.getInputFragment();
            map.put(inputFragment.getCurrentMode(), selectedDeviceItem);
        }
        this.$onResult.invoke(selectedDeviceItem);
        return Unit.INSTANCE;
    }
}
