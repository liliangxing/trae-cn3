# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
.super Ljava/lang/Object;
.source "CheckpointTypefaces.kt"

.field private static final FIGMA_MEDIUM_WEIGHT:I
.field private static final FIGMA_SEMIBOLD_WEIGHT:I
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;


.method public static synthetic $r8$lambda$TroYxxzMNNsl8-flZc5PkY9uLJY(int)android.graphics.Typeface
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->createDefaultWeight$lambda$0(I)Landroid/graphics/Typeface;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kXaxtdP1rJ1os9eQpppxxLPCXwc()android.graphics.Typeface
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->createDefaultWeight$lambda$1()Landroid/graphics/Typeface;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final createDefaultWeight(int)android.graphics.Typeface
    .registers 5
    # ins_size=2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces$$ExternalSyntheticLambda0;-><init>()V
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces$$ExternalSyntheticLambda1;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces$$ExternalSyntheticLambda1;-><init>()V
    invoke-virtual v3, v0, v4, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->createForSdk$conversation_mainlandRelease(I I Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;
    move-result-object v4
    const-string v0, "createForSdk(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/graphics/Typeface;
    return-object v4
.end method

.method private static final createDefaultWeight$lambda$0(int)android.graphics.Typeface
    .registers 3
    # ins_size=1
    sget-object v0, Landroid/graphics/Typeface;->DEFAULT Landroid/graphics/Typeface;
    const/4 v1, 0
    invoke-static v0, v2, v1, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface; I Z)Landroid/graphics/Typeface;
    move-result-object v2
    return-object v2
.end method

.method private static final createDefaultWeight$lambda$1()android.graphics.Typeface
    .registers 1
    # ins_size=0
    sget-object v0, Landroid/graphics/Typeface;->DEFAULT_BOLD Landroid/graphics/Typeface;
    return-object v0
.end method

.method public final createForSdk$conversation_mainlandRelease(int  int  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)java.lang.Object
    .registers 6
    # ins_size=5
    const-string/jumbo v0, weightedFactory
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "fallbackFactory"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v0, 28
    if-lt v2, v0, +00bh
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v4, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +5h
    invoke-interface v5, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final defaultMedium()android.graphics.Typeface
    .registers 2
    # ins_size=1
    const/16 v0, 510
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->createDefaultWeight(I)Landroid/graphics/Typeface;
    move-result-object v0
    return-object v0
.end method

.method public final defaultSemibold()android.graphics.Typeface
    .registers 2
    # ins_size=1
    const/16 v0, 590
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->createDefaultWeight(I)Landroid/graphics/Typeface;
    move-result-object v0
    return-object v0
.end method
