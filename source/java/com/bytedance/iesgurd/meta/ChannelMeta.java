package com.bytedance.iesgurd.meta;

import com.bytedance.geckox.logger.GeckoLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ChannelMeta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/bytedance/iesgurd/meta/ChannelMeta;", "", "()V", "forbidden", "", "getForbidden", "()Z", "setForbidden", "(Z)V", "id", "", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "updateTime", "getUpdateTime", "setUpdateTime", "toString", "", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ChannelMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean forbidden;
    private Long id;
    private Long updateTime;

    /* compiled from: ChannelMeta.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/iesgurd/meta/ChannelMeta$Companion;", "", "()V", "fromString", "Lcom/bytedance/iesgurd/meta/ChannelMeta;", "buffer", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChannelMeta fromString(String buffer) {
            Intrinsics.checkParameterIsNotNull(buffer, "buffer");
            List split$default = StringsKt.split$default(buffer, new String[]{","}, false, 0, 6, (Object) null);
            if (!split$default.isEmpty() && split$default.size() % 2 == 0) {
                try {
                    ChannelMeta channelMeta = new ChannelMeta();
                    int size = split$default.size() / 2;
                    for (int i = 0; i < size; i++) {
                        int i2 = i * 2;
                        String str = (String) split$default.get(i2 + 1);
                        if (!Intrinsics.areEqual(str, "null")) {
                            String str2 = (String) split$default.get(i2);
                            int hashCode = str2.hashCode();
                            if (hashCode != -295931082) {
                                if (hashCode == 3355) {
                                    if (str2.equals("id")) {
                                        channelMeta.setId(Long.valueOf(Long.parseLong(str)));
                                    }
                                } else if (hashCode == 1503566841 && str2.equals("forbidden")) {
                                    channelMeta.setForbidden(true);
                                }
                            } else if (str2.equals("updateTime")) {
                                channelMeta.setUpdateTime(Long.valueOf(Long.parseLong(str)));
                            }
                        }
                    }
                    return channelMeta;
                } catch (Throwable th) {
                    GeckoLogger.w("ChannelMeta fromString error", th);
                }
            }
            return null;
        }
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(Long l) {
        this.id = l;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(Long l) {
        this.updateTime = l;
    }

    public final boolean getForbidden() {
        return this.forbidden;
    }

    public final void setForbidden(boolean z) {
        this.forbidden = z;
    }

    public String toString() {
        String str = "id," + this.id + ",updateTime," + this.updateTime;
        return this.forbidden ? str + ",forbidden,true" : str;
    }
}
