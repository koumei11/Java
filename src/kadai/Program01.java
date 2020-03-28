/*
 * 下記の説明のためのソースコード。
 * １）コメントの書き方
 * ２）package宣言
 * ３）classの定義
 * ４）class変数（class field）
 * ５）instance変数（instance field）
 * ６）class method
 * ７）instance method
 * ※因みにfieldとmethodを合わせてclassの「member」または「property」と総称する
 * （どちらも、そのclassの構成部品、という意味合いを持つので）。
 */

// ***** 説明しよう！！【※0.projectについて】 *****
// ・すべては最初に「java projectを作成する」所から始まります。
// ・このjava projectはEclipseの場合は
// 1A）「ファイル」タブ→「新規」→「Java プロジェクト」
// または
// 1B）パッケージ・エクスプローラやプロジェクト・エクスプローラの何もない場所を右クリック→「新規」→「プロジェクト」→「Java プロジェクト」
// をやると、ダイアログが開くので、そこで
// 2）プロジェクト名（※特に命名規則や慣習はないが日本語とかはやめておくのが無難）を記入
// 3）使用するJREを選択（→つまり、どのversionのJavaを使うのかを選択。基本は最新のを使うのがlibraryも充実してるので良い！JVMも進化してるので、最新になるほど処理が速いし。）
// 4）その他の細かい設定が不要ならば「完了」ボタンを押す（※後から、作成したprojectを右クリックして「プロパティー」から設定を色々と変更できる）
// という手順で作れます。
// 最初にprojectを作ってしまえば、後はその中にpackageやclassをどんどん追加していくだけ！
// →※ここで「Maven プロジェクト」や「Gradle プロジェクト」を選択するとMavenやGradleが使えるprojectを作成できる（発展事項なので現時点では気にしないこと！またの機会に説明する）
// ・基本的には、この「projectという単位」が「applicationの単位」になります（なぜならば、「compileの単位＝project単位」だから！）。
//   つまり、windowsツールを１つ作成したい場合は、それで１つのprojectを作成し、
//   さらに、web application（ECサイトなど）を１つ作成したいとなれば、また別に１つのprojectを作成することになる。
//   今回作成したprojectは「授業と課題用」のprojectである。
// →※数年前から出て来た「Micro Service」という考え方は、１つのサービスを複数の単位で作って別個にcompileできるようにした方が
//   実用的ではないか（releaseしたい機能のprojectだけを修正→compile→差し替え、ができるので、管理が楽）
//   というもので、この考え方で作る場合は、１つのapplicationを複数のprojectで作成することになる（実際には、かな～りコード量が増えるので、後々の管理は楽かもしれないが製造はキツい・・）。
// ・OSのフォルダ・システム上では、projectはフォルダとして作成される。Eclipseでprojectを作成した場合には
//   このフォルダに「.project」というファイルが作成されるが、このファイルが置かれたフォルダをEclipseはprojectとみなしている、というカラクリである。

// コメント方法は３タイプ。これは「１行コメント」。
// Eclipseの場合「ctrl+/」で対象行をコメントアウトしましょう（複数行選択して一気にコメントアウト可能）。

/*
これは「複数行コメント」。
開始から終了までの間、何行書いても、コメント扱いになる。
*/

/**
これは「javadocコメント」という特別なコメント。classやmember（fieldとmethod）に対しての説明を書く場合にのみ使用すること。
javadocを生成したときにこのコメントが採用される（Eclipseの場合は対象classやmemberの名前をcursor hoverすると表示される）。
「@author」など色んな注釈が用意されている（Eclipseの場合、javadocコメント内でctrl+spaceで一覧が表示される）。
 */
