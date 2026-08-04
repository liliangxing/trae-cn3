# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/CliListRefreshResult;
.super Ljava/lang/Object;
.source "CliListRepository.kt"

.field private final clis:Ljava/util/List;
.field private final isSuccess:Z


.method public constructor <init>(java.util.List  boolean)void
    .registers 4
    # ins_size=3
    const-string v0, "clis"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRefreshResult;->clis Ljava/util/List;
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/CliListRefreshResult;->isSuccess Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.CliListRefreshResult  java.util.List  boolean  int  java.lang.Object)com.bytedance.trae.conversation.CliListRefreshResult
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/CliListRefreshResult;->clis Ljava/util/List;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/CliListRefreshResult;->isSuccess Z
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/CliListRefreshResult;->copy(Ljava/util/List; Z)Lcom/bytedance/trae/conversation/CliListRefreshResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CliListRefreshResult;->clis Ljava/util/List;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/CliListRefreshResult;->isSuccess Z
    return v0
.end method

.method public final copy(java.util.List  boolean)com.bytedance.trae.conversation.CliListRefreshResult
    .registers 4
    # ins_size=3
    const-string v0, "clis"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRefreshResult;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/CliListRefreshResult;-><init>(Ljava/util/List; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/CliListRefreshResult;->clis Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;->clis Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/CliListRefreshResult;->isSuccess Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;->isSuccess Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getClis()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CliListRefreshResult;->clis Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/CliListRefreshResult;->clis Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/CliListRefreshResult;->isSuccess Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isSuccess()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/CliListRefreshResult;->isSuccess Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CliListRefreshResult(clis="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/CliListRefreshResult;->clis Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSuccess="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/CliListRefreshResult;->isSuccess Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
