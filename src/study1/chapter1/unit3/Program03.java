/*
 * classの継承を理解してもらうためのソースコード。
 * 下記を勉強する。
 * １）class定義時にextends句を使えば、他classを継承することができる
 * ２）子classをinstance生成するときには親classも同時にinstance生成する必要があるので
 * 　　親classにdefault constructorが定義されていない場合は、子classにconstructorを明示的に書いて
 * 　　そこから親classで定義されているconstructorを呼び出す必要がある
 * ３）子classには、親classにあるmethodと「同じ名前で同じ戻り値の型で同じ型の引数列」のmethodを定義できる【methodのoverride】
 * ４）子classには、親classにあるmethodと「同じ名前で同じ戻り値の型で、違う型の引数列」のmethodを定義できる【methodのoverload】
 * ５）もちろん、「同じ名前で、違う戻り値の型で、違う型の引数列」のmethodも定義できるが、
 * 　　「同一classに戻り値の型だけが違うmethodを定義できない」のと同様に、やはり親classのと「戻り値の型だけが違う」methodは子classに定義できない。
 */

package study1.chapter1.unit3;

/**
 * ピアニストとサッカー選手という2人の人間を作成して自己紹介させるclass
 * @author wombat
 * @since 2020/02/08
 */
public class Program03
{
    public static void main(String[] args) // Ecipseの場合はmainと打ち込んでctrl+spaceで補完して書くこと！
    {
        Person pianist = new Pianist("Maurizio Pollini");
        pianist.doJikoshoukai(); // 「私の名前はMaurizio Pollini、ピアニストです。」と自己紹介させる

        Person footballer = new Footballer("Cristiano Ronaldo");
        footballer.doJikoshoukai(); // 「私の名前はCristiano Ronaldo、サッカー選手です。」と自己紹介させる

        // 上記の例から分かるように、
        // instance作成したときにそれを入れる変数の型は、親classの型にするのが基本。
        // それは、共通の型で受けておけば、下記のように、どの子classであっても一緒くたに扱うことができて便利だから。
        // List<Person> persons = new ArrayList<>(); // Personのlistを作成
        // persons.add(pianist); // listにピアニストを追加
        // persons.add(footballer); // listにサッカー選手を追加
        // for (Person person : persons)
        // {
        //     person.doJikoshoukai(); // 全員まとめて自己紹介させる
        // }
    }
}

/**
 * 人間を表すclass
 * @author wombat
 * @since 2020/02/08
 */
class Person
{
    /** 氏名 */
    public String name;

    // Eclipseの場合、右クリック→「ソース」→「フィールドを使用してコンストラクターを生成」
    // を選択して、下記のconstructorを作成すること。
    /**
     * 氏名を引数で設定してinstance化するためのconstructor。
     * @param name 氏名
     */
    public Person(String name)
    {
        super(); // 親classのdefault constructorを呼ぶ（Person classの場合、親classはObject class）→この場合は何も起こらない
        this.name = name; // field変数と仮引数とで変数名が被った場合は、明示的に「this.」を付けることでfield変数を指し示す必要がある（普段は省略してOK。その場合はcompilerの方で勝手に付けてくれる）。
    }

    /**
     * 自己紹介をする。
     */
    public void doJikoshoukai()
    {
        String jikoshoukai = "私の名前は" + name + "です。";
        System.out.println(jikoshoukai); // Ecipseの場合は「System.out.println();」はsysoと打ってctrl+spaceで補完して書くこと！
    }
}

/**
 * 「職業：ピアニスト」の人間を表すclass
 * @author wombat
 * @since 2020/02/08
 */
class Pianist extends Person
{
    // 親classにdefault constructorが未定義の場合は、子classに何か１つはconstructorを定義して親classのconstructorを呼ばなければ、下記のCompile時エラーとなる：
    // 暗黙的スーパー・コンストラクター Person() は、デフォルト・コンストラクターについては未定義です。明示的コンストラクターを定義する必要があります
    public Pianist(String name)
    {
        super(name);
    }

