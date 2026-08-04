# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;
.super Ljava/lang/Object;
.source "TraeFragmentVerifyCodeBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final etCode1:Landroid/widget/EditText;
.field public final etCode2:Landroid/widget/EditText;
.field public final etCode3:Landroid/widget/EditText;
.field public final etCode4:Landroid/widget/EditText;
.field public final etCode5:Landroid/widget/EditText;
.field public final etCode6:Landroid/widget/EditText;
.field public final ivBack:Landroid/widget/ImageView;
.field public final navBar:Landroidx/constraintlayout/widget/ConstraintLayout;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final tvPhone:Landroid/widget/TextView;
.field public final tvResend:Landroid/widget/TextView;
.field public final tvSubtitle:Landroid/widget/TextView;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  android.widget.EditText  android.widget.EditText  android.widget.EditText  android.widget.EditText  android.widget.EditText  android.widget.EditText  android.widget.ImageView  androidx.constraintlayout.widget.ConstraintLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->etCode1 Landroid/widget/EditText;
    iput-object v3, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->etCode2 Landroid/widget/EditText;
    iput-object v4, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->etCode3 Landroid/widget/EditText;
    iput-object v5, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->etCode4 Landroid/widget/EditText;
    iput-object v6, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->etCode5 Landroid/widget/EditText;
    iput-object v7, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->etCode6 Landroid/widget/EditText;
    iput-object v8, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->ivBack Landroid/widget/ImageView;
    iput-object v9, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->navBar Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v10, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->tvPhone Landroid/widget/TextView;
    iput-object v11, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    iput-object v12, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->tvSubtitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.login.databinding.TraeFragmentVerifyCodeBinding
    .registers 16
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->et_code_1 I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/EditText;
    if-eqz v4, +07ah
    sget v0, Lcom/bytedance/trae/login/R$id;->et_code_2 I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/EditText;
    if-eqz v5, +06fh
    sget v0, Lcom/bytedance/trae/login/R$id;->et_code_3 I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/EditText;
    if-eqz v6, +064h
    sget v0, Lcom/bytedance/trae/login/R$id;->et_code_4 I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/EditText;
    if-eqz v7, +059h
    sget v0, Lcom/bytedance/trae/login/R$id;->et_code_5 I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/EditText;
    if-eqz v8, +04eh
    sget v0, Lcom/bytedance/trae/login/R$id;->et_code_6 I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/EditText;
    if-eqz v9, +043h
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_back I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/ImageView;
    if-eqz v10, +038h
    sget v0, Lcom/bytedance/trae/login/R$id;->nav_bar I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroidx/constraintlayout/widget/ConstraintLayout;
    if-eqz v11, +02dh
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_phone I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +022h
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_resend I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +017h
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_subtitle I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v14, v1
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +00ch
    new-instance v0, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;
    move-object v3, v15
    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v14, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/ImageView; Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v15, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v15
    invoke-virtual v15, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v15
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v15, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    invoke-direct v0, v15, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.login.databinding.TraeFragmentVerifyCodeBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.login.databinding.TraeFragmentVerifyCodeBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/login/R$layout;->trae_fragment_verify_code I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentVerifyCodeBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
