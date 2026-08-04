# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
.super Ljava/lang/Object;
.source "ManagedPromptArbitrationPolicy.kt"

.field private final campaignId:Ljava/lang/String;
.field private final campaignVersion:I
.field private final type:Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;


.method public constructor <init>(com.bytedance.trae.conversation.prompt.ManagedPromptType  java.lang.String  int)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "campaignId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->type Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignId Ljava/lang/String;
    iput v4, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignVersion I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.prompt.ManagedPromptCandidate  com.bytedance.trae.conversation.prompt.ManagedPromptType  java.lang.String  int  int  java.lang.Object)com.bytedance.trae.conversation.prompt.ManagedPromptCandidate
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->type Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignId Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget v3, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignVersion I
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->copy(Lcom/bytedance/trae/conversation/prompt/ManagedPromptType; Ljava/lang/String; I)Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.prompt.ManagedPromptType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->type Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignVersion I
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.prompt.ManagedPromptType  java.lang.String  int)com.bytedance.trae.conversation.prompt.ManagedPromptCandidate
    .registers 5
    # ins_size=4
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "campaignId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptType; Ljava/lang/String; I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->type Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->type Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignVersion I
    iget v5, v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignVersion I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getCampaignId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignId Ljava/lang/String;
    return-object v0
.end method

.method public final getCampaignVersion()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignVersion I
    return v0
.end method

.method public final getStableKey()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 58
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignVersion I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getType()com.bytedance.trae.conversation.prompt.ManagedPromptType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->type Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->type Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignVersion I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ManagedPromptCandidate(type="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->type Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", campaignId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", campaignVersion="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->campaignVersion I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
