# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/PopupMessageDeleteBinding;
.super Ljava/lang/Object;
.source "PopupMessageDeleteBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field private final rootView:Landroid/widget/LinearLayout;


.method private constructor <init>(android.widget.LinearLayout)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/PopupMessageDeleteBinding;->rootView Landroid/widget/LinearLayout;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.PopupMessageDeleteBinding
    .registers 2
    # ins_size=1
    if-eqz v1, +00ah
    new-instance v0, Lcom/bytedance/trae/home/databinding/PopupMessageDeleteBinding;
    check-cast v1, Landroid/widget/LinearLayout;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/databinding/PopupMessageDeleteBinding;-><init>(Landroid/widget/LinearLayout;)V
    return-object v0
    new-instance v1, Ljava/lang/NullPointerException;
    const-string/jumbo v0, rootView
    invoke-direct v1, v0, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.PopupMessageDeleteBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/PopupMessageDeleteBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/PopupMessageDeleteBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.PopupMessageDeleteBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->popup_message_delete I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/PopupMessageDeleteBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/PopupMessageDeleteBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/PopupMessageDeleteBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/PopupMessageDeleteBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
