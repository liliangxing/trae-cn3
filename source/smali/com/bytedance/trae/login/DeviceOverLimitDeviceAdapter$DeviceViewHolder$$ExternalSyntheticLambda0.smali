# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
.field public final synthetic f$1:Lcom/bytedance/trae/login/traeauth/DeviceSummary;


.method public synthetic constructor <init>(com.bytedance.trae.login.DeviceOverLimitDeviceAdapter  com.bytedance.trae.login.traeauth.DeviceSummary)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/login/traeauth/DeviceSummary;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    iget-object v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/login/traeauth/DeviceSummary;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->$r8$lambda$C3Uzsz-Y6-thSMIhjPikNbqndhk(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; Lcom/bytedance/trae/login/traeauth/DeviceSummary; Landroid/view/View;)V
    return-void 
.end method
