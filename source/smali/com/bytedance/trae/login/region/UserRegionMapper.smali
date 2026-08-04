# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/region/UserRegionMapper;
.super Ljava/lang/Object;
.source "UserRegionMapper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/region/UserRegionMapper;
.field private static final ttpCountries:Ljava/util/Set;
.field private static final vaCountries:Ljava/util/Set;


.method static constructor <clinit>()void
    .registers 99
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/region/UserRegionMapper;
    invoke-direct v0, Lcom/bytedance/trae/login/region/UserRegionMapper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/region/UserRegionMapper;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionMapper;
    const-string v1, "AS"
    const-string v2, "GU"
    const-string v3, "MP"
    const-string v4, "PR"
    const-string v5, "UM"
    const-string v6, "US"
    const-string v7, "VI"
    filled-new-array/range v1 ... v7, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/region/UserRegionMapper;->ttpCountries Ljava/util/Set;
    const-string v1, "AD"
    const-string v2, "AG"
    const-string v3, "AI"
    const-string v4, "AL"
    const-string v5, "AR"
    const-string v6, "AT"
    const-string v7, "AW"
    const-string v8, "BA"
    const-string v9, "BB"
    const-string v10, "BE"
    const-string v11, "BG"
    const-string v12, "BL"
    const-string v13, "BM"
    const-string v14, "BO"
    const-string v15, "BQ"
    const-string v16, "BR"
    const-string v17, "BS"
    const-string v18, "BZ"
    const-string v19, "CA"
    const-string v20, "CH"
    const-string v21, "CL"
    const-string v22, "CO"
    const-string v23, "CR"
    const-string v24, "CW"
    const-string v25, "CZ"
    const-string v26, "DE"
    const-string v27, "DK"
    const-string v28, "DM"
    const-string v29, "DO"
    const-string v30, "EC"
    const-string v31, "ES"
    const-string v32, "FI"
    const-string v33, "FK"
    const-string v34, "FO"
    const-string v35, "FR"
    const-string v36, "GB"
    const-string v37, "GD"
    const-string v38, "GF"
    const-string v39, "GG"
    const-string v40, "GI"
    const-string v41, "GL"
    const-string v42, "GP"
    const-string v43, "GR"
    const-string v44, "GT"
    const-string v45, "GY"
    const-string v46, "HN"
    const-string v47, "HR"
    const-string v48, "HT"
    const-string v49, "HU"
    const-string v50, "IE"
    const-string v51, "IM"
    const-string v52, "IS"
    const-string v53, "IT"
    const-string v54, "JE"
    const-string v55, "JM"
    const-string v56, "KN"
    const-string v57, "KY"
    const-string v58, "LC"
    const-string v59, "LI"
    const-string v60, "LT"
    const-string v61, "LU"
    const-string v62, "LV"
    const-string v63, "MC"
    const-string v64, "MD"
    const-string v65, "ME"
    const-string v66, "MF"
    const-string v67, "MK"
    const-string v68, "MQ"
    const-string v69, "MS"
    const-string v70, "MT"
    const-string v71, "MX"
    const-string v72, "NI"
    const-string v73, "NL"
    const-string v74, "NO"
    const-string v75, "PA"
    const-string v76, "PE"
    const-string v77, "PL"
    const-string v78, "PM"
    const-string v79, "PT"
    const-string v80, "PY"
    const-string v81, "RO"
    const-string v82, "RS"
    const-string v83, "SE"
    const-string v84, "SI"
    const-string v85, "SJ"
    const-string v86, "SK"
    const-string v87, "SM"
    const-string v88, "SR"
    const-string v89, "SV"
    const-string v90, "SX"
    const-string v91, "TC"
    const-string v92, "TT"
    const-string v93, "UA"
    const-string v94, "UY"
    const-string v95, "VA"
    const-string v96, "VC"
    const-string v97, "VG"
    const-string v98, "XK"
    filled-new-array/range v1 ... v98, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/region/UserRegionMapper;->vaCountries Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final regionForStoreCountry(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "country"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v0, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toUpperCase(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/region/UserRegionMapper;->ttpCountries Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const-string v2, "TTP"
    return-object v2
    sget-object v0, Lcom/bytedance/trae/login/region/UserRegionMapper;->vaCountries Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    const-string v2, "VA"
    return-object v2
    const-string v2, "SG"
    return-object v2
.end method
