/**
 * 基本課題4.2~3 Monstersクラス
 * @author 221205015 伊藤優希
 */
package rpg.monsters;

import java.util.Random;

public abstract class Monsters {
	protected int hp;
	protected int mp;
	protected String name;
	protected char suffix;
	
	public Monsters(int n, int rnum, String s) {
		Random r = new Random();
		char suf = (char)(0x0041 + n);
		this.suffix = suf;
		this.hp = r.nextInt(rnum);
		this.mp = r.nextInt(rnum);
		name = s + suf;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void attack();
	
	public abstract void run();

}
