# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;
.super Ljava/lang/Object;
.source "ConversationActivity.kt"

.field private final candidate:Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
.field private final config:Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
.field private final hasRegisteredIDE:Z
.field private final hasRegisteredWork:Z
.field private final productType:Lcom/bytedance/trae/conversation/devices/DeviceProductType;


.method public constructor <init>(com.bytedance.trae.conversation.prompt.ManagedPromptCandidate  com.bytedance.trae.conversation.devices.DeviceProductType  boolean  boolean  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig)void
    .registers 7
    # ins_size=6
    const-string v0, "candidate"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "config"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->candidate Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredWork Z
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredIDE Z
    iput-object v6, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->config Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.ConversationActivity$PreparedNewFeaturePrompt  com.bytedance.trae.conversation.prompt.ManagedPromptCandidate  com.bytedance.trae.conversation.devices.DeviceProductType  boolean  boolean  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig  int  java.lang.Object)com.bytedance.trae.conversation.ConversationActivity$PreparedNewFeaturePrompt
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->candidate Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-boolean v6, v3, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredWork Z
    move v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-boolean v7, v3, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredIDE Z
    move v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->config Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move v8, v0
    move v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->copy(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Z Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;)Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;
    move-result-object v3
    return-object v3
.end method

.method public final component1()com.bytedance.trae.conversation.prompt.ManagedPromptCandidate
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->candidate Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredWork Z
    return v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredIDE Z
    return v0
.end method

.method public final component5()com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->config Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.prompt.ManagedPromptCandidate  com.bytedance.trae.conversation.devices.DeviceProductType  boolean  boolean  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig)com.bytedance.trae.conversation.ConversationActivity$PreparedNewFeaturePrompt
    .registers 13
    # ins_size=6
    const-string v0, "candidate"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "config"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move v4, v10
    move v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Z Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->candidate Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->candidate Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredWork Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredWork Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredIDE Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredIDE Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->config Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->config Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCandidate()com.bytedance.trae.conversation.prompt.ManagedPromptCandidate
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->candidate Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    return-object v0
.end method

.method public final getConfig()com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->config Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    return-object v0
.end method

.method public final getHasRegisteredIDE()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredIDE Z
    return v0
.end method

.method public final getHasRegisteredWork()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredWork Z
    return v0
.end method

.method public final getProductType()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->candidate Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredWork Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredIDE Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->config Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PreparedNewFeaturePrompt(candidate="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->candidate Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", productType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasRegisteredWork="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredWork Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasRegisteredIDE="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->hasRegisteredIDE Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", config="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->config Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
