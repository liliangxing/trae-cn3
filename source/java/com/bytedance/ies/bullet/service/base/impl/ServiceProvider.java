package com.bytedance.ies.bullet.service.base.impl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import kotlin.Metadata;

/* compiled from: BaseBulletService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/impl/ServiceProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "()V", "createService", "()Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ServiceProvider<T extends IBulletService> extends BaseBulletService {
    public abstract T createService();
}
