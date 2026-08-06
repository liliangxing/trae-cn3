package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICommonConfigService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\u0018\u00010\tH&J\u0012\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\nH&¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ICommonConfigService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getConstants", "", "", "", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getExtraModelType", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getModelType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ICommonConfigService extends IBulletService {

    /* compiled from: ICommonConfigService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static Map<String, Object> getConstants(ICommonConfigService iCommonConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }
    }

    Map<String, Object> getConstants(ContextProviderFactory providerFactory);

    List<Class<? extends ISchemaModel>> getExtraModelType();

    Class<? extends ISchemaModel> getModelType();
}
