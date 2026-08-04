# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;
.super Ljava/lang/Object;
.source "CancelTaskMonitor.kt"

.field private static final ALOG_SCENE:Ljava/lang/String;
.field private static final ALOG_UPLOAD_WINDOW_SECONDS:J
.field private static final EVENT:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;
.field private static final MAX_UPLOADED_TASK_IDS:I
.field private static final alogUploadedTaskIds:Ljava/util/LinkedHashSet;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;->INSTANCE Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;->alogUploadedTaskIds Ljava/util/LinkedHashSet;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic report$default(com.bytedance.trae.conversation.tracker.CancelTaskMonitor  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.Long  boolean  java.lang.String  int  java.lang.Object)void
    .registers 27
    # ins_size=13
    move/from16 v0, v25
    and-int/lit8 v1, v0, 4
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v1, v0, 8
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v19
    and-int/lit8 v1, v0, 32
    if-eqz v1, +006h
    const-wide/16 v3, 0
    move-wide v9, v3
    goto +3h
    move-wide/from16 v9, v20
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v1, v0, 128
    if-eqz v1, +005h
    const/4 v1, 0
    move v12, v1
    goto +3h
    move/from16 v12, v23
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v24
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    invoke-virtual/range v3 ... v13, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;->report(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/Long; Z Ljava/lang/String;)V
    return-void 
.end method

.method private final uploadALog(long)void
    .registers 15
    # ins_size=3
    const-string v0, "cancel_task_"
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    const-wide/16 v3, 1000
    div-long v9, v1, v3
    const-wide/16 v1, 300
    sub-long v7, v9, v1
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v13, v14, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const/4 v11, 0
    invoke-virtual/range v5 ... v11, Lcom/bytedance/trae/utils/logger/FLogger;->uploadALog(Ljava/lang/String; J J Lkotlin/jvm/functions/Function1;)V
    return-void 
    :try_start_0x2
.end method

.method public final report(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.Long  boolean  java.lang.String)void
    .registers 20
    # ins_size=11
    move-object v0, v10
    move-object v1, v11
    move-object v2, v12
    const-string/jumbo v3, result
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v4, source
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v17, +012h
    sget-object v5, Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;
    const-string v6, "cancel_task"
    invoke-virtual/range v17, Ljava/lang/Long;->longValue()J
    move-result-wide v7
    invoke-virtual v5, v6, v7, v8, Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;->shouldUploadAlog(Ljava/lang/String; J)Z
    move-result v5
    if-eqz v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v6, v3, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v6, v4, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "message_status"
    const-string v1, ""
    if-nez v19, +004h
    move-object v3, v1
    goto +3h
    move-object/from16 v3, v19
    invoke-virtual v6, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "biz_code"
    if-nez v17, +004h
    move-object v3, v1
    goto +3h
    move-object/from16 v3, v17
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v6, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, upload_alog
    invoke-virtual v6, v0, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v3, "latency_ms"
    move-wide v7, v15
    invoke-virtual v0, v3, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, task_id
    if-nez v2, +004h
    move-object v7, v1
    goto +2h
    move-object v7, v2
    invoke-virtual v3, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "conversation_id"
    if-nez v13, +004h
    move-object v7, v1
    goto +2h
    move-object v7, v13
    invoke-virtual v3, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "message_id"
    if-nez v14, +003h
    goto +2h
    move-object v1, v14
    invoke-virtual v3, v4, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "is_task_running"
    move/from16 v4, v18
    invoke-virtual v3, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v4, "cancel_task_monitor"
    invoke-virtual v1, v4, v6, v0, v3, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    if-eqz v5, +029h
    if-eqz v17, +027h
    if-eqz v2, +025h
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;->alogUploadedTaskIds Ljava/util/LinkedHashSet;
    invoke-virtual v0, v12, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +01dh
    invoke-virtual v0, Ljava/util/LinkedHashSet;->size()I
    move-result v1
    const/16 v2, 100
    if-le v1, v2, +00ch
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->first(Ljava/lang/Iterable;)Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/util/LinkedHashSet;->remove(Ljava/lang/Object;)Z
    invoke-virtual/range v17, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    move-object v2, v9
    invoke-direct v9, v0, v1, Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;->uploadALog(J)V
    goto +2h
    move-object v2, v9
    return-void 
    :try_start_0x22
    :try_start_0x37
.end method
