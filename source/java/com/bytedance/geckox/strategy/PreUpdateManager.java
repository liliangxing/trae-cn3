package com.bytedance.geckox.strategy;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.update.UpdateQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PreUpdateManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/geckox/strategy/PreUpdateManager;", "", "()V", "SPLIT", "", "placeholderForAccessKey", "", "preUpdateChannels", "", "", "initPreUpdateChannels", "", "optSwitch", "", "setAccessKeyReplace", "keyStr", "triggerTargetChannelUpdate", "accessKey", "parentChannel", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PreUpdateManager {
    public static final PreUpdateManager INSTANCE = new PreUpdateManager();
    private static final String SPLIT = "@";
    private static Map<String, String> placeholderForAccessKey;
    private static Map<String, Set<String>> preUpdateChannels;

    private PreUpdateManager() {
    }

    public final void triggerTargetChannelUpdate(String accessKey, String parentChannel) {
        PrepareMeta updateMeta;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(parentChannel, "parentChannel");
        if (optSwitch()) {
            initPreUpdateChannels();
            Map<String, Set<String>> map = preUpdateChannels;
            if (map == null || map.isEmpty()) {
                return;
            }
            String str = accessKey + '@' + parentChannel;
            ArrayList arrayList = new ArrayList();
            Map<String, Set<String>> map2 = preUpdateChannels;
            if (map2 == null) {
                Intrinsics.throwNpe();
            }
            Set<String> set = map2.get(str);
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    List split$default = StringsKt.split$default((String) it.next(), new String[]{SPLIT}, false, 0, 6, (Object) null);
                    if (split$default.size() == 2 && (updateMeta = PrepareMetaManager.INSTANCE.getUpdateMeta((String) split$default.get(0), (String) split$default.get(1))) != null && !updateMeta.getInQueue()) {
                        updateMeta.setInQueue(true);
                        updateMeta.setReqType(ReqType.UPDATE_BY_PRE_ACCESS);
                        updateMeta.ignoreBlocks();
                        updateMeta.setPreTriggerChannel(str);
                        arrayList.add(updateMeta);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            UpdateQueue.INSTANCE.add(arrayList, new GeckoUpdateParams("", null, null, null, false, IESGurdUpdatePriority.HIGH, null, null, false, null, 990, null));
        }
    }

    private final void initPreUpdateChannels() {
        AppSettingsManager.IClientIntelligenceConfig config;
        Map<String, List<String>> accessTarget2Parent;
        Map<String, String> placeholderForAccessKey2;
        if (preUpdateChannels != null) {
            return;
        }
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        AppSettingsManager.IGeckoAppSettings geckoAppSettings = inst.getGeckoAppSettings();
        if (geckoAppSettings == null || (config = geckoAppSettings.getConfig()) == null || (accessTarget2Parent = config.accessTarget2Parent()) == null || (placeholderForAccessKey2 = config.placeholderForAccessKey()) == null) {
            return;
        }
        placeholderForAccessKey = placeholderForAccessKey2;
        preUpdateChannels = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : accessTarget2Parent.entrySet()) {
            if (entry.getKey() != null) {
                PreUpdateManager preUpdateManager = INSTANCE;
                String key = entry.getKey();
                Intrinsics.checkExpressionValueIsNotNull(key, "it.key");
                String accessKeyReplace = preUpdateManager.setAccessKeyReplace(key);
                if (accessKeyReplace != null) {
                    List<String> value = entry.getValue();
                    Intrinsics.checkExpressionValueIsNotNull(value, "it.value");
                    for (String str : value) {
                        PreUpdateManager preUpdateManager2 = INSTANCE;
                        Intrinsics.checkExpressionValueIsNotNull(str, "parent");
                        String accessKeyReplace2 = preUpdateManager2.setAccessKeyReplace(str);
                        if (accessKeyReplace2 != null) {
                            Map<String, Set<String>> map = preUpdateChannels;
                            if (map == null) {
                                Intrinsics.throwNpe();
                            }
                            LinkedHashSet linkedHashSet = map.get(accessKeyReplace2);
                            if (linkedHashSet == null) {
                                linkedHashSet = new LinkedHashSet();
                                Map<String, Set<String>> map2 = preUpdateChannels;
                                if (map2 == null) {
                                    Intrinsics.throwNpe();
                                }
                                map2.put(accessKeyReplace2, linkedHashSet);
                            }
                            linkedHashSet.add(accessKeyReplace);
                        }
                    }
                }
            }
        }
    }

    private final boolean optSwitch() {
        AppSettingsManager.IClientIntelligenceConfig config;
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        AppSettingsManager.IGeckoAppSettings geckoAppSettings = inst.getGeckoAppSettings();
        return (geckoAppSettings == null || (config = geckoAppSettings.getConfig()) == null || !config.optSwitch()) ? false : true;
    }

    private final String setAccessKeyReplace(String keyStr) {
        String str = (String) StringsKt.split$default(keyStr, new String[]{SPLIT}, false, 0, 6, (Object) null).get(0);
        Map<String, String> map = placeholderForAccessKey;
        if (map == null) {
            Intrinsics.throwNpe();
        }
        String str2 = map.get(str);
        if (str2 != null) {
            return StringsKt.replace$default(keyStr, str, str2, false, 4, (Object) null);
        }
        return null;
    }
}
