# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;
.super Ljava/lang/Object;
.source "TraeFragmentTodoGroupDetailBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final llContent:Landroid/widget/LinearLayout;
.field private final rootView:Landroidx/core/widget/NestedScrollView;
.field public final tvTodoTitle:Landroid/widget/TextView;


.method private constructor <init>(androidx.core.widget.NestedScrollView  android.widget.LinearLayout  android.widget.TextView)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;->rootView Landroidx/core/widget/NestedScrollView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;->llContent Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;->tvTodoTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeFragmentTodoGroupDetailBinding
    .registers 4
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_content I
    invoke-static v3, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/LinearLayout;
    if-eqz v1, +014h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_todo_title I
    invoke-static v3, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    if-eqz v2, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;
    check-cast v3, Landroidx/core/widget/NestedScrollView;
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;-><init>(Landroidx/core/widget/NestedScrollView; Landroid/widget/LinearLayout; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v3, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v3
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v3, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v3, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeFragmentTodoGroupDetailBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeFragmentTodoGroupDetailBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_todo_group_detail I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;->getRoot()Landroidx/core/widget/NestedScrollView;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.core.widget.NestedScrollView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentTodoGroupDetailBinding;->rootView Landroidx/core/widget/NestedScrollView;
    return-object v0
.end method
