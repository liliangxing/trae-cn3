# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iput-object v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iget-object v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    check-cast v3, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    check-cast v4, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    invoke-static v0, v1, v3, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->$r8$lambda$6YTBLp_rRELCM6Y3rxGtc33V8R4(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Ljava/lang/String; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
