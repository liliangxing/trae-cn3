# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
.super Ljava/lang/Object;
.source "TraeFragmentInputBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final bottomContextualBar:Landroid/widget/FrameLayout;
.field public final btnBranch:Landroid/widget/LinearLayout;
.field public final btnChatNew:Landroid/widget/ImageView;
.field public final btnDevice:Landroid/widget/LinearLayout;
.field public final btnExpressPass:Landroid/widget/ImageView;
.field public final btnExtend:Landroid/widget/LinearLayout;
.field public final btnGithub:Landroid/widget/LinearLayout;
.field public final btnHoldToTalk:Landroid/widget/ImageView;
.field public final btnMicrophone:Landroid/widget/ImageView;
.field public final btnPause:Landroid/widget/ImageView;
.field public final btnPlus:Landroid/widget/ImageView;
.field public final btnSelectFolder:Landroid/widget/LinearLayout;
.field public final btnSendText:Landroid/widget/ImageView;
.field public final etInput:Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
.field public final fullInputContainer:Landroid/widget/LinearLayout;
.field public final imgSelectBranch:Landroid/widget/ImageView;
.field public final inputBottom:Landroid/widget/RelativeLayout;
.field public final ivCloudIcon:Landroid/widget/ImageView;
.field public final ivDeviceBadge:Landroid/widget/ImageView;
.field public final ivDeviceIcon:Landroid/widget/ImageView;
.field public final ivExpressPassBenefitClose:Landroid/widget/ImageView;
.field public final ivExpressPassBenefitIcon:Landroid/widget/ImageView;
.field public final ivRepoIcon:Landroid/widget/ImageView;
.field public final llCloud:Landroid/widget/LinearLayout;
.field public final llCloudContent:Landroid/widget/LinearLayout;
.field public final llDeviceFolderBar:Landroid/widget/LinearLayout;
.field public final llExpressPassBenefit:Landroid/widget/LinearLayout;
.field public final mainInputArea:Landroid/widget/LinearLayout;
.field public final minimizedVoiceBar:Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
.field public final modelSelector:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final rvAttachments:Landroidx/recyclerview/widget/RecyclerView;
.field public final sending:Landroid/widget/ProgressBar;
.field public final tvBranchName:Landroid/widget/TextView;
.field public final tvCloudName:Landroid/widget/TextView;
.field public final tvCloudStatus:Landroid/widget/ImageView;
.field public final tvDeviceName:Landroid/widget/TextView;
.field public final tvExpressPassBenefit:Landroid/widget/TextView;
.field public final tvFolderName:Landroid/widget/TextView;
.field public final tvHoldToTalk:Landroid/widget/TextView;
.field public final tvModelName:Landroid/widget/TextView;
.field public final tvRepoName:Landroid/widget/TextView;
.field public final vsTaskTemplates:Landroid/view/ViewStub;


