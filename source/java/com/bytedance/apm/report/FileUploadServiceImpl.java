package com.bytedance.apm.report;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IFileUploadCallback;
import com.bytedance.services.apm.api.IFileUploadService;
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
public class FileUploadServiceImpl implements IFileUploadService {
    public static String sHost;
    public static String sMappingFileUploadUrl;
    public static String sUploadUrl;

    @Deprecated
    public void setOverSea(boolean z) {
    }

    @Deprecated
    public void setUploadUrl(String str) {
        sUploadUrl = str;
    }

    public static void setUploadHost(String str) {
        sUploadUrl = "https://" + str + ReportConsts.FILE_COLLECT_PATH;
        sHost = str;
    }

    public static void setMappingFileUploadHost(String str) {
        sMappingFileUploadUrl = "https://" + str + ReportConsts.MAPPING_FILE_COLLECT_PATH;
    }

    public void uploadFiles(final String str, final String str2, final String str3, final List<String> list, final String str4, final JSONObject jSONObject, final IFileUploadCallback iFileUploadCallback) {
        AsyncEventManager.getInstance().submitTask(new Runnable() { // from class: com.bytedance.apm.report.FileUploadServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                FileUploadServiceImpl.this.uploadFilesInternal(str, str2, str3, list, str4, jSONObject, iFileUploadCallback);
            }
        });
    }

    public static void uploadMappingFiles(final String str, final String str2, final String str3, final String str4, final String str5, final JSONObject jSONObject, final IFileUploadCallback iFileUploadCallback) {
        AsyncEventManager.getInstance().submitTask(new Runnable() { // from class: com.bytedance.apm.report.FileUploadServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                FileUploadServiceImpl.uploadMappingFilesInternal(str, str2, str3, str4, str5, jSONObject, null, iFileUploadCallback);
            }
        });
    }

    public static void uploadMappingFiles(final String str, final String str2, final String str3, final String str4, final String str5, final JSONObject jSONObject, final String str6, final IFileUploadCallback iFileUploadCallback) {
        AsyncEventManager.getInstance().submitTask(new Runnable() { // from class: com.bytedance.apm.report.FileUploadServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                FileUploadServiceImpl.uploadMappingFilesInternal(str, str2, str3, str4, str5, jSONObject, str6, iFileUploadCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFilesInternal(String str, String str2, String str3, List<String> list, String str4, JSONObject jSONObject, IFileUploadCallback iFileUploadCallback) {
        String str5;
        try {
            IHttpService iHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);
            if (iHttpService == null) {
                iHttpService = ApmContext.getHttpService();
            }
            IMultipartUploader buildMultipartUpload = iHttpService.buildMultipartUpload(sUploadUrl, UrlUtils.UTF_8, false);
            buildMultipartUpload.addFormField("aid", str);
            buildMultipartUpload.addFormField("device_id", str2);
            buildMultipartUpload.addFormField("os", "Android");
            buildMultipartUpload.addFormField("process_name", PullConfiguration.PROCESS_NAME_MAIN);
            Iterator<String> it = list.iterator();
            while (true) {
                str5 = null;
                if (!it.hasNext()) {
                    break;
                }
                File file = new File(it.next());
                if (file.exists()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("logtype", str3);
                    hashMap.put("scene", str4);
                    hashMap.put(ReportConst.JSBConfigParam.ENV, "params.txt");
                    buildMultipartUpload.addFilePart(file.getName(), file, (String) null, hashMap);
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("filetype", "common_params");
            hashMap2.put("logtype", ReportConst.JSBConfigParam.ENV);
            if (jSONObject != null) {
                str5 = jSONObject.toString();
            }
            if (TextUtils.isEmpty(str5)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("defaultData", "none commonParams");
                } catch (JSONException unused) {
                }
                str5 = jSONObject2.toString();
            }
            buildMultipartUpload.addFilePart("params.txt", str5, "text/plain", hashMap2);
            String str6 = new String(buildMultipartUpload.finish().getResponseBytes());
            int i = -1;
            try {
                i = new JSONObject(str6).optInt("errno", -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (iFileUploadCallback != null) {
                if (i == 200) {
                    iFileUploadCallback.onSuccess();
                } else {
                    iFileUploadCallback.onFail(str6);
                }
            }
        } catch (Exception e2) {
            if (iFileUploadCallback != null) {
                iFileUploadCallback.onFail(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uploadMappingFilesInternal(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, String str6, IFileUploadCallback iFileUploadCallback) {
        File file;
        File file2 = null;
        String jSONObject2 = null;
        File file3 = null;
        File file4 = null;
        try {
            try {
                try {
                    IHttpService iHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);
                    if (iHttpService == null) {
                        iHttpService = ApmContext.getHttpService();
                    }
                    IMultipartUploader buildMultipartUpload = iHttpService.buildMultipartUpload(sMappingFileUploadUrl, UrlUtils.UTF_8, false);
                    buildMultipartUpload.addFormField("aid", str);
                    buildMultipartUpload.addFormField("os", "Android");
                    buildMultipartUpload.addFormField("update_version_code", str2);
                    buildMultipartUpload.addFormField("channel", str3);
                    buildMultipartUpload.addFormField("release_build", str4);
                    if (!TextUtils.isEmpty(str6)) {
                        buildMultipartUpload.addFormField("device_id", str6);
                    }
                    buildMultipartUpload.addFormField("monitor_version", "5.0.21.41");
                    File file5 = new File(str5);
                    if (file5.exists()) {
                        String str7 = file5.getParent() + "/" + (FileUtils.getFileNameWithoutSuffix(file5) + ".zip");
                        FileUtils.compress(str7, str5);
                        file = new File(str7);
                        try {
                            buildMultipartUpload.addFilePart(file.getName(), file, (String) null, new HashMap());
                        } catch (IOException e) {
                            e = e;
                            file4 = file;
                            if (iFileUploadCallback != null) {
                                iFileUploadCallback.onFail(e.getMessage());
                            }
                            if (file4 != null) {
                                file4.delete();
                            }
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            file2 = file;
                            e.printStackTrace();
                            if (file2 != null) {
                                file2.delete();
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            file3 = file;
                            if (file3 != null) {
                                try {
                                    file3.delete();
                                } catch (Throwable th2) {
                                    th2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        file = null;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("filetype", "common_params");
                    hashMap.put("logtype", ReportConst.JSBConfigParam.ENV);
                    if (jSONObject != null) {
                        jSONObject2 = jSONObject.toString();
                    }
                    if (TextUtils.isEmpty(jSONObject2)) {
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("defaultData", "none commonParams");
                        } catch (JSONException unused) {
                        }
                        jSONObject2 = jSONObject3.toString();
                    }
                    buildMultipartUpload.addFilePart("params.txt", jSONObject2, "text/plain", hashMap);
                    String str8 = new String(buildMultipartUpload.finish().getResponseBytes());
                    int i = -1;
                    try {
                        i = new JSONObject(str8).optInt("errno", -1);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    if (iFileUploadCallback != null) {
                        if (i == 200) {
                            iFileUploadCallback.onSuccess();
                        } else {
                            iFileUploadCallback.onFail(str8);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (Exception e5) {
                e = e5;
            }
            if (file != null) {
                file.delete();
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
    }
}
