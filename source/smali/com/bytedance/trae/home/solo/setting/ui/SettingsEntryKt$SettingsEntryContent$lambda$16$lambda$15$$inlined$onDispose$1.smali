# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$lambda$16$lambda$15$$inlined$onDispose$1;
.super Ljava/lang/Object;
.source "Effects.kt"

.implements Landroidx/compose/runtime/DisposableEffectResult;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public dispose()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->dismiss()V
    return-void 
.end method
