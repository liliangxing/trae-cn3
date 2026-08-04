# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;
.super Ljava/lang/Object;
.source "TraeRefDialog.kt"

.field private static final DEFAULT_LISTENER:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;


.method public static synthetic $r8$lambda$3mjuXAgolDLvgkR6aalwm084wAw(android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefSource  com.google.android.material.bottomsheet.BottomSheetDialog)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildContentView$lambda$11$lambda$8(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource; Lcom/google/android/material/bottomsheet/BottomSheetDialog;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$dQTXSu0vnMR7XZQDFaWFCeWiSDs(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildSourceItem$lambda$25$lambda$13(Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$dnbKVayCFndf6kpFTm1Q4_E7LzU(com.google.android.material.bottomsheet.BottomSheetDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildContentView$lambda$4$lambda$3(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$sc8OK-vxBnVthCXq3YV4Y6VTO4g(com.google.android.material.bottomsheet.BottomSheetDialog  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildContentView$lambda$1(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$y69kF4WupVCCa2GpcIcX3CB4Q_0(android.view.View  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->DEFAULT_LISTENER$lambda$0(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->DEFAULT_LISTENER Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final DEFAULT_LISTENER$lambda$0(android.view.View  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup)void
    .registers 4
    # ins_size=2
    const-string v0, "anchor"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "group"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    const-string v1, "getContext(...)"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v0, v2, v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->show(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Ljava/util/List;)V
    return-void 
.end method

.method private final buildContentView(android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup  java.util.List  com.google.android.material.bottomsheet.BottomSheetDialog)android.view.View
    .registers 24
    # ins_size=5
    move-object/from16 v6, v20
    move-object/from16 v7, v23
    invoke-virtual/range v20, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v8, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda2;
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda2;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog;)V
    invoke-virtual v7, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    new-instance v9, Landroid/widget/LinearLayout;
    invoke-direct v9, v6, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v10, 1
    invoke-virtual v9, v10, Landroid/widget/LinearLayout;->setOrientation(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_bottom_sheet I
    invoke-virtual v9, v0, Landroid/widget/LinearLayout;->setBackgroundResource(I)V
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;
    const/16 v1, 545
    invoke-static v1, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildContentView$dp(I F)I
    move-result v1
    const/4 v11, -1
    invoke-direct v0, v11, v1, Landroid/view/ViewGroup$LayoutParams;-><init>(I I)V
    invoke-virtual v9, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v12, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v12
    move-object/from16 v1, v20
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    invoke-virtual v12, v0, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setMode(Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode; Z)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->getSources()Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " sources"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v12, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(Ljava/lang/CharSequence;)V
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CLOSE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-virtual v12, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightAction(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda3;
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda3;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog;)V
    invoke-virtual v12, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_bottom_sheet I
    invoke-virtual v12, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setBackgroundResource(I)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -2
    invoke-direct v0, v11, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v12, Landroid/view/View;
    invoke-virtual v9, v12, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    const/16 v12, 16
    if-eqz v22, +03ah
    move-object/from16 v0, v22
    check-cast v0, Ljava/lang/Iterable;
    const/16 v2, 10
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-static v2, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v2
    invoke-static v2, v12, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v2
    new-instance v3, Ljava/util/LinkedHashMap;
    invoke-direct v3, v2, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v3, Ljava/util/Map;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;->getLink()Ljava/lang/String;
    move-result-object v4
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->normalizeUrl(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-interface v3, v4, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1ah
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v3
    move-object v13, v3
    new-instance v14, Landroidx/core/widget/NestedScrollView;
    invoke-direct v14, v6, Landroidx/core/widget/NestedScrollView;-><init>(Landroid/content/Context;)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v2, 1065353216
    const/4 v3, 0
    invoke-direct v0, v11, v3, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v14, v0, Landroidx/core/widget/NestedScrollView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v15, Landroid/widget/LinearLayout;
    invoke-direct v15, v6, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v15, v10, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-static v12, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildContentView$dp(I F)I
    move-result v0
    invoke-virtual v15, v3, v3, v3, v0, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-direct v0, v11, v1, Landroid/view/ViewGroup$LayoutParams;-><init>(I I)V
    invoke-virtual v15, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->getSources()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v16
    move v5, v3
    invoke-interface/range v16, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +07fh
    invoke-interface/range v16, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    add-int/lit8 v17, v5, 1
    if-gez v5, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;->getUrl()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->normalizeUrl(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-interface v13, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda4;
    invoke-direct v4, v6, v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda4;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource; Lcom/google/android/material/bottomsheet/BottomSheetDialog;)V
    move-object/from16 v1, v20
    move-object/from16 v18, v4
    move v4, v8
    move v12, v5
    move-object/from16 v5, v18
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildSourceItem(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference; F Lkotlin/jvm/functions/Function0;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v15, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->getSources()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    sub-int/2addr v0, v10
    if-ge v12, v0, +03ah
    new-instance v0, Landroid/view/View;
    invoke-direct v0, v6, Landroid/view/View;-><init>(Landroid/content/Context;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v6, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/view/View;->setBackgroundColor(I)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v1, v11, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v2, 16
    invoke-static v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildContentView$dp(I F)I
    move-result v3
    invoke-virtual v1, v3, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-static v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildContentView$dp(I F)I
    move-result v3
    invoke-virtual v1, v3, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    invoke-static v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildContentView$dp(I F)I
    move-result v3
    iput v3, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-static v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildContentView$dp(I F)I
    move-result v3
    iput v3, v1, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v15, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto +3h
    const/16 v2, 16
    move v12, v2
    move/from16 v5, v17
    goto/16 -081h
    check-cast v15, Landroid/view/View;
    invoke-virtual v14, v15, Landroidx/core/widget/NestedScrollView;->addView(Landroid/view/View;)V
    check-cast v14, Landroid/view/View;
    invoke-virtual v9, v14, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v9, Landroid/view/View;
    return-object v9
.end method

.method private static final buildContentView$dp(int  float)int
    .registers 2
    # ins_size=2
    int-to-float v0, v0
    mul-float/2addr v0, v1
    float-to-int v0, v0
    return v0
.end method

.method private static final buildContentView$lambda$1(com.google.android.material.bottomsheet.BottomSheetDialog  android.content.DialogInterface)void
    .registers 3
    # ins_size=2
    instance-of v0, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    if-eqz v0, +005h
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    goto +2h
    const/4 v2, 0
    if-nez v2, +003h
    return-void 
    sget v2, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +008h
    const v2, 17170445
    invoke-virtual v1, v2, Landroid/view/View;->setBackgroundResource(I)V
    return-void 
.end method

.method private static final buildContentView$lambda$11$lambda$8(android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefSource  com.google.android.material.bottomsheet.BottomSheetDialog)kotlin.Unit
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;->getUrl()Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->openUrl(Landroid/content/Context; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->dismiss()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final buildContentView$lambda$4$lambda$3(com.google.android.material.bottomsheet.BottomSheetDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->dismiss()V
    return-void 
.end method

.method private final buildSourceItem(android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefSource  com.bytedance.trae.conversation.chat.block.renderer.ref.WebReference  float  kotlin.jvm.functions.Function0)android.view.View
    .registers 28
    # ins_size=6
    move-object/from16 v0, v23
    move/from16 v1, v26
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v0, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    new-instance v4, Landroid/widget/LinearLayout;
    invoke-direct v4, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v5, 1
    invoke-virtual v4, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v6, 16
    invoke-static v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildSourceItem$dp$12(I F)I
    move-result v7
    invoke-static v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildSourceItem$dp$12(I F)I
    move-result v8
    const/4 v9, 0
    invoke-virtual v4, v7, v9, v8, v9, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    invoke-virtual v4, v5, Landroid/widget/LinearLayout;->setClickable(Z)V
    new-instance v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda1;
    move-object/from16 v8, v27
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v4, v7, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v7, Landroid/widget/LinearLayout;
    invoke-direct v7, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v7, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v10, -1
    const/4 v11, -2
    invoke-direct v8, v10, v11, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v8, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v8, Landroid/widget/LinearLayout;
    invoke-direct v8, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v8, v9, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v8, v6, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v12, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v12, v10, v11, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v12, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/4 v12, 0
    if-eqz v25, +007h
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;->getFavicon()Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v12
    new-instance v14, Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-direct v14, v0, Lcom/facebook/drawee/view/SimpleDraweeView;-><init>(Landroid/content/Context;)V
    invoke-virtual v14, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v15
    check-cast v15, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    sget v10, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_web I
    invoke-virtual v15, v10, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setPlaceholderImage(I)V
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    invoke-static v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildSourceItem$dp$12(I F)I
    move-result v15
    invoke-static v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildSourceItem$dp$12(I F)I
    move-result v11
    invoke-direct v10, v15, v11, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v11, 4
    invoke-static v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildSourceItem$dp$12(I F)I
    move-result v15
    invoke-virtual v10, v15, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    iput v6, v10, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v14, v10, Lcom/facebook/drawee/view/SimpleDraweeView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v14, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v10
    check-cast v10, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    const v15, 1074370970
    mul-float/2addr v15, v1
    invoke-static v15, Lcom/facebook/drawee/generic/RoundingParams;->fromCornersRadius(F)Lcom/facebook/drawee/generic/RoundingParams;
    move-result-object v15
    invoke-virtual v10, v15, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setRoundingParams(Lcom/facebook/drawee/generic/RoundingParams;)V
    move-object v10, v14
    check-cast v10, Landroid/view/View;
    invoke-virtual v8, v10, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move-object v10, v13
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +00bh
    invoke-static v10, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v10
    if-eqz v10, +003h
    goto +3h
    move v10, v9
    goto +2h
    move v10, v5
    if-nez v10, +012h
    const-string v10, "http"
    const/4 v15, 2
    invoke-static v13, v10, v9, v15, v12, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +009h
    invoke-static v13, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v10
    invoke-virtual v14, v10, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    new-instance v10, Landroid/widget/TextView;
    invoke-direct v10, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;->getHost()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v10, v13, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v13
    sget v14, Lcom/bytedance/trae/common_ui/R$dimen;->trae_footnote_footnote_font_size_sp I
    invoke-virtual v13, v14, Landroid/content/res/Resources;->getDimension(I)F
    move-result v13
    invoke-virtual v10, v9, v13, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v13
    sget v14, Lcom/bytedance/trae/common_ui/R$dimen;->trae_footnote_footnote_line_height_dp I
    invoke-virtual v13, v14, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v13
    invoke-static v10, v13, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-virtual v10, v3, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v10, v5, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v13, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v10, v13, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    new-instance v13, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v14, 1065353216
    const/4 v15, -2
    invoke-direct v13, v9, v15, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    iput v6, v13, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v13, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v10, Landroid/view/View;
    invoke-virtual v8, v10, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v8, Landroid/view/View;
    invoke-virtual v7, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    if-eqz v25, +016h
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;->getTitle()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +010h
    move-object v8, v6
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/2addr v8, v5
    if-eqz v8, +003h
    goto +2h
    move-object v6, v12
    if-nez v6, +01ah
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;->getTitle()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +00dh
    move-object v8, v6
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/2addr v8, v5
    if-eqz v8, +003h
    goto +2h
    move-object v6, v12
    if-nez v6, +006h
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;->getHost()Ljava/lang/String;
    move-result-object v6
    new-instance v8, Landroid/widget/TextView;
    invoke-direct v8, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v8, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    sget v10, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_sm_md_font_size_sp I
    invoke-virtual v6, v10, Landroid/content/res/Resources;->getDimension(I)F
    move-result v6
    invoke-virtual v8, v9, v6, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    sget v10, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_sm_md_line_height_dp I
    invoke-virtual v6, v10, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v6
    invoke-static v8, v6, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-virtual v8, v2, Landroid/widget/TextView;->setTextColor(I)V
    const-string/jumbo v2, sans-serif-medium
    invoke-static v2, v9, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v2
    invoke-virtual v8, v2, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v8, v5, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v2, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v8, v2, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-static v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildSourceItem$dp$12(I F)I
    move-result v2
    invoke-virtual v8, v9, v2, v9, v9, Landroid/widget/TextView;->setPadding(I I I I)V
    check-cast v8, Landroid/view/View;
    invoke-virtual v7, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    if-eqz v25, +01ah
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;->getDescription()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +014h
    move-object v6, v2
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v5
    if-eqz v6, +003h
    goto +2h
    move-object v2, v12
    if-nez v2, +003h
    goto +4h
    move-object/from16 v16, v2
    goto +9h
    if-eqz v25, +006h
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;->getContent()Ljava/lang/String;
    move-result-object v12
    move-object/from16 v16, v12
    move-object/from16 v2, v16
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00ah
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move v5, v9
    if-nez v5, +04ch
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const-string v17, "
"
    const-string v18, " "
    const/16 v19, 0
    const/16 v20, 4
    const/16 v21, 0
    invoke-static/range v16 ... v21, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v2, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/common_ui/R$dimen;->trae_footnote_footnote_font_size_sp I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getDimension(I)F
    move-result v5
    invoke-virtual v2, v9, v5, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual/range v23, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v5, Lcom/bytedance/trae/common_ui/R$dimen;->trae_footnote_footnote_line_height_dp I
    invoke-virtual v0, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    invoke-static v2, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v0, 3
    invoke-virtual v2, v0, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v0, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-static v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildSourceItem$dp$12(I F)I
    move-result v0
    invoke-virtual v2, v9, v0, v9, v9, Landroid/widget/TextView;->setPadding(I I I I)V
    check-cast v2, Landroid/view/View;
    invoke-virtual v7, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v7, Landroid/view/View;
    invoke-virtual v4, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v0, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v4, Landroid/view/View;
    return-object v4
.end method

.method private static final buildSourceItem$dp$12(int  float)int
    .registers 2
    # ins_size=2
    int-to-float v0, v0
    mul-float/2addr v0, v1
    float-to-int v0, v0
    return v0
.end method

.method private static final buildSourceItem$lambda$25$lambda$13(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final normalizeUrl(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    const/4 v0, 1
    new-array v0, v0, [C
    const/4 v1, 0
    const/16 v2, 47
    aput-char v2, v0, v1
    invoke-static v4, v0, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v4
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method private final openUrl(android.content.Context  java.lang.String)void
    .registers 5
    # ins_size=3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.VIEW"
    invoke-static v4, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v4
    invoke-direct v0, v1, v4, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    instance-of v4, v3, Landroid/app/Activity;
    if-nez v4, +007h
    const/high16 v4, 268435456
    invoke-virtual v0, v4, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method

.method public static synthetic show$default(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefDialog  android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup  java.util.List  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->show(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Ljava/util/List;)V
    return-void 
.end method

.method public final getDEFAULT_LISTENER()com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefClickListener
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->DEFAULT_LISTENER Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
    return-object v0
.end method

.method public final show(android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup  java.util.List)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "group"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->getSources()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    new-instance v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    invoke-direct v0, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;-><init>(Landroid/content/Context;)V
    invoke-direct v1, v2, v3, v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->buildContentView(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Ljava/util/List; Lcom/google/android/material/bottomsheet/BottomSheetDialog;)Landroid/view/View;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setContentView(Landroid/view/View;)V
    invoke-virtual v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->show()V
    return-void 
.end method
