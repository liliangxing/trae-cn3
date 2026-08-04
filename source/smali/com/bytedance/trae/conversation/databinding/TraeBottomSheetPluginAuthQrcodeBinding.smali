# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;
.super Ljava/lang/Object;
.source "TraeBottomSheetPluginAuthQrcodeBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnDesktopCancel:Landroid/widget/TextView;
.field public final ivDesktopProviderIcon:Landroid/widget/ImageView;
.field public final ivProviderIcon:Landroid/widget/ImageView;
.field public final ivQrcode:Landroid/widget/ImageView;
.field public final layoutDesktopContent:Landroid/widget/LinearLayout;
.field public final layoutQrIconRow:Landroid/widget/LinearLayout;
.field public final layoutQrcodeContent:Landroid/widget/LinearLayout;
.field public final pbQrcodeLoading:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvDesc:Landroid/widget/TextView;
.field public final tvDesktopMessage:Landroid/widget/TextView;
.field public final tvDesktopShimmer:Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
.field public final tvFooter:Landroid/widget/TextView;
.field public final tvQrShimmer:Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
.field public final tvStatus:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ProgressBar  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.TextView  com.bytedance.trae.conversation.widget.ShimmerTextView  android.widget.TextView  com.bytedance.trae.conversation.widget.ShimmerTextView  android.widget.TextView)void
    .registers 19
    # ins_size=17
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->rootView Landroid/widget/LinearLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->btnDesktopCancel Landroid/widget/TextView;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->ivDesktopProviderIcon Landroid/widget/ImageView;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->ivProviderIcon Landroid/widget/ImageView;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->ivQrcode Landroid/widget/ImageView;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->layoutDesktopContent Landroid/widget/LinearLayout;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->layoutQrIconRow Landroid/widget/LinearLayout;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->layoutQrcodeContent Landroid/widget/LinearLayout;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->pbQrcodeLoading Landroid/widget/ProgressBar;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->tvDesc Landroid/widget/TextView;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->tvDesktopMessage Landroid/widget/TextView;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->tvDesktopShimmer Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->tvFooter Landroid/widget/TextView;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->tvQrShimmer Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->tvStatus Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeBottomSheetPluginAuthQrcodeBinding
    .registers 21
    # ins_size=1
    move-object/from16 v0, v20
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_desktop_cancel I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +0aah
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_desktop_provider_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +09fh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_provider_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/ImageView;
    if-eqz v7, +094h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_qrcode I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/ImageView;
    if-eqz v8, +089h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_desktop_content I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +07eh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_qr_icon_row I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +073h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_qrcode_content I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/LinearLayout;
    if-eqz v11, +068h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->pb_qrcode_loading I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/ProgressBar;
    if-eqz v12, +05dh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v13, +052h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_desc I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +047h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_desktop_message I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/TextView;
    if-eqz v15, +03ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_desktop_shimmer I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v16, +030h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_footer I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/TextView;
    if-eqz v17, +024h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_qr_shimmer I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    if-eqz v18, +018h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_status I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroid/widget/TextView;
    if-eqz v19, +00ch
    new-instance v1, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct/range v3 ... v19, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/TextView; Lcom/bytedance/trae/conversation/widget/ShimmerTextView; Landroid/widget/TextView; Lcom/bytedance/trae/conversation/widget/ShimmerTextView; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v20, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeBottomSheetPluginAuthQrcodeBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeBottomSheetPluginAuthQrcodeBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_bottom_sheet_plugin_auth_qrcode I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetPluginAuthQrcodeBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
