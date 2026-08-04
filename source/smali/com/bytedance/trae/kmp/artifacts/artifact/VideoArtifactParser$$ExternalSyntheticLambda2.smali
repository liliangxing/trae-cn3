# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->$r8$lambda$RS3V-IXze4r_-qLgES1oyY-9p6A(Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;)Z
    move-result v1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method
