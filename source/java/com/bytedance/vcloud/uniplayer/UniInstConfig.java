package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.impl.UniInstConfig_androidKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: UniInstConfig.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H'J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "Ljava/lang/AutoCloseable;", "close", "", "dispose", "setFloatValue", "key", "Lcom/bytedance/vcloud/uniplayer/InstFltKey;", "value", "", "setIntValue", "Lcom/bytedance/vcloud/uniplayer/InstIntKey;", "", "setStringValue", "Lcom/bytedance/vcloud/uniplayer/InstStrKey;", "", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface UniInstConfig extends AutoCloseable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Override // java.lang.AutoCloseable
    void close();

    @Deprecated(message = "Use close() instead.", replaceWith = @ReplaceWith(expression = "close()", imports = {}))
    void dispose();

    void setFloatValue(InstFltKey key, float value);

    void setIntValue(InstIntKey key, int value);

    void setStringValue(InstStrKey key, String value);

    /* compiled from: UniInstConfig.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniInstConfig$Companion;", "", "()V", "create", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final UniInstConfig create() {
            return UniInstConfig_androidKt.createInstConfig();
        }
    }

    static {
        UniKitService_androidKt.loadLibrary();
    }
}
