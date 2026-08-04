# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;
.super Ljava/lang/Object;
.source "CheckpointDialog.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic show$default(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$Companion  androidx.fragment.app.FragmentManager  int  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.im.model.ConfirmInfo  com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog
    .registers 31
    # ins_size=15
    move/from16 v0, v29
    and-int/lit16 v1, v0, 128
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v24
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v26
    and-int/lit16 v1, v0, 1024
    if-eqz v1, +004h
    move-object v14, v2
    goto +3h
    move-object/from16 v14, v27
    and-int/lit16 v0, v0, 2048
    if-eqz v0, +004h
    move-object v15, v2
    goto +3h
    move-object/from16 v15, v28
    move-object/from16 v3, v16
    move-object/from16 v4, v17
    move/from16 v5, v18
    move-object/from16 v6, v19
    move-object/from16 v7, v20
    move-object/from16 v8, v21
    move-object/from16 v9, v22
    move-object/from16 v10, v23
    move-object/from16 v12, v25
    invoke-virtual/range v3 ... v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;->show(Landroidx/fragment/app/FragmentManager; I Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/im/model/ConfirmInfo; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    move-result-object v0
    return-object v0
.end method

.method public final dismissIfShowing(androidx.fragment.app.FragmentManager)void
    .registers 5
    # ins_size=2
    const-string v0, "fragmentManager"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "CheckpointDialog"
    invoke-virtual v4, v0, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v4
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    if-eqz v0, +010h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "CheckPointDialog"
    const-string v2, "[Dialog] dismissIfShowing: found existing, dismissing"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    invoke-static v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$dismiss(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)V
    return-void 
.end method

.method public final show(androidx.fragment.app.FragmentManager  int  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.im.model.ConfirmInfo  com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  java.lang.String)com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog
    .registers 26
    # ins_size=13
    move-object v0, v14
    move v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v19
    move-object/from16 v5, v20
    move-object/from16 v6, v22
    const-string v7, "fragmentManager"
    invoke-static v14, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v7, "planItem"
    invoke-static v2, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v7, taskId
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v7, "questionsJson"
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v7, "pages"
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v7, "callback"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "[Dialog] show: containerId="
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v15, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", taskId="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", pages="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-interface/range v20, Ljava/util/List;->size()I
    move-result v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", toolName="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual/range v16, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v9
    const/4 v10, 0
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v10
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v9, "CheckPointDialog"
    invoke-virtual v7, v9, v8, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-string v7, "CheckpointDialog"
    invoke-virtual v14, v7, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v8
    instance-of v11, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    if-eqz v11, +01ah
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v12, "[Dialog] show: removing existing dialog"
    invoke-virtual v11, v9, v12, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    move-object v9, v8
    check-cast v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    invoke-static v9, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setOnDismissAction$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v14, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v9
    invoke-virtual v9, v8, Landroidx/fragment/app/FragmentTransaction;->remove(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v8
    invoke-virtual v8, Landroidx/fragment/app/FragmentTransaction;->commitNowAllowingStateLoss()V
    new-instance v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    invoke-direct v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;-><init>()V
    invoke-static v8, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setPlanItem$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/im/model/ParsedPlanItem;)V
    invoke-static v8, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setTaskId$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String;)V
    move-object/from16 v2, v18
    invoke-static v8, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setConversationId$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String;)V
    invoke-static v8, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setQuestionsJson$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String;)V
    invoke-static v8, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setPages$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/util/List;)V
    move-object/from16 v2, v21
    invoke-static v8, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setConfirmInfo$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/im/model/ConfirmInfo;)V
    invoke-static v8, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setCallback$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;)V
    move-object/from16 v2, v23
    invoke-static v8, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setOnDismissAction$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lkotlin/jvm/functions/Function0;)V
    move-object/from16 v2, v24
    invoke-static v8, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setOnFileClick$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lkotlin/jvm/functions/Function1;)V
    move-object/from16 v2, v25
    invoke-virtual v8, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setResolvedPluginDisplayName(Ljava/lang/String;)V
    invoke-virtual v14, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    move-object v2, v8
    check-cast v2, Landroidx/fragment/app/Fragment;
    invoke-virtual v0, v15, v2, v7, Landroidx/fragment/app/FragmentTransaction;->add(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commitNowAllowingStateLoss()V
    return-object v8
.end method
