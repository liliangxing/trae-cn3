# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;
.super Ljava/lang/Object;
.source "HtmlArtifactEntryResolver.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final substringAfterLastPathSeparator(java.lang.String)java.lang.String
    .registers 10
    # ins_size=2
    move-object v6, v9
    check-cast v6, Ljava/lang/CharSequence;
    const/16 v1, 47
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v7
    const/16 v1, 92
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v0
    invoke-static v7, v0, Ljava/lang/Math;->max(I I)I
    move-result v0
    if-gez v0, +003h
    goto +dh
    add-int/lit8 v0, v0, 1
    invoke-virtual v9, v0, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v9
    const-string/jumbo v0, substring(...)
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v9
.end method

.method public final findEntryHtml(java.io.File  java.lang.String)java.io.File
    .registers 10
    # ins_size=3
    const-string v0, "extractDir"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "artifactPath"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;->substringAfterLastPathSeparator(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    const-string v0, ".html"
    const/4 v1, 1
    invoke-static v9, v0, v1, Lkotlin/text/StringsKt;->endsWith(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    const/4 v2, 0
    if-eqz v0, +003h
    goto +2h
    move-object v9, v2
    move-object v0, v9
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v3, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v3
    goto +2h
    move v0, v1
    if-nez v0, +041h
    new-instance v0, Ljava/io/File;
    invoke-direct v0, v8, v9, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/io/File;->isFile()Z
    move-result v4
    if-eqz v4, +003h
    return-object v0
    invoke-static v8, v2, v1, v2, Lkotlin/io/FilesKt;->walk$default(Ljava/io/File; Lkotlin/io/FileWalkDirection; I Ljava/lang/Object;)Lkotlin/io/FileTreeWalk;
    move-result-object v0
    check-cast v0, Lkotlin/sequences/Sequence;
    invoke-interface v0, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01fh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/io/File;
    invoke-virtual v5, Ljava/io/File;->isFile()Z
    move-result v6
    if-eqz v6, +00eh
    invoke-virtual v5, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +004h
    move v5, v1
    goto +2h
    move v5, v3
    if-eqz v5, -020h
    goto +2h
    move-object v4, v2
    check-cast v4, Ljava/io/File;
    if-eqz v4, +003h
    return-object v4
    new-instance v9, Ljava/io/File;
    const-string v0, "index.html"
    invoke-direct v9, v8, v0, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v9, Ljava/io/File;->isFile()Z
    move-result v4
    if-eqz v4, +003h
    return-object v9
    invoke-static v8, v2, v1, v2, Lkotlin/io/FilesKt;->walk$default(Ljava/io/File; Lkotlin/io/FileWalkDirection; I Ljava/lang/Object;)Lkotlin/io/FileTreeWalk;
    move-result-object v8
    check-cast v8, Lkotlin/sequences/Sequence;
    invoke-interface v8, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +01fh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    move-object v4, v9
    check-cast v4, Ljava/io/File;
    invoke-virtual v4, Ljava/io/File;->isFile()Z
    move-result v5
    if-eqz v5, +00eh
    invoke-virtual v4, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    move v4, v1
    goto +2h
    move v4, v3
    if-eqz v4, -020h
    move-object v2, v9
    check-cast v2, Ljava/io/File;
    return-object v2
.end method
