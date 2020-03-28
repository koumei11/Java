package study1.chapter1.unit4;

public class Program04Kadai1Ruidai1 {
    public static void main(String[] args)
    {
        Mammal panda = new CaliforniaSeaLion("キュッキュ");
        panda.sleep(); // キュッキュッ・・。
        panda.doJikoshoukai(); // キュッキュッキュッ・・キュッキュだキュッ！鰭脚類アシカ科アシカ属カリフォルニアアシカ種なんだキュッ！
    }
}
/**
 * 鰭脚類を表すclass
 * @author kinjouhiroaki
 */
abstract class Pinnipedia extends Mammal
{
    public Pinnipedia(String ka, String zoku, String shu, String name) {
        super("鰭脚類", ka, zoku, shu, name);
    }
}
/**
 * アシカ科を表すclass
 * @author kinjouhiroaki
 */
abstract class Otariidae extends Pinnipedia
{
    public Otariidae(String zoku, String shu, String name) {
        super("アシカ科", zoku, shu, name);
    }
}
/**
 * アシカ属を表すclass
 * @author kinjouhiroaki
 */
abstract class Zalophus extends Otariidae
{
    public Zalophus(String shu, String name) {
        super("アシカ属", shu, name);
    }
}
/**
 * カリフォルニアアシカ種を表すclass
 * @author kinjouhiroaki
 */
class CaliforniaSeaLion extends Zalophus
{
    public CaliforniaSeaLion(String name) {
        super("カリフォルニアアシカ種", name);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void sleep() {
        System.out.println("キュッキュッ・・。");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void doJikoshoukai() {
        String jikoshoukai = "キュッキュッキュッ・・" + name + "だキュッ！" + moku + ka + zoku + shu + "なんだキュッ！";
        System.out.println(jikoshoukai);
    }
}
