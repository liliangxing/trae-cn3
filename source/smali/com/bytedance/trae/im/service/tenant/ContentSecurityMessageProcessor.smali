# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;
.super Ljava/lang/Object;
.source "ContentSecurityMessageProcessor.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;
.field private static final gson:Lcom/google/gson/Gson;
.field private static final queryPartListType:Ljava/lang/reflect/Type;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;
    invoke-direct v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;->gson Lcom/google/gson/Gson;
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor$queryPartListType$1;
    invoke-direct v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor$queryPartListType$1;-><init>()V
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor$queryPartListType$1;->getType()Ljava/lang/reflect/Type;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;->queryPartListType Ljava/lang/reflect/Type;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final textContent(com.bytedance.trae.im.model.MessagePart)java.lang.String
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, text
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-virtual v3, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +018h
    const-string v0, "content"
    invoke-virtual v3, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +010h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v3, v1
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method public final processQuery(java.lang.String  java.util.List)com.bytedance.trae.im.service.tenant.ContentSecurityMessageProcessResult
    .registers 17
    # ins_size=3
    move-object v0, v15
    const-string v1, "query"
    invoke-static v15, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, rules
    move-object/from16 v4, v16
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface/range v16, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +007h
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;
    return-object v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v14
    check-cast v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;
    sget-object v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;->gson Lcom/google/gson/Gson;
    sget-object v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;->queryPartListType Ljava/lang/reflect/Type;
    invoke-virtual v1, v15, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
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
    const/4 v0, 0
    check-cast v0, Ljava/util/List;
    if-nez v0, +007h
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;
    return-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +014h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/MessagePart;
    sget-object v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;
    invoke-direct v5, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;->textContent(Lcom/bytedance/trae/im/model/MessagePart;)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, -012h
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v1, Ljava/util/List;
    move-object v5, v1
    check-cast v5, Ljava/lang/Iterable;
    const-string v1, "
"
    move-object v6, v1
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 62
    const/4 v13, 0
    invoke-static/range v5 ... v13, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v9, 1
    if-nez v1, +004h
    move v1, v9
    goto +2h
    const/4 v1, 0
    if-eqz v1, +007h
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;
    return-object v0
    sget-object v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 12
    const/4 v8, 0
    move-object/from16 v4, v16
    invoke-static/range v2 ... v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->filter$default(Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter; Ljava/lang/String; Ljava/util/List; I I I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Passed;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Passed;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +008h
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;
    goto/16 +08eh
    instance-of v2, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    if-eqz v2, +00dh
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;
    check-cast v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    invoke-direct v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;-><init>(Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;)V
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;
    goto/16 +07fh
    instance-of v2, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;
    if-eqz v2, +00ch
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;
    check-cast v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;
    invoke-direct v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;-><init>(Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;)V
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;
    goto +70h
    instance-of v2, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;
    if-eqz v2, +06eh
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v2
    new-instance v3, Lcom/google/gson/JsonObject;
    invoke-direct v3, Lcom/google/gson/JsonObject;-><init>()V
    check-cast v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;->getProcessedContent()Ljava/lang/String;
    move-result-object v4
    const-string v5, "content"
    invoke-virtual v3, v5, v4, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v4, Lcom/bytedance/trae/im/model/MessagePart;
    const-string/jumbo v5, text
    invoke-direct v4, v5, v3, Lcom/bytedance/trae/im/model/MessagePart;-><init>(Ljava/lang/String; Lcom/google/gson/JsonObject;)V
    invoke-interface v2, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    xor-int/2addr v6, v9
    if-eqz v6, -016h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1bh
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, v3, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-static v2, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Desensitized;
    sget-object v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;->gson Lcom/google/gson/Gson;
    invoke-virtual v3, v0, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v3, toJson(...)
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;->getProcessedContent()Ljava/lang/String;
    move-result-object v1
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Desensitized;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    :try_start_0x19
.end method
