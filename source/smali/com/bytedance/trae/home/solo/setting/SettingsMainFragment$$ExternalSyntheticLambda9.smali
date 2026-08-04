# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda9;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroid/widget/TextView;
.field public final synthetic f$1:Landroid/widget/LinearLayout;


.method public synthetic constructor <init>(android.widget.TextView  android.widget.LinearLayout)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda9;->f$0 Landroid/widget/TextView;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda9;->f$1 Landroid/widget/LinearLayout;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda9;->f$0 Landroid/widget/TextView;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda9;->f$1 Landroid/widget/LinearLayout;
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;->$r8$lambda$hA84WZImDFwYWXT7gaewz32_6qk(Landroid/widget/TextView; Landroid/widget/LinearLayout; Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
