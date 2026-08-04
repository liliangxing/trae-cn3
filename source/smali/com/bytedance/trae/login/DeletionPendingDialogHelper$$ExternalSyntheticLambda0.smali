# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Landroid/app/Dialog;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(java.lang.String  android.app.Dialog  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda0;->f$1 Landroid/app/Dialog;
    iput-object v3, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda0;->f$2 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda0;->f$1 Landroid/app/Dialog;
    iget-object v2, v3, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda0;->f$2 Lkotlin/jvm/functions/Function0;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->$r8$lambda$9vjuPUtpYhF68TTDZFupiKB3018(Ljava/lang/String; Landroid/app/Dialog; Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method
