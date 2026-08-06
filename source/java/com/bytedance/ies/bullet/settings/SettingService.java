package com.bytedance.ies.bullet.settings;

import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.pia.core.metrics.ErrorType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: SettingService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/settings/SettingService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/ISettingService;", "()V", ErrorType.SETTINGS, "Lcom/bytedance/ies/bullet/service/base/BulletSettings;", "getSettings", "()Lcom/bytedance/ies/bullet/service/base/BulletSettings;", "settings$delegate", "Lkotlin/Lazy;", "provideBulletSettings", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SettingService extends BaseBulletService implements ISettingService {

    /* renamed from: settings$delegate, reason: from kotlin metadata */
    private final Lazy settings = LazyKt.lazy(new Function0<BulletSettings>() { // from class: com.bytedance.ies.bullet.settings.SettingService$settings$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BulletSettings m592invoke() {
            return new BulletSettings();
        }
    });

    private final BulletSettings getSettings() {
        return (BulletSettings) this.settings.getValue();
    }

    @Override // com.bytedance.ies.bullet.service.base.ISettingService
    public BulletSettings provideBulletSettings() {
        return getSettings();
    }
}
