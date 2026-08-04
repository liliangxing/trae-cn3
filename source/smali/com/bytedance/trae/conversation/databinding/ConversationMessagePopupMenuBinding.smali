# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;
.super Ljava/lang/Object;
.source "ConversationMessagePopupMenuBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final dividerDelete:Landroid/view/View;
.field public final dividerRevert:Landroid/view/View;
.field public final menuCopy:Landroid/widget/LinearLayout;
.field public final menuDelete:Landroid/widget/LinearLayout;
.field public final menuRevert:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;


.method private constructor <init>(android.widget.LinearLayout  android.view.View  android.view.View  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;->dividerDelete Landroid/view/View;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;->dividerRevert Landroid/view/View;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;->menuCopy Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;->menuDelete Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;->menuRevert Landroid/widget/LinearLayout;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.ConversationMessagePopupMenuBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->divider_delete I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +035h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->divider_revert I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v4
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_copy I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_delete I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_revert I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;
    move-object v2, v8
    check-cast v2, Landroid/widget/LinearLayout;
    move-object v1, v0
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;-><init>(Landroid/widget/LinearLayout; Landroid/view/View; Landroid/view/View; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout;)V
    return-object v0
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    invoke-virtual v8, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v8
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v8, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-direct v0, v8, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.ConversationMessagePopupMenuBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.ConversationMessagePopupMenuBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->conversation_message_popup_menu I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/ConversationMessagePopupMenuBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
