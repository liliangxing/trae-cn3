# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
.super Landroid/widget/LinearLayout;
.source "VoiceRecordingOverlay.kt"

.field private final audioVisualizer:Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;
.field private final blurCircle:Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
.field private final cancelCenterColor:I
.field private final cancelEdgeColor:I
.field private final cancelForegroundColor:I
.field private currentState:Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
.field private final dp:F
.field private needVibrate:Z
.field private final normalCenterColor:I
.field private final normalEdgeColor:I
.field private final normalTextColor:I
.field private final normalWaveColor:I
.field private final tipTextView:Landroid/widget/TextView;
.field private final visualizerContainer:Landroid/widget/FrameLayout;


.method public constructor <init>(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet)void
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 24
    # ins_size=4
    move-object/from16 v0, v20
    move-object/from16 v7, v21
    const-string v1, "context"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v20 ... v23, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    sget-object v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;->SPEAKING Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->currentState Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    const/4 v8, 1
    iput-boolean v8, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->needVibrate Z
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_brand I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    iput v9, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->normalCenterColor I
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_brand_300 I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    iput v10, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->normalEdgeColor I
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_onaccent I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v11
    iput v11, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->normalTextColor I
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_onaccent I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->normalWaveColor I
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_red_300 I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->cancelCenterColor I
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_red_100 I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->cancelEdgeColor I
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_status_error_default I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->cancelForegroundColor I
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v12, v1, Landroid/util/DisplayMetrics;->density F
    iput v12, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->dp F
    invoke-virtual v0, v8, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->setOrientation(I)V
    invoke-virtual v0, v8, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->setGravity(I)V
    const/4 v13, 0
    invoke-virtual v0, v13, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->setClipChildren(Z)V
    invoke-virtual v0, v13, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->setClipToPadding(Z)V
    new-instance v1, Landroid/graphics/drawable/GradientDrawable;
    sget-object v2, Landroid/graphics/drawable/GradientDrawable$Orientation;->BOTTOM_TOP Landroid/graphics/drawable/GradientDrawable$Orientation;
    const/4 v3, 3
    new-array v3, v3, [I
    const/4 v14, -1
    aput v14, v3, v13
    aput v14, v3, v8
    invoke-static v14, Landroid/graphics/Color;->red(I)I
    move-result v4
    invoke-static v14, Landroid/graphics/Color;->green(I)I
    move-result v5
    invoke-static v14, Landroid/graphics/Color;->blue(I)I
    move-result v6
    invoke-static v13, v4, v5, v6, Landroid/graphics/Color;->argb(I I I I)I
    move-result v4
    const/4 v15, 2
    aput v4, v3, v15
    invoke-direct v1, v2, v3, Landroid/graphics/drawable/GradientDrawable;-><init>(Landroid/graphics/drawable/GradientDrawable$Orientation; [I)V
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v1, Landroid/view/View;
    invoke-direct v1, v7, Landroid/view/View;-><init>(Landroid/content/Context;)V
    const/16 v6, 17
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->setGravity(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v3, 100
    int-to-float v3, v3
    mul-float/2addr v3, v12
    float-to-int v3, v3
    invoke-direct v2, v14, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v5, Landroid/widget/FrameLayout;
    invoke-direct v5, v7, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v5, v13, Landroid/widget/FrameLayout;->setClipChildren(Z)V
    invoke-virtual v5, v13, Landroid/widget/FrameLayout;->setClipToPadding(Z)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->visualizerContainer Landroid/widget/FrameLayout;
    new-instance v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    const/4 v3, 0
    const/16 v16, 0
    const/16 v17, 6
    const/16 v18, 0
    move-object v1, v4
    move-object/from16 v2, v21
    move-object v14, v4
    move/from16 v4, v16
    move-object/from16 v19, v5
    move/from16 v5, v17
    move-object/from16 v6, v18
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-array v1, v15, [I
    aput v9, v1, v13
    aput v10, v1, v8
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->setCircleColorWithoutCover([I)V
    iput-object v14, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v2, 31
    if-lt v1, v2, +003h
    move v13, v8
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->widthPixels I
    const/16 v2, 559
    int-to-float v2, v2
    mul-float/2addr v2, v12
    float-to-int v2, v2
    if-eqz v13, +006h
    invoke-static v2, v1, Ljava/lang/Math;->max(I I)I
    move-result v1
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v2, v1, v1, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    const/16 v1, 81
    iput v1, v2, Landroid/widget/FrameLayout$LayoutParams;->gravity I
    move-object v4, v14
    check-cast v4, Landroid/view/View;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    move-object/from16 v9, v19
    invoke-virtual v9, v4, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v10, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v10
    move-object/from16 v2, v21
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v10, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->audioVisualizer Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/high16 v2, 1095761920
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextSize(F)V
    const/16 v2, 17
    invoke-virtual v1, v2, Landroid/widget/TextView;->setGravity(I)V
    invoke-virtual v1, v11, Landroid/widget/TextView;->setTextColor(I)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->tipTextView Landroid/widget/TextView;
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v2, v8, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v2, v8, Landroid/widget/LinearLayout;->setGravity(I)V
    check-cast v1, Landroid/view/View;
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -2
    const/4 v5, -1
    invoke-direct v3, v5, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v1, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v10, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v3, 80
    int-to-float v6, v3
    mul-float/2addr v6, v12
    float-to-int v6, v6
    invoke-direct v1, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v6, 24
    int-to-float v6, v6
    mul-float/2addr v6, v12
    float-to-int v6, v6
    iput v6, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v10, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v1, v5, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    iput v3, v1, Landroid/widget/FrameLayout$LayoutParams;->gravity I
    const/16 v3, 34
    int-to-float v3, v3
    mul-float/2addr v3, v12
    float-to-int v3, v3
    iput v3, v1, Landroid/widget/FrameLayout$LayoutParams;->bottomMargin I
    check-cast v2, Landroid/view/View;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v2, v1, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v2, 280
    int-to-float v2, v2
    mul-float/2addr v2, v12
    float-to-int v2, v2
    const/4 v3, -1
    invoke-direct v1, v3, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    move-object v5, v9
    check-cast v5, Landroid/view/View;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v5, v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->setAlpha(F)V
    const/16 v1, 8
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->setVisibility(I)V
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  android.util.AttributeSet  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method public static final synthetic access$getAudioVisualizer$p(com.bytedance.trae.conversation.widget.VoiceRecordingOverlay)com.bytedance.trae.conversation.widget.AudioVisualizerView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->audioVisualizer Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;
    return-object v0
.end method

.method private final updateHighlight(float  float)void
    .registers 6
    # ins_size=3
    const/4 v0, 2
    new-array v0, v0, [I
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->getLocationOnScreen([I)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    const/4 v2, 0
    aget v2, v0, v2
    int-to-float v2, v2
    sub-float/2addr v4, v2
    const/4 v2, 1
    aget v0, v0, v2
    int-to-float v0, v0
    sub-float/2addr v5, v0
    invoke-virtual v1, v4, v5, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->showHighlight(F F)V
    return-void 
.end method

.method public static synthetic updateState$default(com.bytedance.trae.conversation.widget.VoiceRecordingOverlay  com.bytedance.trae.conversation.widget.VoiceRecordingOverlay$RecordingState  float  float  int  java.lang.Object)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 2
    const/4 v0, 0
    if-eqz v6, +003h
    move v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move v4, v0
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->updateState(Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState; F F)V
    return-void 
.end method

.method private final updateUI()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->currentState Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 1
    if-eq v0, v3, +034h
    if-ne v0, v2, +02ch
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->tipTextView Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_recording_release_to_cancel I
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->tipTextView Landroid/widget/TextView;
    iget v4, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->cancelForegroundColor I
    invoke-virtual v0, v4, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    new-array v2, v2, [I
    iget v4, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->cancelCenterColor I
    aput v4, v2, v1
    iget v1, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->cancelEdgeColor I
    aput v1, v2, v3
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->setCircleColor([I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->dismissHighlight()V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->audioVisualizer Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;
    iget v1, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->cancelForegroundColor I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->setBarColor(I)V
    goto +30h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->tipTextView Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_recording_release_to_send I
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->tipTextView Landroid/widget/TextView;
    iget v4, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->normalTextColor I
    invoke-virtual v0, v4, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    new-array v2, v2, [I
    iget v4, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->normalCenterColor I
    aput v4, v2, v1
    iget v1, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->normalEdgeColor I
    aput v1, v2, v3
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->setCircleColorWithoutCover([I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->dismissHighlight()V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->audioVisualizer Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;
    iget v1, v5, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->normalWaveColor I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->setBarColor(I)V
    return-void 
.end method

.method private final vibrate()void
    .registers 7
    # ins_size=1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 31
    const/4 v2, -1
    const/4 v3, 0
    const-wide/16 v4, 20
    if-lt v0, v1, +024h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, vibrator_manager
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/os/VibratorManager;
    if-eqz v1, +005h
    move-object v3, v0
    check-cast v3, Landroid/os/VibratorManager;
    if-eqz v3, +037h
    invoke-virtual v3, Landroid/os/VibratorManager;->getDefaultVibrator()Landroid/os/Vibrator;
    move-result-object v0
    if-eqz v0, +031h
    invoke-static v4, v5, v2, Landroid/os/VibrationEffect;->createOneShot(J I)Landroid/os/VibrationEffect;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/os/Vibrator;->vibrate(Landroid/os/VibrationEffect;)V
    goto +28h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, vibrator
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/os/Vibrator;
    if-eqz v1, +005h
    move-object v3, v0
    check-cast v3, Landroid/os/Vibrator;
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 26
    if-lt v0, v1, +00ch
    if-eqz v3, +00fh
    invoke-static v4, v5, v2, Landroid/os/VibrationEffect;->createOneShot(J I)Landroid/os/VibrationEffect;
    move-result-object v0
    invoke-virtual v3, v0, Landroid/os/Vibrator;->vibrate(Landroid/os/VibrationEffect;)V
    goto +6h
    if-eqz v3, +005h
    invoke-virtual v3, v4, v5, Landroid/os/Vibrator;->vibrate(J)V
    return-void 
    :try_start_0x0
.end method

.method public final getBlurCircle()com.bytedance.trae.conversation.widget.blur.BlurCircleWithAmplitude
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    return-object v0
.end method

.method public final hide()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->stopWaveAnim()V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/SpeakerInterpolator;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/SpeakerInterpolator;-><init>()V
    new-instance v1, Landroid/animation/AnimatorSet;
    invoke-direct v1, Landroid/animation/AnimatorSet;-><init>()V
    const/4 v2, 2
    new-array v3, v2, [Landroid/animation/Animator;
    sget-object v4, Landroid/view/View;->ALPHA Landroid/util/Property;
    new-array v5, v2, [F
    fill-array-data v5, +0000048h
    invoke-static v9, v4, v5, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object; Landroid/util/Property; [F)Landroid/animation/ObjectAnimator;
    move-result-object v4
    const-wide/16 v5, 240
    invoke-virtual v4, v5, v6, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;
    check-cast v0, Landroid/animation/TimeInterpolator;
    invoke-virtual v4, v0, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v7, 0
    aput-object v4, v3, v7
    iget-object v4, v9, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    new-array v2, v2, [F
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->getCircleScale()F
    move-result v8
    aput v8, v2, v7
    const v7, 1058642330
    const/4 v8, 1
    aput v7, v2, v8
    const-string v7, "circleScale"
    invoke-static v4, v7, v2, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object; Ljava/lang/String; [F)Landroid/animation/ObjectAnimator;
    move-result-object v2
    invoke-virtual v2, v5, v6, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;
    invoke-virtual v2, v0, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    aput-object v2, v3, v8
    invoke-virtual v1, v3, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$hide$2$1;
    invoke-direct v0, v9, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$hide$2$1;-><init>(Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;)V
    check-cast v0, Landroid/animation/Animator$AnimatorListener;
    invoke-virtual v1, v0, Landroid/animation/AnimatorSet;->addListener(Landroid/animation/Animator$AnimatorListener;)V
    invoke-virtual v1, Landroid/animation/AnimatorSet;->start()V
    return-void 
    nop 
    fill-array-data-payload b'\x00\x00\x80?\x00\x00\x00\x00' | \x00\x00\x80\x3f\x00\x00\x00\x00
.end method

.method public final shouldCancel(float)boolean
    .registers 5
    # ins_size=2
    new-instance v0, Landroid/graphics/Rect;
    invoke-direct v0, Landroid/graphics/Rect;-><init>()V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z
    iget v1, v0, Landroid/graphics/Rect;->bottom I
    iget-object v2, v3, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->getCircleRectHeight()I
    move-result v2
    sub-int/2addr v1, v2
    invoke-virtual v0, Landroid/graphics/Rect;->isEmpty()Z
    move-result v0
    const/4 v2, 0
    if-eqz v0, +003h
    return v2
    int-to-float v0, v1
    cmpg-float v4, v4, v0
    if-gez v4, +003h
    const/4 v2, 1
    return v2
.end method

.method public final show()void
    .registers 11
    # ins_size=1
    const/4 v0, 0
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->setVisibility(I)V
    sget-object v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;->SPEAKING Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    iput-object v1, v10, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->currentState Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    const/4 v1, 1
    iput-boolean v1, v10, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->needVibrate Z
    invoke-direct v10, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->updateUI()V
    iget-object v2, v10, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->audioVisualizer Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->startAnimation()V
    iget-object v2, v10, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->startWaveAnim()V
    new-instance v2, Lcom/bytedance/trae/conversation/widget/SpeakerInterpolator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/SpeakerInterpolator;-><init>()V
    new-instance v3, Landroid/animation/AnimatorSet;
    invoke-direct v3, Landroid/animation/AnimatorSet;-><init>()V
    const/4 v4, 2
    new-array v5, v4, [Landroid/animation/Animator;
    sget-object v6, Landroid/view/View;->ALPHA Landroid/util/Property;
    new-array v7, v4, [F
    fill-array-data v7, +0000037h
    invoke-static v10, v6, v7, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object; Landroid/util/Property; [F)Landroid/animation/ObjectAnimator;
    move-result-object v6
    const-wide/16 v7, 120
    invoke-virtual v6, v7, v8, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;
    check-cast v2, Landroid/animation/TimeInterpolator;
    invoke-virtual v6, v2, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    aput-object v6, v5, v0
    iget-object v0, v10, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    new-array v4, v4, [F
    fill-array-data v4, +0000026h
    const-string v6, "circleScale"
    invoke-static v0, v6, v4, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object; Ljava/lang/String; [F)Landroid/animation/ObjectAnimator;
    move-result-object v0
    invoke-virtual v0, v7, v8, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;
    invoke-virtual v0, v2, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    aput-object v0, v5, v1
    invoke-virtual v3, v5, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V
    invoke-virtual v3, Landroid/animation/AnimatorSet;->start()V
    invoke-direct v10, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->vibrate()V
    return-void 
    nop 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
    fill-array-data-payload b'\x9a\x99\x19?\x00\x00\x80?' | \x9a\x99\x19\x3f\x00\x00\x80\x3f
.end method

.method public final updateState(com.bytedance.trae.conversation.widget.VoiceRecordingOverlay$RecordingState  float  float)void
    .registers 8
    # ins_size=4
    const-string/jumbo v0, state
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->currentState Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    const/4 v1, 0
    const/4 v2, 1
    const/4 v3, 0
    if-ne v0, v5, +012h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;->SPEAKING Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    if-ne v5, v0, +00dh
    cmpg-float v5, v6, v1
    if-nez v5, +003h
    goto +2h
    move v2, v3
    if-nez v2, +005h
    invoke-direct v4, v6, v7, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->updateHighlight(F F)V
    return-void 
    iput-object v5, v4, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->currentState Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->updateUI()V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;->SPEAKING Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    if-ne v5, v0, +00eh
    cmpg-float v0, v6, v1
    if-nez v0, +004h
    move v0, v2
    goto +2h
    move v0, v3
    if-nez v0, +005h
    invoke-direct v4, v6, v7, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->updateHighlight(F F)V
    sget-object v6, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;->CANCELING Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    if-ne v5, v6, +00ch
    iget-boolean v6, v4, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->needVibrate Z
    if-eqz v6, +008h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->vibrate()V
    iput-boolean v3, v4, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->needVibrate Z
    goto +eh
    sget-object v6, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;->SPEAKING Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    if-ne v5, v6, +00bh
    iget-boolean v5, v4, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->needVibrate Z
    if-nez v5, +007h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->vibrate()V
    iput-boolean v2, v4, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->needVibrate Z
    return-void 
.end method

.method public final updateVolume(float)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->Companion Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$Companion;
    float-to-double v1, v4
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$Companion;->optAmplitude(D)F
    move-result v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->audioVisualizer Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->setAmplitude(F)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->blurCircle Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->updateVolumeData(F)V
    return-void 
.end method
