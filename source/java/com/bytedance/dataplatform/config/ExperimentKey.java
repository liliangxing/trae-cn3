package com.bytedance.dataplatform.config;

import com.bytedance.applog.server.Api;
import com.bytedance.dataplatform.ExperimentConst;
import com.bytedance.dataplatform.ExperimentManager;
import com.bytedance.dataplatform.client.ClientDataSource;
import com.bytedance.dataplatform.client.ClientGroup;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExperimentKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0012\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001+B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bJ\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u0011J)\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u0010&J\u0015\u0010 \u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010(J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0012\u001a\u00020\u0011J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0013\u001a\u00020\u0011R\u0018\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00028\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b \u0010\f¨\u0006,"}, d2 = {"Lcom/bytedance/dataplatform/config/ExperimentKey;", "T", "", Api.KEY_ENCRYPT_RESP_KEY, "", "type", "Ljava/lang/reflect/Type;", "defaultValue", "(Ljava/lang/String;Ljava/lang/reflect/Type;Ljava/lang/Object;)V", "clientDataSourceBuilder", "Lcom/bytedance/dataplatform/config/ExperimentKey$ClientDataSourceBuilder;", "getDefaultValue", "()Ljava/lang/Object;", "setDefaultValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isBindToUser", "", "isEnable", "isSticky", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "layer", "startPoint", "", "getType", "()Ljava/lang/reflect/Type;", "setType", "(Ljava/lang/reflect/Type;)V", "value", "getValue", "bindToUser", "clientGroup", "percent", "vid", "groupValue", "(DLjava/lang/String;Ljava/lang/Object;)Lcom/bytedance/dataplatform/config/ExperimentKey;", "withExposure", "(Z)Ljava/lang/Object;", "setEnable", "setSticky", "ClientDataSourceBuilder", "experiment_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ExperimentKey<T> {
    private ClientDataSourceBuilder<T> clientDataSourceBuilder;
    private T defaultValue;
    private boolean isBindToUser;
    private boolean isEnable;
    private boolean isSticky;
    private String key;
    private String layer;
    private double startPoint;
    private Type type;

    public final ExperimentKey<T> layer(String str) {
        return layer$default(this, str, 0.0d, 2, null);
    }

    public ExperimentKey(String str, Type type, T t) {
        Intrinsics.checkParameterIsNotNull(str, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.key = str;
        this.type = type;
        this.defaultValue = t;
        this.isEnable = true;
    }

    public final T getDefaultValue() {
        return this.defaultValue;
    }

    public final String getKey() {
        return this.key;
    }

    public final Type getType() {
        return this.type;
    }

    public final void setDefaultValue(T t) {
        this.defaultValue = t;
    }

    public final void setKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.key = str;
    }

    public final void setType(Type type) {
        Intrinsics.checkParameterIsNotNull(type, "<set-?>");
        this.type = type;
    }

    public final ExperimentKey<T> setSticky(boolean isSticky) {
        this.isSticky = isSticky;
        return this;
    }

    public final ExperimentKey<T> setEnable(boolean isEnable) {
        this.isEnable = isEnable;
        return this;
    }

    public final ExperimentKey<T> bindToUser(boolean isBindToUser) {
        this.isBindToUser = isBindToUser;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExperimentKey.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00028\u0001¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\nR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/dataplatform/config/ExperimentKey$ClientDataSourceBuilder;", "T", "", "()V", "clientGroups", "", "Lcom/bytedance/dataplatform/client/ClientGroup;", "add", "", "percent", "", "vid", "", "groupValue", "(DLjava/lang/String;Ljava/lang/Object;)V", "bulid", "Lcom/bytedance/dataplatform/client/ClientDataSource;", "layer", "startPoint", "experiment_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class ClientDataSourceBuilder<T> {
        private final List<ClientGroup<T>> clientGroups = new ArrayList();

        public final void add(double percent, String vid, T groupValue) {
            this.clientGroups.add(new ClientGroup<>(vid, percent, groupValue));
        }

        public final ClientDataSource<T> bulid(String layer, double startPoint) {
            Object[] array = this.clientGroups.toArray(new ClientGroup[0]);
            if (array != null) {
                ClientGroup[] clientGroupArr = (ClientGroup[]) array;
                return new ClientDataSource<>(layer, startPoint, ExperimentConst.AB_TEST_NOAPT_MODULE_NAME, null, (ClientGroup[]) Arrays.copyOf(clientGroupArr, clientGroupArr.length));
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public static /* synthetic */ ExperimentKey layer$default(ExperimentKey experimentKey, String str, double d, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layer");
        }
        if ((i & 2) != 0) {
            d = 0.0d;
        }
        return experimentKey.layer(str, d);
    }

    public final ExperimentKey<T> layer(String layer, double startPoint) {
        this.layer = layer;
        this.startPoint = startPoint;
        return this;
    }

    public final ExperimentKey<T> clientGroup(double percent, String vid, T groupValue) {
        Intrinsics.checkParameterIsNotNull(vid, "vid");
        if (this.clientDataSourceBuilder == null) {
            this.clientDataSourceBuilder = new ClientDataSourceBuilder<>();
        }
        ClientDataSourceBuilder<T> clientDataSourceBuilder = this.clientDataSourceBuilder;
        if (clientDataSourceBuilder == null) {
            Intrinsics.throwNpe();
        }
        clientDataSourceBuilder.add(percent, vid, groupValue);
        return this;
    }

    public final T getValue() {
        return getValue(true);
    }

    public T getValue(boolean withExposure) {
        ClientDataSource<T> clientDataSource;
        String str = this.key;
        Type type = this.type;
        T t = this.defaultValue;
        boolean z = this.isEnable;
        boolean z2 = this.isSticky;
        boolean z3 = this.isBindToUser;
        ClientDataSourceBuilder<T> clientDataSourceBuilder = this.clientDataSourceBuilder;
        if (clientDataSourceBuilder != null) {
            String str2 = this.layer;
            if (str2 == null) {
                str2 = this.key + this.type.toString();
            }
            clientDataSource = clientDataSourceBuilder.bulid(str2, this.startPoint);
        } else {
            clientDataSource = null;
        }
        T t2 = (T) ExperimentManager.getExperimentValue(str, type, t, z, z2, withExposure, z3, clientDataSource);
        if (t2 == null) {
            Intrinsics.throwNpe();
        }
        return t2;
    }
}
