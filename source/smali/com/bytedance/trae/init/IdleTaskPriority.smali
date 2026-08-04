# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/IdleTaskPriority;
.super Ljava/lang/Object;
.source "IdleTaskPriority.kt"

.field public static final $stable:I
.field public static final DEFAULT:I
.field public static final HIGH:I
.field public static final INSTANCE:Lcom/bytedance/trae/init/IdleTaskPriority;
.field public static final LOW:I
.field public static final MIDDLE:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/IdleTaskPriority;
    invoke-direct v0, Lcom/bytedance/trae/init/IdleTaskPriority;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/IdleTaskPriority;->INSTANCE Lcom/bytedance/trae/init/IdleTaskPriority;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
