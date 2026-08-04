# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;
.super Ljava/lang/Object;
.source "DeviceStatusLabelPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final resolve(boolean  boolean)com.bytedance.trae.conversation.devices.DeviceStatusLabel
    .registers 3
    # ins_size=3
    if-nez v2, +005h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->UNPAIRED Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    goto +8h
    if-eqz v1, +005h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->ONLINE Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    goto +3h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->OFFLINE Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    return-object v1
.end method
