# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;
.super Ljava/lang/Object;
.source "DeviceFlowNavigator.kt"


.method public static final deviceFlowNavigator(androidx.fragment.app.Fragment)com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator
    .registers 2
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;
    move-result-object v1
    instance-of v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    if-eqz v0, +005h
    check-cast v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    goto +2h
    const/4 v1, 0
    return-object v1
.end method
