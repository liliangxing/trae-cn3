# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HubArtifactItem;
.super Ljava/lang/Object;
.source "IGetArtifactListApi.kt"

.field private final conversationId:Ljava/lang/String;
.field private final createdAt:J
.field private final id:Ljava/lang/String;
.field private final messageIndexRelations:Ljava/util/List;
.field private final path:Ljava/lang/String;
.field private final updatedAt:J


.method public constructor <init>()void
    .registers 12
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const-wide/16 v5, 0
    const-wide/16 v7, 0
    const/16 v9, 63
    const/4 v10, 0
    move-object v0, v11
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/products/HubArtifactItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; J J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.util.List  long  long)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->id Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->conversationId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->path Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->messageIndexRelations Ljava/util/List;
    iput-wide v5, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->createdAt J
    iput-wide v7, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->updatedAt J
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.util.List  long  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=11
    and-int/lit8 v15, v14, 1
    const/4 v0, 0
    if-eqz v15, +004h
    move-object v15, v0
    goto +2h
    move-object v15, v6
    and-int/lit8 v6, v14, 2
    if-eqz v6, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v7
    and-int/lit8 v6, v14, 4
    if-eqz v6, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v8
    and-int/lit8 v6, v14, 8
    if-eqz v6, +003h
    goto +2h
    move-object v0, v9
    and-int/lit8 v6, v14, 16
    const-wide/16 v7, 0
    if-eqz v6, +004h
    move-wide v3, v7
    goto +2h
    move-wide v3, v10
    and-int/lit8 v6, v14, 32
    if-eqz v6, +004h
    move-wide v13, v7
    goto +2h
    move-wide v13, v12
    move-object v6, v5
    move-object v7, v15
    move-object v8, v1
    move-object v9, v2
    move-object v10, v0
    move-wide v11, v3
    invoke-direct/range v6 ... v14, Lcom/bytedance/trae/conversation/products/HubArtifactItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; J J)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.products.HubArtifactItem  java.lang.String  java.lang.String  java.lang.String  java.util.List  long  long  int  java.lang.Object)com.bytedance.trae.conversation.products.HubArtifactItem
    .registers 20
    # ins_size=11
    move-object v0, v9
    and-int/lit8 v1, v18, 1
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->id Ljava/lang/String;
    goto +2h
    move-object v1, v10
    and-int/lit8 v2, v18, 2
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->conversationId Ljava/lang/String;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v18, 4
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->path Ljava/lang/String;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v18, 8
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->messageIndexRelations Ljava/util/List;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v18, 16
    if-eqz v5, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->createdAt J
    goto +2h
    move-wide v5, v14
    and-int/lit8 v7, v18, 32
    if-eqz v7, +005h
    iget-wide v7, v0, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->updatedAt J
    goto +3h
    move-wide/from16 v7, v16
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    move-object v13, v4
    move-wide v14, v5
    move-wide/from16 v16, v7
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; J J)Lcom/bytedance/trae/conversation/products/HubArtifactItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->path Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->messageIndexRelations Ljava/util/List;
    return-object v0
.end method

.method public final component5()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->createdAt J
    return-wide v0
.end method

.method public final component6()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->updatedAt J
    return-wide v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.util.List  long  long)com.bytedance.trae.conversation.products.HubArtifactItem
    .registers 19
    # ins_size=9
    new-instance v9, Lcom/bytedance/trae/conversation/products/HubArtifactItem;
    move-object v0, v9
    move-object v1, v11
    move-object v2, v12
    move-object v3, v13
    move-object v4, v14
    move-wide v5, v15
    move-wide/from16 v7, v17
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/products/HubArtifactItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; J J)V
    return-object v9
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/products/HubArtifactItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/products/HubArtifactItem;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->id Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->conversationId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->path Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->path Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->messageIndexRelations Ljava/util/List;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->messageIndexRelations Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->createdAt J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->createdAt J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->updatedAt J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->updatedAt J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->createdAt J
    return-wide v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageIndexRelations()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->messageIndexRelations Ljava/util/List;
    return-object v0
.end method

.method public final getPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->path Ljava/lang/String;
    return-object v0
.end method

.method public final getUpdatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->updatedAt J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->id Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->conversationId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->path Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->messageIndexRelations Ljava/util/List;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->createdAt J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->updatedAt J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "HubArtifactItem(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", path="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->path Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageIndexRelations="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->messageIndexRelations Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", createdAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->createdAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", updatedAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->updatedAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
