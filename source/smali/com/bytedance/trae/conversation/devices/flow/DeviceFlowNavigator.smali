# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
.super Ljava/lang/Object;
.source "DeviceFlowNavigator.kt"


.method public abstract closeCurrentFlow()void
    # abstract or native
.end method

.method public abstract navigate(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute)void
    # abstract or native
.end method

.method public abstract notifyConnectionSuccess()void
    # abstract or native
.end method

.method public abstract notifyConnectionSuccessWithDevice(com.bytedance.trae.conversation.devices.MobileDevice)void
    # abstract or native
.end method

.method public abstract notifyDeviceListChanged(java.util.List)void
    # abstract or native
.end method

.method public abstract notifyDeviceSelected(com.bytedance.trae.conversation.devices.SelectedDeviceItem)void
    # abstract or native
.end method

.method public abstract onRouteBack()boolean
    # abstract or native
.end method

.method public abstract openNewFlow(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute)void
    # abstract or native
.end method
