# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$4:I


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct  java.lang.String  com.bytedance.trae.home.solo.setting.ui.DeviceManagementPalette  kotlin.jvm.functions.Function1  int)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;->f$0 Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;->f$2 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;->f$3 Lkotlin/jvm/functions/Function1;
    iput v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;->f$4 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;->f$0 Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;->f$1 Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;->f$2 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;->f$3 Lkotlin/jvm/functions/Function1;
    iget v4, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda23;->f$4 I
    move-object v5, v8
    check-cast v5, Landroidx/compose/runtime/Composer;
    check-cast v9, Ljava/lang/Integer;
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v6
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->$r8$lambda$y-l3ZurHqB1M4pbep7iF0tYTCtM(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette; Lkotlin/jvm/functions/Function1; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
