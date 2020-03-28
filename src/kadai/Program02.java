/*
 * instance作成を通して、classとinstanceの関係を理解してもらうためのソースコード。
 * 下記を勉強する。
 * １）default constructorを定義して、それを使ってinstance化を行う
 * ２）instance fieldを初期化するconstructorを定義して、それを使ってinstance化を行う
 * ３）instance fieldを使って処理を行うinstance methodを定義して、生成したinstanceを通してこれを実行する
 */

package kadai;

/**
 * 山本太郎と宮元二郎という2人の人間を作成して自己紹介させるclass
 * @author wombat
 * @since 2020/02/08
 */
public class Program02
{
    public static void main(String[] args) // Ecipseの場合はmainと打ち込んでctrl+spaceで補完して書くこと！
    {
        // instanceの作成とinstance methodの実行方法

        // 1. default constructorで空のinstanceを作成後、fieldに値を１つずつ設定していく方法
        Person yamamotoTarou = new Person(); // ★【省エネTIPS】Ecipseの場合、local変数に代入する場合は、先に右側だけを書いてからctrl+2を押してl（英字のエル）を押すと型を推定して左辺を自動作成してくれる。この場合は「new Person()」とだけ書いてctrl+2→lでOK。
        yamamotoTarou.sei = "山本";
        yamamotoTarou.mei = "太郎";
        yamamotoTarou.age = 16;
        yamamotoTarou.doJikoshoukai(); // 「私の名前は山本 太郎、16歳の人間です。」と自己紹介させる

        // 2. instance fieldを引数の値で初期化してinstanceを作成する方法
        Person miyamotoJirou = new Person("宮元", "二郎", 20);
        miyamotoJirou.doJikoshoukai(); // 「私の名前は宮元 二郎、20歳の人間です。」と自己紹介させる

        String shuzoku = Person.shuzoku;
        System.out.println("Person classのinstanceは全部" + shuzoku + "である。"); // Person classのinstanceは全部人間である。

        // 上記の例から分かるように、
        // instance methodは、[作成したinstance].[method名(引数に設定する値)]で呼び出し、
        // class methodは、[class名].[method名(引数に設定する値)]で呼び出す。
    }
}

/**
 * 人間を表すclass
 * @author wombat
 * @since 2020/02/08
 */
class Person
{
    // 以下はclass field（class固有の情報）
    /** 種族 */
    public static String shuzoku = "人間";

    // 以下はinstance field（instance固有の情報）
    /** 姓 */
    public String sei;
    /** 名 */
    public String mei;
    /** 歳 */
    public int age;

    // ★【省エネTIPS】Eclipseの場合、何も打たずにctrl+spaceで出て来る選択肢から
    // 「Person - コンストラクター」を選択して、下記のdefault constructorを作成すること。
    /**
     * default constructor.
     */
    public Person()
    {
        // 何もしない
    }

    // ★【省エネTIPS】Eclipseの場合、右クリック→「ソース」→「フィールドを使用してコンストラクターを生成」
    // を選択して、下記のconstructorを作成すること。
    /**
     * 姓、名、歳を引数で設定してinstance化するためのconstructor。
     * @param sei 姓
     * @param mei 名
     * @param age 歳
     */
    public Person(String sei, String mei, int age)
    {
        super(); // 親classのdefault constructorを呼ぶ（Person classの場合、親classはObject class）→この場合は何も起こらない
        this.sei = sei; // field変数と仮引数とで変数名が被った場合は、明示的に「this.」を付けることでfield変数を指し示す必要がある（普段は省略してOK。その場合はcompilerの方で勝手に付けてくれる）。
        this.mei = mei;
        this.age = age;
    }

    /**
     * 自己紹介をする。
     */
    public void doJikoshoukai()
    {
        String jikoshoukai = "私の名前は" + sei + " " + mei + "、" + age + "歳の" + shuzoku + "です。";
        System.out.println(jikoshoukai); // Ecipseの場合は「System.out.println();」はsysoと打ってctrl+spaceで補完して書くこと！
    }
}

