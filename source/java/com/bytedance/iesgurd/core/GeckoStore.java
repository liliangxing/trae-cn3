package com.bytedance.iesgurd.core;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.IGeckoLowStorageConfig;
import com.bytedance.geckox.model.Resources;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import com.bytedance.iesgurd.settings.SettingsExtra;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoStore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016¢\u0006\u0002\u0010\u0018J3\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\nJ\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001eJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nJ(\u0010 \u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rJ\u0006\u0010\"\u001a\u00020\u0013J\u001e\u0010#\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\f\u001a \u0012\u0004\u0012\u00020\n\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/iesgurd/core/GeckoStore;", "", "()V", "isStorageAvailableRegistered", "", "isStorageAvailableRegisteredBySPI", "lowStorageAvailable", "", "mLowStorageWhiteList", "", "", "Lcom/bytedance/geckox/model/Resources;", "mPrefetchConfigs", "", "", "mSensitiveStorageBlockList", "noLocalAks", "sensitiveStorageAvailable", "addLowStorageWhiteList", "", "accessKey", "groups", "", "channels", "(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V", "addSensitiveStorageBlockList", "getLowStorageWhiteList", "getNoLocalAks", "getSensitiveStorageBlockList", "getStorageAvailableValue", "Lkotlin/Pair;", "isInLocalAks", "registerPrefetchConfigs", "prefetchConfigs", "resetForTest", "validatePrefetchConfig", "channel", "configBundle", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GeckoStore {
    private static boolean isStorageAvailableRegistered;
    private static List<String> noLocalAks;
    public static final GeckoStore INSTANCE = new GeckoStore();
    private static final Map<String, Map<String, List<String>>> mPrefetchConfigs = new ConcurrentHashMap();
    private static final Map<String, Resources> mLowStorageWhiteList = new ConcurrentHashMap();
    private static final Map<String, Resources> mSensitiveStorageBlockList = new ConcurrentHashMap();
    private static boolean isStorageAvailableRegisteredBySPI = true;
    private static int lowStorageAvailable = -1;
    private static int sensitiveStorageAvailable = -1;

    private GeckoStore() {
    }

    public final void registerPrefetchConfigs(String accessKey, Map<String, ? extends List<String>> prefetchConfigs) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(prefetchConfigs, "prefetchConfigs");
        mPrefetchConfigs.put(accessKey, prefetchConfigs);
    }

    public final boolean validatePrefetchConfig(String accessKey, String channel, String configBundle) {
        List<String> list;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(configBundle, "configBundle");
        Map<String, List<String>> map = mPrefetchConfigs.get(accessKey);
        if (map == null || (list = map.get(channel)) == null) {
            return false;
        }
        return list.contains(configBundle);
    }

    public final void addLowStorageWhiteList(String accessKey, String[] groups, String[] channels) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Map<String, Resources> map = mLowStorageWhiteList;
        Resources resources = map.get(accessKey);
        if (resources == null) {
            resources = new Resources();
            map.put(accessKey, resources);
        }
        if (groups != null) {
            resources.setGroups(ArraysKt.asList(groups));
        }
        if (channels != null) {
            resources.setChannels(ArraysKt.asList(channels));
        }
    }

    public final Resources getLowStorageWhiteList(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        return mLowStorageWhiteList.get(accessKey);
    }

    public final void addSensitiveStorageBlockList(String accessKey, String[] groups, String[] channels) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Map<String, Resources> map = mSensitiveStorageBlockList;
        Resources resources = map.get(accessKey);
        if (resources == null) {
            resources = new Resources();
            map.put(accessKey, resources);
        }
        if (groups != null) {
            resources.setGroups(ArraysKt.asList(groups));
        }
        if (channels != null) {
            resources.setChannels(ArraysKt.asList(channels));
        }
    }

    public final Resources getSensitiveStorageBlockList(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        return mSensitiveStorageBlockList.get(accessKey);
    }

    public final synchronized Pair<Integer, Integer> getStorageAvailableValue() {
        IGeckoLowStorageConfig iGeckoLowStorageConfig;
        Set<Map.Entry> entrySet;
        String[] strArr;
        String[] strArr2;
        List channels;
        List groups;
        Set<Map.Entry> entrySet2;
        String[] strArr3;
        String[] strArr4;
        List channels2;
        List groups2;
        if (isStorageAvailableRegistered) {
            return new Pair<>(Integer.valueOf(lowStorageAvailable), Integer.valueOf(sensitiveStorageAvailable));
        }
        if (isStorageAvailableRegisteredBySPI && (iGeckoLowStorageConfig = (IGeckoLowStorageConfig) ServiceManager.get().getServiceForReal(IGeckoLowStorageConfig.class)) != null) {
            lowStorageAvailable = iGeckoLowStorageConfig.getLowStorageAvailable();
            sensitiveStorageAvailable = iGeckoLowStorageConfig.getSensitiveStorageAvailable();
            if (lowStorageAvailable != -1) {
                isStorageAvailableRegistered = true;
                Map lowStorageWhiteList = iGeckoLowStorageConfig.getLowStorageWhiteList();
                if (lowStorageWhiteList != null && (entrySet2 = lowStorageWhiteList.entrySet()) != null) {
                    for (Map.Entry entry : entrySet2) {
                        GeckoStore geckoStore = INSTANCE;
                        String str = (String) entry.getKey();
                        Resources resources = (Resources) entry.getValue();
                        if (resources == null || (groups2 = resources.getGroups()) == null) {
                            strArr3 = null;
                        } else {
                            Object[] array = groups2.toArray(new String[0]);
                            if (array == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            strArr3 = (String[]) array;
                        }
                        Resources resources2 = (Resources) entry.getValue();
                        if (resources2 == null || (channels2 = resources2.getChannels()) == null) {
                            strArr4 = null;
                        } else {
                            Object[] array2 = channels2.toArray(new String[0]);
                            if (array2 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            strArr4 = (String[]) array2;
                        }
                        geckoStore.addLowStorageWhiteList(str, strArr3, strArr4);
                    }
                }
            }
            if (sensitiveStorageAvailable != -1) {
                isStorageAvailableRegistered = true;
                Map sensitiveStorageBlockList = iGeckoLowStorageConfig.getSensitiveStorageBlockList();
                if (sensitiveStorageBlockList != null && (entrySet = sensitiveStorageBlockList.entrySet()) != null) {
                    for (Map.Entry entry2 : entrySet) {
                        GeckoStore geckoStore2 = INSTANCE;
                        String str2 = (String) entry2.getKey();
                        Resources resources3 = (Resources) entry2.getValue();
                        if (resources3 == null || (groups = resources3.getGroups()) == null) {
                            strArr = null;
                        } else {
                            Object[] array3 = groups.toArray(new String[0]);
                            if (array3 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            strArr = (String[]) array3;
                        }
                        Resources resources4 = (Resources) entry2.getValue();
                        if (resources4 == null || (channels = resources4.getChannels()) == null) {
                            strArr2 = null;
                        } else {
                            Object[] array4 = channels.toArray(new String[0]);
                            if (array4 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            strArr2 = (String[]) array4;
                        }
                        geckoStore2.addSensitiveStorageBlockList(str2, strArr, strArr2);
                    }
                }
            }
            return new Pair<>(Integer.valueOf(lowStorageAvailable), Integer.valueOf(sensitiveStorageAvailable));
        }
        isStorageAvailableRegisteredBySPI = false;
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        Integer valueOf = Integer.valueOf(inst.getAvailableStorage());
        AppSettingsManager inst2 = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst2, "AppSettingsManager.inst()");
        return new Pair<>(valueOf, Integer.valueOf(inst2.getSensitiveStorageAvailable()));
    }

    public final synchronized List<String> getNoLocalAks() {
        List<String> list = noLocalAks;
        if (list != null) {
            return list;
        }
        SettingsExtra settingsExtra = GlobalSettingsManager.INSTANCE.getSettingsExtra();
        if (settingsExtra != null) {
            noLocalAks = settingsExtra.getNoLocalAk();
        }
        return noLocalAks;
    }

    public final boolean isInLocalAks(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        List<String> noLocalAks2 = getNoLocalAks();
        return noLocalAks2 != null && noLocalAks2.contains(accessKey);
    }

    public final void resetForTest() {
        mLowStorageWhiteList.clear();
        mSensitiveStorageBlockList.clear();
    }
}
