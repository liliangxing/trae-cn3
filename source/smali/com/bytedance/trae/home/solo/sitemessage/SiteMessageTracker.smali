# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
.super Ljava/lang/Object;
.source "SiteMessageTracker.kt"

.field public static final $stable:I
.field private static final EVENT_CTA_CLICK:Ljava/lang/String;
.field private static final EVENT_ENTRY_CLICK:Ljava/lang/String;
.field private static final EVENT_ITEM_CLICK:Ljava/lang/String;
.field private static final EVENT_ITEM_DELETE:Ljava/lang/String;
.field private static final EVENT_LIST_PAGE_VIEW:Ljava/lang/String;
.field private static final EVENT_SETTINGS_PAGE_VIEW:Ljava/lang/String;
.field private static final EVENT_SETTINGS_TOGGLE:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final report(java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=3
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-interface v4, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v4
    if-eqz v4, +021h
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v1, reportEvent: 
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v1, ", params: "
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "SiteMessageTracker"
    invoke-static v1, v4, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackCtaClick(int  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=4
    const-string v0, "buttonLabel"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string v2, "message_id"
    invoke-virtual v1, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v4, "button_label"
    invoke-virtual v1, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, v0, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v4
    if-eqz v4, +017h
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, reportEvent: icube_notification_cta_click, params: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "SiteMessageTracker"
    invoke-static v5, v4, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v5, "icube_notification_cta_click"
    invoke-virtual v4, v5, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackEntryClick(boolean)void
    .registers 4
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "has_unread"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v1, reportEvent: icube_notification_entry_click, params: 
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v1, "SiteMessageTracker"
    invoke-static v1, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_notification_entry_click"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackItemClick(int  java.lang.String  boolean  int)void
    .registers 7
    # ins_size=5
    const-string v0, "messageType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "message_id"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v3, "message_type"
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "is_read"
    invoke-virtual v0, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    const-string v3, "position"
    invoke-virtual v0, v3, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, reportEvent: icube_notification_item_click, params: 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "SiteMessageTracker"
    invoke-static v4, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v4, "icube_notification_item_click"
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackItemDelete(int  int)void
    .registers 5
    # ins_size=3
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "message_id"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v3, "position"
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, reportEvent: icube_notification_item_delete, params: 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "SiteMessageTracker"
    invoke-static v4, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v4, "icube_notification_item_delete"
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackListPageView(int  int)void
    .registers 5
    # ins_size=3
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "item_count"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v3, unread_count
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, reportEvent: icube_notification_list_page_view, params: 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "SiteMessageTracker"
    invoke-static v4, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v4, "icube_notification_list_page_view"
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackSettingsPageView()void
    .registers 4
    # ins_size=1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v1
    if-eqz v1, +017h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, reportEvent: icube_notification_settings_page_view, params: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "SiteMessageTracker"
    invoke-static v2, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v2, "icube_notification_settings_page_view"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackSettingsToggle(java.lang.String  boolean)void
    .registers 5
    # ins_size=3
    const-string v0, "key"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "enabled"
    invoke-virtual v1, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, reportEvent: icube_notification_settings_toggle, params: 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "SiteMessageTracker"
    invoke-static v4, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v4, "icube_notification_settings_toggle"
    invoke-virtual v3, v4, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method
