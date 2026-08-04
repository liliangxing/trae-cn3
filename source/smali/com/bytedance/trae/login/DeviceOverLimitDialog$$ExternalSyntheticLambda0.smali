# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroid/app/Activity;
.field public final synthetic f$1:Lkotlin/jvm/internal/Ref$ObjectRef;
.field public final synthetic f$2:Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
.field public final synthetic f$3:Lcom/bytedance/trae/login/traeauth/ListDevicesResult;


.method public synthetic constructor <init>(android.app.Activity  kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding  com.bytedance.trae.login.traeauth.ListDevicesResult)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;->f$0 Landroid/app/Activity;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v3, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iput-object v4, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;->f$0 Landroid/app/Activity;
    iget-object v1, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v2, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iget-object v3, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    check-cast v5, Lcom/bytedance/trae/login/traeauth/DeviceSummary;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->$r8$lambda$AaOOeadGrbjolz-6jfCYI_YY-kM(Landroid/app/Activity; Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/traeauth/DeviceSummary;)Lkotlin/Unit;
    move-result-object v5
    return-object v5
.end method
