package study1.chapter1.unit4.kadai2;

import java.util.ArrayList;
import java.util.List;

public class Program04Kadai2 {
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

        // ＜問３＞
        System.out.println("\n＜問３＞");
        int quantity = 10;
        System.out.println(quantity + "羽のオウムを仕入れての実験：");

        for (Parrot parrot : getParrots(quantity))
        {
            System.out.println(parrot.getSpecies() + "の応答：" + parrot.reply("あべしひでぶたわば"));
        }
    }
    /**
     * 数を受け取ってその数分オウムを返す(問３で追加)
     * @param patrrotsNum オウムの数
     * @return ランダムなオウムのリスト
     */
    private static List<Parrot> getParrots(int patrrotsNum)
    {
        List<Parrot> parrots = new ArrayList<>();
        for (int i = 0; i < patrrotsNum; i++)
        {
            Parrot parrot;
            int rand = (int)(Math.random() * 10);
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
}
/**
 * オウムを表すclass
 * @author kinjouhiroaki
 */
abstract class Parrot
{
    /**
     * かけられた言葉に対して「キュルルッ！」をつけて返す
     * @param words 言葉
     * @return 応答
     */
    public String reply(String words)
    {
        words = (words != null) ? words : ""; // →△ このくらいのコード量の単純なmethodならいいですが、一般的には「仮引数に別のinstanceを代入しない」というのがお約束です（現場によってはコードレビューで修正するように指摘されます）。なお、Javaの言語仕様レベルでこの行為（仮引数に代入する）を防ぐ手段も提供されています。それは「finalというキーワードを仮引数の型の前に付与する」という手段です。このコードで付与してみると、代入を行っているこの行でcompile時エラーとなりますので、試してみましょう。代入先である左辺をString treatedWordsなどのように変えて、仮引数とは別の変数に代入するようにしましょう。
        return "キュルルッ！" + replySub(words);
    }
    /**
     * かけられた言葉に対しておうむ返しをする
     * @param words 言葉
     * @return 応答
     */
    abstract String replySub(String words);
    /**
     * オウムの種類を返す(問３で追加)
     * @return オウムの種類
     */
    abstract String getSpecies(); // →○ これはこれで正解です。別解として問１の方法でやる場合は、これをabstractでない通常のmethodにして、このclassにspeciesというfieldを設定し、それを返す実装を書けばよいです。この場合は、このfieldを子classが必ず初期化するようにdefault constructorは提供せず「speciesを初期化するconstructor」を提供しましょう。※別解は模範解答を参照のこと。
}
/**
 * トマトオウムを表すclass
 * @author kinjouhiroaki
 */
class TomatoParrot extends Parrot
{
    /**
     * {@inheritDoc}
     */
    @Override
    String replySub(String words) {
        words = words.replaceAll("[あいうえお]", "と").replaceAll("[かきくけこ]", "ま"); // →△ 84行目と同じ指摘。ここでは別変数に保存せずそのまま右辺をreturnしてしまうとスッキリします（別変数に保存するのは「１行だと読みにくい」場合です）。※模範解答を参照のこと
        return words;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    String getSpecies() {
        return "トマトオウム";
    }
}
/**
 * キャベツオウムを表すclass
 * @author kinjouhiroaki
 */
class CabbageParrot extends Parrot
{
    /**
     * {@inheritDoc}
     */
    @Override
    String replySub(String words) {
        words = words.substring(1); // →△ 同上
        return words;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    String getSpecies() {
        return "キャベツオウム";
    }
}
/**
 * ロマネスコオウムを表すclass
 * @author kinjouhiroaki
 */
class RomanescoParrot extends Parrot
{
    /**
     * {@inheritDoc}
     */
    @Override
    String replySub(String words) {
        words = words.replaceAll(".", "$0$0"); // →△ 同上
        return words;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    String getSpecies() {
        return "ロマネスコオウム";
    }
}
