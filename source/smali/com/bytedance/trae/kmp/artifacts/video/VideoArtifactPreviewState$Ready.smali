# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
.super Ljava/lang/Object;
.source "VideoArtifactPreviewViewModel.kt"

.implements Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;

.field public static final $stable:I
.field private final dragPositionMs:J
.field private final durationMs:J
.field private final isDragging:Z
.field private final isPlaying:Z
.field private final localSource:Ljava/lang/String;
.field private final playbackSpeed:F
.field private final positionMs:J
.field private final showSpeedMenu:Z


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  long  long  long  boolean  boolean  float  boolean)void
    .registers 13
    # ins_size=12
    const-string v0, "localSource"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->localSource Ljava/lang/String;
    iput-wide v3, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->durationMs J
    iput-wide v5, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->positionMs J
    iput-wide v7, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->dragPositionMs J
    iput-boolean v9, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isDragging Z
    iput-boolean v10, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isPlaying Z
    iput v11, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->playbackSpeed F
    iput-boolean v12, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->showSpeedMenu Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  long  long  long  boolean  boolean  float  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 25
    # ins_size=14
    move/from16 v0, v23
    and-int/lit8 v1, v0, 2
    const-wide/16 v2, 0
    if-eqz v1, +004h
    move-wide v4, v2
    goto +2h
    move-wide v4, v13
    and-int/lit8 v1, v0, 4
    if-eqz v1, +004h
    move-wide v6, v2
    goto +2h
    move-wide v6, v15
    and-int/lit8 v1, v0, 8
    if-eqz v1, +003h
    goto +3h
    move-wide/from16 v2, v17
    and-int/lit8 v1, v0, 16
    const/4 v8, 0
    if-eqz v1, +004h
    move v1, v8
    goto +3h
    move/from16 v1, v19
    and-int/lit8 v9, v0, 32
    if-eqz v9, +004h
    move v9, v8
    goto +3h
    move/from16 v9, v20
    and-int/lit8 v10, v0, 64
    if-eqz v10, +005h
    const/high16 v10, 1065353216
    goto +3h
    move/from16 v10, v21
    and-int/lit16 v0, v0, 128
    if-eqz v0, +003h
    goto +3h
    move/from16 v8, v22
    move-object v13, v11
    move-object v14, v12
    move-wide v15, v4
    move-wide/from16 v17, v6
    move-wide/from16 v19, v2
    move/from16 v21, v1
    move/from16 v22, v9
    move/from16 v23, v10
    move/from16 v24, v8
    invoke-direct/range v13 ... v24, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;-><init>(Ljava/lang/String; J J J Z Z F Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready  java.lang.String  long  long  long  boolean  boolean  float  boolean  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 26
    # ins_size=14
    move-object v0, v12
    move/from16 v1, v24
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->localSource Ljava/lang/String;
    goto +2h
    move-object v2, v13
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-wide v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->durationMs J
    goto +2h
    move-wide v3, v14
    and-int/lit8 v5, v1, 4
    if-eqz v5, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->positionMs J
    goto +3h
    move-wide/from16 v5, v16
    and-int/lit8 v7, v1, 8
    if-eqz v7, +005h
    iget-wide v7, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->dragPositionMs J
    goto +3h
    move-wide/from16 v7, v18
    and-int/lit8 v9, v1, 16
    if-eqz v9, +005h
    iget-boolean v9, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isDragging Z
    goto +3h
    move/from16 v9, v20
    and-int/lit8 v10, v1, 32
    if-eqz v10, +005h
    iget-boolean v10, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isPlaying Z
    goto +3h
    move/from16 v10, v21
    and-int/lit8 v11, v1, 64
    if-eqz v11, +005h
    iget v11, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->playbackSpeed F
    goto +3h
    move/from16 v11, v22
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->showSpeedMenu Z
    goto +3h
    move/from16 v1, v23
    move-object v13, v2
    move-wide v14, v3
    move-wide/from16 v16, v5
    move-wide/from16 v18, v7
    move/from16 v20, v9
    move/from16 v21, v10
    move/from16 v22, v11
    move/from16 v23, v1
    invoke-virtual/range v12 ... v23, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy(Ljava/lang/String; J J J Z Z F Z)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->localSource Ljava/lang/String;
    return-object v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->durationMs J
    return-wide v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->positionMs J
    return-wide v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->dragPositionMs J
    return-wide v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isDragging Z
    return v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isPlaying Z
    return v0
.end method

.method public final component7()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->playbackSpeed F
    return v0
.end method

.method public final component8()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->showSpeedMenu Z
    return v0
.end method

.method public final copy(java.lang.String  long  long  long  boolean  boolean  float  boolean)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 25
    # ins_size=12
    const-string v0, "localSource"
    move-object v2, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-object v1, v0
    move-wide v3, v15
    move-wide/from16 v5, v17
    move-wide/from16 v7, v19
    move/from16 v9, v21
    move/from16 v10, v22
    move/from16 v11, v23
    move/from16 v12, v24
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;-><init>(Ljava/lang/String; J J J Z Z F Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    iget-object v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->localSource Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->localSource Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->durationMs J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->durationMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->positionMs J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->positionMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->dragPositionMs J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->dragPositionMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isDragging Z
    iget-boolean v3, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isDragging Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isPlaying Z
    iget-boolean v3, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isPlaying Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->playbackSpeed F
    iget v3, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->playbackSpeed F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->showSpeedMenu Z
    iget-boolean v8, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->showSpeedMenu Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getDragPositionMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->dragPositionMs J
    return-wide v0
.end method

.method public final getDurationMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->durationMs J
    return-wide v0
.end method

.method public final getLocalSource()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->localSource Ljava/lang/String;
    return-object v0
.end method

.method public final getPlaybackSpeed()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->playbackSpeed F
    return v0
.end method

.method public final getPositionMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->positionMs J
    return-wide v0
.end method

.method public final getShowSpeedMenu()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->showSpeedMenu Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->localSource Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->durationMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->positionMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->dragPositionMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isDragging Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isPlaying Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->playbackSpeed F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->showSpeedMenu Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isDragging()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isDragging Z
    return v0
.end method

.method public final isPlaying()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isPlaying Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Ready(localSource="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->localSource Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", durationMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->durationMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", positionMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->positionMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", dragPositionMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->dragPositionMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isDragging="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isDragging Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isPlaying="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isPlaying Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", playbackSpeed="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->playbackSpeed F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showSpeedMenu="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->showSpeedMenu Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
