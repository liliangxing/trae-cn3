# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Landroid/widget/TextView;
.field public final synthetic f$2:Landroid/widget/TextView;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Landroid/app/Activity;
.field public final synthetic f$5:Landroid/app/Dialog;
.field public final synthetic f$6:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(java.lang.String  android.widget.TextView  android.widget.TextView  java.lang.String  android.app.Activity  android.app.Dialog  kotlin.jvm.functions.Function0)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$1 Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$2 Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$4 Landroid/app/Activity;
    iput-object v6, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$5 Landroid/app/Dialog;
    iput-object v7, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$6 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iget-object v1, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$1 Landroid/widget/TextView;
    iget-object v2, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$2 Landroid/widget/TextView;
    iget-object v3, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$3 Ljava/lang/String;
    iget-object v4, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$4 Landroid/app/Activity;
    iget-object v5, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$5 Landroid/app/Dialog;
    iget-object v6, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;->f$6 Lkotlin/jvm/functions/Function0;
    move-object v7, v9
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->$r8$lambda$D4Va2feJYXXMGUUF7C-B8OF0m4M(Ljava/lang/String; Landroid/widget/TextView; Landroid/widget/TextView; Ljava/lang/String; Landroid/app/Activity; Landroid/app/Dialog; Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method
