# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;
.super Ljava/lang/Object;
.source "KmpStringResource.android.kt"


.method public static final kmpStringResource(org.jetbrains.compose.resources.StringResource  java.lang.Object[]  androidx.compose.runtime.Composer  int)java.lang.String
    .registers 7
    # ins_size=4
    const-string/jumbo v0, resource
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "formatArgs"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, 1041757904
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +008h
    const/4 v1, -1
    const-string v2, "com.bytedance.trae.kmp.ui.kmpStringResource (KmpStringResource.android.kt:10)"
    invoke-static v0, v6, v1, v2, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    array-length v0, v4
    invoke-static v4, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v4
    and-int/lit8 v6, v6, 14
    invoke-static v3, v4, v5, v6, Lorg/jetbrains/compose/resources/StringResources_androidKt;->stringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v3
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    return-object v3
.end method
