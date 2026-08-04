# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;
.super Ljava/lang/Object;
.source "RtcLowAudioDetector.kt"

.field private final avgVolume:D
.field private final confirmed:Z
.field private final hitCount:I
.field private final lowRatio:F
.field private final maxVolume:I
.field private final totalSize:I
.field private final voicedSize:I
.field private final windowHit:Z


.method public constructor <init>(boolean  boolean  int  double  int  int  int  float)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->confirmed Z
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->windowHit Z
    iput v3, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->hitCount I
    iput-wide v4, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->avgVolume D
    iput v6, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->maxVolume I
    iput v7, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->voicedSize I
    iput v8, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->totalSize I
    iput v9, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->lowRatio F
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.health.RtcLowAudioDetector$Evaluation  boolean  boolean  int  double  int  int  int  float  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.health.RtcLowAudioDetector$Evaluation
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->confirmed Z
    goto +2h
    move v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->windowHit Z
    goto +2h
    move v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->hitCount I
    goto +2h
    move v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->avgVolume D
    goto +2h
    move-wide v5, v14
    and-int/lit8 v7, v1, 16
    if-eqz v7, +005h
    iget v7, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->maxVolume I
    goto +3h
    move/from16 v7, v16
    and-int/lit8 v8, v1, 32
    if-eqz v8, +005h
    iget v8, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->voicedSize I
    goto +3h
    move/from16 v8, v17
    and-int/lit8 v9, v1, 64
    if-eqz v9, +005h
    iget v9, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->totalSize I
    goto +3h
    move/from16 v9, v18
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->lowRatio F
    goto +3h
    move/from16 v1, v19
    move v11, v2
    move v12, v3
    move v13, v4
    move-wide v14, v5
    move/from16 v16, v7
    move/from16 v17, v8
    move/from16 v18, v9
    move/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->copy(Z Z I D I I I F)Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->confirmed Z
    return v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->windowHit Z
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->hitCount I
    return v0
.end method

.method public final component4()double
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->avgVolume D
    return-wide v0
.end method

.method public final component5()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->maxVolume I
    return v0
.end method

.method public final component6()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->voicedSize I
    return v0
.end method

.method public final component7()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->totalSize I
    return v0
.end method

.method public final component8()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->lowRatio F
    return v0
.end method

.method public final copy(boolean  boolean  int  double  int  int  int  float)com.bytedance.trae.conversation.brainstorm.health.RtcLowAudioDetector$Evaluation
    .registers 21
    # ins_size=10
    new-instance v10, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;
    move-object v0, v10
    move v1, v12
    move v2, v13
    move v3, v14
    move-wide v4, v15
    move/from16 v6, v17
    move/from16 v7, v18
    move/from16 v8, v19
    move/from16 v9, v20
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;-><init>(Z Z I D I I I F)V
    return-object v10
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->confirmed Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->confirmed Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->windowHit Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->windowHit Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->hitCount I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->hitCount I
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->avgVolume D
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->avgVolume D
    invoke-static v3, v4, v5, v6, Ljava/lang/Double;->compare(D D)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->maxVolume I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->maxVolume I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->voicedSize I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->voicedSize I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->totalSize I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->totalSize I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->lowRatio F
    iget v8, v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->lowRatio F
    invoke-static v1, v8, Ljava/lang/Float;->compare(F F)I
    move-result v8
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getAvgVolume()double
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->avgVolume D
    return-wide v0
.end method

.method public final getConfirmed()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->confirmed Z
    return v0
.end method

.method public final getHitCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->hitCount I
    return v0
.end method

.method public final getLowRatio()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->lowRatio F
    return v0
.end method

.method public final getMaxVolume()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->maxVolume I
    return v0
.end method

.method public final getTotalSize()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->totalSize I
    return v0
.end method

.method public final getVoicedSize()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->voicedSize I
    return v0
.end method

.method public final getWindowHit()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->windowHit Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->confirmed Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->windowHit Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->hitCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->avgVolume D
    invoke-static v1, v2, Ljava/lang/Double;->hashCode(D)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->maxVolume I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->voicedSize I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->totalSize I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->lowRatio F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Evaluation(confirmed="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->confirmed Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", windowHit="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->windowHit Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hitCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->hitCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", avgVolume="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->avgVolume D
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", maxVolume="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->maxVolume I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", voicedSize="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->voicedSize I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", totalSize="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->totalSize I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", lowRatio="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;->lowRatio F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