.method private constructor <init>(android.widget.LinearLayout  android.widget.FrameLayout  android.widget.LinearLayout  android.widget.ImageView  android.widget.LinearLayout  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.ImageView  com.bytedance.trae.conversation.widget.TranscriptEditText  android.widget.LinearLayout  android.widget.ImageView  android.widget.RelativeLayout  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  com.bytedance.trae.conversation.widget.MinimizedVoiceBar  android.widget.LinearLayout  androidx.recyclerview.widget.RecyclerView  android.widget.ProgressBar  android.widget.TextView  android.widget.TextView  android.widget.ImageView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.view.ViewStub)void
    .registers 46
    # ins_size=44
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->rootView Landroid/widget/LinearLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->bottomContextualBar Landroid/widget/FrameLayout;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnChatNew Landroid/widget/ImageView;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnDevice Landroid/widget/LinearLayout;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExtend Landroid/widget/LinearLayout;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnGithub Landroid/widget/LinearLayout;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnHoldToTalk Landroid/widget/ImageView;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnMicrophone Landroid/widget/ImageView;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnPause Landroid/widget/ImageView;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnPlus Landroid/widget/ImageView;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSelectFolder Landroid/widget/LinearLayout;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->fullInputContainer Landroid/widget/LinearLayout;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->imgSelectBranch Landroid/widget/ImageView;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->inputBottom Landroid/widget/RelativeLayout;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivCloudIcon Landroid/widget/ImageView;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivDeviceBadge Landroid/widget/ImageView;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivDeviceIcon Landroid/widget/ImageView;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivExpressPassBenefitClose Landroid/widget/ImageView;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivExpressPassBenefitIcon Landroid/widget/ImageView;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivRepoIcon Landroid/widget/ImageView;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloud Landroid/widget/LinearLayout;
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloudContent Landroid/widget/LinearLayout;
    move-object/from16 v1, v29
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llDeviceFolderBar Landroid/widget/LinearLayout;
    move-object/from16 v1, v30
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llExpressPassBenefit Landroid/widget/LinearLayout;
    move-object/from16 v1, v31
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->mainInputArea Landroid/widget/LinearLayout;
    move-object/from16 v1, v32
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->minimizedVoiceBar Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    move-object/from16 v1, v33
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->modelSelector Landroid/widget/LinearLayout;
    move-object/from16 v1, v34
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->rvAttachments Landroidx/recyclerview/widget/RecyclerView;
    move-object/from16 v1, v35
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->sending Landroid/widget/ProgressBar;
    move-object/from16 v1, v36
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    move-object/from16 v1, v37
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvCloudName Landroid/widget/TextView;
    move-object/from16 v1, v38
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvCloudStatus Landroid/widget/ImageView;
    move-object/from16 v1, v39
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvDeviceName Landroid/widget/TextView;
    move-object/from16 v1, v40
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvExpressPassBenefit Landroid/widget/TextView;
    move-object/from16 v1, v41
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvFolderName Landroid/widget/TextView;
    move-object/from16 v1, v42
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvHoldToTalk Landroid/widget/TextView;
    move-object/from16 v1, v43
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvModelName Landroid/widget/TextView;
    move-object/from16 v1, v44
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvRepoName Landroid/widget/TextView;
    move-object/from16 v1, v45
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->vsTaskTemplates Landroid/view/ViewStub;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeFragmentInputBinding
    .registers 48
    # ins_size=1
    move-object/from16 v0, v47
    sget v1, Lcom/bytedance/trae/conversation/R$id;->bottom_contextual_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/FrameLayout;
    if-eqz v5, +1eeh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_branch I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +1e3h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_chat_new I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/ImageView;
    if-eqz v7, +1d8h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_device I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +1cdh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_express_pass I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/ImageView;
    if-eqz v9, +1c2h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_extend I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +1b7h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_github I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/LinearLayout;
    if-eqz v11, +1ach
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_hold_to_talk I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/ImageView;
    if-eqz v12, +1a1h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_microphone I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/ImageView;
    if-eqz v13, +196h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_pause I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/ImageView;
    if-eqz v14, +18bh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_plus I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/ImageView;
    if-eqz v15, +180h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_select_folder I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/LinearLayout;
    if-eqz v16, +174h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_send_text I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/ImageView;
    if-eqz v17, +168h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->et_input I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    if-eqz v18, +15ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->full_input_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroid/widget/LinearLayout;
    if-eqz v19, +150h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->img_select_branch I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/ImageView;
    if-eqz v20, +144h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->input_bottom I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v21, v2
    check-cast v21, Landroid/widget/RelativeLayout;
    if-eqz v21, +138h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_cloud_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v22, v2
    check-cast v22, Landroid/widget/ImageView;
    if-eqz v22, +12ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_device_badge I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v23, v2
    check-cast v23, Landroid/widget/ImageView;
    if-eqz v23, +120h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_device_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v24, v2
    check-cast v24, Landroid/widget/ImageView;
    if-eqz v24, +114h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_express_pass_benefit_close I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v25, v2
    check-cast v25, Landroid/widget/ImageView;
    if-eqz v25, +108h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_express_pass_benefit_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v26, v2
    check-cast v26, Landroid/widget/ImageView;
    if-eqz v26, +0fch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_repo_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v27, v2
    check-cast v27, Landroid/widget/ImageView;
    if-eqz v27, +0f0h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ll_cloud I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v28, v2
    check-cast v28, Landroid/widget/LinearLayout;
    if-eqz v28, +0e4h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ll_cloud_content I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v29, v2
    check-cast v29, Landroid/widget/LinearLayout;
    if-eqz v29, +0d8h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ll_device_folder_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v30, v2
    check-cast v30, Landroid/widget/LinearLayout;
    if-eqz v30, +0cch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ll_express_pass_benefit I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v31, v2
    check-cast v31, Landroid/widget/LinearLayout;
    if-eqz v31, +0c0h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->main_input_area I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v32, v2
    check-cast v32, Landroid/widget/LinearLayout;
    if-eqz v32, +0b4h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->minimized_voice_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v33, v2
    check-cast v33, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    if-eqz v33, +0a8h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->model_selector I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v34, v2
    check-cast v34, Landroid/widget/LinearLayout;
    if-eqz v34, +09ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->rv_attachments I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v35, v2
    check-cast v35, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v35, +090h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->sending I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v36, v2
    check-cast v36, Landroid/widget/ProgressBar;
    if-eqz v36, +084h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_branch_name I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v37, v2
    check-cast v37, Landroid/widget/TextView;
    if-eqz v37, +078h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_cloud_name I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v38, v2
    check-cast v38, Landroid/widget/TextView;
    if-eqz v38, +06ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_cloud_status I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v39, v2
    check-cast v39, Landroid/widget/ImageView;
    if-eqz v39, +060h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_device_name I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v40, v2
    check-cast v40, Landroid/widget/TextView;
    if-eqz v40, +054h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_express_pass_benefit I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v41, v2
    check-cast v41, Landroid/widget/TextView;
    if-eqz v41, +048h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_folder_name I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v42, v2
    check-cast v42, Landroid/widget/TextView;
    if-eqz v42, +03ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_hold_to_talk I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v43, v2
    check-cast v43, Landroid/widget/TextView;
    if-eqz v43, +030h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_model_name I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v44, v2
    check-cast v44, Landroid/widget/TextView;
    if-eqz v44, +024h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_repo_name I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v45, v2
    check-cast v45, Landroid/widget/TextView;
    if-eqz v45, +018h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->vs_task_templates I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v46, v2
    check-cast v46, Landroid/view/ViewStub;
    if-eqz v46, +00ch
    new-instance v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct/range v3 ... v46, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Lcom/bytedance/trae/conversation/widget/TranscriptEditText; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/RelativeLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar; Landroid/widget/LinearLayout; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/ProgressBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/ImageView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/view/ViewStub;)V
    return-object v1
    invoke-virtual/range v47, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeFragmentInputBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeFragmentInputBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_input I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
