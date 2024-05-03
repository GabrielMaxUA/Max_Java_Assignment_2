import warrior.*;
import weapon.*;
import armour.*;
import weather.*;
import utility.*;

import java.util.Scanner;
import java.util.Random;

public class Warsim {

  // Objects
  public static Scanner input = new Scanner(System.in);
  public static Random randNum = new Random();
  public static Ink ink = new Ink();
  public static Weather weather;

  // Player Objects
  public static Warrior player; // player
  public static Weapon pWeapon; // player weapon
  public static Armour pArmour; // player armour

  // Enemy Objects
  public static Warrior enemy; // enemy
  public static Weapon eWeapon; // enemy weapon
  public static Armour eArmour; // enemy armour
// Variables
  public static boolean gameOver = false;
  public static boolean playerTurn = true;
  public static int choice = 0;
  public static int attackType = 0;
  public static int damage = 0;
  public static int spike = 0;
  public static int damageRed = 0;
  public static String who = "Player";
  public static String winner = "";

  public static void main(String[] args) {
    ink.welcomeMessage();

    // set a random weather for the battle
    int weatherType = randNum.nextInt(4) + 1;
    createWeather(weatherType);

    //====================>>
    // Player Setup
    // Warrior
    ink.printWarriorMenu();
    int choice = input.nextInt(); // 1, 2 or 3
    createWarrior(who, choice);

    // Weapon
    ink.printWeaponMenu();
    choice = input.nextInt(); // 1, 2 or 3
    createWeapon(who, choice);

    // Armour
    ink.printArmourMenu();
    choice = input.nextInt(); // 1, 2 or 3
    createArmour(who, choice);

    //====================>>
    // Enemy Setup
    who = "Enemy"; // swap the who with the what
    // Warrior
    choice = randNum.nextInt(3) + 1;
    createWarrior(who, choice);

    // Weapon
    choice = randNum.nextInt(3) + 1;
    createWeapon(who, choice);

    // Armour
    choice = randNum.nextInt(3) + 1;
    createArmour(who, choice);

    ink.printStats(player, enemy, pWeapon, eWeapon);
    
    // main game loop
    while(!gameOver) { 
     // while the game is NOT over
      if(playerTurn) {
        System.out.println("                    Player's Turn\n ");
        ink.printAttackMenu();
        attackType = input.nextInt();
        damage = pWeapon.strike(weather.getSeverity(), attackType, player.getStrength(), player.getDexterity());

        if(attackType == 2 && damage > 0){
          System.out.printf("You dealt %s of damage with your %s, including %s of crit damage\n", damage, pWeapon.getWclass(), pWeapon.getCrit());
        }
        else{
          System.out.printf("You dealt %s of damage with your %s\n", damage, pWeapon.getWclass());
        }
        if(damage > 0){
        damageRed = eArmour.reduceDamage(damage);
        System.out.printf("Your enemy's armour absorbed %s of your damage \n", damage - damageRed);
        enemy.takeDamage(damageRed);
        if(damageRed > 0){
          System.out.printf("Your enemy took %s of damage in total\n", damageRed);
        }
        else{
          System.out.println("Your enemy's armor absorbed all damage");
        }
        spike = eArmour.getSpike();
        player.takeDamage(spike);
        System.out.printf("Your enemy dealt %s of damage to you by his armor spikes\n", spike);
        }
        else{
          System.out.println("You missed!!!");
        }

        if(!enemy.isAlive()) {
          winner = "Player";
          gameOver = !gameOver;
        }
      }
      else { // enemy turn code
        System.out.println("                    Enemy's Turn\n");
        randNum.nextInt(attackType + 1);
        damage = eWeapon.strike(weather.getSeverity(), attackType, enemy.getStrength(), enemy.getDexterity());

        if(attackType == 2 && damage > 0){
          System.out.printf("You got %s of damage, including %s of crit damage from your enemy's %s\n", damage, eWeapon.getCrit(), eWeapon.getWclass());
        }
        else{
          System.out.printf("Your enemy dealt %s of damage with his %s\n", damage, eWeapon.getWclass());
        }
        if(damage > 0){
        damageRed = pArmour.reduceDamage(damage);
        System.out.printf("Your armour absorbed %s of the damage \n", damage - damageRed);
        player.takeDamage(damageRed);
          if(damageRed > 0){
            System.out.printf("You took %s of damage in total\n", damageRed);
          }
          else{
            System.out.println("Your armor absorbed all damage");
          }
        
        spike = pArmour.getSpike();
        enemy.takeDamage(spike);
        System.out.printf("You dealt %s of damage to your enemy by your armour spikes\n", spike);
        }
        else{
          System.out.println("Your enemy missed!!!");
        }

        if(!enemy.isAlive()) {
          winner = "Player";
          gameOver = !gameOver;
        }
        
        if(!player.isAlive()) {
          winner = "Enemy";
          gameOver = !gameOver;
        }
      }
      ink.printStats(player, enemy, pWeapon, eWeapon);
      playerTurn = !playerTurn; // toggle turns
    } // while()

    ink.printGameOver(winner);
  } // main()

  // Helper Methods
  public static void createWarrior(String who, int choice) {
    if(who.equals("Player")) {
      switch (choice) {
        case 1: // Human
          player = new Human("Human");
          break;
        case 2: // Elf
          player = new Elf("Elf");
          break;
        case 3: // Orc
          player = new Orc("Orc");
          break;
        default:
          System.out.println("oops!");
          break;
      } // switch
    }
    else {
      switch(choice) {
        case 1: // Human
          enemy = new Human("Human");
          break;
        case 2: // Elf
          enemy = new Elf("Elf");
          break;
        case 3: // Orc
          enemy = new Orc("Orc");
          break;
        default:
          System.out.println("oops!");
          break;
      } // switch
    }
  } // createWarrior()

  public static void createWeapon(String who, int choice) {
    switch(choice) {
      case 1: // Dagger
        if(who.equals("Player")) {
          pWeapon = new Dagger();
        }
        else {
          eWeapon = new Dagger();
        }
        break;
      case 2: // Sword
        if(who.equals("Player")) {
          pWeapon = new Sword();
        }
        else {
          eWeapon = new Sword();
        }
        break;
      case 3: // Axe
        if(who.equals("Player")) {
          pWeapon = new Axe();
        }
        else {
          eWeapon = new Axe();
        }
        break;
      default:
        System.out.println("oops!");
        break;
    } // switch
  } // createWeapon()

  public static void createArmour(String who, int choice) {
    switch(choice) {
      case 1: // Leather
        if(who.equals("Player")) {
          pArmour = new Leather();
        }
        else {
          eArmour = new Leather();
        }
        break;
      case 2: // Chainmail
        if(who.equals("Player")) {
          pArmour = new Chainmail();
        }
        else {
          eArmour = new Chainmail();
        }
        break;
      case 3: // Platemail
        if(who.equals("Player")) {
          pArmour = new Platemail();
        }
        else {
          eArmour = new Platemail();
        }
        break;
      default:
        System.out.println("oops!");
        break;
    } // switch
  } // createArmour()

  public static void createWeather(int weatherType) {
    switch (weatherType) {
      case 1: // sun 
        weather = new Sun();
        break;
      case 2: // rain
        weather = new Rain();
        break;
      case 3: // wind
        weather = new Wind();
        break;
      case 4: // storm
        weather = new Storm();
        break;
      default:
        System.out.println("Run!! Godzilla!!!");
        break;
    } // switch
  } // createWeather()
} // class