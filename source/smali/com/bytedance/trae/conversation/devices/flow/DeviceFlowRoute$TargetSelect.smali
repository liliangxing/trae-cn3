# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;
.super Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
.source "DeviceFlowRoute.kt"

.field private final availableTargets:Ljava/util/List;
.field private final enterFrom:Ljava/lang/String;
.field private final existingDeviceIdsByProduct:Ljava/util/Map;


.method public constructor <init>(java.util.List  java.util.Map  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string v0, "availableTargets"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "existingDeviceIdsByProduct"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->availableTargets Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->existingDeviceIdsByProduct Ljava/util/Map;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->enterFrom Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$TargetSelect  java.util.List  java.util.Map  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$TargetSelect
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->availableTargets Ljava/util/List;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->existingDeviceIdsByProduct Ljava/util/Map;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->enterFrom Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->copy(Ljava/util/List; Ljava/util/Map; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->availableTargets Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->existingDeviceIdsByProduct Ljava/util/Map;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->enterFrom Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.util.List  java.util.Map  java.lang.String)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$TargetSelect
    .registers 5
    # ins_size=4
    const-string v0, "availableTargets"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "existingDeviceIdsByProduct"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;-><init>(Ljava/util/List; Ljava/util/Map; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->availableTargets Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->availableTargets Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->existingDeviceIdsByProduct Ljava/util/Map;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->existingDeviceIdsByProduct Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->enterFrom Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->enterFrom Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAvailableTargets()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->availableTargets Ljava/util/List;
    return-object v0
.end method

.method public final getEnterFrom()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->enterFrom Ljava/lang/String;
    return-object v0
.end method

.method public final getExistingDeviceIdsByProduct()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->existingDeviceIdsByProduct Ljava/util/Map;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->availableTargets Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->existingDeviceIdsByProduct Ljava/util/Map;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->enterFrom Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TargetSelect(availableTargets="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->availableTargets Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", existingDeviceIdsByProduct="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->existingDeviceIdsByProduct Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", enterFrom="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->enterFrom Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
