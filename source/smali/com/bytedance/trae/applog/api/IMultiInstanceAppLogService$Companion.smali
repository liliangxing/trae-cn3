# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;
.super Ljava/lang/Object;
.source "IMultiInstanceAppLogService.kt"

.implements Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;
.field private static final impl$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$GrCgV4yKgIUamhYzHJewcdeooUc()com.bytedance.trae.applog.api.IMultiInstanceAppLogService
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;->impl_delegate$lambda$0()Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;
    invoke-direct v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;->$$INSTANCE Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;
    new-instance v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;->impl$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getImpl()com.bytedance.trae.applog.api.IMultiInstanceAppLogService
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;->impl$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;
    return-object v0
.end method

.method private static final impl_delegate$lambda$0()com.bytedance.trae.applog.api.IMultiInstanceAppLogService
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;
    return-object v0
.end method

.method public createInstance()com.bytedance.trae.applog.api.IMultiInstanceAppLog
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;->createInstance()Lcom/bytedance/trae/applog/api/IMultiInstanceAppLog;
    move-result-object v0
    return-object v0
.end method
