# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;
.super Ljava/lang/Object;
.source "AndroidKmpHttpClientFactory.kt"

.implements Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;

.field public static final $stable:I
.field private final envLaneProvider:Lkotlin/jvm/functions/Function0;
.field private final notificationBoeEnabled:Lkotlin/jvm/functions/Function0;
.field private final serviceHeadersProvider:Lkotlin/jvm/functions/Function3;


.method public static synthetic $r8$lambda$LwXylvH4NlCLg16jHyNyZFjL23U(com.bytedance.trae.kmp.network.KmpHttpRequestOptions  java.util.Map  java.lang.String)java.util.Map
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->_init_$lambda$1(Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Ljava/util/Map; Ljava/lang/String;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$fspuLbRQhE0PzsPAL7ZiFy7XdcA()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->_init_$lambda$0()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function3; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function3)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, notificationBoeEnabled
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "envLaneProvider"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, serviceHeadersProvider
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->notificationBoeEnabled Lkotlin/jvm/functions/Function0;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->envLaneProvider Lkotlin/jvm/functions/Function0;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->serviceHeadersProvider Lkotlin/jvm/functions/Function3;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function3  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +00bh
    new-instance v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider$1;
    sget-object v5, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-direct v1, v5, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider$1;-><init>(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/jvm/functions/Function0;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +007h
    new-instance v2, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider$$ExternalSyntheticLambda0;
    invoke-direct v2, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider$$ExternalSyntheticLambda0;-><init>()V
    and-int/lit8 v4, v4, 4
    if-eqz v4, +007h
    new-instance v3, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider$$ExternalSyntheticLambda1;
    invoke-direct v3, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider$$ExternalSyntheticLambda1;-><init>()V
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function3;)V
    return-void 
.end method

.method private static final _init_$lambda$0()java.lang.String
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, Lcom/bytedance/trae/network/DebugSettings;->getEnvLane()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final _init_$lambda$1(com.bytedance.trae.kmp.network.KmpHttpRequestOptions  java.util.Map  java.lang.String)java.util.Map
    .registers 16
    # ins_size=3
    const-string/jumbo v0, options
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestHeaders
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "envLane"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v13, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->getTag()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v13, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->getAddPpeHeaders()Z
    move-result v4
    invoke-virtual v13, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->getAddCommonHeaders()Z
    move-result v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 432
    const/4 v12, 0
    move-object v3, v14
    move-object v8, v15
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/network/TraeHttpConnection;->buildServiceHeaders$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/util/Map; Z Z Ljava/lang/String; Ljava/util/Map; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v13
    return-object v13
.end method

.method private final withAuth(java.util.Map  com.bytedance.trae.kmp.network.KmpRequestAuth)java.util.Map
    .registers 7
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpRequestAuth;->CloudIdeJwtAuthorization Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    if-eq v6, v0, +003h
    return-object v5
    invoke-interface v5, Ljava/util/Map;->keySet()Ljava/util/Set;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    instance-of v0, v6, Ljava/util/Collection;
    const-string v1, "Authorization"
    const/4 v2, 0
    if-eqz v0, +00ch
    move-object v0, v6
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +19h
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +010h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    const/4 v3, 1
    invoke-static v0, v1, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, -011h
    move v2, v3
    if-eqz v2, +003h
    return-object v5
    sget-object v6, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getToken()Ljava/lang/String;
    move-result-object v6
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    return-object v5
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "Cloud-IDE-JWT "
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v1, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/collections/MapsKt;->plus(Ljava/util/Map; Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    return-object v5
.end method

.method private final withNotificationBoe(java.util.Map  com.bytedance.trae.kmp.network.KmpHttpRequestOptions)java.util.Map
    .registers 5
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->getHostType()Lcom/bytedance/trae/kmp/network/KmpHostType;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Notification Lcom/bytedance/trae/kmp/network/KmpHostType;
    if-ne v4, v0, +034h
    iget-object v4, v2, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->notificationBoeEnabled Lkotlin/jvm/functions/Function0;
    invoke-interface v4, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Boolean;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    if-nez v4, +003h
    goto +24h
    const/4 v4, 2
    new-array v4, v4, [Lkotlin/Pair;
    const-string/jumbo v0, x-tt-env
    const-string v1, "boe_notification"
    invoke-static v0, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v1, 0
    aput-object v0, v4, v1
    const-string/jumbo v0, x-use-boe
    const-string v1, "1"
    invoke-static v0, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v1, 1
    aput-object v0, v4, v1
    invoke-static v4, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/collections/MapsKt;->plus(Ljava/util/Map; Ljava/util/Map;)Ljava/util/Map;
    move-result-object v3
    return-object v3
.end method

.method public headers(com.bytedance.trae.kmp.network.KmpHttpRequestOptions  java.util.Map)java.util.Map
    .registers 5
    # ins_size=3
    const-string/jumbo v0, options
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestHeaders
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->serviceHeadersProvider Lkotlin/jvm/functions/Function3;
    invoke-direct v2, v4, v3, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->withNotificationBoe(Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;)Ljava/util/Map;
    move-result-object v4
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;->getAuth()Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    move-result-object v1
    invoke-direct v2, v4, v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->withAuth(Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpRequestAuth;)Ljava/util/Map;
    move-result-object v4
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->envLaneProvider Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v1
    invoke-interface v0, v3, v4, v1, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/Map;
    return-object v3
.end method
