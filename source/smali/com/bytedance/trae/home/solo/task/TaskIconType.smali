# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/home/solo/task/TaskIconType;
.super Ljava/lang/Enum;
.source "TaskModel.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum APP:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum BUSINESS:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum CHAT:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum CODE:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final Companion:Lcom/bytedance/trae/home/solo/task/TaskIconType$Companion;
.field public static final enum DATA:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum DESIGN:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum DOCUMENT:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum IMAGE:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum PERSONAL:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum PPT:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum RESEARCH:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field public static final enum WEBSITE:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field private final iconRes:I


.method private static final synthetic $values()com.bytedance.trae.home.solo.task.TaskIconType[]
    .registers 3
    # ins_size=0
    const/16 v0, 12
    new-array v0, v0, [Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->PPT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->CODE Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->WEBSITE Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->APP Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->IMAGE Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->DESIGN Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->DOCUMENT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->RESEARCH Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->DATA Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->BUSINESS Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->PERSONAL Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    const/16 v1, 11
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->CHAT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/4 v1, 0
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_ppt I
    const-string v3, "PPT"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->PPT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/4 v1, 1
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_code_type I
    const-string v3, "CODE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->CODE Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/4 v1, 2
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_web I
    const-string v3, "WEBSITE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->WEBSITE Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/4 v1, 3
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_app I
    const-string v3, "APP"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->APP Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/4 v1, 4
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_image I
    const-string v3, "IMAGE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->IMAGE Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/4 v1, 5
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_design I
    const-string v3, "DESIGN"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->DESIGN Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/4 v1, 6
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_document I
    const-string v3, "DOCUMENT"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->DOCUMENT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/4 v1, 7
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_research I
    const-string v3, "RESEARCH"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->RESEARCH Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/16 v1, 8
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_data I
    const-string v3, "DATA"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->DATA Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/16 v1, 9
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_business I
    const-string v3, "BUSINESS"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->BUSINESS Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/16 v1, 10
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_personal I
    const-string v3, "PERSONAL"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->PERSONAL Lcom/bytedance/trae/home/solo/task/TaskIconType;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    const/16 v1, 11
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_solo_task_chat I
    const-string v3, "CHAT"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->CHAT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskIconType;->$values()[Lcom/bytedance/trae/home/solo/task/TaskIconType;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->$VALUES [Lcom/bytedance/trae/home/solo/task/TaskIconType;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskIconType$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskIconType$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->Companion Lcom/bytedance/trae/home/solo/task/TaskIconType$Companion;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->iconRes I
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.home.solo.task.TaskIconType
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskIconType;
    return-object v1
.end method

.method public static values()com.bytedance.trae.home.solo.task.TaskIconType[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskIconType;->$VALUES [Lcom/bytedance/trae/home/solo/task/TaskIconType;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/home/solo/task/TaskIconType;
    return-object v0
.end method

.method public final getIconRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/task/TaskIconType;->iconRes I
    return v0
.end method
