# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/image/fresco/FrescoExt;
.super Ljava/lang/Object;
.source "FrescoExt.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/image/fresco/FrescoExt;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$jXIO4i82Y0jEVQwrlq7pU2ZjPoo(com.facebook.imagepipeline.request.ImageRequest  java.lang.Object  java.lang.String  org.json.JSONObject  boolean  boolean)android.util.Pair
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/image/fresco/FrescoExt;->reportImageEvent$lambda$2(Lcom/facebook/imagepipeline/request/ImageRequest; Ljava/lang/Object; Ljava/lang/String; Lorg/json/JSONObject; Z Z)Landroid/util/Pair;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/image/fresco/FrescoExt;
    invoke-direct v0, Lcom/bytedance/trae/image/fresco/FrescoExt;-><init>()V
    sput-object v0, Lcom/bytedance/trae/image/fresco/FrescoExt;->INSTANCE Lcom/bytedance/trae/image/fresco/FrescoExt;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final configImageResize()void
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/image/fresco/FrescoExt$configImageResize$1;
    invoke-direct v0, Lcom/bytedance/trae/image/fresco/FrescoExt$configImageResize$1;-><init>()V
    check-cast v0, Lcom/facebook/imagepipeline/producers/ImageResizeOptionStrategy;
    invoke-static v0, Lcom/facebook/imagepipeline/producers/ImageResizeOptionStrategy;->setStrategy(Lcom/facebook/imagepipeline/producers/ImageResizeOptionStrategy;)V
    return-void 
.end method

.method private final configIndependentCache(java.util.HashMap  java.lang.String  android.content.Context  kotlin.Triple)com.facebook.cache.disk.DiskCacheConfig
    .registers 9
    # ins_size=5
    invoke-static v7, Lcom/facebook/cache/disk/DiskCacheConfig;->newBuilder(Landroid/content/Context;)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v0
    invoke-virtual v7, Landroid/content/Context;->getCacheDir()Ljava/io/File;
    move-result-object v7
    invoke-virtual v0, v7, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->setBaseDirectoryPath(Ljava/io/File;)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v7
    invoke-virtual v7, v6, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->setBaseDirectoryName(Ljava/lang/String;)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v7
    invoke-virtual v8, Lkotlin/Triple;->getFirst()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    mul-int/lit16 v0, v0, 1024
    int-to-long v0, v0
    invoke-virtual v7, v0, v1, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->setMaxCacheSize(J)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v7
    invoke-virtual v8, Lkotlin/Triple;->getSecond()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    const-wide/16 v2, 1024
    mul-long/2addr v0, v2
    invoke-virtual v7, v0, v1, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->setMaxCacheSizeOnLowDiskSpace(J)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v7
    invoke-virtual v8, Lkotlin/Triple;->getThird()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/Number;
    invoke-virtual v8, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    mul-long/2addr v0, v2
    invoke-virtual v7, v0, v1, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->setMaxCacheSizeOnVeryLowDiskSpace(J)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v7
    invoke-virtual v7, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->build()Lcom/facebook/cache/disk/DiskCacheConfig;
    move-result-object v7
    check-cast v5, Ljava/util/Map;
    invoke-interface v5, v6, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v7
.end method

.method private final configMainDiskCache(android.content.Context  com.facebook.imagepipeline.core.ImagePipelineConfig$Builder)void
    .registers 6
    # ins_size=3
    invoke-static v4, Lcom/facebook/cache/disk/DiskCacheConfig;->newBuilder(Landroid/content/Context;)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v0
    invoke-virtual v4, Landroid/content/Context;->getCacheDir()Ljava/io/File;
    move-result-object v4
    invoke-virtual v0, v4, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->setBaseDirectoryPath(Ljava/io/File;)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v4
    const-wide/32 v0, 41943040
    invoke-virtual v4, v0, v1, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->setMaxCacheSize(J)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v0
    const-wide/32 v1, 10485760
    invoke-virtual v0, v1, v2, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->setMaxCacheSizeOnLowDiskSpace(J)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v0
    const-wide/32 v1, 2097152
    invoke-virtual v0, v1, v2, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->setMaxCacheSizeOnVeryLowDiskSpace(J)Lcom/facebook/cache/disk/DiskCacheConfig$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->build()Lcom/facebook/cache/disk/DiskCacheConfig;
    invoke-virtual v4, Lcom/facebook/cache/disk/DiskCacheConfig$Builder;->build()Lcom/facebook/cache/disk/DiskCacheConfig;
    move-result-object v4
    invoke-virtual v5, v4, Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;->setMainDiskCacheConfig(Lcom/facebook/cache/disk/DiskCacheConfig;)Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;
    return-void 
