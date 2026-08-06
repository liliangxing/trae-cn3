package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.impl.UniAbConfig_androidKt;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniAbConfig.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0000H&J\b\u0010\u0005\u001a\u00020\u0003H'J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\rH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "Ljava/lang/AutoCloseable;", "close", "", "copy", "dispose", "setFloatValue", "key", "", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "setIntValue", "setStringValue", "", "setUniAbKv", "Lcom/bytedance/vcloud/uniplayer/UniAbFltKey;", "Lcom/bytedance/vcloud/uniplayer/UniAbKey;", "Lcom/bytedance/vcloud/uniplayer/UniAbStrKey;", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface UniAbConfig extends AutoCloseable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Override // java.lang.AutoCloseable
    void close();

    UniAbConfig copy();

    @Deprecated(message = "Use close() or a use{} block instead.", replaceWith = @ReplaceWith(expression = "close()", imports = {}))
    void dispose();

    void setFloatValue(int key, float value);

    void setIntValue(int key, int value);

    void setStringValue(int key, String value);

    void setUniAbKv(UniAbFltKey key, float value);

    void setUniAbKv(UniAbKey key, int value);

    void setUniAbKv(UniAbStrKey key, String value);

    /* compiled from: UniAbConfig.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static void setUniAbKv(UniAbConfig uniAbConfig, UniAbKey uniAbKey, int i) {
            Intrinsics.checkNotNullParameter(uniAbKey, "key");
            uniAbConfig.setIntValue(uniAbKey.getValue(), i);
        }

        public static void setUniAbKv(UniAbConfig uniAbConfig, UniAbStrKey uniAbStrKey, String str) {
            Intrinsics.checkNotNullParameter(uniAbStrKey, "key");
            Intrinsics.checkNotNullParameter(str, CustomDataTagHandler.VALUE_ATTRIBUTE);
            uniAbConfig.setStringValue(uniAbStrKey.getValue(), str);
        }

        public static void setUniAbKv(UniAbConfig uniAbConfig, UniAbFltKey uniAbFltKey, float f) {
            Intrinsics.checkNotNullParameter(uniAbFltKey, "key");
            uniAbConfig.setFloatValue(uniAbFltKey.getValue(), f);
        }
    }

    /* compiled from: UniAbConfig.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniAbConfig$Companion;", "", "()V", "create", "Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final UniAbConfig create() {
            return UniAbConfig_androidKt.createAbConfig();
        }
    }

    static {
        UniKitService_androidKt.loadLibrary();
    }
}
