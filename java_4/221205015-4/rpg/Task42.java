/**
 * 基本課題4.2　Task42
 * @author 221205015 伊藤優希
 */
package rpg;
import rpg.monsters.*;

public class Task42 {

	public static void main(String[] args) {
		
		Monsters[] m = new Monsters[8];
		m[0] = new Goblin(0,100);
		m[1] = new Werewolf(0,100);
		m[2] = new DeathBat(0,100);
		m[3] = new DeathBat(1,100);
		
		for(int k = 0; k < 4; k++) {
			m[k].attack();
		}
		
		for(int k = 0; k < 4; k++) {
			m[k].run();
		}
	}
}
