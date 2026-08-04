# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;
.super Lcom/bytedance/sdk/account/api/callback/CancelCloseAccountCallback;
.source "DeletionPendingDialogHelper.kt"

.field final synthetic $activity:Landroid/app/Activity;
.field final synthetic $btnCancelDeletion:Landroid/widget/TextView;
.field final synthetic $btnExit:Landroid/widget/TextView;
.field final synthetic $dialog:Landroid/app/Dialog;
.field final synthetic $funnelLoginPlatform:Ljava/lang/String;
.field final synthetic $onRestoreSuccess:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$BFRp549C_U3XrmR6nRd7JPN0anQ(android.app.Activity  com.bytedance.sdk.account.api.response.CancelCloseAccountResponse  java.lang.String  int  android.widget.TextView  android.widget.TextView)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->onError$lambda$1(Landroid/app/Activity; Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse; Ljava/lang/String; I Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$w1roEUZP2aGj0d6hdjboXZ8Gwd8(android.app.Activity  android.app.Dialog  java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->onSuccess$lambda$0(Landroid/app/Activity; Landroid/app/Dialog; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method constructor <init>(android.app.Activity  android.app.Dialog  java.lang.String  kotlin.jvm.functions.Function0  android.widget.TextView  android.widget.TextView)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$activity Landroid/app/Activity;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$dialog Landroid/app/Dialog;
    iput-object v3, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$funnelLoginPlatform Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$onRestoreSuccess Lkotlin/jvm/functions/Function0;
    iput-object v5, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$btnCancelDeletion Landroid/widget/TextView;
    iput-object v6, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$btnExit Landroid/widget/TextView;
    invoke-direct v0, Lcom/bytedance/sdk/account/api/callback/CancelCloseAccountCallback;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$1(android.app.Activity  com.bytedance.sdk.account.api.response.CancelCloseAccountResponse  java.lang.String  int  android.widget.TextView  android.widget.TextView)void
    .registers 13
    # ins_size=6
    invoke-virtual v7, Landroid/app/Activity;->isFinishing()Z
    move-result v0
    if-nez v0, +041h
    invoke-virtual v7, Landroid/app/Activity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +39h
    if-eqz v8, +006h
    iget-object v8, v8, Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse;->errorMsg Ljava/lang/String;
    if-nez v8, +00dh
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_deletion_cancel_failed I
    invoke-virtual v7, v8, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v8
    const-string v0, "getString(...)"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    const-string v3, "account_restore_fail"
    const-string v4, "cancel_close_account"
    invoke-static v10, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v5
    move-object v2, v9
    move-object v6, v8
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->access$reportRestoreFunnel(Lcom/bytedance/trae/login/DeletionPendingDialogHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    move-object v9, v7
    check-cast v9, Landroid/content/Context;
    check-cast v8, Ljava/lang/CharSequence;
    const/4 v10, 0
    invoke-static v9, v8, v10, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v8
    invoke-virtual v8, Landroid/widget/Toast;->show()V
    sget-object v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v8, v7, v11, v12, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->access$resetButtons(Lcom/bytedance/trae/login/DeletionPendingDialogHelper; Landroid/app/Activity; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-void 
.end method

.method private static final onSuccess$lambda$0(android.app.Activity  android.app.Dialog  java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 13
    # ins_size=4
    invoke-virtual v9, Landroid/app/Activity;->isFinishing()Z
    move-result v0
    if-nez v0, +028h
    invoke-virtual v9, Landroid/app/Activity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +20h
    invoke-virtual v10, Landroid/app/Dialog;->dismiss()V
    sget-object v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    const-string v3, "account_restore_api_success"
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 28
    const/4 v8, 0
    move-object v2, v11
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->reportRestoreFunnel$default(Lcom/bytedance/trae/login/DeletionPendingDialogHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    new-instance v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;
    invoke-direct v0, v11, v9, v12, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1;-><init>(Ljava/lang/String; Landroid/app/Activity; Lkotlin/jvm/functions/Function0;)V
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const-string v9, "account_restore"
    invoke-virtual v10, v9, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->onPassportLoginSuccess(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    return-void 
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->onError(Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.response.CancelCloseAccountResponse  int)void
    .registers 12
    # ins_size=3
    iget-object v7, v9, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$activity Landroid/app/Activity;
    iget-object v3, v9, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$funnelLoginPlatform Ljava/lang/String;
    iget-object v5, v9, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$btnCancelDeletion Landroid/widget/TextView;
    iget-object v6, v9, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$btnExit Landroid/widget/TextView;
    new-instance v8, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;
    move-object v0, v8
    move-object v1, v7
    move-object v2, v10
    move v4, v11
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;-><init>(Landroid/app/Activity; Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse; Ljava/lang/String; I Landroid/widget/TextView; Landroid/widget/TextView;)V
    invoke-virtual v7, v8, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->onSuccess(Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.response.CancelCloseAccountResponse)void
    .registers 6
    # ins_size=2
    iget-object v5, v4, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$activity Landroid/app/Activity;
    iget-object v0, v4, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$dialog Landroid/app/Dialog;
    iget-object v1, v4, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$funnelLoginPlatform Ljava/lang/String;
    iget-object v2, v4, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$onRestoreSuccess Lkotlin/jvm/functions/Function0;
    new-instance v3, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;
    invoke-direct v3, v5, v0, v1, v2, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1;-><init>(Landroid/app/Activity; Landroid/app/Dialog; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v5, v3, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method
