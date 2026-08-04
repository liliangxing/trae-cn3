# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $agentType:Ljava/lang/String;
.field final synthetic $cliConversationId:Ljava/lang/String;
.field final synthetic $device:Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
.field final synthetic $local_common_params_str:Ljava/lang/String;
.field final synthetic $mode:Lcom/bytedance/trae/im/service/Mode;
.field final synthetic $query:Ljava/lang/String;
.field final synthetic $selectedModel:Lcom/bytedance/trae/conversation/network/RemoteModelItem;
.field final synthetic $selectedModelName:Ljava/lang/String;
.field final synthetic $targetConversationId:Ljava/lang/String;
.field final synthetic $text:Ljava/lang/String;
.field final synthetic $useFastRequest:Z
.field final synthetic $workspaceFields:Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
.field  J$0:J
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  L$4:Ljava/lang/Object;
.field  L$5:Ljava/lang/Object;
.field  L$6:Ljava/lang/Object;
.field  L$7:Ljava/lang/Object;
.field  Z$0:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method public static synthetic $r8$lambda$eWBJETU0Q9dYMlULYaB1OvlqVwE(com.bytedance.trae.conversation.ConversationViewModel)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->invokeSuspend$lambda$7(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode  com.bytedance.trae.conversation.network.RemoteModelItem  java.lang.String  boolean  com.bytedance.trae.conversation.CreateTaskWorkspaceFields  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 15
    # ins_size=15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$text Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$query Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$targetConversationId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$mode Lcom/bytedance/trae/im/service/Mode;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModelName Ljava/lang/String;
    iput-boolean v9, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$useFastRequest Z
    iput-object v10, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$workspaceFields Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$local_common_params_str Ljava/lang/String;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$agentType Ljava/lang/String;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$cliConversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v14, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$7(com.bytedance.trae.conversation.ConversationViewModel)kotlin.Unit
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getPendingSummaryIsSuccess$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v0
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$submitSummaryPerfReport(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    new-instance v16, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$text Ljava/lang/String;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$query Ljava/lang/String;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$targetConversationId Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$mode Lcom/bytedance/trae/im/service/Mode;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModelName Ljava/lang/String;
    iget-boolean v10, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$useFastRequest Z
    iget-object v11, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$workspaceFields Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    iget-object v12, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$local_common_params_str Ljava/lang/String;
    iget-object v13, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$agentType Ljava/lang/String;
    iget-object v14, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$cliConversationId Ljava/lang/String;
    move-object/from16 v1, v16
    move-object/from16 v15, v19
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v16, Lkotlin/coroutines/Continuation;
    return-object v16
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 100
    # ins_size=2
    move-object/from16 v1, v98
    const-string v2, "pending_"
    const-string/jumbo v3, sendMessageIternal: content security pre filter error, rule=
    const-string/jumbo v4, sendMessageIternal: content security pre filter blocked, rule=
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    iget v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    const-string v9, "getString(...)"
    const-string v10, "ConversationViewModel"
    const-string v11, ""
    const/4 v12, 1
    packed-switch v6, +00015abh
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v3, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v2, v3, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +155ah
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +153fh
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +14bfh
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +12c1h
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +129dh
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->J$0 J
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/im/service/ConversationInfo;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v13, v10
    goto/16 +10eah
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/im/service/ConversationInfo;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v13, v10
    goto/16 +f41h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v4
    goto/16 +dc8h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +d95h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v4
    goto/16 +d07h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +cd4h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v21, v4
    move-object/from16 v18, v5
    move v9, v12
    goto/16 +12dbh
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v9, v12
    goto/16 +12a5h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v9, v12
    goto/16 +1273h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v4
    goto/16 +bb6h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +b83h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v4
    goto/16 +ab3h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +a80h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v4
    goto/16 +9adh
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +97ah
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v4
    goto/16 +8eah
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +8b7h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v4
    goto/16 +12c8h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +1295h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v4
    goto/16 +7c8h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +795h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v4
    goto/16 +64eh
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    check-cast v15, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    check-cast v13, Ljava/lang/String;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v8, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v14, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move-object v9, v14
    move-object v10, v6
    move-object v6, v7
    move-object v14, v8
    move-object v8, v13
    move-object v7, v4
    move-object v4, v3
    move-object/from16 v3, v99
    goto/16 +5dbh
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v4
    goto/16 +555h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v13, Ljava/lang/String;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v14, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v15, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move-object v9, v15
    move-object v15, v7
    move-object v7, v4
    move-object v4, v3
    move-object/from16 v3, v99
    goto/16 +4e6h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v6, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v3
    move-object v13, v4
    move-object v14, v6
    move-object v15, v7
    move-object/from16 v4, v99
    goto/16 +443h
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0ech
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    check-cast v6, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v8, v99
    goto +53h
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1dh
    move-exception v0
    move-object v2, v0
    goto/16 +12f6h
    invoke-static/range v99, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v17, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    const-wide/16 v18, 0
    move-object/from16 v20, v1
    check-cast v20, Lkotlin/coroutines/Continuation;
    const/16 v21, 1
    const/16 v22, 0
    iput v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-static/range v17 ... v22, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->awaitReady$default(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v5, +003h
    return-object v5
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$text Ljava/lang/String;
    new-instance v6, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v6, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$query Ljava/lang/String;
    iput-object v8, v6, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    sget-object v8, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    const-string v13, "content_security_pre_filter"
    invoke-virtual v8, v13, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->triggerRefreshIfNeeded(Ljava/lang/String;)Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v8
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v13
    check-cast v13, Lkotlin/coroutines/CoroutineContext;
    new-instance v14, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;
    const/4 v15, 0
    invoke-direct v14, v6, v8, v15, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$processResult$1;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse; Lkotlin/coroutines/Continuation;)V
    check-cast v14, Lkotlin/jvm/functions/Function2;
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    const/4 v15, 2
    iput v15, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-static v13, v14, v8, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v5, +003h
    return-object v5
    check-cast v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;
    sget-object v13, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;
    invoke-static v8, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-nez v13, +0f2h
    instance-of v13, v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Desensitized;
    if-eqz v13, +015h
    move-object v3, v8
    check-cast v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Desensitized;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Desensitized;->getText()Ljava/lang/String;
    move-result-object v7
    check-cast v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Desensitized;
    invoke-virtual v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Desensitized;->getQuery()Ljava/lang/String;
    move-result-object v3
    iput-object v3, v6, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    const-string v3, "content_filter_input_desensitized"
    goto/16 +0dch
    instance-of v13, v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;
    const-string v14, ", detail="
    if-eqz v13, +086h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v4, v8
    check-cast v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->getDetail()Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;->getRuleName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object v4, v8
    check-cast v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->getDetail()Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;->getRuleDetailName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v10, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_contentSecurityToastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    check-cast v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;
    invoke-virtual v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->getDetail()Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;->getRuleName()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$contentSecurityBlockedText(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    const/4 v6, 0
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    const/4 v6, 3
    iput v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v5, +003h
    return-object v5
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, +00dh
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v5, 0
    invoke-static v3, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setBufferedAgentMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$flushPendingUpgradeReminderIfAllowed(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    return-object v2
    instance-of v4, v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;
    if-eqz v4, +047h
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v13, Ljava/lang/StringBuilder;
    invoke-direct v13, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v3, v8
    check-cast v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;->getDetail()Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;->getRuleName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v13, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object v13, v8
    check-cast v13, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;
    invoke-virtual v13, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;->getDetail()Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;->getRuleDetailName()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v3, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v13, ", message="
    invoke-virtual v3, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    check-cast v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;
    invoke-virtual v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;->getDetail()Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v10, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +7h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    const/4 v3, 0
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$targetConversationId Ljava/lang/String;
    if-eqz v4, +010h
    move-object v8, v4
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/2addr v8, v12
    if-eqz v8, +003h
    goto +2h
    const/4 v4, 0
    if-nez v4, +00eh
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversationId$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v8
    sget-object v13, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v8, v13, +050h
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$mode Lcom/bytedance/trae/im/service/Mode;
    sget-object v13, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v8, v13, +04ah
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedRepoUrl()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +3h
    const/4 v8, 0
    goto +2h
    move v8, v12
    if-nez v8, +034h
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedBranchName()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +3h
    const/4 v8, 0
    goto +2h
    move v8, v12
    if-nez v8, +01eh
    new-instance v8, Lcom/bytedance/trae/im/service/Source;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedRepoUrl()Ljava/lang/String;
    move-result-object v13
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedRepoName()Ljava/lang/String;
    move-result-object v14
    iget-object v15, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedBranchName()Ljava/lang/String;
    move-result-object v15
    const-string v12, "github"
    invoke-direct v8, v13, v14, v15, v12, Lcom/bytedance/trae/im/service/Source;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    move-object/from16 v30, v8
    goto +3h
    const/16 v30, 0
    sget-object v8, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    const/4 v12, 1
    invoke-virtual v8, v12, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->add(I)V
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->nanoTime()J
    move-result-wide v12
    invoke-virtual v8, v12, v13, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    new-instance v8, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$type$1;
    invoke-direct v8, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$type$1;-><init>()V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$type$1;->getType()Ljava/lang/reflect/Type;
    move-result-object v8
    new-instance v12, Lcom/google/gson/Gson;
    invoke-direct v12, Lcom/google/gson/Gson;-><init>()V
    iget-object v13, v6, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v13, Ljava/lang/String;
    invoke-virtual v12, v13, v8, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v8
    const-string v12, "fromJson(...)"
    invoke-static v8, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Ljava/util/List;
    move-object v12, v8
    check-cast v12, Ljava/lang/Iterable;
    instance-of v13, v12, Ljava/util/Collection;
    if-eqz v13, +00dh
    move-object v13, v12
    check-cast v13, Ljava/util/Collection;
    invoke-interface v13, Ljava/util/Collection;->isEmpty()Z
    move-result v13
    if-eqz v13, +004h
    const/4 v12, 0
    goto +1fh
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, -00ah
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v13, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v13
    const-string/jumbo v14, text
    invoke-static v13, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, -017h
    const/4 v12, 1
    check-cast v8, Ljava/lang/Iterable;
    instance-of v13, v8, Ljava/util/Collection;
    if-eqz v13, +00dh
    move-object v13, v8
    check-cast v13, Ljava/util/Collection;
    invoke-interface v13, Ljava/util/Collection;->isEmpty()Z
    move-result v13
    if-eqz v13, +004h
    const/4 v13, 0
    goto +26h
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    const/4 v13, 0
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v14
    if-eqz v14, +01ch
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v14, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v14
    const-string v15, "image"
    invoke-static v14, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, -016h
    add-int/lit8 v13, v13, 1
    if-gez v13, -01ah
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -1fh
    move/from16 v22, v13
    goto +4h
    const/4 v12, 1
    const/16 v22, 0
    sget-object v17, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    if-nez v4, +005h
    move-object/from16 v19, v11
    goto +3h
    move-object/from16 v19, v4
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    if-eqz v8, +008h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +009h
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModelName Ljava/lang/String;
    if-nez v8, +005h
    move-object/from16 v20, v11
    goto +3h
    move-object/from16 v20, v8
    if-eqz v12, +005h
    const/16 v21, 1
    goto +3h
    const/16 v21, 0
    move-object/from16 v18, v2
    invoke-virtual/range v17 ... v22, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->onSendMessage(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I)V
    sget-object v8, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v8
    sget-object v12, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    iget-boolean v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$useFastRequest Z
    if-nez v8, +00ch
    sget-object v14, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->isAutoUseExpress()Z
    move-result v14
    if-eqz v14, +004h
    const/4 v14, 1
    goto +2h
    const/4 v14, 0
    if-eqz v8, +004h
    const/4 v8, 1
    goto +2h
    const/4 v8, 0
    invoke-virtual v12, v13, v14, v8, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->resolveUseFastRequest(Z Z Z)Z
    move-result v8
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v12, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$saveSelectedRepo(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v12
    sget-object v13, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v12, v13, +004h
    const/4 v12, 1
    goto +2h
    const/4 v12, 0
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-interface v13, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +004h
    const/4 v14, 1
    goto +2h
    const/4 v14, 0
    if-eqz v14, +003h
    const/4 v13, 0
    move-object/from16 v22, v13
    check-cast v22, Ljava/lang/String;
    if-eqz v12, +005h
    sget-object v13, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    goto +7h
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v13
    move-object/from16 v23, v13
    if-eqz v12, +005h
    move-object/from16 v24, v11
    goto +9h
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$mode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v13, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v13
    move-object/from16 v24, v13
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$workspaceFields Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->getWorkspaceDir()Ljava/lang/String;
    move-result-object v26
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v37
    iget-object v13, v6, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    move-object/from16 v41, v13
    check-cast v41, Ljava/lang/String;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    if-eqz v13, +008h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v13
    if-nez v13, +004h
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModelName Ljava/lang/String;
    move-object/from16 v39, v13
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    if-nez v13, +005h
    sget-object v13, Lcom/bytedance/trae/im/service/ModelSelectionStrategy;->AUTO Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    goto +3h
    sget-object v13, Lcom/bytedance/trae/im/service/ModelSelectionStrategy;->MANUAL Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    move-object/from16 v42, v13
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    if-eqz v13, +00bh
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v14, v13, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$toCreateTaskCustomModel(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)Lcom/google/gson/JsonObject;
    move-result-object v13
    move-object/from16 v43, v13
    goto +3h
    const/16 v43, 0
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$local_common_params_str Ljava/lang/String;
    check-cast v13, Ljava/lang/CharSequence;
    invoke-interface v13, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +004h
    const/4 v14, 1
    goto +2h
    const/4 v14, 0
    if-eqz v14, +003h
    const/4 v13, 0
    move-object/from16 v44, v13
    check-cast v44, Ljava/lang/String;
    new-instance v29, Lcom/bytedance/trae/im/service/InitialMessage;
    const/16 v38, 0
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$agentType Ljava/lang/String;
    if-eqz v8, +004h
    const/4 v14, 1
    goto +2h
    const/4 v14, 0
    invoke-static v14, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v45
    const/16 v46, 2
    const/16 v47, 0
    move-object/from16 v36, v29
    move-object/from16 v40, v13
    invoke-direct/range v36 ... v47, Lcom/bytedance/trae/im/service/InitialMessage;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ModelSelectionStrategy; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    if-eqz v12, +00bh
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$workspaceFields Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->getProjectId()Ljava/lang/String;
    move-result-object v12
    move-object/from16 v25, v12
    goto +3h
    const/16 v25, 0
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$workspaceFields Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->getWorkspaceFolders()Ljava/util/List;
    move-result-object v27
    new-instance v12, Lcom/bytedance/trae/im/service/CreateTaskRequest;
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v28, 0
    const-string v31, "mobile"
    const/16 v32, 0
    const/16 v33, 0
    const v34, 50190
    const/16 v35, 0
    move-object/from16 v17, v12
    move-object/from16 v18, v4
    invoke-direct/range v17 ... v35, Lcom/bytedance/trae/im/service/CreateTaskRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Z Lcom/bytedance/trae/im/service/InitialMessage; Lcom/bytedance/trae/im/service/Source; Ljava/lang/String; Ljava/util/Map; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v14, 1
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$agentType Ljava/lang/String;
    const-string/jumbo v14, voice_summary
    invoke-static v13, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, +06eh
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v14
    invoke-static v13, v14, v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummaryStartTimestamp$p(Lcom/bytedance/trae/conversation/ConversationViewModel; J)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$cliConversationId Ljava/lang/String;
    if-nez v14, +003h
    move-object v14, v11
    invoke-static v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummarySessionId$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String;)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v14
    invoke-static v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummaryCliType$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/service/CliType;)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$mode Lcom/bytedance/trae/im/service/Mode;
    invoke-static v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummaryMode$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/service/Mode;)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-object v14, v4
    check-cast v14, Ljava/lang/CharSequence;
    if-eqz v14, +00bh
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +003h
    goto +3h
    const/4 v14, 0
    goto +2h
    const/4 v14, 1
    invoke-static v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummaryIsNewSession$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-wide/16 v14, 0
    invoke-static v13, v14, v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummaryDataFirstCharTimestamp$p(Lcom/bytedance/trae/conversation/ConversationViewModel; J)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v14, 0
    invoke-static v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummaryCharCount$p(Lcom/bytedance/trae/conversation/ConversationViewModel; I)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummaryReportSubmitted$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setPendingSummaryIsSuccess$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v13, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getSummaryReportTimeoutJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/Job;
    move-result-object v13
    if-eqz v13, +00ah
    const/4 v14, 1
    const/4 v15, 0
    invoke-static v13, v15, v14, v15, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +2h
    const/4 v15, 0
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v13, v15, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummaryReportTimeoutJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v14, 1
    invoke-static v13, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummaryTracking$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    sget-object v13, Lcom/bytedance/trae/im/track/AgentMonitor;->INSTANCE Lcom/bytedance/trae/im/track/AgentMonitor;
    invoke-virtual v13, v4, Lcom/bytedance/trae/im/track/AgentMonitor;->onUserMessageStart(Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/im/service/ICreateAgentTask;->Companion Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
    move-object v13, v1
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-boolean v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/4 v14, 4
    iput v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-virtual v4, v12, v13, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->createAgentTaskRawCall(Lcom/bytedance/trae/im/service/CreateTaskRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v5, +003h
    return-object v5
    move-object v13, v3
    move-object v14, v6
    move-object v15, v7
    move/from16 v96, v8
    move-object v8, v2
    move/from16 v2, v96
    check-cast v4, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v3
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v6, +00dh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v6, v7, +005h
    const-string v6, "ide"
    goto +12h
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v6, +00dh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v6, v7, +005h
    const-string v6, "pc"
    goto +3h
    const-string v6, "cloud_sandbox"
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$mode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v7
    instance-of v12, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v12, +da5h
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v18
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getActivityMessage()Ljava/lang/String;
    move-result-object v17
    if-nez v17, +00ch
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v17
    if-nez v17, +006h
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v17
    move-object/from16 v20, v17
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->getErrorData()Lcom/google/gson/JsonObject;
    move-result-object v21
    move-object/from16 v25, v9
    iget-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-object/from16 v26, v10
    iget-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$mode Lcom/bytedance/trae/im/service/Mode;
    move-object/from16 v24, v1
    check-cast v24, Lkotlin/coroutines/Continuation;
    iput-object v15, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    move-object/from16 v99, v3
    const/4 v3, 5
    iput v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    move-object/from16 v17, v12
    move-object/from16 v22, v9
    move-object/from16 v23, v10
    invoke-static/range v17 ... v24, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$handleModelUnavailableCreateTaskErrorIfNeeded(Lcom/bytedance/trae/conversation/ConversationViewModel; J Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v9, v15
    move-object v15, v4
    move-object/from16 v4, v99
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    if-eqz v3, +06ah
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v8, 0
    invoke-virtual v3, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v10, 0
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/4 v10, 6
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v3, v8, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v5, v6
    move-object v8, v7
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -429h
    goto/16 -436h
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v18
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getActivityMessage()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +00ch
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +006h
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v10
    move-object/from16 v20, v10
    invoke-virtual v15, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->getErrorData()Lcom/google/gson/JsonObject;
    move-result-object v21
    move-object/from16 v22, v1
    check-cast v22, Lkotlin/coroutines/Continuation;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v15, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/4 v10, 7
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    move-object/from16 v17, v3
    invoke-static/range v17 ... v22, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$handleCreateTaskErrorWithoutModelFallbackIfNeeded(Lcom/bytedance/trae/conversation/ConversationViewModel; J Ljava/lang/String; Lcom/google/gson/JsonObject; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v10, v6
    move-object v6, v13
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    if-eqz v3, +06bh
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v6, 0
    invoke-virtual v3, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v9, 0
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v9, 8
    iput v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v3, v6, v8, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v8, v7
    move-object v5, v10
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -4dah
    goto/16 -4e7h
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v12
    const-wide/32 v17, 991502
    cmp-long v3, v12, v17
    const-string v12, ", msg="
    if-nez v3, +148h
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v6, 0
    invoke-virtual v3, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v8, sendMessageIternal: parallel limit reached, conversationId=
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversationId$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v8, ", code="
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v8
    invoke-virtual v6, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    move-object/from16 v13, v26
    invoke-virtual v3, v13, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->getErrorDetail()Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    move-result-object v3
    if-eqz v3, +00bh
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;->getBlockReason()I
    move-result v6
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    if-nez v6, +003h
    goto +15h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v8
    const/4 v9, 1
    if-ne v8, v9, +00fh
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_no_access I
    invoke-virtual v3, v6, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    goto +55h
    if-nez v6, +003h
    goto +15h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v8
    const/4 v9, 3
    if-ne v8, v9, +00fh
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_not_in_activity_time I
    invoke-virtual v3, v6, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    goto +3eh
    if-nez v6, +003h
    goto +17h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v6
    const/4 v8, 2
    if-ne v6, v8, +011h
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;->getLimit()I
    move-result v3
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-static v6, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$buildParallelLimitMessage(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v3
    goto +25h
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;->getLimit()I
    move-result v8
    goto +2h
    const/4 v8, 2
    if-lez v8, +00dh
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-static v3, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$buildParallelLimitMessage(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v3
    goto +10h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_no_access I
    invoke-virtual v3, v6, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v9, 0
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v9, 9
    iput v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v6, v3, v8, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v4, v7
    move-object v6, v10
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v10, 10
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v7, v8, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v5, +003h
    return-object v5
    move-object v8, v4
    move-object v5, v6
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -62dh
    goto/16 -63ah
    move-object/from16 v13, v26
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v17
    const-wide/32 v19, 2900101
    cmp-long v3, v17, v19
    const-wide/32 v17, 2900105
    if-eqz v3, +a09h
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v19
    cmp-long v3, v19, v17
    if-nez v3, +004h
    goto/16 +9ffh
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v17
    const-wide/32 v19, 991208
    cmp-long v3, v17, v19
    if-nez v3, +0b1h
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v8, sendMessageIternal: append message not allowed, code=
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v8
    invoke-virtual v6, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v13, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v6
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_append_not_allowed I
    invoke-virtual v6, v8, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v6
    move-object/from16 v15, v25
    invoke-static v6, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v9, 0
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v9, 13
    iput v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v3, v6, v8, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v4, v7
    move-object v6, v10
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v10, 14
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v7, v8, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v5, +003h
    return-object v5
    move-object v8, v4
    move-object v5, v6
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -701h
    goto/16 -70eh
    move-object/from16 v15, v25
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v17
    const-wide/16 v19, 500
    cmp-long v3, v17, v19
    if-nez v3, +092h
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v6
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_send_retry I
    invoke-virtual v6, v8, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v9, 0
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v9, 15
    iput v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v3, v6, v8, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v4, v7
    move-object v6, v10
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v10, 16
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v7, v8, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v5, +003h
    return-object v5
    move-object v8, v4
    move-object v5, v6
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -79dh
    goto/16 -7aah
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v17
    const-wide/16 v19, 4050
    cmp-long v3, v17, v19
    move-object/from16 v16, v6
    const-string v6, "getResources(...)"
    if-nez v3, +0d3h
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v8, 0
    invoke-virtual v3, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v9, sendMessageIternal: model overloaded, code=
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v14
    invoke-virtual v8, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v13, v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getActivityMessage()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +011h
    move-object v8, v3
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    const/4 v9, 1
    xor-int/2addr v8, v9
    if-eqz v8, +003h
    goto +2h
    const/4 v3, 0
    if-nez v3, +01ah
    sget-object v3, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget-object v8, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v8
    invoke-virtual v8, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    invoke-static v8, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_model_overloaded I
    const/4 v9, 0
    new-array v12, v9, [Ljava/lang/Object;
    invoke-virtual v3, v8, v6, v12, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v9, 0
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v9, 17
    iput v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v6, v3, v8, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v4, v7
    move-object v6, v10
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v10, 18
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v7, v8, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v5, +003h
    return-object v5
    move-object v8, v4
    move-object v5, v6
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -87ch
    goto/16 -889h
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v17
    const-wide/32 v19, 991209
    cmp-long v3, v17, v19
    if-nez v3, +0d3h
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v8, 0
    invoke-virtual v3, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v9, sendMessageIternal: insufficient resources, code=
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v14
    invoke-virtual v8, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v13, v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getActivityMessage()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +011h
    move-object v8, v3
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    const/4 v9, 1
    xor-int/2addr v8, v9
    if-eqz v8, +003h
    goto +2h
    const/4 v3, 0
    if-nez v3, +01ah
    sget-object v3, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget-object v8, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v8
    invoke-virtual v8, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    invoke-static v8, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_insufficient_resources I
    const/4 v9, 0
    new-array v12, v9, [Ljava/lang/Object;
    invoke-virtual v3, v8, v6, v12, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v9, 0
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v9, 19
    iput v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v6, v3, v8, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v4, v7
    move-object v6, v10
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v10, 20
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v7, v8, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v5, +003h
    return-object v5
    move-object v8, v4
    move-object v5, v6
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -958h
    goto/16 -965h
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v17
    const-wide/32 v19, 40141
    cmp-long v3, v17, v19
    if-eqz v3, +5f7h
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v17
    const-wide/16 v19, 4010
    cmp-long v3, v17, v19
    if-nez v3, +004h
    goto/16 +5ebh
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v17
    const-wide/32 v19, 40142
    cmp-long v3, v17, v19
    if-nez v3, +0cah
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v8, 0
    invoke-virtual v3, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v9, sendMessageIternal: risk control rejected, code=
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v14
    invoke-virtual v8, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v13, v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    sget-object v8, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget-object v9, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v9
    invoke-virtual v9, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_abnormal_account_limit I
    const/4 v12, 0
    new-array v13, v12, [Ljava/lang/Object;
    invoke-virtual v8, v9, v6, v13, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v9, 0
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v9, 24
    iput v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v3, v6, v8, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v4, v7
    move-object v6, v10
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v10, 25
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v7, v8, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v5, +003h
    return-object v5
    move-object v8, v4
    move-object v5, v6
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -a42h
    goto/16 -a4fh
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v17
    const-wide/16 v19, 200
    cmp-long v3, v17, v19
    if-eqz v3, +092h
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v6
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_send_retry I
    invoke-virtual v6, v8, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v9, 0
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v9, 26
    iput v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v3, v6, v8, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v4, v7
    move-object v6, v10
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v10, 27
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v7, v8, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v5, +003h
    return-object v5
    move-object v8, v4
    move-object v5, v6
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -adch
    goto/16 -ae9h
    sget-object v17, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +005h
    const/16 v19, 1
    goto +3h
    const/16 v19, 0
    const/16 v20, 1
    const-string v22, ""
    move-object/from16 v18, v10
    move-object/from16 v21, v7
    invoke-virtual/range v17 ... v22, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/CreateTaskResponse;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CreateTaskResponse;->getTask()Lcom/bytedance/trae/im/service/ConversationInfo;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-eqz v2, +119h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getId()Ljava/lang/String;
    move-result-object v37
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getUserId()Ljava/lang/String;
    move-result-object v41
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getCliId()Ljava/lang/String;
    move-result-object v42
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getCliConversationId()Ljava/lang/String;
    move-result-object v40
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getTitle()Ljava/lang/String;
    move-result-object v43
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getStatus()Ljava/lang/String;
    move-result-object v47
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getCreatedAt()Ljava/lang/String;
    move-result-object v52
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getUpdatedAt()Ljava/lang/String;
    move-result-object v53
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getLatestTaskId()Ljava/lang/String;
    move-result-object v49
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_selectedDevice$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v3, +009h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v44, v3
    goto +3h
    const/16 v44, 0
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_selectedDevice$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v3, +00fh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    if-eqz v3, +009h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v48, v3
    goto +3h
    const/16 v48, 0
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$mode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v46
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedRepoUrl()Ljava/lang/String;
    move-result-object v45
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getCliConversationStatus()Ljava/lang/Integer;
    move-result-object v56
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getOwnerProjectId()Ljava/lang/String;
    move-result-object v57
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getLatestProjectId()Ljava/lang/String;
    move-result-object v58
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getOwnerProjectAbsolutePath()Ljava/lang/String;
    move-result-object v59
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getOwnerProjectWorkSpaceStatus()Ljava/lang/String;
    move-result-object v60
    new-instance v3, Lcom/bytedance/trae/im/service/Conversation;
    const/16 v38, 0
    const/16 v39, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v54, 0
    const/16 v55, 0
    const/16 v61, 0
    const/16 v62, 0
    const v63, 50749446
    const/16 v64, 0
    move-object/from16 v36, v3
    invoke-direct/range v36 ... v64, Lcom/bytedance/trae/im/service/Conversation;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/service/CreateTaskResponse;
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/im/service/CreateTaskResponse;->getTaskId()Ljava/lang/String;
    move-result-object v7
    goto +2h
    const/4 v7, 0
    invoke-static v6, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$set_currentTaskId$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String;)V
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversation$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v6
    invoke-interface v6, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    if-nez v6, +018h
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversation$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v6
    invoke-interface v6, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversationId$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v6
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-interface v6, v7, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$mode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationInfo;->getId()Ljava/lang/String;
    move-result-object v20
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$agentType Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$selectedModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-object/from16 v17, v6
    move-object/from16 v18, v7
    move-object/from16 v19, v10
    move-object/from16 v21, v12
    move-object/from16 v22, v15
    invoke-static/range v17 ... v22, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$cacheTaskModelSelection(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)V
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTask$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    move-object v7, v1
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    move-object/from16 v10, v16
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    const/4 v12, 0
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    const/16 v12, 28
    iput v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v6, v3, v7, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v4, v8
    move-object v6, v10
    move-object v7, v14
    move-object v8, v4
    move-object v14, v7
    move-object/from16 v75, v9
    move-object v7, v2
    move-object v4, v3
    move-object v9, v6
    goto +7h
    move-object/from16 v10, v16
    move-object v7, v2
    move-object/from16 v75, v9
    move-object v9, v10
    const-class v2, Ljava/util/List;
    check-cast v2, Ljava/lang/reflect/Type;
    const/4 v3, 1
    new-array v6, v3, [Ljava/lang/reflect/Type;
    const-class v3, Lcom/bytedance/trae/im/model/MessagePart;
    const/4 v10, 0
    aput-object v3, v6, v10
    invoke-static v2, v6, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v2
    invoke-virtual v2, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v2
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->getGson()Lcom/google/gson/Gson;
    move-result-object v3
    iget-object v6, v14, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-virtual v3, v6, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    move-object/from16 v76, v2
    goto +3h
    const/16 v76, 0
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/CreateTaskResponse;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CreateTaskResponse;->getTaskId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    move-object v6, v11
    goto +2h
    move-object v6, v2
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/CreateTaskResponse;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CreateTaskResponse;->getMessageId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +003h
    move-object v2, v11
    move-object v3, v6
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    const/4 v4, 1
    xor-int/2addr v3, v4
    if-eqz v3, +021h
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, v6, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->migrateTo(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v6, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->onSendResponse(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isSummaryTracking$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, +014h
    sget-object v3, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    new-instance v8, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$$ExternalSyntheticLambda0;
    invoke-direct v8, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    invoke-virtual v3, v6, v8, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->start(Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    goto +6h
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversationId$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    if-nez v8, +005h
    move-object/from16 v37, v11
    goto +3h
    move-object/from16 v37, v8
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +004h
    const/4 v8, 1
    goto +2h
    const/4 v8, 0
    if-eqz v8, +010h
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v2
    invoke-virtual v2, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v8, toString(...)
    invoke-static v2, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v38, v2
    check-cast v38, Ljava/lang/String;
    new-instance v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const-string/jumbo v43, user
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 0
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$agentType Ljava/lang/String;
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v61, 0
    const/16 v62, 0
    const/16 v63, 0
    const/16 v64, 0
    const/16 v65, 0
    const/16 v66, 0
    const/16 v67, 0
    const/16 v68, 0
    const/16 v69, 0
    const/16 v70, 0
    const/16 v71, 0
    const/16 v72, 0
    const/16 v73, 0
    const/16 v74, 0
    const/16 v77, 0
    const/16 v78, 0
    const/16 v79, 0
    const/16 v80, 0
    const/16 v81, 0
    const/16 v82, 0
    const/16 v83, 0
    const/16 v84, 0
    const/16 v85, 0
    const/16 v86, 0
    const/16 v87, 0
    const/16 v88, 0
    const/16 v89, 0
    const/16 v90, 0
    const/16 v91, 0
    const/16 v92, 0
    const v93, -4325448
    const v94, 8388255
    const/16 v95, 0
    move-object/from16 v36, v2
    move-object/from16 v39, v6
    move-object/from16 v54, v8
    move-wide/from16 v59, v3
    invoke-direct/range v36 ... v95, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversationId$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    move-object v10, v8
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +00bh
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +003h
    goto +3h
    const/4 v10, 0
    goto +2h
    const/4 v10, 1
    if-nez v10, +040h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v10
    check-cast v10, Lkotlin/coroutines/CoroutineContext;
    new-instance v12, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v15, 0
    invoke-direct v12, v14, v8, v2, v15, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    const/4 v14, 0
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-wide v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->J$0 J
    const/16 v14, 29
    iput v14, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-static v10, v12, v8, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v5, +003h
    return-object v5
    move-wide/from16 v96, v3
    move-object v4, v2
    move-wide/from16 v2, v96
    move-object/from16 v87, v9
    move-wide/from16 v96, v2
    move-object v2, v4
    move-wide/from16 v3, v96
    goto +3h
    move-object/from16 v87, v9
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->isNewConversation()Z
    move-result v8
    if-eqz v8, +070h
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v9, 0
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->setNewConversation(Z)V
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversationId$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    move-object v9, v8
    check-cast v9, Ljava/lang/CharSequence;
    if-eqz v9, +00bh
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-nez v9, +003h
    goto +3h
    const/4 v9, 0
    goto +2h
    const/4 v9, 1
    if-nez v9, +020h
    sget-object v9, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v9, v8, Lcom/bytedance/trae/im/service/IMService;->addFetchedConversation(Ljava/lang/String;)V
    iget-object v9, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getKeva(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lcom/bytedance/keva/Keva;
    move-result-object v9
    sget-object v10, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppStartTime()Lkotlin/Pair;
    move-result-object v10
    invoke-virtual v10, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/lang/Number;
    invoke-virtual v10, Ljava/lang/Number;->longValue()J
    move-result-wide v14
    invoke-virtual v9, v8, v14, v15, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    iget-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_selectedDevice$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v8, +021h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v8
    if-eqz v8, +01bh
    invoke-virtual v8, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +015h
    sget-object v9, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v9
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/im/service/ConversationInfo;->getCliId()Ljava/lang/String;
    move-result-object v7
    goto +2h
    const/4 v7, 0
    invoke-virtual v9, v7, v8, Lcom/bytedance/trae/conversation/CliListRepository;->saveCliId(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v7, v6
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-lez v7, +004h
    const/4 v7, 1
    goto +2h
    const/4 v7, 0
    if-eqz v7, +0b7h
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_conversationId$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v7
    invoke-interface v7, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    if-nez v7, +005h
    move-object/from16 v37, v11
    goto +3h
    move-object/from16 v37, v7
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    const-string v8, "placeholder_"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v38
    new-instance v75, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    const/16 v19, 0
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v20
    const/16 v21, 2
    const/16 v22, 0
    move-object/from16 v17, v75
    move-object/from16 v18, v6
    invoke-direct/range v17 ... v22, Lcom/bytedance/trae/im/model/ParsedTaskContent;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v45
    const-wide/16 v6, 1
    add-long v59, v3, v6
    new-instance v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/16 v39, 0
    const/16 v40, 0
    const-string v41, "in_progress"
    const/16 v42, 0
    const-string v43, "assistant"
    const/16 v44, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 0
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->$agentType Ljava/lang/String;
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v61, 0
    const/16 v62, 0
    const/16 v63, 0
    const/16 v64, 0
    const/16 v65, 0
    const/16 v66, 0
    const/16 v67, 0
    const/16 v68, 0
    const/16 v69, 0
    const/16 v70, 0
    const/16 v71, 0
    const/16 v72, 0
    const/16 v73, 0
    const/16 v74, 0
    const/16 v76, 0
    const/16 v77, 0
    const/16 v78, 0
    const/16 v79, 0
    const/16 v80, 0
    const/16 v81, 0
    const/16 v82, 0
    const/16 v83, 0
    const/16 v84, 0
    const/16 v85, 0
    const/16 v86, 0
    const/16 v88, 0
    const/16 v89, 0
    const/16 v90, 0
    const/16 v91, 0
    const/16 v92, 0
    const v93, -4325716
    const v94, 8257247
    const/16 v95, 0
    move-object/from16 v36, v3
    move-object/from16 v54, v4
    invoke-direct/range v36 ... v95, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +ah
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string/jumbo v4, sendMessageIternal: taskId is empty from HTTP response, skip placeholder
    invoke-virtual v3, v13, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v3, 0
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_sessionTurnStatus$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    sget-object v6, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->STREAMING Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    invoke-interface v4, v6, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    invoke-static v4, v6, v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setLastStreamingEmitTime$p(Lcom/bytedance/trae/conversation/ConversationViewModel; J)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v6, 2
    new-array v6, v6, [Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v7, 0
    aput-object v2, v6, v7
    const/4 v9, 1
    aput-object v3, v6, v9
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    invoke-static v4, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$upsertMessages(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/util/List;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_sendMessageSuccess$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    invoke-static v2, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    move-object v3, v1
    check-cast v3, Lkotlin/coroutines/Continuation;
    const/4 v6, 0
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    const/16 v6, 30
    iput v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v4, v2, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v5, +003h
    return-object v5
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v3, 0
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getBufferedAgentMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v2
    if-eqz v2, +29fh
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setBufferedAgentMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    const/16 v4, 31
    iput v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-static v3, v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$emitStreamingThrottled(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v5, +003h
    return-object v5
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +28ah
    const/4 v9, 1
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v8, 0
    invoke-virtual v3, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v14, sendMessageIternal: risk control logout, code=
    invoke-virtual v8, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v14
    invoke-virtual v8, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v8, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v13, v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    sget-object v8, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget-object v12, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v12
    invoke-virtual v12, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    invoke-static v12, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_abnormal_account_logout I
    const/4 v13, 0
    new-array v14, v13, [Ljava/lang/Object;
    invoke-virtual v8, v12, v6, v14, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v12, 0
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v12, 21
    iput v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v3, v6, v8, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v4, v7
    move-object v6, v10
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_forceLogout$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v10, v1
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v12, 22
    iput v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v7, v8, v10, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v5, +003h
    return-object v5
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v10, v1
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v12, 23
    iput v12, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v7, v8, v10, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v5, +003h
    return-object v5
    move-object/from16 v21, v4
    move-object/from16 v18, v6
    sget-object v17, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +005h
    move/from16 v19, v9
    goto +3h
    const/16 v19, 0
    const/16 v20, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v22
    invoke-virtual/range v17 ... v22, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -1044h
    goto/16 -1051h
    move-object/from16 v15, v25
    const/4 v9, 1
    sget-object v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->removeTaskId(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v6, 0
    invoke-virtual v3, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v8, sendMessageIternal: device offline, code=
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    move-object v8, v10
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v6, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v13, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    cmp-long v3, v9, v17
    if-nez v3, +005h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_ide_device_offline I
    goto +3h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    sget-object v9, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v9
    invoke-virtual v9, v3, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    const/4 v10, 0
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$4 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$5 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$6 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$7 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v10, 11
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v6, v3, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v5, +003h
    return-object v5
    move-object v3, v4
    move-object v4, v7
    move-object v6, v8
    iget-object v7, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->Z$0 Z
    const/16 v10, 12
    iput v10, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v7, v8, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v5, +003h
    return-object v5
    move-object v8, v4
    move-object v5, v6
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    const/4 v7, 0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -1106h
    goto/16 -1113h
    move-object v15, v9
    instance-of v4, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v4, +056h
    sget-object v17, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +005h
    const/16 v19, 1
    goto +3h
    const/16 v19, 0
    const/16 v20, 0
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v22
    move-object/from16 v18, v6
    move-object/from16 v21, v7
    invoke-virtual/range v17 ... v22, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    const/16 v4, 401
    if-ne v3, v4, +033h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_forceLogout$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    const/4 v6, 0
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    const/16 v6, 32
    iput v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v5, +003h
    return-object v5
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, -115fh
    goto/16 -116ch
    sget-object v17, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    if-eqz v2, +005h
    const/16 v19, 1
    goto +3h
    const/16 v19, 0
    const/16 v20, 0
    const-string v22, ""
    move-object/from16 v18, v6
    move-object/from16 v21, v7
    invoke-virtual/range v17 ... v22, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v3, 0
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->setTaskRunning(Z)V
    sget-object v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v2, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->clear(Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v3, 0
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setBufferedAgentMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isSummaryTracking$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v2
    if-eqz v2, +00dh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v3, 0
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setSummaryTracking$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$submitSummaryPerfReport(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-virtual v2, v3, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_toastText$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    const/4 v6, 0
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$0 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$1 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$2 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->L$3 Ljava/lang/Object;
    const/16 v6, 33
    iput v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v3, v2, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v5, +003h
    return-object v5
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$get_createTaskFailed$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    const/16 v6, 34
    iput v6, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->label I
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v5, +003h
    return-object v5
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v3, 0
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v2
    if-eqz v2, +00dh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v2, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setBufferedAgentMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$flushPendingUpgradeReminderIfAllowed(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v4, 0
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setCreateTaskJob$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lkotlinx/coroutines/Job;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$isUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel;)Z
    move-result v3
    if-eqz v3, +00dh
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v5, 0
    invoke-static v3, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setUserMessagePending$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Z)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$setBufferedAgentMessage$p(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$flushPendingUpgradeReminderIfAllowed(Lcom/bytedance/trae/conversation/ConversationViewModel;)V
    throw v2
    nop 
    packed-switch-payload 0 1 2 3 4 5 6 7 8 9 a b c d e f 10 11 12 13 14 15 16 17 18 19 1a 1b 1c 1d 1e 1f 20 21 22
    :try_start_0x22
    :try_start_0x4d
    :try_start_0x6b
    :try_start_0x7f
    :try_start_0x93
    :try_start_0xa6
    :try_start_0xba
    :try_start_0xcd
    :try_start_0xe5
    :try_start_0xf9
    :try_start_0x10d
    :try_start_0x121
    :try_start_0x134
    :try_start_0x148
    :try_start_0x15b
    :try_start_0x16f
    :try_start_0x182
    :try_start_0x196
    :try_start_0x1a9
    :try_start_0x1bd
    :try_start_0x1d0
    :try_start_0x1e4
    :try_start_0x1f7
    :try_start_0x21f
    :try_start_0x23f
    :try_start_0x267
    :try_start_0x288
    :try_start_0x2a0
    :try_start_0x2b1
    :try_start_0x31f
    :try_start_0x3a3
    :try_start_0x482
    :try_start_0x4cf
    :try_start_0x50b
    :try_start_0x637
    :try_start_0x6ae
    :try_start_0x7ca
    :try_start_0x87b
    :try_start_0x888
    :try_start_0x9d0
    :try_start_0xaa4
    :try_start_0xb3e
    :try_start_0xb4c
    :try_start_0xc1d
    :try_start_0xcf9
    :try_start_0xde3
    :try_start_0xe7d
    :try_start_0xfbe
    :try_start_0xfe7
    :try_start_0x13e8
    :try_start_0x14a8
    :try_start_0x1500
.end method
