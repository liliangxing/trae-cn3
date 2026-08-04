# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;
.super Ljava/lang/Object;
.source "FinishCardResult.kt"

.field private final changedFilesCount:Ljava/lang/Integer;
.field private final conflictCount:Ljava/lang/Integer;
.field private final deleteLineCount:Ljava/lang/Integer;
.field private final insertLineCount:Ljava/lang/Integer;


.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->insertLineCount Ljava/lang/Integer;
    iput-object v2, v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->deleteLineCount Ljava/lang/Integer;
    iput-object v3, v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->conflictCount Ljava/lang/Integer;
    iput-object v4, v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->changedFilesCount Ljava/lang/Integer;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v2, v0
    and-int/lit8 v7, v6, 2
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.model.MergeTotalDiffInfo  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  int  java.lang.Object)com.bytedance.trae.im.model.MergeTotalDiffInfo
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->insertLineCount Ljava/lang/Integer;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->deleteLineCount Ljava/lang/Integer;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->conflictCount Ljava/lang/Integer;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->changedFilesCount Ljava/lang/Integer;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->copy(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer;)Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->insertLineCount Ljava/lang/Integer;
    return-object v0
.end method

.method public final component2()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->deleteLineCount Ljava/lang/Integer;
    return-object v0
.end method

.method public final component3()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->conflictCount Ljava/lang/Integer;
    return-object v0
.end method

.method public final component4()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->changedFilesCount Ljava/lang/Integer;
    return-object v0
.end method

.method public final copy(java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer)com.bytedance.trae.im.model.MergeTotalDiffInfo
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;
    iget-object v1, v4, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->insertLineCount Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->insertLineCount Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->deleteLineCount Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->deleteLineCount Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->conflictCount Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->conflictCount Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->changedFilesCount Ljava/lang/Integer;
    iget-object v5, v5, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->changedFilesCount Ljava/lang/Integer;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getChangedFilesCount()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->changedFilesCount Ljava/lang/Integer;
    return-object v0
.end method

.method public final getConflictCount()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->conflictCount Ljava/lang/Integer;
    return-object v0
.end method

.method public final getDeleteLineCount()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->deleteLineCount Ljava/lang/Integer;
    return-object v0
.end method

.method public final getInsertLineCount()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->insertLineCount Ljava/lang/Integer;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->insertLineCount Ljava/lang/Integer;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->deleteLineCount Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->conflictCount Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->changedFilesCount Ljava/lang/Integer;
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
    const-string v1, "MergeTotalDiffInfo(insertLineCount="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->insertLineCount Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deleteLineCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->deleteLineCount Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conflictCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->conflictCount Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", changedFilesCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->changedFilesCount Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
