# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModelKt;
.super Ljava/lang/Object;
.source "VideoArtifactPreviewViewModel.kt"


.method public static final synthetic access$isLocalMediaSource(java.lang.String)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModelKt;->isLocalMediaSource(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method private static final isLocalMediaSource(java.lang.String)boolean
    .registers 5
    # ins_size=1
    const-string v0, "file:"
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v4, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00ah
    const-string v0, "/"
    invoke-static v4, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    const/4 v1, 1
    return v1
.end method
