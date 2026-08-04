# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;
.super Ljava/lang/Object;
.source "TraeActivityBrainstormBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final brainstormFragmentContainer:Landroid/widget/FrameLayout;
.field private final rootView:Landroid/widget/FrameLayout;


.method private constructor <init>(android.widget.FrameLayout  android.widget.FrameLayout)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;->brainstormFragmentContainer Landroid/widget/FrameLayout;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeActivityBrainstormBinding
    .registers 2
    # ins_size=1
    if-eqz v1, +00ah
    check-cast v1, Landroid/widget/FrameLayout;
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;
    invoke-direct v0, v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/FrameLayout;)V
    return-object v0
    new-instance v1, Ljava/lang/NullPointerException;
    const-string/jumbo v0, rootView
    invoke-direct v1, v0, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeActivityBrainstormBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeActivityBrainstormBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_brainstorm I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityBrainstormBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
