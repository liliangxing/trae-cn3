# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;
.super Ljava/lang/Object;
.source "SettingsUiState.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;-><init>()V
    return-void 
.end method

.method public final fromValue(java.lang.String)com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Dark Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Dark Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    goto +12h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->System Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->System Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Light Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    return-object v2
.end method
