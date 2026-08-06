package com.bytedance.trae.conversation.chat.checkpoint;

import androidx.fragment.app.FragmentManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CheckpointDialogManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialogManager$showCheckpointDialog$1", f = "CheckpointDialogManager.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CheckpointDialogManager$showCheckpointDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CheckpointInteractionCallback $cb;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ FragmentManager $fragmentManager;
    final /* synthetic */ String $messageId;
    final /* synthetic */ ParsedPlanItem $planItem;
    final /* synthetic */ String $pluginName;
    final /* synthetic */ String $taskId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckpointDialogManager$showCheckpointDialog$1(String str, FragmentManager fragmentManager, ParsedPlanItem parsedPlanItem, String str2, String str3, String str4, CheckpointInteractionCallback checkpointInteractionCallback, Continuation<? super CheckpointDialogManager$showCheckpointDialog$1> continuation) {
        super(2, continuation);
        this.$pluginName = str;
        this.$fragmentManager = fragmentManager;
        this.$planItem = parsedPlanItem;
        this.$taskId = str2;
        this.$conversationId = str3;
        this.$messageId = str4;
        this.$cb = checkpointInteractionCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckpointDialogManager$showCheckpointDialog$1(this.$pluginName, this.$fragmentManager, this.$planItem, this.$taskId, this.$conversationId, this.$messageId, this.$cb, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Function0 function0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new CheckpointDialogManager$showCheckpointDialog$1$resolved$1(this.$pluginName, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String str = (String) obj;
        String str2 = str;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            z = false;
        }
        if (z) {
            FLogger.INSTANCE.w("CheckPointDialog", "[DialogManager] fallback to raw name for plugin=" + this.$pluginName);
        }
        if (this.$fragmentManager.isStateSaved()) {
            FLogger.INSTANCE.w("CheckPointDialog", "[DialogManager] ABORT: fragment state already saved");
            function0 = CheckpointDialogManager.onDismissAction;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
        CheckpointDialogManager checkpointDialogManager = CheckpointDialogManager.INSTANCE;
        FragmentManager fragmentManager = this.$fragmentManager;
        ParsedPlanItem parsedPlanItem = this.$planItem;
        String str3 = this.$taskId;
        String str4 = this.$conversationId;
        String str5 = this.$messageId;
        CheckpointInteractionCallback checkpointInteractionCallback = this.$cb;
        if (str == null) {
            str = this.$pluginName;
        }
        checkpointDialogManager.presentCheckpointDialog(fragmentManager, parsedPlanItem, str3, str4, str5, checkpointInteractionCallback, str);
        return Unit.INSTANCE;
    }
}
