# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HttpConst;
.super Ljava/lang/Object;
.source "HttpConst.kt"

.implements Lcom/bytedance/trae/network/IHttpConst;

.field private static final ACCOUNTT_BOE_HOST:Ljava/lang/String;
.field private static final AI_APPLET_JSB_HOST:Ljava/lang/String;
.field private static final ALICE_BOE_HOST:Ljava/lang/String;
.field private static final ASSIST_CENTER_HOST:Ljava/lang/String;
.field private static final BAIKE_JSB_HOST:Ljava/lang/String;
.field private static final BOE:Ljava/lang/String;
.field private static final BOE_HOST:Ljava/lang/String;
.field private static final COZE_PLATFORM_HOST:Ljava/lang/String;
.field private static final FEEDBACK_BASE_URL:Ljava/lang/String;
.field private static final FEEDBACK_SOURCE_LOGIN:Ljava/lang/String;
.field private static final FEEDBACK_SOURCE_PAYMENT:Ljava/lang/String;
.field private static final FEEDBACK_SOURCE_PRAISE:Ljava/lang/String;
.field private static final FEEDBACK_SOURCE_SETTING:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/network/HttpConst;
.field private static final MSSDK_PASSPORT_TOKEN:Ljava/lang/String;
.field private static final MSSDK_PASSPORT_TOKEN_Z:Ljava/lang/String;
.field private static final ONLINE:Ljava/lang/String;
.field private static final ONLINE_API:Ljava/lang/String;
.field private static final ONLINE_BASE_HOST:Ljava/lang/String;
.field private static final ONLINE_BASE_HOST_API:Ljava/lang/String;
.field private static final ONLINE_HOST:Ljava/lang/String;
.field private static final ONLINE_HOST_API:Ljava/lang/String;
.field private static final ONLINE_RTC_SERVER_MESSAGE_DOMAIN:Ljava/lang/String;
.field private static final ONLINE_WWW:Ljava/lang/String;
.field private static final ONLINE_WWW_API:Ljava/lang/String;
.field private static final ONLINE_WWW_HOST:Ljava/lang/String;
.field private static final ONLINE_WWW_HOST_API:Ljava/lang/String;
.field private static final PRAISE_DIALOG_SDK_HOST:Ljava/lang/String;
.field private static final SAMI_WSS_HOST:Ljava/lang/String;
.field private static final SAMI_WSS_QUIC_HOST:Ljava/lang/String;
.field private static final SHARE_PASSPORT_LOGIN_TOKEN:Ljava/lang/String;
.field private static final TEST_RTC_SERVER_MESSAGE_DOMAIN:Ljava/lang/String;
.field private static final accessibilitySdkDebugUrl:Ljava/lang/String;
.field private static final accountSettingUrl:Ljava/lang/String;
.field private static final authorizationWhiteList:Ljava/util/List;
.field private static final avatarOnboardingVideoCoverUrl:Ljava/lang/String;
.field private static final avatarOnboardingVideoModelString:Ljava/lang/String;
.field private static final avatarTutorialAudioUrl:Ljava/lang/String;
.field private static final configDeepLinkUrl:Ljava/lang/String;
.field private static final configLibraUrl:Ljava/lang/String;
.field private static final denoisePrivacyUrl:Ljava/lang/String;
.field private static final deviceManagementUrl:Ljava/lang/String;
.field private static final doubaoOfficialWebsite:Ljava/lang/String;
.field private static final faceMemoryPrivacyUrl:Ljava/lang/String;
.field private static final inst:Lcom/bytedance/trae/network/IHttpConst;
.field private static final legalFaqUrl:Ljava/lang/String;
.field private static final loggingDLPUrl:Ljava/lang/String;
.field private static final memoryFaqUrl:Ljava/lang/String;
.field private static final personUrl:Ljava/lang/String;
.field private static final privacyAbsUrl:Ljava/lang/String;
.field private static final privacyAccountUrl:Ljava/lang/String;
.field private static final privacyNewUrl:Ljava/lang/String;
.field private static final privacyUrl:Ljava/lang/String;
.field private static final termsUrl:Ljava/lang/String;
.field private static final toutiaoArticleUrl:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/HttpConst;
    invoke-direct v0, Lcom/bytedance/trae/network/HttpConst;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/HttpConst;->INSTANCE Lcom/bytedance/trae/network/HttpConst;
    const-class v0, Lcom/bytedance/trae/network/IHttpConst;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/network/IHttpConst;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/network/IHttpConst;
    sput-object v0, Lcom/bytedance/trae/network/HttpConst;->inst Lcom/bytedance/trae/network/IHttpConst;
    const-string v1, ""
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE_BASE_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE_BASE_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE_BASE_HOST_API()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE_BASE_HOST_API Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE_WWW_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE_WWW_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE_WWW_HOST_API()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE_WWW_HOST_API Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE_WWW()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE_WWW Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE_WWW_API()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE_WWW_API Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE_HOST_API()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE_HOST_API Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE_API()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE_API Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getBOE_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->BOE_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getBOE()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->BOE Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getSAMI_WSS_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->SAMI_WSS_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getSAMI_WSS_QUIC_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->SAMI_WSS_QUIC_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getSHARE_PASSPORT_LOGIN_TOKEN()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->SHARE_PASSPORT_LOGIN_TOKEN Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getMSSDK_PASSPORT_TOKEN()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->MSSDK_PASSPORT_TOKEN Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getMSSDK_PASSPORT_TOKEN_Z()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->MSSDK_PASSPORT_TOKEN_Z Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getPRAISE_DIALOG_SDK_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->PRAISE_DIALOG_SDK_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getCOZE_PLATFORM_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->COZE_PLATFORM_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getASSIST_CENTER_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ASSIST_CENTER_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getAI_APPLET_JSB_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->AI_APPLET_JSB_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getBAIKE_JSB_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->BAIKE_JSB_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getFEEDBACK_BASE_URL()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->FEEDBACK_BASE_URL Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getFEEDBACK_SOURCE_LOGIN()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->FEEDBACK_SOURCE_LOGIN Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getFEEDBACK_SOURCE_SETTING()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->FEEDBACK_SOURCE_SETTING Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getFEEDBACK_SOURCE_PAYMENT()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->FEEDBACK_SOURCE_PAYMENT Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getFEEDBACK_SOURCE_PRAISE()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->FEEDBACK_SOURCE_PRAISE Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getConfigLibraUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->configLibraUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getConfigDeepLinkUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->configDeepLinkUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getTermsUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->termsUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getPrivacyUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->privacyUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getPrivacyAccountUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->privacyAccountUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getPrivacyAbsUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->privacyAbsUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getMemoryFaqUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->memoryFaqUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getLegalFaqUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->legalFaqUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getFaceMemoryPrivacyUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->faceMemoryPrivacyUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getPrivacyNewUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->privacyNewUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getONLINE_RTC_SERVER_MESSAGE_DOMAIN()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ONLINE_RTC_SERVER_MESSAGE_DOMAIN Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getTEST_RTC_SERVER_MESSAGE_DOMAIN()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->TEST_RTC_SERVER_MESSAGE_DOMAIN Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getALICE_BOE_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ALICE_BOE_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getACCOUNTT_BOE_HOST()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->ACCOUNTT_BOE_HOST Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getAccountSettingUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->accountSettingUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getDeviceManagementUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->deviceManagementUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getPersonUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->personUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getDenoisePrivacyUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->denoisePrivacyUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getAccessibilitySdkDebugUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->accessibilitySdkDebugUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getDoubaoOfficialWebsite()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->doubaoOfficialWebsite Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getToutiaoArticleUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->toutiaoArticleUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getAuthorizationWhiteList()Ljava/util/List;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/HttpConst;->authorizationWhiteList Ljava/util/List;
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->inst Lcom/bytedance/trae/network/IHttpConst;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getAvatarOnboardingVideoModelString()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->avatarOnboardingVideoModelString Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getAvatarOnboardingVideoCoverUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->avatarOnboardingVideoCoverUrl Ljava/lang/String;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getAvatarTutorialAudioUrl()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    sput-object v2, Lcom/bytedance/trae/network/HttpConst;->avatarTutorialAudioUrl Ljava/lang/String;
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->getLoggingDLPUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v1, v0
    sput-object v1, Lcom/bytedance/trae/network/HttpConst;->loggingDLPUrl Ljava/lang/String;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getACCOUNTT_BOE_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ACCOUNTT_BOE_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getAI_APPLET_JSB_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->AI_APPLET_JSB_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getALICE_BOE_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ALICE_BOE_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getASSIST_CENTER_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ASSIST_CENTER_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getAccessibilitySdkDebugUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->accessibilitySdkDebugUrl Ljava/lang/String;
    return-object v0
