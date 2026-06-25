/**
 * 基本課題4.2~3 FlyingMonstersクラス
 * @author 221205015 伊藤優希
 */
package rpg.monsters;

public abstract class FlyingMonsters extends Monsters{

	public FlyingMonsters(int n, int rnum, String s) {
		super(n, rnum, s);
	}

	@Override
	public void run() {
		System.out.printf("%sバサバサ飛んで逃げて行った．\n",name);
	}
}
