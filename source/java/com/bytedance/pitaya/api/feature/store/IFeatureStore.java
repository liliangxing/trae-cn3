package com.bytedance.pitaya.api.feature.store;

import com.bytedance.mt.protector.ThrowableDisposer;
import com.bytedance.notification.Constants;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pitaya.api.PTYNormalCallback;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.json.JSONObject;

/* compiled from: IFeatureStore.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u0000 52\u00020\u0001:\u00015J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H'J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H'J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H'J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H'J>\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H'J \u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u0003H'J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u0003H'J\u0010\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018H'J \u0010\u001f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020 H'J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020$H'J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020$H'J \u0010(\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H'J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H'J \u0010+\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H'J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H'J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H'J \u0010/\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H'J4\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\u00102\b\b\u0002\u00104\u001a\u00020\u0005H'¨\u00066"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "addFeature", "", "name", "", "value", "", "group", "Lorg/json/JSONObject;", "endSession", "featureName", "groupName", "getFeature", "", "queryType", "", ThrowableDisposer.ConfItem.RETURN_TYPE, "n", "callback", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureCallback;", "getGroupFeature", "Lcom/bytedance/pitaya/api/feature/store/PTYModelInstance;", "query", "", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureGroupQuery;", "dump", "getModelInstance", "instanceId", "pop", "getRegisteredProducer", "registerCppCallback", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureChangeCallback;", "registerFeatureGroup", "featureGroup", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureGroup;", "Lcom/bytedance/pitaya/api/PTYNormalCallback;", "registerFeatureProducer", "featureProducer", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureProducer;", "registerPyCallback", "business", "startSession", "unregisterCppCallback", "id", "unregisterFeatureGroup", "unregisterFeatureProducer", "unregisterPyCallback", "upload", "modelInstance", "sampleRate", IPiaCacheProvider.CacheConfig.FIELD_VERSION, Constants.NOTIFICATION_TAG, "Companion", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IFeatureStore extends ReflectionCall {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int PTYFEQueryTypeCustom = 200;
    public static final int PTYFEQueryTypeKV = 0;
    public static final int PTYFEQueryTypeLastN = 2;
    public static final int PTYFEQueryTypeLastNDay = 4;
    public static final int PTYFEQueryTypeSessionLastN = 5;
    public static final int PTYFEQueryTypeTimeNDay = 3;
    public static final int PTYFEQueryTypeTimeNSecond = 1;
    public static final int PTYFEQueryTypeUnknown = 99;
    public static final int PTYFERetTypeAvg = 6;
    public static final int PTYFERetTypeCount = 3;
    public static final int PTYFERetTypeCustomDict = 202;
    public static final int PTYFERetTypeCustomNumeric = 200;
    public static final int PTYFERetTypeCustomSeq = 203;
    public static final int PTYFERetTypeCustomString = 201;
    public static final int PTYFERetTypeDetails = 1;
    public static final int PTYFERetTypeKV = 0;
    public static final int PTYFERetTypeMax = 5;
    public static final int PTYFERetTypeMin = 4;
    public static final int PTYFERetTypePairDetails = 7;
    public static final int PTYFERetTypeSum = 2;
    public static final int PTYFERetTypeUnknown = 99;

    boolean addFeature(String name, float value, String group);

    boolean addFeature(String name, String value, String group);

    boolean addFeature(String name, JSONObject value, String group);

    boolean endSession(String featureName, String groupName);

    void getFeature(String featureName, String groupName, int queryType, int returnType, int n, PTYFeatureCallback callback);

    PTYModelInstance getGroupFeature(List<PTYFeatureGroupQuery> query, boolean dump);

    PTYModelInstance getModelInstance(String instanceId, boolean pop);

    List<String> getRegisteredProducer();

    String registerCppCallback(String groupName, String featureName, PTYFeatureChangeCallback callback);

    void registerFeatureGroup(PTYFeatureGroup featureGroup, PTYNormalCallback callback);

    void registerFeatureProducer(PTYFeatureProducer featureProducer, PTYNormalCallback callback);

    String registerPyCallback(String groupName, String featureName, String business);

    boolean startSession(String featureName, String groupName);

    void unregisterCppCallback(String groupName, String featureName, String id);

    boolean unregisterFeatureGroup(String groupName);

    boolean unregisterFeatureProducer(String groupName);

    void unregisterPyCallback(String groupName, String featureName, String id);

    boolean upload(PTYModelInstance modelInstance, float sampleRate, String business, int version, String tag);

    /* compiled from: IFeatureStore.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/IFeatureStore$Companion;", "", "()V", "PTYFEQueryTypeCustom", "", "PTYFEQueryTypeKV", "PTYFEQueryTypeLastN", "PTYFEQueryTypeLastNDay", "PTYFEQueryTypeSessionLastN", "PTYFEQueryTypeTimeNDay", "PTYFEQueryTypeTimeNSecond", "PTYFEQueryTypeUnknown", "PTYFERetTypeAvg", "PTYFERetTypeCount", "PTYFERetTypeCustomDict", "PTYFERetTypeCustomNumeric", "PTYFERetTypeCustomSeq", "PTYFERetTypeCustomString", "PTYFERetTypeDetails", "PTYFERetTypeKV", "PTYFERetTypeMax", "PTYFERetTypeMin", "PTYFERetTypePairDetails", "PTYFERetTypeSum", "PTYFERetTypeUnknown", "PTYQueryFeatureType", "PTYReturnFeatureType", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int PTYFEQueryTypeCustom = 200;
        public static final int PTYFEQueryTypeKV = 0;
        public static final int PTYFEQueryTypeLastN = 2;
        public static final int PTYFEQueryTypeLastNDay = 4;
        public static final int PTYFEQueryTypeSessionLastN = 5;
        public static final int PTYFEQueryTypeTimeNDay = 3;
        public static final int PTYFEQueryTypeTimeNSecond = 1;
        public static final int PTYFEQueryTypeUnknown = 99;
        public static final int PTYFERetTypeAvg = 6;
        public static final int PTYFERetTypeCount = 3;
        public static final int PTYFERetTypeCustomDict = 202;
        public static final int PTYFERetTypeCustomNumeric = 200;
        public static final int PTYFERetTypeCustomSeq = 203;
        public static final int PTYFERetTypeCustomString = 201;
        public static final int PTYFERetTypeDetails = 1;
        public static final int PTYFERetTypeKV = 0;
        public static final int PTYFERetTypeMax = 5;
        public static final int PTYFERetTypeMin = 4;
        public static final int PTYFERetTypePairDetails = 7;
        public static final int PTYFERetTypeSum = 2;
        public static final int PTYFERetTypeUnknown = 99;

        /* compiled from: IFeatureStore.kt */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/IFeatureStore$Companion$PTYQueryFeatureType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public @interface PTYQueryFeatureType {
        }

        /* compiled from: IFeatureStore.kt */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/IFeatureStore$Companion$PTYReturnFeatureType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public @interface PTYReturnFeatureType {
        }

        private Companion() {
        }
    }

    /* compiled from: IFeatureStore.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getFeature$default(IFeatureStore iFeatureStore, String str, String str2, int i, int i2, int i3, PTYFeatureCallback pTYFeatureCallback, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFeature");
            }
            iFeatureStore.getFeature(str, str2, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 1 : i3, pTYFeatureCallback);
        }

        public static /* synthetic */ PTYModelInstance getModelInstance$default(IFeatureStore iFeatureStore, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getModelInstance");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return iFeatureStore.getModelInstance(str, z);
        }

        public static /* synthetic */ boolean upload$default(IFeatureStore iFeatureStore, PTYModelInstance pTYModelInstance, float f, String str, int i, String str2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upload");
            }
            if ((i2 & 8) != 0) {
                i = 0;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                str2 = "";
            }
            return iFeatureStore.upload(pTYModelInstance, f, str, i3, str2);
        }
    }
}
