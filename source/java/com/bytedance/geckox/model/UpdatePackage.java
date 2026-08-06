package com.bytedance.geckox.model;

import com.bytedance.geckox.statistic.model.UpdateStatisticModel;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdatePackage.kt */
@Deprecated(message = "")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/geckox/model/UpdatePackage;", "", "accessKey", "", "channel", "version", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getAccessKey", "()Ljava/lang/String;", "getChannel", "fullPackage", "Lcom/bytedance/geckox/model/UpdatePackage$Package;", "getFullPackage", "()Lcom/bytedance/geckox/model/UpdatePackage$Package;", "statisticModel", "Lcom/bytedance/geckox/statistic/model/UpdateStatisticModel;", "getStatisticModel", "()Lcom/bytedance/geckox/statistic/model/UpdateStatisticModel;", "setStatisticModel", "(Lcom/bytedance/geckox/statistic/model/UpdateStatisticModel;)V", "getVersion", "()J", "isPatchUpdate", "", "Package", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class UpdatePackage {
    private final String accessKey;
    private final String channel;
    private final Package fullPackage;
    private UpdateStatisticModel statisticModel;
    private final long version;

    public final boolean isPatchUpdate() {
        return false;
    }

    public UpdatePackage(String accessKey, String channel, long j) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        this.accessKey = accessKey;
        this.channel = channel;
        this.version = j;
    }

    public /* synthetic */ UpdatePackage(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? 0L : j);
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final long getVersion() {
        return this.version;
    }

    public final Package getFullPackage() {
        return this.fullPackage;
    }

    public final UpdateStatisticModel getStatisticModel() {
        return this.statisticModel;
    }

    public final void setStatisticModel(UpdateStatisticModel updateStatisticModel) {
        this.statisticModel = updateStatisticModel;
    }

    /* compiled from: UpdatePackage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/geckox/model/UpdatePackage$Package;", "", "()V", "id", "", "getId", "()J", "setId", "(J)V", "length", "getLength", "setLength", "md5", "", "getMd5", "()Ljava/lang/String;", "setMd5", "(Ljava/lang/String;)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class Package {
        private long id;
        private long length;
        private String md5;

        public final long getId() {
            return this.id;
        }

        public final void setId(long j) {
            this.id = j;
        }

        public final String getMd5() {
            return this.md5;
        }

        public final void setMd5(String str) {
            this.md5 = str;
        }

        public final long getLength() {
            return this.length;
        }

        public final void setLength(long j) {
            this.length = j;
        }
    }
}
