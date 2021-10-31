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


    }


}
