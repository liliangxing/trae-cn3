# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;


.method public synthetic constructor <init>(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    check-cast v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    check-cast v3, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2;->$r8$lambda$GRI_xgiofrB18EgS8QMRfRadBKw(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
