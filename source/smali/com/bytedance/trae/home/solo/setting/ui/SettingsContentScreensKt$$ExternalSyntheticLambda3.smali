# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/kmp/host/KmpHostInfo;
.field public final synthetic f$1:Landroidx/compose/ui/Modifier;
.field public final synthetic f$2:I
.field public final synthetic f$3:I


.method public synthetic constructor <init>(com.bytedance.trae.kmp.host.KmpHostInfo  androidx.compose.ui.Modifier  int  int)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda3;->f$1 Landroidx/compose/ui/Modifier;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda3;->f$2 I
    iput v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda3;->f$3 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=3
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda3;->f$1 Landroidx/compose/ui/Modifier;
    iget v2, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda3;->f$2 I
    iget v3, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda3;->f$3 I
    move-object v4, v7
    check-cast v4, Landroidx/compose/runtime/Composer;
    check-cast v8, Ljava/lang/Integer;
    invoke-virtual v8, Ljava/lang/Integer;->intValue()I
    move-result v5
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt;->$r8$lambda$o8qu_H-1ERaEybSzp50hwDtbjyI(Lcom/bytedance/trae/kmp/host/KmpHostInfo; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
