# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field public static final $stable:I
.field private final artifactId:Ljava/lang/String;
.field private final durationSeconds:I
.field private final fileAction:Ljava/lang/String;
.field private final filePath:Ljava/lang/String;
.field private final lastFrameUri:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  int  java.lang.String)void
    .registers 7
    # ins_size=6
    const-string v0, "artifactId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filePath"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->artifactId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->filePath Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->lastFrameUri Ljava/lang/String;
    iput v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->durationSeconds I
    iput-object v6, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->fileAction Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactDescriptor  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactDescriptor
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->artifactId Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->filePath Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->lastFrameUri Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->durationSeconds I
    move v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->fileAction Ljava/lang/String;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String;)Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->artifactId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->filePath Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->lastFrameUri Ljava/lang/String;
    return-object v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->durationSeconds I
    return v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->fileAction Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  int  java.lang.String)com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactDescriptor
    .registers 13
    # ins_size=6
    const-string v0, "artifactId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filePath"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->artifactId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->artifactId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->filePath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->filePath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->lastFrameUri Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->lastFrameUri Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->durationSeconds I
    iget v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->durationSeconds I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->fileAction Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->fileAction Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getArtifactId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->artifactId Ljava/lang/String;
    return-object v0
.end method

.method public final getDurationSeconds()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->durationSeconds I
    return v0
.end method

.method public final getFileAction()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->fileAction Ljava/lang/String;
    return-object v0
.end method

.method public final getFilePath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->filePath Ljava/lang/String;
    return-object v0
.end method

.method public final getFormattedDuration()java.lang.String
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->durationSeconds I
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->formatVideoDuration(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getLastFrameUri()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->lastFrameUri Ljava/lang/String;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->filePath Ljava/lang/String;
    const/4 v1, 0
    const/4 v2, 2
    const/16 v3, 47
    invoke-static v0, v3, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +004h
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->filePath Ljava/lang/String;
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->artifactId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->filePath Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->lastFrameUri Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->durationSeconds I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->fileAction Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "VideoArtifactDescriptor(artifactId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->artifactId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", filePath="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->filePath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", lastFrameUri="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->lastFrameUri Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", durationSeconds="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->durationSeconds I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", fileAction="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->fileAction Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
