package com.bytedance.ug.sdk.deeplink;

import com.bytedance.ug.sdk.deeplink.interfaces.IClipboard;
import com.bytedance.ug.sdk.deeplink.interfaces.IExecutor;
import com.bytedance.ug.sdk.deeplink.interfaces.INetwork;
import com.bytedance.ug.sdk.deeplink.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DebugChecker {
    static boolean callRegisterLifeCycle;

    public static void check(ZlinkDependAbility zlinkDependAbility) {
        if (!callRegisterLifeCycle) {
            Logger.m446d("DebugChecker", "please call {@Link ZlinkApi#registerLifeCycle first}");
        }
        if (zlinkDependAbility == null) {
            throw new IllegalStateException("ZlinkDependAbility has not been built before the invocation of the init method");
        }
        if (zlinkDependAbility.isDebug()) {
            if (zlinkDependAbility.getApplication() == null) {
                throw new IllegalStateException("The Application must be injected before invoking the build method !");
            }
            if (zlinkDependAbility.getZlinkDepend() == null) {
                throw new IllegalStateException("The IZlinkDepend must be implemented and injected before invoking the build method !");
            }
            if (ZlinkProviderManager.getProvider(INetwork.class) == null) {
                throw new IllegalStateException("The interface INetwork must be implemented and injected before invoking the build method !");
            }
            if (ZlinkProviderManager.getProvider(IExecutor.class) == null) {
                throw new IllegalStateException("The interface IExecutor must be implemented and injected before invoking the build method !");
            }
            if (zlinkDependAbility.getEnableClipboardOutside() && ZlinkProviderManager.getProvider(IClipboard.class) == null) {
                throw new IllegalArgumentException("enableClipboardOutside is true but not config com.bytedance.ug.sdk.deeplink.interfaces.IClipboard.class");
            }
        }
    }
}
