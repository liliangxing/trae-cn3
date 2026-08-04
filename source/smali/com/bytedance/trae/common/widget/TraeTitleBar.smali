# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/TraeTitleBar;
.super Landroid/widget/LinearLayout;
.source "TraeTitleBar.kt"

.field private static final ACTION_DISABLED_ALPHA:F
.field private static final ACTION_ENABLED_ALPHA:F
.field public static final Companion:Lcom/bytedance/trae/common/widget/TraeTitleBar$Companion;
.field private static final MEDIA_PREVIEW_ACTION_BACKGROUND_ALPHA:F
.field public static final SEGMENT_INDEX_CODE:I
.field public static final SEGMENT_INDEX_WORK:I
.field private final actionGap:I
.field private final actionOverflowDrawOrderZ:F
.field private final actionShadowBlurRadius:I
.field private final actionShadowOffsetY:I
.field private final actionShadowPaddingBottom:I
.field private final actionShadowPaddingTop:I
.field private final actionSize:I
.field private final contentRow:Landroid/widget/FrameLayout;
.field private final detailIconSize:I
.field private final detailSubtitleDotView:Landroid/widget/TextView;
.field private final detailSubtitleGap:I
.field private final detailSubtitleIcon:Landroidx/appcompat/widget/AppCompatImageView;
.field private final detailSubtitlePrimaryView:Landroid/widget/TextView;
.field private final detailSubtitleRow:Landroid/widget/LinearLayout;
.field private final detailSubtitleSecondaryView:Landroid/widget/TextView;
.field private final detailTitleContainer:Landroid/widget/LinearLayout;
.field private final detailTitleGap:I
.field private final detailTitleView:Landroid/widget/TextView;
.field private final grabberContainer:Landroid/widget/FrameLayout;
.field private final grabberContainerHeight:I
.field private final grabberHeight:I
.field private final grabberWidth:I
.field private final horizontalPadding:I
.field private final iconSize:I
.field private leftAction:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field private leftActionView:Landroid/view/View;
.field private leftClickListener:Landroid/view/View$OnClickListener;
.field private leftVisible:Z
.field private mediaPreviewAppearance:Z
.field private mode:Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
.field private final operationHeight:I
.field private final operationMarginEnd:I
.field private final operationRadius:I
.field private final operationWidth:I
.field private final pageHeight:I
.field private rightActionView:Landroid/view/View;
.field private rightActions:Ljava/util/List;
.field private rightClickListeners:Ljava/util/List;
.field private rightVisible:Z
.field private final segmentWidth:I
.field private final segmentedControl:Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
.field private final sheetContentHeight:I
.field private shouldUseImplicitBackground:Z
.field private showGrabber:Z
.field private final taskActionContainer:Landroid/widget/FrameLayout;
.field private final taskActionPaddingHorizontal:I
.field private final taskActionWidth:I
.field private final taskAvatarBadge:Landroidx/appcompat/widget/AppCompatImageView;
.field private final taskAvatarBadgeMarginBottom:I
.field private final taskAvatarBadgeMarginEnd:I
.field private final taskAvatarBadgeSize:I
.field private final taskAvatarContainer:Landroid/widget/FrameLayout;
.field private final taskAvatarSize:I
.field private final taskAvatarView:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final taskHeaderHeight:I
.field private final taskOperationIcon:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private taskOperationVisible:Z
.field private final taskSearchButton:Landroidx/appcompat/widget/AppCompatImageButton;
.field private final taskTitleChevron:Landroidx/appcompat/widget/AppCompatImageView;
.field private final taskTitleContainer:Landroid/widget/LinearLayout;
.field private final taskTitleIconGap:I
.field private final taskTitleIconSize:I
.field private final taskTitleView:Landroid/widget/TextView;
.field private final titleSideGap:I
.field private final titleView:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$MbCOwuVJoq0c1rW1nOWI0nqsX0s(com.bytedance.trae.common.widget.TraeTitleBar  android.view.View  int  int  int  int  int  int  int  int)void
    .registers 10
    # ins_size=10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setupTaskHeader$lambda$14(Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/view/View; I I I I I I I I)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->Companion Lcom/bytedance/trae/common/widget/TraeTitleBar$Companion;
    return-void 
