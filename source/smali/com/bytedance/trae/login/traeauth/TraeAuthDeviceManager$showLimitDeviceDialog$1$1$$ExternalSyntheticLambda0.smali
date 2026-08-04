# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;

.field public final synthetic f$0:Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
.field public final synthetic f$1:Landroid/app/Activity;


.method public synthetic constructor <init>(com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$TraeAuthDeviceCallback  android.app.Activity)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1$$ExternalSyntheticLambda0;->f$1 Landroid/app/Activity;
    return-void 
.end method

.method public final onResult(boolean)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1$$ExternalSyntheticLambda0;->f$1 Landroid/app/Activity;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->$r8$lambda$R9jJryZpXGHVmAmkWtjKFxHCuos(Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback; Landroid/app/Activity; Z)V
    return-void 
.end method
