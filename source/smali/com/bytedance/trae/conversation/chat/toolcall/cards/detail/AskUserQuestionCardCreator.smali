# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "AskUserQuestionCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$9zL3_SXPmNrhu3xBipKyJKhWNRA(com.google.gson.JsonElement  java.lang.String  com.google.gson.JsonArray  com.bytedance.trae.conversation.chat.toolcall.cards.detail.AskUserQuestionCardCreator  android.content.Context)android.widget.LinearLayout
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;->buildQuestionsView$lambda$21(Lcom/google/gson/JsonElement; Ljava/lang/String; Lcom/google/gson/JsonArray; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator; Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildOptionRow(android.content.Context  float  java.lang.String)android.view.View
    .registers 11
    # ins_size=4
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v8, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    const/4 v5, -2
    invoke-direct v3, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v4, 2
    int-to-float v6, v4
    mul-float/2addr v6, v9
    float-to-int v6, v6
    iput v6, v3, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/4 v3, 3
    int-to-float v3, v3
    mul-float/2addr v3, v9
    float-to-int v3, v3
    invoke-virtual v0, v1, v3, v1, v3, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v8, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v1, 17
    invoke-virtual v3, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    int-to-float v1, v2
    mul-float/2addr v1, v9
    float-to-int v1, v1
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v1, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v2, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/view/View;
    invoke-direct v1, v8, Landroid/view/View;-><init>(Landroid/content/Context;)V
    const/4 v2, 4
    int-to-float v2, v2
    mul-float/2addr v2, v9
    float-to-int v9, v2
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v9, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v2, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    const/4 v6, 1
    invoke-virtual v2, v6, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_tertiary I
    invoke-static v8, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v2, v6, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    check-cast v2, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v2, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v3, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v3, Landroid/view/View;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v8, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v10, Ljava/lang/CharSequence;
    invoke-virtual v1, v10, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v8, v10, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v1, v8, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v8, 1095761920
    invoke-virtual v1, v4, v8, Landroid/widget/TextView;->setTextSize(I F)V
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v8, v9, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v8, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private final buildQuestionsView(com.bytedance.trae.im.model.ParsedToolCallInfo)kotlin.jvm.functions.Function1
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +009h
    const-string v2, "questions"
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-eqz v0, +051h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v2
    if-eqz v2, +04bh
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v2
    invoke-virtual v2, Lcom/google/gson/JsonArray;->size()I
    move-result v2
    if-nez v2, +003h
    goto +3fh
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +009h
    const-string v3, "answers"
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    goto +2h
    move-object v2, v1
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v3
    if-eqz v3, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v2
    goto +2h
    move-object v2, v1
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v5
    if-eqz v5, +018h
    const-string v3, "custom_input"
    invoke-virtual v5, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +010h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v5, v1
    if-eqz v5, +006h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    new-instance v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v5, v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;-><init>(Lcom/google/gson/JsonElement; Ljava/lang/String; Lcom/google/gson/JsonArray; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;)V
    return-object v5
    return-object v1
.end method

.method private static final buildQuestionsView$lambda$21(com.google.gson.JsonElement  java.lang.String  com.google.gson.JsonArray  com.bytedance.trae.conversation.chat.toolcall.cards.detail.AskUserQuestionCardCreator  android.content.Context)android.widget.LinearLayout
    .registers 24
    # ins_size=5
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    move-object/from16 v2, v23
    const-string v3, "ctx"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    new-instance v4, Landroid/widget/LinearLayout;
    invoke-direct v4, v2, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v5, 1
    invoke-virtual v4, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual/range v19, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v6
    const-string v7, "getAsJsonArray(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    const/4 v9, 0
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    const/16 v11, 12
    const/4 v13, 2
    const/4 v14, -2
    const/4 v15, -1
    if-eqz v10, +203h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    add-int/lit8 v16, v9, 1
    if-gez v9, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v10, Lcom/google/gson/JsonElement;
    if-eqz v10, +1efh
    invoke-virtual v10, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v17
    const/16 v18, 0
    if-eqz v17, +003h
    goto +3h
    move-object/from16 v10, v18
    if-eqz v10, +1e2h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v10
    if-nez v10, +004h
    goto/16 +1dah
    const-string v8, "question"
    invoke-virtual v10, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +1d2h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v17
    if-eqz v17, +003h
    goto +3h
    move-object/from16 v8, v18
    if-eqz v8, +1c7h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +004h
    goto/16 +1bfh
    new-instance v12, Landroid/widget/LinearLayout;
    invoke-direct v12, v2, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v12, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    if-lez v9, +011h
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v5, v15, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v11, v11
    mul-float/2addr v11, v3
    float-to-int v11, v11
    iput v11, v5, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v5, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v5, Landroid/widget/TextView;
    invoke-direct v5, v2, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v5, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v2, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v5, v8, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v8, 1095761920
    invoke-virtual v5, v13, v8, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v5, Landroid/widget/TextView;->getTypeface()Landroid/graphics/Typeface;
    move-result-object v8
    const/4 v11, 1
    invoke-virtual v5, v8, v11, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface; I)V
    check-cast v5, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v15, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v5, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    if-eqz v0, +01eh
    invoke-virtual/range v21, Lcom/google/gson/JsonArray;->size()I
    move-result v5
    if-ge v9, v5, +018h
    invoke-virtual v0, v9, Lcom/google/gson/JsonArray;->get(I)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +012h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    move-object/from16 v5, v18
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v5
    goto +3h
    move-object/from16 v5, v18
    if-eqz v5, +01bh
    const-string/jumbo v8, selected_options
    invoke-virtual v5, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +012h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v9
    if-eqz v9, +003h
    goto +3h
    move-object/from16 v8, v18
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v8
    goto +3h
    move-object/from16 v8, v18
    if-eqz v5, +01ah
    const-string v9, "custom_input"
    invoke-virtual v5, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +012h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v9
    if-eqz v9, +003h
    goto +3h
    move-object/from16 v5, v18
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    goto +3h
    move-object/from16 v5, v18
    new-instance v9, Ljava/util/ArrayList;
    invoke-direct v9, Ljava/util/ArrayList;-><init>()V
    check-cast v9, Ljava/util/List;
    if-eqz v8, +05ch
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +064h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/google/gson/JsonElement;
    if-eqz v11, +045h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v17
    if-eqz v17, +003h
    goto +3h
    move-object/from16 v11, v18
    if-eqz v11, +03ah
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    goto +32h
    const-string v13, "__other__"
    invoke-static v11, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, +028h
    move-object v11, v5
    check-cast v11, Ljava/lang/CharSequence;
    if-eqz v11, +00bh
    invoke-static v11, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v11
    if-eqz v11, +003h
    goto +3h
    const/4 v11, 0
    goto +2h
    const/4 v11, 1
    if-nez v11, +01ah
    sget v11, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_ask_answer_other I
    const/4 v13, 1
    new-array v14, v13, [Ljava/lang/Object;
    const/4 v13, 0
    aput-object v5, v14, v13
    invoke-virtual v2, v11, v14, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    const-string v13, "getString(...)"
    invoke-static v11, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v9, v11, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +4h
    invoke-interface v9, v11, Ljava/util/List;->add(Ljava/lang/Object;)Z
    const/4 v13, 2
    const/4 v14, -2
    goto -53h
    move-object v8, v5
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    const/4 v8, 0
    goto +2h
    const/4 v8, 1
    if-nez v8, +005h
    invoke-interface v9, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move-object v5, v9
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    const/4 v8, 1
    xor-int/2addr v5, v8
    if-eqz v5, +03bh
    new-instance v5, Landroid/widget/LinearLayout;
    invoke-direct v5, v2, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v5, v8, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v10, -2
    invoke-direct v8, v15, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v10, 2
    int-to-float v10, v10
    mul-float/2addr v10, v3
    float-to-int v10, v10
    iput v10, v8, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v8, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v9, Ljava/lang/Iterable;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +010h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    invoke-direct v1, v2, v3, v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;->buildOptionRow(Landroid/content/Context; F Ljava/lang/String;)Landroid/view/View;
    move-result-object v9
    invoke-virtual v5, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -13h
    check-cast v5, Landroid/view/View;
    invoke-virtual v12, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto +60h
    const-string v5, "options"
    invoke-virtual v10, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +059h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v8
    if-eqz v8, +053h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v5
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +040h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/google/gson/JsonElement;
    if-eqz v8, +012h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v9
    if-eqz v9, +003h
    goto +3h
    move-object/from16 v8, v18
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v8
    goto +3h
    move-object/from16 v8, v18
    if-eqz v8, -020h
    const-string v9, "label"
    invoke-virtual v8, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, -028h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v9
    if-eqz v9, +003h
    goto +3h
    move-object/from16 v8, v18
    if-eqz v8, -033h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    goto -3bh
    invoke-direct v1, v2, v3, v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;->buildOptionRow(Landroid/content/Context; F Ljava/lang/String;)Landroid/view/View;
    move-result-object v8
    invoke-virtual v12, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -43h
    check-cast v12, Landroid/view/View;
    invoke-virtual v4, v12, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move/from16 v9, v16
    const/4 v5, 1
    goto/16 -20ah
    move-object/from16 v0, v20
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +03ch
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v2, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_ask_custom_input I
    const/4 v5, 1
    new-array v5, v5, [Ljava/lang/Object;
    const/4 v6, 0
    aput-object v20, v5, v6
    invoke-virtual v2, v1, v5, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v2, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v1, 1095761920
    const/4 v2, 2
    invoke-virtual v0, v2, v1, Landroid/widget/TextView;->setTextSize(I F)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v2, -2
    invoke-direct v1, v15, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v2, v11
    mul-float/2addr v2, v3
    float-to-int v2, v2
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    invoke-virtual v4, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    return-object v4
.end method

.method private final getQuestionCount(com.bytedance.trae.im.model.ParsedToolCallInfo)int
    .registers 3
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +009h
    const-string v0, "questions"
    invoke-virtual v2, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v0
    if-eqz v0, +00bh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v2
    invoke-virtual v2, Lcom/google/gson/JsonArray;->size()I
    move-result v2
    return v2
    const/4 v2, 0
    return v2
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 28
    # ins_size=4
    move-object/from16 v0, v24
    move-object/from16 v1, v25
    move-object/from16 v2, v26
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, toolCallInfo
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v26, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 1
    const/4 v6, 0
    if-nez v3, +015h
    invoke-virtual/range v26, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +009h
    const-string v7, "answers"
    invoke-virtual v3, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    goto +2h
    move-object v3, v4
    if-eqz v3, +003h
    goto +3h
    move v3, v6
    goto +2h
    move v3, v5
    sget-object v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v26, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v4
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v7
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;->getQuestionCount(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)I
    move-result v8
    sget-object v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v7, v9, +017h
    if-eqz v27, +010h
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v9
    if-eqz v9, +00ah
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v9
    if-ne v9, v5, +004h
    move v9, v5
    goto +2h
    move v9, v6
    if-eqz v9, +004h
    move v9, v5
    goto +2h
    move v9, v6
    const-string v10, ""
    const-string v11, "getString(...)"
    if-eqz v9, +01bh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_asking_user I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v1, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object/from16 v17, v1
    move-object v15, v3
    move-object/from16 v18, v4
    move/from16 v20, v5
    move-object/from16 v16, v10
    goto +4dh
    sget-object v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v7, v9, +031h
    if-eqz v3, +02fh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_asked_user I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-lez v8, +01ah
    invoke-virtual/range v25, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v9, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_ask_question_count I
    new-array v5, v5, [Ljava/lang/Object;
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    aput-object v10, v5, v6
    invoke-virtual v1, v9, v8, v5, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    const-string v5, "getQuantityString(...)"
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v10, v1
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;->buildQuestionsView(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lkotlin/jvm/functions/Function1;
    move-result-object v1
    move-object/from16 v18, v1
    move-object v15, v3
    move-object/from16 v17, v4
    goto +17h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_asked_user I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_canceled I
    invoke-virtual v1, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    sget-object v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-object/from16 v17, v1
    move-object v15, v3
    move-object/from16 v18, v4
    move/from16 v20, v6
    goto -4eh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[AskUserQuestionCard] onCreateDetail: name="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v26, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", status="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "AgentTool"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v12, ""
    sget v13, Lcom/bytedance/trae/conversation/R$drawable;->question I
    const/4 v14, 0
    const/16 v21, 0
    const/16 v22, 516
    const/16 v23, 0
    move-object v11, v1
    move-object/from16 v19, v7
    invoke-direct/range v11 ... v23, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 16
    # ins_size=5
    const-string v0, "context"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "card"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 1
    const/4 v3, 0
    if-nez v0, +015h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +009h
    const-string v4, "answers"
    invoke-virtual v0, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-eqz v0, +003h
    goto +3h
    move v0, v3
    goto +2h
    move v0, v2
    sget-object v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v1
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "[AskUserQuestionCard] onUpdateCard: name="
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v8, ", status="
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v9, "AgentTool"
    invoke-virtual v5, v9, v6, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v11, v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;->getQuestionCount(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)I
    move-result v5
    sget-object v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v4, v6, +017h
    if-eqz v15, +010h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v15
    if-eqz v15, +00ah
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v15
    if-ne v15, v2, +004h
    move v15, v2
    goto +2h
    move v15, v3
    if-eqz v15, +004h
    move v15, v2
    goto +2h
    move v15, v3
    const-string v6, ""
    const-string v10, "getString(...)"
    if-eqz v15, +024h
    sget v15, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_asking_user I
    invoke-virtual v12, v15, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v15
    invoke-static v15, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, v15, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v13, v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v15, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v12, v15, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-virtual v13, v12, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v13, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v13, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v13, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    goto +5eh
    sget-object v15, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v4, v15, +038h
    if-eqz v0, +036h
    sget v15, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_asked_user I
    invoke-virtual v12, v15, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v15
    invoke-static v15, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, v15, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    if-lez v5, +014h
    invoke-virtual v12, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    sget v15, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_ask_question_count I
    new-array v0, v2, [Ljava/lang/Object;
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    aput-object v2, v0, v3
    invoke-virtual v12, v15, v5, v0, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v13, v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v13, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v13, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v13, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    invoke-direct v11, v14, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;->buildQuestionsView(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lkotlin/jvm/functions/Function1;
    move-result-object v12
    invoke-virtual v13, v12, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    goto +24h
    sget v15, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_canceled I
    invoke-virtual v12, v15, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v15
    invoke-static v15, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, v15, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v13, v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v15, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v12, v15, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-virtual v13, v12, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v13, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    sget-object v12, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    invoke-virtual v13, v12, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    invoke-virtual v13, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v13, Ljava/lang/StringBuilder;
    invoke-direct v13, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v9, v13, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
