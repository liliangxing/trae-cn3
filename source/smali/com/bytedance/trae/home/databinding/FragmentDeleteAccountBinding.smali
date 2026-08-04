# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;
.super Ljava/lang/Object;
.source "FragmentDeleteAccountBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnCancelConfirm:Landroid/widget/TextView;
.field public final btnCancelOauth:Landroid/widget/TextView;
.field public final btnCancelPwd:Landroid/widget/TextView;
.field public final btnCancelSms:Landroid/widget/TextView;
.field public final btnCancelVerify:Landroid/widget/TextView;
.field public final btnConfirmDelete:Landroid/widget/TextView;
.field public final btnGoogleVerify:Landroid/widget/TextView;
.field public final btnOkCountdown:Landroid/widget/TextView;
.field public final btnPwdVerify:Landroid/widget/TextView;
.field public final btnSendCode:Landroid/widget/TextView;
.field public final btnSmsSendCode:Landroid/widget/TextView;
.field public final btnSmsVerify:Landroid/widget/TextView;
.field public final btnVerify:Landroid/widget/TextView;
.field public final etEmail:Landroid/widget/EditText;
.field public final etPassword:Landroid/widget/EditText;
.field public final etSmsCode:Landroid/widget/EditText;
.field public final etVerificationCode:Landroid/widget/EditText;
.field public final progressLoading:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final scrollContent:Landroid/widget/ScrollView;
.field public final stepConfirm:Landroid/widget/LinearLayout;
.field public final stepEmailVerify:Landroid/widget/LinearLayout;
.field public final stepOauthVerify:Landroid/widget/LinearLayout;
.field public final stepPwdVerify:Landroid/widget/LinearLayout;
.field public final stepSmsVerify:Landroid/widget/LinearLayout;
.field public final stepSubmitted:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvConfirmUserInfo:Landroid/widget/TextView;
.field public final tvEmailVerifyHint:Landroid/widget/TextView;
.field public final tvOauthNickname:Landroid/widget/TextView;
.field public final tvOauthUnsupported:Landroid/widget/TextView;
.field public final tvOauthVerifyHint:Landroid/widget/TextView;
.field public final tvPwdVerifyHint:Landroid/widget/TextView;
.field public final tvSmsVerifyHint:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.EditText  android.widget.EditText  android.widget.EditText  android.widget.EditText  android.widget.ProgressBar  android.widget.ScrollView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 37
    # ins_size=35
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->rootView Landroid/widget/LinearLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnCancelConfirm Landroid/widget/TextView;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnCancelOauth Landroid/widget/TextView;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnCancelPwd Landroid/widget/TextView;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnCancelSms Landroid/widget/TextView;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnCancelVerify Landroid/widget/TextView;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnConfirmDelete Landroid/widget/TextView;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnGoogleVerify Landroid/widget/TextView;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnOkCountdown Landroid/widget/TextView;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnPwdVerify Landroid/widget/TextView;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnSendCode Landroid/widget/TextView;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnSmsSendCode Landroid/widget/TextView;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnSmsVerify Landroid/widget/TextView;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->btnVerify Landroid/widget/TextView;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->etEmail Landroid/widget/EditText;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->etPassword Landroid/widget/EditText;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->etSmsCode Landroid/widget/EditText;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->etVerificationCode Landroid/widget/EditText;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->progressLoading Landroid/widget/ProgressBar;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->scrollContent Landroid/widget/ScrollView;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->stepConfirm Landroid/widget/LinearLayout;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->stepEmailVerify Landroid/widget/LinearLayout;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->stepOauthVerify Landroid/widget/LinearLayout;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->stepPwdVerify Landroid/widget/LinearLayout;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->stepSmsVerify Landroid/widget/LinearLayout;
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->stepSubmitted Landroid/widget/LinearLayout;
    move-object/from16 v1, v29
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    move-object/from16 v1, v30
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->tvConfirmUserInfo Landroid/widget/TextView;
    move-object/from16 v1, v31
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->tvEmailVerifyHint Landroid/widget/TextView;
    move-object/from16 v1, v32
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->tvOauthNickname Landroid/widget/TextView;
    move-object/from16 v1, v33
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->tvOauthUnsupported Landroid/widget/TextView;
    move-object/from16 v1, v34
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->tvOauthVerifyHint Landroid/widget/TextView;
    move-object/from16 v1, v35
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->tvPwdVerifyHint Landroid/widget/TextView;
    move-object/from16 v1, v36
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->tvSmsVerifyHint Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentDeleteAccountBinding
    .registers 39
    # ins_size=1
    move-object/from16 v0, v38
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_cancel_confirm I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +182h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_cancel_oauth I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +177h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_cancel_pwd I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +16ch
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_cancel_sms I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +161h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_cancel_verify I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +156h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_confirm_delete I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +14bh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_google_verify I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +140h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_ok_countdown I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +135h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_pwd_verify I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +12ah
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_send_code I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +11fh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_sms_send_code I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/TextView;
    if-eqz v15, +114h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_sms_verify I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/TextView;
    if-eqz v16, +108h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_verify I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/TextView;
    if-eqz v17, +0fch
    sget v1, Lcom/bytedance/trae/home/R$id;->et_email I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroid/widget/EditText;
    if-eqz v18, +0f0h
    sget v1, Lcom/bytedance/trae/home/R$id;->et_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroid/widget/EditText;
    if-eqz v19, +0e4h
    sget v1, Lcom/bytedance/trae/home/R$id;->et_sms_code I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/EditText;
    if-eqz v20, +0d8h
    sget v1, Lcom/bytedance/trae/home/R$id;->et_verification_code I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v21, v2
    check-cast v21, Landroid/widget/EditText;
    if-eqz v21, +0cch
    sget v1, Lcom/bytedance/trae/home/R$id;->progress_loading I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v22, v2
    check-cast v22, Landroid/widget/ProgressBar;
    if-eqz v22, +0c0h
    sget v1, Lcom/bytedance/trae/home/R$id;->scroll_content I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v23, v2
    check-cast v23, Landroid/widget/ScrollView;
    if-eqz v23, +0b4h
    sget v1, Lcom/bytedance/trae/home/R$id;->step_confirm I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v24, v2
    check-cast v24, Landroid/widget/LinearLayout;
    if-eqz v24, +0a8h
    sget v1, Lcom/bytedance/trae/home/R$id;->step_email_verify I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v25, v2
    check-cast v25, Landroid/widget/LinearLayout;
    if-eqz v25, +09ch
    sget v1, Lcom/bytedance/trae/home/R$id;->step_oauth_verify I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v26, v2
    check-cast v26, Landroid/widget/LinearLayout;
    if-eqz v26, +090h
    sget v1, Lcom/bytedance/trae/home/R$id;->step_pwd_verify I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v27, v2
    check-cast v27, Landroid/widget/LinearLayout;
    if-eqz v27, +084h
    sget v1, Lcom/bytedance/trae/home/R$id;->step_sms_verify I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v28, v2
    check-cast v28, Landroid/widget/LinearLayout;
    if-eqz v28, +078h
    sget v1, Lcom/bytedance/trae/home/R$id;->step_submitted I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v29, v2
    check-cast v29, Landroid/widget/LinearLayout;
    if-eqz v29, +06ch
    sget v1, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v30, v2
    check-cast v30, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v30, +060h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_confirm_user_info I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v31, v2
    check-cast v31, Landroid/widget/TextView;
    if-eqz v31, +054h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_email_verify_hint I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v32, v2
    check-cast v32, Landroid/widget/TextView;
    if-eqz v32, +048h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_oauth_nickname I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v33, v2
    check-cast v33, Landroid/widget/TextView;
    if-eqz v33, +03ch
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_oauth_unsupported I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v34, v2
    check-cast v34, Landroid/widget/TextView;
    if-eqz v34, +030h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_oauth_verify_hint I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v35, v2
    check-cast v35, Landroid/widget/TextView;
    if-eqz v35, +024h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_pwd_verify_hint I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v36, v2
    check-cast v36, Landroid/widget/TextView;
    if-eqz v36, +018h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_sms_verify_hint I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v37, v2
    check-cast v37, Landroid/widget/TextView;
    if-eqz v37, +00ch
    new-instance v1, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct/range v3 ... v37, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/ProgressBar; Landroid/widget/ScrollView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v38, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/NullPointerException;
    const-string v2, "Missing required view with ID: "
    invoke-virtual v2, v0, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentDeleteAccountBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentDeleteAccountBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_delete_account I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentDeleteAccountBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
