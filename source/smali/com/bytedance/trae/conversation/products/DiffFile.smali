# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/DiffFile;
.super Ljava/lang/Object;
.source "DiffFile.kt"

.field private final deleteLineCount:I
.field private final insertLineCount:I
.field private final isBinary:Z
.field private final isConflict:Z
.field private final newContent:Ljava/lang/String;
.field private final newPath:Ljava/lang/String;
.field private final oldContent:Ljava/lang/String;
.field private final oldPath:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  int  int  java.lang.String  java.lang.String  boolean  boolean)void
    .registers 10
    # ins_size=9
    const-string v0, "newPath"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "oldContent"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newContent"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->oldPath Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    iput v4, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->insertLineCount I
    iput v5, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->deleteLineCount I
    iput-object v6, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->oldContent Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->newContent Ljava/lang/String;
    iput-boolean v8, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->isBinary Z
    iput-boolean v9, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->isConflict Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  int  int  java.lang.String  java.lang.String  boolean  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 23
    # ins_size=11
    move/from16 v0, v21
    and-int/lit8 v1, v0, 16
    const-string v2, ""
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v17
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v18
    and-int/lit8 v1, v0, 64
    const/4 v2, 0
    if-eqz v1, +004h
    move v10, v2
    goto +3h
    move/from16 v10, v19
    and-int/lit16 v0, v0, 128
    if-eqz v0, +004h
    move v11, v2
    goto +3h
    move/from16 v11, v20
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move v6, v15
    move/from16 v7, v16
    invoke-direct/range v3 ... v11, Lcom/bytedance/trae/conversation/products/DiffFile;-><init>(Ljava/lang/String; Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Z Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.products.DiffFile  java.lang.String  java.lang.String  int  int  java.lang.String  java.lang.String  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.products.DiffFile
    .registers 20
    # ins_size=11
    move-object v0, v9
    move/from16 v1, v18
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/DiffFile;->oldPath Ljava/lang/String;
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/conversation/products/DiffFile;->insertLineCount I
    goto +2h
    move v4, v12
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/conversation/products/DiffFile;->deleteLineCount I
    goto +2h
    move v5, v13
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/products/DiffFile;->oldContent Ljava/lang/String;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/products/DiffFile;->newContent Ljava/lang/String;
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/conversation/products/DiffFile;->isBinary Z
    goto +3h
    move/from16 v8, v16
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/products/DiffFile;->isConflict Z
    goto +3h
    move/from16 v1, v17
    move-object v10, v2
    move-object v11, v3
    move v12, v4
    move v13, v5
    move-object v14, v6
    move-object v15, v7
    move/from16 v16, v8
    move/from16 v17, v1
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/products/DiffFile;->copy(Ljava/lang/String; Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/products/DiffFile;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->oldPath Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    return-object v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->insertLineCount I
    return v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->deleteLineCount I
    return v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->oldContent Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->newContent Ljava/lang/String;
    return-object v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->isBinary Z
    return v0
.end method

.method public final component8()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->isConflict Z
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  int  int  java.lang.String  java.lang.String  boolean  boolean)com.bytedance.trae.conversation.products.DiffFile
    .registers 19
    # ins_size=9
    const-string v0, "newPath"
    move-object v3, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "oldContent"
    move-object v6, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newContent"
    move-object/from16 v7, v16
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/DiffFile;
    move-object v1, v0
    move-object v2, v11
    move v4, v13
    move v5, v14
    move/from16 v8, v17
    move/from16 v9, v18
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/products/DiffFile;-><init>(Ljava/lang/String; Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/products/DiffFile;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/products/DiffFile;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/DiffFile;->oldPath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/DiffFile;->oldPath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/products/DiffFile;->insertLineCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/products/DiffFile;->insertLineCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/products/DiffFile;->deleteLineCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/products/DiffFile;->deleteLineCount I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/DiffFile;->oldContent Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/DiffFile;->oldContent Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/DiffFile;->newContent Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/DiffFile;->newContent Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/products/DiffFile;->isBinary Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/products/DiffFile;->isBinary Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/products/DiffFile;->isConflict Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/products/DiffFile;->isConflict Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getDeleteLineCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->deleteLineCount I
    return v0
.end method

.method public final getInsertLineCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->insertLineCount I
    return v0
.end method

.method public final getNewContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->newContent Ljava/lang/String;
    return-object v0
.end method

.method public final getNewPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    return-object v0
.end method

.method public final getOldContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->oldContent Ljava/lang/String;
    return-object v0
.end method

.method public final getOldPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->oldPath Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->oldPath Ljava/lang/String;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->insertLineCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->deleteLineCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->oldContent Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->newContent Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->isBinary Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->isConflict Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isBinary()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->isBinary Z
    return v0
.end method

.method public final isConflict()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->isConflict Z
    return v0
.end method

.method public final isNewFile()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffFile;->oldPath Ljava/lang/String;
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DiffFile(oldPath="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->oldPath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", newPath="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", insertLineCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->insertLineCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deleteLineCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->deleteLineCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", oldContent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->oldContent Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", newContent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->newContent Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isBinary="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->isBinary Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isConflict="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/DiffFile;->isConflict Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final toUnifiedDiff()java.lang.String
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/DiffFile;->oldPath Ljava/lang/String;
    const-string v1, "/dev/null"
    if-nez v0, +003h
    move-object v0, v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/DiffFile;->isNewFile()Z
    move-result v2
    if-eqz v2, +005h
    const-string v2, ""
    goto +3h
    const-string v2, "a/"
    iget-boolean v3, v9, Lcom/bytedance/trae/conversation/products/DiffFile;->isBinary Z
    const-string v4, " b/"
    if-eqz v3, +046h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "
                |diff --git "
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v3, v9, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, "
                |Binary files "
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " and b/"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v9, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " differ
            "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    invoke-static v0, v2, v1, v2, Lkotlin/text/StringsKt;->trimMargin$default(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    return-object v0
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/DiffFile;->isNewFile()Z
    move-result v3
    if-eqz v3, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    goto +9h
    iget-object v3, v9, Lcom/bytedance/trae/conversation/products/DiffFile;->oldContent Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->lines(Ljava/lang/CharSequence;)Ljava/util/List;
    move-result-object v3
    iget-object v5, v9, Lcom/bytedance/trae/conversation/products/DiffFile;->newContent Ljava/lang/String;
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->lines(Ljava/lang/CharSequence;)Ljava/util/List;
    move-result-object v5
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "diff --git "
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v7, v9, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v7, 10
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/DiffFile;->isNewFile()Z
    move-result v4
    if-eqz v4, +007h
    const-string v4, "new file mode 100644
"
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v8, "--- "
    invoke-direct v4, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/DiffFile;->isNewFile()Z
    move-result v8
    if-eqz v8, +003h
    goto +12h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "+++ b/"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v9, Lcom/bytedance/trae/conversation/products/DiffFile;->newPath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "@@ -"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/DiffFile;->isNewFile()Z
    move-result v1
    if-eqz v1, +005h
    const-string v1, "0,0"
    goto +14h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "1,"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " +1,"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " @@"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01fh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "-"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto -22h
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01fh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "+"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto -22h
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toString(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method
