# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;
.super Ljava/lang/Object;
.source "FragmentAccountBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnDeleteAccount:Landroid/widget/LinearLayout;
.field public final btnDouyinAction:Landroid/widget/TextView;
.field public final btnPhoneAction:Landroid/widget/TextView;
.field public final cardDeleteAccount:Landroid/widget/LinearLayout;
.field public final cardLoginMethods:Landroid/widget/LinearLayout;
.field public final dividerPhone:Landroid/view/View;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final rowDouyin:Landroid/widget/LinearLayout;
.field public final rowPhone:Landroid/widget/LinearLayout;
.field public final switchPrivacyMode:Landroidx/appcompat/widget/SwitchCompat;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvDouyinSubtitle:Landroid/widget/TextView;
.field public final tvPhoneSubtitle:Landroid/widget/TextView;
.field public final tvPrivacyDesc:Landroid/widget/TextView;
.field public final tvPrivacyDetails:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.LinearLayout  android.widget.LinearLayout  android.view.View  android.widget.LinearLayout  android.widget.LinearLayout  androidx.appcompat.widget.SwitchCompat  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 16
    # ins_size=16
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->btnDeleteAccount Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->btnDouyinAction Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->btnPhoneAction Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->cardDeleteAccount Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->cardLoginMethods Landroid/widget/LinearLayout;
    iput-object v7, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->dividerPhone Landroid/view/View;
    iput-object v8, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->rowDouyin Landroid/widget/LinearLayout;
    iput-object v9, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->rowPhone Landroid/widget/LinearLayout;
    iput-object v10, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    iput-object v11, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v12, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->tvDouyinSubtitle Landroid/widget/TextView;
    iput-object v13, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->tvPhoneSubtitle Landroid/widget/TextView;
    iput-object v14, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->tvPrivacyDesc Landroid/widget/TextView;
    iput-object v15, v0, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->tvPrivacyDetails Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentAccountBinding
    .registers 20
    # ins_size=1
    move-object/from16 v0, v19
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_delete_account I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +09bh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_douyin_action I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +090h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_phone_action I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +085h
    sget v1, Lcom/bytedance/trae/home/R$id;->card_delete_account I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +07ah
    sget v1, Lcom/bytedance/trae/home/R$id;->card_login_methods I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +06fh
    sget v1, Lcom/bytedance/trae/home/R$id;->divider_phone I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v10
    if-eqz v10, +067h
    sget v1, Lcom/bytedance/trae/home/R$id;->row_douyin I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/LinearLayout;
    if-eqz v11, +05ch
    sget v1, Lcom/bytedance/trae/home/R$id;->row_phone I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/LinearLayout;
    if-eqz v12, +051h
    sget v1, Lcom/bytedance/trae/home/R$id;->switch_privacy_mode I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroidx/appcompat/widget/SwitchCompat;
    if-eqz v13, +046h
    sget v1, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v14, +03bh
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_douyin_subtitle I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/TextView;
    if-eqz v15, +030h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_phone_subtitle I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/TextView;
    if-eqz v16, +024h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_privacy_desc I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/TextView;
    if-eqz v17, +018h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_privacy_details I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroid/widget/TextView;
    if-eqz v18, +00ch
    new-instance v1, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    move-object v3, v1
    invoke-direct/range v3 ... v18, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/view/View; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroidx/appcompat/widget/SwitchCompat; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v19, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentAccountBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentAccountBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_account I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentAccountBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
