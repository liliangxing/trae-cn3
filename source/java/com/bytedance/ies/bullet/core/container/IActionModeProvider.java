package com.bytedance.ies.bullet.core.container;

import android.view.Menu;
import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IActionModeProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/core/container/IActionModeProvider;", "", "callAction", "", "type", "", "extra", "", "provideSelectMenuItemList", "", "Lcom/bytedance/ies/bullet/core/container/IActionModeProvider$CustomSelectMenuItem;", "menu", "Landroid/view/Menu;", "Companion", "CustomSelectMenuItem", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IActionModeProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int TYPE_SEARCH = 1;

    void callAction(int type, String extra);

    List<CustomSelectMenuItem> provideSelectMenuItemList(Menu menu);

    /* compiled from: IActionModeProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/core/container/IActionModeProvider$Companion;", "", "()V", "TYPE_SEARCH", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int TYPE_SEARCH = 1;

        private Companion() {
        }
    }

    /* compiled from: IActionModeProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J$\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003J8\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/core/container/IActionModeProvider$CustomSelectMenuItem;", "", "title", "", "clickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class CustomSelectMenuItem {
        private final Function1<String, Unit> clickListener;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomSelectMenuItem copy$default(CustomSelectMenuItem customSelectMenuItem, String str, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = customSelectMenuItem.title;
            }
            if ((i & 2) != 0) {
                function1 = customSelectMenuItem.clickListener;
            }
            return customSelectMenuItem.copy(str, function1);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final Function1<String, Unit> component2() {
            return this.clickListener;
        }

        public final CustomSelectMenuItem copy(String title, Function1<? super String, Unit> clickListener) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            return new CustomSelectMenuItem(title, clickListener);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomSelectMenuItem)) {
                return false;
            }
            CustomSelectMenuItem customSelectMenuItem = (CustomSelectMenuItem) other;
            return Intrinsics.areEqual(this.title, customSelectMenuItem.title) && Intrinsics.areEqual(this.clickListener, customSelectMenuItem.clickListener);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.clickListener.hashCode();
        }

        public String toString() {
            return "CustomSelectMenuItem(title=" + this.title + ", clickListener=" + this.clickListener + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CustomSelectMenuItem(String title, Function1<? super String, Unit> clickListener) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            this.title = title;
            this.clickListener = clickListener;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Function1<String, Unit> getClickListener() {
            return this.clickListener;
        }
    }
}