.end method

.method private final openImageRetrySwitch()void
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    const/16 v1, 3000
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    const/16 v1, 5000
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    const/16 v2, 15000
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    invoke-virtual v2, v1, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    const/16 v1, 10000
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v2, v1, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    const/16 v1, 20000
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v2, v1, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    invoke-static Lcom/facebook/net/RetryInterceptManager;->inst()Lcom/facebook/net/RetryInterceptManager;
    move-result-object v1
    invoke-virtual v1, v0, v2, Lcom/facebook/net/RetryInterceptManager;->open(Ljava/util/ArrayList; Ljava/util/ArrayList;)V
    invoke-static Lcom/facebook/net/RetryInterceptManager;->inst()Lcom/facebook/net/RetryInterceptManager;
    move-result-object v0
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/facebook/net/RetryInterceptManager;->setContentTypeOpen(Z)V
    invoke-static Lcom/facebook/net/RetryInterceptManager;->inst()Lcom/facebook/net/RetryInterceptManager;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/facebook/net/RetryInterceptManager;->setContentLengthOpen(Z)V
    return-void 
.end method

.method private final preCreateImagePipeline()void
    .registers 3
    # ins_size=1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/image/fresco/FrescoExt;
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->getImagePipeline()Lcom/facebook/imagepipeline/core/ImagePipeline;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    const/4 v0, 0
    check-cast v0, Lcom/facebook/imagepipeline/core/ImagePipeline;
    return-void 
    :try_start_0x0
.end method

.method private final reportImageEvent()void
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/image/fresco/FrescoExt$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/image/fresco/FrescoExt$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lcom/optimize/statistics/FrescoMonitor;->addMonitorHookV2(Lcom/optimize/statistics/IMonitorHookV2;)V
    return-void 
.end method

.method private static final reportImageEvent$lambda$2(com.facebook.imagepipeline.request.ImageRequest  java.lang.Object  java.lang.String  org.json.JSONObject  boolean  boolean)android.util.Pair
    .registers 6
    # ins_size=6
    if-eqz v3, +037h
    new-instance v1, Ljava/util/HashMap;
    invoke-direct v1, Ljava/util/HashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    if-eqz v0, +013h
    invoke-virtual v0, Lcom/facebook/imagepipeline/request/ImageRequest;->getSourceUri()Landroid/net/Uri;
    move-result-object v0
    if-eqz v0, +00dh
    const-string v2, "biz_tag"
    invoke-virtual v0, v2, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v1, v2, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/apm/api/IExtraParams;->Companion Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->getAppVariant()Ljava/lang/String;
    move-result-object v0
    const-string v2, "flow_app_variant"
    invoke-interface v1, v2, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v0, "is_request_network"
    invoke-virtual v3, v0, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z
    move-result v0
    new-instance v2, Landroid/util/Pair;
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-direct v2, v0, v1, Landroid/util/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v2
    const/4 v0, 0
    return-object v0
.end method

