# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/privacy/PrivacyCache;
.super Ljava/lang/Object;
.source "PrivacyCache.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/privacy/PrivacyCache;
.field private static final KEY_CLICK_ACCEPT_TIME:Ljava/lang/String;
.field private static final KEY_CLICK_CANCEL_TIME:Ljava/lang/String;
.field private static final KEY_SHOW_TIME:Ljava/lang/String;
.field private static final PREF_NAME:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/privacy/PrivacyCache;
    invoke-direct v0, Lcom/bytedance/trae/home/privacy/PrivacyCache;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/privacy/PrivacyCache;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyCache;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getPrefs(android.content.Context)android.content.SharedPreferences
    .registers 4
    # ins_size=2
    const-string v0, "privacy_cache"
    const/4 v1, 4
    invoke-virtual v3, v0, v1, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v3
    const-string v0, "getSharedPreferences(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method public final savePrivacyWindowClick(android.content.Context  boolean)void
    .registers 6
    # ins_size=3
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/home/privacy/PrivacyCache;->getPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;
    move-result-object v4
    if-eqz v5, +005h
    const-string v5, "privacy_window_click_accept_time"
    goto +3h
    const-string v5, "privacy_window_click_cancel_time"
    const-string v0, ""
    invoke-interface v4, v5, v0, Landroid/content/SharedPreferences;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v0, v1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v1
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +003h
    goto +18h
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v2, 44
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-interface v4, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v4
    invoke-interface v4, v5, v1, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String; Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v4
    invoke-interface v4, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method

.method public final savePrivacyWindowShow(android.content.Context)void
    .registers 6
    # ins_size=2
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v5, Lcom/bytedance/trae/home/privacy/PrivacyCache;->getPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;
    move-result-object v5
    const-string v0, "privacy_window_show_time"
    const-string v1, ""
    invoke-interface v5, v0, v1, Landroid/content/SharedPreferences;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v1, v2
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-static v2, v3, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v2
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    goto +18h
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v3, 44
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-interface v5, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v5
    invoke-interface v5, v0, v2, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String; Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v5
    invoke-interface v5, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method
