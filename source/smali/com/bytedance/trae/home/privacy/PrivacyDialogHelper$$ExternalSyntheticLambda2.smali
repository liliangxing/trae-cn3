# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Landroid/app/Dialog;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(android.app.Dialog  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda2;->f$0 Landroid/app/Dialog;
    iput-object v2, v0, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda2;->f$1 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda2;->f$0 Landroid/app/Dialog;
    iget-object v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda2;->f$1 Lkotlin/jvm/functions/Function0;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->$r8$lambda$rp-ITxe_1Nx3GfOeufB0hq5aY-w(Landroid/app/Dialog; Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method
