package com.bytedance.trae.conversation.widget;

import kotlin.Metadata;

/* compiled from: SpeakerInterpolator.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/widget/SpeakerInterpolator;", "Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpeakerInterpolator extends EaseCubicInterpolator {
    public SpeakerInterpolator() {
        getMControlPoint1().x = 0.0f;
        getMControlPoint1().y = 0.0f;
        getMControlPoint2().x = 0.58f;
        getMControlPoint2().y = 1.0f;
    }
}
