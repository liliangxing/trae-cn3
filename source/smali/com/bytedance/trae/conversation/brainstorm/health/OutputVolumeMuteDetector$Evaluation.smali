# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;
.super Ljava/lang/Object;
.source "OutputVolumeMuteDetector.kt"

.field private final audioDevice:Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
.field private final checkHit:Z
.field private final confirmed:Z
.field private final hitCount:I
.field private final isInCommunicationMode:Z
.field private final musicVolume:Ljava/lang/Integer;
.field private final voiceCallVolume:Ljava/lang/Integer;


.method public constructor <init>(boolean  boolean  int  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  boolean  java.lang.Integer  java.lang.Integer)void
    .registers 9
    # ins_size=8
    const-string v0, "audioDevice"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->confirmed Z
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->checkHit Z
    iput v4, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->hitCount I
    iput-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->isInCommunicationMode Z
    iput-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->musicVolume Ljava/lang/Integer;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->voiceCallVolume Ljava/lang/Integer;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Evaluation  boolean  boolean  int  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  boolean  java.lang.Integer  java.lang.Integer  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Evaluation
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-boolean v6, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->confirmed Z
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-boolean v7, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->checkHit Z
    move v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget v8, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->hitCount I
    move v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-boolean v10, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->isInCommunicationMode Z
    move v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->musicVolume Ljava/lang/Integer;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->voiceCallVolume Ljava/lang/Integer;
    move-object v4, v12
    move-object v7, v5
    move v8, v6
    move v9, v14
    move v10, v0
    move-object v11, v1
    move v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->copy(Z Z I Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Ljava/lang/Integer; Ljava/lang/Integer;)Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;
    move-result-object v5
    return-object v5
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->confirmed Z
    return v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->checkHit Z
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->hitCount I
    return v0
.end method

.method public final component4()com.bytedance.trae.conversation.brainstorm.model.AudioDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    return-object v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->isInCommunicationMode Z
    return v0
.end method

.method public final component6()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->musicVolume Ljava/lang/Integer;
    return-object v0
.end method

.method public final component7()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->voiceCallVolume Ljava/lang/Integer;
    return-object v0
.end method

.method public final copy(boolean  boolean  int  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  boolean  java.lang.Integer  java.lang.Integer)com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Evaluation
    .registers 17
    # ins_size=8
    const-string v0, "audioDevice"
    move-object v5, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;
    move-object v1, v0
    move v2, v10
    move v3, v11
    move v4, v12
    move v6, v14
    move-object v7, v15
    move-object/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;-><init>(Z Z I Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Ljava/lang/Integer; Ljava/lang/Integer;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->confirmed Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->confirmed Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->checkHit Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->checkHit Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->hitCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->hitCount I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->isInCommunicationMode Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->isInCommunicationMode Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->musicVolume Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->musicVolume Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->voiceCallVolume Ljava/lang/Integer;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->voiceCallVolume Ljava/lang/Integer;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAudioDevice()com.bytedance.trae.conversation.brainstorm.model.AudioDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    return-object v0
.end method

.method public final getCheckHit()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->checkHit Z
    return v0
.end method

.method public final getConfirmed()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->confirmed Z
    return v0
.end method

.method public final getHitCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->hitCount I
    return v0
.end method

.method public final getMusicVolume()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->musicVolume Ljava/lang/Integer;
    return-object v0
.end method

.method public final getVoiceCallVolume()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->voiceCallVolume Ljava/lang/Integer;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->confirmed Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->checkHit Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->hitCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->isInCommunicationMode Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->musicVolume Ljava/lang/Integer;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->voiceCallVolume Ljava/lang/Integer;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isInCommunicationMode()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->isInCommunicationMode Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Evaluation(confirmed="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->confirmed Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", checkHit="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->checkHit Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hitCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->hitCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", audioDevice="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isInCommunicationMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->isInCommunicationMode Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", musicVolume="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->musicVolume Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", voiceCallVolume="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;->voiceCallVolume Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
