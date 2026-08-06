package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.InstFltKey;
import com.bytedance.vcloud.uniplayer.InstIntKey;
import com.bytedance.vcloud.uniplayer.InstStrKey;
import com.bytedance.vcloud.uniplayer.UniInstConfig;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniInstConfig.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0017J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/vcloud/impl/UniInstConfigImpl;", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "()V", "mNative", "", "getMNative", "()J", "setMNative", "(J)V", "close", "", "dispose", "setFloatValue", "key", "Lcom/bytedance/vcloud/uniplayer/InstFltKey;", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "setIntValue", "Lcom/bytedance/vcloud/uniplayer/InstIntKey;", "", "setStringValue", "Lcom/bytedance/vcloud/uniplayer/InstStrKey;", "", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniInstConfigImpl implements UniInstConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private long mNative = INSTANCE.create();

    @JvmStatic
    public static final native long create();

    @JvmStatic
    public static final native void destroy(long j);

    @JvmStatic
    public static final native void setFloat(long j, int i, float f);

    @JvmStatic
    public static final native void setInt(long j, int i, int i2);

    @JvmStatic
    public static final native void setStr(long j, int i, String str);

    public final long getMNative() {
        return this.mNative;
    }

    public final void setMNative(long j) {
        this.mNative = j;
    }

    @Override // com.bytedance.vcloud.uniplayer.UniInstConfig
    public void setIntValue(InstIntKey key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        INSTANCE.setInt(this.mNative, key.getValue(), value);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniInstConfig
    public void setFloatValue(InstFltKey key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        INSTANCE.setFloat(this.mNative, key.getValue(), value);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniInstConfig
    public void setStringValue(InstStrKey key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
        INSTANCE.setStr(this.mNative, key.getValue(), value);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniInstConfig, java.lang.AutoCloseable
    public void close() {
        long j = this.mNative;
        this.mNative = 0L;
        INSTANCE.destroy(j);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniInstConfig
    @Deprecated(message = "Use close() instead.", replaceWith = @ReplaceWith(expression = "close()", imports = {}))
    public void dispose() {
        close();
    }

    /* compiled from: UniInstConfig.android.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0087 J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0087 J!\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087 J!\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0087 J!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\u0087 ¨\u0006\u0010"}, d2 = {"Lcom/bytedance/vcloud/impl/UniInstConfigImpl$Companion;", "", "()V", "unip_create_instcfg", "", "unip_destroy_instcfg", "", "instCfg", "unip_instcfg_setfloat", "key", "", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "unip_instcfg_setint", "unip_instcfg_setstr", "", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final long create() {
            return UniInstConfigImpl.create();
        }

        @JvmStatic
        public final void destroy(long j) {
            UniInstConfigImpl.destroy(j);
        }

        @JvmStatic
        public final void setFloat(long j, int i, float f) {
            UniInstConfigImpl.setFloat(j, i, f);
        }

        @JvmStatic
        public final void setInt(long j, int i, int i2) {
            UniInstConfigImpl.setInt(j, i, i2);
        }

        @JvmStatic
        public final void setStr(long j, int i, String str) {
            UniInstConfigImpl.setStr(j, i, str);
        }

        private Companion() {
        }
    }
}
