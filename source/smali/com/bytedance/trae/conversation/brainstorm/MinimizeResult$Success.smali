# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Success;
.super Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;
.source "HolderTypes.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Success;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Success;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Success;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Success;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Success;
    return-void 
.end method

.method private constructor <init>()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method
