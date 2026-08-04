# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;
.super Ljava/lang/Object;
.source "TraeActivityPhoneBindBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnSendCode:Landroid/widget/TextView;
.field public final btnSendCodeOld:Landroid/widget/TextView;
.field public final etOldPhone:Landroid/widget/EditText;
.field public final etPhone:Landroid/widget/EditText;
.field public final ivBack:Landroid/widget/ImageView;
.field public final loadingOverlay:Landroid/widget/FrameLayout;
.field public final navBar:Landroid/widget/LinearLayout;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final tvNavTitle:Landroid/widget/TextView;
.field public final tvNewPhoneTitle:Landroid/widget/TextView;
.field public final tvResendNew:Landroid/widget/TextView;
.field public final tvResendOld:Landroid/widget/TextView;
.field public final tvVerifyNewHint:Landroid/widget/TextView;
.field public final tvVerifyOldHint:Landroid/widget/TextView;
.field public final verifyNewInput:Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
.field public final verifyOldInput:Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
.field public final viewFlipper:Landroid/widget/ViewFlipper;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  android.widget.TextView  android.widget.TextView  android.widget.EditText  android.widget.EditText  android.widget.ImageView  android.widget.FrameLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  com.bytedance.trae.login.widget.VerifyCodeInputView  com.bytedance.trae.login.widget.VerifyCodeInputView  android.widget.ViewFlipper)void
    .registers 20
    # ins_size=18
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->btnSendCode Landroid/widget/TextView;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->btnSendCodeOld Landroid/widget/TextView;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->etOldPhone Landroid/widget/EditText;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->etPhone Landroid/widget/EditText;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->ivBack Landroid/widget/ImageView;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->loadingOverlay Landroid/widget/FrameLayout;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->navBar Landroid/widget/LinearLayout;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->tvNavTitle Landroid/widget/TextView;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->tvNewPhoneTitle Landroid/widget/TextView;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->tvResendNew Landroid/widget/TextView;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->tvResendOld Landroid/widget/TextView;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->tvVerifyNewHint Landroid/widget/TextView;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->tvVerifyOldHint Landroid/widget/TextView;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->verifyNewInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->verifyOldInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->viewFlipper Landroid/widget/ViewFlipper;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.login.databinding.TraeActivityPhoneBindBinding
    .registers 22
    # ins_size=1
    move-object/from16 v0, v21
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_send_code I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +0b6h
    sget v1, Lcom/bytedance/trae/login/R$id;->btn_send_code_old I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +0abh
    sget v1, Lcom/bytedance/trae/login/R$id;->et_old_phone I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/EditText;
    if-eqz v7, +0a0h
    sget v1, Lcom/bytedance/trae/login/R$id;->et_phone I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/EditText;
    if-eqz v8, +095h
    sget v1, Lcom/bytedance/trae/login/R$id;->iv_back I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/ImageView;
    if-eqz v9, +08ah
    sget v1, Lcom/bytedance/trae/login/R$id;->loading_overlay I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/FrameLayout;
    if-eqz v10, +07fh
    sget v1, Lcom/bytedance/trae/login/R$id;->nav_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/LinearLayout;
    if-eqz v11, +074h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_nav_title I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +069h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_new_phone_title I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +05eh
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_resend_new I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +053h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_resend_old I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/TextView;
    if-eqz v15, +048h
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_verify_new_hint I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/TextView;
    if-eqz v16, +03ch
    sget v1, Lcom/bytedance/trae/login/R$id;->tv_verify_old_hint I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/TextView;
    if-eqz v17, +030h
    sget v1, Lcom/bytedance/trae/login/R$id;->verify_new_input I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-eqz v18, +024h
    sget v1, Lcom/bytedance/trae/login/R$id;->verify_old_input I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    if-eqz v19, +018h
    sget v1, Lcom/bytedance/trae/login/R$id;->view_flipper I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/ViewFlipper;
    if-eqz v20, +00ch
    new-instance v1, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroidx/constraintlayout/widget/ConstraintLayout;
    invoke-direct/range v3 ... v20, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/ImageView; Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Lcom/bytedance/trae/login/widget/VerifyCodeInputView; Lcom/bytedance/trae/login/widget/VerifyCodeInputView; Landroid/widget/ViewFlipper;)V
    return-object v1
    invoke-virtual/range v21, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.login.databinding.TraeActivityPhoneBindBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.login.databinding.TraeActivityPhoneBindBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/login/R$layout;->trae_activity_phone_bind I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityPhoneBindBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
