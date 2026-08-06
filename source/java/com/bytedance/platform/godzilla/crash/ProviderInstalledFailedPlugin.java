package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;
import com.bytedance.platform.godzilla.crash.boostcrash.impl.InstrumentationWrapper;
import com.bytedance.platform.godzilla.crash.boostcrash.impl.providerInstalledFailed.FileProviderInstallFailedExceptionCatcher;
import com.bytedance.platform.godzilla.crash.boostcrash.impl.providerInstalledFailed.ProviderClassNotFoundException;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.trae.login.traeauth.TraeAuthManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ProviderInstalledFailedPlugin extends BasePlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "ProviderInstalledFailedPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application application) {
        super.init(application);
        InstrumentationWrapper.registerExceptionCatcher(new FileProviderInstallFailedExceptionCatcher());
        InstrumentationWrapper.registerExceptionCatcher(new ProviderClassNotFoundException());
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        InstrumentationWrapper.startFix();
        Logger.m197e(getName(), TraeAuthManager.STAGE_START);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
        super.destroy();
    }

    public void registerCustomExceptionCatcher(ExceptionCatcher exceptionCatcher) {
        InstrumentationWrapper.registerExceptionCatcher(exceptionCatcher);
    }
}
