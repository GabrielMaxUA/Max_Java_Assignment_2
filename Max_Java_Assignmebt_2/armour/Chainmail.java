package armour;

public class Chainmail extends Armour {
  private int armourAmount = 150;
  private int dexterityCost = 100;
  private int spike = 35;

  public Chainmail() {
    super();
    super.setArmourAmount(armourAmount);
    super.setDexterityCost(dexterityCost);
    super.setSpike(spike);
  } // constructor

  public int reduceDamage(int damageAmount) {
    return damageAmount - this.armourAmount / 5;
  }
  public int spikeDmg(int spikeDamage, int health){
    return health -= health - this.spike;
  }
  
} // class
