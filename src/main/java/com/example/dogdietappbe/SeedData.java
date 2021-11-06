package com.example.dogdietappbe;

import com.example.dogdietappbe.models.*;
import com.example.dogdietappbe.repositories.DogRepository;
import com.example.dogdietappbe.services.DogServices;
import com.example.dogdietappbe.services.RoleService;
import com.example.dogdietappbe.services.UserService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToMany;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private DogRepository dogrepos;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @Transactional
    @Override
    public void run(String[] args) throws
            Exception {

        Dog d1 = new Dog("10lbs", "410");
        Dog d2 = new Dog("20 lbs", "550");
        Dog d3 = new Dog("30lbs", "722");
        Dog d4 = new Dog("40 lbs", "858");
        Dog d5 = new Dog("50lbs", "950");
        Dog d6 = new Dog("60 lbs", "1100");
        Dog d7 = new Dog("70lbs", "1295");
        Dog d8 = new Dog("80 lbs", "1405");
        Dog d9 = new Dog("90bs", "1550");
        Dog d10 = new Dog("100 lbs", "1685");

        Supplement s1 = new Supplement("WholeFoods Zinc + Copper 1 capsule", "2.3 grams of Seasalt", "2.75 grams Nutraceuticals ", "Naturemade Thiamine B1 1 gram", "15 grams Nutiva Hempseed", "Stanadard Process Vitamin E 1.5 gram", "Standard Process Choline 1 gram", null);
        Supplement s2 = new Supplement("Standard Process Zinc Liver Chelate 2 grams", "Sea Salt 2 grams", "Kal Bonemeal 14 grams", "Naturemade -Thiamine/B1 1 gram", "Standard Process Choline 2 gram", "StarwestBotanicals Kelp 2.7grams", "Standard Process WheatGermoil 2 grams", "2 grams SeaSalt");
        Supplement s3 = new Supplement("7grams Hempseeds", "Standard Process Zinc Liver Chelate 1 gram", "Now K Potassium chloride 1gram", "Standard Process WheatGerm oil .3 gram", "Choline .5gram = 1 tab -give 1 gram", "Starwest Botanicals Kelp powder", "Kal Bonemeal 8gram", null);
        Supplement s4 = new Supplement("Kal bonemeal 8 grams", "Now Potassium chloride 1 gram", "Standard Process Wheat Germ oil 2 grams", "Naturemade Thiamine-B1 .5 gram", "Choline .5 gram", "6 grams Nutiva Hempseeds", "Standard Process Zinc Liver Chelate 2 grams", "StarwestBotanicals Kelp powder 4 grams");
        Supplement s5 = new Supplement("Nutiva hempseeds 14 grams", "KAL Bonemeal 5.85 grams ", "Naturemade Thiamine B1 1 gram", "Starwest Botanicals Kelp 3 grams", "Now K Potassium Chloride 1 gram", "Solgar Choline 350 mg  give 1 gram", null, null);
        Supplement s6 = new Supplement("Standard Process Vitamin e 4 grams", "Thiamine-B1 Naturemade 1gram", "Choline 1 gram", "Now K Potassium Chloride", "Standard Process Zinc Liver Chelate", "Iron 65mg tablet 1 g = 1 tablet", null, null);
        Supplement s7 = new Supplement("Kal Bonemeal 8.64 grams", "Now K Potassium Chloride 1 gram", "Standard Process Zinc Liver Chelate 2 grams", "2 grams Starwest botanicals Kelp", "NatureMade Thiamine -b1 1 capsule", "Nutiva Hempseed 10grams", "Standard Process Choline .5 gram", null);
        Supplement s8 = new Supplement("KAL Bonemeal 10 grams", "Nutiva Hempseed 10 gram", "Nutiva Hempseed 10 grams", "Now Potassium Chloride 1 gram", "Standard Process vit E cataplex e 4.6 grams", "Naturemade Thiamine-B1 1 capsule", "Standard Process Zinc liver Chelate 2 gr", "Innovative Research Vit D 1 gram");
        Supplement s9 = new Supplement("Thiamine B1 Naturemade .3 gram", "Standard Process Choline 1 gram", "Standard Process Vit E Cataplex E 2 gram", "Kal Bonemeal 10 grams", "Standard Process Zinc Liver Chelate 2.5 grams", "Now Potassium Chloride 1.1gram", "Starwest Botanicals Kelp 1 gram", "Innovative Research Vit D 1 gram");
        Supplement s10 = new Supplement("Nutiva Hempseed 9 grams", "Standard Process Choline 1 gram", "Standard Process Vitamin E Cataplex E 5.5 grams", "NatureMade Thiamine-B1 .30gram", "KAL Bonemeal 10 grams", "Starwest Botanicals Kelp 1 gram", "Standard Process Zinc liver Chelate 3 gram", "NOW k Potassium Chloride 1.4 grams");

        Protein p1 = new Protein("24gr Beef Liver, 15gr 80/20 GroundBeef, 6gr beef Kidney,8gr Canned Pink Salmon");
        Protein p2 = new Protein("23gr Beef Liver, 20gr 80/20 GroundBeef, 15gr beef Kidney,12gr Canned Pink Salmon");
        Protein p3 = new Protein("20gr Beef Liver, 45gr 73/27 GroundBeef, 10gr beef Kidney,16gr Canned Pink Salmon");
        Protein p4 = new Protein("32gr Beef Liver, 60gr 73/27 GroundBeef, 18gr beef Kidney,19gr Canned Pink Salmon");
        Protein p5 = new Protein("53gr Beef Liver, 44gr 73/27 GroundBeef, 25gr beef Kidney, 26gr Canned Pink Salmon");
        Protein p6 = new Protein("70gr Beef Liver, 110gm 73/27 GroundBeef, 30gr beef Kidney,25gr Canned Pink Salmon");
        Protein p7 = new Protein("80gr Beef Liver, 106gr 73/27 GroundBeef, 25gr beef Kidney, 18gr Canned Pink Salmon");
        Protein p8 = new Protein("92gr Beef Liver, 120 73/27 GroundBeef, 25gr beef Kidney,20gr Canned Pink Salmon");
        Protein p9 = new Protein("100gr Beef Liver, 118gr 73/27 ground beef, 30gr beef Kidney,13gr Canned Pink Salmon");
        Protein p10 = new Protein("128gr Beef Liver, 145gr 73/27 GroundBeef, 40gr beef Kidney,23gr Canned Pink Salmon");


        Fat f1 = new Fat("25 gm Coconut oil");
        Fat f2 = new Fat("44 gm Coconut oil");
        Fat f3 = new Fat("45 gm Coconut oil");
        Fat f4 = new Fat("60 gm Coconut oil");
        Fat f5 = new Fat("75 gm Coconut oil");
        Fat f6 = new Fat("80 gm Coconut oil");
        Fat f7 = new Fat("84 gm Coconut oil");
        Fat f8 = new Fat("95gm Coconut oil");
        Fat f9 = new Fat("108 gm Coconut oil");
        Fat f10 = new Fat("111 gm Coconut oil");

        Vegetable v1 = new Vegetable("12gr Broccoli,44gm spinach");
        Vegetable v2 = new Vegetable("30gr Broccoli,90gr Spinach");
        Vegetable v3 = new Vegetable("35gr Broccoli, 98gr Spinach");
        Vegetable v4 = new Vegetable("55gr Broccoli, 65 gr Spinach");
        Vegetable v5 = new Vegetable("70gr Broccoli, 85gr Spinach");
        Vegetable v6 = new Vegetable("100gr Broccoli,100 gr Spinach");
        Vegetable v7 = new Vegetable("60gr Broccoli, 135 gr Spinach");
        Vegetable v8 = new Vegetable("80gr Broccoli, 133 gr Spinach, 60gr Kale");
        Vegetable v9 = new Vegetable("120gr Broccoli, 105 gr kale, 150 gr Soinach");
        Vegetable v10 = new Vegetable("120gr Broccoli, 160gr Spinach,");

        d1.getFats().add(new DogFat(f1,d1));
        d1.getProteins().add(new DogProteins(d1,p1));
        d1.getVegetables().add(new DogVegetables(v1,d1));
        d1.getSupplements().add(new DogSupplements(s1,d1));

        dogrepos.save(d1);

        d2.getFats().add(new DogFat(f2,d2));
        d2.getProteins().add(new DogProteins(d2,p2));
        d2.getVegetables().add(new DogVegetables(v2,d2));
        d2.getSupplements().add(new DogSupplements(s1,d1));

        dogrepos.save(d2);


        d3.getFats().add(new DogFat(f3,d3));
        d3.getProteins().add(new DogProteins(d3,p3));
        d3.getVegetables().add(new DogVegetables(v3,d3));
        d3.getSupplements().add(new DogSupplements(s3,d3));

        dogrepos.save(d3);

        d4.getFats().add(new DogFat(f4,d4));
        d4.getProteins().add(new DogProteins(d4,p4));
        d4.getVegetables().add(new DogVegetables(v4,d4));
        d4.getSupplements().add(new DogSupplements(s4,d4));

        dogrepos.save(d4);

        d5.getFats().add(new DogFat(f5,d5));
        d5.getProteins().add(new DogProteins(d5,p5));
        d5.getVegetables().add(new DogVegetables(v5,d5));
        d5.getSupplements().add(new DogSupplements(s5,d5));

        dogrepos.save(d5);

        d6.getFats().add(new DogFat(f6,d6));
        d6.getProteins().add(new DogProteins(d6,p6));
        d6.getVegetables().add(new DogVegetables(v6,d6));
        d6.getSupplements().add(new DogSupplements(s6,d6));

        dogrepos.save(d6);


        d7.getFats().add(new DogFat(f7,d7));
        d7.getProteins().add(new DogProteins(d7,p7));
        d7.getVegetables().add(new DogVegetables(v7,d7));
        d7.getSupplements().add(new DogSupplements(s7,d7));

        dogrepos.save(d7);




        d8.getFats().add(new DogFat(f8,d8));
        d8.getProteins().add(new DogProteins(d8,p8));
        d8.getVegetables().add(new DogVegetables(v8,d8));
        d8.getSupplements().add(new DogSupplements(s8,d8));

        dogrepos.save(d8);


        d9.getFats().add(new DogFat(f9,d9));
        d9.getProteins().add(new DogProteins(d9,p9));
        d9.getVegetables().add(new DogVegetables(v9,d9));
        d9.getSupplements().add(new DogSupplements(s9,d9));

        dogrepos.save(d9);

        d10.getFats().add(new DogFat(f10,d10));
        d10.getProteins().add(new DogProteins(d10,p10));
        d10.getVegetables().add(new DogVegetables(v10,d10));
        d10.getSupplements().add(new DogSupplements(s10,d10));

        dogrepos.save(d10);










        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

        // admin, data, user
        User u1 = new User("admin",
                "password");
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

    }


}
