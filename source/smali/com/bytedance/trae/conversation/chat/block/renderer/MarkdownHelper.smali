# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
.super Ljava/lang/Object;
.source "MarkdownHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic createMarkdownContent$default(com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper  com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String  boolean  com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper$ListBulletStyle  int  java.lang.Object)com.larus.business.markdown.api.model.MarkdownContent
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 1
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;->DEFAULT Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->createMarkdownContent(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;)Lcom/larus/business/markdown/api/model/MarkdownContent;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic setMarkdownContent$default(com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper  com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String  boolean  com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper$ListBulletStyle  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 1
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;->DEFAULT Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;)V
    return-void 
.end method

.method public static synthetic setMarkdownContentWithRef$default(com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper  com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String  boolean  com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper$ListBulletStyle  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 1
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;->DEFAULT Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContentWithRef(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;)V
    return-void 
.end method

.method public final createMarkdownContent(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String  boolean  com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper$ListBulletStyle)com.larus.business.markdown.api.model.MarkdownContent
    .registers 82
    # ins_size=5
    move-object/from16 v0, v78
    const-string/jumbo v1, text
    move-object/from16 v4, v79
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "listBulletStyle"
    move-object/from16 v2, v81
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-virtual/range v78, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-virtual v3, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v3, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->widthPixels I
    const/16 v7, 16
    int-to-float v7, v7
    mul-float/2addr v7, v5
    float-to-int v7, v7
    mul-int/lit8 v8, v7, 2
    sub-int/2addr v6, v8
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setMarkdownWidth(I)V
    const/4 v8, 1
    int-to-float v9, v8
    mul-float/2addr v9, v5
    float-to-int v9, v9
    const/4 v10, 2
    int-to-float v11, v10
    mul-float/2addr v11, v5
    float-to-int v12, v11
    const/4 v13, 4
    int-to-float v13, v13
    mul-float/2addr v13, v5
    const/16 v14, 8
    int-to-float v14, v14
    mul-float/2addr v14, v5
    float-to-int v14, v14
    const/16 v15, 15
    int-to-float v15, v15
    mul-float/2addr v15, v5
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v3, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    sget-object v16, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v81, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;->ordinal()I
    move-result v17
    aget v10, v16, v17
    if-eq v10, v8, +01fh
    const/4 v8, 2
    if-ne v10, v8, +016h
    new-instance v8, Lcom/larus/business/markdown/api/model/ListConfig;
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v3, v10, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    const/4 v2, 1
    const/4 v4, 0
    invoke-direct v8, v4, v10, v2, v4, Lcom/larus/business/markdown/api/model/ListConfig;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v44, v8
    goto +ah
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move v2, v8
    const/16 v44, 0
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v81, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;->ordinal()I
    move-result v8
    aget v4, v4, v8
    const/4 v8, 0
    if-eq v4, v2, +01ah
    const/4 v2, 2
    if-ne v4, v2, +011h
    new-instance v4, Lcom/larus/business/markdown/api/model/ListStyle;
    sget-object v10, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$DiscListSymbolStrategy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$DiscListSymbolStrategy;
    check-cast v10, Lcom/larus/business/markdown/api/model/ListSymbolStrategy;
    move/from16 v17, v7
    const/4 v7, 0
    invoke-direct v4, v10, v8, v2, v7, Lcom/larus/business/markdown/api/model/ListStyle;-><init>(Lcom/larus/business/markdown/api/model/ListSymbolStrategy; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v46, v4
    goto +ch
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move/from16 v17, v7
    const/4 v7, 0
    move-object/from16 v46, v7
    const/4 v2, 0
    invoke-virtual v0, v1, v13, v2, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setInlineCodeStyle(I F F F)V
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1;-><init>()V
    sget-object v4, Lcom/larus/business/markdown/api/MarkdownService;->Companion Lcom/larus/business/markdown/api/MarkdownService$Companion;
    invoke-virtual v4, Lcom/larus/business/markdown/api/MarkdownService$Companion;->getService()Lcom/larus/business/markdown/api/MarkdownService;
    move-result-object v4
    if-eqz v4, +16fh
    move-object v7, v0
    check-cast v7, Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;
    new-instance v10, Lcom/larus/business/markdown/api/model/ThematicBreakConfig;
    move-object/from16 v38, v10
    const-wide/high16 v18, 4602678819172646912
    move v11, v9
    float-to-double v8, v5
    mul-double v8, v8, v18
    double-to-int v5, v8
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l2 I
    invoke-static v3, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-direct v10, v5, v8, Lcom/larus/business/markdown/api/model/ThematicBreakConfig;-><init>(Ljava/lang/Integer; Ljava/lang/Integer;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l2 I
    invoke-static v3, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v3, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v3, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v3, v10, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    new-instance v18, Lcom/larus/business/markdown/api/model/BlockQuoteConfig;
    move-object/from16 v37, v18
    const/16 v19, 1
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v20
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v21
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v22
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v23
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v24
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v25
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v26
    invoke-direct/range v18 ... v26, Lcom/larus/business/markdown/api/model/BlockQuoteConfig;-><init>(Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v3, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v3, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    sget-object v58, Lcom/larus/business/markdown/api/model/TitleStyle;->LARGE Lcom/larus/business/markdown/api/model/TitleStyle;
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v3, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    new-instance v47, Lcom/larus/business/markdown/api/model/CodeBlockConfig;
    move-object/from16 v39, v47
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v48
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v49
    const/16 v50, 1
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v51
    const/16 v52, 0
    const/16 v53, 0
    const/16 v54, 0
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 1
    const/16 v59, 1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v60
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v61
    const/16 v62, 0
    const/16 v63, 0
    const/16 v64, 0
    const/16 v65, 0
    const/16 v66, 0
    const/16 v67, 0
    const/16 v68, 0
    const/16 v69, 0
    const/16 v70, 0
    const/16 v71, 0
    const/16 v72, 0
    const/16 v73, 0
    const/16 v74, 0
    const v75, 134201776
    const/16 v76, 0
    invoke-direct/range v47 ... v76, Lcom/larus/business/markdown/api/model/CodeBlockConfig;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Z Ljava/lang/Integer; I Ljava/lang/Integer; Z Ljava/lang/String; Z Z Lcom/larus/business/markdown/api/model/TitleStyle; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Z Ljava/lang/Integer; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Ljava/lang/Boolean; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v3, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v3, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    new-instance v47, Lcom/larus/business/markdown/api/model/TableConfig;
    move-object/from16 v40, v47
    const/16 v48, 0
    const/16 v49, 0
    invoke-static v15, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v50
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v51
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v52
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v54
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v55
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v56
    const/16 v57, 0
    invoke-static/range v17, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v58
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v59
    const/16 v60, 0
    const/16 v61, 0
    const/16 v62, 0
    const/16 v63, 0
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v67
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v68
    const v69, 520739
    invoke-direct/range v47 ... v70, Lcom/larus/business/markdown/api/model/TableConfig;-><init>(Z I Ljava/lang/Float; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/Integer; Z Z Z Z Lcom/larus/business/markdown/api/model/TitleStyle; Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v43
    new-instance v6, Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;
    move-object/from16 v17, v6
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v1, 1070386381
    invoke-static v1, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v29
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v33
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v34
    const/16 v35, 0
    const/16 v36, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v45, 0
    const/16 v47, 0
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v48
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v54, 0
    const v55, -1450805249
    const/16 v56, 31
    invoke-direct/range v17 ... v57, Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;-><init>(I Ljava/lang/Integer; Ljava/util/List; Ljava/lang/String; Z Z Ljava/lang/Integer; I I Ljava/lang/Float; F Ljava/lang/Float; I I Lcom/larus/business/markdown/api/model/BgListItemConfig; Ljava/lang/Integer; Ljava/lang/Integer; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lcom/larus/business/markdown/api/model/BlockQuoteConfig; Lcom/larus/business/markdown/api/model/ThematicBreakConfig; Lcom/larus/business/markdown/api/model/CodeBlockConfig; Lcom/larus/business/markdown/api/model/TableConfig; Lcom/larus/business/markdown/api/model/PhoneNumberConfig; Lio/noties/markwon/core/spans/ListMarginInfo; Ljava/util/List; Lcom/larus/business/markdown/api/model/ListConfig; Ljava/lang/Integer; Lcom/larus/business/markdown/api/model/ListStyle; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig; Z Ljava/util/Map; Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler; Z I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v1, 0
    const/16 v8, 16
    const/4 v9, 0
    move-object v2, v4
    move-object v3, v7
    move-object/from16 v4, v79
    move/from16 v5, v80
    move-object v7, v1
    invoke-static/range v2 ... v9, Lcom/larus/business/markdown/api/MarkdownService$DefaultImpls;->createMarkdownContent$default(Lcom/larus/business/markdown/api/MarkdownService; Lcom/larus/business/markdown/api/view/text/IMarkdownTextView; Ljava/lang/String; Z Lcom/larus/business/markdown/api/model/CustomMarkDownInfo; Ljava/util/Map; I Ljava/lang/Object;)Lcom/larus/business/markdown/api/model/MarkdownContent;
    move-result-object v1
    goto +2h
    move-object v1, v7
    if-eqz v1, +00eh
    check-cast v0, Landroid/view/View;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$1;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$1;-><init>()V
    check-cast v2, Lcom/larus/business/markdown/api/model/CodeCopySpanClickListener;
    invoke-interface v1, v0, v2, Lcom/larus/business/markdown/api/model/MarkdownContent;->setCodeCopySpanClickListener(Landroid/view/View; Lcom/larus/business/markdown/api/model/CodeCopySpanClickListener;)V
    return-object v1
.end method

.method public final setMarkdownContent(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String  boolean  com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper$ListBulletStyle)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, text
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "listBulletStyle"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;->stripBeforeMarkdown(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;->getSafeText()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setRefStripResult(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;)V
    invoke-virtual v1, v2, v0, v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->createMarkdownContent(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;)Lcom/larus/business/markdown/api/model/MarkdownContent;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setMarkdown(Lcom/larus/business/markdown/api/model/MarkdownContent;)V
    return-void 
.end method

.method public final setMarkdownContentWithRef(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String  boolean  com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper$ListBulletStyle)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, text
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "listBulletStyle"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;->stripBeforeMarkdown(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;->getSafeText()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setRefStripResult(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;)V
    invoke-virtual v1, v2, v0, v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->createMarkdownContent(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;)Lcom/larus/business/markdown/api/model/MarkdownContent;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setMarkdown(Lcom/larus/business/markdown/api/model/MarkdownContent;)V
    return-void 
.end method
