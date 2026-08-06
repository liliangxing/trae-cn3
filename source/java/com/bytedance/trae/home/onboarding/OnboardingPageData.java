package com.bytedance.trae.home.onboarding;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: OnboardingPageData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÇ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0019\u001a\u00020\u0003H×\u0001J\t\u0010\u001a\u001a\u00020\u001bH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/home/onboarding/OnboardingPageData;", "", "titleNormalResId", "", "titleItalicResId", "imageResId", "buttonTextResId", "isLastPage", "", "<init>", "(IIIIZ)V", "getTitleNormalResId", "()I", "getTitleItalicResId", "getImageResId", "getButtonTextResId", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OnboardingPageData {
    public static final int $stable = 0;
    private final int buttonTextResId;
    private final int imageResId;
    private final boolean isLastPage;
    private final int titleItalicResId;
    private final int titleNormalResId;

    public static /* synthetic */ OnboardingPageData copy$default(OnboardingPageData onboardingPageData, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = onboardingPageData.titleNormalResId;
        }
        if ((i5 & 2) != 0) {
            i2 = onboardingPageData.titleItalicResId;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = onboardingPageData.imageResId;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = onboardingPageData.buttonTextResId;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            z = onboardingPageData.isLastPage;
        }
        return onboardingPageData.copy(i, i6, i7, i8, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTitleNormalResId() {
        return this.titleNormalResId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTitleItalicResId() {
        return this.titleItalicResId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getImageResId() {
        return this.imageResId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getButtonTextResId() {
        return this.buttonTextResId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsLastPage() {
        return this.isLastPage;
    }

    public final OnboardingPageData copy(int titleNormalResId, int titleItalicResId, int imageResId, int buttonTextResId, boolean isLastPage) {
        return new OnboardingPageData(titleNormalResId, titleItalicResId, imageResId, buttonTextResId, isLastPage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnboardingPageData)) {
            return false;
        }
        OnboardingPageData onboardingPageData = (OnboardingPageData) other;
        return this.titleNormalResId == onboardingPageData.titleNormalResId && this.titleItalicResId == onboardingPageData.titleItalicResId && this.imageResId == onboardingPageData.imageResId && this.buttonTextResId == onboardingPageData.buttonTextResId && this.isLastPage == onboardingPageData.isLastPage;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.titleNormalResId) * 31) + Integer.hashCode(this.titleItalicResId)) * 31) + Integer.hashCode(this.imageResId)) * 31) + Integer.hashCode(this.buttonTextResId)) * 31) + Boolean.hashCode(this.isLastPage);
    }

    public String toString() {
        return "OnboardingPageData(titleNormalResId=" + this.titleNormalResId + ", titleItalicResId=" + this.titleItalicResId + ", imageResId=" + this.imageResId + ", buttonTextResId=" + this.buttonTextResId + ", isLastPage=" + this.isLastPage + ')';
    }

    public OnboardingPageData(int i, int i2, int i3, int i4, boolean z) {
        this.titleNormalResId = i;
        this.titleItalicResId = i2;
        this.imageResId = i3;
        this.buttonTextResId = i4;
        this.isLastPage = z;
    }

    public final int getTitleNormalResId() {
        return this.titleNormalResId;
    }

    public final int getTitleItalicResId() {
        return this.titleItalicResId;
    }

    public final int getImageResId() {
        return this.imageResId;
    }

    public final int getButtonTextResId() {
        return this.buttonTextResId;
    }

    public final boolean isLastPage() {
        return this.isLastPage;
    }
}
