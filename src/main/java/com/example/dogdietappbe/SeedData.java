package com.example.dogdietappbe;

import com.example.dogdietappbe.models.*;
import com.example.dogdietappbe.repositories.*;
import com.example.dogdietappbe.services.RoleService;
import com.example.dogdietappbe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
//@ConditionalOnProperty(
//        prefix = "command.line.runner",
//        value = "enabled",
//        havingValue = "true",
//        matchIfMissing = true)

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private DogRepository dogrepos;

    @Autowired
    private VegetableRepository vegrepos;

    @Autowired
    private SupplementRepository supprepos;

    @Autowired
    private FatRepository fatrepos;

    @Autowired
    private ProteinRepository proteinrepos;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;



    @Transactional
    @Override
    public void run(String[] args) throws
            Exception {

        Dog d1 = new Dog("Dog1", "10lbs", "410");
        Dog d2 = new Dog("Dog2", "20lbs", "550");
        Dog d3 = new Dog("Dog3", "30lbs", "722");
        Dog d4 = new Dog("Dog4", "40lbs", "858");
        Dog d5 = new Dog("Dog5", "50lbs", "950");
        Dog d6 = new Dog("Dog6", "60lbs", "1100");
        Dog d7 = new Dog("Dog7", "70lbs", "1295");
        Dog d8 = new Dog("Dog8", "80lbs", "1405");
        Dog d9 = new Dog("Dog9", "90lbs", "1550");
        Dog d10 = new Dog("Dog10", "100lbs", "1685");


        Supplement wholefoodszinc = new Supplement("wholefoods zinc");
        Supplement seasalt = new Supplement("seasalt");
        Supplement Naturemadethiamine = new Supplement("Naturemadee Thiamine");
        Supplement solgarcholine = new Supplement("Solgar Choline");
        Supplement starwestBotanicalsKelp = new Supplement("Starwest Botanicals kelp");
        Supplement standardProcessZincLiverChelate = new Supplement("Standard Process Zinc Liver Chelate");
        Supplement NowKPotassiumChloride = new Supplement("Now Potassium Chloride");
        Supplement NutivaHempSeed = new Supplement("Nutiva Hempseeds");
        Supplement standardProcessWheatGermOil = new Supplement("Standard Process Wheat Germ Oil");
        Supplement kalBonemeal = new Supplement("KAL Bonemeal");
        Supplement innovativeResearchVitaminD = new Supplement("Innovative Research Vitamin D");
        Supplement StandardProcessvitE = new Supplement("Standard Process Vit E Cataplex E");
        Supplement iron = new Supplement("Iron 65mg table 1 gram=1tablet");
        Supplement standardprocesscholine = new Supplement("StandardProcessCholine");


        supprepos.save(wholefoodszinc);
        supprepos.save(seasalt);
        supprepos.save(Naturemadethiamine);
        supprepos.save(solgarcholine);
        supprepos.save(starwestBotanicalsKelp);
        supprepos.save(standardProcessZincLiverChelate);
        supprepos.save(NowKPotassiumChloride);
        supprepos.save(kalBonemeal);
        supprepos.save(standardProcessWheatGermOil);
        supprepos.save(innovativeResearchVitaminD);
        supprepos.save(iron);
        supprepos.save(StandardProcessvitE);
        supprepos.save(NutivaHempSeed);

        Protein beefliver = new Protein("beefliver");
        Protein beefkidney = new Protein("Beef Kidney");
        Protein beefeightytwenty = new Protein("beef 80/20");
        Protein beefseventythreethirty = new Protein("73/27 ground beef");
        Protein pinksalmon = new Protein("canned pink Salmon");


        proteinrepos.save(beefliver);
        proteinrepos.save(beefeightytwenty);
        proteinrepos.save(beefkidney);
        proteinrepos.save(beefseventythreethirty);
        proteinrepos.save(pinksalmon);

        Vegetable broccoli = new Vegetable("broccoli");
        Vegetable spinach = new Vegetable("spinach");
        Vegetable kale = new Vegetable("kale");

        vegrepos.save(broccoli);
        vegrepos.save(spinach);
        vegrepos.save(kale);


        Fat coconutoil = new Fat("coconutoil");
        fatrepos.save(coconutoil);


        d1.getProteins().add(new DogProteins(d1, beefkidney, 6));
        d1.getProteins().add(new DogProteins(d1, beefeightytwenty, 15));
        d1.getProteins().add(new DogProteins(d1, beefliver, 24));
        d1.getProteins().add(new DogProteins(d1, pinksalmon, 10));
        d1.getVegetables().add(new DogVegetables(broccoli, d1, 12));
        d1.getVegetables().add(new DogVegetables(spinach, d1, 44));
        d1.getFats().add(new DogFat(coconutoil, d1, 25));
        d1.getSupplements().add(new DogSupplements(wholefoodszinc, d1, 1));
        d1.getSupplements().add(new DogSupplements(seasalt, d1, 2));
        d1.getSupplements().add(new DogSupplements(Naturemadethiamine, d1, 1));
        d1.getSupplements().add(new DogSupplements(NutivaHempSeed, d1, 15));
        d1.getSupplements().add(new DogSupplements(standardprocesscholine, d1, 1));
        d1.getSupplements().add(new DogSupplements(wholefoodszinc, d1, 1));
        d1.getSupplements().add(new DogSupplements(StandardProcessvitE, d1, 1));
        d1.getSupplements().add(new DogSupplements(kalBonemeal,d1,4));
        dogrepos.save(d1);

        d2.getProteins().add(new DogProteins(d2, beefkidney, 6));
        d2.getProteins().add(new DogProteins(d2, beefeightytwenty, 20));
        d2.getProteins().add(new DogProteins(d2, beefliver, 23));
        d2.getProteins().add(new DogProteins(d2, pinksalmon, 8));
        d2.getVegetables().add(new DogVegetables(broccoli, d2, 30));
        d2.getVegetables().add(new DogVegetables(spinach, d2, 90));
        d2.getFats().add(new DogFat(coconutoil, d2, 44));
        d2.getSupplements().add(new DogSupplements(standardProcessZincLiverChelate, d2, 2));
        d2.getSupplements().add(new DogSupplements(seasalt, d2, 2));
        d2.getSupplements().add(new DogSupplements(Naturemadethiamine, d2, 1));
        d2.getSupplements().add(new DogSupplements(kalBonemeal, d2, 14));
        d2.getSupplements().add(new DogSupplements(standardprocesscholine, d2, 2));
        d2.getSupplements().add(new DogSupplements(wholefoodszinc, d2, 1));
        d2.getSupplements().add(new DogSupplements(starwestBotanicalsKelp, d2, 3));
        d2.getSupplements().add(new DogSupplements(standardProcessWheatGermOil, d2, 2));

        dogrepos.save(d2);

        d3.getProteins().add(new DogProteins(d3, beefkidney, 10));
        d3.getProteins().add(new DogProteins(d3, beefseventythreethirty, 45));
        d3.getProteins().add(new DogProteins(d3, beefliver, 20));
        d3.getProteins().add(new DogProteins(d3, pinksalmon, 16));
        d3.getVegetables().add(new DogVegetables(broccoli, d3, 35));
        d3.getVegetables().add(new DogVegetables(spinach, d3, 98));
        d3.getFats().add(new DogFat(coconutoil, d3, 45));
        d3.getSupplements().add(new DogSupplements(NutivaHempSeed, d3, 7));
        d3.getSupplements().add(new DogSupplements(standardProcessZincLiverChelate, d3, 1));
        d3.getSupplements().add(new DogSupplements(NowKPotassiumChloride, d3, 1));
        d3.getSupplements().add(new DogSupplements(kalBonemeal, d3, 8));
        d3.getSupplements().add(new DogSupplements(standardProcessWheatGermOil, d3, 1));
        d3.getSupplements().add(new DogSupplements(solgarcholine, d3, 1));
        d3.getSupplements().add(new DogSupplements(starwestBotanicalsKelp, d3, 3));
        d3.getSupplements().add(new DogSupplements(seasalt,d3,1));
        dogrepos.save(d3);


        d4.getProteins().add(new DogProteins(d4, beefkidney, 18));
        d4.getProteins().add(new DogProteins(d4, beefseventythreethirty, 60));
        d4.getProteins().add(new DogProteins(d4, beefliver, 32));
        d4.getProteins().add(new DogProteins(d4, pinksalmon, 19));
        d4.getVegetables().add(new DogVegetables(broccoli, d4, 55));
        d4.getVegetables().add(new DogVegetables(spinach, d4, 65));
        d4.getFats().add(new DogFat(coconutoil, d4, 60));
        d4.getSupplements().add(new DogSupplements(standardProcessZincLiverChelate, d4, 2));
        d4.getSupplements().add(new DogSupplements(NowKPotassiumChloride, d4, 1));
        d4.getSupplements().add(new DogSupplements(Naturemadethiamine, d4, 1));
        d4.getSupplements().add(new DogSupplements(kalBonemeal, d4, 8));
        d4.getSupplements().add(new DogSupplements(standardprocesscholine, d4, 1));
        d4.getSupplements().add(new DogSupplements(wholefoodszinc, d4, 1));
        d4.getSupplements().add(new DogSupplements(starwestBotanicalsKelp, d4, 4));
        d4.getSupplements().add(new DogSupplements(standardProcessWheatGermOil, d4, 2));
        d4.getSupplements().add(new DogSupplements(NutivaHempSeed, d4, 6));

        dogrepos.save(d4);

        d5.getProteins().add(new DogProteins(d5, beefkidney, 25));
        d5.getProteins().add(new DogProteins(d5, beefseventythreethirty, 44));
        d5.getProteins().add(new DogProteins(d5, beefliver, 53));
        d5.getProteins().add(new DogProteins(d5, pinksalmon, 26));
        d5.getVegetables().add(new DogVegetables(broccoli, d5, 70));
        d5.getVegetables().add(new DogVegetables(spinach, d5, 85));
        d5.getFats().add(new DogFat(coconutoil, d5, 75));
        d5.getSupplements().add(new DogSupplements(standardProcessZincLiverChelate, d5, 2));
        d5.getSupplements().add(new DogSupplements(NutivaHempSeed, d5, 14));
        d5.getSupplements().add(new DogSupplements(Naturemadethiamine, d5, 1));
        d5.getSupplements().add(new DogSupplements(kalBonemeal, d5, 6));
        d5.getSupplements().add(new DogSupplements(NowKPotassiumChloride, d5, 1));
        d5.getSupplements().add(new DogSupplements(standardprocesscholine, d5, 1));
        d5.getSupplements().add(new DogSupplements(starwestBotanicalsKelp, d5, 3));
        d5.getSupplements().add(new DogSupplements(seasalt,d5,1));
        dogrepos.save(d5);

        d6.getProteins().add(new DogProteins(d6, beefkidney, 30));
        d6.getProteins().add(new DogProteins(d6, beefseventythreethirty, 110));
        d6.getProteins().add(new DogProteins(d6, beefliver, 70));
        d6.getProteins().add(new DogProteins(d6, pinksalmon, 25));
        d6.getVegetables().add(new DogVegetables(broccoli, d6, 100));
        d6.getVegetables().add(new DogVegetables(spinach, d6, 100));
        d6.getFats().add(new DogFat(coconutoil, d6, 80));
        d6.getSupplements().add(new DogSupplements(StandardProcessvitE, d6, 4));
        d6.getSupplements().add(new DogSupplements(NowKPotassiumChloride, d6, 1));
        d6.getSupplements().add(new DogSupplements(Naturemadethiamine, d6, 1));
        d6.getSupplements().add(new DogSupplements(kalBonemeal, d6, 9));
        d6.getSupplements().add(new DogSupplements(standardprocesscholine, d6, 1));
        d6.getSupplements().add(new DogSupplements(iron, d6, 1));
        d6.getSupplements().add(new DogSupplements(standardProcessZincLiverChelate, d6, 2));
        d6.getSupplements().add(new DogSupplements(seasalt,d6,1));
        dogrepos.save(d6);

        d7.getProteins().add(new DogProteins(d7, beefkidney, 25));
        d7.getProteins().add(new DogProteins(d7, beefseventythreethirty, 106));
        d7.getProteins().add(new DogProteins(d7, beefliver, 80));
        d7.getProteins().add(new DogProteins(d7, pinksalmon, 18));
        d7.getVegetables().add(new DogVegetables(broccoli, d7, 60));
        d7.getVegetables().add(new DogVegetables(spinach, d7, 130));
        d7.getFats().add(new DogFat(coconutoil, d7, 84));
        d7.getSupplements().add(new DogSupplements(kalBonemeal, d7, 8));
        d7.getSupplements().add(new DogSupplements(NowKPotassiumChloride, d7, 1));
        d7.getSupplements().add(new DogSupplements(starwestBotanicalsKelp, d7, 2));
        d7.getSupplements().add(new DogSupplements(Naturemadethiamine, d7, 1));
        d7.getSupplements().add(new DogSupplements(NutivaHempSeed, d7, 10));
        d7.getSupplements().add(new DogSupplements(standardprocesscholine, d7, 1));
        d7.getSupplements().add(new DogSupplements(standardProcessZincLiverChelate, d7, 2));
        d7.getSupplements().add(new DogSupplements(seasalt,d7,1));
        dogrepos.save(d7);

        d8.getProteins().add(new DogProteins(d8, beefkidney, 25));
        d8.getProteins().add(new DogProteins(d8, beefseventythreethirty, 120));
        d8.getProteins().add(new DogProteins(d8, beefliver, 92));
        d8.getProteins().add(new DogProteins(d8, pinksalmon, 20));
        d8.getVegetables().add(new DogVegetables(broccoli, d8, 80));
        d8.getVegetables().add(new DogVegetables(spinach, d8, 133));
        d8.getFats().add(new DogFat(coconutoil, d8, 95));
        d8.getSupplements().add(new DogSupplements(kalBonemeal, d8, 10));
        d8.getSupplements().add(new DogSupplements(NowKPotassiumChloride, d8, 1));
        d8.getSupplements().add(new DogSupplements(StandardProcessvitE, d8, 4));
        d8.getSupplements().add(new DogSupplements(innovativeResearchVitaminD, d8, 1));
        d8.getSupplements().add(new DogSupplements(NutivaHempSeed, d8, 10));
        d8.getSupplements().add(new DogSupplements(Naturemadethiamine, d8, 1));
        d8.getSupplements().add(new DogSupplements(standardProcessZincLiverChelate, d8, 2));
        d8.getSupplements().add(new DogSupplements(seasalt,d8,1));
        dogrepos.save(d8);

        d9.getProteins().add(new DogProteins(d9, beefkidney, 30));
        d9.getProteins().add(new DogProteins(d9, beefseventythreethirty, 118));
        d9.getProteins().add(new DogProteins(d9, beefliver, 100));
        d9.getProteins().add(new DogProteins(d9, pinksalmon, 13));
        d9.getVegetables().add(new DogVegetables(broccoli, d9, 120));
        d9.getVegetables().add(new DogVegetables(spinach, d9, 150));
        d9.getFats().add(new DogFat(coconutoil, d9, 108));
        d9.getSupplements().add(new DogSupplements(kalBonemeal, d9, 10));
        d9.getSupplements().add(new DogSupplements(standardprocesscholine, d9, 1));
        d9.getSupplements().add(new DogSupplements(StandardProcessvitE, d9, 2));
        d9.getSupplements().add(new DogSupplements(Naturemadethiamine, d9, 1));
        d9.getSupplements().add(new DogSupplements(NutivaHempSeed, d9, 10));
        d9.getSupplements().add(new DogSupplements(standardprocesscholine, d9, 1));
        d9.getSupplements().add(new DogSupplements(standardProcessZincLiverChelate, d9, 3));
        d9.getSupplements().add(new DogSupplements(NowKPotassiumChloride, d9, 1));
        d9.getSupplements().add(new DogSupplements(innovativeResearchVitaminD, d9, 1));
        d9.getSupplements().add(new DogSupplements(starwestBotanicalsKelp, d9, 1));

        dogrepos.save(d9);


        d10.getProteins().add(new DogProteins(d10, beefkidney, 40));
        d10.getProteins().add(new DogProteins(d10, beefseventythreethirty, 145));
        d10.getProteins().add(new DogProteins(d10, beefliver, 128));
        d10.getProteins().add(new DogProteins(d10, pinksalmon, 23));
        d10.getVegetables().add(new DogVegetables(broccoli, d10, 120));
        d10.getVegetables().add(new DogVegetables(spinach, d10, 150));
        d10.getFats().add(new DogFat(coconutoil, d10, 108));
        d10.getSupplements().add(new DogSupplements(kalBonemeal, d10, 10));
        d10.getSupplements().add(new DogSupplements(StandardProcessvitE, d10, 5));
        d10.getSupplements().add(new DogSupplements(Naturemadethiamine, d10, 1));
        d10.getSupplements().add(new DogSupplements(NutivaHempSeed, d10, 10));
        d10.getSupplements().add(new DogSupplements(standardProcessZincLiverChelate, d10, 3));
        d10.getSupplements().add(new DogSupplements(standardprocesscholine, d10, 1));
        d10.getSupplements().add(new DogSupplements(NowKPotassiumChloride, d10, 1));
        d10.getSupplements().add(new DogSupplements(seasalt,d10,1));

        dogrepos.save(d10);


        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("DATA");


        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

        User u1 = new User("admin",
                "password","admin@admin.com");
        u1.getRoles()
                .add(new UserRoles(u1,
                        r1));
        u1.getRoles()
                .add(new UserRoles(u1,
                        r2));
        u1.getRoles()
                .add(new UserRoles(u1,
                        r3));

        userService.save(u1);

        // data, user
        User u2 = new User("cinnamon",
                "1234567","cinnamon@cinnamon.com");
        u2.getRoles()
                .add(new UserRoles(u2,
                        r2));
        u2.getRoles()
                .add(new UserRoles(u2,
                        r3));
        userService.save(u2);

        // user
        User u3 = new User("barnbarn",
                "ILuvM4th!","barnbarn@gmail.com");
        u3.getRoles()
                .add(new UserRoles(u3,
                        r2));
        userService.save(u3);

        User u4 = new User("puttat",
                "password","puttat@aol.com");
        u4.getRoles()
                .add(new UserRoles(u4,
                        r2));
        userService.save(u4);

        User u5 = new User("misskitty",
                "password","misskitty@yahoo.com");
        u5.getRoles()
                .add(new UserRoles(u5,
                        r2));
        userService.save(u5);


    }
}