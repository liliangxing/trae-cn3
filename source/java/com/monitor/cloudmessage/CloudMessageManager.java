package com.monitor.cloudmessage;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.report.FileUploadServiceImpl;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.UrlUtils;
import com.bytedance.apm6.util.Tools;
import com.bytedance.services.apm.api.HttpResponse;
import com.monitor.cloudmessage.callback.IABTestConsumer;
import com.monitor.cloudmessage.callback.IAlogConsumer;
import com.monitor.cloudmessage.callback.ICommandReceiveObserver;
import com.monitor.cloudmessage.callback.IMonitorLogConsumer;
import com.monitor.cloudmessage.callback.IPatchConsumer;
import com.monitor.cloudmessage.callback.IPluginConsumer;
import com.monitor.cloudmessage.callback.IRouteConsumer;
import com.monitor.cloudmessage.callback.ITemplateConsumer;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.IMessageHandler;
import com.monitor.cloudmessage.handler.impl.ABTestMessageHandler;
import com.monitor.cloudmessage.handler.impl.AlogMessageHandler;
import com.monitor.cloudmessage.handler.impl.CacheMessageHandler;
import com.monitor.cloudmessage.handler.impl.DBMessageHandler;
import com.monitor.cloudmessage.handler.impl.DataClearMessageHandler;
import com.monitor.cloudmessage.handler.impl.FileUploadMessageHandler;
import com.monitor.cloudmessage.handler.impl.HeapOOMMessageHandler;
import com.monitor.cloudmessage.handler.impl.MonitorLogMessageHandler;
import com.monitor.cloudmessage.handler.impl.NetFlowMessageHandler;
import com.monitor.cloudmessage.handler.impl.NetworkMessageHandler;
import com.monitor.cloudmessage.handler.impl.ObversableMessageHandler;
import com.monitor.cloudmessage.handler.impl.PatchMessageHandler;
import com.monitor.cloudmessage.handler.impl.PermissionMessageHandler;
import com.monitor.cloudmessage.handler.impl.PluginMessageHandler;
import com.monitor.cloudmessage.handler.impl.RouteMessageHandler;
import com.monitor.cloudmessage.handler.impl.SPMessageHandler;
import com.monitor.cloudmessage.handler.impl.StatMessageHandler;
import com.monitor.cloudmessage.handler.impl.TemplateMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.DbFileGenerator;
import com.monitor.cloudmessage.obversable.CloudMessageObserver;
import com.monitor.cloudmessage.utils.DecodeUtils;
import com.vivo.push.PushClient;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CloudMessageManager {
    private static final long MIN_FETCH_INTERVAL_MS = 120000;
    private static IABTestConsumer sAbTestConsumer = null;
    private static volatile String sAid = "";
    private static IAlogConsumer sAlogConsumer = null;
    private static volatile String[] sBlackListForCloudContrlInf = null;
    private static volatile Context sContext = null;
    private static volatile String sDumpFileDir = "";
    private static String sHost = null;
    private static volatile CloudMessageManager sInstance = null;
    private static volatile boolean sIsFetchDataWithSocket = false;
    private static volatile boolean sIsInit = false;
    private static IMonitorLogConsumer sMonitorLogConsumer = null;
    private static IPatchConsumer sPatchConsumer = null;
    private static IPluginConsumer sPluginConsumer = null;
    private static IRouteConsumer sRouteConsumer = null;
    private static ITemplateConsumer sTemplateConsumer = null;
    private static volatile String sUid = "";
    private static volatile String sUpdateVersionCode = "";
    private List<IMessageHandler> mCloudControlHandler;
    private long mLastFetchTime;
    private volatile HashMap<String, String> mCommonParams = new HashMap<>();
    private volatile WeakReference<ICommandReceiveObserver> mCommandReiveObserver = null;
    private Vector mObverserList = new Vector(10);
    private final ExecutorService mExecutorService = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;

    public static void init(Context context) {
        sIsInit = true;
        sContext = context.getApplicationContext();
        getInstance();
        if (ApmContext.isDebugMode()) {
            Logger.d("cloudmessage", new String[]{"CloudMessageManager Init."});
        }
    }

    private CloudMessageManager() {
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(new FileUploadMessageHandler());
        arrayList.add(new CacheMessageHandler());
        arrayList.add(new StatMessageHandler());
        arrayList.add(new NetworkMessageHandler());
        arrayList.add(new RouteMessageHandler());
        arrayList.add(new TemplateMessageHandler());
        arrayList.add(new DBMessageHandler());
        arrayList.add(new SPMessageHandler());
        arrayList.add(new PermissionMessageHandler());
        arrayList.add(new MonitorLogMessageHandler());
        arrayList.add(new AlogMessageHandler());
        arrayList.add(new ABTestMessageHandler());
        arrayList.add(new PatchMessageHandler());
        arrayList.add(new PluginMessageHandler());
        arrayList.add(new HeapOOMMessageHandler());
        arrayList.add(new NetFlowMessageHandler());
        arrayList.add(new DataClearMessageHandler());
        arrayList.add(new ObversableMessageHandler());
        this.mCloudControlHandler = Collections.unmodifiableList(arrayList);
        handleCachedConsumer();
        clearDataCache();
        try {
            sDumpFileDir = dumpFileDir(sContext).getAbsolutePath() + "/dump.hprof";
        } catch (Exception unused) {
        }
    }

    public static CloudMessageManager getInstance() {
        if (sInstance == null) {
            synchronized (CloudMessageManager.class) {
                if (sInstance == null) {
                    if (!sIsInit) {
                        throw new RuntimeException("call CloudMessageManager.init() first");
                    }
                    sInstance = new CloudMessageManager();
                }
            }
        }
        return sInstance;
    }

    private void handleCachedConsumer() {
        IPluginConsumer iPluginConsumer = sPluginConsumer;
        if (iPluginConsumer != null) {
            setPluginMessageConsumer(iPluginConsumer);
            sPluginConsumer = null;
        }
        IPatchConsumer iPatchConsumer = sPatchConsumer;
        if (iPatchConsumer != null) {
            setPatchMessageConsumer(iPatchConsumer);
            sPatchConsumer = null;
        }
        IABTestConsumer iABTestConsumer = sAbTestConsumer;
        if (iABTestConsumer != null) {
            setABTestConsumer(iABTestConsumer);
            sAbTestConsumer = null;
        }
        IAlogConsumer iAlogConsumer = sAlogConsumer;
        if (iAlogConsumer != null) {
            setAlogConsumer(iAlogConsumer);
            sAlogConsumer = null;
        }
        IMonitorLogConsumer iMonitorLogConsumer = sMonitorLogConsumer;
        if (iMonitorLogConsumer != null) {
            setMonitorLogConsumer(iMonitorLogConsumer);
            sMonitorLogConsumer = null;
        }
        IRouteConsumer iRouteConsumer = sRouteConsumer;
        if (iRouteConsumer != null) {
            setRouteConsumer(iRouteConsumer);
            sRouteConsumer = null;
        }
        ITemplateConsumer iTemplateConsumer = sTemplateConsumer;
        if (iTemplateConsumer != null) {
            setTemplateConsumer(iTemplateConsumer);
            sTemplateConsumer = null;
        }
    }

    public Context getContext() {
        return sContext;
    }

    public static boolean isFetchDataWithSocket() {
        return sIsFetchDataWithSocket;
    }

    public static void setFetchDataWithSocket(boolean z) {
        sIsFetchDataWithSocket = z;
    }

    public Enumeration getObverserList() {
        return this.mObverserList.elements();
    }

    public void registerCloudMessageObverser(CloudMessageObserver cloudMessageObserver) {
        if (cloudMessageObserver != null) {
            addToObverserList(cloudMessageObserver);
        }
    }

    public void unregisterCloudMessageObverser(CloudMessageObserver cloudMessageObserver) {
        if (cloudMessageObserver != null) {
            removeFromObverserList(cloudMessageObserver);
        }
    }

    private boolean addToObverserList(CloudMessageObserver cloudMessageObserver) {
        if (this.mObverserList.contains(cloudMessageObserver)) {
            return false;
        }
        this.mObverserList.add(cloudMessageObserver);
        return true;
    }

    private boolean removeFromObverserList(CloudMessageObserver cloudMessageObserver) {
        if (!this.mObverserList.contains(cloudMessageObserver)) {
            return false;
        }
        this.mObverserList.remove(cloudMessageObserver);
        return true;
    }

    public void handleCloudMessage(final CloudMessage cloudMessage) {
        this.mExecutorService.execute(new Runnable() { // from class: com.monitor.cloudmessage.CloudMessageManager.1
            @Override // java.lang.Runnable
            public void run() {
                CloudMessageManager.this.handleCloudMessageInternal(cloudMessage);
            }
        });
    }

    public void handleCloudMessage(final String str) {
        this.mExecutorService.execute(new Runnable() { // from class: com.monitor.cloudmessage.CloudMessageManager.2
            @Override // java.lang.Runnable
            public void run() {
                CloudMessageManager.this.handleCloudMessageInternal(CloudMessage.fromString(str));
            }
        });
    }

    public void handleCloudMessage(byte[] bArr, Map<String, String> map) {
        String str;
        JSONArray optJSONArray;
        if (ApmContext.isDebugMode()) {
            Logger.d("cloudmessage", new String[]{"handleCloudMessage payload and headers"});
        }
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                if ("ran".equals(str2)) {
                    str = DecodeUtils.decodeData(bArr, map.get(str2));
                    break;
                }
            }
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
            str = DecodeUtils.decodeData(bArr);
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("configs");
            if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("cloud_commands")) == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    handleCloudMessage(optString);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCloudMessageInternal(CloudMessage cloudMessage) {
        if (ApmContext.isDebugMode()) {
            Logger.d("cloudmessage", new String[]{"handleCloudMessageInternal cloudMessage=" + cloudMessage});
        }
        if (cloudMessage == null) {
            return;
        }
        ICommandReceiveObserver iCommandReceiveObserver = this.mCommandReiveObserver == null ? null : this.mCommandReiveObserver.get();
        if (iCommandReceiveObserver != null) {
            iCommandReceiveObserver.notifyCommandReceived(cloudMessage);
        }
        Iterator<IMessageHandler> it = this.mCloudControlHandler.iterator();
        while (it.hasNext() && !it.next().handleCloudMessage(cloudMessage)) {
        }
    }

    private void setTemplateConsumer(ITemplateConsumer iTemplateConsumer) {
        if (iTemplateConsumer != null) {
            for (IMessageHandler iMessageHandler : this.mCloudControlHandler) {
                if (iMessageHandler instanceof TemplateMessageHandler) {
                    ((TemplateMessageHandler) iMessageHandler).setTemplateConsumer(iTemplateConsumer);
                    return;
                }
            }
        }
    }

    public static void setTemplateConsumerSafely(ITemplateConsumer iTemplateConsumer) {
        if (sIsInit) {
            getInstance().setTemplateConsumer(iTemplateConsumer);
        } else {
            sTemplateConsumer = iTemplateConsumer;
        }
    }

    private void setRouteConsumer(IRouteConsumer iRouteConsumer) {
        if (iRouteConsumer != null) {
            for (IMessageHandler iMessageHandler : this.mCloudControlHandler) {
                if (iMessageHandler instanceof RouteMessageHandler) {
                    ((RouteMessageHandler) iMessageHandler).setRouteConsumer(iRouteConsumer);
                    return;
                }
            }
        }
    }

    public static void setRouteConsumerSafely(IRouteConsumer iRouteConsumer) {
        if (sIsInit) {
            getInstance().setRouteConsumer(iRouteConsumer);
        } else {
            sRouteConsumer = iRouteConsumer;
        }
    }

    private void setMonitorLogConsumer(IMonitorLogConsumer iMonitorLogConsumer) {
        if (iMonitorLogConsumer != null) {
            for (IMessageHandler iMessageHandler : this.mCloudControlHandler) {
                if (iMessageHandler instanceof MonitorLogMessageHandler) {
                    ((MonitorLogMessageHandler) iMessageHandler).setMonitorLogConsumer(iMonitorLogConsumer);
                    return;
                }
            }
        }
    }

    public static void setMonitorLogConsumerSafely(IMonitorLogConsumer iMonitorLogConsumer) {
        if (sIsInit) {
            getInstance().setMonitorLogConsumer(iMonitorLogConsumer);
        } else {
            sMonitorLogConsumer = iMonitorLogConsumer;
        }
    }

    private void setAlogConsumer(IAlogConsumer iAlogConsumer) {
        if (iAlogConsumer != null) {
            for (IMessageHandler iMessageHandler : this.mCloudControlHandler) {
                if (iMessageHandler instanceof AlogMessageHandler) {
                    ((AlogMessageHandler) iMessageHandler).setAlogConsumer(iAlogConsumer);
                    return;
                }
            }
        }
    }

    public static void setAlogConsumerSafely(IAlogConsumer iAlogConsumer) {
        if (sIsInit) {
            getInstance().setAlogConsumer(iAlogConsumer);
        } else {
            sAlogConsumer = iAlogConsumer;
        }
    }

    private void setABTestConsumer(IABTestConsumer iABTestConsumer) {
        if (iABTestConsumer != null) {
            for (IMessageHandler iMessageHandler : this.mCloudControlHandler) {
                if (iMessageHandler instanceof ABTestMessageHandler) {
                    ((ABTestMessageHandler) iMessageHandler).setmAbTestConsumer(iABTestConsumer);
                    return;
                }
            }
        }
    }

    public static void setABTestConsumerSafely(IABTestConsumer iABTestConsumer) {
        if (sIsInit) {
            getInstance().setABTestConsumer(iABTestConsumer);
        } else {
            sAbTestConsumer = iABTestConsumer;
        }
    }

    private void setPatchMessageConsumer(IPatchConsumer iPatchConsumer) {
        if (iPatchConsumer != null) {
            for (IMessageHandler iMessageHandler : this.mCloudControlHandler) {
                if (iMessageHandler instanceof PatchMessageHandler) {
                    ((PatchMessageHandler) iMessageHandler).setPatchConsumer(iPatchConsumer);
                    return;
                }
            }
        }
    }

    public static void setPatchMessageConsumerSafely(IPatchConsumer iPatchConsumer) {
        if (sIsInit) {
            getInstance().setPatchMessageConsumer(iPatchConsumer);
        } else {
            sPatchConsumer = iPatchConsumer;
        }
    }

    private void setPluginMessageConsumer(IPluginConsumer iPluginConsumer) {
        if (iPluginConsumer != null) {
            for (IMessageHandler iMessageHandler : this.mCloudControlHandler) {
                if (iMessageHandler instanceof PluginMessageHandler) {
                    ((PluginMessageHandler) iMessageHandler).setPluginConsumer(iPluginConsumer);
                    return;
                }
            }
        }
    }

    public static void setPluginMessageComsumerSafely(IPluginConsumer iPluginConsumer) {
        if (sIsInit) {
            getInstance().setPluginMessageConsumer(iPluginConsumer);
        } else {
            sPluginConsumer = iPluginConsumer;
        }
    }

    public static String getUid() {
        return sUid;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static String getAid() {
        return sAid;
    }

    public static void setAid(String str) {
        sAid = str;
    }

    public static String getUpdateVersionCode() {
        return sUpdateVersionCode;
    }

    public static void setUpdateVersionCode(String str) {
        sUpdateVersionCode = str;
    }

    public static String getDumpFileDir() {
        return sDumpFileDir;
    }

    public static void setDumpFileDir(String str) {
        sDumpFileDir = str;
    }

    public HashMap<String, String> getCommonParams() {
        return this.mCommonParams;
    }

    public void setCommonParams(HashMap<String, String> hashMap) {
        this.mCommonParams = hashMap;
    }

    public void setCommandReiveObserver(ICommandReceiveObserver iCommandReceiveObserver) {
        if (iCommandReceiveObserver != null) {
            this.mCommandReiveObserver = new WeakReference<>(iCommandReceiveObserver);
        }
    }

    public static String[] getBlackListForCloudContrlInf() {
        return sBlackListForCloudContrlInf;
    }

    public static void setBlackListForCloudContrlInf(String[] strArr) {
        sBlackListForCloudContrlInf = strArr;
    }

    public static File dumpFileDir(Context context) {
        File file = new File(context.getExternalFilesDir(null) + "/monitor");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private void clearDataCache() {
        this.mExecutorService.execute(new Runnable() { // from class: com.monitor.cloudmessage.CloudMessageManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DbFileGenerator.clearData(CloudMessageManager.sContext);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0109, code lost:
    
        r2 = (java.lang.String) r4.getValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchCommandImmediately() {
        String str;
        JSONArray optJSONArray;
        sHost = FileUploadServiceImpl.sHost;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastFetchTime < MIN_FETCH_INTERVAL_MS) {
            Logger.d("cloudmessage", new String[]{"fetchCommandImmediately too fast. just ignore for this time."});
            return;
        }
        this.mLastFetchTime = currentTimeMillis;
        try {
            String addParamsToURL = UrlUtils.addParamsToURL("https://" + sHost + "/monitor/collect/c/cloudcontrol/get", ApmContext.getQueryParamsMap());
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Version-Code", PushClient.DEFAULT_REQUEST_ID);
            hashMap.put("Accept", "application/json");
            HttpResponse doPost = ApmContext.doPost(addParamsToURL, Tools.safeGetBytes(new JSONObject().toString()), hashMap);
            if (ApmContext.isDebugMode()) {
                Logger.d("cloudmessage", new String[]{"fetchCommandImmediately: url=" + addParamsToURL});
            }
            if (doPost == null) {
                Logger.d("cloudmessage", new String[]{"fetchCommandImmediately: res null"});
                return;
            }
            if (doPost.getStatusCode() == 200) {
                JSONObject jSONObject = new JSONObject(new String(doPost.getResponseBytes()));
                if (ApmContext.isDebugMode()) {
                    Logger.d("cloudmessage", new String[]{"fetchCommandImmediately: resultMsg=" + jSONObject.toString()});
                }
                Map headers = doPost.getHeaders();
                if (headers == null || headers.isEmpty()) {
                    str = null;
                } else {
                    str = (String) headers.get("ran");
                    try {
                        if (TextUtils.isEmpty(str)) {
                            Iterator it = headers.entrySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it.next();
                                if ("ran".equalsIgnoreCase((String) entry.getKey())) {
                                    break;
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                String optString = jSONObject.optString("data");
                if (!optString.isEmpty()) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject = new JSONObject(com.bytedance.apm.util.DecodeUtils.decodeData(optString.getBytes(), str));
                    } else {
                        jSONObject = new JSONObject(new String(optString.getBytes()));
                    }
                }
                if (ApmContext.isDebugMode()) {
                    Logger.d("cloudmessage", new String[]{"fetchCommandImmediately resultMsg=" + jSONObject});
                }
                if (JsonUtils.isEmpty(jSONObject)) {
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("configs");
                if (JsonUtils.isEmpty(optJSONObject) || (optJSONArray = optJSONObject.optJSONArray("cloud_commands")) == null) {
                    return;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    handleCloudMessage(optJSONArray.optString(i));
                }
            }
        } catch (Exception e) {
            Logger.printErrStackTrace("cloudmessage", e, new String[]{"fetchCommandImmediately error."});
        }
    }
}
