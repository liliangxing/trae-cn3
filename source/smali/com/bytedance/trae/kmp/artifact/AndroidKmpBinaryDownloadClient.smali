# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;
.super Ljava/lang/Object;
.source "AndroidKmpArtifactIo.kt"

.implements Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;

.field public static final $stable:I
.field private final context:Landroid/content/Context;
.field private final fileSystem:Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(android.content.Context  com.bytedance.trae.kmp.artifact.AndroidKmpArtifactFileSystem)void
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "fileSystem"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;->context Landroid/content/Context;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;->fileSystem Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;
    return-void 
.end method

.method public static final synthetic access$getContext$p(com.bytedance.trae.kmp.artifact.AndroidKmpBinaryDownloadClient)android.content.Context
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;->context Landroid/content/Context;
    return-object v0
.end method

.method private final rewriteAbsoluteUrlForMock(java.lang.String)java.lang.String
    .registers 12
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideBaseUrlOrNull()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    return-object v11
    new-instance v1, Ljava/net/URI;
    invoke-direct v1, v11, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    new-instance v11, Ljava/net/URI;
    invoke-direct v11, v0, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    new-instance v0, Ljava/net/URI;
    invoke-virtual v11, Ljava/net/URI;->getScheme()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    invoke-virtual v11, Ljava/net/URI;->getHost()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v11, Ljava/net/URI;->getPort()I
    move-result v6
    invoke-virtual v1, Ljava/net/URI;->getRawPath()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v1, Ljava/net/URI;->getRawQuery()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v1, Ljava/net/URI;->getRawFragment()Ljava/lang/String;
    move-result-object v9
    move-object v2, v0
    invoke-direct/range v2 ... v9, Ljava/net/URI;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/net/URI;->toString()Ljava/lang/String;
    move-result-object v11
    const-string/jumbo v0, toString(...)
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v11
.end method

.method public downloadToFile(com.bytedance.trae.kmp.artifact.KmpBinaryDownloadRequest)com.bytedance.trae.kmp.artifact.KmpBinaryDownloadTask
    .registers 12
    # ins_size=2
    const-string/jumbo v0, request
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v10, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;->fileSystem Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;
    invoke-virtual v11, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;->getTarget()Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactIoKt;->resolveForDownload(Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem; Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/io/File;
    move-result-object v0
    invoke-virtual v0, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, Ljava/io/File;->mkdirs()Z
    invoke-virtual v11, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;->getUrl()Ljava/lang/String;
    move-result-object v1
    invoke-direct v10, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;->rewriteAbsoluteUrlForMock(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 1
    invoke-static v2, v3, v2, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;
    invoke-direct v5, v4, v11, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;-><init>(Lkotlinx/coroutines/CompletableDeferred; Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest; Ljava/io/File;)V
    invoke-virtual v11, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;->getHeaders()Ljava/util/Map;
    move-result-object v6
    invoke-static v6, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v6
    invoke-virtual v11, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;->getAuth()Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    move-result-object v11
    sget-object v7, Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;->CloudIdeJwt Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;
    if-ne v11, v7, +058h
    invoke-interface v6, Ljava/util/Map;->keySet()Ljava/util/Set;
    move-result-object v11
    check-cast v11, Ljava/lang/Iterable;
    instance-of v7, v11, Ljava/util/Collection;
    const-string v8, "Authorization"
    if-eqz v7, +00dh
    move-object v7, v11
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +004h
    move v11, v3
    goto +18h
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, -00ah
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    invoke-static v7, v8, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v7
    if-eqz v7, -010h
    const/4 v11, 0
    if-eqz v11, +028h
    sget-object v11, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getToken()Ljava/lang/String;
    move-result-object v11
    move-object v7, v11
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    xor-int/2addr v7, v3
    if-eqz v7, +003h
    goto +2h
    move-object v11, v2
    if-eqz v11, +014h
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v9, "Cloud-IDE-JWT "
    invoke-direct v7, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-interface v6, v8, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v11, v10, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;->context Landroid/content/Context;
    invoke-static v11, Lcom/ss/android/socialbase/downloader/downloader/Downloader;->with(Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v11
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v7
    invoke-virtual v7, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v11, v7, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->taskKey(Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v11
    const/4 v7, 3
    invoke-virtual v11, v7, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->retryCount(I)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v11
    invoke-virtual v11, v3, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->autoSetHashCodeForSameTask(Z)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v11
    invoke-virtual v11, v1, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->url(Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v11
    invoke-virtual v0, Ljava/io/File;->getParent()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +00ch
    iget-object v1, v10, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;->context Landroid/content/Context;
    invoke-virtual v1, Landroid/content/Context;->getCacheDir()Ljava/io/File;
    move-result-object v1
    invoke-virtual v1, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v11, v1, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->savePath(Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v11
    invoke-virtual v0, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v11, v1, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->name(Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v11
    new-instance v1, Ljava/util/ArrayList;
    invoke-interface v6, Ljava/util/Map;->size()I
    move-result v3
    invoke-direct v1, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v3
    invoke-interface v3, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01dh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/util/Map$Entry;
    new-instance v7, Lcom/ss/android/socialbase/downloader/model/HttpHeader;
    invoke-interface v6, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    invoke-interface v6, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    invoke-direct v7, v8, v6, Lcom/ss/android/socialbase/downloader/model/HttpHeader;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -20h
    check-cast v1, Ljava/util/List;
    invoke-virtual v11, v1, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->extraHeaders(Ljava/util/List;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v11
    check-cast v5, Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;
    invoke-virtual v11, v5, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->subThreadListener(Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;)Lcom/ss/android/socialbase/downloader/model/DownloadTask;
    move-result-object v11
    invoke-virtual v11, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->getDownloadId()I
    move-result v1
    invoke-virtual v11, v2, Lcom/ss/android/socialbase/downloader/model/DownloadTask;->asyncDownload(Lcom/ss/android/socialbase/downloader/downloader/IDownloadStartCallback;)V
    new-instance v11, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;
    invoke-direct v11, v4, v10, v1, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;-><init>(Lkotlinx/coroutines/CompletableDeferred; Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient; I Ljava/io/File;)V
    check-cast v11, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadTask;
    return-object v11
.end method
