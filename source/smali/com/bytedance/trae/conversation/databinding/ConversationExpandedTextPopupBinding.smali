# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;
.super Ljava/lang/Object;
.source "ConversationExpandedTextPopupBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final dividerDelete:Landroid/view/View;
.field public final dividerRevert:Landroid/view/View;
.field public final llMenuContainer:Landroid/widget/LinearLayout;
.field public final menuCopy:Landroid/widget/LinearLayout;
.field public final menuDelete:Landroid/widget/LinearLayout;
.field public final menuRevert:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final svTextContent:Landroid/widget/ScrollView;
.field public final tvFullText:Landroid/widget/TextView;


.method private constructor <init>(android.widget.FrameLayout  android.view.View  android.view.View  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ScrollView  android.widget.TextView)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->dividerDelete Landroid/view/View;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->dividerRevert Landroid/view/View;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->llMenuContainer Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->menuCopy Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->menuDelete Landroid/widget/LinearLayout;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->menuRevert Landroid/widget/LinearLayout;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->svTextContent Landroid/widget/ScrollView;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->tvFullText Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.ConversationExpandedTextPopupBinding
    .registers 12
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->divider_delete I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +056h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->divider_revert I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v4
    if-eqz v4, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_menu_container I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_copy I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_delete I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_revert I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->sv_text_content I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/ScrollView;
    if-eqz v9, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_full_text I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;
    move-object v2, v11
    check-cast v2, Landroid/widget/FrameLayout;
    move-object v1, v0
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;-><init>(Landroid/widget/FrameLayout; Landroid/view/View; Landroid/view/View; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ScrollView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.ConversationExpandedTextPopupBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.ConversationExpandedTextPopupBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->conversation_expanded_text_popup I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/ConversationExpandedTextPopupBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
