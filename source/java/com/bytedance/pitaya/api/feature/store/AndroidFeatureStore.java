package com.bytedance.pitaya.api.feature.store;

import android.util.Log;
import com.bytedance.mt.protector.ThrowableDisposer;
import com.bytedance.notification.Constants;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pitaya.api.PTYNormalCallback;
import com.bytedance.pitaya.api.PitayaProxy;
import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYErrorCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AndroidFeatureStore.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J8\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016J\u001e\u0010%\u001a\u00020\t2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020\u0015H\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0015H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0016J \u0010.\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010#\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u0002022\u0006\u0010#\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u00112\u0006\u0010#\u001a\u000203H\u0016J \u00106\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0016J\u0018\u00108\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J \u00109\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0016J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010<\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J \u0010=\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0016J0\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00042\u0006\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006C"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/AndroidFeatureStore;", "Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "dumpFeature", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/pitaya/api/feature/store/PTYModelInstance;", "value", "innerFeatureStore", "getInnerFeatureStore", "()Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "setInnerFeatureStore", "(Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;)V", "producers", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureProducer;", "getProducers$pitayacore_release", "()Ljava/util/concurrent/ConcurrentHashMap;", "addFeature", "", "name", "", "group", "Lorg/json/JSONObject;", "endSession", "featureName", "groupName", "getFeature", "", "queryType", "", ThrowableDisposer.ConfItem.RETURN_TYPE, "n", "callback", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureCallback;", "getGroupFeature", "query", "", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureGroupQuery;", "dump", "getModelInstance", "instanceId", "pop", "getRegisteredProducer", "registerCppCallback", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureChangeCallback;", "registerFeatureGroup", "featureGroup", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureGroup;", "Lcom/bytedance/pitaya/api/PTYNormalCallback;", "registerFeatureProducer", "featureProducer", "registerPyCallback", "business", "startSession", "unregisterCppCallback", "id", "unregisterFeatureGroup", "unregisterFeatureProducer", "unregisterPyCallback", "upload", "modelInstance", "sampleRate", IPiaCacheProvider.CacheConfig.FIELD_VERSION, Constants.NOTIFICATION_TAG, "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidFeatureStore implements IFeatureStore {
    private IFeatureStore innerFeatureStore;
    private final String TAG = "AndroidFeatureStore";
    private final ConcurrentHashMap<String, PTYFeatureProducer> producers = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, PTYModelInstance> dumpFeature = new ConcurrentHashMap<>();

    public final String getTAG() {
        return this.TAG;
    }

    public final IFeatureStore getInnerFeatureStore() {
        return this.innerFeatureStore;
    }

    public final void setInnerFeatureStore(IFeatureStore iFeatureStore) {
        if (iFeatureStore == null || this.innerFeatureStore != null) {
            return;
        }
        synchronized (this) {
            if (this.innerFeatureStore == null) {
                this.innerFeatureStore = iFeatureStore;
                IFeatureStore featureStore = PTYFeatureStoreInstance.INSTANCE.getFeatureStore();
                Intrinsics.checkNotNull(featureStore, "null cannot be cast to non-null type com.bytedance.pitaya.api.feature.store.AndroidFeatureStore");
                Iterator<Map.Entry<String, PTYFeatureProducer>> it = ((AndroidFeatureStore) featureStore).producers.entrySet().iterator();
                while (it.hasNext()) {
                    iFeatureStore.registerFeatureProducer(it.next().getValue(), new PTYNormalCallback() { // from class: com.bytedance.pitaya.api.feature.store.AndroidFeatureStore$innerFeatureStore$1$1
                        @Override // com.bytedance.pitaya.api.PTYNormalCallback
                        public void onResult(boolean success, PTYError error) {
                            Log.i(AndroidFeatureStore.this.getTAG(), String.valueOf(error));
                        }
                    });
                }
                PTYFeatureStoreInstance.INSTANCE.notifyAllListener$pitayacore_release(iFeatureStore);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final ConcurrentHashMap<String, PTYFeatureProducer> getProducers$pitayacore_release() {
        return this.producers;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public void registerFeatureGroup(PTYFeatureGroup featureGroup, PTYNormalCallback callback) {
        Intrinsics.checkNotNullParameter(featureGroup, "featureGroup");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore == null) {
            int code = PTYErrorCode.PITAYA_IMPL_NOT_READY.getCode();
            callback.onResult(false, new PTYError("FeatureStore", code, code, "Pitaya SDK not init", null));
        } else if (iFeatureStore != null) {
            iFeatureStore.registerFeatureGroup(featureGroup, callback);
        }
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean unregisterFeatureGroup(String groupName) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore != null) {
            return iFeatureStore.unregisterFeatureGroup(groupName);
        }
        return false;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public void registerFeatureProducer(PTYFeatureProducer featureProducer, PTYNormalCallback callback) {
        List<String> registeredProducer;
        Intrinsics.checkNotNullParameter(featureProducer, "featureProducer");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String groupName = featureProducer.getGroupName();
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if ((iFeatureStore == null || (registeredProducer = iFeatureStore.getRegisteredProducer()) == null || !registeredProducer.contains(groupName)) ? false : true) {
            int code = PTYErrorCode.INVALID_DATA.getCode();
            callback.onResult(false, new PTYError("FeatureStore", code, code, groupName + " Producer has already been registered", null));
            return;
        }
        synchronized (PTYFeatureStoreInstance.INSTANCE) {
            this.producers.put(groupName, featureProducer);
            IFeatureStore iFeatureStore2 = this.innerFeatureStore;
            if (iFeatureStore2 == null) {
                callback.onResult(true, null);
                Unit unit = Unit.INSTANCE;
            } else if (iFeatureStore2 != null) {
                iFeatureStore2.registerFeatureProducer(featureProducer, callback);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean unregisterFeatureProducer(String groupName) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore != null) {
            return iFeatureStore.unregisterFeatureProducer(groupName);
        }
        return false;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public List<String> getRegisteredProducer() {
        Enumeration<String> keys = this.producers.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "producers.keys()");
        ArrayList list = Collections.list(keys);
        Intrinsics.checkNotNullExpressionValue(list, "list(this)");
        return list;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean startSession(String featureName, String groupName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore != null) {
            return iFeatureStore.startSession(featureName, groupName);
        }
        return false;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean endSession(String featureName, String groupName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore != null) {
            return iFeatureStore.endSession(featureName, groupName);
        }
        return false;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean addFeature(String name, float value, String group) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(group, "group");
        if (this.innerFeatureStore == null && PitayaProxy.isFeatureStoreProxyEnabled()) {
            Log.e(this.TAG, "FeatureStoreProxy is no longer available!!!");
            return false;
        }
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore != null) {
            return iFeatureStore.addFeature(name, value, group);
        }
        return false;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean addFeature(String name, String value, String group) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(group, "group");
        if (this.innerFeatureStore == null && PitayaProxy.isFeatureStoreProxyEnabled()) {
            Log.e(this.TAG, "FeatureStoreProxy is no longer available!!!");
            return false;
        }
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore != null) {
            return iFeatureStore.addFeature(name, value, group);
        }
        return false;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean addFeature(String name, JSONObject value, String group) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(group, "group");
        if (this.innerFeatureStore == null && PitayaProxy.isFeatureStoreProxyEnabled()) {
            Log.e(this.TAG, "FeatureStoreProxy is no longer available!!!");
            return false;
        }
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore != null) {
            return iFeatureStore.addFeature(name, value, group);
        }
        return false;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public void getFeature(String featureName, String groupName, int queryType, int returnType, int n, PTYFeatureCallback callback) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore == null) {
            int code = PTYErrorCode.PITAYA_IMPL_NOT_READY.getCode();
            callback.onResult(false, new PTYError("FeatureStore", code, code, "Pitaya SDK not init", null), "");
        } else if (iFeatureStore != null) {
            iFeatureStore.getFeature(featureName, groupName, queryType, returnType, n, callback);
        }
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public String registerCppCallback(String groupName, String featureName, PTYFeatureChangeCallback callback) {
        String registerCppCallback;
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        return (iFeatureStore == null || (registerCppCallback = iFeatureStore.registerCppCallback(groupName, featureName, callback)) == null) ? "" : registerCppCallback;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public String registerPyCallback(String groupName, String featureName, String business) {
        String registerPyCallback;
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(business, "business");
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        return (iFeatureStore == null || (registerPyCallback = iFeatureStore.registerPyCallback(groupName, featureName, business)) == null) ? "" : registerPyCallback;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public void unregisterCppCallback(String groupName, String featureName, String id) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(id, "id");
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore != null) {
            iFeatureStore.unregisterCppCallback(groupName, featureName, id);
        }
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public void unregisterPyCallback(String groupName, String featureName, String id) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(id, "id");
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore != null) {
            iFeatureStore.unregisterPyCallback(groupName, featureName, id);
        }
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public PTYModelInstance getGroupFeature(List<PTYFeatureGroupQuery> query, boolean dump) {
        IFeatureStore iFeatureStore;
        PTYModelInstance groupFeature;
        JSONObject features;
        Intrinsics.checkNotNullParameter(query, "query");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        PTYModelInstance pTYModelInstance = new PTYModelInstance(uuid, "{}");
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        List<String> registeredProducer = getRegisteredProducer();
        for (PTYFeatureGroupQuery pTYFeatureGroupQuery : query) {
            if (!registeredProducer.contains(pTYFeatureGroupQuery.getGroupName())) {
                arrayList.add(pTYFeatureGroupQuery);
            } else {
                PTYFeatureProducer pTYFeatureProducer = this.producers.get(pTYFeatureGroupQuery.getGroupName());
                if (pTYFeatureProducer != null) {
                    for (PTYFeatureQuery pTYFeatureQuery : pTYFeatureGroupQuery.getQueries()) {
                        if (pTYFeatureQuery.getQueryType() == 200) {
                            JSONObject jSONObject2 = null;
                            if (pTYFeatureQuery.getExtParams() != null) {
                                try {
                                    jSONObject2 = new JSONObject(pTYFeatureQuery.getExtParams());
                                } catch (JSONException unused) {
                                }
                            }
                            switch (pTYFeatureQuery.getReturnType()) {
                                case 200:
                                    jSONObject.put(pTYFeatureQuery.getReturnFeatureName(), Float.valueOf(pTYFeatureProducer.getNumericFeature(pTYFeatureQuery.getFeatureName(), jSONObject2)));
                                    break;
                                case 201:
                                    jSONObject.put(pTYFeatureQuery.getReturnFeatureName(), pTYFeatureProducer.getStringFeature(pTYFeatureQuery.getFeatureName(), jSONObject2));
                                    break;
                                case 202:
                                    jSONObject.put(pTYFeatureQuery.getReturnFeatureName(), pTYFeatureProducer.getDictFeature(pTYFeatureQuery.getFeatureName(), jSONObject2));
                                    break;
                                case 203:
                                    jSONObject.put(pTYFeatureQuery.getReturnFeatureName(), pTYFeatureProducer.getSeqFeature(pTYFeatureQuery.getFeatureName(), jSONObject2));
                                    break;
                            }
                        }
                    }
                }
            }
        }
        if ((!arrayList.isEmpty()) && (iFeatureStore = this.innerFeatureStore) != null && iFeatureStore != null && (groupFeature = iFeatureStore.getGroupFeature(arrayList, false)) != null && (features = groupFeature.getFeatures()) != null) {
            Iterator<String> keys = features.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "it.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, features.get(next));
            }
        }
        pTYModelInstance.updateFeatures$pitayacore_release(jSONObject);
        if (dump) {
            this.dumpFeature.put(pTYModelInstance.getInstanceID(), pTYModelInstance);
        }
        return pTYModelInstance;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public PTYModelInstance getModelInstance(String instanceId, boolean pop) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        if (pop) {
            return this.dumpFeature.remove(instanceId);
        }
        return this.dumpFeature.get(instanceId);
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean upload(PTYModelInstance modelInstance, float sampleRate, String business, int version, String tag) {
        Intrinsics.checkNotNullParameter(modelInstance, "modelInstance");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        IFeatureStore iFeatureStore = this.innerFeatureStore;
        if (iFeatureStore != null) {
            return iFeatureStore.upload(modelInstance, sampleRate, business, version, tag);
        }
        return false;
    }
}
