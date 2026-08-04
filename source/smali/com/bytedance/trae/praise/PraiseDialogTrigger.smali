# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseDialogTrigger;
.super Ljava/lang/Object;
.source "PraiseDialogTrigger.kt"

.field public static final DEFAULT_ENABLE:Z
.field public static final DEFAULT_IGNORE_UG_RULE:Z
.field public static final DEFAULT_MAX_SHOW_COUNT:I
.field public static final DEFAULT_REFUSE_BLOCK_TIME_HOURS:J
.field public static final DEFAULT_TASK_THRESHOLD:I
.field public static final INSTANCE:Lcom/bytedance/trae/praise/PraiseDialogTrigger;
.field private static final KEY_IS_OLD_USER:Ljava/lang/String;
.field private static final KEY_LAST_SHOW_DATE:Ljava/lang/String;
.field private static final KEY_LATER_TIMESTAMP:Ljava/lang/String;
.field private static final KEY_SHOW_COUNT:Ljava/lang/String;
.field private static final KEY_TASK_DONE_COUNT:Ljava/lang/String;
.field private static final ONE_DAY_MILLIS:J
.field private static final ONE_HOUR_MILLIS:J
.field private static final SP_NAME:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final sp$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$erkjlxjQDBLHb2tPN2GgZdCHwoY()android.content.SharedPreferences
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/praise/PraiseDialogTrigger;->sp_delegate$lambda$0()Landroid/content/SharedPreferences;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;-><init>()V
    sput-object v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->sp$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getBoolean(com.google.gson.JsonObject  java.lang.String  boolean)boolean
    .registers 4
    # ins_size=4
    invoke-virtual v1, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v3
    return v3
.end method

.method private final getConfig()com.bytedance.trae.praise.PraiseRatingConfig
    .registers 12
    # ins_size=1
    const-string v0, "Praise"
    const-string v1, "config loaded: "
    const-class v2, Lcom/bytedance/trae/praise/IPraiseSettings;
    invoke-static v2, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    const-string/jumbo v3, obtain(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/praise/IPraiseSettings;
    invoke-interface v2, Lcom/bytedance/trae/praise/IPraiseSettings;->getAndroidAppRating()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +040h
    new-instance v10, Lcom/bytedance/trae/praise/PraiseRatingConfig;
    const-string v3, "enable"
    const/4 v4, 0
    invoke-direct v11, v2, v3, v4, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String; Z)Z
    move-result v4
    const-string v3, "least_chat_times_before_trigger"
    const/4 v5, 3
    invoke-direct v11, v2, v3, v5, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getInt(Lcom/google/gson/JsonObject; Ljava/lang/String; I)I
    move-result v5
    const-string v3, "max_count"
    const/4 v6, 2
    invoke-direct v11, v2, v3, v6, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getInt(Lcom/google/gson/JsonObject; Ljava/lang/String; I)I
    move-result v6
    const-string/jumbo v3, refuse_block_time_hours
    const-wide/16 v7, 168
    invoke-direct v11, v2, v3, v7, v8, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getLong(Lcom/google/gson/JsonObject; Ljava/lang/String; J)J
    move-result-wide v7
    const-string v3, "ignore_ug_rule"
    const/4 v9, 1
    invoke-direct v11, v2, v3, v9, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String; Z)Z
    move-result v9
    move-object v3, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/praise/PraiseRatingConfig;-><init>(Z I I J Z)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +2eh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "config: android_app_rating_v1 is null, using DEFAULT"
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/praise/PraiseRatingConfig;->Companion Lcom/bytedance/trae/praise/PraiseRatingConfig$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/praise/PraiseRatingConfig$Companion;->getDEFAULT()Lcom/bytedance/trae/praise/PraiseRatingConfig;
    move-result-object v10
    goto +20h
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "config: exception "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->Companion Lcom/bytedance/trae/praise/PraiseRatingConfig$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig$Companion;->getDEFAULT()Lcom/bytedance/trae/praise/PraiseRatingConfig;
    move-result-object v10
    return-object v10
    :try_start_0x4
.end method

.method private final getInt(com.google.gson.JsonObject  java.lang.String  int)int
    .registers 4
    # ins_size=4
    invoke-virtual v1, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v3
    return v3
.end method

.method private final getLong(com.google.gson.JsonObject  java.lang.String  long)long
    .registers 5
    # ins_size=5
    invoke-virtual v1, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsLong()J
    move-result-wide v3
    return-wide v3
.end method

.method private final getSp()android.content.SharedPreferences
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->sp$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/content/SharedPreferences;
    return-object v0
.end method

.method private final isOldUser()boolean
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v0
    const-string v1, "is_old_user"
    const/4 v2, 0
    invoke-interface v0, v1, v2, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method private final isSameDay(long  long)boolean
    .registers 9
    # ins_size=5
    const-wide/16 v0, 0
    cmp-long v0, v5, v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    const-wide/32 v2, 86400000
    div-long/2addr v5, v2
    div-long/2addr v7, v2
    cmp-long v5, v5, v7
    if-nez v5, +003h
    const/4 v1, 1
    return v1
