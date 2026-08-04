# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;
.super Ljava/lang/Object;
.source "TraeFragmentBrainstormDiscussBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final aiDisplaySwitcher:Landroid/widget/FrameLayout;
.field public final aiSubtitleContainer:Landroid/widget/FrameLayout;
.field public final bottomBar:Landroid/widget/LinearLayout;
.field public final btnAttach:Landroid/widget/Button;
.field public final btnConfirm:Landroid/widget/Button;
.field public final btnMic:Landroid/widget/Button;
.field public final btnScrollToBottom:Landroid/widget/ImageView;
.field public final chatModeContainer:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final contentSwitcher:Landroid/widget/FrameLayout;
.field public final footerContainer:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final guidelineSphereTop:Landroidx/constraintlayout/widget/Guideline;
.field public final mainWaveform:Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final rvAiSubtitle:Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;
.field public final rvSubtitle:Landroidx/recyclerview/widget/RecyclerView;
.field public final subtitleBg:Landroid/view/View;
.field public final subtitleModeContainer:Landroid/widget/FrameLayout;
.field public final subtitleTopGradient:Landroid/view/View;
.field public final testFrame:Landroid/widget/LinearLayout;
.field public final topBar:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
.field public final tvAiStatus:Landroid/widget/TextView;
.field public final tvBottomStatus:Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
.field public final tvGeneratedByAi:Landroid/widget/TextView;
.field public final tvSubtitleEmptyHint:Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
.field public final webviewSphere:Landroid/webkit/WebView;


.method private constructor <init>(android.widget.FrameLayout  android.widget.FrameLayout  android.widget.FrameLayout  android.widget.LinearLayout  android.widget.Button  android.widget.Button  android.widget.Button  android.widget.ImageView  androidx.constraintlayout.widget.ConstraintLayout  android.widget.FrameLayout  androidx.constraintlayout.widget.ConstraintLayout  androidx.constraintlayout.widget.Guideline  com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView  com.bytedance.trae.conversation.brainstorm.widget.AiSubtitleView  androidx.recyclerview.widget.RecyclerView  android.view.View  android.widget.FrameLayout  android.view.View  android.widget.LinearLayout  com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar  android.widget.TextView  com.bytedance.trae.conversation.brainstorm.widget.ShimmerTextView  android.widget.TextView  com.bytedance.trae.conversation.brainstorm.widget.ShimmerTextView  android.webkit.WebView)void
    .registers 28
    # ins_size=26
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->rootView Landroid/widget/FrameLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->aiDisplaySwitcher Landroid/widget/FrameLayout;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->aiSubtitleContainer Landroid/widget/FrameLayout;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->bottomBar Landroid/widget/LinearLayout;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->btnAttach Landroid/widget/Button;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->btnConfirm Landroid/widget/Button;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->btnMic Landroid/widget/Button;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->btnScrollToBottom Landroid/widget/ImageView;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->chatModeContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->contentSwitcher Landroid/widget/FrameLayout;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->footerContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->guidelineSphereTop Landroidx/constraintlayout/widget/Guideline;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->mainWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->rvAiSubtitle Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->rvSubtitle Landroidx/recyclerview/widget/RecyclerView;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->subtitleBg Landroid/view/View;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->subtitleModeContainer Landroid/widget/FrameLayout;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->subtitleTopGradient Landroid/view/View;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->testFrame Landroid/widget/LinearLayout;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->tvAiStatus Landroid/widget/TextView;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->tvBottomStatus Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->tvGeneratedByAi Landroid/widget/TextView;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->tvSubtitleEmptyHint Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->webviewSphere Landroid/webkit/WebView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeFragmentBrainstormDiscussBinding
    .registers 30
    # ins_size=1
    move-object/from16 v0, v29
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ai_display_switcher I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/FrameLayout;
    if-eqz v5, +10eh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ai_subtitle_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/FrameLayout;
    if-eqz v6, +103h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->bottom_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +0f8h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_attach I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/Button;
    if-eqz v8, +0edh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_confirm I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/Button;
    if-eqz v9, +0e2h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_mic I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/Button;
    if-eqz v10, +0d7h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_scroll_to_bottom I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/ImageView;
    if-eqz v11, +0cch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->chat_mode_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroidx/constraintlayout/widget/ConstraintLayout;
    if-eqz v12, +0c1h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->content_switcher I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/FrameLayout;
    if-eqz v13, +0b6h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->footer_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroidx/constraintlayout/widget/ConstraintLayout;
    if-eqz v14, +0abh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->guideline_sphere_top I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroidx/constraintlayout/widget/Guideline;
    if-eqz v15, +0a0h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->main_waveform I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    if-eqz v16, +094h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->rv_ai_subtitle I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;
    if-eqz v17, +088h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->rv_subtitle I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v18, +07ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->subtitle_bg I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v19
    if-eqz v19, +074h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->subtitle_mode_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/FrameLayout;
    if-eqz v20, +068h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->subtitle_top_gradient I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v21
    if-eqz v21, +060h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->test_frame I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v22, v2
    check-cast v22, Landroid/widget/LinearLayout;
    if-eqz v22, +054h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->top_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v23, v2
    check-cast v23, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    if-eqz v23, +048h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_ai_status I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v24, v2
    check-cast v24, Landroid/widget/TextView;
    if-eqz v24, +03ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_bottom_status I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v25, v2
    check-cast v25, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-eqz v25, +030h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_generated_by_ai I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v26, v2
    check-cast v26, Landroid/widget/TextView;
    if-eqz v26, +024h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle_empty_hint I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v27, v2
    check-cast v27, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-eqz v27, +018h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->webview_sphere I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v28, v2
    check-cast v28, Landroid/webkit/WebView;
    if-eqz v28, +00ch
    new-instance v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/FrameLayout;
    invoke-direct/range v3 ... v28, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/widget/Button; Landroid/widget/Button; Landroid/widget/Button; Landroid/widget/ImageView; Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/FrameLayout; Landroidx/constraintlayout/widget/ConstraintLayout; Landroidx/constraintlayout/widget/Guideline; Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView; Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView; Landroidx/recyclerview/widget/RecyclerView; Landroid/view/View; Landroid/widget/FrameLayout; Landroid/view/View; Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar; Landroid/widget/TextView; Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView; Landroid/widget/TextView; Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView; Landroid/webkit/WebView;)V
    return-object v1
    invoke-virtual/range v29, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/NullPointerException;
    const-string v2, "Missing required view with ID: "
    invoke-virtual v2, v0, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeFragmentBrainstormDiscussBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeFragmentBrainstormDiscussBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_brainstorm_discuss I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormDiscussBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