//***** 説明しよう！！【※1.constructor】 *****
// ・constructorを何も書かなければ、default constructorが暗黙の内に追加される。
// つまり、今回は3つの引数を取るconstructorを書いた時点で「default constructorは
// 暗黙的に作成されるということはなくなった」ため、こちらで明示的にdefault constructorを定義したのだ。
// ・fieldの初期化のタイミングについて：
// 基本的に、instance作成した時点で入っていないとマズいデータはconstructorで設定できるように
// 引数ありのconstructorを作るのが、正しい。
// ・instance化させたくない場合はprivateなconstructorを書くことで、
// publicなdefault constructorが暗黙の内に追加されることを防ぐ（別の機会に解説する）。

// ※注：Javaの慣習ではfieldのaccess修飾子はprivateとして、accessor（getterとsetterのこと）を利用して
// fieldを参照するのが一般的だが、ここでは分かりやすさを優先して今回の学習対象ではない部分は簡略化するためpublicにしている。


//***** 説明しよう！！【※2.classとinstanceの作成】 *****
// ・身近なモノで例えると、classは「たい焼きの型」、それに対してinstanceは「それを使って作成したたい焼き」。
// つまり、classとはあるモノの性質を「属性（データ）」（field）と「可能な操作（処理）」（method）の２つで表したものであり、
// instanceとはその具体例な例のことである。今回のPerson classの例であれば、人間は「属性として、種族、名前、年齢などを持っており」、
// また「自己紹介という操作（動作）が可能」であるから、このようなfieldとmethodを持てる、ということになる。
// さらに、その人間の具体例として、16歳の山本太郎や、20歳の宮元二郎などがいる。



