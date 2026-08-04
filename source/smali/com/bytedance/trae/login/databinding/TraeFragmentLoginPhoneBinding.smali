# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
.super Ljava/lang/Object;
.source "TraeFragmentLoginPhoneBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnBack:Landroid/widget/ImageView;
.field public final btnContainer:Landroid/widget/FrameLayout;
.field public final btnGetCode:Landroid/widget/Button;
.field public final cbAgreement:Landroid/widget/CheckBox;
.field public final etPhone:Landroid/widget/EditText;
.field public final ivClear:Landroid/widget/ImageView;
.field public final llPhoneInput:Landroid/widget/LinearLayout;
.field public final pbLoading:Landroid/widget/ProgressBar;
.field public final privacyPolicyText:Lcom/bytedance/trae/common/widget/UrlSpanTextView;
.field private final rootView:Landroid/widget/ScrollView;
.field public final tvCountryCode:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;


.method private constructor <init>(android.widget.ScrollView  android.widget.ImageView  android.widget.FrameLayout  android.widget.Button  android.widget.CheckBox  android.widget.EditText  android.widget.ImageView  android.widget.LinearLayout  android.widget.ProgressBar  com.bytedance.trae.common.widget.UrlSpanTextView  android.widget.TextView  android.widget.TextView)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->rootView Landroid/widget/ScrollView;
    iput-object v2, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnBack Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnContainer Landroid/widget/FrameLayout;
    iput-object v4, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->btnGetCode Landroid/widget/Button;
    iput-object v5, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->cbAgreement Landroid/widget/CheckBox;
    iput-object v6, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->etPhone Landroid/widget/EditText;
    iput-object v7, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->ivClear Landroid/widget/ImageView;
    iput-object v8, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->llPhoneInput Landroid/widget/LinearLayout;
    iput-object v9, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->pbLoading Landroid/widget/ProgressBar;
    iput-object v10, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->privacyPolicyText Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    iput-object v11, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->tvCountryCode Landroid/widget/TextView;
    iput-object v12, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->tvTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.login.databinding.TraeFragmentLoginPhoneBinding
    .registers 16
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_back I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ImageView;
    if-eqz v4, +07ah
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/FrameLayout;
    if-eqz v5, +06fh
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_get_code I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/Button;
    if-eqz v6, +064h
    sget v0, Lcom/bytedance/trae/login/R$id;->cb_agreement I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/CheckBox;
    if-eqz v7, +059h
    sget v0, Lcom/bytedance/trae/login/R$id;->et_phone I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/EditText;
    if-eqz v8, +04eh
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_clear I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/ImageView;
    if-eqz v9, +043h
    sget v0, Lcom/bytedance/trae/login/R$id;->ll_phone_input I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +038h
    sget v0, Lcom/bytedance/trae/login/R$id;->pb_loading I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/ProgressBar;
    if-eqz v11, +02dh
    sget v0, Lcom/bytedance/trae/login/R$id;->privacy_policy_text I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    if-eqz v12, +022h
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_country_code I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +017h
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_title I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v14, v1
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +00ch
    new-instance v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-object v3, v15
    check-cast v3, Landroid/widget/ScrollView;
    move-object v2, v0
    invoke-direct/range v2 ... v14, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;-><init>(Landroid/widget/ScrollView; Landroid/widget/ImageView; Landroid/widget/FrameLayout; Landroid/widget/Button; Landroid/widget/CheckBox; Landroid/widget/EditText; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Lcom/bytedance/trae/common/widget/UrlSpanTextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.login.databinding.TraeFragmentLoginPhoneBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.login.databinding.TraeFragmentLoginPhoneBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/login/R$layout;->trae_fragment_login_phone I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->getRoot()Landroid/widget/ScrollView;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.ScrollView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;->rootView Landroid/widget/ScrollView;
    return-object v0
.end method
