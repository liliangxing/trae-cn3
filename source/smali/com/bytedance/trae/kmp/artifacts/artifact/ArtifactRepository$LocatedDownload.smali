# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;
.super Ljava/lang/Object;
.source "ArtifactRepository.kt"

.field private final auth:Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
.field private final headers:Ljava/util/Map;
.field private final url:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.util.Map  com.bytedance.trae.kmp.artifact.KmpBinaryAuth)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headers"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "auth"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->url Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->headers Ljava/util/Map;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->auth Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.util.Map  com.bytedance.trae.kmp.artifact.KmpBinaryAuth  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    sget-object v3, Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;->None Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;-><init>(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$LocatedDownload  java.lang.String  java.util.Map  com.bytedance.trae.kmp.artifact.KmpBinaryAuth  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$LocatedDownload
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->url Ljava/lang/String;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->headers Ljava/util/Map;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->auth Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->copy(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->url Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.kmp.artifact.KmpBinaryAuth
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->auth Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    return-object v0
.end method

.method public final copy(java.lang.String  java.util.Map  com.bytedance.trae.kmp.artifact.KmpBinaryAuth)com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$LocatedDownload
    .registers 5
    # ins_size=4
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headers"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "auth"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;-><init>(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->url Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->url Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->headers Ljava/util/Map;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->headers Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->auth Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->auth Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAuth()com.bytedance.trae.kmp.artifact.KmpBinaryAuth
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->auth Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    return-object v0
.end method

.method public final getHeaders()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final getUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->url Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->url Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->headers Ljava/util/Map;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->auth Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "LocatedDownload(url="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->url Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", headers="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->headers Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", auth="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->auth Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
