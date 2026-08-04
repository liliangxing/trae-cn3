# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/abtest/impl/AbTestImpl;
.super Ljava/lang/Object;
.source "AbTestImpl.kt"

.implements Lcom/larus/abtest/api/IAbTest;

.field public static final Companion:Lcom/bytedance/trae/abtest/impl/AbTestImpl$Companion;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/abtest/impl/AbTestImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/abtest/impl/AbTestImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/abtest/impl/AbTestImpl;->Companion Lcom/bytedance/trae/abtest/impl/AbTestImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getExperimentValue(java.lang.String  java.lang.Class  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=4
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tClass
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-virtual v1, v2, v3, v4, v0, Lcom/bytedance/trae/abtest/impl/AbTestImpl;->getExperimentValue(Ljava/lang/String; Ljava/lang/Class; Ljava/lang/Object; Z)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public getExperimentValue(java.lang.String  java.lang.Class  java.lang.Object  boolean)java.lang.Object
    .registers 12
    # ins_size=5
    const-string v0, "key"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tClass
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v5, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move v6, v11
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/abtest/impl/AbTestImpl;->getExperimentValue(Ljava/lang/String; Ljava/lang/Class; Ljava/lang/Object; Z Z)Ljava/lang/Object;
    move-result-object v8
    return-object v8
.end method

.method public getExperimentValue(java.lang.String  java.lang.Class  java.lang.Object  boolean  boolean)java.lang.Object
    .registers 7
    # ins_size=6
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tClass
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/dataplatform/ExperimentManager;->isInit()Z
    move-result v0
    if-nez v0, +003h
    return-object v4
    check-cast v3, Ljava/lang/reflect/Type;
    invoke-static v2, v3, v4, v5, v6, Lcom/bytedance/dataplatform/ExperimentManager;->getExperimentValue(Ljava/lang/String; Ljava/lang/reflect/Type; Ljava/lang/Object; Z Z)Ljava/lang/Object;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v4, v2
    return-object v4
.end method

.method public getExposureInfo(java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    if-eqz v1, +007h
    invoke-static v1, Lcom/bytedance/dataplatform/ExperimentManager;->getExposureInfo(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    return-object v1
.end method

.method public getLibraExperimentCache()org.json.JSONObject
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/dataplatform/ExperimentManager;->getLibraExperimentCache()Lorg/json/JSONObject;
    move-result-object v0
    return-object v0
.end method

.method public getUserVids()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, ""
    return-object v0
.end method

.method public getUserVids(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +005h
    const-string v2, ""
    return-object v2
    invoke-static v2, Lcom/bytedance/dataplatform/ExperimentManager;->getUserVids(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public isInit()boolean
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/dataplatform/ExperimentManager;->isInit()Z
    move-result v0
    return v0
.end method

.method public refresh()void
    .registers 8
    # ins_size=1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/abtest/impl/AbTestImpl$refresh$1;
    const/4 v4, 0
    invoke-direct v0, v4, Lcom/bytedance/trae/abtest/impl/AbTestImpl$refresh$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public testABTestExperimentFetch()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public updateUserId(java.lang.String)void
    .registers 3
    # ins_size=2
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return-void 
    invoke-static v2, Lcom/bytedance/dataplatform/ExperimentManager;->updateUserId(Ljava/lang/String;)V
    return-void 
.end method
