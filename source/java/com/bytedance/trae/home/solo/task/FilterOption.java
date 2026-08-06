package com.bytedance.trae.home.solo.task;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/home/solo/task/FilterOption;", "", "<init>", "()V", "All", "Cloud", "Device", "Lcom/bytedance/trae/home/solo/task/FilterOption$All;", "Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;", "Lcom/bytedance/trae/home/solo/task/FilterOption$Device;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FilterOption {
    public static final int $stable = 0;

    public /* synthetic */ FilterOption(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: TaskModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/task/FilterOption$All;", "Lcom/bytedance/trae/home/solo/task/FilterOption;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class All extends FilterOption {
        public static final int $stable = 0;
        public static final All INSTANCE = new All();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof All)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -525654067;
        }

        public String toString() {
            return "All";
        }

        private All() {
            super(null);
        }
    }

    private FilterOption() {
    }

    /* compiled from: TaskModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;", "Lcom/bytedance/trae/home/solo/task/FilterOption;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Cloud extends FilterOption {
        public static final int $stable = 0;
        public static final Cloud INSTANCE = new Cloud();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cloud)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1654436193;
        }

        public String toString() {
            return "Cloud";
        }

        private Cloud() {
            super(null);
        }
    }

    /* compiled from: TaskModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H×\u0003J\t\u0010\u0011\u001a\u00020\u0012H×\u0001J\t\u0010\u0013\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/home/solo/task/FilterOption$Device;", "Lcom/bytedance/trae/home/solo/task/FilterOption;", "cliId", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCliId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Device extends FilterOption {
        public static final int $stable = 0;
        private final String cliId;
        private final String name;

        public static /* synthetic */ Device copy$default(Device device, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = device.cliId;
            }
            if ((i & 2) != 0) {
                str2 = device.name;
            }
            return device.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCliId() {
            return this.cliId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Device copy(String cliId, String name) {
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            Intrinsics.checkNotNullParameter(name, "name");
            return new Device(cliId, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Device)) {
                return false;
            }
            Device device = (Device) other;
            return Intrinsics.areEqual(this.cliId, device.cliId) && Intrinsics.areEqual(this.name, device.name);
        }

        public int hashCode() {
            return (this.cliId.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return "Device(cliId=" + this.cliId + ", name=" + this.name + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Device(String cliId, String name) {
            super(null);
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            Intrinsics.checkNotNullParameter(name, "name");
            this.cliId = cliId;
            this.name = name;
        }

        public final String getCliId() {
            return this.cliId;
        }

        public final String getName() {
            return this.name;
        }
    }
}
