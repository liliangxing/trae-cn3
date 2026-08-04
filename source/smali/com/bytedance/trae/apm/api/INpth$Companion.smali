# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/api/INpth$Companion;
.super Ljava/lang/Object;
.source "INpth.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/apm/api/INpth$Companion;
.field private static final impl$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$tqKSOb-SQyuWBCQ4W0T4RC6vM6A()com.bytedance.trae.apm.api.INpth
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/apm/api/INpth$Companion;->impl_delegate$lambda$0()Lcom/bytedance/trae/apm/api/INpth;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/api/INpth$Companion;
    invoke-direct v0, Lcom/bytedance/trae/apm/api/INpth$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/apm/api/INpth$Companion;->$$INSTANCE Lcom/bytedance/trae/apm/api/INpth$Companion;
    new-instance v0, Lcom/bytedance/trae/apm/api/INpth$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/apm/api/INpth$Companion$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/apm/api/INpth$Companion;->impl$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getImpl()com.bytedance.trae.apm.api.INpth
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/api/INpth$Companion;->impl$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/apm/api/INpth;
    return-object v0
.end method

.method private static final impl_delegate$lambda$0()com.bytedance.trae.apm.api.INpth
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/apm/api/INpth;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/apm/api/INpth;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/apm/api/INpth;
    return-object v0
.end method

.method public final enableGwpAsan()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/apm/api/INpth$Companion;->getImpl()Lcom/bytedance/trae/apm/api/INpth;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/apm/api/INpth;->enableGwpAsan()V
    return-void 
.end method

.method public final goUpload()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/apm/api/INpth$Companion;->getImpl()Lcom/bytedance/trae/apm/api/INpth;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/apm/api/INpth;->goUpload()V
    return-void 
.end method

.method public final init(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "base"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/api/INpth$Companion;->getImpl()Lcom/bytedance/trae/apm/api/INpth;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/apm/api/INpth;->init(Landroid/content/Context;)V
    return-void 
.end method

.method public final registerCrashCallback(com.bytedance.trae.apm.api.ICrashCallback)void
    .registers 3
    # ins_size=2
    const-string v0, "crashCallback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/api/INpth$Companion;->getImpl()Lcom/bytedance/trae/apm/api/INpth;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/apm/api/INpth;->registerCrashCallback(Lcom/bytedance/trae/apm/api/ICrashCallback;)V
    return-void 
.end method

.method public final startNpthLifecycleRecorder(android.app.Application  int)void
    .registers 4
    # ins_size=3
    const-string v0, "app"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/api/INpth$Companion;->getImpl()Lcom/bytedance/trae/apm/api/INpth;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/apm/api/INpth;->startNpthLifecycleRecorder(Landroid/app/Application; I)V
    return-void 
.end method

.method public final stopUpload(boolean)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/apm/api/INpth$Companion;->getImpl()Lcom/bytedance/trae/apm/api/INpth;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/apm/api/INpth;->stopUpload(Z)V
    return-void 
.end method
