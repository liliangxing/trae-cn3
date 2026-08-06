package com.bytedance.trae.network;

import com.bytedance.trae.network.IHttpConst;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: HttpConst.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\bb\n\u0002\u0010 \n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010U\u001a\u00020\u0006H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u0014\u0010\u001d\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0014\u0010\u001f\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u0014\u0010!\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\bR\u0014\u0010#\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\bR\u0014\u0010%\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u0014\u0010'\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\bR\u0014\u0010)\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\bR\u0014\u0010+\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\bR\u0014\u0010-\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\bR\u0014\u0010/\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\bR\u0014\u00101\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\bR\u0014\u00103\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\bR\u0014\u00105\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\bR\u0014\u00107\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\bR\u0014\u00109\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\bR\u0014\u0010;\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\bR\u0014\u0010=\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\bR\u0014\u0010?\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\bR\u0014\u0010A\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\bR\u0014\u0010C\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\bR\u0014\u0010E\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\bR\u0014\u0010G\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\bR\u0014\u0010I\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\bR\u0014\u0010K\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\bR\u0014\u0010M\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\bR\u0014\u0010O\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\bR\u0014\u0010Q\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\bR\u0014\u0010S\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\bR\u0014\u0010V\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\bR\u0014\u0010X\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\bR\u0014\u0010Z\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\bR\u0014\u0010\\\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\bR\u0014\u0010^\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\bR\u0014\u0010`\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\bR\u0014\u0010b\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\bR\u0014\u0010d\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\bR\u0014\u0010f\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\bR\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00060iX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0014\u0010l\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\bR\u0014\u0010n\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\bR\u0014\u0010p\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\bR\u0014\u0010r\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\b¨\u0006t"}, d2 = {"Lcom/bytedance/trae/network/HttpConst;", "Lcom/bytedance/trae/network/IHttpConst;", "<init>", "()V", "inst", "ONLINE_BASE_HOST", "", "getONLINE_BASE_HOST", "()Ljava/lang/String;", "ONLINE_BASE_HOST_API", "getONLINE_BASE_HOST_API", "ONLINE_WWW_HOST", "getONLINE_WWW_HOST", "ONLINE_WWW_HOST_API", "getONLINE_WWW_HOST_API", "ONLINE_WWW", "getONLINE_WWW", "ONLINE_WWW_API", "getONLINE_WWW_API", "ONLINE_HOST", "getONLINE_HOST", "ONLINE_HOST_API", "getONLINE_HOST_API", DebugSettings.ENTERPRISE_ENV_ONLINE, "getONLINE", "ONLINE_API", "getONLINE_API", "BOE_HOST", "getBOE_HOST", "BOE", "getBOE", "SAMI_WSS_HOST", "getSAMI_WSS_HOST", "SAMI_WSS_QUIC_HOST", "getSAMI_WSS_QUIC_HOST", "SHARE_PASSPORT_LOGIN_TOKEN", "getSHARE_PASSPORT_LOGIN_TOKEN", "MSSDK_PASSPORT_TOKEN", "getMSSDK_PASSPORT_TOKEN", "MSSDK_PASSPORT_TOKEN_Z", "getMSSDK_PASSPORT_TOKEN_Z", "PRAISE_DIALOG_SDK_HOST", "getPRAISE_DIALOG_SDK_HOST", "COZE_PLATFORM_HOST", "getCOZE_PLATFORM_HOST", "ASSIST_CENTER_HOST", "getASSIST_CENTER_HOST", "AI_APPLET_JSB_HOST", "getAI_APPLET_JSB_HOST", "BAIKE_JSB_HOST", "getBAIKE_JSB_HOST", "FEEDBACK_BASE_URL", "getFEEDBACK_BASE_URL", "FEEDBACK_SOURCE_LOGIN", "getFEEDBACK_SOURCE_LOGIN", "FEEDBACK_SOURCE_SETTING", "getFEEDBACK_SOURCE_SETTING", "FEEDBACK_SOURCE_PAYMENT", "getFEEDBACK_SOURCE_PAYMENT", "FEEDBACK_SOURCE_PRAISE", "getFEEDBACK_SOURCE_PRAISE", "configLibraUrl", "getConfigLibraUrl", "configDeepLinkUrl", "getConfigDeepLinkUrl", "termsUrl", "getTermsUrl", "privacyUrl", "getPrivacyUrl", "privacyAccountUrl", "getPrivacyAccountUrl", "privacyAbsUrl", "getPrivacyAbsUrl", "memoryFaqUrl", "getMemoryFaqUrl", "legalFaqUrl", "getLegalFaqUrl", "faceMemoryPrivacyUrl", "getFaceMemoryPrivacyUrl", "privacyNewUrl", "getPrivacyNewUrl", "ONLINE_RTC_SERVER_MESSAGE_DOMAIN", "getONLINE_RTC_SERVER_MESSAGE_DOMAIN", "TEST_RTC_SERVER_MESSAGE_DOMAIN", "getTEST_RTC_SERVER_MESSAGE_DOMAIN", "secLink", "ALICE_BOE_HOST", "getALICE_BOE_HOST", "ACCOUNTT_BOE_HOST", "getACCOUNTT_BOE_HOST", "accountSettingUrl", "getAccountSettingUrl", "deviceManagementUrl", "getDeviceManagementUrl", "personUrl", "getPersonUrl", "denoisePrivacyUrl", "getDenoisePrivacyUrl", "accessibilitySdkDebugUrl", "getAccessibilitySdkDebugUrl", "doubaoOfficialWebsite", "getDoubaoOfficialWebsite", "toutiaoArticleUrl", "getToutiaoArticleUrl", "authorizationWhiteList", "", "getAuthorizationWhiteList", "()Ljava/util/List;", "avatarOnboardingVideoModelString", "getAvatarOnboardingVideoModelString", "avatarOnboardingVideoCoverUrl", "getAvatarOnboardingVideoCoverUrl", "avatarTutorialAudioUrl", "getAvatarTutorialAudioUrl", "loggingDLPUrl", "getLoggingDLPUrl", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HttpConst implements IHttpConst {
    private static final String ACCOUNTT_BOE_HOST;
    private static final String AI_APPLET_JSB_HOST;
    private static final String ALICE_BOE_HOST;
    private static final String ASSIST_CENTER_HOST;
    private static final String BAIKE_JSB_HOST;
    private static final String BOE;
    private static final String BOE_HOST;
    private static final String COZE_PLATFORM_HOST;
    private static final String FEEDBACK_BASE_URL;
    private static final String FEEDBACK_SOURCE_LOGIN;
    private static final String FEEDBACK_SOURCE_PAYMENT;
    private static final String FEEDBACK_SOURCE_PRAISE;
    private static final String FEEDBACK_SOURCE_SETTING;
    public static final HttpConst INSTANCE = new HttpConst();
    private static final String MSSDK_PASSPORT_TOKEN;
    private static final String MSSDK_PASSPORT_TOKEN_Z;
    private static final String ONLINE;
    private static final String ONLINE_API;
    private static final String ONLINE_BASE_HOST;
    private static final String ONLINE_BASE_HOST_API;
    private static final String ONLINE_HOST;
    private static final String ONLINE_HOST_API;
    private static final String ONLINE_RTC_SERVER_MESSAGE_DOMAIN;
    private static final String ONLINE_WWW;
    private static final String ONLINE_WWW_API;
    private static final String ONLINE_WWW_HOST;
    private static final String ONLINE_WWW_HOST_API;
    private static final String PRAISE_DIALOG_SDK_HOST;
    private static final String SAMI_WSS_HOST;
    private static final String SAMI_WSS_QUIC_HOST;
    private static final String SHARE_PASSPORT_LOGIN_TOKEN;
    private static final String TEST_RTC_SERVER_MESSAGE_DOMAIN;
    private static final String accessibilitySdkDebugUrl;
    private static final String accountSettingUrl;
    private static final List<String> authorizationWhiteList;
    private static final String avatarOnboardingVideoCoverUrl;
    private static final String avatarOnboardingVideoModelString;
    private static final String avatarTutorialAudioUrl;
    private static final String configDeepLinkUrl;
    private static final String configLibraUrl;
    private static final String denoisePrivacyUrl;
    private static final String deviceManagementUrl;
    private static final String doubaoOfficialWebsite;
    private static final String faceMemoryPrivacyUrl;
    private static final IHttpConst inst;
    private static final String legalFaqUrl;
    private static final String loggingDLPUrl;
    private static final String memoryFaqUrl;
    private static final String personUrl;
    private static final String privacyAbsUrl;
    private static final String privacyAccountUrl;
    private static final String privacyNewUrl;
    private static final String privacyUrl;
    private static final String termsUrl;
    private static final String toutiaoArticleUrl;

    private HttpConst() {
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getHTTPS() {
        return IHttpConst.DefaultImpls.getHTTPS(this);
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getWSS() {
        return IHttpConst.DefaultImpls.getWSS(this);
    }

    static {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        String str47;
        String str48;
        List<String> emptyList;
        String str49;
        String str50;
        String str51;
        String loggingDLPUrl2;
        IHttpConst iHttpConst = (IHttpConst) ServiceManager.get().getService(IHttpConst.class);
        inst = iHttpConst;
        String str52 = "";
        if (iHttpConst == null || (str = iHttpConst.getONLINE_BASE_HOST()) == null) {
            str = "";
        }
        ONLINE_BASE_HOST = str;
        if (iHttpConst == null || (str2 = iHttpConst.getONLINE_BASE_HOST_API()) == null) {
            str2 = "";
        }
        ONLINE_BASE_HOST_API = str2;
        if (iHttpConst == null || (str3 = iHttpConst.getONLINE_WWW_HOST()) == null) {
            str3 = "";
        }
        ONLINE_WWW_HOST = str3;
        if (iHttpConst == null || (str4 = iHttpConst.getONLINE_WWW_HOST_API()) == null) {
            str4 = "";
        }
        ONLINE_WWW_HOST_API = str4;
        if (iHttpConst == null || (str5 = iHttpConst.getONLINE_WWW()) == null) {
            str5 = "";
        }
        ONLINE_WWW = str5;
        if (iHttpConst == null || (str6 = iHttpConst.getONLINE_WWW_API()) == null) {
            str6 = "";
        }
        ONLINE_WWW_API = str6;
        if (iHttpConst == null || (str7 = iHttpConst.getONLINE_HOST()) == null) {
            str7 = "";
        }
        ONLINE_HOST = str7;
        if (iHttpConst == null || (str8 = iHttpConst.getONLINE_HOST_API()) == null) {
            str8 = "";
        }
        ONLINE_HOST_API = str8;
        if (iHttpConst == null || (str9 = iHttpConst.getONLINE()) == null) {
            str9 = "";
        }
        ONLINE = str9;
        if (iHttpConst == null || (str10 = iHttpConst.getONLINE_API()) == null) {
            str10 = "";
        }
        ONLINE_API = str10;
        if (iHttpConst == null || (str11 = iHttpConst.getBOE_HOST()) == null) {
            str11 = "";
        }
        BOE_HOST = str11;
        if (iHttpConst == null || (str12 = iHttpConst.getBOE()) == null) {
            str12 = "";
        }
        BOE = str12;
        if (iHttpConst == null || (str13 = iHttpConst.getSAMI_WSS_HOST()) == null) {
            str13 = "";
        }
        SAMI_WSS_HOST = str13;
        if (iHttpConst == null || (str14 = iHttpConst.getSAMI_WSS_QUIC_HOST()) == null) {
            str14 = "";
        }
        SAMI_WSS_QUIC_HOST = str14;
        if (iHttpConst == null || (str15 = iHttpConst.getSHARE_PASSPORT_LOGIN_TOKEN()) == null) {
            str15 = "";
        }
        SHARE_PASSPORT_LOGIN_TOKEN = str15;
        if (iHttpConst == null || (str16 = iHttpConst.getMSSDK_PASSPORT_TOKEN()) == null) {
            str16 = "";
        }
        MSSDK_PASSPORT_TOKEN = str16;
        if (iHttpConst == null || (str17 = iHttpConst.getMSSDK_PASSPORT_TOKEN_Z()) == null) {
            str17 = "";
        }
        MSSDK_PASSPORT_TOKEN_Z = str17;
        if (iHttpConst == null || (str18 = iHttpConst.getPRAISE_DIALOG_SDK_HOST()) == null) {
            str18 = "";
        }
        PRAISE_DIALOG_SDK_HOST = str18;
        if (iHttpConst == null || (str19 = iHttpConst.getCOZE_PLATFORM_HOST()) == null) {
            str19 = "";
        }
        COZE_PLATFORM_HOST = str19;
        if (iHttpConst == null || (str20 = iHttpConst.getASSIST_CENTER_HOST()) == null) {
            str20 = "";
        }
        ASSIST_CENTER_HOST = str20;
        if (iHttpConst == null || (str21 = iHttpConst.getAI_APPLET_JSB_HOST()) == null) {
            str21 = "";
        }
        AI_APPLET_JSB_HOST = str21;
        if (iHttpConst == null || (str22 = iHttpConst.getBAIKE_JSB_HOST()) == null) {
            str22 = "";
        }
        BAIKE_JSB_HOST = str22;
        if (iHttpConst == null || (str23 = iHttpConst.getFEEDBACK_BASE_URL()) == null) {
            str23 = "";
        }
        FEEDBACK_BASE_URL = str23;
        if (iHttpConst == null || (str24 = iHttpConst.getFEEDBACK_SOURCE_LOGIN()) == null) {
            str24 = "";
        }
        FEEDBACK_SOURCE_LOGIN = str24;
        if (iHttpConst == null || (str25 = iHttpConst.getFEEDBACK_SOURCE_SETTING()) == null) {
            str25 = "";
        }
        FEEDBACK_SOURCE_SETTING = str25;
        if (iHttpConst == null || (str26 = iHttpConst.getFEEDBACK_SOURCE_PAYMENT()) == null) {
            str26 = "";
        }
        FEEDBACK_SOURCE_PAYMENT = str26;
        if (iHttpConst == null || (str27 = iHttpConst.getFEEDBACK_SOURCE_PRAISE()) == null) {
            str27 = "";
        }
        FEEDBACK_SOURCE_PRAISE = str27;
        if (iHttpConst == null || (str28 = iHttpConst.getConfigLibraUrl()) == null) {
            str28 = "";
        }
        configLibraUrl = str28;
        if (iHttpConst == null || (str29 = iHttpConst.getConfigDeepLinkUrl()) == null) {
            str29 = "";
        }
        configDeepLinkUrl = str29;
        if (iHttpConst == null || (str30 = iHttpConst.getTermsUrl()) == null) {
            str30 = "";
        }
        termsUrl = str30;
        if (iHttpConst == null || (str31 = iHttpConst.getPrivacyUrl()) == null) {
            str31 = "";
        }
        privacyUrl = str31;
        if (iHttpConst == null || (str32 = iHttpConst.getPrivacyAccountUrl()) == null) {
            str32 = "";
        }
        privacyAccountUrl = str32;
        if (iHttpConst == null || (str33 = iHttpConst.getPrivacyAbsUrl()) == null) {
            str33 = "";
        }
        privacyAbsUrl = str33;
        if (iHttpConst == null || (str34 = iHttpConst.getMemoryFaqUrl()) == null) {
            str34 = "";
        }
        memoryFaqUrl = str34;
        if (iHttpConst == null || (str35 = iHttpConst.getLegalFaqUrl()) == null) {
            str35 = "";
        }
        legalFaqUrl = str35;
        if (iHttpConst == null || (str36 = iHttpConst.getFaceMemoryPrivacyUrl()) == null) {
            str36 = "";
        }
        faceMemoryPrivacyUrl = str36;
        if (iHttpConst == null || (str37 = iHttpConst.getPrivacyNewUrl()) == null) {
            str37 = "";
        }
        privacyNewUrl = str37;
        if (iHttpConst == null || (str38 = iHttpConst.getONLINE_RTC_SERVER_MESSAGE_DOMAIN()) == null) {
            str38 = "";
        }
        ONLINE_RTC_SERVER_MESSAGE_DOMAIN = str38;
        if (iHttpConst == null || (str39 = iHttpConst.getTEST_RTC_SERVER_MESSAGE_DOMAIN()) == null) {
            str39 = "";
        }
        TEST_RTC_SERVER_MESSAGE_DOMAIN = str39;
        if (iHttpConst == null || (str40 = iHttpConst.getALICE_BOE_HOST()) == null) {
            str40 = "";
        }
        ALICE_BOE_HOST = str40;
        if (iHttpConst == null || (str41 = iHttpConst.getACCOUNTT_BOE_HOST()) == null) {
            str41 = "";
        }
        ACCOUNTT_BOE_HOST = str41;
        if (iHttpConst == null || (str42 = iHttpConst.getAccountSettingUrl()) == null) {
            str42 = "";
        }
        accountSettingUrl = str42;
        if (iHttpConst == null || (str43 = iHttpConst.getDeviceManagementUrl()) == null) {
            str43 = "";
        }
        deviceManagementUrl = str43;
        if (iHttpConst == null || (str44 = iHttpConst.getPersonUrl()) == null) {
            str44 = "";
        }
        personUrl = str44;
        if (iHttpConst == null || (str45 = iHttpConst.getDenoisePrivacyUrl()) == null) {
            str45 = "";
        }
        denoisePrivacyUrl = str45;
        if (iHttpConst == null || (str46 = iHttpConst.getAccessibilitySdkDebugUrl()) == null) {
            str46 = "";
        }
        accessibilitySdkDebugUrl = str46;
        if (iHttpConst == null || (str47 = iHttpConst.getDoubaoOfficialWebsite()) == null) {
            str47 = "";
        }
        doubaoOfficialWebsite = str47;
        if (iHttpConst == null || (str48 = iHttpConst.getToutiaoArticleUrl()) == null) {
            str48 = "";
        }
        toutiaoArticleUrl = str48;
        if (iHttpConst == null || (emptyList = iHttpConst.getAuthorizationWhiteList()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        authorizationWhiteList = emptyList;
        IHttpConst iHttpConst2 = inst;
        if (iHttpConst2 == null || (str49 = iHttpConst2.getAvatarOnboardingVideoModelString()) == null) {
            str49 = "";
        }
        avatarOnboardingVideoModelString = str49;
        if (iHttpConst2 == null || (str50 = iHttpConst2.getAvatarOnboardingVideoCoverUrl()) == null) {
            str50 = "";
        }
        avatarOnboardingVideoCoverUrl = str50;
        if (iHttpConst2 == null || (str51 = iHttpConst2.getAvatarTutorialAudioUrl()) == null) {
            str51 = "";
        }
        avatarTutorialAudioUrl = str51;
        if (iHttpConst2 != null && (loggingDLPUrl2 = iHttpConst2.getLoggingDLPUrl()) != null) {
            str52 = loggingDLPUrl2;
        }
        loggingDLPUrl = str52;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE_BASE_HOST() {
        return ONLINE_BASE_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE_BASE_HOST_API() {
        return ONLINE_BASE_HOST_API;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE_WWW_HOST() {
        return ONLINE_WWW_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE_WWW_HOST_API() {
        return ONLINE_WWW_HOST_API;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE_WWW() {
        return ONLINE_WWW;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE_WWW_API() {
        return ONLINE_WWW_API;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE_HOST() {
        return ONLINE_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE_HOST_API() {
        return ONLINE_HOST_API;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE() {
        return ONLINE;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE_API() {
        return ONLINE_API;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getBOE_HOST() {
        return BOE_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getBOE() {
        return BOE;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getSAMI_WSS_HOST() {
        return SAMI_WSS_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getSAMI_WSS_QUIC_HOST() {
        return SAMI_WSS_QUIC_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getSHARE_PASSPORT_LOGIN_TOKEN() {
        return SHARE_PASSPORT_LOGIN_TOKEN;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getMSSDK_PASSPORT_TOKEN() {
        return MSSDK_PASSPORT_TOKEN;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getMSSDK_PASSPORT_TOKEN_Z() {
        return MSSDK_PASSPORT_TOKEN_Z;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getPRAISE_DIALOG_SDK_HOST() {
        return PRAISE_DIALOG_SDK_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getCOZE_PLATFORM_HOST() {
        return COZE_PLATFORM_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getASSIST_CENTER_HOST() {
        return ASSIST_CENTER_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getAI_APPLET_JSB_HOST() {
        return AI_APPLET_JSB_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getBAIKE_JSB_HOST() {
        return BAIKE_JSB_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getFEEDBACK_BASE_URL() {
        return FEEDBACK_BASE_URL;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getFEEDBACK_SOURCE_LOGIN() {
        return FEEDBACK_SOURCE_LOGIN;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getFEEDBACK_SOURCE_SETTING() {
        return FEEDBACK_SOURCE_SETTING;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getFEEDBACK_SOURCE_PAYMENT() {
        return FEEDBACK_SOURCE_PAYMENT;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getFEEDBACK_SOURCE_PRAISE() {
        return FEEDBACK_SOURCE_PRAISE;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getConfigLibraUrl() {
        return configLibraUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getConfigDeepLinkUrl() {
        return configDeepLinkUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getTermsUrl() {
        return termsUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getPrivacyUrl() {
        return privacyUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getPrivacyAccountUrl() {
        return privacyAccountUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getPrivacyAbsUrl() {
        return privacyAbsUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getMemoryFaqUrl() {
        return memoryFaqUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getLegalFaqUrl() {
        return legalFaqUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getFaceMemoryPrivacyUrl() {
        return faceMemoryPrivacyUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getPrivacyNewUrl() {
        return privacyNewUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getONLINE_RTC_SERVER_MESSAGE_DOMAIN() {
        return ONLINE_RTC_SERVER_MESSAGE_DOMAIN;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getTEST_RTC_SERVER_MESSAGE_DOMAIN() {
        return TEST_RTC_SERVER_MESSAGE_DOMAIN;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String secLink() {
        String secLink;
        IHttpConst iHttpConst = inst;
        return (iHttpConst == null || (secLink = iHttpConst.secLink()) == null) ? "" : secLink;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getALICE_BOE_HOST() {
        return ALICE_BOE_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getACCOUNTT_BOE_HOST() {
        return ACCOUNTT_BOE_HOST;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getAccountSettingUrl() {
        return accountSettingUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getDeviceManagementUrl() {
        return deviceManagementUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getPersonUrl() {
        return personUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getDenoisePrivacyUrl() {
        return denoisePrivacyUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getAccessibilitySdkDebugUrl() {
        return accessibilitySdkDebugUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getDoubaoOfficialWebsite() {
        return doubaoOfficialWebsite;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getToutiaoArticleUrl() {
        return toutiaoArticleUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public List<String> getAuthorizationWhiteList() {
        return authorizationWhiteList;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getAvatarOnboardingVideoModelString() {
        return avatarOnboardingVideoModelString;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getAvatarOnboardingVideoCoverUrl() {
        return avatarOnboardingVideoCoverUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getAvatarTutorialAudioUrl() {
        return avatarTutorialAudioUrl;
    }

    @Override // com.bytedance.trae.network.IHttpConst
    public String getLoggingDLPUrl() {
        return loggingDLPUrl;
    }
}
