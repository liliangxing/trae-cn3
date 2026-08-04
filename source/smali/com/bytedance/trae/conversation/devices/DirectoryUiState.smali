# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
.super Ljava/lang/Object;
.source "DirectoryViewModel.kt"

.field private final currentDepth:I
.field private final currentParentId:Ljava/lang/String;
.field private final isRootLoading:Z
.field private final nodes:Ljava/util/List;
.field private final resolvedMode:Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
.field private final title:Ljava/lang/String;


.method public constructor <init>()void
    .registers 10
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 63
    const/4 v8, 0
    move-object v0, v9
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;-><init>(Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  java.lang.String  boolean  java.lang.String  int  com.bytedance.trae.conversation.devices.DirectoryViewModel$Mode)void
    .registers 8
    # ins_size=7
    const-string v0, "nodes"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->nodes Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->title Ljava/lang/String;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->isRootLoading Z
    iput-object v5, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentParentId Ljava/lang/String;
    iput v6, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentDepth I
    iput-object v7, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->resolvedMode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.lang.String  boolean  java.lang.String  int  com.bytedance.trae.conversation.devices.DirectoryViewModel$Mode  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    const-string v6, ""
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    const/4 v0, 0
    if-eqz v6, +004h
    move v1, v0
    goto +2h
    move v1, v7
    and-int/lit8 v6, v11, 8
    const/4 v7, 0
    if-eqz v6, +004h
    move-object v2, v7
    goto +2h
    move-object v2, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +003h
    goto +2h
    move v0, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    move-object v3, v7
    goto +2h
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move v9, v1
    move-object v10, v2
    move v11, v0
    move-object v12, v3
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;-><init>(Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.DirectoryUiState  java.util.List  java.lang.String  boolean  java.lang.String  int  com.bytedance.trae.conversation.devices.DirectoryViewModel$Mode  int  java.lang.Object)com.bytedance.trae.conversation.devices.DirectoryUiState
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->nodes Ljava/util/List;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->title Ljava/lang/String;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-boolean v7, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->isRootLoading Z
    move v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentParentId Ljava/lang/String;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget v9, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentDepth I
    move v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->resolvedMode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move v9, v0
    move-object v10, v1
    move v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy(Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->nodes Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->isRootLoading Z
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentParentId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentDepth I
    return v0
.end method

.method public final component6()com.bytedance.trae.conversation.devices.DirectoryViewModel$Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->resolvedMode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    return-object v0
.end method

.method public final copy(java.util.List  java.lang.String  boolean  java.lang.String  int  com.bytedance.trae.conversation.devices.DirectoryViewModel$Mode)com.bytedance.trae.conversation.devices.DirectoryUiState
    .registers 15
    # ins_size=7
    const-string v0, "nodes"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move v4, v11
    move-object v5, v12
    move v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;-><init>(Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->nodes Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->nodes Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->isRootLoading Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->isRootLoading Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentParentId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentParentId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentDepth I
    iget v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentDepth I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->resolvedMode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->resolvedMode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getCurrentDepth()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentDepth I
    return v0
.end method

.method public final getCurrentParentId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentParentId Ljava/lang/String;
    return-object v0
.end method

.method public final getNodes()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->nodes Ljava/util/List;
    return-object v0
.end method

.method public final getResolvedMode()com.bytedance.trae.conversation.devices.DirectoryViewModel$Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->resolvedMode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->title Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->nodes Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->title Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->isRootLoading Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentParentId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentDepth I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->resolvedMode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isRootLoading()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->isRootLoading Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DirectoryUiState(nodes="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->nodes Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isRootLoading="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->isRootLoading Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", currentParentId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentParentId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", currentDepth="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->currentDepth I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", resolvedMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->resolvedMode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