    // ★【省エネTIPS】下記の「methodのoverride」は自分では書かないこと！
    // 「doJ」まで打ち込んでctrl+spaceで補完すると、選択肢一覧が表示されるが、
    // 「doJikoshoukai() : void - 'Person'でのメソッドのオーバーライド」という選択肢をダブルクリックすると、自動で
    // public void doJikoshoukai()の実装skeleton（※骨組だけの空実装のことをskeletonと呼ぶ）が作成されるので、
    // その実装に手を加えるのが省エネな実装方法である！！

    // methodのoverrideの場合は、javadocは「変更後の振る舞いの詳細を書きたい」理由がある場合はそれを記述すればよいが、
    // 特に元のmethodのjavadocのままで差し支えないという場合は{@inheritDoc}と書くことで、元のjavadocを参照することができる。
    // →元のmethodのjavadocからコピペするのはご法度！！それをやってしまうと、コピペ元のjavadocが更新された場合に自動で追従されないため、陳腐化してしまうのだ！！
    // 【小話】これはとても便利でJavaプログラマとしては多用する知識なのだが、世の中、不勉強なプログラマが多くて
    // 「コードレビューの時に『これは何だ？』と疑い深い目で見ながら問い詰めて来るアホウがいる」ことも事実。
    // そういう場合は「この程度の知識もない人間がコードレビューをする立場にいることがおかしい。私と貴方でレビューする立場を逆にしてはどうか？」
    // と毅然と言い放って、次からコードレビュー時にヘタな指摘ができないようにプレッシャーをかけておくのが正解である。
    // それで契約を切られたのならば、その現場は「出来るプログラマにとって良くない環境の現場だった」ということで、むしろ喜ばしいことである。
    /**
     * {@inheritDoc}
     */
    @Override // methodをoverrideするときは、必ず「@Override」というannotationをmethodに付与すること！（理由は後述）
    public void doJikoshoukai()
    {
        String jikoshoukai = "私の名前は" + name + "、ピアニストです。";
        System.out.println(jikoshoukai); // Ecipseの場合は「System.out.println();」はsysoと打ってctrl+spaceで補完して書くこと！
    }
}

/**
 * 「職業：サッカー選手」の人間を表すclass
 * @author wombat
 * @since 2020/02/08
 */
