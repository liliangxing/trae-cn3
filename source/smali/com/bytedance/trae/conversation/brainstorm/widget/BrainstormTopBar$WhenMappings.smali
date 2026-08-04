# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$WhenMappings;
.super Ljava/lang/Object;
.source "BrainstormTopBar.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;->values()[Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;->INTRO Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;->DISCUSSING Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;->ordinal()I
    move-result v3
    aput v2, v0, v3
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->values()[Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Normal Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->ordinal()I
    move-result v3
    aput v1, v0, v3
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Warning Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Expired Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$WhenMappings;->$EnumSwitchMapping$1 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x22
    :try_start_0x2a
    :try_start_0x32
.end method
