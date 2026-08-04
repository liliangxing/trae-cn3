# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
.super Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
.source "DeviceFlowRoute.kt"

.field private final device:Lcom/bytedance/trae/conversation/devices/DeviceItem;
.field private final mode:Lcom/bytedance/trae/conversation/widget/ChatMode;
.field private final showProductType:Z


.method public constructor <init>(com.bytedance.trae.conversation.devices.DeviceItem  com.bytedance.trae.conversation.widget.ChatMode  boolean)void
    .registers 5
    # ins_size=4
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->device Lcom/bytedance/trae/conversation/devices/DeviceItem;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->showProductType Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ProjectSelect  com.bytedance.trae.conversation.devices.DeviceItem  com.bytedance.trae.conversation.widget.ChatMode  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ProjectSelect
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->device Lcom/bytedance/trae/conversation/devices/DeviceItem;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->showProductType Z
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->copy(Lcom/bytedance/trae/conversation/devices/DeviceItem; Lcom/bytedance/trae/conversation/widget/ChatMode; Z)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.devices.DeviceItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->device Lcom/bytedance/trae/conversation/devices/DeviceItem;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.widget.ChatMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->showProductType Z
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.devices.DeviceItem  com.bytedance.trae.conversation.widget.ChatMode  boolean)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ProjectSelect
    .registers 5
    # ins_size=4
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceItem; Lcom/bytedance/trae/conversation/widget/ChatMode; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->device Lcom/bytedance/trae/conversation/devices/DeviceItem;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->device Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->showProductType Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->showProductType Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getDevice()com.bytedance.trae.conversation.devices.DeviceItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->device Lcom/bytedance/trae/conversation/devices/DeviceItem;
    return-object v0
.end method

.method public final getMode()com.bytedance.trae.conversation.widget.ChatMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method public final getShowProductType()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->showProductType Z
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->device Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->showProductType Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ProjectSelect(device="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->device Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", mode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showProductType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->showProductType Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
