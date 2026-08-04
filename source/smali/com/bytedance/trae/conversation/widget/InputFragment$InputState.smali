# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
.super Ljava/lang/Enum;
.source "InputFragment.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
.field public static final enum Empty:Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
.field public static final enum Input:Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
.field public static final enum Sended:Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
.field public static final enum Sending:Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
.field public static final enum Stopped:Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;


.method private static final synthetic $values()com.bytedance.trae.conversation.widget.InputFragment$InputState[]
    .registers 3
    # ins_size=0
    const/4 v0, 5
    new-array v0, v0, [Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Empty Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sending Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sended Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    const-string v1, "Empty"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Empty Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    const-string v1, "Input"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    const-string v1, "Sending"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sending Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    const-string v1, "Sended"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sended Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    const-string v1, "Stopped"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-static Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->$values()[Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->$VALUES [Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.widget.InputFragment$InputState
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.widget.InputFragment$InputState[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->$VALUES [Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    return-object v0
.end method
