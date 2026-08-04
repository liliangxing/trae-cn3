# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper$setupInitHook$1$beforeInit$1;
.super Ljava/lang/Object;
.source "AppLogInitHookHelper.kt"

.implements Lcom/bytedance/bdinstall/ISstInfoProvider;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getDefaultImeiOrMeid(android.content.Context  com.bytedance.bdinstall.InstallOptions)java.lang.String
    .registers 3
    # ins_size=3
    const-string v1, ""
    return-object v1
.end method

.method public getIPV6Address(android.content.Context)org.json.JSONArray
    .registers 21
    # ins_size=2
    const-string v0, "dummy0"
    const-string v1, "iterator(...)"
    new-instance v2, Lorg/json/JSONArray;
    invoke-direct v2, Lorg/json/JSONArray;-><init>()V
    invoke-static Ljava/net/NetworkInterface;->getNetworkInterfaces()Ljava/util/Enumeration;
    move-result-object v3
    if-nez v3, +008h
    new-instance v0, Lorg/json/JSONArray;
    invoke-direct v0, Lorg/json/JSONArray;-><init>()V
    return-object v0
    invoke-static Ljava/net/NetworkInterface;->getNetworkInterfaces()Ljava/util/Enumeration;
    move-result-object v3
    invoke-static v3, Ljava/util/Collections;->list(Ljava/util/Enumeration;)Ljava/util/ArrayList;
    move-result-object v3
    invoke-virtual v3, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +164h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/net/NetworkInterface;
    invoke-virtual v4, Ljava/net/NetworkInterface;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    const-string/jumbo v7, wlan0
    if-nez v6, +009h
    invoke-static v7, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +003h
    goto -1fh
    invoke-virtual v4, Ljava/net/NetworkInterface;->getInetAddresses()Ljava/util/Enumeration;
    move-result-object v4
    invoke-static v4, Ljava/util/Collections;->list(Ljava/util/Enumeration;)Ljava/util/ArrayList;
    move-result-object v4
    invoke-virtual v4, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, -033h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/net/InetAddress;
    invoke-virtual v6, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;
    move-result-object v6
    move-object v8, v6
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v8
    if-nez v8, -017h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v9, v6
    check-cast v9, Ljava/lang/CharSequence;
    const/16 v10, 58
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 6
    const/4 v14, 0
    invoke-static/range v9 ... v14, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v8
    if-gez v8, +004h
    const/4 v8, 1
    goto +2h
    const/4 v8, 0
    if-nez v8, -02eh
    move-object v11, v6
    check-cast v11, Ljava/lang/CharSequence;
    const/16 v12, 37
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 6
    const/16 v16, 0
    invoke-static/range v11 ... v16, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v8
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    const-string/jumbo v12, substring(...)
    const-string/jumbo v13, value
    const-string/jumbo v14, type
    const-string/jumbo v15, toUpperCase(...)
    const-string v9, "getDefault(...)"
    if-eqz v11, +03bh
    new-instance v11, Lorg/json/JSONObject;
    invoke-direct v11, Lorg/json/JSONObject;-><init>()V
    const-string v10, "client_tun"
    invoke-virtual v11, v14, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-gez v8, +011h
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v8
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v8, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +17h
    const/4 v10, 0
    invoke-virtual v6, v10, v8, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v8
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v8, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, v13, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v2, v11, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    goto/16 -089h
    invoke-static v7, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +06ah
    const-string v10, "fe80"
    move-object v11, v6
    check-cast v11, Ljava/lang/CharSequence;
    move-object/from16 v17, v0
    new-instance v0, Lkotlin/text/Regex;
    move-object/from16 v18, v1
    const-string v1, "::"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v0, v11, v1, Lkotlin/text/Regex;->split(Ljava/lang/CharSequence; I)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-nez v1, +030h
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v1
    invoke-interface v0, v1, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v11
    if-eqz v11, +022h
    invoke-interface v1, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-nez v11, +004h
    const/4 v11, 1
    goto +2h
    const/4 v11, 0
    if-nez v11, -017h
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/util/ListIterator;->nextIndex()I
    move-result v1
    const/4 v11, 1
    add-int/2addr v1, v11
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v0
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 0
    new-array v11, v1, [Ljava/lang/String;
    invoke-interface v0, v11, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Ljava/lang/String;
    aget-object v0, v0, v1
    const/4 v1, 1
    invoke-static v10, v0, v1, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, +003h
    goto +bh
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    goto/16 -0f7h
    move-object/from16 v17, v0
    move-object/from16 v18, v1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "client_anpi"
    invoke-virtual v0, v14, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-gez v8, +011h
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v1
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v1, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +17h
    const/4 v1, 0
    invoke-virtual v6, v1, v8, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v6
    invoke-static v6, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v6, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v13, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v2, v0, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    goto -41h
    move-exception v0
    invoke-virtual v0, Ljava/lang/Throwable;->printStackTrace()V
    return-object v2
    :try_start_0x9
    :try_start_0x3d
    :try_start_0xa5
.end method

.method public getImei(android.content.Context  int  com.bytedance.bdinstall.InstallOptions)java.lang.String
    .registers 4
    # ins_size=4
    const-string v1, ""
    return-object v1
.end method

.method public getMac(android.content.Context  com.bytedance.bdinstall.InstallOptions)java.lang.String
    .registers 3
    # ins_size=3
    const-string v1, ""
    return-object v1
.end method

.method public getMeid(android.content.Context  int  com.bytedance.bdinstall.InstallOptions)java.lang.String
    .registers 4
    # ins_size=4
    const-string v1, ""
    return-object v1
.end method

.method public getSerial(android.content.Context  com.bytedance.bdinstall.InstallOptions)java.lang.String
    .registers 4
    # ins_size=3
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v3, "getSerial"
    const-string v0, "getSerial callback"
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, ""
    return-object v2
.end method

.method public getSimSerialNumbers(android.content.Context  com.bytedance.bdinstall.InstallOptions)java.lang.String[]
    .registers 3
    # ins_size=3
    const/4 v1, 0
    new-array v1, v1, [Ljava/lang/String;
    return-object v1
.end method

.method public reflectGetDeviceIdWithSlotIndex(android.content.Context  int)java.lang.String
    .registers 3
    # ins_size=3
    const-string v1, ""
    return-object v1
.end method
