package weapon;

public class Dagger extends Weapon {
  private int damageAmount = 50;
  private int dexterityCost = 50;
  private int hitPercentage = 90;
  private int crit = damageAmount/2;
  private String wClass = "Dagger";

  public Dagger() {
    super();
    super.setDamageAmount(damageAmount);
    super.setDexterityCost(dexterityCost);
    super.setCrit(crit);
    super.setWclass(wClass);
  } // constructor

  public int strike(int weatherIntensity, int attackType, int strength, int dexterity) {
    int amount = 0;
    // roll the dice
    int roll = super.randNum.nextInt(100) + 1; // 1 - 100

    // increasing hitPercentage based on player dexterity
    // decreasing the hitPercent based on attackType
    if(roll <= hitPercentage + 
      ((dexterity - dexterityCost) / 10) - (attackType * 5)) { // hit
      if(attackType == 2) {
        amount = this.damageAmount + (strength / 10) + crit + 2 - weatherIntensity;
      }
      else {
        amount = this.damageAmount + (strength / 20) - weatherIntensity;
      }
    }
    return amount;
  } // strike()
} // class
