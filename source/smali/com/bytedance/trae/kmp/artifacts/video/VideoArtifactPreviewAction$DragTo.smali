# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;
.super Ljava/lang/Object;
.source "VideoArtifactPreviewViewModel.kt"

.implements Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;

.field public static final $stable:I
.field private final positionMs:J


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(long)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;->positionMs J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewAction$DragTo  long  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewAction$DragTo
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;->positionMs J
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;->copy(J)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;->positionMs J
    return-wide v0
.end method

.method public final copy(long)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewAction$DragTo
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;-><init>(J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;->positionMs J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;->positionMs J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getPositionMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;->positionMs J
    return-wide v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;->positionMs J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DragTo(positionMs="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;->positionMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
