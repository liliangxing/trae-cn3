# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Z
.field public final synthetic f$1:J
.field public final synthetic f$10:I
.field public final synthetic f$11:I
.field public final synthetic f$2:J
.field public final synthetic f$3:F
.field public final synthetic f$4:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$5:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$6:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$7:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$8:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$9:Landroidx/compose/ui/Modifier;


.method public synthetic constructor <init>(boolean  long  long  float  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  int  int)void
    .registers 15
    # ins_size=15
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$0 Z
    iput-wide v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$1 J
    iput-wide v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$2 J
    iput v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$3 F
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$4 Lkotlin/jvm/functions/Function0;
    iput-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$5 Lkotlin/jvm/functions/Function1;
    iput-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$6 Lkotlin/jvm/functions/Function1;
    iput-object v10, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$7 Lkotlin/jvm/functions/Function0;
    iput-object v11, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$8 Lkotlin/jvm/functions/Function1;
    iput-object v12, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$9 Landroidx/compose/ui/Modifier;
    iput v13, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$10 I
    iput v14, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$11 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    iget-boolean v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$0 Z
    iget-wide v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$1 J
    iget-wide v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$2 J
    iget v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$3 F
    iget-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$4 Lkotlin/jvm/functions/Function0;
    iget-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$5 Lkotlin/jvm/functions/Function1;
    iget-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$6 Lkotlin/jvm/functions/Function1;
    iget-object v10, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$7 Lkotlin/jvm/functions/Function0;
    iget-object v11, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$8 Lkotlin/jvm/functions/Function1;
    iget-object v12, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$9 Landroidx/compose/ui/Modifier;
    iget v13, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$10 I
    iget v14, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;->f$11 I
    move-object/from16 v15, v18
    check-cast v15, Landroidx/compose/runtime/Composer;
    move-object/from16 v16, v19
    check-cast v16, Ljava/lang/Integer;
    invoke-virtual/range v16, Ljava/lang/Integer;->intValue()I
    move-result v16
    invoke-static/range v1 ... v16, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$2CECS89c2RGjLLUfjZ7zsWVSpfc(Z J J F Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v1
    return-object v1
.end method
