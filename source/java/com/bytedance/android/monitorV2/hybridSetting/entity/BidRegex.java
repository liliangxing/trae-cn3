package com.bytedance.android.monitorV2.hybridSetting.entity;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;

/* compiled from: BidRegex.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0004J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidRegex;", "", "bid", "", "regex", "Lkotlin/text/Regex;", "(Ljava/lang/String;Lkotlin/text/Regex;)V", "_regex", "get_regex", "()Lkotlin/text/Regex;", "set_regex", "(Lkotlin/text/Regex;)V", "getBid", "()Ljava/lang/String;", "<set-?>", "getRegex", "setRegex", "regex$delegate", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidRegex$Delegate;", "compareTo", "", PreloadConfig.KEY_OTHER, "isInitialized", "", "toString", "value", "Delegate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BidRegex implements Comparable<BidRegex> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(BidRegex.class, "regex", "getRegex()Lkotlin/text/Regex;", 0))};
    protected Regex _regex;
    private final String bid;

    /* renamed from: regex$delegate, reason: from kotlin metadata */
    private final Delegate regex;

    public BidRegex(String str, Regex regex) {
        Intrinsics.checkNotNullParameter(str, "bid");
        this.bid = str;
        this.regex = new Delegate();
        if (regex != null) {
            set_regex(regex);
        }
    }

    public final String getBid() {
        return this.bid;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Regex get_regex() {
        Regex regex = this._regex;
        if (regex != null) {
            return regex;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_regex");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void set_regex(Regex regex) {
        Intrinsics.checkNotNullParameter(regex, "<set-?>");
        this._regex = regex;
    }

    public final Regex getRegex() {
        return this.regex.getValue(this, $$delegatedProperties[0]);
    }

    public final void setRegex(Regex regex) {
        Intrinsics.checkNotNullParameter(regex, "<set-?>");
        this.regex.setValue(this, $$delegatedProperties[0], regex);
    }

    @Override // java.lang.Comparable
    public int compareTo(BidRegex other) {
        Intrinsics.checkNotNullParameter(other, PreloadConfig.KEY_OTHER);
        return other.getRegex().getPattern().length() - getRegex().getPattern().length();
    }

    public String toString() {
        return this.bid + ": [" + getRegex() + ']';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isInitialized() {
        return this._regex != null;
    }

    protected Regex value() {
        return get_regex();
    }

    /* compiled from: BidRegex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0086\u0002J'\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0086\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidRegex$Delegate;", "", "(Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidRegex;)V", "getValue", "Lkotlin/text/Regex;", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final class Delegate {
        public Delegate() {
        }

        public final Regex getValue(Object thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return BidRegex.this.value();
        }

        public final void setValue(Object thisRef, KProperty<?> property, Regex value) {
            Intrinsics.checkNotNullParameter(property, "property");
            Intrinsics.checkNotNullParameter(value, "value");
            BidRegex.this.set_regex(value);
        }
    }
}
