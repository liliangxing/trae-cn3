# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer$WhenMappings;
.super Ljava/lang/Object;
.source "FreeActivityQuotaErrorRenderer.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/multilanguage/I18nLanguage;->values()[Lcom/bytedance/trae/multilanguage/I18nLanguage;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;->JA Lcom/bytedance/trae/multilanguage/I18nLanguage;
    invoke-virtual v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;->ZH Lcom/bytedance/trae/multilanguage/I18nLanguage;
    invoke-virtual v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
.end method
