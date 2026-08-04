# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;
.super Ljava/lang/Object;
.source "VoiceExceptionGuard.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final checkAndToast(android.view.ViewGroup  com.bytedance.trae.conversation.brainstorm.health.VoiceCheckTrigger)com.bytedance.trae.conversation.brainstorm.health.VoicePrompt$Health
    .registers 5
    # ins_size=3
    const-string v0, "container"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, trigger
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;-><init>(Landroid/content/Context;)V
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->checkPreflight(Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;)Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    move-result-object v4
    if-nez v4, +004h
    const/4 v3, 0
    return-object v3
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
    move-object v1, v4
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->enqueue(Landroid/view/ViewGroup; Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;)V
    return-object v4
.end method

.method public final checkOnly(android.content.Context  com.bytedance.trae.conversation.brainstorm.health.VoiceCheckTrigger)com.bytedance.trae.conversation.brainstorm.health.VoicePrompt$Health
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, trigger
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;->checkPreflight(Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;)Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    move-result-object v2
    return-object v2
.end method

.method public final resetThrottle$conversation_mainlandRelease()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->resetThrottle$conversation_mainlandRelease()V
    return-void 
.end method
