# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;
.super Ljava/lang/Object;
.source "MergeDiffManager.kt"

.field private final diffFiles:Ljava/util/List;
.field private final sourceBranch:Ljava/lang/String;
.field private final targetBranch:Ljava/lang/String;
.field private final taskName:Ljava/lang/String;
.field private final totalDeleteLineCount:I
.field private final totalInsertLineCount:I


.method public constructor <init>(java.util.List  java.lang.String  int  int  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=7
    const-string v0, "diffFiles"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskName
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sourceBranch
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, targetBranch
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->diffFiles Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->taskName Ljava/lang/String;
    iput v4, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalInsertLineCount I
    iput v5, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalDeleteLineCount I
    iput-object v6, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->sourceBranch Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->targetBranch Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.products.MergeDiffManager$MergeDiffResult  java.util.List  java.lang.String  int  int  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.products.MergeDiffManager$MergeDiffResult
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->diffFiles Ljava/util/List;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->taskName Ljava/lang/String;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget v7, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalInsertLineCount I
    move v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget v8, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalDeleteLineCount I
    move v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->sourceBranch Ljava/lang/String;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->targetBranch Ljava/lang/String;
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move v9, v0
    move v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->copy(Ljava/util/List; Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->diffFiles Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->taskName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalInsertLineCount I
    return v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalDeleteLineCount I
    return v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->sourceBranch Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->targetBranch Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.util.List  java.lang.String  int  int  java.lang.String  java.lang.String)com.bytedance.trae.conversation.products.MergeDiffManager$MergeDiffResult
    .registers 15
    # ins_size=7
    const-string v0, "diffFiles"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskName
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sourceBranch
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, targetBranch
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move v4, v11
    move v5, v12
    move-object v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;-><init>(Ljava/util/List; Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->diffFiles Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->diffFiles Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->taskName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->taskName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalInsertLineCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalInsertLineCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalDeleteLineCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalDeleteLineCount I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->sourceBranch Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->sourceBranch Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->targetBranch Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->targetBranch Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDiffFiles()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->diffFiles Ljava/util/List;
    return-object v0
.end method

.method public final getSourceBranch()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->sourceBranch Ljava/lang/String;
    return-object v0
.end method

.method public final getTargetBranch()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->targetBranch Ljava/lang/String;
    return-object v0
.end method

.method public final getTaskName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->taskName Ljava/lang/String;
    return-object v0
.end method

.method public final getTotalDeleteLineCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalDeleteLineCount I
    return v0
.end method

.method public final getTotalInsertLineCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalInsertLineCount I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->diffFiles Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->taskName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalInsertLineCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalDeleteLineCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->sourceBranch Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->targetBranch Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "MergeDiffResult(diffFiles="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->diffFiles Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->taskName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", totalInsertLineCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalInsertLineCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", totalDeleteLineCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->totalDeleteLineCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sourceBranch="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->sourceBranch Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", targetBranch="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->targetBranch Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
