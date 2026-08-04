# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeColorTokens;
.super Ljava/lang/Object;
.source "TraeComposeTokens.kt"

.field public static final $stable:I
.field private static final Dark:Lcom/bytedance/trae/design/compose/TraeColors;
.field public static final INSTANCE:Lcom/bytedance/trae/design/compose/TraeColorTokens;
.field private static final Light:Lcom/bytedance/trae/design/compose/TraeColors;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeColorTokens;
    invoke-direct v0, Lcom/bytedance/trae/design/compose/TraeColorTokens;-><init>()V
    sput-object v0, Lcom/bytedance/trae/design/compose/TraeColorTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeColorTokens;
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeLightColors;->INSTANCE Lcom/bytedance/trae/design/compose/TraeLightColors;
    check-cast v0, Lcom/bytedance/trae/design/compose/TraeColors;
    sput-object v0, Lcom/bytedance/trae/design/compose/TraeColorTokens;->Light Lcom/bytedance/trae/design/compose/TraeColors;
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeDarkColors;->INSTANCE Lcom/bytedance/trae/design/compose/TraeDarkColors;
    check-cast v0, Lcom/bytedance/trae/design/compose/TraeColors;
    sput-object v0, Lcom/bytedance/trae/design/compose/TraeColorTokens;->Dark Lcom/bytedance/trae/design/compose/TraeColors;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getDark()com.bytedance.trae.design.compose.TraeColors
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeColorTokens;->Dark Lcom/bytedance/trae/design/compose/TraeColors;
    return-object v0
.end method

.method public final getLight()com.bytedance.trae.design.compose.TraeColors
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeColorTokens;->Light Lcom/bytedance/trae/design/compose/TraeColors;
    return-object v0
.end method
