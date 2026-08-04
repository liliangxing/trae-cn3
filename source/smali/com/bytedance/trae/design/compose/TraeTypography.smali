# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeTypography;
.super Ljava/lang/Object;
.source "TraeComposeTokens.kt"

.field public static final $stable:I
.field private final bodyBase:Landroidx/compose/ui/text/TextStyle;
.field private final bodyBaseMd:Landroidx/compose/ui/text/TextStyle;
.field private final bodyBaseStrong:Landroidx/compose/ui/text/TextStyle;
.field private final bodySm:Landroidx/compose/ui/text/TextStyle;
.field private final bodySmMd:Landroidx/compose/ui/text/TextStyle;
.field private final bodySmStrong:Landroidx/compose/ui/text/TextStyle;
.field private final bodyXs:Landroidx/compose/ui/text/TextStyle;
.field private final bodyXsMd:Landroidx/compose/ui/text/TextStyle;
.field private final bodyXsStrong:Landroidx/compose/ui/text/TextStyle;
.field private final captionBase:Landroidx/compose/ui/text/TextStyle;
.field private final captionBaseStrong:Landroidx/compose/ui/text/TextStyle;
.field private final captionXs:Landroidx/compose/ui/text/TextStyle;
.field private final captionXsStrong:Landroidx/compose/ui/text/TextStyle;
.field private final codeBase:Landroidx/compose/ui/text/TextStyle;
.field private final codeSm:Landroidx/compose/ui/text/TextStyle;
.field private final codeXs:Landroidx/compose/ui/text/TextStyle;
.field private final footnote:Landroidx/compose/ui/text/TextStyle;
.field private final footnoteStrong:Landroidx/compose/ui/text/TextStyle;
.field private final heading2xl:Landroidx/compose/ui/text/TextStyle;
.field private final heading2xlStrong:Landroidx/compose/ui/text/TextStyle;
.field private final heading3xl:Landroidx/compose/ui/text/TextStyle;
.field private final heading3xlStrong:Landroidx/compose/ui/text/TextStyle;
.field private final headingLg:Landroidx/compose/ui/text/TextStyle;
.field private final headingLgStrong:Landroidx/compose/ui/text/TextStyle;
.field private final headingM:Landroidx/compose/ui/text/TextStyle;
.field private final headingMStrong:Landroidx/compose/ui/text/TextStyle;
.field private final headingXl:Landroidx/compose/ui/text/TextStyle;
.field private final headingXlStrong:Landroidx/compose/ui/text/TextStyle;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle)void
    .registers 45
    # ins_size=29
    move-object/from16 v0, v16
    move-object/from16 v1, v17
    move-object/from16 v2, v18
    move-object/from16 v3, v19
    move-object/from16 v4, v20
    move-object/from16 v5, v21
    move-object/from16 v6, v22
    move-object/from16 v7, v23
    move-object/from16 v8, v24
    move-object/from16 v9, v25
    move-object/from16 v10, v26
    move-object/from16 v11, v27
    move-object/from16 v12, v28
    move-object/from16 v13, v29
    move-object/from16 v14, v30
    move-object/from16 v15, v31
    move-object/from16 v0, v32
    const-string v0, "bodyBase"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodyBaseMd"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodyBaseStrong"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodySm"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodySmMd"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodySmStrong"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodyXs"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodyXsMd"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodyXsStrong"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "captionBase"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "captionBaseStrong"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "captionXs"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "captionXsStrong"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "codeBase"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "codeSm"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "codeXs"
    move-object/from16 v15, v32
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "footnote"
    move-object/from16 v15, v33
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "footnoteStrong"
    move-object/from16 v15, v34
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "heading2xl"
    move-object/from16 v15, v35
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "heading2xlStrong"
    move-object/from16 v15, v36
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "heading3xl"
    move-object/from16 v15, v37
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "heading3xlStrong"
    move-object/from16 v15, v38
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingLg"
    move-object/from16 v15, v39
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingLgStrong"
    move-object/from16 v15, v40
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingM"
    move-object/from16 v15, v41
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingMStrong"
    move-object/from16 v15, v42
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingXl"
    move-object/from16 v15, v43
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingXlStrong"
    move-object/from16 v15, v44
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v16, Ljava/lang/Object;-><init>()V
    move-object/from16 v0, v16
    move-object/from16 v15, v32
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBase Landroidx/compose/ui/text/TextStyle;
    iput-object v2, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseMd Landroidx/compose/ui/text/TextStyle;
    iput-object v3, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseStrong Landroidx/compose/ui/text/TextStyle;
    iput-object v4, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySm Landroidx/compose/ui/text/TextStyle;
    iput-object v5, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmMd Landroidx/compose/ui/text/TextStyle;
    iput-object v6, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmStrong Landroidx/compose/ui/text/TextStyle;
    iput-object v7, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXs Landroidx/compose/ui/text/TextStyle;
    iput-object v8, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsMd Landroidx/compose/ui/text/TextStyle;
    iput-object v9, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsStrong Landroidx/compose/ui/text/TextStyle;
    iput-object v10, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBase Landroidx/compose/ui/text/TextStyle;
    iput-object v11, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBaseStrong Landroidx/compose/ui/text/TextStyle;
    iput-object v12, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXs Landroidx/compose/ui/text/TextStyle;
    iput-object v13, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXsStrong Landroidx/compose/ui/text/TextStyle;
    iput-object v14, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->codeBase Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v1, v31
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->codeSm Landroidx/compose/ui/text/TextStyle;
    iput-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->codeXs Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v1, v33
    move-object/from16 v2, v34
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->footnote Landroidx/compose/ui/text/TextStyle;
    iput-object v2, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->footnoteStrong Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v1, v35
    move-object/from16 v2, v36
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xl Landroidx/compose/ui/text/TextStyle;
    iput-object v2, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xlStrong Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v1, v37
    move-object/from16 v2, v38
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xl Landroidx/compose/ui/text/TextStyle;
    iput-object v2, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xlStrong Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v1, v39
    move-object/from16 v2, v40
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLg Landroidx/compose/ui/text/TextStyle;
    iput-object v2, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLgStrong Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v1, v41
    move-object/from16 v2, v42
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingM Landroidx/compose/ui/text/TextStyle;
    iput-object v2, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingMStrong Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v1, v43
    move-object/from16 v2, v44
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXl Landroidx/compose/ui/text/TextStyle;
    iput-object v2, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXlStrong Landroidx/compose/ui/text/TextStyle;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.design.compose.TraeTypography  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  int  java.lang.Object)com.bytedance.trae.design.compose.TraeTypography
    .registers 48
    # ins_size=31
    move-object/from16 v0, v17
    move/from16 v1, v46
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBase Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseMd Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySm Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmMd Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXs Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsMd Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBase Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBaseStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXs Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXsStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->codeBase Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->codeSm Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v32
    const v16, 32768
    and-int v16, v1, v16
    move-object/from16 v32, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->codeXs Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v33
    const/high16 v16, 65536
    and-int v16, v1, v16
    move-object/from16 v33, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->footnote Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v34
    const/high16 v16, 131072
    and-int v16, v1, v16
    move-object/from16 v34, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->footnoteStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v35
    const/high16 v16, 262144
    and-int v16, v1, v16
    move-object/from16 v35, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xl Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v36
    const/high16 v16, 524288
    and-int v16, v1, v16
    move-object/from16 v36, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xlStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v37
    const/high16 v16, 1048576
    and-int v16, v1, v16
    move-object/from16 v37, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xl Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v38
    const/high16 v16, 2097152
    and-int v16, v1, v16
    move-object/from16 v38, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xlStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v39
    const/high16 v16, 4194304
    and-int v16, v1, v16
    move-object/from16 v39, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLg Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v40
    const/high16 v16, 8388608
    and-int v16, v1, v16
    move-object/from16 v40, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLgStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v41
    const/high16 v16, 16777216
    and-int v16, v1, v16
    move-object/from16 v41, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingM Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v42
    const/high16 v16, 33554432
    and-int v16, v1, v16
    move-object/from16 v42, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingMStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v43
    const/high16 v16, 67108864
    and-int v16, v1, v16
    move-object/from16 v43, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXl Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v15, v44
    const/high16 v16, 134217728
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXlStrong Landroidx/compose/ui/text/TextStyle;
    goto +3h
    move-object/from16 v1, v45
    move-object/from16 v18, v2
    move-object/from16 v19, v3
    move-object/from16 v20, v4
    move-object/from16 v21, v5
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move-object/from16 v27, v11
    move-object/from16 v28, v12
    move-object/from16 v29, v13
    move-object/from16 v30, v14
    move-object/from16 v44, v15
    move-object/from16 v45, v1
    invoke-virtual/range v17 ... v45, Lcom/bytedance/trae/design/compose/TraeTypography;->copy(Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle;)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v0
    return-object v0
