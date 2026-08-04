# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/api/ActiveConversationTracker;
.super Ljava/lang/Object;
.source "ActiveConversationTracker.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/push/api/ActiveConversationTracker;
.field private static final activeConversationId:Ljava/util/concurrent/atomic/AtomicReference;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/push/api/ActiveConversationTracker;
    invoke-direct v0, Lcom/bytedance/trae/push/api/ActiveConversationTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/push/api/ActiveConversationTracker;->INSTANCE Lcom/bytedance/trae/push/api/ActiveConversationTracker;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;
    const/4 v1, 0
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V
    sput-object v0, Lcom/bytedance/trae/push/api/ActiveConversationTracker;->activeConversationId Ljava/util/concurrent/atomic/AtomicReference;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getActiveConversationId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/api/ActiveConversationTracker;->activeConversationId Ljava/util/concurrent/atomic/AtomicReference;
    invoke-virtual v0, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method public final setActiveConversationId(java.lang.String)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/push/api/ActiveConversationTracker;->activeConversationId Ljava/util/concurrent/atomic/AtomicReference;
    invoke-virtual v0, v2, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V
    return-void 
.end method
