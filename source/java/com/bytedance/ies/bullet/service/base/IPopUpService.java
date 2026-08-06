package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.api.IBulletUIService;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: IPopUpService.kt */
@Deprecated(message = "use InitializeConfig.setPopupConfig(config: IPopupConfig)")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IPopUpService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletUIService;", "popupConfig", "Lcom/bytedance/ies/bullet/service/base/IPopupConfig;", "getPopupConfig", "()Lcom/bytedance/ies/bullet/service/base/IPopupConfig;", "adjustHeight", "", "heightPercent", "", "animated", "draggable", "dismiss", "containerId", "", "getPopupStack", "", "Lcom/bytedance/ies/bullet/service/base/IRouterAbilityProvider;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPopUpService extends IBulletUIService {

    /* compiled from: IPopUpService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean adjustHeight(IPopUpService iPopUpService, int i, boolean z, boolean z2) {
            return false;
        }
    }

    boolean adjustHeight(int heightPercent, boolean animated, boolean draggable);

    boolean dismiss(String containerId);

    IPopupConfig getPopupConfig();

    List<IRouterAbilityProvider> getPopupStack();
}