class Footballer extends Person
{
    // 親classにdefault constructorが未定義(かつ他のconstructorが定義されている場合)の場合は、子classに何か１つはconstructorを定義して親classのconstructorを呼ばなければ、下記のCompile時エラーとなる：
    // 暗黙的スーパー・コンストラクター Person() は、デフォルト・コンストラクターについては未定義です。明示的コンストラクターを定義する必要があります
    public Footballer(String name)
    {
        super(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doJikoshoukai()
    {
        String jikoshoukai = "私の名前は" + name + "、サッカー選手です。";
        System.out.println(jikoshoukai); // Ecipseの場合は「System.out.println();」はsysoと打ってctrl+spaceで補完して書くこと！
    }
}

//***** 説明しよう！！【※1.classの継承】 *****
// １）class定義時にextends句を使えば、他classを継承することができる
// ２）子classをinstance生成するときには親classも同時にinstance生成する必要があるので
// 　　親classにdefault constructorが定義されていない場合は、子classにconstructorを明示的に書いて
// 　　そこから親classで定義されているconstructorを呼び出す必要がある
// 　　※親classにdefault constructorが定義されていれば、子classではそれについて何も意識しなくてOK
// 　　（なぜなら、①子classにconstructorを書かなかった場合：子classにdefault constructorが暗黙的に定義されるが、
// 　　その中で暗黙的に親classのdefault constructorが呼ばれる、②子classにconstructorを書いた場合：そのconstructorの
// 　　最初の行で親のconstructorを呼び出すコードが明示的に書かれていなければ暗黙的に親classにdefault constructorが呼ばれる、
// 　　ので、①と②のどちらの場合も、何かしらの親classのconstructorが呼ばれるような仕組みになってるから。）
// ３）子classには、親classにあるmethodと「同じ名前で同じ戻り値の型で同じ型の引数列」のmethodを定義できる
// 　　→これを『methodのoverride』（上書き）と呼ぶ。
// 　　→overrideすることで、元の（親classの）methodではなくこっちのmethodが実行されるようになるので、「振る舞い」を変えることができる。
// 　　→【重要】この際に安全対策として、「@Override」というannotationをそのmethodに必ず付与すること！
// 　　　これを付けることで「overrideしたつもりで（名前の綴りを間違えてたなどで）overrideされてなかった・・」という凡ミスをcompile時エラーとして教えてくれるようになる！！
// 　　→使い所例：classを定義したら、Object class（※すべてのclassの親となる基底class）のtoString() methodをoverrideして、
// 　　　すべてのfieldの名前と値を出力した文字列を返すようにすると、debugが楽になる。
// ４）子classには、親classにあるmethodと「同じ名前で同じ戻り値の型で、違う型の引数列」のmethodを定義できる
// 　　→これを『methodのoverload』（過積載、過搭載）と呼ぶ。
// 　　　例：String.valueOf(int i)、String.valueOf(long l)、String.valueOf(boolean b)など。
// ５）もちろん、「同じ名前で、違う戻り値の型で、違う型の引数列」のmethodも定義できるが、
// 　　「同一classに戻り値の型だけが違うmethodを定義できない」のと同様に、やはり親classのと「戻り値の型だけが違う」methodは子classに定義できない。



/* 【課題】=====================================================================
これはclassの継承について復習する課題である。

--------------------
【課題１】
--------------------
Program03Kadai1.javaというソースファイルを作成し、下記をコピペし、
Program03Kadai1 classのmain methodがちゃんとcommentの内容どおりに動作するように未実装な
Pianistar（本当はPianistとしたかったが、同じpackage内に既にPianistというclassが存在するため
名前の衝突が起こるので、Pianistarと命名）、Violinist、Cellist、Trumpeter、Hornist、Percussionist
のclassを追加実装せよ。
※main methodに書かれてる内容（ListやArrayListなど）は今後学ぶ内容なので、現段階では詳しく分からなくてよいが、
  「List<[型]>は、[型]で指定した型のinstanceだけを詰められる入れ物である」ことと
  「add methodでinstanceを要素として追加できる」ことさえ知っておけば、本問は回答できる。
※Conductor classのconduct methodで使われている「for-each文」は今後学ぶ内容なので、現段階では詳しく分からなくてよいが、
  「『for ([要素の型] [取り出した要素を表す変数名] : [複数のinstanceを詰められるobject])』という形式で、
  対象objectの要素を前から順番に取り出すことができる」ことさえ知っておけば、本問は回答できる。


package study1.chapter1.unit3;

import java.util.ArrayList;
import java.util.List;

public class Program03Kadai1
{
    public static void main(String[] args)
    {
        List<Musician> orchestra = new ArrayList<>();
        orchestra.add(new Pianistar());
        orchestra.add(new Violinist());
        orchestra.add(new Cellist());
        orchestra.add(new Trumpeter());
        orchestra.add(new Hornist());
        orchestra.add(new Percussionist());
        Conductor.conduct(orchestra);
//        下記が表示される：
//        せーのっ！はいっ！
//        ポロンポロロン♪
//        ギコギコギーコ♪
//        ヴォォォーーーン♪
//        パ～ラ～～パパッ・パ～～パッ・パ～パパッパ～～♪
//        パ・パ・パ・パ～ラッパ・パラッパ・パ～ラッパッ♪
//        だっだーん♪ボヨヨンボヨヨン♪
    }
}

class Conductor
{
    public static void conduct(List<Musician> orchestra)
    {
        System.out.println("せーのっ！はいっ！");
        for (Musician member : orchestra)
        {
            System.out.println(member.play());
        }
    }
}

class Musician
{
    public String play()
    {
        return "ヒュ～ヒュ～♪（口笛）ドダダダ・・（足踏み）";
    }
}
*/