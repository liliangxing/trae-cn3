package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYClass.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u0000 \r2\u00020\u0001:\u0003\f\r\u000eB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYClass;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "classType", "", "(I)V", "bindID", "", "getBindID$pitayacore_release", "()Ljava/lang/String;", "getClassType", "()I", "toString", "ClassType", "Companion", "DataDeliverType", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PTYClass implements ReflectionCall {
    public static final int CLASS_TYPE_COUNT = 4;
    public static final int ORIGIN_TYPE_BYTE_ARRAY = 2;
    public static final int ORIGIN_TYPE_FLOAT_ARRAY = 3;
    public static final int PTY_CLASS_MEMORY_VIEW = 1;
    public static final int PTY_CLASS_MOBILE_CVMAT = 2;
    public static final int PTY_CLASS_ND_ARRAY = 3;
    public static final int PTY_CLASS_TENSOR = 0;
    private final String bindID;
    private final int classType;

    /* compiled from: PTYClass.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYClass$ClassType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes4.dex */
    public @interface ClassType {
    }

    /* compiled from: PTYClass.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYClass$DataDeliverType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes4.dex */
    public @interface DataDeliverType {
    }

    public PTYClass() {
        this(0, 1, null);
    }

    public PTYClass(int i) {
        this.classType = i;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.bindID = uuid;
    }

    public /* synthetic */ PTYClass(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 4 : i);
    }

    public final int getClassType() {
        return this.classType;
    }

    /* renamed from: getBindID$pitayacore_release, reason: from getter */
    public final String getBindID() {
        return this.bindID;
    }

    public String toString() {
        return this.bindID;
    }
}