package kadai;
// package study1.chapter1.unit1; // package宣言。このclassの所属するpackage名（このsource fileの所属するfolder名）を、コードの先頭に記載する必要がある。
// ・つまり、同一フォルダにあるソースファイルはすべて同一のpackageに所属するということになり、後述のアクセス修飾子の
// 「無指定」や「protected」で参照範囲限定されたmemberを参照することが可能ということでもある。
// ・folder名と異なるpackage名にするとcompile時エラー。
// ・因みにpackageの存在意義は『class名の衝突を防ぐ』ことである。プログラミングには『名前空間』（namespace）という概念があるが、
// class名はpackage毎に名前空間が分かれるので、同じpackage内に同じ名前のclassを作成することはできない（同じ名前空間内には同一の名前を
// 持つ物は存在できず、名前の衝突が起きる）が、別のpackageになら、同一の名前のclassを作成しても問題は起こらない。
// →C言語にはこの名前空間を管理する機能が提供されていないため、大企業の大きなシステムであってもその中でたった１つの同一の名前を持つ関数や
// 構造体でも存在したらcompile時エラーになってしまうのだ。そのため必ず名前が一意となるように命名規則や管理台帳を作って対処する、
// ということをやっており、そのために関数や構造体の名前は物凄く長いものになってしまう。
// →Javaの場合も、package名とclass名のどちらも被ってしまう事態が発生した場合はcompile時エラーとなるが、Javaの場合は名前空間を制御するpackageは
// ソースファイルのdirectory構造を表現する機能を兼ねているため、（OSの都合上、同一名を持つファイルを同一のdirectoryには作成できないことから）
// 起こりえないと考えてしまいがちであるが、jar化（※jar（Java Archive）ファイルとはzip圧縮された、javaのclassファイルなどのresource群のこと）
// されたソースコードをlibraryとして使用したときには（同じdirectory構造をjar内部で持つことは可能なので）起こり得るため、packageの命名規則として
// 「自身の所有しているインターネットドメイン名（FQDN）を各レベルに分割して順序を逆にしたものをパッケージ名に使用する」ことが推奨されている。
// これならば世界的に一意なパッケージ名になるというわけである。企業のシステムの場合は大抵この命名規則が採用されているが、個人でプライベートで
// 作成するプログラムならばこれに従わなくても害はないだろう。
// https://docs.oracle.com/javase/specs/jls/se13/html/jls-6.html#jls-6.1 の「Example 6.1-1. Unique Package Names」

// ***** 説明しよう！！【※1.package、class、method共通の命名規則】 *****
// package名、class名、各種変数名に共通する命名規則について、まず最初に説明しておこう！
// 下記はNG。
// (1)Javaの予約語（public、class、int、if、forなど）と同一の名前。※一覧：https://ja.wikipedia.org/wiki/%E3%82%AD%E3%83%BC%E3%83%AF%E3%83%BC%E3%83%89_(Java)
// (2)「数字」または「半角/全角のunderscore以外の半角/全角の記号」から始まる名前。
// (3)「_（半角underscore）または＿（全角underscore）」以外の半角記号を使った名前。
// →つまり、日本語も名前に使えるのだ！でも予期しない不具合が起こる可能性を考えて、使わないのが一般的。
// compile時エラーにならない例：_ok、＿ok、ok、ok123、OK_BOKUJYOU、ＯＫ＿牧場１２３、publics、_public
// compile時エラーになる例：123、123ng、１２３、１２３ng、ng!、n*g、NG?、★ＮＧだじょ、public

/**
 * 下記を解説するためのclass。
 * １）classの定義方法。
 * ２）fieldの定義方法。
 *     - 「class field」（※static修飾子が付与されたfield）と「instance field」（※static修飾子が付与されていないfield）の宣言と代入の書き方。
 * ３）methodの定義方法。
 *     - 「コンストラクタ」（Constructor）というclassのinstanceを作成するための特殊なmethodの定義方法。
 *     - 「メインメソッド」（main method）という、Javaクラスが実行されたときに最初に呼ばれる特殊なmethodの定義方法。
 *     - 上記以外のmethod（いわゆる、普通のmethod）の定義方法
 * @author wombat
 * @since 2020/01/29
 */
/* ----- classの定義 ----- */
public class Program01 // Program01という名前のpublicなclassを定義する文法。

