# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
.super Ljava/lang/Object;
.source "TraeActivityConversationBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnOperationIcon:Lcom/facebook/drawee/view/SimpleDraweeView;
.field public final btnRetryLoad:Landroid/widget/Button;
.field public final checkpointOverlayContainer:Landroidx/fragment/app/FragmentContainerView;
.field public final detailFragmentContainer:Landroidx/fragment/app/FragmentContainerView;
.field public final fragmentContainer:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final inputFragmentContainer:Landroidx/fragment/app/FragmentContainerView;
.field public final layoutLoadError:Landroid/widget/LinearLayout;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final titleBarMark:Landroid/view/View;
.field public final voiceRecordingOverlay:Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
.field public final welcomeFragmentContainer:Landroidx/fragment/app/FragmentContainerView;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  com.facebook.drawee.view.SimpleDraweeView  android.widget.Button  androidx.fragment.app.FragmentContainerView  androidx.fragment.app.FragmentContainerView  androidx.constraintlayout.widget.ConstraintLayout  androidx.fragment.app.FragmentContainerView  android.widget.LinearLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.view.View  com.bytedance.trae.conversation.widget.VoiceRecordingOverlay  androidx.fragment.app.FragmentContainerView)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->btnOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->btnRetryLoad Landroid/widget/Button;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->detailFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->fragmentContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inputFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->layoutLoadError Landroid/widget/LinearLayout;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBarMark Landroid/view/View;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->voiceRecordingOverlay Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->welcomeFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding
    .registers 16
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_operation_icon I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v4, +077h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_retry_load I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/Button;
    if-eqz v5, +06ch
    sget v0, Lcom/bytedance/trae/conversation/R$id;->checkpoint_overlay_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroidx/fragment/app/FragmentContainerView;
    if-eqz v6, +061h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->detail_fragment_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroidx/fragment/app/FragmentContainerView;
    if-eqz v7, +056h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->fragment_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroidx/constraintlayout/widget/ConstraintLayout;
    if-eqz v8, +04bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->input_fragment_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroidx/fragment/app/FragmentContainerView;
    if-eqz v9, +040h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->layout_load_error I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +035h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v11, +02ah
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar_mark I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v12
    if-eqz v12, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->voice_recording_overlay I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    if-eqz v13, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->welcome_fragment_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v14, v1
    check-cast v14, Landroidx/fragment/app/FragmentContainerView;
    if-eqz v14, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-object v3, v15
    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v14, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/Button; Landroidx/fragment/app/FragmentContainerView; Landroidx/fragment/app/FragmentContainerView; Landroidx/constraintlayout/widget/ConstraintLayout; Landroidx/fragment/app/FragmentContainerView; Landroid/widget/LinearLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/view/View; Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay; Landroidx/fragment/app/FragmentContainerView;)V
    return-object v0
    invoke-virtual v15, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v15
    invoke-virtual v15, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v15
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v15, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    invoke-direct v0, v15, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_conversation I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
