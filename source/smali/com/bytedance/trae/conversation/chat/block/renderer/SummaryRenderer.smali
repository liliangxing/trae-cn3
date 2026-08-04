# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;
.super Ljava/lang/Object;
.source "SummaryRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field private static final BLOCK_TAG:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;


.method public static synthetic $r8$lambda$7jMVwzK8CrtfXnmvO_8TSJtCsKw(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String  java.lang.String  boolean)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->createTypewriter$lambda$5(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Ljava/lang/String; Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$KmsvKHMWedcoHWZuqv8ypHzoPuw(android.widget.LinearLayout)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->createTypewriter$lambda$6(Landroid/widget/LinearLayout;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Rgu47JAdUDbmo9DeQVmUqZKF83Y(kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  android.view.View  android.view.MotionEvent)boolean
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->setupLongPressMenu$lambda$7(Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$g2u90LXPMWZOEHyBDLvnInmqNT0(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  kotlin.jvm.internal.Ref$ObjectRef  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  java.lang.String  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  android.view.View)boolean
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->setupLongPressMenu$lambda$8(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Ljava/lang/String; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Landroid/view/View;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final createTypewriter(android.widget.LinearLayout  com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String)com.bytedance.trae.conversation.chat.block.renderer.Typewriter
    .registers 6
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda0;
    invoke-direct v1, v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String;)V
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda1;
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda1;-><init>(Landroid/widget/LinearLayout;)V
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;-><init>(Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function0;)V
    return-object v0
.end method

.method private static final createTypewriter$lambda$5(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String  java.lang.String  boolean)kotlin.Unit
    .registers 12
    # ins_size=4
    const-string v0, "displayText"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v2, v8
    move-object v3, v10
    move v4, v11
    invoke-static/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContentWithRef$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    check-cast v10, Ljava/lang/CharSequence;
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +004h
    const/4 v8, 1
    goto +2h
    const/4 v8, 0
    if-eqz v8, +007h
    sget-object v8, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->markFirstChar(Ljava/lang/String;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method

.method private static final createTypewriter$lambda$6(android.widget.LinearLayout)kotlin.Unit
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->getTag(I)Ljava/lang/Object;
    move-result-object v1
    const/4 v0, 0
    invoke-static v1, v0, Lkotlin/jvm/internal/TypeIntrinsics;->isFunctionOfArity(Ljava/lang/Object; I)Z
    move-result v0
    if-eqz v0, +005h
    check-cast v1, Lkotlin/jvm/functions/Function0;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +005h
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final setupLongPressMenu(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String)void
    .registers 12
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isSelectionActionModeAvailable()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    new-instance v4, Lkotlin/jvm/internal/Ref$FloatRef;
    invoke-direct v4, Lkotlin/jvm/internal/Ref$FloatRef;-><init>()V
    new-instance v5, Lkotlin/jvm/internal/Ref$FloatRef;
    invoke-direct v5, Lkotlin/jvm/internal/Ref$FloatRef;-><init>()V
    new-instance v7, Lkotlin/jvm/internal/Ref$FloatRef;
    invoke-direct v7, Lkotlin/jvm/internal/Ref$FloatRef;-><init>()V
    new-instance v8, Lkotlin/jvm/internal/Ref$FloatRef;
    invoke-direct v8, Lkotlin/jvm/internal/Ref$FloatRef;-><init>()V
    new-instance v3, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v3, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;
    invoke-direct v0, v4, v5, v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef;)V
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;
    move-object v1, v0
    move-object v2, v10
    move-object v6, v11
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Ljava/lang/String; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef;)V
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    return-void 
.end method

.method private static final setupLongPressMenu$lambda$7(kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  android.view.View  android.view.MotionEvent)boolean
    .registers 6
    # ins_size=6
    invoke-virtual v5, Landroid/view/MotionEvent;->getAction()I
    move-result v4
    if-nez v4, +01ah
    invoke-virtual v5, Landroid/view/MotionEvent;->getRawX()F
    move-result v4
    iput v4, v0, Lkotlin/jvm/internal/Ref$FloatRef;->element F
    invoke-virtual v5, Landroid/view/MotionEvent;->getRawY()F
    move-result v0
    iput v0, v1, Lkotlin/jvm/internal/Ref$FloatRef;->element F
    invoke-virtual v5, Landroid/view/MotionEvent;->getX()F
    move-result v0
    iput v0, v2, Lkotlin/jvm/internal/Ref$FloatRef;->element F
    invoke-virtual v5, Landroid/view/MotionEvent;->getY()F
    move-result v0
    iput v0, v3, Lkotlin/jvm/internal/Ref$FloatRef;->element F
    const/4 v0, 0
    return v0
.end method

.method private static final setupLongPressMenu$lambda$8(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  kotlin.jvm.internal.Ref$ObjectRef  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  java.lang.String  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  android.view.View)boolean
    .registers 11
    # ins_size=8
    sget-object v10, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isEnteringSelection()Z
    move-result v10
    const/4 v0, 1
    if-eqz v10, +003h
    return v0
    const/4 v10, 0
    invoke-virtual v3, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->performHapticFeedback(I)Z
    iget-object v10, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;
    if-eqz v10, +005h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dismiss()V
    new-instance v10, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->getContext()Landroid/content/Context;
    move-result-object v1
    const-string v2, "getContext(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;
    invoke-direct v2, v3, v7, v8, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef;)V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;
    invoke-direct v10, v1, v2, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;)V
    iput-object v10, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v4, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;
    if-eqz v4, +00bh
    check-cast v3, Landroid/view/View;
    iget v5, v5, Lkotlin/jvm/internal/Ref$FloatRef;->element F
    iget v6, v6, Lkotlin/jvm/internal/Ref$FloatRef;->element F
    invoke-virtual v4, v3, v5, v6, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->showNear(Landroid/view/View; F F)V
    return v0
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Summary)android.view.View
    .registers 23
    # ins_size=3
    move-object/from16 v0, v20
    move-object/from16 v7, v21
    const-string v1, "context"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "block"
    move-object/from16 v8, v22
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v21, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    new-instance v9, Landroid/widget/LinearLayout;
    invoke-direct v9, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v10, 1
    invoke-virtual v9, v10, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v2, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v5, 8
    int-to-float v5, v5
    mul-float/2addr v5, v1
    float-to-int v5, v5
    iput v5, v2, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    const/4 v5, 6
    int-to-float v5, v5
    mul-float/2addr v5, v1
    float-to-int v5, v5
    iput v5, v2, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v2, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tag_summary_tracking_id I
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getTrackingId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v9, v2, v5, Landroid/widget/LinearLayout;->setTag(I Ljava/lang/Object;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_summary_title I
    invoke-virtual v7, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v2, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v7, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v2, v5, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v5, 1102053376
    const/4 v11, 2
    invoke-virtual v2, v11, v5, Landroid/widget/TextView;->setTextSize(I F)V
    const-string/jumbo v5, sans-serif
    invoke-static v5, v10, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v5
    invoke-virtual v2, v5, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    const/4 v12, 0
    invoke-virtual v2, v12, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    check-cast v2, Landroid/view/View;
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v5, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v3, 12
    int-to-float v3, v3
    mul-float/2addr v3, v1
    float-to-int v1, v3
    iput v1, v5, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v2, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v15, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v15
    move-object/from16 v2, v21
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextColor(I)V
    const/high16 v1, 1099431936
    invoke-virtual v15, v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextSize(I F)V
    const/4 v1, 0
    const/high16 v2, 1065353216
    invoke-virtual v15, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLineSpacing(F F)V
    move-object v1, v15
    check-cast v1, Landroid/view/View;
    invoke-virtual v9, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getFinished()Z
    move-result v1
    if-eqz v1, +047h
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getWebReferences()Ljava/util/List;
    move-result-object v1
    invoke-virtual v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setWebReferenceDescription(Ljava/util/List;)V
    sget-object v13, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getContent()Ljava/lang/String;
    move-result-object v1
    const/16 v16, 1
    const/16 v17, 0
    const/16 v18, 8
    const/16 v19, 0
    move-object v14, v15
    move-object v2, v15
    move-object v15, v1
    invoke-static/range v13 ... v19, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContentWithRef$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getContent()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +003h
    goto +2h
    move v10, v12
    if-eqz v10, +014h
    sget-object v1, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getTrackingId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->markFirstChar(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getTrackingId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->markLastChar(Ljava/lang/String;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getContent()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->setupLongPressMenu(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String;)V
    goto +20h
    move-object v2, v15
    invoke-virtual v2, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLongClickable(Z)V
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getWebReferences()Ljava/util/List;
    move-result-object v1
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setWebReferenceDescription(Ljava/util/List;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getTrackingId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v9, v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->createTypewriter(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tag_typewriter I
    invoke-virtual v9, v2, v1, Landroid/widget/LinearLayout;->setTag(I Ljava/lang/Object;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getContent()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->feed(Ljava/lang/String;)V
    check-cast v9, Landroid/view/View;
    return-object v9
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Summary)void
    .registers 15
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v13, Landroid/widget/LinearLayout;
    const/4 v1, 0
    if-eqz v0, +005h
    check-cast v13, Landroid/widget/LinearLayout;
    goto +2h
    move-object v13, v1
    if-nez v13, +003h
    return-void 
    const/4 v0, 1
    invoke-virtual v13, v0, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v3, +005h
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    goto +2h
    move-object v2, v1
    if-nez v2, +003h
    return-void 
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getTrackingId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +011h
    sget v3, Lcom/bytedance/trae/conversation/R$id;->tag_summary_tracking_id I
    invoke-virtual v13, v3, Landroid/widget/LinearLayout;->getTag(I)Ljava/lang/Object;
    move-result-object v3
    instance-of v4, v3, Ljava/lang/String;
    if-eqz v4, +005h
    check-cast v3, Ljava/lang/String;
    goto +3h
    move-object v10, v1
    goto +2h
    move-object v10, v3
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getFinished()Z
    move-result v3
    const/4 v11, 0
    if-eqz v3, +041h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;
    check-cast v13, Landroid/view/View;
    invoke-virtual v1, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;->cancelTypewriter(Landroid/view/View;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getWebReferences()Ljava/util/List;
    move-result-object v13
    invoke-virtual v2, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setWebReferenceDescription(Ljava/util/List;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getContent()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 1
    const/4 v7, 0
    const/16 v8, 8
    const/4 v9, 0
    move-object v4, v2
    invoke-static/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContentWithRef$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getContent()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-interface v13, Ljava/lang/CharSequence;->length()I
    move-result v13
    if-lez v13, +003h
    goto +2h
    move v0, v11
    if-eqz v0, +00ch
    sget-object v13, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual v13, v10, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->markFirstChar(Ljava/lang/String;)V
    sget-object v13, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual v13, v10, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->markLastChar(Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getContent()Ljava/lang/String;
    move-result-object v13
    invoke-direct v12, v2, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->setupLongPressMenu(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String;)V
    return-void 
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_typewriter I
    invoke-virtual v13, v0, Landroid/widget/LinearLayout;->getTag(I)Ljava/lang/Object;
    move-result-object v0
    instance-of v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    if-eqz v3, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    goto +2h
    move-object v0, v1
    if-nez v0, +00bh
    invoke-direct v12, v13, v2, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->createTypewriter(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    move-result-object v0
    sget v3, Lcom/bytedance/trae/conversation/R$id;->tag_typewriter I
    invoke-virtual v13, v3, v0, Landroid/widget/LinearLayout;->setTag(I Ljava/lang/Object;)V
    invoke-virtual v2, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLongClickable(Z)V
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getWebReferences()Ljava/util/List;
    move-result-object v13
    invoke-virtual v2, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setWebReferenceDescription(Ljava/util/List;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->getContent()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v0, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->feed(Ljava/lang/String;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;)V
    return-void 
.end method
