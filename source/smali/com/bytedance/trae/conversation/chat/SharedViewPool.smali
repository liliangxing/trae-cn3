# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/SharedViewPool;
.super Ljava/lang/Object;
.source "SharedViewPool.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/SharedViewPool;
.field private static final conversationPool:Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;
.field private static final toolListPool:Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/SharedViewPool;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/SharedViewPool;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/SharedViewPool;->INSTANCE Lcom/bytedance/trae/conversation/chat/SharedViewPool;
    new-instance v0, Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/SharedViewPool;->conversationPool Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;
    new-instance v0, Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/SharedViewPool;->toolListPool Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getConversationPool()androidx.recyclerview.widget.RecyclerView$RecycledViewPool
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/SharedViewPool;->conversationPool Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;
    return-object v0
.end method

.method public final getToolListPool()androidx.recyclerview.widget.RecyclerView$RecycledViewPool
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/SharedViewPool;->toolListPool Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;
    return-object v0
.end method
