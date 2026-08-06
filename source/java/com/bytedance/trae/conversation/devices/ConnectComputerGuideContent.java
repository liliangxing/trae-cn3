package com.bytedance.trae.conversation.devices;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: ConnectComputerGuideContentPolicy.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;", "", "heroRes", "", "step1Res", "step2Res", "<init>", "(III)V", "getHeroRes", "()I", "getStep1Res", "getStep2Res", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConnectComputerGuideContent {
    private final int heroRes;
    private final int step1Res;
    private final int step2Res;

    public static /* synthetic */ ConnectComputerGuideContent copy$default(ConnectComputerGuideContent connectComputerGuideContent, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = connectComputerGuideContent.heroRes;
        }
        if ((i4 & 2) != 0) {
            i2 = connectComputerGuideContent.step1Res;
        }
        if ((i4 & 4) != 0) {
            i3 = connectComputerGuideContent.step2Res;
        }
        return connectComputerGuideContent.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHeroRes() {
        return this.heroRes;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStep1Res() {
        return this.step1Res;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStep2Res() {
        return this.step2Res;
    }

    public final ConnectComputerGuideContent copy(int heroRes, int step1Res, int step2Res) {
        return new ConnectComputerGuideContent(heroRes, step1Res, step2Res);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectComputerGuideContent)) {
            return false;
        }
        ConnectComputerGuideContent connectComputerGuideContent = (ConnectComputerGuideContent) other;
        return this.heroRes == connectComputerGuideContent.heroRes && this.step1Res == connectComputerGuideContent.step1Res && this.step2Res == connectComputerGuideContent.step2Res;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.heroRes) * 31) + Integer.hashCode(this.step1Res)) * 31) + Integer.hashCode(this.step2Res);
    }

    public String toString() {
        return "ConnectComputerGuideContent(heroRes=" + this.heroRes + ", step1Res=" + this.step1Res + ", step2Res=" + this.step2Res + ')';
    }

    public ConnectComputerGuideContent(int i, int i2, int i3) {
        this.heroRes = i;
        this.step1Res = i2;
        this.step2Res = i3;
    }

    public final int getHeroRes() {
        return this.heroRes;
    }

    public final int getStep1Res() {
        return this.step1Res;
    }

    public final int getStep2Res() {
        return this.step2Res;
    }
}
