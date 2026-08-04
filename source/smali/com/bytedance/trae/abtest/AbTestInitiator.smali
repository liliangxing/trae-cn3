# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/abtest/AbTestInitiator;
.super Ljava/lang/Object;
.source "AbTestInitiator.kt"

.implements Lcom/larus/init/IAbTestInitiator;

.field public static final Companion:Lcom/bytedance/trae/abtest/AbTestInitiator$Companion;
.field public static final TAG:Ljava/lang/String;
.field private final AB_TEST_SDK_HOST:Ljava/lang/String;
.field private final experimentListener:Lcom/bytedance/dataplatform/IExperimentListener;
.field private final exposureService:Lcom/bytedance/dataplatform/IExposureService;
.field private final netService:Lcom/bytedance/dataplatform/INetService;
.field private final serializationService:Lcom/bytedance/trae/abtest/AbTestInitiator$serializationService$1;
.field private final settings:Lcom/bytedance/trae/abtest/AbTestInitiator$settings$1;


.method public static synthetic $r8$lambda$FKxWT5uOXuuewxXhHDR6RLsphes(java.lang.String  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/abtest/AbTestInitiator;->initAbTest$lambda$1(Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$HGW5GSTJOmo30uPQHnpS7-7J9RY(java.lang.String  org.json.JSONObject)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/abtest/AbTestInitiator;->initAbTest$lambda$0(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$LV-00CE-ORDz_xPS0C_ru7lECPA(java.lang.String)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/abtest/AbTestInitiator;->netService$lambda$4(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$eto4XWl9oeNWudr1GMBLFc6PFJs(java.lang.String)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/abtest/AbTestInitiator;->exposureService$lambda$3(Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$qFLMEaTx_UsyBS2WWzLTZ11jJvQ(org.json.JSONObject)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/abtest/AbTestInitiator;->experimentListener$lambda$5(Lorg/json/JSONObject;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/abtest/AbTestInitiator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/abtest/AbTestInitiator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/abtest/AbTestInitiator;->Companion Lcom/bytedance/trae/abtest/AbTestInitiator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "https://libravm-nontt.byteintlapi.com/common"
    iput-object v0, v1, Lcom/bytedance/trae/abtest/AbTestInitiator;->AB_TEST_SDK_HOST Ljava/lang/String;
    new-instance v0, Lcom/bytedance/trae/abtest/AbTestInitiator$settings$1;
    invoke-direct v0, Lcom/bytedance/trae/abtest/AbTestInitiator$settings$1;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/abtest/AbTestInitiator;->settings Lcom/bytedance/trae/abtest/AbTestInitiator$settings$1;
    new-instance v0, Lcom/bytedance/trae/abtest/AbTestInitiator$serializationService$1;
    invoke-direct v0, Lcom/bytedance/trae/abtest/AbTestInitiator$serializationService$1;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/abtest/AbTestInitiator;->serializationService Lcom/bytedance/trae/abtest/AbTestInitiator$serializationService$1;
    new-instance v0, Lcom/bytedance/trae/abtest/AbTestInitiator$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/abtest/AbTestInitiator$$ExternalSyntheticLambda0;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/abtest/AbTestInitiator;->exposureService Lcom/bytedance/dataplatform/IExposureService;
    new-instance v0, Lcom/bytedance/trae/abtest/AbTestInitiator$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/abtest/AbTestInitiator$$ExternalSyntheticLambda1;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/abtest/AbTestInitiator;->netService Lcom/bytedance/dataplatform/INetService;
    new-instance v0, Lcom/bytedance/trae/abtest/AbTestInitiator$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/abtest/AbTestInitiator$$ExternalSyntheticLambda2;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/abtest/AbTestInitiator;->experimentListener Lcom/bytedance/dataplatform/IExperimentListener;
    return-void 
.end method

.method private static final experimentListener$lambda$5(org.json.JSONObject)void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "onLibraExperimentChanged: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v1, "InitAbTest"
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private static final exposureService$lambda$3(java.lang.String)void
    .registers 4
    # ins_size=1
    if-eqz v3, +01dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "--->>>>> onExposure --->>>>>: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "InitAbTest"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->setExternalAbVersionFromAbTest(Ljava/lang/String;)V
    return-void 
.end method

.method private static final initAbTest$lambda$0(java.lang.String  org.json.JSONObject)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private static final initAbTest$lambda$1(java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "did"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "iid"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-class v1, Lcom/larus/abtest/api/IAbTest;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/larus/abtest/api/IAbTest;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/larus/abtest/api/IAbTest;
    if-eqz v1, +005h
    invoke-interface v1, Lcom/larus/abtest/api/IAbTest;->refresh()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final netService$lambda$4(java.lang.String)java.lang.String
    .registers 9
    # ins_size=1
    const-string v0, "InitAbTest"
    const-string v1, "GET result:
 "
    const-string v2, "GET url: "
    new-instance v3, Lcom/bytedance/article/common/network/SSNetworkClient;
    invoke-direct v3, Lcom/bytedance/article/common/network/SSNetworkClient;-><init>()V
    new-instance v4, Ljava/util/HashMap;
    invoke-direct v4, Ljava/util/HashMap;-><init>()V
    invoke-static Lcom/ss/android/ugc/quota/BDNetworkTagManager;->getInstance()Lcom/ss/android/ugc/quota/BDNetworkTagManager;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/abtest/AbTestInitiator$netService$1$tag$1;
    invoke-direct v6, Lcom/bytedance/trae/abtest/AbTestInitiator$netService$1$tag$1;-><init>()V
    check-cast v6, Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;
    invoke-virtual v5, v6, Lcom/ss/android/ugc/quota/BDNetworkTagManager;->buildBDNetworkTag(Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;)Landroid/util/Pair;
    move-result-object v5
    move-object v6, v4
    check-cast v6, Ljava/util/Map;
    iget-object v7, v5, Landroid/util/Pair;->first Ljava/lang/Object;
    iget-object v5, v5, Landroid/util/Pair;->second Ljava/lang/Object;
    invoke-interface v6, v7, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v5, Lcom/bytedance/common/utility/NetworkClient$ReqContext;
    invoke-direct v5, Lcom/bytedance/common/utility/NetworkClient$ReqContext;-><init>()V
    const/4 v6, 1
    iput-boolean v6, v5, Lcom/bytedance/common/utility/NetworkClient$ReqContext;->addCommonParams Z
    check-cast v4, Ljava/util/Map;
    invoke-virtual v3, v8, v4, v5, Lcom/bytedance/article/common/network/SSNetworkClient;->get(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/common/utility/NetworkClient$ReqContext;)Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v3
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, url = 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, v0, v8, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    const/4 v8, 0
    return-object v8
    :try_start_0x6
.end method

.method public final getAB_TEST_SDK_HOST()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/abtest/AbTestInitiator;->AB_TEST_SDK_HOST Ljava/lang/String;
    return-object v0
.end method

.method public initAbTest()void
    .registers 9
    # ins_size=1
    invoke-static Lcom/bytedance/dataplatform/ExperimentManager;->waitWhenNotInit()V
    new-instance v0, Lcom/bytedance/trae/abtest/AbTestInitiator$$ExternalSyntheticLambda3;
    invoke-direct v0, Lcom/bytedance/trae/abtest/AbTestInitiator$$ExternalSyntheticLambda3;-><init>()V
    const/4 v1, 1
    invoke-static v0, v1, v1, Lcom/bytedance/dataplatform/ExperimentManager;->setAppLogService(Lcom/bytedance/dataplatform/applog/IAppLogService; Z Z)V
    iget-object v0, v8, Lcom/bytedance/trae/abtest/AbTestInitiator;->experimentListener Lcom/bytedance/dataplatform/IExperimentListener;
    invoke-static v0, Lcom/bytedance/dataplatform/ExperimentManager;->setExperimentListener(Lcom/bytedance/dataplatform/IExperimentListener;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    iget-object v2, v8, Lcom/bytedance/trae/abtest/AbTestInitiator;->AB_TEST_SDK_HOST Ljava/lang/String;
    const/4 v3, 1
    iget-object v0, v8, Lcom/bytedance/trae/abtest/AbTestInitiator;->settings Lcom/bytedance/trae/abtest/AbTestInitiator$settings$1;
    move-object v4, v0
    check-cast v4, Lcom/bytedance/dataplatform/ISettings;
    iget-object v0, v8, Lcom/bytedance/trae/abtest/AbTestInitiator;->serializationService Lcom/bytedance/trae/abtest/AbTestInitiator$serializationService$1;
    move-object v5, v0
    check-cast v5, Lcom/bytedance/dataplatform/ISerializationService;
    iget-object v6, v8, Lcom/bytedance/trae/abtest/AbTestInitiator;->exposureService Lcom/bytedance/dataplatform/IExposureService;
    iget-object v7, v8, Lcom/bytedance/trae/abtest/AbTestInitiator;->netService Lcom/bytedance/dataplatform/INetService;
    invoke-static/range v1 ... v7, Lcom/bytedance/dataplatform/ExperimentManager;->init(Landroid/app/Application; Ljava/lang/String; Z Lcom/bytedance/dataplatform/ISettings; Lcom/bytedance/dataplatform/ISerializationService; Lcom/bytedance/dataplatform/IExposureService; Lcom/bytedance/dataplatform/INetService;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/abtest/AbTestInitiator$$ExternalSyntheticLambda4;
    invoke-direct v1, Lcom/bytedance/trae/abtest/AbTestInitiator$$ExternalSyntheticLambda4;-><init>()V
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->doWhenIdsReady(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method
