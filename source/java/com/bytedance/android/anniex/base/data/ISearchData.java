package com.bytedance.android.anniex.base.data;

import android.graphics.Bitmap;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISearchData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/base/data/ISearchData;", "", "getBitmap", "Landroid/graphics/Bitmap;", "getEnterFrom", "", "getEnterMethod", "getText", "SearchDataBuilder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface ISearchData {
    Bitmap getBitmap();

    String getEnterFrom();

    String getEnterMethod();

    String getText();

    /* compiled from: ISearchData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/base/data/ISearchData$SearchDataBuilder;", "", "()V", "searchData", "Lcom/bytedance/android/anniex/base/data/ISearchData$SearchDataBuilder$SearchData;", "build", "Lcom/bytedance/android/anniex/base/data/ISearchData;", "setBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setEnterFrom", "enterFrom", "", "setEnterMethod", "enterMethod", "setText", "text", "SearchData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class SearchDataBuilder {
        private final SearchData searchData = new SearchData(null, null, null, null, 15, null);

        /* compiled from: ISearchData.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006%"}, d2 = {"Lcom/bytedance/android/anniex/base/data/ISearchData$SearchDataBuilder$SearchData;", "Lcom/bytedance/android/anniex/base/data/ISearchData;", "searchText", "", "searchBitmap", "Landroid/graphics/Bitmap;", "containerEnterFrom", "containerEnterMethod", "(Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)V", "getContainerEnterFrom", "()Ljava/lang/String;", "setContainerEnterFrom", "(Ljava/lang/String;)V", "getContainerEnterMethod", "setContainerEnterMethod", "getSearchBitmap", "()Landroid/graphics/Bitmap;", "setSearchBitmap", "(Landroid/graphics/Bitmap;)V", "getSearchText", "setSearchText", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "getBitmap", "getEnterFrom", "getEnterMethod", "getText", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes2.dex */
        private static final /* data */ class SearchData implements ISearchData {
            private String containerEnterFrom;
            private String containerEnterMethod;
            private Bitmap searchBitmap;
            private String searchText;

            public SearchData() {
                this(null, null, null, null, 15, null);
            }

            public static /* synthetic */ SearchData copy$default(SearchData searchData, String str, Bitmap bitmap, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = searchData.searchText;
                }
                if ((i & 2) != 0) {
                    bitmap = searchData.searchBitmap;
                }
                if ((i & 4) != 0) {
                    str2 = searchData.containerEnterFrom;
                }
                if ((i & 8) != 0) {
                    str3 = searchData.containerEnterMethod;
                }
                return searchData.copy(str, bitmap, str2, str3);
            }

            /* renamed from: component1, reason: from getter */
            public final String getSearchText() {
                return this.searchText;
            }

            /* renamed from: component2, reason: from getter */
            public final Bitmap getSearchBitmap() {
                return this.searchBitmap;
            }

            /* renamed from: component3, reason: from getter */
            public final String getContainerEnterFrom() {
                return this.containerEnterFrom;
            }

            /* renamed from: component4, reason: from getter */
            public final String getContainerEnterMethod() {
                return this.containerEnterMethod;
            }

            public final SearchData copy(String searchText, Bitmap searchBitmap, String containerEnterFrom, String containerEnterMethod) {
                return new SearchData(searchText, searchBitmap, containerEnterFrom, containerEnterMethod);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SearchData)) {
                    return false;
                }
                SearchData searchData = (SearchData) other;
                return Intrinsics.areEqual(this.searchText, searchData.searchText) && Intrinsics.areEqual(this.searchBitmap, searchData.searchBitmap) && Intrinsics.areEqual(this.containerEnterFrom, searchData.containerEnterFrom) && Intrinsics.areEqual(this.containerEnterMethod, searchData.containerEnterMethod);
            }

            public int hashCode() {
                String str = this.searchText;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                Bitmap bitmap = this.searchBitmap;
                int hashCode2 = (hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
                String str2 = this.containerEnterFrom;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.containerEnterMethod;
                return hashCode3 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "SearchData(searchText=" + this.searchText + ", searchBitmap=" + this.searchBitmap + ", containerEnterFrom=" + this.containerEnterFrom + ", containerEnterMethod=" + this.containerEnterMethod + ')';
            }

            public SearchData(String str, Bitmap bitmap, String str2, String str3) {
                this.searchText = str;
                this.searchBitmap = bitmap;
                this.containerEnterFrom = str2;
                this.containerEnterMethod = str3;
            }

            public /* synthetic */ SearchData(String str, Bitmap bitmap, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bitmap, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
            }

            public final String getSearchText() {
                return this.searchText;
            }

            public final void setSearchText(String str) {
                this.searchText = str;
            }

            public final Bitmap getSearchBitmap() {
                return this.searchBitmap;
            }

            public final void setSearchBitmap(Bitmap bitmap) {
                this.searchBitmap = bitmap;
            }

            public final String getContainerEnterFrom() {
                return this.containerEnterFrom;
            }

            public final void setContainerEnterFrom(String str) {
                this.containerEnterFrom = str;
            }

            public final String getContainerEnterMethod() {
                return this.containerEnterMethod;
            }

            public final void setContainerEnterMethod(String str) {
                this.containerEnterMethod = str;
            }

            @Override // com.bytedance.android.anniex.base.data.ISearchData
            public String getText() {
                return this.searchText;
            }

            @Override // com.bytedance.android.anniex.base.data.ISearchData
            public Bitmap getBitmap() {
                return this.searchBitmap;
            }

            @Override // com.bytedance.android.anniex.base.data.ISearchData
            public String getEnterFrom() {
                return this.containerEnterFrom;
            }

            @Override // com.bytedance.android.anniex.base.data.ISearchData
            public String getEnterMethod() {
                return this.containerEnterMethod;
            }
        }

        public final SearchDataBuilder setText(String text) {
            this.searchData.setSearchText(text);
            return this;
        }

        public final SearchDataBuilder setBitmap(Bitmap bitmap) {
            this.searchData.setSearchBitmap(bitmap);
            return this;
        }

        public final SearchDataBuilder setEnterFrom(String enterFrom) {
            this.searchData.setContainerEnterFrom(enterFrom);
            return this;
        }

        public final SearchDataBuilder setEnterMethod(String enterMethod) {
            this.searchData.setContainerEnterMethod(enterMethod);
            return this;
        }

        public final ISearchData build() {
            return this.searchData;
        }
    }
}
