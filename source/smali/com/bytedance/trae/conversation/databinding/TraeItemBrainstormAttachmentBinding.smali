# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;
.super Ljava/lang/Object;
.source "TraeItemBrainstormAttachmentBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final cardAttachment:Landroid/widget/FrameLayout;
.field public final ivAttachClose:Landroid/widget/ImageView;
.field public final ivAttachPreview:Lcom/facebook/drawee/view/SimpleDraweeView;
.field public final ivAttachTypeIcon:Landroid/widget/ImageView;
.field public final llAttachFileContent:Landroid/widget/LinearLayout;
.field public final llAttachNameRow:Landroid/widget/LinearLayout;
.field public final overlayAttachFailed:Landroid/widget/FrameLayout;
.field public final overlayAttachLoading:Landroid/widget/FrameLayout;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final tvAttachName:Landroid/widget/TextView;
.field public final tvAttachStatus:Landroid/widget/TextView;


.method private constructor <init>(android.widget.FrameLayout  android.widget.FrameLayout  android.widget.ImageView  com.facebook.drawee.view.SimpleDraweeView  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.FrameLayout  android.widget.FrameLayout  android.widget.TextView  android.widget.TextView)void
    .registers 12
    # ins_size=12
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->cardAttachment Landroid/widget/FrameLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->ivAttachClose Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->ivAttachPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->ivAttachTypeIcon Landroid/widget/ImageView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->llAttachFileContent Landroid/widget/LinearLayout;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->llAttachNameRow Landroid/widget/LinearLayout;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->overlayAttachFailed Landroid/widget/FrameLayout;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->overlayAttachLoading Landroid/widget/FrameLayout;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->tvAttachName Landroid/widget/TextView;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->tvAttachStatus Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemBrainstormAttachmentBinding
    .registers 15
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->card_attachment I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/FrameLayout;
    if-eqz v4, +06fh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_attach_close I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +064h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_attach_preview I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v6, +059h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_attach_type_icon I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/ImageView;
    if-eqz v7, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_attach_file_content I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_attach_name_row I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->overlay_attach_failed I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/FrameLayout;
    if-eqz v10, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->overlay_attach_loading I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/FrameLayout;
    if-eqz v11, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_attach_name I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_attach_status I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;
    move-object v3, v14
    check-cast v3, Landroid/widget/FrameLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Landroid/widget/ImageView; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Landroid/widget/TextView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemBrainstormAttachmentBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemBrainstormAttachmentBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_attachment I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormAttachmentBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
