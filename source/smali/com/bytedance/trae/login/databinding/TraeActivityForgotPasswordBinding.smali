# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;
.super Ljava/lang/Object;
.source "TraeActivityForgotPasswordBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnBackStep1:Landroid/widget/ImageView;
.field public final btnBackStep2:Landroid/widget/ImageView;
.field public final btnBackStep3:Landroid/widget/ImageView;
.field public final btnBackStep4:Landroid/widget/ImageView;
.field public final btnGoLogin:Landroid/widget/Button;
.field public final btnSendCode:Landroid/widget/Button;
.field public final btnSetPassword:Landroid/widget/Button;
.field public final etConfirmPassword:Landroid/widget/EditText;
.field public final etEmailStep1:Landroid/widget/EditText;
.field public final etNewPassword:Landroid/widget/EditText;
.field public final ivClearEmailStep1:Landroid/widget/ImageView;
.field public final ivToggleConfirmPassword:Landroid/widget/ImageView;
.field public final ivToggleNewPassword:Landroid/widget/ImageView;
.field public final layoutConfirmPasswordInput:Landroid/widget/LinearLayout;
.field public final layoutEmailInputStep1:Landroid/widget/LinearLayout;
.field public final layoutErrorStep1:Landroid/widget/LinearLayout;
.field public final layoutErrorStep2:Landroid/widget/LinearLayout;
.field public final layoutErrorStep3:Landroid/widget/LinearLayout;
.field public final layoutNewPasswordInput:Landroid/widget/LinearLayout;
.field public final layoutStepNewPassword:Landroid/widget/LinearLayout;
.field public final layoutStepSendCode:Landroid/widget/LinearLayout;
.field public final layoutStepSuccess:Landroid/widget/LinearLayout;
.field public final layoutStepVerifyCode:Landroid/widget/LinearLayout;
.field public final pbLoadingStep1:Landroid/widget/ProgressBar;
.field public final pbLoadingStep2:Landroid/widget/ProgressBar;
.field public final pbLoadingStep3:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/ScrollView;
.field public final tvErrorStep1:Landroid/widget/TextView;
.field public final tvErrorStep2:Landroid/widget/TextView;
.field public final tvErrorStep3:Landroid/widget/TextView;
.field public final tvResendCode:Landroid/widget/TextView;
.field public final tvVerifyDesc:Landroid/widget/TextView;
.field public final verifyCodeInput:Lcom/bytedance/trae/login/widget/VerifyCodeInputView;


