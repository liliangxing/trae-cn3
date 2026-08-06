package com.bytedance.trae.im.service.tenant;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentSecurityMessageProcessor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;", "", "<init>", "()V", "Passed", "Blocked", "Desensitized", "Error", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Desensitized;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ContentSecurityMessageProcessResult {
    public /* synthetic */ ContentSecurityMessageProcessResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ContentSecurityMessageProcessor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Passed;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Passed extends ContentSecurityMessageProcessResult {
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
            return -1917770019;
        }

        public String toString() {
            return "Passed";
        }

        private Passed() {
            super(null);
        }
    }

    private ContentSecurityMessageProcessResult() {
    }

    /* compiled from: ContentSecurityMessageProcessor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;", "detail", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;", "<init>", "(Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;)V", "getDetail", "()Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Blocked extends ContentSecurityMessageProcessResult {
        private final ContentSecurityFilterResult.Blocked detail;

        public static /* synthetic */ Blocked copy$default(Blocked blocked, ContentSecurityFilterResult.Blocked blocked2, int i, Object obj) {
            if ((i & 1) != 0) {
                blocked2 = blocked.detail;
            }
            return blocked.copy(blocked2);
        }

        /* renamed from: component1, reason: from getter */
        public final ContentSecurityFilterResult.Blocked getDetail() {
            return this.detail;
        }

        public final Blocked copy(ContentSecurityFilterResult.Blocked detail) {
            Intrinsics.checkNotNullParameter(detail, "detail");
            return new Blocked(detail);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Blocked) && Intrinsics.areEqual(this.detail, ((Blocked) other).detail);
        }

        public int hashCode() {
            return this.detail.hashCode();
        }

        public String toString() {
            return "Blocked(detail=" + this.detail + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Blocked(ContentSecurityFilterResult.Blocked detail) {
            super(null);
            Intrinsics.checkNotNullParameter(detail, "detail");
            this.detail = detail;
        }

        public final ContentSecurityFilterResult.Blocked getDetail() {
            return this.detail;
        }
    }

    /* compiled from: ContentSecurityMessageProcessor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Desensitized;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;", "query", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Desensitized extends ContentSecurityMessageProcessResult {
        private final String query;
        private final String text;

        public static /* synthetic */ Desensitized copy$default(Desensitized desensitized, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = desensitized.query;
            }
            if ((i & 2) != 0) {
                str2 = desensitized.text;
            }
            return desensitized.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final Desensitized copy(String query, String text) {
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(text, "text");
            return new Desensitized(query, text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Desensitized)) {
                return false;
            }
            Desensitized desensitized = (Desensitized) other;
            return Intrinsics.areEqual(this.query, desensitized.query) && Intrinsics.areEqual(this.text, desensitized.text);
        }

        public int hashCode() {
            return (this.query.hashCode() * 31) + this.text.hashCode();
        }

        public String toString() {
            return "Desensitized(query=" + this.query + ", text=" + this.text + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Desensitized(String query, String text) {
            super(null);
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(text, "text");
            this.query = query;
            this.text = text;
        }

        public final String getQuery() {
            return this.query;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: ContentSecurityMessageProcessor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Error;", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;", "detail", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;", "<init>", "(Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;)V", "getDetail", "()Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Error extends ContentSecurityMessageProcessResult {
        private final ContentSecurityFilterResult.Error detail;

        public static /* synthetic */ Error copy$default(Error error, ContentSecurityFilterResult.Error error2, int i, Object obj) {
            if ((i & 1) != 0) {
                error2 = error.detail;
            }
            return error.copy(error2);
        }

        /* renamed from: component1, reason: from getter */
        public final ContentSecurityFilterResult.Error getDetail() {
            return this.detail;
        }

        public final Error copy(ContentSecurityFilterResult.Error detail) {
            Intrinsics.checkNotNullParameter(detail, "detail");
            return new Error(detail);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.detail, ((Error) other).detail);
        }

        public int hashCode() {
            return this.detail.hashCode();
        }

        public String toString() {
            return "Error(detail=" + this.detail + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(ContentSecurityFilterResult.Error detail) {
            super(null);
            Intrinsics.checkNotNullParameter(detail, "detail");
            this.detail = detail;
        }

        public final ContentSecurityFilterResult.Error getDetail() {
            return this.detail;
        }
    }
}
