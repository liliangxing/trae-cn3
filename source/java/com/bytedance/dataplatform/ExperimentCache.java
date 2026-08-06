package com.bytedance.dataplatform;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.dataplatform.applog.AppLogManager;
import com.bytedance.dataplatform.client.ClientDataSource;
import com.bytedance.dataplatform.client.ClientGroup;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ExperimentCache {
    private static final int MAX_NUM = 1000;
    private static Map<String, String> extraParameter = new ConcurrentHashMap();
    public static boolean updateOpt;
    private final String REQUEST_URL;
    private Map<String, Integer> clientExperimentLayer;
    private final Context context;
    private JSONObject experimentCache;
    private ExposureManager exposureManager;
    private Future future;
    private INetService netService;
    private ISerializationService serializationService;
    private final Map<String, Object> objectCache = new ConcurrentHashMap();
    private final Map<String, Runnable> stickyExposureAction = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExperimentCache(Application application, String host, boolean needRefresh, ISerializationService serializationService, IExposureService exposureService, INetService netService, Map<String, String> parameter, Set<String> extraVids) {
        this.REQUEST_URL = host;
        extraParameter = parameter;
        this.context = application;
        this.experimentCache = CacheRepository.getJSONObject(application, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_CACHE");
        this.clientExperimentLayer = CacheRepository.getAllInteger(application, "CLIENT_EXPERIMENT_CACHE_TAG");
        this.exposureManager = new ExposureManager(application, exposureService, extraVids);
        ClientExperimentManager.INSTANCE.setExposureManager(this.exposureManager);
        this.serializationService = serializationService;
        this.netService = netService;
        if (needRefresh) {
            this.future = Worker.scheduleWithFixedDelay(new Runnable() { // from class: com.bytedance.dataplatform.ExperimentCache.1
                @Override // java.lang.Runnable
                public void run() {
                    ExperimentCache.this.requestExperimentValue();
                }
            }, 2000L, 3600000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestExperimentValue() {
        try {
            StringBuilder sb = new StringBuilder(this.REQUEST_URL);
            if (!extraParameter.isEmpty()) {
                if (this.REQUEST_URL.indexOf(63) < 0) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                boolean z = true;
                for (Map.Entry<String, String> entry : extraParameter.entrySet()) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(entry.getKey(), UrlUtils.UTF_8)).append("=").append(URLEncoder.encode(entry.getValue(), UrlUtils.UTF_8));
                }
            }
            JSONObject jSONObject = new JSONObject(this.netService.request(sb.toString()));
            if (jSONObject.has(AlogMonitor.ALOG_RESULT_CODE) && jSONObject.has("data") && jSONObject.optInt(AlogMonitor.ALOG_RESULT_CODE, -1) == 0) {
                updateExperimentValue(jSONObject.getJSONObject("data"));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void refresh(Map<String, String> parameter) {
        Future future = this.future;
        if (future != null) {
            future.cancel(true);
        }
        if (parameter != null) {
            extraParameter.putAll(parameter);
        }
        this.future = Worker.scheduleWithFixedDelay(new Runnable() { // from class: com.bytedance.dataplatform.ExperimentCache.2
            @Override // java.lang.Runnable
            public void run() {
                ExperimentCache.this.requestExperimentValue();
            }
        }, 0L, 3600000L);
    }

    private void updateExperimentValue(JSONObject data) {
        JSONObject jSONObject;
        Object obj;
        String string;
        long j;
        JSONObject jSONObject2 = new JSONObject();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<String> keys = data.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject = data.getJSONObject(next);
            } catch (JSONException unused) {
            }
            if (updateOpt) {
                obj = jSONObject.opt("val");
                if (obj == null) {
                }
            } else {
                obj = jSONObject.get("val");
            }
            jSONObject2.put(next, obj);
            if (updateOpt) {
                string = jSONObject.optString("vid", null);
            } else {
                string = jSONObject.getString("vid");
            }
            if (!TextUtils.isEmpty(string)) {
                hashMap.put(next, string);
                if (updateOpt) {
                    j = jSONObject.optLong("et", 0L);
                } else {
                    j = jSONObject.getLong("et");
                }
                if (j > 0) {
                    hashMap2.put(string, Long.valueOf(j));
                }
            }
        }
        this.objectCache.clear();
        this.experimentCache = jSONObject2;
        CacheRepository.saveJSONObject(this.context, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_CACHE", jSONObject2);
        this.exposureManager.updateVidAndEt(hashMap, hashMap2);
        IExperimentListener experimentListener = ExperimentManager.getExperimentListener();
        if (experimentListener != null) {
            experimentListener.onLibraExperimentChanged(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getValue(final String str, Type type, T t, boolean z, final boolean z2) {
        T t2;
        if (type == Boolean.class || type == Boolean.TYPE) {
            t2 = (T) getBoolean(str, (Boolean) t);
        } else if (type == Integer.class || type == Short.class || type == Integer.TYPE || type == Short.TYPE) {
            t2 = (T) getInteger(str, (Integer) t);
        } else if (type == Float.class || type == Float.TYPE) {
            t2 = (T) getFloat(str, (Float) t);
        } else if (type == Long.class || type == Long.TYPE) {
            t2 = (T) getLong(str, (Long) t);
        } else if (type == Double.class || type == Double.TYPE) {
            t2 = (T) getDouble(str, (Double) t);
        } else if (type == String.class) {
            t2 = (T) getString(str, (String) t);
        } else {
            t2 = (T) getObject(str, type, t);
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.dataplatform.ExperimentCache.3
            @Override // java.lang.Runnable
            public void run() {
                ExperimentCache.this.exposureManager.expose(str, z2);
            }
        };
        if (z) {
            runnable.run();
        } else {
            this.stickyExposureAction.put(str, runnable);
        }
        return t2;
    }

    private <T> T getObject(String str, Type type, T t) {
        try {
            if (this.objectCache.containsKey(str) && this.objectCache.get(str).getClass() == type) {
                return (T) this.objectCache.get(str);
            }
            T t2 = (T) this.serializationService.parseObject(this.experimentCache.optString(str, ""), type);
            if (t2 == null) {
                this.objectCache.remove(str);
                return t;
            }
            this.objectCache.put(str, t2);
            return t2;
        } catch (Exception unused) {
            this.objectCache.remove(str);
            return t;
        }
    }

    private Double getDouble(String key, Double defaultValue) {
        return this.experimentCache.has(key) ? Double.valueOf(this.experimentCache.optDouble(key)) : defaultValue;
    }

    private Long getLong(String key, Long defaultValue) {
        return this.experimentCache.has(key) ? Long.valueOf(this.experimentCache.optLong(key)) : defaultValue;
    }

    private Float getFloat(String key, Float defaultValue) {
        return this.experimentCache.has(key) ? Float.valueOf((float) this.experimentCache.optDouble(key)) : defaultValue;
    }

    private Boolean getBoolean(String key, Boolean defaultValue) {
        return this.experimentCache.has(key) ? Boolean.valueOf(this.experimentCache.optBoolean(key)) : defaultValue;
    }

    private Integer getInteger(String key, Integer defaultValue) {
        return this.experimentCache.has(key) ? Integer.valueOf(this.experimentCache.optInt(key)) : defaultValue;
    }

    private String getString(String key, String defaultValue) {
        return this.experimentCache.optString(key, defaultValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T getValue(final String key, final ClientDataSource<T> clientDataSource, boolean withExposure) {
        int i;
        if (clientDataSource == null || TextUtils.isEmpty(clientDataSource.getLayer()) || clientDataSource.getClientGroup() == null || clientDataSource.getClientGroup().length == 0) {
            return null;
        }
        String layer = clientDataSource.getLayer();
        synchronized (this) {
            if (this.clientExperimentLayer.containsKey(layer)) {
                i = this.clientExperimentLayer.get(layer).intValue();
            } else {
                int nextInt = new Random().nextInt(1000);
                this.clientExperimentLayer.put(layer, Integer.valueOf(nextInt));
                CacheRepository.saveInt(this.context, "CLIENT_EXPERIMENT_CACHE_TAG", layer, nextInt);
                AppLogManager.sendLocalStrategyEvent(layer, Integer.valueOf(nextInt));
                i = nextInt;
            }
        }
        int start = (int) (clientDataSource.getStart() * 1000.0d);
        if (i < start) {
            return null;
        }
        for (final ClientGroup<T> clientGroup : clientDataSource.getClientGroup()) {
            if (clientGroup != null && i < (start = (int) (start + (clientGroup.getPercent() * 1000.0d)))) {
                Runnable runnable = new Runnable() { // from class: com.bytedance.dataplatform.ExperimentCache.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.ExperimentCache.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ExperimentCache.this.exposureManager.exposeClient(key, clientDataSource, clientGroup.getVid());
                            }
                        });
                    }
                };
                if (withExposure) {
                    runnable.run();
                } else {
                    this.stickyExposureAction.put(key, runnable);
                }
                return clientGroup.getResult();
            }
        }
        Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.ExperimentCache.5
            @Override // java.lang.Runnable
            public void run() {
                ExperimentCache.this.exposureManager.exposeClient(key, clientDataSource, null);
            }
        });
        return null;
    }

    public void exposureSticky(String key) {
        Runnable runnable = this.stickyExposureAction.get(key);
        if (runnable != null) {
            this.stickyExposureAction.remove(key);
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasLocalCache() {
        JSONObject jSONObject = this.experimentCache;
        return jSONObject != null && jSONObject.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getExposureInfo(String key) {
        return this.exposureManager.getExposureInfo(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAllExposureInfo() {
        return this.exposureManager.getAllExposureInfo();
    }

    public void updateUserId(String userId) {
        this.exposureManager.updateUserId(userId);
    }

    public String getUserVids(String uid) {
        return this.exposureManager.getUserVids(uid);
    }

    public JSONObject getExperimentCache() {
        return CacheRepository.getJSONObject(this.context, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_CACHE");
    }
}
