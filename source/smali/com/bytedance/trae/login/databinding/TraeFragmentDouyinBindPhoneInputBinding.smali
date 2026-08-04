# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
.super Ljava/lang/Object;
.source "TraeFragmentDouyinBindPhoneInputBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnSendCode:Landroid/widget/TextView;
.field public final etPhone:Landroid/widget/EditText;
.field public final pbLoading:Landroid/widget/ProgressBar;
.field public final phoneInputGroup:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvCountryCode:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.EditText  android.widget.ProgressBar  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->btnSendCode Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->etPhone Landroid/widget/EditText;
    iput-object v4, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->pbLoading Landroid/widget/ProgressBar;
    iput-object v5, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->phoneInputGroup Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->tvCountryCode Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->tvTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.login.databinding.TraeFragmentDouyinBindPhoneInputBinding
    .registers 11
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_send_code I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/TextView;
    if-eqz v4, +043h
    sget v0, Lcom/bytedance/trae/login/R$id;->et_phone I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/EditText;
    if-eqz v5, +038h
    sget v0, Lcom/bytedance/trae/login/R$id;->pb_loading I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ProgressBar;
    if-eqz v6, +02dh
    sget v0, Lcom/bytedance/trae/login/R$id;->phone_input_group I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +022h
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_country_code I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +017h
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_title I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +00ch
    new-instance v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-object v3, v10
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/EditText; Landroid/widget/ProgressBar; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v10, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v10
    invoke-virtual v10, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v10
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v10, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    invoke-direct v0, v10, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.login.databinding.TraeFragmentDouyinBindPhoneInputBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.login.databinding.TraeFragmentDouyinBindPhoneInputBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/login/R$layout;->trae_fragment_douyin_bind_phone_input I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
