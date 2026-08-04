# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseDialogHelper;
.super Ljava/lang/Object;
.source "PraiseDialogHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/praise/PraiseDialogHelper;
.field private static final TAG:Ljava/lang/String;
.field private static final settingsUpdateListener:Lcom/bytedance/news/common/settings/SettingsUpdateListener;


.method public static synthetic $r8$lambda$N0kUQjW-IqwNiG1pGM1o5Y3AOjY(com.bytedance.news.common.settings.api.SettingsData)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/praise/PraiseDialogHelper;->settingsUpdateListener$lambda$0(Lcom/bytedance/news/common/settings/api/SettingsData;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogHelper;
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/praise/PraiseDialogHelper;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogHelper;
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogHelper$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogHelper$$ExternalSyntheticLambda0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/praise/PraiseDialogHelper;->settingsUpdateListener Lcom/bytedance/news/common/settings/SettingsUpdateListener;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final registerCustomDialogCallback()void
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/praisedialoglib/manager/PraiseDialogCfgManager;->getInstance()Lcom/bytedance/praisedialoglib/manager/PraiseDialogCfgManager;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1;
    invoke-direct v1, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1;-><init>()V
    check-cast v1, Lcom/bytedance/praisedialoglib/callback/IPraiseDialogActionCallback;
    invoke-virtual v0, v1, Lcom/bytedance/praisedialoglib/manager/PraiseDialogCfgManager;->setIPraiseDialogActionCallback(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogActionCallback;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "Praise"
    const-string/jumbo v2, registerCustomDialogCallback: callback registered
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private static final settingsUpdateListener$lambda$0(com.bytedance.news.common.settings.api.SettingsData)void
    .registers 3
    # ins_size=1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "Praise"
    const-string/jumbo v1, settings updated, refreshing SDK config
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/praise/PraiseDialogHelper;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogHelper;
    invoke-virtual v2, Lcom/bytedance/trae/praise/PraiseDialogHelper;->updateSdkSettings$praise_mainlandRelease()V
    return-void 
.end method

.method public static synthetic tryShowDialog$default(com.bytedance.trae.praise.PraiseDialogHelper  long  long  android.content.Context  java.lang.String  int  java.lang.Object)void
    .registers 19
    # ins_size=9
    and-int/lit8 v0, v17, 1
    const-wide/16 v1, 0
    if-eqz v0, +004h
    move-wide v4, v1
    goto +2h
    move-wide v4, v11
    and-int/lit8 v0, v17, 2
    if-eqz v0, +004h
    move-wide v6, v1
    goto +2h
    move-wide v6, v13
    move-object v3, v10
    move-object v8, v15
    move-object/from16 v9, v16
    invoke-virtual/range v3 ... v9, Lcom/bytedance/trae/praise/PraiseDialogHelper;->tryShowDialog(J J Landroid/content/Context; Ljava/lang/String;)V
    return-void 
.end method

.method public final initSettings(org.json.JSONObject)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, settingsJson
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/praisedialoglib/manager/PraiseDialogCfgManager;->getInstance()Lcom/bytedance/praisedialoglib/manager/PraiseDialogCfgManager;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/praisedialoglib/manager/PraiseDialogCfgManager;->setAppData(Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final onTaskDoneAndTryShow(android.content.Context  java.lang.String)void
    .registers 15
    # ins_size=3
    const-string v1, "context"
    invoke-static v13, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "from"
    invoke-static v14, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-virtual v1, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->isEnabled()Z
    move-result v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, onTaskDoneAndTryShow: enabled=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", from="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v10, "Praise"
    invoke-virtual v2, v10, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    if-nez v1, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-virtual v1, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->onTaskDone()V
    sget-object v1, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-virtual v1, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->shouldShow()Z
    move-result v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v11, onTaskDoneAndTryShow: shouldShow=
    invoke-direct v3, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v10, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v1, +016h
    const-wide/16 v2, 0
    const-wide/16 v4, 1000
    const/4 v8, 1
    const/4 v9, 0
    move-object v1, v12
    move-object v6, v13
    move-object v7, v14
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/praise/PraiseDialogHelper;->tryShowDialog$default(Lcom/bytedance/trae/praise/PraiseDialogHelper; J J Landroid/content/Context; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +8h
    move-exception v0
    move-object v1, v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v0, v10, v11, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x5f
.end method

.method public final registerSettingsListener()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/praise/PraiseDialogHelper;->settingsUpdateListener Lcom/bytedance/news/common/settings/SettingsUpdateListener;
    const/4 v1, 1
    invoke-static v0, v1, Lcom/bytedance/news/common/settings/SettingsManager;->registerListener(Lcom/bytedance/news/common/settings/SettingsUpdateListener; Z)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "Praise"
    const-string/jumbo v2, registerSettingsListener
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/praise/PraiseDialogHelper;->updateSdkSettings$praise_mainlandRelease()V
    invoke-direct v3, Lcom/bytedance/trae/praise/PraiseDialogHelper;->registerCustomDialogCallback()V
    return-void 
.end method

.method public final setHasTaskHistory(boolean)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-virtual v0, v2, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->setOldUser(Z)V
    return-void 
.end method

.method public final showDirectly(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "from"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-static Lcom/bytedance/praisedialoglib/manager/PraiseDialogManager;->getInstance()Lcom/bytedance/praisedialoglib/manager/PraiseDialogManager;
    move-result-object v1
    check-cast v0, Landroid/content/Context;
    invoke-virtual v1, v0, v3, Lcom/bytedance/praisedialoglib/manager/PraiseDialogManager;->showPraiseDialogDirectly(Landroid/content/Context; Ljava/lang/String;)V
    return-void 
.end method

.method public final tryShowDialog(long  long  android.content.Context  java.lang.String)void
    .registers 15
    # ins_size=7
    const-string v0, "context"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "from"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-eqz v0, +010h
    invoke-static Lcom/bytedance/praisedialoglib/manager/PraiseDialogManager;->getInstance()Lcom/bytedance/praisedialoglib/manager/PraiseDialogManager;
    move-result-object v1
    move-object v6, v0
    check-cast v6, Landroid/content/Context;
    move-wide v2, v9
    move-wide v4, v11
    move-object v7, v14
    invoke-virtual/range v1 ... v7, Lcom/bytedance/praisedialoglib/manager/PraiseDialogManager;->tryShowDialog(J J Landroid/content/Context; Ljava/lang/String;)V
    goto +ch
    invoke-static Lcom/bytedance/praisedialoglib/manager/PraiseDialogManager;->getInstance()Lcom/bytedance/praisedialoglib/manager/PraiseDialogManager;
    move-result-object v1
    move-wide v2, v9
    move-wide v4, v11
    move-object v6, v13
    move-object v7, v14
    invoke-virtual/range v1 ... v7, Lcom/bytedance/praisedialoglib/manager/PraiseDialogManager;->tryShowDialog(J J Landroid/content/Context; Ljava/lang/String;)V
    return-void 
.end method

.method public final unregisterSettingsListener()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/praise/PraiseDialogHelper;->settingsUpdateListener Lcom/bytedance/news/common/settings/SettingsUpdateListener;
    invoke-static v0, Lcom/bytedance/news/common/settings/SettingsManager;->unregisterListener(Lcom/bytedance/news/common/settings/SettingsUpdateListener;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "Praise"
    const-string/jumbo v2, unregisterSettingsListener
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final updateSdkSettings$praise_mainlandRelease()void
    .registers 10
    # ins_size=1
    const-string v0, "Praise"
    const-string/jumbo v1, updateSdkSettings: enable=
    const-class v2, Lcom/bytedance/trae/praise/IPraiseSettings;
    invoke-static v2, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    const-string/jumbo v3, obtain(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/praise/IPraiseSettings;
    invoke-interface v2, Lcom/bytedance/trae/praise/IPraiseSettings;->getAndroidAppRating()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +00fh
    const-string v3, "enable"
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v3
    goto +2h
    const/4 v3, 0
    const-string v4, "app_market_order"
    const-string v5, ""
    if-eqz v2, +00eh
    invoke-virtual v2, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +008h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v5
    const-string v7, "market_feedback_url"
    if-eqz v2, +010h
    invoke-virtual v2, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +00ah
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v5, v2
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v8, "market_feedback_dialog_enable"
    invoke-virtual v2, v8, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    invoke-virtual v2, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v2, v7, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v9, v2, Lcom/bytedance/trae/praise/PraiseDialogHelper;->initSettings(Lorg/json/JSONObject;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", appMarketOrder="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", marketFeedbackUrl="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +1bh
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, updateSdkSettings: exception 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x5
    :try_start_0x2d
    :try_start_0x3e
.end method