.end method

.method private static final sp_delegate$lambda$0()android.content.SharedPreferences
    .registers 3
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string/jumbo v1, trae_praise_dialog
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    return-object v0
.end method

.method public final isEnabled()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getConfig()Lcom/bytedance/trae/praise/PraiseRatingConfig;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->getEnable()Z
    move-result v0
    return v0
.end method

.method public final isIgnoreUgRule()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getConfig()Lcom/bytedance/trae/praise/PraiseRatingConfig;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->getIgnoreUgRule()Z
    move-result v0
    return v0
.end method

.method public final isOldUserDetermined()boolean
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v0
    const-string v1, "is_old_user"
    invoke-interface v0, v1, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public final onDialogShown()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v0
    const/4 v1, 0
    const-string/jumbo v2, show_count
    invoke-interface v0, v2, v1, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String; I)I
    move-result v0
    add-int/lit8 v0, v0, 1
    invoke-direct v4, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v1
    invoke-interface v1, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    invoke-interface v1, v2, v0, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String; I)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    const-string v1, "last_show_date"
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-interface v0, v1, v2, v3, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String; J)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method

.method public final onLaterClicked()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    const-string v1, "later_timestamp"
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-interface v0, v1, v2, v3, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String; J)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method

.method public final onRateClicked()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getConfig()Lcom/bytedance/trae/praise/PraiseRatingConfig;
    move-result-object v0
    invoke-direct v3, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v1
    invoke-interface v1, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    const-string/jumbo v2, show_count
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->getMaxCount()I
    move-result v0
    invoke-interface v1, v2, v0, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String; I)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method

.method public final onTaskDone()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v0
    const/4 v1, 0
    const-string/jumbo v2, task_done_count
    invoke-interface v0, v2, v1, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String; I)I
    move-result v0
    add-int/lit8 v0, v0, 1
    invoke-direct v3, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v1
    invoke-interface v1, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    invoke-interface v1, v2, v0, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String; I)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method

.method public final setOldUser(boolean)void
    .registers 5
    # ins_size=2
    invoke-direct v3, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    const-string v1, "is_old_user"
    invoke-interface v0, v1, v4, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String; Z)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences$Editor;->apply()V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, setOldUser: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "Praise"
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final shouldShow()boolean
    .registers 15
    # ins_size=1
    invoke-direct v14, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getConfig()Lcom/bytedance/trae/praise/PraiseRatingConfig;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->getEnable()Z
    move-result v1
    const-string v2, "Praise"
    const/4 v3, 0
    if-nez v1, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v1, shouldShow: NO - disabled by config
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v3
    invoke-direct v14, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v1
    const-string/jumbo v4, show_count
    invoke-interface v1, v4, v3, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String; I)I
    move-result v1
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->getMaxCount()I
    move-result v4
    if-lt v1, v4, +02ch
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v6, shouldShow: NO - showCount(
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, ") >= maxCount("
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->getMaxCount()I
    move-result v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v3
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-direct v14, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v6
    const-string v7, "later_timestamp"
    const-wide/16 v8, 0
    invoke-interface v6, v7, v8, v9, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String; J)J
    move-result-wide v6
    cmp-long v10, v6, v8
    if-lez v10, +03bh
    sub-long v6, v4, v6
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->getRefuseBlockTimeHours()J
    move-result-wide v10
    const-wide/32 v12, 3600000
    mul-long/2addr v10, v12
    cmp-long v10, v6, v10
    if-gez v10, +02dh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, shouldShow: NO - in cooldown, elapsed=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    div-long/2addr v6, v12
    invoke-virtual v4, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "h, need="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->getRefuseBlockTimeHours()J
    move-result-wide v5
    invoke-virtual v4, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v4, 104
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v3
    invoke-direct v14, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v6
    const-string v7, "last_show_date"
    invoke-interface v6, v7, v8, v9, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String; J)J
    move-result-wide v6
    invoke-direct v14, v6, v7, v4, v5, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->isSameDay(J J)Z
    move-result v4
    if-eqz v4, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v1, shouldShow: NO - already shown today
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v3
    invoke-direct v14, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->getSp()Landroid/content/SharedPreferences;
    move-result-object v4
    const-string/jumbo v5, task_done_count
    invoke-interface v4, v5, v3, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String; I)I
    move-result v4
    invoke-direct v14, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->isOldUser()Z
    move-result v5
    const/4 v6, 1
    if-eqz v5, +005h
    if-lt v4, v6, +00ah
    goto +7h
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->getLeastChatTimesBeforeTrigger()I
    move-result v7
    if-lt v4, v7, +003h
    move v3, v6
    const-string v7, ", oldUser="
    if-nez v3, +031h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string/jumbo v9, shouldShow: NO - taskDoneCount=
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, ", threshold="
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    if-eqz v5, +003h
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->getLeastChatTimesBeforeTrigger()I
    move-result v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +28h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v8, shouldShow: YES - taskDoneCount=
    invoke-direct v6, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", showCount="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v3
.end method
