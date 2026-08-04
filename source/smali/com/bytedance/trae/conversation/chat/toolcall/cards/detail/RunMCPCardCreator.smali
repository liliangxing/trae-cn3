# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;
.super Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.source "RunMCPCardCreator.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$fVld9UJb2zf66DZOj-me0jn0f38(com.bytedance.trae.conversation.chat.toolcall.cards.detail.RunMCPCardCreator  com.bytedance.trae.im.model.ParsedToolCallInfo  java.lang.String  android.view.View)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildOnDetailClick$lambda$20(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Ljava/lang/String; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nhX0V2pXQ8E7qCHLsKHSoW382-4(java.util.List  android.content.Context)android.widget.LinearLayout
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildMcpToolListView$lambda$13(Ljava/util/List; Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;-><init>()V
    return-void 
.end method

.method private final buildDisplayName(java.lang.String  java.lang.String)java.lang.String
    .registers 12
    # ins_size=3
    if-nez v10, +006h
    if-nez v11, +004h
    const/4 v10, 0
    return-object v10
    const/4 v0, 2
    new-array v0, v0, [Ljava/lang/String;
    const/4 v1, 0
    aput-object v10, v0, v1
    const/4 v10, 1
    aput-object v11, v0, v10
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, " / "
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 62
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method private final buildMcpToolListView(java.util.List)kotlin.jvm.functions.Function1
    .registers 3
    # ins_size=2
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v2, 0
    return-object v2
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda0;-><init>(Ljava/util/List;)V
    return-object v0
.end method

.method private static final buildMcpToolListView$lambda$13(java.util.List  android.content.Context)android.widget.LinearLayout
    .registers 12
    # ins_size=2
    const-string v0, "ctx"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    check-cast v10, Ljava/lang/Iterable;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    const/4 v3, 0
    move v4, v3
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +067h
    add-int/lit8 v5, v4, 1
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    new-instance v7, Landroid/widget/LinearLayout;
    invoke-direct v7, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v7, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v8, 16
    invoke-virtual v7, v8, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v8, 24
    int-to-float v8, v8
    mul-float/2addr v8, v0
    float-to-int v8, v8
    invoke-virtual v7, v8, Landroid/widget/LinearLayout;->setMinimumHeight(I)V
    const/4 v8, -2
    if-lez v4, +013h
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v9, -1
    invoke-direct v4, v9, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v9, 4
    int-to-float v9, v9
    mul-float/2addr v9, v0
    float-to-int v9, v9
    iput v9, v4, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v4, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/TextView;
    invoke-direct v4, v11, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v4, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v11, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v4, v6, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v6, 2
    const/high16 v9, 1095761920
    invoke-virtual v4, v6, v9, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v4, v2, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v6, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v4, v6, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    check-cast v4, Landroid/view/View;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v8, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v4, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v7, Landroid/view/View;
    invoke-virtual v1, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move v4, v5
    goto -6ah
    return-object v1
.end method

.method private final buildOnDetailClick(com.bytedance.trae.im.model.ParsedToolCallInfo)kotlin.jvm.functions.Function1
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +01ch
    new-instance v1, Lcom/google/gson/GsonBuilder;
    invoke-direct v1, Lcom/google/gson/GsonBuilder;-><init>()V
    invoke-virtual v1, Lcom/google/gson/GsonBuilder;->setPrettyPrinting()Lcom/google/gson/GsonBuilder;
    move-result-object v1
    invoke-virtual v1, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;
    move-result-object v1
    move-object v2, v0
    check-cast v2, Lcom/google/gson/JsonElement;
    invoke-virtual v1, v2, Lcom/google/gson/Gson;->toJson(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v0
    goto +14h
    invoke-virtual v0, Lcom/google/gson/JsonObject;->toString()Ljava/lang/String;
    move-result-object v0
    goto +fh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getErrorMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda1;
    invoke-direct v1, v3, v4, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Ljava/lang/String;)V
    return-object v1
    :try_start_0xe
.end method

.method private static final buildOnDetailClick$lambda$20(com.bytedance.trae.conversation.chat.toolcall.cards.detail.RunMCPCardCreator  com.bytedance.trae.im.model.ParsedToolCallInfo  java.lang.String  android.view.View)kotlin.Unit
    .registers 21
    # ins_size=4
    move-object/from16 v0, v17
    const-string/jumbo v1, v
    move-object/from16 v2, v20
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[RunMCPCard] onDetailClick: mcpToolName="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    const-string/jumbo v5, server_name
    const/4 v6, 0
    if-eqz v4, +017h
    invoke-virtual v4, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    move-object v4, v6
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v6
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v7
    const-string/jumbo v8, tool_name
    if-eqz v7, +017h
    invoke-virtual v7, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v7
    if-eqz v7, +011h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v9
    if-eqz v9, +003h
    goto +2h
    move-object v7, v6
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v6
    invoke-direct v0, v4, v7, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildDisplayName(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "AgentTool"
    invoke-virtual v1, v4, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v8, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string/jumbo v4, tool_call_click
    invoke-virtual v1, v4, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-virtual/range v20, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    instance-of v3, v1, Landroidx/fragment/app/FragmentActivity;
    if-eqz v3, +005h
    check-cast v1, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    move-object v1, v6
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->findBottomSheet(Landroidx/fragment/app/FragmentActivity;)Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    move-result-object v1
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +017h
    invoke-virtual v3, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +011h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v6
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v6
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +01bh
    invoke-virtual v4, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +015h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v6
    if-eqz v4, +00bh
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    goto +3h
    move-object v6, v4
    goto +1dh
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +018h
    const-string v5, "name"
    invoke-virtual v4, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +010h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v6
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v0, v3, v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildDisplayName(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    if-eqz v1, +021h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;
    const/4 v8, 0
    const/4 v10, 0
    invoke-virtual/range v20, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_response I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v11
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 96
    const/16 v16, 0
    move-object/from16 v9, v19
    invoke-static/range v7 ... v16, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;->newInstance$default(Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->navigateTo(Landroidx/fragment/app/Fragment;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final collectMcpToolNames(com.bytedance.trae.im.model.ParsedToolCallInfo)java.util.List
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +01ah
    const-string/jumbo v2, server_name
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +01eh
    const-string/jumbo v3, tool_name
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +015h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v1
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +3h
    move-object v1, v2
    goto +1dh
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v5
    if-eqz v5, +018h
    const-string v2, "name"
    invoke-virtual v5, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +010h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v5, v1
    if-eqz v5, +006h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildDisplayName(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +007h
    invoke-static v5, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v5
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    return-object v5
.end method

.method private final findBottomSheet(androidx.fragment.app.FragmentActivity)com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet
    .registers 4
    # ins_size=2
    const/4 v0, 0
    if-nez v3, +003h
    return-object v0
    invoke-virtual v3, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    const-string v1, "ProcessDetailBottomSheet"
    invoke-virtual v3, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v3
    instance-of v1, v3, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    if-eqz v1, +005h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    return-object v0
.end method

.method protected onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 24
    # ins_size=4
    move-object/from16 v0, v20
    move-object/from16 v1, v21
    move-object/from16 v2, v22
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, toolCallInfo
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v3, +004h
    move v3, v4
    goto +2h
    move v3, v5
    sget-object v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v7
    const/4 v8, 0
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v8
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v6
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v7
    if-eqz v7, +01ah
    const-string/jumbo v9, server_name
    invoke-virtual v7, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v7
    if-eqz v7, +011h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v9
    if-eqz v9, +003h
    goto +2h
    move-object v7, v8
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v8
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v9
    if-eqz v9, +01bh
    const-string/jumbo v10, tool_name
    invoke-virtual v9, v10, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +012h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v8
    if-eqz v9, +008h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v9
    if-nez v9, +020h
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v9
    if-eqz v9, +019h
    const-string v10, "name"
    invoke-virtual v9, v10, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +011h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v8
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v8
    invoke-direct v0, v7, v9, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildDisplayName(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    sget-object v9, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v6, v9, +017h
    if-eqz v23, +010h
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v9
    if-eqz v9, +00ah
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v9
    if-ne v9, v4, +004h
    move v9, v4
    goto +2h
    move v9, v5
    if-eqz v9, +004h
    move v9, v4
    goto +2h
    move v9, v5
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->collectMcpToolNames(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v10
    const-string v11, "getString(...)"
    if-eqz v3, +085h
    if-eqz v9, +004h
    goto/16 +081h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v9
    aget v3, v3, v9
    if-eq v3, v4, +05ah
    const/4 v9, 2
    if-eq v3, v9, +01ah
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_canceled I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_mcp_tool I
    move-object v13, v1
    move v11, v3
    move v12, v5
    move/from16 v18, v12
    move-object v14, v7
    move-object v15, v8
    move-object/from16 v16, v15
    move-object/from16 v19, v16
    goto/16 +099h
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v3
    sget v9, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_called I
    invoke-virtual v1, v9, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-le v3, v4, +015h
    invoke-virtual/range v21, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v11, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_mcp_tool_count I
    new-array v12, v4, [Ljava/lang/Object;
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    aput-object v13, v12, v5
    invoke-virtual v1, v11, v3, v12, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v7
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->ic_mcp_tool I
    if-le v3, v4, +007h
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildMcpToolListView(Ljava/util/List;)Lkotlin/jvm/functions/Function1;
    move-result-object v3
    goto +2h
    move-object v3, v8
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildOnDetailClick(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lkotlin/jvm/functions/Function1;
    move-result-object v4
    move-object v14, v1
    move-object/from16 v16, v3
    move-object/from16 v19, v4
    move v12, v5
    move/from16 v18, v12
    move-object v15, v8
    move-object v13, v9
    goto/16 +05ch
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_failed I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildOnDetailClick(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lkotlin/jvm/functions/Function1;
    move-result-object v9
    move-object v13, v1
    move v11, v3
    move v12, v4
    move/from16 v18, v5
    move-object v14, v7
    move-object v15, v8
    move-object/from16 v16, v15
    move-object/from16 v19, v9
    goto +3eh
    if-eqz v9, +023h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_calling I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v1, v9, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->ic_mcp_tool I
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildMcpToolListView(Ljava/util/List;)Lkotlin/jvm/functions/Function1;
    move-result-object v10
    move-object v15, v1
    move-object v13, v3
    move/from16 v18, v4
    move v12, v5
    move-object v14, v8
    move-object/from16 v19, v14
    move v11, v9
    move-object/from16 v16, v10
    goto +1bh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_calling I
    invoke-virtual v1, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_mcp_tool I
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildMcpToolListView(Ljava/util/List;)Lkotlin/jvm/functions/Function1;
    move-result-object v9
    move-object v13, v1
    move v11, v3
    move/from16 v18, v4
    move v12, v5
    move-object v14, v8
    move-object v15, v14
    move-object/from16 v19, v15
    move-object/from16 v16, v9
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[RunMCPCard] onCreateDetail: name="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", status="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", mcpToolName="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "AgentTool"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const-string v10, ""
    move-object v9, v1
    move-object/from16 v17, v6
    invoke-direct/range v9 ... v19, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1;)V
    return-object v1
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 14
    # ins_size=5
    const-string v0, "context"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "card"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v3
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +01ah
    const-string/jumbo v6, server_name
    invoke-virtual v4, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v4, v5
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v6
    if-eqz v6, +01bh
    const-string/jumbo v7, tool_name
    invoke-virtual v6, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +012h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    move-object v6, v5
    if-eqz v6, +008h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +020h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v6
    if-eqz v6, +019h
    const-string v7, "name"
    invoke-virtual v6, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +011h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    move-object v6, v5
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v5
    invoke-direct v9, v4, v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildDisplayName(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    sget-object v6, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-ne v3, v6, +017h
    if-eqz v13, +010h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v13
    if-eqz v13, +00ah
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v13
    if-ne v13, v1, +004h
    move v13, v1
    goto +2h
    move v13, v2
    if-eqz v13, +004h
    move v13, v1
    goto +2h
    move v13, v2
    invoke-direct v9, v12, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->collectMcpToolNames(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v6
    const-string v7, "getString(...)"
    if-eqz v0, +090h
    if-eqz v13, +004h
    goto/16 +08ch
    sget-object v13, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v0
    aget v13, v13, v0
    if-eq v13, v1, +062h
    const/4 v0, 2
    if-eq v13, v0, +01eh
    sget v13, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_canceled I
    invoke-virtual v10, v13, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v11, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    sget v10, Lcom/bytedance/trae/conversation/R$drawable;->ic_mcp_tool I
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v11, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v11, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    goto/16 +088h
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v13
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_called I
    invoke-virtual v10, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    if-le v13, v1, +015h
    invoke-virtual v10, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v10
    sget v0, Lcom/bytedance/trae/conversation/R$plurals;->trae_chat_tool_mcp_tool_count I
    new-array v7, v1, [Ljava/lang/Object;
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    aput-object v8, v7, v2
    invoke-virtual v10, v0, v13, v7, Landroid/content/res/Resources;->getQuantityString(I I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v4
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v11, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    sget v10, Lcom/bytedance/trae/conversation/R$drawable;->ic_mcp_tool I
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v11, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v11, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    if-le v13, v1, +006h
    invoke-direct v9, v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->buildMcpToolListView(Ljava/util/List;)Lkotlin/jvm/functions/Function1;
    move-result-object v5
    invoke-virtual v11, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setContentView(Lkotlin/jvm/functions/Function1;)V
    goto +46h
    sget v13, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_failed I
    invoke-virtual v10, v13, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v11, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v11, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    sget v10, Lcom/bytedance/trae/conversation/R$drawable;->warning I
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v11, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    goto +26h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_calling I
    invoke-virtual v10, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v11, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    if-eqz v13, +008h
    sget v13, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_mcp_waiting I
    invoke-virtual v10, v13, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v11, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    sget v10, Lcom/bytedance/trae/conversation/R$drawable;->ic_mcp_tool I
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v11, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v11, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v11, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    sget-object v10, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v13, "[RunMCPCard] onUpdateCard: name="
    invoke-direct v11, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", status="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", mcpToolName="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    const-string v12, "AgentTool"
    invoke-virtual v10, v12, v11, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
