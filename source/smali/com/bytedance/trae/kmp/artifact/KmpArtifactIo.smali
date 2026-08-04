# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;
.super Ljava/lang/Object;
.source "KmpArtifactIo.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;
.field private static artifactFileSystem:Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
.field private static binaryDownloadClient:Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->INSTANCE Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final binaryDownloadClient()com.bytedance.trae.kmp.artifact.KmpBinaryDownloadClient
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->binaryDownloadClient Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;
    if-eqz v0, +003h
    return-object v0
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "KmpArtifactIo binary download client is not configured"
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public final configure(com.bytedance.trae.kmp.artifact.KmpBinaryDownloadClient  com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem)void
    .registers 4
    # ins_size=3
    const-string v0, "binaryDownloadClient"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "artifactFileSystem"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->binaryDownloadClient Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;
    sput-object v3, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->artifactFileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    return-void 
.end method

.method public final fileSystem()com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->artifactFileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    if-eqz v0, +003h
    return-object v0
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "KmpArtifactIo filesystem is not configured"
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
