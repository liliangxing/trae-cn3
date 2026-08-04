# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lorg/jetbrains/compose/resources/DrawableResource;
.field public final synthetic f$1:F
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:J
.field public final synthetic f$4:Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
.field public final synthetic f$5:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$6:I


.method public synthetic constructor <init>(org.jetbrains.compose.resources.DrawableResource  float  java.lang.String  long  com.bytedance.trae.home.solo.setting.ui.DeviceManagementPalette  kotlin.jvm.functions.Function0  int)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$0 Lorg/jetbrains/compose/resources/DrawableResource;
    iput v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$1 F
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$2 Ljava/lang/String;
    iput-wide v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$3 J
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$4 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$5 Lkotlin/jvm/functions/Function0;
    iput v8, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$6 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=3
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$0 Lorg/jetbrains/compose/resources/DrawableResource;
    iget v1, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$1 F
    iget-object v2, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$2 Ljava/lang/String;
    iget-wide v3, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$3 J
    iget-object v5, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$4 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iget-object v6, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$5 Lkotlin/jvm/functions/Function0;
    iget v7, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda22;->f$6 I
    move-object v8, v11
    check-cast v8, Landroidx/compose/runtime/Composer;
    check-cast v12, Ljava/lang/Integer;
    invoke-virtual v12, Ljava/lang/Integer;->intValue()I
    move-result v9
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->$r8$lambda$tvZxtbLG8BeSirQrwrpcB44kX50(Lorg/jetbrains/compose/resources/DrawableResource; F Ljava/lang/String; J Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette; Lkotlin/jvm/functions/Function0; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v11
    return-object v11
.end method
