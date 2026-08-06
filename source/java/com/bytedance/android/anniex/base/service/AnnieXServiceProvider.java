package com.bytedance.android.anniex.base.service;

import com.bytedance.android.anniex.ability.service.AnnieXPitayaProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXAccountService;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.android.anniex.ability.service.IAnnieXLifecycleConfigService;
import com.bytedance.android.anniex.ability.service.IAnnieXPropsProvider;
import com.bytedance.android.anniex.lite.base.IAnnieXHostActivityService;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegateProvider;
import com.bytedance.android.anniex.lite.base.IAnnieXLynxProcess;
import com.bytedance.android.anniex.lite.base.ILitePageService;
import com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieXPreloadStrategyProvider;
import com.bytedance.android.anniex.utils.IAnnieXLatchService;
import kotlin.Metadata;

/* compiled from: AnnieXServiceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXServiceProvider;", "", "()V", "createAnnieXPitayaProvider", "Lcom/bytedance/android/anniex/ability/service/AnnieXPitayaProvider;", "createAnnieXSettingsService", "Lcom/bytedance/android/anniex/base/service/AnnieXSettingsService;", "createIAnnieXAccountService", "Lcom/bytedance/android/anniex/ability/service/IAnnieXAccountService;", "createIAnnieXBizPropsProvider", "Lcom/bytedance/android/anniex/ability/service/IAnnieXBizPropsProvider;", "createIAnnieXContextProvider", "Lcom/bytedance/android/anniex/ability/service/IAnnieXContextProvider;", "createIAnnieXCustomActivityService", "Lcom/bytedance/android/anniex/ability/service/IAnnieXCustomActivityService;", "createIAnnieXHostActivityService", "Lcom/bytedance/android/anniex/lite/base/IAnnieXHostActivityService;", "createIAnnieXLatchService", "Lcom/bytedance/android/anniex/utils/IAnnieXLatchService;", "createIAnnieXLifecycleConfigService", "Lcom/bytedance/android/anniex/ability/service/IAnnieXLifecycleConfigService;", "createIAnnieXLitePageDelegateProvider", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegateProvider;", "createIAnnieXLynxProcess", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLynxProcess;", "createIAnnieXPreloadStrategyProvider", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/IAnnieXPreloadStrategyProvider;", "createIAnnieXPropsProvider", "Lcom/bytedance/android/anniex/ability/service/IAnnieXPropsProvider;", "createILitePageService", "Lcom/bytedance/android/anniex/lite/base/ILitePageService;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class AnnieXServiceProvider {
    public AnnieXPitayaProvider createAnnieXPitayaProvider() {
        return null;
    }

    public AnnieXSettingsService createAnnieXSettingsService() {
        return null;
    }

    public IAnnieXAccountService createIAnnieXAccountService() {
        return null;
    }

    public IAnnieXBizPropsProvider createIAnnieXBizPropsProvider() {
        return null;
    }

    public IAnnieXContextProvider createIAnnieXContextProvider() {
        return null;
    }

    public IAnnieXCustomActivityService createIAnnieXCustomActivityService() {
        return null;
    }

    public IAnnieXHostActivityService createIAnnieXHostActivityService() {
        return null;
    }

    public IAnnieXLatchService createIAnnieXLatchService() {
        return null;
    }

    public IAnnieXLifecycleConfigService createIAnnieXLifecycleConfigService() {
        return null;
    }

    public IAnnieXLitePageDelegateProvider createIAnnieXLitePageDelegateProvider() {
        return null;
    }

    public IAnnieXLynxProcess createIAnnieXLynxProcess() {
        return null;
    }

    public IAnnieXPreloadStrategyProvider createIAnnieXPreloadStrategyProvider() {
        return null;
    }

    public IAnnieXPropsProvider createIAnnieXPropsProvider() {
        return null;
    }

    public ILitePageService createILitePageService() {
        return null;
    }
}
