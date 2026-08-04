# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;
.super Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL;
.source "AppFetchBridgeMethod.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$Companion;
.field private static final DEFAULT_CONTENT_TYPE:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$HWQavO4pOMCXDi4cgnCwRZhgMGU(com.bytedance.trae.anniex.AppFetchBridgeMethod  com.bytedance.trae.anniex.AbsAppFetchMethodIDL$AppFetchParamModel  java.util.Map  java.util.Map  java.lang.String  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock  java.lang.String)void
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;->handle$lambda$8(Lcom/bytedance/trae/anniex/AppFetchBridgeMethod; Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel; Ljava/util/Map; Ljava/util/Map; Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; Ljava/lang/String;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;->Companion Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL;-><init>()V
    return-void 
.end method

.method private final buildPostBody(java.lang.Object)byte[]
    .registers 4
    # ins_size=2
    instance-of v0, v3, Ljava/lang/String;
    const-string v1, "getBytes(...)"
    if-eqz v0, +00eh
    check-cast v3, Ljava/lang/String;
    sget-object v0, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v3, v0, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2ch
    instance-of v0, v3, Ljava/util/Map;
    if-eqz v0, +01dh
    new-instance v0, Lorg/json/JSONObject;
    check-cast v3, Ljava/util/Map;
    invoke-direct v0, v3, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V
    invoke-virtual v0, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toString(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v3, v0, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +dh
    const-string/jumbo v3, {}
    sget-object v0, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v3, v0, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method private final buildUrl(java.lang.String  java.util.Map)java.lang.String
    .registers 5
    # ins_size=3
    invoke-interface v4, Ljava/util/Map;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-object v3
    invoke-static v3, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    invoke-virtual v3, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;
    move-result-object v3
    invoke-interface v4, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v4
    invoke-interface v4, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +018h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-virtual v3, v1, v0, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    goto -1bh
    invoke-virtual v3, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v3
    invoke-virtual v3, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, toString(...)
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method private final getExecutorService(com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext)java.util.concurrent.ExecutorService
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/sdk/xbridge/cn/utils/RuntimeHelper;->INSTANCE Lcom/bytedance/sdk/xbridge/cn/utils/RuntimeHelper;
    invoke-virtual v0, v2, Lcom/bytedance/sdk/xbridge/cn/utils/RuntimeHelper;->getThreadPoolDepend(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;)Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostThreadPoolExecutorDepend;
    move-result-object v2
    if-eqz v2, +008h
    invoke-interface v2, Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostThreadPoolExecutorDepend;->getNormalThreadExecutor()Ljava/util/concurrent/ExecutorService;
    move-result-object v2
    if-nez v2, +00bh
    invoke-static Ljava/util/concurrent/Executors;->newCachedThreadPool()Ljava/util/concurrent/ExecutorService;
    move-result-object v2
    const-string v0, "newCachedThreadPool(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method private static final handle$lambda$8(com.bytedance.trae.anniex.AppFetchBridgeMethod  com.bytedance.trae.anniex.AbsAppFetchMethodIDL$AppFetchParamModel  java.util.Map  java.util.Map  java.lang.String  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock  java.lang.String)void
    .registers 16
    # ins_size=7
    const/4 v0, 0
    invoke-interface v10, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;->getUrl()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v9, v1, v11, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;->buildUrl(Ljava/lang/String; Ljava/util/Map;)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "://"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v1, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 47
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v2, Ljava/util/Map;
    invoke-interface v12, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v3
    invoke-interface v3, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const/4 v5, 1
    if-eqz v4, +024h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/Map$Entry;
    invoke-interface v4, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +003h
    goto +2h
    move v5, v0
    if-eqz v5, -01bh
    invoke-interface v4, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v5
    invoke-interface v4, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v4
    invoke-interface v2, v5, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -28h
    new-instance v3, Ljava/util/ArrayList;
    invoke-interface v2, Ljava/util/Map;->size()I
    move-result v4
    invoke-direct v3, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v2
    invoke-interface v2, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01dh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/Map$Entry;
    new-instance v6, Lcom/bytedance/retrofit2/client/Header;
    invoke-interface v4, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    invoke-interface v4, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-direct v6, v7, v4, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v3, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -20h
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    instance-of v4, v3, Ljava/util/Collection;
    const-string v6, "X-Tt-Token"
    if-eqz v4, +00dh
    move-object v4, v3
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +004h
    move v3, v0
    goto +1ch
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/retrofit2/client/Header;
    invoke-virtual v4, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v6, v5, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v4
    if-eqz v4, -014h
    move v3, v5
    const-string v4, ""
    const/4 v7, 0
    if-nez v3, +031h
    const-class v3, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v3
    const-class v8, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v3, v8, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v3, +007h
    invoke-interface v3, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v7
    if-nez v3, +003h
    move-object v3, v4
    move-object v8, v3
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +004h
    move v8, v5
    goto +2h
    move v8, v0
    if-eqz v8, +00ah
    new-instance v8, Lcom/bytedance/retrofit2/client/Header;
    invoke-direct v8, v6, v3, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v2, v8, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    instance-of v6, v3, Ljava/util/Collection;
    const-string/jumbo v8, x-ide-token
    if-eqz v6, +00dh
    move-object v6, v3
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +004h
    move v3, v0
    goto +1ch
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, -00ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/retrofit2/client/Header;
    invoke-virtual v6, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v8, v5, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v6
    if-eqz v6, -014h
    move v3, v5
    if-nez v3, +031h
    const-class v3, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v3
    const-class v6, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v3, v6, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v3, +007h
    invoke-interface v3, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v7
    if-nez v3, +003h
    goto +2h
    move-object v4, v3
    move-object v3, v4
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +003h
    goto +2h
    move v5, v0
    if-eqz v5, +00ah
    new-instance v3, Lcom/bytedance/retrofit2/client/Header;
    invoke-direct v3, v8, v4, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v2, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    const-class v3, Lcom/bytedance/trae/anniex/AppFetchTtnetApi;
    invoke-static v1, v3, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsService(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/anniex/AppFetchTtnetApi;
    const-string v3, "GET"
    invoke-static v13, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00bh
    invoke-interface v1, v11, v2, Lcom/bytedance/trae/anniex/AppFetchTtnetApi;->get(Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/retrofit2/Call;
    move-result-object v9
    invoke-interface v9, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v9
    goto +37h
    const-string v3, "POST"
    invoke-static v13, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +0e0h
    const-string v13, "Content-Type"
    invoke-interface v12, v13, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/lang/String;
    if-nez v13, +00fh
    const-string v13, "content-type"
    invoke-interface v12, v13, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    move-object v13, v12
    check-cast v13, Ljava/lang/String;
    if-nez v13, +004h
    const-string v13, "application/x-www-form-urlencoded"
    invoke-interface v10, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;->getData()Ljava/lang/Object;
    move-result-object v10
    invoke-direct v9, v10, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;->buildPostBody(Ljava/lang/Object;)[B
    move-result-object v9
    new-instance v10, Lcom/bytedance/retrofit2/mime/TypedByteArray;
    new-array v12, v0, [Ljava/lang/String;
    invoke-direct v10, v13, v9, v12, Lcom/bytedance/retrofit2/mime/TypedByteArray;-><init>(Ljava/lang/String; [B [Ljava/lang/String;)V
    invoke-interface v1, v11, v2, v10, Lcom/bytedance/trae/anniex/AppFetchTtnetApi;->post(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/mime/TypedByteArray;)Lcom/bytedance/retrofit2/Call;
    move-result-object v9
    invoke-interface v9, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v9
    if-nez v9, +00eh
    const/4 v2, 0
    const-string/jumbo v3, response is null
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v14
    invoke-static/range v1 ... v6, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    invoke-virtual v9, Lcom/bytedance/retrofit2/SsResponse;->raw()Lcom/bytedance/retrofit2/client/Response;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/retrofit2/client/Response;->getStatus()I
    move-result v10
    invoke-virtual v9, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/retrofit2/mime/TypedInput;
    if-eqz v9, +02fh
    invoke-interface v9, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v9
    check-cast v9, Ljava/io/Closeable;
    move-object v11, v9
    check-cast v11, Ljava/io/InputStream;
    new-instance v12, Ljava/io/ByteArrayOutputStream;
    invoke-direct v12, Ljava/io/ByteArrayOutputStream;-><init>()V
    const/16 v13, 4096
    new-array v13, v13, [B
    invoke-virtual v11, v13, Ljava/io/InputStream;->read([B)I
    move-result v1
    if-lez v1, +006h
    invoke-virtual v12, v13, v0, v1, Ljava/io/ByteArrayOutputStream;->write([B I I)V
    goto -9h
    const-string v11, "UTF-8"
    invoke-virtual v12, v11, Ljava/io/ByteArrayOutputStream;->toString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    invoke-static v9, v7, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +bh
    move-exception v10
    throw v10
    move-exception v11
    invoke-static v9, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v11
    const-string/jumbo v11, {}
    const-string/jumbo v9, string
    invoke-static v15, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +003h
    goto +3ah
    new-instance v9, Lorg/json/JSONObject;
    invoke-direct v9, v11, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    goto +ch
    new-instance v9, Lorg/json/JSONObject;
    invoke-direct v9, Lorg/json/JSONObject;-><init>()V
    const-string v12, "raw"
    invoke-virtual v9, v12, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v9
    new-instance v11, Ljava/util/LinkedHashMap;
    invoke-direct v11, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v11, Ljava/util/Map;
    invoke-virtual v9, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v12
    const-string v13, "keys(...)"
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v13
    if-eqz v13, +010h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/lang/String;
    invoke-virtual v9, v13, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v15
    invoke-interface v11, v13, v15, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -13h
    invoke-static v11, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->assignX(Ljava/lang/Object;)Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/IXAssignDir;
    move-result-object v11
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-class v9, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchResultModel;
    invoke-static v9, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->createXModel(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;
    move-result-object v9
    move-object v12, v9
    check-cast v12, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchResultModel;
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    check-cast v10, Ljava/lang/Number;
    invoke-interface v12, v10, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchResultModel;->setStatus(Ljava/lang/Number;)V
    invoke-interface v12, v11, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchResultModel;->setResponse(Ljava/lang/Object;)V
    check-cast v9, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;
    const/4 v10, 2
    invoke-static v14, v9, v7, v10, v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onSuccess$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +41h
    const/4 v2, -3
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, Ljava/lang/StringBuilder;-><init>()V
    const-string v10, "Unsupported method: "
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v14
    invoke-static/range v1 ... v6, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    move-exception v9
    invoke-virtual v9, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v9
    if-nez v9, +005h
    const-string/jumbo v9, request failed
    const-class v10, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchResultModel;
    invoke-static v10, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->createXModel(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;
    move-result-object v10
    move-object v11, v10
    check-cast v11, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchResultModel;
    const/4 v12, -1
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    check-cast v12, Ljava/lang/Number;
    invoke-interface v11, v12, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchResultModel;->setStatus(Ljava/lang/Number;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v10, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;
    invoke-interface v14, v0, v9, v10, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;->onFailure(I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;)V
    return-void 
    :try_start_0x1
    :try_start_0xb2
    :try_start_0xdd
    :try_start_0x116
    :try_start_0x1e0
    :try_start_0x1fc
    :try_start_0x201
    :try_start_0x203
    :try_start_0x214
    :try_start_0x21a
.end method

.method public canRunInBackground()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public bridge synthetic handle(com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock)void
    .registers 4
    # ins_size=4
    check-cast v2, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;->handle(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext; Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;)V
    return-void 
.end method

.method public handle(com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext  com.bytedance.trae.anniex.AbsAppFetchMethodIDL$AppFetchParamModel  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock)void
    .registers 15
    # ins_size=4
    const-string v0, "bridgeContext"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v13, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;->getUrl()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +00eh
    const/4 v2, -3
    const-string/jumbo v3, url is empty
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v14
    invoke-static/range v1 ... v6, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    invoke-interface v12, Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;->getBridgeCall()Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;->getUrl()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-virtual v1, v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedUrl(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +00eh
    const/4 v2, -3
    const-string/jumbo v3, untrusted page domain
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v14
    invoke-static/range v1 ... v6, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-interface v13, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;->getUrl()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedUrl(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +00eh
    const/4 v2, -3
    const-string/jumbo v3, untrusted request domain
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v14
    invoke-static/range v1 ... v6, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    invoke-interface v13, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;->getMethod()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "GET"
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v2, "ROOT"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v0, toUpperCase(...)
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v13, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;->getResponseType()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "json"
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v13, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;->getHeader()Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Ljava/util/Map;
    if-eqz v1, +005h
    check-cast v0, Ljava/util/Map;
    goto +5h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    move-object v7, v0
    invoke-interface v13, Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;->getParams()Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Ljava/util/Map;
    if-eqz v1, +005h
    check-cast v0, Ljava/util/Map;
    goto +5h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    move-object v6, v0
    invoke-direct v11, v12, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;->getExecutorService(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;)Ljava/util/concurrent/ExecutorService;
    move-result-object v12
    new-instance v0, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;
    move-object v3, v0
    move-object v4, v11
    move-object v5, v13
    move-object v9, v14
    invoke-direct/range v3 ... v10, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/anniex/AppFetchBridgeMethod; Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel; Ljava/util/Map; Ljava/util/Map; Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; Ljava/lang/String;)V
    invoke-interface v12, v0, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method
