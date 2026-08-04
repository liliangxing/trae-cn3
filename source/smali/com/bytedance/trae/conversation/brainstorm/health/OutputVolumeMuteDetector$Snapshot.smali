# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;
.super Ljava/lang/Object;
.source "OutputVolumeMuteDetector.kt"

.field private final audioDevice:Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
.field private final isInCommunicationMode:Z
.field private final musicVolume:Ljava/lang/Integer;
.field private final voiceCallVolume:Ljava/lang/Integer;


.method public constructor <init>(com.bytedance.trae.conversation.brainstorm.model.AudioDevice  boolean  java.lang.Integer  java.lang.Integer)void
    .registers 6
    # ins_size=5
    const-string v0, "audioDevice"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->isInCommunicationMode Z
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->musicVolume Ljava/lang/Integer;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->voiceCallVolume Ljava/lang/Integer;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Snapshot  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  boolean  java.lang.Integer  java.lang.Integer  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Snapshot
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->isInCommunicationMode Z
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->musicVolume Ljava/lang/Integer;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->voiceCallVolume Ljava/lang/Integer;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->copy(Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Ljava/lang/Integer; Ljava/lang/Integer;)Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.brainstorm.model.AudioDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->isInCommunicationMode Z
    return v0
.end method

.method public final component3()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->musicVolume Ljava/lang/Integer;
    return-object v0
.end method

.method public final component4()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->voiceCallVolume Ljava/lang/Integer;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.brainstorm.model.AudioDevice  boolean  java.lang.Integer  java.lang.Integer)com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Snapshot
    .registers 6
    # ins_size=5
    const-string v0, "audioDevice"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;-><init>(Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Ljava/lang/Integer; Ljava/lang/Integer;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->isInCommunicationMode Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->isInCommunicationMode Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->musicVolume Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->musicVolume Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->voiceCallVolume Ljava/lang/Integer;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->voiceCallVolume Ljava/lang/Integer;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAudioDevice()com.bytedance.trae.conversation.brainstorm.model.AudioDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    return-object v0
.end method

.method public final getMusicVolume()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->musicVolume Ljava/lang/Integer;
    return-object v0
.end method

.method public final getVoiceCallVolume()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->voiceCallVolume Ljava/lang/Integer;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->isInCommunicationMode Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->musicVolume Ljava/lang/Integer;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->voiceCallVolume Ljava/lang/Integer;
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
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->isInCommunicationMode Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Snapshot(audioDevice="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->audioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isInCommunicationMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->isInCommunicationMode Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", musicVolume="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->musicVolume Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", voiceCallVolume="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->voiceCallVolume Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
