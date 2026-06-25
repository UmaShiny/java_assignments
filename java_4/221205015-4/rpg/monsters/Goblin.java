/**
 * 基本課題4.2~3 Goblinクラス
 * @author 221205015 伊藤優希
 */
package rpg.monsters;

public class Goblin extends WalkingMonsters{

	public Goblin(int n, int rnum) {
		super(n, rnum, "ゴブリン");
		super.name = "ゴブリン" + super.suffix;
	}
	
	@Override
	public void attack() {
		System.out.printf("%sはナイフで斬りつけた！\n",name);
	}

}
