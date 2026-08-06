package com.bytedance.android.anniex.base.data;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IReportData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\tJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IReportData;", "", "getContainerTraceId", "", "getScene", "getSessionId", "getText", "getUrl", "getViewTraceId", "ReportDataBuilder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IReportData {
    String getContainerTraceId();

    String getScene();

    String getSessionId();

    String getText();

    String getUrl();

    String getViewTraceId();

    /* compiled from: IReportData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IReportData$ReportDataBuilder;", "", "()V", "reportData", "Lcom/bytedance/android/anniex/base/data/IReportData$ReportDataBuilder$ReportData;", "build", "Lcom/bytedance/android/anniex/base/data/IReportData;", "setContainerTraceId", "traceId", "", "setScene", "scene", "setSessionId", "sessionId", "setText", "text", "setUrl", "url", "setViewTraceId", "ReportData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ReportDataBuilder {
        private final ReportData reportData = new ReportData(null, null, null, null, null, null, 63, null);

        /* compiled from: IReportData.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\n\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006,"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IReportData$ReportDataBuilder$ReportData;", "Lcom/bytedance/android/anniex/base/data/IReportData;", "containerId", "", "currentUrl", "reportText", "traceIdForContainer", "traceIdForView", "secLinkScene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContainerId", "()Ljava/lang/String;", "setContainerId", "(Ljava/lang/String;)V", "getCurrentUrl", "setCurrentUrl", "getReportText", "setReportText", "getSecLinkScene", "setSecLinkScene", "getTraceIdForContainer", "setTraceIdForContainer", "getTraceIdForView", "setTraceIdForView", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "getContainerTraceId", "getScene", "getSessionId", "getText", "getUrl", "getViewTraceId", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes2.dex */
        private static final /* data */ class ReportData implements IReportData {
            private String containerId;
            private String currentUrl;
            private String reportText;
            private String secLinkScene;
            private String traceIdForContainer;
            private String traceIdForView;

            public ReportData() {
                this(null, null, null, null, null, null, 63, null);
            }

            public static /* synthetic */ ReportData copy$default(ReportData reportData, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = reportData.containerId;
                }
                if ((i & 2) != 0) {
                    str2 = reportData.currentUrl;
                }
                String str7 = str2;
                if ((i & 4) != 0) {
                    str3 = reportData.reportText;
                }
                String str8 = str3;
                if ((i & 8) != 0) {
                    str4 = reportData.traceIdForContainer;
                }
                String str9 = str4;
                if ((i & 16) != 0) {
                    str5 = reportData.traceIdForView;
                }
                String str10 = str5;
                if ((i & 32) != 0) {
                    str6 = reportData.secLinkScene;
                }
                return reportData.copy(str, str7, str8, str9, str10, str6);
            }

            /* renamed from: component1, reason: from getter */
            public final String getContainerId() {
                return this.containerId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getCurrentUrl() {
                return this.currentUrl;
            }

            /* renamed from: component3, reason: from getter */
            public final String getReportText() {
                return this.reportText;
            }

            /* renamed from: component4, reason: from getter */
            public final String getTraceIdForContainer() {
                return this.traceIdForContainer;
            }

            /* renamed from: component5, reason: from getter */
            public final String getTraceIdForView() {
                return this.traceIdForView;
            }

            /* renamed from: component6, reason: from getter */
            public final String getSecLinkScene() {
                return this.secLinkScene;
            }

            public final ReportData copy(String containerId, String currentUrl, String reportText, String traceIdForContainer, String traceIdForView, String secLinkScene) {
                return new ReportData(containerId, currentUrl, reportText, traceIdForContainer, traceIdForView, secLinkScene);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReportData)) {
                    return false;
                }
                ReportData reportData = (ReportData) other;
                return Intrinsics.areEqual(this.containerId, reportData.containerId) && Intrinsics.areEqual(this.currentUrl, reportData.currentUrl) && Intrinsics.areEqual(this.reportText, reportData.reportText) && Intrinsics.areEqual(this.traceIdForContainer, reportData.traceIdForContainer) && Intrinsics.areEqual(this.traceIdForView, reportData.traceIdForView) && Intrinsics.areEqual(this.secLinkScene, reportData.secLinkScene);
            }

            public int hashCode() {
                String str = this.containerId;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.currentUrl;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.reportText;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.traceIdForContainer;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.traceIdForView;
                int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.secLinkScene;
                return hashCode5 + (str6 != null ? str6.hashCode() : 0);
            }

            public String toString() {
                return "ReportData(containerId=" + this.containerId + ", currentUrl=" + this.currentUrl + ", reportText=" + this.reportText + ", traceIdForContainer=" + this.traceIdForContainer + ", traceIdForView=" + this.traceIdForView + ", secLinkScene=" + this.secLinkScene + ')';
            }

            public ReportData(String str, String str2, String str3, String str4, String str5, String str6) {
                this.containerId = str;
                this.currentUrl = str2;
                this.reportText = str3;
                this.traceIdForContainer = str4;
                this.traceIdForView = str5;
                this.secLinkScene = str6;
            }

            public /* synthetic */ ReportData(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
            }

            public final String getContainerId() {
                return this.containerId;
            }

            public final void setContainerId(String str) {
                this.containerId = str;
            }

            public final String getCurrentUrl() {
                return this.currentUrl;
            }

            public final void setCurrentUrl(String str) {
                this.currentUrl = str;
            }

            public final String getReportText() {
                return this.reportText;
            }

            public final void setReportText(String str) {
                this.reportText = str;
            }

            public final String getTraceIdForContainer() {
                return this.traceIdForContainer;
            }

            public final void setTraceIdForContainer(String str) {
                this.traceIdForContainer = str;
            }

            public final String getTraceIdForView() {
                return this.traceIdForView;
            }

            public final void setTraceIdForView(String str) {
                this.traceIdForView = str;
            }

            public final String getSecLinkScene() {
                return this.secLinkScene;
            }

            public final void setSecLinkScene(String str) {
                this.secLinkScene = str;
            }

            @Override // com.bytedance.android.anniex.base.data.IReportData
            public String getText() {
                return this.reportText;
            }

            @Override // com.bytedance.android.anniex.base.data.IReportData
            public String getUrl() {
                return this.currentUrl;
            }

            @Override // com.bytedance.android.anniex.base.data.IReportData
            public String getContainerTraceId() {
                return this.traceIdForContainer;
            }

            @Override // com.bytedance.android.anniex.base.data.IReportData
            public String getViewTraceId() {
                return this.traceIdForView;
            }

            @Override // com.bytedance.android.anniex.base.data.IReportData
            public String getScene() {
                return this.secLinkScene;
            }

            @Override // com.bytedance.android.anniex.base.data.IReportData
            public String getSessionId() {
                return this.containerId;
            }
        }

        public final ReportDataBuilder setText(String text) {
            this.reportData.setReportText(text);
            return this;
        }

        public final ReportDataBuilder setUrl(String url) {
            this.reportData.setCurrentUrl(url);
            return this;
        }

        public final ReportDataBuilder setContainerTraceId(String traceId) {
            this.reportData.setTraceIdForContainer(traceId);
            return this;
        }

        public final ReportDataBuilder setViewTraceId(String traceId) {
            this.reportData.setTraceIdForView(traceId);
            return this;
        }

        public final ReportDataBuilder setScene(String scene) {
            this.reportData.setSecLinkScene(scene);
            return this;
        }

        public final ReportDataBuilder setSessionId(String sessionId) {
            this.reportData.setContainerId(sessionId);
            return this;
        }

        public final IReportData build() {
            return this.reportData;
        }
    }
}
