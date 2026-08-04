# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
.super Ljava/lang/Object;
.source "DeviceFlowContainerBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic targetSelectRoute$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$Companion  java.util.List  java.util.Map  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute
    .registers 7
    # ins_size=6
    const/4 v6, 1
    and-int/2addr v5, v6
    if-eqz v5, +00ah
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    const/4 v5, 0
    const/4 v0, 0
    invoke-static v2, v5, v6, v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->availableTargets$default(Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy; Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;->targetSelectRoute(Ljava/util/List; Ljava/util/Map; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    move-result-object v1
    return-object v1
.end method

.method public final newInstance(com.bytedance.trae.conversation.devices.flow.DeviceFlowRequest)com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet
    .registers 5
    # ins_size=2
    const-string/jumbo v0, request
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    sget-object v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->put(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;)Ljava/lang/String;
    move-result-object v4
    const-string v2, "arg_request_key"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method

.method public final offlineActivationRoute(com.bytedance.trae.conversation.devices.DeviceItem  com.bytedance.trae.conversation.devices.DeviceProductType)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute
    .registers 13
    # ins_size=3
    const-string v0, "device"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;
    new-instance v9, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired()Z
    move-result v5
    const/4 v6, 0
    const/16 v7, 16
    const/4 v8, 0
    move-object v1, v9
    move-object v4, v12
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v11, 0
    const/4 v12, 2
    invoke-direct v0, v9, v11, v12, v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;-><init>(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    return-object v0
.end method

.method public final targetSelectRoute(java.util.List  java.util.Map  java.lang.String)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute
    .registers 14
    # ins_size=4
    const-string v0, "availableTargets"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "existingDeviceIdsByProduct"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 1
    if-ne v0, v1, +02bh
    invoke-static v11, Lkotlin/collections/CollectionsKt;->single(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v11
    move-object v1, v11
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    new-instance v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    new-instance v9, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-interface v12, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Ljava/util/Set;
    if-nez v12, +006h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v12
    move-object v2, v12
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 56
    const/4 v8, 0
    move-object v0, v9
    move-object v3, v13
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v11, v9, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V
    check-cast v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    goto +9h
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;
    invoke-direct v0, v11, v12, v13, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;-><init>(Ljava/util/List; Ljava/util/Map; Ljava/lang/String;)V
    move-object v11, v0
    check-cast v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    return-object v11
.end method
