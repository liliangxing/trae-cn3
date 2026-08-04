# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/conversation/chat/block/renderer/markdown/MarkdownHeaderFactoryHooker;
.super Ljava/lang/Object;
.source "MarkdownHeaderFactoryHooker.java"

.field public static final sStyleMap:Ljava/util/WeakHashMap;


.method public static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Ljava/util/WeakHashMap;
    invoke-direct v0, Ljava/util/WeakHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/markdown/MarkdownHeaderFactoryHooker;->sStyleMap Ljava/util/WeakHashMap;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static applyCustomHeadingStyle(android.text.TextPaint  int  com.bytedance.trae.conversation.chat.block.renderer.HeaderStyleConfig)void
    .registers 5
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->getSizesSp()Ljava/util/Map;
    move-result-object v0
    if-eqz v0, +01bh
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +011h
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Float;
    invoke-virtual v3, Ljava/lang/Float;->floatValue()F
    move-result v3
    goto +21h
    const/4 v0, 1
    if-eq v3, v0, +01dh
    const/4 v0, 2
    if-eq v3, v0, +017h
    const/4 v0, 3
    if-eq v3, v0, +011h
    const/4 v0, 4
    if-eq v3, v0, +00bh
    const/4 v0, 5
    if-eq v3, v0, +005h
    const/high16 v3, 1097859072
    goto +fh
    const/high16 v3, 1098907648
    goto +ch
    const/high16 v3, 1099431936
    goto +9h
    const/high16 v3, 1099956224
    goto +6h
    const/high16 v3, 1100480512
    goto +3h
    const/high16 v3, 1101004800
    invoke-static Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->scaledDensity F
    mul-float/2addr v3, v0
    invoke-virtual v2, v3, Landroid/text/TextPaint;->setTextSize(F)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->getColor()Ljava/lang/Integer;
    move-result-object v3
    if-eqz v3, +009h
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    invoke-virtual v2, v3, Landroid/text/TextPaint;->setColor(I)V
    return-void 
.end method

.method public static bindHeadingStyle(io.noties.markwon.core.spans.HeadingSpan  com.bytedance.trae.conversation.chat.block.renderer.HeaderStyleConfig)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/markdown/MarkdownHeaderFactoryHooker;->sStyleMap Ljava/util/WeakHashMap;
    monitor-enter v0
    invoke-virtual v0, v1, v2, Ljava/util/WeakHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    monitor-exit v0
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method public hookUpdateDrawState(android.text.TextPaint)void
    .registers 5
    # ins_size=2
    invoke-static Lme/ele/lancet/base/Origin;->callVoid()V
    invoke-static Lme/ele/lancet/base/This;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lio/noties/markwon/core/spans/HeadingSpan;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/markdown/MarkdownHeaderFactoryHooker;->sStyleMap Ljava/util/WeakHashMap;
    monitor-enter v1
    invoke-virtual v1, v0, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    monitor-exit v1
    if-eqz v2, +009h
    invoke-virtual v0, Lio/noties/markwon/core/spans/HeadingSpan;->getLevel()I
    move-result v0
    invoke-static v4, v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/markdown/MarkdownHeaderFactoryHooker;->applyCustomHeadingStyle(Landroid/text/TextPaint; I Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;)V
    return-void 
    move-exception v4
    monitor-exit v1
    throw v4
    :try_start_0xc
    :try_start_0x1e
.end method

.method public hookUpdateMeasureState(android.text.TextPaint)void
    .registers 5
    # ins_size=2
    invoke-static Lme/ele/lancet/base/Origin;->callVoid()V
    invoke-static Lme/ele/lancet/base/This;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lio/noties/markwon/core/spans/HeadingSpan;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/markdown/MarkdownHeaderFactoryHooker;->sStyleMap Ljava/util/WeakHashMap;
    monitor-enter v1
    invoke-virtual v1, v0, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    monitor-exit v1
    if-eqz v2, +009h
    invoke-virtual v0, Lio/noties/markwon/core/spans/HeadingSpan;->getLevel()I
    move-result v0
    invoke-static v4, v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/markdown/MarkdownHeaderFactoryHooker;->applyCustomHeadingStyle(Landroid/text/TextPaint; I Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;)V
    return-void 
    move-exception v4
    monitor-exit v1
    throw v4
    :try_start_0xc
    :try_start_0x1e
.end method
