# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;
.super Ljava/lang/Object;
.source "TraeFragmentLoginEntryBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final agreementContainer:Landroid/widget/LinearLayout;
.field public final bottomLoginContainer:Landroid/widget/LinearLayout;
.field public final btnBytecloudSso:Landroid/widget/TextView;
.field public final btnDouyinLogin:Landroid/widget/FrameLayout;
.field public final btnEnterpriseLogin:Landroid/widget/TextView;
.field public final btnPhoneLogin:Landroid/widget/FrameLayout;
.field public final dividerLoginLinks:Landroid/view/View;
.field public final ivAgreementCheck:Landroid/widget/ImageView;
.field public final privacyPolicyText:Lcom/bytedance/trae/common/widget/UrlSpanTextView;
.field private final rootView:Landroid/widget/LinearLayout;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.FrameLayout  android.widget.TextView  android.widget.FrameLayout  android.view.View  android.widget.ImageView  com.bytedance.trae.common.widget.UrlSpanTextView)void
    .registers 11
    # ins_size=11
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->agreementContainer Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->bottomLoginContainer Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->btnBytecloudSso Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->btnDouyinLogin Landroid/widget/FrameLayout;
    iput-object v6, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->btnEnterpriseLogin Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->btnPhoneLogin Landroid/widget/FrameLayout;
    iput-object v8, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->dividerLoginLinks Landroid/view/View;
    iput-object v9, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->ivAgreementCheck Landroid/widget/ImageView;
    iput-object v10, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->privacyPolicyText Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.login.databinding.TraeFragmentLoginEntryBinding
    .registers 14
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->agreement_container I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +061h
    sget v0, Lcom/bytedance/trae/login/R$id;->bottom_login_container I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +056h
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_bytecloud_sso I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +04bh
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_douyin_login I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/FrameLayout;
    if-eqz v7, +040h
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_enterprise_login I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +035h
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_phone_login I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/FrameLayout;
    if-eqz v9, +02ah
    sget v0, Lcom/bytedance/trae/login/R$id;->divider_login_links I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v10
    if-eqz v10, +022h
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_agreement_check I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/ImageView;
    if-eqz v11, +017h
    sget v0, Lcom/bytedance/trae/login/R$id;->privacy_policy_text I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    if-eqz v12, +00ch
    new-instance v0, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;
    move-object v3, v13
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v12, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/FrameLayout; Landroid/widget/TextView; Landroid/widget/FrameLayout; Landroid/view/View; Landroid/widget/ImageView; Lcom/bytedance/trae/common/widget/UrlSpanTextView;)V
    return-object v0
    invoke-virtual v13, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v13
    invoke-virtual v13, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v13
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v13, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    invoke-direct v0, v13, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.login.databinding.TraeFragmentLoginEntryBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.login.databinding.TraeFragmentLoginEntryBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/login/R$layout;->trae_fragment_login_entry I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeFragmentLoginEntryBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
