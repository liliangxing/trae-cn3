# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
.super Ljava/lang/Object;
.source "VoicePromptCenter.kt"

.field private static final DEFAULT_DURATION_MS:J
.field private static final FADE_TOTAL_MS:J
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
.field private static currentType:Ljava/lang/Class;
.field private static final lastEmitAtByType:Ljava/util/concurrent/ConcurrentHashMap;
.field private static latestContainer:Landroid/view/ViewGroup;
.field private static final mainHandler:Landroid/os/Handler;
.field private static nextPromptRunnable:Ljava/lang/Runnable;
.field private static final queue:Ljava/util/PriorityQueue;


.method public static synthetic $r8$lambda$aQNIHTwWmdGUq4-oR8eb-RHmWlM()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->showNext$lambda$1()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
    new-instance v0, Ljava/util/PriorityQueue;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter$special$$inlined$compareByDescending$1;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter$special$$inlined$compareByDescending$1;-><init>()V
    check-cast v1, Ljava/util/Comparator;
    const/16 v2, 8
    invoke-direct v0, v2, v1, Ljava/util/PriorityQueue;-><init>(I Ljava/util/Comparator;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->queue Ljava/util/PriorityQueue;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->lastEmitAtByType Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->mainHandler Landroid/os/Handler;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final isAlreadyPending(com.bytedance.trae.conversation.brainstorm.health.VoicePrompt)boolean
    .registers 7
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->currentType Ljava/lang/Class;
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +003h
    return v1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->queue Ljava/util/PriorityQueue;
    check-cast v0, Ljava/lang/Iterable;
    instance-of v2, v0, Ljava/util/Collection;
    const/4 v3, 0
    if-eqz v2, +00dh
    move-object v2, v0
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move v1, v3
    goto +1fh
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, -00ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    invoke-virtual v2, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -018h
    return v1
.end method

.method private final recordEmit(com.bytedance.trae.conversation.brainstorm.health.VoicePrompt)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->lastEmitAtByType Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v0, Ljava/util/Map;
    invoke-virtual v4, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v4
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-interface v0, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final shouldEmit(com.bytedance.trae.conversation.brainstorm.health.VoicePrompt)boolean
    .registers 6
    # ins_size=2
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->lastEmitAtByType Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v5, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Long;
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v2
    goto +3h
    const-wide/16 v2, 0
    sub-long/2addr v0, v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;->getThrottleMs()J
    move-result-wide v2
    cmp-long v5, v0, v2
    if-ltz v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    return v5
.end method

.method private final showNext()void
    .registers 13
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->queue Ljava/util/PriorityQueue;
    invoke-virtual v0, Ljava/util/PriorityQueue;->poll()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    if-nez v0, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->latestContainer Landroid/view/ViewGroup;
    if-nez v2, +003h
    return-void 
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->currentType Ljava/lang/Class;
    invoke-direct v12, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->recordEmit(Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;)V
    sget-object v1, Lcom/bytedance/trae/common/widget/InlineToast;->INSTANCE Lcom/bytedance/trae/common/widget/InlineToast;
    invoke-virtual v2, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v3
    const-string v4, "getContext(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;->text(Landroid/content/Context;)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;->getIconRes()I
    move-result v4
    const-wide/16 v5, 2000
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 112
    const/4 v11, 0
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/common/widget/InlineToast;->show$default(Lcom/bytedance/trae/common/widget/InlineToast; Landroid/view/ViewGroup; Ljava/lang/CharSequence; I J I Lcom/bytedance/trae/common/widget/InlineToast$Position; I I Ljava/lang/Object;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter$$ExternalSyntheticLambda0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->nextPromptRunnable Ljava/lang/Runnable;
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->mainHandler Landroid/os/Handler;
    const-wide/16 v2, 2500
    invoke-virtual v1, v0, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final showNext$lambda$1()void
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
    const/4 v1, 0
    sput-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->currentType Ljava/lang/Class;
    sput-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->nextPromptRunnable Ljava/lang/Runnable;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->showNext()V
    return-void 
.end method

.method public final clearAll()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->queue Ljava/util/PriorityQueue;
    invoke-virtual v0, Ljava/util/PriorityQueue;->clear()V
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->currentType Ljava/lang/Class;
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->latestContainer Landroid/view/ViewGroup;
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->nextPromptRunnable Ljava/lang/Runnable;
    if-eqz v1, +007h
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->mainHandler Landroid/os/Handler;
    invoke-virtual v2, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->nextPromptRunnable Ljava/lang/Runnable;
    sget-object v0, Lcom/bytedance/trae/common/widget/InlineToast;->INSTANCE Lcom/bytedance/trae/common/widget/InlineToast;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/InlineToast;->dismiss()V
    return-void 
.end method

.method public final enqueue(android.view.ViewGroup  com.bytedance.trae.conversation.brainstorm.health.VoicePrompt)void
    .registers 4
    # ins_size=3
    const-string v0, "container"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "prompt"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->latestContainer Landroid/view/ViewGroup;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->shouldEmit(Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;)Z
    move-result v2
    if-nez v2, +003h
    return-void 
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->isAlreadyPending(Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;)Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->queue Ljava/util/PriorityQueue;
    invoke-virtual v2, v3, Ljava/util/PriorityQueue;->offer(Ljava/lang/Object;)Z
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->currentType Ljava/lang/Class;
    if-nez v2, +005h
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->showNext()V
    return-void 
.end method

.method public final resetThrottle$conversation_mainlandRelease()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->lastEmitAtByType Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    return-void 
.end method
