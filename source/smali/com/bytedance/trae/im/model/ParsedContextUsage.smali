# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/ParsedContextUsage;
.super Ljava/lang/Object;
.source "ParsedChatMessage.kt"

.field private final chunkIndex:Ljava/lang/Integer;
.field private final chunkTotal:Ljava/lang/Integer;
.field private final contextBatchId:Ljava/lang/String;
.field private final contextBatchSeq:Ljava/lang/Integer;
.field private final contexts:Ljava/util/List;
.field private final tokenUsageByDisplayType:Ljava/util/List;
.field private final updatedAt:Ljava/lang/Long;


.method public constructor <init>()void
    .registers 11
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 127
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/im/model/ParsedContextUsage;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  java.lang.Long  java.lang.String  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.util.List)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contexts Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/im/model/ParsedContextUsage;->updatedAt Ljava/lang/Long;
    iput-object v3, v0, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchSeq Ljava/lang/Integer;
    iput-object v5, v0, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkIndex Ljava/lang/Integer;
    iput-object v6, v0, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkTotal Ljava/lang/Integer;
    iput-object v7, v0, Lcom/bytedance/trae/im/model/ParsedContextUsage;->tokenUsageByDisplayType Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.lang.Long  java.lang.String  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=10
    and-int/lit8 v15, v14, 1
    const/4 v0, 0
    if-eqz v15, +004h
    move-object v15, v0
    goto +2h
    move-object v15, v7
    and-int/lit8 v7, v14, 2
    if-eqz v7, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v8
    and-int/lit8 v7, v14, 4
    if-eqz v7, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v9
    and-int/lit8 v7, v14, 8
    if-eqz v7, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v10
    and-int/lit8 v7, v14, 16
    if-eqz v7, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v11
    and-int/lit8 v7, v14, 32
    if-eqz v7, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v12
    and-int/lit8 v7, v14, 64
    if-eqz v7, +004h
    move-object v14, v0
    goto +2h
    move-object v14, v13
    move-object v7, v6
    move-object v8, v15
    move-object v9, v1
    move-object v10, v2
    move-object v11, v3
    move-object v12, v4
    move-object v13, v5
    invoke-direct/range v7 ... v14, Lcom/bytedance/trae/im/model/ParsedContextUsage;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/util/List;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.model.ParsedContextUsage  java.util.List  java.lang.Long  java.lang.String  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.util.List  int  java.lang.Object)com.bytedance.trae.im.model.ParsedContextUsage
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contexts Ljava/util/List;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->updatedAt Ljava/lang/Long;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchId Ljava/lang/String;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchSeq Ljava/lang/Integer;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkIndex Ljava/lang/Integer;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkTotal Ljava/lang/Integer;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->tokenUsageByDisplayType Ljava/util/List;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move-object v9, v14
    move-object v10, v0
    move-object v11, v1
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/im/model/ParsedContextUsage;->copy(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/util/List;)Lcom/bytedance/trae/im/model/ParsedContextUsage;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contexts Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->updatedAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchSeq Ljava/lang/Integer;
    return-object v0
.end method

.method public final component5()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkIndex Ljava/lang/Integer;
    return-object v0
.end method

.method public final component6()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkTotal Ljava/lang/Integer;
    return-object v0
.end method

.method public final component7()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->tokenUsageByDisplayType Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.util.List  java.lang.Long  java.lang.String  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.util.List)com.bytedance.trae.im.model.ParsedContextUsage
    .registers 17
    # ins_size=8
    new-instance v8, Lcom/bytedance/trae/im/model/ParsedContextUsage;
    move-object v0, v8
    move-object v1, v10
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/im/model/ParsedContextUsage;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/util/List;)V
    return-object v8
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contexts Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contexts Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedContextUsage;->updatedAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->updatedAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchSeq Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchSeq Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkIndex Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkIndex Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkTotal Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkTotal Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedContextUsage;->tokenUsageByDisplayType Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/im/model/ParsedContextUsage;->tokenUsageByDisplayType Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getChunkIndex()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkIndex Ljava/lang/Integer;
    return-object v0
.end method

.method public final getChunkTotal()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkTotal Ljava/lang/Integer;
    return-object v0
.end method

.method public final getContextBatchId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchId Ljava/lang/String;
    return-object v0
.end method

.method public final getContextBatchSeq()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchSeq Ljava/lang/Integer;
    return-object v0
.end method

.method public final getContexts()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contexts Ljava/util/List;
    return-object v0
.end method

.method public final getTokenUsageByDisplayType()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->tokenUsageByDisplayType Ljava/util/List;
    return-object v0
.end method

.method public final getUpdatedAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->updatedAt Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contexts Ljava/util/List;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedContextUsage;->updatedAt Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchSeq Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkIndex Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkTotal Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedContextUsage;->tokenUsageByDisplayType Ljava/util/List;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ParsedContextUsage(contexts="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contexts Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", updatedAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedContextUsage;->updatedAt Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", contextBatchId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", contextBatchSeq="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedContextUsage;->contextBatchSeq Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", chunkIndex="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkIndex Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", chunkTotal="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedContextUsage;->chunkTotal Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", tokenUsageByDisplayType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedContextUsage;->tokenUsageByDisplayType Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
