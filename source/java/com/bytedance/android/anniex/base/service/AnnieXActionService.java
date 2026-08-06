package com.bytedance.android.anniex.base.service;

import android.content.Context;
import android.view.Menu;
import android.view.View;
import com.bytedance.android.anniex.base.data.ICopyData;
import com.bytedance.android.anniex.base.data.IDownloadData;
import com.bytedance.android.anniex.base.data.IMoreData;
import com.bytedance.android.anniex.base.data.IReportData;
import com.bytedance.android.anniex.base.data.ISaveImageData;
import com.bytedance.android.anniex.base.data.ISearchData;
import com.bytedance.ies.bullet.core.container.IActionModeProvider;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXActionService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXActionService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "()V", "copy", "", "context", "Landroid/content/Context;", "copyData", "Lcom/bytedance/android/anniex/base/data/ICopyData;", "download", "downloadData", "Lcom/bytedance/android/anniex/base/data/IDownloadData;", "more", "moreData", "Lcom/bytedance/android/anniex/base/data/IMoreData;", "provideLongClickListener", "Landroid/view/View$OnLongClickListener;", "config", "Lcom/bytedance/android/anniex/base/service/AnnieXActionService$LongClickConfig;", "provideSelectMenuItemList", "", "Lcom/bytedance/ies/bullet/core/container/IActionModeProvider$CustomSelectMenuItem;", "menu", "Landroid/view/Menu;", "Lcom/bytedance/android/anniex/base/service/AnnieXActionService$SelectMenuConfig;", "report", "reportData", "Lcom/bytedance/android/anniex/base/data/IReportData;", "saveImage", "saveImageData", "Lcom/bytedance/android/anniex/base/data/ISaveImageData;", "search", "searchData", "Lcom/bytedance/android/anniex/base/data/ISearchData;", "LongClickConfig", "SelectMenuConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class AnnieXActionService extends BaseBulletService {
    public void copy(Context context, ICopyData copyData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(copyData, "copyData");
        AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(AnnieXActionService.class);
        if (annieXActionService != null) {
            annieXActionService.copy(context, copyData);
        }
    }

    public void download(Context context, IDownloadData downloadData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(downloadData, "downloadData");
        AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(AnnieXActionService.class);
        if (annieXActionService != null) {
            annieXActionService.download(context, downloadData);
        }
    }

    public void more(Context context, IMoreData moreData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moreData, "moreData");
        AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(AnnieXActionService.class);
        if (annieXActionService != null) {
            annieXActionService.more(context, moreData);
        }
    }

    public void report(Context context, IReportData reportData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(AnnieXActionService.class);
        if (annieXActionService != null) {
            annieXActionService.report(context, reportData);
        }
    }

    public void search(Context context, ISearchData searchData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(searchData, "searchData");
        AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(AnnieXActionService.class);
        if (annieXActionService != null) {
            annieXActionService.search(context, searchData);
        }
    }

    public void saveImage(Context context, ISaveImageData saveImageData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(saveImageData, "saveImageData");
        AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(AnnieXActionService.class);
        if (annieXActionService != null) {
            annieXActionService.saveImage(context, saveImageData);
        }
    }

    /* compiled from: AnnieXActionService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXActionService$SelectMenuConfig;", "", "sessionId", "", "enableSearch", "", "enterFrom", "enterMethod", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getEnableSearch", "()Z", "getEnterFrom", "()Ljava/lang/String;", "getEnterMethod", "getSessionId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final /* data */ class SelectMenuConfig {
        private final boolean enableSearch;
        private final String enterFrom;
        private final String enterMethod;
        private final String sessionId;

        public static /* synthetic */ SelectMenuConfig copy$default(SelectMenuConfig selectMenuConfig, String str, boolean z, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = selectMenuConfig.sessionId;
            }
            if ((i & 2) != 0) {
                z = selectMenuConfig.enableSearch;
            }
            if ((i & 4) != 0) {
                str2 = selectMenuConfig.enterFrom;
            }
            if ((i & 8) != 0) {
                str3 = selectMenuConfig.enterMethod;
            }
            return selectMenuConfig.copy(str, z, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getEnableSearch() {
            return this.enableSearch;
        }

        /* renamed from: component3, reason: from getter */
        public final String getEnterFrom() {
            return this.enterFrom;
        }

        /* renamed from: component4, reason: from getter */
        public final String getEnterMethod() {
            return this.enterMethod;
        }

        public final SelectMenuConfig copy(String sessionId, boolean enableSearch, String enterFrom, String enterMethod) {
            return new SelectMenuConfig(sessionId, enableSearch, enterFrom, enterMethod);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectMenuConfig)) {
                return false;
            }
            SelectMenuConfig selectMenuConfig = (SelectMenuConfig) other;
            return Intrinsics.areEqual(this.sessionId, selectMenuConfig.sessionId) && this.enableSearch == selectMenuConfig.enableSearch && Intrinsics.areEqual(this.enterFrom, selectMenuConfig.enterFrom) && Intrinsics.areEqual(this.enterMethod, selectMenuConfig.enterMethod);
        }

        public int hashCode() {
            String str = this.sessionId;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.enableSearch)) * 31;
            String str2 = this.enterFrom;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.enterMethod;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "SelectMenuConfig(sessionId=" + this.sessionId + ", enableSearch=" + this.enableSearch + ", enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ')';
        }

        public SelectMenuConfig(String str, boolean z, String str2, String str3) {
            this.sessionId = str;
            this.enableSearch = z;
            this.enterFrom = str2;
            this.enterMethod = str3;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final boolean getEnableSearch() {
            return this.enableSearch;
        }

        public final String getEnterFrom() {
            return this.enterFrom;
        }

        public final String getEnterMethod() {
            return this.enterMethod;
        }
    }

    public List<IActionModeProvider.CustomSelectMenuItem> provideSelectMenuItemList(Context context, Menu menu, SelectMenuConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(config, "config");
        AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(AnnieXActionService.class);
        if (annieXActionService != null) {
            return annieXActionService.provideSelectMenuItemList(context, menu, config);
        }
        return null;
    }

    /* compiled from: AnnieXActionService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXActionService$LongClickConfig;", "", "sessionId", "", "disableSaveImage", "", "enterFrom", "enterMethod", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getDisableSaveImage", "()Z", "getEnterFrom", "()Ljava/lang/String;", "getEnterMethod", "getSessionId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final /* data */ class LongClickConfig {
        private final boolean disableSaveImage;
        private final String enterFrom;
        private final String enterMethod;
        private final String sessionId;

        public static /* synthetic */ LongClickConfig copy$default(LongClickConfig longClickConfig, String str, boolean z, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = longClickConfig.sessionId;
            }
            if ((i & 2) != 0) {
                z = longClickConfig.disableSaveImage;
            }
            if ((i & 4) != 0) {
                str2 = longClickConfig.enterFrom;
            }
            if ((i & 8) != 0) {
                str3 = longClickConfig.enterMethod;
            }
            return longClickConfig.copy(str, z, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getDisableSaveImage() {
            return this.disableSaveImage;
        }

        /* renamed from: component3, reason: from getter */
        public final String getEnterFrom() {
            return this.enterFrom;
        }

        /* renamed from: component4, reason: from getter */
        public final String getEnterMethod() {
            return this.enterMethod;
        }

        public final LongClickConfig copy(String sessionId, boolean disableSaveImage, String enterFrom, String enterMethod) {
            return new LongClickConfig(sessionId, disableSaveImage, enterFrom, enterMethod);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LongClickConfig)) {
                return false;
            }
            LongClickConfig longClickConfig = (LongClickConfig) other;
            return Intrinsics.areEqual(this.sessionId, longClickConfig.sessionId) && this.disableSaveImage == longClickConfig.disableSaveImage && Intrinsics.areEqual(this.enterFrom, longClickConfig.enterFrom) && Intrinsics.areEqual(this.enterMethod, longClickConfig.enterMethod);
        }

        public int hashCode() {
            String str = this.sessionId;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.disableSaveImage)) * 31;
            String str2 = this.enterFrom;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.enterMethod;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "LongClickConfig(sessionId=" + this.sessionId + ", disableSaveImage=" + this.disableSaveImage + ", enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ')';
        }

        public LongClickConfig(String str, boolean z, String str2, String str3) {
            this.sessionId = str;
            this.disableSaveImage = z;
            this.enterFrom = str2;
            this.enterMethod = str3;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final boolean getDisableSaveImage() {
            return this.disableSaveImage;
        }

        public final String getEnterFrom() {
            return this.enterFrom;
        }

        public final String getEnterMethod() {
            return this.enterMethod;
        }
    }

    public View.OnLongClickListener provideLongClickListener(Context context, LongClickConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(AnnieXActionService.class);
        if (annieXActionService != null) {
            return annieXActionService.provideLongClickListener(context, config);
        }
        return null;
    }
}
