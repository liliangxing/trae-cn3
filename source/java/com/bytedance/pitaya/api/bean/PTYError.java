package com.bytedance.pitaya.api.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: PTYError.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYError;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "domain", "", "code", "", "subCode", ErrorBundle.SUMMARY_ENTRY, "stacks", "", "(Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)V", "getCode", "()I", "getDomain", "()Ljava/lang/String;", "getStacks", "()Ljava/util/List;", "getSubCode", "getSummary", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYError implements ReflectionCall {
    private final int code;
    private final String domain;
    private final List<String> stacks;
    private final int subCode;
    private final String summary;

    public static /* synthetic */ PTYError copy$default(PTYError pTYError, String str, int i, int i2, String str2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pTYError.domain;
        }
        if ((i3 & 2) != 0) {
            i = pTYError.code;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = pTYError.subCode;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            str2 = pTYError.summary;
        }
        String str3 = str2;
        if ((i3 & 16) != 0) {
            list = pTYError.stacks;
        }
        return pTYError.copy(str, i4, i5, str3, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSubCode() {
        return this.subCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    public final List<String> component5() {
        return this.stacks;
    }

    public final PTYError copy(String domain, int code, int subCode, String summary, List<String> stacks) {
        return new PTYError(domain, code, subCode, summary, stacks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PTYError)) {
            return false;
        }
        PTYError pTYError = (PTYError) other;
        return Intrinsics.areEqual(this.domain, pTYError.domain) && this.code == pTYError.code && this.subCode == pTYError.subCode && Intrinsics.areEqual(this.summary, pTYError.summary) && Intrinsics.areEqual(this.stacks, pTYError.stacks);
    }

    public int hashCode() {
        String str = this.domain;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.code)) * 31) + Integer.hashCode(this.subCode)) * 31;
        String str2 = this.summary;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.stacks;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "PTYError(domain=" + this.domain + ", code=" + this.code + ", subCode=" + this.subCode + ", summary=" + this.summary + ", stacks=" + this.stacks + ')';
    }

    public PTYError(String str, int i, int i2, String str2, List<String> list) {
        this.domain = str;
        this.code = i;
        this.subCode = i2;
        this.summary = str2;
        this.stacks = list;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final int getSubCode() {
        return this.subCode;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final List<String> getStacks() {
        return this.stacks;
    }
}
