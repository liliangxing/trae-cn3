# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;
.super Ljava/lang/Object;
.source "TraeItemToolListBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final flContent:Landroid/widget/FrameLayout;
.field public final ivChevronRight:Landroid/widget/ImageView;
.field public final ivIcon:Landroid/widget/ImageView;
.field public final llBody:Landroid/widget/LinearLayout;
.field public final llHeader:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvBadge:Landroid/widget/TextView;
.field public final tvIconEmoji:Landroid/widget/TextView;
.field public final tvSubtitle:Landroid/widget/TextView;
.field public final tvTitle:Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
.field public final vVerticalLine:Landroid/view/View;


.method private constructor <init>(android.widget.LinearLayout  android.widget.FrameLayout  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView  com.bytedance.trae.conversation.widget.ShimmerTextView  android.view.View)void
    .registers 12
    # ins_size=12
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->flContent Landroid/widget/FrameLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->ivChevronRight Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->ivIcon Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->llBody Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->llHeader Landroid/widget/LinearLayout;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->tvBadge Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->tvIconEmoji Landroid/widget/TextView;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->tvSubtitle Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->tvTitle Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->vVerticalLine Landroid/view/View;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemToolListBinding
    .registers 15
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->fl_content I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/FrameLayout;
    if-eqz v4, +06ch
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_chevron_right I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +061h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_icon I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +056h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_body I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +04bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_header I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +040h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_badge I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +035h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_icon_emoji I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +02ah
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +01fh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v12, +014h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->v_vertical_line I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v13
    if-eqz v13, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;
    move-object v3, v14
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/FrameLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Lcom/bytedance/trae/conversation/widget/ShimmerTextView; Landroid/view/View;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemToolListBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemToolListBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_tool_list I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemToolListBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
