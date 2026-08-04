# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy;
.super Ljava/lang/Object;
.source "DeviceFlowDeviceClickPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final resolve(com.bytedance.trae.conversation.devices.DeviceItem)com.bytedance.trae.conversation.devices.flow.DeviceFlowDeviceClickRoute
    .registers 8
    # ins_size=2
    const-string v0, "device"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    const/4 v2, 3
    const/4 v3, 1
    const/4 v4, 2
    if-eq v0, v1, +039h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired()Z
    move-result v0
    if-nez v0, +033h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v7
    sget-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v7, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v7
    aget v7, v0, v7
    if-eq v7, v3, +01bh
    if-eq v7, v4, +016h
    if-eq v7, v2, +008h
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "remote handled above"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    sget-object v7, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    goto +3h
    sget-object v7, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$BindingGuide;
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$BindingGuide;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;
    return-object v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 0
    const/4 v5, 0
    if-eq v0, v3, +026h
    if-eq v0, v4, +00fh
    if-ne v0, v2, +007h
    sget-object v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$SelectDeviceDirectly;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$SelectDeviceDirectly;
    check-cast v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;
    goto +30h
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v7
    if-eqz v7, +007h
    sget-object v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$ProjectSelect;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$ProjectSelect;
    check-cast v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;
    goto +1fh
    new-instance v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-direct v7, v0, v5, v4, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;
    goto +15h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v7
    if-eqz v7, +007h
    sget-object v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$ProjectSelect;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$ProjectSelect;
    check-cast v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;
    goto +ah
    new-instance v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-direct v7, v0, v5, v4, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;
    return-object v7
.end method
