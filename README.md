# MHW-Equipment-Optimizer

【魔物獵人：世界】裝備最佳化工具\
裝備列表版本與PC版同步

## 使用工具

-	Eclipse IDE for Java Developers (2018-09)
-	JRE System Library (1.8)

## 如何使用

### 必要檔案：

安裝 JRE 1.8.0_191 或以上\
https://www.oracle.com/technetwork/java/javase/downloads/index.html

### 裝飾珠設定(設定完成後只要在獲得新的裝飾珠後修改即可)：

編輯/裝備檔案/_擁有裝飾珠.txt\
使用的換行符號是\n所以建議使用Notepad++來編輯檔案
```
#鑲嵌槽等級,等級
#技能名稱,需要裝飾品,擁有裝飾品
鑲嵌槽等級,3
耳塞,5,5
毒瓶追加,1,1
麻痺瓶追加,1,1
睡眠瓶追加,1,1
爆破瓶追加,1,1
匠,5,1
減輕膽怯,3,3
龍封力強化,1,1
屬性解放裝填擴充,3,0
...
```

### 裝備檔案設定：
/裝備檔案 目錄下的其他檔案盡量不要更動，若遊戲有新的裝備加入則有更新的必要

### 需求檔設定：

* 注意：文字檔所有以#開頭的行都會視為註解而不會實際讀取

以狩獵笛.txt 為例
```
#檔名：狩獵笛.txt
#技能名稱,需要技能等級
系列需求：
屍套龍之命脈,3
需求：
耳塞,5
匠,3
弱點特效,3
無傷,2
吹笛名人,1
昏厥耐性,3
回復速度,3
體力回復量UP,3
體力增強,3

武器：
爆鱗鼓赤紅星光
```
"系列需求："下輸入要求的系列技能以及裝備個數，這裡是屍套龍的系列技能，若不需要系列技能請輸入"(無),0"\
"需求："下輸入要求的技能和等級數\
\
以下為可選輸入，如果有輸入的話就會強制選取那些裝備來配對，沒有的話會自動從已有裝備中搜尋\
"武器："下輸入要求的武器名稱(目前我不打算輸入所有的武器，所以這部份請在/裝備檔案/_武器.txt自己加上)\
"頭："同上，
"身："...，
"腕："...，
"腰："...，
"腳："...，
"護石："...，

### 輸入方式：
Windows 10 命令提示字元：
```
cd <MHW-Equipment-Optimizer.jar 的目錄>
java -Dfile.encoding=UTF-8 -jar MHW-Equipment-Optimizer.jar <需求檔案名稱.txt>
```

### 輸出範例：
```
java -Dfile.encoding=UTF-8 -jar MHW-Equipment-Optimizer.jar 狩獵笛.txt
爆鱗鼓赤紅星光,爆鱗龍頭盔β,絢輝龍鎧羅鎧甲β,烏爾德腕甲β,烏爾德腰甲γ,烏爾德護腿γ,匠之護石III
{匠=3, 體力增強=3, 昏厥耐性=3, 耳塞=5, 弱點特效=3, 超會心=1, 體力回復量UP=3, 龍屬性攻擊強化=1, 回復速度=3, 無傷=2, 吹笛名人=1}
防禦力： 444, 屬性抗性：  -5,+11,+2,-9,-13, 剩餘裝飾品數： 0
```

## 未來實作功能：
* 顯示剩餘鑲嵌槽的等級
* 實作使用者介面
* 英語支援
