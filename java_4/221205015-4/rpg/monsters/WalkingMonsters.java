/**
 * 基本課題4.2~3 WalkingMonstersクラス
 * @author 221205015 伊藤優希
 */
package rpg.monsters;

public abstract class WalkingMonsters extends Monsters{
	
	public WalkingMonsters(int n, int rnum, String s) {
		super(n, rnum, s);
	}

	@Override
	public void run() {
		System.out.printf("%sはトコトコ走って逃げた．\n",name);
	}
	
}
