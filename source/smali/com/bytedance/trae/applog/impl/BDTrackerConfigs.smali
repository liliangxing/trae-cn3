# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;
.super Ljava/lang/Object;
.source "BDTrackerConfigs.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->INSTANCE Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getUriConfig(boolean)com.bytedance.applog.UriConfig
    .registers 3
    # ins_size=2
    const/4 v2, 0
    invoke-static v2, Lcom/bytedance/applog/UriConfig;->createUriConfig(I)Lcom/bytedance/applog/UriConfig;
    move-result-object v2
    const-string v0, "createUriConfig(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public final configSensitiveApi(com.bytedance.applog.InitConfig)void
    .registers 3
    # ins_size=2
    const-string v0, "config"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public final uriConfig(boolean)com.bytedance.applog.UriConfig
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->getUriConfig(Z)Lcom/bytedance/applog/UriConfig;
    move-result-object v1
    return-object v1
.end method
