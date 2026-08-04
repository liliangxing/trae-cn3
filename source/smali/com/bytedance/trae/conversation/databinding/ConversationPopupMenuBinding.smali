# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;
.super Ljava/lang/Object;
.source "ConversationPopupMenuBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final ivMenuPin:Landroid/widget/ImageView;
.field public final menuArtifact:Landroid/widget/LinearLayout;
.field public final menuDelete:Landroid/widget/LinearLayout;
.field public final menuDividerArtifact:Landroid/view/View;
.field public final menuDividerPin:Landroid/view/View;
.field public final menuPin:Landroid/widget/LinearLayout;
.field public final menuRename:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvMenuPin:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.view.View  android.view.View  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->ivMenuPin Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->menuArtifact Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->menuDelete Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->menuDividerArtifact Landroid/view/View;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->menuDividerPin Landroid/view/View;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->menuPin Landroid/widget/LinearLayout;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->menuRename Landroid/widget/LinearLayout;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->tvMenuPin Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.ConversationPopupMenuBinding
    .registers 13
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_menu_pin I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ImageView;
    if-eqz v4, +053h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_artifact I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +048h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_delete I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +03dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_divider_artifact I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v7
    if-eqz v7, +035h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_divider_pin I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v8
    if-eqz v8, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_pin I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_rename I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_menu_pin I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;
    move-object v3, v12
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/view/View; Landroid/view/View; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView;)V
    return-object v0
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.ConversationPopupMenuBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.ConversationPopupMenuBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->conversation_popup_menu I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/ConversationPopupMenuBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
