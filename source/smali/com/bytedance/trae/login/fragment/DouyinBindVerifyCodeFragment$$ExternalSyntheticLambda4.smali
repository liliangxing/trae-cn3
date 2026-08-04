# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;

.field public final synthetic f$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
.field public final synthetic f$1:Z


.method public synthetic constructor <init>(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  boolean)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iput-boolean v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda4;->f$1 Z
    return-void 
.end method

.method public final onResult(boolean)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    iget-boolean v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda4;->f$1 Z
    invoke-static v0, v1, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->$r8$lambda$cmpLdybkBQJ8SteotlXtPGqmT9E(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z Z)V
    return-void 
.end method
