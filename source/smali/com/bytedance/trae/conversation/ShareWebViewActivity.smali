# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ShareWebViewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "ShareWebViewActivity.kt"

.field private static final CLOUDIDE_SESSION_COOKIE_NAME:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;
.field private static final EXTRA_MODE:Ljava/lang/String;
.field private static final EXTRA_POST_URL:Ljava/lang/String;
.field private static final EXTRA_SHARE_URL:Ljava/lang/String;
.field private static final EXTRA_SOURCE:Ljava/lang/String;
.field private static final EXTRA_TITLE:Ljava/lang/String;
.field private static final EXTRA_URL:Ljava/lang/String;
.field public static final MODE_OPEN_IN_BROWSER:I
.field public static final MODE_SHARE:I
.field private btnBack:Landroid/widget/ImageView;
.field private btnShare:Landroid/widget/ImageView;
.field private syncedCookieUrl:Ljava/lang/String;
.field private tvTitle:Landroid/widget/TextView;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$6IRQuxv7oCwfnKJ1QiRy2rUw1dI(com.bytedance.trae.conversation.ShareWebViewActivity  java.lang.String  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->onCreate$lambda$2(Lcom/bytedance/trae/conversation/ShareWebViewActivity; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$FJW1UsPCv5Pdka7yk3anH2EIPxk(com.bytedance.trae.conversation.ShareWebViewActivity  com.bytedance.android.anniex.base.builder.PageBuilder)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->onCreate$lambda$3(Lcom/bytedance/trae/conversation/ShareWebViewActivity; Lcom/bytedance/android/anniex/base/builder/PageBuilder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nb3T41zNGPw1irWSGPxpn2XnkeA(com.bytedance.trae.conversation.ShareWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->onCreate$lambda$0(Lcom/bytedance/trae/conversation/ShareWebViewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$pfri1nAN1wOTrGDz3AtF8RhbYHw(com.bytedance.trae.conversation.ShareWebViewActivity  java.lang.String  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->onCreate$lambda$1(Lcom/bytedance/trae/conversation/ShareWebViewActivity; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->Companion Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static final synthetic access$openInSystemBrowser(com.bytedance.trae.conversation.ShareWebViewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->openInSystemBrowser(Ljava/lang/String;)V
    return-void 
.end method

.method private final clearCloudideSessionCookie(java.lang.String)void
    .registers 16
    # ins_size=2
    const-string v0, "."
    const-string v1, "https://"
    const-string v2, "X-Cloudide-Session=; path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT; domain="
    const-string v3, "X-Cloudide-Session=; path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT; domain=."
    invoke-static v15, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v15
    invoke-virtual v15, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v15
    if-nez v15, +003h
    return-void 
    move-object v4, v15
    check-cast v4, Ljava/lang/CharSequence;
    filled-new-array v0, [Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 6
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    const/4 v5, 2
    invoke-static v4, v5, Lkotlin/collections/CollectionsKt;->takeLast(Ljava/util/List; I)Ljava/util/List;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/Iterable;
    move-object v6, v0
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 62
    const/4 v13, 0
    invoke-static/range v5 ... v13, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-static Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;
    move-result-object v4
    const-string v5, "X-Cloudide-Session=; path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT"
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v6, v0, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v0, v2, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v4, v15, v5, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/webkit/CookieManager;->flush()V
    return-void 
    :try_start_0x8
.end method

.method public static com_bytedance_trae_conversation_ShareWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.ShareWebViewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->com_bytedance_trae_conversation_ShareWebViewActivity__onStop$___twin___()V
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

.method private final loadWithNativeWebView(java.lang.String)void
    .registers 7
    # ins_size=2
    new-instance v0, Landroid/webkit/WebView;
    move-object v1, v5
    check-cast v1, Landroid/content/Context;
    invoke-direct v0, v1, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->webView Landroid/webkit/WebView;
    invoke-virtual v0, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v1
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v1, v2, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    invoke-virtual v1, v2, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V
    invoke-virtual v1, v2, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V
    invoke-virtual v1, v2, Landroid/webkit/WebSettings;->setSupportZoom(Z)V
    invoke-virtual v1, v2, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V
    const/4 v3, 0
    invoke-virtual v1, v3, Landroid/webkit/WebSettings;->setDisplayZoomControls(Z)V
    invoke-virtual v1, v2, Landroid/webkit/WebSettings;->setMixedContentMode(I)V
    new-instance v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity$loadWithNativeWebView$2;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/ShareWebViewActivity$loadWithNativeWebView$2;-><init>(Lcom/bytedance/trae/conversation/ShareWebViewActivity;)V
    check-cast v1, Landroid/webkit/WebViewClient;
    invoke-virtual v0, v1, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->fragment_container I
    invoke-virtual v5, v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    move-object v2, v0
    check-cast v2, Landroid/view/View;
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v4, -1
    invoke-direct v3, v4, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, v3, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v0, v6, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    return-void 
.end method

.method private static final onCreate$lambda$0(com.bytedance.trae.conversation.ShareWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->finish()V
    return-void 
.end method

.method private static final onCreate$lambda$1(com.bytedance.trae.conversation.ShareWebViewActivity  java.lang.String  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->openInSystemBrowser(Ljava/lang/String;)V
    return-void 
.end method

.method private static final onCreate$lambda$2(com.bytedance.trae.conversation.ShareWebViewActivity  java.lang.String  android.view.View)void
    .registers 4
    # ins_size=3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v0, "extra_source"
    invoke-virtual v3, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +004h
    const-string v3, "inside"
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker;->trackShareButtonClick(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->showSharePanelWithSystem(Ljava/lang/String;)V
    return-void 
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.conversation.ShareWebViewActivity  com.bytedance.android.anniex.base.builder.PageBuilder)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "$this$createFragmentHolder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v2, v1, Lcom/bytedance/android/anniex/base/builder/PageBuilder;->activity(Landroid/app/Activity;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final openInSystemBrowser(java.lang.String)void
    .registers 4
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity;
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.VIEW"
    invoke-static v3, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    invoke-direct v0, v1, v3, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->startActivity(Landroid/content/Intent;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method

.method private final showSharePanel(java.lang.String)void
    .registers 5
    # ins_size=2
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_share_webview_title I
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_share_webview_content I
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;
    invoke-direct v1, Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;-><init>()V
    invoke-virtual v1, v0, Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;->setTitle(Ljava/lang/String;)Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;->setText(Ljava/lang/String;)Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;
    move-result-object v0
    invoke-virtual v0, v4, Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;->setTargetUrl(Ljava/lang/String;)Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;
    move-result-object v4
    new-instance v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity$showSharePanel$shareModel$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity$showSharePanel$shareModel$1;-><init>()V
    check-cast v0, Lcom/bytedance/ug/sdk/share/api/callback/ShareEventCallback;
    invoke-virtual v4, v0, Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;->setEventCallBack(Lcom/bytedance/ug/sdk/share/api/callback/ShareEventCallback;)Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/ug/sdk/share/api/entity/ShareContent$Builder;->build()Lcom/bytedance/ug/sdk/share/api/entity/ShareContent;
    move-result-object v4
    new-instance v0, Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;
    move-object v1, v3
    check-cast v1, Landroid/app/Activity;
    invoke-direct v0, v1, Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;-><init>(Landroid/app/Activity;)V
    const-string v1, "943841_xbk_android_1"
    invoke-virtual v0, v1, Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;->withPanelId(Ljava/lang/String;)Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;
    move-result-object v0
    const-string/jumbo v1, 取消
    invoke-virtual v0, v1, Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;->withCancelBtnText(Ljava/lang/String;)Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;->withShareContent(Lcom/bytedance/ug/sdk/share/api/entity/ShareContent;)Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;
    move-result-object v4
    const/4 v0, 0
    invoke-virtual v4, v0, Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;->withDisableGetShreInfo(Z)Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;
    move-result-object v4
    new-instance v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity$showSharePanel$panelContent$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity$showSharePanel$panelContent$1;-><init>()V
    check-cast v0, Lcom/bytedance/ug/sdk/share/api/callback/OnPanelActionCallback;
    invoke-virtual v4, v0, Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;->withPanelActionCallback(Lcom/bytedance/ug/sdk/share/api/callback/OnPanelActionCallback;)Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;
    move-result-object v4
    new-instance v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity$showSharePanel$panelContent$2;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity$showSharePanel$panelContent$2;-><init>()V
    check-cast v0, Lcom/bytedance/ug/sdk/share/api/callback/PanelItemsCallback;
    invoke-virtual v4, v0, Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;->withPanelItemsCallback(Lcom/bytedance/ug/sdk/share/api/callback/PanelItemsCallback;)Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/ug/sdk/share/api/panel/PanelContent$PanelContentBuilder;->build()Lcom/bytedance/ug/sdk/share/api/panel/PanelContent;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/ug/sdk/share/ShareSdk;->showPanel(Lcom/bytedance/ug/sdk/share/api/panel/PanelContent;)Lcom/bytedance/ug/sdk/share/impl/ui/panel/ISharePanel;
    return-void 
.end method

.method private final showSharePanelWithSystem(java.lang.String)void
    .registers 10
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/share/ShareUtils;->INSTANCE Lcom/bytedance/trae/conversation/share/ShareUtils;
    move-object v1, v8
    check-cast v1, Landroid/content/Context;
    const-string v3, ""
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 24
    const/4 v7, 0
    move-object v2, v9
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/share/ShareUtils;->shareLink$default(Lcom/bytedance/trae/conversation/share/ShareUtils; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Z
    return-void 
    :try_start_0x0
.end method

.method private final syncCloudideSessionCookie(java.lang.String)void
    .registers 19
    # ins_size=2
    move-object/from16 v0, v18
    const-string v1, "."
    const-string v2, "https://"
    const-string v3, "X-Cloudide-Session="
    sget-object v4, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-virtual v4, v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedUrl(Ljava/lang/String;)Z
    move-result v4
    if-nez v4, +003h
    return-void 
    const-class v4, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v4
    const-class v5, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v4, v5, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v4, +007h
    invoke-interface v4, Lcom/bytedance/trae/login/api/ILoginService;->getCloudideSession()Ljava/lang/String;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    if-nez v4, +004h
    const-string v4, ""
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    const/4 v6, 1
    if-nez v5, +004h
    move v5, v6
    goto +2h
    const/4 v5, 0
    if-eqz v5, +003h
    return-void 
    invoke-static/range v18, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v5
    invoke-virtual v5, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    return-void 
    move-object v7, v5
    check-cast v7, Ljava/lang/CharSequence;
    filled-new-array v1, [Ljava/lang/String;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 6
    const/4 v12, 0
    invoke-static/range v7 ... v12, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v7
    const/4 v8, 2
    invoke-static v7, v8, Lkotlin/collections/CollectionsKt;->takeLast(Ljava/util/List; I)Ljava/util/List;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Ljava/lang/Iterable;
    move-object v9, v1
    check-cast v9, Ljava/lang/CharSequence;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 62
    const/16 v16, 0
    invoke-static/range v8 ... v16, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-static Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;
    move-result-object v7
    invoke-virtual v7, v6, Landroid/webkit/CookieManager;->setAcceptCookie(Z)V
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "; domain=."
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "; path=/; Secure; HttpOnly; SameSite=Lax"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v7, v1, v3, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v7, v1, v3, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Landroid/webkit/CookieManager;->flush()V
    move-object/from16 v1, v17
    iput-object v0, v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->syncedCookieUrl Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v17
    return-void 
    :try_start_0x8
    :try_start_0xb6
.end method

.method public com_bytedance_trae_conversation_ShareWebViewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method public onBackPressed()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->webView Landroid/webkit/WebView;
    if-eqz v0, +00ch
    invoke-virtual v0, Landroid/webkit/WebView;->canGoBack()Z
    move-result v1
    if-eqz v1, +006h
    invoke-virtual v0, Landroid/webkit/WebView;->goBack()V
    goto +4h
    invoke-super v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onBackPressed()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 10
    # ins_size=2
    invoke-super v8, v9, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v9, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_webview I
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->setContentView(I)V
    sget v9, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v9
    const-string v0, "findViewById(...)"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v9, Landroid/widget/ImageView;
    iput-object v9, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->btnBack Landroid/widget/ImageView;
    sget v9, Lcom/bytedance/trae/conversation/R$id;->btn_share I
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v9
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v9, Landroid/widget/ImageView;
    iput-object v9, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->btnShare Landroid/widget/ImageView;
    sget v9, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v9
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v9, Landroid/widget/TextView;
    iput-object v9, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->tvTitle Landroid/widget/TextView;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v9
    const-string v0, "extra_url"
    invoke-virtual v9, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    const-string v0, ""
    if-nez v9, +003h
    move-object v9, v0
    move-object v1, v9
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    if-nez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +006h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->finish()V
    return-void 
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v4, "extra_share_url"
    invoke-virtual v1, v4, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    move-object v1, v0
    iget-object v4, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->tvTitle Landroid/widget/TextView;
    const/4 v5, 0
    if-nez v4, +009h
    const-string/jumbo v4, tvTitle
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v5
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v6
    const-string v7, "extra_title"
    invoke-virtual v6, v7, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +2h
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v4, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->btnBack Landroid/widget/ImageView;
    if-nez v0, +008h
    const-string v0, "btnBack"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v5
    new-instance v4, Lcom/bytedance/trae/conversation/ShareWebViewActivity$$ExternalSyntheticLambda0;
    invoke-direct v4, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/ShareWebViewActivity;)V
    invoke-virtual v0, v4, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v4, "extra_mode"
    invoke-virtual v0, v4, v3, Landroid/content/Intent;->getIntExtra(Ljava/lang/String; I)I
    move-result v0
    const-string v4, "btnShare"
    if-ne v0, v2, +021h
    iget-object v1, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->btnShare Landroid/widget/ImageView;
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v5
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_open_in_browser I
    invoke-virtual v1, v3, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v1, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->btnShare Landroid/widget/ImageView;
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v1
    new-instance v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity$$ExternalSyntheticLambda1;
    invoke-direct v1, v8, v9, Lcom/bytedance/trae/conversation/ShareWebViewActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/ShareWebViewActivity; Ljava/lang/String;)V
    invoke-virtual v5, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +35h
    move-object v6, v1
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v6
    if-nez v6, +01fh
    iget-object v6, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->btnShare Landroid/widget/ImageView;
    if-nez v6, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v5
    invoke-virtual v6, v3, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v3, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->btnShare Landroid/widget/ImageView;
    if-nez v3, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v3
    new-instance v3, Lcom/bytedance/trae/conversation/ShareWebViewActivity$$ExternalSyntheticLambda2;
    invoke-direct v3, v8, v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/ShareWebViewActivity; Ljava/lang/String;)V
    invoke-virtual v5, v3, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +fh
    iget-object v1, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->btnShare Landroid/widget/ImageView;
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v1
    const/16 v1, 8
    invoke-virtual v5, v1, Landroid/widget/ImageView;->setVisibility(I)V
    const-string v1, ":/?#[]@!$&'()*+,;=-._~%"
    invoke-static v9, v1, Landroid/net/Uri;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-ne v0, v2, +018h
    sget-object v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-virtual v0, v9, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedUrl(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +009h
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->openInSystemBrowser(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->finish()V
    return-void 
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->clearCloudideSessionCookie(Ljava/lang/String;)V
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->loadWithNativeWebView(Ljava/lang/String;)V
    goto +4eh
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->syncCloudideSessionCookie(Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v2, sslocal://webview?hide_nav_bar=1&url=
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/android/anniex/assemble/AnnieX;->INSTANCE Lcom/bytedance/android/anniex/assemble/AnnieX;
    new-instance v2, Lcom/bytedance/trae/conversation/ShareWebViewActivity$$ExternalSyntheticLambda3;
    invoke-direct v2, v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/ShareWebViewActivity;)V
    invoke-virtual v1, v2, Lcom/bytedance/android/anniex/assemble/AnnieX;->createFragmentHolder(Lkotlin/jvm/functions/Function1;)Lcom/bytedance/android/anniex/base/container/holder/IFragmentHolder;
    move-result-object v1
    invoke-interface v1, v0, Lcom/bytedance/android/anniex/base/container/holder/IFragmentHolder;->loadSchema(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/conversation/R$id;->fragment_container I
    invoke-interface v1, Lcom/bytedance/android/anniex/base/container/holder/IFragmentHolder;->getFragment()Landroidx/fragment/app/Fragment;
    move-result-object v1
    invoke-virtual v0, v2, v1, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commit()I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    goto +13h
    move-exception v0
    const-string v1, "AnnieX loadSchema failed, fallback to system browser"
    check-cast v0, Ljava/lang/Throwable;
    const-string v2, "ShareWebViewActivity"
    invoke-static v2, v1, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->openInSystemBrowser(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->finish()V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-void 
    :try_start_0x124
.end method

.method protected onDestroy()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->syncedCookieUrl Ljava/lang/String;
    if-eqz v0, +005h
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->clearCloudideSessionCookie(Ljava/lang/String;)V
    const/4 v0, 0
    iput-object v0, v4, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->syncedCookieUrl Ljava/lang/String;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->webView Landroid/webkit/WebView;
    if-eqz v1, +01ch
    invoke-virtual v1, Landroid/webkit/WebView;->stopLoading()V
    invoke-virtual v1, Landroid/webkit/WebView;->getParent()Landroid/view/ViewParent;
    move-result-object v2
    instance-of v3, v2, Landroid/view/ViewGroup;
    if-eqz v3, +005h
    check-cast v2, Landroid/view/ViewGroup;
    goto +2h
    move-object v2, v0
    if-eqz v2, +008h
    move-object v3, v1
    check-cast v3, Landroid/view/View;
    invoke-virtual v2, v3, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    invoke-virtual v1, Landroid/webkit/WebView;->destroy()V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->webView Landroid/webkit/WebView;
    invoke-super v4, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->com_bytedance_trae_conversation_ShareWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/ShareWebViewActivity;)V
    return-void 
.end method
