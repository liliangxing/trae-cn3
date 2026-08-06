package com.bytedance.dataplatform;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.applog.server.Api;
import com.bytedance.dataplatform.applog.AppLogManager;
import com.bytedance.dataplatform.client.ClientDataSource;
import com.bytedance.dataplatform.client.ClientGroup;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: ClientExperimentManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001e\"\u0004\b\u0000\u0010\u001f2\u0006\u0010 \u001a\u00020\u00072\u000e\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001cH\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007J.\u0010%\u001a\u00020#\"\u0004\b\u0000\u0010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001c2\u0006\u0010 \u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010'\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001e\"\u0004\b\u0000\u0010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001cH\u0002JC\u0010(\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u0001H\u001f2\u0006\u0010,\u001a\u00020-2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001c¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\u00020-\"\u0004\b\u0000\u0010\u001f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001cH\u0002J\u001a\u00100\u001a\u00020#2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0015J\u000e\u00102\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R[\u0010\u0005\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00040\u0004 \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\t0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0019\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/dataplatform/ClientExperimentManager;", "", "()V", "MAX_NUM", "", "clientExperimentLayer", "", "", "kotlin.jvm.PlatformType", "", "getClientExperimentLayer", "()Ljava/util/Map;", "clientExperimentLayer$delegate", "Lkotlin/Lazy;", "context", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "customRandomStrategy", "Lkotlin/Function1;", "exposureManager", "Lcom/bytedance/dataplatform/ExposureManager;", "key2Vid", "toExposureIds", "", "Lkotlin/Triple;", "Lcom/bytedance/dataplatform/client/ClientDataSource;", "assignClientExperimentValue", "Lcom/bytedance/dataplatform/client/ClientGroup;", "T", Api.KEY_ENCRYPT_RESP_KEY, "clientDataSource", "clearLayerAssign", "", "layer", "expose", "vid", "getOrAssignExperimentGroup", "getValue", "classType", "Ljava/lang/reflect/Type;", "defaultValue", "withExposure", "", "(Ljava/lang/String;Ljava/lang/reflect/Type;Ljava/lang/Object;ZLcom/bytedance/dataplatform/client/ClientDataSource;)Ljava/lang/Object;", "isDefinitionError", "setCustomRandomStrategy", "supplier", "setExposureManager", "experiment_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ClientExperimentManager {
    private static final int MAX_NUM = 1000;
    private static Application context;
    private static Function1<? super String, Integer> customRandomStrategy;
    private static ExposureManager exposureManager;
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ClientExperimentManager.class), "clientExperimentLayer", "getClientExperimentLayer()Ljava/util/Map;"))};
    public static final ClientExperimentManager INSTANCE = new ClientExperimentManager();
    private static final List<Triple<String, ClientDataSource<?>, String>> toExposureIds = new CopyOnWriteArrayList();
    private static final Map<String, String> key2Vid = new HashMap();

    /* renamed from: clientExperimentLayer$delegate, reason: from kotlin metadata */
    private static final Lazy clientExperimentLayer = LazyKt.lazy(new Function0<Map<String, Integer>>() { // from class: com.bytedance.dataplatform.ClientExperimentManager$clientExperimentLayer$2
        public final Map<String, Integer> invoke() {
            return CacheRepository.getAllInteger(ClientExperimentManager.INSTANCE.getContext(), "CLIENT_EXPERIMENT_CACHE_TAG");
        }
    });

    private final Map<String, Integer> getClientExperimentLayer() {
        Lazy lazy = clientExperimentLayer;
        KProperty kProperty = $$delegatedProperties[0];
        return (Map) lazy.getValue();
    }

    private ClientExperimentManager() {
    }

    public static final /* synthetic */ ExposureManager access$getExposureManager$p(ClientExperimentManager clientExperimentManager) {
        ExposureManager exposureManager2 = exposureManager;
        if (exposureManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("exposureManager");
        }
        return exposureManager2;
    }

    public final Application getContext() {
        return context;
    }

    public final void setContext(Application application) {
        context = application;
    }

    public final void setExposureManager(final ExposureManager exposureManager2) {
        Intrinsics.checkParameterIsNotNull(exposureManager2, "exposureManager");
        if (exposureManager == null) {
            Log.d("Experiment:", "setExposureManager");
            exposureManager = exposureManager2;
            Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.ClientExperimentManager$setExposureManager$2
                @Override // java.lang.Runnable
                public final void run() {
                    List<Triple> list;
                    ClientExperimentManager clientExperimentManager = ClientExperimentManager.INSTANCE;
                    list = ClientExperimentManager.toExposureIds;
                    for (Triple triple : list) {
                        ExposureManager.this.exposeClient((String) triple.getFirst(), (ClientDataSource) triple.getSecond(), (String) triple.getThird());
                    }
                }
            });
        }
    }

    public final <T> T getValue(String key, Type classType, T defaultValue, boolean withExposure, ClientDataSource<T> clientDataSource) {
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkParameterIsNotNull(classType, "classType");
        if (context == null) {
            throw new RuntimeException("ExperimentManager has not set context");
        }
        if (ExperimentManager.stickyCache.containsKey(key)) {
            Object obj = ExperimentManager.stickyCache.get(key);
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            if (Intrinsics.areEqual(obj.getClass(), classType)) {
                if (withExposure) {
                    Map<String, String> map = key2Vid;
                    if (map.containsKey(key)) {
                        String str = map.get(key);
                        if (clientDataSource == null) {
                            Intrinsics.throwNpe();
                        }
                        expose(clientDataSource, key, str);
                    }
                }
                return (T) ExperimentManager.returnValue(key, ExperimentManager.stickyCache.get(key), true, "sticky", clientDataSource);
            }
        }
        ClientGroup<T> assignClientExperimentValue = assignClientExperimentValue(key, clientDataSource);
        if (assignClientExperimentValue != null) {
            if (withExposure) {
                if (clientDataSource == null) {
                    Intrinsics.throwNpe();
                }
                expose(clientDataSource, key, assignClientExperimentValue.getVid());
            }
            Map<String, String> map2 = key2Vid;
            String vid = assignClientExperimentValue.getVid();
            Intrinsics.checkExpressionValueIsNotNull(vid, "value.vid");
            map2.put(key, vid);
            return (T) ExperimentManager.returnValue(key, assignClientExperimentValue.getResult(), true, "client", clientDataSource);
        }
        return (T) ExperimentManager.returnValue(key, defaultValue, true, "default", clientDataSource);
    }

    private final <T> ClientGroup<T> assignClientExperimentValue(String key, ClientDataSource<T> clientDataSource) {
        if (isDefinitionError(clientDataSource)) {
            return null;
        }
        if (clientDataSource == null) {
            Intrinsics.throwNpe();
        }
        ClientGroup<T> orAssignExperimentGroup = getOrAssignExperimentGroup(clientDataSource);
        if (orAssignExperimentGroup != null) {
            return orAssignExperimentGroup;
        }
        expose(clientDataSource, key, null);
        return null;
    }

    private final <T> boolean isDefinitionError(ClientDataSource<T> clientDataSource) {
        if (clientDataSource == null || TextUtils.isEmpty(clientDataSource.getLayer()) || clientDataSource.getClientGroup() == null) {
            return true;
        }
        ClientGroup<T>[] clientGroup = clientDataSource.getClientGroup();
        Intrinsics.checkExpressionValueIsNotNull(clientGroup, "clientDataSource.clientGroup");
        return clientGroup.length == 0;
    }

    private final <T> void expose(final ClientDataSource<T> clientDataSource, final String key, final String vid) {
        if (exposureManager != null) {
            Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.ClientExperimentManager$expose$2
                @Override // java.lang.Runnable
                public final void run() {
                    ClientExperimentManager.access$getExposureManager$p(ClientExperimentManager.INSTANCE).exposeClient(key, clientDataSource, vid);
                }
            });
        } else {
            toExposureIds.add(new Triple<>(key, clientDataSource, vid));
        }
    }

    public final void clearLayerAssign(String layer) {
        Intrinsics.checkParameterIsNotNull(layer, "layer");
        if (getClientExperimentLayer().containsKey(layer)) {
            CacheRepository.removeKey(context, "CLIENT_EXPERIMENT_CACHE_TAG", layer);
        }
    }

    private final <T> ClientGroup<T> getOrAssignExperimentGroup(ClientDataSource<T> clientDataSource) {
        int nextInt;
        int i;
        String layer = clientDataSource.getLayer();
        if (getClientExperimentLayer().containsKey(layer)) {
            Integer num = getClientExperimentLayer().get(layer);
            if (num == null) {
                Intrinsics.throwNpe();
            }
            i = num.intValue();
        } else {
            Function1<? super String, Integer> function1 = customRandomStrategy;
            if (function1 != null) {
                Intrinsics.checkExpressionValueIsNotNull(layer, "layer");
                Integer num2 = (Integer) function1.invoke(layer);
                if (num2 != null) {
                    nextInt = num2.intValue();
                    if (nextInt >= 0 || nextInt >= 1000) {
                        nextInt = ((nextInt % 1000) + 1000) % 1000;
                    }
                    Map<String, Integer> clientExperimentLayer2 = getClientExperimentLayer();
                    Intrinsics.checkExpressionValueIsNotNull(clientExperimentLayer2, "clientExperimentLayer");
                    clientExperimentLayer2.put(layer, Integer.valueOf(nextInt));
                    CacheRepository.saveInt(context, "CLIENT_EXPERIMENT_CACHE_TAG", layer, nextInt);
                    AppLogManager.sendLocalStrategyEvent(layer, Integer.valueOf(nextInt));
                    i = nextInt;
                }
            }
            nextInt = new Random().nextInt(1000);
            if (nextInt >= 0) {
            }
            nextInt = ((nextInt % 1000) + 1000) % 1000;
            Map<String, Integer> clientExperimentLayer22 = getClientExperimentLayer();
            Intrinsics.checkExpressionValueIsNotNull(clientExperimentLayer22, "clientExperimentLayer");
            clientExperimentLayer22.put(layer, Integer.valueOf(nextInt));
            CacheRepository.saveInt(context, "CLIENT_EXPERIMENT_CACHE_TAG", layer, nextInt);
            AppLogManager.sendLocalStrategyEvent(layer, Integer.valueOf(nextInt));
            i = nextInt;
        }
        double d = 1000;
        int start = (int) (clientDataSource.getStart() * d);
        if (i < start) {
            return null;
        }
        for (ClientGroup<T> clientGroup : clientDataSource.getClientGroup()) {
            if (clientGroup != null && i < (start = start + ((int) (clientGroup.getPercent() * d)))) {
                return clientGroup;
            }
        }
        return null;
    }

    public final void setCustomRandomStrategy(Function1<? super String, Integer> supplier) {
        Intrinsics.checkParameterIsNotNull(supplier, "supplier");
        customRandomStrategy = supplier;
    }
}
