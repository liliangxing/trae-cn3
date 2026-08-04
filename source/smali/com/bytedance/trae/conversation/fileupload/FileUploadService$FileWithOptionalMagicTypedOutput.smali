# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;
.super Ljava/lang/Object;
.source "FileUploadService.kt"

.implements Lcom/bytedance/retrofit2/mime/TypedOutput;

.field private final contentType:Ljava/lang/String;
.field private final enableMagic:Z
.field private final file:Ljava/io/File;
.field private final onProgress:Lkotlin/jvm/functions/Function3;
.field private final totalBytes:J
.field private final useV2:Z


.method public constructor <init>(java.io.File  java.lang.String  boolean  boolean  long  kotlin.jvm.functions.Function3)void
    .registers 9
    # ins_size=8
    const-string v0, "file"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "contentType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->file Ljava/io/File;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->contentType Ljava/lang/String;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->enableMagic Z
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->useV2 Z
    iput-wide v6, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->totalBytes J
    iput-object v8, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->onProgress Lkotlin/jvm/functions/Function3;
    return-void 
.end method

.method private final notifyProgress(long)void
    .registers 11
    # ins_size=3
    iget-object v0, v8, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->onProgress Lkotlin/jvm/functions/Function3;
    if-nez v0, +003h
    return-void 
    iget-wide v1, v8, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->totalBytes J
    const-wide/16 v3, 0
    cmp-long v5, v1, v3
    if-lez v5, +003h
    goto +5h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->length()J
    move-result-wide v1
    cmp-long v3, v1, v3
    const/4 v4, 0
    const/16 v5, 100
    if-gtz v3, +004h
    move v3, v4
    goto +5h
    int-to-long v6, v5
    mul-long/2addr v6, v9
    div-long/2addr v6, v1
    long-to-int v3, v6
    invoke-static v3, v4, v5, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-static v9, v10, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v9
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v10
    invoke-interface v0, v3, v9, v10, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public fileName()java.lang.String
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public length()long
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->file Ljava/io/File;
    invoke-virtual v0, Ljava/io/File;->length()J
    move-result-wide v0
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->enableMagic Z
    iget-boolean v3, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->useV2 Z
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->getUploadMagicNumber(Z Z)[B
    move-result-object v2
    array-length v2, v2
    int-to-long v2, v2
    add-long/2addr v0, v2
    return-wide v0
.end method

.method public md5Stub()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, ""
    return-object v0
.end method

.method public mimeType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->contentType Ljava/lang/String;
    return-object v0
.end method

.method public writeTo(java.io.OutputStream)void
    .registers 16
    # ins_size=2
    const-string v0, "out"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v14, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->enableMagic Z
    iget-boolean v1, v14, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->useV2 Z
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->getUploadMagicNumber(Z Z)[B
    move-result-object v0
    array-length v1, v0
    const/4 v2, 1
    const/4 v3, 0
    if-nez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    xor-int/2addr v1, v2
    const-wide/16 v4, 0
    if-eqz v1, +00ch
    invoke-virtual v15, v0, Ljava/io/OutputStream;->write([B)V
    array-length v0, v0
    int-to-long v0, v0
    add-long/2addr v0, v4
    invoke-direct v14, v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->notifyProgress(J)V
    goto +2h
    move-wide v0, v4
    new-instance v2, Ljava/io/FileInputStream;
    iget-object v6, v14, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->file Ljava/io/File;
    invoke-direct v2, v6, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    check-cast v2, Ljava/io/Closeable;
    move-object v6, v2
    check-cast v6, Ljava/io/FileInputStream;
    const/16 v7, 8192
    new-array v7, v7, [B
    invoke-virtual v6, v7, Ljava/io/FileInputStream;->read([B)I
    move-result v8
    if-lez v8, +031h
    iget-boolean v9, v14, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->useV2 Z
    if-eqz v9, +024h
    iget-boolean v9, v14, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->enableMagic Z
    if-eqz v9, +020h
    move v9, v3
    if-ge v9, v8, +01dh
    aget-byte v10, v7, v9
    invoke-static Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->getTRAE_XOR_KEY_V2()[B
    move-result-object v11
    invoke-static Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->getTRAE_XOR_KEY_V2()[B
    move-result-object v12
    array-length v12, v12
    int-to-long v12, v12
    rem-long v12, v4, v12
    long-to-int v12, v12
    aget-byte v11, v11, v12
    xor-int/2addr v10, v11
    int-to-byte v10, v10
    aput-byte v10, v7, v9
    const-wide/16 v10, 1
    add-long/2addr v4, v10
    add-int/lit8 v9, v9, 1
    goto -1ch
    invoke-virtual v15, v7, v3, v8, Ljava/io/OutputStream;->write([B I I)V
    int-to-long v8, v8
    add-long/2addr v0, v8
    invoke-direct v14, v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;->notifyProgress(J)V
    goto -34h
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v15, 0
    invoke-static v2, v15, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-void 
    move-exception v15
    throw v15
    move-exception v0
    invoke-static v2, v15, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v0
    :try_start_0x2e
    :try_start_0x72
.end method
