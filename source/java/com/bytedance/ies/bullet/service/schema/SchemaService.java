package com.bytedance.ies.bullet.service.schema;

import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.service.base.ChannelBundleModel;
import com.bytedance.ies.bullet.service.base.ISchemaConfig;
import com.bytedance.ies.bullet.service.base.ISchemaService;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SchemaService.kt */
@Deprecated(message = "Only for LuckyCat plugin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0017\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/SchemaService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/ISchemaService;", "config", "Lcom/bytedance/ies/bullet/service/base/ISchemaConfig;", "(Lcom/bytedance/ies/bullet/service/base/ISchemaConfig;)V", "getConfig", "()Lcom/bytedance/ies/bullet/service/base/ISchemaConfig;", "extractDetailFromPrefix", "Lcom/bytedance/ies/bullet/service/base/ChannelBundleModel;", "url", "", "prefixList", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SchemaService extends BaseBulletService implements ISchemaService {
    private static final String MODULE = "schema";
    private final ISchemaConfig config;

    public SchemaService(ISchemaConfig iSchemaConfig) {
        Intrinsics.checkNotNullParameter(iSchemaConfig, "config");
        this.config = iSchemaConfig;
    }

    @Override // com.bytedance.ies.bullet.service.base.ISchemaService
    public ISchemaConfig getConfig() {
        return this.config;
    }

    @Override // com.bytedance.ies.bullet.service.base.ISchemaService
    public ChannelBundleModel extractDetailFromPrefix(String url, List<String> prefixList) {
        Intrinsics.checkNotNullParameter(url, "url");
        RLChannelBundleModel parseChannelBundle = ResourceLoader.with$default(ResourceLoader.INSTANCE, getBid(), null, 2, null).parseChannelBundle(url);
        if (parseChannelBundle == null) {
            parseChannelBundle = new RLChannelBundleModel("", "", false);
        }
        return new ChannelBundleModel(parseChannelBundle.getChannel(), parseChannelBundle.getBundlePath(), parseChannelBundle.getValid());
    }
}