// ***** 説明しよう！！【※2.class定義】 *****
// ・classとは「オブジェクト指向」で『モノの概要を「属性」と「操作」という２つの観点で表した構造物』である。
// →「属性」はfieldとして、「操作」はmethodとして表現している。
//   例：「人間」は「名前、年齢、性別」を持っていて、「喋る、寝る」ことができるので、「人間」は「名前、年齢、性別」というfieldを持たせ、「喋る、寝る」というmethodを持たせたclassとして表現できる。

// ・classの定義方法：
// 0. まずはpackage宣言（どのpackageに所属しているか）を行う。default package（projectのソースフォルダ直下）に作成（→悪い慣習！）した場合にのみpackage宣言は不要。
//    次に、libraryを使う場合は、そのlibraryをimportする（またの機会に説明する）
// 1. 『[アクセス修飾子] [その他の修飾子] class [class名]』の構文で定義すること。
// 2. classに付けられるアクセス修飾子（access modifier）は、public、無指定、の２種類のみ。Eclipseの場合はこれ以外を指定するとcompile時エラーとなるので、すぐにミスが分かる。

// ●Javaの【アクセス修飾子】（access modifier）（全４種類）を強制力のゆるい順番に紹介：
// public：外部のどのclassからでも参照可能。「外部公開されたインタフェース」というイメージ（ここで言うインタフェースとは広義の意味でのもの（接合面、接続面）であり、Javaのinterfaceのことではない）。
// protected：同一packageの他classのほか、子class（継承関係で繋がってるいわゆる子孫のclass）からも参照可能。
// 無指定：同一packageの他classからも参照可能。※「package-private」という呼び方をされる。
// 他classから参照不可能。
// ※特殊な例：同じファイルに複数のclassを定義した場合は、private以外は、同じファイルに定義した他classからでも参照可能。

