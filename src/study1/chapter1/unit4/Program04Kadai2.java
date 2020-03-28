package study1.chapter1.unit4;

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
        words = (words != null) ? words : "";
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
    abstract String getSpecies();
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
        words = words.replaceAll("[あいうえお]", "と").replaceAll("[かきくけこ]", "ま");
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
        words = words.substring(1);
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
        words = words.replaceAll(".", "$0$0");
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
