# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;
.super Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
.source "DeviceFlowRoute.kt"

.field private final devices:Ljava/util/List;
.field private final hasRegisteredIDE:Z
.field private final hasRegisteredWork:Z
.field private final productType:Lcom/bytedance/trae/conversation/devices/DeviceProductType;


.method public constructor <init>(com.bytedance.trae.conversation.devices.DeviceProductType  java.util.List  boolean  boolean)void
    .registers 6
    # ins_size=5
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "devices"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->devices Ljava/util/List;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredWork Z
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredIDE Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$NewFeaturePrompt  com.bytedance.trae.conversation.devices.DeviceProductType  java.util.List  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$NewFeaturePrompt
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->devices Ljava/util/List;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredWork Z
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredIDE Z
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->copy(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/List; Z Z)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->devices Ljava/util/List;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredWork Z
    return v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredIDE Z
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.devices.DeviceProductType  java.util.List  boolean  boolean)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$NewFeaturePrompt
    .registers 6
    # ins_size=5
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "devices"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/List; Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->devices Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->devices Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredWork Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredWork Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredIDE Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredIDE Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getDevices()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->devices Ljava/util/List;
    return-object v0
.end method

.method public final getHasRegisteredIDE()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredIDE Z
    return v0
.end method

.method public final getHasRegisteredWork()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredWork Z
    return v0
.end method

.method public final getProductType()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->devices Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredWork Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredIDE Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "NewFeaturePrompt(productType="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", devices="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->devices Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasRegisteredWork="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredWork Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasRegisteredIDE="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->hasRegisteredIDE Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
