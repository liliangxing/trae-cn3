package com.bytedance.apm6;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.CommonParams;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.DeviceInfoUtil;
import com.bytedance.apm.util.SlardarProperties;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.hub.Apm;
import com.bytedance.apm6.hub.ApmAdapter;
import com.bytedance.apm6.memory.IMapsCollectService;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.ies.argus.bean.ArgusConstants;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Apm6 {
    static final String OUTSIDE_MAX_SIZE_MB_TODAY = "max_size_mb_today";
    private static List<IResponseConfigListener> mConfigListeners;

    public static Runnable init(final Context context) {
        return Apm.initWithAsync(new ApmAdapter() { // from class: com.bytedance.apm6.Apm6.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.apm6.hub.ApmAdapter
            public IHttpService createHttpService() {
                return ApmContext.getHttpService();
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public Context getContext() {
                return context;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public int getAid() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getAid();
                }
                return 0;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public String getDeviceId() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getDeviceId();
                }
                return null;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public long getUid() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getUid();
                }
                return 0L;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public String getSessionId() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getSession();
                }
                return null;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public String getProcessName() {
                return ApmContext.getCurrentProcessName();
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public String getChannel() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getChannel();
                }
                return null;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public int getUpdateVersionCode() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getUpdateVersionCode();
                }
                return 0;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public String getVersionName() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getVersionName();
                }
                return null;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public int getVersionCode() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getUpdateVersionCode();
                }
                return 0;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public String getAppVersion() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getAppVersion();
                }
                return null;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public String getReleaseBuild() {
                CommonParams params = ApmContext.getParams();
                String releaseBuild = params != null ? params.getReleaseBuild() : null;
                return (TextUtils.isEmpty(releaseBuild) || Objects.equals(releaseBuild, ArgusConstants.NULL_PLACE_HOLDER)) ? SlardarProperties.getReleaseBuild() : releaseBuild;
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public int getManifestVersionCode() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getManifestVersionCode();
                }
                return 0;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.apm6.hub.ApmAdapter
            public IEncrypt createEncryptServiceImpl() {
                return ApmDelegate.getInstance().getEncrypt();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.apm6.hub.ApmAdapter
            public EncryptService createEncryptRequestServiceImpl() {
                return new EncryptService() { // from class: com.bytedance.apm6.Apm6.1.1
                    @Override // com.bytedance.apm6.service.encrypt.EncryptService
                    public String tryEncryptRequest(String str, List<Pair<String, String>> list) {
                        return RequestEncryptUtils.tryEncryptRequest(str, list);
                    }
                };
            }

            @Override // com.bytedance.apm6.hub.ApmAdapter, com.bytedance.apm6.foundation.context.ApmContextAdapter
            public JSONObject getStableHeaderExtras() {
                CommonParams params = ApmContext.getParams();
                if (params != null) {
                    return params.getStaticHeaderExtras();
                }
                return null;
            }

            @Override // com.bytedance.apm6.hub.ApmAdapter, com.bytedance.apm6.foundation.context.ApmContextAdapter
            public JSONObject getDynamicHeaderExtras() {
                return super.getDynamicHeaderExtras();
            }

            @Override // com.bytedance.apm6.hub.ApmAdapter, com.bytedance.apm6.foundation.context.ApmContextAdapter
            public Map<String, String> getParamsExtras() {
                return ApmContext.getParamsExtras();
            }

            @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
            public JSONObject getOutsideConfig() {
                JSONObject staticHeaderExtras;
                CommonParams params = ApmContext.getParams();
                if (params == null || (staticHeaderExtras = params.getStaticHeaderExtras()) == null) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("max_size_mb_today", staticHeaderExtras.optInt("max_size_mb_today", -1));
                    return jSONObject;
                } catch (JSONException unused) {
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.apm6.hub.ApmAdapter
            public SlardarResponseService createSlardarResponseService() {
                return new SlardarResponseService() { // from class: com.bytedance.apm6.Apm6.1.2
                    @Override // com.bytedance.apm6.consumer.slardar.SlardarResponseService
                    public void onResponse(final JSONObject jSONObject) {
                        if (ApmContext.isMainProcess()) {
                            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm6.Apm6.1.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Apm6.dispatchSlardarResponse(jSONObject);
                                }
                            });
                        }
                    }
                };
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.apm6.hub.ApmAdapter
            public MemoryConfigService createMemoryConfigService() {
                return new DefaultMemoryConfigService();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.apm6.hub.ApmAdapter
            public IMapsCollectService createMapsCollectService() {
                return new DefaultMapsCollectService();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.apm6.hub.ApmAdapter
            public IDeviceInfoService createDeviceInfoService() {
                return new IDeviceInfoService() { // from class: com.bytedance.apm6.Apm6.1.3
                    @Override // com.bytedance.apm6.service.device.IDeviceInfoService
                    public JSONObject getDeviceInfo() {
                        JSONObject jSONObject = new JSONObject();
                        DeviceInfoUtil.getInstance().addConstantDeviceInfo(jSONObject);
                        return jSONObject;
                    }
                };
            }

            @Override // com.bytedance.apm6.hub.ApmAdapter
            public MonitorableInterceptor getInterceptor() {
                return ApmContext.getInterceptor();
            }
        });
    }

    public static void registerResponseConfigListener(IResponseConfigListener iResponseConfigListener) {
        if (iResponseConfigListener == null) {
            return;
        }
        if (mConfigListeners == null) {
            mConfigListeners = new CopyOnWriteArrayList();
        }
        if (mConfigListeners.contains(iResponseConfigListener)) {
            return;
        }
        mConfigListeners.add(iResponseConfigListener);
    }

    public static void unregisterResponseConfigListener(IResponseConfigListener iResponseConfigListener) {
        List<IResponseConfigListener> list;
        if (iResponseConfigListener == null || (list = mConfigListeners) == null) {
            return;
        }
        list.remove(iResponseConfigListener);
    }

    public static void dispatchSlardarResponse(JSONObject jSONObject) {
        List<IResponseConfigListener> list = mConfigListeners;
        if (list != null) {
            Iterator<IResponseConfigListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onResponse(jSONObject);
            }
        }
    }
}
