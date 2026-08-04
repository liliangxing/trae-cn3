# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field public final synthetic f$0:Landroid/widget/TextView;
.field public final synthetic f$1:Landroid/content/Context;


.method public synthetic constructor <init>(android.widget.TextView  android.content.Context)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda7;->f$0 Landroid/widget/TextView;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda7;->f$1 Landroid/content/Context;
    return-void 
.end method

.method public final onCheckedChanged(android.widget.CompoundButton  boolean)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda7;->f$0 Landroid/widget/TextView;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda7;->f$1 Landroid/content/Context;
    invoke-static v0, v1, v3, v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->$r8$lambda$Xbi_95C_jZqHewr1ue-Dyh9dnrY(Landroid/widget/TextView; Landroid/content/Context; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method
