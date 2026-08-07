#!/bin/bash
# TRAE CN3 APK 自动化构建脚本
# 用法: ./build.sh <输入APK> <输出APK>
# 例如: ./build.sh /workspace/trae_cn3_v22.apk /workspace/trae_cn3_v24.apk
#
# 脚本会自动完成:
#   1. 安装工具（如果缺失）
#   2. 编译 Java → Smali
#   3. 解包 APK，替换 dex
#   4. 恢复 META-INF/services
#   5. 签名（v2+v3）
#   6. 验证

set -e

# ===== 参数检查 =====
INPUT_APK="$1"
OUTPUT_APK="$2"

if [ -z "$INPUT_APK" ] || [ -z "$OUTPUT_APK" ]; then
    echo "用法: $0 <输入APK> <输出APK>"
    echo "例如: $0 /workspace/trae_cn3_v22.apk /workspace/trae_cn3_v24.apk"
    exit 1
fi

if [ ! -f "$INPUT_APK" ]; then
    echo "错误: 输入 APK 不存在: $INPUT_APK"
    exit 1
fi

# ===== 路径配置 =====
WORK=/data/user/work
REPO="$WORK/trae-cn3-repo"
APKTOOL_JAR="$WORK/apktool.jar"
BAKSMALI_JAR="$WORK/baksmali.jar"
UBER_SIGNER="$WORK/uber-apk-signer.jar"
KEYSTORE="$WORK/trae3.keystore"
ANDROID_JAR=/usr/lib/android-sdk/platforms/android-23/android.jar
DX=/usr/lib/android-sdk/build-tools/debian/dx
DECODED="$WORK/trae_cn3_decoded"
BUILD_DIR="$WORK/build"
STUBS_DIR="$WORK/stubs"

# ===== 1. 安装工具（如果缺失）=====
echo "=== 步骤 1: 检查/安装工具 ==="

if ! command -v javac &>/dev/null; then
    echo "安装 JDK..."
    apt-get update -qq && apt-get install -y -qq default-jdk
fi

if [ ! -f "$APKTOOL_JAR" ]; then
    echo "下载 apktool 2.9.3..."
    wget -q "https://github.com/iBotPeaches/Apktool/releases/download/v2.9.3/apktool_2.9.3.jar" -O "$APKTOOL_JAR"
fi

if [ ! -f "$BAKSMALI_JAR" ]; then
    echo "下载 baksmali..."
    wget -q "https://bitbucket.org/JesusFreke/smali/downloads/baksmali-2.5.2.jar" -O "$BAKSMALI_JAR"
fi

if [ ! -f "$UBER_SIGNER" ]; then
    echo "下载 uber-apk-signer..."
    wget -q "https://github.com/patrickfav/uber-apk-signer/releases/download/v1.3.0/uber-apk-signer-1.3.0.jar" -O "$UBER_SIGNER"
fi

if [ ! -f "$KEYSTORE" ]; then
    echo "生成 keystore..."
    keytool -genkey -v -keystore "$KEYSTORE" \
        -alias trae3 -keyalg RSA -keysize 2048 -validity 10000 \
        -storepass trae123 -keypass trae123 \
        -dname "CN=TRAE3, OU=Dev, O=ByteDance, L=Beijing, ST=Beijing, C=CN"
fi

if [ ! -f "$DX" ]; then
    echo "安装 android-sdk-build-tools..."
    apt-get install -y -qq android-sdk-build-tools
fi

if [ ! -f "$ANDROID_JAR" ]; then
    echo "安装 android-sdk-platform..."
    apt-get install -y -qq android-sdk-platform 2>/dev/null || true
    # 如果还是找不到，搜索
    if [ ! -f "$ANDROID_JAR" ]; then
        ANDROID_JAR=$(find /usr -name "android.jar" 2>/dev/null | head -1)
        if [ -z "$ANDROID_JAR" ]; then
            echo "错误: 找不到 android.jar"
            exit 1
        fi
    fi
fi

echo "工具就绪。"

# ===== 2. 编译 Java → Smali =====
echo ""
echo "=== 步骤 2: 编译 Java → Smali ==="

# 2a. 编译 stub 类
echo "编译 stub 类..."
rm -rf "$STUBS_DIR/classes"
mkdir -p "$STUBS_DIR/classes"
javac -source 8 -target 8 \
    -cp "$ANDROID_JAR" \
    -d "$STUBS_DIR/classes" \
    $(find "$REPO/source/stubs" -name "*.java") 2>&1

# 2b. 打包 stub 为 jar
echo "打包 stub jar..."
cd "$STUBS_DIR/classes"
jar cf "$STUBS_DIR/stubs.jar" .

# 2c. 编译自定义 Java
echo "编译自定义 Java..."
rm -rf "$BUILD_DIR"
mkdir -p "$BUILD_DIR/classes"
javac -source 8 -target 8 \
    -cp "$ANDROID_JAR:$STUBS_DIR/stubs.jar" \
    -d "$BUILD_DIR/classes" \
    "$REPO/source/java/com/bytedance/trae/conversation/extract/"*.java 2>&1

