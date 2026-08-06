package com.bytedance.apm.alog.net;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.util.SlardarProperties;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.ies.argus.bean.ArgusConstants;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AlogUploadService {
    public static String UPLOAD_URL = "https://mon.zijieapi.com/monitor/collect/c/logcollect";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface AlogCallBack {
        void onSuccess(boolean z, int i, Exception exc, JSONObject jSONObject);
    }

    public static void setUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UPLOAD_URL = str;
    }

    public static void setUploadHost(String str) {
        UPLOAD_URL = "https://" + str + ReportConsts.FILE_COLLECT_PATH;
    }

    public static boolean uploadAlogFiles(String str, String str2, String str3, List<String> list, String str4, JSONObject jSONObject) {
        return uploadAlogFiles(str, str2, str3, list, str4, jSONObject, null);
    }

    public static boolean uploadAlogFiles(String str, String str2, String str3, List<String> list, String str4, JSONObject jSONObject, AlogCallBack alogCallBack) {
        HttpResponse finish;
        try {
            IHttpService iHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);
            HashMap hashMap = new HashMap();
            hashMap.put("scene", str4);
            IMultipartUploader buildMultipartUpload = iHttpService.buildMultipartUpload(UPLOAD_URL, UrlUtils.UTF_8, false, hashMap);
            buildMultipartUpload.addFormField("aid", str);
            buildMultipartUpload.addFormField("verify_info", SlardarProperties.getReleaseBuild());
            buildMultipartUpload.addFormField("device_id", str2);
            buildMultipartUpload.addFormField("os", "Android");
            buildMultipartUpload.addFormField("process_name", str3);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists()) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("logtype", "alog");
                    hashMap2.put("scene", str4);
                    hashMap2.put(ReportConst.JSBConfigParam.ENV, "params.txt");
                    buildMultipartUpload.addFilePart(file.getName(), file, (String) null, hashMap2);
                }
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("filetype", "common_params");
            hashMap3.put("logtype", ReportConst.JSBConfigParam.ENV);
            String jSONObject2 = jSONObject == null ? null : jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("defaultData", "none commonParams");
                } catch (JSONException unused) {
                }
                jSONObject2 = jSONObject3.toString();
            }
            buildMultipartUpload.addFilePart("params.txt", jSONObject2, "text/plain", hashMap3);
            finish = buildMultipartUpload.finish();
            try {
            } catch (JSONException e) {
                if (alogCallBack != null) {
                    alogCallBack.onSuccess(false, 7, e, null);
                }
            }
        } catch (IOException e2) {
            if (alogCallBack != null) {
                alogCallBack.onSuccess(false, 8, e2, null);
            }
        } catch (Exception e3) {
            if (alogCallBack != null) {
                alogCallBack.onSuccess(false, 10, e3, null);
            }
        }
        if (finish.getResponseBytes() == null) {
            if (alogCallBack != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("ALOG_UPLOAD_RESPONSE", ArgusConstants.NULL_PLACE_HOLDER);
                jSONObject4.put("ALOG_UPLOAD_STATUS", finish.getStatusCode());
                alogCallBack.onSuccess(false, 11, null, jSONObject4);
            }
            return false;
        }
        JSONObject jSONObject5 = new JSONObject(new String(finish.getResponseBytes()));
        if (jSONObject5.optInt("errno", -1) != 200) {
            if (alogCallBack != null) {
                alogCallBack.onSuccess(false, 6, null, jSONObject5);
            }
            return false;
        }
        String optString = jSONObject5.optString("message");
        if (!ReportConsts.RESPONSE_MESSAGE_LONG_ESCAPE.equals(optString) && !ReportConsts.RESPONSE_MESSAGE_DROP_DATA.equals(optString)) {
            if (alogCallBack != null) {
                alogCallBack.onSuccess(true, -1, null, jSONObject5);
            }
            return true;
        }
        alogCallBack.onSuccess(false, 13, null, jSONObject5);
        return false;
    }
}
