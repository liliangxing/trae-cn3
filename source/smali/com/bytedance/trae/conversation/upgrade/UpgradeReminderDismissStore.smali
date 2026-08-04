# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;
.super Ljava/lang/Object;
.source "UpgradeReminderDismissStore.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;
.field private static final PREF:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;
    invoke-direct v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;->INSTANCE Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final isDismissed(java.lang.String)boolean
    .registers 5
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return v1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string/jumbo v2, upgrade_reminder_dismissed
    invoke-virtual v0, v2, v1, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, v4, v1, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String; Z)Z
    move-result v4
    return v4
.end method

.method public final markDismissed(java.lang.String)void
    .registers 5
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string/jumbo v1, upgrade_reminder_dismissed
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    const/4 v1, 1
    invoke-interface v0, v4, v1, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String; Z)Landroid/content/SharedPreferences$Editor;
    move-result-object v4
    invoke-interface v4, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method
