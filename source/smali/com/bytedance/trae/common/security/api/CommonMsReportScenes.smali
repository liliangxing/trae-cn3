# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/security/api/CommonMsReportScenes;
.super Ljava/lang/Object;
.source "CommonMsReportScenes.kt"

.field public static final COLD_START:Ljava/lang/String;
.field public static final DID_IID_UPDATE:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/common/security/api/CommonMsReportScenes;
.field public static final LOGIN:Ljava/lang/String;
.field public static final MESSAGE:Ljava/lang/String;
.field public static final MODE_CHANGE_DELAY_MS:J
.field public static final MODE_CHANGE_PREFIX:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/security/api/CommonMsReportScenes;
    invoke-direct v0, Lcom/bytedance/trae/common/security/api/CommonMsReportScenes;-><init>()V
    sput-object v0, Lcom/bytedance/trae/common/security/api/CommonMsReportScenes;->INSTANCE Lcom/bytedance/trae/common/security/api/CommonMsReportScenes;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
