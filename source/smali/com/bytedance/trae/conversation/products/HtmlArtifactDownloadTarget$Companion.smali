# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;
.super Ljava/lang/Object;
.source "HtmlArtifactDownloadTarget.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$substringAfterLastPathSeparator(com.bytedance.trae.conversation.products.HtmlArtifactDownloadTarget$Companion  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->substringAfterLastPathSeparator(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final lastPathSeparatorIndex(java.lang.String)int
    .registers 9
    # ins_size=2
    check-cast v8, Ljava/lang/CharSequence;
    const/16 v1, 47
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v8
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v6
    const/16 v1, 92
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v8
    invoke-static v6, v8, Ljava/lang/Math;->max(I I)I
    move-result v8
    return v8
.end method

.method private final normalizePathSeparators(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    const/16 v1, 92
    const/16 v2, 47
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v7
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; C C Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    return-object v7
.end method

.method private final parentPath(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const/4 v0, 2
    new-array v0, v0, [C
    fill-array-data v0, +0000021h
    invoke-static v3, v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->normalizePathSeparators(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->lastPathSeparatorIndex(Ljava/lang/String;)I
    move-result v0
    if-gez v0, +005h
    const-string v3, ""
    return-object v3
    const/4 v1, 0
    invoke-virtual v3, v1, v0, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, substring(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
    nop 
    fill-array-data-payload b'/\x00\\\x00' | \x2f\x00\x5c\x00
.end method

.method private final substringAfterLastPathSeparator(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->lastPathSeparatorIndex(Ljava/lang/String;)I
    move-result v0
    if-gez v0, +003h
    goto +dh
    add-int/lit8 v0, v0, 1
    invoke-virtual v2, v0, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, substring(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method private final toZipSavePath(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    if-nez v0, +004h
    move v0, v1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-object v4
    const-string v0, ".html"
    invoke-static v4, v0, v1, Lkotlin/text/StringsKt;->endsWith(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    const-string v2, ".zip"
    if-eqz v0, +019h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    const/4 v1, 5
    invoke-static v4, v1, Lkotlin/text/StringsKt;->dropLast(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    goto +38h
    const-string v0, ".htm"
    invoke-static v4, v0, v1, Lkotlin/text/StringsKt;->endsWith(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, +019h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    const/4 v1, 4
    invoke-static v4, v1, Lkotlin/text/StringsKt;->dropLast(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    goto +19h
    invoke-static v4, v2, v1, Lkotlin/text/StringsKt;->endsWith(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, +003h
    goto +12h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method public final fromPreviewPath(java.lang.String)com.bytedance.trae.conversation.products.HtmlArtifactDownloadTarget
    .registers 6
    # ins_size=2
    const-string v0, "previewPath"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->parentPath(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->toZipSavePath(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->normalizePathSeparators(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->substringAfterLastPathSeparator(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v5, v1, v2, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method
