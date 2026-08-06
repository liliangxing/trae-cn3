package com.bytedance.ies.bullet.kit.lynx.service;

import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.lynx.service.ILynxGlobalConfigService;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.model.BDXLynxKitModel;
import com.lynx.tasm.TemplateBundle;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ILynxGlobalConfigService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\u0018\u00010\u0005H\u0016J\u0012\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/kit/lynx/service/BaseLynxGlobalConfigService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/kit/lynx/service/ILynxGlobalConfigService;", "()V", "createBehaviors", "", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "createGlobalClientDelegate", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "createKitViewLifecycleDelegate", "Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "createLynxModule", "getExtraModelType", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getModelType", "getTemplateBundleByUrl", "Lcom/lynx/tasm/TemplateBundle;", "url", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseLynxGlobalConfigService extends BaseBulletService implements ILynxGlobalConfigService {
    @Override // com.bytedance.ies.bullet.kit.lynx.service.ILynxGlobalConfigService
    public List<?> createBehaviors(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.lynx.service.ILynxGlobalConfigService
    public ILynxClientDelegate createGlobalClientDelegate(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.kit.service.IBulletGlobalConfigService
    public IBulletLoadLifeCycle createKitViewLifecycleDelegate(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.lynx.service.ILynxGlobalConfigService
    public List<?> createLynxModule(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.ICommonConfigService
    public List<Class<? extends ISchemaModel>> getExtraModelType() {
        return null;
    }

    @Deprecated(message = "仅用于轻量级全页和flow全页，其他场景请勿使用")
    public TemplateBundle getTemplateBundleByUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.ICommonConfigService
    public Map<String, Object> getConstants(ContextProviderFactory contextProviderFactory) {
        return ILynxGlobalConfigService.DefaultImpls.getConstants(this, contextProviderFactory);
    }

    @Override // com.bytedance.ies.bullet.service.base.ICommonConfigService
    public Class<? extends ISchemaModel> getModelType() {
        return BDXLynxKitModel.class;
    }
}
