# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
.field public final synthetic f$1:Landroidx/compose/ui/Modifier;
.field public final synthetic f$10:I
.field public final synthetic f$11:I
.field public final synthetic f$2:Landroidx/compose/foundation/ScrollState;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$4:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$5:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$6:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$7:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$8:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$9:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState  androidx.compose.ui.Modifier  androidx.compose.foundation.ScrollState  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  int  int)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$1 Landroidx/compose/ui/Modifier;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$2 Landroidx/compose/foundation/ScrollState;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$3 Lkotlin/jvm/functions/Function0;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$4 Lkotlin/jvm/functions/Function1;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$5 Lkotlin/jvm/functions/Function1;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$6 Lkotlin/jvm/functions/Function0;
    iput-object v8, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$7 Lkotlin/jvm/functions/Function0;
    iput-object v9, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$8 Lkotlin/jvm/functions/Function0;
    iput-object v10, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$9 Lkotlin/jvm/functions/Function1;
    iput v11, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$10 I
    iput v12, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$11 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 18
    # ins_size=3
    move-object v0, v15
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$1 Landroidx/compose/ui/Modifier;
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$2 Landroidx/compose/foundation/ScrollState;
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$3 Lkotlin/jvm/functions/Function0;
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$4 Lkotlin/jvm/functions/Function1;
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$5 Lkotlin/jvm/functions/Function1;
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$6 Lkotlin/jvm/functions/Function0;
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$7 Lkotlin/jvm/functions/Function0;
    iget-object v9, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$8 Lkotlin/jvm/functions/Function0;
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$9 Lkotlin/jvm/functions/Function1;
    iget v11, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$10 I
    iget v12, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;->f$11 I
    move-object/from16 v13, v16
    check-cast v13, Landroidx/compose/runtime/Composer;
    move-object/from16 v14, v17
    check-cast v14, Ljava/lang/Integer;
    invoke-virtual v14, Ljava/lang/Integer;->intValue()I
    move-result v14
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->$r8$lambda$eBLdJ134aOFtf1UG0FNjW3n1UZI(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/ScrollState; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v1
    return-object v1
.end method
