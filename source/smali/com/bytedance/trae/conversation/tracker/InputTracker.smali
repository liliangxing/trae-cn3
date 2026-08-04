# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/InputTracker;
.super Ljava/lang/Object;
.source "InputTracker.kt"

.field private static final EVENT_ATTACHMENT_CLICK:Ljava/lang/String;
.field private static final EVENT_MODE_SWITCH_CLICK:Ljava/lang/String;
.field private static final EVENT_SELECT_REPOSITORY_CLICK:Ljava/lang/String;
.field private static final EVENT_SHOWCASE_CLICK:Ljava/lang/String;
.field private static final EVENT_SHOWCASE_SHOW:Ljava/lang/String;
.field private static final EVENT_SKILLS_PANEL_SHOW:Ljava/lang/String;
.field private static final EVENT_SKILL_SELECT_CLICK:Ljava/lang/String;
.field private static final EVENT_VOICE_INPUT_CLICK:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/InputTracker;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final trackAttachmentClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v0, "icube_attachment_click"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x6
.end method

.method public final trackConversationMenuItemClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "action"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v0, "icube_menu_action_click"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x5
.end method

.method public final trackMenuClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, task_id
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_menu_click"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x6
.end method

.method public final trackModeSwitchClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v0, "icube_mode_switch_click"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x6
.end method

.method public final trackSelectRepositoryClick(int)void
    .registers 4
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "is_select"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_select_repository_click"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
.end method

.method public final trackShowcaseClick(int  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, showcaseId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "position"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v3, showcase_id
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v4, "icube_showcase_click"
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x6
.end method

.method public final trackShowcaseShow(int)void
    .registers 4
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "item_count"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_showcase_show"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
.end method

.method public final trackSkillSelectClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, skillName
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, skill_name
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_skill_select_click"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x6
.end method

.method public final trackSkillsPanelShow(int)void
    .registers 4
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, skill_count
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_skills_panel_show"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
.end method

.method public final trackVoiceInputClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "currentPage"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "current_page"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_voice_input_click"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x5
.end method
