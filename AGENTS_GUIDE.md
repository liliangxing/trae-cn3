# AI Agent 操作指引（必读）

> **如果你是 AI Agent，请在做任何修改之前完整阅读本文件。**

---

## 1. 核心原则：Java 是唯一源码

**自定义代码只存 Java，不存 Smali。**

```
你修改的文件              构建过程              最终产物
source/java/*.java  →  javac → d8 → baksmali  →  *.smali  →  apktool b  →  APK
（唯一源码）              （编译链，中间产物）        （临时文件）       （最终包）
```

- 你只修改 `source/java/` 下的 Java 文件
- Smali 是编译生成的中间产物，不存仓库、不手动修改
- 如果你看到 `source/smali/` 下有自定义类的 .smali 文件，**那是错误的**，应该删除

---

## 2. 仓库里有什么、在哪里

### 2.1 两类代码：自定义 Java 和原版 Smali

| 目录 | 内容 | 你能改吗 |
|------|------|---------|
| `source/java/com/bytedance/trae/conversation/extract/` | 4 个手写 Java 文件 | **可以改，这是你的工作区** |
| `source/java/` 其余部分 | 37,983 个 jadx 反编译的 Java 文件 | **不要改**（仅供阅读原版逻辑） |
| `source/smali/` | 6,732 个原版 APK 的 Smali 文件 | **不要改**（打包时原样使用） |
| `source/res/` | 修改过的资源文件 | 可以改 |

### 2.2 自定义 Java 文件清单

| 文件 | 路径 | 作用 |
|------|------|------|
| `ExtractHelper.java` | `source/java/com/bytedance/trae/conversation/extract/ExtractHelper.java` | 主入口：数据库查询 + API 回退 + Markdown 生成 |
| `ApiMessageFetcher.java` | `source/java/com/bytedance/trae/conversation/extract/ApiMessageFetcher.java` | 从服务器 API 拉取消息（含 SSL TrustManager 内部类） |
| `FileLogger.java` | `source/java/com/bytedance/trae/conversation/extract/FileLogger.java` | 文件日志工具 |
| `GitHubPusher.java` | `source/java/com/bytedance/trae/conversation/extract/GitHubPusher.java` | 异步推送到 GitHub |

### 2.3 其他修改过的文件

| 文件 | 路径 | 改动 |
|------|------|------|
| MenuPopupWindow.smali | `source/smali/com/bytedance/trae/conversation/widget/MenuPopupWindow.smali` | 添加"提取对话"菜单点击 |
| MenuPopupWindow$OnMenuClickListener.smali | `source/smali/com/bytedance/trae/conversation/widget/` | 添加 `onExtractClick()` 方法 |
| MenuPopupWindow$$ExternalSyntheticLambda5.smali | `source/smali/com/bytedance/trae/conversation/widget/` | 新增：点击监听器 |
| TaskFragment.smali | `source/smali/com/bytedance/trae/conversation/TaskFragment.smali` | 任务列表接入提取 |
| ConversationActivity$initTitleBar$3$1.smali | `source/smali/com/bytedance/trae/conversation/` | 对话页面接入提取 |
| conversation_popup_menu.xml | `source/res/layout/conversation_popup_menu.xml` | 菜单布局 |

> 这些 Smali 文件是原版 APK 反编译后做了小改动（加菜单项），不是我们的自定义类，所以仍以 Smali 形式存储。

---

## 3. 如何修改代码

### 3.1 修改 Java 文件

直接编辑 `source/java/com/bytedance/trae/conversation/extract/` 下的 `.java` 文件。

**改完后必须重新编译成 Smali 才能打包 APK。** 见第 4 节。

### 3.2 为什么不能直接存 Smali？

1. Smali 不可读，维护困难
2. Java 是单一源码，避免 Smali 和 Java 不一致
3. 从 Java 编译 Smali 是确定性过程，不会引入人为错误
4. 如果你发现仓库里有自定义类的 .smali 文件，**请删除它**，只保留 .java

---

## 4. 如何从 Java 编译 Smali 并打包 APK

### 4.1 前提条件

需要一个 apktool 解包的 APK 项目目录。如果环境里没有：

```bash
apktool d original.apk -o decoded_project/
```

### 4.2 编译 Java → Smali

```bash
# 1. 准备 stub 类（解决编译依赖）
#    需要 Android SDK 的 android.jar 和 App 内部类的 stub
#    详见 BUILD_SCRIPT/BUILD.md

# 2. 编译 Java
javac -source 8 -target 8 \
  -cp android.jar:stubs.jar \
  -d out_classes/ \
  source/java/com/bytedance/trae/conversation/extract/*.java

# 3. 转成 dex
d8 --output out.dex \
  out_classes/com/bytedance/trae/conversation/extract/*.class

# 4. 反编译 dex 为 Smali
java -jar baksmali.jar d out.dex -o out_smali/
```

### 4.3 同步到解包目录并打包

