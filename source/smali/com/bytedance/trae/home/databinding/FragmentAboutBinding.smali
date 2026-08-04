# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;
.super Ljava/lang/Object;
.source "FragmentAboutBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnBusinessLicense:Landroid/widget/LinearLayout;
.field public final btnCommunity:Landroid/widget/LinearLayout;
.field public final btnContact:Landroid/widget/LinearLayout;
.field public final btnHelp:Landroid/widget/LinearLayout;
.field public final btnIcpFiling:Landroid/widget/LinearLayout;
.field public final btnOpensource:Landroid/widget/LinearLayout;
.field public final btnPermissionUsage:Landroid/widget/LinearLayout;
.field public final btnPersonalInfoList:Landroid/widget/LinearLayout;
.field public final btnPrivacy:Landroid/widget/LinearLayout;
.field public final btnShareList:Landroid/widget/LinearLayout;
.field public final btnTerms:Landroid/widget/LinearLayout;
.field public final dividerCommunity:Landroid/view/View;
.field public final dividerIcp:Landroid/view/View;
.field public final dividerLicense:Landroid/view/View;
.field public final dividerPermission:Landroid/view/View;
.field public final dividerPersonalInfo:Landroid/view/View;
.field public final dividerShareList:Landroid/view/View;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvVersion:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.view.View  android.view.View  android.view.View  android.view.View  android.view.View  android.view.View  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView)void
    .registers 23
    # ins_size=21
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->rootView Landroid/widget/LinearLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnBusinessLicense Landroid/widget/LinearLayout;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnCommunity Landroid/widget/LinearLayout;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnContact Landroid/widget/LinearLayout;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnHelp Landroid/widget/LinearLayout;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnIcpFiling Landroid/widget/LinearLayout;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnOpensource Landroid/widget/LinearLayout;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnPermissionUsage Landroid/widget/LinearLayout;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnPersonalInfoList Landroid/widget/LinearLayout;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnPrivacy Landroid/widget/LinearLayout;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnShareList Landroid/widget/LinearLayout;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->btnTerms Landroid/widget/LinearLayout;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->dividerCommunity Landroid/view/View;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->dividerIcp Landroid/view/View;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->dividerLicense Landroid/view/View;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->dividerPermission Landroid/view/View;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->dividerPersonalInfo Landroid/view/View;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->dividerShareList Landroid/view/View;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->tvVersion Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentAboutBinding
    .registers 25
    # ins_size=1
    move-object/from16 v0, v24
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_business_license I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +0c2h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_community I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +0b7h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_contact I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +0ach
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_help I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +0a1h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_icp_filing I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +096h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_opensource I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +08bh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_permission_usage I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/LinearLayout;
    if-eqz v11, +080h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_personal_info_list I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/LinearLayout;
    if-eqz v12, +075h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_privacy I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/LinearLayout;
    if-eqz v13, +06ah
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_share_list I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/LinearLayout;
    if-eqz v14, +05fh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_terms I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/LinearLayout;
    if-eqz v15, +054h
    sget v1, Lcom/bytedance/trae/home/R$id;->divider_community I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v16
    if-eqz v16, +04ch
    sget v1, Lcom/bytedance/trae/home/R$id;->divider_icp I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v17
    if-eqz v17, +044h
    sget v1, Lcom/bytedance/trae/home/R$id;->divider_license I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v18
    if-eqz v18, +03ch
    sget v1, Lcom/bytedance/trae/home/R$id;->divider_permission I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v19
    if-eqz v19, +034h
    sget v1, Lcom/bytedance/trae/home/R$id;->divider_personal_info I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v20
    if-eqz v20, +02ch
    sget v1, Lcom/bytedance/trae/home/R$id;->divider_share_list I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v21
    if-eqz v21, +024h
    sget v1, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v22, v2
    check-cast v22, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v22, +018h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_version I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v23, v2
    check-cast v23, Landroid/widget/TextView;
    if-eqz v23, +00ch
    new-instance v1, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct/range v3 ... v23, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v24, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentAboutBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentAboutBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_about I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentAboutBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
