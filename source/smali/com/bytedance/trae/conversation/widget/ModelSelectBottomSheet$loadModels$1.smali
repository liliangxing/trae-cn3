# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ModelSelectBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cachedModels:Ljava/util/List;
.field final synthetic $functions:Ljava/util/List;
.field final synthetic $hasCachedModels:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet  java.util.List  boolean  java.util.List  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->$functions Ljava/util/List;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->$hasCachedModels Z
    iput-object v4, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->$cachedModels Ljava/util/List;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->$functions Ljava/util/List;
    iget-boolean v3, v6, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->$hasCachedModels Z
    iget-object v4, v6, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->$cachedModels Ljava/util/List;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;-><init>(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet; Ljava/util/List; Z Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->label I
    const-string v2, "ModelSelectBottomSheet"
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v1, +01bh
    if-eq v1, v4, +010h
    if-ne v1, v3, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3ch
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +58h
    move-exception v14
    goto +59h
    move-exception v14
    goto/16 +0cah
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-static v14, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->access$getCliType$p(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;)Lcom/bytedance/trae/im/service/CliType;
    move-result-object v14
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-eq v14, v1, +022h
    iget-object v14, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-static v14, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->access$getCliType$p(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;)Lcom/bytedance/trae/im/service/CliType;
    move-result-object v14
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v14, v1, +003h
    goto +16h
    sget-object v14, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;->Companion Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->$functions Ljava/util/List;
    const-string v5, "model_select_dialog"
    move-object v6, v13
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v3, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->label I
    invoke-virtual v14, v1, v5, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->fetchModelsForUi(Ljava/util/List; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    check-cast v14, Ljava/util/List;
    goto +5ch
    sget-object v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;->Companion Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    iget-object v14, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-static v14, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->access$getCliId$p(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;)Ljava/lang/String;
    move-result-object v6
    iget-object v14, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-static v14, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->access$getIdeVersion$p(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;)Ljava/lang/String;
    move-result-object v9
    iget-object v14, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-static v14, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->access$getCliType$p(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;)Lcom/bytedance/trae/im/service/CliType;
    move-result-object v11
    iget-object v7, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->$functions Ljava/util/List;
    const/4 v8, 0
    const-string v10, "model_select_dialog"
    move-object v12, v13
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput v4, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->label I
    invoke-virtual/range v5 ... v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->fetchPcModelsForUi(Ljava/lang/String; Ljava/util/List; Z Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    check-cast v14, Ljava/util/List;
    goto +34h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "loadModels failed"
    invoke-virtual v0, v2, v1, v14, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-boolean v14, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->$hasCachedModels Z
    if-nez v14, +01ch
    iget-object v14, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->isAdded()Z
    move-result v14
    if-eqz v14, +014h
    iget-object v14, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v14
    if-eqz v14, +00ch
    sget v0, Lcom/bytedance/trae/conversation/R$string;->imkit_model_list_load_failed I
    const/4 v1, 0
    invoke-static v14, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v14
    invoke-virtual v14, Landroid/widget/Toast;->show()V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->$cachedModels Ljava/util/List;
    if-nez v14, +00ch
    sget-object v14, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v14
    invoke-static v14, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v14
    iget-object v0, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v0
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->isAdded()Z
    move-result v1
    if-eqz v1, +02ah
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getView()Landroid/view/View;
    move-result-object v1
    if-eqz v1, +022h
    if-nez v0, +003h
    goto +1eh
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;)Landroid/widget/ProgressBar;
    move-result-object v1
    if-nez v1, +008h
    const-string v1, "progressBar"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    const/16 v2, 8
    invoke-virtual v1, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;->this$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    const-string v2, "network"
    invoke-static v1, v14, v2, v4, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->access$updateModelList(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet; Ljava/util/List; Ljava/lang/String; Z Landroid/content/Context;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    sget-object v14, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v0, "loadModels: skip result, fragment detached"
    invoke-virtual v14, v2, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    throw v14
    :try_start_0x10
    :try_start_0x1c
    :try_start_0x28
.end method
