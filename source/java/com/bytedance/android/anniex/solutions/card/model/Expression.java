package com.bytedance.android.anniex.solutions.card.model;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Expression.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/model/Expression;", "", "id", "", "name", "defaultValue", RemoteMessageConst.MessageBody.PARAM, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getDefaultValue", "()Ljava/lang/Object;", "getId", "()Ljava/lang/String;", "getName", "getParam", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Expression {

    @SerializedName(AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE)
    private final Object defaultValue;

    @SerializedName(AirActionConstant.ActionId.ACTION_ID)
    private final String id;

    @SerializedName(AirActionConstant.ActionId.ACTION_ID_NAME)
    private final String name;

    @SerializedName(AirActionConstant.ActionId.ACTION_ID_PARAMS)
    private final Object param;

    public Expression() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Expression copy$default(Expression expression, String str, String str2, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            str = expression.id;
        }
        if ((i & 2) != 0) {
            str2 = expression.name;
        }
        if ((i & 4) != 0) {
            obj = expression.defaultValue;
        }
        if ((i & 8) != 0) {
            obj2 = expression.param;
        }
        return expression.copy(str, str2, obj, obj2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    /* renamed from: component4, reason: from getter */
    public final Object getParam() {
        return this.param;
    }

    public final Expression copy(String id, String name, Object defaultValue, Object param) {
        return new Expression(id, name, defaultValue, param);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Expression)) {
            return false;
        }
        Expression expression = (Expression) other;
        return Intrinsics.areEqual(this.id, expression.id) && Intrinsics.areEqual(this.name, expression.name) && Intrinsics.areEqual(this.defaultValue, expression.defaultValue) && Intrinsics.areEqual(this.param, expression.param);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Object obj = this.defaultValue;
        int hashCode3 = (hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.param;
        return hashCode3 + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Expression(id=" + this.id + ", name=" + this.name + ", defaultValue=" + this.defaultValue + ", param=" + this.param + ')';
    }

    public Expression(String str, String str2, Object obj, Object obj2) {
        this.id = str;
        this.name = str2;
        this.defaultValue = obj;
        this.param = obj2;
    }

    public /* synthetic */ Expression(String str, String str2, Object obj, Object obj2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : obj, (i & 8) != 0 ? null : obj2);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final Object getParam() {
        return this.param;
    }
}
