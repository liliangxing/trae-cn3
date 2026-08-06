package com.bytedance.trae.design.compose;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;

/* compiled from: TraeContextMenuPopup.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\b$J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\b'Jn\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\b)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019¨\u00060"}, d2 = {"Lcom/bytedance/trae/design/compose/TraeContextMenuItem;", "", "key", "", "text", "onClick", "Lkotlin/Function0;", "", "icon", "Lorg/jetbrains/compose/resources/DrawableResource;", "textColor", "Landroidx/compose/ui/graphics/Color;", "iconTint", "trailingIcon", "trailingIconTint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lorg/jetbrains/compose/resources/DrawableResource;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lorg/jetbrains/compose/resources/DrawableResource;Landroidx/compose/ui/graphics/Color;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getKey", "()Ljava/lang/String;", "getText", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getIcon", "()Lorg/jetbrains/compose/resources/DrawableResource;", "getTextColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getIconTint-QN2ZGVo", "getTrailingIcon", "getTrailingIconTint-QN2ZGVo", "component1", "component2", "component3", "component4", "component5", "component5-QN2ZGVo", "component6", "component6-QN2ZGVo", "component7", "component8", "component8-QN2ZGVo", "copy", "copy-D_Dgqy4", "equals", "", "other", "hashCode", "", "toString", "design-system-compose_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class TraeContextMenuItem {
    public static final int $stable = 0;
    private final DrawableResource icon;
    private final Color iconTint;
    private final String key;
    private final Function0<Unit> onClick;
    private final String text;
    private final Color textColor;
    private final DrawableResource trailingIcon;
    private final Color trailingIconTint;

    public /* synthetic */ TraeContextMenuItem(String str, String str2, Function0 function0, DrawableResource drawableResource, Color color, Color color2, DrawableResource drawableResource2, Color color3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, function0, drawableResource, color, color2, drawableResource2, color3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final Function0<Unit> component3() {
        return this.onClick;
    }

    /* renamed from: component4, reason: from getter */
    public final DrawableResource getIcon() {
        return this.icon;
    }

    /* renamed from: component5-QN2ZGVo, reason: not valid java name and from getter */
    public final Color getTextColor() {
        return this.textColor;
    }

    /* renamed from: component6-QN2ZGVo, reason: not valid java name and from getter */
    public final Color getIconTint() {
        return this.iconTint;
    }

    /* renamed from: component7, reason: from getter */
    public final DrawableResource getTrailingIcon() {
        return this.trailingIcon;
    }

    /* renamed from: component8-QN2ZGVo, reason: not valid java name and from getter */
    public final Color getTrailingIconTint() {
        return this.trailingIconTint;
    }

    /* renamed from: copy-D_Dgqy4, reason: not valid java name */
    public final TraeContextMenuItem m1840copyD_Dgqy4(String key, String text, Function0<Unit> onClick, DrawableResource icon, Color textColor, Color iconTint, DrawableResource trailingIcon, Color trailingIconTint) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return new TraeContextMenuItem(key, text, onClick, icon, textColor, iconTint, trailingIcon, trailingIconTint, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeContextMenuItem)) {
            return false;
        }
        TraeContextMenuItem traeContextMenuItem = (TraeContextMenuItem) other;
        return Intrinsics.areEqual(this.key, traeContextMenuItem.key) && Intrinsics.areEqual(this.text, traeContextMenuItem.text) && Intrinsics.areEqual(this.onClick, traeContextMenuItem.onClick) && Intrinsics.areEqual(this.icon, traeContextMenuItem.icon) && Intrinsics.areEqual(this.textColor, traeContextMenuItem.textColor) && Intrinsics.areEqual(this.iconTint, traeContextMenuItem.iconTint) && Intrinsics.areEqual(this.trailingIcon, traeContextMenuItem.trailingIcon) && Intrinsics.areEqual(this.trailingIconTint, traeContextMenuItem.trailingIconTint);
    }

    public int hashCode() {
        int hashCode = ((((this.key.hashCode() * 31) + this.text.hashCode()) * 31) + this.onClick.hashCode()) * 31;
        DrawableResource drawableResource = this.icon;
        int hashCode2 = (hashCode + (drawableResource == null ? 0 : drawableResource.hashCode())) * 31;
        Color color = this.textColor;
        int i = (hashCode2 + (color == null ? 0 : Color.hashCode-impl(color.unbox-impl()))) * 31;
        Color color2 = this.iconTint;
        int i2 = (i + (color2 == null ? 0 : Color.hashCode-impl(color2.unbox-impl()))) * 31;
        DrawableResource drawableResource2 = this.trailingIcon;
        int hashCode3 = (i2 + (drawableResource2 == null ? 0 : drawableResource2.hashCode())) * 31;
        Color color3 = this.trailingIconTint;
        return hashCode3 + (color3 != null ? Color.hashCode-impl(color3.unbox-impl()) : 0);
    }

    public String toString() {
        return "TraeContextMenuItem(key=" + this.key + ", text=" + this.text + ", onClick=" + this.onClick + ", icon=" + this.icon + ", textColor=" + this.textColor + ", iconTint=" + this.iconTint + ", trailingIcon=" + this.trailingIcon + ", trailingIconTint=" + this.trailingIconTint + ')';
    }

    private TraeContextMenuItem(String str, String str2, Function0<Unit> function0, DrawableResource drawableResource, Color color, Color color2, DrawableResource drawableResource2, Color color3) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.key = str;
        this.text = str2;
        this.onClick = function0;
        this.icon = drawableResource;
        this.textColor = color;
        this.iconTint = color2;
        this.trailingIcon = drawableResource2;
        this.trailingIconTint = color3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TraeContextMenuItem(String str, String str2, Function0 function0, DrawableResource drawableResource, Color color, Color color2, DrawableResource drawableResource2, Color color3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, function0, r7, r8, (i & 32) != 0 ? r8 : color2, (i & 64) != 0 ? null : drawableResource2, (i & 128) != 0 ? null : color3, null);
        DrawableResource drawableResource3 = (i & 8) != 0 ? null : drawableResource;
        Color color4 = (i & 16) != 0 ? null : color;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getText() {
        return this.text;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public final DrawableResource getIcon() {
        return this.icon;
    }

    /* renamed from: getTextColor-QN2ZGVo, reason: not valid java name */
    public final Color m1842getTextColorQN2ZGVo() {
        return this.textColor;
    }

    /* renamed from: getIconTint-QN2ZGVo, reason: not valid java name */
    public final Color m1841getIconTintQN2ZGVo() {
        return this.iconTint;
    }

    public final DrawableResource getTrailingIcon() {
        return this.trailingIcon;
    }

    /* renamed from: getTrailingIconTint-QN2ZGVo, reason: not valid java name */
    public final Color m1843getTrailingIconTintQN2ZGVo() {
        return this.trailingIconTint;
    }
}
