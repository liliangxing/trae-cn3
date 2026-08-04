# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;
.super Ljava/lang/Object;
.source "TraeItemBrainstormSubtitleBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final ivSubtaskLoading:Landroid/widget/ImageView;
.field public final ivSubtaskStatusIcon:Landroid/widget/ImageView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final subtaskBadgeContainer:Landroid/widget/LinearLayout;
.field public final tvSubtaskStatusText:Landroid/widget/TextView;
.field public final tvSubtitleContent:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;->ivSubtaskLoading Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;->ivSubtaskStatusIcon Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;->subtaskBadgeContainer Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;->tvSubtaskStatusText Landroid/widget/TextView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;->tvSubtitleContent Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemBrainstormSubtitleBinding
    .registers 10
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_subtask_loading I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ImageView;
    if-eqz v4, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_subtask_status_icon I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->subtask_badge_container I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_subtask_status_text I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle_content I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;
    move-object v3, v9
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v9, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    invoke-virtual v9, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v9
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v9, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-direct v0, v9, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemBrainstormSubtitleBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemBrainstormSubtitleBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_subtitle I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormSubtitleBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
