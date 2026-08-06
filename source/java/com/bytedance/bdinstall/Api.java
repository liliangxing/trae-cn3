package com.bytedance.bdinstall;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.bdinstall.network.TTResponse;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Api {
    public static final String KEY_ABFLAG = "abflag";
    public static final String KEY_AB_CLIENT = "ab_client";
    public static final String KEY_AB_FEATURE = "ab_feature";
    public static final String KEY_AB_GROUP = "ab_group";
    public static final String KEY_AB_VERSION = "ab_version";
    public static final String KEY_AC = "ac";
    public static final String KEY_ACCESS = "access";
    public static final String KEY_AID = "aid";
    public static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    public static final String KEY_APPKEY = "appkey";
    public static final String KEY_APP_LANGUAGE = "app_language";
    public static final String KEY_APP_NAME = "app_name";
    public static final String KEY_APP_REGION = "app_region";
    public static final String KEY_APP_TRACK = "app_track";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_APP_VERSION_MINOR = "app_version_minor";
    public static final String KEY_BASIC_CONTEXT = "basic_context";
    public static final String KEY_BD_DID = "bd_did";
    public static final String KEY_BUILD_SERIAL = "build_serial";
    public static final String KEY_CARRIER = "carrier";
    public static final String KEY_CD = "cd";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CLEAR_KEY_PREFIX = "clear_key_prefix";
    public static final String KEY_CPU_ABI = "cpu_abi";
    public static final String KEY_CUSTOM = "custom";
    public static final String KEY_C_UDID = "clientudid";
    public static final String KEY_DENSITY_DPI = "density_dpi";
    public static final String KEY_DEVICE_BRAND = "device_brand";
    public static final String KEY_DEVICE_CATEGORY = "device_category";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_DEVICE_MANUFACTURER = "device_manufacturer";
    public static final String KEY_DEVICE_MODEL = "device_model";
    public static final String KEY_DEVICE_PLATFORM = "device_platform";
    public static final String KEY_DEVICE_TOKEN = "device_token";
    public static final String KEY_DEVICE_TYPE = "device_type";
    public static final String KEY_DISPLAY_DENSITY = "display_density";
    public static final String KEY_DISPLAY_NAME = "display_name";
    public static final String KEY_DPI = "dpi";
    public static final String KEY_ENCRYPT_DID = "klink_edi";
    public static final String KEY_ENCRYPT_IID = "klink_eii";
    public static final String KEY_EXTERNAL_DERECTORY_DEVICE_PARAMETER = "ZQLiNFJR+CWEI4px";
    public static final String KEY_GOOGLE_AID = "google_aid";
    public static final String KEY_GOOGLE_AID_LIMIT = "gaid_limited";
    public static final String KEY_HEADER = "header";
    public static final String KEY_HTTP_CODE = "HttpCode";
    public static final String KEY_IID = "iid";
    public static final String KEY_INSTALL_ID = "install_id";
    public static final String KEY_KLINK_EGDI = "klink_egdi";
    public static final String KEY_LANGUAGE = "language";
    public static final String KEY_MAC_ADDRESS = "mac_address";
    public static final String KEY_MAGIC = "magic_tag";
    public static final String KEY_MANIFEST_VERSION_CODE = "manifest_version_code";
    public static final String KEY_MCC_MNC = "mcc_mnc";
    private static final String KEY_MSG = "message";
    public static final String KEY_NEW_USER = "new_user";
    public static final String KEY_NEW_USER_MODE = "new_user_mode";
    public static final String KEY_NOT_REQUEST_SENDER = "not_request_sender";
    public static final String KEY_OLD_DID = "old_did";
    public static final String KEY_OPEN_UDID = "openudid";
    public static final String KEY_OS = "os";
    public static final String KEY_OS_API = "os_api";
    public static final String KEY_OS_VERSION = "os_version";
    public static final String KEY_PACKAGE = "package";
    public static final String KEY_PICO_SN = "pico_sn";
    public static final String KEY_REAL_PACKAGE_NAME = "real_package_name";
    public static final String KEY_REGION = "region";
    public static final String KEY_REGISTER_CUSTOM = "register_custom";
    public static final String KEY_REGISTER_TIME = "register_time";
    public static final String KEY_RELEASE_BUILD = "release_build";
    public static final String KEY_RESOLUTION = "resolution";
    public static final String KEY_ROM = "rom";
    public static final String KEY_ROM_VERSION = "rom_version";
    public static final String KEY_RTICKET = "_rticket";
    public static final String KEY_SDK_TARGET_VERSION = "sdk_target_version";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SDK_VERSION_CODE = "sdk_version_code";
    public static final String KEY_SECURITY_CONTEXT = "security_context";
    public static final String KEY_SERIAL_NUMBER = "serial_number";
    public static final String KEY_SET_COOKIE = "Set-Cookie";
    public static final String KEY_SIG_HASH = "sig_hash";
    public static final String KEY_SIM_REGION = "sim_region";
    public static final String KEY_SIM_SERIAL_NUMBER = "sim_serial_number";
    public static final String KEY_SSID = "ssid";
    public static final String KEY_SSMIX = "ssmix";
    public static final String KEY_STARTED = "_install_started_v2";
    public static final String KEY_TICKET = "ticket";
    public static final String KEY_TICKET_APP_ID = "app_id";
    public static final String KEY_TICKET_DEVICE_ID = "device_id";
    public static final String KEY_TICKET_INSTALL_ID = "installation_id";
    public static final String KEY_TIMEZONE = "timezone";
    public static final String KEY_TS_SIGN = "ts_sign";
    private static final String KEY_TT_INFO = "tt_info";
    public static final String KEY_TWEAKED_CHANNEL = "tweaked_channel";
    public static final String KEY_TZ_NAME = "tz_name";
    public static final String KEY_TZ_OFFSET = "tz_offset";
    public static final String KEY_UPDATE_VERSION_CODE = "update_version_code";
    public static final String KEY_USER_AGENT = "user_agent";
    public static final String KEY_USER_UNIQUE_ID = "user_unique_id";
    public static final String KEY_UUID = "uuid";
    public static final String KEY_VERSION_CODE = "version_code";
    public static final String KEY_VERSION_NAME = "version_name";
    public static final String MSG_MAGIC = "ss_app_log";
    private static final String MSG_OK = "success";
    public static final String REQ_ID = "req_id";
    public static final String SP_KEY_BD_DID = "bd_did";
    public static final String SP_KEY_C_UDID = "clientudid";
    public static final String SP_KEY_DEVICE_ID = "device_id";
    public static final String SP_KEY_DEVICE_TOKEN = "device_token";
    public static final String SP_KEY_GOOGLE_AD_LIMITED = "gaid_limited";
    public static final String SP_KEY_GOOGLE_AID = "google_aid";
    public static final String SP_KEY_INSTALL_ID = "install_id";
    public static final String SP_KEY_IS_ACTIVATED = "is_activated";
    public static final String SP_KEY_IS_FIRST_ACTIVATE_FOR_APP = "is_first_activate_for_app";
    public static final String SP_KEY_IS_FIRST_REGISTER_FOR_APP = "is_first_register_for_app";
    public static final String SP_KEY_IS_MIGRATE = "is_migrate";
    public static final String SP_KEY_OLD_DID = "old_did";
    public static final String SP_KEY_OPEN_UDID = "openudid";
    public static final String SP_KEY_SERIAL_NUMBER = "serial_number";
    private static final String KEY_TT_DATA = "tt_data";
    private static final String[] KEYS_PLAINTEXT = {"aid", "app_version", KEY_TT_DATA, "device_id", "bd_did"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static TTResponse register(INetworkClient iNetworkClient, INetworkClientWrapper iNetworkClientWrapper, String str, JSONObject jSONObject, boolean z, IEncryptor iEncryptor, boolean z2, List<Pair<String, String>> list) {
        HashMap<String, String> createHeader = createHeader(z, z2);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Pair<String, String> pair = list.get(i);
                createHeader.put(pair.first, pair.second);
            }
        }
        TTResponse tTResponse = null;
        try {
            byte[] transformStrToByte = transformStrToByte(jSONObject.toString(), z, iEncryptor);
            if (transformStrToByte != null && z) {
                str = str + "&tt_data=a";
            }
            if (iNetworkClientWrapper != null) {
                TTResponse post = iNetworkClientWrapper.post(str, transformStrToByte, createHeader);
                DrLog.m139d("ticket network client is ready. response is " + post);
                return post;
            }
            TTResponse tTResponse2 = new TTResponse(str, 200, null, iNetworkClient.post(str, transformStrToByte, createHeader));
            try {
                DrLog.m139d("network client is ready. response is " + tTResponse2);
                return tTResponse2;
            } catch (Exception e) {
                e = e;
                tTResponse = tTResponse2;
                DrLog.m141e("Register#doRegister http error = ", e);
                e.printStackTrace();
                return tTResponse;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean verify(INetworkClient iNetworkClient, INetworkClientWrapper iNetworkClientWrapper, String str, JSONObject jSONObject, boolean z, IEncryptor iEncryptor, boolean z2, List<Pair<String, String>> list) {
        TTResponse tTResponse;
        HashMap<String, String> createHeader = createHeader(z, z2);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                createHeader.put(list.get(i).first, list.get(i).second);
            }
        }
        DrLog.m139d("TicketGuard# [before verify] add headers " + createHeader);
        JSONObject jSONObject2 = null;
        try {
            byte[] transformStrToByte = transformStrToByte(jSONObject.toString(), z, iEncryptor);
            if (transformStrToByte != null && z) {
                str = str + "&tt_data=a";
            }
            if (iNetworkClientWrapper != null) {
                tTResponse = iNetworkClientWrapper.post(str, transformStrToByte, createHeader);
                DrLog.m139d("ticket network client is ready. response is " + tTResponse);
            } else {
                TTResponse tTResponse2 = new TTResponse(str, 200, null, iNetworkClient.post(str, transformStrToByte, createHeader));
                DrLog.m139d(" network client is ready. response is " + tTResponse2);
                tTResponse = tTResponse2;
            }
            if (tTResponse != null) {
                jSONObject2 = new JSONObject(tTResponse.getBody());
            }
        } catch (Exception e) {
            DrLog.m141e("TicketGuard# doVerify http error = ", e);
            e.printStackTrace();
        }
        return jSONObject2 != null && "success".equals(jSONObject2.optString("message", ""));
    }

    private static String encryptUrl(String str, boolean z, IEncryptor iEncryptor) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : KEYS_PLAINTEXT) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (Pair pair : arrayList) {
            buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        buildUpon.appendQueryParameter(KEY_TT_INFO, new String(Base64.encode(transformStrToByte(query, z, iEncryptor), 8)));
        return buildUpon.build().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean active(INetworkClient iNetworkClient, INetworkClientWrapper iNetworkClientWrapper, String str, boolean z, IEncryptor iEncryptor, boolean z2) {
        TTResponse tTResponse;
        StringBuilder sb = new StringBuilder(str);
        HashMap<String, String> buildHeader = buildHeader(z2);
        JSONObject jSONObject = null;
        try {
            if (iNetworkClientWrapper != null) {
                tTResponse = iNetworkClientWrapper.get(encryptUrl(sb.toString(), z, iEncryptor), buildHeader);
                try {
                    DrLog.m139d("ticket network client is ready. response is " + tTResponse);
                } catch (Exception e) {
                    e = e;
                    DrLog.m141e("active http error = ", e);
                    e.printStackTrace();
                    if (tTResponse != null) {
                    }
                    if (jSONObject == null) {
                    }
                }
            } else {
                TTResponse tTResponse2 = new TTResponse(str, 200, null, iNetworkClient.get(encryptUrl(sb.toString(), z, iEncryptor), buildHeader));
                try {
                    DrLog.m139d("network client is ready. response is " + tTResponse2);
                    tTResponse = tTResponse2;
                } catch (Exception e2) {
                    e = e2;
                    tTResponse = tTResponse2;
                    DrLog.m141e("active http error = ", e);
                    e.printStackTrace();
                    if (tTResponse != null) {
                    }
                    if (jSONObject == null) {
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            tTResponse = null;
        }
        if (tTResponse != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(tTResponse.getBody());
                try {
                    DrLog.m139d("active response body " + jSONObject2);
                    jSONObject = jSONObject2;
                } catch (JSONException e4) {
                    e = e4;
                    jSONObject = jSONObject2;
                    DrLog.m141e("active parse json error " + tTResponse + ", ", e);
                    e.printStackTrace();
                    if (jSONObject == null) {
                    }
                }
            } catch (JSONException e5) {
                e = e5;
            }
        }
        return jSONObject == null && "success".equals(jSONObject.optString("message", ""));
    }

    private static byte[] transformStrToByte(String str, boolean z, IEncryptor iEncryptor) {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                if (z) {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes(UrlUtils.UTF_8));
                        gZIPOutputStream = gZIPOutputStream2;
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        try {
                            DrLog.ysnp(th);
                            if (gZIPOutputStream != null) {
                                gZIPOutputStream.close();
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            return !z ? byteArray : byteArray;
                        } catch (Throwable th2) {
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e) {
                                    DrLog.ysnp(e);
                                }
                            }
                            throw th2;
                        }
                    }
                } else {
                    byteArrayOutputStream.write(str.getBytes(UrlUtils.UTF_8));
                }
            } catch (IOException e2) {
                DrLog.ysnp(e2);
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (gZIPOutputStream != null) {
            gZIPOutputStream.close();
        }
        byteArray = byteArrayOutputStream.toByteArray();
        if (!z && iEncryptor != null) {
            return iEncryptor.encrypt(byteArray, byteArray.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addParams(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (sb.toString().indexOf(63) < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append(str).append("=").append(Uri.encode(str2));
    }

    private static HashMap<String, String> createHeader(boolean z, boolean z2) {
        HashMap<String, String> buildHeader = buildHeader(z2);
        if (z) {
            buildHeader.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            buildHeader.put("Content-Type", "application/json; charset=utf-8");
        }
        return buildHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> buildHeader(final boolean z) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.bdinstall.Api.1
                public int triggerType() {
                    return 0;
                }

                public boolean markAsNewUser() {
                    return !z;
                }
            });
            if (buildBDNetworkTag != null) {
                hashMap.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }
}
