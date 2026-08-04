# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;
.super Ljava/lang/Object;
.source "FileUploadService.kt"

.field private final code:I
.field private final errorText:Ljava/lang/String;
.field private final headersText:Ljava/lang/String;
.field private final isSuccessful:Z
.field private final message:Ljava/lang/String;


.method public constructor <init>(int  boolean  java.lang.String  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=6
    const-string v0, "message"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "errorText"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headersText"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->code I
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful Z
    iput-object v4, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->message Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->errorText Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->headersText Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(int  boolean  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 4
    const-string v0, ""
    if-eqz v14, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v10
    and-int/lit8 v10, v13, 16
    if-eqz v10, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move v2, v8
    move v3, v9
    move-object v5, v11
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;-><init>(I Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.fileupload.FileUploadService$ObjectStorePutResult  int  boolean  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.FileUploadService$ObjectStorePutResult
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget v4, v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->code I
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-boolean v5, v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful Z
    move v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->message Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->errorText Ljava/lang/String;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->headersText Ljava/lang/String;
    move-object v2, v8
    move-object v5, v3
    move v6, v4
    move v7, v10
    move-object v8, v0
    move-object v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->copy(I Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;
    move-result-object v3
    return-object v3
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->code I
    return v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful Z
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->errorText Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->headersText Ljava/lang/String;
    return-object v0
.end method

.method public final copy(int  boolean  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.fileupload.FileUploadService$ObjectStorePutResult
    .registers 13
    # ins_size=6
    const-string v0, "message"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "errorText"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headersText"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;
    move-object v1, v0
    move v2, v8
    move v3, v9
    move-object v4, v10
    move-object v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;-><init>(I Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;
    iget v1, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->code I
    iget v3, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->code I
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->errorText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->errorText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->headersText Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->headersText Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->code I
    return v0
.end method

.method public final getErrorText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->errorText Ljava/lang/String;
    return-object v0
.end method

.method public final getHeadersText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->headersText Ljava/lang/String;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->message Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->code I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->message Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->errorText Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->headersText Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isSuccessful()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ObjectStorePutResult(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->code I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSuccessful="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorText="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->errorText Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", headersText="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->headersText Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
