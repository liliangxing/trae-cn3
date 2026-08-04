# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;
.super Ljava/lang/Object;
.source "KmpArtifactIo.kt"

.field public static final $stable:I
.field private final errorMessage:Ljava/lang/String;
.field private final file:Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
.field private final headers:Ljava/util/Map;
.field private final statusCode:I


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.artifact.KmpFileReference  int  java.util.Map  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "headers"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iput v3, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->statusCode I
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->headers Ljava/util/Map;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->errorMessage Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.artifact.KmpFileReference  int  java.util.Map  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v3
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;-><init>(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; I Ljava/util/Map; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifact.KmpBinaryDownloadResult  com.bytedance.trae.kmp.artifact.KmpFileReference  int  java.util.Map  java.lang.String  int  java.lang.Object)com.bytedance.trae.kmp.artifact.KmpBinaryDownloadResult
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget v2, v0, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->statusCode I
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->headers Ljava/util/Map;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->errorMessage Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->copy(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; I Ljava/util/Map; Ljava/lang/String;)Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.kmp.artifact.KmpFileReference
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->statusCode I
    return v0
.end method

.method public final component3()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->errorMessage Ljava/lang/String;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.kmp.artifact.KmpFileReference  int  java.util.Map  java.lang.String)com.bytedance.trae.kmp.artifact.KmpBinaryDownloadResult
    .registers 6
    # ins_size=5
    const-string v0, "headers"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;-><init>(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; I Ljava/util/Map; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->statusCode I
    iget v3, v5, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->statusCode I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->headers Ljava/util/Map;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->headers Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->errorMessage Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->errorMessage Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getErrorMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->errorMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getFile()com.bytedance.trae.kmp.artifact.KmpFileReference
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    return-object v0
.end method

.method public final getHeaders()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final getStatusCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->statusCode I
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v2, v3, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->statusCode I
    invoke-static v2, Ljava/lang/Integer;->hashCode(I)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->headers Ljava/util/Map;
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->errorMessage Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isSuccess()boolean
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    const/4 v1, 0
    if-eqz v0, +017h
    iget v0, v4, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->statusCode I
    const/16 v2, 200
    const/4 v3, 1
    if-gt v2, v0, +008h
    const/16 v2, 300
    if-ge v0, v2, +004h
    move v0, v3
    goto +2h
    move v0, v1
    if-eqz v0, +007h
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->errorMessage Ljava/lang/String;
    if-nez v0, +003h
    move v1, v3
    return v1
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "KmpBinaryDownloadResult(file="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->file Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", statusCode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->statusCode I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", headers="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->headers Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->errorMessage Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
