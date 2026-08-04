# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;


.method public static synthetic $r8$lambda$0JcBxYBJaoujTbTlRKjRPSxxjjQ(java.lang.String)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;->remoteDownloadRequest$lambda$0(Ljava/lang/String;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$2NlVBNDon7Cu-UUo397BblgLhuA(byte)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;->encodePathSegment$lambda$2(B)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final encodePathSegment(java.lang.String)java.lang.String
    .registers 11
    # ins_size=2
    invoke-static v10, Lkotlin/text/StringsKt;->encodeToByteArray(Ljava/lang/String;)[B
    move-result-object v0
    const-string v10, ""
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    new-instance v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator$$ExternalSyntheticLambda1;
    invoke-direct v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator$$ExternalSyntheticLambda1;-><init>()V
    const/16 v7, 30
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/ArraysKt;->joinToString$default([B Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method private static final encodePathSegment$lambda$2(byte)java.lang.CharSequence
    .registers 5
    # ins_size=1
    and-int/lit16 v4, v4, 255
    const/16 v0, 97
    const/4 v1, 1
    const/4 v2, 0
    if-gt v0, v4, +008h
    const/16 v0, 123
    if-ge v4, v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +05fh
    const/16 v0, 65
    if-gt v0, v4, +008h
    const/16 v0, 91
    if-ge v4, v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +052h
    const/16 v0, 48
    if-gt v0, v4, +007h
    const/16 v3, 58
    if-ge v4, v3, +003h
    goto +2h
    move v1, v2
    if-nez v1, +046h
    const/16 v1, 45
    if-eq v4, v1, +042h
    const/16 v1, 95
    if-eq v4, v1, +03eh
    const/16 v1, 46
    if-eq v4, v1, +03ah
    const/16 v1, 126
    if-ne v4, v1, +003h
    goto +34h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "%"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const/16 v2, 16
    invoke-static v2, Lkotlin/text/CharsKt;->checkRadix(I)I
    move-result v2
    invoke-static v4, v2, Ljava/lang/Integer;->toString(I I)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v2, toString(...)
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v2, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v2, toUpperCase(...)
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 2
    invoke-static v4, v2, v0, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String; I C)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    goto +8h
    int-to-char v4, v4
    invoke-static v4, Ljava/lang/String;->valueOf(C)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    return-object v4
.end method

.method private static final remoteDownloadRequest$lambda$0(java.lang.String)java.lang.CharSequence
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;->encodePathSegment(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    return-object v1
.end method

.method public final localTarget(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, "filePath"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "/"
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v3, v0, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v3
    const-string v0, "files/"
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v3, v1, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v3
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final normalizeRemotePath(java.lang.String  java.lang.String)java.lang.String
    .registers 8
    # ins_size=3
    const-string v0, "filePath"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v0, 47
    const/4 v1, 0
    const/4 v2, 0
    if-eqz v7, +018h
    const/4 v3, 1
    new-array v4, v3, [C
    aput-char v0, v4, v1
    invoke-static v7, v4, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v7
    if-eqz v7, +00dh
    move-object v4, v7
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v3, v4
    if-eqz v3, +003h
    goto +2h
    move-object v7, v2
    if-eqz v7, +02ah
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    const-string v6, ""
    return-object v6
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const/4 v0, 2
    invoke-static v6, v7, v1, v0, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +009h
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v6, v7, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v6
    return-object v6
    const-string v7, "/"
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v6, v7, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method

.method public final remoteDownloadRequest(java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.kmp.artifacts.artifact.ArtifactDownloadRequest
    .registers 24
    # ins_size=4
    move-object/from16 v0, v21
    move-object/from16 v1, v23
    const-string v2, "explorerUrl"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "filePath"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v2, v20
    move-object/from16 v3, v22
    invoke-virtual v2, v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;->normalizeRemotePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v1, 1
    new-array v4, v1, [C
    const/4 v9, 0
    const/16 v10, 47
    aput-char v10, v4, v9
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [C Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +01ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Ljava/lang/String;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    move v6, v1
    goto +2h
    move v6, v9
    if-eqz v6, -018h
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v4, Ljava/util/List;
    move-object v11, v4
    check-cast v11, Ljava/lang/Iterable;
    const-string v3, "/"
    move-object v12, v3
    check-cast v12, Ljava/lang/CharSequence;
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    new-instance v17, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator$$ExternalSyntheticLambda0;
    invoke-direct/range v17, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator$$ExternalSyntheticLambda0;-><init>()V
    const/16 v18, 30
    const/16 v19, 0
    invoke-static/range v11 ... v19, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    new-array v1, v1, [C
    aput-char v10, v1, v9
    invoke-static v0, v1, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "/file/"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "?download=true"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/kmp/network/KmpRequestAuth;->CloudIdeJwtAuthorization Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;-><init>(Ljava/lang/String; Lcom/bytedance/trae/kmp/network/KmpRequestAuth;)V
    return-object v4
.end method
