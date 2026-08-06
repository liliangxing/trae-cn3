package com.bytedance.ies.bullet.core.common;

import androidx.compose.material3.TextFieldImplKt;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.utils.AnnieXConstants;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: Scenes.kt */
@Deprecated(message = "use Components instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/core/common/Scenes;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "AbsActivity", "PopupFragment", "ContainerFragment", TextFieldImplKt.ContainerId, "Card", "LitePage", "AnnieXPage", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum Scenes {
    AbsActivity("page"),
    PopupFragment("popup"),
    ContainerFragment("fragment"),
    Container(AnnieX.CONTAINER_VIEW_TYPE_CARD),
    Card(AnnieX.CONTAINER_VIEW_TYPE_CARD),
    LitePage(AnnieXConstants.LITE_PAGE),
    AnnieXPage("annie_x_page");

    private final String tag;

    Scenes(String str) {
        this.tag = str;
    }

    public final String getTag() {
        return this.tag;
    }
}
