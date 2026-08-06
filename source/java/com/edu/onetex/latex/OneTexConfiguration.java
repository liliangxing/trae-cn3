package com.edu.onetex.latex;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OneTexConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0017\u0018\u00002\u00020\u0001Ba\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fR&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0014\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/edu/onetex/latex/OneTexConfiguration;", "", "commandReplacementMapping", "", "", "commandRollbackMapping", "supportNewCommand", "", "supportNewCommandV2", "fontBold", "lowVersionCompat", "fixAlignLeft", "(Ljava/util/Map;Ljava/util/Map;ZZZZZ)V", "getCommandReplacementMapping", "()Ljava/util/Map;", "setCommandReplacementMapping", "(Ljava/util/Map;)V", "getCommandRollbackMapping", "setCommandRollbackMapping", "getFixAlignLeft", "()Z", "getFontBold", "setFontBold", "(Z)V", "getLowVersionCompat", "setLowVersionCompat", "getSupportNewCommand", "setSupportNewCommand", "getSupportNewCommandV2", "setSupportNewCommandV2", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class OneTexConfiguration {
    private Map<String, String> commandReplacementMapping;
    private Map<String, String> commandRollbackMapping;
    private final boolean fixAlignLeft;
    private boolean fontBold;
    private boolean lowVersionCompat;
    private boolean supportNewCommand;
    private boolean supportNewCommandV2;

    public OneTexConfiguration(Map<String, String> map, Map<String, String> map2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(map, "commandReplacementMapping");
        Intrinsics.checkNotNullParameter(map2, "commandRollbackMapping");
        this.commandReplacementMapping = map;
        this.commandRollbackMapping = map2;
        this.supportNewCommand = z;
        this.supportNewCommandV2 = z2;
        this.fontBold = z3;
        this.lowVersionCompat = z4;
        this.fixAlignLeft = z5;
    }

    public /* synthetic */ OneTexConfiguration(Map map, Map map2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2, z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4, (i & 64) != 0 ? false : z5);
    }

    public final Map<String, String> getCommandReplacementMapping() {
        return this.commandReplacementMapping;
    }

    public final void setCommandReplacementMapping(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.commandReplacementMapping = map;
    }

    public final Map<String, String> getCommandRollbackMapping() {
        return this.commandRollbackMapping;
    }

    public final void setCommandRollbackMapping(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.commandRollbackMapping = map;
    }

    public final boolean getSupportNewCommand() {
        return this.supportNewCommand;
    }

    public final void setSupportNewCommand(boolean z) {
        this.supportNewCommand = z;
    }

    public final boolean getSupportNewCommandV2() {
        return this.supportNewCommandV2;
    }

    public final void setSupportNewCommandV2(boolean z) {
        this.supportNewCommandV2 = z;
    }

    public final boolean getFontBold() {
        return this.fontBold;
    }

    public final void setFontBold(boolean z) {
        this.fontBold = z;
    }

    public final boolean getLowVersionCompat() {
        return this.lowVersionCompat;
    }

    public final void setLowVersionCompat(boolean z) {
        this.lowVersionCompat = z;
    }

    public final boolean getFixAlignLeft() {
        return this.fixAlignLeft;
    }
}
