# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/im/model/MessageSourcePhase;
.super Ljava/lang/Enum;
.source "ParsedChatMessage.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/im/model/MessageSourcePhase;
.field public static final enum FETCHED:Lcom/bytedance/trae/im/model/MessageSourcePhase;
.field public static final enum STREAMING:Lcom/bytedance/trae/im/model/MessageSourcePhase;
.field public static final enum STREAM_DONE:Lcom/bytedance/trae/im/model/MessageSourcePhase;
.field public static final enum STREAM_ERROR:Lcom/bytedance/trae/im/model/MessageSourcePhase;


.method private static final synthetic $values()com.bytedance.trae.im.model.MessageSourcePhase[]
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Lcom/bytedance/trae/im/model/MessageSourcePhase;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/im/model/MessageSourcePhase;->FETCHED Lcom/bytedance/trae/im/model/MessageSourcePhase;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAMING Lcom/bytedance/trae/im/model/MessageSourcePhase;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAM_DONE Lcom/bytedance/trae/im/model/MessageSourcePhase;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAM_ERROR Lcom/bytedance/trae/im/model/MessageSourcePhase;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;
    const-string v1, "FETCHED"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/model/MessageSourcePhase;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;->FETCHED Lcom/bytedance/trae/im/model/MessageSourcePhase;
    new-instance v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;
    const-string v1, "STREAMING"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/model/MessageSourcePhase;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAMING Lcom/bytedance/trae/im/model/MessageSourcePhase;
    new-instance v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;
    const-string v1, "STREAM_DONE"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/model/MessageSourcePhase;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAM_DONE Lcom/bytedance/trae/im/model/MessageSourcePhase;
    new-instance v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;
    const-string v1, "STREAM_ERROR"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/model/MessageSourcePhase;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;->STREAM_ERROR Lcom/bytedance/trae/im/model/MessageSourcePhase;
    invoke-static Lcom/bytedance/trae/im/model/MessageSourcePhase;->$values()[Lcom/bytedance/trae/im/model/MessageSourcePhase;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;->$VALUES [Lcom/bytedance/trae/im/model/MessageSourcePhase;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.im.model.MessageSourcePhase
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/MessageSourcePhase;
    return-object v1
.end method

.method public static values()com.bytedance.trae.im.model.MessageSourcePhase[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/model/MessageSourcePhase;->$VALUES [Lcom/bytedance/trae/im/model/MessageSourcePhase;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/im/model/MessageSourcePhase;
    return-object v0
.end method
