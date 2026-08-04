# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
.super Ljava/lang/Object;
.source "ArtifactRepository.kt"

.field public static final $stable:I
.field private static final Companion:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$Companion;
.field public static final DOWNLOAD_URL_ATTEMPTS:I
.field public static final DOWNLOAD_URL_RETRY_DELAY_MS:J
.field public static final IO_CHUNK_SIZE:I
.field private static final json:Lkotlinx/serialization/json/Json;
.field private final cache:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
.field private final cacheFileSystem:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;
.field private final cleanupScope:Lkotlinx/coroutines/CoroutineScope;
.field private final downloadClient:Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;
.field private final fileSystem:Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
.field private final httpClient:Lcom/bytedance/trae/kmp/network/KmpHttpClient;
.field private final inFlight:Ljava/util/Map;
.field private initialization:Lkotlinx/coroutines/CompletableDeferred;
.field private initialized:Z
.field private final maxCacheBytes:J
.field private final mutex:Lkotlinx/coroutines/sync/Mutex;
.field private final nowMillis:Lkotlin/jvm/functions/Function0;
.field private final repositoryDispatcher:Lkotlinx/coroutines/CoroutineDispatcher;


.method public static synthetic $r8$lambda$QEKi3kXIQC9BJw2vmmgBPdaKofc()long
    .registers 2
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->_init_$lambda$0()J
    move-result-wide v0
    return-wide v0
.end method

