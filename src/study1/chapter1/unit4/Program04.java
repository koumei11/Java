/*
 * abstract classと、それを継承したclassの関係を理解してもらうためのソースコード。
 * 下記を勉強する。
 * １）親classをabstract classにしてabstract methodを使うmerit
 * ２）abstract classとabstract methodの定義方法
 * ３）abstract classを継承したclassはabstract methodを実装する責務があるということ
 * ４）abstract classはinstance化できないということ
 */

package study1.chapter1.unit4;

/**
 * 孫悟空という人間を作成して自己紹介させるclass
 * @author wombat
 * @since 2020/02/08
 */
public class Program04
{
    public static void main(String[] args) // Ecipseの場合はmainと打ち込んでctrl+spaceで補完して書くこと！
    {
        Mammal gokuu = new Human("孫悟空");
        gokuu.sleep(); // zzz...
        gokuu.doJikoshoukai(); // 「オッス！オラ、孫悟空！霊長目ヒト科ヒト属ヒト種、ようするにニンゲンだ！」と自己紹介させる

        // 上記の例から分かるように、
        // abstract methodは「継承された非abstractなclassで必ず実装される」仕組みになってるので、問題なく呼び出せるのだ。

        // abstract classは後に学ぶinterface同様に「instance化」することはできない。
        // 実装が足りてない可能性があるclassはinstance化させるわけにはいかないので、これは考えてみれば当然のこと！
        // Mammal gokuu = new Mammal("霊長目", "ヒト科", "ヒト属", "ヒト種", "孫悟空"); // 「型 Mammal のインスタンスを生成できません」というcompile時エラーになる。
    }
}

/**
 * 哺乳類を表すclass
 * @author wombat
 * @since 2020/02/08
 */
abstract class Mammal
{
    // 以下はclass field（class固有の情報）
    /** 分類階級(https://ja.wikipedia.org/wiki/%E5%93%BA%E4%B9%B3%E9%A1%9E) */
    public static String bunruiKaikyuu = "哺乳綱";

    // 以下はinstance field（instance固有の情報）
    /** 目 */
    public String moku;
    /** 科 */
    public String ka;
    /** 属 */
    public String zoku;
    /** 種 */
    public String shu;
    /** 名前 */
    public String name;

    // 【注意】どれか１つでもinstance fieldの中に『instance化の際に必ず初期化して欲しい』ものがある場合は、default constructorは作成しないこと。
    // →代わりに『instance化の際に必ず初期化したい』fieldの初期値を引数にとるconstructorを定義すること。
    // この場合は、すべてのinstance field（目、科、属、種、名前）をinstance化の際に必ず初期化して欲しいので、default constructorは作成しない。
//    /**
//     * default constructor.
//     */
//    public Mammal()
//    {
//        // 何もしない
//    }

    // Eclipseの場合、右クリック→「ソース」→「フィールドを使用してコンストラクターを生成」
    // を選択して、下記のconstructorを作成すること。
    /**
     * 目、科、属、種、名前を引数で設定してinstance化するためのconstructor。
     * @param moku 目
     * @param ka 科
     * @param zoku 属
     * @param shu 種
     * @param name 名前
     */
    public Mammal(String moku, String ka, String zoku, String shu, String name)
    {
        super(); // 親classのdefault constructorを呼ぶ（Person classの場合、親classはObject class）→この場合は何も起こらない
        this.moku = moku; // field変数と仮引数とで変数名が被った場合は、明示的に「this.」を付けることでfield変数を指し示す必要がある（普段は省略してOK。その場合はcompilerの方で勝手に付けてくれる）。
        this.ka = ka;
        this.zoku = zoku;
        this.shu = shu;
        this.name = name;
    }

    /**
     * 寝る。
     */
    public void sleep()
    {
        System.out.println("zzz..."); // Ecipseの場合は「System.out.println();」はsysoと打ってctrl+spaceで補完して書くこと！
    }

