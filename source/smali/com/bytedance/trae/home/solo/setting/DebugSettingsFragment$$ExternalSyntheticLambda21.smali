# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda21;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/widget/TextView;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;
.field public final synthetic f$2:Z


.method public synthetic constructor <init>(android.widget.TextView  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda21;->f$0 Landroid/widget/TextView;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda21;->f$1 Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;
    iput-boolean v3, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda21;->f$2 Z
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda21;->f$0 Landroid/widget/TextView;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda21;->f$1 Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;
    iget-boolean v2, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda21;->f$2 Z
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->$r8$lambda$MwsFGByzYl5i-5qOB6hp5ktsuKU(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Z)V
    return-void 
.end method
