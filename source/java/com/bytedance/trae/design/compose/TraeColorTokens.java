package com.bytedance.trae.design.compose;

import kotlin.Metadata;

/* compiled from: TraeComposeTokens.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/design/compose/TraeColorTokens;", "", "<init>", "()V", "Light", "Lcom/bytedance/trae/design/compose/TraeColors;", "getLight", "()Lcom/bytedance/trae/design/compose/TraeColors;", "Dark", "getDark", "design-system-compose_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TraeColorTokens {
    public static final int $stable = 0;
    public static final TraeColorTokens INSTANCE = new TraeColorTokens();
    private static final TraeColors Light = TraeLightColors.INSTANCE;
    private static final TraeColors Dark = TraeDarkColors.INSTANCE;

    private TraeColorTokens() {
    }

    public final TraeColors getLight() {
        return Light;
    }

    public final TraeColors getDark() {
        return Dark;
    }
}