    /**
     * 自己紹介をする。
     */
    abstract public void doJikoshoukai();
    // abstract classは通常のmethodの他にabstract methodを定義できる。これは子classに実装を任せる場合に使う。
    // abstract methodは実装を書かない！書くと「抽象メソッドは本文を指定しません」とcompile時エラーになる。
}

// --- 以下、重要な解説が埋もれてしまうので、constructorのjavadocは割愛するが、出題された課題や業務ではjavadocは極力書く姿勢でいるのが好ましい。 ---

/**
 * 霊長目を表すclass
 * @author wombat
 * @since 2020/02/08
 */
abstract class Primate extends Mammal
{
    // 親classにdefault constructorが未定義の場合は、子classに何か１つはconstructorを定義して親classのconstructorを呼ばなければ、下記のCompile時エラーとなる：
    // 暗黙的スーパー・コンストラクター Mammal() は、デフォルト・コンストラクターについては未定義です。明示的コンストラクターを定義する必要があります

    // ★【省エネTIPS】下記のconstructorは自分では書かないこと！行番号の個所にcompileエラー表示が出たら、それをクリックすると解決策の一覧が表示されるが、
    // 「コンストラクター'Primate(String, String, String, String, String)'を追加します」という選択肢をダブルクリックすると、自動で
    // public Primate(String moku, String ka, String zoku, String shu, String name)の実装skeleton（※骨組だけの空実装のことをskeletonと呼ぶ）が作成されるので、
    // その実装に手を加えるのが省エネな実装方法である！！
    public Primate(String ka, String zoku, String shu, String name)
    {
        super("霊長目", ka, zoku, shu, name);
    }
}

/**
 * ヒト科を表すclass
 * @author wombat
 * @since 2020/02/08
 */
abstract class Hominidae extends Primate
{
    // 親classにdefault constructorが未定義の場合は、子classに何か１つはconstructorを定義して親classのconstructorを呼ばなければ、下記のCompile時エラーとなる：
    // 暗黙的スーパー・コンストラクター Primate() は、デフォルト・コンストラクターについては未定義です。明示的コンストラクターを定義する必要があります
    public Hominidae(String zoku, String shu, String name)
    {
        super("ヒト科", zoku, shu, name);
    }
}

/**
 * ヒト属（ホモ属）を表すclass
 * @author wombat
 * @since 2020/02/08
 */
abstract class Homo extends Hominidae
{
    // 親classにdefault constructorが未定義の場合は、子classに何か１つはconstructorを定義して親classのconstructorを呼ばなければ、下記のCompile時エラーとなる：
    // 暗黙的スーパー・コンストラクター Hominidae() は、デフォルト・コンストラクターについては未定義です。明示的コンストラクターを定義する必要があります
    public Homo(String shu, String name)
    {
        super("ヒト属", shu, name);
    }
}

/**
 * ヒト種を表すclass
 * @author wombat
 * @since 2020/02/08
 */
class Human extends Homo
{
    // 親classにdefault constructorが未定義の場合は、子classに何か１つはconstructorを定義して親classのconstructorを呼ばなければ、下記のCompile時エラーとなる：
    // 暗黙的スーパー・コンストラクター Homo() は、デフォルト・コンストラクターについては未定義です。明示的コンストラクターを定義する必要があります
    public Human(String name)
    {
        super("ヒト種", name);
    }

    // 【注意】abstract classを継承したabstractでないclassは、まだ実装されていないabstract methodについての実装を書かないといけない！
    // 実装漏れがある場合は「型 Human は継承された抽象メソッド Mammal.doJikoshoukai() を実装する必要があります」とcompile時エラーになる。

