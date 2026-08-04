# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/app/Activity;
.field public final synthetic f$1:Landroid/app/Dialog;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(android.app.Activity  android.app.Dialog  java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;->f$0 Landroid/app/Activity;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;->f$1 Landroid/app/Dialog;
    iput-object v3, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;->f$3 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final run()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;->f$0 Landroid/app/Activity;
    iget-object v1, v4, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;->f$1 Landroid/app/Dialog;
    iget-object v2, v4, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;->f$2 Ljava/lang/String;
    iget-object v3, v4, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;->f$3 Lkotlin/jvm/functions/Function0;
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$r8$lambda$w1roEUZP2aGj0d6hdjboXZ8Gwd8(Landroid/app/Activity; Landroid/app/Dialog; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
