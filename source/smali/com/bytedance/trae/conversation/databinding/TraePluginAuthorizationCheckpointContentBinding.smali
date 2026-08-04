# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;
.super Ljava/lang/Object;
.source "TraePluginAuthorizationCheckpointContentBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnPluginAuthDesktopCancel:Landroid/widget/TextView;
.field public final btnPluginAuthorizationAuthorize:Landroid/widget/TextView;
.field public final btnPluginAuthorizationCancel:Landroid/widget/TextView;
.field public final ivPluginAuthLinkIcon:Landroid/widget/ImageView;
.field public final ivPluginAuthProviderIcon:Landroid/widget/ImageView;
.field public final ivPluginAuthQrcodeProviderIcon:Landroid/widget/ImageView;
.field public final ivPluginAuthTraeIcon:Landroid/widget/ImageView;
.field public final ivPluginAuthorizationQrcode:Landroid/widget/ImageView;
.field public final ivPluginAuthorizationSuccessIcon:Landroid/widget/ImageView;
.field public final layoutPluginAuthorizationActions:Landroid/widget/LinearLayout;
.field public final layoutPluginAuthorizationDesktopRedirect:Landroid/widget/LinearLayout;
.field public final layoutPluginAuthorizationQrcode:Landroid/widget/LinearLayout;
.field public final layoutPluginAuthorizationSuccess:Landroid/widget/LinearLayout;
.field public final pbPluginAuthorizationLoading:Landroid/widget/ProgressBar;
.field public final pbPluginAuthorizationQrcodeLoading:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvPluginAuthDesktopFooter:Landroid/widget/TextView;
.field public final tvPluginAuthDesktopMessage:Landroid/widget/TextView;
.field public final tvPluginAuthorizationBody:Landroid/widget/TextView;
.field public final tvPluginAuthorizationQrcodeDesc:Landroid/widget/TextView;
.field public final tvPluginAuthorizationQrcodeFooter:Landroid/widget/TextView;
.field public final tvPluginAuthorizationQrcodeStatus:Landroid/widget/TextView;
.field public final tvPluginAuthorizationSuccessLabel:Landroid/widget/TextView;
.field public final tvPluginAuthorizationSuccessName:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ProgressBar  android.widget.ProgressBar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 27
    # ins_size=25
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->rootView Landroid/widget/LinearLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->btnPluginAuthDesktopCancel Landroid/widget/TextView;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->btnPluginAuthorizationAuthorize Landroid/widget/TextView;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->btnPluginAuthorizationCancel Landroid/widget/TextView;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->ivPluginAuthLinkIcon Landroid/widget/ImageView;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->ivPluginAuthProviderIcon Landroid/widget/ImageView;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->ivPluginAuthQrcodeProviderIcon Landroid/widget/ImageView;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->ivPluginAuthTraeIcon Landroid/widget/ImageView;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->ivPluginAuthorizationQrcode Landroid/widget/ImageView;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->ivPluginAuthorizationSuccessIcon Landroid/widget/ImageView;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->layoutPluginAuthorizationActions Landroid/widget/LinearLayout;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->layoutPluginAuthorizationDesktopRedirect Landroid/widget/LinearLayout;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->layoutPluginAuthorizationQrcode Landroid/widget/LinearLayout;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->layoutPluginAuthorizationSuccess Landroid/widget/LinearLayout;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->pbPluginAuthorizationLoading Landroid/widget/ProgressBar;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->pbPluginAuthorizationQrcodeLoading Landroid/widget/ProgressBar;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->tvPluginAuthDesktopFooter Landroid/widget/TextView;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->tvPluginAuthDesktopMessage Landroid/widget/TextView;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->tvPluginAuthorizationBody Landroid/widget/TextView;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->tvPluginAuthorizationQrcodeDesc Landroid/widget/TextView;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->tvPluginAuthorizationQrcodeFooter Landroid/widget/TextView;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->tvPluginAuthorizationQrcodeStatus Landroid/widget/TextView;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->tvPluginAuthorizationSuccessLabel Landroid/widget/TextView;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->tvPluginAuthorizationSuccessName Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraePluginAuthorizationCheckpointContentBinding
    .registers 29
    # ins_size=1
    move-object/from16 v0, v28
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_plugin_auth_desktop_cancel I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +10ah
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_plugin_authorization_authorize I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +0ffh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_plugin_authorization_cancel I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +0f4h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_plugin_auth_link_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/ImageView;
    if-eqz v8, +0e9h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_plugin_auth_provider_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/ImageView;
    if-eqz v9, +0deh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_plugin_auth_qrcode_provider_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/ImageView;
    if-eqz v10, +0d3h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_plugin_auth_trae_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/ImageView;
    if-eqz v11, +0c8h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_plugin_authorization_qrcode I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/ImageView;
    if-eqz v12, +0bdh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_plugin_authorization_success_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/ImageView;
    if-eqz v13, +0b2h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_plugin_authorization_actions I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/LinearLayout;
    if-eqz v14, +0a7h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_plugin_authorization_desktop_redirect I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/LinearLayout;
    if-eqz v15, +09ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_plugin_authorization_qrcode I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/LinearLayout;
    if-eqz v16, +090h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_plugin_authorization_success I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/LinearLayout;
    if-eqz v17, +084h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->pb_plugin_authorization_loading I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroid/widget/ProgressBar;
    if-eqz v18, +078h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->pb_plugin_authorization_qrcode_loading I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroid/widget/ProgressBar;
    if-eqz v19, +06ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_auth_desktop_footer I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/TextView;
    if-eqz v20, +060h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_auth_desktop_message I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v21, v2
    check-cast v21, Landroid/widget/TextView;
    if-eqz v21, +054h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_body I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v22, v2
    check-cast v22, Landroid/widget/TextView;
    if-eqz v22, +048h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_qrcode_desc I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v23, v2
    check-cast v23, Landroid/widget/TextView;
    if-eqz v23, +03ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_qrcode_footer I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v24, v2
    check-cast v24, Landroid/widget/TextView;
    if-eqz v24, +030h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_qrcode_status I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v25, v2
    check-cast v25, Landroid/widget/TextView;
    if-eqz v25, +024h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_success_label I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v26, v2
    check-cast v26, Landroid/widget/TextView;
    if-eqz v26, +018h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_success_name I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v27, v2
    check-cast v27, Landroid/widget/TextView;
    if-eqz v27, +00ch
    new-instance v1, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct/range v3 ... v27, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Landroid/widget/ProgressBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v28, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraePluginAuthorizationCheckpointContentBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraePluginAuthorizationCheckpointContentBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_plugin_authorization_checkpoint_content I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraePluginAuthorizationCheckpointContentBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
