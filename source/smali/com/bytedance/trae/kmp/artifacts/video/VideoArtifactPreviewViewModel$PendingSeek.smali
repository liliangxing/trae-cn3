# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
.super Ljava/lang/Object;
.source "VideoArtifactPreviewViewModel.kt"

.field private final generation:I
.field private final positionMs:J


.method public constructor <init>(long  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->positionMs J
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->generation I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$PendingSeek  long  int  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$PendingSeek
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->positionMs J
    and-int/lit8 v4, v4, 2
    if-eqz v4, +004h
    iget v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->generation I
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->copy(J I)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->positionMs J
    return-wide v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->generation I
    return v0
.end method

.method public final copy(long  int)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$PendingSeek
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;-><init>(J I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->positionMs J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->positionMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->generation I
    iget v8, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->generation I
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getGeneration()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->generation I
    return v0
.end method

.method public final getPositionMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->positionMs J
    return-wide v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->positionMs J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->generation I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PendingSeek(positionMs="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->positionMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", generation="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->generation I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
