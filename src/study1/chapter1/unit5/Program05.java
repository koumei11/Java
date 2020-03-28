///*
// * interfaceの定義と、それを実装したclassの関係を理解してもらうためのソースコード。
// * 下記を勉強する。
// * １）interfaceはabstract classをより抽象化したものであり、定数とabstract methodしか定義できないこと
// * ２）interfaceを実装したclassはabstract methodを実装する責務があるということ
// * ３）interfaceはinstance化できないということ
// * ４）interfaceはType（型）として使われること
// */
//
//package study1.chapter1.unit5;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * interfaceの２つの観点から使い方を示すclass
// * @author wombat
// * @since 2020/03/08
// */
//public class Program05
//{
//    public static void main(String[] args) // Ecipseの場合はmainと打ち込んでctrl+spaceで補完して書くこと！
//    {
//        System.out.println("【コードサンプル１】");
//        // サッカー選手兼料理人である人物を作成
//        FootballerChef keisukeHonda = new FootballerChef(); // Ecipseの場合、先に右側だけを書いてからctrl+2を押してl（英字のエル）を押して書くこと！
//        keisukeHonda.doLifting(); // 1, 2, 3, ... ... ... 1000, 1001, 1002, ...
//        keisukeHonda.doCooking(); // 今日のスペシャリテは「フォアグラと牛フィレ肉のロッシーニ風～香草の香りに初春の陽気を感じて～」でございます。
//
//        // サッカー選手兼料理人兼ピアニストである人物を作成
//        FootballerChefPianist shinjiKagawa = new FootballerChefPianist();
//        shinjiKagawa.doLifting(); // パガニーニの「鐘」によるブラヴーラ風大幻想曲
//        shinjiKagawa.doCooking(); // おまえに食わせるタンメンはねぇ！
//        shinjiKagawa.playPiano("パガニーニの「鐘」によるブラヴューラ風大幻想曲"); // では、リクエストにお応えしてパガニーニの「鐘」によるブラヴューラ風大幻想曲を弾きましょうかね。
//
//
//        System.out.println("\n【コードサンプル２】");
//        String opinion = "ベートーヴェンは偉大と言えよう";
//        String[] itemCodes = new String[] {"10201", "A9123", "57715", "1A2B3C", "293ZQ", "4545=67.41"};
//
//        CustomerCentre customerCentre1 = new SonyCustomerCentre();
//        customerCentre1.acceptOpinion(opinion); // ベートーヴェンは偉大と言えようとのこと、貴重なご意見をありがとうございます。
//        System.out.println(customerCentre1.acceptRepair(itemCodes)); // 修理を承りました。終わりましたらご連絡します。
//
//        CustomerCentre customerCentre2 = new ToshibaCustomerCentre();
//        customerCentre2.acceptOpinion(opinion); // 調査して折り返しご連絡します。
//        System.out.println(customerCentre2.acceptRepair(itemCodes)); // 修理可能な製品について修理を承りました。受付番号は[0, 1, 2]です。
//        System.out.println(customerCentre2);
//    }
//}
//
////******************************************************************************************************
//
//// 【１．多重継承させたいという観点からのinterfaceの使用】
//// Program03とProgram04を通して『classの継承』（←「親を子が継承する」という見方でなく、逆に見て、
//// 「子class間で共通なfieldとmethodを親classとして抽出する」という見方をする方が実践的だし分かりやすい）
//// というものが如何に便利に使えるかを学んだが、このclassの継承だけでは、行き詰まってしまうことがある。
//// Javaは多重継承を言語仕様でサポートしていないからである。
//// 例えば、サッカー選手という親class、料理人という親classを作成した場合に、それら両方を継承してサッカー選手兼料理人というclassは作成できない。
//// そんな場合にはinterfaceを使えばよい。１つのclassでいくつでもinterfaceを実装できるからである。
//// その代わり、interfaceは実装を持てない（定数と抽象methodしか定義できない）ので、それをimplementsしたclass側ですべて実装しなきゃいけないが・・。
//// ※Java1.8でinterfaceにstatic methodとdefault methodが導入されたが、これは別の機会に解説する。
//
///**
// * サッカー選手ができることを定義したinterface
// * @author wombat
// * @since 2020/03/08
// */
//interface Footballer // interfaceは暗黙的にpublicなため、publicは省略して書くのが慣習（冗長なコードは避ける）！書いてしまうと初心者丸出し感がハンパない！
//// 因みにprotectedやprivateを付与するとcompile時エラー。
//{
//    /**
//     * リフティングをする。
//     */
//    void doLifting(); // ※注：interfaceに定義されたfieldはすべて暗黙的にpublic abstractとなるため、publicとabstractは省略して書くのが慣習（冗長なコードは避ける）！書いてしまうと初心者丸出し感がハンパない！
//    // 因みにprotectedやprivateを付与するとcompile時エラー（Java1.9からは条件付きでprivateもOKになったが、これは別の機会に解説する）。実装を書いてもcompile時エラー。
//}
//
///**
// * 料理人ができることを定義したinterface
// * @author wombat
// * @since 2020/03/08
// */
//interface Chef
//{
//    /** 本日のスペシャリテ */
//    String TODAYS_SPECIALITE = "フォアグラと牛フィレ肉のロッシーニ風～香草の香りに初春の陽気を感じて～";
//    // ※注：interfaceに定義されたfieldはすべて暗黙的にpublic static finalとなるため、publicとstaticとfinalは省略して書くのが慣習（冗長なコードは避ける）であるが、定数は定数らしく見えるように略さずに書けという現場もある。
//    // 因みにprotectedやprivateを付与するとcompile時エラー。
//
//    /**
//     * 料理をする。
//     */
//    void doCooking();
//}
//
///**
// * ピアニストができることを定義したinterface
// * @author wombat
// * @since 2020/03/08
// */
//interface Pianist
//{
//    /**
//     * ピアノを弾く
//     * @param piece リクエスト曲
//     */
//    void playPiano(String piece);
//}
//
///**
// * サッカー選手兼料理人を表すclass
// * @author wombat
// * @since 2020/03/08
// */
//class FootballerChef implements Footballer, Chef // ★【省エネTIPS】Ecipseの場合はimplements ○, △と打ち込んで、エラーが表示されたら、エラーをクリックして「実装されていないメソッドの追加」を選択（→自動的にoverrideすべきすべてのmethodの仮実装が作成される）して書くこと！
//{ // classの継承をするときにはextendsと書いたが、interfaceの実装の場合はimplementsと書く！
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void doLifting() // 実装するinterfaceのmethodと同じsignatureで、かつアクセス修飾子はinterfaceの可視性と同等以上（つまりpublic）でなければならない（でなければcompile時エラー）
//    {
//        System.out.println("1, 2, 3, ... ... ... 1000, 1001, 1002, ...");
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void doCooking() // 上記のはFootballer interfaceの持つmethodの実装、こっちはChef interfaceの持つmethodの実装
//    {
//        System.out.println("今日のスペシャリテは「" + TODAYS_SPECIALITE + "」でございます。");
//    }
//}
//
//class FootballerChefPianist implements Footballer, Chef, Pianist
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void doLifting()
//    {
//        System.out.println("ほっ、ほっ、ほっ、・・・");
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void doCooking()
//    {
//        System.out.println("おまえに食わせるタンメンはねぇ！");
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void playPiano(String piece)
//    {
//        System.out.println("では、リクエストにお応えして" + piece + "を弾きましょうかね。");
//    }
//}
//
//// ******************************************************************************************************
//
////【２．広義のINTERFACE（外部との接合点、接点、境界）という観点からのinterfaceの使用】
//// ・広義のINTERFACEとは何か？
//// まずはJavaのinterfaceのことは忘れて欲しい。
//// 日本語（外来語）のインタフェース（interface）という言葉は日常的に使われる言葉である。
//// 「API」（Application Programming Interface）、「外部インタフェース」や「ユーザインタフェース」などは良く耳にするだろう。
//// これらでインタフェースという単語は、２つの物を繋ぐ「接合点、接点、境界」という意味合いで使われている。
//// 例えばパソコンと外部機器（デジカメ、ビデオカメラ、ボイスレコーダ、マイク、Webカメラ、外付けHDD、など）を繋ぐのに
//// USB（Universal Serial Bus）コネクタを使っているが、これらUSB差込口はINTERFACEである。
//// また、HDDの接続の規格にはIDE（帯のような形をした線を使う古い規格）とSATA（新しい規格）があるが、これらの差込口もINTERFACEである。
//// その他に最近ではBluetoothのようなワイアレスインタフェースという物理的な差込口がないINTERFACEもある。
//// 一方で「ユーザインタフェース」とは、機械と人間の間のINTERFACE（接合点）であり、パソコンの場合は「画面、キーボード、マウス、オーディオ、マイク」がINTERFACE、
//// バイクや車の場合は「ハンドル、アクセル、ブレーキ、クラッチ、シフトチェンジペダル、クラクション」がINTERFACEであり、
//// さらにバイクの場合は倒し込みやサスペンションへの荷重など車体への入力も可能なので「車体」すらもINTERFACEである。
//
//// ・interface設計
//// class設計（どんなfieldとmethodを持たせ、処理を行わせるかを考える）を行うときに、まずは
//// 「外部に公開するmethod（つまり窓口として用意するmethod）にはどんなものが必要か」から考え始めるのが、自然な発想である。
//// 『外部から「どのようなデータ」を受け取り、処理結果として「どのようなデータ」を返すのかを決めて』（★）から、さて「内部実装はどうしようかね？」
//// となるわけであるが、この（★）は「interface設計」と呼ばれている。
//// さて、Javaでの「interface設計」はinterfaceに外部公開したいmethodを定義することに他ならない。
//// 最初にinterfaceを作成してから、それを実装するclassを書くことで、頭の中で「何をすべきか」か明確になり、
//// 不必要なmethod公開が抑制でき明瞭なコードが書ける。
////
//// また、先にinterfaceを作成しておくことで、プログラム作成の分担作業も用意になる、
//// 例：機能Aを担当するチームと、機能Bを担当するチームがいる。また、これらの機能を使って別の機能Cを作成するチームがいるとする。
//// 機能Cのチームは、他２チームからそれぞれの機能のinterfaceを貰っておけば、そのinterfaceを実装した仮のclass（dummy classやstubなどと呼ばれる）
//// を作成すれば、機能Aと機能Bの完成を待たずして、機能Cのプログラム作成に取り掛かることができる。
//// 機能Aも機能Bもそれぞれのinterfaceを実装するclassとして作成されるので、それぞれが完成した時点でdummy classから置き換えれば、
//// その時点で結合テストが行える状態になるというカラクリである。
//// このような方法でプログラムを作成することを「Interface-based programming」や「Interface-oriented programming」と呼ぶ。
//// 参考：https://en.wikipedia.org/wiki/Interface-based_programming
//// この例に見るように、interfaceを利用すること、つまり実装と実装の間にinterfaceを挟むことには『実装同士を疎結合にできるという利点』が
//// あるのです（プログラムの疎結合とは、相手の実装に左右されない、という意味であり、疎結合なコードは良いコードである。反対語は密結合。）。
//// ※分かりにくければ、こんな例を考えたらどうだろう。あるJavaのclass（仮にAと呼ぶ）のソースに別のJava（仮にBと呼ぶ）のclassのimport文がある場合、
//// もしBがclass名を変えた場合はAのソースにもその修正を入れる必要が出て来るが、ここでBでなくBが実装するinterfaceをimportしていた場合は
//// Bが名前を変えたとしてもAのソースには修正を入れる必要がない。これは飽くまで疎結合の１つの例である。
//// ※このinterfaceによる疎結合化をさらに推し進めたのがDI（Dependency Injection、依存性の注入）であるが、これは高度な話題なので、またの機会に説明する。
//
///**
// * カスタマーセンターができることを定義したinterface
// * @author wombat
// * @since 2020/03/08
// */
//interface CustomerCentre // まずは、カスタマーセンターが公開すべきmethodとfieldを定義することから始める！
//{
//    /**
//     * 意見を聞く
//     * @param opinion 意見
//     */
//    void acceptOpinion(String opinion);
//
//    /**
//     * 修理を受け付ける
//     * @param itemCodes 修理したい製品の製品番号一覧
//     * @return 返答
//     */
//    String acceptRepair(String[] itemCodes);
//}
//
///**
// * ＳＯＮＹのカスタマーセンター
// * @author wombat
// * @since 2020/03/08
// */
//class SonyCustomerCentre implements CustomerCentre // 後は、個々のカスタマーセンターがCustomerCentre interfaceを実装するように作成するだけ！簡単！
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void acceptOpinion(String opinion)
//    {
//        System.out.println(opinion + "とのこと、貴重なご意見をありがとうございます。");
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String acceptRepair(String[] itemCodes)
//    {
//        return "修理を承りました。終わりましたらご連絡します。";
//    }
//}
//
///**
// * 東芝のカスタマーセンター
// * @author wombat
// * @since 2020/03/08
// */
//class ToshibaCustomerCentre implements CustomerCentre
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void acceptOpinion(String opinion)
//    {
//        String reply;
//        if (opinion.length() < 5)
//        {
//            reply = consultProductDepartment(opinion); // ★【省エネTIPS】Ecipseの場合、未定義のmethodでも躊躇なく書いてしまい、、エラーが表示されたら、エラーをクリックして「メソッド'consultProductDepartment(String)'を作成します」を選択（→自動的に引数や戻り値の型を推測してmethodの仮実装が作成される）して書くこと！
//        }
//        else if (opinion.length() < 100)
//        {
//            reply = consultMarketingDivision(opinion);
//        }
//        else
//        {
//            reply = "貴重なご意見をありがとうございます。";
//        }
//        System.out.println(reply);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String acceptRepair(String[] itemCodes)
//    {
//        List<Integer> receptionNos = new ArrayList<>();
//        for (String itemCode : itemCodes)
//        {
//            if (checkIfRepairable(itemCode))
//            {
//                int receptionNo = requestRepairDepartment(itemCode);
//                receptionNos.add(receptionNo);
//            }
//        }
//        return "修理可能な製品について修理を承りました。受付番号は" + receptionNos + "です。";
//    }
//
//    // 以下は、すべて内部処理（外部に公開する必要がないので、アクセス修飾子はprivateとする）。
//    // 実際に個々のカスタマーセンターの内部で何をやっているかなどは、外部は知らなくても困らない事柄である（ブラックボックスでよろしい）。
//
//    private String consultProductDepartment(String opinion)
//    {
//        return opinion + "の目的でしたら、こちらの製品がよろしいかと思います。";
//    }
//
//    private String consultMarketingDivision(String opinion)
//    {
//        return (opinion.length() < 10) ? "お調べした所、こちらにはそのような報告はございません。" : "調査して折り返しご連絡します。";
//    }
//
//    private boolean checkIfRepairable(String itemCode)
//    {
//        return itemCode.startsWith("1") || itemCode.startsWith("2");
//    }
//
//    private int receptionNo;
//    private int requestRepairDepartment(String itemCode)
//    {
//        return receptionNo++;
//    }
//}
//
////***** 説明しよう！！【※1.インタフェース（interface）】 *****
////０）概論
//// ・interfaceには実装は書けず、定数とabstract methodしか定義できない（つまり、abstract classをさらに抽象化し、もはやガワしか残ってないという状態）。
//// ・以下の２つの観点から、interfaceの使用は促される。
////   （１）多重継承させたいという観点からのinterfaceの使用
////   （２）広義のINTERFACE（外部との接合点、接点、境界）という観点からのinterfaceの使用（※interface設計をまず行いたい）
//
//// １）interfaceの定義方法
//// ・命名規則はProgram01で学んだclassの場合と同じ。つまり、
////   言語仕様的には、package、class、変数などあらゆるものの命名と同じく、
////   ①「Javaの予約語」と同じ名前は付けられず、
////   ②「数字」または「半角/全角のunderscore以外の半角/全角の記号」から始まる名前は付けられず、
////   ③「_（半角underscore）または＿（全角underscore）」以外の半角記号を使った名前は付けられない。
////   慣習的には、『「大文字」から始め、複数の単語から成る場合はそれぞれの頭文字を大文字にしたcamel case』
////   （ラクダのコブみたいなことからこう呼ばれる）で書く。※従わなくてもcompile時エラーにはならないが、この慣習には必ず従うこと！どの現場であっても世界共通の慣習なのだ！
////   abstract classと違い、わざわざinterfaceであることを強調する名前を付けることはしないこと！Javaの標準APIでも、ListやMapなどはinterfaceなのだが、interfaceであることを匂わせる名前ではない。
//// ・『public interface [interface名] { [fieldとmethodの定義] }』が基本構文。但しinterfaceは暗黙的にpublicなため、publicは省略して書くのが慣習（冗長なコードは避ける）！書いてしまうと初心者丸出し感がハンパない！
////   因みにprotectedやprivateを付与するとcompile時エラー。
////   なお、interfaceは親interfaceを継承可能。それもclassと違い、複数の継承も可能。
////   例：interface FootballerChef extends Footballer, Chef {}
////   →このFootballerChefをimplementsするclassはFootballer interfaceとChef interfaceの両方をimplementsすることになる。
//// ・fieldの定義は『public static final [型] [定数名] = [初期値];』が基本構文。但しinterfaceに定義されたfieldはすべて暗黙的にpublic static final（つまり定数）となるため、publicとstaticとfinalは省略して書くのが慣習（冗長なコードは避ける）であるが、定数は定数らしく見えるように略さずに書けという現場もある。
////   →因みにprotectedやprivateを付与するとcompile時エラー。
//// ・methodの定義は『public abstract [型] [method名]([引数列]);』が基本構文。但しinterfaceに定義されたfieldとmethodはすべて暗黙的にpublicとなるため、publicは省略して書くのが慣習（冗長なコードは避ける）！publicを書いてしまうと初心者丸出し感がハンパない！
////   →因みにprotectedやprivateを付与するとcompile時エラー（Java1.9からは条件付きでprivateもOKになったが、これは別の機会に解説する）。実装を書いてもcompile時エラー。
//
//// ２）interfaceの実装方法
//// ・class定義時にclass名の後に半角スペースを入れて『implements [interface名], [interface名], ...』で実装する（複数のinterfaceを指定可能）。
//// ・interfaceを実装する非abstractなclassは、すべての未実装なmethod（abstract method）を実装しないとcompile時エラーとなる。
//// ・interfaceの実装class独自の命名規則の慣習は特になく、classの命名規則と同じである。
////   →DI（Dependency Injection、依存性の注入）を使う場合は、interface実装classは名前の末尾にImplと付ける慣習があるが、DIを使わない場合はImplは付けない方が良い（Javaの標準APIでもListを実装するArrayListやLinkedListにはImplが付いてない！）。
////   →Program04で学んだabstract classの場合は慣習として先頭にAbstractを付けるのとは対照的である。これはInterfaceがType（型）として使われるのに対してabstract classはそのような使われ方をされないからである。例：List mylist;のようにinterfaceは型として使われる。
//
//// 下記はinterfaceを実装したabstract classを実装した非abstract classについての、abstract methodの実装例である。
//interface TypeA // 2つのabstract methodを持つinterface
//{
//    int method1();
//    String method2(int num);
////    void metho3() // interfaceのmethodは暗黙的にabstract methodのため、実装を書くとcompile時エラー「抽象メソッドは本文を指定しません」
////    {
////        // 何もしない実装
////    }
//}
//abstract class AbstractClassA1 implements TypeA // abstract classはabstract methodを持てるので、interfaceのabstract methodを実装する義務はない
//{
//    // interfaceのmethodを１つも実装しない →OK
//}
//abstract class AbstractClassA2 implements TypeA // abstract classは非abstractなmethodも持てるので、もちろん、実装しても構わない。
//{
//    @Override
//    public int method1()
//    {
//        return 1919072;
//    }
//}
////class ClassA1 extends AbstractClassA2 // compile時エラー「型 ClassA1 は継承された抽象メソッド TypeA.method2(int) を実装する必要があります」
////{
////    // method2(int)を実装しない
////}
//class ClassA2 extends AbstractClassA2 // 非abstractなclassはabstract methodを持てないので、親のabstract methodをすべて実装しなければcompile時エラー
//{
//    @Override
//    public String method2(int num) // 親classである
//    {
//        return "引数の値＝" + num;
//    }
//}
//
//
//
///* 【課題】=====================================================================
//これはinterfaceの実装について復習する課題である。
//
//--------------------
//【課題１】
//--------------------
//次の各問に答えよ。
//１）抽象class（abstract class）とinterfaceの違いを説明せよ。下記について言及すること。但しJava1.8以降に追加された新仕様については考えないものとする。
//・子classが継承または実装できる親の数
//・定義できるmember
//・命名規則の慣習
//・戻り値や変数の型として使うかどうか
//２）「interfaceの定義」と「そのmember」のformatについて説明せよ。また、そのときの書き方の慣習についても述べよ。
//
//
//--------------------
//【課題２】
//--------------------
//１）下記のinterfaceを定義する、compileが通るコードを書け。
//名前：TypeA
//親Interface：なし
//持ってる定数：なし
//持ってるmethod：名前はmethodA、引数なし、戻り値なし
//２）下記のinterfaceを定義する、compileが通るコードを書け。
//名前：TypeB
//親Interface：なし
//持ってる定数：なし
//持ってるmethod：名前はmethodB、引数はなし、戻り値の型はint
//３）下記のinterfaceを定義する、compileが通るコードを書け。
//名前：TypeC
//親Interface：「TypeA」と「TypeB」の２つ
//持ってる定数：名前はFIELD_C、型はintで値は777
//持ってるmethod：名前はmethodC、引数はString型の引数１つ、戻り値の型はString
//４）TypeAとTypeBを実装するabstractなclass（名前はAbstractC1）を定義する、compileが通るコード例を１つ書け。
//５）TypeCを実装するabstractなclass（名前はAbstractC2）を定義する、compileが通るコード例を１つ書け。
//６）TypeAとTypeBを実装する非abstractなclass（名前はClassC1）を定義する、compileが通るコード例を１つ書け。
//７）TypeCを実装する非abstractなclass（名前はClassC2）を定義する、compileが通るコード例を１つ書け。
//８）４）で作成したAbstractC1を継承する非abstractなclass（名前はClassC3）を定義する、compileが通るコード例を１つ書け。
//９）５）で作成したAbstractC2を継承する非abstractなclass（名前はClassC4）を定義する、compileが通るコード例を１つ書け。
//
//
//--------------------
//【課題３】
//--------------------
//次の各問に答えよ。
//１）デジカメは「電源のON/OFF切り替えができ」、「ズーム調節やモード切替などの調整が行え」、
//「写真が撮れ」、「撮った写真がその場で確認でき」、「パソコンと繋いで撮った写真をパソコンに移動でき」る機能がついている。
//このデジカメのUI（ユーザインタフェース）となってる部位を思いつくだけリストアップせよ。
//２）不動産情報データバンクを作成した。集めた不動産情報を、無料会員は１日１回まで、月額定額会員は使い放題かつ非公開情報も見られる
//APIでの通信サービスを始めるとする。この場合、どのようなAPIが考えられるだろうか？いくつか思いつくものを挙げよ。
//参考：youtubeのAPI：https://developers.google.com/youtube/v3/docs?hl=ja
//３）交換法則を調べる計算機classを作ってlibraryとして配布して、皆に自由に使ってもらいたい。
//下記の４つの機能を実装することにする。
//機能１：２つの加算可能なobjectを入力値として受け取り、それらを足し合わせる機能
//機能２：２つの加算可能なobjectを入力値として受け取り、それらの加算の可換性を判定する機能。
//機能３：２つの乗算可能なobjectを入力値として受け取り、それらを掛け合わせる機能。
//機能４：２つの乗算可能なobjectを入力値として受け取り、それらの乗算の可換性を判定する機能。
//※可換性とは「交換法則を満足する性質を持つ」ということ。
//上記それぞれの機能がこのclassの公開すべきmethod（public method）となるが、
//入力値のobjectは、当然libraryとして配布するため、libraryを使う側の人間が作成したclassのinstanceも受け入れたい。
//こういう場合は、それぞれの機能の引数の型をinterfaceにしてそのlibraryで配布する必要がある。
//機能１～４それぞれについて「どのようなmethodを持つinterface」を実装するclassのinstanceが、引数に渡される必要があるだろうか？
//*/