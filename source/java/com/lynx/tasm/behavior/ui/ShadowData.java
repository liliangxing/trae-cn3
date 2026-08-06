package com.lynx.tasm.behavior.ui;

import android.graphics.Color;
import com.lynx.react.bridge.ReadableArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class ShadowData {
    public float blurRadius;
    public float blurRenderRadiusExtent;
    public int color;
    public float offsetX;
    public float offsetY;
    public int option;
    public float spreadRadius;

    public String toString() {
        return "ShadowData: Color: red " + Color.red(this.color) + " green: " + Color.green(this.color) + " blue: " + Color.blue(Color.blue(this.color)) + " OffsetX: " + this.offsetX + " offsetY: " + this.offsetY + " blurRadius: " + this.blurRadius + " spreadRadius: " + this.spreadRadius + "option: " + this.option;
    }

    public ShadowData() {
        this.option = 0;
    }

    public ShadowData(ShadowData shadowData) {
        this.option = 0;
        this.color = shadowData.color;
        this.offsetX = shadowData.offsetX;
        this.offsetY = shadowData.offsetY;
        this.blurRadius = shadowData.blurRadius;
        this.spreadRadius = shadowData.spreadRadius;
        this.blurRenderRadiusExtent = shadowData.blurRenderRadiusExtent;
        this.option = shadowData.option;
    }

    public boolean isInset() {
        return this.option == 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ShadowData shadowData = (ShadowData) obj;
        return this.color == shadowData.color && Float.compare(shadowData.offsetX, this.offsetX) == 0 && Float.compare(shadowData.offsetY, this.offsetY) == 0 && Float.compare(shadowData.blurRadius, this.blurRadius) == 0 && Float.compare(shadowData.spreadRadius, this.spreadRadius) == 0 && Float.compare(shadowData.blurRenderRadiusExtent, this.blurRenderRadiusExtent) == 0 && this.option == shadowData.option;
    }

    public int hashCode() {
        int i = ((this.option * 31) + this.color) * 31;
        float f = this.offsetX;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.offsetY;
        int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.blurRadius;
        int floatToIntBits3 = (floatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.spreadRadius;
        int floatToIntBits4 = (floatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
        float f5 = this.blurRenderRadiusExtent;
        return floatToIntBits4 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0);
    }

    public static List<ShadowData> parseShadow(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableArray array = readableArray.getArray(i);
            ShadowData shadowData = new ShadowData();
            shadowData.offsetX = (float) array.getDouble(0);
            shadowData.offsetY = (float) array.getDouble(1);
            float f = (float) array.getDouble(2);
            shadowData.blurRadius = f;
            shadowData.blurRenderRadiusExtent = f * 1.25f;
            shadowData.spreadRadius = (float) array.getDouble(3);
            shadowData.option = array.getInt(4);
            shadowData.color = (int) array.getLong(5);
            if (checkIsValidShadowData(shadowData)) {
                arrayList.add(shadowData);
            }
        }
        return arrayList;
    }

    private static boolean checkIsValidShadowData(ShadowData shadowData) {
        return ((shadowData.offsetX == 0.0f && shadowData.offsetY == 0.0f && shadowData.blurRadius == 0.0f && shadowData.spreadRadius == 0.0f) || Color.alpha(shadowData.color) == 0 || shadowData.blurRadius < 0.0f) ? false : true;
    }
}
