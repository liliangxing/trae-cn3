# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:J
.field public final synthetic f$1:J
.field public final synthetic f$2:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$4:Landroidx/compose/ui/Modifier;
.field public final synthetic f$5:I
.field public final synthetic f$6:I


.method public synthetic constructor <init>(long  long  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  int  int)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$0 J
    iput-wide v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$1 J
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$2 Lkotlin/jvm/functions/Function1;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$3 Lkotlin/jvm/functions/Function1;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$4 Landroidx/compose/ui/Modifier;
    iput v8, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$5 I
    iput v9, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$6 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=3
    iget-wide v0, v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$0 J
    iget-wide v2, v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$1 J
    iget-object v4, v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$2 Lkotlin/jvm/functions/Function1;
    iget-object v5, v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$3 Lkotlin/jvm/functions/Function1;
    iget-object v6, v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$4 Landroidx/compose/ui/Modifier;
    iget v7, v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$5 I
    iget v8, v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;->f$6 I
    move-object v9, v12
    check-cast v9, Landroidx/compose/runtime/Composer;
    check-cast v13, Ljava/lang/Integer;
    invoke-virtual v13, Ljava/lang/Integer;->intValue()I
    move-result v10
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$3KNoH5LtYSrQnrD9B9bjPOyjYDQ(J J Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v12
    return-object v12
.end method
