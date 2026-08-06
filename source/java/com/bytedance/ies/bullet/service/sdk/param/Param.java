package com.bytedance.ies.bullet.service.sdk.param;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.service.schema.IParam;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.sdk.SchemaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Param.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001c\u001a\u00020\bH&¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/Param;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/bullet/service/schema/IParam;", "value", "(Ljava/lang/Object;)V", "_isSet", "", "_key", "", "_value", "Ljava/lang/Object;", "isSet", "()Z", "key", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "initWithData", "", "data", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "defaultValue", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;Ljava/lang/String;Ljava/lang/Object;)V", "objectToValue", "", "(Ljava/lang/Object;)Ljava/lang/Object;", "stringToValue", "string", "(Ljava/lang/String;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Param<T> implements IParam {
    private boolean _isSet;
    private String _key;
    private T _value;

    public abstract T stringToValue(String string);

    public Param(T t) {
        this._value = t;
    }

    /* renamed from: isSet, reason: from getter */
    public final boolean get_isSet() {
        return this._isSet;
    }

    /* renamed from: getKey, reason: from getter */
    public final String get_key() {
        return this._key;
    }

    public final T getValue() {
        return this._value;
    }

    public final void initWithData(ISchemaData data, String key, T defaultValue) {
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        SchemaData schemaData = (SchemaData) data;
        this._key = key;
        String stringValue = schemaData.getStringValue(key);
        if (stringValue != null) {
            T stringToValue = stringToValue(stringValue);
            this._value = stringToValue;
            if (stringToValue != null) {
                this._isSet = true;
                return;
            }
            schemaData.markValueError(key, stringValue);
        }
        Bundle bundle = schemaData.get_innerBundle();
        if (bundle != null && (obj = bundle.get(key)) != null) {
            T objectToValue = objectToValue(obj);
            this._value = objectToValue;
            if (objectToValue != null) {
                this._isSet = true;
                return;
            }
            schemaData.markValueError(key, obj.toString());
        }
        this._value = defaultValue;
    }

    public T objectToValue(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String str = value instanceof String ? (String) value : null;
        if (str != null) {
            return stringToValue(str);
        }
        return null;
    }
}
