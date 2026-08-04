# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final enum Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
.super Ljava/lang/Enum;
.source "VideoArtifactPreview.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
.field public static final enum Rejected:Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
.field public static final enum Undecided:Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
.field public static final enum VerticalDown:Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;


.method private static final synthetic $values()com.bytedance.trae.kmp.artifacts.video.PreviewDismissGestureDirection[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->Undecided Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->VerticalDown Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->Rejected Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    const-string v1, "Undecided"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->Undecided Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    const-string v1, "VerticalDown"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->VerticalDown Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    const-string v1, "Rejected"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->Rejected Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    invoke-static Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->$values()[Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->$VALUES [Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.kmp.artifacts.video.PreviewDismissGestureDirection
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    return-object v1
.end method

.method public static values()com.bytedance.trae.kmp.artifacts.video.PreviewDismissGestureDirection[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->$VALUES [Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    return-object v0
.end method
