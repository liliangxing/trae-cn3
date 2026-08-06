package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.api.IBulletService;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: ISchemaService.kt */
@Deprecated(message = "Only for LuckyCat plugin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ISchemaService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "config", "Lcom/bytedance/ies/bullet/service/base/ISchemaConfig;", "getConfig", "()Lcom/bytedance/ies/bullet/service/base/ISchemaConfig;", "extractDetailFromPrefix", "Lcom/bytedance/ies/bullet/service/base/ChannelBundleModel;", "url", "", "prefixList", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ISchemaService extends IBulletService {
    ChannelBundleModel extractDetailFromPrefix(String url, List<String> prefixList);

    ISchemaConfig getConfig();

    /* compiled from: ISchemaService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelBundleModel extractDetailFromPrefix$default(ISchemaService iSchemaService, String str, List list, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: extractDetailFromPrefix");
            }
            if ((i & 2) != 0) {
                list = null;
            }
            return iSchemaService.extractDetailFromPrefix(str, list);
        }
    }
}
