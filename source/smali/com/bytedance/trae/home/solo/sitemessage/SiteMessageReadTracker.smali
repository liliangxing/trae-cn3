# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
.super Ljava/lang/Object;
.source "SiteMessageReadTracker.kt"

.field public static final $stable:I
.field private final cacheExpirationDays:J
.field private final debounceInterval:J
.field private debounceRunnable:Ljava/lang/Runnable;
.field private final exposureDuration:J
.field private final gson:Lcom/google/gson/Gson;
.field private final handler:Landroid/os/Handler;
.field private final markedReadIds:Ljava/util/Set;
.field private final maxCachedEvents:I
.field private final pendingEventsKey:Ljava/lang/String;
.field private final pendingReadIds:Ljava/util/Set;
.field private tickRunnable:Ljava/lang/Runnable;
.field private final trackingStartTimes:Ljava/util/Map;


.method public static synthetic $r8$lambda$11JIVEy_EE-ww6a8zAaLAr0tfLQ(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->retryPendingEvents$lambda$11(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$EeFBRTMjcbIX25D4UGtNkoeOKeI(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->flushReadReport$lambda$4(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$_lt5dDHodHRSPDnLijhhxw2kRaU(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->scheduleDebounceFlush$lambda$2(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$fUESx4gJobfTvhTzRu_i_0mWTQ0(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->retryPendingEvents$lambda$10(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    const-wide/16 v0, 5000
    iput-wide v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->exposureDuration J
    const-wide/16 v0, 2000
    iput-wide v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->debounceInterval J
    const/16 v0, 100
    iput v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->maxCachedEvents I
    const-wide/16 v0, 7
    iput-wide v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->cacheExpirationDays J
    const-string v0, "SiteMessage.pendingEvents"
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->pendingEventsKey Ljava/lang/String;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->handler Landroid/os/Handler;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->trackingStartTimes Ljava/util/Map;
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->markedReadIds Ljava/util/Set;
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->pendingReadIds Ljava/util/Set;
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->gson Lcom/google/gson/Gson;
    return-void 
.end method

.method public static final synthetic access$getHandler$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker)android.os.Handler
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->handler Landroid/os/Handler;
    return-object v0
.end method

.method public static final synthetic access$getTrackingStartTimes$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker)java.util.Map
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->trackingStartTimes Ljava/util/Map;
    return-object v0
.end method

.method public static final synthetic access$setTickRunnable$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker  java.lang.Runnable)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->tickRunnable Ljava/lang/Runnable;
    return-void 
.end method

.method public static final synthetic access$tick(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->tick()V
    return-void 
.end method

.method private final cachePendingReadEvents(java.util.List)void
    .registers 8
    # ins_size=2
    invoke-direct v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->loadPendingEvents()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +017h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->intValue()I
    move-result v3
    new-instance v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    const-string v5, "read"
    invoke-direct v4, v3, v5, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;-><init>(I Ljava/lang/String; J)V
    invoke-interface v0, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -1ah
    invoke-direct v6, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->deduplicateAndSave(Ljava/util/List;)V
    return-void 
.end method

.method private final cleanupStaleEvents()void
    .registers 9
    # ins_size=1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iget-wide v2, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->cacheExpirationDays J
    const-wide/32 v4, 86400000
    mul-long/2addr v2, v4
    sub-long/2addr v0, v2
    invoke-direct v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->loadPendingEvents()Ljava/util/List;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +01ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->getTimestamp()J
    move-result-wide v6
    cmp-long v6, v6, v0
    if-ltz v6, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    if-eqz v6, -018h
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v4, Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v0
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v1
    if-eq v0, v1, +005h
    invoke-direct v8, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->savePendingEvents(Ljava/util/List;)V
    return-void 
.end method

.method private final deduplicateAndSave(java.util.List)void
    .registers 8
    # ins_size=2
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    invoke-static v7, Lkotlin/collections/CollectionsKt;->asReversedMutable(Ljava/util/List;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +032h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->getMessageId()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v5, 95
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->getEventType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v3, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -030h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -35h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->reversed(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/util/Collection;
    invoke-static v7, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v7
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v0
    iget v1, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->maxCachedEvents I
    if-le v0, v1, +00ah
    invoke-static v7, v1, Lkotlin/collections/CollectionsKt;->takeLast(Ljava/util/List; I)Ljava/util/List;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->savePendingEvents(Ljava/util/List;)V
    goto +4h
    invoke-direct v6, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->savePendingEvents(Ljava/util/List;)V
    return-void 
.end method

.method private final ensureTickRunning()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->tickRunnable Ljava/lang/Runnable;
    if-eqz v0, +003h
    return-void 
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$ensureTickRunning$runnable$1;
    invoke-direct v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$ensureTickRunning$runnable$1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;)V
    check-cast v0, Ljava/lang/Runnable;
    iput-object v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->tickRunnable Ljava/lang/Runnable;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->handler Landroid/os/Handler;
    const-wide/16 v2, 1000
    invoke-virtual v1, v0, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final flushReadReport$lambda$4(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->cachePendingReadEvents(Ljava/util/List;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final loadPendingEvents()java.util.List
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string/jumbo v1, site_message
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->pendingEventsKey Ljava/lang/String;
    const/4 v2, 0
    invoke-interface v0, v1, v2, Landroid/content/SharedPreferences;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->gson Lcom/google/gson/Gson;
    new-instance v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$loadPendingEvents$1;
    invoke-direct v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$loadPendingEvents$1;-><init>()V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$loadPendingEvents$1;->getType()Ljava/lang/reflect/Type;
    move-result-object v2
    invoke-virtual v1, v0, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v0, Ljava/util/List;
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    :try_start_0x1c
.end method

.method private final removeEvents(java.lang.String  java.util.Set)void
    .registers 8
    # ins_size=3
    invoke-direct v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->loadPendingEvents()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +02bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->getEventType()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +013h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->getMessageId()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v7, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    if-eqz v3, -029h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2eh
    check-cast v1, Ljava/util/List;
    invoke-direct v5, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->savePendingEvents(Ljava/util/List;)V
    return-void 
.end method

.method private static final retryPendingEvents$lambda$10(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v2
    const-string v0, "read"
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->removeEvents(Ljava/lang/String; Ljava/util/Set;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final retryPendingEvents$lambda$11(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v2
    const-string v0, "delete"
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->removeEvents(Ljava/lang/String; Ljava/util/Set;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final savePendingEvents(java.util.List)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string/jumbo v1, site_message
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->pendingEventsKey Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->gson Lcom/google/gson/Gson;
    invoke-virtual v2, v4, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-interface v0, v1, v4, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String; Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v4
    invoke-interface v4, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method

.method private final scheduleDebounceFlush()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->debounceRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->handler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$$ExternalSyntheticLambda3;
    invoke-direct v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;)V
    iput-object v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->debounceRunnable Ljava/lang/Runnable;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->handler Landroid/os/Handler;
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->debounceInterval J
    invoke-virtual v1, v0, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final scheduleDebounceFlush$lambda$2(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker)void
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->flushReadReport()V
    return-void 
.end method

.method private final stopTickIfNeeded()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->trackingStartTimes Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->isEmpty()Z
    move-result v0
    if-eqz v0, +00eh
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->tickRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->handler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->tickRunnable Ljava/lang/Runnable;
    return-void 
.end method

.method private final tick()void
    .registers 11
    # ins_size=1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    iget-object v3, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->trackingStartTimes Ljava/util/Map;
    invoke-interface v3, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v3
    invoke-interface v3, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +02ch
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/Map$Entry;
    invoke-interface v4, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    invoke-interface v4, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->longValue()J
    move-result-wide v6
    sub-long v6, v0, v6
    iget-wide v8, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->exposureDuration J
    cmp-long v4, v6, v8
    if-ltz v4, -026h
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v2, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -2fh
    invoke-interface v2, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +028h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    iget-object v3, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->trackingStartTimes Ljava/util/Map;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v3, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->markedReadIds Ljava/util/Set;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    iget-object v3, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->pendingReadIds Ljava/util/Set;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v3, v1, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    goto -2bh
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +005h
    invoke-direct v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->scheduleDebounceFlush()V
    invoke-direct v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->stopTickIfNeeded()V
    return-void 
.end method

.method public final cachePendingDeleteEvent(int)void
    .registers 7
    # ins_size=2
    invoke-direct v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->loadPendingEvents()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    const-string v2, "delete"
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-direct v1, v6, v2, v3, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;-><init>(I Ljava/lang/String; J)V
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-direct v5, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->deduplicateAndSave(Ljava/util/List;)V
    return-void 
.end method

.method public final clearAll()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->trackingStartTimes Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->clear()V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->markedReadIds Ljava/util/Set;
    invoke-interface v0, Ljava/util/Set;->clear()V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->pendingReadIds Ljava/util/Set;
    invoke-interface v0, Ljava/util/Set;->clear()V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->tickRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->handler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->tickRunnable Ljava/lang/Runnable;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->debounceRunnable Ljava/lang/Runnable;
    if-eqz v1, +007h
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->handler Landroid/os/Handler;
    invoke-virtual v2, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iput-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->debounceRunnable Ljava/lang/Runnable;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-direct v3, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->savePendingEvents(Ljava/util/List;)V
    return-void 
.end method

.method public final flushReadReport()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->debounceRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->handler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-object v0, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->debounceRunnable Ljava/lang/Runnable;
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->pendingReadIds Ljava/util/Set;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->pendingReadIds Ljava/util/Set;
    invoke-interface v0, Ljava/util/Set;->clear()V
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    const-string v3, "read"
    const/4 v4, 0
    new-instance v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$$ExternalSyntheticLambda2;
    invoke-direct v5, v8, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker; Ljava/util/List;)V
    const/4 v6, 4
    const/4 v7, 0
    invoke-static/range v1 ... v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->updateStatus$default(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository; Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final retryPendingEvents()void
    .registers 15
    # ins_size=1
    invoke-direct v14, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->cleanupStaleEvents()V
    invoke-direct v14, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->loadPendingEvents()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +019h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->getEventType()Ljava/lang/String;
    move-result-object v4
    const-string v5, "read"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -017h
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v2, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +014h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->getMessageId()I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    move-object v6, v2
    check-cast v6, Ljava/util/List;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +019h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->getEventType()Ljava/lang/String;
    move-result-object v4
    const-string v5, "delete"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -017h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v0, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +014h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->getMessageId()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v0, Ljava/util/List;
    move-object v1, v6
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +012h
    sget-object v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    const-string v7, "read"
    new-instance v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$$ExternalSyntheticLambda0;
    invoke-direct v8, v14, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker; Ljava/util/List;)V
    const/4 v9, 0
    const/16 v10, 8
    const/4 v11, 0
    invoke-static/range v5 ... v11, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->updateStatus$default(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository; Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)V
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +013h
    sget-object v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    const-string v9, "delete"
    new-instance v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$$ExternalSyntheticLambda1;
    invoke-direct v10, v14, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker; Ljava/util/List;)V
    const/4 v11, 0
    const/16 v12, 8
    const/4 v13, 0
    move-object v8, v0
    invoke-static/range v7 ... v13, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->updateStatus$default(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository; Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final startTracking(int)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->markedReadIds Ljava/util/Set;
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->trackingStartTimes Ljava/util/Map;
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->trackingStartTimes Ljava/util/Map;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-interface v0, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->ensureTickRunning()V
    return-void 
.end method

.method public final stopTracking(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->trackingStartTimes Ljava/util/Map;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->stopTickIfNeeded()V
    return-void 
.end method
