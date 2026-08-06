package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.api.IBulletService;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: ISettingService.kt */
@Deprecated(message = "配置逐渐迁移至BulletSettings通道")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ISettingService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "provideBulletSettings", "Lcom/bytedance/ies/bullet/service/base/BulletSettings;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ISettingService extends IBulletService {
    BulletSettings provideBulletSettings();
}
