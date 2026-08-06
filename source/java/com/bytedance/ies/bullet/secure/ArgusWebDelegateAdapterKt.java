package com.bytedance.ies.bullet.secure;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.argus.api.params.ContainerCreatedParams;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusWebDelegateAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"initArgusContainerCreatedParams", "Lcom/bytedance/ies/argus/api/params/ContainerCreatedParams;", "Lcom/bytedance/ies/bullet/core/BulletContext;", "createType", "Lcom/bytedance/ies/argus/api/params/ArgusContainerCreateType;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArgusWebDelegateAdapterKt {
    public static final ContainerCreatedParams initArgusContainerCreatedParams(BulletContext bulletContext, ArgusContainerCreateType argusContainerCreateType) {
        Intrinsics.checkNotNullParameter(argusContainerCreateType, "createType");
        if (bulletContext == null) {
            return new ContainerCreatedParams((Uri) null, argusContainerCreateType, (String) null, (Bundle) null, 8, (DefaultConstructorMarker) null);
        }
        ISchemaData schemaData = bulletContext.getSchemaData();
        return new ContainerCreatedParams(schemaData != null ? schemaData.getInnerOriginUrl() : null, argusContainerCreateType, bulletContext.getBid(), bulletContext.getSchemeContext().getBundle());
    }
}
