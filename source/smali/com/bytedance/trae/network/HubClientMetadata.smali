# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HubClientMetadata;
.super Ljava/lang/Object;
.source "HubClientMetadata.kt"

.field public static final Companion:Lcom/bytedance/trae/network/HubClientMetadata$Companion;
.field private static final DEFAULT_DEVICE_NAME:Ljava/lang/String;
.field private static final MAX_DEVICE_NAME_LENGTH:I
.field private final deviceName:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/HubClientMetadata$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/HubClientMetadata$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/HubClientMetadata;->Companion Lcom/bytedance/trae/network/HubClientMetadata$Companion;
    return-void 
.end method

.method private constructor <init>(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/HubClientMetadata;->deviceName Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, Lcom/bytedance/trae/network/HubClientMetadata;-><init>(Ljava/lang/String;)V
    return-void 
.end method

.method public final getDeviceName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/HubClientMetadata;->deviceName Ljava/lang/String;
    return-object v0
.end method
