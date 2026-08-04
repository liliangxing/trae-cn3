# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;
.super Ljava/lang/Object;
.source "CNCommercialApiParser.kt"

.field public static final $stable:I
.field private static final COMPAT_SUCCESS_CODE:J
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;
.field private static final PAY_STATUS_FIELDS:Ljava/util/Set;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->INSTANCE Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;
    const-string/jumbo v0, user_pay_identity_str
    const-string v1, "is_credits_billing"
    const-string/jumbo v2, user_pay_identity
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->PAY_STATUS_FIELDS Ljava/util/Set;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final booleanOrNull(com.google.gson.JsonObject  java.lang.String)java.lang.Boolean
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +037h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-nez v2, +003h
    goto +2fh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +026h
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v2
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v0, v2
    check-cast v0, Ljava/lang/Boolean;
    return-object v0
    :try_start_0x14
.end method

.method private final intOrNull(com.google.gson.JsonObject  java.lang.String)java.lang.Integer
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +037h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-nez v2, +003h
    goto +2fh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +026h
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v0, v2
    check-cast v0, Ljava/lang/Integer;
    return-object v0
    :try_start_0x14
.end method

.method private final longOrNull(com.google.gson.JsonObject  java.lang.String)java.lang.Long
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +037h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-nez v2, +003h
    goto +2fh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +026h
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsLong()J
    move-result-wide v2
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v0, v2
    check-cast v0, Ljava/lang/Long;
    return-object v0
    :try_start_0x14
.end method

.method private final objectOrNull(com.google.gson.JsonObject  java.lang.String)com.google.gson.JsonObject
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +017h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-nez v2, +003h
    goto +fh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v0
    return-object v0
.end method

.method private final stringOrNull(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +033h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-nez v2, +003h
    goto +2bh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +022h
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v0, v2
    check-cast v0, Ljava/lang/String;
    return-object v0
    :try_start_0x14
.end method

.method private final toBizResponse(com.google.gson.JsonObject  java.lang.Object  long)com.bytedance.trae.network.response.BizResponse
    .registers 16
    # ins_size=5
    new-instance v10, Lcom/bytedance/trae/network/response/BizResponse;
    const-string v0, "code"
    invoke-direct v11, v12, v0, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->longOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v14
    move-wide v1, v14
    const-string v14, "msg"
    invoke-direct v11, v12, v14, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->stringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    const-string v14, "message"
    invoke-direct v11, v12, v14, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->stringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v7, 0
    const/16 v8, 40
    const/4 v9, 0
    move-object v0, v10
    move-object v6, v13
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v10
.end method

.method public final parseBillingSwitch(java.lang.String)com.bytedance.trae.network.response.BizResponse
    .registers 13
    # ins_size=2
    const-string v0, "body"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v12, Lcom/bytedance/trae/network/response/BizResponse;
    const-wide/16 v2, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v8, 0
    const/16 v9, 46
    const/4 v10, 0
    move-object v1, v12
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v12
.end method

.method public final parsePayStatus(java.lang.String)com.bytedance.trae.network.response.BizResponse
    .registers 9
    # ins_size=2
    const-string v0, "body"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v8, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v8
    const-string v0, "data"
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->objectOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Lcom/google/gson/JsonObject;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    const-string/jumbo v2, user_pay_identity
    invoke-direct v7, v8, v2, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->intOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v3
    if-nez v3, +006h
    invoke-direct v7, v0, v2, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->intOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v3
    const-string/jumbo v2, user_pay_identity_str
    invoke-direct v7, v8, v2, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->stringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +006h
    invoke-direct v7, v0, v2, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->stringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    const-string v2, "is_credits_billing"
    invoke-direct v7, v8, v2, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->booleanOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v5
    const/4 v6, 0
    if-eqz v5, +007h
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    goto +dh
    invoke-direct v7, v0, v2, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->booleanOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    goto +2h
    move v2, v6
    invoke-direct v1, v3, v4, v2, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;-><init>(Ljava/lang/Integer; Ljava/lang/String; Z)V
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->PAY_STATUS_FIELDS Ljava/util/Set;
    check-cast v2, Ljava/lang/Iterable;
    instance-of v3, v2, Ljava/util/Collection;
    if-eqz v3, +00ch
    move-object v3, v2
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +003h
    goto +2ch
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +023h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-virtual v8, v3, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v4
    const/4 v5, 1
    if-nez v4, +012h
    if-eqz v0, +00ah
    invoke-virtual v0, v3, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v3
    if-ne v3, v5, +004h
    move v3, v5
    goto +2h
    move v3, v6
    if-eqz v3, +003h
    goto +3h
    move v3, v6
    goto +2h
    move v3, v5
    if-eqz v3, -024h
    move v6, v5
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    if-eqz v6, +005h
    const-wide/16 v2, 0
    goto +3h
    const-wide/16 v2, -999
    invoke-direct v7, v8, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->toBizResponse(Lcom/google/gson/JsonObject; Ljava/lang/Object; J)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v8
    return-object v8
.end method

.method public final parseUsage(java.lang.String)com.bytedance.trae.network.response.BizResponse
    .registers 6
    # ins_size=2
    const-string v0, "body"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v5, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    move-object v1, v5
    check-cast v1, Lcom/google/gson/JsonElement;
    const-class v2, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;
    invoke-virtual v0, v1, v2, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;
    const-string/jumbo v1, user_entitlement_pack_list
    invoke-virtual v5, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +009h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    if-eqz v1, +005h
    const-wide/16 v1, 0
    goto +3h
    const-wide/16 v1, -999
    invoke-direct v4, v5, v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->toBizResponse(Lcom/google/gson/JsonObject; Ljava/lang/Object; J)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v5
    return-object v5
.end method
