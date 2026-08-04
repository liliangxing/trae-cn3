# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnShowListener;

.field public final synthetic f$0:Lcom/google/android/material/bottomsheet/BottomSheetDialog;
.field public final synthetic f$1:Landroid/app/Activity;
.field public final synthetic f$2:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;


.method public synthetic constructor <init>(com.google.android.material.bottomsheet.BottomSheetDialog  android.app.Activity  com.bytedance.trae.login.DeviceOverLimitDialog$Scene)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda5;->f$0 Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda5;->f$1 Landroid/app/Activity;
    iput-object v3, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda5;->f$2 Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    return-void 
.end method

.method public final onShow(android.content.DialogInterface)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda5;->f$0 Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    iget-object v1, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda5;->f$1 Landroid/app/Activity;
    iget-object v2, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda5;->f$2 Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->$r8$lambda$WEiaYKIN42AgWfqGwdPRGEdCsOA(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Landroid/app/Activity; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Landroid/content/DialogInterface;)V
    return-void 
.end method