// 3.classに付けられるその他修飾子はabstract、final、strictfpのみ。これらについては別の機会に解説する。
// 4.１つのファイルに定義できるpublicなclassは１つだけ（逆に最低１つは定義しないといけない）！！複数定義するとcompile時エラー。
// 5.対象ファイル名とそこに定義するpublicなclassの名前は一致させないとコンパイル時エラー。
// 6.publicでないclass（つまり無指定のclass）は何個でも定義が許されてるが、原則的にこれはやってはダメ（classがどのファイルに定義されてるのか分からなくなり管理できないので）。
// 7.classの中にclassを定義可能。これは内部class（innner class）と言うが、これについては別の機会に解説する。
// 8.規則上の制限はないが、慣習的にclass名は『「大文字」から始め、複数の単語から成る場合はそれぞれの頭文字を大文字にしたcamel case』
//   （ラクダのコブみたいなことからこう呼ばれる）で書く。先頭だけは英字であることが必須（でないとcompile時エラー）。
// 8.直後の中括弧（{と}）の中にこのclassのmemberを定義する。
{
    /* ----- class fieldの定義 ----- */
    // class fieldとは、このclassがclass単位で持っているfieldのこと。static修飾子を付けることでclass fieldとなる。
    private static String field1; // field1という名前のprivateなclass fieldをString型で「宣言」する。
//    private static final String field2; // これはcompile error:「ブランクの final フィールド field2 は初期化されていない可能性があります」
    private static final String field2 = "abeshi"; // field2という名前のprivateでfinalなclass fieldをString型で「宣言」と同時に「初期化」する。
    public static int field3; // field3という名前のpublicなclass fieldをint型で「宣言」する。
    public static final int FIELD_4 = 1234567890; // FIELD_4という名前のpublicでfinalなclass fieldをint型で「宣言」と同時に「初期化」する。
    // ※finalという修飾子を付けると「値の変更が不可能」になる。つまりそのfieldは「定数」という意味を持つことになる
    // （しかし【※2.field定義】で後述するが、一般的にはstatic finalでないとプログラム的に「定数」とは言えない）。

    /* ----- instance fieldの定義 ----- */
    // class fieldとは、このclassのinstance単位で持っているfieldのこと。static修飾子を付けないことでinstance fieldとなる。
    private String field5; // field5という名前のprivateなinstance fieldをString型で「宣言」する。
    public int field6; // field3という名前のpublicなinstance fieldをint型で「宣言」する。

    // ***** 説明しよう！！【※3.field定義】 *****
    // fieldとは、そのclassが持っている「属性」である！！例えば「人間」は「名前、職業、趣味」を持つことができるので、これらはfieldとして定義ができるということになる。
    // ・fieldの定義方法：
    // 1.『[アクセス修飾子] [その他の修飾子] [型] [field名]』の構文で定義すること。
    // 2.fieldにはJavaで用意されてる全４種類のアクセス修飾子（access modifier）が使える。
    // 3.その他の修飾子には、static、final、abstract、native、synchronized、transient、volatileが付与可能。
    //   staticを付けるとそのfieldはclass fieldに、付けなければinstance fieldとなる。これらの違いについてはProgram02で説明する。
    //   finalを付けると、そのfieldの値を変更不可能にすることができる。なので、finalなfieldは「宣言と同時に初期化（初期値の設定）」をしないとcompile時エラー
    //   （但し、instance fieldについては後述の「constructor」で初期化を行う記述があればcompile時エラーにはならない。
    //   これはinstance fieldは遅くてもinstance生成時に決定されればよいという性格のものであることを考えると、納得がいく仕様である）。
    //   finalにすれば安心というわけではなく、変更可能なObjectを型に持つfinalなfieldの場合はそのObjectの内部構造を変更できてしまうことに注意（別の機会に解説する）！
    //   ここでは「primitiveまたは変更不可能なオブジェクト（immutable object）」のfieldにfinal修飾子を付ければ、変更されることはない、とだけ覚えておこう（意味は別の機会に解説する）。
    //   また、特に（広義の意味での）「定数」と言ったら「staticでfinal」なfieldを指す。なぜならばstaticでないfieldはinstance field（instanceの数だけ存在するfield）だからである。
    //   finalなinstance fieldに同一の値を与えて「ほら、どのinstanceを見ても同じ値だし変更できないから、staticでないけどこれはまさに定数だよね？」というのは屁理屈である。
    //   確かに定数という定義は満たしてるが、プログラムではそんな「意味のないこと」はやらないのである。
    //   さらに、一般的に「定数」と言われたら、狭義の意味での定数を意味し「public static final」なfieldを指し、特別に『すべて「大文字」で書き、
    //   複数の単語から成る場合はそれぞれの単語を_（アンダースコア）で連結したsnake case』（ヘビみたいなことからこう呼ばれる）で書く。
    //   システム共通の定数はpublicとしsnake caseで書き、あるクラス内だけで共通の定数はprivateとして外部から隠ぺいする、という使い分けをする。
    //   ※staticとfinal以外の修飾子については別の機会に解説する。
    // 4.Javaには３種類の変数がある。
    //   (1)class field変数：staticなfield。class単位で保持するので、同じclassのどのinstanceでも同じ値となる。変数の参照可能範囲（scope）は、自class内全体で、さらに、アクセス修飾子次第で外部にまで及ぶ。
    //   (2)instance field変数：非staticなfield。instance単位で保持するので、同じclassのinstanceであってもinstance毎に保持する値は同一とは限らない。変数のscopeはclass field変数と同じ。
    //   (3)local変数(local variable)：methodの内部で宣言した変数。変数のscope は宣言された行以降～そのmethodの定義の終わりの行まで。
    //   C言語のようなオブジェクト指向でない言語の場合は、すべての変数は(3)のように宣言された以降の行でしか有効でないため、
    //   そのソースファイル内で利用するすべての変数をファイルの冒頭で一気に宣言する慣習があり、C言語上がりのプログラマは(3)の場合に
    //   同じようにmethodの冒頭で一気に宣言することがあるが、これは無駄に変数のscopeを広げてしまう悪手である！！
    //   『変数のscopeは小さいほど良い』、『変数は使う直前で宣言する』という原則は最重要事項なので、これらをいつも意識してプログラムを書くこと！！
    //   →[Q]scopeが広いのはなぜ悪い？
    //   →[A]コードを解読する立場になってみよう。宣言された直後からmethodが終わるまでずっとその変数のことを頭の片隅に置きながら
    //   さて、宣言されたわけだが、どこで使われるのだろうか、今使われたけどまだ使われるのだろうか、おっと、ここで値が変更された、次に使われるときは新しい値だよ・・と、
    //   で次はどこで使われるのだろうか・・と追っていくハメになるのだ。
    //   これが2～3個ならいいが、5～6個あたりからすでに頭がパンクしてこないだろうか？『プログラムは、書くのはたった１回だけだが、
    //   読まれるのは何十回あるか分からない』ということを考えれば、如何に『可読性の高さ』が重要事項であるかが分かるだろう。
    //   当然『可読性の高いコード＝bugが発見しやすいコード＝（保守時や機能追加時に）bugが埋め込まれる可能性の低いコード』である。
    //   因みに変数のscopeを小さくする手法はいくつかある。代表的なものは「while loopよりもfor loopを使う」や「method切り出し」である。
    //   for loopの場合は、loop変数のscopeをfor loop内に限定することができるし、method切り出しをすれば、変数を切り出したmethod内に限定することができる。
    //   methodは「１method＝１機能」という粒度が原則で、これに則るとおのずと変数のscopeを小さくできる。しかし何事もそうだがやり過ぎは禁物。
    //   余りにも細かい粒度でmethod分割をすると、methodのnest（階層構造）が深くなり過ぎて、何やってるのか追うのが大変になり可読性が著しく損なわれるという本末転倒になりかねない。
    //   また、method間を引数で受け継ぐのが本来の姿である性質のデータを、面倒だからということで「(2)instance field変数」に持たせるのは
    //   物凄い悪手（anti-pattern）である！！これをやってしまうと一気にその変数のscopeがそのclass内全域にまで広がってしまう。
    //   fieldに定義するものは、そのclassの性質となるものだけであり、単にmethod間でのデータのやり取りで楽したいというだけで、余計なデータをfieldとして持たせるべきではないのだ。
    // 5.「宣言」と「初期化」について：
    //   ・宣言とは、型と変数名を書くことで、コンピュータのメモリ上にその型のデータを保持できるだけのサイズの領域を確保させる行為である。
    //   ・初期化とは、その変数に指定の型のデータを代入する式を書くことで、実際に確保されたメモリにデータを格納させる行為である。
    //   ・宣言と初期化は別々に行っても良いし、同時に行っても良い。
    //     一般的には「if文またはswitch文による条件分岐で初期化する場合→別々に行う」、「それ以外の場合→分ける必要性がないので同時に行う」（別の機会に解説するが、collectionやmapの場合は同時に行う）。
    //   ・【重要】field変数の場合は、宣言しただけで暗黙的に「ゼロ値」（zero value）で初期化される、というlocal変数にはない特徴があることを覚えておこう！
    //     ここで言う「ゼロ値」とは、基本型の場合は下記で、参照型の場合はnullのことである。
    //     boolean型：false、char型：''、byte型/short型/int型/long型：0、float型/double型：0.0
    // 6.field変数とlocal変数（仮引数も含めて）は同一の名前を付けることができる。 ※「仮引数」については別の機会に解説する
    //   この場合はlocal変数がfield変数を隠してしまってる状態になり、単に変数名だけで参照した場合はlocal変数が参照されるが、
    //   「this.field変数名」で参照すればfield変数（class変数、instance変数）が参照でき、「class名.class変数名」だとclass変数が参照できる。
    //   因みにthisとは自instanceへの参照のことであり（現時点では理解できなくて全く構わない）、thisを使ってclass変数にアクセスするのはお作法的には良くない。

    public Program01() // class名と同じ名前を持ち、戻り値を書かない「特殊なmethod」のことをコンストラクタ（Constructor）と言う。
    {
        System.out.println("これは引数を何も受け取らないconstructorで、default constructorと呼ばれる。");
        // ★【省エネTIPS】Ecipseの場合は「System.out.println();」はsysoと打ってctrl+spaceで補完して書くこと！
    }

    public Program01(String s)
    {
        field5 = s;
        System.out.println("これはString型の引数を１個受け取るconstructor。");
    }

    public Program01(int i)
    {
        field6 = i;
        System.out.println("これはint型の引数を１個受け取るconstructor。");
    }

    public Program01(String s, int i)
    {
        field5 = s;
        field6 = i;
        System.out.println("これはString型とint型の引数をそれぞれ１個受け取るconstructor。");
    }

    public static void main(String[] args) // main methodとは、このclassをJavaで実行したときに「最初に実行されるmethod」（エントリーポイント）のこと
    {
        // ★【省エネTIPS】Ecipseの場合は「public static void main(String[] args){...}」は
        // mainと打ってctrl+spaceで補完してEnterを押すことによる自動作成で書くこと！
        // ※補完で表示される一覧の中で１番最初の選択肢が「main - mainメソッド」なので、そのままEnterキーを押せばよい、という理屈である。

        System.out.println("Hello World!");

        new Program01(); // default constructor呼び出し
        new Program01("abeshi"); // String型の引数を１個受け取るconstructor呼び出し（「実引数」に文字列リテラル"abeshi"を渡しての呼び出し）
        new Program01(777); // int型の引数を１個受け取るconstructor呼び出し
        new Program01("abeshi", 777); // String型とint型の引数をそれぞれ１個受け取るconstructor呼び出し

        Program01 program01 = new Program01("abeshi", 777); // 上記と同じくconstructor呼び出しを行いProgram01のinstanceを作成し、さらにそれを左辺のprogram01という変数に代入
        program01.thisIsAPublicInstanceMethod(); // program01という変数に代入されたinstanceに対して、instance method呼び出し
        thisIsAPublicClassMethod("これは引数！"); // class method呼び出し（「実引数」に文字列リテラル"これは引数！"を渡しての呼び出し）
        // ※文字列リテラル（String literal）とはいわゆる「"」と「"」で囲ってソースコードにベタ書きした文字列のこと。
    }

    private void thisIsAPublicInstanceMethod() // instance methodを定義（※static修飾子を付けない場合はinstance methodとなる）
    {
        System.out.println("field5の値は" + field5 + "、field6の値は" + field6);
    }

    private static void thisIsAPublicClassMethod(String s) // class methodを定義（※static修飾子を付けない場合はinstance methodとなる）
    {
        System.out.println("これはString型の引数を１個受け取るmethod。与えられた引数は「" + s + "」。"); // 説明文を標準出力に書き出す（渡された「仮引数」の内容も一緒に）
    }

    // ***** 説明しよう！！【※4.method定義】 *****
    // methodとは、そのclassが可能な「操作」である！！例えば「人間」は「歩く、走る」ことができるので、これらはmethodとして定義ができるということになる。
    // ・methodの定義方法：
    //    [アクセス修飾子] [各種修飾子] [戻り値の型] [method名] [引数列] { [methodの実装] }というフォーマットで定義するのが基本だが、
    //    下記に述べるように、特殊なmethodの場合は、これらの一部を書いてはいけなかったり、書く内容が指定されていたりする。
    // 1. methodは大きく分けて３種類がある。
    // (1)Constructor：classをインスタンス（instance）化するための特殊なmethod。class名と同じ名前を持ち、戻り値を書かない（書くと普通のmethod扱いとなる ←compile時エラーにはならないが紛らわしいのでお作法的にNG）。
    //    引数列の型情報の組み合わせが異なれば、何個でもConstructorを定義することが可能。
    //    １個もConstructorを書かなかった場合は、Compile時に暗黙的に（＝勝手に）publicな「引数なしのConstructor」（つまりdefault constructor）が作成される言語仕様に
    //    なってるため、 default constructor以外のconstructorを書かない場合は、constructor自体を書かないのが正しい。
    //    また、default constructorのアクセス修飾子をprivateとすることで外部からinstance化させないようにするというテクニックもある（別の機会に解説する）。
    //    （java.loang.Object class以外の）親classを継承したclassの場合は親classのconstructorを呼び出すことで親classのfieldの初期化を行う必要があるケースが多いが
    //    親classのconstructorはsuperというkeywordで呼び出せる（super();は親classのdefault constructor呼び出し、super(123);は親classのint型引数を１個受け取る
    //    constructor呼び出し、など）が、これを書けるのは（comment行を除いた）constructorの１行目のみであることに注意（でないとcompile時エラーになる）（継承については別の機会に解説する）！
    //    また、Constructorを呼び出すときは、new演算子を用いる。class名がAbeshiでdefault constructorが定義されているならばnew Abeshi();で呼び出せる。
    //    ※classとinstanceの関係、instance化の意味については、Program02で解説する。
    //    ※instance化する＝instantiateまたはinstantialize、instance化＝Instantiationまたはinstantialization （http://dictionary.sensagent.com/instantialization/en-en/）
    // (2)main method：このclassをJavaで実行したときにまず最初に呼び出される特殊なmethod（これが書かれてないclassを実行しようとすると実行時エラーになる）。
    //    「publicでstaticで戻り値はvoid（何も返さない）で名前はmainで引数はString配列型ただ１個」でなければmain methodとはみなされず、普通のmethod扱いとなる。 ←compile時エラーにはならないが紛らわしいのでお作法的にNG
    //    受け取った引数の名前（これを「仮引数」と呼ぶ）は慣習的にargsとするが他の名前にしても、別に普通のmethod扱いされることもないしcompile時エラーにもならない。
    // (3)普通のmethod：上記(1)と(2)に該当しないmethod。
    //    static修飾子を付けない場合はinstance methodとなり、呼び出す場合は[method名(引数に設定する値)]で呼び出し、
    //    static修飾子を付ける場合はclass methodとなり、呼び出す場合は[class名].[method名(引数に設定する値)]で呼び出す（Program02で解説する）。
}



