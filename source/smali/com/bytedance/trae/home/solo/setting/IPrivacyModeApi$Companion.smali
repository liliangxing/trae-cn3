# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;
.super Ljava/lang/Object;
.source "PrivacyModeApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final createService()com.bytedance.trae.home.solo.setting.IPrivacyModeApi
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "privacy_mode"
    const-class v2, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;
    const/4 v3, 0
    sget-object v4, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v5, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 52
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;
    return-object v0
.end method

.method public final query(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;
    move-result-object v0
    invoke-interface v0, v2, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;->queryPrivacyMode(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final toggle(boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=3
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationRequest;
    if-eqz v3, +005h
    const-string v3, "open"
    goto +3h
    const-string v3, "close"
    invoke-direct v1, v3, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationRequest;-><init>(Ljava/lang/String;)V
    invoke-interface v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;->operatePrivacyMode(Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
.end method
