package com.bytedance.trae.abtest;

import android.util.Pair;
import com.bytedance.article.common.network.SSNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.dataplatform.ExperimentManager;
import com.bytedance.dataplatform.IExperimentListener;
import com.bytedance.dataplatform.IExposureService;
import com.bytedance.dataplatform.INetService;
import com.bytedance.dataplatform.ISerializationService;
import com.bytedance.dataplatform.ISettings;
import com.bytedance.dataplatform.applog.IAppLogService;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.Gson;
import com.larus.abtest.api.IAbTest;
import com.larus.init.IAbTestInitiator;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AbTestInitiator.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u000b\u000e\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/abtest/AbTestInitiator;", "Lcom/larus/init/IAbTestInitiator;", "<init>", "()V", "AB_TEST_SDK_HOST", "", "getAB_TEST_SDK_HOST", "()Ljava/lang/String;", "initAbTest", "", "settings", "com/bytedance/trae/abtest/AbTestInitiator$settings$1", "Lcom/bytedance/trae/abtest/AbTestInitiator$settings$1;", "serializationService", "com/bytedance/trae/abtest/AbTestInitiator$serializationService$1", "Lcom/bytedance/trae/abtest/AbTestInitiator$serializationService$1;", "exposureService", "Lcom/bytedance/dataplatform/IExposureService;", "netService", "Lcom/bytedance/dataplatform/INetService;", "experimentListener", "Lcom/bytedance/dataplatform/IExperimentListener;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AbTestInitiator implements IAbTestInitiator {
    public static final String TAG = "InitAbTest";
    private final String AB_TEST_SDK_HOST = "https://libravm-nontt.byteintlapi.com/common";
    private final AbTestInitiator$settings$1 settings = new ISettings() { // from class: com.bytedance.trae.abtest.AbTestInitiator$settings$1
        public <T> T getValue(String key, Type tClass, T defaultValue) {
            Intrinsics.checkNotNullParameter(tClass, "tClass");
            return null;
        }
    };
    private final AbTestInitiator$serializationService$1 serializationService = new ISerializationService() { // from class: com.bytedance.trae.abtest.AbTestInitiator$serializationService$1
        private final Gson gson = new Gson();

        /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #0 {all -> 0x002f, blocks: (B:4:0x0007, B:7:0x000f, B:9:0x001a, B:14:0x0026), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String object2Json(Object instance) {
            boolean z;
            try {
                if (instance == null) {
                    FLogger.INSTANCE.w(AbTestInitiator.TAG, "object2Json: instance is null");
                    return "{}";
                }
                String json = this.gson.toJson(instance);
                String str = json;
                if (str != null && str.length() != 0) {
                    z = false;
                    if (z) {
                        return json;
                    }
                    FLogger.INSTANCE.w(AbTestInitiator.TAG, "object2Json: result is empty");
                    return "{}";
                }
                z = true;
                if (z) {
                }
            } catch (Throwable th) {
                FLogger.INSTANCE.e(AbTestInitiator.TAG, "object2Json: Failed to parse OBJECT to JSON: " + th.getMessage(), th);
                return "{}";
            }
        }

        public <T> T parseObject(String input, Type clazz) {
            try {
                String str = input;
                if ((str == null || str.length() == 0) || clazz == null) {
                    FLogger.INSTANCE.w(AbTestInitiator.TAG, "parseObject: input is " + input + ",clazz is " + clazz);
                    return null;
                }
                T t = (T) this.gson.fromJson(input, clazz);
                if (t == null) {
                    FLogger.INSTANCE.w(AbTestInitiator.TAG, "parseObject: input is " + input + ",clazz is " + clazz + ", result is null");
                    return null;
                }
                FLogger.INSTANCE.i(AbTestInitiator.TAG, "parseObject success, result: " + t);
                return t;
            } catch (Throwable th) {
                FLogger.INSTANCE.e(AbTestInitiator.TAG, "parseObject:Failed to parse JSON to OBJECT, input is " + input + ",clazz is " + clazz + ", " + th.getMessage(), th);
                return null;
            }
        }
    };
    private final IExposureService exposureService = new IExposureService() { // from class: com.bytedance.trae.abtest.AbTestInitiator$$ExternalSyntheticLambda0
        public final void expose(String str) {
            AbTestInitiator.exposureService$lambda$3(str);
        }
    };
    private final INetService netService = new INetService() { // from class: com.bytedance.trae.abtest.AbTestInitiator$$ExternalSyntheticLambda1
        public final String request(String str) {
            String netService$lambda$4;
            netService$lambda$4 = AbTestInitiator.netService$lambda$4(str);
            return netService$lambda$4;
        }
    };
    private final IExperimentListener experimentListener = new IExperimentListener() { // from class: com.bytedance.trae.abtest.AbTestInitiator$$ExternalSyntheticLambda2
        public final void onLibraExperimentChanged(JSONObject jSONObject) {
            AbTestInitiator.experimentListener$lambda$5(jSONObject);
        }
    };

    public final String getAB_TEST_SDK_HOST() {
        return this.AB_TEST_SDK_HOST;
    }

    public void initAbTest() {
        ExperimentManager.waitWhenNotInit();
        ExperimentManager.setAppLogService(new IAppLogService() { // from class: com.bytedance.trae.abtest.AbTestInitiator$$ExternalSyntheticLambda3
            public final void onEventV3(String str, JSONObject jSONObject) {
                AbTestInitiator.initAbTest$lambda$0(str, jSONObject);
            }
        }, true, true);
        ExperimentManager.setExperimentListener(this.experimentListener);
        ExperimentManager.init(AppHost.INSTANCE.getApplication(), this.AB_TEST_SDK_HOST, true, this.settings, this.serializationService, this.exposureService, this.netService);
        IApplog.INSTANCE.doWhenIdsReady(new Function2() { // from class: com.bytedance.trae.abtest.AbTestInitiator$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit initAbTest$lambda$1;
                initAbTest$lambda$1 = AbTestInitiator.initAbTest$lambda$1((String) obj, (String) obj2);
                return initAbTest$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAbTest$lambda$0(String str, JSONObject jSONObject) {
        IApplog.Companion companion = IApplog.INSTANCE;
        Intrinsics.checkNotNull(str);
        companion.reportEvent(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAbTest$lambda$1(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "did");
        Intrinsics.checkNotNullParameter(str2, "iid");
        IAbTest iAbTest = (IAbTest) ServiceManager.get().getService(IAbTest.class);
        if (iAbTest != null) {
            iAbTest.refresh();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exposureService$lambda$3(String str) {
        if (str != null) {
            FLogger.INSTANCE.i(TAG, "--->>>>> onExposure --->>>>>: " + str);
            IApplog.INSTANCE.setExternalAbVersionFromAbTest(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String netService$lambda$4(String str) {
        try {
            SSNetworkClient sSNetworkClient = new SSNetworkClient();
            HashMap hashMap = new HashMap();
            Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.abtest.AbTestInitiator$netService$1$tag$1
                public int triggerType() {
                    return 0;
                }
            });
            hashMap.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
            NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
            reqContext.addCommonParams = true;
            String str2 = sSNetworkClient.get(str, hashMap, reqContext);
            FLogger.INSTANCE.d(TAG, "GET url: " + str);
            FLogger.INSTANCE.d(TAG, "GET result:\n " + str2);
            return str2;
        } catch (Throwable th) {
            FLogger.INSTANCE.e(TAG, "url = " + str, th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void experimentListener$lambda$5(JSONObject jSONObject) {
        FLogger.INSTANCE.i(TAG, "onLibraExperimentChanged: " + jSONObject);
    }
}
