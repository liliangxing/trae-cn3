package com.bytedance.trae.im.service.tenant;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentSecurityFilter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;", "", "<init>", "()V", "Passed", "Blocked", "Desensitized", "Error", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Passed;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ContentSecurityFilterResult {
    public /* synthetic */ ContentSecurityFilterResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ContentSecurityFilter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Passed;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Passed extends ContentSecurityFilterResult {
        public static final Passed INSTANCE = new Passed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Passed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1132271155;
        }

        public String toString() {
            return "Passed";
        }

        private Passed() {
            super(null);
        }
    }

    private ContentSecurityFilterResult() {
    }

    /* compiled from: ContentSecurityFilter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;", "ruleName", "", "ruleDetailName", "matchedContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRuleName", "()Ljava/lang/String;", "getRuleDetailName", "getMatchedContent", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Blocked extends ContentSecurityFilterResult {
        private final String matchedContent;
        private final String ruleDetailName;
        private final String ruleName;

        public static /* synthetic */ Blocked copy$default(Blocked blocked, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = blocked.ruleName;
            }
            if ((i & 2) != 0) {
                str2 = blocked.ruleDetailName;
            }
            if ((i & 4) != 0) {
                str3 = blocked.matchedContent;
            }
            return blocked.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getRuleName() {
            return this.ruleName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getRuleDetailName() {
            return this.ruleDetailName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMatchedContent() {
            return this.matchedContent;
        }

        public final Blocked copy(String ruleName, String ruleDetailName, String matchedContent) {
            Intrinsics.checkNotNullParameter(ruleName, "ruleName");
            Intrinsics.checkNotNullParameter(ruleDetailName, "ruleDetailName");
            Intrinsics.checkNotNullParameter(matchedContent, "matchedContent");
            return new Blocked(ruleName, ruleDetailName, matchedContent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Blocked)) {
                return false;
            }
            Blocked blocked = (Blocked) other;
            return Intrinsics.areEqual(this.ruleName, blocked.ruleName) && Intrinsics.areEqual(this.ruleDetailName, blocked.ruleDetailName) && Intrinsics.areEqual(this.matchedContent, blocked.matchedContent);
        }

        public int hashCode() {
            return (((this.ruleName.hashCode() * 31) + this.ruleDetailName.hashCode()) * 31) + this.matchedContent.hashCode();
        }

        public String toString() {
            return "Blocked(ruleName=" + this.ruleName + ", ruleDetailName=" + this.ruleDetailName + ", matchedContent=" + this.matchedContent + ')';
        }

        public final String getRuleName() {
            return this.ruleName;
        }

        public final String getRuleDetailName() {
            return this.ruleDetailName;
        }

        public final String getMatchedContent() {
            return this.matchedContent;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Blocked(String ruleName, String ruleDetailName, String matchedContent) {
            super(null);
            Intrinsics.checkNotNullParameter(ruleName, "ruleName");
            Intrinsics.checkNotNullParameter(ruleDetailName, "ruleDetailName");
            Intrinsics.checkNotNullParameter(matchedContent, "matchedContent");
            this.ruleName = ruleName;
            this.ruleDetailName = ruleDetailName;
            this.matchedContent = matchedContent;
        }
    }

    /* compiled from: ContentSecurityFilter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;", "ruleName", "", "processedContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRuleName", "()Ljava/lang/String;", "getProcessedContent", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Desensitized extends ContentSecurityFilterResult {
        private final String processedContent;
        private final String ruleName;

        public static /* synthetic */ Desensitized copy$default(Desensitized desensitized, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = desensitized.ruleName;
            }
            if ((i & 2) != 0) {
                str2 = desensitized.processedContent;
            }
            return desensitized.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getRuleName() {
            return this.ruleName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getProcessedContent() {
            return this.processedContent;
        }

        public final Desensitized copy(String ruleName, String processedContent) {
            Intrinsics.checkNotNullParameter(ruleName, "ruleName");
            Intrinsics.checkNotNullParameter(processedContent, "processedContent");
            return new Desensitized(ruleName, processedContent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Desensitized)) {
                return false;
            }
            Desensitized desensitized = (Desensitized) other;
            return Intrinsics.areEqual(this.ruleName, desensitized.ruleName) && Intrinsics.areEqual(this.processedContent, desensitized.processedContent);
        }

        public int hashCode() {
            return (this.ruleName.hashCode() * 31) + this.processedContent.hashCode();
        }

        public String toString() {
            return "Desensitized(ruleName=" + this.ruleName + ", processedContent=" + this.processedContent + ')';
        }

        public final String getRuleName() {
            return this.ruleName;
        }

        public final String getProcessedContent() {
            return this.processedContent;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Desensitized(String ruleName, String processedContent) {
            super(null);
            Intrinsics.checkNotNullParameter(ruleName, "ruleName");
            Intrinsics.checkNotNullParameter(processedContent, "processedContent");
            this.ruleName = ruleName;
            this.processedContent = processedContent;
        }
    }

    /* compiled from: ContentSecurityFilter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;", "ruleName", "", "ruleDetailName", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRuleName", "()Ljava/lang/String;", "getRuleDetailName", "getMessage", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Error extends ContentSecurityFilterResult {
        private final String message;
        private final String ruleDetailName;
        private final String ruleName;

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.ruleName;
            }
            if ((i & 2) != 0) {
                str2 = error.ruleDetailName;
            }
            if ((i & 4) != 0) {
                str3 = error.message;
            }
            return error.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getRuleName() {
            return this.ruleName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getRuleDetailName() {
            return this.ruleDetailName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(String ruleName, String ruleDetailName, String message) {
            Intrinsics.checkNotNullParameter(ruleName, "ruleName");
            Intrinsics.checkNotNullParameter(ruleDetailName, "ruleDetailName");
            Intrinsics.checkNotNullParameter(message, "message");
            return new Error(ruleName, ruleDetailName, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.ruleName, error.ruleName) && Intrinsics.areEqual(this.ruleDetailName, error.ruleDetailName) && Intrinsics.areEqual(this.message, error.message);
        }

        public int hashCode() {
            return (((this.ruleName.hashCode() * 31) + this.ruleDetailName.hashCode()) * 31) + this.message.hashCode();
        }

        public String toString() {
            return "Error(ruleName=" + this.ruleName + ", ruleDetailName=" + this.ruleDetailName + ", message=" + this.message + ')';
        }

        public final String getRuleName() {
            return this.ruleName;
        }

        public final String getRuleDetailName() {
            return this.ruleDetailName;
        }

        public final String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String ruleName, String ruleDetailName, String message) {
            super(null);
            Intrinsics.checkNotNullParameter(ruleName, "ruleName");
            Intrinsics.checkNotNullParameter(ruleDetailName, "ruleDetailName");
            Intrinsics.checkNotNullParameter(message, "message");
            this.ruleName = ruleName;
            this.ruleDetailName = ruleDetailName;
            this.message = message;
        }
    }
}
