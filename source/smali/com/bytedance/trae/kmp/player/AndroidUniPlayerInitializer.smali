# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;
.super Ljava/lang/Object;
.source "AndroidUniPlayerInitializer.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;
.field private static bridge initialized:Z


.method public static synthetic $r8$lambda$TaoxWqUr8Ve6Uyi7ap7Co2v9osE(android.content.Context)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;->initialize$lambda$1$lambda$0(Landroid/content/Context;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;
    invoke-direct v0, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;->INSTANCE Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final initialize$lambda$1$lambda$0(android.content.Context)kotlin.Unit
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/vcloud/uniplayer/UniKitService;->INSTANCE Lcom/bytedance/vcloud/uniplayer/UniKitService;
    const/4 v1, 0
    const/4 v2, 2
    invoke-static v0, v3, v1, v2, v1, Lcom/bytedance/vcloud/uniplayer/UniKitService_androidKt;->initOnce$default(Lcom/bytedance/vcloud/uniplayer/UniKitService; Landroid/content/Context; Lcom/bytedance/vcloud/uniplayer/UniAbConfig; I Ljava/lang/Object;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method public final initialize(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;->initialized Z
    if-eqz v0, +003h
    return-void 
    monitor-enter v1
    sget-boolean v0, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;->initialized Z
    if-eqz v0, +004h
    monitor-exit v1
    return-void 
    invoke-virtual v2, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    invoke-static v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactIoKt;->configureAndroidKmpArtifactIo(Landroid/content/Context;)V
    new-instance v0, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer$$ExternalSyntheticLambda0;-><init>(Landroid/content/Context;)V
    invoke-static v0, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializerKt;->initializeUniPlayer(Lkotlin/jvm/functions/Function0;)V
    const/4 v2, 1
    sput-boolean v2, Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;->initialized Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v1
    return-void 
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0xb
    :try_start_0x11
.end method
