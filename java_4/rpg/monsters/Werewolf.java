/**
 * 基本課題4.2~3 Werewolfクラス
 * @author 221205015 伊藤優希
 */
package rpg.monsters;

public class Werewolf extends WalkingMonsters{
	
	public Werewolf(int n, int rnum) {
		super(n, rnum, "ウォーウルフ");
		super.name = "ウォーウルフ" + super.suffix;
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void attack() {
		System.out.printf("%sはかみついた！\n",name);
	}
	
}
