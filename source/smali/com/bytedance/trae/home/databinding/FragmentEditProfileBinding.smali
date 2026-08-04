# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;
.super Ljava/lang/Object;
.source "FragmentEditProfileBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnEditAvatar:Landroid/widget/FrameLayout;
.field public final btnEditName:Landroid/widget/LinearLayout;
.field public final dividerEmail:Landroid/view/View;
.field public final imgAvatarEditIndicator:Landroid/widget/ImageView;
.field public final ivAvatar:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final rowEmail:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvAccountLabel:Landroid/widget/TextView;
.field public final tvEmailValue:Landroid/widget/TextView;
.field public final tvNameValue:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.FrameLayout  android.widget.LinearLayout  android.view.View  android.widget.ImageView  com.facebook.drawee.view.SimpleDraweeView  android.widget.LinearLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 12
    # ins_size=12
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->btnEditAvatar Landroid/widget/FrameLayout;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->btnEditName Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->dividerEmail Landroid/view/View;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->imgAvatarEditIndicator Landroid/widget/ImageView;
    iput-object v6, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->ivAvatar Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v7, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->rowEmail Landroid/widget/LinearLayout;
    iput-object v8, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v9, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->tvAccountLabel Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->tvEmailValue Landroid/widget/TextView;
    iput-object v11, v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->tvNameValue Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentEditProfileBinding
    .registers 15
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_edit_avatar I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/FrameLayout;
    if-eqz v4, +06ch
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_edit_name I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +061h
    sget v0, Lcom/bytedance/trae/home/R$id;->divider_email I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v6
    if-eqz v6, +059h
    sget v0, Lcom/bytedance/trae/home/R$id;->img_avatar_edit_indicator I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/ImageView;
    if-eqz v7, +04eh
    sget v0, Lcom/bytedance/trae/home/R$id;->iv_avatar I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v8, +043h
    sget v0, Lcom/bytedance/trae/home/R$id;->row_email I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +038h
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v10, +02dh
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_account_label I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +022h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_email_value I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_name_value I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +00ch
    new-instance v0, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;
    move-object v3, v14
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/view/View; Landroid/widget/ImageView; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/LinearLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v14, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v14
    invoke-virtual v14, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v14
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v14, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    invoke-direct v0, v14, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentEditProfileBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentEditProfileBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_edit_profile I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentEditProfileBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
