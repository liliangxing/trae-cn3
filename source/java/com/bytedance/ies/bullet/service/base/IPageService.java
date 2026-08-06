package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.api.IBulletUIService;
import com.bytedance.pia.core.plugins.PiaPropsPlugin;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: IPageService.kt */
@Deprecated(message = "use InitializeConfig.setPageConfig(pageConfig: IPageConfig)")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IPageService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletUIService;", "pageConfig", "Lcom/bytedance/ies/bullet/service/base/IPageConfig;", PiaPropsPlugin.PROPS_NAME_PAGE_CONFIG, "()Lcom/bytedance/ies/bullet/service/base/IPageConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPageService extends IBulletUIService {
    IPageConfig getPageConfig();
}
