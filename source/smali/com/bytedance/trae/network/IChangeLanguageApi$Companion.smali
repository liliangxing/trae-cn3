# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;
.super Ljava/lang/Object;
.source "IChangeLanguageApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;->$$INSTANCE Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getDEFAULT_HEADERS()java.util.Map
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lcom/bytedance/trae/network/DebugSettings;->buildDefaultHeaders$default(Lcom/bytedance/trae/network/DebugSettings; Ljava/util/Map; I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic safeCall$default(com.bytedance.trae.network.IChangeLanguageApi$Companion  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +008h
    sget-object v1, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v1, Lcom/bytedance/trae/utils/LocaleManager;->getEffectiveLanguage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;->safeCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic syncLanguage$default(com.bytedance.trae.network.IChangeLanguageApi$Companion  java.lang.String  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +008h
    sget-object v1, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v1, Lcom/bytedance/trae/utils/LocaleManager;->getEffectiveLanguage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;->syncLanguage(Ljava/lang/String;)V
    return-void 
.end method

.method public final safeCall(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getUserID()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v3, "change_language"
    const-class v4, Lcom/bytedance/trae/network/IChangeLanguageApi;
    invoke-direct v12, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;
    const/4 v7, 0
    invoke-direct v6, v0, v1, v13, v7, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v8, 0
    const/16 v10, 48
    const/4 v11, 0
    move-object v9, v14
    invoke-static/range v2 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    return-object v13
.end method

.method public final syncLanguage()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v2, v0, v1, v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;->syncLanguage$default(Lcom/bytedance/trae/network/IChangeLanguageApi$Companion; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final syncLanguage(java.lang.String)void
    .registers 9
    # ins_size=2
    const-string v0, "language"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlinx/coroutines/GlobalScope;->INSTANCE Lkotlinx/coroutines/GlobalScope;
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$syncLanguage$1;
    const/4 v4, 0
    invoke-direct v0, v8, v4, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$syncLanguage$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
