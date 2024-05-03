package armour;


public class Platemail extends Armour {
  private int armourAmount = 250;
  private int dexterityCost = 200;
  private int spike = 25;

  public Platemail() {
    super();
    super.setArmourAmount(armourAmount);
    super.setDexterityCost(dexterityCost);
    super.setSpike(spike);
  } // constructor

  public int reduceDamage(int damageAmount) {
    return damageAmount - this.armourAmount / 2;
  }
  public int spikeDmg(int spikeDamage, int health){
    return health -= health - this.spike;
  }
    
} // class
