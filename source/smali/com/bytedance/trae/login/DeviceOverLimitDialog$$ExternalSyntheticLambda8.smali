# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Landroid/app/Activity;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Lkotlin/jvm/internal/Ref$ObjectRef;
.field public final synthetic f$3:Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
.field public final synthetic f$4:Lcom/bytedance/trae/login/traeauth/ListDevicesResult;


.method public synthetic constructor <init>(android.app.Activity  java.lang.String  kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding  com.bytedance.trae.login.traeauth.ListDevicesResult)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;->f$0 Landroid/app/Activity;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;->f$2 Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v4, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;->f$3 Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iput-object v5, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;->f$4 Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;->f$0 Landroid/app/Activity;
    iget-object v1, v5, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;->f$1 Ljava/lang/String;
    iget-object v2, v5, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;->f$2 Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v3, v5, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;->f$3 Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iget-object v4, v5, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;->f$4 Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->$r8$lambda$qoN6Ufc7kwjsNQnrPwlR2blVnKQ(Landroid/app/Activity; Ljava/lang/String; Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; Lcom/bytedance/trae/login/traeauth/ListDevicesResult;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
