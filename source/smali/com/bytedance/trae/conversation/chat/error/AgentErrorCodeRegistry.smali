# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;
.super Ljava/lang/Object;
.source "AgentErrorCodeRegistry.kt"

.field public static final CODE_FREE_ACTIVITY_QUOTA_EXHAUSTED:I
.field private static final CONFIG_MAP:Ljava/util/Map;
.field private static final DEFAULT_CONFIG:Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
.field private static final ERROR_CODE_I18N_PREFIX:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;


.method static constructor <clinit>()void
    .registers 19
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_default I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    const-string v4, "Unknown error"
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v0
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->DEFAULT_CONFIG Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v0
    new-instance v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_default I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    const-string v4, "Unknown error"
    move-object v1, v8
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v1, 6
    new-array v1, v1, [Ljava/lang/Integer;
    const/4 v2, -2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const/4 v3, 0
    aput-object v2, v1, v3
    const/16 v2, 10
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const/4 v3, 1
    aput-object v2, v1, v3
    const/16 v2, 11
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const/4 v4, 2
    aput-object v2, v1, v4
    const/16 v2, 12
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const/4 v4, 3
    aput-object v2, v1, v4
    const/16 v2, 13
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const/4 v4, 4
    aput-object v2, v1, v4
    const/16 v2, 14
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const/4 v4, 5
    aput-object v2, v1, v4
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +014h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, v2, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -17h
    const/4 v1, -1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_server_crash I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Server error. Please try again later."
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 999
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_network I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request service failed, please check your network configuration and try again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 998
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_network_internal I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request service failed, please check if you are in an intranet environment and try again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 997
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_client_network I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request service failed, please check your network configuration and try again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 996
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_client_network_internal I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request service failed, please check if you are in an intranet environment and try again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 995
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_request_timeout I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request service timeout, please check your network configuration and try again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 994
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_request_timeout_internal I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request service timeout, please check if you are in an intranet environment and try again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 993
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_model_response_timeout I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Model response timeout, please try again later."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 992
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_model_response_failed I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Model response failed, please try again later."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 978
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_model_auto_selection_failed I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Model response failed, please try again later."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 976
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_os_suspend_timeout I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request timed out, possibly due to network interruption caused by the device screen turning off."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 975
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_network_changed I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Your network has changed. Please try again after the network stabilizes."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 974
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_network_disconnected I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Your network connection has been disconnected. Please reconnect and try again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 1006
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_connection I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Network error, please check your network configuration and try again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 700
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_firewall_blocked I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request blocked by current network. Please check your network proxy or contact your network administrator."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 980
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_proxy_connect I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Service request failed, please check the system network proxy settings and try again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 1001
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_invalid_token I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Authentication error, please log in again and try again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 1002
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_auth_fail I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Authentication failed. Please log in again and retry."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 1003
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_password_changed I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Your session has expired due to a password change. Please log in again."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4010
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_abnormal_account_logout I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Risky account detected. You have been automatically logged out."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4011
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_abnormal_account_limit I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "AI Chat usage today has reached the limit."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4014
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_account_deleted I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Your account has been deleted."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 3004
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_request_limit I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "The model is experiencing high traffic, please try again later."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4007
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_user_request_limit I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request throttled. Please try again later."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4008
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_agent_error_premium_usage_limit I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Your current usage has been exhausted, and you’re temporarily unable to continue the conversation."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4009
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_standard_usage_limit I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request throttled. Please try again later."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4021
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_today_request_limit I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "The number of sessions today has reached the upper limit, please come back tomorrow."
    move-object v4, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v12, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_queue_timeout I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    const-string v14, "The request has timed out. Please try again later."
    const/4 v15, 0
    const/16 v16, 8
    const/16 v17, 0
    move-object v11, v1
    invoke-direct/range v11 ... v17, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/16 v2, 4050
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v0, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v4, 4051
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v0, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v4, 4052
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v0, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 5003
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_out_of_quota I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request throttled. Please try again later."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 977
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_premium_quota_drained I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "You've used up your Premium model request quota."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 2001
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_unknown I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request failed. Please try again later."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v13, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_model_fail I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    const-string v15, "Model Request failed. Please try again later."
    const/16 v16, 0
    const/16 v17, 8
    const/16 v18, 0
    move-object v12, v1
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/16 v4, 3003
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v0, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v4, 4053
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v0, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v4, 4054
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v0, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4001
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_invalid_args I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request failed. Please try again later."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v13, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_token_limit I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    const-string v15, "Request failed. Please create a new session and try again."
    move-object v12, v1
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/16 v4, 4006
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v0, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v4, 4022
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v0, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4026
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_context_length_exceeded I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Context length has exceeded the maximum limit."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4023
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_model_not_existed I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Model list has been updated. Please confirm and try again."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4024
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_model_existed I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Please don't add the same model more than once."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 991
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_return_empty I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Model has heavy traffic. Please try again later."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 987
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_model_output_too_long I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Output is too long, please enter 'Continue' to get more."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 1009
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_big_message I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Message too long, please optimize the input and try again."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 983
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_sensitive_content I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Message may contain sensitive words. Please check and resend."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 979
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_input_sensitive I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Your input may contain sensitive words. Please check and resend."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4016
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_image_content_safety I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "The picture contains sensitive content."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4400
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_ai_feature_restricted I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "The AI feature is restricted in the current workspace."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4013
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_request_abnormal I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "AI service is not available in the current region now."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4012
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_request_downgrade I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Request failed. Please try again later."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4015
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_risk_request I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Your request has been flagged for security review."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4017
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_risk_request I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Your request has been flagged for security review."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 40142
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_abnormal_account_limit I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "AI Chat usage today has reached the limit."
    move-object v4, v11
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 985
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    const-string v6, ""
    const/4 v7, 0
    invoke-direct v4, v5, v7, v6, v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z)V
    invoke-interface v0, v1, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 984
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_custom_model_not_found I
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    const-string v11, "Incorrect model name, please verify it matches the provider's name."
    const/4 v12, 0
    const/16 v13, 8
    const/4 v14, 0
    move-object v8, v4
    invoke-direct/range v8 ... v14, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4028
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    const-string v6, "Unknown error"
    invoke-direct v4, v5, v7, v6, v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z)V
    invoke-interface v0, v1, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 5001
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_turn_exceeded I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "The number of session turns has exceeded the upper limit, please try creating a new session."
    const/4 v7, 0
    const/16 v8, 8
    const/4 v9, 0
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 5002
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_timeout I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Request failed. Please try again later."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 5004
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_agent_busy I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Request failed. Please try again later."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 6004
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_intent_error I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Intent recognition failed. Please try again later."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 7000
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_not_support_multimedia I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "The current model does not support questions containing images."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 7001
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_system_not_support_ai I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "The current remote operating system version does not support AI features."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 7002
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_default I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Unknown error"
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 1005
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_solo_agent_exclusive I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "This mode is exclusive to Pro users. Upgrade to unlock."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v12, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_llm_invalid_json I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    const-string v14, "An error occurred during model processing. Please try again or switch the model."
    const/4 v15, 0
    const/16 v16, 8
    const/16 v17, 0
    move-object v11, v1
    invoke-direct/range v11 ... v17, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const v3, 4000003
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v3, 4000004
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 4000005
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->INFO Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_llm_queuing I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Too many current requests. Please wait in the queue."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v12, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_llm_loop_detected I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    const-string v14, "Loop was detected in the model and the request has been interrupted."
    move-object v11, v1
    invoke-direct/range v11 ... v17, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const v3, 4000009
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v3, 4000012
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 4000010
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_llm_prompt_too_long I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "The input is too long. Please shorten your input."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v12, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_task_timeout_expired I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    const-string v14, "Task timeout: Execution exceeded 24 hours."
    move-object v11, v1
    invoke-direct/range v11 ... v17, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const v3, 4000100
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v3, 4000101
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 4000002
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_task_turn_exceeded I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Model thinking limit reached, please enter 'Continue' to get more."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 5000001
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_project_not_found I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Project error. Please reopen the project folder."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 1010002
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_client_unauthorized I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Authorization failed. Please log in again."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 13000000
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_tool_call_retry_limit I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Tool call failed due to model hallucination."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4200
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_subscription_expired I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "The enterprise subscription has expired."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4201
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_seat_quota_billing_disabled I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "The seat-included conversation quota has been reached. Please contact your administrator to activate pay-as-you-go services."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4202
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_seat_quota_billing_insufficient I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "The seat-included conversation quota has been reached. Please contact your administrator to check if the pay-as-you-go service is functioning properly."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4203
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_seat_quota_limit_reached I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Your usage has reached the limit. Please contact your administrator to raise the pay-as-you-go quota."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4213
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_no_custom_model I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Not allowed to add custom models."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4214
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_account_not_exist I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Account does not exist."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4215
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_subscription_expired I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Enterprise subscription expired."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4216
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_session_expired I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Session expired. Please log in again."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4220
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_model_usage_exhausted I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Model usage exhausted."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4221
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_tenant_quota I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Enterprise quota limit reached."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4222
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_user_quota I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Personal quota limit reached."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4223
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_per_model_tenant_quota I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Enterprise per-model quota limit reached."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4224
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_per_model_user_quota I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Personal per-model quota limit reached."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4225
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_quota_config_invalid I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Per-user quota cannot exceed total quota."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4232
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_solo_subscription I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "SOLO is not available in your current subscription plan."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4237
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_auto_mode_all_models_disabled I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "All models supported by Auto mode have been disabled. Please contact your administrator."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4113
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_claude_model_forbidden I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Claude series models are currently unavailable in Hong Kong and Macau."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4120
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_cannot_use_solo_mode I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Can not use solo mode, please switch to dev mode."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4031
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->INFO Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_free_activity_quota I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Let's call it a day. Get some rest and we'll pick this back up tomorrow!"
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4032
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_free_activity_end I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "The event has ended. Please try again."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4035
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_paygo_arrears I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Account status abnormal. Unable to start tasks at this time."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4036
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_invite_only I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Invite-only access. Redeem your invitation code."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const/16 v1, 4027
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_invalid_tool_call I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "The argument schema for mcp tool is incompatible with current model."
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v12, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_git_repo_not_found I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    const-string v14, "Repository info not found."
    move-object v11, v1
    invoke-direct/range v11 ... v17, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const v3, 991400
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v3, 991401
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_git_token_invalid I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const-string v7, "Git token is invalid."
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v1
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const v3, 991402
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v3, 991403
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 991209
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_insufficient_resources I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "Insufficient resources, please retry later."
    const/4 v7, 0
    const/16 v8, 8
    const/4 v9, 0
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v10, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_model_overloaded I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Model overloaded, please retry later."
    const/4 v6, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992600
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_not_initialized I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "VM manager is not initialized."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992601
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_not_running I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Lite VM is not running."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992602
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_start_failed I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Failed to start Lite VM."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992603
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_status_error I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Lite VM status error."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992604
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_communication_error I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Failed to communicate with Lite VM."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992605
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_invoke_error I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Lite VM invocation failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992606
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_session_sync I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Lite VM session sync failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992607
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_mount_error I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Lite VM mount failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992608
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_config_error I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Lite VM configuration error."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992609
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_pending_task I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Lite VM has pending tasks."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992610
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_not_supported I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Lite VM is not supported."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992611
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_packet_loss I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "SOLO workspace event stream packet loss detected."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992612
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_stream_disconnected I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "SOLO workspace event stream disconnected."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992613
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_stream_timeout I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "SOLO workspace event stream timed out."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992614
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_out_of_memory I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "SOLO workspace failed to start due to insufficient memory."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992615
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_dhcp_failed I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "SOLO workspace DHCP failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 992616
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_vm_dns_proxy_failed I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "SOLO workspace DNS Proxy failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000101
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_git_clone_failed I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "GitHub Repository sync failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000102
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_git_clone_timeout I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "GitHub Repository sync timed out."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000103
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_restic_restore_failed I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Data sync failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000104
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_restic_restore_timeout I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Data sync timed out."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000105
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_env_restore_failed I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Environment restore failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000106
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_env_restore_timeout I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Environment restore timed out."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000107
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_storage_error I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Task initialization failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000108
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_session_busy I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Task initialization failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000109
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_git_push_failed I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Code push failed. Changes may be lost."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000110
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_backup_failed I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Data backup failed. Changes may be lost."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 2000111
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_remote_history_restore_failed I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Task history restoration failed."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 5910000
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_5910000 I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Model Request failed. Please try again later."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 5910001
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_5910001 I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Model Request failed. Please try again later."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 5910002
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_5910002 I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Model Request failed. Please try again later."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 5910003
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_5910003 I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Model Request failed. Please try again later."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 5920000
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_5920000 I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Server error. Please try again later."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 5920001
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_5920001 I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Server error. Please try again later."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 5920002
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_5920002 I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Server error. Please try again later."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const v1, 991502
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_solo_parallel_limit I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "Parallel tasks have reached the limit."
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v0, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->CONFIG_MAP Ljava/util/Map;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildEnterpriseCommercialDisplay(android.content.res.Resources  java.lang.Integer  com.google.gson.JsonObject)com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry$DisplayResult
    .registers 12
    # ins_size=4
    const/4 v0, 0
    if-nez v10, +003h
    goto +ah
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v10
    const v1, 991502
    if-eq v10, v1, +003h
    return-object v0
    const-string v10, "limit"
    invoke-direct v8, v11, v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->readInt(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v10
    if-nez v10, +011h
    const-string v10, "parallel_limit"
    invoke-direct v8, v11, v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->readInt(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v10
    if-nez v10, +009h
    const-string/jumbo v10, solo_agent_parallel_limit
    invoke-direct v8, v11, v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->readInt(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;->INSTANCE Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;
    invoke-virtual v11, v9, v10, Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;->parallelLimitMessage(Landroid/content/res/Resources; Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    return-object v0
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 12
    const/4 v7, 0
    move-object v1, v9
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v9
.end method

.method private final buildErrorCodeI18nKey(int  java.lang.String)java.lang.String
    .registers 6
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "icube_error_code_"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +029h
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->sanitizeDataType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    move v1, v2
    if-eqz v1, +019h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 95
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    return-object v4
    :try_start_0xf
.end method

.method static synthetic buildErrorCodeI18nKey$default(com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry  int  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->buildErrorCodeI18nKey(I Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final buildInternalUsageLimitMessage(android.content.res.Resources  com.google.gson.JsonObject)java.lang.String
    .registers 15
    # ins_size=3
    const-string v0, "models"
    invoke-direct v12, v14, v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->readStringList(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +00ah
    sget-object v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;
    const-string v2, "model_names"
    invoke-direct v1, v14, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->readStringList(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +00ah
    sget-object v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;
    const-string v2, "modelNames"
    invoke-direct v1, v14, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->readStringList(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v14
    invoke-interface v14, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +00eh
    sget-object v14, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_internalUsageLimit_message I
    const/4 v1, 0
    new-array v1, v1, [Ljava/lang/Object;
    invoke-virtual v14, v13, v0, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    return-object v13
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_internalUsageLimit_messageWithModels I
    move-object v3, v14
    check-cast v3, Ljava/lang/Iterable;
    const-string v14, ", "
    move-object v4, v14
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v14
    invoke-static v0, v14, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v14
    invoke-static v14, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v14
    invoke-virtual v1, v13, v2, v14, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getStringWithNamedArgs(Landroid/content/res/Resources; I Ljava/util/Map;)Ljava/lang/String;
    move-result-object v13
    return-object v13
.end method

.method private final buildModelUnavailableDisplay(android.content.res.Resources  java.lang.Integer  java.lang.String  com.google.gson.JsonObject)com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry$DisplayResult
    .registers 14
    # ins_size=5
    const/4 v0, 0
    const/4 v1, 0
    if-nez v11, +003h
    goto +3eh
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v2
    const/16 v3, 4008
    if-ne v2, v3, +037h
    invoke-direct v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->isInternalUser()Z
    move-result v11
    if-eqz v11, +030h
    const-string v11, "is_internal_usage_limit"
    invoke-direct v9, v13, v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v11
    const/4 v12, 1
    invoke-static v12, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v12
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +003h
    goto +1dh
    new-instance v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    invoke-direct v9, v10, v13, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->buildInternalUsageLimitMessage(Landroid/content/res/Resources; Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    sget-object v11, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v12, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_internalUsageLimit_title I
    new-array v13, v0, [Ljava/lang/Object;
    invoke-virtual v11, v10, v12, v13, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v2, v1
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto/16 +087h
    return-object v1
    if-nez v11, +003h
    goto +5fh
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v2
    const/16 v3, 4037
    if-ne v2, v3, +058h
    const-string/jumbo v11, type
    invoke-direct v9, v13, v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    const-string v1, "empty_git"
    invoke-static v11, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    const-string v1, ""
    if-eqz v11, +00dh
    sget-object v11, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v13, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_repoLevelModelUnavailable_emptyGit I
    new-array v0, v0, [Ljava/lang/Object;
    invoke-virtual v11, v10, v13, v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    goto +1dh
    sget-object v11, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_repoLevelModelUnavailable I
    const-string v2, "level"
    invoke-direct v9, v13, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    if-nez v13, +003h
    move-object v13, v1
    const-string/jumbo v2, repoLevel
    invoke-static v2, v13, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v13
    invoke-static v13, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v13
    invoke-virtual v11, v10, v0, v13, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getStringWithNamedArgs(Landroid/content/res/Resources; I Ljava/util/Map;)Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v11
    if-eqz v11, +006h
    if-nez v12, +003h
    move-object v12, v1
    move-object v10, v12
    move-object v1, v10
    check-cast v1, Ljava/lang/String;
    new-instance v10, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 12
    const/4 v6, 0
    move-object v0, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v10
    goto +24h
    if-nez v11, +003h
    goto +21h
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v11
    const/16 v12, 4410
    if-ne v11, v12, +01ah
    new-instance v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    const-string/jumbo v11, rule_name
    invoke-direct v9, v13, v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v9, v10, v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->contentSecurityBlockedMessage(Landroid/content/res/Resources; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 12
    const/4 v8, 0
    move-object v2, v1
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method private final config(android.content.res.Resources  int  java.lang.String)com.bytedance.trae.conversation.chat.error.AgentErrorCodeConfig
    .registers 12
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->CONFIG_MAP Ljava/util/Map;
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +02dh
    move-object v3, v11
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +008h
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    move v1, v2
    if-nez v1, +01eh
    invoke-direct v8, v10, v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->buildErrorCodeI18nKey(I Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v11, v9, v10, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getStringByName(Landroid/content/res/Resources; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +012h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;->getLevel()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    move-result-object v2
    const/4 v3, 0
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v9
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v9
    return-object v0
    move-object v0, v11
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +008h
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    move v1, v2
    if-nez v1, +01ch
    invoke-direct v8, v10, v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->buildErrorCodeI18nKey(I Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v0, v9, v11, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getStringByName(Landroid/content/res/Resources; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +010h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    const/4 v3, 0
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v9
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v9
    const/4 v11, 2
    const/4 v0, 0
    invoke-static v8, v10, v0, v11, v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->buildErrorCodeI18nKey$default(Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry; I Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v11, v9, v10, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getStringByName(Landroid/content/res/Resources; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +010h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    const/4 v2, 0
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;-><init>(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/Integer; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v9
    sget-object v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->DEFAULT_CONFIG Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    return-object v9
.end method

.method static synthetic config$default(com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry  android.content.res.Resources  int  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.chat.error.AgentErrorCodeConfig
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->config(Landroid/content/res/Resources; I Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic displayMessage$default(com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry  android.content.res.Resources  java.lang.Integer  java.lang.String  com.google.gson.JsonObject  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry$DisplayResult
    .registers 18
    # ins_size=9
    and-int/lit8 v0, v16, 4
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v12
    and-int/lit8 v0, v16, 8
    if-eqz v0, +004h
    move-object v6, v1
    goto +2h
    move-object v6, v13
    and-int/lit8 v0, v16, 16
    if-eqz v0, +004h
    move-object v7, v1
    goto +2h
    move-object v7, v14
    and-int/lit8 v0, v16, 32
    if-eqz v0, +00ah
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    move v8, v0
    goto +2h
    move v8, v15
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    invoke-virtual/range v2 ... v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->displayMessage(Landroid/content/res/Resources; Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    move-result-object v0
    return-object v0
.end method

.method private static synthetic getCONFIG_MAP$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method private final isInternalUser()boolean
    .registers 5
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;
    move-result-object v1
    const-string v2, "bytecloud"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    const/4 v2, 1
    if-nez v1, +014h
    const/4 v1, 0
    if-eqz v0, +00ch
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getOdinUserType()I
    move-result v0
    const/16 v3, 12
    if-ne v0, v3, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-eqz v0, +003h
    goto +2h
    move v2, v1
    return v2
.end method

.method private final readBoolean(com.google.gson.JsonObject  java.lang.String)java.lang.Boolean
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +036h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +030h
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
    :try_start_0x13
.end method

.method private final readInt(com.google.gson.JsonObject  java.lang.String)java.lang.Integer
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +036h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +030h
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
    :try_start_0x13
.end method

.method private final readString(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +03fh
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +039h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +02fh
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
    move-object v2, v0
    check-cast v2, Ljava/lang/String;
    if-eqz v2, +00eh
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    move-object v0, v2
    return-object v0
    :try_start_0x13
.end method

.method private final readStringList(com.google.gson.JsonObject  java.lang.String)java.util.List
    .registers 6
    # ins_size=3
    if-eqz v4, +0bch
    invoke-virtual v4, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-nez v4, +004h
    goto/16 +0b4h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v5
    const/4 v0, 0
    if-eqz v5, +065h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v4
    const-string v5, "getAsJsonArray(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +046h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/google/gson/JsonElement;
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +02fh
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    if-eqz v1, +00eh
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, -044h
    invoke-interface v5, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -49h
    check-cast v5, Ljava/util/List;
    goto +48h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +03fh
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    move-object v4, v0
    check-cast v4, Ljava/lang/String;
    if-eqz v4, +015h
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/lit8 v5, v5, 1
    if-eqz v5, +003h
    goto +2h
    move-object v4, v0
    if-eqz v4, +006h
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    if-nez v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    goto +7h
    move-object v5, v0
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    return-object v5
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    return-object v4
    :try_start_0x3d
    :try_start_0x7a
.end method

.method private final sanitizeDataType(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    const-string v1, ""
    if-eqz v0, +003h
    return-object v1
    new-instance v0, Lkotlin/text/Regex;
    const-string v2, "[^a-zA-Z0-9_]"
    invoke-direct v0, v2, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, v1, Lkotlin/text/Regex;->replace(Ljava/lang/CharSequence; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method public final contentSecurityBlockedMessage(android.content.res.Resources  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    const-string/jumbo v0, resources
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;->blockedMessage(Landroid/content/res/Resources; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final displayMessage(android.content.res.Resources  java.lang.Integer  java.lang.String  com.google.gson.JsonObject  java.lang.String  boolean)com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry$DisplayResult
    .registers 14
    # ins_size=7
    const-string/jumbo v0, resources
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorDisplayPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorDisplayPolicy;
    invoke-virtual v0, v9, v13, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorDisplayPolicy;->resolve(Ljava/lang/Integer; Z)Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;
    move-result-object v13
    const/4 v0, 0
    if-eqz v13, +028h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    sget-object v10, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->getMessageResId()I
    move-result v11
    new-array v12, v0, [Ljava/lang/Object;
    invoke-virtual v10, v8, v11, v12, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->getLevel()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->getTitleResId()I
    move-result v1
    new-array v0, v0, [Ljava/lang/Object;
    invoke-virtual v12, v8, v1, v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->getShowInfoIcon()Z
    move-result v12
    invoke-direct v9, v10, v11, v8, v12, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z)V
    return-object v9
    invoke-direct v7, v8, v9, v10, v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->buildModelUnavailableDisplay(Landroid/content/res/Resources; Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    move-result-object v13
    if-eqz v13, +003h
    return-object v13
    invoke-direct v7, v8, v9, v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->buildEnterpriseCommercialDisplay(Landroid/content/res/Resources; Ljava/lang/Integer; Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    move-result-object v11
    if-eqz v11, +003h
    return-object v11
    if-eqz v9, +00bh
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v11
    invoke-direct v7, v8, v11, v12, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->config(Landroid/content/res/Resources; I Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    move-result-object v11
    goto +3h
    sget-object v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->DEFAULT_CONFIG Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;->getUseOriginMessage()Z
    move-result v12
    const/4 v13, 1
    if-eqz v12, +014h
    move-object v12, v10
    check-cast v12, Ljava/lang/CharSequence;
    if-eqz v12, +00bh
    invoke-interface v12, Ljava/lang/CharSequence;->length()I
    move-result v12
    if-nez v12, +003h
    goto +3h
    move v12, v0
    goto +2h
    move v12, v13
    if-nez v12, +003h
    goto +30h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;->getStringResId()Ljava/lang/Integer;
    move-result-object v10
    if-eqz v10, +027h
    sget-object v10, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;->getStringResId()Ljava/lang/Integer;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/Integer;->intValue()I
    move-result v12
    new-array v1, v0, [Ljava/lang/Object;
    invoke-virtual v10, v8, v12, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +004h
    move v10, v13
    goto +2h
    move v10, v0
    if-eqz v10, +006h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;->getDefaultMessage()Ljava/lang/String;
    move-result-object v8
    move-object v10, v8
    check-cast v10, Ljava/lang/String;
    goto +5h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;->getDefaultMessage()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;->getLevel()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    move-result-object v8
    sget-object v12, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->ERROR Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    if-ne v8, v12, +02dh
    if-eqz v9, +02bh
    move-object v8, v10
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +003h
    move v0, v13
    if-eqz v0, +01fh
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v10, " ("
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const/16 v9, 41
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    move-object v1, v10
    new-instance v8, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;->getLevel()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 12
    const/4 v6, 0
    move-object v0, v8
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v8
.end method
