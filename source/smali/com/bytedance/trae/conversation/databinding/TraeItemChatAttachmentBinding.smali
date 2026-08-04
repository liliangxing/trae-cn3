# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;
.super Ljava/lang/Object;
.source "TraeItemChatAttachmentBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final ivFileIcon:Landroid/widget/ImageView;
.field private final rootView:Landroidx/cardview/widget/CardView;
.field public final tvFileExt:Landroid/widget/TextView;
.field public final tvFilename:Landroid/widget/TextView;


.method private constructor <init>(androidx.cardview.widget.CardView  android.widget.ImageView  android.widget.TextView  android.widget.TextView)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;->rootView Landroidx/cardview/widget/CardView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;->ivFileIcon Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;->tvFileExt Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;->tvFilename Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemChatAttachmentBinding
    .registers 5
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_file_icon I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    if-eqz v1, +01eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_file_ext I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    if-eqz v2, +014h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_filename I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    if-eqz v3, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;
    check-cast v4, Landroidx/cardview/widget/CardView;
    invoke-direct v0, v4, v1, v2, v3, Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;-><init>(Landroidx/cardview/widget/CardView; Landroid/widget/ImageView; Landroid/widget/TextView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemChatAttachmentBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemChatAttachmentBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_chat_attachment I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;->getRoot()Landroidx/cardview/widget/CardView;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.cardview.widget.CardView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemChatAttachmentBinding;->rootView Landroidx/cardview/widget/CardView;
    return-object v0
.end method
