# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/api/BDTrackerConsts;
.super Ljava/lang/Object;
.source "BDTrackerConsts.kt"

.field public static final EVENT_VERIFY_HOST:Ljava/lang/String;
.field public static final EVENT_VERIFY_OVERSEA_HOST:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/applog/api/BDTrackerConsts;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/applog/api/BDTrackerConsts;
    invoke-direct v0, Lcom/bytedance/trae/applog/api/BDTrackerConsts;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/api/BDTrackerConsts;->INSTANCE Lcom/bytedance/trae/applog/api/BDTrackerConsts;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