.end method

.method public getAccountSettingUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->accountSettingUrl Ljava/lang/String;
    return-object v0
.end method

.method public getAuthorizationWhiteList()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->authorizationWhiteList Ljava/util/List;
    return-object v0
.end method

.method public getAvatarOnboardingVideoCoverUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->avatarOnboardingVideoCoverUrl Ljava/lang/String;
    return-object v0
.end method

.method public getAvatarOnboardingVideoModelString()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->avatarOnboardingVideoModelString Ljava/lang/String;
    return-object v0
.end method

.method public getAvatarTutorialAudioUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->avatarTutorialAudioUrl Ljava/lang/String;
    return-object v0
.end method

.method public getBAIKE_JSB_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->BAIKE_JSB_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getBOE()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->BOE Ljava/lang/String;
    return-object v0
.end method

.method public getBOE_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->BOE_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getCOZE_PLATFORM_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->COZE_PLATFORM_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getConfigDeepLinkUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->configDeepLinkUrl Ljava/lang/String;
    return-object v0
.end method

.method public getConfigLibraUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->configLibraUrl Ljava/lang/String;
    return-object v0
.end method

.method public getDenoisePrivacyUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->denoisePrivacyUrl Ljava/lang/String;
    return-object v0
.end method

.method public getDeviceManagementUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->deviceManagementUrl Ljava/lang/String;
    return-object v0
