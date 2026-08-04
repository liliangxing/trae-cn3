# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnShowListener;

.field public final synthetic f$0:Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;


.method public synthetic constructor <init>(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;
    return-void 
.end method

.method public final onShow(android.content.DialogInterface)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;
    invoke-static v0, v2, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1;->$r8$lambda$bMrSNiwLsb6JHMo0OW5pXAK1NHQ(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback; Landroid/content/DialogInterface;)V
    return-void 
.end method
