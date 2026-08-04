# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroidx/activity/result/ActivityResultCallback;

.field public final synthetic f$0:Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;


.method public synthetic constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    return-void 
.end method

.method public final onActivityResult(java.lang.Object)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    check-cast v2, Landroidx/activity/result/ActivityResult;
    invoke-static v0, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->$r8$lambda$RcR1C-6RLjQ2lbK4M4Wzzui8fLk(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method
