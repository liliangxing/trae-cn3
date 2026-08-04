# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/kmp/network/KmpHttpClient;
.field public final synthetic f$1:Lcom/bytedance/trae/kmp/host/KmpHostInfo;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$4:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$5:Landroidx/compose/ui/Modifier;
.field public final synthetic f$6:I
.field public final synthetic f$7:I


.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.host.KmpHostInfo  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  int  int)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$0 Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$1 Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$2 Lkotlin/jvm/functions/Function0;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$3 Lkotlin/jvm/functions/Function0;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$4 Lkotlin/jvm/functions/Function1;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$5 Landroidx/compose/ui/Modifier;
    iput v7, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$6 I
    iput v8, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$7 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=3
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$0 Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$1 Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    iget-object v2, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$2 Lkotlin/jvm/functions/Function0;
    iget-object v3, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$3 Lkotlin/jvm/functions/Function0;
    iget-object v4, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$4 Lkotlin/jvm/functions/Function1;
    iget-object v5, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$5 Landroidx/compose/ui/Modifier;
    iget v6, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$6 I
    iget v7, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda8;->f$7 I
    move-object v8, v11
    check-cast v8, Landroidx/compose/runtime/Composer;
    check-cast v12, Ljava/lang/Integer;
    invoke-virtual v12, Ljava/lang/Integer;->intValue()I
    move-result v9
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt;->$r8$lambda$PWkEhmM690M2OPmjq_MSkRl_n54(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/host/KmpHostInfo; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v11
    return-object v11
.end method
