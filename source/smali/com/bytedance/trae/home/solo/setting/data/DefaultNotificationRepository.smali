# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;
.super Ljava/lang/Object;
.source "NotificationRepository.kt"

.implements Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository;

.field public static final $stable:I
.field private static final Companion:Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$Companion;
.field private static final NOTIFICATION_COUNT_PATH:Ljava/lang/String;
.field private static final NOTIFICATION_REQUEST_OPTIONS:Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
.field private static final NOTIFICATION_TAG:Ljava/lang/String;
.field private final _unreadCount:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final hostInfo:Lcom/bytedance/trae/kmp/host/KmpHostInfo;
.field private final httpClient:Lcom/bytedance/trae/kmp/network/KmpHttpClient;
.field private final repositoryDispatcher:Lkotlinx/coroutines/CoroutineDispatcher;
.field private final unreadCount:Lkotlinx/coroutines/flow/StateFlow;


.method static constructor <clinit>()void
    .registers 10
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->Companion Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->$stable I
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    const-string/jumbo v2, site_message
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    sget-object v6, Lcom/bytedance/trae/kmp/network/KmpRequestAuth;->CloudIdeJwtAuthorization Lcom/bytedance/trae/kmp/network/KmpRequestAuth;
    sget-object v7, Lcom/bytedance/trae/kmp/network/KmpHostType;->Notification Lcom/bytedance/trae/kmp/network/KmpHostType;
    const/16 v8, 14
    const/4 v9, 0
    move-object v1, v0
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->NOTIFICATION_REQUEST_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.host.KmpHostInfo  kotlinx.coroutines.CoroutineDispatcher)void
    .registers 5
    # ins_size=4
    const-string v0, "httpClient"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hostInfo"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, repositoryDispatcher
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->repositoryDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    const/4 v2, 0
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->_unreadCount Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->unreadCount Lkotlinx/coroutines/flow/StateFlow;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.host.KmpHostInfo  kotlinx.coroutines.CoroutineDispatcher  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +006h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/host/KmpHostInfo; Lkotlinx/coroutines/CoroutineDispatcher;)V
    return-void 
.end method

.method public static final synthetic access$fetchUnreadCount(com.bytedance.trae.home.solo.setting.data.DefaultNotificationRepository  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->fetchUnreadCount(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getHostInfo$p(com.bytedance.trae.home.solo.setting.data.DefaultNotificationRepository)com.bytedance.trae.kmp.host.KmpHostInfo
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    return-object v0
.end method

.method public static final synthetic access$get_unreadCount$p(com.bytedance.trae.home.solo.setting.data.DefaultNotificationRepository)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->_unreadCount Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method private final fetchUnreadCount(kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=2
    instance-of v0, v12, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$fetchUnreadCount$1;
    if-eqz v0, +012h
    move-object v0, v12
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$fetchUnreadCount$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$fetchUnreadCount$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v12, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$fetchUnreadCount$1;->label I
    sub-int/2addr v12, v2
    iput v12, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$fetchUnreadCount$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$fetchUnreadCount$1;
    invoke-direct v0, v11, v12, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$fetchUnreadCount$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository; Lkotlin/coroutines/Continuation;)V
    move-object v8, v0
    iget-object v12, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$fetchUnreadCount$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$fetchUnreadCount$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v1, v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    sget-object v12, Lcom/bytedance/trae/kmp/network/KmpHostType;->Notification Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v3, "/icube/api/v1/notifications/count"
    const/4 v4, 0
    invoke-direct v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->notificationCountParams()Ljava/util/Map;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->NOTIFICATION_REQUEST_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v7
    check-cast v7, Lkotlinx/serialization/DeserializationStrategy;
    const/4 v9, 4
    const/4 v10, 0
    iput v2, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$fetchUnreadCount$1;->label I
    move-object v2, v12
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/kmp/network/KmpHttpClient$DefaultImpls;->getResult$default(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlinx/serialization/DeserializationStrategy; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    check-cast v12, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    invoke-virtual v12, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getData()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto;
    if-eqz v12, +00dh
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto;->getData()Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;
    move-result-object v12
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->getCount()I
    move-result v12
    goto +2h
    const/4 v12, 0
    invoke-static v12, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v12
    return-object v12
.end method

.method private final notificationCountParams()java.util.Map
    .registers 4
    # ins_size=1
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v1, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getAppVersionName()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, version
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v1, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isIOS()Z
    move-result v1
    if-eqz v1, +005h
    const-string v1, "iOS"
    goto +3h
    const-string v1, "Android"
    const-string v2, "platform"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v1, "language"
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->notificationLanguage()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v1, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getStoreCountryCode()Ljava/lang/String;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    const/4 v1, 0
    if-eqz v1, +008h
    const-string/jumbo v2, storeCountryCode
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v0, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method private final notificationLanguage()java.lang.String
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getLanguageCode()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, zh
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +006h
    const-string/jumbo v0, zh-cn
    goto +dh
    const-string v1, "ja"
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    move-object v0, v1
    goto +3h
    const-string v0, "en"
    return-object v0
.end method

.method public getUnreadCount()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->unreadCount Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public refresh(kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;->repositoryDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$refresh$2;
    const/4 v2, 0
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$refresh$2;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v4, Lcom/bytedance/trae/kmp/repository/KmpRepositoryCoroutinesKt;->withRepositoryContext(Lkotlinx/coroutines/CoroutineDispatcher; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    if-ne v4, v0, +003h
    return-object v4
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method
