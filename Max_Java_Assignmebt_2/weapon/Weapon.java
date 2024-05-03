package weapon;

import java.util.Random;

public abstract class Weapon {
  private int damageAmount;
  private int dexterityCost;
  private int crit;
  private String wClass;
  protected Random randNum = new Random();

  public Weapon() {
    // do nothing
  } // contructor

  //===============>>
  // GETTERS
  public int getDamageAmount() {
    return this.damageAmount;
  }
  public int getDexterityCost() {
    return this.dexterityCost;
  }
  public int getCrit(){
    return crit;
  }
  public String getWclass(){
    return wClass;
  }

  //===============>>
  // SETTERS
  public void setDamageAmount(int damageAmount) {
    this.damageAmount = damageAmount;
  }
  public void setDexterityCost(int dexterityCost) {
    this.dexterityCost = dexterityCost;
  }
  public void setCrit(int crit){
    this.crit = crit;
  }
  public void setWclass(String wSclass){
    this.wClass = wSclass;
  }
  // makes it polymorphic!
  public abstract int strike(int weatherIntensity, int attackType, int strength, int dexterity);
} // class
