# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService;
.super Lcom/bytedance/ies/bullet/kit/web/service/BaseWebGlobalConfigService;
.source "TraeWebGlobalConfigService.kt"

.field public static final $stable:I
.field private final urlInterceptorDelegate:Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/ies/bullet/kit/web/service/BaseWebGlobalConfigService;-><init>()V
    new-instance v0, Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1;
    invoke-direct v0, Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService;->urlInterceptorDelegate Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1;
    return-void 
.end method

.method public applySettings(android.webkit.WebSettings  android.webkit.WebView  com.bytedance.ies.bullet.core.model.context.ContextProviderFactory)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, settings
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, webView
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "providerFactory"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, v4, Lcom/bytedance/ies/bullet/kit/web/service/BaseWebGlobalConfigService;->applySettings(Landroid/webkit/WebSettings; Landroid/webkit/WebView; Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V
    const-string v3, " trae/0.0.1"
    invoke-virtual v2, v3, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V
    return-void 
.end method

.method public createWebViewLoadUrlInterceptorDelegate(com.bytedance.ies.bullet.core.model.context.ContextProviderFactory)com.bytedance.ies.bullet.kit.web.IWebViewLoadUrlInterceptorDelegate
    .registers 3
    # ins_size=2
    const-string v0, "providerFactory"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService;->urlInterceptorDelegate Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1;
    check-cast v2, Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;
    return-object v2
.end method
