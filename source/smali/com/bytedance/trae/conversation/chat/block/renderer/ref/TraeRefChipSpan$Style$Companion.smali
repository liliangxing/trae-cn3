# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;
.super Ljava/lang/Object;
.source "TraeRefChipSpan.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;-><init>()V
    return-void 
.end method

.method public final from(android.content.Context)com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefChipSpan$Style
    .registers 15
    # ins_size=2
    const-string v0, "context"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v10, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$dimen;->trae_footnote_footnote_font_size_sp I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimension(I)F
    move-result v5
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v14, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v14, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l2 I
    invoke-static v14, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    new-instance v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v11, 240
    const/4 v12, 0
    move-object v1, v14
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;-><init>(I I I F F F F F F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v14
.end method