.method public final init(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/HashSet;
    invoke-direct v0, Ljava/util/HashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    new-instance v1, Lcom/optimize/statistics/FrescoTraceListener;
    invoke-direct v1, Lcom/optimize/statistics/FrescoTraceListener;-><init>()V
    invoke-interface v0, v1, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    new-instance v1, Lcom/facebook/imagepipeline/listener/RequestLoggingListener;
    invoke-direct v1, Lcom/facebook/imagepipeline/listener/RequestLoggingListener;-><init>()V
    invoke-interface v0, v1, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    sget-object v1, Lcom/facebook/imagepipeline/common/ImageDecodeBitmapConfigStrategy;->MEMORY_AT_LEAST Lcom/facebook/imagepipeline/common/ImageDecodeBitmapConfigStrategy;
    invoke-static v1, Lcom/facebook/imagepipeline/common/ImageDecodeBitmapConfigStrategy;->setStrategy(Lcom/facebook/imagepipeline/common/ImageDecodeBitmapConfigStrategy;)V
    const/4 v1, 1
    invoke-static v1, Lcom/optimize/statistics/FrescoMonitor;->setExceedTheLimitBitmapMonitorEnabled(Z)V
    invoke-static v1, Lcom/optimize/statistics/FrescoMonitor;->setReportHitCacheEnabled(Z)V
    invoke-static Lcom/facebook/drawee/backends/pipeline/DraweeConfig;->newBuilder()Lcom/facebook/drawee/backends/pipeline/DraweeConfig$Builder;
    move-result-object v2
    new-instance v3, Lcom/optimize/statistics/FrescoControllerListener;
    invoke-direct v3, Lcom/optimize/statistics/FrescoControllerListener;-><init>()V
    check-cast v3, Lcom/facebook/drawee/controller/ControllerListener;
    invoke-virtual v2, v3, Lcom/facebook/drawee/backends/pipeline/DraweeConfig$Builder;->addGlobalControllerListener(Lcom/facebook/drawee/controller/ControllerListener;)Lcom/facebook/drawee/backends/pipeline/DraweeConfig$Builder;
    move-result-object v2
    new-instance v3, Lcom/facebook/imagepipeline/memory/PoolFactory;
    invoke-static Lcom/facebook/imagepipeline/memory/PoolConfig;->newBuilder()Lcom/facebook/imagepipeline/memory/PoolConfig$Builder;
    move-result-object v4
    invoke-virtual v4, Lcom/facebook/imagepipeline/memory/PoolConfig$Builder;->build()Lcom/facebook/imagepipeline/memory/PoolConfig;
    move-result-object v4
    invoke-direct v3, v4, Lcom/facebook/imagepipeline/memory/PoolFactory;-><init>(Lcom/facebook/imagepipeline/memory/PoolConfig;)V
    new-instance v4, Lcom/facebook/net/FrescoTTNetFetcher;
    invoke-direct v4, v1, Lcom/facebook/net/FrescoTTNetFetcher;-><init>(Z)V
    sget-object v5, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v5
    check-cast v5, Landroid/content/Context;
    invoke-static v5, Lcom/facebook/imagepipeline/core/ImagePipelineConfig;->newBuilder(Landroid/content/Context;)Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;
    move-result-object v5
    invoke-virtual v5, v1, Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;->setDownsampleEnabled(Z)Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;
    move-result-object v5
    invoke-virtual v5, v3, Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;->setPoolFactory(Lcom/facebook/imagepipeline/memory/PoolFactory;)Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;
    move-result-object v5
    check-cast v4, Lcom/facebook/imagepipeline/producers/NetworkFetcher;
    invoke-virtual v5, v4, Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;->setNetworkFetcher(Lcom/facebook/imagepipeline/producers/NetworkFetcher;)Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;
    move-result-object v4
    invoke-virtual v4, v0, Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;->setRequestListeners(Ljava/util/Set;)Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;->setDiskCacheEnabled(Z)Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/image/fresco/FrescoExt;->configMainDiskCache(Landroid/content/Context; Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;)V
    invoke-static Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;->newBuilder()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig$Builder;
    move-result-object v8
    sget-object v4, Lcom/bytedance/fresco/heif/HeifDecoder;->HEIF_FORMAT Lcom/facebook/imageformat/ImageFormat;
    new-instance v5, Lcom/bytedance/fresco/heif/HeifDecoder$HeifFormatChecker;
    invoke-direct v5, Lcom/bytedance/fresco/heif/HeifDecoder$HeifFormatChecker;-><init>()V
    check-cast v5, Lcom/facebook/imageformat/ImageFormat$FormatChecker;
    new-instance v6, Lcom/bytedance/fresco/heif/HeifDecoder$HeifFormatDecoder;
    invoke-virtual v3, Lcom/facebook/imagepipeline/memory/PoolFactory;->getPooledByteBufferFactory()Lcom/facebook/common/memory/PooledByteBufferFactory;
    move-result-object v3
    invoke-direct v6, v3, Lcom/bytedance/fresco/heif/HeifDecoder$HeifFormatDecoder;-><init>(Lcom/facebook/common/memory/PooledByteBufferFactory;)V
    check-cast v6, Lcom/facebook/imagepipeline/decoder/ImageDecoder;
    invoke-virtual v8, v4, v5, v6, Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig$Builder;->addDecodingCapability(Lcom/facebook/imageformat/ImageFormat; Lcom/facebook/imageformat/ImageFormat$FormatChecker; Lcom/facebook/imagepipeline/decoder/ImageDecoder;)Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig$Builder;
    move-result-object v8
    sget-object v3, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->INSTANCE Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;
    invoke-virtual v3, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->getSVG_FORMAT()Lcom/facebook/imageformat/ImageFormat;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgFormatChecker;
    invoke-direct v4, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgFormatChecker;-><init>()V
    check-cast v4, Lcom/facebook/imageformat/ImageFormat$FormatChecker;
    new-instance v5, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDecoder;
    invoke-direct v5, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDecoder;-><init>()V
    check-cast v5, Lcom/facebook/imagepipeline/decoder/ImageDecoder;
    invoke-virtual v8, v3, v4, v5, Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig$Builder;->addDecodingCapability(Lcom/facebook/imageformat/ImageFormat; Lcom/facebook/imageformat/ImageFormat$FormatChecker; Lcom/facebook/imagepipeline/decoder/ImageDecoder;)Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig$Builder;
    move-result-object v8
    invoke-virtual v8, Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig$Builder;->build()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;
    move-result-object v8
    invoke-virtual v0, v8, Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;->setImageDecoderConfig(Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;)Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;
    new-instance v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;
    invoke-direct v8, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;-><init>()V
    check-cast v8, Lcom/facebook/imagepipeline/drawable/DrawableFactory;
    invoke-virtual v2, v8, Lcom/facebook/drawee/backends/pipeline/DraweeConfig$Builder;->addCustomDrawableFactory(Lcom/facebook/imagepipeline/drawable/DrawableFactory;)Lcom/facebook/drawee/backends/pipeline/DraweeConfig$Builder;
    sget-object v8, Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;->INSTANCE Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;
    check-cast v8, Lcom/facebook/imagepipeline/cache/CacheKeyFactory;
    invoke-virtual v0, v8, Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;->setCacheKeyFactory(Lcom/facebook/imagepipeline/cache/CacheKeyFactory;)Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;
    invoke-static Lcom/facebook/imagepipeline/cache/DefaultCacheKeyFactory;->getInstance()Lcom/facebook/imagepipeline/cache/DefaultCacheKeyFactory;
    move-result-object v8
    invoke-virtual v8, v1, Lcom/facebook/imagepipeline/cache/DefaultCacheKeyFactory;->setCacheKeyOnlyPath(Z)V
    invoke-virtual v0, Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;->experiment()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;
    move-result-object v8
    invoke-virtual v8, v1, Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;->setOomOptEnabled(Z)Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;
    invoke-direct v7, Lcom/bytedance/trae/image/fresco/FrescoExt;->configImageResize()V
    invoke-direct v7, Lcom/bytedance/trae/image/fresco/FrescoExt;->openImageRetrySwitch()V
    invoke-direct v7, Lcom/bytedance/trae/image/fresco/FrescoExt;->reportImageEvent()V
    const/4 v8, 0
    invoke-static v8, Lcom/facebook/drawee/backends/pipeline/Fresco;->setCanReInitialize(Z)V
    sget-object v8, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v8
    check-cast v8, Landroid/content/Context;
    invoke-virtual v0, Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;->build()Lcom/facebook/imagepipeline/core/ImagePipelineConfig;
    move-result-object v0
    invoke-virtual v2, Lcom/facebook/drawee/backends/pipeline/DraweeConfig$Builder;->build()Lcom/facebook/drawee/backends/pipeline/DraweeConfig;
    move-result-object v2
    invoke-static v8, v0, v2, Lcom/facebook/drawee/backends/pipeline/Fresco;->initialize(Landroid/content/Context; Lcom/facebook/imagepipeline/core/ImagePipelineConfig; Lcom/facebook/drawee/backends/pipeline/DraweeConfig;)V
    invoke-static v1, Lcom/facebook/drawee/view/SimpleDraweeView;->enableLazySize(Z)V
    invoke-direct v7, Lcom/bytedance/trae/image/fresco/FrescoExt;->preCreateImagePipeline()V
    return-void 
.end method
