# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeDimens;
.super Ljava/lang/Object;
.source "TraeComposeTokens.kt"

.field public static final $stable:I
.field private final artifactPreviewErrorIconSize:F
.field private final artifactPreviewLoadingIndicatorSize:F
.field private final artifactPreviewReloadButtonPaddingHorizontal:F
.field private final artifactPreviewReloadButtonPaddingVertical:F
.field private final artifactPreviewReloadButtonRadius:F
.field private final artifactPreviewStateGap:F
.field private final artifactPreviewStateHorizontalPadding:F
.field private final bodyBaseFontSizeSp:J
.field private final bodyBaseLineHeightDp:F
.field private final bodyBaseStrongFontSizeSp:J
.field private final bodyBaseStrongLineHeightDp:F
.field private final bodyBodyBaseFontSizeSp:J
.field private final bodyBodyBaseLineHeightDp:F
.field private final bodyBodyBaseMdFontSizeSp:J
.field private final bodyBodyBaseMdLineHeightDp:F
.field private final bodyBodyBaseStrongFontSizeSp:J
.field private final bodyBodyBaseStrongLineHeightDp:F
.field private final bodyBodySmFontSizeSp:J
.field private final bodyBodySmLineHeightDp:F
.field private final bodyBodySmMdFontSizeSp:J
.field private final bodyBodySmMdLineHeightDp:F
.field private final bodyBodySmStrongFontSizeSp:J
.field private final bodyBodySmStrongLineHeightDp:F
.field private final bodyBodyXsFontSizeSp:J
.field private final bodyBodyXsLineHeightDp:F
.field private final bodyBodyXsMdFontSizeSp:J
.field private final bodyBodyXsMdLineHeightDp:F
.field private final bodyBodyXsStrongFontSizeSp:J
.field private final bodyBodyXsStrongLineHeightDp:F
.field private final bodyMdFontSizeSp:J
.field private final bodyMdLineHeightDp:F
.field private final bodyMdStrongFontSizeSp:J
.field private final bodyMdStrongLineHeightDp:F
.field private final bodySmFontSizeSp:J
.field private final bodySmLineHeightDp:F
.field private final bodySmStrongFontSizeSp:J
.field private final bodySmStrongLineHeightDp:F
.field private final bodyXsFontSizeSp:J
.field private final bodyXsLineHeightDp:F
.field private final captionCaptionBaseFontSizeSp:J
.field private final captionCaptionBaseLineHeightDp:F
.field private final captionCaptionBaseStrongFontSizeSp:J
.field private final captionCaptionBaseStrongLineHeightDp:F
.field private final captionCaptionXsFontSizeSp:J
.field private final captionCaptionXsLineHeightDp:F
.field private final captionCaptionXsStrongFontSizeSp:J
.field private final captionCaptionXsStrongLineHeightDp:F
.field private final codeCodeBaseFontSizeSp:J
.field private final codeCodeBaseLineHeightDp:F
.field private final codeCodeSmFontSizeSp:J
.field private final codeCodeSmLineHeightDp:F
.field private final codeCodeXsFontSizeSp:J
.field private final codeCodeXsLineHeightDp:F
.field private final codeEditorFontSizeSp:J
.field private final codeEditorLineHeightDp:F
.field private final codeTerminalFontSizeSp:J
.field private final codeTerminalLineHeightDp:F
.field private final contextMenuAnchorGap:F
.field private final contextMenuDetailIconTextGap:F
.field private final contextMenuDetailVerticalPadding:F
.field private final contextMenuDetailWidth:F
.field private final contextMenuDividerHeight:F
.field private final contextMenuElevation:F
.field private final contextMenuIconSize:F
.field private final contextMenuItemHeight:F
.field private final contextMenuItemHorizontalPadding:F
.field private final contextMenuRadius:F
.field private final contextMenuShadowBlurRadius:F
.field private final contextMenuShadowOffsetY:F
.field private final contextMenuShadowPaddingBottom:F
.field private final contextMenuShadowPaddingHorizontal:F
.field private final contextMenuShadowPaddingTop:F
.field private final contextMenuTextMarginStart:F
.field private final contextMenuVerticalPadding:F
.field private final contextMenuWidth:F
.field private final fontSizeSp:J
.field private final footnoteFootnoteFontSizeSp:J
.field private final footnoteFootnoteLineHeightDp:F
.field private final footnoteFootnoteStrongFontSizeSp:J
.field private final footnoteFootnoteStrongLineHeightDp:F
.field private final heading2xlFontSizeSp:J
.field private final heading2xlLineHeightDp:F
.field private final heading2xsFontSizeSp:J
.field private final heading2xsLineHeightDp:F
.field private final heading3xlFontSizeSp:J
.field private final heading3xlLineHeightDp:F
.field private final heading3xsFontSizeSp:J
.field private final heading3xsLineHeightDp:F
.field private final headingHeading2xlFontSizeSp:J
.field private final headingHeading2xlLineHeightDp:F
.field private final headingHeading2xlStrongFontSizeSp:J
.field private final headingHeading2xlStrongLineHeightDp:F
.field private final headingHeading3xlFontSizeSp:J
.field private final headingHeading3xlLineHeightDp:F
.field private final headingHeading3xlStrongFontSizeSp:J
.field private final headingHeading3xlStrongLineHeightDp:F
.field private final headingHeadingLgFontSizeSp:J
.field private final headingHeadingLgLineHeightDp:F
.field private final headingHeadingLgStrongFontSizeSp:J
.field private final headingHeadingLgStrongLineHeightDp:F
.field private final headingHeadingMFontSizeSp:J
.field private final headingHeadingMLineHeightDp:F
.field private final headingHeadingMStrongFontSizeSp:J
.field private final headingHeadingMStrongLineHeightDp:F
.field private final headingHeadingXlFontSizeSp:J
.field private final headingHeadingXlLineHeightDp:F
.field private final headingHeadingXlStrongFontSizeSp:J
.field private final headingHeadingXlStrongLineHeightDp:F
.field private final headingLgFontSizeSp:J
.field private final headingLgLineHeightDp:F
.field private final headingMdFontSizeSp:J
.field private final headingMdLineHeightDp:F
.field private final headingSmFontSizeSp:J
.field private final headingSmLineHeightDp:F
.field private final headingXlFontSizeSp:J
.field private final headingXlLineHeightDp:F
.field private final headingXsFontSizeSp:J
.field private final headingXsLineHeightDp:F
.field private final lineHeightDp:F
.field private final loadingViewElevation:F
.field private final titleBarActionGap:F
.field private final titleBarActionSize:F
.field private final titleBarDetailIconSize:F
.field private final titleBarDetailSubtitleGap:F
.field private final titleBarDetailTitleGap:F
.field private final titleBarDownloadIconSize:F
.field private final titleBarElevation:F
.field private final titleBarGrabberContainerHeight:F
.field private final titleBarGrabberHeight:F
.field private final titleBarGrabberWidth:F
.field private final titleBarHorizontalPadding:F
.field private final titleBarIconSize:F
.field private final titleBarOperationHeight:F
.field private final titleBarOperationMarginEnd:F
.field private final titleBarOperationRadius:F
.field private final titleBarOperationWidth:F
.field private final titleBarPageHeight:F
.field private final titleBarSegmentPadding:F
.field private final titleBarSegmentSelectedWidth:F
.field private final titleBarSegmentShadowBlurRadius:F
.field private final titleBarSegmentSlotWidth:F
.field private final titleBarSegmentWidth:F
.field private final titleBarShadowBlurRadius:F
.field private final titleBarShadowOffsetY:F
.field private final titleBarSheetContentHeight:F
.field private final titleBarSheetHeight:F
.field private final titleBarTaskActionPaddingHorizontal:F
.field private final titleBarTaskActionWidth:F
.field private final titleBarTaskAvatarBadgeMarginBottom:F
.field private final titleBarTaskAvatarBadgeMarginEnd:F
.field private final titleBarTaskAvatarBadgeSize:F
.field private final titleBarTaskAvatarSize:F
.field private final titleBarTaskHeight:F
.field private final titleBarTaskTitleIconGap:F
.field private final titleBarTaskTitleIconSize:F
.field private final titleBarTitleSideGap:F
.field private final videoArtifactCardBorderWidth:F
.field private final videoArtifactCardBottomMargin:F
.field private final videoArtifactCardDividerHeight:F
.field private final videoArtifactCardDurationBottomMargin:F
.field private final videoArtifactCardDurationEndMargin:F
.field private final videoArtifactCardDurationHeight:F
.field private final videoArtifactCardDurationHorizontalPadding:F
.field private final videoArtifactCardFileIconContainerSize:F
.field private final videoArtifactCardFileIconSize:F
.field private final videoArtifactCardGradientHeight:F
.field private final videoArtifactCardHeaderHeight:F
.field private final videoArtifactCardHeaderHorizontalPadding:F
.field private final videoArtifactCardHeaderVerticalPadding:F
.field private final videoArtifactCardPlayButtonPadding:F
.field private final videoArtifactCardPlayButtonSize:F
.field private final videoArtifactCardPlayIconSize:F
.field private final videoArtifactCardPreviewHeight:F
.field private final videoArtifactCardRadius:F
.field private final videoArtifactCardTitleGap:F
.field private final videoPreviewControlBottomMargin:F
.field private final videoPreviewControlContentHeight:F
.field private final videoPreviewControlGap:F
.field private final videoPreviewControlHeight:F
.field private final videoPreviewControlHorizontalMargin:F
.field private final videoPreviewControlPaddingEnd:F
.field private final videoPreviewControlPaddingStart:F
.field private final videoPreviewControlPaddingVertical:F
.field private final videoPreviewControlRadius:F
.field private final videoPreviewControlTextRowHeight:F
.field private final videoPreviewPlayIconSize:F
.field private final videoPreviewPlayTouchSize:F
.field private final videoPreviewProgressHeight:F
.field private final videoPreviewProgressHorizontalInset:F
.field private final videoPreviewProgressThumbSize:F
.field private final videoPreviewProgressTrackHeight:F
.field private final videoPreviewSpeedMenuItemHeight:F
.field private final videoPreviewSpeedMenuRadius:F
.field private final videoPreviewSpeedMenuWidth:F
.field private final videoPreviewTitleFontSizeSp:J
.field private final videoPreviewTitleLineHeightDp:F


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method private constructor <init>(float  float  float  float  float  float  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  long  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  long  float)void
    .registers 248
    # ins_size=245
    move-object v0, v3
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    move v1, v4
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewErrorIconSize F
    move v1, v5
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewLoadingIndicatorSize F
    move v1, v6
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingHorizontal F
    move v1, v7
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingVertical F
    move v1, v8
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonRadius F
    move v1, v9
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateGap F
    move v1, v10
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateHorizontalPadding F
    move-wide v1, v11
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseFontSizeSp J
    move v1, v13
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseLineHeightDp F
    move-wide v1, v14
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongFontSizeSp J
    move/from16 v1, v16
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongLineHeightDp F
    move-wide/from16 v1, v17
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseFontSizeSp J
    move/from16 v1, v19
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseLineHeightDp F
    move-wide/from16 v1, v20
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdFontSizeSp J
    move/from16 v1, v22
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdLineHeightDp F
    move-wide/from16 v1, v23
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongFontSizeSp J
    move/from16 v1, v25
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongLineHeightDp F
    move-wide/from16 v1, v26
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmFontSizeSp J
    move/from16 v1, v28
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmLineHeightDp F
    move-wide/from16 v1, v29
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdFontSizeSp J
    move/from16 v1, v31
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdLineHeightDp F
    move-wide/from16 v1, v32
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongFontSizeSp J
    move/from16 v1, v34
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongLineHeightDp F
    move-wide/from16 v1, v35
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsFontSizeSp J
    move/from16 v1, v37
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsLineHeightDp F
    move-wide/from16 v1, v38
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdFontSizeSp J
    move/from16 v1, v40
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdLineHeightDp F
    move-wide/from16 v1, v41
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongFontSizeSp J
    move/from16 v1, v43
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongLineHeightDp F
    move-wide/from16 v1, v44
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdFontSizeSp J
    move/from16 v1, v46
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdLineHeightDp F
    move-wide/from16 v1, v47
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongFontSizeSp J
    move/from16 v1, v49
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongLineHeightDp F
    move-wide/from16 v1, v50
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmFontSizeSp J
    move/from16 v1, v52
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmLineHeightDp F
    move-wide/from16 v1, v53
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongFontSizeSp J
    move/from16 v1, v55
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongLineHeightDp F
    move-wide/from16 v1, v56
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsFontSizeSp J
    move/from16 v1, v58
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsLineHeightDp F
    move-wide/from16 v1, v59
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseFontSizeSp J
    move/from16 v1, v61
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseLineHeightDp F
    move-wide/from16 v1, v62
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongFontSizeSp J
    move/from16 v1, v64
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongLineHeightDp F
    move-wide/from16 v1, v65
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsFontSizeSp J
    move/from16 v1, v67
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsLineHeightDp F
    move-wide/from16 v1, v68
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongFontSizeSp J
    move/from16 v1, v70
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongLineHeightDp F
    move-wide/from16 v1, v71
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseFontSizeSp J
    move/from16 v1, v73
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseLineHeightDp F
    move-wide/from16 v1, v74
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmFontSizeSp J
    move/from16 v1, v76
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmLineHeightDp F
    move-wide/from16 v1, v77
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsFontSizeSp J
    move/from16 v1, v79
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsLineHeightDp F
    move-wide/from16 v1, v80
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorFontSizeSp J
    move/from16 v1, v82
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorLineHeightDp F
    move-wide/from16 v1, v83
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalFontSizeSp J
    move/from16 v1, v85
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalLineHeightDp F
    move/from16 v1, v86
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuAnchorGap F
    move/from16 v1, v87
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailIconTextGap F
    move/from16 v1, v88
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailVerticalPadding F
    move/from16 v1, v89
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailWidth F
    move/from16 v1, v90
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDividerHeight F
    move/from16 v1, v91
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuElevation F
    move/from16 v1, v92
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuIconSize F
    move/from16 v1, v93
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHeight F
    move/from16 v1, v94
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHorizontalPadding F
    move/from16 v1, v95
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuRadius F
    move/from16 v1, v96
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowBlurRadius F
    move/from16 v1, v97
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowOffsetY F
    move/from16 v1, v98
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingBottom F
    move/from16 v1, v99
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingHorizontal F
    move/from16 v1, v100
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingTop F
    move/from16 v1, v101
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuTextMarginStart F
    move/from16 v1, v102
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuVerticalPadding F
    move/from16 v1, v103
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuWidth F
    move-wide/from16 v1, v104
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->fontSizeSp J
    move-wide/from16 v1, v106
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteFontSizeSp J
    move/from16 v1, v108
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteLineHeightDp F
    move-wide/from16 v1, v109
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongFontSizeSp J
    move/from16 v1, v111
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongLineHeightDp F
    move-wide/from16 v1, v112
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlFontSizeSp J
    move/from16 v1, v114
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlLineHeightDp F
    move-wide/from16 v1, v115
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsFontSizeSp J
    move/from16 v1, v117
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsLineHeightDp F
    move-wide/from16 v1, v118
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlFontSizeSp J
    move/from16 v1, v120
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlLineHeightDp F
    move-wide/from16 v1, v121
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsFontSizeSp J
    move/from16 v1, v123
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsLineHeightDp F
    move-wide/from16 v1, v124
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlFontSizeSp J
    move/from16 v1, v126
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlLineHeightDp F
    move-wide/from16 v1, v127
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongFontSizeSp J
    move/from16 v1, v129
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongLineHeightDp F
    move-wide/from16 v1, v130
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlFontSizeSp J
    move/from16 v1, v132
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlLineHeightDp F
    move-wide/from16 v1, v133
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongFontSizeSp J
    move/from16 v1, v135
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongLineHeightDp F
    move-wide/from16 v1, v136
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgFontSizeSp J
    move/from16 v1, v138
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgLineHeightDp F
    move-wide/from16 v1, v139
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongFontSizeSp J
    move/from16 v1, v141
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongLineHeightDp F
    move-wide/from16 v1, v142
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMFontSizeSp J
    move/from16 v1, v144
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMLineHeightDp F
    move-wide/from16 v1, v145
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongFontSizeSp J
    move/from16 v1, v147
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongLineHeightDp F
    move-wide/from16 v1, v148
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlFontSizeSp J
    move/from16 v1, v150
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlLineHeightDp F
    move-wide/from16 v1, v151
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongFontSizeSp J
    move/from16 v1, v153
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongLineHeightDp F
    move-wide/from16 v1, v154
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgFontSizeSp J
    move/from16 v1, v156
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgLineHeightDp F
    move-wide/from16 v1, v157
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdFontSizeSp J
    move/from16 v1, v159
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdLineHeightDp F
    move-wide/from16 v1, v160
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmFontSizeSp J
    move/from16 v1, v162
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmLineHeightDp F
    move-wide/from16 v1, v163
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlFontSizeSp J
    move/from16 v1, v165
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlLineHeightDp F
    move-wide/from16 v1, v166
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsFontSizeSp J
    move/from16 v1, v168
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsLineHeightDp F
    move/from16 v1, v169
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->lineHeightDp F
    move/from16 v1, v170
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->loadingViewElevation F
    move/from16 v1, v171
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionGap F
    move/from16 v1, v172
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionSize F
    move/from16 v1, v173
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailIconSize F
    move/from16 v1, v174
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailSubtitleGap F
    move/from16 v1, v175
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailTitleGap F
    move/from16 v1, v176
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDownloadIconSize F
    move/from16 v1, v177
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarElevation F
    move/from16 v1, v178
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberContainerHeight F
    move/from16 v1, v179
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberHeight F
    move/from16 v1, v180
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberWidth F
    move/from16 v1, v181
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarHorizontalPadding F
    move/from16 v1, v182
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarIconSize F
    move/from16 v1, v183
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationHeight F
    move/from16 v1, v184
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationMarginEnd F
    move/from16 v1, v185
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationRadius F
    move/from16 v1, v186
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationWidth F
    move/from16 v1, v187
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarPageHeight F
    move/from16 v1, v188
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentPadding F
    move/from16 v1, v189
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSelectedWidth F
    move/from16 v1, v190
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentShadowBlurRadius F
    move/from16 v1, v191
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSlotWidth F
    move/from16 v1, v192
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentWidth F
    move/from16 v1, v193
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowBlurRadius F
    move/from16 v1, v194
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowOffsetY F
    move/from16 v1, v195
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetContentHeight F
    move/from16 v1, v196
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetHeight F
    move/from16 v1, v197
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionPaddingHorizontal F
    move/from16 v1, v198
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionWidth F
    move/from16 v1, v199
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginBottom F
    move/from16 v1, v200
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginEnd F
    move/from16 v1, v201
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeSize F
    move/from16 v1, v202
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarSize F
    move/from16 v1, v203
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskHeight F
    move/from16 v1, v204
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconGap F
    move/from16 v1, v205
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconSize F
    move/from16 v1, v206
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTitleSideGap F
    move/from16 v1, v207
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBorderWidth F
    move/from16 v1, v208
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBottomMargin F
    move/from16 v1, v209
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDividerHeight F
    move/from16 v1, v210
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationBottomMargin F
    move/from16 v1, v211
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationEndMargin F
    move/from16 v1, v212
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHeight F
    move/from16 v1, v213
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHorizontalPadding F
    move/from16 v1, v214
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconContainerSize F
    move/from16 v1, v215
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconSize F
    move/from16 v1, v216
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardGradientHeight F
    move/from16 v1, v217
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHeight F
    move/from16 v1, v218
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHorizontalPadding F
    move/from16 v1, v219
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderVerticalPadding F
    move/from16 v1, v220
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonPadding F
    move/from16 v1, v221
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonSize F
    move/from16 v1, v222
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayIconSize F
    move/from16 v1, v223
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPreviewHeight F
    move/from16 v1, v224
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardRadius F
    move/from16 v1, v225
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardTitleGap F
    move/from16 v1, v226
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlBottomMargin F
    move/from16 v1, v227
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlContentHeight F
    move/from16 v1, v228
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlGap F
    move/from16 v1, v229
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHeight F
    move/from16 v1, v230
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHorizontalMargin F
    move/from16 v1, v231
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingEnd F
    move/from16 v1, v232
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingStart F
    move/from16 v1, v233
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingVertical F
    move/from16 v1, v234
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlRadius F
    move/from16 v1, v235
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlTextRowHeight F
    move/from16 v1, v236
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayIconSize F
    move/from16 v1, v237
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayTouchSize F
    move/from16 v1, v238
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHeight F
    move/from16 v1, v239
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHorizontalInset F
    move/from16 v1, v240
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressThumbSize F
    move/from16 v1, v241
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressTrackHeight F
    move/from16 v1, v242
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuItemHeight F
    move/from16 v1, v243
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuRadius F
    move/from16 v1, v244
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuWidth F
    move-wide/from16 v1, v245
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleFontSizeSp J
    move/from16 v1, v247
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleLineHeightDp F
    return-void 
