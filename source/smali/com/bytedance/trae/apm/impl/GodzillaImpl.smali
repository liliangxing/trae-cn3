# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/GodzillaImpl;
.super Ljava/lang/Object;
.source "GodzillaImpl.kt"

.implements Lcom/bytedance/trae/apm/api/IGodzilla;

.field public static final Companion:Lcom/bytedance/trae/apm/impl/GodzillaImpl$Companion;
.field private static final DEFAULT_MEMORY:I
.field private static final TAG:Ljava/lang/String;
.field private static sMaxMemory:J
.field private enableGodzillaInTestChannel:Z
.field private startGzlRunnable:Ljava/lang/Runnable;


.method public static synthetic $r8$lambda$MZq_xgzrR7JU84iNT_6neG22Qwo(com.bytedance.trae.apm.impl.GodzillaImpl)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->init$lambda$1(Lcom/bytedance/trae/apm/impl/GodzillaImpl;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ZY1qPGDmaT6DVDhkQeq98ruYXgU(java.lang.String  java.lang.String  com.bytedance.platform.godzilla.common.Logger$Level)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->init$lambda$0(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/platform/godzilla/common/Logger$Level;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/GodzillaImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->Companion Lcom/bytedance/trae/apm/impl/GodzillaImpl$Companion;
    const-wide/16 v0, -1
    sput-wide v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->sMaxMemory J
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getSMaxMemory$cp()long
    .registers 2
    # ins_size=0
    sget-wide v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->sMaxMemory J
    return-wide v0
.end method

.method public static final synthetic access$setSMaxMemory$cp(long)void
    .registers 2
    # ins_size=2
    sput-wide v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->sMaxMemory J
    return-void 
.end method

.method private static final init$lambda$0(java.lang.String  java.lang.String  com.bytedance.platform.godzilla.common.Logger$Level)void
    .registers 4
    # ins_size=3
    if-nez v3, +004h
    const/4 v3, -1
    goto +9h
    sget-object v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/platform/godzilla/common/Logger$Level;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 1
    if-eq v3, v0, +02fh
    const/4 v0, 2
    if-eq v3, v0, +023h
    const/4 v0, 3
    if-eq v3, v0, +017h
    const/4 v0, 4
    if-eq v3, v0, +00bh
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +24h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    goto +1bh
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +12h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +9h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private static final init$lambda$1(com.bytedance.trae.apm.impl.GodzillaImpl)void
    .registers 3
    # ins_size=1
    invoke-static Lcom/bytedance/crash/Npth;->isInit()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-static Lcom/bytedance/platform/godzilla/Godzilla;->with()Lcom/bytedance/platform/godzilla/Godzilla;
    move-result-object v2
    sget-object v0, Lcom/bytedance/platform/godzilla/plugin/StartType;->REGISTER_EXCEPTION Lcom/bytedance/platform/godzilla/plugin/StartType;
    invoke-virtual v2, v0, Lcom/bytedance/platform/godzilla/Godzilla;->start(Lcom/bytedance/platform/godzilla/plugin/StartType;)V
    goto +11h
    iget-object v2, v2, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->startGzlRunnable Ljava/lang/Runnable;
    if-nez v2, +009h
    const-string/jumbo v2, startGzlRunnable
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    const-wide/16 v0, 500
    invoke-static v2, v0, v1, Lcom/bytedance/trae/utils/ThreadUtils;->postInForeground(Ljava/lang/Runnable; J)V
    return-void 
.end method

.method public enableGodzillaInTestChannel(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->enableGodzillaInTestChannel Z
    return-void 
.end method

.method public init()void
    .registers 5
    # ins_size=1
    new-instance v0, Lcom/bytedance/platform/godzilla/Godzilla$Builder;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/platform/godzilla/Godzilla$Builder;-><init>(Landroid/app/Application;)V
    new-instance v1, Lcom/bytedance/trae/apm/impl/GodzillaImpl$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/apm/impl/GodzillaImpl$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v0, v1, Lcom/bytedance/platform/godzilla/Godzilla$Builder;->setLog(Lcom/bytedance/platform/godzilla/common/ILog;)Lcom/bytedance/platform/godzilla/Godzilla$Builder;
    new-instance v1, Lcom/bytedance/trae/apm/impl/GodzillaImpl$init$2;
    invoke-direct v1, Lcom/bytedance/trae/apm/impl/GodzillaImpl$init$2;-><init>()V
    check-cast v1, Lcom/bytedance/platform/godzilla/common/IReflectHackHelper;
    invoke-virtual v0, v1, Lcom/bytedance/platform/godzilla/Godzilla$Builder;->setReflectHackHelper(Lcom/bytedance/platform/godzilla/common/IReflectHackHelper;)Lcom/bytedance/platform/godzilla/Godzilla$Builder;
    new-instance v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    const/4 v3, 1
    invoke-direct v1, v3, v3, v2, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;-><init>(Z Z Ljava/util/List;)V
    check-cast v1, Lcom/bytedance/platform/godzilla/plugin/BasePlugin;
    invoke-virtual v0, v1, Lcom/bytedance/platform/godzilla/Godzilla$Builder;->plugin(Lcom/bytedance/platform/godzilla/plugin/BasePlugin;)Lcom/bytedance/platform/godzilla/Godzilla$Builder;
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v2, 26
    if-ge v1, v2, +00ch
    new-instance v1, Lcom/bytedance/platform/godzilla/anr/SpBlockPlugin;
    invoke-direct v1, Lcom/bytedance/platform/godzilla/anr/SpBlockPlugin;-><init>()V
    check-cast v1, Lcom/bytedance/platform/godzilla/plugin/BasePlugin;
    invoke-virtual v0, v1, Lcom/bytedance/platform/godzilla/Godzilla$Builder;->plugin(Lcom/bytedance/platform/godzilla/plugin/BasePlugin;)Lcom/bytedance/platform/godzilla/Godzilla$Builder;
    new-instance v1, Lcom/bytedance/trae/apm/impl/plugin/HoraeArrayMapException;
    invoke-direct v1, Lcom/bytedance/trae/apm/impl/plugin/HoraeArrayMapException;-><init>()V
    check-cast v1, Lcom/bytedance/platform/godzilla/plugin/BasePlugin;
    invoke-virtual v0, v1, Lcom/bytedance/platform/godzilla/Godzilla$Builder;->plugin(Lcom/bytedance/platform/godzilla/plugin/BasePlugin;)Lcom/bytedance/platform/godzilla/Godzilla$Builder;
    new-instance v1, Lcom/bytedance/platform/godzilla/crash/uncaughtexecption/SuperUncaughtExceptionPlugin;
    new-instance v2, Lcom/bytedance/trae/apm/impl/GodzillaImpl$init$3;
    invoke-direct v2, Lcom/bytedance/trae/apm/impl/GodzillaImpl$init$3;-><init>()V
    check-cast v2, Lcom/bytedance/platform/godzilla/crash/uncaughtexecption/SuperUncaughtExceptionPlugin$ConfigFetcher;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    check-cast v3, Landroid/content/Context;
    invoke-direct v1, v2, v3, Lcom/bytedance/platform/godzilla/crash/uncaughtexecption/SuperUncaughtExceptionPlugin;-><init>(Lcom/bytedance/platform/godzilla/crash/uncaughtexecption/SuperUncaughtExceptionPlugin$ConfigFetcher; Landroid/content/Context;)V
    check-cast v1, Lcom/bytedance/platform/godzilla/plugin/BasePlugin;
    invoke-virtual v0, v1, Lcom/bytedance/platform/godzilla/Godzilla$Builder;->plugin(Lcom/bytedance/platform/godzilla/plugin/BasePlugin;)Lcom/bytedance/platform/godzilla/Godzilla$Builder;
    invoke-virtual v0, Lcom/bytedance/platform/godzilla/Godzilla$Builder;->build()Lcom/bytedance/platform/godzilla/Godzilla;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/platform/godzilla/Godzilla;->init(Lcom/bytedance/platform/godzilla/Godzilla;)Lcom/bytedance/platform/godzilla/Godzilla;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/platform/godzilla/Godzilla;->start()V
    new-instance v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl$$ExternalSyntheticLambda1;
    invoke-direct v0, v4, Lcom/bytedance/trae/apm/impl/GodzillaImpl$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/apm/impl/GodzillaImpl;)V
    iput-object v0, v4, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->startGzlRunnable Ljava/lang/Runnable;
    invoke-interface v0, Ljava/lang/Runnable;->run()V
    return-void 
.end method
