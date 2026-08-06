package com.bytedance.ies.bullet.service.base.lynx;

import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IKitDynamicService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/lynx/IKitDynamicService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "checkInstalled", "", "type", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "install", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IKitDynamicService extends IBulletService {

    /* compiled from: IKitDynamicService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean checkInstalled(IKitDynamicService iKitDynamicService, KitType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return false;
        }
    }

    boolean checkInstalled(KitType type);

    void install(KitType type);
}
