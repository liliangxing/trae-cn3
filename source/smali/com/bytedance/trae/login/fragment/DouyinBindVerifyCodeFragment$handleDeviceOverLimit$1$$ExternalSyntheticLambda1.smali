# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
.field public final synthetic f$2:Z


.method public synthetic constructor <init>(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.traeauth.ListDevicesResult  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iput-object v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iput-boolean v3, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda1;->f$2 Z
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iget-object v1, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iget-boolean v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda1;->f$2 Z
    check-cast v4, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    check-cast v5, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    invoke-static v0, v1, v2, v4, v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1;->$r8$lambda$lOCxCpXBD5nKxxhXib0qszIQJG0(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Z Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
