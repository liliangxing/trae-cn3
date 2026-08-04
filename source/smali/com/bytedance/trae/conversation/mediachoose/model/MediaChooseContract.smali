# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;
.super Ljava/lang/Object;
.source "MediaChooseContract.kt"

.field public static final EXTRA_CONFIG:Ljava/lang/String;
.field public static final EXTRA_INITIAL_SELECTED:Ljava/lang/String;
.field public static final EXTRA_MAIN_COUNT:Ljava/lang/String;
.field public static final EXTRA_MAX_SINGLE_SIZE:Ljava/lang/String;
.field public static final EXTRA_MAX_TOTAL_SIZE:Ljava/lang/String;
.field public static final EXTRA_PREVIEW_CONFIG:Ljava/lang/String;
.field public static final EXTRA_PREVIEW_INDEX:Ljava/lang/String;
.field public static final EXTRA_PREVIEW_ITEMS:Ljava/lang/String;
.field public static final EXTRA_PREVIEW_KEEP_ORIGIN:Ljava/lang/String;
.field public static final EXTRA_PREVIEW_SELECTED_IDS:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;
.field public static final RESULT_BACK:I
.field public static final RESULT_BACK_KEEP_ORIGIN:Ljava/lang/String;
.field public static final RESULT_BACK_SELECTED_IDS:Ljava/lang/String;
.field public static final RESULT_HAS_VIDEO:Ljava/lang/String;
.field public static final RESULT_KEEP_ORIGIN:Ljava/lang/String;
.field public static final RESULT_SELECTED:Ljava/lang/String;
.field private static bridge previewItemsCache:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;->INSTANCE Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getPreviewItemsCache()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;->previewItemsCache Ljava/util/List;
    return-object v0
.end method

.method public final setPreviewItemsCache(java.util.List)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;->previewItemsCache Ljava/util/List;
    return-void 
.end method
