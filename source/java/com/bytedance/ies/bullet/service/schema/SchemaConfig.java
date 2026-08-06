package com.bytedance.ies.bullet.service.schema;

import com.bytedance.ies.bullet.service.base.ISchemaConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SchemaConfig.kt */
@Deprecated(message = "Only for LuckyCat plugin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/SchemaConfig;", "Lcom/bytedance/ies/bullet/service/base/ISchemaConfig;", "_prefixList", "", "", "(Ljava/util/List;)V", "getPrefixList", "Builder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class SchemaConfig implements ISchemaConfig {
    private final List<String> _prefixList;

    public /* synthetic */ SchemaConfig(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    private SchemaConfig(List<String> list) {
        this._prefixList = list;
    }

    @Override // com.bytedance.ies.bullet.service.base.ISchemaConfig
    public List<String> getPrefixList() {
        return this._prefixList;
    }

    /* compiled from: SchemaConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/SchemaConfig$Builder;", "", "()V", "prefixList", "", "", "build", "Lcom/bytedance/ies/bullet/service/schema/SchemaConfig;", "setPrefixList", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {
        private List<String> prefixList = new ArrayList();

        public final Builder setPrefixList(List<String> prefixList) {
            Intrinsics.checkNotNullParameter(prefixList, "prefixList");
            this.prefixList.addAll(prefixList);
            return this;
        }

        public final SchemaConfig build() {
            return new SchemaConfig(this.prefixList, null);
        }
    }
}
