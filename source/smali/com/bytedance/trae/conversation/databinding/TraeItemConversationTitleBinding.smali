# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;
.super Ljava/lang/Object;
.source "TraeItemConversationTitleBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final containerInner:Landroid/widget/LinearLayout;
.field public final containerMetadata:Landroid/widget/LinearLayout;
.field public final containerTaskHeader:Landroid/widget/LinearLayout;
.field public final ivCloudIcon:Landroid/widget/ImageView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvCloudDot:Landroid/widget/TextView;
.field public final tvCloudName:Landroid/widget/TextView;
.field public final tvCloudText:Landroid/widget/TextView;
.field public final tvTaskName:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ImageView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->containerInner Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->containerMetadata Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->containerTaskHeader Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->ivCloudIcon Landroid/widget/ImageView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->tvCloudDot Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->tvCloudName Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->tvCloudText Landroid/widget/TextView;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->tvTaskName Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemConversationTitleBinding
    .registers 13
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->container_inner I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +04fh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->container_metadata I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +044h
    move-object v6, v12
    check-cast v6, Landroid/widget/LinearLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_cloud_icon I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/ImageView;
    if-eqz v7, +036h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_cloud_dot I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +02bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_cloud_name I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +020h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_cloud_text I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +015h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_task_name I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +00ah
    new-instance v12, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;
    move-object v2, v12
    move-object v3, v6
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v12
    invoke-virtual v12, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    invoke-virtual v12, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v12
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v12, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    invoke-direct v0, v12, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemConversationTitleBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemConversationTitleBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_conversation_title I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemConversationTitleBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
