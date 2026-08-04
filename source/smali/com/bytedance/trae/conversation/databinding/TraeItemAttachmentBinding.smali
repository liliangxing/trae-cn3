# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
.super Ljava/lang/Object;
.source "TraeItemAttachmentBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnRemove:Landroid/widget/ImageView;
.field public final fileInfoOverlay:Landroid/widget/FrameLayout;
.field public final ivAttachment:Lcom/facebook/drawee/view/SimpleDraweeView;
.field public final overlayFailed:Landroid/widget/FrameLayout;
.field public final overlayLoading:Landroid/widget/FrameLayout;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final tvExtBadge:Landroid/widget/TextView;
.field public final tvFileName:Landroid/widget/TextView;


.method private constructor <init>(android.widget.FrameLayout  android.widget.ImageView  android.widget.FrameLayout  com.facebook.drawee.view.SimpleDraweeView  android.widget.FrameLayout  android.widget.FrameLayout  android.widget.TextView  android.widget.TextView)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->btnRemove Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->fileInfoOverlay Landroid/widget/FrameLayout;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->ivAttachment Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->overlayFailed Landroid/widget/FrameLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->overlayLoading Landroid/widget/FrameLayout;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->tvExtBadge Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->tvFileName Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemAttachmentBinding
    .registers 12
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_remove I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ImageView;
    if-eqz v4, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->file_info_overlay I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/FrameLayout;
    if-eqz v5, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_attachment I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v6, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->overlay_failed I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/FrameLayout;
    if-eqz v7, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->overlay_loading I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/FrameLayout;
    if-eqz v8, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_ext_badge I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_file_name I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    move-object v3, v11
    check-cast v3, Landroid/widget/FrameLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/ImageView; Landroid/widget/FrameLayout; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Landroid/widget/TextView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemAttachmentBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemAttachmentBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_attachment I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
