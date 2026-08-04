# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessRefreshTarget$DefaultImpls;
.super Ljava/lang/Object;
.source "DeviceFlowConnectionSuccessRefreshTarget.kt"


.method public static synthetic onDeviceConnectionSuccess$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessRefreshTarget  java.lang.String  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    if-nez v3, +00bh
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-interface v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessRefreshTarget;->onDeviceConnectionSuccess(Ljava/lang/String;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: onDeviceConnectionSuccess"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