```bash
# 1. 复制编译生成的 Smali 到解包目录
cp out_smali/com/bytedance/trae/conversation/extract/*.smali \
   decoded_project/smali_classes9/com/bytedance/trae/conversation/extract/

# 2. 复制原版 Smali 中的其他修改文件
cp source/smali/com/bytedance/trae/conversation/widget/MenuPopupWindow*.smali \
   decoded_project/smali_classes9/com/bytedance/trae/conversation/widget/

# 3. 复制资源文件
cp source/res/layout/conversation_popup_menu.xml \
   decoded_project/res/layout/

# 4. 删除缓存（重要！）
rm -rf decoded_project/build

# 5. 打包
apktool b decoded_project/ -o output_unsigned.apk
```

### 4.4 签名（关键！）

```bash
java -jar uber-apk-signer.jar \
  -a output_unsigned.apk \
  --out /workspace \
  --ks trae3.keystore \
  --ksAlias trae3 \
  --ksPass trae123 \
  --ksKeyPass trae123 \
  --allowResign
```

> **绝对不能用 jarsigner！** 它只生成 v1 签名，Android 7.0+ 会闪退（package info is null）。
> **必须看到 `signature verified [v2, v3]` 才算成功。**

### 4.5 验证

```bash
java -jar uber-apk-signer.jar -a output.apk -y
unzip -t output.apk
```

---

## 5. 常见错误与避坑

### 5.1 "package info is null" 闪退
**原因：** 只签了 v1（用了 jarsigner）
**解决：** 用 uber-apk-signer，确保输出 `[v2, v3]`

### 5.2 VerifyError 闪退
**原因：** Smali 寄存器类型冲突（如果你手写了 Smali）
**解决：** 不要手写 Smali，从 Java 编译

### 5.3 打包出来代码没变
**原因：** apktool 用了 `build/` 缓存
**解决：** 打包前 `rm -rf decoded_project/build`

### 5.4 Smali 文件冲突
**原因：** 同一个类在多个 `smali_classes*` 目录下都有
**解决：** 自定义类只放在 `smali_classes9/`

### 5.5 API 返回 400
**原因：** `before_limit` 参数值不对
**解决：** 必须用 `before_limit=10`

### 5.6 GitHubPusher 推送失败
**原因：** Token 已失效
**解决：** 生成新 Token，更新到 BuildConfig

### 5.7 编译 Java 报错找不到类
**原因：** 缺少 stub 类（Android 框架类、Trae 内部类）
**解决：** 参见 `BUILD_SCRIPT/BUILD.md` 中的 stub 类清单

---

## 6. 需要哪些工具

| 工具 | 用途 | 下载方式 |
|------|------|---------|
| apktool | APK 解包/打包 | `apt install apktool` 或 [ibotpeaches.github.io](https://ibotpeaches.github.io/Apktool/) |
| baksmali | dex→smali | `wget https://bitbucket.org/JesusFreke/smali/downloads/baksmali-2.5.2.jar` |
| uber-apk-signer | APK 签名（v2/v3） | [GitHub](https://github.com/patrickfav/uber-apk-signer) |
| jadx | dex→Java 反编译 | [GitHub](https://github.com/skylot/jadx/releases) |
| Java JDK | 运行工具 + 编译 Java | 系统自带或 `apt install default-jdk` |
| d8 | .class→.dex | Android SDK build-tools 中自带 |

> **不需要任何特殊 skill、MCP 工具或浏览器自动化。** 只需要基本的文件读写和 bash 执行能力。

---

## 7. 完整搭建文档

从原始 APK 到修改到打包到反编译的完整过程，见：

**`搭建指南/trae_cn3-APK逆向修改与Smali转Java完整指南.md`**

---

## 8. 文件完整性检查清单

确认以下文件都在：

**Java 源码（必须）：**
- [ ] `source/java/com/bytedance/trae/conversation/extract/ExtractHelper.java`
- [ ] `source/java/com/bytedance/trae/conversation/extract/ApiMessageFetcher.java`
- [ ] `source/java/com/bytedance/trae/conversation/extract/FileLogger.java`
- [ ] `source/java/com/bytedance/trae/conversation/extract/GitHubPusher.java`

**构建规范（必须）：**
- [ ] `BUILD_SCRIPT/APK_BUILD_SPEC.md`
- [ ] `BUILD_SCRIPT/BUILD.md`

**不应存在的文件（如果有请删除）：**
- [ ] ~~`source/smali/.../extract/ExtractHelper.smali`~~
- [ ] ~~`source/smali/.../extract/ApiMessageFetcher.smali`~~
- [ ] ~~`source/smali/.../extract/ApiMessageFetcher$1.smali`~~
- [ ] ~~`source/smali/.../extract/FileLogger.smali`~~
- [ ] ~~`source/smali/.../extract/GitHubPusher.smali`~~

一键检查命令：
```bash
echo "=== 应该存在的 Java 文件 ==="
for f in ExtractHelper ApiMessageFetcher FileLogger GitHubPusher; do
  p="source/java/com/bytedance/trae/conversation/extract/$f.java"
  [ -f "$p" ] && echo "  OK  $p" || echo "  缺失 $p"
done

echo "=== 不应该存在的 Smali 文件 ==="
for f in ExtractHelper ApiMessageFetcher FileLogger GitHubPusher; do
  p="source/smali/com/bytedance/trae/conversation/extract/$f.smali"
  [ -f "$p" ] && echo "  错误！存在 $p（应删除）" || echo "  OK  $p 不存在"
done
```
