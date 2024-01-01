package morenames.npcs;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.friendly.human.ElderHumanMob;
import necesse.entity.mobs.friendly.human.HumanMob;
import necesse.entity.mobs.friendly.human.humanShop.*;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = HumanMob.class, name = "getRandomName", arguments = {GameRandom.class})
public class NamePatch {

    public static String[] alchemistNames = new String[]{
            "Lavoisier", "Nobel", "Avogadro", "Curie", "Mendeleev", "Bohr", "Boyle", "Bragg", "Bunsen", "Chargaff", "Dalton", "Democritus", "Faraday", "Franklin", "Gibbs", "Hoyle", "Lawrence", "Pasteur", "Pauling", "Rutherford", "Thomson", "Volta"
    };

    public static String[] anglerNames = new String[]{
            "Adam", "Bart", "Billy", "Bobby", "Charles", "Danny", "Grayson", "Ivan", "Izzy", "Jey", "Jimmy", "Johnny", "Matty", "Miles", "Nathan", "Phillip", "Sammy", "Simon", "Spencer", "Timmy", "Tyler"
    };

    public static String[] gunsmithNames = new String[]{
            "Colt", "Borchardt", " Browning", " Gatling", " Kalashnikov", " Mauser", " Andre", "Brimst", "Bronson", "Dante", "Darius", "Darnell", "Darryl", "DeAndre", "Demetrius", "DeShawn", "Dominique", "Jalen", "Jamal", "Malik", "Marquis", "Maurice", "Reginald", "Terrance", "Terrell", "Tony", "Trevon", "Tyrone", "Willie", "Xavier"
    };

    public static String[] mageNames = new String[]{
            "Merlin", " Alasdair", "Arddun", "Arwyn", "Berwyn", "Dalamar", "Dulais", "Elric", "Fizban", "Gearroid", "Greum", "Gwentor", "Hirael", "Leomund", "Maelor", "Magius", "Merlyn", "Ningauble", "Sargon", "Seonag", "Tagar", "Xanadu"
    };

    public static String[] pawnBrokerNames = new String[]{
        "Alfred", "Barney", "Calvin", "Edmund", "Edwin", "Eugene", "Finn ", "Frank", "Frederick", "Gilbert", "Gus", "Harold", "Howard", "Humphrey", "Isaac", "Joseph", "Kristian ", "Louis", "Milton", "Mortimer", "Ralph", "Seymour", "Walter", "Wilbur"
    };

    public static String[] pirateNames = new String[] {
            "Zheng Zhilong", " Drake", " Black Beard", "Captain Bullywort", "Captain Morgan", "Captain Stoney Dirt", "David", "Gunpowder Garry", "Jack", "Jake", "James T. Beard", "Red Beard", "Wet Beard"
    };

    public static String[] stylistNames = new String[]{
            "Annabel", "Biah", "Bri", "Brianne", "Esmeralda", "Flora", "Hazel", "Iris", "Kati", "Kylie", "Lola", "Meliyah", "Pearl", "Petra", "Rox", "Roxanne", "Ruby", "Scarlett", "Stella", "Tallulah"
    };

    public static String[] travelingMerchantNames = new String[]
            {
                    "Abraham", "Aedan", "Aphraim", "Bohemas", "Eladon", "Gallius", "Llewellyn", "Mercer", "Rawleigh", "Riley", "Romeo", "Shipton", "Willy"
            };

    public static String[] elderNames = new String[]{
            "Deeplake", "Andrew", "Asher", "Bradley", "Brandon", "Brett", "Brian", "Cody", "Cole", "Colin", "Connor", "Daniel", "Dylan", "Garrett", "Harley", "Jack", "Jacob", "Jake", "Jeff", "Jeffrey", "Joe", "Kevin", "Kyle", "Levi", "Logan", "Luke", "Marty", "Maxwell", "Ryan", "Scott", "Seth", "Steve", "Tanner", "Trent", "Wyatt", "Zach"
    };

    public static String[] guardNames = new String[]{
            "Caesar"
    };


//    protected String getRandomName(GameRandom random) {
//        HumanMob.HumanGender gender = this.getHumanGender();
//        if (gender == HumanMob.HumanGender.NEUTRAL) {
//            return getRandomName(random, neutralNames);
//        } else if (gender == HumanMob.HumanGender.MALE) {
//            return getRandomName(random, maleNames);
//        } else {
//            return gender == HumanMob.HumanGender.FEMALE ? getRandomName(random, femaleNames) : "NULL";
//        }
//    }

    public static String getRandomName(GameRandom random, String[] names) {
        return names[random.nextInt(names.length)];
    }

    @Advice.OnMethodExit
    static void onExit(@Advice.This HumanMob man, @Advice.Argument(0) GameRandom random, @Advice.Return(readOnly = false) String result) {
        if (man instanceof AlchemistHumanMob){
            //pick a random name from the array
            result = getRandomName(random, alchemistNames);
        }
        else if (man instanceof AnglerHumanMob)
        {
            result = getRandomName(random, anglerNames);
        }
        else if (man instanceof GunsmithHumanMob)
        {
            result = getRandomName(random, gunsmithNames);
        }
        else if (man instanceof MageHumanMob)
        {
            result = getRandomName(random, mageNames);
        }
        else if (man instanceof PawnBrokerHumanMob)
        {
            result = getRandomName(random, pawnBrokerNames);
        }
        else if (man instanceof PirateHumanMob)
        {
            result = getRandomName(random, pirateNames);
        }
        else if (man instanceof StylistHumanMob)
        {
            result = getRandomName(random, stylistNames);
        }
        else if (man instanceof TravelingMerchantMob)
        {
            result = getRandomName(random, travelingMerchantNames);
        }
        else if (man instanceof ElderHumanMob) {
            result = getRandomName(random, elderNames);
        }{
            //do nothing
        }
        //System.out.println("Worked");
    }
}
