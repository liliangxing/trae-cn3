# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "PureShowWidgetFullscreenActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;
.field private static final EXTRA_PAYLOAD_KEY:Ljava/lang/String;
.field private static final PAYLOAD_CACHE_LIMIT:I
.field private static final TAG:Ljava/lang/String;
.field private static final payloadCache:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;
.field private titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$bOoNeppmq07WGMWumWaRnQSDigU(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->onCreate$lambda$1(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->payloadCache Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getPayloadCache$cp()com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity$Companion$payloadCache$1
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->payloadCache Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;
    return-object v0
.end method

.method public static final synthetic access$getWebView$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->webView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static final synthetic access$setWebView$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity  android.webkit.WebView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->webView Landroid/webkit/WebView;
    return-void 
.end method

.method public static com_bytedance_trae_conversation_chat_block_renderer_PureShowWidgetFullscreenActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->com_bytedance_trae_conversation_chat_block_renderer_PureShowWidgetFullscreenActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private static final onCreate$lambda$1(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->finish()V
    return-void 
.end method

.method private final setupWebView(android.webkit.WebView)void
    .registers 5
    # ins_size=2
    const/4 v0, 0
    invoke-virtual v4, v0, Landroid/webkit/WebView;->setBackgroundColor(I)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$setupWebView$1;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$setupWebView$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;)V
    check-cast v1, Landroid/webkit/WebViewClient;
    invoke-virtual v4, v1, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    invoke-virtual v4, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v4
    const/4 v1, 1
    invoke-virtual v4, v1, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v4, v1, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    const-string v2, "UTF-8"
    invoke-virtual v4, v2, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V
    invoke-virtual v4, v1, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V
    invoke-virtual v4, v0, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V
    invoke-virtual v4, v1, Landroid/webkit/WebSettings;->setMixedContentMode(I)V
    invoke-virtual v4, v0, Landroid/webkit/WebSettings;->setSupportZoom(Z)V
    invoke-virtual v4, v0, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V
    invoke-virtual v4, v0, Landroid/webkit/WebSettings;->setDisplayZoomControls(Z)V
    invoke-virtual v4, v0, Landroid/webkit/WebSettings;->setAllowFileAccess(Z)V
    invoke-virtual v4, v0, Landroid/webkit/WebSettings;->setAllowContentAccess(Z)V
    invoke-virtual v4, v0, Landroid/webkit/WebSettings;->setJavaScriptCanOpenWindowsAutomatically(Z)V
    invoke-virtual v4, v1, Landroid/webkit/WebSettings;->setMediaPlaybackRequiresUserGesture(Z)V
    return-void 
.end method

.method public com_bytedance_trae_conversation_chat_block_renderer_PureShowWidgetFullscreenActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 9
    # ins_size=2
    invoke-super v7, v8, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v8, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_pure_show_widget_fullscreen I
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->setContentView(I)V
    sget v8, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->findViewById(I)Landroid/view/View;
    move-result-object v8
    const-string v0, "findViewById(...)"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v8, Lcom/bytedance/trae/conversation/R$id;->webview I
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->findViewById(I)Landroid/view/View;
    move-result-object v8
    move-object v0, v8
    check-cast v0, Landroid/webkit/WebView;
    iput-object v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->webView Landroid/webkit/WebView;
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "extra_payload_key"
    invoke-virtual v1, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-static v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;->access$consumePayload(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenPayload;
    move-result-object v8
    if-nez v8, +006h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->finish()V
    return-void 
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    const-string/jumbo v2, titleBar
    const/4 v3, 0
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenPayload;->getTitle()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 1
    if-eqz v4, +010h
    move-object v6, v4
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v5
    if-eqz v6, +003h
    goto +2h
    move-object v4, v3
    if-nez v4, +00dh
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_web I
    invoke-virtual v7, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v6, "getString(...)"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(Ljava/lang/CharSequence;)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$$ExternalSyntheticLambda0;
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;)V
    invoke-virtual v3, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->setupWebView(Landroid/webkit/WebView;)V
    const-string v1, "https://widget.traecontent.com/"
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenPayload;->getWidgetCode()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, v8, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;->build(Ljava/lang/String; Z)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, text/html
    const-string v4, "UTF-8"
    const/4 v5, 0
    invoke-virtual/range v0 ... v5, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method protected onDestroy()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->webView Landroid/webkit/WebView;
    const/4 v1, 0
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->webView Landroid/webkit/WebView;
    if-eqz v0, +01eh
    invoke-virtual v0, Landroid/webkit/WebView;->getParent()Landroid/view/ViewParent;
    move-result-object v2
    instance-of v3, v2, Landroid/view/ViewGroup;
    if-eqz v3, +005h
    move-object v1, v2
    check-cast v1, Landroid/view/ViewGroup;
    if-eqz v1, +008h
    move-object v2, v0
    check-cast v2, Landroid/view/View;
    invoke-virtual v1, v2, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    invoke-virtual v0, Landroid/webkit/WebView;->stopLoading()V
    invoke-virtual v0, Landroid/webkit/WebView;->removeAllViews()V
    invoke-virtual v0, Landroid/webkit/WebView;->destroy()V
    invoke-super v4, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->com_bytedance_trae_conversation_chat_block_renderer_PureShowWidgetFullscreenActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;)V
    return-void 
.end method