.end method

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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 13
    # ins_size=4
    const-string v0, "context"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v10, v11, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    new-instance v0, Landroid/widget/FrameLayout;
    invoke-direct v0, v10, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    iput-object v0, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberContainer Landroid/widget/FrameLayout;
    new-instance v1, Landroid/widget/FrameLayout;
    invoke-direct v1, v10, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    iput-object v1, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v10, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleContainer Landroid/widget/LinearLayout;
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleView Landroid/widget/TextView;
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v10, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleRow Landroid/widget/LinearLayout;
    new-instance v2, Landroidx/appcompat/widget/AppCompatImageView;
    invoke-direct v2, v10, Landroidx/appcompat/widget/AppCompatImageView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleIcon Landroidx/appcompat/widget/AppCompatImageView;
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitlePrimaryView Landroid/widget/TextView;
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleDotView Landroid/widget/TextView;
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleSecondaryView Landroid/widget/TextView;
    new-instance v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    move-object v3, v2
    move-object v4, v10
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->segmentedControl Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v10, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleView Landroid/widget/TextView;
    new-instance v2, Landroidx/appcompat/widget/AppCompatImageView;
    invoke-direct v2, v10, Landroidx/appcompat/widget/AppCompatImageView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleChevron Landroidx/appcompat/widget/AppCompatImageView;
    new-instance v2, Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-direct v2, v10, Lcom/facebook/drawee/view/SimpleDraweeView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    new-instance v2, Landroid/widget/FrameLayout;
    invoke-direct v2, v10, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    new-instance v2, Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-direct v2, v10, Landroidx/appcompat/widget/AppCompatImageButton;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    new-instance v2, Landroid/widget/FrameLayout;
    invoke-direct v2, v10, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    new-instance v2, Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-direct v2, v10, Lcom/facebook/drawee/view/SimpleDraweeView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarView Lcom/facebook/drawee/view/SimpleDraweeView;
    new-instance v2, Landroidx/appcompat/widget/AppCompatImageView;
    invoke-direct v2, v10, Landroidx/appcompat/widget/AppCompatImageView;-><init>(Landroid/content/Context;)V
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadge Landroidx/appcompat/widget/AppCompatImageView;
    sget-object v10, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->PAGE Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    iput-object v10, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v10, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    iput-object v10, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    const/4 v10, 1
    iput-boolean v10, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftVisible Z
    iput-boolean v10, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightVisible Z
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    iput-object v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightClickListeners Ljava/util/List;
    invoke-virtual v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getBackground()Landroid/graphics/drawable/Drawable;
    move-result-object v2
    const/4 v3, 0
    if-nez v2, +004h
    move v2, v10
    goto +2h
    move v2, v3
    iput-boolean v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->shouldUseImplicitBackground Z
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_page_height I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->pageHeight I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_task_height I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskHeaderHeight I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_sheet_content_height I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->sheetContentHeight I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_grabber_container_height I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberContainerHeight I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_grabber_width I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberWidth I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_grabber_height I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberHeight I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_horizontal_padding I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->horizontalPadding I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_action_size I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_action_gap I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionGap I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_title_side_gap I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleSideGap I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_detail_title_gap I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleGap I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_detail_subtitle_gap I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleGap I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_icon_size I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->iconSize I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_detail_icon_size I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailIconSize I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_segment_width I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->segmentWidth I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_task_title_icon_size I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleIconSize I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_task_title_icon_gap I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleIconGap I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_task_action_width I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionWidth I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_task_action_padding_horizontal I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionPaddingHorizontal I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_task_avatar_size I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarSize I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_task_avatar_badge_size I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadgeSize I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_task_avatar_badge_margin_end I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadgeMarginEnd I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_task_avatar_badge_margin_bottom I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadgeMarginBottom I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_operation_width I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->operationWidth I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_operation_height I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->operationHeight I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_operation_radius I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->operationRadius I
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_operation_margin_end I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->operationMarginEnd I
    invoke-virtual v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_elevation I
    invoke-virtual v2, v4, Landroid/content/res/Resources;->getDimension(I)F
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionOverflowDrawOrderZ F
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_shadow_blur_radius I
    invoke-direct v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v2
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_shadow_offset_y I
    invoke-direct v9, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->dimen(I)I
    move-result v4
    iput v4, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowOffsetY I
    sub-int v5, v2, v4
    invoke-static v5, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v5
    iput v5, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingTop I
    add-int/2addr v2, v4
    iput v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingBottom I
    invoke-virtual v9, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOrientation(I)V
    invoke-virtual v9, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setGravity(I)V
    invoke-virtual v9, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setClipToPadding(Z)V
    invoke-virtual v9, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setClipChildren(Z)V
    invoke-direct v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setupGrabber()V
    invoke-direct v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setupContentRow()V
    check-cast v0, Landroid/view/View;
    invoke-virtual v9, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->addView(Landroid/view/View;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v9, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->addView(Landroid/view/View;)V
    if-eqz v11, +005h
    invoke-direct v9, v11, v12, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyAttrs(Landroid/util/AttributeSet; I)V
    invoke-direct v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyMode()V
    invoke-direct v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyImplicitBackground()V
    invoke-direct v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rebuildActions()V
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final actionFromValue(int)com.bytedance.trae.common.widget.TraeTitleBar$Action
    .registers 5
    # ins_size=2
    invoke-static Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    const/4 v1, 0
    if-ltz v4, +009h
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v2
    if-ge v4, v2, +003h
    const/4 v1, 1
    if-eqz v1, +007h
    invoke-interface v0, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    goto +3h
    sget-object v4, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    check-cast v4, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    return-object v4
.end method

.method private final actionViewTag(int)java.lang.String
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeTitleBar.action."
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final addActionContent(android.widget.FrameLayout  android.view.View  int)void
    .registers 5
    # ins_size=4
    iget v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    invoke-direct v1, v2, v3, v4, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->addShadowContent(Landroid/widget/FrameLayout; Landroid/view/View; I I)V
    return-void 
.end method

.method private final addShadowContent(android.widget.FrameLayout  android.view.View  int  int)void
    .registers 6
    # ins_size=5
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v0, v4, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    iget v4, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    iput v4, v0, Landroid/widget/FrameLayout$LayoutParams;->leftMargin I
    iget v4, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingTop I
    iput v4, v0, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final allowActionShadowOverflow()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    instance-of v1, v0, Landroid/view/ViewGroup;
    if-eqz v1, +005h
    check-cast v0, Landroid/view/ViewGroup;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +009h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/ViewGroup;->setClipChildren(Z)V
    invoke-virtual v0, v1, Landroid/view/ViewGroup;->setClipToPadding(Z)V
    return-void 
.end method

.method private final applyAttrs(android.util.AttributeSet  int)void
    .registers 7
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common_ui/R$styleable;->TraeTitleBar [I
    const/4 v2, 0
    invoke-virtual v0, v5, v1, v6, v2, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet; [I I I)Landroid/content/res/TypedArray;
    move-result-object v5
    const-string v6, "obtainStyledAttributes(...)"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/common_ui/R$styleable;->TraeTitleBar_trae_titleText I
    invoke-virtual v5, v6, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;
    move-result-object v6
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    invoke-virtual v0, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleView Landroid/widget/TextView;
    invoke-virtual v0, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v6, Lcom/bytedance/trae/common_ui/R$styleable;->TraeTitleBar_trae_titleBarMode I
    invoke-virtual v5, v6, v2, Landroid/content/res/TypedArray;->getInt(I I)I
    move-result v6
    const/4 v0, 1
    if-eq v6, v0, +017h
    const/4 v1, 2
    if-eq v6, v1, +011h
    const/4 v1, 3
    if-eq v6, v1, +00bh
    const/4 v1, 4
    if-eq v6, v1, +005h
    sget-object v6, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->PAGE Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    goto +ch
    sget-object v6, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->TASK_LIST Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    goto +9h
    sget-object v6, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->NEW_CONVERSATION Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    goto +6h
    sget-object v6, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->CONVERSATION_DETAIL Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    goto +3h
    sget-object v6, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    iput-object v6, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget v6, Lcom/bytedance/trae/common_ui/R$styleable;->TraeTitleBar_trae_titleBarShowGrabber I
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v3, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-ne v1, v3, +004h
    move v1, v0
    goto +2h
    move v1, v2
    invoke-virtual v5, v6, v1, Landroid/content/res/TypedArray;->getBoolean(I Z)Z
    move-result v6
    iput-boolean v6, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showGrabber Z
    sget v6, Lcom/bytedance/trae/common_ui/R$styleable;->TraeTitleBar_trae_titleBarLeftAction I
    invoke-virtual v5, v6, v2, Landroid/content/res/TypedArray;->getInt(I I)I
    move-result v6
    invoke-direct v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionFromValue(I)Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    move-result-object v6
    iput-object v6, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget v6, Lcom/bytedance/trae/common_ui/R$styleable;->TraeTitleBar_trae_titleBarRightAction I
    invoke-virtual v5, v6, v2, Landroid/content/res/TypedArray;->getInt(I I)I
    move-result v6
    invoke-direct v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionFromValue(I)Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    move-result-object v6
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    if-ne v6, v1, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v6
    goto +5h
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    iput-object v6, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    iget-object v6, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    if-eq v6, v1, +004h
    move v6, v0
    goto +2h
    move v6, v2
    iput-boolean v6, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftVisible Z
    iget-object v6, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-nez v6, +003h
    move v2, v0
    iput-boolean v2, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightVisible Z
    invoke-virtual v5, Landroid/content/res/TypedArray;->recycle()V
    return-void 
    move-exception v6
    invoke-virtual v5, Landroid/content/res/TypedArray;->recycle()V
    throw v6
    :try_start_0x10
.end method

.method private final applyImplicitBackground()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->shouldUseImplicitBackground Z
    if-nez v0, +003h
    return-void 
    invoke-direct v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->findParentSurfaceBackground()Landroid/graphics/drawable/Drawable;
    move-result-object v0
    if-nez v0, +00dh
    invoke-direct v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->defaultBackgroundColorRes()I
    move-result v0
    const/4 v1, 0
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->roundedBackground(I F)Landroid/graphics/drawable/GradientDrawable;
    move-result-object v0
    check-cast v0, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setBackground(Landroid/graphics/drawable/Drawable;)V
    return-void 
.end method

.method private final applyMode()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberContainer Landroid/widget/FrameLayout;
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const/4 v3, 0
    const/16 v4, 8
    if-ne v1, v2, +008h
    iget-boolean v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showGrabber Z
    if-eqz v1, +004h
    move v1, v3
    goto +2h
    move v1, v4
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->PAGE Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-eq v1, v2, +00bh
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-ne v1, v2, +003h
    goto +3h
    move v1, v4
    goto +2h
    move v1, v3
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleContainer Landroid/widget/LinearLayout;
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->CONVERSATION_DETAIL Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-ne v1, v2, +004h
    move v1, v3
    goto +2h
    move v1, v4
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->segmentedControl Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->NEW_CONVERSATION Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-ne v1, v2, +003h
    goto +2h
    move v3, v4
    invoke-virtual v0, v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->setVisibility(I)V
    invoke-direct v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->syncTaskHeaderVisibility()V
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v2, -1
    invoke-direct v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentHeightForMode()I
    move-result v3
    invoke-direct v1, v2, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-ne v0, v1, +00ch
    iget-boolean v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showGrabber Z
    if-eqz v0, +008h
    iget v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->sheetContentHeight I
    iget v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberContainerHeight I
    add-int/2addr v0, v1
    goto +15h
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-ne v0, v1, +005h
    iget v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->sheetContentHeight I
    goto +ch
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->TASK_LIST Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-ne v0, v1, +005h
    iget v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskHeaderHeight I
    goto +3h
    iget v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->pageHeight I
    invoke-virtual v5, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setMinimumHeight(I)V
    invoke-direct v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyImplicitBackground()V
    invoke-virtual v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->requestLayout()V
    return-void 
.end method

.method private final applySubtitleTextStyle(android.widget.TextView)void
    .registers 5
    # ins_size=2
    const/4 v0, 1
    invoke-virtual v4, v0, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v0, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v4, v0, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    const/4 v0, 0
    invoke-virtual v4, v0, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    invoke-virtual v4, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v4, v1, Landroid/widget/TextView;->setTextColor(I)V
    const-string/jumbo v1, sans-serif
    invoke-static v1, v0, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v1
    invoke-virtual v4, v1, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v4, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_caption_caption_xs_font_size_sp I
    invoke-virtual v1, v2, Landroid/content/res/Resources;->getDimension(I)F
    move-result v1
    invoke-virtual v4, v0, v1, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v4, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$dimen;->trae_caption_caption_xs_line_height_dp I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    invoke-static v4, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    return-void 
.end method

.method private final applyTaskTitleTextStyle(android.widget.TextView)void
    .registers 5
    # ins_size=2
    invoke-virtual v4, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v4, v0, Landroid/widget/TextView;->setTextColor(I)V
    const-string/jumbo v0, sans-serif-medium
    const/4 v1, 0
    invoke-static v0, v1, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v0
    invoke-virtual v4, v0, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    const v0, 1013920983
    invoke-virtual v4, v0, Landroid/widget/TextView;->setLetterSpacing(F)V
    invoke-virtual v4, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_heading_heading_2xl_strong_font_size_sp I
    invoke-virtual v0, v2, Landroid/content/res/Resources;->getDimension(I)F
    move-result v0
    invoke-virtual v4, v1, v0, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v4, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$dimen;->trae_heading_heading_2xl_strong_line_height_dp I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    invoke-static v4, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    return-void 
.end method

.method private final applyTitleTextStyle(android.widget.TextView)void
    .registers 6
    # ins_size=2
    iget-boolean v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mediaPreviewAppearance Z
    invoke-virtual v5, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v1
    if-eqz v0, +005h
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_special_white I
    goto +3h
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v5, v1, Landroid/widget/TextView;->setTextColor(I)V
    if-eqz v0, +006h
    const-string/jumbo v1, sans-serif
    goto +4h
    const-string/jumbo v1, sans-serif-medium
    const/4 v2, 0
    invoke-static v1, v2, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v1
    invoke-virtual v5, v1, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v5, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    if-eqz v0, +005h
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_preview_title_font_size_sp I
    goto +3h
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_base_font_size_sp I
    invoke-virtual v1, v3, Landroid/content/res/Resources;->getDimension(I)F
    move-result v1
    invoke-virtual v5, v2, v1, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v5, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    if-eqz v0, +005h
    sget v0, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_preview_title_line_height_dp I
    goto +3h
    sget v0, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_base_line_height_dp I
    invoke-virtual v1, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    invoke-static v5, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    return-void 
.end method

.method private final contentHeightForMode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 3
    if-eq v0, v1, +00bh
    const/4 v1, 5
    if-eq v0, v1, +005h
    iget v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->pageHeight I
    goto +6h
    iget v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->sheetContentHeight I
    goto +3h
    iget v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskHeaderHeight I
    return v0
.end method

.method private final createActionLayoutParams(int  int)android.widget.FrameLayout$LayoutParams
    .registers 7
    # ins_size=3
    invoke-direct v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentHeightForMode()I
    move-result v0
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;
    iget v2, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    mul-int/lit8 v2, v2, 2
    add-int/2addr v5, v2
    iget v2, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    iget v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingTop I
    add-int/2addr v2, v3
    iget v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingBottom I
    add-int/2addr v2, v3
    or-int/lit8 v3, v6, 48
    invoke-direct v1, v5, v2, v3, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    iget v5, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    sub-int/2addr v0, v5
    div-int/lit8 v0, v0, 2
    iget v5, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingTop I
    sub-int/2addr v0, v5
    iput v0, v1, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    const v5, 8388611
    if-ne v6, v5, +008h
    iget v5, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    neg-int v5, v5
    iput v5, v1, Landroid/widget/FrameLayout$LayoutParams;->leftMargin I
    goto +6h
    iget v5, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    neg-int v5, v5
    iput v5, v1, Landroid/widget/FrameLayout$LayoutParams;->rightMargin I
    return-object v1
.end method

.method private final createActionShadowContainer(int  int)android.widget.FrameLayout
    .registers 12
    # ins_size=3
    new-instance v10, Landroid/widget/FrameLayout;
    invoke-virtual v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-direct v10, v0, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    const/4 v0, 0
    invoke-virtual v10, v0, Landroid/widget/FrameLayout;->setClipToPadding(Z)V
    invoke-virtual v10, v0, Landroid/widget/FrameLayout;->setClipChildren(Z)V
    const/4 v0, 1
    invoke-virtual v10, v0, Landroid/widget/FrameLayout;->setClickable(Z)V
    invoke-virtual v10, v0, Landroid/widget/FrameLayout;->setFocusable(Z)V
    const/4 v1, 0
    invoke-virtual v10, v0, v1, Landroid/widget/FrameLayout;->setLayerType(I Landroid/graphics/Paint;)V
    new-instance v0, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;
    invoke-virtual v10, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_title_bar_shadow I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    iget v1, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    int-to-float v1, v1
    const/high16 v2, 1073741824
    div-float v5, v1, v2
    iget v1, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    int-to-float v6, v1
    iget v1, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowOffsetY I
    int-to-float v7, v1
    new-instance v8, Landroid/graphics/Rect;
    iget v1, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    iget v2, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingTop I
    iget v3, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingBottom I
    invoke-direct v8, v1, v2, v1, v3, Landroid/graphics/Rect;-><init>(I I I I)V
    move-object v2, v0
    move v3, v11
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;-><init>(I I F F F Landroid/graphics/Rect;)V
    check-cast v0, Landroid/graphics/drawable/Drawable;
    invoke-virtual v10, v0, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    return-object v10
.end method

.method private final createIconButton(com.bytedance.trae.common.widget.TraeTitleBar$Action  boolean)androidx.appcompat.widget.AppCompatImageButton
    .registers 6
    # ins_size=3
    new-instance v0, Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-direct v0, v1, Landroidx/appcompat/widget/AppCompatImageButton;-><init>(Landroid/content/Context;)V
    sget-object v1, Landroid/widget/ImageView$ScaleType;->CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->getIconRes()I
    move-result v1
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setImageResource(I)V
    iget-boolean v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mediaPreviewAppearance Z
    if-eqz v1, +013h
    invoke-virtual v0, Landroidx/appcompat/widget/AppCompatImageButton;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_special_white I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-static v1, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setImageTintList(Landroid/content/res/ColorStateList;)V
    const/4 v1, 1
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setClickable(Z)V
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setFocusable(Z)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setStateListAnimator(Landroid/animation/StateListAnimator;)V
    if-eqz v5, +01dh
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->getPrimary()Z
    move-result v4
    if-eqz v4, +005h
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_brand I
    goto +3h
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_title_bar_action_bg I
    iget v5, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    int-to-float v5, v5
    const/high16 v1, 1073741824
    div-float/2addr v5, v1
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->roundedBackground(I F)Landroid/graphics/drawable/GradientDrawable;
    move-result-object v4
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v4, Landroidx/appcompat/widget/AppCompatImageButton;->setBackground(Landroid/graphics/drawable/Drawable;)V
    goto +4h
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setBackground(Landroid/graphics/drawable/Drawable;)V
    return-object v0
.end method

.method private final createRightActionView(java.util.List)android.view.View
    .registers 12
    # ins_size=2
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-ne v0, v1, +01ah
    invoke-static v11, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-direct v10, v11, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createSingleActionButton(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;)Landroid/widget/FrameLayout;
    move-result-object v11
    iget-object v0, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightClickListeners Ljava/util/List;
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/View$OnClickListener;
    invoke-virtual v11, v0, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v11, Landroid/view/View;
    return-object v11
    invoke-direct v10, v11, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionsWidth(Ljava/util/List;)I
    move-result v0
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_title_bar_action_bg I
    invoke-static v1, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-direct v10, v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createActionShadowContainer(I I)Landroid/widget/FrameLayout;
    move-result-object v1
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-virtual v1, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-direct v3, v4, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v4, 17
    invoke-virtual v3, v4, Landroid/widget/LinearLayout;->setGravity(I)V
    invoke-virtual v3, v2, Landroid/widget/LinearLayout;->setClipToPadding(Z)V
    invoke-virtual v3, v2, Landroid/widget/LinearLayout;->setClipChildren(Z)V
    iget v4, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->horizontalPadding I
    invoke-virtual v3, v4, v2, v4, v2, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    check-cast v11, Ljava/lang/Iterable;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    move v4, v2
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +03fh
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    add-int/lit8 v6, v4, 1
    if-gez v4, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v5, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-direct v10, v5, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createIconButton(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action; Z)Landroidx/appcompat/widget/AppCompatImageButton;
    move-result-object v5
    invoke-direct v10, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionViewTag(I)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v7, Landroidx/appcompat/widget/AppCompatImageButton;->setTag(Ljava/lang/Object;)V
    iget-object v7, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightClickListeners Ljava/util/List;
    invoke-static v7, v4, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Landroid/view/View$OnClickListener;
    invoke-virtual v5, v7, Landroidx/appcompat/widget/AppCompatImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v5, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    iget v8, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->iconSize I
    iget v9, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    invoke-direct v7, v8, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    if-lez v4, +006h
    iget v4, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionGap I
    iput v4, v7, Landroid/widget/LinearLayout$LayoutParams;->leftMargin I
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v5, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move v4, v6
    goto -42h
    check-cast v3, Landroid/view/View;
    invoke-direct v10, v1, v3, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->addActionContent(Landroid/widget/FrameLayout; Landroid/view/View; I)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final createSingleActionButton(com.bytedance.trae.common.widget.TraeTitleBar$Action)android.widget.FrameLayout
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->getPrimary()Z
    move-result v0
    if-eqz v0, +00dh
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_brand I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    goto +24h
    iget-boolean v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mediaPreviewAppearance Z
    if-eqz v0, +017h
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_brand_grey_500 I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    const/high16 v1, 1112276992
    invoke-static v1, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v1
    invoke-static v0, v1, Landroidx/core/graphics/ColorUtils;->setAlphaComponent(I I)I
    move-result v0
    goto +bh
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_title_bar_action_bg I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    iget v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    invoke-direct v3, v1, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createActionShadowContainer(I I)Landroid/widget/FrameLayout;
    move-result-object v0
    const/4 v1, 0
    invoke-direct v3, v4, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createIconButton(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action; Z)Landroidx/appcompat/widget/AppCompatImageButton;
    move-result-object v4
    invoke-direct v3, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionViewTag(I)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v2, Landroidx/appcompat/widget/AppCompatImageButton;->setTag(Ljava/lang/Object;)V
    invoke-virtual v4, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setClickable(Z)V
    invoke-virtual v4, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setFocusable(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/View;
    iget v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    invoke-direct v3, v0, v4, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->addActionContent(Landroid/widget/FrameLayout; Landroid/view/View; I)V
    return-object v0
.end method

.method private final createTaskActionBackground()android.graphics.drawable.Drawable
    .registers 11
    # ins_size=1
    new-instance v7, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_title_bar_action_bg I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_title_bar_shadow I
    invoke-static v0, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    iget v0, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    int-to-float v0, v0
    const/high16 v3, 1073741824
    div-float v3, v0, v3
    iget v0, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    int-to-float v4, v0
    iget v0, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowOffsetY I
    int-to-float v5, v0
    new-instance v6, Landroid/graphics/Rect;
    iget v0, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    iget v8, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingTop I
    iget v9, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingBottom I
    invoke-direct v6, v0, v8, v0, v9, Landroid/graphics/Rect;-><init>(I I I I)V
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;-><init>(I I F F F Landroid/graphics/Rect;)V
    check-cast v7, Landroid/graphics/drawable/Drawable;
    return-object v7
.end method

.method private final defaultBackgroundColorRes()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    if-eq v0, v1, +018h
    const/4 v1, 2
    if-eq v0, v1, +015h
    const/4 v1, 3
    if-eq v0, v1, +012h
    const/4 v1, 4
    if-eq v0, v1, +00ch
    const/4 v1, 5
    if-ne v0, v1, +003h
    goto +7h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_default I
    goto +3h
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_secondary I
    return v0
.end method

.method private final dimen(int)int
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    return v2
.end method

.method private final findActionView(android.view.View  int)android.view.View
    .registers 7
    # ins_size=3
    const/4 v0, 0
    if-nez v5, +003h
    return-object v0
    invoke-virtual v5, Landroid/view/View;->getTag()Ljava/lang/Object;
    move-result-object v1
    invoke-direct v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionViewTag(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v5
    instance-of v1, v5, Landroid/view/ViewGroup;
    if-eqz v1, +019h
    check-cast v5, Landroid/view/ViewGroup;
    invoke-virtual v5, Landroid/view/ViewGroup;->getChildCount()I
    move-result v1
    const/4 v2, 0
    if-ge v2, v1, +010h
    invoke-virtual v5, v2, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;
    move-result-object v3
    invoke-direct v4, v3, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->findActionView(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +003h
    return-object v3
    add-int/lit8 v2, v2, 1
    goto -fh
    return-object v0
.end method

.method private final findParentSurfaceBackground()android.graphics.drawable.Drawable
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    instance-of v1, v0, Landroid/view/View;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroid/view/View;
    goto +2h
    move-object v0, v2
    if-eqz v0, +031h
    invoke-virtual v0, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;
    move-result-object v0
    if-nez v0, +003h
    goto +29h
    invoke-direct v3, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->isTransparentColor(Landroid/graphics/drawable/Drawable;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v2
    invoke-virtual v0, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;
    move-result-object v1
    if-eqz v1, +013h
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v1, v2, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    move-result-object v1
    if-eqz v1, +009h
    invoke-virtual v1, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;
    move-result-object v1
    if-eqz v1, +003h
    goto +ah
    invoke-virtual v0, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;
    move-result-object v1
    const-string v0, "mutate(...)"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v1
    return-object v2
.end method

.method private final findRightActionClickTarget(int)android.view.View
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 1
    if-ne v0, v1, +007h
    if-nez v3, +005h
    iget-object v3, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    goto +7h
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->findActionView(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    return-object v3
.end method

.method private final isTransparentColor(android.graphics.drawable.Drawable)boolean
    .registers 3
    # ins_size=2
    instance-of v0, v2, Landroid/graphics/drawable/ColorDrawable;
    if-eqz v0, +00ch
    check-cast v2, Landroid/graphics/drawable/ColorDrawable;
    invoke-virtual v2, Landroid/graphics/drawable/ColorDrawable;->getColor()I
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method private final liftActionOverflowAboveSiblings()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$EmptyOutlineProvider;->INSTANCE Lcom/bytedance/trae/common/widget/TraeTitleBar$EmptyOutlineProvider;
    check-cast v0, Landroid/view/ViewOutlineProvider;
    invoke-virtual v3, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getZ()F
    move-result v0
    iget v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionOverflowDrawOrderZ F
    cmpg-float v0, v0, v1
    if-gez v0, +011h
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getTranslationZ()F
    move-result v0
    iget v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionOverflowDrawOrderZ F
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getZ()F
    move-result v2
    sub-float/2addr v1, v2
    add-float/2addr v0, v1
    invoke-virtual v3, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTranslationZ(F)V
    return-void 
.end method

.method private final rebuildActions()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftActionView Landroid/view/View;
    if-eqz v0, +007h
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    if-eqz v0, +007h
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V
    const/4 v0, 0
    iput-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftActionView Landroid/view/View;
    iput-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->TASK_LIST Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-ne v0, v1, +006h
    invoke-direct v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->updateTaskTitleMargins()V
    return-void 
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const/4 v2, 0
    const/4 v3, 4
    if-eq v0, v1, +02bh
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-direct v6, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createSingleActionButton(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;)Landroid/widget/FrameLayout;
    move-result-object v0
    iget-boolean v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftVisible Z
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftClickListener Landroid/view/View$OnClickListener;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    check-cast v0, Landroid/view/View;
    iget v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    const v5, 8388611
    invoke-direct v6, v4, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createActionLayoutParams(I I)Landroid/widget/FrameLayout$LayoutParams;
    move-result-object v4
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, v4, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iput-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftActionView Landroid/view/View;
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +027h
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    invoke-direct v6, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createRightActionView(Ljava/util/List;)Landroid/view/View;
    move-result-object v0
    iget-boolean v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightVisible Z
    if-eqz v1, +003h
    goto +2h
    move v2, v3
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    iget-object v2, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    invoke-direct v6, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionsWidth(Ljava/util/List;)I
    move-result v2
    const v3, 8388613
    invoke-direct v6, v2, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createActionLayoutParams(I I)Landroid/widget/FrameLayout$LayoutParams;
    move-result-object v2
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iput-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    invoke-direct v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->updateTitleMargins()V
    return-void 
.end method

.method private final rightActionsWidth(java.util.List)int
    .registers 6
    # ins_size=2
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v0
    if-eqz v0, +01eh
    const/4 v1, 1
    if-eq v0, v1, +018h
    iget v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->horizontalPadding I
    mul-int/lit8 v0, v0, 2
    iget v2, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->iconSize I
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v3
    mul-int/2addr v2, v3
    add-int/2addr v0, v2
    iget v2, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionGap I
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    sub-int/2addr v5, v1
    mul-int/2addr v2, v5
    add-int/2addr v0, v2
    goto +5h
    iget v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final roundedBackground(int  float)android.graphics.drawable.GradientDrawable
    .registers 5
    # ins_size=3
    new-instance v0, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v0, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-static v1, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v0, v3, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    invoke-virtual v0, v4, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    return-object v0
.end method

.method public static synthetic setMode$default(com.bytedance.trae.common.widget.TraeTitleBar  com.bytedance.trae.common.widget.TraeTitleBar$Mode  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +009h
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-ne v1, v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setMode(Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode; Z)V
    return-void 
.end method

.method public static synthetic setSegmentedSelectedIndex$default(com.bytedance.trae.common.widget.TraeTitleBar  int  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setSegmentedSelectedIndex(I Z)V
    return-void 
.end method

.method public static synthetic setTaskHeaderViewIds$default(com.bytedance.trae.common.widget.TraeTitleBar  int  int  int  int  int  int  int  int  int  java.lang.Object)void
    .registers 12
    # ins_size=11
    and-int/lit8 v11, v10, 1
    const/4 v0, -1
    if-eqz v11, +003h
    move v2, v0
    and-int/lit8 v11, v10, 2
    if-eqz v11, +003h
    move v3, v0
    and-int/lit8 v11, v10, 4
    if-eqz v11, +003h
    move v4, v0
    and-int/lit8 v11, v10, 8
    if-eqz v11, +003h
    move v5, v0
    and-int/lit8 v11, v10, 16
    if-eqz v11, +003h
    move v6, v0
    and-int/lit8 v11, v10, 32
    if-eqz v11, +003h
    move v7, v0
    and-int/lit8 v11, v10, 64
    if-eqz v11, +003h
    move v8, v0
    and-int/lit16 v10, v10, 128
    if-eqz v10, +003h
    move v9, v0
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskHeaderViewIds(I I I I I I I I)V
    return-void 
.end method

.method private final setupContentRow()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setClipToPadding(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setClipChildren(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    iget v2, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->horizontalPadding I
    invoke-virtual v0, v2, v1, v2, v1, Landroid/widget/FrameLayout;->setPadding(I I I I)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    const/16 v2, 17
    invoke-virtual v0, v2, Landroid/widget/TextView;->setGravity(I)V
    const/4 v3, 1
    invoke-virtual v0, v3, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v3, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    invoke-direct v6, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyTitleTextStyle(Landroid/widget/TextView;)V
    invoke-direct v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setupDetailTitle()V
    invoke-direct v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setupTaskHeader()V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v4, -1
    invoke-direct v3, v4, v4, v2, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v3, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleContainer Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v3, v4, v4, v2, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v3, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->segmentedControl Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
    check-cast v1, Landroid/view/View;
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;
    iget v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->segmentWidth I
    iget v5, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->pageHeight I
    invoke-direct v3, v4, v5, v2, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v3, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final setupDetailTitle()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleContainer Landroid/widget/LinearLayout;
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v3, 8
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setClipToPadding(Z)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setClipChildren(Z)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleView Landroid/widget/TextView;
    const v4, 8388611
    invoke-virtual v0, v4, Landroid/widget/TextView;->setGravity(I)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v1, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v0, v3, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    invoke-direct v7, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyTitleTextStyle(Landroid/widget/TextView;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleContainer Landroid/widget/LinearLayout;
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleView Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_base_line_height_dp I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    const/4 v6, -1
    invoke-direct v4, v6, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleRow Landroid/widget/LinearLayout;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setClipToPadding(Z)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setClipChildren(Z)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleIcon Landroidx/appcompat/widget/AppCompatImageView;
    sget-object v1, Landroid/widget/ImageView$ScaleType;->CENTER_INSIDE Landroid/widget/ImageView$ScaleType;
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleRow Landroid/widget/LinearLayout;
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleIcon Landroidx/appcompat/widget/AppCompatImageView;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    iget v4, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailIconSize I
    invoke-direct v2, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitlePrimaryView Landroid/widget/TextView;
    invoke-direct v7, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applySubtitleTextStyle(Landroid/widget/TextView;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleDotView Landroid/widget/TextView;
    invoke-direct v7, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applySubtitleTextStyle(Landroid/widget/TextView;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleSecondaryView Landroid/widget/TextView;
    invoke-direct v7, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applySubtitleTextStyle(Landroid/widget/TextView;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleRow Landroid/widget/LinearLayout;
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitlePrimaryView Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -2
    invoke-direct v2, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iget v5, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleGap I
    iput v5, v2, Landroid/widget/LinearLayout$LayoutParams;->leftMargin I
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleRow Landroid/widget/LinearLayout;
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleDotView Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iget v5, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleGap I
    iput v5, v2, Landroid/widget/LinearLayout$LayoutParams;->leftMargin I
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleRow Landroid/widget/LinearLayout;
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleSecondaryView Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v5, 1065353216
    invoke-direct v2, v3, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    iget v3, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleGap I
    iput v3, v2, Landroid/widget/LinearLayout$LayoutParams;->leftMargin I
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleContainer Landroid/widget/LinearLayout;
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleRow Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_caption_caption_xs_line_height_dp I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    invoke-direct v2, v6, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final setupGrabber()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberContainer Landroid/widget/FrameLayout;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    iget v2, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberWidth I
    iget v3, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberContainerHeight I
    invoke-direct v1, v2, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/view/View;
    invoke-virtual v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-direct v0, v1, Landroid/view/View;-><init>(Landroid/content/Context;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_title_bar_grabber I
    iget v2, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberHeight I
    int-to-float v2, v2
    const/high16 v3, 1073741824
    div-float/2addr v2, v3
    invoke-direct v5, v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->roundedBackground(I F)Landroid/graphics/drawable/GradientDrawable;
    move-result-object v1
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v1, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;
    iget v2, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberWidth I
    iget v3, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberHeight I
    const/16 v4, 17
    invoke-direct v1, v2, v3, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    iget-object v2, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->grabberContainer Landroid/widget/FrameLayout;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v0, v1, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final setupTaskActionContainer()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setVisibility(I)V
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setClipToPadding(Z)V
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setClipChildren(Z)V
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setClickable(Z)V
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setFocusable(Z)V
    invoke-direct v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createTaskActionBackground()Landroid/graphics/drawable/Drawable;
    move-result-object v3
    invoke-virtual v0, v3, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    sget-object v3, Landroid/widget/ImageView$ScaleType;->CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v0, v3, Landroidx/appcompat/widget/AppCompatImageButton;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    const/4 v3, 0
    invoke-virtual v0, v3, Landroidx/appcompat/widget/AppCompatImageButton;->setBackground(Landroid/graphics/drawable/Drawable;)V
    const/4 v4, 1
    invoke-virtual v0, v4, Landroidx/appcompat/widget/AppCompatImageButton;->setClickable(Z)V
    invoke-virtual v0, v4, Landroidx/appcompat/widget/AppCompatImageButton;->setFocusable(Z)V
    invoke-virtual v0, v3, Landroidx/appcompat/widget/AppCompatImageButton;->setStateListAnimator(Landroid/animation/StateListAnimator;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    sget-object v5, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v3, v5, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setActualImageScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    sget v5, Lcom/bytedance/trae/common_ui/R$drawable;->bg_solo_avatar_placeholder I
    invoke-virtual v3, v5, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setPlaceholderImage(I)V
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v0
    check-cast v0, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    invoke-static Lcom/facebook/drawee/generic/RoundingParams;->asCircle()Lcom/facebook/drawee/generic/RoundingParams;
    move-result-object v3
    invoke-virtual v0, v3, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setRoundingParams(Lcom/facebook/drawee/generic/RoundingParams;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, v4, Landroid/widget/FrameLayout;->setClickable(Z)V
    invoke-virtual v0, v4, Landroid/widget/FrameLayout;->setFocusable(Z)V
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setClipChildren(Z)V
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setClipToPadding(Z)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    iget-object v3, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarView Lcom/facebook/drawee/view/SimpleDraweeView;
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;
    iget v5, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarSize I
    const/16 v6, 17
    invoke-direct v4, v5, v5, v6, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v4, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadge Landroidx/appcompat/widget/AppCompatImageView;
    sget-object v3, Landroid/widget/ImageView$ScaleType;->CENTER_INSIDE Landroid/widget/ImageView$ScaleType;
    invoke-virtual v0, v3, Landroidx/appcompat/widget/AppCompatImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageView;->setVisibility(I)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadge Landroidx/appcompat/widget/AppCompatImageView;
    check-cast v1, Landroid/view/View;
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;
    iget v4, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadgeSize I
    const v5, 8388693
    invoke-direct v3, v4, v4, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    iget v4, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadgeMarginEnd I
    iput v4, v3, Landroid/widget/FrameLayout$LayoutParams;->rightMargin I
    iget v4, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadgeMarginBottom I
    iput v4, v3, Landroid/widget/FrameLayout$LayoutParams;->bottomMargin I
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v3, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-virtual v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-direct v0, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v0, v6, Landroid/widget/LinearLayout;->setGravity(I)V
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setClipToPadding(Z)V
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setClipChildren(Z)V
    iget v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionPaddingHorizontal I
    invoke-virtual v0, v1, v2, v1, v2, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    iget v3, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    invoke-direct v2, v3, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    iget v3, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    invoke-direct v2, v3, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    check-cast v0, Landroid/view/View;
    iget v2, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionWidth I
    iget v3, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    invoke-direct v7, v1, v0, v2, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->addShadowContent(Landroid/widget/FrameLayout; Landroid/view/View; I I)V
    return-void 
.end method

.method private final setupTaskHeader()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v3, 8
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setClipToPadding(Z)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setClipChildren(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setGravity(I)V
    const/4 v2, 1
    invoke-virtual v0, v2, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v2, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    invoke-direct v6, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyTaskTitleTextStyle(Landroid/widget/TextView;)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleView Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -2
    invoke-direct v2, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleChevron Landroidx/appcompat/widget/AppCompatImageView;
    sget-object v1, Landroid/widget/ImageView$ScaleType;->CENTER_INSIDE Landroid/widget/ImageView$ScaleType;
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    invoke-virtual v0, v3, Landroidx/appcompat/widget/AppCompatImageView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleChevron Landroidx/appcompat/widget/AppCompatImageView;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    iget v3, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleIconSize I
    invoke-direct v2, v3, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iget v3, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleIconGap I
    iput v3, v2, Landroid/widget/LinearLayout$LayoutParams;->leftMargin I
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v3, -1
    const v4, 8388627
    invoke-direct v2, v3, v3, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setupTaskOperationIcon()V
    invoke-direct v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setupTaskActionContainer()V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    iget v3, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->operationWidth I
    iget v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->operationHeight I
    const v5, 8388629
    invoke-direct v2, v3, v4, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    iget v3, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionWidth I
    iget v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->operationMarginEnd I
    add-int/2addr v3, v4
    iput v3, v2, Landroid/widget/FrameLayout$LayoutParams;->rightMargin I
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    iget-object v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    iget v3, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionWidth I
    iget v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    mul-int/lit8 v4, v4, 2
    add-int/2addr v3, v4
    iget v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    iget v5, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingTop I
    add-int/2addr v4, v5
    iget v5, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingBottom I
    add-int/2addr v4, v5
    const v5, 8388661
    invoke-direct v2, v3, v4, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    iget v3, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskHeaderHeight I
    iget v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    sub-int/2addr v3, v4
    div-int/lit8 v3, v3, 2
    iget v4, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowPaddingTop I
    sub-int/2addr v3, v4
    iput v3, v2, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    iget v3, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    neg-int v3, v3
    iput v3, v2, Landroid/widget/FrameLayout$LayoutParams;->rightMargin I
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    new-instance v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$$ExternalSyntheticLambda0;
    invoke-direct v1, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/common/widget/TraeTitleBar;)V
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V
    return-void 
.end method

.method private static final setupTaskHeader$lambda$14(com.bytedance.trae.common.widget.TraeTitleBar  android.view.View  int  int  int  int  int  int  int  int)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->updateTaskTitleMargins()V
    return-void 
.end method

.method private final setupTaskOperationIcon()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    const/16 v1, 8
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setVisibility(I)V
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v1
    check-cast v1, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    sget-object v2, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v1, v2, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setActualImageScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v0
    check-cast v0, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    iget v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->operationRadius I
    int-to-float v1, v1
    invoke-static v1, Lcom/facebook/drawee/generic/RoundingParams;->fromCornersRadius(F)Lcom/facebook/drawee/generic/RoundingParams;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setRoundingParams(Lcom/facebook/drawee/generic/RoundingParams;)V
    return-void 
.end method

.method private final syncTaskHeaderVisibility()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->TASK_LIST Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const/4 v2, 0
    if-ne v0, v1, +004h
    const/4 v0, 1
    goto +2h
    move v0, v2
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    const/16 v3, 8
    if-eqz v0, +004h
    move v4, v2
    goto +2h
    move v4, v3
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    if-eqz v0, +004h
    move v4, v2
    goto +2h
    move v4, v3
    invoke-virtual v1, v4, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v0, +007h
    iget-boolean v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationVisible Z
    if-eqz v0, +003h
    goto +2h
    move v2, v3
    invoke-virtual v1, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setVisibility(I)V
    return-void 
.end method

.method private final tintTaskIcon(android.widget.ImageView)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v3, v0, Landroid/widget/ImageView;->setColorFilter(I)V
    return-void 
.end method

.method private final updateTaskTitleMargins()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    instance-of v1, v0, Landroid/widget/FrameLayout$LayoutParams;
    if-eqz v1, +005h
    check-cast v0, Landroid/widget/FrameLayout$LayoutParams;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    iget-boolean v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationVisible Z
    const/4 v2, 0
    if-eqz v1, +008h
    iget v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->operationWidth I
    iget v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->operationMarginEnd I
    add-int/2addr v1, v3
    goto +2h
    move v1, v2
    iget v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionWidth I
    add-int/2addr v3, v1
    iget v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleSideGap I
    add-int/2addr v3, v1
    iget v1, v0, Landroid/widget/FrameLayout$LayoutParams;->rightMargin I
    if-eq v1, v3, +00bh
    iput v3, v0, Landroid/widget/FrameLayout$LayoutParams;->rightMargin I
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleChevron Landroidx/appcompat/widget/AppCompatImageView;
    invoke-virtual v0, Landroidx/appcompat/widget/AppCompatImageView;->getVisibility()I
    move-result v0
    if-nez v0, +008h
    iget v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleIconSize I
    iget v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleIconGap I
    add-int v2, v0, v1
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getWidth()I
    move-result v0
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    invoke-virtual v1, Landroid/widget/FrameLayout;->getPaddingLeft()I
    move-result v1
    sub-int/2addr v0, v1
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->contentRow Landroid/widget/FrameLayout;
    invoke-virtual v1, Landroid/widget/FrameLayout;->getPaddingRight()I
    move-result v1
    sub-int/2addr v0, v1
    sub-int/2addr v0, v3
    sub-int/2addr v0, v2
    if-lez v0, +00fh
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleView Landroid/widget/TextView;
    invoke-virtual v1, Landroid/widget/TextView;->getMaxWidth()I
    move-result v1
    if-eq v1, v0, +007h
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleView Landroid/widget/TextView;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setMaxWidth(I)V
    return-void 
.end method

.method private final updateTitleMargins()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->TASK_LIST Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    if-ne v0, v1, +006h
    invoke-direct v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->updateTaskTitleMargins()V
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const/4 v2, 0
    if-eq v0, v1, +005h
    iget v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionSize I
    goto +2h
    move v0, v2
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    invoke-direct v7, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionsWidth(Ljava/util/List;)I
    move-result v1
    iget-object v3, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    invoke-virtual v3, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    const-string v4, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/FrameLayout$LayoutParams;
    invoke-static v0, v1, Ljava/lang/Math;->max(I I)I
    move-result v5
    if-nez v5, +004h
    move v5, v2
    goto +4h
    iget v6, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleSideGap I
    add-int/2addr v5, v6
    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->leftMargin I
    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->rightMargin I
    iget-object v5, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v3, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v3, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleContainer Landroid/widget/LinearLayout;
    invoke-virtual v3, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/FrameLayout$LayoutParams;
    iget v4, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleGap I
    iget v5, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->actionShadowBlurRadius I
    add-int/2addr v4, v5
    if-nez v0, +004h
    move v0, v2
    goto +2h
    add-int/2addr v0, v4
    iput v0, v3, Landroid/widget/FrameLayout$LayoutParams;->leftMargin I
    if-nez v1, +003h
    goto +3h
    add-int v2, v1, v4
    iput v2, v3, Landroid/widget/FrameLayout$LayoutParams;->rightMargin I
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleContainer Landroid/widget/LinearLayout;
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method public final getConversationDetailSubtitleText()java.lang.CharSequence
    .registers 13
    # ins_size=1
    const/4 v0, 2
    new-array v0, v0, [Ljava/lang/String;
    iget-object v1, v12, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitlePrimaryView Landroid/widget/TextView;
    invoke-virtual v1, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    const-string v3, ""
    if-nez v1, +003h
    move-object v1, v3
    const/4 v4, 0
    aput-object v1, v0, v4
    iget-object v1, v12, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleSecondaryView Landroid/widget/TextView;
    invoke-virtual v1, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v1
    if-eqz v1, +006h
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v3, v2
    const/4 v1, 1
    aput-object v3, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v5, v3
    check-cast v5, Ljava/lang/String;
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +004h
    move v5, v1
    goto +2h
    move v5, v4
    if-eqz v5, -018h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v2, Ljava/util/List;
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    const-string v0, " · "
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    return-object v0
.end method

.method public final getDisplayedTitleText()java.lang.CharSequence
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    const-string v2, "getText(...)"
    if-eq v0, v1, +023h
    const/4 v1, 2
    if-eq v0, v1, +019h
    const/4 v1, 3
    if-eq v0, v1, +00ch
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +1bh
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleView Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +11h
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->segmentedControl Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getSelectedTab()Ljava/lang/CharSequence;
    move-result-object v0
    goto +ah
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleView Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public final getSegmentedSelectedIndex()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->segmentedControl Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->getSelectedIndex()I
    move-result v0
    return v0
.end method

.method public final getTaskAvatarView()com.facebook.drawee.view.SimpleDraweeView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarView Lcom/facebook/drawee/view/SimpleDraweeView;
    return-object v0
.end method

.method public final getTaskOperationIconView()com.facebook.drawee.view.SimpleDraweeView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    return-object v0
.end method

.method public final getTitleText()java.lang.CharSequence
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getDisplayedTitleText()Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public final isTaskOperationIconVisible()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationVisible Z
    return v0
.end method

.method protected onAttachedToWindow()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroid/widget/LinearLayout;->onAttachedToWindow()V
    invoke-direct v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyImplicitBackground()V
    invoke-direct v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->allowActionShadowOverflow()V
    invoke-direct v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->liftActionOverflowAboveSiblings()V
    return-void 
.end method

.method public final setConversationDetailSubtitle(java.lang.CharSequence  java.lang.CharSequence  int)void
    .registers 7
    # ins_size=4
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleIcon Landroidx/appcompat/widget/AppCompatImageView;
    invoke-virtual v0, v6, Landroidx/appcompat/widget/AppCompatImageView;->setImageResource(I)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleIcon Landroidx/appcompat/widget/AppCompatImageView;
    const/16 v1, 8
    const/4 v2, 0
    if-nez v6, +004h
    move v6, v1
    goto +2h
    move v6, v2
    invoke-virtual v0, v6, Landroidx/appcompat/widget/AppCompatImageView;->setVisibility(I)V
    iget-object v6, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitlePrimaryView Landroid/widget/TextView;
    invoke-virtual v6, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v6, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitlePrimaryView Landroid/widget/TextView;
    const/4 v0, 1
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v0
    if-eqz v4, +004h
    move v4, v1
    goto +2h
    move v4, v2
    invoke-virtual v6, v4, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v4, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleDotView Landroid/widget/TextView;
    const-string/jumbo v6, ·
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v4, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleDotView Landroid/widget/TextView;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +3h
    move v6, v2
    goto +2h
    move v6, v0
    if-nez v6, +004h
    move v6, v2
    goto +2h
    move v6, v1
    invoke-virtual v4, v6, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v4, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleSecondaryView Landroid/widget/TextView;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleSecondaryView Landroid/widget/TextView;
    if-eqz v5, +00ah
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    goto +2h
    move v1, v2
    invoke-virtual v4, v1, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method

.method public final setConversationDetailSubtitleIcon(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleIcon Landroidx/appcompat/widget/AppCompatImageView;
    invoke-virtual v0, v2, Landroidx/appcompat/widget/AppCompatImageView;->setImageResource(I)V
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailSubtitleIcon Landroidx/appcompat/widget/AppCompatImageView;
    if-nez v2, +005h
    const/16 v2, 8
    goto +2h
    const/4 v2, 0
    invoke-virtual v0, v2, Landroidx/appcompat/widget/AppCompatImageView;->setVisibility(I)V
    return-void 
.end method

.method public final setConversationDetailTitle(java.lang.CharSequence)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->detailTitleView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final setInteractionEnabled(boolean)void
    .registers 5
    # ins_size=2
    invoke-virtual v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->segmentedControl Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
    invoke-virtual v0, v4, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v0, v4, Landroidx/appcompat/widget/AppCompatImageButton;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, v4, Landroid/widget/FrameLayout;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, v4, Lcom/facebook/drawee/view/SimpleDraweeView;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftActionView Landroid/view/View;
    if-eqz v0, +005h
    invoke-virtual v0, v4, Landroid/view/View;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftActionView Landroid/view/View;
    if-eqz v0, +005h
    invoke-virtual v0, v4, Landroid/view/View;->setClickable(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    if-eqz v0, +005h
    invoke-virtual v0, v4, Landroid/view/View;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    if-eqz v0, +005h
    invoke-virtual v0, v4, Landroid/view/View;->setClickable(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 1
    if-le v0, v1, +02ch
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->getIndices(Ljava/util/Collection;)Lkotlin/ranges/IntRange;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    move-object v1, v0
    check-cast v1, Lkotlin/collections/IntIterator;
    invoke-virtual v1, Lkotlin/collections/IntIterator;->nextInt()I
    move-result v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    invoke-direct v3, v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->findActionView(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, -013h
    invoke-virtual v1, v4, Landroid/view/View;->setEnabled(Z)V
    invoke-virtual v1, v4, Landroid/view/View;->setClickable(Z)V
    goto -1bh
    return-void 
.end method

.method public final setLeftAction(com.bytedance.trae.common.widget.TraeTitleBar$Action)void
    .registers 3
    # ins_size=2
    const-string v0, "action"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    if-eq v2, v0, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    iput-boolean v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftVisible Z
    invoke-direct v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rebuildActions()V
    return-void 
.end method

.method public final setLeftActionVisible(boolean)void
    .registers 3
    # ins_size=2
    iput-boolean v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftVisible Z
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftActionView Landroid/view/View;
    if-eqz v0, +00ah
    if-eqz v2, +004h
    const/4 v2, 0
    goto +2h
    const/4 v2, 4
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method public final setMode(com.bytedance.trae.common.widget.TraeTitleBar$Mode  boolean)void
    .registers 4
    # ins_size=3
    const-string v0, "mode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    iput-boolean v3, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showGrabber Z
    invoke-direct v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyMode()V
    invoke-direct v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rebuildActions()V
    return-void 
.end method

.method public final setOnLeftActionClickListener(android.view.View$OnClickListener)void
    .registers 3
    # ins_size=2
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftClickListener Landroid/view/View$OnClickListener;
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftActionView Landroid/view/View;
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final setOnRightActionClickListener(int  android.view.View$OnClickListener)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightClickListeners Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v1
    if-gt v1, v3, +007h
    const/4 v1, 0
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -ah
    invoke-interface v0, v3, v4, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightClickListeners Ljava/util/List;
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->findActionView(Landroid/view/View; I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, v4, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    if-nez v3, +009h
    iget-object v3, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    if-eqz v3, +005h
    invoke-virtual v3, v4, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final setOnRightActionClickListener(android.view.View$OnClickListener)void
    .registers 3
    # ins_size=2
    const/4 v0, 0
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(I Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final setOnSegmentedTabSelectedListener(kotlin.jvm.functions.Function2)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->segmentedControl Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
    invoke-virtual v0, v2, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->setOnTabSelected(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public final setOnTaskAvatarClickListener(android.view.View$OnClickListener)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, v5, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v5, +004h
    move v3, v1
    goto +2h
    move v3, v2
    invoke-virtual v0, v3, Landroid/widget/FrameLayout;->setClickable(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    if-eqz v5, +003h
    goto +2h
    move v1, v2
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setFocusable(Z)V
    return-void 
.end method

.method public final setOnTaskSearchClickListener(android.view.View$OnClickListener)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v0, v2, Landroidx/appcompat/widget/AppCompatImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final setOnTaskTitleClickListener(android.view.View$OnClickListener)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, v5, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v5, +004h
    move v3, v1
    goto +2h
    move v3, v2
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setClickable(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    if-eqz v5, +003h
    goto +2h
    move v1, v2
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setFocusable(Z)V
    return-void 
.end method

.method public final setOnTitleClickListener(android.view.View$OnClickListener)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    invoke-virtual v0, v5, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v5, +004h
    move v3, v1
    goto +2h
    move v3, v2
    invoke-virtual v0, v3, Landroid/widget/TextView;->setClickable(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    if-eqz v5, +003h
    goto +2h
    move v1, v2
    invoke-virtual v0, v1, Landroid/widget/TextView;->setFocusable(Z)V
    return-void 
.end method

.method public final setRightAction(com.bytedance.trae.common.widget.TraeTitleBar$Action)void
    .registers 3
    # ins_size=2
    const-string v0, "action"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    if-ne v2, v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    goto +5h
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActions(Ljava/util/List;)V
    return-void 
.end method

.method public final setRightActionEnabled(int  boolean)void
    .registers 5
    # ins_size=3
    invoke-direct v2, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->findRightActionClickTarget(I)Landroid/view/View;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, v4, Landroid/view/View;->setEnabled(Z)V
    if-eqz v4, +005h
    const/high16 v1, 1065353216
    goto +4h
    const v1, 1053609165
    invoke-virtual v0, v1, Landroid/view/View;->setAlpha(F)V
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->findActionView(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +005h
    invoke-virtual v3, v4, Landroid/view/View;->setEnabled(Z)V
    return-void 
.end method

.method public final setRightActionResource(int  int)void
    .registers 7
    # ins_size=3
    invoke-direct v4, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->findRightActionClickTarget(I)Landroid/view/View;
    move-result-object v5
    if-nez v5, +003h
    return-void 
    iget-object v5, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    instance-of v0, v5, Landroid/view/ViewGroup;
    if-eqz v0, +028h
    const-string v0, "null cannot be cast to non-null type android.view.ViewGroup"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/view/ViewGroup;
    invoke-virtual v5, Landroid/view/ViewGroup;->getChildCount()I
    move-result v5
    const/4 v1, 0
    if-ge v1, v5, +01ah
    iget-object v2, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/view/ViewGroup;
    invoke-virtual v2, v1, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    instance-of v3, v2, Landroidx/appcompat/widget/AppCompatImageButton;
    if-eqz v3, +008h
    check-cast v2, Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v2, v6, Landroidx/appcompat/widget/AppCompatImageButton;->setImageResource(I)V
    goto +4h
    add-int/lit8 v1, v1, 1
    goto -19h
    return-void 
.end method

.method public final setRightActionViewId(int  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->findRightActionClickTarget(I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, v2, Landroid/view/View;->setId(I)V
    return-void 
.end method

.method public final setRightActions(java.util.List)void
    .registers 7
    # ins_size=2
    const-string v0, "actions"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +015h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget-object v4, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    if-eq v3, v4, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, -014h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v0, Ljava/util/List;
    iput-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    xor-int/2addr v6, v2
    iput-boolean v6, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightVisible Z
    iget-object v6, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightClickListeners Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    invoke-static v6, v0, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v6
    iput-object v6, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightClickListeners Ljava/util/List;
    invoke-direct v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rebuildActions()V
    return-void 
.end method

.method public final setRightActionsVisible(boolean)void
    .registers 3
    # ins_size=2
    iput-boolean v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightVisible Z
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActionView Landroid/view/View;
    if-eqz v0, +00ah
    if-eqz v2, +004h
    const/4 v2, 0
    goto +2h
    const/4 v2, 4
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method public final setSegmentedSelectedIndex(int  boolean)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->segmentedControl Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;->setSelectedIndex(I Z)V
    return-void 
.end method

.method public final setTaskAvatarBadgeImageResource(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadge Landroidx/appcompat/widget/AppCompatImageView;
    invoke-virtual v0, v2, Landroidx/appcompat/widget/AppCompatImageView;->setImageResource(I)V
    return-void 
.end method

.method public final setTaskAvatarBadgeVisible(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadge Landroidx/appcompat/widget/AppCompatImageView;
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroidx/appcompat/widget/AppCompatImageView;->setVisibility(I)V
    return-void 
.end method

.method public final setTaskEnterpriseMode(boolean)void
    .registers 7
    # ins_size=2
    if-nez v6, +003h
    return-void 
    invoke-virtual v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->density F
    const/16 v0, 36
    int-to-float v0, v0
    mul-float/2addr v0, v6
    float-to-int v0, v0
    const/4 v1, 5
    int-to-float v1, v1
    mul-float/2addr v1, v6
    float-to-int v6, v1
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    const/16 v2, 8
    invoke-virtual v1, v2, Landroidx/appcompat/widget/AppCompatImageButton;->setVisibility(I)V
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarView Lcom/facebook/drawee/view/SimpleDraweeView;
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v4, 17
    invoke-direct v3, v0, v0, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    invoke-virtual v1, Landroid/widget/FrameLayout;->removeAllViews()V
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    invoke-virtual v1, Landroid/widget/FrameLayout;->getParent()Landroid/view/ViewParent;
    move-result-object v1
    instance-of v3, v1, Landroid/view/ViewGroup;
    if-eqz v3, +005h
    move-object v2, v1
    check-cast v2, Landroid/view/ViewGroup;
    if-eqz v2, +009h
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    check-cast v1, Landroid/view/View;
    invoke-virtual v2, v1, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    iget-object v2, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    check-cast v2, Landroid/view/View;
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v3, v0, v0, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, v3, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    invoke-virtual v1, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    const-string v2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/FrameLayout$LayoutParams;
    iput v0, v1, Landroid/widget/FrameLayout$LayoutParams;->width I
    iput v0, v1, Landroid/widget/FrameLayout$LayoutParams;->height I
    iget v2, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskHeaderHeight I
    sub-int/2addr v2, v0
    div-int/lit8 v2, v2, 2
    iput v2, v1, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    iput v6, v1, Landroid/widget/FrameLayout$LayoutParams;->rightMargin I
    const v6, 8388661
    iput v6, v1, Landroid/widget/FrameLayout$LayoutParams;->gravity I
    iget-object v6, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v1, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method public final setTaskHeaderViewIds(int  int  int  int  int  int  int  int)void
    .registers 10
    # ins_size=9
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setId(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleView Landroid/widget/TextView;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setId(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleChevron Landroidx/appcompat/widget/AppCompatImageView;
    invoke-virtual v2, v4, Landroidx/appcompat/widget/AppCompatImageView;->setId(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v2, v5, Landroidx/appcompat/widget/AppCompatImageButton;->setId(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarContainer Landroid/widget/FrameLayout;
    invoke-virtual v2, v6, Landroid/widget/FrameLayout;->setId(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v2, v7, Lcom/facebook/drawee/view/SimpleDraweeView;->setId(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskAvatarBadge Landroidx/appcompat/widget/AppCompatImageView;
    invoke-virtual v2, v8, Landroidx/appcompat/widget/AppCompatImageView;->setId(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v2, v9, Lcom/facebook/drawee/view/SimpleDraweeView;->setId(I)V
    return-void 
.end method

.method public final setTaskOperationIconVisible(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskOperationVisible Z
    invoke-direct v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->syncTaskHeaderVisibility()V
    invoke-direct v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->updateTaskTitleMargins()V
    return-void 
.end method

.method public final setTaskSearchButtonVisible(boolean)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    if-eqz v3, +004h
    const/4 v1, 0
    goto +3h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskActionContainer Landroid/widget/FrameLayout;
    if-eqz v3, +007h
    invoke-direct v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->createTaskActionBackground()Landroid/graphics/drawable/Drawable;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    return-void 
.end method

.method public final setTaskSearchContentDescription(java.lang.CharSequence)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v0, v2, Landroidx/appcompat/widget/AppCompatImageButton;->setContentDescription(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final setTaskSearchIcon(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v0, v2, Landroidx/appcompat/widget/AppCompatImageButton;->setImageResource(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskSearchButton Landroidx/appcompat/widget/AppCompatImageButton;
    check-cast v2, Landroid/widget/ImageView;
    invoke-direct v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->tintTaskIcon(Landroid/widget/ImageView;)V
    return-void 
.end method

.method public final setTaskTitleTrailingIcon(int)void
    .registers 3
    # ins_size=2
    if-nez v2, +010h
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleChevron Landroidx/appcompat/widget/AppCompatImageView;
    const/4 v0, 0
    invoke-virtual v2, v0, Landroidx/appcompat/widget/AppCompatImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleChevron Landroidx/appcompat/widget/AppCompatImageView;
    const/16 v0, 8
    invoke-virtual v2, v0, Landroidx/appcompat/widget/AppCompatImageView;->setVisibility(I)V
    goto +13h
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleChevron Landroidx/appcompat/widget/AppCompatImageView;
    invoke-virtual v0, v2, Landroidx/appcompat/widget/AppCompatImageView;->setImageResource(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleChevron Landroidx/appcompat/widget/AppCompatImageView;
    const/4 v0, 0
    invoke-virtual v2, v0, Landroidx/appcompat/widget/AppCompatImageView;->setVisibility(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleChevron Landroidx/appcompat/widget/AppCompatImageView;
    check-cast v2, Landroid/widget/ImageView;
    invoke-direct v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->tintTaskIcon(Landroid/widget/ImageView;)V
    invoke-direct v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->updateTaskTitleMargins()V
    return-void 
.end method

.method public final setTitle(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(I)V
    return-void 
.end method

.method public final setTitle(java.lang.CharSequence)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->taskTitleView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final showConversationDetailHeader()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->CONVERSATION_DETAIL Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const/4 v1, 0
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setMode(Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode; Z)V
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->BACK Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-virtual v3, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setLeftAction(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;)V
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CHAT_NEW Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->MORE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    aput-object v2, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    invoke-virtual v3, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActions(Ljava/util/List;)V
    return-void 
.end method

.method public final showMediaPreviewHeader(java.lang.CharSequence)void
    .registers 5
    # ins_size=2
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mediaPreviewAppearance Z
    const/4 v1, 0
    iput-boolean v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->shouldUseImplicitBackground Z
    invoke-virtual v3, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setBackgroundColor(I)V
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->PAGE Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    iput-object v2, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->mode Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    iput-boolean v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showGrabber Z
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->BACK Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    iput-object v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget-object v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->DOWNLOAD Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    iput-object v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightActions Ljava/util/List;
    iput-boolean v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->leftVisible Z
    iput-boolean v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rightVisible Z
    invoke-virtual v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(Ljava/lang/CharSequence;)V
    invoke-direct v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyMode()V
    iget-object v4, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->titleView Landroid/widget/TextView;
    invoke-direct v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->applyTitleTextStyle(Landroid/widget/TextView;)V
    invoke-direct v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->rebuildActions()V
    return-void 
.end method

.method public final showNewConversationHeader()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->NEW_CONVERSATION Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const/4 v1, 0
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setMode(Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode; Z)V
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->BACK Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-virtual v2, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setLeftAction(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;)V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-virtual v2, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActions(Ljava/util/List;)V
    return-void 
.end method

.method public final showTaskListHeader()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->TASK_LIST Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const/4 v1, 0
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setMode(Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode; Z)V
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-virtual v2, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setLeftAction(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;)V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-virtual v2, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActions(Ljava/util/List;)V
    return-void 
.end method
