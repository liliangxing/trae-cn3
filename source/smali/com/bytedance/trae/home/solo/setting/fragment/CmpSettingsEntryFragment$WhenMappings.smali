# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$WhenMappings;
.super Ljava/lang/Object;
.source "CmpSettingsEntryFragment.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I


.method static constructor <clinit>()void
    .registers 6
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->values()[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Subscribe Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Usage Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v3
    aput v2, v0, v3
    const/4 v3, 3
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Points Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    aput v3, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Account Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/4 v5, 4
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Message Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/4 v5, 5
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Theme Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/4 v5, 6
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Language Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/4 v5, 7
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Notification Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 8
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->DeviceManagement Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 9
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Connectors Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 10
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->PrivacyPermission Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 11
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Update Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 12
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->About Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 13
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Debug Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 14
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Logout Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 15
    aput v5, v0, v4
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->values()[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Light Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->ordinal()I
    move-result v4
    aput v1, v0, v4
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Dark Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->System Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->ordinal()I
    move-result v1
    aput v3, v0, v1
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$WhenMappings;->$EnumSwitchMapping$1 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x1a
    :try_start_0x22
    :try_start_0x2b
    :try_start_0x34
    :try_start_0x3d
    :try_start_0x46
    :try_start_0x50
    :try_start_0x5a
    :try_start_0x64
    :try_start_0x6e
    :try_start_0x78
    :try_start_0x82
    :try_start_0x8c
    :try_start_0x9f
    :try_start_0xa7
    :try_start_0xaf
.end method
