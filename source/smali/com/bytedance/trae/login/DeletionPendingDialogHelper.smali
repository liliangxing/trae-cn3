# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
.super Ljava/lang/Object;
.source "DeletionPendingDialogHelper.kt"

.field public static final ERROR_CODE_ACCOUNT_DELETION_PENDING:I
.field public static final INSTANCE:Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$9vjuPUtpYhF68TTDZFupiKB3018(java.lang.String  android.app.Dialog  kotlin.jvm.functions.Function0  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->show$lambda$1(Ljava/lang/String; Landroid/app/Dialog; Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$D4Va2feJYXXMGUUF7C-B8OF0m4M(java.lang.String  android.widget.TextView  android.widget.TextView  java.lang.String  android.app.Activity  android.app.Dialog  kotlin.jvm.functions.Function0  android.view.View)void
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->show$lambda$2(Ljava/lang/String; Landroid/widget/TextView; Landroid/widget/TextView; Ljava/lang/String; Landroid/app/Activity; Landroid/app/Dialog; Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    invoke-direct v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$reportRestoreFunnel(com.bytedance.trae.login.DeletionPendingDialogHelper  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->reportRestoreFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$resetButtons(com.bytedance.trae.login.DeletionPendingDialogHelper  android.app.Activity  android.widget.TextView  android.widget.TextView)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->resetButtons(Landroid/app/Activity; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-void 
.end method

.method private final reportRestoreFunnel(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 20
    # ins_size=6
    move-object v0, v15
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const/4 v3, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 1984
    const/4 v13, 0
    move-object/from16 v1, v16
    move-object v2, v15
    move-object/from16 v4, v17
    move-object/from16 v5, v18
    move-object/from16 v6, v19
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method static synthetic reportRestoreFunnel$default(com.bytedance.trae.login.DeletionPendingDialogHelper  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 4
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v10
    and-int/lit8 v10, v13, 8
    if-eqz v10, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v10, v13, 16
    if-eqz v10, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->reportRestoreFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final resetButtons(android.app.Activity  android.widget.TextView  android.widget.TextView)void
    .registers 5
    # ins_size=4
    const/4 v0, 1
    invoke-virtual v3, v0, Landroid/widget/TextView;->setEnabled(Z)V
    invoke-virtual v4, v0, Landroid/widget/TextView;->setEnabled(Z)V
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_deletion_cancel_deletion I
    invoke-virtual v2, v4, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v3, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private static final show$lambda$1(java.lang.String  android.app.Dialog  kotlin.jvm.functions.Function0  android.view.View)void
    .registers 12
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    const-string v2, "account_restore_exit"
    const-string/jumbo v3, user_exit
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 24
    const/4 v7, 0
    move-object v1, v8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->reportRestoreFunnel$default(Lcom/bytedance/trae/login/DeletionPendingDialogHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual v9, Landroid/app/Dialog;->dismiss()V
    if-eqz v10, +005h
    invoke-interface v10, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final show$lambda$2(java.lang.String  android.widget.TextView  android.widget.TextView  java.lang.String  android.app.Activity  android.app.Dialog  kotlin.jvm.functions.Function0  android.view.View)void
    .registers 16
    # ins_size=8
    sget-object v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    const-string v2, "account_restore_click"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 28
    const/4 v7, 0
    move-object v1, v8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->reportRestoreFunnel$default(Lcom/bytedance/trae/login/DeletionPendingDialogHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    const/4 v15, 0
    invoke-virtual v9, v15, Landroid/widget/TextView;->setEnabled(Z)V
    invoke-virtual v10, v15, Landroid/widget/TextView;->setEnabled(Z)V
    const-string v15, "..."
    check-cast v15, Ljava/lang/CharSequence;
    invoke-virtual v9, v15, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountAPIV3Impl;->instance()Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;
    move-result-object v15
    new-instance v7, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;
    move-object v0, v7
    move-object v1, v12
    move-object v2, v13
    move-object v3, v8
    move-object v4, v14
    move-object v5, v9
    move-object v6, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1;-><init>(Landroid/app/Activity; Landroid/app/Dialog; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Landroid/widget/TextView; Landroid/widget/TextView;)V
    check-cast v7, Lcom/bytedance/sdk/account/api/callback/CancelCloseAccountCallback;
    invoke-interface v15, v11, v7, Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;->cancelCloseAccountWithToken(Ljava/lang/String; Lcom/bytedance/sdk/account/api/callback/CancelCloseAccountCallback;)V
    return-void 
.end method

.method public final show(android.app.Activity  java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 5
    # ins_size=4
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, token
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onRestoreSuccess
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v1, v2, v3, v4, v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->show(Landroid/app/Activity; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final show(android.app.Activity  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 12
    # ins_size=5
    const-string v0, "activity"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, token
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onRestoreSuccess
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->show(Landroid/app/Activity; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Ljava/lang/String;)V
    return-void 
.end method

.method public final show(android.app.Activity  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  java.lang.String)void
    .registers 24
    # ins_size=6
    move-object/from16 v5, v19
    const-string v0, "activity"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, token
    move-object/from16 v4, v20
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onRestoreSuccess
    move-object/from16 v7, v21
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v8, Landroid/app/Dialog;
    move-object v0, v5
    check-cast v0, Landroid/content/Context;
    invoke-direct v8, v0, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    const/4 v0, 1
    invoke-virtual v8, v0, Landroid/app/Dialog;->requestWindowFeature(I)Z
    sget v0, Lcom/bytedance/trae/login/R$layout;->dialog_account_deletion_pending I
    invoke-virtual v8, v0, Landroid/app/Dialog;->setContentView(I)V
    invoke-virtual v8, Landroid/app/Dialog;->getWindow()Landroid/view/Window;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +02ch
    new-instance v2, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v2, v1, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v2, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v2, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual/range v19, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->widthPixels I
    int-to-double v2, v2
    const-wide v9, 4605380978949069210
    mul-double/2addr v2, v9
    double-to-int v2, v2
    const/4 v3, -2
    invoke-virtual v0, v2, v3, Landroid/view/Window;->setLayout(I I)V
    const/16 v2, 17
    invoke-virtual v0, v2, Landroid/view/Window;->setGravity(I)V
    const/high16 v2, 1056964608
    invoke-virtual v0, v2, Landroid/view/Window;->setDimAmount(F)V
    invoke-virtual v8, v1, Landroid/app/Dialog;->setCancelable(Z)V
    invoke-virtual v8, v1, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_exit I
    invoke-virtual v8, v0, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_cancel_deletion I
    invoke-virtual v8, v0, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    move-object v9, v0
    check-cast v9, Landroid/widget/TextView;
    const-string v12, "account_deletion_pending_shown"
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 28
    const/16 v17, 0
    move-object/from16 v10, v18
    move-object/from16 v11, v23
    invoke-static/range v10 ... v17, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->reportRestoreFunnel$default(Lcom/bytedance/trae/login/DeletionPendingDialogHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    new-instance v0, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda0;
    move-object/from16 v1, v22
    move-object/from16 v2, v23
    invoke-direct v0, v2, v8, v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Landroid/app/Dialog; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v3, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v10, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;
    move-object v0, v10
    move-object/from16 v1, v23
    move-object v2, v9
    move-object/from16 v4, v20
    move-object/from16 v5, v19
    move-object v6, v8
    move-object/from16 v7, v21
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/login/DeletionPendingDialogHelper$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String; Landroid/widget/TextView; Landroid/widget/TextView; Ljava/lang/String; Landroid/app/Activity; Landroid/app/Dialog; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v9, v10, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v8, Landroid/app/Dialog;->show()V
    return-void 
.end method
