package com.lynx.animax.setting;

import java.util.Collection;
import java.util.Collections;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public final class AnimaXSettingValue {
    private final Boolean mBooleanValue;
    private final Collection<String> mCollectionValue;
    private final Double mDoubleValue;
    private final Long mLongValue;
    private final String mStringValue;
    private final SettingType mType;

    /* loaded from: classes6.dex */
    private enum SettingType {
        STRING,
        COLLECTION,
        BOOLEAN,
        LONG,
        DOUBLE
    }

    private AnimaXSettingValue(String str) {
        this.mStringValue = str;
        this.mCollectionValue = null;
        this.mBooleanValue = null;
        this.mLongValue = null;
        this.mDoubleValue = null;
        this.mType = SettingType.STRING;
    }

    private AnimaXSettingValue(Collection<String> collection) {
        this.mStringValue = null;
        this.mCollectionValue = collection;
        this.mBooleanValue = null;
        this.mLongValue = null;
        this.mDoubleValue = null;
        this.mType = SettingType.COLLECTION;
    }

    private AnimaXSettingValue(Boolean bool) {
        this.mStringValue = null;
        this.mCollectionValue = null;
        this.mBooleanValue = bool;
        this.mLongValue = null;
        this.mDoubleValue = null;
        this.mType = SettingType.BOOLEAN;
    }

    private AnimaXSettingValue(Long l) {
        this.mStringValue = null;
        this.mCollectionValue = null;
        this.mBooleanValue = null;
        this.mLongValue = l;
        this.mDoubleValue = null;
        this.mType = SettingType.LONG;
    }

    private AnimaXSettingValue(Double d) {
        this.mStringValue = null;
        this.mCollectionValue = null;
        this.mBooleanValue = null;
        this.mLongValue = null;
        this.mDoubleValue = d;
        this.mType = SettingType.DOUBLE;
    }

    public static AnimaXSettingValue fromString(String str) {
        if (str == null) {
            str = "";
        }
        return new AnimaXSettingValue(str);
    }

    public static AnimaXSettingValue fromCollection(Collection<String> collection) {
        if (collection == null) {
            collection = Collections.emptyList();
        }
        return new AnimaXSettingValue(collection);
    }

    public static AnimaXSettingValue fromBoolean(boolean z) {
        return new AnimaXSettingValue(Boolean.valueOf(z));
    }

    public static AnimaXSettingValue fromLong(long j) {
        return new AnimaXSettingValue(Long.valueOf(j));
    }

    public static AnimaXSettingValue fromDouble(double d) {
        return new AnimaXSettingValue(Double.valueOf(d));
    }

    public static AnimaXSettingValue empty() {
        return new AnimaXSettingValue("");
    }

    public boolean isString() {
        return this.mType == SettingType.STRING;
    }

    public boolean isCollection() {
        return this.mType == SettingType.COLLECTION;
    }

    public boolean isBoolean() {
        return this.mType == SettingType.BOOLEAN;
    }

    public boolean isLong() {
        return this.mType == SettingType.LONG;
    }

    public boolean isDouble() {
        return this.mType == SettingType.DOUBLE;
    }

    public String getStringOrEmpty() {
        return this.mType == SettingType.STRING ? this.mStringValue : "";
    }

    public Collection<String> getCollectionOrEmpty() {
        return this.mType == SettingType.COLLECTION ? this.mCollectionValue : Collections.emptyList();
    }

    public boolean getBooleanOrFalse() {
        Boolean bool;
        if (this.mType != SettingType.BOOLEAN || (bool = this.mBooleanValue) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public long getLongOrZero() {
        Long l;
        if (this.mType != SettingType.LONG || (l = this.mLongValue) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public double getDoubleOrZero() {
        Double d;
        if (this.mType != SettingType.DOUBLE || (d = this.mDoubleValue) == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{type=");
        sb.append(this.mType.name());
        sb.append(", value=");
        int i = AnonymousClass1.$SwitchMap$com$lynx$animax$setting$AnimaXSettingValue$SettingType[this.mType.ordinal()];
        if (i == 1) {
            String str = this.mStringValue;
            sb.append(str != null ? str : "");
        } else if (i != 2) {
            if (i == 3) {
                Object obj = this.mBooleanValue;
                if (obj == null) {
                    obj = "false";
                }
                sb.append(obj);
            } else if (i == 4) {
                Object obj2 = this.mLongValue;
                if (obj2 == null) {
                    obj2 = "0";
                }
                sb.append(obj2);
            } else if (i == 5) {
                Object obj3 = this.mDoubleValue;
                if (obj3 == null) {
                    obj3 = "0.0";
                }
                sb.append(obj3);
            } else {
                sb.append("");
            }
        } else if (this.mCollectionValue != null) {
            sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(UByte$$ExternalSyntheticBackport0.m((CharSequence) ", ", (Iterable) this.mCollectionValue)).append(AbstractJsonLexerKt.END_LIST);
        } else {
            sb.append("[]");
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: com.lynx.animax.setting.AnimaXSettingValue$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$animax$setting$AnimaXSettingValue$SettingType;

        static {
            int[] iArr = new int[SettingType.values().length];
            $SwitchMap$com$lynx$animax$setting$AnimaXSettingValue$SettingType = iArr;
            try {
                iArr[SettingType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$animax$setting$AnimaXSettingValue$SettingType[SettingType.COLLECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$animax$setting$AnimaXSettingValue$SettingType[SettingType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$animax$setting$AnimaXSettingValue$SettingType[SettingType.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lynx$animax$setting$AnimaXSettingValue$SettingType[SettingType.DOUBLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
