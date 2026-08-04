# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda22;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Ljava/util/Map;
.field public final synthetic f$1:F
.field public final synthetic f$2:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(java.util.Map  float  kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda22;->f$0 Ljava/util/Map;
    iput v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda22;->f$1 F
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda22;->f$2 Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda22;->f$0 Ljava/util/Map;
    iget v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda22;->f$1 F
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda22;->f$2 Lkotlin/jvm/functions/Function1;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$LLlOj3DHgWJNGLiK9hcFFlNHkMw(Ljava/util/Map; F Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
