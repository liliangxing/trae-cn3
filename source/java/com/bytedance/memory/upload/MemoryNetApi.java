package com.bytedance.memory.upload;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.util.NetTypeUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.memory.common.MemoryExecutorSupplier;
import com.bytedance.memory.common.MemoryLog;
import com.bytedance.memory.dump.DumpFileProvider;
import com.bytedance.memory.event.EventUtils;
import com.bytedance.memory.heap.HeapSaver;
import com.bytedance.memory.watcher.MemoryChecker;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.push.client.intelligence.FeatureConnectionConstant;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MemoryNetApi {
    public static final String DUMP_COLLECT_PATH = "/monitor/collect/c/mom_dump_collect";
    public static final String UPLOAD_CHECK_PATH = "/monitor/collect/c/memory_upload_check?aid=%d&os=android";
    public static final String UPLOAD_CLIENT_SUFFIX = "/monitor/collect/c/exception";
    public static List<String> sUploadCheckUrls = new ArrayList();
    public static List<String> sDumpCollectUrls = new ArrayList();
    public static List<String> sUploadClientResultUrls = new ArrayList();
    public static String UPLOAD_WHEN_NOT_WIFI = "upload_when_not_wifi";
    public static String HPROF_FORCE_UPLOAD = "hprof_force_upload";
    public static String HPROF_SHRINK_DEEP = "hprof_shrink_deep";
    private static volatile boolean sUploading = false;

    public static void uploadClientResult(final String str) {
        MemoryExecutorSupplier.NORMAL_SERVICE.execute(new Runnable() { // from class: com.bytedance.memory.upload.MemoryNetApi.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("d_s_t", System.currentTimeMillis());
                    jSONObject2.put(ReportConst.KEY_EVENT_TYPE, "memory_object_monitor");
                    jSONObject2.put("log_id", 464);
                    jSONObject2.put("log_type", "memory_object_monitor");
                    jSONObject2.put("memory_object", new JSONObject(str).optJSONObject("memory_object"));
                    jSONObject2.put(FeatureConnectionConstant.NETWORK_TYPE, NetTypeUtils.getNetworkType(ApmContext.getContext()).getValue());
                    String sessionId = ApmContext.getDynamicParams().getSessionId();
                    if (!TextUtils.isEmpty(sessionId)) {
                        jSONObject2.put(XConstant.SESSION_ID, sessionId);
                    }
                    jSONObject2.put("sid", ApmContext.getStartId());
                    jSONObject2.put(ReportConst.KEY_TIMESTAMP, System.currentTimeMillis());
                    jSONArray.put(jSONObject2);
                    jSONObject.put("data", jSONArray);
                    jSONObject.put(OnlineTracing.HeaderKeys.KEY_SSR_FALLBACK_HEADER, ApmContext.getHeaderInner());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                Iterator<String> it = MemoryNetApi.sUploadClientResultUrls.iterator();
                while (it.hasNext()) {
                    try {
                        HttpResponse doPost = ApmContext.doPost(it.next(), jSONObject.toString().getBytes(), (Map) null);
                        if (doPost != null && new JSONObject(new String(doPost.getResponseBytes())).optInt(CDNLoader.DIAGNOSE_ERROR_CODE, -1) == 0) {
                            MemoryLog.m101i("client analysis report success", new Object[0]);
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "uploadClientResult-MNA");
    }

    public static void uploadFile() {
        EventUtils.uploadCategoryEvent("uploadFile");
        synchronized (MemoryNetApi.class) {
            if (!sUploading && !TextUtils.isEmpty(HeapSaver.getInstance().getLatestZipPath())) {
                boolean z = true;
                sUploading = true;
                if (!NetUtils.isWifi(MemoryApi.getInstance().getContext()) && !EventUtils.getMemoryEvent(UPLOAD_WHEN_NOT_WIFI)) {
                    EventUtils.uploadCategoryEvent(EventUtils.ERROR_DISALLOW_UPLOAD_WHEN_NOT_WIFI_IN_UPLOAD);
                    MemoryLog.m101i("not wifi, not upload", new Object[0]);
                    return;
                }
                try {
                    MemoryLog.m101i("MemoryNetApi uploadFile begin", new Object[0]);
                    EventUtils.uploadCategoryEvent("uploadFile_begin");
                    JSONObject header = ApmContext.getHeader();
                    header.put("update_version_code", HeapSaver.getInstance().getUpdateVersionCode());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportConst.KEY_EVENT_TYPE, "memory_object_monitor");
                    jSONObject.put(HeapSaver.HPROF_TYPE, HeapSaver.getInstance().getHprofType());
                    jSONObject.put(ReportConst.KEY_TIMESTAMP, HeapSaver.getInstance().getCrashTime());
                    HashMap hashMap = new HashMap(2);
                    hashMap.put(OnlineTracing.HeaderKeys.KEY_SSR_FALLBACK_HEADER, header.toString());
                    hashMap.put("data", jSONObject.toString());
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(new File(HeapSaver.getInstance().getLatestZipPath()));
                    EventUtils.uploadCategoryEvent(EventUtils.UPLOAD_DUMP);
                    List<String> list = sDumpCollectUrls;
                    if (list != null && list.size() > 0) {
                        Iterator<String> it = sDumpCollectUrls.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            HttpResponse uploadFiles = ApmContext.uploadFiles(it.next(), arrayList, hashMap);
                            if (uploadFiles != null) {
                                String str = new String(uploadFiles.getResponseBytes());
                                if (TextUtils.isEmpty(str)) {
                                    MemoryLog.m101i("MemoryNetApi uploadFile succeed", new Object[0]);
                                    HeapSaver.getInstance().deleteCache();
                                    EventUtils.uploadCategoryEvent(EventUtils.UPLOAD_DUMP_SUCCESS);
                                    MemoryChecker.getInstance().setCanAnalyse(false);
                                    break;
                                }
                                EventUtils.uploadCategoryEvent("uploadFile_error");
                                MemoryLog.m101i("MemoryNetApi uploadFile failed,message:" + str, new Object[0]);
                            } else {
                                EventUtils.uploadCategoryEvent("uploadFile_error_httpResponseNone");
                                MemoryLog.m101i("MemoryNetApi uploadFile failed, response is null", new Object[0]);
                            }
                        }
                        if (!z) {
                            EventUtils.uploadCategoryEvent(EventUtils.ERROR_UPLOADFILE_FAILED);
                        }
                    } else {
                        EventUtils.uploadCategoryEvent(EventUtils.DUMPCOLLECT_URL_NULL);
                    }
                } catch (Throwable th) {
                    ApmAlogHelper.e("MemoryNetApi", th.toString());
                    EnsureManager.ensureNotReachHere(th);
                    EventUtils.uploadCategoryEvent(EventUtils.ERROR_UPLOADFILE_EXCEPTION);
                }
                sUploading = false;
                return;
            }
            EventUtils.uploadCategoryEvent("uploadFile_error_uploadingOrEmpty");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0143, code lost:
    
        r0 = new org.json.JSONObject(new java.lang.String(r1.getResponseBytes())).optBoolean("should_upload");
        com.bytedance.memory.common.MemoryLog.m101i("uploadCheck with api: shouldUpload " + r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0171, code lost:
    
        if (r0 != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0173, code lost:
    
        com.bytedance.memory.event.EventUtils.uploadCategoryEvent(com.bytedance.memory.event.EventUtils.FORBID_UPLOAD);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0178, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void uploadCheck() {
        EventUtils.uploadCategoryEvent("uploadCheck");
        if (!DumpFileProvider.getInstance().pendingHeapMarkFileExist()) {
            if (DumpFileProvider.getInstance().getPendingHeapFile().exists()) {
                HeapSaver.getInstance().deleteCache();
                EventUtils.uploadCategoryEvent(EventUtils.ERROR_CORRUPTED_HPROF);
                return;
            }
            return;
        }
        if (!NetUtils.isWifi(MemoryApi.getInstance().getContext()) && !EventUtils.getMemoryEvent(UPLOAD_WHEN_NOT_WIFI)) {
            EventUtils.uploadCategoryEvent(EventUtils.ERROR_DISALLOW_UPLOAD_WHEN_NOT_WIFI_IN_UPLOADCHECK);
            MemoryLog.m101i("not wifi, not upload", new Object[0]);
            return;
        }
        File pendingHeapFile = DumpFileProvider.getInstance().getPendingHeapFile();
        if (pendingHeapFile.exists() && pendingHeapFile.lastModified() < System.currentTimeMillis() - 604800000) {
            HeapSaver.getInstance().deleteCache();
            EventUtils.uploadCategoryEvent(EventUtils.ERROR_EXPIRED_HEAP_HPROF);
        }
        if (!TextUtils.isEmpty(HeapSaver.getInstance().getLatestZipPath())) {
            File file = new File(HeapSaver.getInstance().getLatestZipPath());
            if (file.exists() && file.lastModified() < System.currentTimeMillis() - 604800000) {
                HeapSaver.getInstance().deleteCache();
                EventUtils.uploadCategoryEvent(EventUtils.ERROR_EXPIRED_ZIP_HPROF);
            }
        }
        if (!NetUtils.isWifi(MemoryApi.getInstance().getContext()) && !EventUtils.getMemoryEvent(UPLOAD_WHEN_NOT_WIFI)) {
            EventUtils.uploadCategoryEvent(EventUtils.ERROR_DISALLOW_UPLOAD_WHEN_NOT_WIFI_IN_UPLOADCHECK);
            MemoryLog.m101i("not wifi, not upload", new Object[0]);
            return;
        }
        if (!TextUtils.equals(ApmContext.getHeaderInner().optString("update_version_code", ""), HeapSaver.getInstance().getUpdateVersionCode())) {
            EventUtils.uploadCategoryEvent("uploadCheck_error_versionDiff");
            HeapSaver.getInstance().deleteCache();
            EventUtils.uploadCategoryEvent(EventUtils.ERROR_VERSION_MISMATCH);
            return;
        }
        if (!EventUtils.getMemoryEvent(HPROF_FORCE_UPLOAD)) {
            try {
                List<String> list = sUploadCheckUrls;
                if (list != null && list.size() > 0) {
                    Iterator<String> it = sUploadCheckUrls.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        HttpResponse doGet = ApmContext.doGet(String.format(it.next(), Integer.valueOf(ApmContext.getHeader().optInt(CommonConstants.KEY_AID, 0))), (Map) null);
                        if (doGet != null) {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HeapSaver.getInstance().shrink();
    }
}
