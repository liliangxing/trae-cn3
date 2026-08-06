package com.bytedance.trae.network;

import java.util.List;
import kotlin.Metadata;

/* compiled from: IHttpConst.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\bn\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010X\u001a\u00020\u0003H&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0012\u0010\u0018\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0012\u0010\u001c\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u0012\u0010\u001e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0005R\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0012\u0010\"\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0012\u0010$\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u0012\u0010&\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0005R\u0012\u0010(\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0005R\u0012\u0010*\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0005R\u0012\u0010,\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0005R\u0012\u0010.\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0005R\u0012\u00100\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0005R\u0012\u00102\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0005R\u0012\u00104\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0005R\u0012\u00106\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0005R\u0012\u00108\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0005R\u0012\u0010:\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0005R\u0012\u0010<\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0005R\u0012\u0010>\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0005R\u0012\u0010@\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0005R\u0012\u0010B\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005R\u0012\u0010D\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0005R\u0012\u0010F\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0005R\u0012\u0010H\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0005R\u0012\u0010J\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0005R\u0012\u0010L\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0005R\u0012\u0010N\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0005R\u0012\u0010P\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0005R\u0012\u0010R\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0005R\u0012\u0010T\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\u0005R\u0012\u0010V\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u0005R\u0012\u0010Y\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u0005R\u0012\u0010[\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u0005R\u0012\u0010]\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\u0005R\u0012\u0010_\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b`\u0010\u0005R\u0012\u0010a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\u0005R\u0012\u0010c\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bd\u0010\u0005R\u0012\u0010e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010\u0005R\u0012\u0010g\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\u0005R\u0012\u0010i\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u0005R\u0012\u0010k\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u0005R\u0012\u0010m\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bn\u0010\u0005R\u0012\u0010o\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\u0005R\u0018\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00030rX¦\u0004¢\u0006\u0006\u001a\u0004\bs\u0010t¨\u0006u"}, d2 = {"Lcom/bytedance/trae/network/IHttpConst;", "", "WSS", "", "getWSS", "()Ljava/lang/String;", "HTTPS", "getHTTPS", "ONLINE_BASE_HOST_API", "getONLINE_BASE_HOST_API", "ONLINE_BASE_HOST", "getONLINE_BASE_HOST", "ONLINE_WWW_HOST", "getONLINE_WWW_HOST", "ONLINE_WWW_HOST_API", "getONLINE_WWW_HOST_API", "ONLINE_WWW", "getONLINE_WWW", "ONLINE_WWW_API", "getONLINE_WWW_API", "ONLINE_HOST", "getONLINE_HOST", "ONLINE_HOST_API", "getONLINE_HOST_API", DebugSettings.ENTERPRISE_ENV_ONLINE, "getONLINE", "ONLINE_API", "getONLINE_API", "BOE_HOST", "getBOE_HOST", "BOE", "getBOE", "SAMI_WSS_HOST", "getSAMI_WSS_HOST", "SAMI_WSS_QUIC_HOST", "getSAMI_WSS_QUIC_HOST", "SHARE_PASSPORT_LOGIN_TOKEN", "getSHARE_PASSPORT_LOGIN_TOKEN", "MSSDK_PASSPORT_TOKEN", "getMSSDK_PASSPORT_TOKEN", "MSSDK_PASSPORT_TOKEN_Z", "getMSSDK_PASSPORT_TOKEN_Z", "PRAISE_DIALOG_SDK_HOST", "getPRAISE_DIALOG_SDK_HOST", "COZE_PLATFORM_HOST", "getCOZE_PLATFORM_HOST", "ASSIST_CENTER_HOST", "getASSIST_CENTER_HOST", "AI_APPLET_JSB_HOST", "getAI_APPLET_JSB_HOST", "BAIKE_JSB_HOST", "getBAIKE_JSB_HOST", "FEEDBACK_BASE_URL", "getFEEDBACK_BASE_URL", "FEEDBACK_SOURCE_LOGIN", "getFEEDBACK_SOURCE_LOGIN", "FEEDBACK_SOURCE_SETTING", "getFEEDBACK_SOURCE_SETTING", "FEEDBACK_SOURCE_PAYMENT", "getFEEDBACK_SOURCE_PAYMENT", "FEEDBACK_SOURCE_PRAISE", "getFEEDBACK_SOURCE_PRAISE", "configLibraUrl", "getConfigLibraUrl", "configDeepLinkUrl", "getConfigDeepLinkUrl", "termsUrl", "getTermsUrl", "privacyUrl", "getPrivacyUrl", "privacyAccountUrl", "getPrivacyAccountUrl", "privacyAbsUrl", "getPrivacyAbsUrl", "memoryFaqUrl", "getMemoryFaqUrl", "legalFaqUrl", "getLegalFaqUrl", "faceMemoryPrivacyUrl", "getFaceMemoryPrivacyUrl", "privacyNewUrl", "getPrivacyNewUrl", "loggingDLPUrl", "getLoggingDLPUrl", "ONLINE_RTC_SERVER_MESSAGE_DOMAIN", "getONLINE_RTC_SERVER_MESSAGE_DOMAIN", "TEST_RTC_SERVER_MESSAGE_DOMAIN", "getTEST_RTC_SERVER_MESSAGE_DOMAIN", "secLink", "ALICE_BOE_HOST", "getALICE_BOE_HOST", "ACCOUNTT_BOE_HOST", "getACCOUNTT_BOE_HOST", "accountSettingUrl", "getAccountSettingUrl", "deviceManagementUrl", "getDeviceManagementUrl", "personUrl", "getPersonUrl", "denoisePrivacyUrl", "getDenoisePrivacyUrl", "accessibilitySdkDebugUrl", "getAccessibilitySdkDebugUrl", "doubaoOfficialWebsite", "getDoubaoOfficialWebsite", "toutiaoArticleUrl", "getToutiaoArticleUrl", "avatarOnboardingVideoModelString", "getAvatarOnboardingVideoModelString", "avatarOnboardingVideoCoverUrl", "getAvatarOnboardingVideoCoverUrl", "avatarTutorialAudioUrl", "getAvatarTutorialAudioUrl", "authorizationWhiteList", "", "getAuthorizationWhiteList", "()Ljava/util/List;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IHttpConst {

    /* compiled from: IHttpConst.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static String getHTTPS(IHttpConst iHttpConst) {
            return "https://";
        }

        public static String getWSS(IHttpConst iHttpConst) {
            return "wss://";
        }
    }

    String getACCOUNTT_BOE_HOST();

    String getAI_APPLET_JSB_HOST();

    String getALICE_BOE_HOST();

    String getASSIST_CENTER_HOST();

    String getAccessibilitySdkDebugUrl();

    String getAccountSettingUrl();

    List<String> getAuthorizationWhiteList();

    String getAvatarOnboardingVideoCoverUrl();

    String getAvatarOnboardingVideoModelString();

    String getAvatarTutorialAudioUrl();

    String getBAIKE_JSB_HOST();

    String getBOE();

    String getBOE_HOST();

    String getCOZE_PLATFORM_HOST();

    String getConfigDeepLinkUrl();

    String getConfigLibraUrl();

    String getDenoisePrivacyUrl();

    String getDeviceManagementUrl();

    String getDoubaoOfficialWebsite();

    String getFEEDBACK_BASE_URL();

    String getFEEDBACK_SOURCE_LOGIN();

    String getFEEDBACK_SOURCE_PAYMENT();

    String getFEEDBACK_SOURCE_PRAISE();

    String getFEEDBACK_SOURCE_SETTING();

    String getFaceMemoryPrivacyUrl();

    String getHTTPS();

    String getLegalFaqUrl();

    String getLoggingDLPUrl();

    String getMSSDK_PASSPORT_TOKEN();

    String getMSSDK_PASSPORT_TOKEN_Z();

    String getMemoryFaqUrl();

    String getONLINE();

    String getONLINE_API();

    String getONLINE_BASE_HOST();

    String getONLINE_BASE_HOST_API();

    String getONLINE_HOST();

    String getONLINE_HOST_API();

    String getONLINE_RTC_SERVER_MESSAGE_DOMAIN();

    String getONLINE_WWW();

    String getONLINE_WWW_API();

    String getONLINE_WWW_HOST();

    String getONLINE_WWW_HOST_API();

    String getPRAISE_DIALOG_SDK_HOST();

    String getPersonUrl();

    String getPrivacyAbsUrl();

    String getPrivacyAccountUrl();

    String getPrivacyNewUrl();

    String getPrivacyUrl();

    String getSAMI_WSS_HOST();

    String getSAMI_WSS_QUIC_HOST();

    String getSHARE_PASSPORT_LOGIN_TOKEN();

    String getTEST_RTC_SERVER_MESSAGE_DOMAIN();

    String getTermsUrl();

    String getToutiaoArticleUrl();

    String getWSS();

    String secLink();
}
