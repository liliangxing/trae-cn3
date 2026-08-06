package com.bytedance.ies.argus.plugin;

import com.bytedance.ies.argus.plugin.ISecurePluginHandler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ISecurePlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH&J\u0017\u0010\r\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H&J\b\u0010\u0012\u001a\u00020\fH&J\b\u0010\u0013\u001a\u00020\u0014H&R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/argus/plugin/ISecurePlugin;", "INSTANCE", "Lcom/bytedance/ies/argus/plugin/ISecurePluginHandler;", "", "()V", "pluginName", "", "getPluginName", "()Ljava/lang/String;", "pluginName$delegate", "Lkotlin/Lazy;", "hasInit", "", "initInstance", "cId", "(Ljava/lang/String;)Lcom/bytedance/ies/argus/plugin/ISecurePluginHandler;", "instanceClazz", "Ljava/lang/Class;", "setup", "type", "Lcom/bytedance/ies/argus/plugin/SecurePluginType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class ISecurePlugin<INSTANCE extends ISecurePluginHandler> {

    /* renamed from: pluginName$delegate, reason: from kotlin metadata */
    private final Lazy pluginName = LazyKt.lazy(new Function0<String>(this) { // from class: com.bytedance.ies.argus.plugin.ISecurePlugin$pluginName$2
        final /* synthetic */ ISecurePlugin<INSTANCE> this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        public final String invoke() {
            return this.this$0.type().getStringValue();
        }
    });

    public abstract boolean hasInit();

    public abstract INSTANCE initInstance(String cId);

    public abstract Class<INSTANCE> instanceClazz();

    public abstract boolean setup();

    public abstract SecurePluginType type();

    public final String getPluginName() {
        return (String) this.pluginName.getValue();
    }
}
