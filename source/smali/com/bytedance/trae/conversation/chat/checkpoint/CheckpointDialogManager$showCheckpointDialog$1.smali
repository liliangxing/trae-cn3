# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "CheckpointDialogManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cb:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $fragmentManager:Landroidx/fragment/app/FragmentManager;
.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $planItem:Lcom/bytedance/trae/im/model/ParsedPlanItem;
.field final synthetic $pluginName:Ljava/lang/String;
.field final synthetic $taskId:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  androidx.fragment.app.FragmentManager  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback  kotlin.coroutines.Continuation)void
    .registers 9
    # ins_size=9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$pluginName Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$fragmentManager Landroidx/fragment/app/FragmentManager;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$taskId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$conversationId Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$messageId Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$cb Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    const/4 v1, 2
    invoke-direct v0, v1, v8, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 12
    # ins_size=3
    new-instance v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$pluginName Ljava/lang/String;
    iget-object v2, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$fragmentManager Landroidx/fragment/app/FragmentManager;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$taskId Ljava/lang/String;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$conversationId Ljava/lang/String;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$messageId Ljava/lang/String;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$cb Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    move-object v0, v10
    move-object v8, v11
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;-><init>(Ljava/lang/String; Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/coroutines/Continuation;
    return-object v10
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +28h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v9
    check-cast v9, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1$resolved$1;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$pluginName Ljava/lang/String;
    const/4 v4, 0
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1$resolved$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v8
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->label I
    invoke-static v9, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    check-cast v9, Ljava/lang/String;
    move-object v0, v9
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00ah
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 0
    const-string v0, "CheckPointDialog"
    if-eqz v2, +018h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[DialogManager] fallback to raw name for plugin="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$pluginName Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$fragmentManager Landroidx/fragment/app/FragmentManager;
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v1
    if-eqz v1, +015h
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "[DialogManager] ABORT: fragment state already saved"
    invoke-virtual v9, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->access$getOnDismissAction$p()Lkotlin/jvm/functions/Function0;
    move-result-object v9
    if-eqz v9, +005h
    invoke-interface v9, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$fragmentManager Landroidx/fragment/app/FragmentManager;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$taskId Ljava/lang/String;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$conversationId Ljava/lang/String;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$messageId Ljava/lang/String;
    iget-object v6, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$cb Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    if-nez v9, +004h
    iget-object v9, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;->$pluginName Ljava/lang/String;
    move-object v7, v9
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->access$presentCheckpointDialog(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager; Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Ljava/lang/String;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
