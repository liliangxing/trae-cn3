package com.xiaomi.push.service;

/* renamed from: com.xiaomi.push.service.an */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1756an {

    /* renamed from: A */
    public static String f3023A = "ext_auth_method";

    /* renamed from: B */
    public static String f3024B = "ext_security";

    /* renamed from: C */
    public static String f3025C = "ext_kick";

    /* renamed from: D */
    public static String f3026D = "ext_client_attr";

    /* renamed from: E */
    public static String f3027E = "ext_cloud_attr";

    /* renamed from: F */
    public static String f3028F = "ext_pkg_name";

    /* renamed from: G */
    public static String f3029G = "ext_notify_id";

    /* renamed from: H */
    public static String f3030H = "ext_clicked_button";

    /* renamed from: I */
    public static String f3031I = "ext_notify_type";

    /* renamed from: J */
    public static String f3032J = "ext_session";

    /* renamed from: K */
    public static String f3033K = "sig";

    /* renamed from: L */
    public static String f3034L = "ext_notify_title";

    /* renamed from: M */
    public static String f3035M = "ext_notify_description";

    /* renamed from: N */
    public static String f3036N = "ext_messenger";

    /* renamed from: O */
    public static String f3037O = "title";

    /* renamed from: P */
    public static String f3038P = "description";

    /* renamed from: Q */
    public static String f3039Q = "notifyId";

    /* renamed from: R */
    public static String f3040R = "dump";

    /* renamed from: a */
    public static String f3041a = "1";

    /* renamed from: b */
    public static String f3042b = "2";

    /* renamed from: c */
    public static String f3043c = "3";

    /* renamed from: d */
    public static String f3044d = "com.xiaomi.push.OPEN_CHANNEL";

    /* renamed from: e */
    public static String f3045e = "com.xiaomi.push.SEND_MESSAGE";

    /* renamed from: f */
    public static String f3046f = "com.xiaomi.push.SEND_IQ";

    /* renamed from: g */
    public static String f3047g = "com.xiaomi.push.BATCH_SEND_MESSAGE";

    /* renamed from: h */
    public static String f3048h = "com.xiaomi.push.SEND_PRES";

    /* renamed from: i */
    public static String f3049i = "com.xiaomi.push.CLOSE_CHANNEL";

    /* renamed from: j */
    public static String f3050j = "com.xiaomi.push.FORCE_RECONN";

    /* renamed from: k */
    public static String f3051k = "com.xiaomi.push.RESET_CONN";

    /* renamed from: l */
    public static String f3052l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";

    /* renamed from: m */
    public static String f3053m = "com.xiaomi.push.SEND_STATS";

    /* renamed from: n */
    public static String f3054n = "com.xiaomi.push.HANDLE_FCM_MSG";

    /* renamed from: o */
    public static String f3055o = "com.xiaomi.push.APP_NOTIFY_MSG";

    /* renamed from: p */
    public static String f3056p = "com.xiaomi.push.CHANGE_HOST";

    /* renamed from: q */
    public static String f3057q = "com.xiaomi.push.PING_TIMER";

    /* renamed from: r */
    public static String f3058r = "com.xiaomi.push.APP_CHANNEL_SWITCH";

    /* renamed from: s */
    public static String f3059s = "ext_user_id";

    /* renamed from: t */
    public static String f3060t = "ext_user_server";

    /* renamed from: u */
    public static String f3061u = "ext_user_res";

    /* renamed from: v */
    public static String f3062v = "ext_chid";

    /* renamed from: w */
    public static String f3063w = "ext_receive_time";

    /* renamed from: x */
    public static String f3064x = "ext_broadcast_time";

    /* renamed from: y */
    public static String f3065y = "ext_sid";

    /* renamed from: z */
    public static String f3066z = "ext_token";

    /* renamed from: a */
    public static String m3733a(int i) {
        switch (i) {
            case 0:
                return "ERROR_OK";
            case 1:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case 2:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case 3:
                return "ERROR_NETWORK_FAILED";
            case 4:
                return "ERROR_ACCESS_DENIED";
            case 5:
                return "ERROR_AUTH_FAILED";
            case 6:
                return "ERROR_MULTI_LOGIN";
            case 7:
                return "ERROR_SERVER_ERROR";
            case 8:
                return "ERROR_RECEIVE_TIMEOUT";
            case 9:
                return "ERROR_READ_ERROR";
            case 10:
                return "ERROR_SEND_ERROR";
            case 11:
                return "ERROR_RESET";
            case 12:
                return "ERROR_NO_CLIENT";
            case 13:
                return "ERROR_SERVER_STREAM";
            case 14:
                return "ERROR_THREAD_BLOCK";
            case 15:
                return "ERROR_SERVICE_DESTROY";
            case 16:
                return "ERROR_SESSION_CHANGED";
            case 17:
                return "ERROR_READ_TIMEOUT";
            case 18:
                return "ERROR_CONNECTIING_TIMEOUT";
            case 19:
                return "ERROR_USER_BLOCKED";
            case 20:
                return "ERROR_REDIRECT";
            case 21:
                return "ERROR_BIND_TIMEOUT";
            case 22:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i);
        }
    }
}