.end method

.method public getDoubaoOfficialWebsite()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->doubaoOfficialWebsite Ljava/lang/String;
    return-object v0
.end method

.method public getFEEDBACK_BASE_URL()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->FEEDBACK_BASE_URL Ljava/lang/String;
    return-object v0
.end method

.method public getFEEDBACK_SOURCE_LOGIN()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->FEEDBACK_SOURCE_LOGIN Ljava/lang/String;
    return-object v0
.end method

.method public getFEEDBACK_SOURCE_PAYMENT()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->FEEDBACK_SOURCE_PAYMENT Ljava/lang/String;
    return-object v0
.end method

.method public getFEEDBACK_SOURCE_PRAISE()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->FEEDBACK_SOURCE_PRAISE Ljava/lang/String;
    return-object v0
.end method

.method public getFEEDBACK_SOURCE_SETTING()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->FEEDBACK_SOURCE_SETTING Ljava/lang/String;
    return-object v0
.end method

.method public getFaceMemoryPrivacyUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->faceMemoryPrivacyUrl Ljava/lang/String;
    return-object v0
.end method

.method public getHTTPS()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/network/IHttpConst$DefaultImpls;->getHTTPS(Lcom/bytedance/trae/network/IHttpConst;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getLegalFaqUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->legalFaqUrl Ljava/lang/String;
    return-object v0
.end method

.method public getLoggingDLPUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->loggingDLPUrl Ljava/lang/String;
    return-object v0
.end method

.method public getMSSDK_PASSPORT_TOKEN()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->MSSDK_PASSPORT_TOKEN Ljava/lang/String;
    return-object v0
.end method

.method public getMSSDK_PASSPORT_TOKEN_Z()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->MSSDK_PASSPORT_TOKEN_Z Ljava/lang/String;
    return-object v0
.end method

.method public getMemoryFaqUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->memoryFaqUrl Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE_API()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE_API Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE_BASE_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE_BASE_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE_BASE_HOST_API()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE_BASE_HOST_API Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE_HOST_API()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE_HOST_API Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE_RTC_SERVER_MESSAGE_DOMAIN()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE_RTC_SERVER_MESSAGE_DOMAIN Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE_WWW()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE_WWW Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE_WWW_API()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE_WWW_API Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE_WWW_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE_WWW_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getONLINE_WWW_HOST_API()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->ONLINE_WWW_HOST_API Ljava/lang/String;
    return-object v0
.end method

.method public getPRAISE_DIALOG_SDK_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->PRAISE_DIALOG_SDK_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getPersonUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->personUrl Ljava/lang/String;
    return-object v0
.end method

.method public getPrivacyAbsUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->privacyAbsUrl Ljava/lang/String;
    return-object v0
.end method

.method public getPrivacyAccountUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->privacyAccountUrl Ljava/lang/String;
    return-object v0
.end method

.method public getPrivacyNewUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->privacyNewUrl Ljava/lang/String;
    return-object v0
.end method

.method public getPrivacyUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->privacyUrl Ljava/lang/String;
    return-object v0
.end method

.method public getSAMI_WSS_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->SAMI_WSS_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getSAMI_WSS_QUIC_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->SAMI_WSS_QUIC_HOST Ljava/lang/String;
    return-object v0
.end method

.method public getSHARE_PASSPORT_LOGIN_TOKEN()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->SHARE_PASSPORT_LOGIN_TOKEN Ljava/lang/String;
    return-object v0
.end method

.method public getTEST_RTC_SERVER_MESSAGE_DOMAIN()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->TEST_RTC_SERVER_MESSAGE_DOMAIN Ljava/lang/String;
    return-object v0
.end method

.method public getTermsUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->termsUrl Ljava/lang/String;
    return-object v0
.end method

.method public getToutiaoArticleUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->toutiaoArticleUrl Ljava/lang/String;
    return-object v0
.end method

.method public getWSS()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/network/IHttpConst$DefaultImpls;->getWSS(Lcom/bytedance/trae/network/IHttpConst;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public secLink()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->inst Lcom/bytedance/trae/network/IHttpConst;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/network/IHttpConst;->secLink()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method
