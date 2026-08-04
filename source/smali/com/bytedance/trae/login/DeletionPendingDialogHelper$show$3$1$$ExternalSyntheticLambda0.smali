# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/app/Activity;
.field public final synthetic f$1:Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:I
.field public final synthetic f$4:Landroid/widget/TextView;
.field public final synthetic f$5:Landroid/widget/TextView;


.method public synthetic constructor <init>(android.app.Activity  com.bytedance.sdk.account.api.response.CancelCloseAccountResponse  java.lang.String  int  android.widget.TextView  android.widget.TextView)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$0 Landroid/app/Activity;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse;
    iput-object v3, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    iput v4, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$3 I
    iput-object v5, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$4 Landroid/widget/TextView;
    iput-object v6, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$5 Landroid/widget/TextView;
    return-void 
.end method

.method public final run()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$0 Landroid/app/Activity;
    iget-object v1, v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse;
    iget-object v2, v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    iget v3, v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$3 I
    iget-object v4, v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$4 Landroid/widget/TextView;
    iget-object v5, v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0;->f$5 Landroid/widget/TextView;
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;->$r8$lambda$BFRp549C_U3XrmR6nRd7JPN0anQ(Landroid/app/Activity; Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse; Ljava/lang/String; I Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-void 
.end method
