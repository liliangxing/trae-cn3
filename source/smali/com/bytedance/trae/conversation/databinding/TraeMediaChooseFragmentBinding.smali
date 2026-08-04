# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
.super Ljava/lang/Object;
.source "TraeMediaChooseFragmentBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final bottomBar:Landroid/widget/LinearLayout;
.field public final btnPreview:Landroid/widget/TextView;
.field public final btnSend:Landroid/widget/TextView;
.field public final cbOrigin:Landroid/widget/CheckBox;
.field public final partialPermissionNotice:Landroid/widget/TextView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final rv:Landroidx/recyclerview/widget/RecyclerView;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.CheckBox  android.widget.TextView  androidx.recyclerview.widget.RecyclerView  com.bytedance.trae.common.widget.TraeTitleBar)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->bottomBar Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->btnPreview Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->btnSend Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->cbOrigin Landroid/widget/CheckBox;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->partialPermissionNotice Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->rv Landroidx/recyclerview/widget/RecyclerView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeMediaChooseFragmentBinding
    .registers 12
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->bottom_bar I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_preview I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_send I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->cb_origin I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/CheckBox;
    if-eqz v7, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->partial_permission_notice I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v9, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v10, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-object v3, v11
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/CheckBox; Landroid/widget/TextView; Landroidx/recyclerview/widget/RecyclerView; Lcom/bytedance/trae/common/widget/TraeTitleBar;)V
    return-object v0
    invoke-virtual v11, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v11
    invoke-virtual v11, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v11
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v11, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    invoke-direct v0, v11, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeMediaChooseFragmentBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeMediaChooseFragmentBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_media_choose_fragment I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
