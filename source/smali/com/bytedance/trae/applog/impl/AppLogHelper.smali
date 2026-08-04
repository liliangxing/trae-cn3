# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/AppLogHelper;
.super Ljava/lang/Object;
.source "AppLogHelper.kt"

.field private static final ACCOUNT_TYPE_BYTEDANCE:Ljava/lang/String;
.field private static final ACCOUNT_TYPE_TOB:Ljava/lang/String;
.field private static final ACCOUNT_TYPE_TOC:Ljava/lang/String;
.field private static final ACCOUNT_TYPE_UNKNOWN:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/applog/impl/AppLogHelper;
.field private static final KEY_ACCOUNT_TYPE:Ljava/lang/String;
.field private static final KEY_BIZ_USER_ID:Ljava/lang/String;
.field private static final KEY_MINOR_MODE:Ljava/lang/String;
.field private static final KEY_SCOPE:Ljava/lang/String;
.field private static final KEY_TENANT:Ljava/lang/String;
.field private static final KEY_TENANT_ID:Ljava/lang/String;
.field private static final KEY_TENANT_NAME:Ljava/lang/String;
.field private static final KEY_TOB_DID:Ljava/lang/String;
.field private static final KEY_TOC_DID:Ljava/lang/String;
.field private static final SCOPE_SAAS:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static bridge currentAccountType:Ljava/lang/String;
.field private static bridge currentAccountUserId:Ljava/lang/String;
.field private static bridge currentTenantId:Ljava/lang/String;
.field private static bridge currentTenantName:Ljava/lang/String;
.field private static final dataObserver:Lcom/bytedance/trae/applog/impl/AppLogHelper$dataObserver$1;
.field private static final eventCommonParamsGenerators:Ljava/util/Map;
.field private static final eventCommonParamsMap:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final launchObserver:Lcom/bytedance/applog/ILaunchObserver;
.field private static final launchObserverList:Ljava/util/List;
.field private static mConfigInfo:Lcom/bytedance/trae/applog/api/AppLogConfigInfo;
.field private static final mDidListenerCallbackList:Ljava/util/List;
.field private static final navigatorCallback:Lcom/bytedance/trae/applog/impl/AppLogHelper$navigatorCallback$1;
.field private static final navigatorCallbackList:Ljava/util/List;
.field private static final networkClient:Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;
.field private static bridge tobInitialized:Z
.field private static bridge tobInitializing:Z


