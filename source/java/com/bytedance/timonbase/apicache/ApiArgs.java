package com.bytedance.timonbase.apicache;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.mt.protector.ThrowableDisposer;
import com.vivo.push.PushClientConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0018\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\\\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001d\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/timonbase/apicache/ApiArgs;", "", "id", "", PushClientConstants.TAG_CLASS_NAME, "", "memberName", "thisOrClass", "parameters", "", ThrowableDisposer.ConfItem.RETURN_TYPE, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "getId", "()I", "getMemberName", "getParameters", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getReturnType", "getThisOrClass", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;)Lcom/bytedance/timonbase/apicache/ApiArgs;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class ApiArgs {
    private final String className;
    private final int id;
    private final String memberName;
    private final Object[] parameters;
    private final String returnType;
    private final Object thisOrClass;

    public static /* synthetic */ ApiArgs copy$default(ApiArgs apiArgs, int i, String str, String str2, Object obj, Object[] objArr, String str3, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = apiArgs.id;
        }
        if ((i2 & 2) != 0) {
            str = apiArgs.className;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = apiArgs.memberName;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            obj = apiArgs.thisOrClass;
        }
        Object obj3 = obj;
        if ((i2 & 16) != 0) {
            objArr = apiArgs.parameters;
        }
        Object[] objArr2 = objArr;
        if ((i2 & 32) != 0) {
            str3 = apiArgs.returnType;
        }
        return apiArgs.copy(i, str4, str5, obj3, objArr2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMemberName() {
        return this.memberName;
    }

    /* renamed from: component4, reason: from getter */
    public final Object getThisOrClass() {
        return this.thisOrClass;
    }

    /* renamed from: component5, reason: from getter */
    public final Object[] getParameters() {
        return this.parameters;
    }

    /* renamed from: component6, reason: from getter */
    public final String getReturnType() {
        return this.returnType;
    }

    public final ApiArgs copy(int id, String className, String memberName, Object thisOrClass, Object[] parameters, String returnType) {
        return new ApiArgs(id, className, memberName, thisOrClass, parameters, returnType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiArgs)) {
            return false;
        }
        ApiArgs apiArgs = (ApiArgs) other;
        return this.id == apiArgs.id && Intrinsics.areEqual(this.className, apiArgs.className) && Intrinsics.areEqual(this.memberName, apiArgs.memberName) && Intrinsics.areEqual(this.thisOrClass, apiArgs.thisOrClass) && Intrinsics.areEqual(this.parameters, apiArgs.parameters) && Intrinsics.areEqual(this.returnType, apiArgs.returnType);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        String str = this.className;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.memberName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj = this.thisOrClass;
        int hashCode4 = (hashCode3 + (obj != null ? obj.hashCode() : 0)) * 31;
        Object[] objArr = this.parameters;
        int hashCode5 = (hashCode4 + (objArr != null ? Arrays.hashCode(objArr) : 0)) * 31;
        String str3 = this.returnType;
        return hashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ApiArgs(id=" + this.id + ", className=" + this.className + ", memberName=" + this.memberName + ", thisOrClass=" + this.thisOrClass + ", parameters=" + Arrays.toString(this.parameters) + ", returnType=" + this.returnType + ")";
    }

    public ApiArgs(int i, String str, String str2, Object obj, Object[] objArr, String str3) {
        this.id = i;
        this.className = str;
        this.memberName = str2;
        this.thisOrClass = obj;
        this.parameters = objArr;
        this.returnType = str3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getMemberName() {
        return this.memberName;
    }

    public final Object getThisOrClass() {
        return this.thisOrClass;
    }

    public final Object[] getParameters() {
        return this.parameters;
    }

    public final String getReturnType() {
        return this.returnType;
    }
}
