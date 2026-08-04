# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackPolicy;
.super Ljava/lang/Object;
.source "DeviceFlowBackPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final leftAction(int  boolean)com.bytedance.trae.conversation.devices.flow.DeviceFlowBackAction
    .registers 3
    # ins_size=3
    if-nez v2, +005h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;->Defer Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;
    return-object v1
    if-lez v1, +005h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;->PopRoute Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;
    goto +3h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;->CloseFlow Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;
    return-object v1
.end method

.method public final systemBack(int)com.bytedance.trae.conversation.devices.flow.DeviceFlowBackAction
    .registers 2
    # ins_size=2
    sget-object v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;->CloseFlow Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;
    return-object v1
.end method
