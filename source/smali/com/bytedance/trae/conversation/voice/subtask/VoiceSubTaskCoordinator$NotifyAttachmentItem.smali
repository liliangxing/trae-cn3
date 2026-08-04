# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;
.super Ljava/lang/Object;
.source "VoiceSubTaskCoordinator.kt"

.field private final attachmentId:Ljava/lang/String;
.field private final displayName:Ljava/lang/String;
.field private final sizeBytes:J
.field private final uploadedRef:Ljava/lang/String;
.field private final useImageUpload:Z


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  boolean  long)void
    .registers 8
    # ins_size=7
    const-string v0, "attachmentId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, uploadedRef
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayName"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->attachmentId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->uploadedRef Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->displayName Ljava/lang/String;
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->useImageUpload Z
    iput-wide v6, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->sizeBytes J
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  boolean  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=9
    and-int/lit8 v14, v14, 16
    if-eqz v14, +004h
    const-wide/16 v12, 0
    move-wide v5, v12
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move v4, v11
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$NotifyAttachmentItem  java.lang.String  java.lang.String  java.lang.String  boolean  long  int  java.lang.Object)com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$NotifyAttachmentItem
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->attachmentId Ljava/lang/String;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->uploadedRef Ljava/lang/String;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->displayName Ljava/lang/String;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-boolean v8, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->useImageUpload Z
    move v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-wide v9, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->sizeBytes J
    move-wide v2, v9
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v0
    move v10, v1
    move-wide v11, v2
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J)Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->attachmentId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->uploadedRef Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->useImageUpload Z
    return v0
.end method

.method public final component5()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->sizeBytes J
    return-wide v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  boolean  long)com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$NotifyAttachmentItem
    .registers 15
    # ins_size=7
    const-string v0, "attachmentId"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, uploadedRef
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayName"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move v5, v12
    move-wide v6, v13
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->attachmentId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->attachmentId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->uploadedRef Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->uploadedRef Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->displayName Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->displayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->useImageUpload Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->useImageUpload Z
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->sizeBytes J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->sizeBytes J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getAttachmentId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->attachmentId Ljava/lang/String;
    return-object v0
.end method

.method public final getDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final getSizeBytes()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->sizeBytes J
    return-wide v0
.end method

.method public final getUploadedRef()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->uploadedRef Ljava/lang/String;
    return-object v0
.end method

.method public final getUseImageUpload()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->useImageUpload Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->attachmentId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->uploadedRef Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->displayName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->useImageUpload Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->sizeBytes J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "NotifyAttachmentItem(attachmentId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->attachmentId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", uploadedRef="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->uploadedRef Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", displayName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->displayName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", useImageUpload="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->useImageUpload Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sizeBytes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;->sizeBytes J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
