# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;
.super Ljava/lang/Object;
.source "ConnectComputerGuideFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$Companion  com.bytedance.trae.conversation.devices.DeviceProductType  java.util.Collection  java.lang.String  com.bytedance.trae.conversation.devices.DevicePairingTrigger  int  java.lang.Object)com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    sget-object v4, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->CONNECT_BUTTON Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Collection; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;)Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    move-result-object v0
    return-object v0
.end method

.method public final newEmbeddedInstance(com.bytedance.trae.conversation.devices.BindingTarget)com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment
    .registers 5
    # ins_size=2
    const-string/jumbo v0, target
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/BindingTarget;)Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +008h
    const-string v1, "arg_embedded_presentation"
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    return-object v4
.end method

.method public final newInstance(com.bytedance.trae.conversation.devices.BindingTarget)com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment
    .registers 6
    # ins_size=2
    const-string/jumbo v0, target
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getExistingDeviceIds()Ljava/util/Set;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getEnterFrom()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getTriggerBy()Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    move-result-object v3
    invoke-virtual v4, v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Collection; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;)Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v1
    if-eqz v1, +00bh
    const-string v2, "arg_device_id"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getDeviceId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v2, v3, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v1
    if-eqz v1, +00bh
    const-string v2, "arg_device_name"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getDeviceName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v2, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public final newInstance(com.bytedance.trae.conversation.devices.DeviceProductType  java.util.Collection  java.lang.String  com.bytedance.trae.conversation.devices.DevicePairingTrigger)com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment
    .registers 8
    # ins_size=5
    const-string v0, "productType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "existingDeviceIds"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, triggerBy
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "arg_product_type"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    const-string v5, "arg_existing_device_ids"
    invoke-virtual v1, v5, v4, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String; Ljava/util/ArrayList;)V
    const-string v4, "arg_enter_from"
    invoke-virtual v1, v4, v6, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "arg_trigger_by"
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->name()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method

.method public final newInstance(java.util.ArrayList)com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment
    .registers 10
    # ins_size=2
    const-string v0, "onlineDeviceIds"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-object v3, v9
    check-cast v3, Ljava/util/Collection;
    const-string v4, "new_task"
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v8
    invoke-static/range v1 ... v7, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;->newInstance$default(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Collection; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v1
    if-eqz v1, +007h
    const-string v2, "arg_online_device_ids"
    invoke-virtual v1, v2, v9, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String; Ljava/util/ArrayList;)V
    return-object v0
.end method
