package com.bytedance.pitaya.api.bean;

import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PTYPackageInfo.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001/BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Jc\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010¨\u00060"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYPackageInfo;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "name", "", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "deployment", "taskType", "", PraiseDialogConstant.FROM, "buildTime", "extraStr", "models", "", "Lcom/bytedance/pitaya/api/bean/PTYModelInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBuildTime", "()Ljava/lang/String;", "getDeployment", "extra", "Lorg/json/JSONObject;", "getExtra", "()Lorg/json/JSONObject;", "extra$delegate", "Lkotlin/Lazy;", "getExtraStr", "getFrom", "()I", "getModels", "()Ljava/util/List;", "getName", "getTaskType", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class PTYPackageInfo implements ReflectionCall {
    public static final int PACKAGE_FROM_DEBUG = 0;
    public static final int PACKAGE_FROM_PRE_RELEASE = 1;
    public static final int PACKAGE_FROM_RELEASE = 2;
    public static final int PACKAGE_FROM_UNKNOWN = 3;
    public static final int TASK_TYPE_COUNT = 3;
    public static final int TASK_TYPE_MIN_PYTHON = 2;
    public static final int TASK_TYPE_PYTHON = 1;
    public static final int TASK_TYPE_RESOURCE = 0;
    private final String buildTime;
    private final String deployment;

    /* renamed from: extra$delegate, reason: from kotlin metadata */
    private final Lazy extra;
    private final String extraStr;
    private final int from;
    private final List<PTYModelInfo> models;
    private final String name;
    private final int taskType;
    private final String version;

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeployment() {
        return this.deployment;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTaskType() {
        return this.taskType;
    }

    /* renamed from: component5, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBuildTime() {
        return this.buildTime;
    }

    /* renamed from: component7, reason: from getter */
    public final String getExtraStr() {
        return this.extraStr;
    }

    public final List<PTYModelInfo> component8() {
        return this.models;
    }

    public final PTYPackageInfo copy(String name, String version, String deployment, int taskType, int from, String buildTime, String extraStr, List<PTYModelInfo> models) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, IPiaCacheProvider.CacheConfig.FIELD_VERSION);
        Intrinsics.checkNotNullParameter(deployment, "deployment");
        Intrinsics.checkNotNullParameter(buildTime, "buildTime");
        return new PTYPackageInfo(name, version, deployment, taskType, from, buildTime, extraStr, models);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PTYPackageInfo)) {
            return false;
        }
        PTYPackageInfo pTYPackageInfo = (PTYPackageInfo) other;
        return Intrinsics.areEqual(this.name, pTYPackageInfo.name) && Intrinsics.areEqual(this.version, pTYPackageInfo.version) && Intrinsics.areEqual(this.deployment, pTYPackageInfo.deployment) && this.taskType == pTYPackageInfo.taskType && this.from == pTYPackageInfo.from && Intrinsics.areEqual(this.buildTime, pTYPackageInfo.buildTime) && Intrinsics.areEqual(this.extraStr, pTYPackageInfo.extraStr) && Intrinsics.areEqual(this.models, pTYPackageInfo.models);
    }

    public int hashCode() {
        int hashCode = ((((((((((this.name.hashCode() * 31) + this.version.hashCode()) * 31) + this.deployment.hashCode()) * 31) + Integer.hashCode(this.taskType)) * 31) + Integer.hashCode(this.from)) * 31) + this.buildTime.hashCode()) * 31;
        String str = this.extraStr;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<PTYModelInfo> list = this.models;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "PTYPackageInfo(name=" + this.name + ", version=" + this.version + ", deployment=" + this.deployment + ", taskType=" + this.taskType + ", from=" + this.from + ", buildTime=" + this.buildTime + ", extraStr=" + this.extraStr + ", models=" + this.models + ')';
    }

    public PTYPackageInfo(String str, String str2, String str3, int i, int i2, String str4, String str5, List<PTYModelInfo> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, IPiaCacheProvider.CacheConfig.FIELD_VERSION);
        Intrinsics.checkNotNullParameter(str3, "deployment");
        Intrinsics.checkNotNullParameter(str4, "buildTime");
        this.name = str;
        this.version = str2;
        this.deployment = str3;
        this.taskType = i;
        this.from = i2;
        this.buildTime = str4;
        this.extraStr = str5;
        this.models = list;
        this.extra = LazyKt.lazy(new Function0<JSONObject>() { // from class: com.bytedance.pitaya.api.bean.PTYPackageInfo$extra$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final JSONObject invoke() {
                String extraStr = PTYPackageInfo.this.getExtraStr();
                if (extraStr != null) {
                    return new JSONObject(extraStr);
                }
                return null;
            }
        });
    }

    public final String getDeployment() {
        return this.deployment;
    }

    public final String getName() {
        return this.name;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getBuildTime() {
        return this.buildTime;
    }

    public final String getExtraStr() {
        return this.extraStr;
    }

    public final int getFrom() {
        return this.from;
    }

    public final List<PTYModelInfo> getModels() {
        return this.models;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final JSONObject getExtra() {
        return (JSONObject) this.extra.getValue();
    }
}
