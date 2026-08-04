# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda8;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
.field public final synthetic f$1:I


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda8;->f$0 Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iput v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda8;->f$1 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda8;->f$0 Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda8;->f$1 I
    check-cast v3, Landroidx/compose/runtime/Composer;
    check-cast v4, Ljava/lang/Integer;
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v4
    invoke-static v0, v1, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->$r8$lambda$sIgQELVkKB0MC9o5jQ12dXPlHGE(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
