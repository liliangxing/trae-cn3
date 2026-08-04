# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;
.super Ljava/lang/Object;
.source "FragmentSiteMessageSettingsBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final loading:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final scrollView:Landroid/widget/ScrollView;
.field public final stackView:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ProgressBar  android.widget.ScrollView  android.widget.LinearLayout  com.bytedance.trae.common.widget.TraeTitleBar)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;->loading Landroid/widget/ProgressBar;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;->scrollView Landroid/widget/ScrollView;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;->stackView Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentSiteMessageSettingsBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->loading I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ProgressBar;
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/home/R$id;->scroll_view I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ScrollView;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/home/R$id;->stack_view I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;
    move-object v3, v8
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Landroid/widget/ScrollView; Landroid/widget/LinearLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar;)V
    return-object v0
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    invoke-virtual v8, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v8
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v8, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-direct v0, v8, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentSiteMessageSettingsBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentSiteMessageSettingsBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_site_message_settings I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageSettingsBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
