# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
.super Ljava/lang/Object;
.source "SettingsTracker.kt"

.field public static final $stable:I
.field public static final BINDING_ACTION_BIND:Ljava/lang/String;
.field public static final BINDING_ACTION_CHANGE:Ljava/lang/String;
.field public static final BINDING_ACTION_UNBIND:Ljava/lang/String;
.field public static final BINDING_TYPE_DOUYIN:Ljava/lang/String;
.field public static final BINDING_TYPE_PHONE:Ljava/lang/String;
.field private static final EVENT_ACCOUNT_BINDING_CLICK:Ljava/lang/String;
.field private static final EVENT_ACCOUNT_BINDING_RESULT:Ljava/lang/String;
.field private static final EVENT_DEVICE_MANAGEMENT_PAGE_VIEW:Ljava/lang/String;
.field private static final EVENT_DEVICE_REMOVE_CLICK:Ljava/lang/String;
.field private static final EVENT_LANGUAGE_SWITCH_CLICK:Ljava/lang/String;
.field private static final EVENT_LOGOUT_CLICK:Ljava/lang/String;
.field private static final EVENT_SETTINGS_CLICK:Ljava/lang/String;
.field private static final EVENT_SETTINGS_PAGE_VIEW:Ljava/lang/String;
.field private static final EVENT_THEME_SWITCH_CLICK:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
.field public static final RESULT_FAIL:Ljava/lang/String;
.field public static final RESULT_SUCCESS:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field public static final TYPE_ABOUT:Ljava/lang/String;
.field public static final TYPE_ACCOUNT:Ljava/lang/String;
.field public static final TYPE_CONNECTORS:Ljava/lang/String;
.field public static final TYPE_DEVICE_MANAGEMENT:Ljava/lang/String;
.field public static final TYPE_LANGUAGE:Ljava/lang/String;
.field public static final TYPE_NOTIFICATION:Ljava/lang/String;
.field public static final TYPE_THEME:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
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
    const-string v1, "SettingsTracker"
    invoke-static v1, v4, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static synthetic trackAccountBindingResult$default(com.bytedance.trae.home.solo.setting.SettingsTracker  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  int  java.lang.Object)void
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 8
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v11, v13, 16
    if-eqz v11, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingResult(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic trackSettingsPageView$default(com.bytedance.trae.home.solo.setting.SettingsTracker  java.lang.String  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +005h
    const-string/jumbo v1, task_list
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsPageView(Ljava/lang/String;)V
    return-void 
.end method

.method public final trackAccountBindingClick(java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, type
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "action"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "current_page"
    const-string/jumbo v4, settings
    invoke-virtual v2, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v2, v0, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v2, v1, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v6
    if-eqz v6, +017h
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v7, reportEvent: icube_account_binding_click, params: 
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v7, "SettingsTracker"
    invoke-static v7, v6, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v7, "icube_account_binding_click"
    invoke-virtual v6, v7, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackAccountBindingResult(java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String)void
    .registers 12
    # ins_size=6
    const-string/jumbo v0, type
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "action"
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, result
    invoke-static v9, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string v4, "current_page"
    const-string/jumbo v5, settings
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v0, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v1, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v2, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v10, +011h
    check-cast v10, Ljava/lang/Number;
    invoke-virtual v10, Ljava/lang/Number;->intValue()I
    move-result v7
    const-string v8, "error_code"
    invoke-static v7, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, v8, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v11, +007h
    const-string v7, "fail_reason"
    invoke-virtual v3, v7, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v7
    if-eqz v7, +017h
    new-instance v7, Ljava/lang/StringBuilder;
    const-string/jumbo v8, reportEvent: icube_account_binding_result, params: 
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v8, "SettingsTracker"
    invoke-static v8, v7, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v7, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v8, "icube_account_binding_result"
    invoke-virtual v7, v8, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackDeviceManagementPageView(int)void
    .registers 4
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "device_count"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v1, reportEvent: device_management_page_view, params: 
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v1, "SettingsTracker"
    invoke-static v1, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "device_management_page_view"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackDeviceRemoveClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "deviceId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "device_id"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v1, reportEvent: icube_device_remove_click, params: 
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v1, "SettingsTracker"
    invoke-static v1, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_device_remove_click"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackLanguageSwitchClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v0, reportEvent: icube_language_switch_click, params: 
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "SettingsTracker"
    invoke-static v0, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v0, "icube_language_switch_click"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackLogoutClick()void
    .registers 4
    # ins_size=1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "current_page"
    const-string/jumbo v2, settings
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v1
    if-eqz v1, +017h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, reportEvent: icube_logout_click, params: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "SettingsTracker"
    invoke-static v2, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v2, "icube_logout_click"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackSettingsClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v0, reportEvent: icube_settings_click, params: 
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "SettingsTracker"
    invoke-static v0, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v0, "icube_settings_click"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackSettingsPageView(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "enterFrom"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "enter_from"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v1, reportEvent: settings_page_view, params: 
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v1, "SettingsTracker"
    invoke-static v1, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v1, settings_page_view
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackThemeSwitchClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-eqz v3, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v0, reportEvent: icube_theme_switch_click, params: 
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "SettingsTracker"
    invoke-static v0, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v0, "icube_theme_switch_click"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method
