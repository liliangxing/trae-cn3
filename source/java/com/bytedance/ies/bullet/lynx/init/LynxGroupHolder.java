package com.bytedance.ies.bullet.lynx.init;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxStorageGroup;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxGroupHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0002JC\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u0007J3\u0010\u0018\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00072\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0002\u0010\u0019JE\u0010\u0018\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00072\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u0010¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxGroupHolder;", "", "()V", "lockObj", "Ljava/lang/Object;", "lynxGroupMap", "", "", "Lcom/lynx/tasm/LynxGroup;", "lynxGroupRefMap", "", "addLynxGroupRef", "", "groupName", "createLynxGroup", "shareGroup", "", "enableCanvas", "preloadJSPaths", "", "enableDynamicV8", "enableCanvasOptimization", "(Ljava/lang/String;ZZ[Ljava/lang/String;ZZ)Lcom/lynx/tasm/LynxGroup;", "getLynxGroup", "getOrCreateLynxGroup", "(Ljava/lang/String;[Ljava/lang/String;ZZ)Lcom/lynx/tasm/LynxGroup;", "storageGroup", "(Ljava/lang/String;[Ljava/lang/String;ZZZZ)Lcom/lynx/tasm/LynxGroup;", "removeLynxGroup", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxGroupHolder {
    public static final LynxGroupHolder INSTANCE = new LynxGroupHolder();
    private static final Object lockObj = new Object();
    private static final Map<String, LynxGroup> lynxGroupMap = new LinkedHashMap();
    private static final Map<String, Integer> lynxGroupRefMap = new LinkedHashMap();

    private LynxGroupHolder() {
    }

    public final LynxGroup getLynxGroup(String groupName) {
        LynxGroup lynxGroup;
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        synchronized (lockObj) {
            lynxGroup = lynxGroupMap.get(groupName);
        }
        return lynxGroup;
    }

    public final LynxGroup createLynxGroup(String groupName, boolean shareGroup, boolean enableCanvas, String[] preloadJSPaths, boolean enableDynamicV8, boolean enableCanvasOptimization) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        boolean z = true;
        if (shareGroup) {
            LynxGroup Create = LynxGroup.Create(groupName, groupName, preloadJSPaths, false, enableCanvas || enableCanvasOptimization, enableDynamicV8);
            Intrinsics.checkNotNullExpressionValue(Create, "{\n            LynxGroup.…8\n            )\n        }");
            return Create;
        }
        if (!enableCanvas && !enableCanvasOptimization) {
            z = false;
        }
        LynxGroup Create2 = LynxGroup.Create(groupName, preloadJSPaths, false, z, enableDynamicV8);
        Intrinsics.checkNotNullExpressionValue(Create2, "{\n            LynxGroup.…8\n            )\n        }");
        return Create2;
    }

    public static /* synthetic */ LynxGroup getOrCreateLynxGroup$default(LynxGroupHolder lynxGroupHolder, String str, String[] strArr, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 32) != 0) {
            z4 = false;
        }
        return lynxGroupHolder.getOrCreateLynxGroup(str, strArr, z, z2, z3, z4);
    }

    public final LynxGroup getOrCreateLynxGroup(String groupName, String[] preloadJSPaths, boolean enableCanvas, boolean enableDynamicV8, boolean enableCanvasOptimization, boolean storageGroup) {
        LynxGroup lynxGroup;
        LynxGroup Create;
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        synchronized (lockObj) {
            INSTANCE.addLynxGroupRef(groupName);
            Map<String, LynxGroup> map = lynxGroupMap;
            lynxGroup = map.get(groupName);
            if (lynxGroup == null || lynxGroup == null) {
                if (storageGroup) {
                    Create = new LynxStorageGroup.LynxStorageGroupBuilder().setGroupName(groupName).setID(groupName).setPreloadJSPaths(preloadJSPaths).setUseProviderJsEnv(false).setEnableCanvas(enableCanvas || enableCanvasOptimization).setEnableDynamicV8(enableDynamicV8).build();
                } else {
                    Create = LynxGroup.Create(groupName, preloadJSPaths, false, enableCanvas, enableDynamicV8, enableCanvasOptimization);
                }
                lynxGroup = Create;
                Intrinsics.checkNotNullExpressionValue(lynxGroup, "lynxGroup");
                map.put(groupName, lynxGroup);
            }
        }
        return lynxGroup;
    }

    public final LynxGroup getOrCreateLynxGroup(String groupName, String[] preloadJSPaths, boolean enableCanvas, boolean enableDynamicV8) {
        LynxGroup lynxGroup;
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        synchronized (lockObj) {
            INSTANCE.addLynxGroupRef(groupName);
            Map<String, LynxGroup> map = lynxGroupMap;
            lynxGroup = map.get(groupName);
            if (lynxGroup == null || lynxGroup == null) {
                lynxGroup = LynxGroup.Create(groupName, preloadJSPaths, false, enableCanvas, enableDynamicV8);
                Intrinsics.checkNotNullExpressionValue(lynxGroup, "lynxGroup");
                map.put(groupName, lynxGroup);
            }
        }
        return lynxGroup;
    }

    private final void addLynxGroupRef(String groupName) {
        Map<String, Integer> map = lynxGroupRefMap;
        Integer num = map.get(groupName);
        map.put(groupName, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
    }

    public final void removeLynxGroup(String groupName) {
        synchronized (lockObj) {
            String str = groupName;
            if (str == null || str.length() == 0) {
                return;
            }
            Map<String, Integer> map = lynxGroupRefMap;
            Integer num = map.get(groupName);
            if (num != null) {
                int intValue = num.intValue();
                if (intValue == 1) {
                    LynxGroup remove = lynxGroupMap.remove(groupName);
                    LynxStorageGroup lynxStorageGroup = remove instanceof LynxStorageGroup ? (LynxStorageGroup) remove : null;
                    if (lynxStorageGroup != null) {
                        lynxStorageGroup.destroy();
                    }
                    map.remove(groupName);
                } else {
                    map.put(groupName, Integer.valueOf(intValue - 1));
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }
}
