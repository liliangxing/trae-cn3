# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
.field public final synthetic f$1:Lcom/bytedance/sdk/account/api/call/MobileApiResponse;


.method public synthetic constructor <init>(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  com.bytedance.sdk.account.api.call.MobileApiResponse)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
    iput-object v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
    iget-object v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;->$r8$lambda$vRmOJFLRZjQ871WHek5Vn2aC0Sw(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
