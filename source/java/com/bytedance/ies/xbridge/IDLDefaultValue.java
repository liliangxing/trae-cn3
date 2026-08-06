package com.bytedance.ies.xbridge;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.xbridge.annotation.DefaultType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeRegistryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/bytedance/ies/xbridge/IDLDefaultValue;", "", "type", "Lcom/bytedance/ies/xbridge/annotation/DefaultType;", "doubleValue", "", "stringValue", "", "intValue", "", "boolValue", "", "longValue", "", "(Lcom/bytedance/ies/xbridge/annotation/DefaultType;DLjava/lang/String;IZJ)V", "getBoolValue", "()Z", "getDoubleValue", "()D", "getIntValue", "()I", "getLongValue", "()J", "getStringValue", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/ies/xbridge/annotation/DefaultType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class IDLDefaultValue {
    private final boolean boolValue;
    private final double doubleValue;
    private final int intValue;
    private final long longValue;
    private final String stringValue;
    private final DefaultType type;

    public IDLDefaultValue() {
        this(null, 0.0d, null, 0, false, 0L, 63, null);
    }

    /* renamed from: component1, reason: from getter */
    public final DefaultType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final double getDoubleValue() {
        return this.doubleValue;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStringValue() {
        return this.stringValue;
    }

    /* renamed from: component4, reason: from getter */
    public final int getIntValue() {
        return this.intValue;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getBoolValue() {
        return this.boolValue;
    }

    /* renamed from: component6, reason: from getter */
    public final long getLongValue() {
        return this.longValue;
    }

    public final IDLDefaultValue copy(DefaultType type, double doubleValue, String stringValue, int intValue, boolean boolValue, long longValue) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(stringValue, "stringValue");
        return new IDLDefaultValue(type, doubleValue, stringValue, intValue, boolValue, longValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IDLDefaultValue)) {
            return false;
        }
        IDLDefaultValue iDLDefaultValue = (IDLDefaultValue) other;
        return this.type == iDLDefaultValue.type && Double.compare(this.doubleValue, iDLDefaultValue.doubleValue) == 0 && Intrinsics.areEqual(this.stringValue, iDLDefaultValue.stringValue) && this.intValue == iDLDefaultValue.intValue && this.boolValue == iDLDefaultValue.boolValue && this.longValue == iDLDefaultValue.longValue;
    }

    public int hashCode() {
        return (((((((((this.type.hashCode() * 31) + Double.hashCode(this.doubleValue)) * 31) + this.stringValue.hashCode()) * 31) + Integer.hashCode(this.intValue)) * 31) + Boolean.hashCode(this.boolValue)) * 31) + Long.hashCode(this.longValue);
    }

    public String toString() {
        return "IDLDefaultValue(type=" + this.type + ", doubleValue=" + this.doubleValue + ", stringValue=" + this.stringValue + ", intValue=" + this.intValue + ", boolValue=" + this.boolValue + ", longValue=" + this.longValue + ')';
    }

    public IDLDefaultValue(DefaultType type, double d, String stringValue, int i, boolean z, long j) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(stringValue, "stringValue");
        this.type = type;
        this.doubleValue = d;
        this.stringValue = stringValue;
        this.intValue = i;
        this.boolValue = z;
        this.longValue = j;
    }

    public /* synthetic */ IDLDefaultValue(DefaultType defaultType, double d, String str, int i, boolean z, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? DefaultType.NONE : defaultType, (i2 & 2) != 0 ? 0.0d : d, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? 0 : i, (i2 & 16) == 0 ? z : false, (i2 & 32) != 0 ? 0L : j);
    }

    public final DefaultType getType() {
        return this.type;
    }

    public final double getDoubleValue() {
        return this.doubleValue;
    }

    public final String getStringValue() {
        return this.stringValue;
    }

    public final int getIntValue() {
        return this.intValue;
    }

    public final boolean getBoolValue() {
        return this.boolValue;
    }

    public final long getLongValue() {
        return this.longValue;
    }
}
