# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;
.super Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
.source "DeviceFlowRoute.kt"

.field private final codeMode:Z
.field private final mode:Lcom/bytedance/trae/conversation/widget/ChatMode;
.field private final preselectedDeviceId:Ljava/lang/String;


.method public constructor <init>(com.bytedance.trae.conversation.widget.ChatMode  java.lang.String  boolean)void
    .registers 5
    # ins_size=4
    const-string v0, "mode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->preselectedDeviceId Ljava/lang/String;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->codeMode Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$DeviceSelect  com.bytedance.trae.conversation.widget.ChatMode  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$DeviceSelect
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->preselectedDeviceId Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->codeMode Z
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->copy(Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.widget.ChatMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->preselectedDeviceId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->codeMode Z
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.widget.ChatMode  java.lang.String  boolean)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$DeviceSelect
    .registers 5
    # ins_size=4
    const-string v0, "mode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;-><init>(Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->preselectedDeviceId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->preselectedDeviceId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->codeMode Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->codeMode Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getCodeMode()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->codeMode Z
    return v0
.end method

.method public final getMode()com.bytedance.trae.conversation.widget.ChatMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method public final getPreselectedDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->preselectedDeviceId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->preselectedDeviceId Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->codeMode Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DeviceSelect(mode="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->mode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", preselectedDeviceId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->preselectedDeviceId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", codeMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->codeMode Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
