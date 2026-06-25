/**
 * 基本課題4.2~3 DeathBatクラス
 * @author 221205015 伊藤優希
 */
package rpg.monsters;

public class DeathBat extends FlyingMonsters{
	public DeathBat(int n, int rnum) {
		super(n, rnum, "デスバット");
		super.name = "デスバット" + super.suffix;
	}

	@Override
	public void attack() {
		System.out.printf("%sは突っついた！\n",name);
	}

}
