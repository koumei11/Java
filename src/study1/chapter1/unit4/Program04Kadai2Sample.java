package study1.chapter1.unit4;
//package study1.chapter1.unit4;
//
//public class Program04Kadai2Sample
//{
//    public static void main(String[] args)
//    {
//        // 各オウムの個体を作成する
//        TomatoParrot parrotT = new TomatoParrot();
//        CabbageParrot parrotC = new CabbageParrot();
//        RomanescoParrot parrotR = new RomanescoParrot();
//
//        // オウムに声をかけて、その応答を出力する
//        String call = "ありがとう";
//        System.out.println("*** 「" + call + "」と声をかけたときの応答 ***");
//        System.out.println("トマトオウムの応答：" + parrotT.reply(call)); // トマトオウムの応答：キュルルッ！とりがとと
//        System.out.println("キャベツオウムの応答：" + parrotC.reply(call)); // キャベツオウムの応答：キュルルッ！りがとう
//        System.out.println("ロマネスコオウムの応答：" + parrotR.reply(call)); // ロマネスコオウムの応答：キュルルッ！あありりががととうう
//
//        call = "ぼくはおにぎりがすきなんだな";
//        System.out.println("*** 「" + call + "」と声をかけたときの応答 ***");
//        System.out.println("トマトオウムの応答：" + parrotT.reply(call)); // トマトオウムの応答：キュルルッ！ぼまはとにぎりがすまなんだな
//        System.out.println("キャベツオウムの応答：" + parrotC.reply(call)); // キャベツオウムの応答：キュルルッ！くはおにぎりがすきなんだな
//        System.out.println("ロマネスコオウムの応答：" + parrotR.reply(call)); // ロマネスコオウムの応答：キュルルッ！ぼぼくくははおおににぎぎりりががすすききななんんだだなな
//    }
//}
//
///**
// * トマトオウムを表すclass
// * @author wombat
// * @since 2020/03/01
// */
//class TomatoParrot
//{
//    /**
//     * オウム返しする。
//     * @param words かけた言葉
//     * @return 返答
//     */
//    public String reply(String words)
//    {
//        String reply = (words != null) ? words : ""; // 「ぬるぽ」を阻止！
//
//        // トマトオウム固有の処理
//        reply = reply.replaceAll("[あいうえお]", "と").replaceAll("[かきくけこ]", "ま"); // トマトオウムという種類のオウムは「あ、い、う、え、お」を「と」に、「か、き、く、け、こ」を「ま」に言いかえる。
//
//        // オウム共通の処理
//        reply = "キュルルッ！" + reply; // いずれのオウムも、喋り始めるときに、必ず「キュルルッ！」と叫んでから喋り始める。
//
//        return reply;
//    }
//}
//
///**
// * キャベツオウムを表すclass
// * @author wombat
// * @since 2020/03/01
// */
//class CabbageParrot
//{
//    /**
//     * オウム返しする。
//     * @param words かけた言葉
//     * @return 返答
//     */
//    public String reply(String words)
//    {
//        String reply = (words != null) ? words : ""; // 「ぬるぽ」を阻止！
//
//        // キャベツオウム固有の処理
//        reply = reply.substring(1); // キャベツオウムという種類のオウムは最初の単語だけを抜かす。
//
//        // オウム共通の処理
//        reply = "キュルルッ！" + reply; // いずれのオウムも、喋り始めるときに、必ず「キュルルッ！」と叫んでから喋り始める。
//
//        return reply;
//    }
//}
//
///**
// * ロマネスコオウムを表すclass
// * @author wombat
// * @since 2020/03/01
// */
//class RomanescoParrot
//{
//    /**
//     * オウム返しする。
//     * @param words かけた言葉
//     * @return 返答
//     */
//    public String reply(String words)
//    {
//        String reply = (words != null) ? words : ""; // 「ぬるぽ」を阻止！
//
//        // ロマネスコオウム固有の処理
//        reply = reply.replaceAll(".", "$0$0"); // ロマネスコオウムという種類のオウムは各単語を２回ずつ発声しながら喋る。
//
//        // オウム共通の処理
//        reply = "キュルルッ！" + reply;
//
//        return reply;
//    }
//}
