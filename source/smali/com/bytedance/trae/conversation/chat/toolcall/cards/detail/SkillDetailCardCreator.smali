# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "SkillDetailCardCreator.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;
.field private static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$WIAAUJEmq8SqgVFTAI4Zp8aAuN0(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator  java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator$Companion$SkillDetailParsed  android.content.Context)android.view.View
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->onUpdateCard$lambda$2(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$X0qmeui4D_EN_C-MOS1EJKkDRpg(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator  java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator$Companion$SkillDetailParsed  android.content.Context)android.view.View
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->onCreateDetail$lambda$1(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed; Landroid/content/Context;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildDescriptionView(android.content.Context  java.lang.String  java.lang.String)android.view.View
    .registers 12
    # ins_size=4
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/4 v3, -2
    const/4 v4, -1
    if-eqz v10, +047h
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v5
    if-nez v5, +03fh
    new-instance v5, Landroid/widget/TextView;
    invoke-direct v5, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/4 v6, 2
    const/high16 v7, 1095761920
    invoke-virtual v5, v6, v7, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-static v2, Landroid/graphics/Typeface;->defaultFromStyle(I)Landroid/graphics/Typeface;
    move-result-object v2
    invoke-virtual v5, v2, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    const-string v2, "#484847"
    invoke-static v2, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v2
    invoke-virtual v5, v2, Landroid/widget/TextView;->setTextColor(I)V
    const/16 v2, 17
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v0, v2
    invoke-static v5, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    move-object v0, v11
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v5, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v0, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v5, v0, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v5, v10, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    check-cast v5, Landroid/view/View;
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v10, v4, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v5, v10, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v10, Landroid/widget/TextView;
    invoke-direct v10, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v0, Lcom/bytedance/trae/common_ui/R$style;->Trae_Text_Body_Sm I
    invoke-virtual v10, v9, v0, Landroid/widget/TextView;->setTextAppearance(Landroid/content/Context; I)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v9, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v10, v9, Landroid/widget/TextView;->setTextColor(I)V
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v10, v11, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    check-cast v10, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v4, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v10, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final extractSkillDetail(com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 3
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v2
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-nez v2, +003h
    goto +9h
    const-string/jumbo v0, skill_detail
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    return-object v2
    const/4 v2, 0
    return-object v2
.end method

.method private final extractSkillName(com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 3
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-nez v2, +004h
    const/4 v2, 0
    return-object v2
    const-string v0, "name"
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, skill_name
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final onCreateDetail$lambda$1(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator  java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator$Companion$SkillDetailParsed  android.content.Context)android.view.View
    .registers 5
    # ins_size=4
    const-string v0, "ctx"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;->getDescription()Ljava/lang/String;
    move-result-object v3
    invoke-direct v1, v4, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->buildDescriptionView(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private static final onUpdateCard$lambda$2(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator  java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator$Companion$SkillDetailParsed  android.content.Context)android.view.View
    .registers 5
    # ins_size=4
    const-string v0, "ctx"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;->getDescription()Ljava/lang/String;
    move-result-object v3
    invoke-direct v1, v4, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->buildDescriptionView(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method private final readString(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +033h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +02dh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +023h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +01dh
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +011h
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    move-object v0, v2
    return-object v0
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 23
    # ins_size=4
    move-object/from16 v0, v19
    move-object/from16 v1, v20
    move-object/from16 v2, v21
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, toolCallInfo
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v14
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->extractSkillName(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->extractSkillDetail(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v4
    sget-object v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;
    invoke-virtual v6, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;->parseSkillDetail(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;
    move-result-object v4
    move-object v6, v3
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +3h
    move v6, v7
    goto +2h
    move v6, v8
    if-nez v6, +01ch
    sget-object v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v14, v6, +00dh
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_launching_skill I
    new-array v9, v8, [Ljava/lang/Object;
    aput-object v3, v9, v7
    invoke-virtual v1, v6, v9, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +eh
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_launched_skill I
    new-array v9, v8, [Ljava/lang/Object;
    aput-object v3, v9, v7
    invoke-virtual v1, v6, v9, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +3h
    const-string v1, "Skill"
    move-object v10, v1
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;->getName()Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    move v6, v8
    goto +2h
    move v6, v7
    if-eqz v6, +00ah
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +004h
    move v6, v8
    goto +2h
    move v6, v7
    if-eqz v6, +004h
    move-object v11, v1
    goto +2h
    move-object v11, v5
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v9, "[SkillCard] onCreateDetail: name="
    invoke-direct v6, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v6, ", status="
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v6, "AgentTool"
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string/jumbo v2, ⚡
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->ic_toolcall_skill I
    const/4 v12, 0
    const/4 v13, 0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;->getDescription()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +003h
    move v7, v8
    if-eqz v7, +007h
    new-instance v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda1;
    invoke-direct v5, v0, v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;)V
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 804
    const/16 v18, 0
    move-object v6, v1
    move-object v7, v2
    move v8, v9
    move v9, v12
    move-object v12, v13
    move-object v13, v5
    invoke-direct/range v6 ... v18, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 12
    # ins_size=5
    const-string v11, "context"
    invoke-static v8, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v11, "card"
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v11, toolCallInfo
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    invoke-virtual v11, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v11
    invoke-direct v7, v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->extractSkillName(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->extractSkillDetail(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;->parseSkillDetail(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;
    move-result-object v2
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    move v3, v4
    goto +2h
    move v3, v5
    if-nez v3, +022h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v11, v3, +010h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_launching_skill I
    new-array v6, v5, [Ljava/lang/Object;
    aput-object v0, v6, v4
    invoke-virtual v8, v3, v6, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    goto +11h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_launched_skill I
    new-array v6, v5, [Ljava/lang/Object;
    aput-object v0, v6, v4
    invoke-virtual v8, v3, v6, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    goto +3h
    const-string v8, "Skill"
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;->getDescription()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +004h
    move v8, v5
    goto +2h
    move v8, v4
    if-eqz v8, +008h
    new-instance v8, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v8, v7, v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;)V
    goto +2h
    move-object v8, v1
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;->getName()Ljava/lang/String;
    move-result-object v8
    move-object v2, v8
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +004h
    move v2, v5
    goto +2h
    move v2, v4
    if-eqz v2, +009h
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    move v4, v5
    if-eqz v4, +003h
    move-object v1, v8
    invoke-virtual v9, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v9, v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v0, "[SkillCard] onUpdateCard: name="
    invoke-direct v9, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", status="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    const-string v10, "AgentTool"
    invoke-virtual v8, v10, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
