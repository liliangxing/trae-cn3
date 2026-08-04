# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda16;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnDismissListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/AccountFragment;
.field public final synthetic f$1:Landroid/app/Dialog;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.AccountFragment  android.app.Dialog)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda16;->f$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda16;->f$1 Landroid/app/Dialog;
    return-void 
.end method

.method public final onDismiss(android.content.DialogInterface)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda16;->f$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda16;->f$1 Landroid/app/Dialog;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->$r8$lambda$M0e1y15wP-m_hG5ickXc69Edoas(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/app/Dialog; Landroid/content/DialogInterface;)V
    return-void 
.end method
