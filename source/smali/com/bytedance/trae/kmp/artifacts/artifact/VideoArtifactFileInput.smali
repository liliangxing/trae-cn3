# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field public static final $stable:I
.field private final fileAction:Ljava/lang/String;
.field private final filePath:Ljava/lang/String;
.field private final videoInfo:Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactInfoInput)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->filePath Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->fileAction Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->videoInfo Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactFileInput  java.lang.String  java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactInfoInput  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactFileInput
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->filePath Ljava/lang/String;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->fileAction Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->videoInfo Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->copy(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;)Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->filePath Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->fileAction Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactInfoInput
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->videoInfo Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactInfoInput)com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactFileInput
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->filePath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->filePath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->fileAction Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->fileAction Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->videoInfo Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->videoInfo Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getFileAction()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->fileAction Ljava/lang/String;
    return-object v0
.end method

.method public final getFilePath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->filePath Ljava/lang/String;
    return-object v0
.end method

.method public final getVideoInfo()com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactInfoInput
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->videoInfo Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->filePath Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->fileAction Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->videoInfo Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "VideoArtifactFileInput(filePath="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->filePath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", fileAction="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->fileAction Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", videoInfo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->videoInfo Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
