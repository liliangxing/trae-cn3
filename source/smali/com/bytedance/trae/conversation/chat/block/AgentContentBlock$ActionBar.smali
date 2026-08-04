# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final feedbackState:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
.field private final isUserCanceled:Ljava/lang/Boolean;
.field private final isVoiceSummaryStyle:Z
.field private final messageId:Ljava/lang/String;
.field private final varargs onActionClick:Lkotlin/jvm/functions/Function1;
.field private final showFeedback:Z
.field private final showInterjectedStatus:Z
.field private final showManualStopStatus:Z
.field private final status:Ljava/lang/String;
.field private final tokenUsage:Lcom/bytedance/trae/im/model/ParsedTokenUsage;


.method public constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedTokenUsage  java.lang.Boolean  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState  boolean  boolean  boolean  boolean  kotlin.jvm.functions.Function1)void
    .registers 12
    # ins_size=11
    const-string v0, "messageId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "feedbackState"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->status Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->messageId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isUserCanceled Ljava/lang/Boolean;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->feedbackState Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    iput-boolean v7, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showFeedback Z
    iput-boolean v8, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showManualStopStatus Z
    iput-boolean v9, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showInterjectedStatus Z
    iput-boolean v10, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle Z
    iput-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->onActionClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedTokenUsage  java.lang.Boolean  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState  boolean  boolean  boolean  boolean  kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 26
    # ins_size=13
    move/from16 v0, v24
    and-int/lit8 v1, v0, 16
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->NONE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    move-object v7, v1
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v1, v0, 32
    if-eqz v1, +005h
    const/4 v1, 1
    move v8, v1
    goto +3h
    move/from16 v8, v19
    and-int/lit8 v1, v0, 64
    const/4 v2, 0
    if-eqz v1, +004h
    move v9, v2
    goto +3h
    move/from16 v9, v20
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move v10, v2
    goto +3h
    move/from16 v10, v21
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move v11, v2
    goto +3h
    move/from16 v11, v22
    and-int/lit16 v0, v0, 512
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v12, v0
    goto +3h
    move-object/from16 v12, v23
    move-object v2, v13
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    invoke-direct/range v2 ... v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Ljava/lang/Boolean; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState; Z Z Z Z Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedTokenUsage  java.lang.Boolean  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState  boolean  boolean  boolean  boolean  kotlin.jvm.functions.Function1  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar
    .registers 24
    # ins_size=13
    move-object v0, v11
    move/from16 v1, v22
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->status Ljava/lang/String;
    goto +2h
    move-object v2, v12
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->messageId Ljava/lang/String;
    goto +2h
    move-object v3, v13
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    goto +2h
    move-object v4, v14
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isUserCanceled Ljava/lang/Boolean;
    goto +2h
    move-object v5, v15
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->feedbackState Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    goto +3h
    move-object/from16 v6, v16
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-boolean v7, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showFeedback Z
    goto +3h
    move/from16 v7, v17
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showManualStopStatus Z
    goto +3h
    move/from16 v8, v18
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-boolean v9, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showInterjectedStatus Z
    goto +3h
    move/from16 v9, v19
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-boolean v10, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle Z
    goto +3h
    move/from16 v10, v20
    and-int/lit16 v1, v1, 512
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->onActionClick Lkotlin/jvm/functions/Function1;
    goto +3h
    move-object/from16 v1, v21
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    move-object v15, v5
    move-object/from16 v16, v6
    move/from16 v17, v7
    move/from16 v18, v8
    move/from16 v19, v9
    move/from16 v20, v10
    move-object/from16 v21, v1
    invoke-virtual/range v11 ... v21, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->copy(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Ljava/lang/Boolean; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState; Z Z Z Z Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component10()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->onActionClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.im.model.ParsedTokenUsage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    return-object v0
.end method

.method public final component4()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isUserCanceled Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->feedbackState Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    return-object v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showFeedback Z
    return v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showManualStopStatus Z
    return v0
.end method

.method public final component8()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showInterjectedStatus Z
    return v0
.end method

.method public final component9()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle Z
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedTokenUsage  java.lang.Boolean  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState  boolean  boolean  boolean  boolean  kotlin.jvm.functions.Function1)com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar
    .registers 23
    # ins_size=11
    const-string v0, "messageId"
    move-object v3, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "feedbackState"
    move-object/from16 v6, v17
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    move-object v1, v0
    move-object v2, v13
    move-object v4, v15
    move-object/from16 v5, v16
    move/from16 v7, v18
    move/from16 v8, v19
    move/from16 v9, v20
    move/from16 v10, v21
    move-object/from16 v11, v22
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Ljava/lang/Boolean; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState; Z Z Z Z Lkotlin/jvm/functions/Function1;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->messageId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isUserCanceled Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isUserCanceled Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->feedbackState Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->feedbackState Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showFeedback Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showFeedback Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showManualStopStatus Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showManualStopStatus Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showInterjectedStatus Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showInterjectedStatus Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->onActionClick Lkotlin/jvm/functions/Function1;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->onActionClick Lkotlin/jvm/functions/Function1;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getFeedbackState()com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->feedbackState Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    return-object v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getOnActionClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->onActionClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getShowFeedback()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showFeedback Z
    return v0
.end method

.method public final getShowInterjectedStatus()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showInterjectedStatus Z
    return v0
.end method

.method public final getShowManualStopStatus()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showManualStopStatus Z
    return v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getTokenUsage()com.bytedance.trae.im.model.ParsedTokenUsage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->status Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->messageId Ljava/lang/String;
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isUserCanceled Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->feedbackState Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showFeedback Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showManualStopStatus Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showInterjectedStatus Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->onActionClick Lkotlin/jvm/functions/Function1;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isUserCanceled()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isUserCanceled Ljava/lang/Boolean;
    return-object v0
.end method

.method public final isVoiceSummaryStyle()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ActionBar(status="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->status Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", tokenUsage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isUserCanceled="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isUserCanceled Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", feedbackState="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->feedbackState Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showFeedback="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showFeedback Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showManualStopStatus="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showManualStopStatus Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showInterjectedStatus="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->showInterjectedStatus Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isVoiceSummaryStyle="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onActionClick="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->onActionClick Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
