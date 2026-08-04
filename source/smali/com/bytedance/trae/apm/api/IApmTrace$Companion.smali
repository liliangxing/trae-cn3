# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
.super Ljava/lang/Object;
.source "IApmTrace.kt"

.implements Lcom/bytedance/trae/apm/api/IApmTrace;

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
.field private static final impl$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$pOxlOSb7IolKKU_p8uTB1P4MttQ()com.bytedance.trae.apm.api.IApmTrace
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->impl_delegate$lambda$0()Lcom/bytedance/trae/apm/api/IApmTrace;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    invoke-direct v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->$$INSTANCE Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    new-instance v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->impl$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getImpl()com.bytedance.trae.apm.api.IApmTrace
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->impl$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/apm/api/IApmTrace;
    return-object v0
.end method

.method private static final impl_delegate$lambda$0()com.bytedance.trae.apm.api.IApmTrace
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/apm/api/IApmTrace;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/apm/api/IApmTrace;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/apm/api/IApmTrace;
    return-object v0
.end method

.method public addPerfTag(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->getImpl()Lcom/bytedance/trae/apm/api/IApmTrace;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/apm/api/IApmTrace;->addPerfTag(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public addTag(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->getImpl()Lcom/bytedance/trae/apm/api/IApmTrace;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/apm/api/IApmTrace;->addTag(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public reportApmEvent(java.lang.String  org.json.JSONObject  org.json.JSONObject  org.json.JSONObject)void
    .registers 6
    # ins_size=5
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "category"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->getImpl()Lcom/bytedance/trae/apm/api/IApmTrace;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, v4, v5, Lcom/bytedance/trae/apm/api/IApmTrace;->reportApmEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public reportTeaEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->getImpl()Lcom/bytedance/trae/apm/api/IApmTrace;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/apm/api/IApmTrace;->reportTeaEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public startApmScene(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->getImpl()Lcom/bytedance/trae/apm/api/IApmTrace;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/apm/api/IApmTrace;->startApmScene(Ljava/lang/String;)V
    return-void 
.end method

.method public stopApmScene(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->getImpl()Lcom/bytedance/trae/apm/api/IApmTrace;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/apm/api/IApmTrace;->stopApmScene(Ljava/lang/String;)V
    return-void 
.end method

.method public traceAll(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->getImpl()Lcom/bytedance/trae/apm/api/IApmTrace;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/apm/api/IApmTrace;->traceAll(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
