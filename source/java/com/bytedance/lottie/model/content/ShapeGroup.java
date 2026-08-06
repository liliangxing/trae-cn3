package com.bytedance.lottie.model.content;

import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.animation.content.Content;
import com.bytedance.lottie.animation.content.ContentGroup;
import com.bytedance.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class ShapeGroup implements ContentModel {
    private final List<ContentModel> items;
    private final String name;

    public ShapeGroup(String str, List<ContentModel> list) {
        this.name = str;
        this.items = list;
    }

    public String getName() {
        return this.name;
    }

    public List<ContentModel> getItems() {
        return this.items;
    }

    @Override // com.bytedance.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.name + "' Shapes: " + Arrays.toString(this.items.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }
}
