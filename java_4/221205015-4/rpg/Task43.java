/**
 * 基本課題4.3　Task43
 * @author 221205015 伊藤優希
 */

// rpgパッケージに所属させる（消さないこと！）
package rpg;

import rpg.monsters.*;
import java.util.Random;


/**
 * 基本課題4.3（雛形）
 */
public class Task43 {

	public static void main(String[] args) {
		
		int countGob = 0;
		int countBat = 0;
		int countWol = 0;
		
		//int countATK = 0;
		int countRUN = 0;
		
		// 発生させるモンスターの数を2〜5の範囲で生成する
		Random rM = new Random();
		int length = rM.nextInt(4) + 2;
		// 生成するモンスターを格納する配列を作成
		Monsters[] m = new Monsters[length]; 
		// モンスターをランダムに生成
		Random rG = new Random();
		for(int k = 0; k < length; k++) {
			switch (rG.nextInt(3)) {
			case 0:
				m[k] = new Goblin(countGob,100);
				countGob++;
				break;
			case 1:
				m[k] = new DeathBat(countBat,100);
				countBat++;
				break;
			case 2:
				m[k] = new Werewolf(countWol,100);
				countWol++;
				break;
			}
		}
		// 生成したモンスターを表示
		showMonsters(m);
		// モンスターがランダムに行動
		while(countRUN < length) {
			for(int k = 0; k < length; k++) {
				boolean h = rG.nextBoolean();
				if(m[k] == null) {
					continue;
				}
				if(h) {
					//System.out.printf("今，%sが行動しています.\n>>>",m[k].getName());
					m[k].attack();
					//countATK++;
					continue;
				}else {
					//System.out.printf("今，%sが行動しています.\n>>>",m[k].getName());
					m[k].run();
					m[k] = null;
					countRUN++;
					continue;
				}
			}
		}
		// 全てのモンスターが逃げ出したら表示
		System.out.println("\nモンスターは全て逃げ出した！");
	}

	private static void showMonsters(Monsters[] m) {
		for(int k = 0; k < m.length; k++) {
			System.out.printf("%s,",m[k].getName());
		}
		System.out.printf("が現れた．\n\n");
	}
}