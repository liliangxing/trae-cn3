# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/app/Activity;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(android.app.Activity  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda0;->f$0 Landroid/app/Activity;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda0;->f$0 Landroid/app/Activity;
    iget-object v1, v2, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/functions/Function0;
    invoke-static v0, v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->$r8$lambda$xJPrt9ou4_CklyS8HR-_onEolQU(Landroid/app/Activity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
