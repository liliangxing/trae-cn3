# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
.super Ljava/lang/Object;
.source "ImageUploadModels.kt"

.field private final errorCode:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field private final errorMessage:Ljava/lang/String;
.field private final valid:Z


.method public constructor <init>(boolean  java.lang.String  com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->valid Z
    iput-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorMessage Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorCode Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    return-void 
.end method

.method public synthetic constructor <init>(boolean  java.lang.String  com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 2
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.imageupload.FileValidationResult  boolean  java.lang.String  com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode  int  java.lang.Object)com.bytedance.trae.conversation.imageupload.FileValidationResult
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->valid Z
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorMessage Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorCode Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->copy(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->valid Z
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorMessage Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorCode Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    return-object v0
.end method

.method public final copy(boolean  java.lang.String  com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode)com.bytedance.trae.conversation.imageupload.FileValidationResult
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->valid Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->valid Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorMessage Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorMessage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorCode Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorCode Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getErrorCode()com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorCode Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    return-object v0
.end method

.method public final getErrorMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getValid()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->valid Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->valid Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorMessage Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorCode Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "FileValidationResult(valid="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->valid Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorMessage Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorCode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->errorCode Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
