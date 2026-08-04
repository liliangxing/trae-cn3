# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;
.super Ljava/lang/Object;
.source "SummaryRenderer.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;-><init>()V
    return-void 
.end method

.method public final cancelTypewriter(android.view.View)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_typewriter I
    invoke-virtual v4, v0, Landroid/view/View;->getTag(I)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    goto +2h
    move-object v0, v2
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->cancel()V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_typewriter I
    invoke-virtual v4, v0, v2, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    return-void 
.end method
