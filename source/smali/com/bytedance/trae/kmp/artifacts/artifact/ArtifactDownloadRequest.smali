# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field public static final $stable:I
.field private final auth:Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
.field private final url:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  com.bytedance.trae.kmp.network.KmpRequestAuth)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "auth"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->url Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.ArtifactDownloadRequest  java.lang.String  com.bytedance.trae.kmp.network.KmpRequestAuth  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.ArtifactDownloadRequest
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->url Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->copy(Ljava/lang/String; Lcom/bytedance/trae/kmp/network/KmpRequestAuth;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->url Ljava/lang/String;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.kmp.network.KmpRequestAuth
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    return-object v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.kmp.network.KmpRequestAuth)com.bytedance.trae.kmp.artifacts.artifact.ArtifactDownloadRequest
    .registers 4
    # ins_size=3
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "auth"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;-><init>(Ljava/lang/String; Lcom/bytedance/trae/kmp/network/KmpRequestAuth;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->url Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->url Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAuth()com.bytedance.trae.kmp.network.KmpRequestAuth
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    return-object v0
.end method

.method public final getUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->url Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->url Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/network/KmpRequestAuth;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ArtifactDownloadRequest(url="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->url Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", auth="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->auth Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
