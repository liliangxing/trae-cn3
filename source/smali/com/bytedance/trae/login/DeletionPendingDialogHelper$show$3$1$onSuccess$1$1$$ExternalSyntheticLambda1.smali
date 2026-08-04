# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/app/Activity;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(android.app.Activity  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda1;->f$0 Landroid/app/Activity;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda1;->f$0 Landroid/app/Activity;
    iget-object v1, v2, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    invoke-static v0, v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->$r8$lambda$m4TwcNTtLcjUdRY04rRaJjhIxlI(Landroid/app/Activity; Ljava/lang/String;)V
    return-void 
.end method