/* 【課題】=====================================================================
これはproject、package、class、field、methodの定義方法について復習する課題である。

【課題１】
１）projectとは何かを自分の言葉で説明せよ。下記の内容について言及すること。
・どんな単位でprojectを作るのか？
・OSのフォルダシステム上ではprojectは何として表現されているのか？
  また、Eclipseはそれをprojectであるとどうやって認識しているのか？
・命名規則はあるのか？あればどういうものか？

２）packageとは何かを自分の言葉で説明せよ。下記の内容について言及すること。
・packageのありがたみとは？（「class名の名前空間」について言及すること）
・OSのフォルダシステム上ではpackageは何として表現されているのか？
・命名規則はあるのか？あればどういうものか？

３）classとは何かを自分の言葉で説明せよ。下記の内容について言及すること。
・「オブジェクト指向」的にclassはどう説明できるか？
  例えばバイクをclassで表した場合はfieldとmethodには何を定義できるか？
・定義のフォーマットはどんな形になるか？
・命名規則はあるのか？あればどういうものか？
・OSのフォルダシステム上ではclassは何として表現されているのか？
  それの名前とpublicなclassの名前とに関係性はあるか？
  それの中に（どんなclassであっても）classは複数定義可能なのか？

４）fieldとは何かを自分の言葉で説明せよ。下記の内容について言及すること。
・定義のフォーマットはどんな形になるか？
・命名規則はあるのか？あればどういうものか？
・class fieldとinstance fieldの違いは？（意味の違いは？定義方法の違いは？呼び出し方法の違いは？）

５）methodとは何かを自分の言葉で説明せよ。下記の内容について言及すること。
・定義のフォーマットはどんな形になるか？
・命名規則はあるのか？あればどういうものか？
・class methodとinstance methodの違いは？（意味の違いは？定義方法の違いは？呼び出し方法の違いは？それらから自身のclass fieldとinstance fieldは参照できるのか？）
・２つの特殊なmethodがあるが、それはどういうものか？
*/