/* 【課題】=====================================================================
これはinstance fieldとclass field、instance methodとclass methodについて復習する課題である。

--------------------
【課題１】
--------------------
Program02Kadai1.javaというソースファイルを作成し、下記をコピペし、
Program02Kadai1 classのmain methodがちゃんと動作するように未実装なAccessCounter classを実装せよ。
ここで、AccessCounter classは各ページとサイト全体のアクセス数を数えて保持するclassであり、
incrementAccess()は訪問があった場合にこれを呼ぶことでそのページとサイト全体のアクセス数を1だけ増やすmethod、
getPageAccessCount()は対象ページのアクセス数を返し、
getWebsiteAccessCount()はサイト全体のアクセス数を返し、
getStatusMessage()は対象のページのステータスを返すmethodである。
戻り値の期待値は下記のmain methodで各method呼び出しを行ってる行の行末の１行コメントに記載してあるので、
その通りになるようにAccessCounter classを実装すること。


package study1.chapter1.unit2;

public class Program02Kadai1
{
    public static void main(String[] args)
    {
        // トップページ用のaccess counterを作成
        AccessCounter counter1 = new AccessCounter("トップページ");

        // 自己紹介ページ用のaccess counterを作成
        AccessCounter counter2 = new AccessCounter("自己紹介ページ");

        // 趣味のページ用のaccess counterを作成
        AccessCounter counter3 = new AccessCounter("趣味のページ");

        // 誰かがトップページに訪問し、趣味のページを開いて去る
        counter1.incrementAccess();
        counter3.incrementAccess();

        // 誰かがトップページに訪問し、自己紹介のページを開いて去る
        counter1.incrementAccess();
        counter2.incrementAccess();

        // 誰かが趣味のページを訪問して去る
        counter3.incrementAccess();

        // 誰かがトップページに訪問して去る
        counter1.incrementAccess();

        // トップページのアクセス数を取得して表示
        System.out.println(counter1.getPageAccessCount()); // 3

        // 自己紹介のアクセス数を取得して表示
        System.out.println(counter2.getPageAccessCount()); // 1

        // 趣味のページのアクセス数を取得して表示
        System.out.println(counter3.getPageAccessCount()); // 2

        // サイト全体のアクセス数を取得して表示
        System.out.println(AccessCounter.getWebsiteAccessCount()); // 6

        // トップページのアクセスステータスを取得して表示
        System.out.println(counter1.getStatusMessage()); // 現在のアクセス数：3回（トップページ)／6回（サイト全体）
    }
}

class AccessCounter
{
    // TODO
}


--------------------
【課題２】（発展課題）
--------------------
【課題１】のコードでは「ページ毎にaccess counterを作成」するという不自然なaccess counterの設計をしていたが、
ここでaccess counterの設計を「すべての個別ページについてのaccess数も管理する」と見直してみよう。

Program02Kadai2.javaというソースファイルを作成し、下記をコピペし、
Program02Kadai2 classのmain methodがちゃんと動作するように未実装なAccessCounter2 classを実装せよ。

＜必要な知識＞
①MapやHashMapは今後学ぶ内容なので、現段階では詳しく分からなくてよいが、下記の知識を知っておけば、本問は回答できる。
１）Mapとは、key値とvalue値を対応付けて保持することができる入れ物である。
    ただし、参照型しか保持できずprimitive型（int、long、double、booleanなど）は保持できない。
２）Mapは「Map<[key値の型], [value値の型]> [変数名] = new HashMap<>();」という形式でinstance化できる。
３）「[Map instanceの変数名].put([key値], [value値]);」という形式で、Map instanceにkey値とvalue値をセットで保持させられる。
４）「[Map instanceの変数名].containsKey([key値])」という形式で、Map instanceがこのkey値を保持しているかを調べることができる（戻り値がtrueならば保持している、falseなら保持していない）。
５）「[Map instanceの変数名].get([key値])」という形式で、Map instanceがこのkey値とセットで保持しているvalue値を取得できる。
②primitive型にはそれに対応する参照型がある（intに対してInteger、longに対してLong、doubleに対してDoubleなど）。
  Java1.5以降、auto-boxingという「primitive型とそれに対応する参照型の間での暗黙的な自動変換」が行われるようになった。
  つまり、Mapのinstanceにprimitive型のkey値またはvalue値を渡すことも可能である（対応する参照型に変換されて保持される）し、
  逆に取得したkey値やvalue値を対応するprimitive型の変数に代入することも可能である（対応するprimitive型に変換されて代入される）。

具体的な例：
Map<String, Integer> map = new HashMap<>(); // 「String型のkey値」と「Integer型のvalue値」をセットで保持するMapのinstanceを作成
map.put("abeshi", 1); // key値"abeshi"とvalue値1をセットでMap instanceに追加
if (map.containsKey("abeshi")) // key値が"abeshi"であるセットを保持しているか？
{
    Integer i = map.get("abeshi"); // 保持している場合は、そのvalue値を取得して変数iに代入する
}


package study1.chapter1.unit2;

import java.util.HashMap;
import java.util.Map;

public class Program02Kadai2
{
    public static void main(String[] args)
    {
        // トップページ用のaccess counterを作成
        AccessCounter2 counter = AccessCounter2.getCounter();

        // 誰かがトップページに訪問し、趣味のページを開いて去る
        counter.incrementAccess("トップページ");
        counter.incrementAccess("趣味のページ");

        // 誰かがトップページに訪問し、自己紹介のページを開いて去る
        counter.incrementAccess("トップページ");
        counter.incrementAccess("自己紹介ページ");

        // 誰かが趣味のページを訪問して去る
        counter.incrementAccess("趣味のページ");

        // 誰かがトップページに訪問して去る
        counter.incrementAccess("トップページ");

        // トップページのアクセス数を取得して表示
        System.out.println(counter.getPageAccessCount("トップページ")); // 3

        // 自己紹介のアクセス数を取得して表示
        System.out.println(counter.getPageAccessCount("自己紹介ページ")); // 1

        // 趣味のページのアクセス数を取得して表示
        System.out.println(counter.getPageAccessCount("趣味のページ")); // 2

        // サイト全体のアクセス数を取得して表示
        System.out.println(counter.getWebsiteAccessCount()); // 6

        // トップページのアクセスステータスを取得して表示
        System.out.println(counter.getStatusMessage("トップページ")); // 現在のアクセス数：3回（トップページ)／6回（サイト全体）
    }
}

class AccessCounter2
{
    // TODO
}
*/