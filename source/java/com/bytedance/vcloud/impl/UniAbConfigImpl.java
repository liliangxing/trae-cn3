package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.UniAbConfig;
import com.bytedance.vcloud.uniplayer.UniAbFltKey;
import com.bytedance.vcloud.uniplayer.UniAbKey;
import com.bytedance.vcloud.uniplayer.UniAbStrKey;
import com.bytedance.vcloud.uniplayer.UniKitService_androidKt;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniAbConfig.android.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0001H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0017J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0017H\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/bytedance/vcloud/impl/UniAbConfigImpl;", "Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "nativePtr", "", "(J)V", "()V", "other", "(Lcom/bytedance/vcloud/impl/UniAbConfigImpl;)V", "mNative", "getMNative", "()J", "setMNative", "close", "", "copy", "dispose", "setFloatValue", "key", "", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "setIntValue", "setStringValue", "", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniAbConfigImpl implements UniAbConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private long mNative;

    @JvmStatic
    public static final native long copy(long j);

    @JvmStatic
    public static final native void destroy(long j);

    @JvmStatic
    public static final native void setFloat(long j, int i, float f);

    @JvmStatic
    public static final native void setInt(long j, int i, int i2);

    @JvmStatic
    public static final native void setStr(long j, int i, String str);

    @Override // com.bytedance.vcloud.uniplayer.UniAbConfig
    public void setUniAbKv(UniAbFltKey uniAbFltKey, float f) {
        UniAbConfig.DefaultImpls.setUniAbKv(this, uniAbFltKey, f);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAbConfig
    public void setUniAbKv(UniAbKey uniAbKey, int i) {
        UniAbConfig.DefaultImpls.setUniAbKv(this, uniAbKey, i);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAbConfig
    public void setUniAbKv(UniAbStrKey uniAbStrKey, String str) {
        UniAbConfig.DefaultImpls.setUniAbKv(this, uniAbStrKey, str);
    }

    public final long getMNative() {
        return this.mNative;
    }

    public final void setMNative(long j) {
        this.mNative = j;
    }

    public UniAbConfigImpl(long j) {
        this.mNative = j;
    }

    public UniAbConfigImpl() {
        this.mNative = INSTANCE.copy(0L);
    }

    public UniAbConfigImpl(UniAbConfigImpl uniAbConfigImpl) {
        Intrinsics.checkNotNullParameter(uniAbConfigImpl, "other");
        this.mNative = INSTANCE.copy(uniAbConfigImpl.mNative);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAbConfig
    public void setIntValue(int key, int value) {
        INSTANCE.setInt(this.mNative, key, value);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAbConfig
    public void setFloatValue(int key, float value) {
        INSTANCE.setFloat(this.mNative, key, value);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAbConfig
    public void setStringValue(int key, String value) {
        Intrinsics.checkNotNullParameter(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
        INSTANCE.setStr(this.mNative, key, value);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAbConfig, java.lang.AutoCloseable
    public void close() {
        long j = this.mNative;
        this.mNative = 0L;
        INSTANCE.destroy(j);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAbConfig
    @Deprecated(message = "Use close() or a use{} block instead.", replaceWith = @ReplaceWith(expression = "close()", imports = {}))
    public void dispose() {
        close();
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAbConfig
    public UniAbConfig copy() {
        return new UniAbConfigImpl(this);
    }

    /* compiled from: UniAbConfig.android.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0087 J!\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0087 J\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J\u0011\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 ¨\u0006\u0010"}, d2 = {"Lcom/bytedance/vcloud/impl/UniAbConfigImpl$Companion;", "", "()V", "unip_abconfig_setfloat", "", "abconfig", "", "key", "", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "unip_abconfig_setint", "unip_abconfig_setstr", "", "unip_copy_abconfig", "unip_destroy_abconfig", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final long copy(long j) {
            return UniAbConfigImpl.copy(j);
        }

        @JvmStatic
        public final void destroy(long j) {
            UniAbConfigImpl.destroy(j);
        }

        @JvmStatic
        public final void setFloat(long j, int i, float f) {
            UniAbConfigImpl.setFloat(j, i, f);
        }

        @JvmStatic
        public final void setInt(long j, int i, int i2) {
            UniAbConfigImpl.setInt(j, i, i2);
        }

        @JvmStatic
        public final void setStr(long j, int i, String str) {
            UniAbConfigImpl.setStr(j, i, str);
        }

        private Companion() {
        }
    }

    static {
        UniKitService_androidKt.loadLibrary();
    }
}
