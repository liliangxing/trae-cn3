# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
.super Ljava/lang/Object;
.source "RunCommandDialogCreator.kt"

.field private final bgColor:I
.field private final textColor:I


.method public constructor <init>(int  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->bgColor I
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->textColor I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator$WarningConfig  int  int  int  java.lang.Object)com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator$WarningConfig
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->bgColor I
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->textColor I
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->copy(I I)Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->bgColor I
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->textColor I
    return v0
.end method

.method public final copy(int  int)com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator$WarningConfig
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;-><init>(I I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->bgColor I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->bgColor I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->textColor I
    iget v5, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->textColor I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getBgColor()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->bgColor I
    return v0
.end method

.method public final getTextColor()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->textColor I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->bgColor I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->textColor I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "WarningConfig(bgColor="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->bgColor I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", textColor="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->textColor I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
