# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;
.super Ljava/lang/Object;
.source "ReparoHotPatchImpl.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;
.field private static final KEY_HOTFIX_REALTIME_FETCH:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final VALUE_FALSE:Ljava/lang/String;
.field private static final VALUE_TRUE:Ljava/lang/String;
.field private static final hotPatchConfig:Lcom/bytedance/trae/hotfix/HotPatchConfig;
.field private static settingListenerRegistered:Z


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;
    invoke-direct v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;-><init>()V
    sput-object v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->INSTANCE Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;
    const-string v0, "ReparoHotPatch"
    sput-object v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->TAG Ljava/lang/String;
    const-string v0, "hotfix_realtime_fetch"
    sput-object v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->KEY_HOTFIX_REALTIME_FETCH Ljava/lang/String;
    const-string v0, "1"
    sput-object v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->VALUE_TRUE Ljava/lang/String;
    const-string v0, "0"
    sput-object v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->VALUE_FALSE Ljava/lang/String;
    new-instance v0, Lcom/bytedance/trae/hotfix/HotPatchConfig;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/hotfix/HotPatchConfig;-><init>(Landroid/app/Application;)V
    sput-object v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->hotPatchConfig Lcom/bytedance/trae/hotfix/HotPatchConfig;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final init()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->hotPatchConfig Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-virtual v1, v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->init(Lcom/bytedance/trae/hotfix/HotPatchConfig;)V
    return-void 
.end method

.method public final init(com.bytedance.trae.hotfix.HotPatchConfig)void
    .registers 4
    # ins_size=2
    const-string v0, "config"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/mira/plugin/hook/flipped/Flipped;->invokeHiddenApiRestrictions()V
    invoke-static Lcom/bytedance/reparo/Reparo;->getInstance()Lcom/bytedance/reparo/Reparo;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;
    invoke-direct v1, v3, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;-><init>(Lcom/bytedance/trae/hotfix/HotPatchConfig;)V
    check-cast v1, Lcom/bytedance/reparo/IReparoConfig;
    invoke-virtual v0, v1, Lcom/bytedance/reparo/Reparo;->init(Lcom/bytedance/reparo/IReparoConfig;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->TAG Ljava/lang/String;
    const-string v1, "REPARO HOTFIX INITED!"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final loadRemotePatch()void
    .registers 5
    # ins_size=1
    invoke-static Lcom/bytedance/reparo/Reparo;->getInstance()Lcom/bytedance/reparo/Reparo;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->hotPatchConfig Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-virtual v1, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getRequestInterval()J
    move-result-wide v2
    invoke-virtual v0, v2, v3, Lcom/bytedance/reparo/Reparo;->setRequestInterval(J)V
    invoke-static Lcom/bytedance/reparo/Reparo;->getInstance()Lcom/bytedance/reparo/Reparo;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/reparo/Reparo;->loadRemotePatch()V
    invoke-virtual v1, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getApplication()Landroid/app/Application;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$loadRemotePatch$1;
    invoke-direct v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$loadRemotePatch$1;-><init>()V
    check-cast v1, Landroid/app/Application$ActivityLifecycleCallbacks;
    invoke-virtual v0, v1, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->TAG Ljava/lang/String;
    const-string v2, "REPARO HOTFIX trigger loadRemotePatch!"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
