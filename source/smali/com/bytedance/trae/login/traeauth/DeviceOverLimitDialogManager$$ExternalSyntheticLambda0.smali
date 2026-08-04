# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;

.field public final synthetic f$0:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;


.method public synthetic constructor <init>(com.bytedance.trae.login.DeviceOverLimitDialog$Callback)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    return-void 
.end method

.method public final onResult(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    invoke-static v0, v2, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->$r8$lambda$0YNw2TdJUeeSo0NOCn70P8Doj2U(Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback; Z)V
    return-void 
.end method
