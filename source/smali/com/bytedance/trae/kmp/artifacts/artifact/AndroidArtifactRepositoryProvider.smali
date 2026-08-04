# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;
.super Ljava/lang/Object;
.source "AndroidArtifactRepositoryProvider.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;
.field private static final processScope:Lkotlinx/coroutines/CoroutineScope;
.field private static final repository$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$rvGcsZgxkmjDXZqVEgaV-J3DH1M()com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;->repository_delegate$lambda$0()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;->processScope Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;->repository$delegate Lkotlin/Lazy;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final repository_delegate$lambda$0()com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository
    .registers 12
    # ins_size=0
    new-instance v11, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    sget-object v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->INSTANCE Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->get()Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    move-result-object v1
    sget-object v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->INSTANCE Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->binaryDownloadClient()Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->INSTANCE Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;->fileSystem()Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;->processScope Lkotlinx/coroutines/CoroutineScope;
    const-wide/16 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 112
    const/4 v10, 0
    move-object v0, v11
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient; Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem; Lkotlinx/coroutines/CoroutineScope; J Lkotlin/jvm/functions/Function0; Lkotlinx/coroutines/CoroutineDispatcher; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v11
.end method

.method public final getRepository()com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/AndroidArtifactRepositoryProvider;->repository$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    return-object v0
.end method
