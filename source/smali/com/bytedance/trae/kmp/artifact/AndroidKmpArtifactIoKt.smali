# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactIoKt;
.super Ljava/lang/Object;
.source "AndroidKmpArtifactIo.kt"


.method public static final configureAndroidKmpArtifactIo(android.content.Context)void
    .registers 5
    # ins_size=1
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v4, v0
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;
    new-instance v1, Ljava/io/File;
    invoke-virtual v4, Landroid/content/Context;->getCacheDir()Ljava/io/File;
    move-result-object v2
    const-string v3, "kmp-artifacts"
    invoke-direct v1, v2, v3, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;-><init>(Ljava/io/File;)V
    sget-object v1, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->INSTANCE Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;
    new-instance v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;
    invoke-direct v2, v4, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;-><init>(Landroid/content/Context; Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;)V
    check-cast v2, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->configure(Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient; Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;)V
    return-void 
.end method

.method public static final resolveForDownload(com.bytedance.trae.kmp.artifact.AndroidKmpArtifactFileSystem  com.bytedance.trae.kmp.artifact.KmpFileReference)java.io.File
    .registers 3
    # ins_size=2
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "file"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->localUri(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/lang/String;
    move-result-object v1
    new-instance v2, Ljava/io/File;
    new-instance v0, Ljava/net/URI;
    invoke-direct v0, v1, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    invoke-direct v2, v0, Ljava/io/File;-><init>(Ljava/net/URI;)V
    return-object v2
.end method