    // ★【省エネTIPS】下記の「methodのoverride」は自分では書かないこと！行番号の個所にcompileエラー表示が出たら、それをクリックすると解決策の一覧が表示されるが、
    // 「実装されていないメソッドの追加」という選択肢をダブルクリックすると、自動で
    // public void doJikoshoukai()の実装skeleton（※骨組だけの空実装のことをskeletonと呼ぶ）が作成されるので、
    // その実装に手を加えるのが省エネな実装方法である！！
    /**
     * {@inheritDoc}
     */
    @Override
    public void doJikoshoukai()
    {
        String jikoshoukai = "オッス！オラ、" + name + "！" + moku + ka + zoku + shu + "、ようするにニンゲンだ！";
        System.out.println(jikoshoukai); // Ecipseの場合は「System.out.println();」はsysoと打ってctrl+spaceで補完して書くこと！
    }
}

//***** 説明しよう！！【※1.抽象classと抽象method】 *****
// ０）概論
// Javaでは、いくつかの処理間で「共通な部分」があれば、それをmethod切り出しして、それを呼び出すことで
// 同じ処理の繰り返し実装（コピペ実装）をなくすことができる。
// それと同じ話で、いくつかのclass間で「共通な部分」があれば、それを抽出して親classとしてまとめて、それを継承することで
// 同じ処理の繰り返し実装（コピペ実装）をなくすことができる。※親classという名前だとピンとこないのなら共通classと言い換えても良い。
// classは「属性」（field）と「操作」（method）から構成されるが、共通のfieldと共通のmethodは親classに持たせる、ということである。
// その中身（「値そのもの」や「処理そのもの」）も全く共通ならば、それだけで済むが、大枠は共通だけど中身は違うという場合は
// 子classの方で「親のfieldに子class固有の値を代入」したり「親のmethodに子class固有の処理を代入」したりするための機構が必要になる。
// fieldの方は、instance生成時に設定すれば良いという話（つまり、①親classにfieldを定義し、②親classに「（子class用に）fieldを初期化
// するためのconstructor」を用意しておいて、③子classのconstructorでそれを呼び出す、ことで実現できる）であり、
// methodの方は、直接「method」（処理）を代入するという方法はJavaの言語仕様にはない（・・従来はなかったのだが、Java1.8からはFunction class（関数class）
// が追加されて、それが可能になった。とりあえずこの話題についてはかなり高度なので今後の学習内容として、今は気にしなくてよい）が、
// overrideという仕様でmethodを上書き実装することはできるので、それを使えば良いという話（つまり、①親classの共通methodの中で
// 「子class固有のmethodを呼び出す」ように実装しておき、②親classに「（子class用に）overrideしてもらうためのmethod」を用意しておいて、
// ③子classでそのmethodをoverrideして子class固有処理をここに実装する、ことで実現できる）である。
// このときに「（子class用に）overrideしてもらうためのmethod」を『未実装』にしておくことで、子classに実装させる（＝overrideさせる）ことを
// 言語仕様レベルで『強制』させることができる（つまり実装しないとcompile時エラーとなる）というのが【今回の学習内容のミソ】である。
// →親classで「overrideしてもらうためのmethod」を仮実装してしまうと、子classでoverrideをし忘れた場合にその仮実装が実行されてしまうので、実装漏れに気付けない（error-proneである）！
// →『未実装』と言っても空の実装（{}という実装）を行うのとは話が違うことに注意！中括弧も付けずに、例えば「String createStringMethod(int numLetters);」
//   という風に定義するのである。これはこのままでは文法エラーなのでcompile時エラーとなってしまうが、戻り値の前にabstractというキーワードを
//   加えて「abstract String createStringMethod(int numLetters);」とすれば、これは抽象methodとしてみなされ、文法エラーは解消される。
// このようなmethodのことを抽象methodと言い、抽象methodは実装がないため、抽象methodを持つclassは不完全なclassとなるため
// instance化ができなくなる（このclassをinstance化して抽象methodを呼び出したときの挙動はどうなるかを考えると納得できる話である）。
// このような不完全なclassを「抽象class」（abstract class）と呼び、class定義時にabstractキーワードを付与する必要がある（付与しないとcompile時エラー）。
// つまり、いくつかのclassでの処理の中にある共通部分をまとめたいときには、
// ・固有処理部分をabstract methodとして定義し、
// ・共通処理部分はそのまま実装しつつ固有処理部分はそのabstract methodを呼び出すようなmethodを定義した、
// abstractな親class（共通class）を作成する、ということになる
// （※これを「method切り出し」に対応させて仮に「class切り出し」と呼ぶようにすれば、イメージが掴みやすいかと思う）。
// このように、classの継承関係で得られる利点から、親classはabstractになる例が殆どである。
//
// １）抽象class（abstract class）について
//     ・定義方法：classを抽象化（abstract化）するには、定義時にclassの前にabstract修飾子を付与するだけ！
//       →Program01.javaで、classは[アクセス修飾子] [その他の修飾子] class [class名]というフォーマットで定義することを学んだが、[その他の修飾子]の所にabstractと書けばよい。
//     ・【重要】abstract classはinstance化できない。実装が足りてない可能性があるclassはinstance化させるわけにはいかないので、これは考えてみれば当然のこと！
//
// ２）抽象method（abstract method）について
//     ・abstract classは普通のmethodの他に「abstract method」なるmethodも定義できる。
//       →Program01.javaで、methodは[アクセス修飾子] [その他の修飾子] [戻り値の型] [method名] [引数列] { [methodの実装] }というフォーマットで定義するすることを学んだが、[その他の修飾子]の所にabstractと書けばよい。
//     ・これは子classに「実装を任せたい場合」、さらに言えば「実装を強制したい場合」に使う（→課題で扱うので、その課題を通して使い所を実感してみて欲しい）。
// 　　・abstract classを継承（extends）した非abstractなclassは、まだ実装されていないabstract methodを実装する義務がある（しないとcompile時エラー）。
// 　　　つまり、abstract classであるClassAを継承したabstractなClassBを継承した非abstractなClassCがあったときに、
// 　　　ClassAに３つのabstract methodがあり、その内の２つはClassBで実装された場合は、ClassCでは残り１つについてだけ実装の義務が残る。
// 　　　ただし、ClassBでさらに１つのabstract methodが定義された場合は、ClassCではこの分についても実装の義務が発生するので、この場合は２つについて実装の義務がある。



