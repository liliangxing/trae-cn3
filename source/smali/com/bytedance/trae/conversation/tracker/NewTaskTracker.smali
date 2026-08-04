# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;
.super Ljava/lang/Object;
.source "NewTaskTracker.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic trackTaskListPageView$default(com.bytedance.trae.conversation.tracker.NewTaskTracker  int  java.lang.String  int  int  int  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 2
    if-eqz v13, +004h
    const-string v8, ""
    move-object v2, v8
    and-int/lit8 v8, v12, 4
    const/4 v13, 0
    if-eqz v8, +004h
    move v3, v13
    goto +2h
    move v3, v9
    and-int/lit8 v8, v12, 8
    if-eqz v8, +004h
    move v4, v13
    goto +2h
    move v4, v10
    and-int/lit8 v8, v12, 16
    if-eqz v8, +004h
    move v5, v13
    goto +2h
    move v5, v11
    move-object v0, v6
    move v1, v7
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskListPageView(I Ljava/lang/String; I I I)V
    return-void 
.end method

.method public final trackPageView(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "enterFrom"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "enter_from"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "new_task_page_view"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackTaskCardClick(java.lang.String  java.lang.String  int)void
    .registers 6
    # ins_size=4
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskStatus
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, task_id
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, task_status
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "position"
    invoke-virtual v0, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v4, "icube_task_card_click"
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackTaskCardSlide(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, task_id
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_task_card_slide"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackTaskDeleteClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, task_id
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_task_delete_click"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackTaskDetailPageView(java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=4
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskStatus
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, task_id
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, task_status
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "enter_from"
    invoke-virtual v0, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v4, task_detail_page_view
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackTaskListPageView(int  java.lang.String  int  int  int)void
    .registers 8
    # ins_size=6
    const-string/jumbo v0, showType
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, task_count
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v3, "ide_task_count"
    invoke-virtual v0, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v3, "pc_task_count"
    invoke-virtual v0, v3, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v3, "remote_task_count"
    invoke-virtual v0, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    move-object v3, v4
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +008h
    const-string/jumbo v3, show_type
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v4, task_list_page_view
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackTaskRenameClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, task_id
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_task_rename_click"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method
