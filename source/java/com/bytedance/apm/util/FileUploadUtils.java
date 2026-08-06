package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FileUploadUtils {
    public static HttpResponse uploadFiles(String str, List<File> list, Map<String, String> map) {
        try {
            IHttpService iHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);
            if (iHttpService == null) {
                iHttpService = ApmContext.getHttpService();
            }
            IMultipartUploader buildMultipartUpload = iHttpService.buildMultipartUpload(str, com.bytedance.android.standard.tools.url.UrlUtils.UTF_8, false);
            if (list != null && !list.isEmpty()) {
                for (File file : list) {
                    if (file.exists()) {
                        buildMultipartUpload.addFilePart(file.getName(), file, (String) null, new HashMap());
                    }
                }
            }
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    buildMultipartUpload.addFormField(entry.getKey(), entry.getValue());
                }
            }
            String str2 = new String(buildMultipartUpload.finish().getResponseBytes());
            if (!TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    return new HttpResponse(jSONObject.optInt("error_code", 0), jSONObject.optString("message", "").getBytes());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
