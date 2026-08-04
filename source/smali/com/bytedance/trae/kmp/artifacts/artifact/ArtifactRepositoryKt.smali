# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepositoryKt;
.super Ljava/lang/Object;
.source "ArtifactRepository.kt"


.method public static final synthetic access$extensionSuffix(java.lang.String)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepositoryKt;->extensionSuffix(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final extensionSuffix(java.lang.String)java.lang.String
    .registers 6
    # ins_size=1
    const/4 v0, 2
    const/16 v1, 47
    const/4 v2, 0
    invoke-static v5, v1, v2, v0, v2, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    const/16 v0, 46
    const-string v1, ""
    invoke-static v5, v0, v1, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v3, 1
    xor-int/2addr v0, v3
    if-eqz v0, +00bh
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v0
    const/16 v4, 12
    if-gt v0, v4, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    goto +2h
    move-object v5, v2
    if-eqz v5, +011h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "."
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v1, v2
    return-object v1
.end method
