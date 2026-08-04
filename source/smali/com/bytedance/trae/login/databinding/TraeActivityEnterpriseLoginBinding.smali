# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;
.super Ljava/lang/Object;
.source "TraeActivityEnterpriseLoginBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnBack:Landroid/widget/ImageView;
.field public final btnBackPassword:Landroid/widget/ImageView;
.field public final btnContinue:Landroid/widget/Button;
.field public final btnLogin:Landroid/widget/Button;
.field public final btnSsoLogin:Landroid/widget/FrameLayout;
.field public final etEmailStep1:Landroid/widget/EditText;
.field public final etPassword:Landroid/widget/EditText;
.field public final ivClearEmail:Landroid/widget/ImageView;
.field public final ivClearPassword:Landroid/widget/ImageView;
.field public final ivTogglePassword:Landroid/widget/ImageView;
.field public final layoutEmailInput:Landroid/widget/LinearLayout;
.field public final layoutErrorEmail:Landroid/widget/LinearLayout;
.field public final layoutErrorPassword:Landroid/widget/LinearLayout;
.field public final layoutOrDivider:Landroid/widget/LinearLayout;
.field public final layoutPasswordInput:Landroid/widget/LinearLayout;
.field public final layoutStepEmail:Landroid/widget/LinearLayout;
.field public final layoutStepPassword:Landroid/widget/LinearLayout;
.field public final pbLoading:Landroid/widget/ProgressBar;
.field public final pbLoadingEmail:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/ScrollView;
.field public final tvEmailDisplay:Landroid/widget/TextView;
.field public final tvError:Landroid/widget/TextView;
.field public final tvErrorEmail:Landroid/widget/TextView;
.field public final tvForgotPassword:Landroid/widget/TextView;
.field public final tvStep2Title:Landroid/widget/TextView;


.method private constructor <init>(android.widget.ScrollView  android.widget.ImageView  android.widget.ImageView  android.widget.Button  android.widget.Button  android.widget.FrameLayout  android.widget.EditText  android.widget.EditText  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ProgressBar  android.widget.ProgressBar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 28
    # ins_size=26
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->rootView Landroid/widget/ScrollView;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->btnBack Landroid/widget/ImageView;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->btnBackPassword Landroid/widget/ImageView;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->btnContinue Landroid/widget/Button;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->btnLogin Landroid/widget/Button;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->btnSsoLogin Landroid/widget/FrameLayout;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->etEmailStep1 Landroid/widget/EditText;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->etPassword Landroid/widget/EditText;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->ivClearEmail Landroid/widget/ImageView;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->ivClearPassword Landroid/widget/ImageView;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->ivTogglePassword Landroid/widget/ImageView;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->layoutEmailInput Landroid/widget/LinearLayout;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->layoutErrorEmail Landroid/widget/LinearLayout;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->layoutErrorPassword Landroid/widget/LinearLayout;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->layoutOrDivider Landroid/widget/LinearLayout;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->layoutPasswordInput Landroid/widget/LinearLayout;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->layoutStepEmail Landroid/widget/LinearLayout;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->layoutStepPassword Landroid/widget/LinearLayout;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->pbLoading Landroid/widget/ProgressBar;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->pbLoadingEmail Landroid/widget/ProgressBar;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->tvEmailDisplay Landroid/widget/TextView;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->tvError Landroid/widget/TextView;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->tvErrorEmail Landroid/widget/TextView;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->tvForgotPassword Landroid/widget/TextView;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->tvStep2Title Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.login.databinding.TraeActivityEnterpriseLoginBinding
    .registers 30
    # ins_size=1
    move-object/from16 v0, v29
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_back I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +116h
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_back_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +10bh
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_continue I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/Button;
    if-eqz v7, +100h
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_login I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/Button;
    if-eqz v8, +0f5h
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_sso_login I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/FrameLayout;
    if-eqz v9, +0eah
    sget v1, Lcom/bytedance/trae/login/R$id;->et_email_step1 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/EditText;
    if-eqz v10, +0dfh
    sget v1, Lcom/bytedance/trae/login/R$id;->et_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/EditText;
    if-eqz v11, +0d4h
    sget v1, Lcom/bytedance/trae/login/R$id;->iv_clear_email I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/ImageView;
    if-eqz v12, +0c9h
    sget v1, Lcom/bytedance/trae/login/R$id;->iv_clear_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/ImageView;
    if-eqz v13, +0beh
    sget v1, Lcom/bytedance/trae/login/R$id;->iv_toggle_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/ImageView;
    if-eqz v14, +0b3h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_email_input I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/LinearLayout;
    if-eqz v15, +0a8h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_error_email I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/LinearLayout;
    if-eqz v16, +09ch
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_error_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/LinearLayout;
    if-eqz v17, +090h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_or_divider I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroid/widget/LinearLayout;
    if-eqz v18, +084h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_password_input I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroid/widget/LinearLayout;
    if-eqz v19, +078h
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_step_email I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/LinearLayout;
    if-eqz v20, +06ch
    sget v1, Lcom/bytedance/trae/login/R$id;->layout_step_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v21, v2
    check-cast v21, Landroid/widget/LinearLayout;
    if-eqz v21, +060h
    sget v1, Lcom/bytedance/trae/login/R$id;->pb_loading I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v22, v2
    check-cast v22, Landroid/widget/ProgressBar;
    if-eqz v22, +054h
    sget v1, Lcom/bytedance/trae/login/R$id;->pb_loading_email I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v23, v2
    check-cast v23, Landroid/widget/ProgressBar;
    if-eqz v23, +048h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_email_display I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v24, v2
    check-cast v24, Landroid/widget/TextView;
    if-eqz v24, +03ch
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_error I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v25, v2
    check-cast v25, Landroid/widget/TextView;
    if-eqz v25, +030h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_error_email I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v26, v2
    check-cast v26, Landroid/widget/TextView;
    if-eqz v26, +024h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_forgot_password I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v27, v2
    check-cast v27, Landroid/widget/TextView;
    if-eqz v27, +018h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_step2_title I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v28, v2
    check-cast v28, Landroid/widget/TextView;
    if-eqz v28, +00ch
    new-instance v1, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/ScrollView;
    invoke-direct/range v3 ... v28, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;-><init>(Landroid/widget/ScrollView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/Button; Landroid/widget/Button; Landroid/widget/FrameLayout; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Landroid/widget/ProgressBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v29, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.login.databinding.TraeActivityEnterpriseLoginBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.login.databinding.TraeActivityEnterpriseLoginBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/login/R$layout;->trae_activity_enterprise_login I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->getRoot()Landroid/widget/ScrollView;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.ScrollView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityEnterpriseLoginBinding;->rootView Landroid/widget/ScrollView;
    return-object v0
.end method
