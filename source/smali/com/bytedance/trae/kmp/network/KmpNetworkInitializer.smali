# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;
.super Ljava/lang/Object;
.source "KmpNetworkInitializer.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;
.field private static bridge registered:Z


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;
    invoke-direct v0, Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;->INSTANCE Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final ensureRegistered()void
    .registers 4
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;->registered Z
    if-eqz v0, +003h
    return-void 
    monitor-enter v3
    sget-boolean v0, Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;->registered Z
    if-eqz v0, +004h
    monitor-exit v3
    return-void 
    sget-object v0, Lcom/bytedance/kmp/spi/KmpServiceManager;->INSTANCE Lcom/bytedance/kmp/spi/KmpServiceManager;
    const-class v1, Lcom/bytedance/kmp/network/IKmpNetworkService;
    invoke-static v1, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;
    invoke-direct v2, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;-><init>()V
    check-cast v2, Lcom/bytedance/kmp/spi/IKmpService;
    invoke-virtual v0, v1, v2, Lcom/bytedance/kmp/spi/KmpServiceManager;->put(Lkotlin/reflect/KClass; Lcom/bytedance/kmp/spi/IKmpService;)V
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;->registered Z
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v3
    return-void 
    move-exception v0
    monitor-exit v3
    throw v0
    :try_start_0x6
    :try_start_0xc
.end method
