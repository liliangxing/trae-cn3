# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;
.super Ljava/lang/Object;
.source "VideoArtifactPreviewViewModel.kt"

.implements Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;

.field public static final $stable:I
.field private final speed:F


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(float)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->speed F
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewAction$SelectSpeed  float  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewAction$SelectSpeed
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->speed F
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->copy(F)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;
    move-result-object v0
    return-object v0
.end method

.method public final component1()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->speed F
    return v0
.end method

.method public final copy(float)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewAction$SelectSpeed
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;-><init>(F)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;
    iget v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->speed F
    iget v4, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->speed F
    invoke-static v1, v4, Ljava/lang/Float;->compare(F F)I
    move-result v4
    if-eqz v4, +003h
    return v2
    return v0
.end method

.method public final getSpeed()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->speed F
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->speed F
    invoke-static v0, Ljava/lang/Float;->hashCode(F)I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SelectSpeed(speed="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->speed F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
