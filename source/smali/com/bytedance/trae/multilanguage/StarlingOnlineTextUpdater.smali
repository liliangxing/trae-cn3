# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
.super Ljava/lang/Object;
.source "StarlingOnlineTextUpdater.kt"

.field private static final CACHE_DIR_NAME:Ljava/lang/String;
.field private static final CACHE_FILE_SUFFIX:Ljava/lang/String;
.field private static final DATA_KEYS:Ljava/util/List;
.field public static final INSTANCE:Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
.field private static final META_KEYS:Ljava/util/Set;
.field private static final TAG:Ljava/lang/String;
.field private static final executor:Ljava/util/concurrent/ExecutorService;


.method public static synthetic $r8$lambda$39c8Bc7T66d_Vmy0rnZQGoP_Vis(java.lang.Runnable)java.lang.Thread
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->executor$lambda$1(Ljava/lang/Runnable;)Ljava/lang/Thread;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$84_OJ_suZvK47y9_PsezHXVQkBI(org.json.JSONObject  java.lang.String)org.json.JSONObject
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->parsePayload$lambda$22$lambda$18(Lorg/json/JSONObject; Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Ov00CKzgmTXxXfVqUbOFRjLaxd4(com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  com.bytedance.trae.multilanguage.I18nLanguage  android.content.Context  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->refresh$lambda$8(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage; Landroid/content/Context; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$TYOKf12KX48AFC7g-V3RvCyjNWA(org.json.JSONObject)java.util.Map
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->parsePayload$lambda$22$lambda$19(Lorg/json/JSONObject;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jZ6aPI2XkL6qorbcMQsTmUlu47M(com.bytedance.trae.multilanguage.I18nLanguage)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->refreshAll$lambda$2(Lcom/bytedance/trae/multilanguage/I18nLanguage;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kZ5qCROveV7W6SsVUlJ4zHSQJo0(org.json.JSONObject  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->optVersion$lambda$33(Lorg/json/JSONObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 17
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    invoke-direct v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;-><init>()V
    sput-object v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->INSTANCE Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    new-instance v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda3;
    invoke-direct v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v0, Ljava/util/concurrent/Executors;->newSingleThreadExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;
    move-result-object v0
    const-string v1, "newSingleThreadExecutor(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->executor Ljava/util/concurrent/ExecutorService;
    const-string v0, "Data"
    const-string v1, "data"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->DATA_KEYS Ljava/util/List;
    const-string v1, "code"
    const-string v2, "data"
    const-string v3, "error"
    const-string v4, "err_msg"
    const-string v5, "err_no"
    const-string v6, "lang"
    const-string v7, "language"
    const-string v8, "locale"
    const-string v9, "log_id"
    const-string v10, "message"
    const-string v11, "msg"
    const-string v12, "namespace"
    const-string/jumbo v13, result
    const-string/jumbo v14, status
    const-string/jumbo v15, success
    const-string/jumbo v16, version
    filled-new-array/range v1 ... v16, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->META_KEYS Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final addCandidateObjects(org.json.JSONObject  java.util.List  com.bytedance.trae.multilanguage.I18nLanguage)void
    .registers 7
    # ins_size=4
    invoke-interface v5, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    const/16 v0, 10
    new-array v0, v0, [Ljava/lang/String;
    const/4 v1, 0
    const-string v2, "data"
    aput-object v2, v0, v1
    const/4 v1, 1
    const-string/jumbo v2, result
    aput-object v2, v0, v1
    const/4 v1, 2
    const-string/jumbo v2, text
    aput-object v2, v0, v1
    const/4 v1, 3
    const-string/jumbo v2, texts
    aput-object v2, v0, v1
    const/4 v1, 4
    const-string/jumbo v2, values
    aput-object v2, v0, v1
    const/4 v1, 5
    const-string v2, "content"
    aput-object v2, v0, v1
    const/4 v1, 6
    const-string/jumbo v2, translations
    aput-object v2, v0, v1
    const/4 v1, 7
    const-string v2, "message"
    aput-object v2, v0, v1
    const/16 v1, 8
    const-string v2, "Data"
    aput-object v2, v0, v1
    const/16 v1, 9
    invoke-virtual v6, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v2
    aput-object v2, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v4, v1, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v1
    if-eqz v1, -010h
    sget-object v2, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->INSTANCE Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    invoke-direct v2, v1, v5, v6, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->addCandidateObjects(Lorg/json/JSONObject; Ljava/util/List; Lcom/bytedance/trae/multilanguage/I18nLanguage;)V
    goto -17h
    return-void 
.end method

.method private final buildLanguagesParam(com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  com.bytedance.trae.multilanguage.I18nLanguage)java.lang.String
    .registers 12
    # ins_size=3
    invoke-virtual v11, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v11
    invoke-static v11, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    check-cast v11, Ljava/util/Collection;
    invoke-virtual v10, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;->getFallbackLanguages()Ljava/util/List;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    invoke-static v11, v10, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    new-instance v11, Ljava/util/ArrayList;
    invoke-direct v11, Ljava/util/ArrayList;-><init>()V
    check-cast v11, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +017h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, -015h
    invoke-interface v11, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v11, Ljava/util/List;
    check-cast v11, Ljava/lang/Iterable;
    invoke-static v11, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, ","
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 62
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method private final buildUrl(com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  com.bytedance.trae.multilanguage.I18nLanguage)java.lang.String
    .registers 7
    # ins_size=3
    invoke-virtual v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;->getZoneHost()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 1
    new-array v1, v1, [C
    const/4 v2, 0
    const/16 v3, 47
    aput-char v3, v1, v2
    invoke-static v0, v1, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v0
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->buildLanguagesParam(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage;)Ljava/lang/String;
    move-result-object v6
    const-string v1, ","
    invoke-static v6, v1, Landroid/net/Uri;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "/check_and_get_text/"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;->getApiKey()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;->getMode()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;->getNamespace()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, "?lang="
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method

.method private final cacheDir(android.content.Context)java.io.File
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/io/File;
    invoke-virtual v3, Landroid/content/Context;->getFilesDir()Ljava/io/File;
    move-result-object v3
    const-string/jumbo v1, starling_online_text
    invoke-direct v0, v3, v1, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    return-object v0
.end method

.method private final cacheFile(java.io.File  java.lang.String)java.io.File
    .registers 5
    # ins_size=3
    new-instance v0, Ljava/io/File;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v1, ".json"
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v3, v4, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    return-object v0
.end method

.method private final cacheKey(com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  com.bytedance.trae.multilanguage.I18nLanguage)java.lang.String
    .registers 12
    # ins_size=3
    const/4 v0, 3
    new-array v0, v0, [Ljava/lang/String;
    const/4 v1, 0
    invoke-virtual v10, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;->getMode()Ljava/lang/String;
    move-result-object v2
    aput-object v2, v0, v1
    const/4 v1, 1
    invoke-virtual v10, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;->getNamespace()Ljava/lang/String;
    move-result-object v10
    aput-object v10, v0, v1
    const/4 v10, 2
    invoke-virtual v11, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v11
    aput-object v11, v0, v10
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, "_"
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 62
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    invoke-direct v9, v10, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->toCacheFilePart(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method private final checkStatus(org.json.JSONObject  java.lang.String)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, status
    invoke-virtual v4, v0, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z
    move-result v1
    if-nez v1, +003h
    return-void 
    const/16 v1, 200
    invoke-virtual v4, v0, v1, Lorg/json/JSONObject;->optInt(Ljava/lang/String; I)I
    move-result v0
    if-ne v0, v1, +003h
    return-void 
    new-instance v1, Ljava/lang/IllegalStateException;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, " status="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, ", message="
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, "message"
    invoke-virtual v4, v0, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v4
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v1, v4, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method private static final executor$lambda$1(java.lang.Runnable)java.lang.Thread
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/Thread;
    const-string/jumbo v1, starling-online-text
    invoke-direct v0, v2, v1, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable; Ljava/lang/String;)V
    const/4 v2, 1
    invoke-virtual v0, v2, Ljava/lang/Thread;->setDaemon(Z)V
    return-object v0
.end method

.method private final firstStringValue(org.json.JSONObject)java.lang.String
    .registers 6
    # ins_size=2
    const-string v0, "message"
    const-string v1, "defaultMessage"
    const-string/jumbo v2, value
    const-string/jumbo v3, text
    filled-new-array v2, v3, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +021h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v5, v1, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Ljava/lang/String;
    if-eqz v2, -012h
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -020h
    check-cast v1, Ljava/lang/String;
    return-object v1
    const/4 v5, 0
    return-object v5
.end method

.method private final loadCachedPayload(android.content.Context  com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  com.bytedance.trae.multilanguage.I18nLanguage)com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater$StarlingPayload
    .registers 8
    # ins_size=4
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v4
    check-cast v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    invoke-direct v4, v6, v7, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->cacheKey(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage;)Ljava/lang/String;
    move-result-object v6
    invoke-direct v4, v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->cacheDir(Landroid/content/Context;)Ljava/io/File;
    move-result-object v5
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->cacheFile(Ljava/io/File; Ljava/lang/String;)Ljava/io/File;
    move-result-object v5
    invoke-virtual v5, Ljava/io/File;->isFile()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v5, v0
    if-nez v5, +003h
    return-object v0
    new-instance v6, Lorg/json/JSONObject;
    const/4 v1, 1
    invoke-static v5, v0, v1, v0, Lkotlin/io/FilesKt;->readText$default(Ljava/io/File; Ljava/nio/charset/Charset; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-direct v6, v5, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string/jumbo v5, strings
    invoke-virtual v6, v5, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v5
    if-eqz v5, +008h
    const/4 v2, 0
    invoke-direct v4, v5, v2, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->toStringMap(Lorg/json/JSONObject; Z)Ljava/util/Map;
    move-result-object v5
    goto +2h
    move-object v5, v0
    if-nez v5, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v5
    invoke-interface v5, Ljava/util/Map;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move-object v1, v0
    goto +1ch
    const-string/jumbo v2, version
    invoke-virtual v6, v2, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v1, v2
    if-eqz v1, +003h
    goto +2h
    move-object v6, v0
    new-instance v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;
    invoke-direct v1, v5, v6, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;-><init>(Ljava/util/Map; Ljava/lang/String;)V
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    goto +ch
    move-exception v5
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v6
    if-eqz v6, +02ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "cache load failed: language="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v2, ", error="
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v6, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v2, "StarlingOnlineText"
    invoke-virtual v1, v2, v7, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v5, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;
    return-object v0
    :try_start_0x1
.end method

.method private final optVersion(org.json.JSONObject)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, "Version"
    const-string/jumbo v1, version
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda1;
    invoke-direct v1, v3, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda1;-><init>(Lorg/json/JSONObject;)V
    invoke-static v0, v1, Lkotlin/sequences/SequencesKt;->map(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v3
    invoke-interface v3, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +017h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, -018h
    goto +2h
    const/4 v0, 0
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method private static final optVersion$lambda$33(org.json.JSONObject  java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method private final parsePayload(java.lang.String  com.bytedance.trae.multilanguage.I18nLanguage)com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater$StarlingPayload
    .registers 11
    # ins_size=3
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, v9, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string v9, "Starling response"
    invoke-direct v8, v0, v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->checkStatus(Lorg/json/JSONObject; Ljava/lang/String;)V
    const-string v9, "message"
    invoke-virtual v0, v9, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v1
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +063h
    sget-object v4, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->INSTANCE Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    const-string v5, "Starling message"
    invoke-direct v4, v1, v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->checkStatus(Lorg/json/JSONObject; Ljava/lang/String;)V
    invoke-direct v4, v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->optVersion(Lorg/json/JSONObject;)Ljava/lang/String;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->DATA_KEYS Ljava/util/List;
    check-cast v5, Ljava/lang/Iterable;
    invoke-static v5, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda4;
    invoke-direct v6, v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda4;-><init>(Lorg/json/JSONObject;)V
    invoke-static v5, v6, Lkotlin/sequences/SequencesKt;->mapNotNull(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda5;
    invoke-direct v6, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda5;-><init>()V
    invoke-static v5, v6, Lkotlin/sequences/SequencesKt;->map(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v5
    invoke-interface v5, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +011h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Ljava/util/Map;
    invoke-interface v7, Ljava/util/Map;->isEmpty()Z
    move-result v7
    xor-int/2addr v7, v2
    if-eqz v7, -012h
    goto +2h
    move-object v6, v3
    check-cast v6, Ljava/util/Map;
    if-eqz v6, +008h
    new-instance v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;
    invoke-direct v9, v6, v4, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;-><init>(Ljava/util/Map; Ljava/lang/String;)V
    return-object v9
    const-string v5, "Data"
    invoke-virtual v1, v5, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z
    move-result v6
    if-eqz v6, +012h
    invoke-virtual v1, v5, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +00ch
    new-instance v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v10
    invoke-direct v9, v10, v4, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;-><init>(Ljava/util/Map; Ljava/lang/String;)V
    return-object v9
    const-string v1, "data"
    invoke-virtual v0, v1, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v4
    const/4 v5, 0
    if-eqz v4, +03eh
    sget-object v6, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->INSTANCE Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    const-string v7, "Starling data"
    invoke-direct v6, v4, v7, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->checkStatus(Lorg/json/JSONObject; Ljava/lang/String;)V
    invoke-direct v6, v4, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->optVersion(Lorg/json/JSONObject;)Ljava/lang/String;
    move-result-object v7
    if-nez v7, +00eh
    invoke-virtual v4, v9, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v7
    if-eqz v7, +007h
    invoke-direct v6, v7, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->optVersion(Lorg/json/JSONObject;)Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v3
    invoke-virtual v4, v9, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v9
    if-eqz v9, +01fh
    invoke-virtual v9, v1, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v9
    if-eqz v9, +019h
    invoke-static v6, v9, v5, v2, v3, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->toStringMap$default(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater; Lorg/json/JSONObject; Z I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v9
    if-eqz v9, +013h
    invoke-interface v9, Ljava/util/Map;->isEmpty()Z
    move-result v1
    xor-int/2addr v1, v2
    if-eqz v1, +003h
    goto +2h
    move-object v9, v3
    if-eqz v9, +008h
    new-instance v10, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;
    invoke-direct v10, v9, v7, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;-><init>(Ljava/util/Map; Ljava/lang/String;)V
    return-object v10
    new-instance v9, Ljava/util/ArrayList;
    invoke-direct v9, Ljava/util/ArrayList;-><init>()V
    check-cast v9, Ljava/util/List;
    invoke-direct v8, v0, v9, v10, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->addCandidateObjects(Lorg/json/JSONObject; Ljava/util/List; Lcom/bytedance/trae/multilanguage/I18nLanguage;)V
    check-cast v9, Ljava/lang/Iterable;
    new-instance v10, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v9, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v10, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v10, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +012h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->INSTANCE Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    invoke-static v4, v1, v5, v2, v3, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->toStringMap$default(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater; Lorg/json/JSONObject; Z I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v1
    invoke-interface v10, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v10, Ljava/util/List;
    check-cast v10, Ljava/lang/Iterable;
    new-instance v9, Ljava/util/ArrayList;
    invoke-direct v9, Ljava/util/ArrayList;-><init>()V
    check-cast v9, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Ljava/util/Map;
    invoke-interface v4, Ljava/util/Map;->isEmpty()Z
    move-result v4
    xor-int/2addr v4, v2
    if-eqz v4, -012h
    invoke-interface v9, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v9, Ljava/util/List;
    check-cast v9, Ljava/lang/Iterable;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-nez v10, +003h
    goto +28h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-nez v10, +003h
    goto +1dh
    move-object v10, v3
    check-cast v10, Ljava/util/Map;
    invoke-interface v10, Ljava/util/Map;->size()I
    move-result v10
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/util/Map;
    invoke-interface v2, Ljava/util/Map;->size()I
    move-result v2
    if-ge v10, v2, +004h
    move-object v3, v1
    move v10, v2
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-nez v1, -013h
    check-cast v3, Ljava/util/Map;
    if-nez v3, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v3
    new-instance v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;
    invoke-direct v8, v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->optVersion(Lorg/json/JSONObject;)Ljava/lang/String;
    move-result-object v10
    invoke-direct v9, v3, v10, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;-><init>(Ljava/util/Map; Ljava/lang/String;)V
    return-object v9
.end method

.method private static final parsePayload$lambda$22$lambda$18(org.json.JSONObject  java.lang.String)org.json.JSONObject
    .registers 3
    # ins_size=2
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v1
    return-object v1
.end method

.method private static final parsePayload$lambda$22$lambda$19(org.json.JSONObject)java.util.Map
    .registers 5
    # ins_size=1
    const-string v0, "it"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->INSTANCE Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    const/4 v1, 1
    const/4 v2, 0
    const/4 v3, 0
    invoke-static v0, v4, v3, v1, v2, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->toStringMap$default(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater; Lorg/json/JSONObject; Z I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v4
    return-object v4
.end method

.method private final redactAppKey(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    check-cast v3, Ljava/lang/CharSequence;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "/check_and_get_text/[^/]+/"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    const-string v1, "/check_and_get_text/***/"
    invoke-virtual v0, v3, v1, Lkotlin/text/Regex;->replace(Ljava/lang/CharSequence; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public static synthetic refresh$default(com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater  android.content.Context  com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  com.bytedance.trae.multilanguage.I18nLanguage  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  int  java.lang.Object)void
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 8
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v11, v13, 16
    if-eqz v11, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->refresh(Landroid/content/Context; Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final refresh$lambda$8(com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  com.bytedance.trae.multilanguage.I18nLanguage  android.content.Context  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2)void
    .registers 22
    # ins_size=5
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    move-object/from16 v2, v19
    move-object/from16 v3, v20
    move-object/from16 v4, v21
    const-string v5, ", url="
    const-string v6, ", version="
    const-string v7, ", count="
    const-string v8, "StarlingOnlineText"
    const-string v9, "cache hit: key="
    const-string/jumbo v10, refresh start: language=
    const-string v11, ""
    sget-object v12, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->INSTANCE Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    sget-object v13, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-direct v12, v0, v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->buildUrl(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage;)Ljava/lang/String;
    move-result-object v13
    invoke-direct v12, v2, v0, v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->loadCachedPayload(Landroid/content/Context; Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage;)Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;
    move-result-object v14
    if-eqz v14, +044h
    sget-object v15, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    move-object/from16 v16, v11
    invoke-virtual v14, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getStrings()Ljava/util/Map;
    move-result-object v11
    invoke-virtual v15, v1, v11, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->updateStrings(Lcom/bytedance/trae/multilanguage/I18nLanguage; Ljava/util/Map;)V
    sget-object v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v15, Ljava/lang/StringBuilder;
    invoke-direct v15, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v12, v0, v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->cacheKey(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage;)Ljava/lang/String;
    move-result-object v9
    invoke-virtual v15, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v14, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getStrings()Ljava/util/Map;
    move-result-object v15
    invoke-interface v15, Ljava/util/Map;->size()I
    move-result v15
    invoke-virtual v9, v15, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v14, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getVersion()Ljava/lang/String;
    move-result-object v14
    if-nez v14, +004h
    move-object/from16 v14, v16
    invoke-virtual v9, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v11, v8, v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +3h
    move-object/from16 v16, v11
    sget-object v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v11, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-direct v12, v13, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->redactAppKey(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v8, v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v12, v13, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->request(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-direct v12, v9, v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->parsePayload(Ljava/lang/String; Lcom/bytedance/trae/multilanguage/I18nLanguage;)Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getStrings()Ljava/util/Map;
    move-result-object v10
    invoke-interface v10, Ljava/util/Map;->isEmpty()Z
    move-result v10
    xor-int/lit8 v10, v10, 1
    if-eqz v10, +00eh
    sget-object v10, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getStrings()Ljava/util/Map;
    move-result-object v11
    invoke-virtual v10, v1, v11, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->updateStrings(Lcom/bytedance/trae/multilanguage/I18nLanguage; Ljava/util/Map;)V
    invoke-direct v12, v2, v0, v1, v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->saveCachedPayload(Landroid/content/Context; Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage; Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;)V
    new-instance v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextResult;
    invoke-virtual v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getStrings()Ljava/util/Map;
    move-result-object v2
    invoke-interface v2, Ljava/util/Map;->size()I
    move-result v2
    invoke-virtual v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getVersion()Ljava/lang/String;
    move-result-object v9
    invoke-direct v0, v1, v2, v13, v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextResult;-><init>(Lcom/bytedance/trae/multilanguage/I18nLanguage; I Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +16h
    move-exception v0
    goto +ah
    move-exception v0
    move-object/from16 v16, v11
    goto +6h
    move-exception v0
    move-object/from16 v16, v11
    move-object/from16 v13, v16
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isSuccess-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +045h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextResult;
    sget-object v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string/jumbo v11, refresh success: language=
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextResult;->getLanguage()Lcom/bytedance/trae/multilanguage/I18nLanguage;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v2, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextResult;->getStringCount()I
    move-result v10
    invoke-virtual v7, v10, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v2, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextResult;->getVersion()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +005h
    move-object/from16 v11, v16
    goto +2h
    move-object v11, v7
    invoke-virtual v6, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v9, v8, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v3, +005h
    invoke-interface v3, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-eqz v0, +04eh
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v6, refresh failed: language=
    invoke-direct v3, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    sget-object v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->INSTANCE Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    invoke-direct v5, v13, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->redactAppKey(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, ", error="
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, ": "
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v8, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    if-eqz v4, +005h
    invoke-interface v4, v1, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x1b
    :try_start_0x21
    :try_start_0x2b
.end method

.method public static synthetic refreshAll$default(com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater  android.content.Context  com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  java.util.List  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 4
    if-eqz v13, +018h
    const/4 v9, 3
    new-array v9, v9, [Lcom/bytedance/trae/multilanguage/I18nLanguage;
    const/4 v13, 0
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->EN Lcom/bytedance/trae/multilanguage/I18nLanguage;
    aput-object v0, v9, v13
    const/4 v13, 1
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->ZH Lcom/bytedance/trae/multilanguage/I18nLanguage;
    aput-object v0, v9, v13
    const/4 v13, 2
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nLanguage;->JA Lcom/bytedance/trae/multilanguage/I18nLanguage;
    aput-object v0, v9, v13
    invoke-static v9, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v9
    move-object v3, v9
    and-int/lit8 v9, v12, 8
    const/4 v13, 0
    if-eqz v9, +004h
    move-object v4, v13
    goto +2h
    move-object v4, v10
    and-int/lit8 v9, v12, 16
    if-eqz v9, +004h
    move-object v5, v13
    goto +2h
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->refreshAll(Landroid/content/Context; Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Ljava/util/List; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final refreshAll$lambda$2(com.bytedance.trae.multilanguage.I18nLanguage)java.lang.CharSequence
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    return-object v1
.end method

.method private final request(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    new-instance v0, Lcom/bytedance/common/utility/NetworkClient$ReqContext;
    invoke-direct v0, Lcom/bytedance/common/utility/NetworkClient$ReqContext;-><init>()V
    const/4 v1, 0
    iput-boolean v1, v0, Lcom/bytedance/common/utility/NetworkClient$ReqContext;->addCommonParams Z
    invoke-static Lcom/bytedance/common/utility/NetworkClient;->getDefault()Lcom/bytedance/common/utility/NetworkClient;
    move-result-object v1
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    invoke-virtual v1, v4, v2, v0, Lcom/bytedance/common/utility/NetworkClient;->get(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/common/utility/NetworkClient$ReqContext;)Ljava/lang/String;
    move-result-object v4
    const-string v0, "get(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method private final saveCachedPayload(android.content.Context  com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  com.bytedance.trae.multilanguage.I18nLanguage  com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater$StarlingPayload)void
    .registers 13
    # ins_size=5
    const-string v0, "StarlingOnlineText"
    const-string v1, "cache saved: key="
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v8
    check-cast v2, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    invoke-direct v8, v10, v11, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->cacheKey(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage;)Ljava/lang/String;
    move-result-object v10
    invoke-direct v8, v9, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->cacheDir(Landroid/content/Context;)Ljava/io/File;
    move-result-object v9
    invoke-virtual v9, Ljava/io/File;->mkdirs()Z
    invoke-direct v8, v9, v10, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->cacheFile(Ljava/io/File; Ljava/lang/String;)Ljava/io/File;
    move-result-object v2
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, version
    invoke-virtual v12, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getVersion()Ljava/lang/String;
    move-result-object v5
    const-string v6, ""
    if-nez v5, +003h
    move-object v5, v6
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string/jumbo v4, strings
    new-instance v5, Lorg/json/JSONObject;
    invoke-virtual v12, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getStrings()Ljava/util/Map;
    move-result-object v7
    invoke-direct v5, v7, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    invoke-virtual v3, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, toString(...)
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Ljava/io/File;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v7, ".tmp"
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-direct v4, v9, v5, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    const/4 v9, 2
    const/4 v5, 0
    invoke-static v4, v3, v5, v9, v5, Lkotlin/io/FilesKt;->writeText$default(Ljava/io/File; Ljava/lang/String; Ljava/nio/charset/Charset; I Ljava/lang/Object;)V
    invoke-virtual v4, v2, Ljava/io/File;->renameTo(Ljava/io/File;)Z
    move-result v7
    if-nez v7, +008h
    invoke-static v2, v3, v5, v9, v5, Lkotlin/io/FilesKt;->writeText$default(Ljava/io/File; Ljava/lang/String; Ljava/nio/charset/Charset; I Ljava/lang/Object;)V
    invoke-virtual v4, Ljava/io/File;->delete()Z
    sget-object v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v1, ", count="
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v12, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getStrings()Ljava/util/Map;
    move-result-object v1
    invoke-interface v1, Ljava/util/Map;->size()I
    move-result v1
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v1, ", version="
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v12, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;->getVersion()Ljava/lang/String;
    move-result-object v12
    if-nez v12, +003h
    goto +2h
    move-object v6, v12
    invoke-virtual v10, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v0, v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v9, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    goto +ch
    move-exception v9
    sget-object v10, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v9, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v9
    invoke-static v9, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    invoke-static v9, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v9
    if-eqz v9, +028h
    sget-object v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v12, Ljava/lang/StringBuilder;
    const-string v1, "cache save failed: language="
    invoke-direct v12, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v12, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", error="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v9, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v0, v11, v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x4
    :try_start_0x29
.end method

.method private final toCacheFilePart(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    check-cast v3, Ljava/lang/CharSequence;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "[^A-Za-z0-9._-]"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    const-string v1, "_"
    invoke-virtual v0, v3, v1, Lkotlin/text/Regex;->replace(Ljava/lang/CharSequence; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final toStringMap(org.json.JSONObject  boolean)java.util.Map
    .registers 9
    # ins_size=3
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    invoke-virtual v7, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +044h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-eqz v8, +01ah
    sget-object v3, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->META_KEYS Ljava/util/Set;
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget-object v4, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v4, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, toLowerCase(...)
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, v4, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto -25h
    invoke-virtual v7, v2, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v3
    instance-of v4, v3, Ljava/lang/String;
    if-eqz v4, +009h
    move-object v4, v0
    check-cast v4, Ljava/util/Map;
    invoke-interface v4, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -34h
    instance-of v4, v3, Lorg/json/JSONObject;
    if-eqz v4, -037h
    check-cast v3, Lorg/json/JSONObject;
    invoke-direct v6, v3, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->firstStringValue(Lorg/json/JSONObject;)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, -03fh
    move-object v4, v0
    check-cast v4, Ljava/util/Map;
    invoke-interface v4, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -47h
    check-cast v0, Ljava/util/Map;
    return-object v0
.end method

.method static synthetic toStringMap$default(com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater  org.json.JSONObject  boolean  int  java.lang.Object)java.util.Map
    .registers 5
    # ins_size=5
    const/4 v4, 1
    and-int/2addr v3, v4
    if-eqz v3, +003h
    move v2, v4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->toStringMap(Lorg/json/JSONObject; Z)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public final refresh(android.content.Context  com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  com.bytedance.trae.multilanguage.I18nLanguage  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2)void
    .registers 14
    # ins_size=6
    const-string v0, "context"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "config"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "language"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->executor Ljava/util/concurrent/ExecutorService;
    new-instance v7, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;
    move-object v1, v7
    move-object v2, v10
    move-object v3, v11
    move-object v4, v9
    move-object v5, v12
    move-object v6, v13
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage; Landroid/content/Context; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2;)V
    invoke-interface v0, v7, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public final refreshAll(android.content.Context  com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  java.util.List  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2)void
    .registers 25
    # ins_size=6
    move-object/from16 v0, v22
    const-string v1, "context"
    move-object/from16 v2, v20
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "config"
    move-object/from16 v9, v21
    invoke-static v9, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "languages"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, refreshAll scheduled: languages=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    new-instance v16, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda2;
    invoke-direct/range v16, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda2;-><init>()V
    const/16 v17, 31
    const/16 v18, 0
    move-object v10, v0
    invoke-static/range v10 ... v18, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "StarlingOnlineText"
    invoke-virtual v1, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Lcom/bytedance/trae/multilanguage/I18nLanguage;
    sget-object v3, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->INSTANCE Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    invoke-virtual/range v20, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v4
    const-string v1, "getApplicationContext(...)"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v5, v21
    move-object/from16 v7, v23
    move-object/from16 v8, v24
    invoke-virtual/range v3 ... v8, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->refresh(Landroid/content/Context; Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2;)V
    goto -21h
    return-void 
.end method