.method public static synthetic $r8$lambda$CO_-DWa3QfMfhM6dIQi2DlNLfG4(java.lang.String  long  boolean)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->launchObserver$lambda$5(Ljava/lang/String; J Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$IqIb4lRYWg-UrSZ9jmkPeaWwmMQ()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/applog/impl/AppLogHelper;->init$lambda$1()V
    return-void 
.end method

.method public static synthetic $r8$lambda$QxgvnfCiH0_PhDHjsu8DmKw5sl0(android.util.Pair)android.util.Pair
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->setBDAccountCallback$lambda$2(Landroid/util/Pair;)Landroid/util/Pair;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$tHbIqWIzx95W0zNRqDlTRfTWMz4(kotlin.jvm.functions.Function0)android.util.Pair
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->setBDAccountCallbackProvider$lambda$3(Lkotlin/jvm/functions/Function0;)Landroid/util/Pair;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$u4ICQrXL3XAnTxrtjpYIr_fcGyY(com.bytedance.bdinstall.Level)java.util.HashMap
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->init$lambda$0(Lcom/bytedance/bdinstall/Level;)Ljava/util/HashMap;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    const-string/jumbo v0, unknown
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountType Ljava/lang/String;
    const-string v0, ""
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountUserId Ljava/lang/String;
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentTenantId Ljava/lang/String;
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentTenantName Ljava/lang/String;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->mDidListenerCallbackList Ljava/util/List;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->eventCommonParamsGenerators Ljava/util/Map;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->eventCommonParamsMap Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->navigatorCallbackList Ljava/util/List;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->launchObserverList Ljava/util/List;
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->networkClient Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$dataObserver$1;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$dataObserver$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->dataObserver Lcom/bytedance/trae/applog/impl/AppLogHelper$dataObserver$1;
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$navigatorCallback$1;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$navigatorCallback$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->navigatorCallback Lcom/bytedance/trae/applog/impl/AppLogHelper$navigatorCallback$1;
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda3;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda3;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->launchObserver Lcom/bytedance/applog/ILaunchObserver;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getMDidListenerCallbackList$p()java.util.List
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->mDidListenerCallbackList Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getNavigatorCallbackList$p()java.util.List
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->navigatorCallbackList Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$updateBdTuringId(com.bytedance.trae.applog.impl.AppLogHelper  java.lang.String  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->updateBdTuringId(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final addCommonParamsToBundle(android.os.Bundle)void
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->eventCommonParamsGenerators Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +026h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v5, v2, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z
    move-result v3
    if-nez v3, -020h
    if-eqz v1, -022h
    sget-object v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-direct v3, v5, v2, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addToBundle(Landroid/os/Bundle; Ljava/lang/String; Ljava/lang/Object;)V
    goto -29h
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->eventCommonParamsMap Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v0, Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    sget-object v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    invoke-direct v2, v5, v3, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addToBundle(Landroid/os/Bundle; Ljava/lang/String; Ljava/lang/Object;)V
    goto -1bh
    const-string v0, "account_type"
    sget-object v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountType Ljava/lang/String;
    invoke-direct v4, v5, v0, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->putBundleIfAbsent(Landroid/os/Bundle; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x16
    :try_start_0x4c
.end method

.method private final addCommonParamsToJSONObject(org.json.JSONObject)void
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->eventCommonParamsGenerators Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +024h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v5, v2, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z
    move-result v3
    if-nez v3, -020h
    if-eqz v1, -022h
    invoke-virtual v5, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -27h
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->eventCommonParamsMap Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v0, Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    sget-object v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    invoke-direct v2, v5, v3, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addToJSONObject(Lorg/json/JSONObject; Ljava/lang/String; Ljava/lang/Object;)V
    goto -1bh
    const-string v0, "account_type"
    sget-object v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountType Ljava/lang/String;
    invoke-direct v4, v5, v0, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->putJsonIfAbsent(Lorg/json/JSONObject; Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
    :try_start_0x16
    :try_start_0x4a
.end method

.method private final addToBundle(android.os.Bundle  java.lang.String  java.lang.Object)void
    .registers 6
    # ins_size=4
    invoke-virtual v3, v4, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    instance-of v0, v5, Ljava/lang/String;
    if-eqz v0, +008h
    check-cast v5, Ljava/lang/String;
    invoke-virtual v3, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    goto +33h
    instance-of v0, v5, Ljava/lang/Integer;
    if-eqz v0, +00ch
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    invoke-virtual v3, v4, v5, Landroid/os/Bundle;->putInt(Ljava/lang/String; I)V
    goto +25h
    instance-of v0, v5, Ljava/lang/Long;
    if-eqz v0, +00ch
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    invoke-virtual v3, v4, v0, v1, Landroid/os/Bundle;->putLong(Ljava/lang/String; J)V
    goto +17h
    instance-of v0, v5, Ljava/lang/Boolean;
    if-eqz v0, +00ch
    check-cast v5, Ljava/lang/Boolean;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    invoke-virtual v3, v4, v5, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    goto +9h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v3
    if-nez v3, +003h
    return-void 
    new-instance v3, Ljava/lang/IllegalArgumentException;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v0, "addToBundle -> unsupported type: "
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v3
.end method

.method private final addToJSONObject(org.json.JSONObject  java.lang.String  java.lang.Object)void
    .registers 6
    # ins_size=4
    invoke-virtual v3, v4, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    instance-of v0, v5, Ljava/lang/String;
    if-eqz v0, +006h
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +35h
    instance-of v0, v5, Ljava/lang/Integer;
    if-eqz v0, +00ch
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    goto +27h
    instance-of v0, v5, Ljava/lang/Long;
    if-eqz v0, +00ch
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    invoke-virtual v3, v4, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    goto +19h
    instance-of v0, v5, Ljava/lang/Boolean;
    if-eqz v0, +00ch
    check-cast v5, Ljava/lang/Boolean;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    goto +bh
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v3
    if-nez v3, +005h
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-void 
    new-instance v3, Ljava/lang/IllegalArgumentException;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v0, "addToJSONObject -> unsupported type: "
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v3
.end method

.method private final addTobMappingParams(org.json.JSONObject)void
    .registers 4
    # ins_size=2
    const-string v0, "account_type"
    sget-object v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountType Ljava/lang/String;
    invoke-direct v2, v3, v0, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->putJsonIfAbsent(Lorg/json/JSONObject; Ljava/lang/String; Ljava/lang/Object;)V
    invoke-static Lcom/bytedance/applog/AppLog;->getDid()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +008h
    const-string/jumbo v1, toc_did
    invoke-direct v2, v3, v1, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->putJsonIfAbsent(Lorg/json/JSONObject; Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method private final addTocMappingParams(android.os.Bundle)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->shouldUseTobAppLog()Z
    move-result v0
    if-eqz v0, +021h
    sget-boolean v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitialized Z
    if-nez v0, +003h
    goto +1bh
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    invoke-virtual v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->getDid()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +008h
    const-string/jumbo v1, tob_did
    invoke-direct v2, v3, v1, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->putBundleIfAbsent(Landroid/os/Bundle; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final addTocMappingParams(org.json.JSONObject)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->shouldUseTobAppLog()Z
    move-result v0
    if-eqz v0, +021h
    sget-boolean v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitialized Z
    if-nez v0, +003h
    goto +1bh
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    invoke-virtual v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->getDid()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +008h
    const-string/jumbo v1, tob_did
    invoke-direct v2, v3, v1, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->putJsonIfAbsent(Lorg/json/JSONObject; Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method private final buildTobJSONObject(android.os.Bundle)org.json.JSONObject
    .registers 7
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v6, Landroid/os/Bundle;->keySet()Ljava/util/Set;
    move-result-object v1
    const-string v2, "keySet(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +015h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    sget-object v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v6, v2, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v4
    invoke-direct v3, v0, v2, v4, Lcom/bytedance/trae/applog/impl/AppLogHelper;->putTobValue(Lorg/json/JSONObject; Ljava/lang/String; Ljava/lang/Object;)V
    goto -18h
    invoke-direct v5, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addTobMappingParams(Lorg/json/JSONObject;)V
    return-object v0
.end method

.method private final buildTobJSONObject(org.json.JSONObject)org.json.JSONObject
    .registers 6
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v5, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +013h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v5, v2, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v0, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->putTobValue(Lorg/json/JSONObject; Ljava/lang/String; Ljava/lang/Object;)V
    goto -16h
    invoke-direct v4, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addTobMappingParams(Lorg/json/JSONObject;)V
    return-object v0
.end method

.method private final copyJSONObject(org.json.JSONObject)org.json.JSONObject
    .registers 6
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v5, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v5, v2, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -13h
    return-object v0
.end method

.method private static final init$lambda$0(com.bytedance.bdinstall.Level)java.util.HashMap
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v1, Lcom/bytedance/bdinstall/Level;->value()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/TraeTTNet;->getAppLogExtraParams(I)Ljava/util/HashMap;
    move-result-object v1
    return-object v1
.end method

.method private static final init$lambda$1()void
    .registers 2
    # ins_size=0
    new-instance v0, Ljava/util/HashMap;
    sget-object v1, Lcom/bytedance/trae/apm/api/IExtraParams;->Companion Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->getStaticParams()Ljava/util/Map;
    move-result-object v1
    invoke-direct v0, v1, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V
    invoke-static v0, Lcom/bytedance/applog/AppLog;->setHeaderInfo(Ljava/util/HashMap;)V
    return-void 
.end method

.method private final synchronized initTobAppLogIfNeeded()void
    .registers 3
    # ins_size=1
    monitor-enter v2
    invoke-direct v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->shouldUseTobAppLog()Z
    move-result v0
    if-eqz v0, +039h
    sget-boolean v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitialized Z
    if-nez v0, +035h
    sget-boolean v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitializing Z
    if-eqz v0, +003h
    goto +2fh
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->mConfigInfo Lcom/bytedance/trae/applog/api/AppLogConfigInfo;
    if-nez v0, +004h
    monitor-exit v2
    return-void 
    const/4 v1, 1
    sput-boolean v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitializing Z
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;
    sget-object v1, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    invoke-virtual v1, v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->init(Lcom/bytedance/trae/applog/api/AppLogConfigInfo;)Z
    move-result v0
    sput-boolean v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitialized Z
    invoke-direct v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->updateTobAccountInfo()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    const/4 v0, 0
    sput-boolean v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitializing Z
    monitor-exit v2
    return-void 
    monitor-exit v2
    return-void 
    move-exception v0
    monitor-exit v2
    throw v0
    :try_start_0x1
    :try_start_0x17
    :try_start_0x19
    :try_start_0x30
.end method

.method private static final launchObserver$lambda$5(java.lang.String  long  boolean)void
    .registers 6
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->launchObserverList Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/applog/ILaunchObserver;
    invoke-interface v1, v2, v3, v4, v5, Lcom/bytedance/applog/ILaunchObserver;->onLaunch(Ljava/lang/String; J Z)V
    goto -fh
    return-void 
.end method

.method private final putBundleIfAbsent(android.os.Bundle  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    invoke-virtual v2, v3, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +013h
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-virtual v2, v3, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final putJsonIfAbsent(org.json.JSONObject  java.lang.String  java.lang.Object)void
    .registers 5
    # ins_size=4
    invoke-virtual v2, v3, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +016h
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-virtual v2, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    return-void 
.end method

.method private final putTobValue(org.json.JSONObject  java.lang.String  java.lang.Object)void
    .registers 5
    # ins_size=4
    if-eqz v4, +01ch
    sget-object v0, Lorg/json/JSONObject;->NULL Ljava/lang/Object;
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +12h
    instance-of v0, v4, Ljava/lang/Boolean;
    if-eqz v0, +00ch
    check-cast v4, Ljava/lang/Boolean;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-virtual v2, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    return-void 
.end method

.method private final reportTobEventIfNeeded(java.lang.String  android.os.Bundle)void
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->shouldUseTobAppLog()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->initTobAppLogIfNeeded()V
    sget-boolean v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitialized Z
    if-nez v0, +003h
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->buildTobJSONObject(Landroid/os/Bundle;)Lorg/json/JSONObject;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->onEventV3(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0xf
.end method

.method private final reportTobEventIfNeeded(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->shouldUseTobAppLog()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->initTobAppLogIfNeeded()V
    sget-boolean v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitialized Z
    if-nez v0, +003h
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->buildTobJSONObject(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->onEventV3(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0xf
.end method

.method private final reportTobMiscEventIfNeeded(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->shouldUseTobAppLog()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->initTobAppLogIfNeeded()V
    sget-boolean v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitialized Z
    if-nez v0, +003h
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->copyJSONObject(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    move-result-object v3
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addCommonParamsToJSONObject(Lorg/json/JSONObject;)V
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addTocMappingParams(Lorg/json/JSONObject;)V
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->buildTobJSONObject(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->onMiscEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0xf
.end method

.method private static final setBDAccountCallback$lambda$2(android.util.Pair)android.util.Pair
    .registers 1
    # ins_size=1
    return-object v0
.end method

.method private static final setBDAccountCallbackProvider$lambda$3(kotlin.jvm.functions.Function0)android.util.Pair
    .registers 1
    # ins_size=1
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/util/Pair;
    return-object v0
.end method

.method private final shouldUseTobAppLog()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    invoke-virtual v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->isSupported()Z
    move-result v0
    if-eqz v0, +00fh
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountType Ljava/lang/String;
    const-string/jumbo v1, tob
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final updateBdTuringId(java.lang.String  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-static Lcom/bytedance/bdturing/BdTuring;->getInstance()Lcom/bytedance/bdturing/BdTuring;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/bdturing/BdTuring;->getConfig()Lcom/bytedance/bdturing/BdTuringConfig;
    move-result-object v3
    if-eqz v3, +005h
    invoke-virtual v3, v1, Lcom/bytedance/bdturing/BdTuringConfig;->setDeviceId(Ljava/lang/String;)Lcom/bytedance/bdturing/BdTuringConfig;
    invoke-static Lcom/bytedance/bdturing/BdTuring;->getInstance()Lcom/bytedance/bdturing/BdTuring;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/bdturing/BdTuring;->getConfig()Lcom/bytedance/bdturing/BdTuringConfig;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, v2, Lcom/bytedance/bdturing/BdTuringConfig;->setInstallId(Ljava/lang/String;)Lcom/bytedance/bdturing/BdTuringConfig;
    return-void 
.end method

.method private final updateTobAccountInfo()void
    .registers 5
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->tobInitialized Z
    if-nez v0, +003h
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    const-string v1, "account_type"
    sget-object v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountType Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->setHeaderInfo(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    const-string v1, "biz_user_id"
    sget-object v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountUserId Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->setHeaderInfo(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    sget-object v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountUserId Ljava/lang/String;
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->setUserUniqueID(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    const-string/jumbo v1, tenant
    sget-object v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentTenantId Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->setHeaderInfo(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    const-string/jumbo v1, tenant_id
    sget-object v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentTenantId Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->setHeaderInfo(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    const-string/jumbo v1, tenant_name
    sget-object v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentTenantName Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->setHeaderInfo(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    const-string/jumbo v1, scope
    sget-object v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountType Ljava/lang/String;
    const-string/jumbo v3, tob
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +006h
    const-string/jumbo v2, saas
    goto +3h
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->setHeaderInfo(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x5
.end method

.method public final addEventCommonParams(java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, valueGenerator
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->eventCommonParamsGenerators Ljava/util/Map;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final addGetAppLogIdListener(com.bytedance.trae.applog.api.OnGetAppLogIdListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->mDidListenerCallbackList Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addLaunchObserver(com.bytedance.trae.applog.api.OnLaunchCallback)void
    .registers 4
    # ins_size=2
    const-string v0, "observer"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->launchObserverList Ljava/util/List;
    new-instance v1, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda4;
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/applog/api/OnLaunchCallback;)V
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addNavigationCallback(com.bytedance.trae.applog.api.OnNavigateCallback)void
    .registers 4
    # ins_size=2
    const-string v0, "callback"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->navigatorCallbackList Ljava/util/List;
    new-instance v1, Lcom/bytedance/trae/applog/impl/AppLogHelper$addNavigationCallback$1;
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper$addNavigationCallback$1;-><init>(Lcom/bytedance/trae/applog/api/OnNavigateCallback;)V
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final doWhenIdsReady(kotlin.jvm.functions.Function2)void
    .registers 7
    # ins_size=2
    const-string v0, "action"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/applog/AppLog;->getDid()Ljava/lang/String;
    move-result-object v0
    const-string v1, ""
    if-nez v0, +003h
    move-object v0, v1
    invoke-static Lcom/bytedance/applog/AppLog;->getIid()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v1, v2
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/4 v3, 1
    const/4 v4, 0
    if-lez v2, +004h
    move v2, v3
    goto +2h
    move v2, v4
    if-eqz v2, +018h
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +003h
    goto +2h
    move v3, v4
    if-eqz v3, +00bh
    const-string v2, "doWhenIdsReady"
    invoke-direct v5, v0, v1, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->updateBdTuringId(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v6, v0, v1, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$doWhenIdsReady$1;
    invoke-direct v0, v6, Lcom/bytedance/trae/applog/impl/AppLogHelper$doWhenIdsReady$1;-><init>(Lkotlin/jvm/functions/Function2;)V
    check-cast v0, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v5, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method

.method public final init(com.bytedance.trae.applog.api.AppLogConfigInfo)void
    .registers 7
    # ins_size=2
    const-string v0, "configInfo"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;
    invoke-virtual v0, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;->preInit()V
    sput-object v6, Lcom/bytedance/trae/applog/impl/AppLogHelper;->mConfigInfo Lcom/bytedance/trae/applog/api/AppLogConfigInfo;
    new-instance v0, Lcom/bytedance/applog/InitConfig;
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getAppId()I
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getChannel()Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v1, v2, Lcom/bytedance/applog/InitConfig;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;
    invoke-virtual v1, v0, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;->setupInitHook(Lcom/bytedance/applog/InitConfig;)V
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getAppName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/applog/InitConfig;->setAppName(Ljava/lang/String;)Lcom/bytedance/applog/InitConfig;
    sget-object v1, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->INSTANCE Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->isBoe()Z
    move-result v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->uriConfig(Z)Lcom/bytedance/applog/UriConfig;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/applog/InitConfig;->setUriConfig(Lcom/bytedance/applog/UriConfig;)Lcom/bytedance/applog/InitConfig;
    sget-object v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->networkClient Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;
    check-cast v1, Lcom/bytedance/bdinstall/INetworkClient;
    invoke-virtual v0, v1, Lcom/bytedance/applog/InitConfig;->setNetworkClient(Lcom/bytedance/bdinstall/INetworkClient;)Lcom/bytedance/applog/InitConfig;
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/applog/InitConfig;->setAutoStart(Z)Lcom/bytedance/applog/InitConfig;
    invoke-virtual v0, v1, Lcom/bytedance/applog/InitConfig;->setHandleLifeCycle(Z)V
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getVersionCode()I
    move-result v2
    int-to-long v2, v2
    invoke-virtual v0, v2, v3, Lcom/bytedance/applog/InitConfig;->setVersionCode(J)Lcom/bytedance/applog/InitConfig;
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getVersionName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/applog/InitConfig;->setVersion(Ljava/lang/String;)Lcom/bytedance/applog/InitConfig;
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getUpdateVersionCode()I
    move-result v2
    int-to-long v2, v2
    invoke-virtual v0, v2, v3, Lcom/bytedance/applog/InitConfig;->setUpdateVersionCode(J)Lcom/bytedance/applog/InitConfig;
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getFilterEnable()Z
    move-result v2
    invoke-virtual v0, v2, Lcom/bytedance/applog/InitConfig;->setEventFilterEnable(Z)V
    new-instance v2, Lcom/bytedance/trae/applog/impl/AppLogLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "AppLog_"
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getAppId()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/applog/impl/AppLogLogger;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/bdinstall/ILogger;
    invoke-virtual v0, v2, Lcom/bytedance/applog/InitConfig;->setLogger(Lcom/bytedance/bdinstall/ILogger;)Lcom/bytedance/applog/InitConfig;
    sget-object v2, Lcom/bytedance/trae/utils/LanguageUtil;->INSTANCE Lcom/bytedance/trae/utils/LanguageUtil;
    sget-object v3, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v3, Lcom/bytedance/trae/utils/AppLocaleUtils;->getAppLocale()Ljava/util/Locale;
    move-result-object v3
    invoke-virtual v3, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v3
    const-string v4, "getLanguage(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/utils/LanguageUtil;->getLanguageForCommonParameters(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/applog/InitConfig;->setLanguage(Ljava/lang/String;)Lcom/bytedance/applog/InitConfig;
    sget-object v2, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->INSTANCE Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;
    invoke-virtual v2, v0, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->configSensitiveApi(Lcom/bytedance/applog/InitConfig;)V
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v2
    xor-int/2addr v2, v1
    invoke-static v2, Lcom/bytedance/applog/AppLog;->setEncryptAndCompress(Z)V
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getSamplingEnable()Z
    move-result v2
    invoke-static v2, Lcom/bytedance/applog/AppLog;->setEventSamplingEnable(Z)V
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getNewMonitorEnabled()Z
    move-result v2
    invoke-static v2, Lcom/bytedance/applog/AppLog;->setNewMonitorEnabled(Z)V
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getNewMonitorInDebugMode()Z
    move-result v2
    invoke-static v2, Lcom/bytedance/applog/AppLog;->setNewMonitorInDebugMode(Z)V
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getDefaultSentryEnabled()Z
    move-result v2
    sput-boolean v2, Lcom/bytedance/applog/monitor/v3/MonitorConfigManager;->defaultSentryEnabled Z
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getDefaultSentryColdStartSamplingRate()I
    move-result v2
    sput v2, Lcom/bytedance/applog/monitor/v3/MonitorConfigManager;->defaultSentryColdStartSamplingRate I
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getDefaultColdStartReportDelay()J
    move-result-wide v2
    sput-wide v2, Lcom/bytedance/applog/monitor/v3/MonitorConfigManager;->defaultColdStartReportDelay J
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getDefaultReportInterval()J
    move-result-wide v2
    sput-wide v2, Lcom/bytedance/applog/monitor/v3/MonitorConfigManager;->defaultReportInterval J
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getPackByLengthEnabled()Z
    move-result v2
    sput-boolean v2, Lcom/bytedance/applog/batch/PackOptConfig;->packByLengthEnabled Z
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getRealtimeEventOptEnabled()Z
    move-result v2
    sput-boolean v2, Lcom/bytedance/applog/batch/PackOptConfig;->realtimeEventOptEnabled Z
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getPackMultiQueryEnabled()Z
    move-result v6
    sput-boolean v6, Lcom/bytedance/applog/batch/PackOptConfig;->packMultiQueryEnabled Z
    invoke-static v1, Lcom/bytedance/applog/AppLog;->setBDInstallEventTrackEnabled(Z)V
    const-class v6, Lcom/bytedance/trae/common/security/api/SecurityService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v6
    const-class v2, Lcom/bytedance/trae/common/security/api/SecurityService;
    invoke-virtual v6, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/common/security/api/SecurityService;
    if-eqz v6, +005h
    invoke-interface v6, Lcom/bytedance/trae/common/security/api/SecurityService;->initBdInstall()V
    new-instance v6, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda1;
    invoke-direct v6, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v6, Lcom/bytedance/applog/AppLog;->setExtraParams(Lcom/bytedance/bdinstall/IExtraParams;)V
    sget-object v6, Lcom/bytedance/trae/applog/impl/AppLogHelper;->navigatorCallback Lcom/bytedance/trae/applog/impl/AppLogHelper$navigatorCallback$1;
    move-object v2, v6
    check-cast v2, Lcom/bytedance/applog/collector/NavigatorCallback;
    invoke-static v2, Lcom/bytedance/applog/AppLog;->setNavigatorCallback(Lcom/bytedance/applog/collector/NavigatorCallback;)V
    check-cast v6, Lcom/bytedance/applog/collector/NavigatorCallback;
    invoke-static v6, Lcom/bytedance/applog/AppLog;->setBgSessionTaskNavigatorCallback(Lcom/bytedance/applog/collector/NavigatorCallback;)V
    sget-object v6, Lcom/bytedance/trae/applog/impl/AppLogHelper;->launchObserver Lcom/bytedance/applog/ILaunchObserver;
    invoke-static v6, Lcom/bytedance/applog/AppLog;->addLaunchObserver(Lcom/bytedance/applog/ILaunchObserver;)V
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v6
    check-cast v6, Landroid/content/Context;
    invoke-static v6, v0, Lcom/bytedance/applog/AppLog;->init(Landroid/content/Context; Lcom/bytedance/applog/InitConfig;)V
    invoke-direct v5, Lcom/bytedance/trae/applog/impl/AppLogHelper;->initTobAppLogIfNeeded()V
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v6
    check-cast v6, Landroid/content/Context;
    invoke-static v6, Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;->getInstance(Landroid/content/Context;)Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;->getExposedVids()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lcom/bytedance/applog/AppLog;->setExternalAbVersion(Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/applog/impl/AppLogHelper;->dataObserver Lcom/bytedance/trae/applog/impl/AppLogHelper$dataObserver$1;
    check-cast v6, Lcom/bytedance/applog/IDataObserver;
    invoke-static v6, Lcom/bytedance/applog/AppLog;->addDataObserver(Lcom/bytedance/applog/IDataObserver;)V
    new-instance v6, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda2;
    invoke-direct v6, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v6, Lcom/bytedance/common/utility/concurrent/ThreadPlus;->submitRunnable(Ljava/lang/Runnable;)V
    invoke-static v1, Lcom/bytedance/applog/AppLog;->setBgSessionTaskEnabled(Z)V
    return-void 
.end method

.method public final onAccountTypeChanged(java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "accountType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tenantId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tenantName
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +0000039h
    goto +1dh
    const-string/jumbo v0, toc
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +018h
    goto +13h
    const-string/jumbo v0, tob
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00eh
    goto +9h
    const-string v0, "bytedance"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +005h
    const-string/jumbo v0, unknown
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountType Ljava/lang/String;
    sput-object v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentAccountUserId Ljava/lang/String;
    sput-object v4, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentTenantId Ljava/lang/String;
    sput-object v5, Lcom/bytedance/trae/applog/impl/AppLogHelper;->currentTenantName Ljava/lang/String;
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->shouldUseTobAppLog()Z
    move-result v2
    if-eqz v2, +005h
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->initTobAppLogIfNeeded()V
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->updateTobAccountInfo()V
    return-void 
    nop 
    sparse-switch-payload -7a040c55 1c147 1c148
.end method

.method public final onMiscEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "logType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "obj"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lcom/bytedance/applog/AppLog;->onMiscEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->reportTobMiscEventIfNeeded(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final openETVerify()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->mConfigInfo Lcom/bytedance/trae/applog/api/AppLogConfigInfo;
    if-eqz v0, +039h
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getAppId()I
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    check-cast v2, Landroid/content/Context;
    const/4 v3, 1
    invoke-static v1, v3, v2, Lcom/bytedance/applog/util/EventsSenderUtils;->setEventsSenderEnable(Ljava/lang/String; Z Landroid/content/Context;)V
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v1
    if-eqz v1, +010h
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getAppId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "https://log.byteoversea.net"
    invoke-static v0, v1, Lcom/bytedance/applog/util/EventsSenderUtils;->setEventVerifyHost(Ljava/lang/String; Ljava/lang/String;)V
    goto +eh
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getAppId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "https://log.snssdk.com"
    invoke-static v0, v1, Lcom/bytedance/applog/util/EventsSenderUtils;->setEventVerifyHost(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final putEventCommonParams(java.lang.String  java.lang.Object)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->eventCommonParamsMap Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v0, Ljava/util/Map;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final removeDidListener(com.bytedance.trae.applog.api.OnGetAppLogIdListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->mDidListenerCallbackList Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final reportEvent(java.lang.String  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +007h
    new-instance v3, Landroid/os/Bundle;
    invoke-direct v3, Landroid/os/Bundle;-><init>()V
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addCommonParamsToBundle(Landroid/os/Bundle;)V
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addTocMappingParams(Landroid/os/Bundle;)V
    invoke-static v2, v3, Lcom/bytedance/applog/AppLog;->onEventV3(Ljava/lang/String; Landroid/os/Bundle;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->reportTobEventIfNeeded(Ljava/lang/String; Landroid/os/Bundle;)V
    return-void 
.end method

.method public final reportEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +007h
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addCommonParamsToJSONObject(Lorg/json/JSONObject;)V
    invoke-direct v1, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addTocMappingParams(Lorg/json/JSONObject;)V
    invoke-static v2, v3, Lcom/bytedance/applog/AppLog;->onEventV3(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->reportTobEventIfNeeded(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final setBDAccountCallback(android.util.Pair)void
    .registers 3
    # ins_size=2
    const-string v0, "pair"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda0;-><init>(Landroid/util/Pair;)V
    invoke-static v0, Lcom/bytedance/applog/AppLog;->setBDAccountCallback(Lcom/bytedance/applog/IBDAccountCallback;)V
    const/4 v2, 1
    invoke-static v2, Lcom/bytedance/applog/AppLog;->setEnableEventUserId(Z)V
    return-void 
.end method

.method public final setBDAccountCallbackProvider(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    const-string v0, "provider"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda5;
    invoke-direct v0, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda5;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-static v0, Lcom/bytedance/applog/AppLog;->setBDAccountCallback(Lcom/bytedance/applog/IBDAccountCallback;)V
    const/4 v2, 1
    invoke-static v2, Lcom/bytedance/applog/AppLog;->setEnableEventUserId(Z)V
    return-void 
.end method
