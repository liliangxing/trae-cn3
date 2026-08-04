# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/SearchConversationItem;
.super Ljava/lang/Object;
.source "IListConversationsService.kt"

.field private final cliId:Ljava/lang/String;
.field private final conversationId:Ljava/lang/String;
.field private final conversationTitle:Ljava/lang/String;
.field private final conversationUpdatedAt:Ljava/lang/String;
.field private final messageContent:Ljava/lang/String;
.field private final messageCreatedAt:Ljava/lang/String;
.field private final messageCreatedAtMs:Ljava/lang/String;
.field private final messageId:Ljava/lang/String;
.field private final messageRole:Ljava/lang/String;
.field private final replyToMessageId:Ljava/lang/String;


.method public constructor <init>()void
    .registers 14
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 1023
    const/4 v12, 0
    move-object v0, v13
    invoke-direct/range v0 ... v12, Lcom/bytedance/trae/im/service/SearchConversationItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 11
    # ins_size=11
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->cliId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationTitle Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationUpdatedAt Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageId Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageRole Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->replyToMessageId Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageContent Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAt Ljava/lang/String;
    iput-object v10, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAtMs Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 24
    # ins_size=13
    move/from16 v0, v22
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v12
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v13
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v14
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v15
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v16
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v17
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v18
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v19
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v0, v0, 512
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v21
    move-object v12, v11
    move-object v13, v1
    move-object v14, v3
    move-object v15, v4
    move-object/from16 v16, v5
    move-object/from16 v17, v6
    move-object/from16 v18, v7
    move-object/from16 v19, v8
    move-object/from16 v20, v9
    move-object/from16 v21, v10
    move-object/from16 v22, v2
    invoke-direct/range v12 ... v22, Lcom/bytedance/trae/im/service/SearchConversationItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.SearchConversationItem  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.SearchConversationItem
    .registers 24
    # ins_size=13
    move-object v0, v11
    move/from16 v1, v22
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->cliId Ljava/lang/String;
    goto +2h
    move-object v2, v12
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationId Ljava/lang/String;
    goto +2h
    move-object v3, v13
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationTitle Ljava/lang/String;
    goto +2h
    move-object v4, v14
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationUpdatedAt Ljava/lang/String;
    goto +2h
    move-object v5, v15
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageId Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v16
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageRole Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v17
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->replyToMessageId Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v18
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageContent Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v19
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAt Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v1, v1, 512
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAtMs Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v21
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    move-object v15, v5
    move-object/from16 v16, v6
    move-object/from16 v17, v7
    move-object/from16 v18, v8
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object/from16 v21, v1
    invoke-virtual/range v11 ... v21, Lcom/bytedance/trae/im/service/SearchConversationItem;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/im/service/SearchConversationItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAtMs Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationTitle Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationUpdatedAt Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageRole Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageContent Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAt Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.im.service.SearchConversationItem
    .registers 23
    # ins_size=11
    new-instance v11, Lcom/bytedance/trae/im/service/SearchConversationItem;
    move-object v0, v11
    move-object v1, v13
    move-object v2, v14
    move-object v3, v15
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    move-object/from16 v6, v18
    move-object/from16 v7, v19
    move-object/from16 v8, v20
    move-object/from16 v9, v21
    move-object/from16 v10, v22
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/im/service/SearchConversationItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v11
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/SearchConversationItem;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SearchConversationItem;->cliId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;->cliId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationTitle Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationTitle Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationUpdatedAt Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationUpdatedAt Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageRole Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageRole Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SearchConversationItem;->replyToMessageId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;->replyToMessageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageContent Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageContent Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAt Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAt Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAtMs Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAtMs Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getConversationTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationTitle Ljava/lang/String;
    return-object v0
.end method

.method public final getConversationUpdatedAt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationUpdatedAt Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageContent Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageCreatedAt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAt Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageCreatedAtMs()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAtMs Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageRole()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageRole Ljava/lang/String;
    return-object v0
.end method

.method public final getReplyToMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SearchConversationItem;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/SearchConversationItem;->cliId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationTitle Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationUpdatedAt Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageRole Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/SearchConversationItem;->replyToMessageId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageContent Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAt Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAtMs Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SearchConversationItem(cliId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SearchConversationItem;->cliId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conversationTitle="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationTitle Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conversationUpdatedAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SearchConversationItem;->conversationUpdatedAt Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageRole="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageRole Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", replyToMessageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SearchConversationItem;->replyToMessageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageContent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageContent Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageCreatedAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAt Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageCreatedAtMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SearchConversationItem;->messageCreatedAtMs Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