/* 【課題】=====================================================================
これはclassの継承について復習する課題である。

--------------------
【課題１】
--------------------
Program04Kadai1.javaというソースファイルを作成し、下記をコピペし、
Program04Kadai1 classのmain methodがちゃんと動作するように、下記のclassをProgram04Kadai1.javaに定義せよ。
１）Mammalを継承する、食肉目を表すclass（class名は「Carnivora」）
２）Carnivoraを継承する、クマ科を表すclass（class名は「Ursidae」）
３）Ursidaeを継承する、ジャイアントパンダ属を表すclass（class名は「Ailuropoda」）
４）Ailuropodaを継承する、ジャイアントパンダ種を表すclass（class名は「GiantPanda」）

戻り値の期待値は下記のmain methodで各method呼び出しを行ってる行の行末の１行コメントに記載してあるので、
その通りになるようにAccessCounter classを実装すること。

※つまり、Program04.javaでは「哺乳綱霊長目ヒト科ヒト属ヒト種」の個体を作成して自己紹介させたが、
　この課題では「哺乳綱食肉目クマ科ジャイアントパンダ属ジャイアントパンダ種」の個体を作成して自己紹介させたいのである。

package study1.chapter1.unit4;

public class Program04Kadai1
{
    public static void main(String[] args)
    {
        Mammal panda = new GiantPanda("リンリン");
        panda.sleep(); // ぐーすーぴー。
        panda.doJikoshoukai(); // ボク・・リンリンだぱんっ！食肉目クマ科ジャイアントパンダ属ジャイアントパンダ種のパンダだよ・・。

        new GiantPanda("リーリー").doJikoshoukai(); // ボク・・リーリーだぱんっ！食肉目クマ科ジャイアントパンダ属ジャイアントパンダ種のパンダだよ・・。
    }
}


--------------------
【課題１‐類題１】
--------------------
Program04Kadai1Ruidai1.javaというソースファイルを作成し、下記をコピペし、
Program04Kadai1Ruidai1 classのmain methodがちゃんと動作するように、下記の階層構造を持つclassをProgram04Kadai1Ruidai1.javaに定義せよ。
綱：哺乳綱＞目：鰭脚類（ききゃくるい）（Pinnipedia）＞科：アシカ科（Otariidae）＞属：アシカ属（Zalophus）＞種：カリフォルニアアシカ種（California sea lion）

package study1.chapter1.unit4;

public class Program04Kadai1Ruidai1
{
    public static void main(String[] args)
    {
        Mammal panda = new CaliforniaSeaLion("キュッキュ");
        panda.sleep(); // キュッキュッ・・。
        panda.doJikoshoukai(); // キュッキュッキュッ・・キュッキュだキュッ！鰭脚類アシカ科アシカ属カリフォルニアアシカ種なんだキュッ！
    }
}


--------------------
【課題２】
--------------------
3種類のオウムがいる。
いずれのオウムも、喋りかけると、こちらの言葉（発声）をオウム返ししてくれるが、オウムの種類によって以下の癖がある。
・トマトオウムという種類のオウムは「あ、い、う、え、お」を「と」に、「か、き、く、け、こ」を「ま」に言いかえる。
・キャベツオウムという種類のオウムは最初の単語だけを抜かす。
・ロマネスコオウムという種類のオウムは各単語を２回ずつ発声しながら喋る。
また、いずれのオウムも、喋り始めるときに、必ず「キュルルッ！」と叫んでから喋り始める。

（問１）
Program04Kadai2Sample.javaは、これらのオウムの応答を出力するソースコードである（回答作成時にclass名が被らないようにコメントアウトしてある）。
このコードには『「オウムの共通処理」が「各種オウムの固有処理」に混ざり込んでしまっている』という欠点がある。
そこで、オウムという親classを作り、各種オウムはその子classとし、親classに「オウムの共通処理」を、子classに「各種オウムの固有処理」を
振り分けて持たせ、コードの拡張性を高めたい。

Program04Kadai2.javaというソースファイルを作成し、下記をコピペし、
Program04Kadai2 classのmain methodがちゃんと動作するように、
１）オウムclass（Parrot）の未実装部分を実装せよ。
２）オウムclassの子classとして「トマトオウムを表すclass」、「キャベツオウムを表すclass」、「ロマネスコオウムを表すclass」を定義せよ。


public class Program04Kadai2
{
    public static void main(String[] args)
    {
        // ＜問１＞
        System.out.println("＜問１＞");

        // 各オウムの個体を作成する
        Parrot parrotT = new TomatoParrot();
        Parrot parrotC = new CabbageParrot();
        Parrot parrotR = new RomanescoParrot();

        // オウムに声をかけて、その応答を出力する
        String call = "ありがとう";
        System.out.println("*** 「" + call + "」と声をかけたときの応答 ***");
        System.out.println("トマトオウムの応答：" + parrotT.reply(call)); // トマトオウムの応答：キュルルッ！とりがとと
        System.out.println("キャベツオウムの応答：" + parrotC.reply(call)); // キャベツオウムの応答：キュルルッ！りがとう
        System.out.println("ロマネスコオウムの応答：" + parrotR.reply(call)); // ロマネスコオウムの応答：キュルルッ！あありりががととうう

        call = "ぼくはおにぎりがすきなんだな";
        System.out.println("*** 「" + call + "」と声をかけたときの応答 ***");
        System.out.println("トマトオウムの応答：" + parrotT.reply(call)); // トマトオウムの応答：キュルルッ！ぼまはとにぎりがすまなんだな
        System.out.println("キャベツオウムの応答：" + parrotC.reply(call)); // キャベツオウムの応答：キュルルッ！くはおにぎりがすきなんだな
        System.out.println("ロマネスコオウムの応答：" + parrotR.reply(call)); // ロマネスコオウムの応答：キュルルッ！ぼぼくくははおおににぎぎりりががすすききななんんだだなな
    }
}

abstract class Parrot // abstract methodを定義したいので、abstract classにする！
{
    public String reply(String words)
    {
        // TODO ここに実装すること
    }

    abstract String replySub(String words); // ※これは各オウムclassに実装を任せたいのでabstract methodとして定義する！
}


（問２）
Program04Kadai2Sample.javaのコードのメンテナンス性・拡張性を高めるためにProgram04Kadai2.javaに修正（refactoring）したが、
「メンテナンス性が高まった」、「拡張性が高まった」ということを、以下の具体例で説明せよ。
・「いずれのオウムも、喋り始めるときに、必ず「キュルルッ！」と叫んでから喋り始める。」ではなく、
  「いずれのオウムも、喋り始めるときに、半々の確率で「キュルルッ！」または「加トちゃんペッ！」と叫んでから喋り始める。」が正しかったので
  そのように修正しなければならなくなった。
・他にも「ニンジンオウム」、「ダイコンオウム」、「ゴボウオウム」、「ナスビオウム」、「カイワレオウム」なども扱うことになったので
  これらのclassも追加定義しなければならなくなった。


（問３）
（問１）のProgram04Kadai2.javaのmain methodの実装に、下記の追記を加えた場合でも、
main methodがちゃんと動作するように、適切にオウムや各種オウムのclassを修正せよ。

１）下記コードをmain methodに追記する：
        // ＜問３＞
        System.out.println("\n＜問３＞");
        int quantity = 10;
        System.out.println(quantity + "羽のオウムを仕入れての実験：");

        for (Parrot parrot : getParrots(quantity))
        {
            System.out.println(parrot.getSpecies() + "の応答：" + parrot.reply("あべしひでぶたわば"));
            // 下記がランダムで10行だけ表示される：
            // トマトオウムの応答：キュルルッ！とべしひでぶたわば
            // キャベツオウムの応答：キュルルッ！べしひでぶたわば
            // ロマネスコオウムの応答：キュルルッ！ああべべししひひででぶぶたたわわばば
        }

２）下記「オウムを希望の個数だけ仕入れる」methodの定義をProgram04Kadai2 classに追記する：
    private static List<Parrot> getParrots(int patrrotsNum)
    {
        List<Parrot> parrots = new ArrayList<>();
        for (int i = 0; i < patrrotsNum; i++)
        {
            Parrot parrot;
            int rand = (int)(Math.random() * 10); // 優先順位注意：castは*よりも評価の優先度が高いため(int)Math.random() * 10だと「(int)Math.random()」の評価結果に対して10をかける、という意味になってしまう
            switch (rand % 3)
            {
            case 0:
                parrot = new TomatoParrot();
                break;
            case 1:
                parrot = new CabbageParrot();
                break;
            case 2:
                parrot = new RomanescoParrot();
                break;
            default:
                throw new IllegalStateException("ここに入ったらバグ！");
            }
            parrots.add(parrot);
        }
        return parrots;
    }

※main methodで使われている「for-each文」は今後学ぶ内容なので、現段階では詳しく分からなくてよいが、
  「『for ([要素の型] [取り出した要素を表す変数名] : [複数のinstanceを詰められるobject])』という形式で、
  対象objectの要素を前から順番に取り出すことができる」ことさえ知っておけば、本問は回答できる。

※getParrots methodで使われている「for文」は今後学ぶ内容なので、現段階では詳しく分からなくてよいが、
  「『for (int i = 0; i < [回数を表す数値]; i++)』という形式で、[回数を表す数値]回分だけ処理を繰り返すことができる」
  ことさえ知っておけば、本問は回答できる。

※getParrots methodで使われている「switch文」は今後学ぶ内容なので、現段階では詳しく分からなくてよいが、
  「『switch ([数値変数])』の[数値変数]で分岐ができ、『case [数値]:』の内で[数値変数]＝[数値]であるcase文が実行される」
  ことさえ知っておけば、本問は回答できる。

※getParrots methodに書かれてる内容（ListやArrayListなど）は今後学ぶ内容なので、現段階では詳しく分からなくてよいが、
  「List<[型]>は、[型]で指定した型のinstanceだけを詰められる入れ物である」ことと
  「add methodでinstanceを要素として追加できる」ことさえ知っておけば、本問は回答できる。


--------------------
【課題３】
--------------------
【課題２】では３種類のオウムについての「オウム返し」をプログラミングしたが、
実は、トマトオウム属に属する種すべてが同じ応答をするわけではないことが判明した。
同様に、キャベツオウム属に属する種すべてが同じ応答をするわけではないことも判明した。
そこで、新たに分かった「種固有の応答方法」をプログラムに盛り込んでみたい。

各種オウムに「かけた言葉」に対する「オウム返し」の仕方のまとめ：

・オウム科：「キュルルッ！」と叫んでから喋り始める。

  ・トマトオウム属：「かけた言葉」の「あ、い、う、え、お」を「と」に、「か、き、く、け、こ」を「ま」に言いかえる。
    しかし、同じトマトオウムでも、種によって上記の応答（これを「正規の応答」と呼ぶことにする）をするか「種固有の別の応答」をするかには「種固有の条件」が存在する。
    ・桃太郎トマトオウム種：「かけた言葉が5語以下」（words.length() <= 5）ならオウム返し（正規の応答）するが、それ以外の場合は「とまと・・」と応答
    ・サンマルツァーノトマトオウム種：「かけた言葉が10語以上」（words.length() >= 10）ならオウム返し（正規の応答）するが、それ以外の場合は「まえからよんでもうしろからとまと」と応答
    ・フィオレンティーノトマトオウム種：「かけた言葉に「と」か「ま」が含まれている」（words.matches(".*[とま].*")）ならオウム返し（正規の応答）するが、それ以外の場合は各語の間に「と」を挟んで応答（String.join("と", words.split(""))）

  ・キャベツオウム属：「かけた言葉」の最初の単語だけを抜かす。
    さらに加えて、同じキャベツオウムでも、種によって「その後の処理」が異なる。
    ・グリーンボールキャベツオウム種：特に種固有の特徴なし
    ・サボイキャベツオウム種：50%（(int)(Math.random() * 10) % 2 == 0）の確率で逆順に発声する（new StringBuilder(words).reverse().toString()）

  ・ロマネスコオウム属：「かけた言葉」の各単語を２回ずつ発声しながら喋る。


同じpackage内だと【課題２】で作成したclassと名前が衝突するので、この下にsub1というpackageを作成し、
Program04Kadai3.javaというソースファイルを作成し、下記をコピペし、
Program04Kadai3 classのmain methodがちゃんと動作するように、
１）オウムclass（Parrot）をProgram04Kadai2.javaからコピペせよ。
２）オウムclassの子classとして「トマトオウムを表すclass」、「キャベツオウムを表すclass」、「ロマネスコオウムを表すclass」を
    Program04Kadai2.javaからコピペして来て、必要なclassについては抽象classに変更して実装を修正せよ。
    ※ヒント：必要かどうかの判断基準は『「これらの下に子classを作成する必要があり、かつ、その子classに固有の処理がある」かどうか』。
３）新しく「桃太郎トマトオウムを表すclass」、「サンマルツァーノトマトオウムを表すclass」、「フィオレンティーノトマトオウムを表すclass」
    「グリーンボールキャベツを表すclass」、「サボイキャベツオウムを表すclass」を定義せよ。
※プログラムの鉄則「class固有の処理はそのclassで行う」に則り、親class固有の処理は親classで行い、子class固有の処理は子classで行うこと！
  つまり、親class固有の処理まで子classに実装しないようにすること！メンテナンス性・拡張性が高いコードを意識して書きましょう。


package study1.chapter1.unit4.sub1;

import java.util.ArrayList;
import java.util.List;

public class Program04Kadai3
{
    public static void main(String[] args)
    {
        int quantity = 10;
        System.out.println(quantity + "羽のオウムを仕入れての実験：");

        String call = "ありがとう";
        System.out.println("\n*** 「" + call + "」と声をかけたときの応答 ***");
        for (Parrot parrot : getParrots(quantity))
        {
            System.out.println(parrot.getSpecies() + "の応答：" + parrot.reply(call));
            // 下記がランダムで10行だけ表示される：
            // 桃太郎トマトオウムの応答：キュルルッ！とりがとと
            // サンマルツァーノトマトオウムの応答：キュルルッ！まえからよんでもうしろからとまと
            // フィオレンティーノトマトオウムの応答：キュルルッ！とりがとと
            // グリーンボールキャベツオウムの応答：キュルルッ！りがとう
            // サボイキャベツオウムの応答：キュルルッ！りがとう
            // サボイキャベツオウムの応答：キュルルッ！うとがり
            // ロマネスコオウムの応答：キュルルッ！あありりががととうう
        }

        call = "すりじゃやわるだなぷらこって";
        System.out.println("\n*** 「" + call + "」と声をかけたときの応答 ***");
        for (Parrot parrot : getParrots(quantity))
        {
            System.out.println(parrot.getSpecies() + "の応答：" + parrot.reply(call));
            // 下記がランダムで10行だけ表示される：
            // 桃太郎トマトオウムの応答：キュルルッ！とまと・・
            // サンマルツァーノトマトオウムの応答：キュルルッ！すりじゃやわるだなぷらまって
            // フィオレンティーノトマトオウムの応答：キュルルッ！すとりとじとゃとやとわとるとだとなとぷとらとことっとて
            // グリーンボールキャベツオウムの応答：キュルルッ！りじゃやわるだなぷらこって
            // サボイキャベツオウムの応答：キュルルッ！りじゃやわるだなぷらこって
            // サボイキャベツオウムの応答：キュルルッ！てっこらぷなだるわやゃじり
            // ロマネスコオウムの応答：キュルルッ！すすりりじじゃゃややわわるるだだななぷぷららここっってて
        }
    }

    // オウムを希望の個数だけ仕入れる。
    private static List<Parrot> getParrots(int patrrotsNum)
    {
        List<Parrot> parrots = new ArrayList<>();
        for (int i = 0; i < patrrotsNum; i++)
        {
            Parrot parrot;
            int rand = (int)(Math.random() * 10); // 優先順位注意：castは*よりも評価の優先度が高いため(int)Math.random() * 10だと「(int)Math.random()」の評価結果に対して10をかける、という意味になってしまう
            switch (rand % 3)
            {
            case 0:
                parrot = getTomatoParrot();
                break;
            case 1:
                parrot = getCabbageParrot();
                break;
            case 2:
                parrot = new RomanescoParrot();
                break;
            default:
                throw new IllegalStateException("ここに入ったらバグ！");
            }
            parrots.add(parrot);
        }
        return parrots;
    }

    //トマトオウムを仕入れる。
    private static TomatoParrot getTomatoParrot()
    {
        int rand = (int)(Math.random() * 10);
        switch (rand % 3)
        {
        case 0:
            return new MomotarouTomatoParrot();
        case 1:
            return new SanMarzanoTomatoParrot();
        case 2:
            return new FiorentinoTomatoParrot();
        default:
            throw new IllegalStateException("ここに入ったらバグ！");
        }
    }

    // キャベツオウムを仕入れる。
    private static CabbageParrot getCabbageParrot()
    {
        int rand = (int)(Math.random() * 10);
        switch (rand % 2)
        {
        case 0:
            return new CannonballCabbage();
        case 1:
            return new SavoyCabbageParrot();
        default:
            throw new IllegalStateException("ここに入ったらバグ！");
        }
    }
}
*/