# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "BrainstormSummarySheet.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$Companion;
.field private static final SHEET_HEIGHT_RATIO:F
.field private static final TAG:Ljava/lang/String;
.field private onDismissCallback:Lkotlin/jvm/functions/Function0;
.field private summary:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;


.method public static synthetic $r8$lambda$5Em9N1Tq58S-03vq1RnAhWPuFjM(android.content.Context  java.lang.String)java.lang.CharSequence
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->onViewCreated$lambda$2(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$QmkPNfxkPhtYmfyWDIp8IlT41lk(android.content.Context  java.lang.String)java.lang.CharSequence
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->onViewCreated$lambda$3(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$lpr9qHi-dyJ3q1D_0_4ogEPMk90(com.bytedance.trae.conversation.brainstorm.widget.BrainstormSummarySheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->onViewCreated$lambda$4(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    return-void 
.end method

.method public static final synthetic access$setSummary$p(com.bytedance.trae.conversation.brainstorm.widget.BrainstormSummarySheet  com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->summary Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    return-void 
.end method

.method private static final onViewCreated$lambda$2(android.content.Context  java.lang.String)java.lang.CharSequence
    .registers 5
    # ins_size=2
    const-string v0, "it"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_summary_bullet_prefix I
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/Object;
    const/4 v2, 0
    aput-object v4, v1, v2
    invoke-virtual v3, v0, v1, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    return-object v3
.end method

.method private static final onViewCreated$lambda$3(android.content.Context  java.lang.String)java.lang.CharSequence
    .registers 5
    # ins_size=2
    const-string v0, "it"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_summary_action_prefix I
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/Object;
    const/4 v2, 0
    aput-object v4, v1, v2
    invoke-virtual v3, v0, v1, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    return-object v3
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.conversation.brainstorm.widget.BrainstormSummarySheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->dismiss()V
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->onDismissCallback Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final getOnDismissCallback()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->onDismissCallback Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_brainstorm_summary I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onStart()void
    .registers 4
    # ins_size=1
    invoke-super v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onStart()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->getDialog()Landroid/app/Dialog;
    move-result-object v0
    if-eqz v0, +033h
    sget v1, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v0, v1, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-nez v0, +003h
    goto +29h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-float v1, v1
    const v2, 1061997773
    mul-float/2addr v1, v2
    float-to-int v1, v1
    invoke-virtual v0, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v2
    iput v1, v2, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v0, v2, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-static v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    const/4 v1, 3
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 15
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v12, v13, v14, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    iget-object v14, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->summary Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    if-nez v14, +003h
    return-void 
    invoke-virtual v13, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_key_points I
    invoke-virtual v13, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->getKeyPoints()Ljava/util/List;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    const-string v2, "
"
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$$ExternalSyntheticLambda0;
    invoke-direct v9, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$$ExternalSyntheticLambda0;-><init>(Landroid/content/Context;)V
    const/16 v10, 30
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v1, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_action_items I
    invoke-virtual v13, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->getActionItems()Ljava/util/List;
    move-result-object v14
    move-object v3, v14
    check-cast v3, Ljava/lang/Iterable;
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$$ExternalSyntheticLambda1;
    invoke-direct v9, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$$ExternalSyntheticLambda1;-><init>(Landroid/content/Context;)V
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v14
    check-cast v14, Ljava/lang/CharSequence;
    invoke-virtual v1, v14, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v14, Lcom/bytedance/trae/conversation/R$id;->btn_close_summary I
    invoke-virtual v13, v14, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v13
    new-instance v14, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$$ExternalSyntheticLambda2;
    invoke-direct v14, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;)V
    invoke-virtual v13, v14, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final setOnDismissCallback(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->onDismissCallback Lkotlin/jvm/functions/Function0;
    return-void 
.end method
