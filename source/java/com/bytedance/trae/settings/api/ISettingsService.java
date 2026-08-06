package com.bytedance.trae.settings.api;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: ISettingsService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J#\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H&¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/settings/api/ISettingsService;", "", "init", "", "obtain", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "updateSettings", "force", "", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "callbackOnMainThread", "unregisterListener", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ISettingsService {
    void init();

    <T> T obtain(Class<T> clazz);

    void registerListener(SettingsUpdateListener listener, boolean callbackOnMainThread);

    void unregisterListener(SettingsUpdateListener listener);

    void updateSettings(boolean force);

    /* compiled from: ISettingsService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void updateSettings$default(ISettingsService iSettingsService, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSettings");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            iSettingsService.updateSettings(z);
        }

        public static /* synthetic */ void registerListener$default(ISettingsService iSettingsService, SettingsUpdateListener settingsUpdateListener, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerListener");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            iSettingsService.registerListener(settingsUpdateListener, z);
        }
    }
}
