package com.bytedance.ies.argus.plugin;

import android.app.Application;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusConstants;
import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.config.AppSecConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: SecLinkPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/plugin/SecLinkPlugin;", "Lcom/bytedance/ies/argus/plugin/ISecurePlugin;", "Lcom/bytedance/ies/argus/plugin/SecLinkPluginHandler;", "()V", "hasInit", "", "initInstance", "cId", "", "instanceClazz", "Ljava/lang/Class;", "setup", "type", "Lcom/bytedance/ies/argus/plugin/SecurePluginType;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SecLinkPlugin extends ISecurePlugin<SecLinkPluginHandler> {
    public static final String TAG = "SecLinkPlugin";

    @Override // com.bytedance.ies.argus.plugin.ISecurePlugin
    public SecurePluginType type() {
        return SecurePluginType.SEC_LINK;
    }

    @Override // com.bytedance.ies.argus.plugin.ISecurePlugin
    public boolean setup() {
        try {
            if (!hasInit()) {
                ArgusInitConfig.AppEnv env = ArgusEnv.INSTANCE.getInstance().getEnv();
                String appId = env != null ? env.getAppId() : null;
                Application application = ArgusEnv.INSTANCE.getInstance().getApplication();
                ArgusInitConfig.AppEnv env2 = ArgusEnv.INSTANCE.getInstance().getEnv();
                String appVersion = env2 != null ? env2.getAppVersion() : null;
                if (appId != null && application != null && appVersion != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("https://%s", Arrays.copyOf(new Object[]{ArgusConstants.SEC_LINK_HOST}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    SecLinkFacade.init(application, new AppSecConfig.Builder().aid(appId).lang("cn").host(format).build());
                }
            }
        } catch (Exception e) {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "init secLink error: " + e, null, null, 12, null);
        }
        return hasInit();
    }

    @Override // com.bytedance.ies.argus.plugin.ISecurePlugin
    public SecLinkPluginHandler initInstance(String cId) {
        return new SecLinkPluginHandler(type(), cId);
    }

    @Override // com.bytedance.ies.argus.plugin.ISecurePlugin
    public Class<SecLinkPluginHandler> instanceClazz() {
        return SecLinkPluginHandler.class;
    }

    @Override // com.bytedance.ies.argus.plugin.ISecurePlugin
    public boolean hasInit() {
        return SecLinkFacade.isInitiated();
    }
}
