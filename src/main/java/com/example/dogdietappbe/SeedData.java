package com.example.dogdietappbe;

import com.example.dogdietappbe.models.*;
import com.example.dogdietappbe.repositories.DogRepository;
import com.example.dogdietappbe.services.DogServices;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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




    @Transactional
    @Override
    public void run(String[] args) throws
            Exception{

        Dog d1 = new Dog("10lbs","410");
        Dog d2 = new Dog("20 lbs","550");
        Dog d3 = new Dog("30lbs","722");
        Dog d4 = new Dog("40 lbs","858");
        Dog d5 = new Dog("50lbs","950");
        Dog d6 = new Dog("60 lbs","1100");
        Dog d7 = new Dog("70lbs","1295");
        Dog d8 = new Dog("80 lbs","1405");
        Dog d9 = new Dog("90bs","1550");
        Dog d10 = new Dog("100 lbs","1685");

        Supplement s1 = new Supplement("WholeFoods Zinc + Copper 1 capsule","2.3 grams of Seasalt","2.75 grams Nutraceuticals ","Naturemade Thiamine B1 1 gram","15 grams Nutiva Hempseed","Stanadard Process Vitamin E 1.5 gram","Standard Process Choline 1 gram",null);
        Supplement s2 = new Supplement("Standard Process Zinc Liver Chelate 2 grams","Sea Salt 2 grams","Kal Bonemeal 14 grams","Naturemade -Thiamine/B1 1 gram","Standard Process Choline 2 gram","StarwestBotanicals Kelp 2.7grams","Standard Process WheatGermoil 2 grams","2 grams SeaSalt");
        Supplement s3 = new Supplement("7grams Hempseeds","Standard Process Zinc Liver Chelate 1 gram","Now K Potassium chloride 1gram","Standard Process WheatGerm oil .3 gram","Choline .5gram = 1 tab -give 1 gram","Starwest Botanicals Kelp powder","Kal Bonemeal 8gram",null);
        Supplement s4 = new Supplement("Kal bonemeal 8 grams","Now Potassium chloride 1 gram","Standard Process Wheat Germ oil 2 grams","Naturemade Thiamine-B1 .5 gram","Choline .5 gram","6 grams Nutiva Hempseeds","Standard Process Zinc Liver Chelate 2 grams","StarwestBotanicals Kelp powder 4 grams");;
        Supplement s5 = new Supplement("Nutiva hempseeds 14 grams","KAL Bonemeal 5.85 grams ","Naturemade Thiamine B1 1 gram","Starwest Botanicals Kelp 3 grams","Now K Potassium Chloride 1 gram","Solgar Choline 350 mg  give 1 gram",null,null);
        Supplement s6 = new Supplement("Standard Process Vitamin e 4 grams","Thiamine-B1 Naturemade 1gram","Choline 1 gram","Now K Potassium Chloride","Standard Process Zinc Liver Chelate","Iron 65mg tablet 1 g = 1 tablet",null,null);
        Supplement s7 = new Supplement("Kal Bonemeal 8.64 grams","Now K Potassium Chloride 1 gram","Standard Process Zinc Liver Chelate 2 grams","2 grams Starwest botanicals Kelp","NatureMade Thiamine -b1 1 capsule","Nutiva Hempseed 10grams","Standard Process Choline .5 gram",null);
        Supplement s8 = new Supplement("KAL Bonemeal 10 grams","Nutiva Hempseed 10 gram","Nutiva Hempseed 10 grams","Now Potassium Chloride 1 gram","Standard Process vit E cataplex e 4.6 grams","Naturemade Thiamine-B1 1 capsule","Standard Process Zinc liver Chelate 2 gr","Innovative Research Vit D 1 gram");
        Supplement s9 = new Supplement("Thiamine B1 Naturemade .3 gram","Standard Process Choline 1 gram","Standard Process Vit E Cataplex E 2 gram","Kal Bonemeal 10 grams","Standard Process Zinc Liver Chelate 2.5 grams","Now Potassium Chloride 1.1gram","Starwest Botanicals Kelp 1 gram","Innovative Research Vit D 1 gram");
        Supplement s10 = new Supplement("Nutiva Hempseed 9 grams","Standard Process Choline 1 gram","Standard Process Vitamin E Cataplex E 5.5 grams","NatureMade Thiamine-B1 .30gram","KAL Bonemeal 10 grams","Starwest Botanicals Kelp 1 gram","Standard Process Zinc liver Chelate 3 gram","NOW k Potassium Chloride 1.4 grams");

        d1.getSupplements(s1);
        d2.getSupplements(s2);
        d3.getSupplements(s3);
        d4.getSupplements(s4);
        d5.getSupplements(s5);
        d6.getSupplements(s6);
        d7.getSupplements(s7);
        d8.getSupplements(s8);
        d9.getSupplements(s9);
        d10.getSupplements(s10);

        d1.getVegetables().add(new Vegetable("44 grams spinach, 12 grams Broccoli"));
        d1.getProteins().add(new Protein("24grams Beef Liver,15 grams 80/20 ground beef, canned Pink Salmon, 6 grams Beef Kidney"));
        d1.getFats().add(new Fat("25 grams Coconut oil"));

        dogrepos.save(d1);

        d2.getFats().add(new Fat("44 grams Coconut oil"));
        d2.getVegetables().add(new Vegetable("30 grams Broccoli, 90 grams Spinach"));
        d2.getProteins().add(new Protein("23 grams Beef Liver,15 grams Beef Kidney, 12 grams Pink Salmon,20 grams ground beef"));

        dogrepos.save(d2);

        d3.getFats().add(new Fat("45 grams 73/27 beef,10 gram Beef kidney, 20 grams Beef liver, 70 grams Egg,16 grams canned pink salmon"));
        d3.getVegetables().add(new Vegetable("35 grams Broccoli, 99grams Spinach"));
        d3.getFats().add(new Fat("45 grams coconut oil"));

        dogrepos.save(d3);

        d4.getFats().add(new Fat("60 grams Coconut oil"));
        d4.getVegetables().add(new Vegetable("55 grams Broccoli, 65 grams Spinach"));
        d4.getProteins().add(new Protein("6 grams Egg, 32 grams beef Liver,60 grams 73/27 ground beef, 32 grams Beef liver,18 grams beeef kidney, 19 grams Canned Pink Salmon"));

        dogrepos.save(d4);

        d5.getProteins().add(new Protein("17 grams Egg ,44 grams 73/27 ground beef, 53 grams beef liver, 25grams beef kidney,26 grams canned pink salmon,"));
        d5.getVegetables().add(new Vegetable("85 grams Spinach, 70 grams Broccoli"));
        d5.getFats().add(new Fat("75 grams coconut oil"));

        dogrepos.save(d5);

        d6.getFats().add(new Fat("80 grams Coconut oil"));
        d6.getVegetables().add(new Vegetable("100 grams Broccoli, 100 grams spinach,"));
        d6.getProteins().add(new Protein("110 grams 73/27 ground beef , 25 grams Canned Pink Salmon, 70 grams Beef liver, 30 grams Beef Kidney"));

        dogrepos.save(d6);

        d7.getProteins().add(new Protein("106 grams 73/27 ground beef, 80 grams beef liver, 25 grams beef kidney, 5 grams egg,18 grams canned pink salmon"));
        d7.getVegetables().add(new Vegetable("135 grams Spinach, 60 grams Broccoli, 74 grams Kale"));
        d7.getFats().add(new Fat("84 grams coconut oil"));

        dogrepos.save(d7);

        d8.getFats().add(new Fat("95 grams Coconut oil"));
        d8.getVegetables().add(new Vegetable("133 grams Spinach, 80 grams broccoli, 60 grams Kale"));
        d8.getProteins().add(new Protein("120 grams 73/27 ground beef, 25 grams beef kidney, 92 grams beef liver,20 grams canned pink salmon"));

        dogrepos.save(d8);

        d9.getVegetables().add(new Vegetable("150 grams Spinach, 105 grams kale,120 grams Broccoli"));
        d9.getProteins().add(new Protein("117.5 grams 73/27 ground beef, 100 grams beef liver, 30 grams beef kidney,13 grams canned pink salmon"));
        d9.getFats().add(new Fat ("108 grams Coconut oil"));

        dogrepos.save(d9);

        d10.getFats().add(new Fat("111 grams coconut oil"));
        d10.getProteins().add(new Protein("145 grams 73/27 ground beef, 128 grams beef liver, 40 grams beef kidney, 23 grams canned pink Salmon"));
        d10.getFats().add(new Fat("111 grams coconut oil"));













    }


}
