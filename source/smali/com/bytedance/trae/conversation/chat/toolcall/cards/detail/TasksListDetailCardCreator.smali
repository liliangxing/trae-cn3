# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "TasksListDetailCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$MCNPr-qt1Curfd8oRV5sdEFpcog(com.bytedance.trae.conversation.chat.toolcall.cards.detail.TasksListDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;->onCreateDetail$lambda$0(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jPrVH6Gc1A7-ecet7OUmB1s51G4(com.bytedance.trae.conversation.chat.toolcall.cards.detail.TasksListDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;->onCreateDetail$lambda$2(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildTodoListView(android.content.Context  java.util.List)android.view.View
    .registers 9
    # ins_size=3
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    const/4 v2, 0
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +029h
    add-int/lit8 v3, v2, 1
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;
    invoke-direct v6, v7, v0, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;->buildTodoRow(Landroid/content/Context; F Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;)Landroid/view/View;
    move-result-object v4
    if-lez v2, +016h
    invoke-virtual v4, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v2
    instance-of v5, v2, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v5, +005h
    check-cast v2, Landroid/widget/LinearLayout$LayoutParams;
    goto +2h
    const/4 v2, 0
    if-eqz v2, +008h
    const/4 v5, 4
    int-to-float v5, v5
    mul-float/2addr v5, v0
    float-to-int v5, v5
    iput v5, v2, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move v2, v3
    goto -2ch
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final buildTodoRow(android.content.Context  float  com.bytedance.trae.conversation.chat.toolcall.cards.detail.TasksListDetailCardCreator$TodoItem)android.view.View
    .registers 15
    # ins_size=4
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v3, 24
    int-to-float v3, v3
    mul-float/2addr v3, v13
    float-to-int v3, v3
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setMinimumHeight(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    const/4 v5, -2
    invoke-direct v3, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    int-to-float v2, v2
    mul-float/2addr v2, v13
    float-to-int v2, v2
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;->getStatus()Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;->ordinal()I
    move-result v3
    aget v3, v4, v3
    const/4 v4, 2
    const/4 v6, 1
    if-eq v3, v6, +06fh
    if-eq v3, v4, +051h
    const/4 v7, 3
    if-ne v3, v7, +048h
    const/16 v3, 14
    int-to-float v3, v3
    mul-float/2addr v3, v13
    float-to-int v3, v3
    new-instance v7, Landroid/view/View;
    invoke-direct v7, v12, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v8, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v8, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-virtual v8, v6, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V
    const v9, 1066779279
    mul-float/2addr v9, v13
    float-to-int v9, v9
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l2 I
    invoke-static v12, v10, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    invoke-virtual v8, v9, v10, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    invoke-virtual v8, v1, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    check-cast v8, Landroid/graphics/drawable/Drawable;
    invoke-virtual v7, v8, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v8, Landroid/widget/FrameLayout;
    invoke-direct v8, v12, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v9, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v10, 17
    invoke-direct v9, v3, v3, v10, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v7, v9, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v8, Landroid/view/View;
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v3, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v8, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    goto +3eh
    new-instance v12, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v12, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v12
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v12, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->in_process I
    invoke-virtual v3, v7, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v7, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v3, v7, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v3, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    goto +1ch
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v12, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->checkmark_circle_1 I
    invoke-virtual v3, v7, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v7, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v3, v7, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v3, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v12, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;->getContent()Ljava/lang/String;
    move-result-object v14
    check-cast v14, Ljava/lang/CharSequence;
    invoke-virtual v2, v14, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v14, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v12, v14, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v12
    invoke-virtual v2, v12, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v12, 1095761920
    invoke-virtual v2, v4, v12, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v2, v6, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v12, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v2, v12, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    check-cast v2, Landroid/view/View;
    new-instance v12, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v14, 1065353216
    invoke-direct v12, v1, v5, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v14, 4
    int-to-float v14, v14
    mul-float/2addr v14, v13
    float-to-int v13, v14
    invoke-virtual v12, v13, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, v12, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private final collectTodoItems(com.bytedance.trae.im.model.ParsedToolCallInfo)java.util.List
    .registers 10
    # ins_size=2
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v9
    if-eqz v9, +088h
    const-string/jumbo v0, todos
    invoke-virtual v9, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +07fh
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    goto +2h
    move-object v9, v1
    if-eqz v9, +074h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v9
    if-nez v9, +004h
    goto/16 +06ch
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v0
    invoke-virtual v9, Lcom/google/gson/JsonArray;->size()I
    move-result v2
    const/4 v3, 0
    if-ge v3, v2, +05ch
    invoke-virtual v9, v3, Lcom/google/gson/JsonArray;->get(I)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +053h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v1
    if-eqz v4, +049h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-nez v4, +003h
    goto +41h
    const-string v5, "content"
    invoke-virtual v4, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +03ah
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v5, v1
    if-eqz v5, +030h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto +28h
    const-string/jumbo v6, status
    invoke-virtual v4, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v4, v1
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v1
    new-instance v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;
    sget-object v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus$Companion;
    invoke-virtual v7, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;
    move-result-object v4
    invoke-direct v6, v5, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;)V
    invoke-interface v0, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    add-int/lit8 v3, v3, 1
    goto -5bh
    invoke-static v0, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v9
    return-object v9
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v9
    return-object v9
