# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;
.super Ljava/lang/Object;
.source "TraeExpressPassPopWindowBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final expressPassClose:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final tvExpressPassSubtitle:Landroid/widget/TextView;
.field public final tvExpressPassTitle:Landroid/widget/TextView;


.method private constructor <init>(android.widget.FrameLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;->expressPassClose Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;->tvExpressPassSubtitle Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;->tvExpressPassTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeExpressPassPopWindowBinding
    .registers 5
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->express_pass_close I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/LinearLayout;
    if-eqz v1, +01eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_express_pass_subtitle I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    if-eqz v2, +014h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_express_pass_title I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    if-eqz v3, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;
    check-cast v4, Landroid/widget/FrameLayout;
    invoke-direct v0, v4, v1, v2, v3, Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v4, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v4
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v4, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v4, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeExpressPassPopWindowBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeExpressPassPopWindowBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_express_pass_pop_window I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeExpressPassPopWindowBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
