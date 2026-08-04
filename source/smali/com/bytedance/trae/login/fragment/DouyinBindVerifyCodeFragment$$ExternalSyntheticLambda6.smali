# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function2;


.method public synthetic constructor <init>(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  kotlin.jvm.functions.Function2)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iput-object v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda6;->f$1 Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    iput-object v3, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda6;->f$2 Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iget-object v1, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda6;->f$1 Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    iget-object v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda6;->f$2 Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->$r8$lambda$W_DSYIpNIPlf9NMDTHZihruJ1SY(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method
