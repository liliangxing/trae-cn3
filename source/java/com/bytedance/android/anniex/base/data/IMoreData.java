package com.bytedance.android.anniex.base.data;

import com.bytedance.android.anniex.base.service.AnnieXUIService;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMoreData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IMoreData;", "", "getEnterFrom", "", "getMorePanelButtons", "", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$MorePanelButton;", "getSessionId", "getUrl", "MoreDataBuilder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IMoreData {
    String getEnterFrom();

    List<AnnieXUIService.MorePanelButton> getMorePanelButtons();

    String getSessionId();

    String getUrl();

    /* compiled from: IMoreData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IMoreData$MoreDataBuilder;", "", "()V", "moreData", "Lcom/bytedance/android/anniex/base/data/IMoreData$MoreDataBuilder$MoreData;", "build", "Lcom/bytedance/android/anniex/base/data/IMoreData;", "setEnterFrom", "enterFrom", "", "setMorePanelButtons", "panelButtons", "", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$MorePanelButton;", "setSessionId", "sessionId", "setUrl", StreamTrafficObservable.STREAM_URL, "MoreData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class MoreDataBuilder {
        private final MoreData moreData = new MoreData(null, null, null, null, 15, null);

        /* compiled from: IMoreData.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IMoreData$MoreDataBuilder$MoreData;", "Lcom/bytedance/android/anniex/base/data/IMoreData;", "currentUrl", "", "moreEnterFrom", "currentSessionId", "panelButtons", "", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$MorePanelButton;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCurrentSessionId", "()Ljava/lang/String;", "setCurrentSessionId", "(Ljava/lang/String;)V", "getCurrentUrl", "setCurrentUrl", "getMoreEnterFrom", "setMoreEnterFrom", "getPanelButtons", "()Ljava/util/List;", "setPanelButtons", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getEnterFrom", "getMorePanelButtons", "getSessionId", "getUrl", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
        private static final /* data */ class MoreData implements IMoreData {
            private String currentSessionId;
            private String currentUrl;
            private String moreEnterFrom;
            private List<AnnieXUIService.MorePanelButton> panelButtons;

            public MoreData() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MoreData copy$default(MoreData moreData, String str, String str2, String str3, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = moreData.currentUrl;
                }
                if ((i & 2) != 0) {
                    str2 = moreData.moreEnterFrom;
                }
                if ((i & 4) != 0) {
                    str3 = moreData.currentSessionId;
                }
                if ((i & 8) != 0) {
                    list = moreData.panelButtons;
                }
                return moreData.copy(str, str2, str3, list);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCurrentUrl() {
                return this.currentUrl;
            }

            /* renamed from: component2, reason: from getter */
            public final String getMoreEnterFrom() {
                return this.moreEnterFrom;
            }

            /* renamed from: component3, reason: from getter */
            public final String getCurrentSessionId() {
                return this.currentSessionId;
            }

            public final List<AnnieXUIService.MorePanelButton> component4() {
                return this.panelButtons;
            }

            public final MoreData copy(String currentUrl, String moreEnterFrom, String currentSessionId, List<AnnieXUIService.MorePanelButton> panelButtons) {
                return new MoreData(currentUrl, moreEnterFrom, currentSessionId, panelButtons);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MoreData)) {
                    return false;
                }
                MoreData moreData = (MoreData) other;
                return Intrinsics.areEqual(this.currentUrl, moreData.currentUrl) && Intrinsics.areEqual(this.moreEnterFrom, moreData.moreEnterFrom) && Intrinsics.areEqual(this.currentSessionId, moreData.currentSessionId) && Intrinsics.areEqual(this.panelButtons, moreData.panelButtons);
            }

            public int hashCode() {
                String str = this.currentUrl;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.moreEnterFrom;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.currentSessionId;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                List<AnnieXUIService.MorePanelButton> list = this.panelButtons;
                return hashCode3 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                return "MoreData(currentUrl=" + this.currentUrl + ", moreEnterFrom=" + this.moreEnterFrom + ", currentSessionId=" + this.currentSessionId + ", panelButtons=" + this.panelButtons + ')';
            }

            public MoreData(String str, String str2, String str3, List<AnnieXUIService.MorePanelButton> list) {
                this.currentUrl = str;
                this.moreEnterFrom = str2;
                this.currentSessionId = str3;
                this.panelButtons = list;
            }

            public /* synthetic */ MoreData(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list);
            }

            public final String getCurrentUrl() {
                return this.currentUrl;
            }

            public final void setCurrentUrl(String str) {
                this.currentUrl = str;
            }

            public final String getMoreEnterFrom() {
                return this.moreEnterFrom;
            }

            public final void setMoreEnterFrom(String str) {
                this.moreEnterFrom = str;
            }

            public final String getCurrentSessionId() {
                return this.currentSessionId;
            }

            public final void setCurrentSessionId(String str) {
                this.currentSessionId = str;
            }

            public final List<AnnieXUIService.MorePanelButton> getPanelButtons() {
                return this.panelButtons;
            }

            public final void setPanelButtons(List<AnnieXUIService.MorePanelButton> list) {
                this.panelButtons = list;
            }

            @Override // com.bytedance.android.anniex.base.data.IMoreData
            public String getUrl() {
                return this.currentUrl;
            }

            @Override // com.bytedance.android.anniex.base.data.IMoreData
            public String getEnterFrom() {
                return this.moreEnterFrom;
            }

            @Override // com.bytedance.android.anniex.base.data.IMoreData
            public String getSessionId() {
                return this.currentSessionId;
            }

            @Override // com.bytedance.android.anniex.base.data.IMoreData
            public List<AnnieXUIService.MorePanelButton> getMorePanelButtons() {
                return this.panelButtons;
            }
        }

        public final MoreDataBuilder setUrl(String url) {
            Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
            this.moreData.setCurrentUrl(url);
            return this;
        }

        public final MoreDataBuilder setEnterFrom(String enterFrom) {
            Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
            this.moreData.setMoreEnterFrom(enterFrom);
            return this;
        }

        public final MoreDataBuilder setSessionId(String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            this.moreData.setCurrentSessionId(sessionId);
            return this;
        }

        public final MoreDataBuilder setMorePanelButtons(List<AnnieXUIService.MorePanelButton> panelButtons) {
            Intrinsics.checkNotNullParameter(panelButtons, "panelButtons");
            this.moreData.setPanelButtons(panelButtons);
            return this;
        }

        public final IMoreData build() {
            return this.moreData;
        }
    }
}
