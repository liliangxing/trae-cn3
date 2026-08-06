package com.bytedance.ies.bullet.service.base;

import com.bytedance.ug.sdk.share.impl.network.request.FetchTokenInfoThread;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0003Jc\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreloadConfig;", "", "geckoChannel", "", "Lcom/bytedance/ies/bullet/service/base/PreloadGeckoChannelConfig;", "image", "Lcom/bytedance/ies/bullet/service/base/PreloadImageConfig;", "font", "Lcom/bytedance/ies/bullet/service/base/PreloadFontConfig;", FetchTokenInfoThread.VIDEO_TOKEN, "Lcom/bytedance/ies/bullet/service/base/PreloadVideoConfig;", "js", "Lcom/bytedance/ies/bullet/service/base/PreloadJsConfig;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getFont", "()Ljava/util/List;", "getGeckoChannel", "getImage", "getJs", "getVideo", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class PreloadConfig {
    private final List<PreloadFontConfig> font;
    private final List<PreloadGeckoChannelConfig> geckoChannel;
    private final List<PreloadImageConfig> image;
    private final List<PreloadJsConfig> js;
    private final List<PreloadVideoConfig> video;

    public PreloadConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PreloadConfig copy$default(PreloadConfig preloadConfig, List list, List list2, List list3, List list4, List list5, int i, Object obj) {
        if ((i & 1) != 0) {
            list = preloadConfig.geckoChannel;
        }
        if ((i & 2) != 0) {
            list2 = preloadConfig.image;
        }
        List list6 = list2;
        if ((i & 4) != 0) {
            list3 = preloadConfig.font;
        }
        List list7 = list3;
        if ((i & 8) != 0) {
            list4 = preloadConfig.video;
        }
        List list8 = list4;
        if ((i & 16) != 0) {
            list5 = preloadConfig.js;
        }
        return preloadConfig.copy(list, list6, list7, list8, list5);
    }

    public final List<PreloadGeckoChannelConfig> component1() {
        return this.geckoChannel;
    }

    public final List<PreloadImageConfig> component2() {
        return this.image;
    }

    public final List<PreloadFontConfig> component3() {
        return this.font;
    }

    public final List<PreloadVideoConfig> component4() {
        return this.video;
    }

    public final List<PreloadJsConfig> component5() {
        return this.js;
    }

    public final PreloadConfig copy(List<PreloadGeckoChannelConfig> geckoChannel, List<PreloadImageConfig> image, List<PreloadFontConfig> font, List<PreloadVideoConfig> video, List<PreloadJsConfig> js) {
        return new PreloadConfig(geckoChannel, image, font, video, js);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreloadConfig)) {
            return false;
        }
        PreloadConfig preloadConfig = (PreloadConfig) other;
        return Intrinsics.areEqual(this.geckoChannel, preloadConfig.geckoChannel) && Intrinsics.areEqual(this.image, preloadConfig.image) && Intrinsics.areEqual(this.font, preloadConfig.font) && Intrinsics.areEqual(this.video, preloadConfig.video) && Intrinsics.areEqual(this.js, preloadConfig.js);
    }

    public int hashCode() {
        List<PreloadGeckoChannelConfig> list = this.geckoChannel;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<PreloadImageConfig> list2 = this.image;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<PreloadFontConfig> list3 = this.font;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<PreloadVideoConfig> list4 = this.video;
        int hashCode4 = (hashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<PreloadJsConfig> list5 = this.js;
        return hashCode4 + (list5 != null ? list5.hashCode() : 0);
    }

    public String toString() {
        return "PreloadConfig(geckoChannel=" + this.geckoChannel + ", image=" + this.image + ", font=" + this.font + ", video=" + this.video + ", js=" + this.js + ')';
    }

    public PreloadConfig(List<PreloadGeckoChannelConfig> list, List<PreloadImageConfig> list2, List<PreloadFontConfig> list3, List<PreloadVideoConfig> list4, List<PreloadJsConfig> list5) {
        this.geckoChannel = list;
        this.image = list2;
        this.font = list3;
        this.video = list4;
        this.js = list5;
    }

    public /* synthetic */ PreloadConfig(List list, List list2, List list3, List list4, List list5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : list4, (i & 16) != 0 ? null : list5);
    }

    public final List<PreloadGeckoChannelConfig> getGeckoChannel() {
        return this.geckoChannel;
    }

    public final List<PreloadImageConfig> getImage() {
        return this.image;
    }

    public final List<PreloadFontConfig> getFont() {
        return this.font;
    }

    public final List<PreloadVideoConfig> getVideo() {
        return this.video;
    }

    public final List<PreloadJsConfig> getJs() {
        return this.js;
    }
}
