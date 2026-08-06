package com.bytedance.trae.settings.impl;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.trae.settings.api.ISettingsService;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsServiceImpl.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J#\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\tH\u0016¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/settings/impl/SettingsServiceImpl;", "Lcom/bytedance/trae/settings/api/ISettingsService;", "<init>", "()V", EventConstants.PARAM_SOURCE_INIT, "", "obtain", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "updateSettings", "force", "", "registerListener", "listener", "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "callbackOnMainThread", "unregisterListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SettingsServiceImpl implements ISettingsService {
    private static final String TAG = "Settings";

    @Override // com.bytedance.trae.settings.api.ISettingsService
    public void init() {
        try {
            SettingsManager.updateSettings(false);
            FLogger.INSTANCE.mo428i(TAG, "SettingsServiceImpl init: updateSettings done");
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "SettingsServiceImpl init: exception " + e.getMessage());
        }
    }

    @Override // com.bytedance.trae.settings.api.ISettingsService
    public <T> T obtain(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return (T) SettingsManager.obtain(clazz);
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "SettingsServiceImpl obtain " + clazz.getSimpleName() + ": exception " + e.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.trae.settings.api.ISettingsService
    public void updateSettings(boolean force) {
        try {
            SettingsManager.updateSettings(force);
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "SettingsServiceImpl updateSettings: exception " + e.getMessage());
        }
    }

    @Override // com.bytedance.trae.settings.api.ISettingsService
    public void registerListener(SettingsUpdateListener listener, boolean callbackOnMainThread) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SettingsManager.registerListener(listener, callbackOnMainThread);
    }

    @Override // com.bytedance.trae.settings.api.ISettingsService
    public void unregisterListener(SettingsUpdateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SettingsManager.unregisterListener(listener);
    }
}
