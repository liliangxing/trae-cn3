# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1;
.super Ljava/lang/Object;
.source "TraeWebGlobalConfigService.kt"

.implements Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;


.method public static synthetic $r8$lambda$xci-75dAQOba_O2ZP5jzAwHFoT0(android.webkit.WebView  java.lang.String  java.util.Map  kotlin.jvm.functions.Function2)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1;->provideWebViewLoadUrlInterceptor$lambda$0(Landroid/webkit/WebView; Ljava/lang/String; Ljava/util/Map; Lkotlin/jvm/functions/Function2;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final provideWebViewLoadUrlInterceptor$lambda$0(android.webkit.WebView  java.lang.String  java.util.Map  kotlin.jvm.functions.Function2)kotlin.Unit
    .registers 9
    # ins_size=4
    const-string v0, "<this>"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v5, "next"
    invoke-static v8, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v7, +00ah
    new-instance v5, Ljava/util/LinkedHashMap;
    invoke-direct v5, Ljava/util/LinkedHashMap;-><init>()V
    move-object v7, v5
    check-cast v7, Ljava/util/Map;
    sget-object v5, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v5, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getPpeEnable()Z
    move-result v0
    const-string/jumbo v1, x-tt-env
    const/4 v2, 1
    const/4 v3, 0
    const-string v4, "1"
    if-eqz v0, +020h
    const-string/jumbo v0, x-use-ppe
    invoke-interface v7, v0, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getPpeEnv()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +02dh
    invoke-virtual v5, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getPpeEnv()Ljava/lang/String;
    move-result-object v5
    invoke-interface v7, v1, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +24h
    invoke-virtual v5, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getBoeEnable()Z
    move-result v0
    if-eqz v0, +01fh
    const-string/jumbo v0, x-use-boe
    invoke-interface v7, v0, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getBoeEnv()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +009h
    invoke-virtual v5, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getBoeEnv()Ljava/lang/String;
    move-result-object v5
    invoke-interface v7, v1, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-interface v8, v6, v7, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method public provideWebViewLoadUrlInterceptor()kotlin.jvm.functions.Function4
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1$$ExternalSyntheticLambda0;-><init>()V
    return-object v0
.end method
