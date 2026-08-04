# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/UploadTempFileFactoryKt;
.super Ljava/lang/Object;
.source "UploadTempFileFactory.kt"


.method public static final createUploadTempFile(java.io.File  java.lang.String)java.io.File
    .registers 6
    # ins_size=2
    const-string v0, "cacheDir"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v5, +02bh
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +01fh
    const/4 v0, 1
    new-array v1, v0, [C
    const/4 v2, 0
    const/16 v3, 46
    aput-char v3, v1, v2
    invoke-static v5, v1, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +011h
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v0, v1
    if-eqz v0, +003h
    goto +2h
    const/4 v5, 0
    if-eqz v5, +003h
    goto +3h
    const-string v5, "bin"
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "."
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, upload_
    invoke-static v0, v5, v4, Ljava/io/File;->createTempFile(Ljava/lang/String; Ljava/lang/String; Ljava/io/File;)Ljava/io/File;
    move-result-object v4
    const-string v5, "createTempFile(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method
