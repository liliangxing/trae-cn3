# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/CompressionResult;
.super Ljava/lang/Object;
.source "ImageUploadModels.kt"

.field private final compressedSize:J
.field private final file:Ljava/io/File;
.field private final height:I
.field private final originalSize:J
.field private final wasCompressed:Z
.field private final width:I


.method public constructor <init>(java.io.File  int  int  long  long  boolean)void
    .registers 10
    # ins_size=9
    const-string v0, "file"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->file Ljava/io/File;
    iput v3, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->width I
    iput v4, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->height I
    iput-wide v5, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->originalSize J
    iput-wide v7, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->compressedSize J
    iput-boolean v9, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->wasCompressed Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.imageupload.CompressionResult  java.io.File  int  int  long  long  boolean  int  java.lang.Object)com.bytedance.trae.conversation.imageupload.CompressionResult
    .registers 20
    # ins_size=11
    move-object v0, v9
    and-int/lit8 v1, v18, 1
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->file Ljava/io/File;
    goto +2h
    move-object v1, v10
    and-int/lit8 v2, v18, 2
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->width I
    goto +2h
    move v2, v11
    and-int/lit8 v3, v18, 4
    if-eqz v3, +005h
    iget v3, v0, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->height I
    goto +2h
    move v3, v12
    and-int/lit8 v4, v18, 8
    if-eqz v4, +005h
    iget-wide v4, v0, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->originalSize J
    goto +2h
    move-wide v4, v13
    and-int/lit8 v6, v18, 16
    if-eqz v6, +005h
    iget-wide v6, v0, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->compressedSize J
    goto +2h
    move-wide v6, v15
    and-int/lit8 v8, v18, 32
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->wasCompressed Z
    goto +3h
    move/from16 v8, v17
    move-object v10, v1
    move v11, v2
    move v12, v3
    move-wide v13, v4
    move-wide v15, v6
    move/from16 v17, v8
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->copy(Ljava/io/File; I I J J Z)Lcom/bytedance/trae/conversation/imageupload/CompressionResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.io.File
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->file Ljava/io/File;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->width I
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->height I
    return v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->originalSize J
    return-wide v0
.end method

.method public final component5()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->compressedSize J
    return-wide v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->wasCompressed Z
    return v0
.end method

.method public final copy(java.io.File  int  int  long  long  boolean)com.bytedance.trae.conversation.imageupload.CompressionResult
    .registers 19
    # ins_size=9
    const-string v0, "file"
    move-object v2, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;
    move-object v1, v0
    move v3, v12
    move v4, v13
    move-wide v5, v14
    move-wide/from16 v7, v16
    move/from16 v9, v18
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;-><init>(Ljava/io/File; I I J J Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->file Ljava/io/File;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->file Ljava/io/File;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->width I
    iget v3, v8, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->width I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->height I
    iget v3, v8, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->height I
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->originalSize J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->originalSize J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->compressedSize J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->compressedSize J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->wasCompressed Z
    iget-boolean v8, v8, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->wasCompressed Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getCompressedSize()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->compressedSize J
    return-wide v0
.end method

.method public final getFile()java.io.File
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->file Ljava/io/File;
    return-object v0
.end method

.method public final getHeight()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->height I
    return v0
.end method

.method public final getOriginalSize()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->originalSize J
    return-wide v0
.end method

.method public final getWasCompressed()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->wasCompressed Z
    return v0
.end method

.method public final getWidth()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->width I
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->file Ljava/io/File;
    invoke-virtual v0, Ljava/io/File;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->width I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->height I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->originalSize J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->compressedSize J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->wasCompressed Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CompressionResult(file="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->file Ljava/io/File;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", width="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->width I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", height="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->height I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", originalSize="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->originalSize J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", compressedSize="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->compressedSize J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", wasCompressed="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->wasCompressed Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
