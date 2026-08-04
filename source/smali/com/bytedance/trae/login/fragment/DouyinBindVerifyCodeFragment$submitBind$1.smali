# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;
.super Lcom/bytedance/sdk/account/mobile/thread/call/BindLoginCallback;
.source "DouyinBindVerifyCodeFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;


.method public static synthetic $r8$lambda$6YTBLp_rRELCM6Y3rxGtc33V8R4(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  java.lang.String  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->onError$lambda$2(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Ljava/lang/String; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$9qxkCgCn032VRXdF3CaPU9Irj18(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->onError$lambda$3(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$CnBVxc3WBEtaVwRikE62jjkbHxE(com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->onError$lambda$2$lambda$1(Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wHe0Fop5X8xjAmBKFDG30wZ5rEU(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.sdk.account.api.call.MobileApiResponse  int  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->onError$lambda$4(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/sdk/account/api/call/MobileApiResponse; I Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$yyDTw1bJ2YgLinI7jdZMKSPpDHE(com.bytedance.trae.login.activity.DouyinBindPhoneActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->onError$lambda$2$lambda$0(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-direct v0, Lcom/bytedance/sdk/account/mobile/thread/call/BindLoginCallback;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$2(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  java.lang.String  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 11
    # ins_size=4
    const-string v0, "activity"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "binding"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-static v7, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$setSubmitting$p(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z)V
    invoke-virtual v9, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setBindLoading(Z)V
    sget-object v1, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->INSTANCE Lcom/bytedance/trae/login/DeletionPendingDialogHelper;
    move-object v2, v9
    check-cast v2, Landroid/app/Activity;
    new-instance v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda3;
    invoke-direct v4, v9, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;)V
    new-instance v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda4;
    invoke-direct v5, v10, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;)V
    const-string v6, "douyin"
    move-object v3, v8
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/login/DeletionPendingDialogHelper;->show(Landroid/app/Activity; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Ljava/lang/String;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final onError$lambda$2$lambda$0(com.bytedance.trae.login.activity.DouyinBindPhoneActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->navigateToMainActivity()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onError$lambda$2$lambda$1(com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    iget-object v2, v2, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const-string v0, ""
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setText(Ljava/lang/CharSequence;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onError$lambda$3(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 5
    # ins_size=3
    const-string v0, "activity"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "binding"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$setSubmitting$p(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setBindLoading(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    iget-object v4, v4, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const-string v0, ""
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setText(Ljava/lang/CharSequence;)V
    invoke-static v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$showPhoneConflictDialog(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onError$lambda$4(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment  com.bytedance.sdk.account.api.call.MobileApiResponse  int  com.bytedance.trae.login.activity.DouyinBindPhoneActivity  com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding)kotlin.Unit
    .registers 8
    # ins_size=5
    const-string v0, "activity"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "binding"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-static v3, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$setSubmitting$p(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Z)V
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setBindLoading(Z)V
    iget-object v1, v7, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v2, 1
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setEnabled(Z)V
    iget-object v7, v7, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const-string v1, ""
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v7, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setText(Ljava/lang/CharSequence;)V
    check-cast v6, Landroid/content/Context;
    if-eqz v4, +006h
    iget-object v4, v4, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    if-nez v4, +015h
    sget v4, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_fail I
    new-array v7, v2, [Ljava/lang/Object;
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    aput-object v5, v7, v0
    invoke-virtual v3, v4, v7, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string v3, "getString(...)"
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v6, v4, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->onError(Lcom/bytedance/sdk/account/api/call/MobileApiResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.api.call.MobileApiResponse  int)void
    .registers 28
    # ins_size=3
    move-object/from16 v0, v25
    move-object/from16 v1, v26
    move/from16 v2, v27
    if-eqz v1, +006h
    iget-object v3, v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->errorMsg Ljava/lang/String;
    if-nez v3, +011h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "bind_login_error_"
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const/16 v4, 1201
    const/16 v18, 1
    const/4 v15, 0
    if-eq v2, v4, +01ah
    const/16 v4, 1202
    if-eq v2, v4, +016h
    const/16 v4, 1203
    if-eq v2, v4, +012h
    const/16 v4, 1204
    if-eq v2, v4, +00eh
    iget-object v4, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-static v4, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$isVerifyCodeError(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Ljava/lang/String;)Z
    move-result v4
    if-eqz v4, +003h
    goto +4h
    move/from16 v19, v15
    goto +3h
    move/from16 v19, v18
    const/16 v14, 1075
    const/16 v13, 1041
    const/16 v12, 1007
    if-eq v2, v12, +01bh
    if-eq v2, v13, +019h
    if-eq v2, v14, +014h
    const-string/jumbo v4, verify_code_error
    packed-switch v2, +00000b9h
    iget-object v5, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-static v5, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$isVerifyCodeError(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Ljava/lang/String;)Z
    move-result v5
    if-eqz v5, +003h
    goto +ah
    const-string v4, "bind_login"
    goto +7h
    const-string v4, "account_deletion_pending"
    goto +4h
    const-string/jumbo v4, phone_already_bound
    move-object/from16 v20, v4
    sget-object v4, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const-string/jumbo v5, submit_bind_phone
    invoke-static/range v27, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v15, v5, v6, v3, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackDouyinBindPhoneResult(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v5, "douyin_bind_fail"
    const-string v6, "douyin"
    const/4 v7, 0
    invoke-static/range v27, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v9
    const/4 v11, 0
    const/16 v16, 0
    const/16 v17, 0
    const-string v21, "fail"
    const-string/jumbo v22, submit_bind_phone
    const/16 v23, 452
    const/16 v24, 0
    move-object/from16 v8, v20
    move-object v10, v3
    move-object/from16 v12, v16
    move-object/from16 v13, v17
    move-object/from16 v14, v21
    move/from16 v21, v15
    move-object/from16 v15, v22
    move/from16 v16, v23
    move-object/from16 v17, v24
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    if-eqz v19, +01fh
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v5, "douyin_bind_verify_code_error"
    const-string v6, "douyin"
    const/4 v7, 0
    invoke-static/range v27, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v9
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const-string v14, "fail"
    const-string/jumbo v15, submit_bind_phone
    const/16 v16, 452
    const/16 v17, 0
    move-object/from16 v8, v20
    move-object v10, v3
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    if-eqz v1, +00bh
    iget-object v3, v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;->mobileObj Lcom/bytedance/sdk/account/mobile/query/MobileQueryObj;
    check-cast v3, Lcom/bytedance/sdk/account/mobile/query/BindLoginObj;
    if-eqz v3, +005h
    iget-object v3, v3, Lcom/bytedance/sdk/account/mobile/query/BindLoginObj;->mCancelToken Ljava/lang/String;
    goto +2h
    const/4 v3, 0
    const/16 v4, 1075
    if-ne v2, v4, +01dh
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move/from16 v18, v21
    if-nez v18, +00dh
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    new-instance v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Ljava/lang/String;)V
    invoke-static v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$runOnHost(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lkotlin/jvm/functions/Function2;)V
    return-void 
    const/16 v3, 1007
    if-eq v2, v3, +011h
    const/16 v3, 1041
    if-eq v2, v3, +00dh
    iget-object v3, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    new-instance v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda2;
    invoke-direct v4, v3, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lcom/bytedance/sdk/account/api/call/MobileApiResponse; I)V
    invoke-static v3, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$runOnHost(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lkotlin/jvm/functions/Function2;)V
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    new-instance v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda1;
    invoke-direct v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    invoke-static v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$runOnHost(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Lkotlin/jvm/functions/Function2;)V
    return-void 
    nop 
    packed-switch-payload 4b1 4b2 4b3 4b4
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->onSuccess(Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.api.call.MobileApiResponse)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;
    iget-object v2, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-direct v1, v4, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1;-><init>(Lcom/bytedance/sdk/account/api/call/MobileApiResponse; Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const-string v4, "douyin"
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->onPassportLoginSuccess(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    return-void 
.end method
