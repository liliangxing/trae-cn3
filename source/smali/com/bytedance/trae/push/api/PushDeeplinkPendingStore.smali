# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;
.super Ljava/lang/Object;
.source "PushDeeplinkPendingStore.kt"

.field private static final EXPIRE_MS:J
.field public static final INSTANCE:Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;
.field private static final KEY_PENDING_URI:Ljava/lang/String;
.field private static final KEY_SAVED_AT:Ljava/lang/String;
.field private static final SP_NAME:Ljava/lang/String;
.field private static bridge sp:Landroid/content/SharedPreferences;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;
    invoke-direct v0, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;-><init>()V
    sput-object v0, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;->INSTANCE Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getSp(android.content.Context)android.content.SharedPreferences
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;->sp Landroid/content/SharedPreferences;
    if-nez v0, +015h
    invoke-virtual v3, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v3
    const-string/jumbo v0, push_deeplink_pending
    const/4 v1, 0
    invoke-virtual v3, v0, v1, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;->sp Landroid/content/SharedPreferences;
    const-string v3, "also(...)"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public final clear(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;->getSp(Landroid/content/Context;)Landroid/content/SharedPreferences;
    move-result-object v2
    invoke-interface v2, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    const-string/jumbo v0, pending_uri
    invoke-interface v2, v0, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    const-string/jumbo v0, saved_at
    invoke-interface v2, v0, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    invoke-interface v2, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method

.method public final consumeIfPresent(android.content.Context)android.net.Uri
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, v8, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;->getSp(Landroid/content/Context;)Landroid/content/SharedPreferences;
    move-result-object v8
    const-string/jumbo v0, pending_uri
    const/4 v1, 0
    invoke-interface v8, v0, v1, Landroid/content/SharedPreferences;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    return-object v1
    const-wide/16 v3, 0
    const-string/jumbo v5, saved_at
    invoke-interface v8, v5, v3, v4, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String; J)J
    move-result-wide v3
    invoke-interface v8, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v8
    invoke-interface v8, v0, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v8
    invoke-interface v8, v5, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v8
    invoke-interface v8, Landroid/content/SharedPreferences$Editor;->apply()V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    sub-long/2addr v5, v3
    const-wide/16 v3, 2000
    cmp-long v8, v5, v3
    if-lez v8, +003h
    return-object v1
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    return-object v1
    :try_start_0x38
.end method

.method public final save(android.content.Context  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, uriString
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;->getSp(Landroid/content/Context;)Landroid/content/SharedPreferences;
    move-result-object v3
    invoke-interface v3, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v3
    const-string/jumbo v0, pending_uri
    invoke-interface v3, v0, v4, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String; Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v3
    const-string/jumbo v4, saved_at
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-interface v3, v4, v0, v1, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String; J)Landroid/content/SharedPreferences$Editor;
    move-result-object v3
    invoke-interface v3, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method
