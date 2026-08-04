# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;
.super Ljava/lang/Object;
.source "OutputVolumeMuteDetector.kt"

.field public static final CONFIRM_CHECK_COUNT:I
.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Companion;
.field private consecutiveMutedChecks:I
.field private lastAudioDevice:Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->Companion Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final toEvaluation(com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Snapshot  boolean  boolean  int)com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Evaluation
    .registers 14
    # ins_size=5
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->getAudioDevice()Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-result-object v4
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->isInCommunicationMode()Z
    move-result v5
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->getMusicVolume()Ljava/lang/Integer;
    move-result-object v6
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->getVoiceCallVolume()Ljava/lang/Integer;
    move-result-object v7
    move-object v0, v8
    move v1, v11
    move v2, v12
    move v3, v13
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;-><init>(Z Z I Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Ljava/lang/Integer; Ljava/lang/Integer;)V
    return-object v8
.end method

.method public final evaluate(boolean  com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Snapshot)com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector$Evaluation
    .registers 7
    # ins_size=3
    const-string/jumbo v0, snapshot
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    if-nez v5, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->reset()V
    invoke-direct v4, v6, v0, v0, v0, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->toEvaluation(Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot; Z Z I)Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;
    move-result-object v5
    return-object v5
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->lastAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->getAudioDevice()Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-result-object v1
    if-eq v5, v1, +00ah
    iput v0, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->consecutiveMutedChecks I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->getAudioDevice()Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-result-object v5
    iput-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->lastAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->getAudioDevice()Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-result-object v5
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->ordinal()I
    move-result v5
    aget v5, v1, v5
    const/4 v1, 2
    const/4 v2, 1
    if-eq v5, v2, +029h
    if-ne v5, v1, +021h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->isInCommunicationMode()Z
    move-result v5
    if-eqz v5, +036h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->getVoiceCallVolume()Ljava/lang/Integer;
    move-result-object v5
    if-eqz v5, +011h
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    if-gtz v5, +004h
    move v5, v2
    goto +2h
    move v5, v0
    if-ne v5, v2, +004h
    move v5, v2
    goto +2h
    move v5, v0
    if-eqz v5, +01eh
    goto +1ah
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;->getMusicVolume()Ljava/lang/Integer;
    move-result-object v5
    if-eqz v5, +011h
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    if-gtz v5, +004h
    move v5, v2
    goto +2h
    move v5, v0
    if-ne v5, v2, +004h
    move v5, v2
    goto +2h
    move v5, v0
    if-eqz v5, +006h
    iget v3, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->consecutiveMutedChecks I
    add-int/2addr v3, v2
    goto +2h
    move v3, v0
    iput v3, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->consecutiveMutedChecks I
    if-lt v3, v1, +003h
    goto +2h
    move v2, v0
    if-eqz v2, +004h
    iput v0, v4, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->consecutiveMutedChecks I
    invoke-direct v4, v6, v2, v5, v3, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->toEvaluation(Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot; Z Z I)Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;
    move-result-object v5
    return-object v5
.end method

.method public final reset()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->consecutiveMutedChecks I
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;->lastAudioDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    return-void 
.end method
