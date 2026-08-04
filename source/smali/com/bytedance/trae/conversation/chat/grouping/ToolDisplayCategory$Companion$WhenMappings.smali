# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion$WhenMappings;
.super Ljava/lang/Object;
.source "ToolDisplayCategory.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->values()[Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->NONE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
.end method
