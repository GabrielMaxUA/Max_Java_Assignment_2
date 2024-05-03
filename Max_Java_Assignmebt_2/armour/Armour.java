package armour;

public abstract class Armour {
  private int armourAmount;
  private int dexterityCost;
  private int spike;

  public Armour() {
    // do nothing
  }

  //==============>>
  // GETTERS
  public int getArmourAmount() {
    return this.armourAmount;
  }
  public int getDexterityCost() {
    return this.dexterityCost;
  }
  public int getSpike(){
    return spike;
  }

  //==============>>
  // SETTERS
  public void setArmourAmount(int armourAmount) {
    this.armourAmount = armourAmount;
  }
  public void setDexterityCost(int dexterityCost) {
    this.dexterityCost = dexterityCost;
  }
  public void setSpike(int spike){
    this.spike = spike;
  }

  //methods 
  public abstract int reduceDamage(int damageAmount);
  public abstract int spikeDmg(int spikeDamage, int health);
} // class