.method private constructor <init>(android.widget.ScrollView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.Button  android.widget.Button  android.widget.Button  android.widget.EditText  android.widget.EditText  android.widget.EditText  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ProgressBar  android.widget.ProgressBar  android.widget.ProgressBar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  com.bytedance.trae.login.widget.VerifyCodeInputView)void
    .registers 36
    # ins_size=34
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->rootView Landroid/widget/ScrollView;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->btnBackStep1 Landroid/widget/ImageView;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->btnBackStep2 Landroid/widget/ImageView;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->btnBackStep3 Landroid/widget/ImageView;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->btnBackStep4 Landroid/widget/ImageView;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->btnGoLogin Landroid/widget/Button;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->btnSendCode Landroid/widget/Button;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->btnSetPassword Landroid/widget/Button;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->etConfirmPassword Landroid/widget/EditText;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->etEmailStep1 Landroid/widget/EditText;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->etNewPassword Landroid/widget/EditText;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->ivClearEmailStep1 Landroid/widget/ImageView;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->ivToggleConfirmPassword Landroid/widget/ImageView;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->ivToggleNewPassword Landroid/widget/ImageView;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->layoutConfirmPasswordInput Landroid/widget/LinearLayout;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->layoutEmailInputStep1 Landroid/widget/LinearLayout;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->layoutErrorStep1 Landroid/widget/LinearLayout;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->layoutErrorStep2 Landroid/widget/LinearLayout;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->layoutErrorStep3 Landroid/widget/LinearLayout;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->layoutNewPasswordInput Landroid/widget/LinearLayout;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->layoutStepNewPassword Landroid/widget/LinearLayout;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->layoutStepSendCode Landroid/widget/LinearLayout;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->layoutStepSuccess Landroid/widget/LinearLayout;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->layoutStepVerifyCode Landroid/widget/LinearLayout;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->pbLoadingStep1 Landroid/widget/ProgressBar;
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->pbLoadingStep2 Landroid/widget/ProgressBar;
    move-object/from16 v1, v29
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->pbLoadingStep3 Landroid/widget/ProgressBar;
    move-object/from16 v1, v30
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->tvErrorStep1 Landroid/widget/TextView;
    move-object/from16 v1, v31
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->tvErrorStep2 Landroid/widget/TextView;
    move-object/from16 v1, v32
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->tvErrorStep3 Landroid/widget/TextView;
    move-object/from16 v1, v33
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->tvResendCode Landroid/widget/TextView;
    move-object/from16 v1, v34
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->tvVerifyDesc Landroid/widget/TextView;
    move-object/from16 v1, v35
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.login.databinding.TraeActivityForgotPasswordBinding
    .registers 38
    # ins_size=1
    move-object/from16 v0, v37
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_back_step1 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +176h
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_back_step2 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +16bh
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_back_step3 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/ImageView;
    if-eqz v7, +160h
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_back_step4 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/ImageView;
    if-eqz v8, +155h
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_go_login I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/Button;
    if-eqz v9, +14ah
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_send_code I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/Button;
    if-eqz v10, +13fh
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_set_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/Button;
    if-eqz v11, +134h
    sget v1, Lcom/bytedance/trae/login/R$id;->et_confirm_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/EditText;
    if-eqz v12, +129h
    sget v1, Lcom/bytedance/trae/login/R$id;->et_email_step1 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/EditText;
    if-eqz v13, +11eh
    sget v1, Lcom/bytedance/trae/login/R$id;->et_new_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/EditText;
    if-eqz v14, +113h
    sget v1, Lcom/bytedance/trae/login/R$id;->iv_clear_email_step1 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/ImageView;
    if-eqz v15, +108h
    sget v1, Lcom/bytedance/trae/login/R$id;->iv_toggle_confirm_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/ImageView;
    if-eqz v16, +0fch
    sget v1, Lcom/bytedance/trae/login/R$id;->iv_toggle_new_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/ImageView;
    if-eqz v17, +0f0h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_confirm_password_input I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroid/widget/LinearLayout;
    if-eqz v18, +0e4h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_email_input_step1 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroid/widget/LinearLayout;
    if-eqz v19, +0d8h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_error_step1 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/LinearLayout;
    if-eqz v20, +0cch
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_error_step2 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v21, v2
    check-cast v21, Landroid/widget/LinearLayout;
    if-eqz v21, +0c0h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_error_step3 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v22, v2
    check-cast v22, Landroid/widget/LinearLayout;
    if-eqz v22, +0b4h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_new_password_input I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v23, v2
    check-cast v23, Landroid/widget/LinearLayout;
    if-eqz v23, +0a8h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_step_new_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v24, v2
    check-cast v24, Landroid/widget/LinearLayout;
    if-eqz v24, +09ch
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_step_send_code I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v25, v2
    check-cast v25, Landroid/widget/LinearLayout;
    if-eqz v25, +090h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_step_success I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v26, v2
    check-cast v26, Landroid/widget/LinearLayout;
    if-eqz v26, +084h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_step_verify_code I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v27, v2
    check-cast v27, Landroid/widget/LinearLayout;
    if-eqz v27, +078h
    sget v1, Lcom/bytedance/trae/login/R$id;->pb_loading_step1 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v28, v2
    check-cast v28, Landroid/widget/ProgressBar;
    if-eqz v28, +06ch
    sget v1, Lcom/bytedance/trae/login/R$id;->pb_loading_step2 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v29, v2
    check-cast v29, Landroid/widget/ProgressBar;
    if-eqz v29, +060h
    sget v1, Lcom/bytedance/trae/login/R$id;->pb_loading_step3 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v30, v2
    check-cast v30, Landroid/widget/ProgressBar;
    if-eqz v30, +054h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_error_step1 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v31, v2
    check-cast v31, Landroid/widget/TextView;
    if-eqz v31, +048h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_error_step2 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v32, v2
    check-cast v32, Landroid/widget/TextView;
    if-eqz v32, +03ch
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_error_step3 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v33, v2
    check-cast v33, Landroid/widget/TextView;
    if-eqz v33, +030h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_resend_code I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v34, v2
    check-cast v34, Landroid/widget/TextView;
    if-eqz v34, +024h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_verify_desc I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v35, v2
    check-cast v35, Landroid/widget/TextView;
    if-eqz v35, +018h
    sget v1, Lcom/bytedance/trae/login/R$id;->verify_code_input I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v36, v2
    check-cast v36, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-eqz v36, +00ch
    new-instance v1, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/ScrollView;
    invoke-direct/range v3 ... v36, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;-><init>(Landroid/widget/ScrollView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/Button; Landroid/widget/Button; Landroid/widget/Button; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Landroid/widget/ProgressBar; Landroid/widget/ProgressBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Lcom/bytedance/trae/login/widget/VerifyCodeInputView;)V
    return-object v1
    invoke-virtual/range v37, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.login.databinding.TraeActivityForgotPasswordBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.login.databinding.TraeActivityForgotPasswordBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/login/R$layout;->trae_activity_forgot_password I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->getRoot()Landroid/widget/ScrollView;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.ScrollView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityForgotPasswordBinding;->rootView Landroid/widget/ScrollView;
    return-object v0
.end method
