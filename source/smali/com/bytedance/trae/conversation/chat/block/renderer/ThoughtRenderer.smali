# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer;
.super Ljava/lang/Object;
.source "ThoughtRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field public static final BLOCK_TAG:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer$Companion;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Thought)android.view.View
    .registers 12
    # ins_size=3
    const-string v0, "context"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v8
    move-object v2, v10
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v10, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    invoke-virtual v8, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextColor(I)V
    const/4 v10, 2
    const/high16 v1, 1097859072
    invoke-virtual v8, v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextSize(I F)V
    const/4 v10, 0
    const v1, 1066192077
    invoke-virtual v8, v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLineSpacing(F F)V
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v10, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v1, 4
    int-to-float v1, v1
    mul-float/2addr v1, v0
    float-to-int v0, v1
    iput v0, v10, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    iput v0, v10, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;->getThought()Ljava/lang/String;
    move-result-object v3
    const/4 v5, 0
    const/16 v6, 12
    const/4 v7, 0
    move-object v2, v8
    invoke-static/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    check-cast v8, Landroid/view/View;
    return-object v8
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Thought)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v0, +005h
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    goto +2h
    const/4 v8, 0
    move-object v1, v8
    if-nez v1, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;->getThought()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 12
    const/4 v6, 0
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;)V
    return-void 
.end method
