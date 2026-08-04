# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnKeyListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    return-void 
.end method

.method public final onKey(android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    invoke-static v0, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->$r8$lambda$aEx4OStCaPTZDA9tK6_gNM5j8PM(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet; Landroid/content/DialogInterface; I Landroid/view/KeyEvent;)Z
    move-result v2
    return v2
.end method
