# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;
.super Ljava/lang/Object;
.source "DeviceFlowConnectionSuccessPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic destination$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessPolicy  com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute  com.bytedance.trae.conversation.devices.MobileDevice  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessDestination
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 1
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;->destination(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Lcom/bytedance/trae/conversation/devices/MobileDevice; Z)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination;
    move-result-object v0
    return-object v0
.end method

.method public final destination(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute  com.bytedance.trae.conversation.devices.MobileDevice  boolean)com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessDestination
    .registers 5
    # ins_size=4
    const-string v0, "initialRoute"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "device"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v2, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;
    if-eqz v2, +01ch
    if-eqz v4, +00eh
    new-instance v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$ReturnToDeviceSelection;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$ReturnToDeviceSelection;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination;
    goto +11h
    new-instance v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$DeferReturnToDeviceSelection;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$DeferReturnToDeviceSelection;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination;
    goto +5h
    sget-object v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$NotifyHost;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$NotifyHost;
    check-cast v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination;
    return-object v2
.end method
