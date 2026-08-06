package com.bytedance.ies.bullet.service.base.resourceloader.config;

import com.bytedance.forest.model.PreloadConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000e\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR*\u0010\u0014\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR*\u0010\u0017\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/CustomLoaderConfig;", "", "disableDefaultLoader", "", "(Z)V", "getDisableDefaultLoader", "()Z", "loaderSequence", "", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/LoaderType;", "getLoaderSequence", "()Ljava/util/List;", "setLoaderSequence", "(Ljava/util/List;)V", "priorityHigh", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "getPriorityHigh", "setPriorityHigh", "priorityLow", "getPriorityLow", "setPriorityLow", "removedLoader", "getRemovedLoader", "setRemovedLoader", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class CustomLoaderConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean disableDefaultLoader;
    private List<LoaderType> loaderSequence = new ArrayList();
    private List<? extends Class<? extends IXResourceLoader>> priorityHigh;
    private List<? extends Class<? extends IXResourceLoader>> priorityLow;
    private List<? extends Class<? extends IXResourceLoader>> removedLoader;

    public CustomLoaderConfig(boolean z) {
        this.disableDefaultLoader = z;
    }

    public final boolean getDisableDefaultLoader() {
        return this.disableDefaultLoader;
    }

    public final List<LoaderType> getLoaderSequence() {
        return this.loaderSequence;
    }

    public final void setLoaderSequence(List<LoaderType> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.loaderSequence = list;
    }

    public final List<Class<? extends IXResourceLoader>> getPriorityHigh() {
        return this.priorityHigh;
    }

    public final void setPriorityHigh(List<? extends Class<? extends IXResourceLoader>> list) {
        this.priorityHigh = list;
    }

    public final List<Class<? extends IXResourceLoader>> getPriorityLow() {
        return this.priorityLow;
    }

    public final void setPriorityLow(List<? extends Class<? extends IXResourceLoader>> list) {
        this.priorityLow = list;
    }

    public final List<Class<? extends IXResourceLoader>> getRemovedLoader() {
        return this.removedLoader;
    }

    public final void setRemovedLoader(List<? extends Class<? extends IXResourceLoader>> list) {
        this.removedLoader = list;
    }

    /* compiled from: TaskConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/CustomLoaderConfig$Companion;", "", "()V", "from", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/CustomLoaderConfig;", PreloadConfig.KEY_OTHER, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomLoaderConfig from(CustomLoaderConfig other) {
            if (other == null) {
                return null;
            }
            CustomLoaderConfig customLoaderConfig = new CustomLoaderConfig(other.getDisableDefaultLoader());
            if (other.getRemovedLoader() != null) {
                ArrayList arrayList = new ArrayList();
                List<Class<? extends IXResourceLoader>> removedLoader = other.getRemovedLoader();
                Intrinsics.checkNotNull(removedLoader);
                arrayList.addAll(removedLoader);
                customLoaderConfig.setRemovedLoader(arrayList);
            }
            if (other.getPriorityHigh() != null) {
                ArrayList arrayList2 = new ArrayList();
                List<Class<? extends IXResourceLoader>> priorityHigh = other.getPriorityHigh();
                Intrinsics.checkNotNull(priorityHigh);
                arrayList2.addAll(priorityHigh);
                customLoaderConfig.setPriorityHigh(arrayList2);
            }
            if (other.getPriorityLow() != null) {
                ArrayList arrayList3 = new ArrayList();
                List<Class<? extends IXResourceLoader>> priorityLow = other.getPriorityLow();
                Intrinsics.checkNotNull(priorityLow);
                arrayList3.addAll(priorityLow);
                customLoaderConfig.setPriorityLow(arrayList3);
            }
            if (!other.getLoaderSequence().isEmpty()) {
                customLoaderConfig.getLoaderSequence().addAll(other.getLoaderSequence());
            }
            return customLoaderConfig;
        }
    }
}
