package com.bytedance.bdturing.ttnet;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.net.CommonResponse;
import com.bytedance.bdturing.utils.Consts;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TuringCommonRequest {
    private static final String DEFAULT_CONTENT_TYPE = "application/json; charset=utf-8";
    public static final int DEFAULT_ERROR_CODE = -9999;
    private JSONObject mBodyData;
    private Map<String, String> mBodyParams;
    private Map<String, String> mHeader;
    private Map<String, String> mQueryParam;
    private String mUrl;

    public TuringCommonRequest(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, Map<String, String> map3) {
        this.mUrl = str;
        this.mQueryParam = map;
        this.mBodyParams = map2;
        this.mBodyData = jSONObject;
        map3 = map3 == null ? new HashMap<>() : map3;
        this.mHeader = map3;
        if (map3.containsKey("Content-Type")) {
            return;
        }
        this.mHeader.put("Content-Type", "application/json; charset=utf-8");
    }

    public TuringCommonRequest(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        this(str, map, map2, null, map3);
    }

    public HttpClient getHttpClient() {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        if (config != null) {
            return config.getHttpClient();
        }
        return null;
    }

    public String appendUrlParams(String str, Map<String, String> map) {
        Map<String, String> commonParams = getCommonParams();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                commonParams.put(str2, map.get(str2));
            }
        }
        if (commonParams == null || commonParams.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : commonParams.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), entry.getValue()));
        }
        sb.append(NetworkUtils.format(arrayList, UrlUtils.UTF_8));
        return sb.toString();
    }

    public void doGet(final ITuringNetworkCallBack iTuringNetworkCallBack) {
        try {
            String appendUrlParams = appendUrlParams(this.mUrl, this.mQueryParam);
            addColorHeader(appendUrlParams, this.mHeader);
            ((ITuringNetworkApi) RetrofitUtils.getSsRetrofit(appendUrlParams).create(ITuringNetworkApi.class)).doGet(true, appendUrlParams, null, null).enqueue(new Callback<String>() { // from class: com.bytedance.bdturing.ttnet.TuringCommonRequest.1
                public void onResponse(Call<String> call, SsResponse<String> ssResponse) {
                    if (iTuringNetworkCallBack != null) {
                        String readResponse = TuringCommonRequest.this.readResponse(ssResponse);
                        try {
                            if (!TextUtils.isEmpty(readResponse)) {
                                JSONObject jSONObject = new JSONObject(readResponse);
                                CommonResponse commonResponse = new CommonResponse();
                                commonResponse.code = jSONObject.optInt(AlogMonitor.ALOG_RESULT_CODE, TuringCommonRequest.DEFAULT_ERROR_CODE);
                                commonResponse.data = jSONObject.optJSONObject("data");
                                commonResponse.message = jSONObject.optString("message");
                                iTuringNetworkCallBack.onResponse(commonResponse);
                            } else {
                                iTuringNetworkCallBack.onError(new Throwable("body is empty"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            ITuringNetworkCallBack iTuringNetworkCallBack2 = iTuringNetworkCallBack;
                            if (iTuringNetworkCallBack2 != null) {
                                iTuringNetworkCallBack2.onError(e);
                            }
                        }
                    }
                }

                public void onFailure(Call<String> call, Throwable th) {
                    ITuringNetworkCallBack iTuringNetworkCallBack2 = iTuringNetworkCallBack;
                    if (iTuringNetworkCallBack2 != null) {
                        iTuringNetworkCallBack2.onError(th);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (iTuringNetworkCallBack != null) {
                iTuringNetworkCallBack.onError(e);
            }
        }
    }

    public void doPost(final ITuringNetworkCallBack iTuringNetworkCallBack) {
        try {
            String appendUrlParams = appendUrlParams(this.mUrl, this.mQueryParam);
            addColorHeader(appendUrlParams, this.mHeader);
            JSONObject jSONObject = this.mBodyData;
            if (jSONObject == null) {
                jSONObject = buildRequestBody(this.mBodyParams);
            }
            final byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
            ((ITuringNetworkApi) RetrofitUtils.getSsRetrofit(appendUrlParams).create(ITuringNetworkApi.class)).doPost(appendUrlParams, null, new TypedOutput() { // from class: com.bytedance.bdturing.ttnet.TuringCommonRequest.2
                public String fileName() {
                    return null;
                }

                public String md5Stub() {
                    return null;
                }

                public String mimeType() {
                    return null;
                }

                public long length() {
                    return bytes.length;
                }

                public void writeTo(OutputStream outputStream) throws IOException {
                    outputStream.write(bytes);
                }
            }, TTNetUtil.toHeaderList(this.mHeader)).enqueue(new Callback<String>() { // from class: com.bytedance.bdturing.ttnet.TuringCommonRequest.3
                public void onResponse(Call<String> call, SsResponse<String> ssResponse) {
                    if (iTuringNetworkCallBack != null) {
                        try {
                            String readResponse = TuringCommonRequest.this.readResponse(ssResponse);
                            if (!TextUtils.isEmpty(readResponse)) {
                                JSONObject jSONObject2 = new JSONObject(readResponse);
                                CommonResponse commonResponse = new CommonResponse();
                                commonResponse.code = jSONObject2.optInt(AlogMonitor.ALOG_RESULT_CODE, TuringCommonRequest.DEFAULT_ERROR_CODE);
                                commonResponse.message = jSONObject2.optString("message");
                                commonResponse.sec_message = jSONObject2.optString("sec_message");
                                commonResponse.data = jSONObject2.optJSONObject("data");
                                iTuringNetworkCallBack.onResponse(commonResponse);
                            } else {
                                iTuringNetworkCallBack.onError(new Throwable("body is Empty"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            iTuringNetworkCallBack.onError(e);
                        }
                    }
                }

                public void onFailure(Call<String> call, Throwable th) {
                    ITuringNetworkCallBack iTuringNetworkCallBack2 = iTuringNetworkCallBack;
                    if (iTuringNetworkCallBack2 != null) {
                        iTuringNetworkCallBack2.onError(th);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (iTuringNetworkCallBack != null) {
                iTuringNetworkCallBack.onError(e);
            }
        }
    }

    private void addColorHeader(String str, Map<String, String> map) {
        try {
            Context applicationContext = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getApplicationContext() : null;
            if (applicationContext != null) {
                TrafficColorHelper.addColorToHeader(applicationContext, str, map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a A[Catch: Exception -> 0x0076, TRY_LEAVE, TryCatch #4 {Exception -> 0x0076, blocks: (B:51:0x0072, B:44:0x007a), top: B:50:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String readResponse(SsResponse<String> ssResponse) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        Exception e;
        if (ssResponse.code() == 200) {
            try {
                inputStream = ssResponse.raw().getBody().in();
            } catch (Exception e2) {
                byteArrayOutputStream = null;
                e = e2;
                inputStream = null;
            } catch (Throwable th2) {
                byteArrayOutputStream = null;
                th = th2;
                inputStream = null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        String str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return str;
                            }
                        }
                        byteArrayOutputStream.close();
                        return str;
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return "";
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                byteArrayOutputStream = null;
                e = e7;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        }
        return "";
    }

    private Map<String, String> getCommonParams() {
        HashMap hashMap = new HashMap();
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        if (config != null) {
            hashMap.put("aid", config.getAppId());
            hashMap.put("lang", config.getLanguage());
            hashMap.put(Api.KEY_APP_NAME, config.getAppName());
            hashMap.put("locale", config.getLocale());
            hashMap.put("channel", config.getChannel());
            hashMap.put("ch", config.getChannel());
            hashMap.put(WsConstants.KEY_APP_KEY, config.getAppKey());
            hashMap.put("iid", config.getInstallId());
            hashMap.put("did", config.getDeviceId());
            hashMap.put("vc", config.getAppVersion());
            hashMap.put("app_version", config.getAppVersion());
            hashMap.put("region", config.getRegionType().getName());
            Activity topActivity = config.getTopActivity();
            hashMap.put("resolution", UtilsKt.getResolution());
            hashMap.put(EventReport.SCREEN_ORIENTATION, "" + UtilsKt.getCurrentOrientation(topActivity));
            hashMap.put("sdk_version", "4.1.1.cn");
            hashMap.put("os_version", Consts.SYSTEM_VERSION);
            hashMap.put("device_brand", Consts.DEVICE_BRAND);
            hashMap.put("device_model", Consts.DEVICE_MODEL);
            hashMap.put("os_name", Consts.OS_NAME);
            hashMap.put("version_code", config.getAppVersionCode());
            hashMap.put("version_name", config.getAppVersion());
            hashMap.put(Api.KEY_DEVICE_TYPE, Consts.DEVICE_MODEL);
            hashMap.put("device_platform", Consts.OS_NAME);
            hashMap.put("os_type", "0");
        }
        return hashMap;
    }

    private JSONObject buildRequestBody(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
