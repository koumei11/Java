package study1.chapter1.unit4;

public class Program04Kadai1 {
    public static void main(String[] args)
    {
        Mammal panda = new GiantPanda("リンリン");
        panda.sleep(); // ぐーすーぴー。
        panda.doJikoshoukai(); // ボク・・リンリンだぱんっ！食肉目クマ科ジャイアントパンダ属ジャイアントパンダ種のパンダだよ・・。

        new GiantPanda("リーリー").doJikoshoukai(); // ボク・・リーリーだぱんっ！食肉目クマ科ジャイアントパンダ属ジャイアントパンダ種のパンダだよ・・。
    }
}
/**
 * 食肉目を表すclass
 * @author kinjouhiroaki
 */
abstract class Carnivora extends Mammal
{
    public Carnivora(String ka, String zoku, String shu, String name) {
        super("食肉目", ka, zoku, shu, name);
    }
}
/**
 * クマ科を表すclass
 * @author kinjouhiroaki
 */
abstract class Ursidae extends Carnivora
{
    public Ursidae(String zoku, String shu, String name) {
        super("クマ科", zoku, shu, name);
    }
}
/**
 * ジャイアントパンダ属を表すclass
 * @author kinjouhiroaki
 */
abstract class Ailuropoda extends Ursidae
{
    public Ailuropoda(String shu, String name) {
        super("ジャイアントパンダ属", shu, name);
    }
}
/**
 * ジャイアントパンダ種を表すclass
 * @author kinjouhiroaki
 */
class GiantPanda extends Ailuropoda
{
    public GiantPanda(String name) {
        super("ジャイアントパンダ種", name);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void sleep() {
        System.out.println("ぐーすーぴー。");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void doJikoshoukai() {
        String jikoshoukai = "ボク・・" + name + "だぱんっ！" + moku + ka + zoku + shu + "のパンダだよ・・。";
        System.out.println(jikoshoukai);
    }
}
