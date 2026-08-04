# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/VerifyCodeActivity;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.VerifyCodeActivity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/login/activity/VerifyCodeActivity;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/login/activity/VerifyCodeActivity;
    check-cast v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState;
    invoke-static v0, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->$r8$lambda$8_Be-Th8XvN8cK8OmGLZ4ymBJAo(Lcom/bytedance/trae/login/activity/VerifyCodeActivity; Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