.end method

.method public final component1()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBase Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component10()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBase Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component11()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBaseStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component12()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXs Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component13()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXsStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component14()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->codeBase Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component15()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->codeSm Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component16()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->codeXs Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component17()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->footnote Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component18()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->footnoteStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component19()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xl Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component2()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseMd Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component20()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xlStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component21()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xl Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component22()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xlStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component23()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLg Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component24()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLgStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component25()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingM Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component26()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingMStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component27()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXl Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component28()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXlStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component3()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component4()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySm Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component5()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmMd Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component6()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component7()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXs Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component8()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsMd Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final component9()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final copy(androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle  androidx.compose.ui.text.TextStyle)com.bytedance.trae.design.compose.TraeTypography
    .registers 60
    # ins_size=29
    move-object/from16 v1, v32
    move-object/from16 v2, v33
    move-object/from16 v3, v34
    move-object/from16 v4, v35
    move-object/from16 v5, v36
    move-object/from16 v6, v37
    move-object/from16 v7, v38
    move-object/from16 v8, v39
    move-object/from16 v9, v40
    move-object/from16 v10, v41
    move-object/from16 v11, v42
    move-object/from16 v12, v43
    move-object/from16 v13, v44
    move-object/from16 v14, v45
    move-object/from16 v15, v46
    move-object/from16 v16, v47
    move-object/from16 v17, v48
    move-object/from16 v18, v49
    move-object/from16 v19, v50
    move-object/from16 v20, v51
    move-object/from16 v21, v52
    move-object/from16 v22, v53
    move-object/from16 v23, v54
    move-object/from16 v24, v55
    move-object/from16 v25, v56
    move-object/from16 v26, v57
    move-object/from16 v27, v58
    move-object/from16 v28, v59
    const-string v0, "bodyBase"
    move-object/from16 v29, v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodyBaseMd"
    move-object/from16 v1, v33
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodyBaseStrong"
    move-object/from16 v1, v34
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodySm"
    move-object/from16 v1, v35
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodySmMd"
    move-object/from16 v1, v36
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodySmStrong"
    move-object/from16 v1, v37
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodyXs"
    move-object/from16 v1, v38
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodyXsMd"
    move-object/from16 v1, v39
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bodyXsStrong"
    move-object/from16 v1, v40
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "captionBase"
    move-object/from16 v1, v41
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "captionBaseStrong"
    move-object/from16 v1, v42
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "captionXs"
    move-object/from16 v1, v43
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "captionXsStrong"
    move-object/from16 v1, v44
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "codeBase"
    move-object/from16 v1, v45
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "codeSm"
    move-object/from16 v1, v46
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "codeXs"
    move-object/from16 v1, v47
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "footnote"
    move-object/from16 v1, v48
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "footnoteStrong"
    move-object/from16 v1, v49
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "heading2xl"
    move-object/from16 v1, v50
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "heading2xlStrong"
    move-object/from16 v1, v51
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "heading3xl"
    move-object/from16 v1, v52
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "heading3xlStrong"
    move-object/from16 v1, v53
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingLg"
    move-object/from16 v1, v54
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingLgStrong"
    move-object/from16 v1, v55
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingM"
    move-object/from16 v1, v56
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingMStrong"
    move-object/from16 v1, v57
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingXl"
    move-object/from16 v1, v58
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headingXlStrong"
    move-object/from16 v1, v59
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v30, Lcom/bytedance/trae/design/compose/TraeTypography;
    move-object/from16 v0, v30
    move-object/from16 v1, v29
    invoke-direct/range v0 ... v28, Lcom/bytedance/trae/design/compose/TraeTypography;-><init>(Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle;)V
    return-object v30
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/design/compose/TraeTypography;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/design/compose/TraeTypography;
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBase Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBase Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseMd Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseMd Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySm Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySm Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmMd Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmMd Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXs Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXs Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsMd Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsMd Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBase Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBase Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBaseStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBaseStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXs Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXs Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXsStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXsStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->codeBase Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->codeBase Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->codeSm Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->codeSm Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->codeXs Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->codeXs Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->footnote Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->footnote Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->footnoteStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->footnoteStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xl Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xl Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xlStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xlStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xl Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xl Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xlStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xlStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLg Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLg Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLgStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLgStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->headingM Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->headingM Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->headingMStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->headingMStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXl Landroidx/compose/ui/text/TextStyle;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXl Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXlStrong Landroidx/compose/ui/text/TextStyle;
    iget-object v5, v5, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXlStrong Landroidx/compose/ui/text/TextStyle;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBodyBase()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBase Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getBodyBaseMd()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseMd Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getBodyBaseStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getBodySm()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySm Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getBodySmMd()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmMd Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getBodySmStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getBodyXs()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXs Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getBodyXsMd()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsMd Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getBodyXsStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getCaptionBase()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBase Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getCaptionBaseStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBaseStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getCaptionXs()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXs Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getCaptionXsStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXsStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getCodeBase()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->codeBase Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getCodeSm()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->codeSm Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getCodeXs()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->codeXs Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getFootnote()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->footnote Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getFootnoteStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->footnoteStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getHeading2xl()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xl Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getHeading2xlStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xlStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getHeading3xl()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xl Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getHeading3xlStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xlStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getHeadingLg()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLg Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getHeadingLgStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLgStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getHeadingM()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingM Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getHeadingMStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingMStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getHeadingXl()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXl Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public final getHeadingXlStrong()androidx.compose.ui.text.TextStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXlStrong Landroidx/compose/ui/text/TextStyle;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBase Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v0, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseMd Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySm Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmMd Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXs Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsMd Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBase Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBaseStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXs Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXsStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->codeBase Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->codeSm Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->codeXs Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->footnote Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->footnoteStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xl Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xlStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xl Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xlStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLg Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLgStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->headingM Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->headingMStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXl Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXlStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, Landroidx/compose/ui/text/TextStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeTypography(bodyBase="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBase Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBaseMd="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseMd Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyBaseStrong="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyBaseStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodySm="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySm Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodySmMd="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmMd Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodySmStrong="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->bodySmStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyXs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXs Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyXsMd="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsMd Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bodyXsStrong="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->bodyXsStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionBase="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBase Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionBaseStrong="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->captionBaseStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionXs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXs Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", captionXsStrong="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->captionXsStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeBase="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->codeBase Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeSm="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->codeSm Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeXs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->codeXs Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", footnote="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->footnote Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", footnoteStrong="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->footnoteStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading2xl="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xl Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading2xlStrong="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->heading2xlStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading3xl="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xl Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", heading3xlStrong="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->heading3xlStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingLg="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLg Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v1, ", headingLgStrong="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->headingLgStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingM="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->headingM Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingMStrong="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->headingMStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingXl="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXl Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", headingXlStrong="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraeTypography;->headingXlStrong Landroidx/compose/ui/text/TextStyle;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
