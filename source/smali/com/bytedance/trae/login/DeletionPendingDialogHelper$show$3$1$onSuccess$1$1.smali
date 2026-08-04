# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;
.super Ljava/lang/Object;
.source "DeletionPendingDialogHelper.kt"

.implements Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;

.field final synthetic $activity:Landroid/app/Activity;
.field final synthetic $funnelLoginPlatform:Ljava/lang/String;
.field final synthetic $onRestoreSuccess:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$m4TwcNTtLcjUdRY04rRaJjhIxlI(android.app.Activity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->onFailure$lambda$1(Landroid/app/Activity; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xJPrt9ou4_CklyS8HR-_onEolQU(android.app.Activity  kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->onSuccess$lambda$0(Landroid/app/Activity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method constructor <init>(java.lang.String  android.app.Activity  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->$funnelLoginPlatform Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->$activity Landroid/app/Activity;
    iput-object v3, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->$onRestoreSuccess Lkotlin/jvm/functions/Function0;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final onFailure$lambda$1(android.app.Activity  java.lang.String)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Landroid/app/Activity;->isFinishing()Z
    move-result v0
    if-nez v0, +022h
    invoke-virtual v1, Landroid/app/Activity;->isDestroyed()Z
    move-result v0
    if-nez v0, +01ch
    move-object v0, v1
    check-cast v0, Landroid/content/Context;
    if-nez v2, +00dh
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_deletion_login_failed I
    invoke-virtual v1, v2, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v1, "getString(...)"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v0, v2, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onSuccess$lambda$0(android.app.Activity  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Landroid/app/Activity;->isFinishing()Z
    move-result v0
    if-nez v0, +00bh
    invoke-virtual v1, Landroid/app/Activity;->isDestroyed()Z
    move-result v1
    if-nez v1, +005h
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public deviceOverLimit(java.lang.String)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public onFailure(java.lang.String  java.lang.String)void
    .registers 11
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeAuth after restore failed: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 32
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "DeletionPendingDialog"
    invoke-static v1, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v2, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    iget-object v3, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->$funnelLoginPlatform Ljava/lang/String;
    const-string v4, "account_restore_fail"
    const-string/jumbo v5, trae_auth_after_restore
    move-object v6, v9
    move-object v7, v10
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->access$reportRestoreFunnel(Lcom/bytedance/trae/login/DeletionPendingDialogHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iget-object v9, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->$activity Landroid/app/Activity;
    new-instance v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda1;
    invoke-direct v0, v9, v10, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda1;-><init>(Landroid/app/Activity; Ljava/lang/String;)V
    invoke-virtual v9, v0, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public onSuccess()void
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    iget-object v1, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->$funnelLoginPlatform Ljava/lang/String;
    const-string v2, "account_restore_success"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 28
    const/4 v7, 0
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->reportRestoreFunnel$default(Lcom/bytedance/trae/login/DeletionPendingDialogHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v0, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->$activity Landroid/app/Activity;
    iget-object v1, v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;->$onRestoreSuccess Lkotlin/jvm/functions/Function0;
    new-instance v2, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda0;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda0;-><init>(Landroid/app/Activity; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v0, v2, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method
