package com.bytedance.android.anniex.container.util;

import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXContainerManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J.\u0010\u0013\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0011J\"\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007RC\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/anniex/container/util/AnnieXContainerManager;", "", "()V", "containerMap", "Ljava/util/LinkedHashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/anniex/base/container/IContainer;", "Lkotlin/collections/LinkedHashMap;", "getContainerMap", "()Ljava/util/LinkedHashMap;", "containerMap$delegate", "Lkotlin/Lazy;", "addContainer", "", "container", "closeContainerById", "", "containerId", "getAllContainer", "getContainerById", "isTopContainer", "removeContainerById", "release", "triggerNestingDoll", "bdxTag", "launchMode", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "self", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXContainerManager {
    public static final AnnieXContainerManager INSTANCE = new AnnieXContainerManager();

    /* renamed from: containerMap$delegate, reason: from kotlin metadata */
    private static final Lazy containerMap = LazyKt.lazy(new Function0<LinkedHashMap<String, WeakReference<IContainer>>>() { // from class: com.bytedance.android.anniex.container.util.AnnieXContainerManager$containerMap$2
        public final LinkedHashMap<String, WeakReference<IContainer>> invoke() {
            return new LinkedHashMap<>();
        }
    });

    /* compiled from: AnnieXContainerManager.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LaunchMode.values().length];
            try {
                iArr[LaunchMode.REMOVE_SAME_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AnnieXContainerManager() {
    }

    private final LinkedHashMap<String, WeakReference<IContainer>> getContainerMap() {
        return (LinkedHashMap) containerMap.getValue();
    }

    public final void addContainer(IContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        String bDXTag = container.getBDXTag();
        if (bDXTag != null) {
            INSTANCE.triggerNestingDoll(bDXTag, container.getBDXLaunchMode(), container);
        }
        getContainerMap().put(container.getContainerId(), new WeakReference<>(container));
    }

    public final boolean closeContainerById(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        WeakReference<IContainer> remove = getContainerMap().remove(containerId);
        IContainer iContainer = remove != null ? remove.get() : null;
        if (iContainer == null) {
            return false;
        }
        iContainer.close();
        iContainer.release();
        return true;
    }

    public static /* synthetic */ boolean removeContainerById$default(AnnieXContainerManager annieXContainerManager, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return annieXContainerManager.removeContainerById(str, z);
    }

    public final boolean removeContainerById(String containerId, boolean release) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        WeakReference<IContainer> remove = getContainerMap().remove(containerId);
        IContainer iContainer = remove != null ? remove.get() : null;
        if (iContainer == null) {
            return false;
        }
        if (!release) {
            return true;
        }
        iContainer.release();
        return true;
    }

    public final IContainer getContainerById(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        WeakReference<IContainer> weakReference = getContainerMap().get(containerId);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final LinkedHashMap<String, WeakReference<IContainer>> getAllContainer() {
        return getContainerMap();
    }

    public static /* synthetic */ void triggerNestingDoll$default(AnnieXContainerManager annieXContainerManager, String str, LaunchMode launchMode, IContainer iContainer, int i, Object obj) {
        if ((i & 4) != 0) {
            iContainer = null;
        }
        annieXContainerManager.triggerNestingDoll(str, launchMode, iContainer);
    }

    public final void triggerNestingDoll(String bdxTag, LaunchMode launchMode, IContainer self) {
        Intrinsics.checkNotNullParameter(bdxTag, "bdxTag");
        Intrinsics.checkNotNullParameter(launchMode, "launchMode");
        if (WhenMappings.$EnumSwitchMapping$0[launchMode.ordinal()] == 1) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, WeakReference<IContainer>> entry : getContainerMap().entrySet()) {
                IContainer iContainer = entry.getValue().get();
                if (Intrinsics.areEqual(iContainer != null ? iContainer.getBDXTag() : null, bdxTag)) {
                    if (IConditionCallKt.enableRemoveSamePageFix()) {
                        IContainer iContainer2 = entry.getValue().get();
                        if (!Intrinsics.areEqual(iContainer2 != null ? iContainer2.getSystemContext() : null, self != null ? self.getSystemContext() : null)) {
                            arrayList.add(entry.getKey());
                        }
                    } else {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                closeContainerById((String) it.next());
            }
        }
    }

    @JvmStatic
    public static final boolean isTopContainer(IContainer container) {
        Map.Entry entry;
        WeakReference weakReference;
        Intrinsics.checkNotNullParameter(container, "container");
        Set<Map.Entry<String, WeakReference<IContainer>>> entrySet = INSTANCE.getAllContainer().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "it");
        IContainer iContainer = null;
        if (!(!entrySet.isEmpty())) {
            entrySet = null;
        }
        if (entrySet != null && (entry = (Map.Entry) CollectionsKt.last(entrySet)) != null && (weakReference = (WeakReference) entry.getValue()) != null) {
            iContainer = (IContainer) weakReference.get();
        }
        return Intrinsics.areEqual(iContainer, container);
    }
}
