package armour;

public class Leather extends Armour {
  private int armourAmount = 50;
  private int dexterityCost = 50;
  private int spike = 30;

  public Leather() {
    super();
    super.setArmourAmount(armourAmount);
    super.setDexterityCost(dexterityCost);
    super.setSpike(spike);
  } // constructor

  public int reduceDamage(int damageAmount) {
    return damageAmount - this.armourAmount / 10;
  }
  public int spikeDmg(int spikeDamage, int health){
    return health -= health - this.spike;
  }
  
} // class
