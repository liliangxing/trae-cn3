# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;
.super Ljava/lang/Object;
.source "SettingsEntry.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I
.field public static final synthetic $EnumSwitchMapping$2:[I
.field public static final synthetic $EnumSwitchMapping$3:[I


.method static constructor <clinit>()void
    .registers 6
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->values()[Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->Free Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->PublicCloud Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->ordinal()I
    move-result v3
    aput v2, v0, v3
    const/4 v3, 3
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->Enterprise Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->ordinal()I
    move-result v4
    aput v3, v0, v4
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->values()[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Theme Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    aput v1, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Language Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    aput v2, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Debug Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    aput v3, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Subscribe Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/4 v5, 4
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Usage Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/4 v5, 5
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Account Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/4 v5, 6
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Message Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/4 v5, 7
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Points Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 8
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Notification Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 9
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->DeviceManagement Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 10
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Connectors Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 11
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->PrivacyPermission Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 12
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Update Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 13
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->About Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 14
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Logout Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    const/16 v5, 15
    aput v5, v0, v4
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-static Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->values()[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Light Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->ordinal()I
    move-result v4
    aput v1, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Dark Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->ordinal()I
    move-result v4
    aput v2, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->System Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->ordinal()I
    move-result v4
    aput v3, v0, v4
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-static Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;->values()[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;->Team Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;->ordinal()I
    move-result v3
    aput v1, v0, v3
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;->Enterprise Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$3 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x1a
    :try_start_0x2b
    :try_start_0x33
    :try_start_0x3b
    :try_start_0x43
    :try_start_0x4c
    :try_start_0x55
    :try_start_0x5e
    :try_start_0x67
    :try_start_0x71
    :try_start_0x7b
    :try_start_0x85
    :try_start_0x8f
    :try_start_0x99
    :try_start_0xa3
    :try_start_0xad
    :try_start_0xc0
    :try_start_0xc8
    :try_start_0xd0
    :try_start_0xe1
    :try_start_0xe9
.end method