.method public static synthetic $r8$lambda$rOQdUGW-qBraMfiyLHmfVa0TSFk(kotlinx.serialization.json.JsonBuilder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->json$lambda$21(Lkotlinx/serialization/json/JsonBuilder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->$stable I
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$$ExternalSyntheticLambda0;-><init>()V
    const/4 v2, 1
    invoke-static v1, v0, v2, v1, Lkotlinx/serialization/json/JsonKt;->Json$default(Lkotlinx/serialization/json/Json; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Lkotlinx/serialization/json/Json;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->json Lkotlinx/serialization/json/Json;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.artifact.KmpBinaryDownloadClient  com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem  kotlinx.coroutines.CoroutineScope  long  kotlin.jvm.functions.Function0  kotlinx.coroutines.CoroutineDispatcher)void
    .registers 10
    # ins_size=9
    const-string v0, "httpClient"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "downloadClient"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "fileSystem"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, ownerScope
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, nowMillis
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, repositoryDispatcher
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->downloadClient Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-wide v6, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->maxCacheBytes J
    iput-object v8, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->nowMillis Lkotlin/jvm/functions/Function0;
    iput-object v9, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->repositoryDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;
    invoke-direct v2, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;-><init>(Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;)V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cacheFileSystem Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ManagedCacheFileSystem;
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;
    invoke-direct v3, v2, v6, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem; J)V
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cache Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    invoke-static v5, v9, Lcom/bytedance/trae/kmp/repository/KmpRepositoryCoroutinesKt;->repositoryScope(Lkotlinx/coroutines/CoroutineScope; Lkotlinx/coroutines/CoroutineDispatcher;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cleanupScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 0
    invoke-static v4, v2, v3, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v2, Ljava/util/Map;
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->inFlight Ljava/util/Map;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.artifact.KmpBinaryDownloadClient  com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem  kotlinx.coroutines.CoroutineScope  long  kotlin.jvm.functions.Function0  kotlinx.coroutines.CoroutineDispatcher  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 22
    # ins_size=11
    and-int/lit8 v0, v20, 16
    if-eqz v0, +007h
    const-wide/32 v0, 104857600
    move-wide v7, v0
    goto +3h
    move-wide/from16 v7, v16
    and-int/lit8 v0, v20, 32
    if-eqz v0, +009h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$$ExternalSyntheticLambda1;-><init>()V
    move-object v9, v0
    goto +3h
    move-object/from16 v9, v18
    and-int/lit8 v0, v20, 64
    if-eqz v0, +008h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v10, v0
    goto +3h
    move-object/from16 v10, v19
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient; Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem; Lkotlinx/coroutines/CoroutineScope; J Lkotlin/jvm/functions/Function0; Lkotlinx/coroutines/CoroutineDispatcher;)V
    return-void 
.end method

.method private static final _init_$lambda$0()long
    .registers 2
    # ins_size=0
    sget-object v0, Lkotlinx/datetime/Clock$System;->INSTANCE Lkotlinx/datetime/Clock$System;
    invoke-virtual v0, Lkotlinx/datetime/Clock$System;->now()Lkotlinx/datetime/Instant;
    move-result-object v0
    invoke-virtual v0, Lkotlinx/datetime/Instant;->toEpochMilliseconds()J
    move-result-wide v0
    return-wide v0
.end method

.method public static final synthetic access$cleanupFiles(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  java.util.Collection  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cleanupFiles(Ljava/util/Collection; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$decodeLocalFile(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->decodeLocalFile(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$distribute(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$PreparedResource  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->distribute(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource; Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getCache$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository)com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cache Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    return-object v0
.end method

.method public static final synthetic access$getFileSystem$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository)com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    return-object v0
.end method

.method public static final synthetic access$getJson$cp()kotlinx.serialization.json.Json
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->json Lkotlinx/serialization/json/Json;
    return-object v0
.end method

.method public static final synthetic access$initializeInRepositoryContext(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initializeInRepositoryContext(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$locate(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->locate(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$locateLocal(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->locateLocal(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$locateRemote(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->locateRemote(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$prepareInRepositoryContext(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->prepareInRepositoryContext(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$prepareUncached(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  java.lang.String  com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->prepareUncached(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Ljava/lang/String; Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$ready(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  java.lang.String  com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->ready(Ljava/lang/String; Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$restoreCache(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->restoreCache(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final cleanupFiles(java.util.Collection  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    sget-object v0, Lkotlinx/coroutines/NonCancellable;->INSTANCE Lkotlinx/coroutines/NonCancellable;
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;
    const/4 v2, 0
    invoke-direct v1, v4, v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$cleanupFiles$2;-><init>(Ljava/util/Collection; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    if-ne v4, v5, +003h
    return-object v4
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private final decodeLocalFile(com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 24
    # ins_size=3
    move-object/from16 v1, v21
    move-object/from16 v0, v23
    instance-of v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;
    if-eqz v2, +012h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;
    iget v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->label I
    const/4 v5, 0
    const/4 v7, 1
    packed-switch v4, +0000193h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v2, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +17fh
    iget-object v2, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +140h
    iget v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->I$0 I
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$1 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +130h
    move-exception v0
    goto +42h
    iget-wide v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->J$0 J
    iget v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->I$0 I
    iget-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$4 Ljava/lang/Object;
    check-cast v10, [B
    iget-object v11, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$3 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;
    iget-object v12, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$2 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v13, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$1 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v14, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    check-cast v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0c9h
    move-exception v0
    move v6, v4
    goto +20h
    iget v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->I$1 I
    iget-wide v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->J$0 J
    iget v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->I$0 I
    iget-object v11, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$3 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;
    iget-object v12, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$2 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v13, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$1 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v14, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    check-cast v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v15, v4
    move-object v4, v12
    goto/16 +070h
    move-exception v0
    move v6, v10
    move-object v4, v12
    move-object v7, v14
    move-object/from16 v20, v2
    move-object v2, v0
    move-object/from16 v0, v20
    goto/16 +100h
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$1 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +18h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    move-object/from16 v4, v22
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$1 Ljava/lang/Object;
    iput v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->label I
    const-string v8, "artifact-decoded"
    invoke-interface v0, v8, v2, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->createTemporaryFile(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v8, v1
    move-object v9, v0
    check-cast v9, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;-><init>()V
    const-wide/16 v10, 0
    move-object v13, v8
    move-object v14, v9
    const/4 v12, 0
    const/4 v15, 0
    iget-object v8, v13, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    const/high16 v16, 65536
    iput-object v13, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$1 Ljava/lang/Object;
    iput-object v14, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$2 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$3 Ljava/lang/Object;
    iput-object v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$4 Ljava/lang/Object;
    iput v12, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->I$0 I
    iput-wide v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->J$0 J
    iput v15, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->I$1 I
    const/4 v9, 2
    iput v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->label I
    move-object v9, v4
    move-wide/from16 v17, v10
    move/from16 v19, v12
    move/from16 v12, v16
    move-object/from16 v16, v13
    move-object v13, v2
    invoke-interface/range v8 ... v13, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->read(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; J I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v3, +003h
    return-object v3
    move-object v11, v0
    move-object v13, v4
    move-object v0, v8
    move-object v4, v14
    move-object/from16 v14, v16
    move-wide/from16 v8, v17
    move/from16 v10, v19
    check-cast v0, [B
    array-length v12, v0
    if-nez v12, +004h
    move v12, v7
    goto +2h
    const/4 v12, 0
    if-nez v12, +050h
    invoke-virtual v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->decode([B)[B
    move-result-object v12
    array-length v6, v12
    if-nez v6, +004h
    move v6, v7
    goto +2h
    const/4 v6, 0
    xor-int/2addr v6, v7
    if-eqz v6, +02eh
    iget-object v6, v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    if-eqz v15, +004h
    move v15, v7
    goto +2h
    const/4 v15, 0
    iput-object v14, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    iput-object v13, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$1 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$2 Ljava/lang/Object;
    iput-object v11, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$3 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$4 Ljava/lang/Object;
    iput v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->I$0 I
    iput-wide v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->J$0 J
    const/4 v5, 3
    iput v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->label I
    invoke-interface v6, v4, v12, v15, v2, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->write(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; [B Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v3, +003h
    return-object v3
    move-object v12, v4
    move v4, v10
    move-object v10, v0
    move v15, v7
    move-object v0, v10
    move-object/from16 v20, v12
    move v12, v4
    move-object v4, v13
    move-object v13, v14
    move-object/from16 v14, v20
    goto +8h
    move v12, v10
    move-object/from16 v20, v14
    move-object v14, v4
    move-object v4, v13
    move-object/from16 v13, v20
    array-length v0, v0
    int-to-long v5, v0
    add-long/2addr v5, v8
    move-object v0, v11
    move-wide v10, v5
    const/4 v5, 0
    goto/16 -082h
    move-exception v0
    move v6, v12
    move-object v7, v13
    move-object v4, v14
    goto/16 -0c0h
    invoke-virtual v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->finish()[B
    move-result-object v0
    array-length v5, v0
    if-nez v5, +004h
    move v5, v7
    goto +2h
    const/4 v5, 0
    xor-int/2addr v5, v7
    if-eqz v5, +01eh
    iget-object v5, v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    if-eqz v15, +004h
    move v6, v7
    goto +2h
    const/4 v6, 0
    iput-object v14, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$1 Ljava/lang/Object;
    const/4 v7, 0
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$2 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$3 Ljava/lang/Object;
    iput v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->I$0 I
    const/4 v7, 4
    iput v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->label I
    invoke-interface v5, v4, v0, v6, v2, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->write(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; [B Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v2, v4
    return-object v2
    move-exception v0
    move v6, v10
    goto/16 -0f0h
    move-exception v0
    goto +6h
    move-exception v0
    move/from16 v19, v12
    move-object/from16 v16, v13
    move-object v4, v14
    move-object/from16 v7, v16
    move/from16 v6, v19
    goto/16 -0fdh
    move-exception v0
    move-object v7, v8
    move-object v4, v9
    const/4 v6, 0
    goto/16 -103h
    if-nez v6, +01dh
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$0 Ljava/lang/Object;
    const/4 v5, 0
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$1 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$2 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$3 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->L$4 Ljava/lang/Object;
    const/4 v5, 6
    iput v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$decodeLocalFile$1;->label I
    invoke-direct v7, v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cleanupFiles(Ljava/util/Collection; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    throw v2
    nop 
    packed-switch-payload 0 1 2 3 4 5 6
    :try_start_0x4e
    :try_start_0x6d
    :try_start_0x8b
    :try_start_0xc3
    :try_start_0xce
    :try_start_0xef
    :try_start_0x100
    :try_start_0x14a
    :try_start_0x158
.end method

.method private final distribute(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$PreparedResource  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=4
    instance-of v0, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;
    invoke-direct v0, v8, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 1
    if-eqz v2, +03ah
    if-eq v2, v5, +024h
    if-eq v2, v4, +011h
    if-ne v2, v3, +007h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +109h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v10, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$2 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v10, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$1 Ljava/lang/Object;
    check-cast v10, Ljava/util/Iterator;
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0d0h
    iget-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$3 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v10, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$2 Ljava/lang/Object;
    check-cast v10, Ljava/util/Iterator;
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource;
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$0 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +67h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    instance-of v11, v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;
    if-eqz v11, +024h
    check-cast v10, Ljava/lang/Iterable;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +066h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lkotlinx/coroutines/CompletableDeferred;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Failed;
    move-object v1, v9
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Failed;-><init>(Ljava/lang/String;)V
    invoke-interface v11, v0, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    goto -1bh
    instance-of v11, v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Cached;
    if-eqz v11, +04fh
    check-cast v10, Ljava/lang/Iterable;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    move-object v3, v8
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +03fh
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lkotlinx/coroutines/CompletableDeferred;
    invoke-interface v11, Lkotlinx/coroutines/CompletableDeferred;->isActive()Z
    move-result v2
    if-eqz v2, -010h
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Cached;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Cached;->getCacheReference()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Cached;->getFile()Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v2
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$0 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$1 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$2 Ljava/lang/Object;
    iput-object v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$3 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->label I
    invoke-direct v3, v4, v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->ready(Ljava/lang/String; Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    move-object v7, v2
    move-object v2, v9
    move-object v9, v11
    move-object v11, v7
    check-cast v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;
    invoke-interface v9, v11, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +009h
    invoke-virtual v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;->getLease()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;
    move-result-object v9
    invoke-interface v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;->release()V
    move-object v9, v2
    goto -42h
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    instance-of v11, v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Temporary;
    if-eqz v11, +061h
    new-instance v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    iget-object v2, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Temporary;
    invoke-virtual v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Temporary;->getFile()Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v5
    invoke-virtual v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Temporary;->getLocalUri()Ljava/lang/String;
    move-result-object v9
    iget-object v6, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cleanupScope Lkotlinx/coroutines/CoroutineScope;
    invoke-direct v11, v2, v5, v9, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;-><init>(Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem; Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope;)V
    check-cast v10, Ljava/lang/Iterable;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    move-object v10, v9
    move-object v2, v11
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +02dh
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lkotlinx/coroutines/CompletableDeferred;
    invoke-interface v9, Lkotlinx/coroutines/CompletableDeferred;->isActive()Z
    move-result v11
    if-eqz v11, -010h
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$0 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$1 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$2 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->label I
    invoke-virtual v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->acquire(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    check-cast v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;
    invoke-interface v9, v11, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, -027h
    invoke-virtual v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;->getLease()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;
    move-result-object v9
    invoke-interface v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;->release()V
    goto -30h
    const/4 v9, 0
    iput-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$0 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$1 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->L$2 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$distribute$1;->label I
    invoke-virtual v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->finishDistribution(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, +003h
    return-object v1
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    new-instance v9, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v9, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v9
.end method

.method private final initializeInRepositoryContext(kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=2
    instance-of v0, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;
    invoke-direct v0, v7, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    const/4 v3, 1
    const/4 v4, 0
    packed-switch v2, +000016bh
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$3 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/sync/Mutex;
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v2, Ljava/lang/Throwable;
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v3, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +109h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$3 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/sync/Mutex;
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v2, Ljava/util/concurrent/CancellationException;
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v3, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +11eh
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    iget-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v5, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0b7h
    move-exception v8
    move-object v2, v8
    move-object v3, v5
    goto/16 +0c8h
    move-exception v8
    move-object v2, v8
    move-object v3, v5
    goto/16 +0edh
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v6, v5
    move-object v5, v2
    goto/16 +08ch
    move-exception v8
    move-object v3, v2
    move-object v6, v5
    move-object v2, v8
    goto/16 +0aeh
    move-exception v8
    move-object v3, v2
    move-object v6, v5
    move-object v2, v8
    goto/16 +0d2h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +6ah
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    iget-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +14h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    invoke-interface v2, v4, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    move-object v5, v7
    iget-boolean v8, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initialized Z
    if-eqz v8, +008h
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v2, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v8
    iget-object v8, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initialization Lkotlinx/coroutines/CompletableDeferred;
    if-eqz v8, +00dh
    const/4 v6, 0
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    invoke-static v8, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v8
    if-nez v8, +010h
    invoke-static v4, v3, v4, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v8
    iput-object v8, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initialization Lkotlinx/coroutines/CompletableDeferred;
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    invoke-static v8, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v8
    invoke-interface v2, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    invoke-virtual v8, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlinx/coroutines/CompletableDeferred;
    invoke-virtual v8, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/Boolean;
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    if-nez v8, +013h
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    const/4 v8, 2
    iput v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    invoke-interface v2, v0, Lkotlinx/coroutines/CompletableDeferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    const/4 v8, 3
    iput v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    invoke-direct v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->restoreCache(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, -08bh
    return-object v1
    iget-object v2, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$2 Ljava/lang/Object;
    const/4 v8, 4
    iput v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    invoke-interface v2, v4, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    iput-boolean v3, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initialized Z
    iput-object v4, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initialization Lkotlinx/coroutines/CompletableDeferred;
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v2, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v5, v8, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    move-exception v8
    invoke-interface v2, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v8
    iget-object v8, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$3 Ljava/lang/Object;
    const/4 v5, 6
    iput v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    invoke-interface v8, v4, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v1, v8
    move-object v0, v6
    iget-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initialization Lkotlinx/coroutines/CompletableDeferred;
    if-ne v8, v3, +004h
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initialization Lkotlinx/coroutines/CompletableDeferred;
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v1, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    invoke-interface v3, v2, Lkotlinx/coroutines/CompletableDeferred;->completeExceptionally(Ljava/lang/Throwable;)Z
    throw v2
    move-exception v8
    invoke-interface v1, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v8
    iget-object v8, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->L$3 Ljava/lang/Object;
    const/4 v5, 5
    iput v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    invoke-interface v8, v4, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v1, v8
    move-object v0, v6
    iget-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initialization Lkotlinx/coroutines/CompletableDeferred;
    if-ne v8, v3, +004h
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initialization Lkotlinx/coroutines/CompletableDeferred;
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v1, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    invoke-interface v3, v2, Lkotlinx/coroutines/CompletableDeferred;->cancel(Ljava/util/concurrent/CancellationException;)V
    throw v2
    move-exception v8
    invoke-interface v1, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v8
    move-exception v8
    invoke-interface v2, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v8
    nop 
    packed-switch-payload 0 1 2 3 4 5 6
    :try_start_0x64
    :try_start_0x7b
    :try_start_0xb1
    :try_start_0xbb
    :try_start_0xfe
    :try_start_0x10c
    :try_start_0x11e
    :try_start_0x124
    :try_start_0x130
    :try_start_0x14a
    :try_start_0x174
.end method

.method private static final json$lambda$21(kotlinx.serialization.json.JsonBuilder)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "$this$Json"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-virtual v1, v0, Lkotlinx/serialization/json/JsonBuilder;->setIgnoreUnknownKeys(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final locate(com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=3
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getSource()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    if-eq v0, v1, +010h
    const/4 v1, 2
    if-ne v0, v1, +007h
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->locateLocal(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->locateRemote(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
.end method

.method private final locateLocal(com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 30
    # ins_size=3
    move-object/from16 v0, v29
    instance-of v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;
    iget v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->label I
    move-object/from16 v2, v27
    goto +8h
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;
    move-object/from16 v2, v27
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->label I
    const/4 v5, 2
    const/4 v6, 0
    const/4 v8, 1
    if-eqz v4, +044h
    if-eq v4, v8, +025h
    if-ne v4, v5, +01bh
    iget v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->I$1 I
    iget v9, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->I$0 I
    iget-object v10, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$2 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v11, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$1 Ljava/lang/Object;
    check-cast v11, Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v15, v9
    move-object v7, v10
    move-object v0, v11
    move-object v14, v12
    goto/16 +13ch
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->I$2 I
    iget v9, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->I$1 I
    iget v10, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->I$0 I
    iget-object v11, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$2 Ljava/lang/Object;
    check-cast v11, Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$1 Ljava/lang/Object;
    check-cast v12, Ljava/lang/String;
    iget-object v13, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v7, v4
    move v4, v9
    move v9, v10
    move-object v10, v11
    move-object v11, v12
    move-object v12, v13
    goto/16 +09bh
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;
    invoke-virtual/range v28, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getArtifactPath()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;->localTarget(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    sget-object v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->json Lkotlinx/serialization/json/Json;
    check-cast v4, Lkotlinx/serialization/StringFormat;
    new-instance v15, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    invoke-virtual/range v28, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getConversationId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v28, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getMessageId()Ljava/lang/String;
    move-result-object v12
    const/4 v13, 0
    const/16 v14, 8
    const/16 v16, 0
    move-object v9, v15
    move-object v7, v15
    move-object/from16 v15, v16
    invoke-direct/range v9 ... v15, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v4, Lkotlinx/serialization/StringFormat;->getSerializersModule()Lkotlinx/serialization/modules/SerializersModule;
    sget-object v9, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v9
    check-cast v9, Lkotlinx/serialization/SerializationStrategy;
    invoke-interface v4, v9, v7, Lkotlinx/serialization/StringFormat;->encodeToString(Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const/4 v7, 4
    move-object v14, v2
    move v15, v7
    move-object v7, v4
    const/4 v4, 0
    if-ge v4, v15, +0d9h
    iget-object v9, v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    sget-object v10, Lcom/bytedance/trae/kmp/network/KmpHostType;->Ai Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v11, "/api/solo_hub/v1/conversations/artifact/get_download_url"
    const/4 v13, 0
    const/16 v16, 0
    new-instance v26, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    const-string v18, "artifact_download_url"
    const/16 v19, 1
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    sget-object v23, Lcom/bytedance/trae/kmp/network/KmpHostType;->Ai Lcom/bytedance/trae/kmp/network/KmpHostType;
    const/16 v24, 28
    const/16 v25, 0
    move-object/from16 v17, v26
    invoke-direct/range v17 ... v25, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v12, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v12
    move-object/from16 v17, v12
    check-cast v17, Lkotlinx/serialization/DeserializationStrategy;
    const/16 v18, 24
    const/16 v19, 0
    iput-object v14, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$0 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$1 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$2 Ljava/lang/Object;
    iput v15, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->I$0 I
    iput v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->I$1 I
    iput v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->I$2 I
    iput v8, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->label I
    move-object v12, v7
    move-object/from16 v20, v14
    move-object/from16 v14, v16
    move/from16 v21, v15
    move-object/from16 v15, v26
    move-object/from16 v16, v17
    move-object/from16 v17, v1
    invoke-static/range v9 ... v19, Lcom/bytedance/trae/kmp/network/KmpHttpClient$DefaultImpls;->postResult$default(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlinx/serialization/DeserializationStrategy; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v3, +003h
    return-object v3
    move-object v11, v0
    move-object v10, v7
    move-object v0, v9
    move-object/from16 v12, v20
    move/from16 v9, v21
    move v7, v4
    check-cast v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getData()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;
    if-eqz v13, +036h
    invoke-virtual v13, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->getData()Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    move-result-object v13
    if-eqz v13, +030h
    invoke-virtual v13, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->getUrlMap()Ljava/util/Map;
    move-result-object v13
    if-eqz v13, +02ah
    invoke-interface v13, v11, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/lang/String;
    if-eqz v13, +022h
    move-object v14, v13
    check-cast v14, Ljava/lang/CharSequence;
    invoke-static v14, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v14
    xor-int/2addr v14, v8
    if-eqz v14, +005h
    move-object/from16 v16, v13
    goto +3h
    move-object/from16 v16, v6
    if-eqz v16, +011h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 6
    const/16 v20, 0
    move-object v15, v0
    invoke-direct/range v15 ... v20, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;-><init>(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getStatusCode()I
    move-result v13
    const/16 v14, 202
    if-eq v13, v14, +01ch
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->getCode()J
    move-result-wide v13
    const-wide/16 v15, 202
    cmp-long v0, v13, v15
    if-nez v0, +004h
    move v0, v8
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v8
    if-eqz v0, +01eh
    const/4 v0, 3
    if-ne v7, v0, +003h
    goto +19h
    iput-object v12, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$0 Ljava/lang/Object;
    iput-object v11, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$1 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->L$2 Ljava/lang/Object;
    iput v9, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->I$0 I
    iput v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->I$1 I
    iput v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateLocal$1;->label I
    const-wide/16 v13, 50
    invoke-static v13, v14, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, -13dh
    return-object v3
    add-int/2addr v4, v8
    goto/16 -0d7h
    return-object v6
.end method

.method private final locateRemote(com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 26
    # ins_size=3
    move-object/from16 v0, v23
    move-object/from16 v1, v25
    instance-of v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;
    iget v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    move-object v10, v2
    iget-object v1, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;->label I
    const/4 v13, 1
    if-eqz v3, +016h
    if-ne v3, v13, +00ch
    iget-object v2, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v3, v1
    move-object v1, v2
    goto +54h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    sget-object v4, Lcom/bytedance/trae/kmp/network/KmpHostType;->Remote Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v5, "/api/remote/v1/chat_sessions/"
    invoke-direct v1, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getCliConversationId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    new-instance v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    const-string v15, "artifact_chat_session"
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    sget-object v20, Lcom/bytedance/trae/kmp/network/KmpHostType;->Remote Lcom/bytedance/trae/kmp/network/KmpHostType;
    const/16 v21, 30
    const/16 v22, 0
    move-object v14, v8
    invoke-direct/range v14 ... v22, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Lkotlinx/serialization/DeserializationStrategy;
    const/16 v11, 12
    const/4 v12, 0
    move-object/from16 v1, v24
    iput-object v1, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;->L$0 Ljava/lang/Object;
    iput v13, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$locateRemote$1;->label I
    invoke-static/range v3 ... v12, Lcom/bytedance/trae/kmp/network/KmpHttpClient$DefaultImpls;->getResult$default(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlinx/serialization/DeserializationStrategy; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v2, +003h
    return-object v2
    check-cast v3, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;
    const/4 v3, 0
    if-eqz v2, +04fh
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;->getCode()J
    move-result-wide v4
    const-wide/16 v6, 0
    cmp-long v4, v4, v6
    if-nez v4, +004h
    move v4, v13
    goto +2h
    const/4 v4, 0
    if-eqz v4, +003h
    goto +2h
    move-object v2, v3
    if-eqz v2, +03ch
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;->getData()Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;
    move-result-object v2
    if-nez v2, +003h
    goto +34h
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->getExplorerUrl()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +02fh
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v13
    if-eqz v5, +003h
    goto +2h
    move-object v4, v3
    if-nez v4, +003h
    goto +1fh
    sget-object v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->getWorkspacePath()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getArtifactPath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v4, v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;->remoteDownloadRequest(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;
    move-result-object v1
    new-instance v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;->getUrl()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    sget-object v5, Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;->CloudIdeJwt Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    const/4 v6, 2
    const/4 v7, 0
    move-object v2, v8
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;-><init>(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v8
    return-object v3
.end method

.method private final prepareInRepositoryContext(com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=3
    move-object/from16 v1, v19
    move-object/from16 v0, v21
    instance-of v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;
    if-eqz v2, +012h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;
    iget v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    const/4 v5, 1
    const/4 v6, 0
    packed-switch v4, +000036dh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    check-cast v3, Lkotlinx/coroutines/sync/Mutex;
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    check-cast v4, Ljava/util/concurrent/CancellationException;
    iget-object v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v2, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +30fh
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;
    iget-object v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +2d7h
    move-exception v0
    move-object v8, v7
    move-object v7, v5
    goto +17h
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;
    iget-object v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v5, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +2abh
    move-exception v0
    move-object v5, v4
    move-object v4, v0
    goto/16 +2c3h
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$5 Ljava/lang/Object;
    check-cast v4, Lkotlinx/coroutines/sync/Mutex;
    iget-object v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;
    iget-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v0, v8
    move-object v8, v10
    move-object/from16 v17, v9
    move-object v9, v4
    move-object v4, v7
    move-object/from16 v7, v17
    goto/16 +24fh
    move-exception v0
    move-object v4, v0
    move-object v5, v7
    move-object v7, v9
    move-object v8, v10
    goto/16 +297h
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;
    iget-object v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v5, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +1fbh
    move-exception v0
    goto/16 +204h
    move-exception v0
    goto/16 +27bh
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +1d3h
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$6 Ljava/lang/Object;
    check-cast v4, Lkotlinx/coroutines/sync/Mutex;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$5 Ljava/lang/Object;
    check-cast v7, Lkotlinx/coroutines/CompletableDeferred;
    iget-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v11, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    iget-object v12, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v0, v8
    move-object v8, v10
    move-object v10, v12
    goto/16 +14bh
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +113h
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0f2h
    iget-wide v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->J$0 J
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0cah
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    iget-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v9
    move-object v9, v7
    goto/16 +07ch
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v0, v4
    move-object v10, v7
    goto +14h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    move-object/from16 v0, v20
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-direct v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->initializeInRepositoryContext(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v3, +003h
    return-object v3
    move-object v10, v1
    new-instance v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheKey;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getSource()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    move-result-object v12
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getCliConversationId()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getMessageId()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getArtifactPath()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getRendition()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
    move-result-object v16
    move-object v11, v4
    invoke-direct/range v11 ... v16, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheKey;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;)V
    invoke-virtual v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheKey;->stableId()Ljava/lang/String;
    move-result-object v8
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v7, "cache/"
    invoke-direct v4, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getArtifactPath()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepositoryKt;->access$extensionSuffix(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    iget-object v7, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    invoke-interface v7, v4, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->file(Ljava/lang/String;)Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v7
    iget-object v9, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    const/4 v11, 2
    iput v11, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-interface v9, v7, v2, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->exists(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v3, +003h
    return-object v3
    move-object v11, v0
    move-object v0, v9
    move-object v9, v4
    move-object v4, v7
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-eqz v0, +053h
    iget-object v0, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->nowMillis Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v7
    iget-object v0, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    iput-wide v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->J$0 J
    const/4 v5, 3
    iput v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-interface v0, v4, v7, v8, v2, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->touch(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-wide/from16 v17, v7
    move-object v7, v4
    move-wide/from16 v4, v17
    move-object v8, v9
    move-object v9, v10
    iget-object v0, v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cache Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    iput-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    const/4 v10, 4
    iput v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-virtual v0, v8, v4, v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->access(Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v4, v7
    move-object v5, v8
    move-object v7, v9
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    const/4 v0, 5
    iput v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-direct v7, v5, v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->ready(Ljava/lang/String; Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    return-object v0
    invoke-interface v2, Lkotlin/coroutines/Continuation;->getContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v7, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v7, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v7, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    invoke-static v0, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v0
    iget-object v7, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v11, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$5 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$6 Ljava/lang/Object;
    const/4 v12, 6
    iput v12, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-interface v7, v6, v2, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v3, +003h
    return-object v3
    move-object/from16 v17, v7
    move-object v7, v0
    move-object v0, v4
    move-object/from16 v4, v17
    iget-object v12, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->inFlight Ljava/util/Map;
    invoke-interface v12, v8, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;
    const/4 v13, 0
    if-eqz v12, +014h
    invoke-virtual v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;->getWaiters()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    invoke-static v13, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v5
    invoke-static v12, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    goto +1bh
    new-instance v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;
    new-array v14, v5, [Lkotlinx/coroutines/CompletableDeferred;
    aput-object v7, v14, v13
    invoke-static v14, Lkotlin/collections/CollectionsKt;->mutableListOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v13
    invoke-direct v12, v13, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;-><init>(Ljava/util/List;)V
    iget-object v13, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->inFlight Ljava/util/Map;
    invoke-interface v13, v8, v12, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v5
    invoke-static v12, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    invoke-interface v4, v6, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    invoke-virtual v5, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;
    invoke-virtual v5, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Boolean;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    if-nez v5, +01bh
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$5 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$6 Ljava/lang/Object;
    const/4 v0, 7
    iput v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-interface v7, v2, Lkotlinx/coroutines/CompletableDeferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    return-object v0
    iput-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$5 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$6 Ljava/lang/Object;
    const/16 v5, 8
    iput v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-direct v10, v11, v9, v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->prepareUncached(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Ljava/lang/String; Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v5, v7
    move-object v7, v8
    move-object v8, v10
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource;
    move-object/from16 v17, v5
    move-object v5, v0
    move-object/from16 v0, v17
    goto +16h
    move-exception v0
    move-object v5, v7
    move-object v7, v8
    move-object v8, v10
    new-instance v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "artifact preparation failed"
    invoke-direct v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;-><init>(Ljava/lang/String;)V
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource;
    move-object v0, v5
    move-object v5, v9
    iget-object v9, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    iput-object v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    iput-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$5 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$6 Ljava/lang/Object;
    const/16 v10, 9
    iput v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-interface v9, v6, v2, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v3, +003h
    return-object v3
    iget-object v10, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->inFlight Ljava/util/Map;
    invoke-interface v10, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v4, +007h
    iget-object v10, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->inFlight Ljava/util/Map;
    invoke-interface v10, v7, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;->getWaiters()Ljava/util/List;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    invoke-static v10, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v10
    invoke-interface v9, v6, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$5 Ljava/lang/Object;
    const/16 v9, 10
    iput v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-direct v8, v5, v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->distribute(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource; Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v3, +003h
    return-object v3
    move-object v5, v0
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    const/16 v0, 11
    iput v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-interface v5, v2, Lkotlinx/coroutines/CompletableDeferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    return-object v0
    move-exception v0
    invoke-interface v9, v6, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    move-exception v0
    move-object v7, v8
    move-object v8, v10
    throw v0
    iget-object v0, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$0 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$1 Ljava/lang/Object;
    iput-object v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$2 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$3 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$4 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$5 Ljava/lang/Object;
    iput-object v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->L$6 Ljava/lang/Object;
    const/16 v9, 12
    iput v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareInRepositoryContext$1;->label I
    invoke-interface v0, v6, v2, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v3, +003h
    return-object v3
    move-object v3, v0
    move-object v2, v8
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->inFlight Ljava/util/Map;
    invoke-interface v0, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v5, +007h
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->inFlight Ljava/util/Map;
    invoke-interface v0, v7, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$InFlightPreparation;->getWaiters()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    invoke-interface v3, v6, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlinx/coroutines/CompletableDeferred;
    invoke-interface v2, v4, Lkotlinx/coroutines/CompletableDeferred;->cancel(Ljava/util/concurrent/CancellationException;)V
    goto -fh
    throw v4
    move-exception v0
    invoke-interface v3, v6, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    move-exception v0
    invoke-interface v4, v6, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    nop 
    packed-switch-payload 0 1 2 3 4 5 6 7 8 9 a b c
    :try_start_0x57
    :try_start_0x70
    :try_start_0x92
    :try_start_0xb6
    :try_start_0x233
    :try_start_0x298
    :try_start_0x2b4
    :try_start_0x2c0
    :try_start_0x2ec
    :try_start_0x303
    :try_start_0x358
.end method

.method private final prepareUncached(com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  java.lang.String  com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 26
    # ins_size=5
    move-object/from16 v1, v21
    move-object/from16 v0, v22
    move-object/from16 v2, v25
    instance-of v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;
    if-eqz v3, +012h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;
    iget v4, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    sub-int/2addr v2, v5
    iput v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    goto +6h
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;
    invoke-direct v3, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    const/4 v6, 1
    const/4 v7, 0
    packed-switch v5, +00004cfh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/Throwable;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +4bch
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    check-cast v0, Ljava/lang/Throwable;
    iget-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v6, Ljava/util/Set;
    iget-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +480h
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Cached;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +41fh
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Cached;
    iget-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v6, Ljava/util/Set;
    iget-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +3e9h
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    move-object v5, v0
    check-cast v5, Ljava/util/Set;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    move-object v8, v0
    check-cast v8, Ljava/lang/String;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    move-object v9, v0
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v9
    move-object/from16 v19, v6
    move-object v6, v5
    move-object/from16 v5, v19
    goto/16 +39fh
    iget-wide v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->J$0 J
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    iget-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    check-cast v8, Ljava/util/Set;
    iget-object v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v10, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-wide v12, v5
    move-object v5, v8
    move-object v6, v9
    move-object v2, v10
    move-object v15, v11
    goto/16 +34ah
    move-exception v0
    move-object v5, v7
    move-object v2, v8
    move-object v6, v9
    move-object v9, v10
    move-object v8, v11
    goto/16 +3efh
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    iget-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    check-cast v5, Ljava/util/Set;
    iget-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v9
    goto/16 +2ffh
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Temporary;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +2d1h
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Temporary;
    iget-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v6, Ljava/util/Set;
    iget-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +29ah
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +24eh
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;
    iget-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/util/Set;
    iget-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +224h
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    check-cast v5, Ljava/util/Set;
    iget-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v9
    move-object v9, v8
    move-object v8, v6
    move-object v6, v5
    move-object v5, v0
    goto/16 +1d3h
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    move-object v5, v0
    check-cast v5, Ljava/util/Set;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    move-object v8, v0
    check-cast v8, Ljava/lang/String;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    move-object v9, v0
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +196h
    move-exception v0
    move-object v2, v5
    move-object v5, v7
    move-object/from16 v19, v9
    move-object v9, v8
    move-object/from16 v8, v19
    goto/16 +35ch
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +15bh
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;
    iget-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/util/Set;
    iget-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +12fh
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$6 Ljava/lang/Object;
    move-object v5, v0
    check-cast v5, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadTask;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$5 Ljava/lang/Object;
    move-object v6, v0
    check-cast v6, Ljava/util/Set;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    iget-object v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v19, v9
    move-object v9, v5
    move-object v5, v6
    move-object v6, v8
    move-object/from16 v8, v19
    goto/16 +0c6h
    move-exception v0
    move-object v2, v6
    move-object v6, v8
    move-object v8, v9
    goto/16 +304h
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;
    iget-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    iget-object v10, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v10
    move-object v10, v9
    goto +61h
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    iget-object v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v19, v5
    move-object v5, v0
    move-object v0, v8
    move-object v8, v2
    move-object/from16 v2, v19
    goto +1ah
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    move-object/from16 v2, v23
    iput-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    move-object/from16 v5, v24
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-direct v1, v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->locate(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v4, +003h
    return-object v4
    move-object v9, v1
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;
    if-nez v8, +00ah
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;
    const-string v2, "artifact location failed"
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;-><init>(Ljava/lang/String;)V
    return-object v0
    iget-object v10, v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    const/4 v11, 2
    iput v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    const-string v11, "artifact-download"
    invoke-interface v10, v11, v3, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->createTemporaryFile(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v4, +003h
    return-object v4
    move-object v11, v9
    move-object/from16 v19, v10
    move-object v10, v0
    move-object v0, v8
    move-object v8, v2
    move-object/from16 v2, v19
    check-cast v2, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    new-array v6, v6, [Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    const/4 v9, 0
    aput-object v2, v6, v9
    invoke-static v6, Lkotlin/collections/SetsKt;->mutableSetOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v6
    iget-object v9, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->downloadClient Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;
    new-instance v12, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->getUrl()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->getHeaders()Ljava/util/Map;
    move-result-object v14
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$LocatedDownload;->getAuth()Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    move-result-object v0
    invoke-direct v12, v13, v14, v0, v2, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;-><init>(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth; Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)V
    invoke-interface v9, v12, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;->downloadToFile(Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;)Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadTask;
    move-result-object v9
    iput-object v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v10, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    iput-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$5 Ljava/lang/Object;
    iput-object v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$6 Ljava/lang/Object;
    const/4 v0, 3
    iput v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-interface v9, v3, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadTask;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object/from16 v19, v2
    move-object v2, v0
    move-object/from16 v0, v19
    move-object/from16 v20, v6
    move-object v6, v5
    move-object/from16 v5, v20
    check-cast v2, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->isSuccess()Z
    move-result v9
    if-nez v9, +05bh
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;->getErrorMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, "artifact download failed"
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;-><init>(Ljava/lang/String;)V
    invoke-static v7, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +027h
    sget-object v2, Lkotlinx/coroutines/NonCancellable;->INSTANCE Lkotlinx/coroutines/NonCancellable;
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$2;
    invoke-direct v6, v11, v8, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$2;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    iput-object v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$5 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$6 Ljava/lang/Object;
    const/4 v8, 4
    iput v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-static v2, v6, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    move-object v6, v11
    move-object v11, v6
    check-cast v5, Ljava/util/Collection;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$5 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$6 Ljava/lang/Object;
    const/4 v2, 5
    iput v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-direct v11, v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cleanupFiles(Ljava/util/Collection; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    return-object v0
    move-exception v0
    move-object v2, v5
    move-object v5, v7
    move-object v9, v8
    goto/16 -1fdh
    invoke-virtual v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->getSource()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    move-result-object v2
    sget-object v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->Local Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    if-ne v2, v9, +025h
    iput-object v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$5 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$6 Ljava/lang/Object;
    const/4 v2, 6
    iput v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-direct v11, v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->decodeLocalFile(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    move-object v9, v11
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    invoke-interface v5, v0, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-object v11, v9
    iget-object v2, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$5 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$6 Ljava/lang/Object;
    const/4 v9, 7
    iput v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-interface v2, v0, v3, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->metadata(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, -1d4h
    return-object v4
    check-cast v2, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    if-nez v2, +051h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;
    const-string v2, "downloaded artifact missing"
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Failed;-><init>(Ljava/lang/String;)V
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +026h
    sget-object v2, Lkotlinx/coroutines/NonCancellable;->INSTANCE Lkotlinx/coroutines/NonCancellable;
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$2;
    invoke-direct v5, v11, v9, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$2;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    iput-object v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    const/16 v8, 8
    iput v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-static v2, v5, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    move-object v5, v6
    move-object v6, v11
    move-object v11, v6
    move-object v6, v5
    check-cast v6, Ljava/util/Collection;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    const/16 v2, 9
    iput v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-direct v11, v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cleanupFiles(Ljava/util/Collection; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    return-object v0
    move-exception v0
    move-object v2, v6
    move-object v5, v7
    move-object v6, v8
    goto/16 -295h
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->getSize()J
    move-result-wide v12
    iget-wide v14, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->maxCacheBytes J
    cmp-long v0, v12, v14
    if-lez v0, +05ah
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Temporary;
    iget-object v2, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    invoke-interface v2, v5, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->localUri(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Temporary;-><init>(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Ljava/lang/String;)V
    invoke-static v5, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +024h
    sget-object v2, Lkotlinx/coroutines/NonCancellable;->INSTANCE Lkotlinx/coroutines/NonCancellable;
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$2;
    invoke-direct v8, v11, v9, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$2;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    iput-object v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    const/16 v9, 10
    iput v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-static v2, v8, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    move-object v8, v11
    move-object v11, v8
    if-eqz v5, +00ah
    invoke-static v6, v5, Lkotlin/collections/SetsKt;->minus(Ljava/util/Set; Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v6, v2
    check-cast v6, Ljava/util/Collection;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    const/16 v2, 11
    iput v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-direct v11, v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cleanupFiles(Ljava/util/Collection; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    return-object v0
    move-exception v0
    move-object v2, v6
    goto -64h
    move-object v0, v6
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    iget-object v0, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    const/16 v10, 12
    iput v10, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-interface v0, v5, v8, v3, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->atomicReplace(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object v0, v2
    move-object v5, v6
    move-object v6, v8
    move-object v8, v9
    iget-object v2, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->nowMillis Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->longValue()J
    move-result-wide v9
    iget-object v2, v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v11, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    iput-wide v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->J$0 J
    const/16 v12, 13
    iput v12, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-interface v2, v6, v9, v10, v3, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->touch(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    move-object v2, v8
    move-wide v12, v9
    goto/16 -349h
    new-instance v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->getSize()J
    move-result-wide v10
    const/4 v0, 0
    const/16 v16, 8
    const/16 v17, 0
    move-object v8, v14
    move-object v9, v2
    move-object/from16 v18, v14
    move v14, v0
    move-object v7, v15
    move/from16 v15, v16
    move-object/from16 v16, v17
    invoke-direct/range v8 ... v16, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;-><init>(Ljava/lang/String; J J Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v0, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cache Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    const/4 v8, 0
    iput-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    const/16 v8, 14
    iput v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    move-object/from16 v8, v18
    invoke-virtual v0, v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->commit(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object v8, v2
    goto/16 -3a2h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Cached;
    invoke-direct v0, v8, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$PreparedResource$Cached;-><init>(Ljava/lang/String; Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)V
    invoke-static v5, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +023h
    sget-object v2, Lkotlinx/coroutines/NonCancellable;->INSTANCE Lkotlinx/coroutines/NonCancellable;
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v9, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$2;
    const/4 v10, 0
    invoke-direct v9, v7, v8, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$2;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    iput-object v7, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    const/16 v8, 15
    iput v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-static v2, v9, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    move-object v8, v7
    move-object v7, v8
    if-eqz v5, +00ah
    invoke-static v6, v5, Lkotlin/collections/SetsKt;->minus(Ljava/util/Set; Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v6, v2
    check-cast v6, Ljava/util/Collection;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    const/4 v2, 0
    iput-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    const/16 v2, 16
    iput v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-direct v7, v6, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cleanupFiles(Ljava/util/Collection; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    return-object v0
    move-exception v0
    move-object v2, v6
    move-object v9, v8
    move-object v6, v5
    move-object v8, v7
    goto +26h
    move-exception v0
    goto +3h
    move-exception v0
    move-object v7, v15
    move-object v9, v2
    move-object v2, v5
    move-object v8, v7
    goto +1dh
    move-exception v0
    move-object v2, v5
    goto +12h
    move-exception v0
    move-object v2, v6
    move-object v6, v8
    goto +fh
    move-exception v0
    move-object v2, v5
    move-object v5, v9
    goto +5h
    move-exception v0
    move-object v2, v6
    move-object v6, v5
    goto -5h
    invoke-interface v5, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadTask;->cancel()V
    throw v0
    move-exception v0
    move-object v9, v8
    move-object v8, v11
    goto +6h
    move-exception v0
    move-object v2, v6
    move-object v9, v8
    move-object v8, v11
    move-object v6, v5
    const/4 v5, 0
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +029h
    sget-object v6, Lkotlinx/coroutines/NonCancellable;->INSTANCE Lkotlinx/coroutines/NonCancellable;
    check-cast v6, Lkotlin/coroutines/CoroutineContext;
    new-instance v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$2;
    const/4 v10, 0
    invoke-direct v7, v8, v9, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$2;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    iput-object v8, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v10, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    iput-object v10, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$5 Ljava/lang/Object;
    iput-object v10, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$6 Ljava/lang/Object;
    const/16 v9, 17
    iput v9, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-static v6, v7, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v4, +003h
    return-object v4
    move-object v6, v2
    move-object v2, v6
    if-eqz v5, +00ah
    invoke-static v2, v5, Lkotlin/collections/SetsKt;->minus(Ljava/util/Set; Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v5
    if-nez v5, +003h
    goto +2h
    move-object v2, v5
    check-cast v2, Ljava/util/Collection;
    iput-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$0 Ljava/lang/Object;
    const/4 v5, 0
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$1 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$2 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$3 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$4 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$5 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->L$6 Ljava/lang/Object;
    const/16 v5, 18
    iput v5, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepareUncached$1;->label I
    invoke-direct v8, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cleanupFiles(Ljava/util/Collection; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    throw v0
    packed-switch-payload 0 1 2 3 4 5 6 7 8 9 a b c d e f 10 11 12
    :try_start_0x84
    :try_start_0xa5
    :try_start_0xcb
    :try_start_0x11d
    :try_start_0x13b
    :try_start_0x182
    :try_start_0x219
    :try_start_0x230
    :try_start_0x252
    :try_start_0x254
    :try_start_0x25a
    :try_start_0x2b3
    :try_start_0x2bb
    :try_start_0x2d4
    :try_start_0x2de
    :try_start_0x2f8
    :try_start_0x2fc
    :try_start_0x34b
    :try_start_0x355
    :try_start_0x3ad
    :try_start_0x3ce
    :try_start_0x3f7
    :try_start_0x40c
    :try_start_0x42c
    :try_start_0x496
.end method

.method private final ready(java.lang.String  com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=4
    instance-of v0, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;
    invoke-direct v0, v4, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;->label I
    const/4 v3, 1
    if-eqz v2, +019h
    if-ne v2, v3, +00fh
    iget-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;->L$1 Ljava/lang/Object;
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ch
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v6, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cache Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;->L$0 Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$ready$1;->label I
    invoke-virtual v7, v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->acquire(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    move-object v5, v4
    check-cast v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;
    iget-object v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    invoke-interface v1, v6, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->localUri(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/lang/String;
    move-result-object v6
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$CacheLease;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cleanupScope Lkotlinx/coroutines/CoroutineScope;
    invoke-direct v1, v7, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$CacheLease;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease; Lkotlinx/coroutines/CoroutineScope;)V
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;
    invoke-direct v0, v6, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;-><init>(Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;)V
    return-object v0
.end method

.method private final restoreCache(kotlin.coroutines.Continuation)java.lang.Object
    .registers 23
    # ins_size=2
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    instance-of v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;
    iget v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->label I
    const/4 v5, 3
    const/4 v6, 2
    const/4 v7, 1
    const/4 v8, 0
    if-eqz v4, +031h
    if-eq v4, v7, +027h
    if-eq v4, v6, +011h
    if-ne v4, v5, +007h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a3h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$3 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$2 Ljava/lang/Object;
    check-cast v7, Ljava/util/Iterator;
    iget-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/util/Collection;
    iget-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4ah
    iget-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +12h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$0 Ljava/lang/Object;
    iput v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->label I
    invoke-interface v1, v2, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->list(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v4, v0
    check-cast v1, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    move-object v10, v4
    move-object v9, v7
    move-object v7, v1
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +043h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    iget-object v1, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->fileSystem Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    iput-object v10, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$0 Ljava/lang/Object;
    iput-object v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$1 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$2 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$3 Ljava/lang/Object;
    iput v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->label I
    invoke-interface v1, v4, v2, Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;->metadata(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    check-cast v1, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    if-nez v1, +004h
    move-object v1, v8
    goto +1ch
    new-instance v20, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    invoke-virtual v4, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->getSize()J
    move-result-wide v13
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->getModifiedAtMillis()J
    move-result-wide v15
    const/16 v17, 0
    const/16 v18, 8
    const/16 v19, 0
    move-object/from16 v11, v20
    invoke-direct/range v11 ... v19, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;-><init>(Ljava/lang/String; J J Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v1, v20
    if-eqz v1, -041h
    invoke-interface v9, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -46h
    check-cast v9, Ljava/util/List;
    iget-object v1, v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->cache Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$0 Ljava/lang/Object;
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$1 Ljava/lang/Object;
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$2 Ljava/lang/Object;
    iput-object v8, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->L$3 Ljava/lang/Object;
    iput v5, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$restoreCache$1;->label I
    invoke-virtual v1, v9, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;->startupCleanup(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final initialize(kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->repositoryDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initialize$2;
    const/4 v2, 0
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initialize$2;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)V
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

.method public final prepare(com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->repositoryDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepare$2;
    const/4 v2, 0
    invoke-direct v1, v3, v4, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$prepare$2;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v5, Lcom/bytedance/trae/kmp/repository/KmpRepositoryCoroutinesKt;->withRepositoryContext(Lkotlinx/coroutines/CoroutineDispatcher; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method
