package com.bytedance.ies.bullet.service.base.settings;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import kotlin.Metadata;

/* compiled from: IBulletSettingsService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J#\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH&¢\u0006\u0002\u0010\u000eR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/IBulletSettingsService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "config", "Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;", "getConfig", "()Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;", "setConfig", "(Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;)V", "checkUpdate", "", "obtainSettings", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletSettingsService extends IBulletService {
    void checkUpdate();

    BulletSettingsConfig getConfig();

    <T> T obtainSettings(Class<T> clazz);

    void setConfig(BulletSettingsConfig bulletSettingsConfig);
}
