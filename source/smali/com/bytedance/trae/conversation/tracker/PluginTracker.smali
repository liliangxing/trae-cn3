# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/PluginTracker;
.super Ljava/lang/Object;
.source "PluginTracker.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/PluginTracker;
.field private static final SLARDAR_EVENT:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final reportEvent(java.lang.String  org.json.JSONObject  org.json.JSONObject)void
    .registers 6
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-eqz v0, +021h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, reportEvent: 
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", params: "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "PluginTracker"
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-virtual v4, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v4, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string/jumbo v4, stage
    invoke-virtual v0, v4, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v5, +018h
    invoke-virtual v5, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v3
    if-eqz v3, +012h
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +00ch
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v0, v4, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;
    goto -fh
    sget-object v3, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v4, "plugin_connector_funnel"
    const/4 v1, 0
    invoke-virtual v3, v4, v0, v5, v1, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method static synthetic reportEvent$default(com.bytedance.trae.conversation.tracker.PluginTracker  java.lang.String  org.json.JSONObject  org.json.JSONObject  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static synthetic trackAuthResult$default(com.bytedance.trae.conversation.tracker.PluginTracker  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthResult(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final trackAuthFail(java.lang.String  java.lang.String)void
    .registers 11
    # ins_size=3
    const-string v0, "platform"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "failReason"
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v4, v0, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v9, "fail_reason"
    invoke-virtual v4, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "connector_auth_fail"
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v2, v8
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->reportEvent$default(Lcom/bytedance/trae/conversation/tracker/PluginTracker; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final trackAuthResult(java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 12
    # ins_size=5
    const-string v0, "itemId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "connectorId"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, result
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string v1, "item_id"
    invoke-virtual v3, v1, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v8, "connector_id"
    invoke-virtual v3, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v0, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v11, +007h
    const-string v8, "error_code"
    invoke-virtual v3, v8, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "connector_auth_result"
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->reportEvent$default(Lcom/bytedance/trae/conversation/tracker/PluginTracker; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final trackAuthStart(java.lang.String  java.lang.String)void
    .registers 11
    # ins_size=3
    const-string v0, "platform"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "entry"
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v4, v0, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v4, v1, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "connector_auth_start"
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v2, v8
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->reportEvent$default(Lcom/bytedance/trae/conversation/tracker/PluginTracker; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final trackAuthSuccess(java.lang.String  long  java.lang.String)void
    .registers 7
    # ins_size=5
    const-string v0, "platform"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "authMethod"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "duration_ms"
    invoke-virtual v1, v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "auth_method"
    invoke-virtual v1, v0, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v6, v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v3, "connector_auth_success"
    invoke-direct v2, v3, v1, v6, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackPluginInclude(java.lang.String  java.lang.String  java.lang.String)void
    .registers 11
    # ins_size=4
    const-string v0, "itemId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "itemType"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string v1, "item_id"
    invoke-virtual v3, v1, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v8, "item_type"
    invoke-virtual v3, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v0, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "chat_plugin_include"
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->reportEvent$default(Lcom/bytedance/trae/conversation/tracker/PluginTracker; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final trackPluginInvoked(java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 12
    # ins_size=5
    const-string v0, "itemId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "itemType"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "invokeType"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string v1, "item_id"
    invoke-virtual v3, v1, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v8, "item_type"
    invoke-virtual v3, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v8, "invoke_type"
    invoke-virtual v3, v8, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v0, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "chat_plugin_invoked"
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->reportEvent$default(Lcom/bytedance/trae/conversation/tracker/PluginTracker; Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    return-void 
.end method
