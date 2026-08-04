# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;
.super Ljava/lang/Object;
.source "DeviceBindingPolicy.kt"

.field private currentState:Lcom/bytedance/trae/conversation/devices/BindingGuideState;
.field private lockedDeviceId:Ljava/lang/String;
.field private successConsumed:Z
.field private final target:Lcom/bytedance/trae/conversation/devices/BindingTarget;


.method public constructor <init>(com.bytedance.trae.conversation.devices.BindingTarget)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, target
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getDeviceId()Ljava/lang/String;
    move-result-object v3
    const/4 v0, 0
    if-eqz v3, +00eh
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    iput-object v3, v2, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->lockedDeviceId Ljava/lang/String;
    new-instance v3, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForDesktop;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->lockedDeviceId Ljava/lang/String;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForDesktop;-><init>(Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    iput-object v3, v2, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->currentState Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    return-void 
.end method

.method public final consumeSucceededDevice()com.bytedance.trae.conversation.devices.MobileDevice
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->successConsumed Z
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->currentState Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    invoke-interface v0, Lcom/bytedance/trae/conversation/devices/BindingGuideState;->getDisplayState()Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    move-result-object v0
    instance-of v2, v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;
    if-eqz v2, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;
    goto +2h
    move-object v0, v1
    if-nez v0, +003h
    return-object v1
    const/4 v1, 1
    iput-boolean v1, v3, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->successConsumed Z
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;->getDevice()Lcom/bytedance/trae/conversation/devices/MobileDevice;
    move-result-object v0
    return-object v0
.end method

.method public final getCurrentState()com.bytedance.trae.conversation.devices.BindingGuideState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->currentState Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    return-object v0
.end method

.method public final getLockedDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->lockedDeviceId Ljava/lang/String;
    return-object v0
.end method

.method public final onRefreshFailed()com.bytedance.trae.conversation.devices.BindingGuideState
    .registers 3
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/devices/BindingGuideState$RefreshFailed;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->currentState Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    invoke-interface v1, Lcom/bytedance/trae/conversation/devices/BindingGuideState;->getDisplayState()Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/BindingGuideState$RefreshFailed;-><init>(Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;)V
    check-cast v0, Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->currentState Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    return-object v0
.end method

.method public final onRefreshSucceeded(java.util.List)com.bytedance.trae.conversation.devices.BindingGuideStableState
    .registers 10
    # ins_size=2
    const-string v0, "devices"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->currentState Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    invoke-interface v0, Lcom/bytedance/trae/conversation/devices/BindingGuideState;->getDisplayState()Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;
    goto +2h
    move-object v0, v2
    if-eqz v0, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    return-object v0
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->lockedDeviceId Ljava/lang/String;
    const/4 v1, 1
    const/4 v3, 0
    if-nez v0, +04bh
    move-object v0, v9
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +031h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v6
    iget-object v7, v8, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v7
    if-ne v6, v7, +01ah
    iget-object v6, v8, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getExistingDeviceIds()Ljava/util/Set;
    move-result-object v6
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-interface v6, v7, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +00ah
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/MobileDevice;->isOnline()Z
    move-result v5
    if-eqz v5, +004h
    move v5, v1
    goto +2h
    move v5, v3
    if-eqz v5, -032h
    goto +2h
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    iput-object v0, v8, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->lockedDeviceId Ljava/lang/String;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->lockedDeviceId Ljava/lang/String;
    check-cast v9, Ljava/lang/Iterable;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +025h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +010h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v5
    iget-object v6, v8, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v6
    if-ne v5, v6, +004h
    move v5, v1
    goto +2h
    move v5, v3
    if-eqz v5, -026h
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    if-nez v2, +00ah
    new-instance v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForDesktop;
    invoke-direct v9, v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForDesktop;-><init>(Ljava/lang/String;)V
    check-cast v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    goto +28h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->isPaired()Z
    move-result v9
    if-eqz v9, +00ah
    new-instance v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;
    invoke-direct v9, v2, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;-><init>(Lcom/bytedance/trae/conversation/devices/MobileDevice;)V
    check-cast v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    goto +1ah
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->isOnline()Z
    move-result v9
    if-nez v9, +00ah
    new-instance v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForDesktop;
    invoke-direct v9, v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForDesktop;-><init>(Ljava/lang/String;)V
    check-cast v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    goto +ch
    new-instance v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForAuthorization;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v0
    invoke-direct v9, v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForAuthorization;-><init>(Ljava/lang/String;)V
    check-cast v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    iput-object v0, v8, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->currentState Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    return-object v9
.end method
