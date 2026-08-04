# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$1:F


.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  float)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function1;
    iput v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda0;->f$1 F
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function1;
    iget v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda0;->f$1 F
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$R8wGlbFNDKBH9pN6ACLTDxvwV_o(Lkotlin/jvm/functions/Function1; F)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
