package com.lynx.animax.property;

/* loaded from: classes6.dex */
public class AnimaXValueParam {
    public static final int FRAME_INDEX_ALL = -1;
    private final Boolean mBooleanValue;
    private final Integer mColorValue;
    private final Coordinate mCoordinateValue;
    private final Number mNumberValue;
    private final String mStringValue;
    private final Integer mTargetFrame;
    private final Type mType;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum Type {
        STRING,
        NUMBER,
        BOOLEAN,
        COORDINATE,
        COLOR,
        COLOR_FILTER,
        NULL
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class Coordinate {
        public final double x;
        public final double y;
        public final double z;

        public Coordinate(double d, double d2, double d3) {
            this.x = d;
            this.y = d2;
            this.z = d3;
        }
    }

    private AnimaXValueParam(Type type, String str, Number number, Boolean bool, Coordinate coordinate, Integer num, Integer num2) {
        this.mType = type;
        this.mStringValue = str;
        this.mNumberValue = number;
        this.mBooleanValue = bool;
        this.mCoordinateValue = coordinate;
        this.mColorValue = num;
        this.mTargetFrame = num2;
    }

    public static AnimaXValueParam fromString(String str) {
        return new AnimaXValueParam(Type.STRING, str, null, null, null, null, null);
    }

    public static AnimaXValueParam fromString(String str, int i) {
        return new AnimaXValueParam(Type.STRING, str, null, null, null, null, Integer.valueOf(i));
    }

    public static AnimaXValueParam fromNumber(double d) {
        return new AnimaXValueParam(Type.NUMBER, null, Double.valueOf(d), null, null, null, null);
    }

    public static AnimaXValueParam fromNumber(double d, int i) {
        return new AnimaXValueParam(Type.NUMBER, null, Double.valueOf(d), null, null, null, Integer.valueOf(i));
    }

    public static AnimaXValueParam fromBoolean(boolean z) {
        return new AnimaXValueParam(Type.BOOLEAN, null, null, Boolean.valueOf(z), null, null, null);
    }

    public static AnimaXValueParam fromBoolean(boolean z, int i) {
        return new AnimaXValueParam(Type.BOOLEAN, null, null, Boolean.valueOf(z), null, null, Integer.valueOf(i));
    }

    public static AnimaXValueParam fromCoordinate(double d, double d2) {
        return new AnimaXValueParam(Type.COORDINATE, null, null, null, new Coordinate(d, d2, 0.0d), null, null);
    }

    public static AnimaXValueParam fromCoordinate(double d, double d2, int i) {
        return new AnimaXValueParam(Type.COORDINATE, null, null, null, new Coordinate(d, d2, 0.0d), null, Integer.valueOf(i));
    }

    public static AnimaXValueParam fromCoordinate(double d, double d2, double d3) {
        return new AnimaXValueParam(Type.COORDINATE, null, null, null, new Coordinate(d, d2, d3), null, null);
    }

    public static AnimaXValueParam fromCoordinate(double d, double d2, double d3, int i) {
        return new AnimaXValueParam(Type.COORDINATE, null, null, null, new Coordinate(d, d2, d3), null, Integer.valueOf(i));
    }

    public static AnimaXValueParam fromColor(int i) {
        return new AnimaXValueParam(Type.COLOR, null, null, null, null, Integer.valueOf(i), null);
    }

    public static AnimaXValueParam fromColor(int i, int i2) {
        return new AnimaXValueParam(Type.COLOR, null, null, null, null, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static AnimaXValueParam fromColorFilter(int i, int i2) {
        return new AnimaXValueParam(Type.COLOR_FILTER, null, Double.valueOf(i2), null, null, Integer.valueOf(i), null);
    }

    public static AnimaXValueParam fromColorFilter(int i, int i2, int i3) {
        return new AnimaXValueParam(Type.COLOR_FILTER, null, Double.valueOf(i2), null, null, Integer.valueOf(i), Integer.valueOf(i3));
    }

    public static AnimaXValueParam createNull() {
        return new AnimaXValueParam(Type.NULL, null, null, null, null, null, null);
    }

    public boolean hasTargetFrame() {
        Integer num = this.mTargetFrame;
        return (num == null || num.intValue() == -1) ? false : true;
    }

    public int getTargetFrame() {
        Integer num = this.mTargetFrame;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public boolean isString() {
        return this.mType == Type.STRING;
    }

    public boolean isNumber() {
        return this.mType == Type.NUMBER;
    }

    public boolean isBoolean() {
        return this.mType == Type.BOOLEAN;
    }

    public boolean isCoordinate() {
        return this.mType == Type.COORDINATE;
    }

    public boolean isColor() {
        return this.mType == Type.COLOR;
    }

    public boolean isColorFilter() {
        return this.mType == Type.COLOR_FILTER;
    }

    public boolean isNull() {
        return this.mType == Type.NULL;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public double getNumberValue() {
        Number number = this.mNumberValue;
        if (number != null) {
            return number.doubleValue();
        }
        return 0.0d;
    }

    public boolean getBooleanValue() {
        Boolean bool = this.mBooleanValue;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public double getX() {
        Coordinate coordinate = this.mCoordinateValue;
        if (coordinate != null) {
            return coordinate.x;
        }
        return 0.0d;
    }

    public double getY() {
        Coordinate coordinate = this.mCoordinateValue;
        if (coordinate != null) {
            return coordinate.y;
        }
        return 0.0d;
    }

    public double getZ() {
        Coordinate coordinate = this.mCoordinateValue;
        if (coordinate != null) {
            return coordinate.z;
        }
        return 0.0d;
    }

    public int getColorValue() {
        Integer num;
        if ((isColor() || isColorFilter()) && (num = this.mColorValue) != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getFilterMode() {
        if (isColorFilter()) {
            return (int) getNumberValue();
        }
        return 0;
    }

    public int getTypeIndex() {
        return this.mType.ordinal();
    }

    /* renamed from: com.lynx.animax.property.AnimaXValueParam$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$animax$property$AnimaXValueParam$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$lynx$animax$property$AnimaXValueParam$Type = iArr;
            try {
                iArr[Type.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$animax$property$AnimaXValueParam$Type[Type.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$animax$property$AnimaXValueParam$Type[Type.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$animax$property$AnimaXValueParam$Type[Type.COORDINATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lynx$animax$property$AnimaXValueParam$Type[Type.COLOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$lynx$animax$property$AnimaXValueParam$Type[Type.COLOR_FILTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$lynx$animax$property$AnimaXValueParam$Type[Type.NULL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public String toString() {
        int targetFrame = getTargetFrame();
        switch (AnonymousClass1.$SwitchMap$com$lynx$animax$property$AnimaXValueParam$Type[this.mType.ordinal()]) {
            case 1:
                return "AnimaXValueParam{stringValue='" + this.mStringValue + "', targetFrame=" + targetFrame + "}";
            case 2:
                return "AnimaXValueParam{numberValue=" + getNumberValue() + ", targetFrame=" + targetFrame + "}";
            case 3:
                return "AnimaXValueParam{booleanValue=" + getBooleanValue() + ", targetFrame=" + targetFrame + "}";
            case 4:
                return "AnimaXValueParam{coordinateValue=(" + getX() + "," + getY() + "," + getZ() + "), targetFrame=" + targetFrame + "}";
            case 5:
                return "AnimaXValueParam{colorValue=" + getColorValue() + ", targetFrame=" + targetFrame + "}";
            case 6:
                return "AnimaXValueParam{colorValue=" + getColorValue() + ", mode=" + getNumberValue() + ", targetFrame=" + targetFrame + "}";
            case 7:
                return "AnimaXValueParam{null, targetFrame=" + targetFrame + "}";
            default:
                return "AnimaXValueParam{unknown}";
        }
    }
}
