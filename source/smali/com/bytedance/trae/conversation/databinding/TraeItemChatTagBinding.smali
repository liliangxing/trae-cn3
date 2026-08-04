# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;
.super Ljava/lang/Object;
.source "TraeItemChatTagBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field private final rootView:Landroid/widget/TextView;
.field public final tvTag:Landroid/widget/TextView;


.method private constructor <init>(android.widget.TextView  android.widget.TextView)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;->rootView Landroid/widget/TextView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;->tvTag Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemChatTagBinding
    .registers 2
    # ins_size=1
    if-eqz v1, +00ah
    check-cast v1, Landroid/widget/TextView;
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;
    invoke-direct v0, v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;-><init>(Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    new-instance v1, Ljava/lang/NullPointerException;
    const-string/jumbo v0, rootView
    invoke-direct v1, v0, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemChatTagBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemChatTagBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_chat_tag I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;->getRoot()Landroid/widget/TextView;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.TextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemChatTagBinding;->rootView Landroid/widget/TextView;
    return-object v0
.end method
