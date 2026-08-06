package com.bytedance.android.monitorV2.hybridSetting.entity;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: BidRegex.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/LazyBidRegex;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidRegex;", "bid", "", "regStr", "(Ljava/lang/String;Ljava/lang/String;)V", "getRegStr", "()Ljava/lang/String;", "compareTo", "", PreloadConfig.KEY_OTHER, "toString", "value", "Lkotlin/text/Regex;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LazyBidRegex extends BidRegex {
    private final String regStr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyBidRegex(String str, String str2) {
        super(str, null);
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "regStr");
        this.regStr = str2;
    }

    public final String getRegStr() {
        return this.regStr;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.entity.BidRegex
    protected Regex value() {
        if (!isInitialized()) {
            set_regex(new Regex(this.regStr));
        }
        return get_regex();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.monitorV2.hybridSetting.entity.BidRegex, java.lang.Comparable
    public int compareTo(BidRegex other) {
        int length;
        int length2;
        Intrinsics.checkNotNullParameter(other, PreloadConfig.KEY_OTHER);
        if (other instanceof LazyBidRegex) {
            length = ((LazyBidRegex) other).regStr.length();
            length2 = this.regStr.length();
        } else {
            length = other.getRegex().getPattern().length();
            length2 = getRegex().getPattern().length();
        }
        return length - length2;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.entity.BidRegex
    public String toString() {
        return getBid() + ": [" + this.regStr + ']';
    }
}
