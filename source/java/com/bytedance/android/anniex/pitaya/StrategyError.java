package com.bytedance.android.anniex.pitaya;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage;
import com.ttnet.org.chromium.net.NetError;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: StrategyError.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/android/anniex/pitaya/StrategyError;", "", "domain", "", "code", "", "subCode", ErrorBundle.SUMMARY_ENTRY, "stacks", "", "(Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)V", "getCode", "()I", "getDomain", "()Ljava/lang/String;", "getStacks", "()Ljava/util/List;", "getSubCode", "getSummary", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "Domain", "ErrorCode", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class StrategyError {
    private final int code;
    private final String domain;
    private final List<String> stacks;
    private final int subCode;
    private final String summary;

    public static /* synthetic */ StrategyError copy$default(StrategyError strategyError, String str, int i, int i2, String str2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = strategyError.domain;
        }
        if ((i3 & 2) != 0) {
            i = strategyError.code;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = strategyError.subCode;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            str2 = strategyError.summary;
        }
        String str3 = str2;
        if ((i3 & 16) != 0) {
            list = strategyError.stacks;
        }
        return strategyError.copy(str, i4, i5, str3, list);
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

    public final StrategyError copy(String domain, int code, int subCode, String summary, List<String> stacks) {
        return new StrategyError(domain, code, subCode, summary, stacks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StrategyError)) {
            return false;
        }
        StrategyError strategyError = (StrategyError) other;
        return Intrinsics.areEqual(this.domain, strategyError.domain) && this.code == strategyError.code && this.subCode == strategyError.subCode && Intrinsics.areEqual(this.summary, strategyError.summary) && Intrinsics.areEqual(this.stacks, strategyError.stacks);
    }

    public int hashCode() {
        String str = this.domain;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.code)) * 31) + Integer.hashCode(this.subCode)) * 31;
        String str2 = this.summary;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.stacks;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public StrategyError(String str, int i, int i2, String str2, List<String> list) {
        this.domain = str;
        this.code = i;
        this.subCode = i2;
        this.summary = str2;
        this.stacks = list;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final int getCode() {
        return this.code;
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

    /* compiled from: StrategyError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/pitaya/StrategyError$Domain;", "", "domain", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDomain", "()Ljava/lang/String;", "BDP", "SERVER", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public enum Domain {
        BDP("bdp"),
        SERVER(SubTaskRequestMessage.EXECUTOR_SERVER);

        private final String domain;

        Domain(String str) {
            this.domain = str;
        }

        public final String getDomain() {
            return this.domain;
        }
    }

    /* compiled from: StrategyError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/pitaya/StrategyError$ErrorCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "STRATEGY_DISABLE", "STRATEGY_UNKNOWN", "UNKNOWN_EXCEPTION", "METHOD_NOT_IMPLEMENTED", "POLICY_NOT_READY", "POLICY_NULL", "DETECTED_TEXT_BLANK", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public enum ErrorCode {
        STRATEGY_DISABLE(-100),
        STRATEGY_UNKNOWN(-101),
        UNKNOWN_EXCEPTION(NetError.ERR_SSL_CLIENT_AUTH_CERT_NEEDED),
        METHOD_NOT_IMPLEMENTED(NetError.ERR_TUNNEL_CONNECTION_FAILED),
        POLICY_NOT_READY(NetError.ERR_NO_SSL_VERSIONS_ENABLED),
        POLICY_NULL(NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH),
        DETECTED_TEXT_BLANK(NetError.ERR_SSL_RENEGOTIATION_REQUESTED);

        private final int code;

        ErrorCode(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }
    }

    public String toString() {
        return "StrategyError(domain=" + this.domain + ", code=" + this.code + ", subCode=" + this.subCode + ", summary=" + this.summary + ", stacks=" + this.stacks + ')';
    }
}