.end method

.method public synthetic constructor <init>(float  float  float  float  float  float  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  long  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  long  float  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 246
    # ins_size=246
    invoke-direct/range v0 ... v244, Lcom/bytedance/trae/design/compose/TraeDimens;-><init>(F F F F F F F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F F F F F F F F F F F F F F F F F F F J J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F J F)V
    return-void 
.end method

.method public static synthetic copy-LXmn6JE$default(com.bytedance.trae.design.compose.TraeDimens  float  float  float  float  float  float  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  long  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  long  float  int  int  int  int  int  int  int  java.lang.Object)com.bytedance.trae.design.compose.TraeDimens
    .registers 275
    # ins_size=253
    move-object/from16 v0, v22
    move/from16 v1, v267
    move/from16 v2, v268
    move/from16 v3, v269
    move/from16 v4, v270
    move/from16 v5, v271
    move/from16 v6, v272
    move/from16 v7, v273
    and-int/lit8 v8, v1, 1
    if-eqz v8, +005h
    iget v8, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewErrorIconSize F
    goto +3h
    move/from16 v8, v23
    and-int/lit8 v9, v1, 2
    if-eqz v9, +005h
    iget v9, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewLoadingIndicatorSize F
    goto +3h
    move/from16 v9, v24
    and-int/lit8 v10, v1, 4
    if-eqz v10, +005h
    iget v10, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingHorizontal F
    goto +3h
    move/from16 v10, v25
    and-int/lit8 v11, v1, 8
    if-eqz v11, +005h
    iget v11, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingVertical F
    goto +3h
    move/from16 v11, v26
    and-int/lit8 v12, v1, 16
    if-eqz v12, +005h
    iget v12, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonRadius F
    goto +3h
    move/from16 v12, v27
    and-int/lit8 v13, v1, 32
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateGap F
    goto +3h
    move/from16 v13, v28
    and-int/lit8 v14, v1, 64
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateHorizontalPadding F
    goto +3h
    move/from16 v14, v29
    and-int/lit16 v15, v1, 128
    move/from16 v29, v14
    if-eqz v15, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseFontSizeSp J
    goto +3h
    move-wide/from16 v14, v30
    move-wide/from16 v30, v14
    and-int/lit16 v14, v1, 256
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseLineHeightDp F
    goto +3h
    move/from16 v14, v32
    and-int/lit16 v15, v1, 512
    move/from16 v32, v14
    if-eqz v15, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongFontSizeSp J
    goto +3h
    move-wide/from16 v14, v33
    move-wide/from16 v33, v14
    and-int/lit16 v14, v1, 1024
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongLineHeightDp F
    goto +3h
    move/from16 v14, v35
    and-int/lit16 v15, v1, 2048
    move/from16 v35, v14
    if-eqz v15, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseFontSizeSp J
    goto +3h
    move-wide/from16 v14, v36
    move-wide/from16 v36, v14
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseLineHeightDp F
    goto +3h
    move/from16 v14, v38
    and-int/lit16 v15, v1, 8192
    move/from16 v38, v14
    if-eqz v15, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdFontSizeSp J
    goto +3h
    move-wide/from16 v14, v39
    move-wide/from16 v39, v14
    and-int/lit16 v14, v1, 16384
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdLineHeightDp F
    goto +3h
    move/from16 v14, v41
    const v15, 32768
    and-int v16, v1, v15
    move/from16 v28, v13
    move/from16 v41, v14
    if-eqz v16, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v42
    const/high16 v16, 65536
    and-int v17, v1, v16
    if-eqz v17, +005h
    iget v15, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongLineHeightDp F
    goto +3h
    move/from16 v15, v44
    const/high16 v17, 131072
    and-int v18, v1, v17
    move-wide/from16 v42, v13
    if-eqz v18, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmFontSizeSp J
    goto +3h
    move-wide/from16 v13, v45
    const/high16 v18, 262144
    and-int v19, v1, v18
    move-wide/from16 v45, v13
    if-eqz v19, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmLineHeightDp F
    goto +3h
    move/from16 v13, v47
    const/high16 v14, 524288
    and-int v19, v1, v14
    move/from16 v44, v15
    if-eqz v19, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdFontSizeSp J
    goto +3h
    move-wide/from16 v14, v48
    const/high16 v19, 1048576
    and-int v20, v1, v19
    move-wide/from16 v48, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdLineHeightDp F
    goto +3h
    move/from16 v14, v50
    const/high16 v15, 2097152
    and-int v20, v1, v15
    move/from16 v47, v13
    move/from16 v50, v14
    if-eqz v20, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v51
    const/high16 v20, 4194304
    and-int v20, v1, v20
    if-eqz v20, +005h
    iget v15, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongLineHeightDp F
    goto +3h
    move/from16 v15, v53
    const/high16 v20, 8388608
    and-int v20, v1, v20
    move-wide/from16 v51, v13
    if-eqz v20, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsFontSizeSp J
    goto +3h
    move-wide/from16 v13, v54
    const/high16 v20, 16777216
    and-int v20, v1, v20
    move-wide/from16 v54, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsLineHeightDp F
    goto +3h
    move/from16 v13, v56
    const/high16 v14, 33554432
    and-int/2addr v14, v1
    move/from16 v56, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdFontSizeSp J
    goto +3h
    move-wide/from16 v13, v57
    const/high16 v20, 67108864
    and-int v20, v1, v20
    move-wide/from16 v57, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdLineHeightDp F
    goto +3h
    move/from16 v13, v59
    const/high16 v14, 134217728
    and-int/2addr v14, v1
    move/from16 v59, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v60
    const/high16 v20, 268435456
    and-int v20, v1, v20
    move-wide/from16 v60, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongLineHeightDp F
    goto +3h
    move/from16 v13, v62
    const/high16 v14, 536870912
    and-int/2addr v14, v1
    move/from16 v62, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdFontSizeSp J
    goto +3h
    move-wide/from16 v13, v63
    const/high16 v20, 1073741824
    and-int v20, v1, v20
    move-wide/from16 v63, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdLineHeightDp F
    goto +3h
    move/from16 v13, v65
    const/high16 v14, -2147483648
    and-int/2addr v1, v14
    move/from16 v65, v13
    if-eqz v1, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v66
    and-int/lit8 v1, v2, 1
    if-eqz v1, +005h
    iget v1, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongLineHeightDp F
    goto +3h
    move/from16 v1, v68
    and-int/lit8 v20, v2, 2
    move-wide/from16 v66, v13
    if-eqz v20, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmFontSizeSp J
    goto +3h
    move-wide/from16 v13, v69
    and-int/lit8 v20, v2, 4
    move-wide/from16 v69, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmLineHeightDp F
    goto +3h
    move/from16 v13, v71
    and-int/lit8 v14, v2, 8
    move/from16 v71, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v72
    and-int/lit8 v20, v2, 16
    move-wide/from16 v72, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongLineHeightDp F
    goto +3h
    move/from16 v13, v74
    and-int/lit8 v14, v2, 32
    move/from16 v74, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsFontSizeSp J
    goto +3h
    move-wide/from16 v13, v75
    and-int/lit8 v20, v2, 64
    move-wide/from16 v75, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsLineHeightDp F
    goto +3h
    move/from16 v13, v77
    and-int/lit16 v14, v2, 128
    move/from16 v77, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseFontSizeSp J
    goto +3h
    move-wide/from16 v13, v78
    move-wide/from16 v78, v13
    and-int/lit16 v13, v2, 256
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseLineHeightDp F
    goto +3h
    move/from16 v13, v80
    and-int/lit16 v14, v2, 512
    move/from16 v80, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v81
    move-wide/from16 v81, v13
    and-int/lit16 v13, v2, 1024
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongLineHeightDp F
    goto +3h
    move/from16 v13, v83
    and-int/lit16 v14, v2, 2048
    move/from16 v83, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsFontSizeSp J
    goto +3h
    move-wide/from16 v13, v84
    move-wide/from16 v84, v13
    and-int/lit16 v13, v2, 4096
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsLineHeightDp F
    goto +3h
    move/from16 v13, v86
    and-int/lit16 v14, v2, 8192
    move/from16 v86, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v87
    move-wide/from16 v87, v13
    and-int/lit16 v13, v2, 16384
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongLineHeightDp F
    goto +3h
    move/from16 v13, v89
    const v14, 32768
    and-int v20, v2, v14
    move/from16 v89, v13
    if-eqz v20, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseFontSizeSp J
    goto +3h
    move-wide/from16 v13, v90
    and-int v20, v2, v16
    move-wide/from16 v90, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseLineHeightDp F
    goto +3h
    move/from16 v13, v92
    and-int v14, v2, v17
    move/from16 v92, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmFontSizeSp J
    goto +3h
    move-wide/from16 v13, v93
    and-int v20, v2, v18
    move-wide/from16 v93, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmLineHeightDp F
    goto +3h
    move/from16 v13, v95
    const/high16 v14, 524288
    and-int v20, v2, v14
    move/from16 v95, v13
    if-eqz v20, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsFontSizeSp J
    goto +3h
    move-wide/from16 v13, v96
    and-int v20, v2, v19
    move-wide/from16 v96, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsLineHeightDp F
    goto +3h
    move/from16 v13, v98
    const/high16 v14, 2097152
    and-int v20, v2, v14
    move/from16 v98, v13
    if-eqz v20, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorFontSizeSp J
    goto +3h
    move-wide/from16 v13, v99
    const/high16 v20, 4194304
    and-int v20, v2, v20
    move-wide/from16 v99, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorLineHeightDp F
    goto +3h
    move/from16 v13, v101
    const/high16 v14, 8388608
    and-int/2addr v14, v2
    move/from16 v101, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalFontSizeSp J
    goto +3h
    move-wide/from16 v13, v102
    const/high16 v20, 16777216
    and-int v20, v2, v20
    move-wide/from16 v102, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalLineHeightDp F
    goto +3h
    move/from16 v13, v104
    const/high16 v14, 33554432
    and-int/2addr v14, v2
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuAnchorGap F
    goto +3h
    move/from16 v14, v105
    const/high16 v20, 67108864
    and-int v20, v2, v20
    move/from16 v105, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailIconTextGap F
    goto +3h
    move/from16 v14, v106
    const/high16 v20, 134217728
    and-int v20, v2, v20
    move/from16 v106, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailVerticalPadding F
    goto +3h
    move/from16 v14, v107
    const/high16 v20, 268435456
    and-int v20, v2, v20
    move/from16 v107, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailWidth F
    goto +3h
    move/from16 v14, v108
    const/high16 v20, 536870912
    and-int v20, v2, v20
    move/from16 v108, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDividerHeight F
    goto +3h
    move/from16 v14, v109
    const/high16 v20, 1073741824
    and-int v20, v2, v20
    move/from16 v109, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuElevation F
    goto +3h
    move/from16 v14, v110
    const/high16 v20, -2147483648
    and-int v2, v2, v20
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuIconSize F
    goto +3h
    move/from16 v2, v111
    and-int/lit8 v20, v3, 1
    move/from16 v111, v2
    if-eqz v20, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHeight F
    goto +3h
    move/from16 v2, v112
    and-int/lit8 v20, v3, 2
    move/from16 v112, v2
    if-eqz v20, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHorizontalPadding F
    goto +3h
    move/from16 v2, v113
    and-int/lit8 v20, v3, 4
    move/from16 v113, v2
    if-eqz v20, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuRadius F
    goto +3h
    move/from16 v2, v114
    and-int/lit8 v20, v3, 8
    move/from16 v114, v2
    if-eqz v20, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowBlurRadius F
    goto +3h
    move/from16 v2, v115
    and-int/lit8 v20, v3, 16
    move/from16 v115, v2
    if-eqz v20, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowOffsetY F
    goto +3h
    move/from16 v2, v116
    and-int/lit8 v20, v3, 32
    move/from16 v116, v2
    if-eqz v20, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingBottom F
    goto +3h
    move/from16 v2, v117
    and-int/lit8 v20, v3, 64
    move/from16 v117, v2
    if-eqz v20, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingHorizontal F
    goto +3h
    move/from16 v2, v118
    move/from16 v118, v2
    and-int/lit16 v2, v3, 128
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingTop F
    goto +3h
    move/from16 v2, v119
    move/from16 v119, v2
    and-int/lit16 v2, v3, 256
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuTextMarginStart F
    goto +3h
    move/from16 v2, v120
    move/from16 v120, v2
    and-int/lit16 v2, v3, 512
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuVerticalPadding F
    goto +3h
    move/from16 v2, v121
    move/from16 v121, v2
    and-int/lit16 v2, v3, 1024
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuWidth F
    goto +3h
    move/from16 v2, v122
    move/from16 v122, v2
    and-int/lit16 v2, v3, 2048
    move/from16 v104, v13
    move/from16 v110, v14
    if-eqz v2, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->fontSizeSp J
    goto +3h
    move-wide/from16 v13, v123
    and-int/lit16 v2, v3, 4096
    move-wide/from16 v123, v13
    if-eqz v2, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteFontSizeSp J
    goto +3h
    move-wide/from16 v13, v125
    and-int/lit16 v2, v3, 8192
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteLineHeightDp F
    goto +3h
    move/from16 v2, v127
    move/from16 v127, v2
    and-int/lit16 v2, v3, 16384
    move-wide/from16 v125, v13
    if-eqz v2, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v128
    const v2, 32768
    and-int v20, v3, v2
    if-eqz v20, +005h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongLineHeightDp F
    goto +3h
    move/from16 v2, v130
    and-int v20, v3, v16
    move-wide/from16 v128, v13
    if-eqz v20, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlFontSizeSp J
    goto +3h
    move-wide/from16 v13, v131
    and-int v20, v3, v17
    move-wide/from16 v131, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlLineHeightDp F
    goto +3h
    move/from16 v13, v133
    and-int v14, v3, v18
    move/from16 v133, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsFontSizeSp J
    goto +3h
    move-wide/from16 v13, v134
    const/high16 v20, 524288
    and-int v21, v3, v20
    move-wide/from16 v134, v13
    if-eqz v21, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsLineHeightDp F
    goto +3h
    move/from16 v13, v136
    and-int v14, v3, v19
    move/from16 v136, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlFontSizeSp J
    goto +3h
    move-wide/from16 v13, v137
    const/high16 v20, 2097152
    and-int v21, v3, v20
    move-wide/from16 v137, v13
    if-eqz v21, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlLineHeightDp F
    goto +3h
    move/from16 v13, v139
    const/high16 v14, 4194304
    and-int/2addr v14, v3
    move/from16 v139, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsFontSizeSp J
    goto +3h
    move-wide/from16 v13, v140
    const/high16 v20, 8388608
    and-int v20, v3, v20
    move-wide/from16 v140, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsLineHeightDp F
    goto +3h
    move/from16 v13, v142
    const/high16 v14, 16777216
    and-int/2addr v14, v3
    move/from16 v142, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlFontSizeSp J
    goto +3h
    move-wide/from16 v13, v143
    const/high16 v20, 33554432
    and-int v20, v3, v20
    move-wide/from16 v143, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlLineHeightDp F
    goto +3h
    move/from16 v13, v145
    const/high16 v14, 67108864
    and-int/2addr v14, v3
    move/from16 v145, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v146
    const/high16 v20, 134217728
    and-int v20, v3, v20
    move-wide/from16 v146, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongLineHeightDp F
    goto +3h
    move/from16 v13, v148
    const/high16 v14, 268435456
    and-int/2addr v14, v3
    move/from16 v148, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlFontSizeSp J
    goto +3h
    move-wide/from16 v13, v149
    const/high16 v20, 536870912
    and-int v20, v3, v20
    move-wide/from16 v149, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlLineHeightDp F
    goto +3h
    move/from16 v13, v151
    const/high16 v14, 1073741824
    and-int/2addr v14, v3
    move/from16 v151, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v152
    const/high16 v20, -2147483648
    and-int v3, v3, v20
    if-eqz v3, +005h
    iget v3, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongLineHeightDp F
    goto +3h
    move/from16 v3, v154
    and-int/lit8 v20, v4, 1
    move-wide/from16 v152, v13
    if-eqz v20, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgFontSizeSp J
    goto +3h
    move-wide/from16 v13, v155
    and-int/lit8 v20, v4, 2
    move-wide/from16 v155, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgLineHeightDp F
    goto +3h
    move/from16 v13, v157
    and-int/lit8 v14, v4, 4
    move/from16 v157, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v158
    and-int/lit8 v20, v4, 8
    move-wide/from16 v158, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongLineHeightDp F
    goto +3h
    move/from16 v13, v160
    and-int/lit8 v14, v4, 16
    move/from16 v160, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMFontSizeSp J
    goto +3h
    move-wide/from16 v13, v161
    and-int/lit8 v20, v4, 32
    move-wide/from16 v161, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMLineHeightDp F
    goto +3h
    move/from16 v13, v163
    and-int/lit8 v14, v4, 64
    move/from16 v163, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v164
    move-wide/from16 v164, v13
    and-int/lit16 v13, v4, 128
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongLineHeightDp F
    goto +3h
    move/from16 v13, v166
    and-int/lit16 v14, v4, 256
    move/from16 v166, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlFontSizeSp J
    goto +3h
    move-wide/from16 v13, v167
    move-wide/from16 v167, v13
    and-int/lit16 v13, v4, 512
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlLineHeightDp F
    goto +3h
    move/from16 v13, v169
    and-int/lit16 v14, v4, 1024
    move/from16 v169, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongFontSizeSp J
    goto +3h
    move-wide/from16 v13, v170
    move-wide/from16 v170, v13
    and-int/lit16 v13, v4, 2048
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongLineHeightDp F
    goto +3h
    move/from16 v13, v172
    and-int/lit16 v14, v4, 4096
    move/from16 v172, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgFontSizeSp J
    goto +3h
    move-wide/from16 v13, v173
    move-wide/from16 v173, v13
    and-int/lit16 v13, v4, 8192
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgLineHeightDp F
    goto +3h
    move/from16 v13, v175
    and-int/lit16 v14, v4, 16384
    move/from16 v175, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdFontSizeSp J
    goto +3h
    move-wide/from16 v13, v176
    const v20, 32768
    and-int v21, v4, v20
    move-wide/from16 v176, v13
    if-eqz v21, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdLineHeightDp F
    goto +3h
    move/from16 v13, v178
    and-int v14, v4, v16
    move/from16 v178, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmFontSizeSp J
    goto +3h
    move-wide/from16 v13, v179
    and-int v20, v4, v17
    move-wide/from16 v179, v13
    if-eqz v20, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmLineHeightDp F
    goto +3h
    move/from16 v13, v181
    and-int v14, v4, v18
    move/from16 v181, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlFontSizeSp J
    goto +3h
    move-wide/from16 v13, v182
    const/high16 v20, 524288
    and-int v21, v4, v20
    move-wide/from16 v182, v13
    if-eqz v21, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlLineHeightDp F
    goto +3h
    move/from16 v13, v184
    and-int v14, v4, v19
    move/from16 v184, v13
    if-eqz v14, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsFontSizeSp J
    goto +3h
    move-wide/from16 v13, v185
    const/high16 v20, 2097152
    and-int v21, v4, v20
    move-wide/from16 v185, v13
    if-eqz v21, +005h
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsLineHeightDp F
    goto +3h
    move/from16 v13, v187
    const/high16 v14, 4194304
    and-int/2addr v14, v4
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->lineHeightDp F
    goto +3h
    move/from16 v14, v188
    const/high16 v20, 8388608
    and-int v20, v4, v20
    move/from16 v188, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->loadingViewElevation F
    goto +3h
    move/from16 v14, v189
    const/high16 v20, 16777216
    and-int v20, v4, v20
    move/from16 v189, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionGap F
    goto +3h
    move/from16 v14, v190
    const/high16 v20, 33554432
    and-int v20, v4, v20
    move/from16 v190, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionSize F
    goto +3h
    move/from16 v14, v191
    const/high16 v20, 67108864
    and-int v20, v4, v20
    move/from16 v191, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailIconSize F
    goto +3h
    move/from16 v14, v192
    const/high16 v20, 134217728
    and-int v20, v4, v20
    move/from16 v192, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailSubtitleGap F
    goto +3h
    move/from16 v14, v193
    const/high16 v20, 268435456
    and-int v20, v4, v20
    move/from16 v193, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailTitleGap F
    goto +3h
    move/from16 v14, v194
    const/high16 v20, 536870912
    and-int v20, v4, v20
    move/from16 v194, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDownloadIconSize F
    goto +3h
    move/from16 v14, v195
    const/high16 v20, 1073741824
    and-int v20, v4, v20
    move/from16 v195, v14
    if-eqz v20, +005h
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarElevation F
    goto +3h
    move/from16 v14, v196
    const/high16 v20, -2147483648
    and-int v4, v4, v20
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberContainerHeight F
    goto +3h
    move/from16 v4, v197
    and-int/lit8 v20, v5, 1
    move/from16 v197, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberHeight F
    goto +3h
    move/from16 v4, v198
    and-int/lit8 v20, v5, 2
    move/from16 v198, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberWidth F
    goto +3h
    move/from16 v4, v199
    and-int/lit8 v20, v5, 4
    move/from16 v199, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarHorizontalPadding F
    goto +3h
    move/from16 v4, v200
    and-int/lit8 v20, v5, 8
    move/from16 v200, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarIconSize F
    goto +3h
    move/from16 v4, v201
    and-int/lit8 v20, v5, 16
    move/from16 v201, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationHeight F
    goto +3h
    move/from16 v4, v202
    and-int/lit8 v20, v5, 32
    move/from16 v202, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationMarginEnd F
    goto +3h
    move/from16 v4, v203
    and-int/lit8 v20, v5, 64
    move/from16 v203, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationRadius F
    goto +3h
    move/from16 v4, v204
    move/from16 v204, v4
    and-int/lit16 v4, v5, 128
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationWidth F
    goto +3h
    move/from16 v4, v205
    move/from16 v205, v4
    and-int/lit16 v4, v5, 256
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarPageHeight F
    goto +3h
    move/from16 v4, v206
    move/from16 v206, v4
    and-int/lit16 v4, v5, 512
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentPadding F
    goto +3h
    move/from16 v4, v207
    move/from16 v207, v4
    and-int/lit16 v4, v5, 1024
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSelectedWidth F
    goto +3h
    move/from16 v4, v208
    move/from16 v208, v4
    and-int/lit16 v4, v5, 2048
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentShadowBlurRadius F
    goto +3h
    move/from16 v4, v209
    move/from16 v209, v4
    and-int/lit16 v4, v5, 4096
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSlotWidth F
    goto +3h
    move/from16 v4, v210
    move/from16 v210, v4
    and-int/lit16 v4, v5, 8192
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentWidth F
    goto +3h
    move/from16 v4, v211
    move/from16 v211, v4
    and-int/lit16 v4, v5, 16384
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowBlurRadius F
    goto +3h
    move/from16 v4, v212
    const v20, 32768
    and-int v21, v5, v20
    move/from16 v212, v4
    if-eqz v21, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowOffsetY F
    goto +3h
    move/from16 v4, v213
    and-int v20, v5, v16
    move/from16 v213, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetContentHeight F
    goto +3h
    move/from16 v4, v214
    and-int v20, v5, v17
    move/from16 v214, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetHeight F
    goto +3h
    move/from16 v4, v215
    and-int v20, v5, v18
    move/from16 v215, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionPaddingHorizontal F
    goto +3h
    move/from16 v4, v216
    const/high16 v20, 524288
    and-int v21, v5, v20
    move/from16 v216, v4
    if-eqz v21, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionWidth F
    goto +3h
    move/from16 v4, v217
    and-int v20, v5, v19
    move/from16 v217, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginBottom F
    goto +3h
    move/from16 v4, v218
    const/high16 v20, 2097152
    and-int v21, v5, v20
    move/from16 v218, v4
    if-eqz v21, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginEnd F
    goto +3h
    move/from16 v4, v219
    const/high16 v20, 4194304
    and-int v20, v5, v20
    move/from16 v219, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeSize F
    goto +3h
    move/from16 v4, v220
    const/high16 v20, 8388608
    and-int v20, v5, v20
    move/from16 v220, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarSize F
    goto +3h
    move/from16 v4, v221
    const/high16 v20, 16777216
    and-int v20, v5, v20
    move/from16 v221, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskHeight F
    goto +3h
    move/from16 v4, v222
    const/high16 v20, 33554432
    and-int v20, v5, v20
    move/from16 v222, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconGap F
    goto +3h
    move/from16 v4, v223
    const/high16 v20, 67108864
    and-int v20, v5, v20
    move/from16 v223, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconSize F
    goto +3h
    move/from16 v4, v224
    const/high16 v20, 134217728
    and-int v20, v5, v20
    move/from16 v224, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTitleSideGap F
    goto +3h
    move/from16 v4, v225
    const/high16 v20, 268435456
    and-int v20, v5, v20
    move/from16 v225, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBorderWidth F
    goto +3h
    move/from16 v4, v226
    const/high16 v20, 536870912
    and-int v20, v5, v20
    move/from16 v226, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBottomMargin F
    goto +3h
    move/from16 v4, v227
    const/high16 v20, 1073741824
    and-int v20, v5, v20
    move/from16 v227, v4
    if-eqz v20, +005h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDividerHeight F
    goto +3h
    move/from16 v4, v228
    const/high16 v20, -2147483648
    and-int v5, v5, v20
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationBottomMargin F
    goto +3h
    move/from16 v5, v229
    and-int/lit8 v20, v6, 1
    move/from16 v229, v5
    if-eqz v20, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationEndMargin F
    goto +3h
    move/from16 v5, v230
    and-int/lit8 v20, v6, 2
    move/from16 v230, v5
    if-eqz v20, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHeight F
    goto +3h
    move/from16 v5, v231
    and-int/lit8 v20, v6, 4
    move/from16 v231, v5
    if-eqz v20, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHorizontalPadding F
    goto +3h
    move/from16 v5, v232
    and-int/lit8 v20, v6, 8
    move/from16 v232, v5
    if-eqz v20, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconContainerSize F
    goto +3h
    move/from16 v5, v233
    and-int/lit8 v20, v6, 16
    move/from16 v233, v5
    if-eqz v20, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconSize F
    goto +3h
    move/from16 v5, v234
    and-int/lit8 v20, v6, 32
    move/from16 v234, v5
    if-eqz v20, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardGradientHeight F
    goto +3h
    move/from16 v5, v235
    and-int/lit8 v20, v6, 64
    move/from16 v235, v5
    if-eqz v20, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHeight F
    goto +3h
    move/from16 v5, v236
    move/from16 v236, v5
    and-int/lit16 v5, v6, 128
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHorizontalPadding F
    goto +3h
    move/from16 v5, v237
    move/from16 v237, v5
    and-int/lit16 v5, v6, 256
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderVerticalPadding F
    goto +3h
    move/from16 v5, v238
    move/from16 v238, v5
    and-int/lit16 v5, v6, 512
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonPadding F
    goto +3h
    move/from16 v5, v239
    move/from16 v239, v5
    and-int/lit16 v5, v6, 1024
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonSize F
    goto +3h
    move/from16 v5, v240
    move/from16 v240, v5
    and-int/lit16 v5, v6, 2048
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayIconSize F
    goto +3h
    move/from16 v5, v241
    move/from16 v241, v5
    and-int/lit16 v5, v6, 4096
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPreviewHeight F
    goto +3h
    move/from16 v5, v242
    move/from16 v242, v5
    and-int/lit16 v5, v6, 8192
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardRadius F
    goto +3h
    move/from16 v5, v243
    move/from16 v243, v5
    and-int/lit16 v5, v6, 16384
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardTitleGap F
    goto +3h
    move/from16 v5, v244
    const v20, 32768
    and-int v20, v6, v20
    move/from16 v244, v5
    if-eqz v20, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlBottomMargin F
    goto +3h
    move/from16 v5, v245
    and-int v16, v6, v16
    move/from16 v245, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlContentHeight F
    goto +3h
    move/from16 v5, v246
    and-int v16, v6, v17
    move/from16 v246, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlGap F
    goto +3h
    move/from16 v5, v247
    and-int v16, v6, v18
    move/from16 v247, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHeight F
    goto +3h
    move/from16 v5, v248
    const/high16 v16, 524288
    and-int v16, v6, v16
    move/from16 v248, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHorizontalMargin F
    goto +3h
    move/from16 v5, v249
    and-int v16, v6, v19
    move/from16 v249, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingEnd F
    goto +3h
    move/from16 v5, v250
    const/high16 v16, 2097152
    and-int v16, v6, v16
    move/from16 v250, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingStart F
    goto +3h
    move/from16 v5, v251
    const/high16 v16, 4194304
    and-int v16, v6, v16
    move/from16 v251, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingVertical F
    goto +3h
    move/from16 v5, v252
    const/high16 v16, 8388608
    and-int v16, v6, v16
    move/from16 v252, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlRadius F
    goto +3h
    move/from16 v5, v253
    const/high16 v16, 16777216
    and-int v16, v6, v16
    move/from16 v253, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlTextRowHeight F
    goto +3h
    move/from16 v5, v254
    const/high16 v16, 33554432
    and-int v16, v6, v16
    move/from16 v254, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayIconSize F
    goto +3h
    move/from16 v5, v255
    const/high16 v16, 67108864
    and-int v16, v6, v16
    move/from16 v255, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayTouchSize F
    goto +3h
    move/from16 v5, v256
    const/high16 v16, 134217728
    and-int v16, v6, v16
    move/16 v256, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHeight F
    goto +3h
    move/from16 v5, v257
    const/high16 v16, 268435456
    and-int v16, v6, v16
    move/16 v257, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHorizontalInset F
    goto +3h
    move/from16 v5, v258
    const/high16 v16, 536870912
    and-int v16, v6, v16
    move/16 v258, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressThumbSize F
    goto +3h
    move/from16 v5, v259
    const/high16 v16, 1073741824
    and-int v16, v6, v16
    move/16 v259, v5
    if-eqz v16, +005h
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressTrackHeight F
    goto +3h
    move/from16 v5, v260
    const/high16 v16, -2147483648
    and-int v6, v6, v16
    if-eqz v6, +005h
    iget v6, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuItemHeight F
    goto +3h
    move/from16 v6, v261
    and-int/lit8 v16, v7, 1
    move/16 v261, v6
    if-eqz v16, +005h
    iget v6, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuRadius F
    goto +3h
    move/from16 v6, v262
    and-int/lit8 v16, v7, 2
    move/16 v262, v6
    if-eqz v16, +005h
    iget v6, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuWidth F
    goto +3h
    move/from16 v6, v263
    and-int/lit8 v16, v7, 4
    move/16 v260, v5
    move/16 v263, v6
    if-eqz v16, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleFontSizeSp J
    goto +3h
    move-wide/from16 v5, v264
    and-int/lit8 v7, v7, 8
    if-eqz v7, +005h
    iget v7, v0, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleLineHeightDp F
    goto +3h
    move/from16 v7, v266
    move/from16 v23, v8
    move/from16 v24, v9
    move/from16 v25, v10
    move/from16 v26, v11
    move/from16 v27, v12
    move-wide/from16 v8, v30
    move-wide/from16 v8, v33
    move-wide/from16 v8, v36
    move-wide/from16 v8, v39
    move-wide/from16 v8, v42
    move-wide/from16 v8, v45
    move-wide/from16 v8, v48
    move-wide/from16 v8, v51
    move/from16 v53, v15
    move-wide/from16 v8, v54
    move-wide/from16 v8, v57
    move-wide/from16 v8, v60
    move-wide/from16 v8, v63
    move-wide/from16 v8, v66
    move/from16 v68, v1
    move-wide/from16 v0, v69
    move-wide/from16 v0, v72
    move-wide/from16 v0, v75
    move-wide/from16 v0, v78
    move-wide/from16 v0, v81
    move-wide/from16 v0, v84
    move-wide/from16 v0, v87
    move-wide/from16 v0, v90
    move-wide/from16 v0, v93
    move-wide/from16 v0, v96
    move-wide/from16 v0, v99
    move-wide/from16 v0, v102
    move-wide/from16 v0, v123
    move-wide/from16 v0, v125
    move-wide/from16 v0, v128
    move/from16 v130, v2
    move-wide/from16 v0, v131
    move-wide/from16 v0, v134
    move-wide/from16 v0, v137
    move-wide/from16 v0, v140
    move-wide/from16 v0, v143
    move-wide/from16 v0, v146
    move-wide/from16 v0, v149
    move-wide/from16 v0, v152
    move/from16 v154, v3
    move-wide/from16 v0, v155
    move-wide/from16 v0, v158
    move-wide/from16 v0, v161
    move-wide/from16 v0, v164
    move-wide/from16 v0, v167
    move-wide/from16 v0, v170
    move-wide/from16 v0, v173
    move-wide/from16 v0, v176
    move-wide/from16 v0, v179
    move-wide/from16 v0, v182
    move-wide/from16 v0, v185
    move/from16 v187, v13
    move/from16 v196, v14
    move/from16 v228, v4
    move-wide/16 v264, v5
    move/16 v266, v7
    invoke-virtual/range v22 ... v266, Lcom/bytedance/trae/design/compose/TraeDimens;->copy-LXmn6JE(F F F F F F F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F F F F F F F F F F F F F F F F F F F J J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F J F)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v0
    return-object v0
.end method

.method public final component1-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewErrorIconSize F
    return v0
.end method

.method public final component10-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongFontSizeSp J
    return-wide v0
.end method

.method public final component100-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongLineHeightDp F
    return v0
.end method

.method public final component101-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMFontSizeSp J
    return-wide v0
.end method

.method public final component102-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMLineHeightDp F
    return v0
.end method

.method public final component103-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongFontSizeSp J
    return-wide v0
.end method

.method public final component104-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongLineHeightDp F
    return v0
.end method

.method public final component105-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlFontSizeSp J
    return-wide v0
.end method

.method public final component106-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlLineHeightDp F
    return v0
.end method

.method public final component107-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongFontSizeSp J
    return-wide v0
.end method

.method public final component108-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongLineHeightDp F
    return v0
.end method

.method public final component109-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgFontSizeSp J
    return-wide v0
.end method

.method public final component11-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongLineHeightDp F
    return v0
.end method

.method public final component110-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgLineHeightDp F
    return v0
.end method

.method public final component111-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdFontSizeSp J
    return-wide v0
.end method

.method public final component112-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdLineHeightDp F
    return v0
.end method

.method public final component113-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmFontSizeSp J
    return-wide v0
.end method

.method public final component114-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmLineHeightDp F
    return v0
.end method

.method public final component115-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlFontSizeSp J
    return-wide v0
.end method

.method public final component116-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlLineHeightDp F
    return v0
.end method

.method public final component117-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsFontSizeSp J
    return-wide v0
.end method

.method public final component118-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsLineHeightDp F
    return v0
.end method

.method public final component119-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->lineHeightDp F
    return v0
.end method

.method public final component12-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseFontSizeSp J
    return-wide v0
.end method

.method public final component120-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->loadingViewElevation F
    return v0
.end method

.method public final component121-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionGap F
    return v0
.end method

.method public final component122-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionSize F
    return v0
.end method

.method public final component123-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailIconSize F
    return v0
.end method

.method public final component124-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailSubtitleGap F
    return v0
.end method

.method public final component125-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailTitleGap F
    return v0
.end method

.method public final component126-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDownloadIconSize F
    return v0
.end method

.method public final component127-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarElevation F
    return v0
.end method

.method public final component128-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberContainerHeight F
    return v0
.end method

.method public final component129-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberHeight F
    return v0
.end method

.method public final component13-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseLineHeightDp F
    return v0
.end method

.method public final component130-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberWidth F
    return v0
.end method

.method public final component131-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarHorizontalPadding F
    return v0
.end method

.method public final component132-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarIconSize F
    return v0
.end method

.method public final component133-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationHeight F
    return v0
.end method

.method public final component134-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationMarginEnd F
    return v0
.end method

.method public final component135-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationRadius F
    return v0
.end method

.method public final component136-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationWidth F
    return v0
.end method

.method public final component137-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarPageHeight F
    return v0
.end method

.method public final component138-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentPadding F
    return v0
.end method

.method public final component139-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSelectedWidth F
    return v0
.end method

.method public final component14-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdFontSizeSp J
    return-wide v0
.end method

.method public final component140-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentShadowBlurRadius F
    return v0
.end method

.method public final component141-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSlotWidth F
    return v0
.end method

.method public final component142-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentWidth F
    return v0
.end method

.method public final component143-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowBlurRadius F
    return v0
.end method

.method public final component144-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowOffsetY F
    return v0
.end method

.method public final component145-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetContentHeight F
    return v0
.end method

.method public final component146-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetHeight F
    return v0
.end method

.method public final component147-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionPaddingHorizontal F
    return v0
.end method

.method public final component148-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionWidth F
    return v0
.end method

.method public final component149-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginBottom F
    return v0
.end method

.method public final component15-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdLineHeightDp F
    return v0
.end method

.method public final component150-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginEnd F
    return v0
.end method

.method public final component151-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeSize F
    return v0
.end method

.method public final component152-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarSize F
    return v0
.end method

.method public final component153-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskHeight F
    return v0
.end method

.method public final component154-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconGap F
    return v0
.end method

.method public final component155-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconSize F
    return v0
.end method

.method public final component156-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTitleSideGap F
    return v0
.end method

.method public final component157-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBorderWidth F
    return v0
.end method

.method public final component158-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBottomMargin F
    return v0
.end method

.method public final component159-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDividerHeight F
    return v0
.end method

.method public final component16-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongFontSizeSp J
    return-wide v0
.end method

.method public final component160-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationBottomMargin F
    return v0
.end method

.method public final component161-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationEndMargin F
    return v0
.end method

.method public final component162-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHeight F
    return v0
.end method

.method public final component163-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHorizontalPadding F
    return v0
.end method

.method public final component164-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconContainerSize F
    return v0
.end method

.method public final component165-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconSize F
    return v0
.end method

.method public final component166-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardGradientHeight F
    return v0
.end method

.method public final component167-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHeight F
    return v0
.end method

.method public final component168-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHorizontalPadding F
    return v0
.end method

.method public final component169-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderVerticalPadding F
    return v0
.end method

.method public final component17-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongLineHeightDp F
    return v0
.end method

.method public final component170-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonPadding F
    return v0
.end method

.method public final component171-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonSize F
    return v0
.end method

.method public final component172-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayIconSize F
    return v0
.end method

.method public final component173-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPreviewHeight F
    return v0
.end method

.method public final component174-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardRadius F
    return v0
.end method

.method public final component175-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardTitleGap F
    return v0
.end method

.method public final component176-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlBottomMargin F
    return v0
.end method

.method public final component177-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlContentHeight F
    return v0
.end method

.method public final component178-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlGap F
    return v0
.end method

.method public final component179-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHeight F
    return v0
.end method

.method public final component18-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmFontSizeSp J
    return-wide v0
.end method

.method public final component180-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHorizontalMargin F
    return v0
.end method

.method public final component181-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingEnd F
    return v0
.end method

.method public final component182-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingStart F
    return v0
.end method

.method public final component183-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingVertical F
    return v0
.end method

.method public final component184-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlRadius F
    return v0
.end method

.method public final component185-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlTextRowHeight F
    return v0
.end method

.method public final component186-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayIconSize F
    return v0
.end method

.method public final component187-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayTouchSize F
    return v0
.end method

.method public final component188-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHeight F
    return v0
.end method

.method public final component189-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHorizontalInset F
    return v0
.end method

.method public final component19-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmLineHeightDp F
    return v0
.end method

.method public final component190-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressThumbSize F
    return v0
.end method

.method public final component191-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressTrackHeight F
    return v0
.end method

.method public final component192-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuItemHeight F
    return v0
.end method

.method public final component193-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuRadius F
    return v0
.end method

.method public final component194-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuWidth F
    return v0
.end method

.method public final component195-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleFontSizeSp J
    return-wide v0
.end method

.method public final component196-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleLineHeightDp F
    return v0
.end method

.method public final component2-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewLoadingIndicatorSize F
    return v0
.end method

.method public final component20-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdFontSizeSp J
    return-wide v0
.end method

.method public final component21-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdLineHeightDp F
    return v0
.end method

.method public final component22-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongFontSizeSp J
    return-wide v0
.end method

.method public final component23-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongLineHeightDp F
    return v0
.end method

.method public final component24-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsFontSizeSp J
    return-wide v0
.end method

.method public final component25-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsLineHeightDp F
    return v0
.end method

.method public final component26-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdFontSizeSp J
    return-wide v0
.end method

.method public final component27-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdLineHeightDp F
    return v0
.end method

.method public final component28-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongFontSizeSp J
    return-wide v0
.end method

.method public final component29-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongLineHeightDp F
    return v0
.end method

.method public final component3-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingHorizontal F
    return v0
.end method

.method public final component30-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdFontSizeSp J
    return-wide v0
.end method

.method public final component31-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdLineHeightDp F
    return v0
.end method

.method public final component32-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongFontSizeSp J
    return-wide v0
.end method

.method public final component33-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongLineHeightDp F
    return v0
.end method

.method public final component34-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmFontSizeSp J
    return-wide v0
.end method

.method public final component35-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmLineHeightDp F
    return v0
.end method

.method public final component36-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongFontSizeSp J
    return-wide v0
.end method

.method public final component37-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongLineHeightDp F
    return v0
.end method

.method public final component38-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsFontSizeSp J
    return-wide v0
.end method

.method public final component39-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsLineHeightDp F
    return v0
.end method

.method public final component4-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingVertical F
    return v0
.end method

.method public final component40-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseFontSizeSp J
    return-wide v0
.end method

.method public final component41-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseLineHeightDp F
    return v0
.end method

.method public final component42-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongFontSizeSp J
    return-wide v0
.end method

.method public final component43-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongLineHeightDp F
    return v0
.end method

.method public final component44-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsFontSizeSp J
    return-wide v0
.end method

.method public final component45-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsLineHeightDp F
    return v0
.end method

.method public final component46-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongFontSizeSp J
    return-wide v0
.end method

.method public final component47-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongLineHeightDp F
    return v0
.end method

.method public final component48-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseFontSizeSp J
    return-wide v0
.end method

.method public final component49-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseLineHeightDp F
    return v0
.end method

.method public final component5-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonRadius F
    return v0
.end method

.method public final component50-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmFontSizeSp J
    return-wide v0
.end method

.method public final component51-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmLineHeightDp F
    return v0
.end method

.method public final component52-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsFontSizeSp J
    return-wide v0
.end method

.method public final component53-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsLineHeightDp F
    return v0
.end method

.method public final component54-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorFontSizeSp J
    return-wide v0
.end method

.method public final component55-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorLineHeightDp F
    return v0
.end method

.method public final component56-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalFontSizeSp J
    return-wide v0
.end method

.method public final component57-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalLineHeightDp F
    return v0
.end method

.method public final component58-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuAnchorGap F
    return v0
.end method

.method public final component59-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailIconTextGap F
    return v0
.end method

.method public final component6-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateGap F
    return v0
.end method

.method public final component60-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailVerticalPadding F
    return v0
.end method

.method public final component61-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailWidth F
    return v0
.end method

.method public final component62-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDividerHeight F
    return v0
.end method

.method public final component63-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuElevation F
    return v0
.end method

.method public final component64-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuIconSize F
    return v0
.end method

.method public final component65-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHeight F
    return v0
.end method

.method public final component66-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHorizontalPadding F
    return v0
.end method

.method public final component67-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuRadius F
    return v0
.end method

.method public final component68-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowBlurRadius F
    return v0
.end method

.method public final component69-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowOffsetY F
    return v0
.end method

.method public final component7-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateHorizontalPadding F
    return v0
.end method

.method public final component70-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingBottom F
    return v0
.end method

.method public final component71-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingHorizontal F
    return v0
.end method

.method public final component72-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingTop F
    return v0
.end method

.method public final component73-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuTextMarginStart F
    return v0
.end method

.method public final component74-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuVerticalPadding F
    return v0
.end method

.method public final component75-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuWidth F
    return v0
.end method

.method public final component76-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->fontSizeSp J
    return-wide v0
.end method

.method public final component77-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteFontSizeSp J
    return-wide v0
.end method

.method public final component78-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteLineHeightDp F
    return v0
.end method

.method public final component79-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongFontSizeSp J
    return-wide v0
.end method

.method public final component8-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseFontSizeSp J
    return-wide v0
.end method

.method public final component80-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongLineHeightDp F
    return v0
.end method

.method public final component81-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlFontSizeSp J
    return-wide v0
.end method

.method public final component82-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlLineHeightDp F
    return v0
.end method

.method public final component83-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsFontSizeSp J
    return-wide v0
.end method

.method public final component84-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsLineHeightDp F
    return v0
.end method

.method public final component85-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlFontSizeSp J
    return-wide v0
.end method

.method public final component86-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlLineHeightDp F
    return v0
.end method

.method public final component87-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsFontSizeSp J
    return-wide v0
.end method

.method public final component88-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsLineHeightDp F
    return v0
.end method

.method public final component89-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlFontSizeSp J
    return-wide v0
.end method

.method public final component9-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseLineHeightDp F
    return v0
.end method

.method public final component90-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlLineHeightDp F
    return v0
.end method

.method public final component91-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongFontSizeSp J
    return-wide v0
.end method

.method public final component92-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongLineHeightDp F
    return v0
.end method

.method public final component93-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlFontSizeSp J
    return-wide v0
.end method

.method public final component94-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlLineHeightDp F
    return v0
.end method

.method public final component95-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongFontSizeSp J
    return-wide v0
.end method

.method public final component96-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongLineHeightDp F
    return v0
.end method

.method public final component97-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgFontSizeSp J
    return-wide v0
.end method

.method public final component98-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgLineHeightDp F
    return v0
.end method

.method public final component99-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongFontSizeSp J
    return-wide v0
.end method

.method public final copy-LXmn6JE(float  float  float  float  float  float  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  long  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  long  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  float  long  float)com.bytedance.trae.design.compose.TraeDimens
    .registers 492
    # ins_size=245
    move/from16 v1, v248
    move/from16 v2, v249
    move/from16 v3, v250
    move/from16 v4, v251
    move/from16 v5, v252
    move/from16 v6, v253
    move/from16 v7, v254
    move-wide/from16 v8, v255
    move/from16 v10, v257
    move-wide/from16 v11, v258
    move/from16 v13, v260
    move-wide/from16 v14, v261
    move/from16 v16, v263
    move-wide/from16 v17, v264
    move/from16 v19, v266
    move-wide/from16 v20, v267
    move/from16 v22, v269
    move-wide/from16 v23, v270
    move/from16 v25, v272
    move-wide/from16 v26, v273
    move/from16 v28, v275
    move-wide/from16 v29, v276
    move/from16 v31, v278
    move-wide/from16 v32, v279
    move/from16 v34, v281
    move-wide/from16 v35, v282
    move/from16 v37, v284
    move-wide/from16 v38, v285
    move/from16 v40, v287
    move-wide/from16 v41, v288
    move/from16 v43, v290
    move-wide/from16 v44, v291
    move/from16 v46, v293
    move-wide/from16 v47, v294
    move/from16 v49, v296
    move-wide/from16 v50, v297
    move/from16 v52, v299
    move-wide/from16 v53, v300
    move/from16 v55, v302
    move-wide/from16 v56, v303
    move/from16 v58, v305
    move-wide/from16 v59, v306
    move/from16 v61, v308
    move-wide/from16 v62, v309
    move/from16 v64, v311
    move-wide/from16 v65, v312
    move/from16 v67, v314
    move-wide/from16 v68, v315
    move/from16 v70, v317
    move-wide/from16 v71, v318
    move/from16 v73, v320
    move-wide/from16 v74, v321
    move/from16 v76, v323
    move-wide/from16 v77, v324
    move/from16 v79, v326
    move-wide/from16 v80, v327
    move/from16 v82, v329
    move/from16 v83, v330
    move/from16 v84, v331
    move/from16 v85, v332
    move/from16 v86, v333
    move/from16 v87, v334
    move/from16 v88, v335
    move/from16 v89, v336
    move/from16 v90, v337
    move/from16 v91, v338
    move/from16 v92, v339
    move/from16 v93, v340
    move/from16 v94, v341
    move/from16 v95, v342
    move/from16 v96, v343
    move/from16 v97, v344
    move/from16 v98, v345
    move/from16 v99, v346
    move/from16 v100, v347
    move-wide/from16 v101, v348
    move-wide/from16 v103, v350
    move/from16 v105, v352
    move-wide/from16 v106, v353
    move/from16 v108, v355
    move-wide/from16 v109, v356
    move/from16 v111, v358
    move-wide/from16 v112, v359
    move/from16 v114, v361
    move-wide/from16 v115, v362
    move/from16 v117, v364
    move-wide/from16 v118, v365
    move/from16 v120, v367
    move-wide/from16 v121, v368
    move/from16 v123, v370
    move-wide/from16 v124, v371
    move/from16 v126, v373
    move-wide/from16 v127, v374
    move/from16 v129, v376
    move-wide/from16 v130, v377
    move/from16 v132, v379
    move-wide/from16 v133, v380
    move/from16 v135, v382
    move-wide/from16 v136, v383
    move/from16 v138, v385
    move-wide/from16 v139, v386
    move/from16 v141, v388
    move-wide/from16 v142, v389
    move/from16 v144, v391
    move-wide/from16 v145, v392
    move/from16 v147, v394
    move-wide/from16 v148, v395
    move/from16 v150, v397
    move-wide/from16 v151, v398
    move/from16 v153, v400
    move-wide/from16 v154, v401
    move/from16 v156, v403
    move-wide/from16 v157, v404
    move/from16 v159, v406
    move-wide/from16 v160, v407
    move/from16 v162, v409
    move-wide/from16 v163, v410
    move/from16 v165, v412
    move/from16 v166, v413
    move/from16 v167, v414
    move/from16 v168, v415
    move/from16 v169, v416
    move/from16 v170, v417
    move/from16 v171, v418
    move/from16 v172, v419
    move/from16 v173, v420
    move/from16 v174, v421
    move/from16 v175, v422
    move/from16 v176, v423
    move/from16 v177, v424
    move/from16 v178, v425
    move/from16 v179, v426
    move/from16 v180, v427
    move/from16 v181, v428
    move/from16 v182, v429
    move/from16 v183, v430
    move/from16 v184, v431
    move/from16 v185, v432
    move/from16 v186, v433
    move/from16 v187, v434
    move/from16 v188, v435
    move/from16 v189, v436
    move/from16 v190, v437
    move/from16 v191, v438
    move/from16 v192, v439
    move/from16 v193, v440
    move/from16 v194, v441
    move/from16 v195, v442
    move/from16 v196, v443
    move/from16 v197, v444
    move/from16 v198, v445
    move/from16 v199, v446
    move/from16 v200, v447
    move/from16 v201, v448
    move/from16 v202, v449
    move/from16 v203, v450
    move/from16 v204, v451
    move/from16 v205, v452
    move/from16 v206, v453
    move/from16 v207, v454
    move/from16 v208, v455
    move/from16 v209, v456
    move/from16 v210, v457
    move/from16 v211, v458
    move/from16 v212, v459
    move/from16 v213, v460
    move/from16 v214, v461
    move/from16 v215, v462
    move/from16 v216, v463
    move/from16 v217, v464
    move/from16 v218, v465
    move/from16 v219, v466
    move/from16 v220, v467
    move/from16 v221, v468
    move/from16 v222, v469
    move/from16 v223, v470
    move/from16 v224, v471
    move/from16 v225, v472
    move/from16 v226, v473
    move/from16 v227, v474
    move/from16 v228, v475
    move/from16 v229, v476
    move/from16 v230, v477
    move/from16 v231, v478
    move/from16 v232, v479
    move/from16 v233, v480
    move/from16 v234, v481
    move/from16 v235, v482
    move/from16 v236, v483
    move/from16 v237, v484
    move/from16 v238, v485
    move/from16 v239, v486
    move/from16 v240, v487
    move/from16 v241, v488
    move-wide/from16 v242, v489
    move/from16 v244, v491
    new-instance v246, Lcom/bytedance/trae/design/compose/TraeDimens;
    move-object/from16 v0, v246
    const/16 v245, 0
    invoke-direct/range v0 ... v245, Lcom/bytedance/trae/design/compose/TraeDimens;-><init>(F F F F F F F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F F F F F F F F F F F F F F F F F F F J J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F J F Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v246
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/design/compose/TraeDimens;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/design/compose/TraeDimens;
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewErrorIconSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewErrorIconSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewLoadingIndicatorSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewLoadingIndicatorSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingHorizontal F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingHorizontal F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingVertical F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingVertical F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonRadius F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonRadius F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateGap F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateGap F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateHorizontalPadding F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateHorizontalPadding F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuAnchorGap F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuAnchorGap F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailIconTextGap F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailIconTextGap F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailVerticalPadding F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailVerticalPadding F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailWidth F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailWidth F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDividerHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDividerHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuElevation F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuElevation F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuIconSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuIconSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHorizontalPadding F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHorizontalPadding F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuRadius F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuRadius F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowBlurRadius F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowBlurRadius F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowOffsetY F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowOffsetY F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingBottom F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingBottom F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingHorizontal F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingHorizontal F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingTop F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingTop F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuTextMarginStart F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuTextMarginStart F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuVerticalPadding F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuVerticalPadding F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuWidth F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuWidth F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->fontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->fontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsLineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsLineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->lineHeightDp F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->lineHeightDp F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->loadingViewElevation F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->loadingViewElevation F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionGap F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionGap F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailIconSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailIconSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailSubtitleGap F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailSubtitleGap F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailTitleGap F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailTitleGap F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDownloadIconSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDownloadIconSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarElevation F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarElevation F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberContainerHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberContainerHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberWidth F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberWidth F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarHorizontalPadding F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarHorizontalPadding F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarIconSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarIconSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationMarginEnd F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationMarginEnd F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationRadius F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationRadius F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationWidth F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationWidth F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarPageHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarPageHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentPadding F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentPadding F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSelectedWidth F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSelectedWidth F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentShadowBlurRadius F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentShadowBlurRadius F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSlotWidth F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSlotWidth F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentWidth F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentWidth F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowBlurRadius F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowBlurRadius F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowOffsetY F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowOffsetY F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetContentHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetContentHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionPaddingHorizontal F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionPaddingHorizontal F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionWidth F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionWidth F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginBottom F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginBottom F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginEnd F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginEnd F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconGap F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconGap F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTitleSideGap F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTitleSideGap F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBorderWidth F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBorderWidth F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBottomMargin F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBottomMargin F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDividerHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDividerHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationBottomMargin F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationBottomMargin F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationEndMargin F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationEndMargin F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHorizontalPadding F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHorizontalPadding F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconContainerSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconContainerSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardGradientHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardGradientHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHorizontalPadding F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHorizontalPadding F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderVerticalPadding F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderVerticalPadding F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonPadding F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonPadding F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayIconSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayIconSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPreviewHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPreviewHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardRadius F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardRadius F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardTitleGap F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardTitleGap F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlBottomMargin F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlBottomMargin F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlContentHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlContentHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlGap F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlGap F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHorizontalMargin F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHorizontalMargin F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingEnd F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingEnd F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingStart F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingStart F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingVertical F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingVertical F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlRadius F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlRadius F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlTextRowHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlTextRowHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayIconSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayIconSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayTouchSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayTouchSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHorizontalInset F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHorizontalInset F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressThumbSize F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressThumbSize F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressTrackHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressTrackHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuItemHeight F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuItemHeight F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuRadius F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuRadius F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuWidth F
    iget v3, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuWidth F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleFontSizeSp J
    iget-wide v5, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleFontSizeSp J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/unit/TextUnit;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleLineHeightDp F
    iget v8, v8, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleLineHeightDp F
    invoke-static v1, v8, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getArtifactPreviewErrorIconSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewErrorIconSize F
    return v0
.end method

.method public final getArtifactPreviewLoadingIndicatorSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewLoadingIndicatorSize F
    return v0
.end method

.method public final getArtifactPreviewReloadButtonPaddingHorizontal-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingHorizontal F
    return v0
.end method

.method public final getArtifactPreviewReloadButtonPaddingVertical-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingVertical F
    return v0
.end method

.method public final getArtifactPreviewReloadButtonRadius-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonRadius F
    return v0
.end method

.method public final getArtifactPreviewStateGap-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateGap F
    return v0
.end method

.method public final getArtifactPreviewStateHorizontalPadding-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateHorizontalPadding F
    return v0
.end method

.method public final getBodyBaseFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBaseLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseLineHeightDp F
    return v0
.end method

.method public final getBodyBaseStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBaseStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongLineHeightDp F
    return v0
.end method

.method public final getBodyBodyBaseFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBodyBaseLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseLineHeightDp F
    return v0
.end method

.method public final getBodyBodyBaseMdFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBodyBaseMdLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdLineHeightDp F
    return v0
.end method

.method public final getBodyBodyBaseStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBodyBaseStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongLineHeightDp F
    return v0
.end method

.method public final getBodyBodySmFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBodySmLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmLineHeightDp F
    return v0
.end method

.method public final getBodyBodySmMdFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBodySmMdLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdLineHeightDp F
    return v0
.end method

.method public final getBodyBodySmStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBodySmStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongLineHeightDp F
    return v0
.end method

.method public final getBodyBodyXsFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBodyXsLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsLineHeightDp F
    return v0
.end method

.method public final getBodyBodyXsMdFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBodyXsMdLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdLineHeightDp F
    return v0
.end method

.method public final getBodyBodyXsStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongFontSizeSp J
    return-wide v0
.end method

.method public final getBodyBodyXsStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongLineHeightDp F
    return v0
.end method

.method public final getBodyMdFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdFontSizeSp J
    return-wide v0
.end method

.method public final getBodyMdLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdLineHeightDp F
    return v0
.end method

.method public final getBodyMdStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongFontSizeSp J
    return-wide v0
.end method

.method public final getBodyMdStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongLineHeightDp F
    return v0
.end method

.method public final getBodySmFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmFontSizeSp J
    return-wide v0
.end method

.method public final getBodySmLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmLineHeightDp F
    return v0
.end method

.method public final getBodySmStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongFontSizeSp J
    return-wide v0
.end method

.method public final getBodySmStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongLineHeightDp F
    return v0
.end method

.method public final getBodyXsFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsFontSizeSp J
    return-wide v0
.end method

.method public final getBodyXsLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsLineHeightDp F
    return v0
.end method

.method public final getCaptionCaptionBaseFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseFontSizeSp J
    return-wide v0
.end method

.method public final getCaptionCaptionBaseLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseLineHeightDp F
    return v0
.end method

.method public final getCaptionCaptionBaseStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongFontSizeSp J
    return-wide v0
.end method

.method public final getCaptionCaptionBaseStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongLineHeightDp F
    return v0
.end method

.method public final getCaptionCaptionXsFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsFontSizeSp J
    return-wide v0
.end method

.method public final getCaptionCaptionXsLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsLineHeightDp F
    return v0
.end method

.method public final getCaptionCaptionXsStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongFontSizeSp J
    return-wide v0
.end method

.method public final getCaptionCaptionXsStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongLineHeightDp F
    return v0
.end method

.method public final getCodeCodeBaseFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseFontSizeSp J
    return-wide v0
.end method

.method public final getCodeCodeBaseLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseLineHeightDp F
    return v0
.end method

.method public final getCodeCodeSmFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmFontSizeSp J
    return-wide v0
.end method

.method public final getCodeCodeSmLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmLineHeightDp F
    return v0
.end method

.method public final getCodeCodeXsFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsFontSizeSp J
    return-wide v0
.end method

.method public final getCodeCodeXsLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsLineHeightDp F
    return v0
.end method

.method public final getCodeEditorFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorFontSizeSp J
    return-wide v0
.end method

.method public final getCodeEditorLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorLineHeightDp F
    return v0
.end method

.method public final getCodeTerminalFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalFontSizeSp J
    return-wide v0
.end method

.method public final getCodeTerminalLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalLineHeightDp F
    return v0
.end method

.method public final getContextMenuAnchorGap-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuAnchorGap F
    return v0
.end method

.method public final getContextMenuDetailIconTextGap-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailIconTextGap F
    return v0
.end method

.method public final getContextMenuDetailVerticalPadding-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailVerticalPadding F
    return v0
.end method

.method public final getContextMenuDetailWidth-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailWidth F
    return v0
.end method

.method public final getContextMenuDividerHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDividerHeight F
    return v0
.end method

.method public final getContextMenuElevation-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuElevation F
    return v0
.end method

.method public final getContextMenuIconSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuIconSize F
    return v0
.end method

.method public final getContextMenuItemHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHeight F
    return v0
.end method

.method public final getContextMenuItemHorizontalPadding-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHorizontalPadding F
    return v0
.end method

.method public final getContextMenuRadius-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuRadius F
    return v0
.end method

.method public final getContextMenuShadowBlurRadius-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowBlurRadius F
    return v0
.end method

.method public final getContextMenuShadowOffsetY-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowOffsetY F
    return v0
.end method

.method public final getContextMenuShadowPaddingBottom-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingBottom F
    return v0
.end method

.method public final getContextMenuShadowPaddingHorizontal-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingHorizontal F
    return v0
.end method

.method public final getContextMenuShadowPaddingTop-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingTop F
    return v0
.end method

.method public final getContextMenuTextMarginStart-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuTextMarginStart F
    return v0
.end method

.method public final getContextMenuVerticalPadding-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuVerticalPadding F
    return v0
.end method

.method public final getContextMenuWidth-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuWidth F
    return v0
.end method

.method public final getFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->fontSizeSp J
    return-wide v0
.end method

.method public final getFootnoteFootnoteFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteFontSizeSp J
    return-wide v0
.end method

.method public final getFootnoteFootnoteLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteLineHeightDp F
    return v0
.end method

.method public final getFootnoteFootnoteStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongFontSizeSp J
    return-wide v0
.end method

.method public final getFootnoteFootnoteStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongLineHeightDp F
    return v0
.end method

.method public final getHeading2xlFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlFontSizeSp J
    return-wide v0
.end method

.method public final getHeading2xlLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlLineHeightDp F
    return v0
.end method

.method public final getHeading2xsFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsFontSizeSp J
    return-wide v0
.end method

.method public final getHeading2xsLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsLineHeightDp F
    return v0
.end method

.method public final getHeading3xlFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlFontSizeSp J
    return-wide v0
.end method

.method public final getHeading3xlLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlLineHeightDp F
    return v0
.end method

.method public final getHeading3xsFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsFontSizeSp J
    return-wide v0
.end method

.method public final getHeading3xsLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsLineHeightDp F
    return v0
.end method

.method public final getHeadingHeading2xlFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingHeading2xlLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlLineHeightDp F
    return v0
.end method

.method public final getHeadingHeading2xlStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingHeading2xlStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongLineHeightDp F
    return v0
.end method

.method public final getHeadingHeading3xlFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingHeading3xlLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlLineHeightDp F
    return v0
.end method

.method public final getHeadingHeading3xlStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingHeading3xlStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongLineHeightDp F
    return v0
.end method

.method public final getHeadingHeadingLgFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingHeadingLgLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgLineHeightDp F
    return v0
.end method

.method public final getHeadingHeadingLgStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingHeadingLgStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongLineHeightDp F
    return v0
.end method

.method public final getHeadingHeadingMFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingHeadingMLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMLineHeightDp F
    return v0
.end method

.method public final getHeadingHeadingMStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingHeadingMStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongLineHeightDp F
    return v0
.end method

.method public final getHeadingHeadingXlFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingHeadingXlLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlLineHeightDp F
    return v0
.end method

.method public final getHeadingHeadingXlStrongFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingHeadingXlStrongLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongLineHeightDp F
    return v0
.end method

.method public final getHeadingLgFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingLgLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgLineHeightDp F
    return v0
.end method

.method public final getHeadingMdFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingMdLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdLineHeightDp F
    return v0
.end method

.method public final getHeadingSmFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingSmLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmLineHeightDp F
    return v0
.end method

.method public final getHeadingXlFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingXlLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlLineHeightDp F
    return v0
.end method

.method public final getHeadingXsFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsFontSizeSp J
    return-wide v0
.end method

.method public final getHeadingXsLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsLineHeightDp F
    return v0
.end method

.method public final getLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->lineHeightDp F
    return v0
.end method

.method public final getLoadingViewElevation-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->loadingViewElevation F
    return v0
.end method

.method public final getTitleBarActionGap-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionGap F
    return v0
.end method

.method public final getTitleBarActionSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionSize F
    return v0
.end method

.method public final getTitleBarDetailIconSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailIconSize F
    return v0
.end method

.method public final getTitleBarDetailSubtitleGap-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailSubtitleGap F
    return v0
.end method

.method public final getTitleBarDetailTitleGap-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailTitleGap F
    return v0
.end method

.method public final getTitleBarDownloadIconSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDownloadIconSize F
    return v0
.end method

.method public final getTitleBarElevation-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarElevation F
    return v0
.end method

.method public final getTitleBarGrabberContainerHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberContainerHeight F
    return v0
.end method

.method public final getTitleBarGrabberHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberHeight F
    return v0
.end method

.method public final getTitleBarGrabberWidth-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberWidth F
    return v0
.end method

.method public final getTitleBarHorizontalPadding-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarHorizontalPadding F
    return v0
.end method

.method public final getTitleBarIconSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarIconSize F
    return v0
.end method

.method public final getTitleBarOperationHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationHeight F
    return v0
.end method

.method public final getTitleBarOperationMarginEnd-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationMarginEnd F
    return v0
.end method

.method public final getTitleBarOperationRadius-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationRadius F
    return v0
.end method

.method public final getTitleBarOperationWidth-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationWidth F
    return v0
.end method

.method public final getTitleBarPageHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarPageHeight F
    return v0
.end method

.method public final getTitleBarSegmentPadding-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentPadding F
    return v0
.end method

.method public final getTitleBarSegmentSelectedWidth-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSelectedWidth F
    return v0
.end method

.method public final getTitleBarSegmentShadowBlurRadius-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentShadowBlurRadius F
    return v0
.end method

.method public final getTitleBarSegmentSlotWidth-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSlotWidth F
    return v0
.end method

.method public final getTitleBarSegmentWidth-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentWidth F
    return v0
.end method

.method public final getTitleBarShadowBlurRadius-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowBlurRadius F
    return v0
.end method

.method public final getTitleBarShadowOffsetY-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowOffsetY F
    return v0
.end method

.method public final getTitleBarSheetContentHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetContentHeight F
    return v0
.end method

.method public final getTitleBarSheetHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetHeight F
    return v0
.end method

.method public final getTitleBarTaskActionPaddingHorizontal-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionPaddingHorizontal F
    return v0
.end method

.method public final getTitleBarTaskActionWidth-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionWidth F
    return v0
.end method

.method public final getTitleBarTaskAvatarBadgeMarginBottom-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginBottom F
    return v0
.end method

.method public final getTitleBarTaskAvatarBadgeMarginEnd-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginEnd F
    return v0
.end method

.method public final getTitleBarTaskAvatarBadgeSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeSize F
    return v0
.end method

.method public final getTitleBarTaskAvatarSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarSize F
    return v0
.end method

.method public final getTitleBarTaskHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskHeight F
    return v0
.end method

.method public final getTitleBarTaskTitleIconGap-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconGap F
    return v0
.end method

.method public final getTitleBarTaskTitleIconSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconSize F
    return v0
.end method

.method public final getTitleBarTitleSideGap-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTitleSideGap F
    return v0
.end method

.method public final getVideoArtifactCardBorderWidth-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBorderWidth F
    return v0
.end method

.method public final getVideoArtifactCardBottomMargin-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBottomMargin F
    return v0
.end method

.method public final getVideoArtifactCardDividerHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDividerHeight F
    return v0
.end method

.method public final getVideoArtifactCardDurationBottomMargin-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationBottomMargin F
    return v0
.end method

.method public final getVideoArtifactCardDurationEndMargin-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationEndMargin F
    return v0
.end method

.method public final getVideoArtifactCardDurationHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHeight F
    return v0
.end method

.method public final getVideoArtifactCardDurationHorizontalPadding-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHorizontalPadding F
    return v0
.end method

.method public final getVideoArtifactCardFileIconContainerSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconContainerSize F
    return v0
.end method

.method public final getVideoArtifactCardFileIconSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconSize F
    return v0
.end method

.method public final getVideoArtifactCardGradientHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardGradientHeight F
    return v0
.end method

.method public final getVideoArtifactCardHeaderHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHeight F
    return v0
.end method

.method public final getVideoArtifactCardHeaderHorizontalPadding-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHorizontalPadding F
    return v0
.end method

.method public final getVideoArtifactCardHeaderVerticalPadding-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderVerticalPadding F
    return v0
.end method

.method public final getVideoArtifactCardPlayButtonPadding-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonPadding F
    return v0
.end method

.method public final getVideoArtifactCardPlayButtonSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonSize F
    return v0
.end method

.method public final getVideoArtifactCardPlayIconSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayIconSize F
    return v0
.end method

.method public final getVideoArtifactCardPreviewHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPreviewHeight F
    return v0
.end method

.method public final getVideoArtifactCardRadius-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardRadius F
    return v0
.end method

.method public final getVideoArtifactCardTitleGap-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardTitleGap F
    return v0
.end method

.method public final getVideoPreviewControlBottomMargin-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlBottomMargin F
    return v0
.end method

.method public final getVideoPreviewControlContentHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlContentHeight F
    return v0
.end method

.method public final getVideoPreviewControlGap-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlGap F
    return v0
.end method

.method public final getVideoPreviewControlHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHeight F
    return v0
.end method

.method public final getVideoPreviewControlHorizontalMargin-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHorizontalMargin F
    return v0
.end method

.method public final getVideoPreviewControlPaddingEnd-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingEnd F
    return v0
.end method

.method public final getVideoPreviewControlPaddingStart-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingStart F
    return v0
.end method

.method public final getVideoPreviewControlPaddingVertical-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingVertical F
    return v0
.end method

.method public final getVideoPreviewControlRadius-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlRadius F
    return v0
.end method

.method public final getVideoPreviewControlTextRowHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlTextRowHeight F
    return v0
.end method

.method public final getVideoPreviewPlayIconSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayIconSize F
    return v0
.end method

.method public final getVideoPreviewPlayTouchSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayTouchSize F
    return v0
.end method

.method public final getVideoPreviewProgressHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHeight F
    return v0
.end method

.method public final getVideoPreviewProgressHorizontalInset-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHorizontalInset F
    return v0
.end method

.method public final getVideoPreviewProgressThumbSize-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressThumbSize F
    return v0
.end method

.method public final getVideoPreviewProgressTrackHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressTrackHeight F
    return v0
.end method

.method public final getVideoPreviewSpeedMenuItemHeight-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuItemHeight F
    return v0
.end method

.method public final getVideoPreviewSpeedMenuRadius-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuRadius F
    return v0
.end method

.method public final getVideoPreviewSpeedMenuWidth-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuWidth F
    return v0
.end method

.method public final getVideoPreviewTitleFontSizeSp-XSAIIZE()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleFontSizeSp J
    return-wide v0
.end method

.method public final getVideoPreviewTitleLineHeightDp-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleLineHeightDp F
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewErrorIconSize F
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewLoadingIndicatorSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingHorizontal F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingVertical F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonRadius F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateHorizontalPadding F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuAnchorGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailIconTextGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailVerticalPadding F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailWidth F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDividerHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuElevation F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuIconSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHorizontalPadding F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuRadius F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowBlurRadius F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowOffsetY F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingBottom F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingHorizontal F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingTop F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuTextMarginStart F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuVerticalPadding F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuWidth F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->fontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->lineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->loadingViewElevation F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailIconSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailSubtitleGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailTitleGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDownloadIconSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarElevation F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberContainerHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberWidth F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarHorizontalPadding F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarIconSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationMarginEnd F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationRadius F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationWidth F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarPageHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentPadding F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSelectedWidth F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentShadowBlurRadius F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSlotWidth F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentWidth F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowBlurRadius F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowOffsetY F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetContentHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionPaddingHorizontal F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionWidth F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginBottom F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginEnd F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTitleSideGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBorderWidth F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBottomMargin F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDividerHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationBottomMargin F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationEndMargin F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHorizontalPadding F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconContainerSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardGradientHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHorizontalPadding F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderVerticalPadding F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonPadding F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayIconSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPreviewHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardRadius F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardTitleGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlBottomMargin F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlContentHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHorizontalMargin F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingEnd F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingStart F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingVertical F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlRadius F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlTextRowHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayIconSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayTouchSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHorizontalInset F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressThumbSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressTrackHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuItemHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuRadius F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuWidth F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeDimens(artifactPreviewErrorIconSize="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewErrorIconSize F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", artifactPreviewLoadingIndicatorSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewLoadingIndicatorSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", artifactPreviewReloadButtonPaddingHorizontal="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingHorizontal F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", artifactPreviewReloadButtonPaddingVertical="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonPaddingVertical F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", artifactPreviewReloadButtonRadius="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewReloadButtonRadius F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", artifactPreviewStateGap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateGap F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", artifactPreviewStateHorizontalPadding="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->artifactPreviewStateHorizontalPadding F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBaseFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBaseLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBaseStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBaseStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBaseStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyBaseFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-wide v1, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyBaseLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyBaseMdFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyBaseMdLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseMdLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyBaseStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyBaseStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyBaseStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodySmFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodySmLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodySmMdFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodySmMdLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmMdLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodySmStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodySmStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodySmStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v1, ", bodyBodyXsFontSizeSp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyXsLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyXsMdFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyXsMdLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsMdLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyXsStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBodyXsStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyBodyXsStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyMdFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyMdLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyMdStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyMdStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyMdStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodySmFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodySmLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodySmStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodySmStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodySmStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyXsFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyXsLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->bodyXsLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionCaptionBaseFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionCaptionBaseLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionCaptionBaseStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionCaptionBaseStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionBaseStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionCaptionXsFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionCaptionXsLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionCaptionXsStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v1, ", captionCaptionXsStrongLineHeightDp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->captionCaptionXsStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeCodeBaseFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeCodeBaseLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeBaseLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeCodeSmFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeCodeSmLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeSmLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeCodeXsFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeCodeXsLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->codeCodeXsLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeEditorFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeEditorLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->codeEditorLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeTerminalFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeTerminalLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->codeTerminalLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuAnchorGap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuAnchorGap F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuDetailIconTextGap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailIconTextGap F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuDetailVerticalPadding="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailVerticalPadding F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuDetailWidth="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDetailWidth F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuDividerHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuDividerHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuElevation="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuElevation F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuIconSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuIconSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuItemHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuItemHorizontalPadding="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuItemHorizontalPadding F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuRadius="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuRadius F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuShadowBlurRadius="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowBlurRadius F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuShadowOffsetY="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowOffsetY F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v1, ", contextMenuShadowPaddingBottom="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingBottom F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuShadowPaddingHorizontal="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingHorizontal F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuShadowPaddingTop="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuShadowPaddingTop F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuTextMarginStart="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuTextMarginStart F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuVerticalPadding="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuVerticalPadding F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMenuWidth="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->contextMenuWidth F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->fontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", footnoteFootnoteFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", footnoteFootnoteLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", footnoteFootnoteStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", footnoteFootnoteStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->footnoteFootnoteStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading2xlFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-wide v1, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlFontSizeSp J
    invoke-static v1, v2, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading2xlLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xlLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading2xsFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading2xsLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->heading2xsLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading3xlFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading3xlLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xlLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading3xsFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading3xsLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->heading3xsLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeading2xlFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeading2xlLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeading2xlStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeading2xlStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading2xlStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v1, ", headingHeading3xlFontSizeSp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeading3xlLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeading3xlStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeading3xlStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeading3xlStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingLgFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingLgLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingLgStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingLgStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingLgStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingMFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingMLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingMStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingMStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingMStrongLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingXlFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingXlLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingXlStrongFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingHeadingXlStrongLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingHeadingXlStrongLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingLgFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingLgLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingLgLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingMdFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingMdLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingMdLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingSmFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingSmLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingSmLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingXlFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v1, ", headingXlLineHeightDp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXlLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingXsFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingXsLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->headingXsLineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", lineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->lineHeightDp F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", loadingViewElevation="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->loadingViewElevation F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarActionGap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionGap F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarActionSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarActionSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarDetailIconSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailIconSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarDetailSubtitleGap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailSubtitleGap F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarDetailTitleGap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDetailTitleGap F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarDownloadIconSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarDownloadIconSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarElevation="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarElevation F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarGrabberContainerHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberContainerHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarGrabberHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarGrabberWidth="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarGrabberWidth F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarHorizontalPadding="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarHorizontalPadding F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarIconSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarIconSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarOperationHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarOperationMarginEnd="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationMarginEnd F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarOperationRadius="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationRadius F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarOperationWidth="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarOperationWidth F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarPageHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarPageHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarSegmentPadding="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentPadding F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v1, ", titleBarSegmentSelectedWidth="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSelectedWidth F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarSegmentShadowBlurRadius="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentShadowBlurRadius F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarSegmentSlotWidth="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentSlotWidth F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarSegmentWidth="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSegmentWidth F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarShadowBlurRadius="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowBlurRadius F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarShadowOffsetY="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarShadowOffsetY F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarSheetContentHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetContentHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarSheetHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarSheetHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarTaskActionPaddingHorizontal="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionPaddingHorizontal F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarTaskActionWidth="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskActionWidth F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarTaskAvatarBadgeMarginBottom="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginBottom F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarTaskAvatarBadgeMarginEnd="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeMarginEnd F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarTaskAvatarBadgeSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarBadgeSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarTaskAvatarSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskAvatarSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarTaskHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarTaskTitleIconGap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconGap F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarTaskTitleIconSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTaskTitleIconSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleBarTitleSideGap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->titleBarTitleSideGap F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardBorderWidth="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBorderWidth F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardBottomMargin="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardBottomMargin F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardDividerHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDividerHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardDurationBottomMargin="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationBottomMargin F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardDurationEndMargin="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationEndMargin F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v1, ", videoArtifactCardDurationHeight="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardDurationHorizontalPadding="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardDurationHorizontalPadding F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardFileIconContainerSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconContainerSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardFileIconSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardFileIconSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardGradientHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardGradientHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardHeaderHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardHeaderHorizontalPadding="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderHorizontalPadding F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardHeaderVerticalPadding="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardHeaderVerticalPadding F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardPlayButtonPadding="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonPadding F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardPlayButtonSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayButtonSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardPlayIconSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPlayIconSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardPreviewHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardPreviewHeight F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardRadius="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardRadius F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoArtifactCardTitleGap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoArtifactCardTitleGap F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewControlBottomMargin="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlBottomMargin F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewControlContentHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlContentHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewControlGap="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlGap F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewControlHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewControlHorizontalMargin="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlHorizontalMargin F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewControlPaddingEnd="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingEnd F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewControlPaddingStart="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingStart F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewControlPaddingVertical="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlPaddingVertical F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewControlRadius="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlRadius F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v1, ", videoPreviewControlTextRowHeight="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewControlTextRowHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewPlayIconSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayIconSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewPlayTouchSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewPlayTouchSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewProgressHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewProgressHorizontalInset="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressHorizontalInset F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewProgressThumbSize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressThumbSize F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewProgressTrackHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewProgressTrackHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewSpeedMenuItemHeight="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuItemHeight F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewSpeedMenuRadius="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuRadius F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewSpeedMenuWidth="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewSpeedMenuWidth F
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewTitleFontSizeSp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleFontSizeSp J
    invoke-static v2, v3, Landroidx/compose/ui/unit/TextUnit;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", videoPreviewTitleLineHeightDp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeDimens;->videoPreviewTitleLineHeightDp F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
