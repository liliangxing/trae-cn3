# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
.super Ljava/lang/Object;
.source "VoiceDiscussionAttemptTracker.kt"

.field private final cliType:Lcom/bytedance/trae/im/service/CliType;
.field private final conversationId:Ljava/lang/String;
.field private final hasSeenIntro:Z
.field private final isNewSession:Z
.field private final mode:Lcom/bytedance/trae/im/service/Mode;
.field private final roomId:Ljava/lang/String;


.method public constructor <init>()void
    .registers 10
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 63
    const/4 v8, 0
    move-object v0, v9
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;-><init>(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  boolean  boolean)void
    .registers 8
    # ins_size=7
    const-string v0, "cliType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, roomId
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->cliType Lcom/bytedance/trae/im/service/CliType;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->mode Lcom/bytedance/trae/im/service/Mode;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->conversationId Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->roomId Ljava/lang/String;
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->isNewSession Z
    iput-boolean v7, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->hasSeenIntro Z
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  boolean  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    sget-object v6, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    const-string v0, ""
    if-eqz v6, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +003h
    goto +2h
    move-object v0, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +003h
    const/4 v9, 1
    move v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +003h
    const/4 v10, 0
    move v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v1
    move-object v10, v0
    move v11, v2
    move v12, v3
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;-><init>(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Z Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->cliType Lcom/bytedance/trae/im/service/CliType;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->mode Lcom/bytedance/trae/im/service/Mode;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->conversationId Ljava/lang/String;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->roomId Ljava/lang/String;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-boolean v9, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->isNewSession Z
    move v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-boolean v10, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->hasSeenIntro Z
    move v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move v11, v2
    move v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->copy(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    move-result-object v4
    return-object v4
.end method

.method public final component1()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->cliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.im.service.Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->mode Lcom/bytedance/trae/im/service/Mode;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->roomId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->isNewSession Z
    return v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->hasSeenIntro Z
    return v0
.end method

.method public final copy(com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.Mode  java.lang.String  java.lang.String  boolean  boolean)com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext
    .registers 15
    # ins_size=7
    const-string v0, "cliType"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, roomId
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move v6, v13
    move v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;-><init>(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->cliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->cliType Lcom/bytedance/trae/im/service/CliType;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->mode Lcom/bytedance/trae/im/service/Mode;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->mode Lcom/bytedance/trae/im/service/Mode;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->conversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->roomId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->roomId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->isNewSession Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->isNewSession Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->hasSeenIntro Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->hasSeenIntro Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getCliType()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->cliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getHasSeenIntro()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->hasSeenIntro Z
    return v0
.end method

.method public final getMode()com.bytedance.trae.im.service.Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->mode Lcom/bytedance/trae/im/service/Mode;
    return-object v0
.end method

.method public final getRoomId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->roomId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/CliType;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->mode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Mode;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->conversationId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->roomId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->isNewSession Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->hasSeenIntro Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isNewSession()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->isNewSession Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "VoiceDiscussionAttemptContext(cliType="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", mode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->mode Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", roomId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->roomId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isNewSession="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->isNewSession Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasSeenIntro="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;->hasSeenIntro Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
