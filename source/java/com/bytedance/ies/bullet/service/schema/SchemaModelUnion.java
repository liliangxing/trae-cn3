package com.bytedance.ies.bullet.service.schema;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SchemaModelUnion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;)V", "containerModel", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getContainerModel", "()Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "setContainerModel", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;)V", "kitModel", "getKitModel", "setKitModel", "getSchemaData", "()Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "uiModel", "getUiModel", "setUiModel", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SchemaModelUnion {
    private ISchemaModel containerModel;
    private ISchemaModel kitModel;
    private final ISchemaData schemaData;
    private ISchemaModel uiModel;

    public static /* synthetic */ SchemaModelUnion copy$default(SchemaModelUnion schemaModelUnion, ISchemaData iSchemaData, int i, Object obj) {
        if ((i & 1) != 0) {
            iSchemaData = schemaModelUnion.schemaData;
        }
        return schemaModelUnion.copy(iSchemaData);
    }

    /* renamed from: component1, reason: from getter */
    public final ISchemaData getSchemaData() {
        return this.schemaData;
    }

    public final SchemaModelUnion copy(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        return new SchemaModelUnion(schemaData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SchemaModelUnion) && Intrinsics.areEqual(this.schemaData, ((SchemaModelUnion) other).schemaData);
    }

    public int hashCode() {
        return this.schemaData.hashCode();
    }

    public String toString() {
        return "SchemaModelUnion(schemaData=" + this.schemaData + ')';
    }

    public SchemaModelUnion(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        this.schemaData = schemaData;
    }

    public final ISchemaData getSchemaData() {
        return this.schemaData;
    }

    public final ISchemaModel getContainerModel() {
        return this.containerModel;
    }

    public final void setContainerModel(ISchemaModel iSchemaModel) {
        this.containerModel = iSchemaModel;
    }

    public final ISchemaModel getUiModel() {
        return this.uiModel;
    }

    public final void setUiModel(ISchemaModel iSchemaModel) {
        this.uiModel = iSchemaModel;
    }

    public final ISchemaModel getKitModel() {
        return this.kitModel;
    }

    public final void setKitModel(ISchemaModel iSchemaModel) {
        this.kitModel = iSchemaModel;
    }
}
