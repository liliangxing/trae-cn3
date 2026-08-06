package com.bytedance.bdturing.methods;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.PreCreateManager;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.ttnet.HttpClient;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class VerifyDialogHandler implements IVerifyInnerHandler {
    public static final String CLOSE_WEB = "bytedcert.close_web";
    public static final String CONFIRM_DIALOG_SIZE = "bytedcert.confirm_dialog_size";
    public static final String DIALOG_SIZE = "bytedcert.dialogSize";
    public static final String DIALOG_SIZE_V2 = "bytedcert.dialogSize_V2";
    public static final String EVENT_TO_NATIVE = "bytedcert.eventToNative";
    public static final String GET_SETTINGS = "bytedcert.getSettings";
    public static final String GET_TOUCH = "bytedcert.getTouch";
    public static final String H5_AVAILABLE = "bytedcert.h5_available";
    public static final String H5_GET_SENSOR = "bytedcert.getSensor";
    public static final String H5_STATE_CHANGED = "bytedcert.h5_state_changed";
    public static final String NATIVE_REQUEST = "bytedcert.network.request";
    public static final String NEW_WEB_RESULT = "bytedcert.web_result";
    public static final String OPEN_NEW_WEB = "bytedcert.open_new_web";
    public static final String OPEN_NEW_WEB_RESULT = "bytedcert.new_web_result";
    public static final String PAGE_END = "bytedcert.pageEnd";
    public static final String PRELOAD_VERIFY_FINISH = "bytedcert.preLoadVerifyFinish";
    public static final String READY_VIEW = "bytedcert.readyView";
    public static final String REFRESH_VERIFY_VIEW_FINISH = "bytedcert.refreshVerifyViewFinish";
    public static final String SDK_INFO = "bytedcert.getSdkInfo";
    public static final String VERIFY = "bytedcert.verify";
    public static final String VERIFY_CONFIRM_RESULT = "bytedcert.verify_confirm_result";
    public static final String VERIFY_RESULT = "bytedcert.verifyResult";

    public void clearDialogResource() {
    }

    public void closeWeb() {
    }

    public void getSdkInfo(JsCallParser jsCallParser) {
    }

    public void getSensorData(JsCallParser jsCallParser) {
    }

    public void getSettings(JsCallParser jsCallParser) {
    }

    public void onH5Available() {
    }

    public void onSetDialogSize(int i, int i2, boolean z) {
    }

    public void onSetDialogSizeV2(int i, int i2, boolean z) {
    }

    public void onVerify(String str, BdTuringCallback bdTuringCallback) {
    }

    public void onVerifyResult(int i, String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
    }

    public void onWebResult(String str) {
    }

    public void openNewWeb(String str, String str2) {
    }

    public void uploadSmarterData() {
    }

    public void verifyConfirmResult(int i, String str) {
    }

    @Override // com.bytedance.bdturing.methods.IVerifyInnerHandler
    public void handle(final JsCallParser jsCallParser) {
        char c;
        try {
            String str = jsCallParser.mFuncName;
            switch (str.hashCode()) {
                case -1759249244:
                    if (str.equals(VERIFY_RESULT)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1628743486:
                    if (str.equals(H5_STATE_CHANGED)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1563440329:
                    if (str.equals(GET_TOUCH)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1534238297:
                    if (str.equals(VERIFY)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -1471628194:
                    if (str.equals(PAGE_END)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1366167938:
                    if (str.equals(REFRESH_VERIFY_VIEW_FINISH)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -1260067134:
                    if (str.equals(H5_GET_SENSOR)) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case -1028963129:
                    if (str.equals(PRELOAD_VERIFY_FINISH)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -985680828:
                    if (str.equals(DIALOG_SIZE_V2)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -514719849:
                    if (str.equals(DIALOG_SIZE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -440027648:
                    if (str.equals("bytedcert.getSdkInfo")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 364408852:
                    if (str.equals(VERIFY_CONFIRM_RESULT)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 385404715:
                    if (str.equals(CONFIRM_DIALOG_SIZE)) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 428780843:
                    if (str.equals("bytedcert.getSettings")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 491779646:
                    if (str.equals(EVENT_TO_NATIVE)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 755725445:
                    if (str.equals(H5_AVAILABLE)) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 1154510586:
                    if (str.equals(READY_VIEW)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1176627553:
                    if (str.equals(NATIVE_REQUEST)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1225487854:
                    if (str.equals(OPEN_NEW_WEB)) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 1762692255:
                    if (str.equals(CLOSE_WEB)) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 1861543318:
                    if (str.equals(NEW_WEB_RESULT)) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    JSONObject jSONObject = new JSONObject(jsCallParser.mParams);
                    onSetDialogSize(jSONObject.getInt("w"), jSONObject.getInt("h"), jSONObject.optBoolean("fullScreen", false));
                    return;
                case 1:
                    JSONObject jSONObject2 = new JSONObject(jsCallParser.mParams);
                    onSetDialogSizeV2(jSONObject2.getInt("w"), jSONObject2.getInt("h"), jSONObject2.optBoolean("fullScreen", false));
                    return;
                case 2:
                    VerifyTaskHandler.getInstance().sendMessage(2, jsCallParser);
                    return;
                case 3:
                    clearDialogResource();
                    return;
                case 4:
                    JSONObject jSONObject3 = new JSONObject(jsCallParser.mParams);
                    onVerifyResult(jSONObject3.optInt("result"), jSONObject3.optString("mode"), jSONObject3.optString("type"), jSONObject3.optString("token"), jSONObject3.optString("mobile"), jSONObject3.optString("decision"), jSONObject3.optJSONObject("query"));
                    return;
                case 5:
                    JSONObject jSONObject4 = new JSONObject(jsCallParser.mParams);
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = jSONObject4.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = jSONObject4.opt(next);
                        hashMap.put(next, opt != null ? opt.toString() : null);
                    }
                    return;
                case 6:
                    JSONObject jSONObject5 = new JSONObject(jsCallParser.mParams);
                    EventReport.onEvent(jSONObject5.optString("event"), jSONObject5, null);
                    return;
                case 7:
                    nativeRequest(jsCallParser);
                    return;
                case '\b':
                    getSettings(jsCallParser);
                    return;
                case '\t':
                    onVerify(new JSONObject(jsCallParser.mParams).getString("params"), new BdTuringCallback() { // from class: com.bytedance.bdturing.methods.VerifyDialogHandler.1
                        @Override // com.bytedance.bdturing.BdTuringCallback
                        public void onFail(int i, JSONObject jSONObject6) {
                            try {
                                JSONObject jSONObject7 = new JSONObject();
                                jSONObject7.put("result", i);
                                jsCallParser.response(1, jSONObject7);
                            } catch (JSONException unused) {
                            }
                        }

                        @Override // com.bytedance.bdturing.BdTuringCallback
                        public void onSuccess(int i, JSONObject jSONObject6) {
                            onFail(i, jSONObject6);
                        }
                    });
                    return;
                case '\n':
                    uploadSmarterData();
                    return;
                case 11:
                    PreCreateManager.getInstance().preCreateFinish();
                    EventReport.statisticPreCreateSuccess(System.currentTimeMillis() - PreCreateManager.getInstance().getPreCreateStartTime());
                    return;
                case '\f':
                    EventReport.statisticPreCreateLoadSuccess(System.currentTimeMillis() - PreCreateManager.getInstance().getPreCreateLoadStartTime());
                    return;
                case '\r':
                    getSdkInfo(jsCallParser);
                    return;
                case 14:
                    onH5Available();
                    return;
                case 15:
                    getSensorData(jsCallParser);
                    return;
                case 16:
                    JSONObject jSONObject6 = new JSONObject(jsCallParser.mParams);
                    verifyConfirmResult(jSONObject6.optInt("result", -1), jSONObject6.optString("url", ""));
                    return;
                case 17:
                    JSONObject jSONObject7 = new JSONObject(jsCallParser.mParams);
                    openNewWeb(jSONObject7.optString("title", ""), jSONObject7.optString("url", ""));
                    return;
                case 18:
                    closeWeb();
                    break;
                case 19:
                    break;
                case 20:
                    JSONObject jSONObject8 = new JSONObject(jsCallParser.mParams);
                    onSetDialogSize(jSONObject8.getInt("w"), jSONObject8.getInt("h"), jSONObject8.optBoolean("fullScreen", false));
                    return;
                default:
                    return;
            }
            onWebResult(jsCallParser.mParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void nativeRequest(final JsCallParser jsCallParser) {
        try {
            JSONObject jSONObject = new JSONObject(jsCallParser.mParams);
            String string = jSONObject.getString("url");
            String string2 = jSONObject.getString("method");
            JSONObject optJSONObject = jSONObject.optJSONObject("query");
            Object opt = jSONObject.opt("data");
            if (optJSONObject != null) {
                StringBuilder append = new StringBuilder(string).append("?");
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    append.append("&" + next + "=").append(optJSONObject.get(next) != null ? optJSONObject.get(next).toString() : null);
                }
                string = append.toString();
            }
            final String str = string;
            final String replaceAll = opt == null ? "" : opt.toString().replaceAll("\\\\/", "/");
            if (LogUtil.isDebug()) {
                LogUtil.m160d("CallNativeRequest", str);
            }
            final HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json; charset=utf-8");
            if (string2.equals("post")) {
                VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.methods.VerifyDialogHandler.2
                    @Override // java.lang.Runnable
                    public void run() {
                        HttpClient httpClient = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getHttpClient() : null;
                        VerifyDialogHandler.this.responseToJs(jsCallParser, httpClient != null ? new String(httpClient.post(str, hashMap, replaceAll.getBytes()), Charsets.UTF_8) : "");
                    }
                });
            } else {
                VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.methods.VerifyDialogHandler.3
                    @Override // java.lang.Runnable
                    public void run() {
                        HttpClient httpClient = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getHttpClient() : null;
                        VerifyDialogHandler.this.responseToJs(jsCallParser, httpClient != null ? new String(httpClient.get(str, hashMap), Charsets.UTF_8) : "");
                    }
                });
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void responseToJs(JsCallParser jsCallParser, String str) {
        if (LogUtil.isDebug()) {
            LogUtil.m160d("CallNativeRequest", str);
        }
        int i = !TextUtils.isEmpty(str) ? 1 : 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", str);
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            i = 0;
        }
        jsCallParser.response(i, jSONObject);
    }
}
