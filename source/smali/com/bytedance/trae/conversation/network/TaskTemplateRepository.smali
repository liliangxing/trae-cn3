# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
.super Ljava/lang/Object;
.source "TaskTemplateRepository.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
.field private static final KEVA_REPO_SUFFIX:Ljava/lang/String;
.field private static final KEY_SEND_MESSAGE_COUNT:Ljava/lang/String;
.field private static final KEY_TEMPLATES:Ljava/lang/String;
.field private static final gson:Lcom/google/gson/Gson;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->gson Lcom/google/gson/Gson;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getKeva()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00eh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string/jumbo v1, task_templates
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "getRepo(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public final add(int)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const/4 v1, 0
    const-string/jumbo v2, send_showcase_count
    invoke-virtual v0, v2, v1, Lcom/bytedance/keva/Keva;->getInt(Ljava/lang/String; I)I
    move-result v0
    const/16 v1, 10
    if-le v0, v1, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v1
    add-int/2addr v0, v4
    invoke-virtual v1, v2, v0, Lcom/bytedance/keva/Keva;->storeInt(Ljava/lang/String; I)V
    return-void 
.end method

.method public final getCacheTaskTemplates()com.bytedance.trae.network.response.HttpDataResult
    .registers 14
    # ins_size=1
    invoke-direct v13, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string/jumbo v1, template_list
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, +044h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v13
    check-cast v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    sget-object v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->gson Lcom/google/gson/Gson;
    const-class v3, Lcom/bytedance/trae/conversation/network/TaskTemplatesData;
    invoke-virtual v1, v0, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/TaskTemplatesData;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v0, v2
    move-object v9, v0
    check-cast v9, Lcom/bytedance/trae/conversation/network/TaskTemplatesData;
    if-eqz v9, +019h
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v1, Lcom/bytedance/trae/network/response/BizResponse;
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v10, 0
    const/16 v11, 46
    const/4 v12, 0
    move-object v3, v1
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/4 v2, -1
    const-string v3, "cache is empty"
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v0
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    :try_start_0x1d
.end method

.method public final getTaskTemplates(kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    move-object/from16 v0, v18
    instance-of v2, v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;
    if-eqz v2, +012h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v0, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;-><init>(Lcom/bytedance/trae/conversation/network/TaskTemplateRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;->label I
    const-string/jumbo v5, template_list
    const/4 v6, 1
    if-eqz v4, +015h
    if-ne v4, v6, +00bh
    iget-object v2, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +07dh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const/4 v4, 0
    invoke-virtual v0, v5, v4, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v7, v0
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +3h
    const/4 v7, 0
    goto +2h
    move v7, v6
    if-nez v7, +043h
    sget-object v7, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v7, v1
    check-cast v7, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    sget-object v7, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->gson Lcom/google/gson/Gson;
    const-class v8, Lcom/bytedance/trae/conversation/network/TaskTemplatesData;
    invoke-virtual v7, v0, v8, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/TaskTemplatesData;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v7, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    move-object v0, v4
    move-object v13, v0
    check-cast v13, Lcom/bytedance/trae/conversation/network/TaskTemplatesData;
    if-eqz v13, +018h
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v2, Lcom/bytedance/trae/network/response/BizResponse;
    const-wide/16 v8, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v14, 0
    const/16 v15, 46
    const/16 v16, 0
    move-object v7, v2
    invoke-direct/range v7 ... v16, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v2, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IGetTaskTemplatesApi;->Companion Lcom/bytedance/trae/conversation/network/IGetTaskTemplatesApi$Companion;
    new-instance v7, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$result$1;
    invoke-direct v7, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$result$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;->L$0 Ljava/lang/Object;
    iput v6, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$getTaskTemplates$1;->label I
    invoke-virtual v0, v7, v2, Lcom/bytedance/trae/conversation/network/IGetTaskTemplatesApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v2, v1
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +033h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/TaskTemplatesData;
    if-eqz v0, +024h
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    invoke-direct v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->gson Lcom/google/gson/Gson;
    invoke-virtual v4, v0, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v5, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-object v3
    :try_start_0x5b
    :try_start_0xc7
.end method

.method public final isShow()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string/jumbo v1, send_showcase_count
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getInt(Ljava/lang/String; I)I
    move-result v0
    const/4 v1, 3
    if-lt v0, v1, +003h
    return v2
    const/4 v0, 1
    return v0
.end method

.method public final preload()void
    .registers 8
    # ins_size=1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$preload$1;
    const/4 v4, 0
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$preload$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final toTaskTemplateModels(java.util.List  java.lang.String)java.util.List
    .registers 14
    # ins_size=3
    const-string v0, "<this>"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +027h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/network/TaskTemplate;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/TaskTemplate;->getId()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +00ch
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/List;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v3, Ljava/util/List;
    invoke-interface v3, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -2ah
    new-instance v12, Ljava/util/ArrayList;
    invoke-interface v0, Ljava/util/Map;->size()I
    move-result v1
    invoke-direct v12, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v12, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +060h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/TaskTemplate;
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const-string v3, ""
    move-object v7, v3
    move-object v8, v7
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +026h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/network/TaskTemplate;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplate;->getType()Ljava/lang/String;
    move-result-object v4
    const-string v5, "normal"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplate;->getPrompt()Ljava/lang/String;
    move-result-object v7
    goto -1ch
    const-string v5, "git"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -023h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplate;->getPrompt()Ljava/lang/String;
    move-result-object v8
    goto -29h
    new-instance v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/TaskTemplate;->getId()I
    move-result v5
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/TaskTemplate;->getTitle()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/TaskTemplate;->getIcon()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/TaskTemplate;->getMode()Ljava/lang/String;
    move-result-object v10
    move-object v4, v1
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v12, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -63h
    check-cast v12, Ljava/util/List;
    check-cast v12, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +017h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->getMode()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -015h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v0, Ljava/util/List;
    return-object v0
.end method
