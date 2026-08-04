# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$WhenMappings;
.super Ljava/lang/Object;
.source "ChatFrontResponseTracker.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->values()[Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->Success Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->Failed Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->Canceled Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
.end method
