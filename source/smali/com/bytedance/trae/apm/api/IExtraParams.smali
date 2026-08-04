# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/apm/api/IExtraParams;
.super Ljava/lang/Object;
.source "IExtraParams.kt"

.field public static final Companion:Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
.field public static final KEY_APP_VARIANT:Ljava/lang/String;
.field public static final KEY_BUILD_JOB_ID:Ljava/lang/String;
.field public static final KEY_GIT_BRANCH:Ljava/lang/String;
.field public static final KEY_GIT_COMMIT_ID:Ljava/lang/String;
.field public static final KEY_PROCESS_ID:Ljava/lang/String;
.field public static final KEY_PROCESS_NAME:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->$$INSTANCE Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
    sput-object v0, Lcom/bytedance/trae/apm/api/IExtraParams;->Companion Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
    return-void 
.end method

.method public abstract getAppVariant()java.lang.String
    # abstract or native
.end method

.method public abstract getStaticParams()java.util.Map
    # abstract or native
.end method
