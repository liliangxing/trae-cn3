# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;
.super Ljava/lang/Object;
.source "DialogChatAttachmentVoiceBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnCamera:Landroid/widget/LinearLayout;
.field public final btnClose:Landroid/widget/ImageView;
.field public final btnFiles:Landroid/widget/LinearLayout;
.field public final btnPhoto:Landroid/widget/LinearLayout;
.field public final dragHandle:Landroid/view/View;
.field public final header:Landroid/widget/FrameLayout;
.field public final optionsGrid:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final spacerCameraPhoto:Landroid/view/View;
.field public final spacerPhotoFiles:Landroid/view/View;
.field public final tvTitle:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.view.View  android.widget.FrameLayout  android.widget.LinearLayout  android.view.View  android.view.View  android.widget.TextView)void
    .registers 12
    # ins_size=12
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->btnCamera Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->btnClose Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->btnFiles Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->btnPhoto Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->dragHandle Landroid/view/View;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->header Landroid/widget/FrameLayout;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->optionsGrid Landroid/widget/LinearLayout;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->spacerCameraPhoto Landroid/view/View;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->spacerPhotoFiles Landroid/view/View;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->tvTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.DialogChatAttachmentVoiceBinding
    .registers 15
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_camera I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +066h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_close I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +05bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_files I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +050h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_photo I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +045h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->drag_handle I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v8
    if-eqz v8, +03dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->header I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/FrameLayout;
    if-eqz v9, +032h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->options_grid I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +027h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->spacer_camera_photo I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v11
    if-eqz v11, +01fh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->spacer_photo_files I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v12
    if-eqz v12, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;
    move-object v3, v14
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/view/View; Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.DialogChatAttachmentVoiceBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.DialogChatAttachmentVoiceBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->dialog_chat_attachment_voice I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/DialogChatAttachmentVoiceBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
