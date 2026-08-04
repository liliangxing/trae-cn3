# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/response/HttpErrorCode;
.super Ljava/lang/Object;
.source "HttpErrorCode.kt"

.field public static final CANCELLED:I
.field public static final CONNECT_FAIL:I
.field public static final EOF_ERROR:I
.field public static final ILLEGAL_ARGUMENT:I
.field public static final INSTANCE:Lcom/bytedance/trae/network/response/HttpErrorCode;
.field public static final INVALID_FORMAT:I
.field public static final NULL_POINTER:I
.field public static final SOCKET_TIME_OUT:I
.field public static final UNKNOWN:I
.field public static final UNKNOWN_HOST:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/response/HttpErrorCode;
    invoke-direct v0, Lcom/bytedance/trae/network/response/HttpErrorCode;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/response/HttpErrorCode;->INSTANCE Lcom/bytedance/trae/network/response/HttpErrorCode;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
