# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda19;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda19;->f$0 Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda19;->f$0 Lkotlin/jvm/functions/Function1;
    check-cast v4, Ljava/lang/Long;
    invoke-virtual v4, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$GS_na5PYY_wSmlAxu_5JuWOMw9M(Lkotlin/jvm/functions/Function1; J)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