# 2d. dx 转 dex
echo "dx 转 dex..."
"$DX" --dex --output="$BUILD_DIR/classes.dex" "$BUILD_DIR/classes"

# 2e. baksmali 反编译
echo "baksmali 反编译..."
java -jar "$BAKSMALI_JAR" d "$BUILD_DIR/classes.dex" -o "$BUILD_DIR/smali"

# 验证
SMALI_COUNT=$(find "$BUILD_DIR/smali/com/bytedance/trae/conversation/extract/" -name "*.smali" | wc -l)
echo "生成 $SMALI_COUNT 个 Smali 文件"
if [ "$SMALI_COUNT" -ne 5 ]; then
    echo "错误: 应该生成 5 个 Smali 文件，实际 $SMALI_COUNT"
    exit 1
fi

# ===== 3. 解包 APK，替换 dex =====
echo ""
echo "=== 步骤 3: 解包 APK 并替换 dex ==="

rm -rf "$DECODED"
java -jar "$APKTOOL_JAR" d "$INPUT_APK" -o "$DECODED" -f 2>&1 | tail -3

# 替换自定义 Smali
echo "替换自定义 Smali..."
cp "$BUILD_DIR/smali/com/bytedance/trae/conversation/extract/"*.smali \
   "$DECODED/smali_classes9/com/bytedance/trae/conversation/extract/"

# 删除 build 缓存
rm -rf "$DECODED/build"

# 用 apktool 编译（资源编译会失败，但 dex 已生成）
echo "apktool 编译 dex（资源编译失败是正常的）..."
java -jar "$APKTOOL_JAR" b "$DECODED" -o /tmp/dummy.apk 2>&1 || true

# 验证 dex 已生成
if [ ! -f "$DECODED/build/apk/classes9.dex" ]; then
    echo "错误: classes9.dex 未生成"
    exit 1
fi
echo "classes9.dex 已生成: $(ls -la "$DECODED/build/apk/classes9.dex" | awk '{print $5}') bytes"

# ===== 4. 替换 dex 到 APK =====
echo ""
echo "=== 步骤 4: 替换 dex 到 APK ==="

# 复制原始 APK
cp "$INPUT_APK" "$OUTPUT_APK"

# 删除旧签名
echo "删除旧签名..."
zip -d "$OUTPUT_APK" "META-INF/*" 2>&1 | grep -E "deleting|warning" || true

# 替换 classes9.dex
echo "替换 classes9.dex..."
cd "$DECODED/build/apk/"
zip -0 "$OUTPUT_APK" classes9.dex

# 恢复 META-INF/services
echo "恢复 META-INF/services..."
mkdir -p /tmp/meta_restore && cd /tmp/meta_restore
rm -f META-INF/services/*
unzip -o "$INPUT_APK" "META-INF/services/*" -d . 2>&1 | grep "inflating" || true
zip "$OUTPUT_APK" META-INF/services/* 2>&1 | grep "adding" || true

# ===== 5. 签名 =====
echo ""
echo "=== 步骤 5: 签名 ==="

java -jar "$UBER_SIGNER" \
    -a "$OUTPUT_APK" \
    --out "$(dirname "$OUTPUT_APK")" \
    --ks "$KEYSTORE" \
    --ksAlias trae3 \
    --ksPass trae123 \
    --ksKeyPass trae123 \
    --allowResign 2>&1

# 重命名 signed 文件
BASENAME=$(basename "$OUTPUT_APK" .apk)
SIGNED_FILE="$(dirname "$OUTPUT_APK")/${BASENAME}-aligned-signed.apk"
if [ -f "$SIGNED_FILE" ]; then
    mv "$SIGNED_FILE" "$OUTPUT_APK"
fi

# ===== 6. 验证 =====
echo ""
echo "=== 步骤 6: 验证 ==="

echo "--- 签名验证 ---"
java -jar "$UBER_SIGNER" -a "$OUTPUT_APK" -y 2>&1

echo ""
echo "--- 完整性验证 ---"
unzip -t "$OUTPUT_APK" 2>&1 | tail -2

echo ""
echo "--- dex 内容验证 ---"
VERIFY_DIR="/tmp/verify_$(date +%s)"
mkdir -p "$VERIFY_DIR" && cd "$VERIFY_DIR"
unzip -o "$OUTPUT_APK" classes9.dex -d . 2>&1
java -jar "$BAKSMALI_JAR" d classes9.dex -o verify_smali 2>&1
echo "自定义类:"
find verify_smali -name "*.smali" -path "*/extract/*" | sort

echo ""
echo "--- 关键参数验证 ---"
grep "before_limit" verify_smali/com/bytedance/trae/conversation/extract/ApiMessageFetcher.smali 2>/dev/null && echo "OK" || echo "错误: before_limit 未找到"

echo ""
echo "========================================="
echo "构建完成！"
echo "输出 APK: $OUTPUT_APK"
echo "大小: $(ls -lh "$OUTPUT_APK" | awk '{print $5}')"
echo "========================================="