.end method

.method private static final onCreateDetail$lambda$0(com.bytedance.trae.conversation.chat.toolcall.cards.detail.TasksListDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;->buildTodoListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onCreateDetail$lambda$2(com.bytedance.trae.conversation.chat.toolcall.cards.detail.TasksListDetailCardCreator  java.util.List  android.content.Context)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;->buildTodoListView(Landroid/content/Context; Ljava/util/List;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 26
    # ins_size=4
    move-object/from16 v0, v22
    move-object/from16 v1, v23
    move-object/from16 v2, v24
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, toolCallInfo
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v3, +004h
    move v3, v5
    goto +2h
    move v3, v4
    sget-object v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v7
    const/4 v8, 0
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v8
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v6
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;->collectTodoItems(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v7
    const-string v9, "getString(...)"
    if-nez v3, +021h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_todo_updating I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v7
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/2addr v3, v5
    if-eqz v3, +007h
    new-instance v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v8, v0, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator; Ljava/util/List;)V
    move-object v13, v1
    move/from16 v18, v5
    move-object/from16 v16, v8
    goto/16 +083h
    move-object v3, v7
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    xor-int/2addr v10, v5
    if-eqz v10, +036h
    move-object v10, v7
    check-cast v10, Ljava/lang/Iterable;
    instance-of v11, v10, Ljava/util/Collection;
    if-eqz v11, +00dh
    move-object v11, v10
    check-cast v11, Ljava/util/Collection;
    invoke-interface v11, Ljava/util/Collection;->isEmpty()Z
    move-result v11
    if-eqz v11, +004h
    move v10, v5
    goto +1fh
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, -00ah
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;->getStatus()Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;
    if-ne v11, v12, +004h
    move v11, v5
    goto +2h
    move v11, v4
    if-nez v11, -017h
    move v10, v4
    if-eqz v10, +004h
    move v10, v5
    goto +2h
    move v10, v4
    if-eqz v10, +00ch
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_todo_all_completed I
    invoke-virtual v1, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +26h
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v9
    if-lez v9, +018h
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v10, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_todo_count I
    new-array v11, v5, [Ljava/lang/Object;
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    aput-object v12, v11, v4
    invoke-virtual v1, v10, v9, v11, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    goto +ah
    sget v9, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_todo_updating I
    invoke-virtual v1, v9, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/2addr v3, v5
    if-eqz v3, +007h
    new-instance v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$$ExternalSyntheticLambda1;
    invoke-direct v8, v0, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator; Ljava/util/List;)V
    move-object v13, v1
    move/from16 v18, v4
    goto/16 -083h
    const/4 v14, 0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[TasksListCard] onCreateDetail: name="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", status="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", tasks="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "AgentTool"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v10, ""
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->todo I
    const/4 v12, 0
    const/4 v15, 0
    const/16 v19, 0
    const/16 v20, 548
    const/16 v21, 0
    move-object v9, v1
    move-object/from16 v17, v6
    invoke-direct/range v9 ... v21, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 13
    # ins_size=5
    const-string v12, "context"
    invoke-static v9, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "card"
    invoke-static v10, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v12, toolCallInfo
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v12
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v12, +004h
    move v12, v1
    goto +2h
    move v12, v0
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    const/4 v4, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v2
    invoke-direct v8, v11, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;->collectTodoItems(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v3
    const-string v5, "getString(...)"
    if-nez v12, +016h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_todo_updating I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto/16 +081h
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    move-object v12, v3
    check-cast v12, Ljava/util/Collection;
    invoke-interface v12, Ljava/util/Collection;->isEmpty()Z
    move-result v12
    xor-int/2addr v12, v1
    if-eqz v12, +036h
    move-object v12, v3
    check-cast v12, Ljava/lang/Iterable;
    instance-of v6, v12, Ljava/util/Collection;
    if-eqz v6, +00dh
    move-object v6, v12
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +004h
    move v12, v1
    goto +1fh
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, -00ah
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;->getStatus()Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;
    if-ne v6, v7, +004h
    move v6, v1
    goto +2h
    move v6, v0
    if-nez v6, -017h
    move v12, v0
    if-eqz v12, +004h
    move v12, v1
    goto +2h
    move v12, v0
    if-eqz v12, +012h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_todo_all_completed I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    goto +2ch
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v12
    if-lez v12, +018h
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    sget v5, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_todo_count I
    new-array v1, v1, [Ljava/lang/Object;
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v1, v0
    invoke-virtual v9, v5, v12, v1, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    goto +ah
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_todo_updating I
    invoke-virtual v9, v12, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v10, v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v10, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v12, "[TasksListCard] onUpdateCard: name="
    invoke-direct v10, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", status="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", tasks="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string v11, "AgentTool"
    invoke-virtual v9, v11, v10, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
