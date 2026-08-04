# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;
.super Ljava/lang/Object;
.source "ChatTokenUsageTracker.kt"

.field private completionTokens:I
.field private reasoningTokens:I


.method public constructor <init>()void
    .registers 4
    # ins_size=1
    const/4 v0, 3
    const/4 v1, 0
    const/4 v2, 0
    invoke-direct v3, v2, v2, v0, v1, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;-><init>(I I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->completionTokens I
    iput v2, v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->reasoningTokens I
    return-void 
.end method

.method public synthetic constructor <init>(int  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;-><init>(I I)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.track.ChatTokenUsageTracker$CumulativeTokenUsage  int  int  int  java.lang.Object)com.bytedance.trae.im.track.ChatTokenUsageTracker$CumulativeTokenUsage
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget v1, v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->completionTokens I
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget v2, v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->reasoningTokens I
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->copy(I I)Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->completionTokens I
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->reasoningTokens I
    return v0
.end method

.method public final copy(int  int)com.bytedance.trae.im.track.ChatTokenUsageTracker$CumulativeTokenUsage
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;-><init>(I I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;
    iget v1, v4, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->completionTokens I
    iget v3, v5, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->completionTokens I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->reasoningTokens I
    iget v5, v5, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->reasoningTokens I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getCompletionTokens()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->completionTokens I
    return v0
.end method

.method public final getReasoningTokens()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->reasoningTokens I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->completionTokens I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->reasoningTokens I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final setCompletionTokens(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->completionTokens I
    return-void 
.end method

.method public final setReasoningTokens(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->reasoningTokens I
    return-void 
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CumulativeTokenUsage(completionTokens="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->completionTokens I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", reasoningTokens="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;->reasoningTokens I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
