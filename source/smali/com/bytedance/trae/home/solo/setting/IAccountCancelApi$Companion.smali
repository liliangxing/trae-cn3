# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
.super Ljava/lang/Object;
.source "AccountCancelApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;


.method public static synthetic $r8$lambda$iB1n7h2ryNdfGxZyIoEjLxX-dzQ(byte)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->hexMix$lambda$1(B)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic confirm$default(com.bytedance.trae.home.solo.setting.IAccountCancelApi$Companion  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->confirm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final createService()com.bytedance.trae.home.solo.setting.IAccountCancelApi
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "account_cancel"
    const-class v2, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    const/4 v3, 0
    sget-object v4, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v5, Lcom/bytedance/trae/network/HostType;->ONLINE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 52
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    return-object v0
.end method

.method private final createTraeService()com.bytedance.trae.home.solo.setting.IAccountCancelApi
    .registers 13
    # ins_size=1
    const-string v0, ""
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-nez v1, +003h
    goto +2h
    move-object v0, v1
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v1
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +007h
    const-string v2, "X-Cloudide-Token"
    invoke-interface v1, v2, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v1, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v8
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v4, "account_cancel_trae"
    const-class v5, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    const/4 v6, 0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->ONLINE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v7
    const/4 v9, 0
    const/16 v10, 36
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    return-object v0
    :try_start_0x2
.end method

.method private final hexMix(java.lang.String)java.lang.String
    .registers 12
    # ins_size=2
    sget-object v0, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v11, v0, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v1
    const-string v11, "getBytes(...)"
    invoke-static v1, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v11, ""
    move-object v2, v11
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion$$ExternalSyntheticLambda0;
    invoke-direct v7, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion$$ExternalSyntheticLambda0;-><init>()V
    const/16 v8, 30
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/ArraysKt;->joinToString$default([B Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    return-object v11
.end method

.method private static final hexMix$lambda$1(byte)java.lang.CharSequence
    .registers 4
    # ins_size=1
    const/4 v0, 1
    new-array v1, v0, [Ljava/lang/Object;
    xor-int/lit8 v3, v3, 5
    and-int/lit16 v3, v3, 255
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    const/4 v2, 0
    aput-object v3, v1, v2
    invoke-static v1, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v3
    const-string v0, "%02x"
    invoke-static v0, v3, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v0, "format(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    return-object v3
.end method

.method public final authVerify(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    invoke-interface v4, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -016h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1bh
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    const/16 v4, 10
    invoke-static v0, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-static v4, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v4
    const/16 v1, 16
    invoke-static v4, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v4
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, v4, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v1, Ljava/util/Map;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +023h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v2, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-virtual v0, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v2
    invoke-virtual v0, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v0
    invoke-interface v1, v2, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -26h
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v4
    invoke-interface v4, v1, v5, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->authVerify(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method public final cancelCheck(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v0
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->cancelCheck(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final confirm(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=5
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v0
    invoke-interface v0, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->cancelConfirm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final deleteUserData(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createTraeService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v0
    invoke-interface v0, v2, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->deleteUserData(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final pwdVerify(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=3
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/PWDVerifyRequest;
    invoke-direct v1, v3, Lcom/bytedance/trae/home/solo/setting/PWDVerifyRequest;-><init>(Ljava/lang/String;)V
    invoke-interface v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->pwdVerify(Lcom/bytedance/trae/home/solo/setting/PWDVerifyRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
.end method

.method public final restoreAccount(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=3
    const/4 v0, 2
    new-array v0, v0, [Lkotlin/Pair;
    const-string/jumbo v1, token
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v1, 0
    aput-object v3, v0, v1
    const-string/jumbo v3, restoreType
    const-string v1, "1"
    invoke-static v3, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v1, 1
    aput-object v3, v0, v1
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v3
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v0
    invoke-interface v0, v3, v4, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->cancelLogin(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
.end method

.method public final sendEmailCode(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=3
    const/4 v0, 3
    new-array v0, v0, [Lkotlin/Pair;
    const-string v1, "email"
    invoke-direct v8, v9, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->hexMix(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-static v1, v9, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v9
    const/4 v1, 0
    aput-object v9, v0, v1
    const-string v9, "15"
    invoke-direct v8, v9, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->hexMix(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    const-string/jumbo v1, type
    invoke-static v1, v9, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v9
    const/4 v1, 1
    aput-object v9, v0, v1
    const-string v9, ""
    invoke-direct v8, v9, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->hexMix(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    const-string v1, "password"
    invoke-static v1, v9, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v9
    const/4 v1, 2
    aput-object v9, v0, v1
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v3
    invoke-direct v8, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v2
    const/4 v4, 0
    const/4 v6, 2
    const/4 v7, 0
    move-object v5, v10
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$DefaultImpls;->emailSendCode$default(Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi; Ljava/util/Map; I Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    return-object v9
.end method

.method public final sendSmsCode(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=3
    const/4 v0, 2
    new-array v0, v0, [Lkotlin/Pair;
    const-string v1, "mobile"
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v1, 0
    aput-object v3, v0, v1
    const-string/jumbo v3, type
    const-string v1, "22"
    invoke-static v3, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v1, 1
    aput-object v3, v0, v1
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v3
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v0
    invoke-interface v0, v3, v4, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->smsSendCode(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
.end method

.method public final userCheck(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v0
    invoke-interface v0, v2, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->cancelUserCheck(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final verifyEmailCode(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=3
    const/4 v0, 2
    new-array v0, v0, [Lkotlin/Pair;
    const-string v1, "15"
    invoke-direct v8, v1, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->hexMix(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, type
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    const-string v1, "code"
    invoke-direct v8, v9, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->hexMix(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-static v1, v9, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v9
    const/4 v1, 1
    aput-object v9, v0, v1
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v3
    invoke-direct v8, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v2
    const/4 v4, 0
    const/4 v6, 2
    const/4 v7, 0
    move-object v5, v10
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$DefaultImpls;->emailVerify$default(Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi; Ljava/util/Map; I Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    return-object v9
.end method

.method public final verifySmsCode(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=3
    invoke-direct v7, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->createService()Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
    move-result-object v0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v8
    move-object v4, v9
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$DefaultImpls;->smsValidateCode$default(Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi; Ljava/lang/String; I I Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    return-object v8
.end method
